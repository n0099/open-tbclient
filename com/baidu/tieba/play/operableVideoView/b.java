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
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends d {
    private VideoSerializeVideoThreadInfo jzq;
    private VideoItemData mzn;
    private by mzo;

    public b(Context context, View view) {
        super(context, view);
        this.mzp = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        xc(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mAe.setOnTouchListener(null);
        this.mAe.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(by byVar) {
        super.setData(byVar);
        this.mzo = byVar;
        if (this.amX) {
            this.mzn = new VideoItemData();
            this.mzn.buildWithThreadData(byVar);
            return;
        }
        this.jzq = new VideoSerializeVideoThreadInfo();
        this.jzq.copyFromThreadInfo(byVar);
        this.jzq.source = byVar.mRecomSource;
        this.jzq.extra = byVar.mRecomExtra;
        this.jzq.ab_tag = byVar.mRecomAbTag;
        this.jzq.weight = byVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxc() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxb() {
        this.mzH = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dCC();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.amX) {
                crQ();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                crR();
            } else {
                crR();
            }
            if (this.akt != null) {
                this.akt.onClick(dBI());
            }
        }
    }

    private void crQ() {
        if (this.mzn != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mzo != null) {
                this.mzn.buildWithThreadData(this.mzo);
            }
            arrayList.add(this.mzn);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.mzo != null && this.mzo.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.mzo.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void crR() {
        if (this.jzq != null) {
            if (this.mzo != null) {
                this.jzq.copyFromThreadInfo(this.mzo);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.amY, n.boB(), "", this.jzq);
            if (this.mzo != null && this.mzo.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.mzo.getBaijiahaoData().oriUgcNid);
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
    public void dwZ() {
        if (this.mzO == this.mzG) {
            dCv();
        }
    }

    public void dCv() {
        HS(this.mzH);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dCu() {
        return false;
    }
}
