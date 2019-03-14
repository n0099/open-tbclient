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
    private VideoItemData hZh;
    private VideoSerializeVideoThreadInfo hZi;
    private bg hZj;

    public b(Context context, View view) {
        super(context, view);
        this.hZk = UIMsg.m_AppUI.MSG_APP_GPS;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        pe(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void init() {
        super.init();
        this.hZM.setOnTouchListener(null);
        this.hZM.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        super.setData(bgVar);
        this.hZj = bgVar;
        if (this.hZO) {
            this.hZh = new VideoItemData();
            this.hZh.buildWithThreadData(bgVar);
            return;
        }
        this.hZi = new VideoSerializeVideoThreadInfo();
        this.hZi.copyFromThreadInfo(bgVar);
        this.hZi.source = bgVar.mRecomSource;
        this.hZi.extra = bgVar.mRecomExtra;
        this.hZi.ab_tag = bgVar.mRecomAbTag;
        this.hZi.weight = bgVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void bUb() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void bUc() {
        this.hZo = 128;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.video_mute) {
                bUk();
                return;
            }
            if (!j.kY()) {
                l.showToast(this.mContext, d.j.no_network_guide);
            } else if (this.hZO) {
                aQp();
            } else {
                aQq();
            }
            if (this.bNu != null) {
                this.bNu.onClick(bSZ());
            }
        }
    }

    private void aQp() {
        if (this.hZh != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.hZh);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", "index", this.mFrom)));
        }
    }

    private void aQq() {
        if (this.hZi != null) {
            if (this.hZj != null) {
                this.hZi.copyFromThreadInfo(this.hZj);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.ctu, n.YE(), "", this.hZi)));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected void bUd() {
        if (this.hZu == this.hZn) {
            bUe();
        }
    }

    public void bUe() {
        xs(this.hZo);
        bUf();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void bTZ() {
        if (this.gIj.getVisibility() == 8 && this.hZu != this.hZo) {
            bUe();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void bUa() {
        super.bUa();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
