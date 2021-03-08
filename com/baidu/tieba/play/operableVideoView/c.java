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
    private VideoSerializeVideoThreadInfo jOK;
    private VideoItemData mLx;
    private cb mLy;

    public c(Context context, View view) {
        super(context, view);
        xr(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mMm.setOnTouchListener(null);
        this.mMm.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(cb cbVar) {
        super.setData(cbVar);
        this.mLy = cbVar;
        if (this.anT) {
            this.mLx = new VideoItemData();
            this.mLx.buildWithThreadData(cbVar);
            return;
        }
        this.jOK = new VideoSerializeVideoThreadInfo();
        this.jOK.copyFromThreadInfo(cbVar);
        this.jOK.source = cbVar.mRecomSource;
        this.jOK.extra = cbVar.mRecomExtra;
        this.jOK.ab_tag = cbVar.mRecomAbTag;
        this.jOK.weight = cbVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvD() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvC() {
        this.mLR = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dAZ();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.anT) {
                if (this.mLx != null) {
                    fZ(this.mLx.forum_id, this.mLx.thread_id);
                }
            } else if (this.jOK != null) {
                fZ(this.jOK.forumId, this.jOK.threadId);
            }
        }
    }

    private void fZ(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.mLy);
        pbActivityConfig.setVideoOriginArea(az.bs(this.mMm));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.ao(this.mLy);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.alm != null) {
            this.alm.onClick(dAf());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvA() {
        if (this.mViewState == this.mLQ) {
            dAS();
        }
    }

    public void dAS() {
        GB(this.mLR);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dAP() {
        return false;
    }
}
