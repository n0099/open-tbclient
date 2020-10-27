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
    private VideoSerializeVideoThreadInfo jfd;
    private VideoItemData meP;
    private bw meQ;

    public b(Context context, View view) {
        super(context, view);
        this.meR = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        wm(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mfG.setOnTouchListener(null);
        this.mfG.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        super.setData(bwVar);
        this.meQ = bwVar;
        if (this.alS) {
            this.meP = new VideoItemData();
            this.meP.buildWithThreadData(bwVar);
            return;
        }
        this.jfd = new VideoSerializeVideoThreadInfo();
        this.jfd.copyFromThreadInfo(bwVar);
        this.jfd.source = bwVar.mRecomSource;
        this.jfd.extra = bwVar.mRecomExtra;
        this.jfd.ab_tag = bwVar.mRecomAbTag;
        this.jfd.weight = bwVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dpH() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dpG() {
        this.mfj = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dvi();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.alS) {
                clz();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                clA();
            } else {
                clA();
            }
            if (this.ajp != null) {
                this.ajp.onClick(dun());
            }
        }
    }

    private void clz() {
        if (this.meP != null) {
            ArrayList arrayList = new ArrayList();
            if (this.meQ != null) {
                this.meP.buildWithThreadData(this.meQ);
            }
            arrayList.add(this.meP);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.meQ != null && this.meQ.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.meQ.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void clA() {
        if (this.jfd != null) {
            if (this.meQ != null) {
                this.jfd.copyFromThreadInfo(this.meQ);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.alT, n.bjM(), "", this.jfd);
            if (this.meQ != null && this.meQ.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.meQ.getBaijiahaoData().oriUgcNid);
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
    public void dpE() {
        if (this.mfq == this.mfi) {
            dva();
        }
    }

    public void dva() {
        Gq(this.mfj);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean duZ() {
        return false;
    }
}
