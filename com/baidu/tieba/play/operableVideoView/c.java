package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes.dex */
public class c extends d {
    private VideoSerializeVideoThreadInfo jLP;
    private VideoItemData mEF;
    private bz mEG;

    public c(Context context, View view) {
        super(context, view);
        xd(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mFv.setOnTouchListener(null);
        this.mFv.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bz bzVar) {
        super.setData(bzVar);
        this.mEG = bzVar;
        if (this.anC) {
            this.mEF = new VideoItemData();
            this.mEF.buildWithThreadData(bzVar);
            return;
        }
        this.jLP = new VideoSerializeVideoThreadInfo();
        this.jLP.copyFromThreadInfo(bzVar);
        this.jLP.source = bzVar.mRecomSource;
        this.jLP.extra = bzVar.mRecomExtra;
        this.jLP.ab_tag = bzVar.mRecomAbTag;
        this.jLP.weight = bzVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwR() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwQ() {
        this.mEZ = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dCr();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.anC) {
                if (this.mEF != null) {
                    ga(this.mEF.forum_id, this.mEF.thread_id);
                }
            } else if (this.jLP != null) {
                ga(this.jLP.forumId, this.jLP.threadId);
            }
        }
    }

    private void ga(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.mEG);
        pbActivityConfig.setVideoOriginArea(ay.bw(this.mFv));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.an(this.mEG);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.akV != null) {
            this.akV.onClick(dBx());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwO() {
        if (this.mFg == this.mEY) {
            dCk();
        }
    }

    public void dCk() {
        HL(this.mEZ);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dCj() {
        return false;
    }
}
