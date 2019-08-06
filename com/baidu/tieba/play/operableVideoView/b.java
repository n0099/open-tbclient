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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends c {
    private VideoItemData iyY;
    private VideoSerializeVideoThreadInfo iyZ;
    private bh iza;

    public b(Context context, View view) {
        super(context, view);
        this.izb = UIMsg.m_AppUI.MSG_APP_GPS;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        qi(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void init() {
        super.init();
        this.izE.setOnTouchListener(null);
        this.izE.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bh bhVar) {
        super.setData(bhVar);
        this.iza = bhVar;
        if (this.izG) {
            this.iyY = new VideoItemData();
            this.iyY.buildWithThreadData(bhVar);
            return;
        }
        this.iyZ = new VideoSerializeVideoThreadInfo();
        this.iyZ.copyFromThreadInfo(bhVar);
        this.iyZ.source = bhVar.mRecomSource;
        this.iyZ.extra = bhVar.mRecomExtra;
        this.iyZ.ab_tag = bhVar.mRecomAbTag;
        this.iyZ.weight = bhVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void cfk() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    public void cfl() {
        this.izf = 128;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cft();
                return;
            }
            if (!j.kc()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.izG) {
                aZy();
            } else {
                aZz();
            }
            if (this.bWq != null) {
                this.bWq.onClick(ceg());
            }
        }
    }

    private void aZy() {
        if (this.iyY != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.iyY);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom)));
        }
    }

    private void aZz() {
        if (this.iyZ != null) {
            if (this.iza != null) {
                this.iyZ.copyFromThreadInfo(this.iza);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.bWU, n.ael(), "", this.iyZ)));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected void cfm() {
        if (this.izl == this.ize) {
            cfn();
        }
    }

    public void cfn() {
        zc(this.izf);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
