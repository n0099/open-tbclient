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
    private VideoSerializeVideoThreadInfo jzo;
    private VideoItemData mzl;
    private by mzm;

    public b(Context context, View view) {
        super(context, view);
        this.mzn = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        xc(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mAc.setOnTouchListener(null);
        this.mAc.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(by byVar) {
        super.setData(byVar);
        this.mzm = byVar;
        if (this.amX) {
            this.mzl = new VideoItemData();
            this.mzl.buildWithThreadData(byVar);
            return;
        }
        this.jzo = new VideoSerializeVideoThreadInfo();
        this.jzo.copyFromThreadInfo(byVar);
        this.jzo.source = byVar.mRecomSource;
        this.jzo.extra = byVar.mRecomExtra;
        this.jzo.ab_tag = byVar.mRecomAbTag;
        this.jzo.weight = byVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxb() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dxa() {
        this.mzF = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dCB();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.amX) {
                crP();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                crQ();
            } else {
                crQ();
            }
            if (this.akt != null) {
                this.akt.onClick(dBH());
            }
        }
    }

    private void crP() {
        if (this.mzl != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mzm != null) {
                this.mzl.buildWithThreadData(this.mzm);
            }
            arrayList.add(this.mzl);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.mzm != null && this.mzm.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.mzm.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void crQ() {
        if (this.jzo != null) {
            if (this.mzm != null) {
                this.jzo.copyFromThreadInfo(this.mzm);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.amY, n.boB(), "", this.jzo);
            if (this.mzm != null && this.mzm.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.mzm.getBaijiahaoData().oriUgcNid);
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
    public void dwY() {
        if (this.mzM == this.mzE) {
            dCu();
        }
    }

    public void dCu() {
        HS(this.mzF);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dCt() {
        return false;
    }
}
