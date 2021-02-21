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
    private VideoSerializeVideoThreadInfo jNb;
    private VideoItemData mJv;
    private cb mJw;

    public b(Context context, View view) {
        super(context, view);
        this.mJx = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        xr(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mKk.setOnTouchListener(null);
        this.mKk.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(cb cbVar) {
        super.setData(cbVar);
        this.mJw = cbVar;
        if (this.amB) {
            this.mJv = new VideoItemData();
            this.mJv.buildWithThreadData(cbVar);
            return;
        }
        this.jNb = new VideoSerializeVideoThreadInfo();
        this.jNb.copyFromThreadInfo(cbVar);
        this.jNb.source = cbVar.mRecomSource;
        this.jNb.extra = cbVar.mRecomExtra;
        this.jNb.ab_tag = cbVar.mRecomAbTag;
        this.jNb.weight = cbVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvu() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvt() {
        this.mJP = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dAR();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (com.baidu.tbadk.a.d.bjA()) {
                dAI();
            } else if (com.baidu.tbadk.a.d.bjB()) {
                csj();
            } else if (com.baidu.tbadk.a.d.bjy()) {
                dAJ();
            } else if (this.amB) {
                csj();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(this.mFrom)) {
                csk();
            } else {
                csk();
            }
            if (this.ajT != null) {
                this.ajT.onClick(dzW());
            }
        }
    }

    private void csj() {
        if (this.mJw != null) {
            if (this.mJv == null) {
                this.mJv = new VideoItemData();
            }
            ArrayList arrayList = new ArrayList();
            this.mJv.buildWithThreadData(this.mJw);
            arrayList.add(this.mJv);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.mJw != null && this.mJw.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.mJw.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void csk() {
        if (this.jNb != null) {
            if (this.mJw != null) {
                this.jNb.copyFromThreadInfo(this.mJw);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.amC, m.bnC(), "", this.jNb);
            if (this.mJw != null && this.mJw.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.mJw.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void dAI() {
        if (this.mJw != null) {
            if (this.jNb == null) {
                this.jNb = new VideoSerializeVideoThreadInfo();
            }
            this.jNb.copyFromThreadInfo(this.mJw);
            VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(this.mContext, this.mFrom, this.amC, m.bnC(), "", this.jNb);
            if (this.mJw != null && this.mJw.getBaijiahaoData() != null) {
                videoMiddlePageLightActivityConfig.setNid(this.mJw.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageLightActivityConfig));
        }
    }

    private void dAJ() {
        if (this.agk != null) {
            this.agk.onClick(dzW());
        } else if (this.jNb != null) {
            String str = this.jNb.threadId;
            String str2 = this.jNb.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.mJw);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvr() {
        if (this.mViewState == this.mJO) {
            dAK();
        }
    }

    public void dAK() {
        Gy(this.mJP);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dAH() {
        return false;
    }
}
