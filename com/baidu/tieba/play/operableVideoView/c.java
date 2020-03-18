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
    private VideoSerializeVideoThreadInfo gPp;
    private VideoItemData jza;
    private bj jzb;

    public c(Context context, View view) {
        super(context, view);
        rX(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jzP.setOnTouchListener(null);
        this.jzP.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.jzb = bjVar;
        if (this.Pj) {
            this.jza = new VideoItemData();
            this.jza.buildWithThreadData(bjVar);
            return;
        }
        this.gPp = new VideoSerializeVideoThreadInfo();
        this.gPp.copyFromThreadInfo(bjVar);
        this.gPp.source = bjVar.mRecomSource;
        this.gPp.extra = bjVar.mRecomExtra;
        this.gPp.ab_tag = bjVar.mRecomAbTag;
        this.gPp.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cun() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cum() {
        this.jzt = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cAb();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.Pj) {
                if (this.jza != null) {
                    ei(this.jza.forum_id, this.jza.thread_id);
                }
            } else if (this.gPp != null) {
                ei(this.gPp.forumId, this.gPp.threadId);
            }
        }
    }

    private void ei(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.jzb);
        pbActivityConfig.setVideoOriginArea(au.aP(this.jzP));
        pbActivityConfig.setNeedPreLoad(true);
        i.ak(this.jzb);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.Ni != null) {
            this.Ni.onClick(cyL());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cuk() {
        if (this.jzz == this.jzs) {
            czT();
        }
    }

    public void czT() {
        zG(this.jzt);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
