package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes.dex */
public class c extends d {
    private VideoSerializeVideoThreadInfo jNb;
    private VideoItemData mJv;
    private cb mJw;

    public c(Context context, View view) {
        super(context, view);
        xr(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mKk.setOnTouchListener(null);
        this.mKk.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(cb cbVar) {
        super.setData(cbVar);
        this.mJw = cbVar;
        if (this.amB) {
            this.mJv = new VideoItemData();
            this.mJv.buildWithThreadData(cbVar);
            return;
        }
        this.jNb = new VideoSerializeVideoThreadInfo();
        this.jNb.copyFromThreadInfo(cbVar);
        this.jNb.source = cbVar.mRecomSource;
        this.jNb.extra = cbVar.mRecomExtra;
        this.jNb.ab_tag = cbVar.mRecomAbTag;
        this.jNb.weight = cbVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvu() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvt() {
        this.mJP = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dAR();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.amB) {
                if (this.mJv != null) {
                    fZ(this.mJv.forum_id, this.mJv.thread_id);
                }
            } else if (this.jNb != null) {
                fZ(this.jNb.forumId, this.jNb.threadId);
            }
        }
    }

    private void fZ(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.mJw);
        pbActivityConfig.setVideoOriginArea(az.bs(this.mKk));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.ao(this.mJw);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.ajT != null) {
            this.ajT.onClick(dzW());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvr() {
        if (this.mViewState == this.mJO) {
            dAK();
        }
    }

    public void dAK() {
        Gy(this.mJP);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dAH() {
        return false;
    }
}
