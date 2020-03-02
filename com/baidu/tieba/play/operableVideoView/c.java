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
    private VideoSerializeVideoThreadInfo gNW;
    private VideoItemData jxp;
    private bj jxq;

    public c(Context context, View view) {
        super(context, view);
        rR(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jye.setOnTouchListener(null);
        this.jye.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.jxq = bjVar;
        if (this.Pi) {
            this.jxp = new VideoItemData();
            this.jxp.buildWithThreadData(bjVar);
            return;
        }
        this.gNW = new VideoSerializeVideoThreadInfo();
        this.gNW.copyFromThreadInfo(bjVar);
        this.gNW.source = bjVar.mRecomSource;
        this.gNW.extra = bjVar.mRecomExtra;
        this.gNW.ab_tag = bjVar.mRecomAbTag;
        this.gNW.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctT() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctS() {
        this.jxI = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                czG();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.Pi) {
                if (this.jxp != null) {
                    ek(this.jxp.forum_id, this.jxp.thread_id);
                }
            } else if (this.gNW != null) {
                ek(this.gNW.forumId, this.gNW.threadId);
            }
        }
    }

    private void ek(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.jxq);
        pbActivityConfig.setVideoOriginArea(au.aP(this.jye));
        pbActivityConfig.setNeedPreLoad(true);
        i.aj(this.jxq);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.Nh != null) {
            this.Nh.onClick(cyr());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctO() {
        if (this.jxO == this.jxH) {
            czz();
        }
    }

    public void czz() {
        zy(this.jxI);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
