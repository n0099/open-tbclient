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
    private VideoSerializeVideoThreadInfo hzo;
    private VideoItemData kjc;
    private bj kjd;

    public c(Context context, View view) {
        super(context, view);
        tb(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kjT.setOnTouchListener(null);
        this.kjT.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.kjd = bjVar;
        if (this.ahK) {
            this.kjc = new VideoItemData();
            this.kjc.buildWithThreadData(bjVar);
            return;
        }
        this.hzo = new VideoSerializeVideoThreadInfo();
        this.hzo.copyFromThreadInfo(bjVar);
        this.hzo.source = bjVar.mRecomSource;
        this.hzo.extra = bjVar.mRecomExtra;
        this.hzo.ab_tag = bjVar.mRecomAbTag;
        this.hzo.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cET() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cES() {
        this.kjw = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cKL();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.ahK) {
                if (this.kjc != null) {
                    ex(this.kjc.forum_id, this.kjc.thread_id);
                }
            } else if (this.hzo != null) {
                ex(this.hzo.forumId, this.hzo.threadId);
            }
        }
    }

    private void ex(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.kjd);
        pbActivityConfig.setVideoOriginArea(au.aQ(this.kjT));
        pbActivityConfig.setNeedPreLoad(true);
        i.am(this.kjd);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.afS != null) {
            this.afS.onClick(cJq());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cEQ() {
        if (this.kjD == this.kjv) {
            cKD();
        }
    }

    public void cKD() {
        Ah(this.kjw);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
