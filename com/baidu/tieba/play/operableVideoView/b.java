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
    private VideoItemData izM;
    private VideoSerializeVideoThreadInfo izN;
    private bh izO;

    public b(Context context, View view) {
        super(context, view);
        this.izP = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        pS(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void init() {
        super.init();
        this.iAs.setOnTouchListener(null);
        this.iAs.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bh bhVar) {
        super.setData(bhVar);
        this.izO = bhVar;
        if (this.iAu) {
            this.izM = new VideoItemData();
            this.izM.buildWithThreadData(bhVar);
            return;
        }
        this.izN = new VideoSerializeVideoThreadInfo();
        this.izN.copyFromThreadInfo(bhVar);
        this.izN.source = bhVar.mRecomSource;
        this.izN.extra = bhVar.mRecomExtra;
        this.izN.ab_tag = bhVar.mRecomAbTag;
        this.izN.weight = bhVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void ccY() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void ccZ() {
        this.izT = 128;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cdh();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.iAu) {
                baf();
            } else {
                bag();
            }
            if (this.cmo != null) {
                this.cmo.onClick(cbX());
            }
        }
    }

    private void baf() {
        if (this.izM != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.izM);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom)));
        }
    }

    private void bag() {
        if (this.izN != null) {
            if (this.izO != null) {
                this.izN.copyFromThreadInfo(this.izO);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.cmS, n.ait(), "", this.izN)));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected void cda() {
        if (this.izZ == this.izS) {
            cdb();
        }
    }

    public void cdb() {
        xK(this.izT);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
