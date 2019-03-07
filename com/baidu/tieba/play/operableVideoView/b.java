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
    private VideoItemData hZm;
    private VideoSerializeVideoThreadInfo hZn;
    private bg hZo;

    public b(Context context, View view) {
        super(context, view);
        this.hZp = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        pe(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void init() {
        super.init();
        this.hZR.setOnTouchListener(null);
        this.hZR.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        super.setData(bgVar);
        this.hZo = bgVar;
        if (this.hZT) {
            this.hZm = new VideoItemData();
            this.hZm.buildWithThreadData(bgVar);
            return;
        }
        this.hZn = new VideoSerializeVideoThreadInfo();
        this.hZn.copyFromThreadInfo(bgVar);
        this.hZn.source = bgVar.mRecomSource;
        this.hZn.extra = bgVar.mRecomExtra;
        this.hZn.ab_tag = bgVar.mRecomAbTag;
        this.hZn.weight = bgVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void bTY() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void bTZ() {
        this.hZt = 128;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == d.g.video_mute) {
                bUh();
                return;
            }
            if (!j.kY()) {
                l.showToast(this.mContext, d.j.no_network_guide);
            } else if (this.hZT) {
                aQp();
            } else {
                aQq();
            }
            if (this.bNt != null) {
                this.bNt.onClick(bSW());
            }
        }
    }

    private void aQp() {
        if (com.baidu.tbadk.plugins.c.py("com.baidu.tieba.pluginResource")) {
            if (this.hZm != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hZm);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", "index", this.mFrom)));
            }
        } else if (this.hZm != null) {
            dG(this.hZm.forum_id, this.hZm.thread_id);
        }
    }

    private void aQq() {
        if (com.baidu.tbadk.plugins.c.py("com.baidu.tieba.pluginResource")) {
            if (this.hZn != null) {
                if (this.hZo != null) {
                    this.hZn.copyFromThreadInfo(this.hZo);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.ctx, n.YE(), "", this.hZn)));
            }
        } else if (this.hZn != null) {
            dG(this.hZn.forumId, this.hZn.threadId);
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
    protected void bUa() {
        if (this.hZz == this.hZs) {
            bUb();
        }
    }

    public void bUb() {
        xs(this.hZt);
        bUc();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void bTW() {
        if (this.gIj.getVisibility() == 8 && this.hZz != this.hZt) {
            bUb();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void bTX() {
        super.bTX();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
