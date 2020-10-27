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
    private VideoSerializeVideoThreadInfo jfd;
    private VideoItemData meP;
    private bw meQ;

    public c(Context context, View view) {
        super(context, view);
        wm(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mfG.setOnTouchListener(null);
        this.mfG.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        super.setData(bwVar);
        this.meQ = bwVar;
        if (this.alS) {
            this.meP = new VideoItemData();
            this.meP.buildWithThreadData(bwVar);
            return;
        }
        this.jfd = new VideoSerializeVideoThreadInfo();
        this.jfd.copyFromThreadInfo(bwVar);
        this.jfd.source = bwVar.mRecomSource;
        this.jfd.extra = bwVar.mRecomExtra;
        this.jfd.ab_tag = bwVar.mRecomAbTag;
        this.jfd.weight = bwVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dpH() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dpG() {
        this.mfj = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dvi();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.alS) {
                if (this.meP != null) {
                    fY(this.meP.forum_id, this.meP.thread_id);
                }
            } else if (this.jfd != null) {
                fY(this.jfd.forumId, this.jfd.threadId);
            }
        }
    }

    private void fY(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.meQ);
        pbActivityConfig.setVideoOriginArea(ay.bd(this.mfG));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.al(this.meQ);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.ajp != null) {
            this.ajp.onClick(dun());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dpE() {
        if (this.mfq == this.mfi) {
            dva();
        }
    }

    public void dva() {
        Gq(this.mfj);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean duZ() {
        return false;
    }
}
