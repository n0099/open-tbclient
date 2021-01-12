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
    private VideoSerializeVideoThreadInfo jHj;
    private VideoItemData mzV;
    private bz mzW;

    public b(Context context, View view) {
        super(context, view);
        this.mzX = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        wZ(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mAL.setOnTouchListener(null);
        this.mAL.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bz bzVar) {
        super.setData(bzVar);
        this.mzW = bzVar;
        if (this.amL) {
            this.mzV = new VideoItemData();
            this.mzV.buildWithThreadData(bzVar);
            return;
        }
        this.jHj = new VideoSerializeVideoThreadInfo();
        this.jHj.copyFromThreadInfo(bzVar);
        this.jHj.source = bzVar.mRecomSource;
        this.jHj.extra = bzVar.mRecomExtra;
        this.jHj.ab_tag = bzVar.mRecomAbTag;
        this.jHj.weight = bzVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dta() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dsZ() {
        this.mAp = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dyA();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.amL) {
                cqS();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(this.mFrom)) {
                cqT();
            } else {
                cqT();
            }
            if (this.ake != null) {
                this.ake.onClick(dxG());
            }
        }
    }

    private void cqS() {
        if (this.mzV != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mzW != null) {
                this.mzV.buildWithThreadData(this.mzW);
            }
            arrayList.add(this.mzV);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.mzW != null && this.mzW.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.mzW.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cqT() {
        if (this.jHj != null) {
            if (this.mzW != null) {
                this.jHj.copyFromThreadInfo(this.mzW);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.amM, m.bnj(), "", this.jHj);
            if (this.mzW != null && this.mzW.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.mzW.getBaijiahaoData().oriUgcNid);
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
    public void dsX() {
        if (this.mAw == this.mAo) {
            dyt();
        }
    }

    public void dyt() {
        Gf(this.mAp);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dys() {
        return false;
    }
}
