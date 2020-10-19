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
import com.baidu.tieba.card.m;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends d {
    private VideoSerializeVideoThreadInfo iSH;
    private VideoItemData lSq;
    private bw lSr;

    public b(Context context, View view) {
        super(context, view);
        this.lSs = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        vV(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.lTh.setOnTouchListener(null);
        this.lTh.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        super.setData(bwVar);
        this.lSr = bwVar;
        if (this.alR) {
            this.lSq = new VideoItemData();
            this.lSq.buildWithThreadData(bwVar);
            return;
        }
        this.iSH = new VideoSerializeVideoThreadInfo();
        this.iSH.copyFromThreadInfo(bwVar);
        this.iSH.source = bwVar.mRecomSource;
        this.iSH.extra = bwVar.mRecomExtra;
        this.iSH.ab_tag = bwVar.mRecomAbTag;
        this.iSH.weight = bwVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dmz() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dmy() {
        this.lSK = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dsb();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.alR) {
                cis();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                cit();
            } else {
                cit();
            }
            if (this.ajo != null) {
                this.ajo.onClick(drg());
            }
        }
    }

    private void cis() {
        if (this.lSq != null) {
            ArrayList arrayList = new ArrayList();
            if (this.lSr != null) {
                this.lSq.buildWithThreadData(this.lSr);
            }
            arrayList.add(this.lSq);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.lSr != null && this.lSr.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.lSr.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cit() {
        if (this.iSH != null) {
            if (this.lSr != null) {
                this.iSH.copyFromThreadInfo(this.lSr);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.alS, m.bhT(), "", this.iSH);
            if (this.lSr != null && this.lSr.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.lSr.getBaijiahaoData().oriUgcNid);
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
    public void dmw() {
        if (this.lSR == this.lSJ) {
            drT();
        }
    }

    public void drT() {
        FX(this.lSK);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean drS() {
        return false;
    }
}
