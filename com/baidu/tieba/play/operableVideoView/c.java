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
    private VideoSerializeVideoThreadInfo jMN;
    private VideoItemData mJg;
    private cb mJh;

    public c(Context context, View view) {
        super(context, view);
        xr(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mJV.setOnTouchListener(null);
        this.mJV.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(cb cbVar) {
        super.setData(cbVar);
        this.mJh = cbVar;
        if (this.amB) {
            this.mJg = new VideoItemData();
            this.mJg.buildWithThreadData(cbVar);
            return;
        }
        this.jMN = new VideoSerializeVideoThreadInfo();
        this.jMN.copyFromThreadInfo(cbVar);
        this.jMN.source = cbVar.mRecomSource;
        this.jMN.extra = cbVar.mRecomExtra;
        this.jMN.ab_tag = cbVar.mRecomAbTag;
        this.jMN.weight = cbVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvn() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvm() {
        this.mJA = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dAK();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.amB) {
                if (this.mJg != null) {
                    fZ(this.mJg.forum_id, this.mJg.thread_id);
                }
            } else if (this.jMN != null) {
                fZ(this.jMN.forumId, this.jMN.threadId);
            }
        }
    }

    private void fZ(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.mJh);
        pbActivityConfig.setVideoOriginArea(az.bs(this.mJV));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.ao(this.mJh);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.ajT != null) {
            this.ajT.onClick(dzP());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvk() {
        if (this.mViewState == this.mJz) {
            dAD();
        }
    }

    public void dAD() {
        Gy(this.mJA);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dAA() {
        return false;
    }
}
