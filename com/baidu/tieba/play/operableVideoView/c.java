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
    private VideoSerializeVideoThreadInfo jzo;
    private VideoItemData mzl;
    private by mzm;

    public c(Context context, View view) {
        super(context, view);
        xc(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mAc.setOnTouchListener(null);
        this.mAc.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(by byVar) {
        super.setData(byVar);
        this.mzm = byVar;
        if (this.amX) {
            this.mzl = new VideoItemData();
            this.mzl.buildWithThreadData(byVar);
            return;
        }
        this.jzo = new VideoSerializeVideoThreadInfo();
        this.jzo.copyFromThreadInfo(byVar);
        this.jzo.source = byVar.mRecomSource;
        this.jzo.extra = byVar.mRecomExtra;
        this.jzo.ab_tag = byVar.mRecomAbTag;
        this.jzo.weight = byVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxb() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxa() {
        this.mzF = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dCB();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.amX) {
                if (this.mzl != null) {
                    gd(this.mzl.forum_id, this.mzl.thread_id);
                }
            } else if (this.jzo != null) {
                gd(this.jzo.forumId, this.jzo.threadId);
            }
        }
    }

    private void gd(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.mzm);
        pbActivityConfig.setVideoOriginArea(az.bn(this.mAc));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.an(this.mzm);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.akt != null) {
            this.akt.onClick(dBH());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwY() {
        if (this.mzM == this.mzE) {
            dCu();
        }
    }

    public void dCu() {
        HS(this.mzF);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dCt() {
        return false;
    }
}
