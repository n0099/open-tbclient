package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes.dex */
public class c extends d {
    private VideoSerializeVideoThreadInfo iik;
    private VideoItemData ldF;
    private bv ldG;

    public c(Context context, View view) {
        super(context, view);
        us(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.lex.setOnTouchListener(null);
        this.lex.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bv bvVar) {
        super.setData(bvVar);
        this.ldG = bvVar;
        if (this.ajI) {
            this.ldF = new VideoItemData();
            this.ldF.buildWithThreadData(bvVar);
            return;
        }
        this.iik = new VideoSerializeVideoThreadInfo();
        this.iik.copyFromThreadInfo(bvVar);
        this.iik.source = bvVar.mRecomSource;
        this.iik.extra = bvVar.mRecomExtra;
        this.iik.ab_tag = bvVar.mRecomAbTag;
        this.iik.weight = bvVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cUo() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cUn() {
        this.ldZ = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cZC();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.ajI) {
                if (this.ldF != null) {
                    fh(this.ldF.forum_id, this.ldF.thread_id);
                }
            } else if (this.iik != null) {
                fh(this.iik.forumId, this.iik.threadId);
            }
        }
    }

    private void fh(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.ldG);
        pbActivityConfig.setVideoOriginArea(ax.aW(this.lex));
        pbActivityConfig.setNeedPreLoad(true);
        k.ak(this.ldG);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.ahn != null) {
            this.ahn.onClick(cYJ());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cUl() {
        if (this.leg == this.ldY) {
            cZu();
        }
    }

    public void cZu() {
        Cw(this.ldZ);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cZt() {
        return false;
    }
}
