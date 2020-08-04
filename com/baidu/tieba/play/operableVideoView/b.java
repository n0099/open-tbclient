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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends d {
    private VideoSerializeVideoThreadInfo iik;
    private VideoItemData ldF;
    private bv ldG;

    public b(Context context, View view) {
        super(context, view);
        this.ldH = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        us(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.lex.setOnTouchListener(null);
        this.lex.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bv bvVar) {
        super.setData(bvVar);
        this.ldG = bvVar;
        if (this.ajI) {
            this.ldF = new VideoItemData();
            this.ldF.buildWithThreadData(bvVar);
            return;
        }
        this.iik = new VideoSerializeVideoThreadInfo();
        this.iik.copyFromThreadInfo(bvVar);
        this.iik.source = bvVar.mRecomSource;
        this.iik.extra = bvVar.mRecomExtra;
        this.iik.ab_tag = bvVar.mRecomAbTag;
        this.iik.weight = bvVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cUo() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cUn() {
        this.ldZ = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cZC();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.ajI) {
                bRu();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                bRv();
            } else {
                bRv();
            }
            if (this.ahn != null) {
                this.ahn.onClick(cYJ());
            }
        }
    }

    private void bRu() {
        if (this.ldF != null) {
            ArrayList arrayList = new ArrayList();
            if (this.ldG != null) {
                this.ldF.buildWithThreadData(this.ldG);
            }
            arrayList.add(this.ldF);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.ldG != null && this.ldG.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.ldG.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bRv() {
        if (this.iik != null) {
            if (this.ldG != null) {
                this.iik.copyFromThreadInfo(this.ldG);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.ajJ, m.aVX(), "", this.iik);
            if (this.ldG != null && this.ldG.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.ldG.getBaijiahaoData().oriUgcNid);
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
    public void cUl() {
        if (this.leg == this.ldY) {
            cZu();
        }
    }

    public void cZu() {
        Cw(this.ldZ);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cZt() {
        return false;
    }
}
