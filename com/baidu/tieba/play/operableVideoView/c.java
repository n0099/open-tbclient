package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes.dex */
public class c extends d {
    private VideoSerializeVideoThreadInfo jlL;
    private VideoItemData mlh;
    private bx mli;

    public c(Context context, View view) {
        super(context, view);
        wy(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mlY.setOnTouchListener(null);
        this.mlY.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bx bxVar) {
        super.setData(bxVar);
        this.mli = bxVar;
        if (this.alY) {
            this.mlh = new VideoItemData();
            this.mlh.buildWithThreadData(bxVar);
            return;
        }
        this.jlL = new VideoSerializeVideoThreadInfo();
        this.jlL.copyFromThreadInfo(bxVar);
        this.jlL.source = bxVar.mRecomSource;
        this.jlL.extra = bxVar.mRecomExtra;
        this.jlL.ab_tag = bxVar.mRecomAbTag;
        this.jlL.weight = bxVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void drJ() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void drI() {
        this.mlB = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dxk();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.alY) {
                if (this.mlh != null) {
                    fY(this.mlh.forum_id, this.mlh.thread_id);
                }
            } else if (this.jlL != null) {
                fY(this.jlL.forumId, this.jlL.threadId);
            }
        }
    }

    private void fY(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.mli);
        pbActivityConfig.setVideoOriginArea(az.bk(this.mlY));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.an(this.mli);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.aju != null) {
            this.aju.onClick(dwp());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void drG() {
        if (this.mlI == this.mlA) {
            dxc();
        }
    }

    public void dxc() {
        Hb(this.mlB);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dxb() {
        return false;
    }
}
