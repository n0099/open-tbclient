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
    private VideoSerializeVideoThreadInfo gOi;
    private VideoItemData jxB;
    private bj jxC;

    public c(Context context, View view) {
        super(context, view);
        rR(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jyq.setOnTouchListener(null);
        this.jyq.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.jxC = bjVar;
        if (this.Pi) {
            this.jxB = new VideoItemData();
            this.jxB.buildWithThreadData(bjVar);
            return;
        }
        this.gOi = new VideoSerializeVideoThreadInfo();
        this.gOi.copyFromThreadInfo(bjVar);
        this.gOi.source = bjVar.mRecomSource;
        this.gOi.extra = bjVar.mRecomExtra;
        this.gOi.ab_tag = bjVar.mRecomAbTag;
        this.gOi.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctU() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctT() {
        this.jxU = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                czH();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.Pi) {
                if (this.jxB != null) {
                    ek(this.jxB.forum_id, this.jxB.thread_id);
                }
            } else if (this.gOi != null) {
                ek(this.gOi.forumId, this.gOi.threadId);
            }
        }
    }

    private void ek(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.jxC);
        pbActivityConfig.setVideoOriginArea(au.aP(this.jyq));
        pbActivityConfig.setNeedPreLoad(true);
        i.aj(this.jxC);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.Nh != null) {
            this.Nh.onClick(cys());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctP() {
        if (this.jya == this.jxT) {
            czA();
        }
    }

    public void czA() {
        zy(this.jxU);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
