package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes.dex */
public class c extends d {
    private VideoSerializeVideoThreadInfo iSH;
    private VideoItemData lSq;
    private bw lSr;

    public c(Context context, View view) {
        super(context, view);
        vV(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.lTh.setOnTouchListener(null);
        this.lTh.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        super.setData(bwVar);
        this.lSr = bwVar;
        if (this.alR) {
            this.lSq = new VideoItemData();
            this.lSq.buildWithThreadData(bwVar);
            return;
        }
        this.iSH = new VideoSerializeVideoThreadInfo();
        this.iSH.copyFromThreadInfo(bwVar);
        this.iSH.source = bwVar.mRecomSource;
        this.iSH.extra = bwVar.mRecomExtra;
        this.iSH.ab_tag = bwVar.mRecomAbTag;
        this.iSH.weight = bwVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dmz() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dmy() {
        this.lSK = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dsb();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.alR) {
                if (this.lSq != null) {
                    fT(this.lSq.forum_id, this.lSq.thread_id);
                }
            } else if (this.iSH != null) {
                fT(this.iSH.forumId, this.iSH.threadId);
            }
        }
    }

    private void fT(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.lSr);
        pbActivityConfig.setVideoOriginArea(ay.bc(this.lTh));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.al(this.lSr);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.ajo != null) {
            this.ajo.onClick(drg());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dmw() {
        if (this.lSR == this.lSJ) {
            drT();
        }
    }

    public void drT() {
        FX(this.lSK);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean drS() {
        return false;
    }
}
