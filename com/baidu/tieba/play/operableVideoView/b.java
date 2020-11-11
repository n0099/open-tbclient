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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends d {
    private VideoSerializeVideoThreadInfo jlb;
    private VideoItemData mkN;
    private bw mkO;

    public b(Context context, View view) {
        super(context, view);
        this.mkP = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        wv(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mlE.setOnTouchListener(null);
        this.mlE.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        super.setData(bwVar);
        this.mkO = bwVar;
        if (this.alS) {
            this.mkN = new VideoItemData();
            this.mkN.buildWithThreadData(bwVar);
            return;
        }
        this.jlb = new VideoSerializeVideoThreadInfo();
        this.jlb.copyFromThreadInfo(bwVar);
        this.jlb.source = bwVar.mRecomSource;
        this.jlb.extra = bwVar.mRecomExtra;
        this.jlb.ab_tag = bwVar.mRecomAbTag;
        this.jlb.weight = bwVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dsj() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dsi() {
        this.mlh = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dxK();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.alS) {
                coa();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                cob();
            } else {
                cob();
            }
            if (this.ajp != null) {
                this.ajp.onClick(dwP());
            }
        }
    }

    private void coa() {
        if (this.mkN != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mkO != null) {
                this.mkN.buildWithThreadData(this.mkO);
            }
            arrayList.add(this.mkN);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.mkO != null && this.mkO.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.mkO.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cob() {
        if (this.jlb != null) {
            if (this.mkO != null) {
                this.jlb.copyFromThreadInfo(this.mkO);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.alT, n.bmm(), "", this.jlb);
            if (this.mkO != null && this.mkO.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.mkO.getBaijiahaoData().oriUgcNid);
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
    public void dsg() {
        if (this.mlo == this.mlg) {
            dxC();
        }
    }

    public void dxC() {
        GD(this.mlh);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dxB() {
        return false;
    }
}
