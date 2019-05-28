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
    private VideoItemData irD;
    private VideoSerializeVideoThreadInfo irE;
    private bg irF;

    public b(Context context, View view) {
        super(context, view);
        this.irG = UIMsg.m_AppUI.MSG_APP_GPS;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        pS(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void init() {
        super.init();
        this.isi.setOnTouchListener(null);
        this.isi.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        super.setData(bgVar);
        this.irF = bgVar;
        if (this.isk) {
            this.irD = new VideoItemData();
            this.irD.buildWithThreadData(bgVar);
            return;
        }
        this.irE = new VideoSerializeVideoThreadInfo();
        this.irE.copyFromThreadInfo(bgVar);
        this.irE.source = bgVar.mRecomSource;
        this.irE.extra = bgVar.mRecomExtra;
        this.irE.ab_tag = bgVar.mRecomAbTag;
        this.irE.weight = bgVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void ccb() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void ccc() {
        this.irK = 128;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cck();
                return;
            }
            if (!j.jS()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.isk) {
                aXz();
            } else {
                aXA();
            }
            if (this.bVi != null) {
                this.bVi.onClick(caY());
            }
        }
    }

    private void aXz() {
        if (this.irD != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.irD);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom)));
        }
    }

    private void aXA() {
        if (this.irE != null) {
            if (this.irF != null) {
                this.irE.copyFromThreadInfo(this.irF);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.bVL, n.adi(), "", this.irE)));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected void ccd() {
        if (this.irQ == this.irJ) {
            cce();
        }
    }

    public void cce() {
        yv(this.irK);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
