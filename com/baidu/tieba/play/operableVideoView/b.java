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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends d {
    private VideoSerializeVideoThreadInfo jlL;
    private VideoItemData mlh;
    private bx mli;

    public b(Context context, View view) {
        super(context, view);
        this.mlj = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        wy(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.mlY.setOnTouchListener(null);
        this.mlY.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bx bxVar) {
        super.setData(bxVar);
        this.mli = bxVar;
        if (this.alY) {
            this.mlh = new VideoItemData();
            this.mlh.buildWithThreadData(bxVar);
            return;
        }
        this.jlL = new VideoSerializeVideoThreadInfo();
        this.jlL.copyFromThreadInfo(bxVar);
        this.jlL.source = bxVar.mRecomSource;
        this.jlL.extra = bxVar.mRecomExtra;
        this.jlL.ab_tag = bxVar.mRecomAbTag;
        this.jlL.weight = bxVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void drJ() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void drI() {
        this.mlB = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dxk();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.alY) {
                cnC();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                cnD();
            } else {
                cnD();
            }
            if (this.aju != null) {
                this.aju.onClick(dwp());
            }
        }
    }

    private void cnC() {
        if (this.mlh != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mli != null) {
                this.mlh.buildWithThreadData(this.mli);
            }
            arrayList.add(this.mlh);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.mli != null && this.mli.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.mli.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cnD() {
        if (this.jlL != null) {
            if (this.mli != null) {
                this.jlL.copyFromThreadInfo(this.mli);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.alZ, n.blo(), "", this.jlL);
            if (this.mli != null && this.mli.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.mli.getBaijiahaoData().oriUgcNid);
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
    public void drG() {
        if (this.mlI == this.mlA) {
            dxc();
        }
    }

    public void dxc() {
        Hb(this.mlB);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dxb() {
        return false;
    }
}
