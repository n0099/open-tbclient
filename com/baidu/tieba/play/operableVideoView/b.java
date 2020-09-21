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
    private VideoSerializeVideoThreadInfo iDR;
    private VideoItemData lDb;
    private bw lDc;

    public b(Context context, View view) {
        super(context, view);
        this.lDd = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        vo(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.lDS.setOnTouchListener(null);
        this.lDS.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        super.setData(bwVar);
        this.lDc = bwVar;
        if (this.alz) {
            this.lDb = new VideoItemData();
            this.lDb.buildWithThreadData(bwVar);
            return;
        }
        this.iDR = new VideoSerializeVideoThreadInfo();
        this.iDR.copyFromThreadInfo(bwVar);
        this.iDR.source = bwVar.mRecomSource;
        this.iDR.extra = bwVar.mRecomExtra;
        this.iDR.ab_tag = bwVar.mRecomAbTag;
        this.iDR.weight = bwVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void diQ() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void diP() {
        this.lDv = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                doq();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.alz) {
                ceW();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                ceX();
            } else {
                ceX();
            }
            if (this.aiW != null) {
                this.aiW.onClick(dnv());
            }
        }
    }

    private void ceW() {
        if (this.lDb != null) {
            ArrayList arrayList = new ArrayList();
            if (this.lDc != null) {
                this.lDb.buildWithThreadData(this.lDc);
            }
            arrayList.add(this.lDb);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.lDc != null && this.lDc.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.lDc.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void ceX() {
        if (this.iDR != null) {
            if (this.lDc != null) {
                this.iDR.copyFromThreadInfo(this.lDc);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.alA, m.bfk(), "", this.iDR);
            if (this.lDc != null && this.lDc.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.lDc.getBaijiahaoData().oriUgcNid);
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
    public void diN() {
        if (this.lDC == this.lDu) {
            doi();
        }
    }

    public void doi() {
        Fr(this.lDv);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean doh() {
        return false;
    }
}
