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
    private VideoItemData ixV;
    private VideoSerializeVideoThreadInfo ixW;
    private bg ixX;

    public b(Context context, View view) {
        super(context, view);
        this.ixY = UIMsg.m_AppUI.MSG_APP_GPS;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        qh(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void init() {
        super.init();
        this.iyA.setOnTouchListener(null);
        this.iyA.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        super.setData(bgVar);
        this.ixX = bgVar;
        if (this.iyC) {
            this.ixV = new VideoItemData();
            this.ixV.buildWithThreadData(bgVar);
            return;
        }
        this.ixW = new VideoSerializeVideoThreadInfo();
        this.ixW.copyFromThreadInfo(bgVar);
        this.ixW.source = bgVar.mRecomSource;
        this.ixW.extra = bgVar.mRecomExtra;
        this.ixW.ab_tag = bgVar.mRecomAbTag;
        this.ixW.weight = bgVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void ceS() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void ceT() {
        this.iyc = 128;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cfb();
                return;
            }
            if (!j.kc()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.iyC) {
                aZw();
            } else {
                aZx();
            }
            if (this.bWk != null) {
                this.bWk.onClick(cdO());
            }
        }
    }

    private void aZw() {
        if (this.ixV != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.ixV);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom)));
        }
    }

    private void aZx() {
        if (this.ixW != null) {
            if (this.ixX != null) {
                this.ixW.copyFromThreadInfo(this.ixX);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.bWO, n.aek(), "", this.ixW)));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected void ceU() {
        if (this.iyi == this.iyb) {
            ceV();
        }
    }

    public void ceV() {
        za(this.iyc);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
