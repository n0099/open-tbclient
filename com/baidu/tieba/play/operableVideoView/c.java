package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes.dex */
public class c extends d {
    private VideoSerializeVideoThreadInfo gNU;
    private VideoItemData jxn;
    private bj jxo;

    public c(Context context, View view) {
        super(context, view);
        rR(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jyc.setOnTouchListener(null);
        this.jyc.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.jxo = bjVar;
        if (this.Pi) {
            this.jxn = new VideoItemData();
            this.jxn.buildWithThreadData(bjVar);
            return;
        }
        this.gNU = new VideoSerializeVideoThreadInfo();
        this.gNU.copyFromThreadInfo(bjVar);
        this.gNU.source = bjVar.mRecomSource;
        this.gNU.extra = bjVar.mRecomExtra;
        this.gNU.ab_tag = bjVar.mRecomAbTag;
        this.gNU.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctR() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctQ() {
        this.jxG = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                czE();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.Pi) {
                if (this.jxn != null) {
                    ek(this.jxn.forum_id, this.jxn.thread_id);
                }
            } else if (this.gNU != null) {
                ek(this.gNU.forumId, this.gNU.threadId);
            }
        }
    }

    private void ek(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.jxo);
        pbActivityConfig.setVideoOriginArea(au.aP(this.jyc));
        pbActivityConfig.setNeedPreLoad(true);
        i.aj(this.jxo);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.Nh != null) {
            this.Nh.onClick(cyp());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctM() {
        if (this.jxM == this.jxF) {
            czx();
        }
    }

    public void czx() {
        zy(this.jxG);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
