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
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends c {
    private VideoItemData hYT;
    private VideoSerializeVideoThreadInfo hYU;
    private bg hYV;

    public b(Context context, View view) {
        super(context, view);
        this.hYW = UIMsg.m_AppUI.MSG_APP_GPS;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        pe(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void init() {
        super.init();
        this.hZy.setOnTouchListener(null);
        this.hZy.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        super.setData(bgVar);
        this.hYV = bgVar;
        if (this.hZA) {
            this.hYT = new VideoItemData();
            this.hYT.buildWithThreadData(bgVar);
            return;
        }
        this.hYU = new VideoSerializeVideoThreadInfo();
        this.hYU.copyFromThreadInfo(bgVar);
        this.hYU.source = bgVar.mRecomSource;
        this.hYU.extra = bgVar.mRecomExtra;
        this.hYU.ab_tag = bgVar.mRecomAbTag;
        this.hYU.weight = bgVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void bTX() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void bTY() {
        this.hZa = 128;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.video_mute) {
                bUg();
                return;
            }
            if (!j.kY()) {
                l.showToast(this.mContext, d.j.no_network_guide);
            } else if (this.hZA) {
                aQn();
            } else {
                aQo();
            }
            if (this.bNw != null) {
                this.bNw.onClick(bSV());
            }
        }
    }

    private void aQn() {
        if (this.hYT != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.hYT);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", "index", this.mFrom)));
        }
    }

    private void aQo() {
        if (this.hYU != null) {
            if (this.hYV != null) {
                this.hYU.copyFromThreadInfo(this.hYV);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.ctw, n.YB(), "", this.hYU)));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected void bTZ() {
        if (this.hZg == this.hYZ) {
            bUa();
        }
    }

    public void bUa() {
        xo(this.hZa);
        bUb();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void bTV() {
        if (this.gHW.getVisibility() == 8 && this.hZg != this.hZa) {
            bUa();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void bTW() {
        super.bTW();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
