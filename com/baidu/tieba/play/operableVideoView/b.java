package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
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
    private VideoItemData iBq;
    private VideoSerializeVideoThreadInfo iBr;
    private bh iBs;

    public b(Context context, View view) {
        super(context, view);
        this.iBt = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        ql(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void init() {
        super.init();
        this.iBW.setOnTouchListener(null);
        this.iBW.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bh bhVar) {
        super.setData(bhVar);
        this.iBs = bhVar;
        if (this.iBY) {
            this.iBq = new VideoItemData();
            this.iBq.buildWithThreadData(bhVar);
            return;
        }
        this.iBr = new VideoSerializeVideoThreadInfo();
        this.iBr.copyFromThreadInfo(bhVar);
        this.iBr.source = bhVar.mRecomSource;
        this.iBr.extra = bhVar.mRecomExtra;
        this.iBr.ab_tag = bhVar.mRecomAbTag;
        this.iBr.weight = bhVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void cfY() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void cfZ() {
        this.iBx = 128;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cgh();
                return;
            }
            if (!j.kc()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.iBY) {
                bac();
            } else {
                bad();
            }
            if (this.bXj != null) {
                this.bXj.onClick(ceV());
            }
        }
    }

    private void bac() {
        if (this.iBq != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.iBq);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom)));
        }
    }

    private void bad() {
        if (this.iBr != null) {
            if (this.iBs != null) {
                this.iBr.copyFromThreadInfo(this.iBs);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.bXN, n.aep(), "", this.iBr)));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected void cga() {
        if (this.iBD == this.iBw) {
            cgb();
        }
    }

    public void cgb() {
        zf(this.iBx);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
