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
    private VideoItemData mEF;
    private bz mEG;

    public b(Context context, View view) {
        super(context, view);
        this.mEH = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        xd(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mFv.setOnTouchListener(null);
        this.mFv.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bz bzVar) {
        super.setData(bzVar);
        this.mEG = bzVar;
        if (this.anC) {
            this.mEF = new VideoItemData();
            this.mEF.buildWithThreadData(bzVar);
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
    public void dwR() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dwQ() {
        this.mEZ = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dCr();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.anC) {
                cuJ();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(this.mFrom)) {
                cuK();
            } else {
                cuK();
            }
            if (this.akV != null) {
                this.akV.onClick(dBx());
            }
        }
    }

    private void cuJ() {
        if (this.mEF != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mEG != null) {
                this.mEF.buildWithThreadData(this.mEG);
            }
            arrayList.add(this.mEF);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.mEG != null && this.mEG.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.mEG.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cuK() {
        if (this.jLP != null) {
            if (this.mEG != null) {
                this.jLP.copyFromThreadInfo(this.mEG);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.anD, m.brc(), "", this.jLP);
            if (this.mEG != null && this.mEG.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.mEG.getBaijiahaoData().oriUgcNid);
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
    public void dwO() {
        if (this.mFg == this.mEY) {
            dCk();
        }
    }

    public void dCk() {
        HL(this.mEZ);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dCj() {
        return false;
    }
}
