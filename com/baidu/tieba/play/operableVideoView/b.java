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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends c {
    private VideoItemData iyV;
    private VideoSerializeVideoThreadInfo iyW;
    private bh iyX;

    public b(Context context, View view) {
        super(context, view);
        this.iyY = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        pS(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void init() {
        super.init();
        this.izB.setOnTouchListener(null);
        this.izB.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bh bhVar) {
        super.setData(bhVar);
        this.iyX = bhVar;
        if (this.izD) {
            this.iyV = new VideoItemData();
            this.iyV.buildWithThreadData(bhVar);
            return;
        }
        this.iyW = new VideoSerializeVideoThreadInfo();
        this.iyW.copyFromThreadInfo(bhVar);
        this.iyW.source = bhVar.mRecomSource;
        this.iyW.extra = bhVar.mRecomExtra;
        this.iyW.ab_tag = bhVar.mRecomAbTag;
        this.iyW.weight = bhVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void ccW() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void ccX() {
        this.izc = 128;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cdf();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.izD) {
                bad();
            } else {
                bae();
            }
            if (this.clw != null) {
                this.clw.onClick(cbV());
            }
        }
    }

    private void bad() {
        if (this.iyV != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.iyV);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom)));
        }
    }

    private void bae() {
        if (this.iyW != null) {
            if (this.iyX != null) {
                this.iyW.copyFromThreadInfo(this.iyX);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.cma, n.air(), "", this.iyW)));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected void ccY() {
        if (this.izi == this.izb) {
            ccZ();
        }
    }

    public void ccZ() {
        xJ(this.izc);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
