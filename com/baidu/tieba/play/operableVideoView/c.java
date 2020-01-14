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
    private VideoSerializeVideoThreadInfo gLV;
    private VideoItemData jww;
    private bj jwx;

    public c(Context context, View view) {
        super(context, view);
        rO(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jxm.setOnTouchListener(null);
        this.jxm.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.jwx = bjVar;
        if (this.OF) {
            this.jww = new VideoItemData();
            this.jww.buildWithThreadData(bjVar);
            return;
        }
        this.gLV = new VideoSerializeVideoThreadInfo();
        this.gLV.copyFromThreadInfo(bjVar);
        this.gLV.source = bjVar.mRecomSource;
        this.gLV.extra = bjVar.mRecomExtra;
        this.gLV.ab_tag = bjVar.mRecomAbTag;
        this.gLV.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void csy() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void csx() {
        this.jwP = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cyj();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.OF) {
                if (this.jww != null) {
                    eb(this.jww.forum_id, this.jww.thread_id);
                }
            } else if (this.gLV != null) {
                eb(this.gLV.forumId, this.gLV.threadId);
            }
        }
    }

    private void eb(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.jwx);
        pbActivityConfig.setVideoOriginArea(au.aP(this.jxm));
        pbActivityConfig.setNeedPreLoad(true);
        i.ai(this.jwx);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.MG != null) {
            this.MG.onClick(cwW());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cst() {
        if (this.jwV == this.jwO) {
            cyd();
        }
    }

    public void cyd() {
        zr(this.jwP);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
