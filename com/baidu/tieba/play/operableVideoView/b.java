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
    private VideoItemData irE;
    private VideoSerializeVideoThreadInfo irF;
    private bg irG;

    public b(Context context, View view) {
        super(context, view);
        this.irH = UIMsg.m_AppUI.MSG_APP_GPS;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        pT(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void init() {
        super.init();
        this.isj.setOnTouchListener(null);
        this.isj.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        super.setData(bgVar);
        this.irG = bgVar;
        if (this.isl) {
            this.irE = new VideoItemData();
            this.irE.buildWithThreadData(bgVar);
            return;
        }
        this.irF = new VideoSerializeVideoThreadInfo();
        this.irF.copyFromThreadInfo(bgVar);
        this.irF.source = bgVar.mRecomSource;
        this.irF.extra = bgVar.mRecomExtra;
        this.irF.ab_tag = bgVar.mRecomAbTag;
        this.irF.weight = bgVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void ccc() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void ccd() {
        this.irL = 128;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                ccl();
                return;
            }
            if (!j.jS()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.isl) {
                aXz();
            } else {
                aXA();
            }
            if (this.bVj != null) {
                this.bVj.onClick(caZ());
            }
        }
    }

    private void aXz() {
        if (this.irE != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.irE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom)));
        }
    }

    private void aXA() {
        if (this.irF != null) {
            if (this.irG != null) {
                this.irF.copyFromThreadInfo(this.irG);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.bVM, n.adi(), "", this.irF)));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected void cce() {
        if (this.irR == this.irK) {
            ccf();
        }
    }

    public void ccf() {
        yv(this.irL);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
