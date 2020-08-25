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
/* loaded from: classes2.dex */
public class b extends d {
    private VideoSerializeVideoThreadInfo iwp;
    private VideoItemData ltZ;
    private bw lua;

    public b(Context context, View view) {
        super(context, view);
        this.lub = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        ve(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.luQ.setOnTouchListener(null);
        this.luQ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        super.setData(bwVar);
        this.lua = bwVar;
        if (this.akX) {
            this.ltZ = new VideoItemData();
            this.ltZ.buildWithThreadData(bwVar);
            return;
        }
        this.iwp = new VideoSerializeVideoThreadInfo();
        this.iwp.copyFromThreadInfo(bwVar);
        this.iwp.source = bwVar.mRecomSource;
        this.iwp.extra = bwVar.mRecomExtra;
        this.iwp.ab_tag = bwVar.mRecomAbTag;
        this.iwp.weight = bwVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfl() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfk() {
        this.lut = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dkG();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.akX) {
                cbG();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                cbH();
            } else {
                cbH();
            }
            if (this.aiA != null) {
                this.aiA.onClick(djM());
            }
        }
    }

    private void cbG() {
        if (this.ltZ != null) {
            ArrayList arrayList = new ArrayList();
            if (this.lua != null) {
                this.ltZ.buildWithThreadData(this.lua);
            }
            arrayList.add(this.ltZ);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.lua != null && this.lua.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.lua.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cbH() {
        if (this.iwp != null) {
            if (this.lua != null) {
                this.iwp.copyFromThreadInfo(this.lua);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.akY, m.beq(), "", this.iwp);
            if (this.lua != null && this.lua.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.lua.getBaijiahaoData().oriUgcNid);
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
    public void dfi() {
        if (this.luA == this.lus) {
            dky();
        }
    }

    public void dky() {
        EQ(this.lut);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dkx() {
        return false;
    }
}
