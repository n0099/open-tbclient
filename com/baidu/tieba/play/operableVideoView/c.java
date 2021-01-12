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
    private VideoSerializeVideoThreadInfo jHj;
    private VideoItemData mzV;
    private bz mzW;

    public c(Context context, View view) {
        super(context, view);
        wZ(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mAL.setOnTouchListener(null);
        this.mAL.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bz bzVar) {
        super.setData(bzVar);
        this.mzW = bzVar;
        if (this.amL) {
            this.mzV = new VideoItemData();
            this.mzV.buildWithThreadData(bzVar);
            return;
        }
        this.jHj = new VideoSerializeVideoThreadInfo();
        this.jHj.copyFromThreadInfo(bzVar);
        this.jHj.source = bzVar.mRecomSource;
        this.jHj.extra = bzVar.mRecomExtra;
        this.jHj.ab_tag = bzVar.mRecomAbTag;
        this.jHj.weight = bzVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dta() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dsZ() {
        this.mAp = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dyA();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.amL) {
                if (this.mzV != null) {
                    fZ(this.mzV.forum_id, this.mzV.thread_id);
                }
            } else if (this.jHj != null) {
                fZ(this.jHj.forumId, this.jHj.threadId);
            }
        }
    }

    private void fZ(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.mzW);
        pbActivityConfig.setVideoOriginArea(ay.bw(this.mAL));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.an(this.mzW);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.ake != null) {
            this.ake.onClick(dxG());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dsX() {
        if (this.mAw == this.mAo) {
            dyt();
        }
    }

    public void dyt() {
        Gf(this.mAp);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dys() {
        return false;
    }
}
