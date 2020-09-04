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
    private VideoSerializeVideoThreadInfo iwv;
    private VideoItemData luk;
    private bw lul;

    public b(Context context, View view) {
        super(context, view);
        this.lum = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        vg(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.lvb.setOnTouchListener(null);
        this.lvb.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        super.setData(bwVar);
        this.lul = bwVar;
        if (this.akZ) {
            this.luk = new VideoItemData();
            this.luk.buildWithThreadData(bwVar);
            return;
        }
        this.iwv = new VideoSerializeVideoThreadInfo();
        this.iwv.copyFromThreadInfo(bwVar);
        this.iwv.source = bwVar.mRecomSource;
        this.iwv.extra = bwVar.mRecomExtra;
        this.iwv.ab_tag = bwVar.mRecomAbTag;
        this.iwv.weight = bwVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfm() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfl() {
        this.luE = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dkJ();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.akZ) {
                cbH();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                cbI();
            } else {
                cbI();
            }
            if (this.aiC != null) {
                this.aiC.onClick(djP());
            }
        }
    }

    private void cbH() {
        if (this.luk != null) {
            ArrayList arrayList = new ArrayList();
            if (this.lul != null) {
                this.luk.buildWithThreadData(this.lul);
            }
            arrayList.add(this.luk);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.lul != null && this.lul.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.lul.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cbI() {
        if (this.iwv != null) {
            if (this.lul != null) {
                this.iwv.copyFromThreadInfo(this.lul);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.ala, m.beq(), "", this.iwv);
            if (this.lul != null && this.lul.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.lul.getBaijiahaoData().oriUgcNid);
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
    public void dfj() {
        if (this.luL == this.luD) {
            dkB();
        }
    }

    public void dkB() {
        EQ(this.luE);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dkA() {
        return false;
    }
}
