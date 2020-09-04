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
    private VideoSerializeVideoThreadInfo iwv;
    private VideoItemData luk;
    private bw lul;

    public c(Context context, View view) {
        super(context, view);
        vg(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.lvb.setOnTouchListener(null);
        this.lvb.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        super.setData(bwVar);
        this.lul = bwVar;
        if (this.akZ) {
            this.luk = new VideoItemData();
            this.luk.buildWithThreadData(bwVar);
            return;
        }
        this.iwv = new VideoSerializeVideoThreadInfo();
        this.iwv.copyFromThreadInfo(bwVar);
        this.iwv.source = bwVar.mRecomSource;
        this.iwv.extra = bwVar.mRecomExtra;
        this.iwv.ab_tag = bwVar.mRecomAbTag;
        this.iwv.weight = bwVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfm() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfl() {
        this.luE = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dkJ();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.akZ) {
                if (this.luk != null) {
                    fz(this.luk.forum_id, this.luk.thread_id);
                }
            } else if (this.iwv != null) {
                fz(this.iwv.forumId, this.iwv.threadId);
            }
        }
    }

    private void fz(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.lul);
        pbActivityConfig.setVideoOriginArea(ay.aY(this.lvb));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.ak(this.lul);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.aiC != null) {
            this.aiC.onClick(djP());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfj() {
        if (this.luL == this.luD) {
            dkB();
        }
    }

    public void dkB() {
        EQ(this.luE);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dkA() {
        return false;
    }
}
