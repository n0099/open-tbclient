package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends d {
    private VideoSerializeVideoThreadInfo jLP;
    private VideoItemData mEE;
    private bz mEF;

    public b(Context context, View view) {
        super(context, view);
        this.mEG = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        xd(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mFu.setOnTouchListener(null);
        this.mFu.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bz bzVar) {
        super.setData(bzVar);
        this.mEF = bzVar;
        if (this.anC) {
            this.mEE = new VideoItemData();
            this.mEE.buildWithThreadData(bzVar);
            return;
        }
        this.jLP = new VideoSerializeVideoThreadInfo();
        this.jLP.copyFromThreadInfo(bzVar);
        this.jLP.source = bzVar.mRecomSource;
        this.jLP.extra = bzVar.mRecomExtra;
        this.jLP.ab_tag = bzVar.mRecomAbTag;
        this.jLP.weight = bzVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwS() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwR() {
        this.mEY = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dCs();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.anC) {
                cuK();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(this.mFrom)) {
                cuL();
            } else {
                cuL();
            }
            if (this.akV != null) {
                this.akV.onClick(dBy());
            }
        }
    }

    private void cuK() {
        if (this.mEE != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mEF != null) {
                this.mEE.buildWithThreadData(this.mEF);
            }
            arrayList.add(this.mEE);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.mEF != null && this.mEF.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.mEF.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cuL() {
        if (this.jLP != null) {
            if (this.mEF != null) {
                this.jLP.copyFromThreadInfo(this.mEF);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.anD, m.brd(), "", this.jLP);
            if (this.mEF != null && this.mEF.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.mEF.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwP() {
        if (this.mFf == this.mEX) {
            dCl();
        }
    }

    public void dCl() {
        HL(this.mEY);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dCk() {
        return false;
    }
}
