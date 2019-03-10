package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
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
    private VideoItemData hZn;
    private VideoSerializeVideoThreadInfo hZo;
    private bg hZp;

    public b(Context context, View view) {
        super(context, view);
        this.hZq = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        pe(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void init() {
        super.init();
        this.hZS.setOnTouchListener(null);
        this.hZS.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        super.setData(bgVar);
        this.hZp = bgVar;
        if (this.hZU) {
            this.hZn = new VideoItemData();
            this.hZn.buildWithThreadData(bgVar);
            return;
        }
        this.hZo = new VideoSerializeVideoThreadInfo();
        this.hZo.copyFromThreadInfo(bgVar);
        this.hZo.source = bgVar.mRecomSource;
        this.hZo.extra = bgVar.mRecomExtra;
        this.hZo.ab_tag = bgVar.mRecomAbTag;
        this.hZo.weight = bgVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void bTZ() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void bUa() {
        this.hZu = 128;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.video_mute) {
                bUi();
                return;
            }
            if (!j.kY()) {
                l.showToast(this.mContext, d.j.no_network_guide);
            } else if (this.hZU) {
                aQq();
            } else {
                aQr();
            }
            if (this.bNt != null) {
                this.bNt.onClick(bSX());
            }
        }
    }

    private void aQq() {
        if (com.baidu.tbadk.plugins.c.py("com.baidu.tieba.pluginResource")) {
            if (this.hZn != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hZn);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", "index", this.mFrom)));
            }
        } else if (this.hZn != null) {
            dG(this.hZn.forum_id, this.hZn.thread_id);
        }
    }

    private void aQr() {
        if (com.baidu.tbadk.plugins.c.py("com.baidu.tieba.pluginResource")) {
            if (this.hZo != null) {
                if (this.hZp != null) {
                    this.hZo.copyFromThreadInfo(this.hZp);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.ctx, n.YE(), "", this.hZo)));
            }
        } else if (this.hZo != null) {
            dG(this.hZo.forumId, this.hZo.threadId);
        }
    }

    private void dG(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected void bUb() {
        if (this.hZA == this.hZt) {
            bUc();
        }
    }

    public void bUc() {
        xs(this.hZu);
        bUd();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void bTX() {
        if (this.gIk.getVisibility() == 8 && this.hZA != this.hZu) {
            bUc();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void bTY() {
        super.bTY();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
