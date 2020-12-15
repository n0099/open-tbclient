package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes.dex */
public class c extends d {
    private VideoSerializeVideoThreadInfo jzq;
    private VideoItemData mzn;
    private by mzo;

    public c(Context context, View view) {
        super(context, view);
        xc(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mAe.setOnTouchListener(null);
        this.mAe.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(by byVar) {
        super.setData(byVar);
        this.mzo = byVar;
        if (this.amX) {
            this.mzn = new VideoItemData();
            this.mzn.buildWithThreadData(byVar);
            return;
        }
        this.jzq = new VideoSerializeVideoThreadInfo();
        this.jzq.copyFromThreadInfo(byVar);
        this.jzq.source = byVar.mRecomSource;
        this.jzq.extra = byVar.mRecomExtra;
        this.jzq.ab_tag = byVar.mRecomAbTag;
        this.jzq.weight = byVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxc() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxb() {
        this.mzH = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dCC();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.amX) {
                if (this.mzn != null) {
                    gd(this.mzn.forum_id, this.mzn.thread_id);
                }
            } else if (this.jzq != null) {
                gd(this.jzq.forumId, this.jzq.threadId);
            }
        }
    }

    private void gd(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.mzo);
        pbActivityConfig.setVideoOriginArea(az.bn(this.mAe));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.an(this.mzo);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.akt != null) {
            this.akt.onClick(dBI());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwZ() {
        if (this.mzO == this.mzG) {
            dCv();
        }
    }

    public void dCv() {
        HS(this.mzH);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dCu() {
        return false;
    }
}
