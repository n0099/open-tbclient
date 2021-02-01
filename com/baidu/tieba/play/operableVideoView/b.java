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
    private VideoSerializeVideoThreadInfo jMN;
    private VideoItemData mJg;
    private cb mJh;

    public b(Context context, View view) {
        super(context, view);
        this.mJi = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        xr(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mJV.setOnTouchListener(null);
        this.mJV.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(cb cbVar) {
        super.setData(cbVar);
        this.mJh = cbVar;
        if (this.amB) {
            this.mJg = new VideoItemData();
            this.mJg.buildWithThreadData(cbVar);
            return;
        }
        this.jMN = new VideoSerializeVideoThreadInfo();
        this.jMN.copyFromThreadInfo(cbVar);
        this.jMN.source = cbVar.mRecomSource;
        this.jMN.extra = cbVar.mRecomExtra;
        this.jMN.ab_tag = cbVar.mRecomAbTag;
        this.jMN.weight = cbVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvn() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvm() {
        this.mJA = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dAK();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (com.baidu.tbadk.a.d.bjA()) {
                dAB();
            } else if (com.baidu.tbadk.a.d.bjB()) {
                csc();
            } else if (com.baidu.tbadk.a.d.bjy()) {
                dAC();
            } else if (this.amB) {
                csc();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(this.mFrom)) {
                csd();
            } else {
                csd();
            }
            if (this.ajT != null) {
                this.ajT.onClick(dzP());
            }
        }
    }

    private void csc() {
        if (this.mJh != null) {
            if (this.mJg == null) {
                this.mJg = new VideoItemData();
            }
            ArrayList arrayList = new ArrayList();
            this.mJg.buildWithThreadData(this.mJh);
            arrayList.add(this.mJg);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.mJh != null && this.mJh.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.mJh.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void csd() {
        if (this.jMN != null) {
            if (this.mJh != null) {
                this.jMN.copyFromThreadInfo(this.mJh);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.amC, m.bnC(), "", this.jMN);
            if (this.mJh != null && this.mJh.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.mJh.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void dAB() {
        if (this.mJh != null) {
            if (this.jMN == null) {
                this.jMN = new VideoSerializeVideoThreadInfo();
            }
            this.jMN.copyFromThreadInfo(this.mJh);
            VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(this.mContext, this.mFrom, this.amC, m.bnC(), "", this.jMN);
            if (this.mJh != null && this.mJh.getBaijiahaoData() != null) {
                videoMiddlePageLightActivityConfig.setNid(this.mJh.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageLightActivityConfig));
        }
    }

    private void dAC() {
        if (this.agk != null) {
            this.agk.onClick(dzP());
        } else if (this.jMN != null) {
            String str = this.jMN.threadId;
            String str2 = this.jMN.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.mJh);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dvk() {
        if (this.mViewState == this.mJz) {
            dAD();
        }
    }

    public void dAD() {
        Gy(this.mJA);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dAA() {
        return false;
    }
}
