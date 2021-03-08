package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageLightActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends d {
    private VideoSerializeVideoThreadInfo jOK;
    private VideoItemData mLx;
    private cb mLy;

    public b(Context context, View view) {
        super(context, view);
        this.mLz = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        xr(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mMm.setOnTouchListener(null);
        this.mMm.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(cb cbVar) {
        super.setData(cbVar);
        this.mLy = cbVar;
        if (this.anT) {
            this.mLx = new VideoItemData();
            this.mLx.buildWithThreadData(cbVar);
            return;
        }
        this.jOK = new VideoSerializeVideoThreadInfo();
        this.jOK.copyFromThreadInfo(cbVar);
        this.jOK.source = cbVar.mRecomSource;
        this.jOK.extra = cbVar.mRecomExtra;
        this.jOK.ab_tag = cbVar.mRecomAbTag;
        this.jOK.weight = cbVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvD() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvC() {
        this.mLR = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dAZ();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (com.baidu.tbadk.a.d.bjC()) {
                dAQ();
            } else if (com.baidu.tbadk.a.d.bjD()) {
                csp();
            } else if (com.baidu.tbadk.a.d.bjA()) {
                dAR();
            } else if (this.anT) {
                csp();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(this.mFrom)) {
                csq();
            } else {
                csq();
            }
            if (this.alm != null) {
                this.alm.onClick(dAf());
            }
        }
    }

    private void csp() {
        if (this.mLy != null) {
            if (this.mLx == null) {
                this.mLx = new VideoItemData();
            }
            ArrayList arrayList = new ArrayList();
            this.mLx.buildWithThreadData(this.mLy);
            arrayList.add(this.mLx);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.mLy != null && this.mLy.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.mLy.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void csq() {
        if (this.jOK != null) {
            if (this.mLy != null) {
                this.jOK.copyFromThreadInfo(this.mLy);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.anU, m.bnE(), "", this.jOK);
            if (this.mLy != null && this.mLy.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.mLy.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void dAQ() {
        if (this.mLy != null) {
            if (this.jOK == null) {
                this.jOK = new VideoSerializeVideoThreadInfo();
            }
            this.jOK.copyFromThreadInfo(this.mLy);
            VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(this.mContext, this.mFrom, this.anU, m.bnE(), "", this.jOK);
            if (this.mLy != null && this.mLy.getBaijiahaoData() != null) {
                videoMiddlePageLightActivityConfig.setNid(this.mLy.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageLightActivityConfig));
        }
    }

    private void dAR() {
        if (this.ahC != null) {
            this.ahC.onClick(dAf());
        } else if (this.jOK != null) {
            String str = this.jOK.threadId;
            String str2 = this.jOK.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.mLy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvA() {
        if (this.mViewState == this.mLQ) {
            dAS();
        }
    }

    public void dAS() {
        GB(this.mLR);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dAP() {
        return false;
    }
}
