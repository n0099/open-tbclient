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
    private VideoSerializeVideoThreadInfo jlb;
    private VideoItemData mkN;
    private bw mkO;

    public c(Context context, View view) {
        super(context, view);
        wv(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mlE.setOnTouchListener(null);
        this.mlE.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        super.setData(bwVar);
        this.mkO = bwVar;
        if (this.alS) {
            this.mkN = new VideoItemData();
            this.mkN.buildWithThreadData(bwVar);
            return;
        }
        this.jlb = new VideoSerializeVideoThreadInfo();
        this.jlb.copyFromThreadInfo(bwVar);
        this.jlb.source = bwVar.mRecomSource;
        this.jlb.extra = bwVar.mRecomExtra;
        this.jlb.ab_tag = bwVar.mRecomAbTag;
        this.jlb.weight = bwVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dsj() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dsi() {
        this.mlh = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dxK();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.alS) {
                if (this.mkN != null) {
                    fY(this.mkN.forum_id, this.mkN.thread_id);
                }
            } else if (this.jlb != null) {
                fY(this.jlb.forumId, this.jlb.threadId);
            }
        }
    }

    private void fY(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.mkO);
        pbActivityConfig.setVideoOriginArea(ay.bh(this.mlE));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.al(this.mkO);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.ajp != null) {
            this.ajp.onClick(dwP());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dsg() {
        if (this.mlo == this.mlg) {
            dxC();
        }
    }

    public void dxC() {
        GD(this.mlh);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dxB() {
        return false;
    }
}
