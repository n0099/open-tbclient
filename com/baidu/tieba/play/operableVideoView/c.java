package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes.dex */
public class c extends d {
    private VideoSerializeVideoThreadInfo gII;
    private VideoItemData jsP;
    private bj jsQ;

    public c(Context context, View view) {
        super(context, view);
        rB(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jtF.setOnTouchListener(null);
        this.jtF.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.jsQ = bjVar;
        if (this.OB) {
            this.jsP = new VideoItemData();
            this.jsP.buildWithThreadData(bjVar);
            return;
        }
        this.gII = new VideoSerializeVideoThreadInfo();
        this.gII.copyFromThreadInfo(bjVar);
        this.gII.source = bjVar.mRecomSource;
        this.gII.extra = bjVar.mRecomExtra;
        this.gII.ab_tag = bjVar.mRecomAbTag;
        this.gII.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void crp() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cro() {
        this.jti = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cxa();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.OB) {
                if (this.jsP != null) {
                    dZ(this.jsP.forum_id, this.jsP.thread_id);
                }
            } else if (this.gII != null) {
                dZ(this.gII.forumId, this.gII.threadId);
            }
        }
    }

    private void dZ(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.jsQ);
        pbActivityConfig.setVideoOriginArea(au.aL(this.jtF));
        pbActivityConfig.setNeedPreLoad(true);
        i.ah(this.jsQ);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.Mz != null) {
            this.Mz.onClick(cvN());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void crk() {
        if (this.jto == this.jth) {
            cwU();
        }
    }

    public void cwU() {
        zm(this.jti);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
