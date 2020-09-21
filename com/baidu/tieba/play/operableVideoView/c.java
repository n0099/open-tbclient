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
    private VideoSerializeVideoThreadInfo iDR;
    private VideoItemData lDb;
    private bw lDc;

    public c(Context context, View view) {
        super(context, view);
        vo(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.lDS.setOnTouchListener(null);
        this.lDS.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        super.setData(bwVar);
        this.lDc = bwVar;
        if (this.alz) {
            this.lDb = new VideoItemData();
            this.lDb.buildWithThreadData(bwVar);
            return;
        }
        this.iDR = new VideoSerializeVideoThreadInfo();
        this.iDR.copyFromThreadInfo(bwVar);
        this.iDR.source = bwVar.mRecomSource;
        this.iDR.extra = bwVar.mRecomExtra;
        this.iDR.ab_tag = bwVar.mRecomAbTag;
        this.iDR.weight = bwVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void diQ() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void diP() {
        this.lDv = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                doq();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.alz) {
                if (this.lDb != null) {
                    fM(this.lDb.forum_id, this.lDb.thread_id);
                }
            } else if (this.iDR != null) {
                fM(this.iDR.forumId, this.iDR.threadId);
            }
        }
    }

    private void fM(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.lDc);
        pbActivityConfig.setVideoOriginArea(ay.ba(this.lDS));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.al(this.lDc);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.aiW != null) {
            this.aiW.onClick(dnv());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void diN() {
        if (this.lDC == this.lDu) {
            doi();
        }
    }

    public void doi() {
        Fr(this.lDv);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean doh() {
        return false;
    }
}
