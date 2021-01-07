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
    private VideoItemData mEE;
    private bz mEF;

    public c(Context context, View view) {
        super(context, view);
        xd(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mFu.setOnTouchListener(null);
        this.mFu.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bz bzVar) {
        super.setData(bzVar);
        this.mEF = bzVar;
        if (this.anC) {
            this.mEE = new VideoItemData();
            this.mEE.buildWithThreadData(bzVar);
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
    public void dwS() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwR() {
        this.mEY = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dCs();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.anC) {
                if (this.mEE != null) {
                    ga(this.mEE.forum_id, this.mEE.thread_id);
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
        pbActivityConfig.setThreadData(this.mEF);
        pbActivityConfig.setVideoOriginArea(ay.bw(this.mFu));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.an(this.mEF);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.akV != null) {
            this.akV.onClick(dBy());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwP() {
        if (this.mFf == this.mEX) {
            dCl();
        }
    }

    public void dCl() {
        HL(this.mEY);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dCk() {
        return false;
    }
}
