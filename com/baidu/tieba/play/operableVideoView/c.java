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
    private VideoSerializeVideoThreadInfo hzu;
    private VideoItemData kjg;
    private bj kjh;

    public c(Context context, View view) {
        super(context, view);
        tb(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kjX.setOnTouchListener(null);
        this.kjX.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.kjh = bjVar;
        if (this.ahN) {
            this.kjg = new VideoItemData();
            this.kjg.buildWithThreadData(bjVar);
            return;
        }
        this.hzu = new VideoSerializeVideoThreadInfo();
        this.hzu.copyFromThreadInfo(bjVar);
        this.hzu.source = bjVar.mRecomSource;
        this.hzu.extra = bjVar.mRecomExtra;
        this.hzu.ab_tag = bjVar.mRecomAbTag;
        this.hzu.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cEQ() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cEP() {
        this.kjA = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cKI();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.ahN) {
                if (this.kjg != null) {
                    ex(this.kjg.forum_id, this.kjg.thread_id);
                }
            } else if (this.hzu != null) {
                ex(this.hzu.forumId, this.hzu.threadId);
            }
        }
    }

    private void ex(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.kjh);
        pbActivityConfig.setVideoOriginArea(au.aQ(this.kjX));
        pbActivityConfig.setNeedPreLoad(true);
        i.am(this.kjh);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.afV != null) {
            this.afV.onClick(cJn());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cEN() {
        if (this.kjH == this.kjz) {
            cKA();
        }
    }

    public void cKA() {
        Ah(this.kjA);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
