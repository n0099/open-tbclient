package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends c {
    private VideoItemData irA;
    private VideoSerializeVideoThreadInfo irB;
    private bg irC;

    public b(Context context, View view) {
        super(context, view);
        this.irD = UIMsg.m_AppUI.MSG_APP_GPS;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        pS(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void init() {
        super.init();
        this.isf.setOnTouchListener(null);
        this.isf.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        super.setData(bgVar);
        this.irC = bgVar;
        if (this.ish) {
            this.irA = new VideoItemData();
            this.irA.buildWithThreadData(bgVar);
            return;
        }
        this.irB = new VideoSerializeVideoThreadInfo();
        this.irB.copyFromThreadInfo(bgVar);
        this.irB.source = bgVar.mRecomSource;
        this.irB.extra = bgVar.mRecomExtra;
        this.irB.ab_tag = bgVar.mRecomAbTag;
        this.irB.weight = bgVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void cbY() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void cbZ() {
        this.irH = 128;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cch();
                return;
            }
            if (!j.jS()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.ish) {
                aXw();
            } else {
                aXx();
            }
            if (this.bVi != null) {
                this.bVi.onClick(caV());
            }
        }
    }

    private void aXw() {
        if (this.irA != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.irA);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom)));
        }
    }

    private void aXx() {
        if (this.irB != null) {
            if (this.irC != null) {
                this.irB.copyFromThreadInfo(this.irC);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.bVL, n.adi(), "", this.irB)));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected void cca() {
        if (this.irN == this.irG) {
            ccb();
        }
    }

    public void ccb() {
        yv(this.irH);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
