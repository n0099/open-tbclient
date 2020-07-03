package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends d {
    private VideoSerializeVideoThreadInfo icg;
    private VideoItemData kWf;
    private bu kWg;

    public b(Context context, View view) {
        super(context, view);
        this.kWh = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        tO(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kWW.setOnTouchListener(null);
        this.kWW.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bu buVar) {
        super.setData(buVar);
        this.kWg = buVar;
        if (this.ajN) {
            this.kWf = new VideoItemData();
            this.kWf.buildWithThreadData(buVar);
            return;
        }
        this.icg = new VideoSerializeVideoThreadInfo();
        this.icg.copyFromThreadInfo(buVar);
        this.icg.source = buVar.mRecomSource;
        this.icg.extra = buVar.mRecomExtra;
        this.icg.ab_tag = buVar.mRecomAbTag;
        this.icg.weight = buVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cQx() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cQw() {
        this.kWz = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cWp();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.ajN) {
                bOj();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                bOk();
            } else {
                bOk();
            }
            if (this.ahw != null) {
                this.ahw.onClick(cUU());
            }
        }
    }

    private void bOj() {
        if (this.kWf != null) {
            ArrayList arrayList = new ArrayList();
            if (this.kWg != null) {
                this.kWf.buildWithThreadData(this.kWg);
            }
            arrayList.add(this.kWf);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.kWg != null && this.kWg.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.kWg.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bOk() {
        if (this.icg != null) {
            if (this.kWg != null) {
                this.icg.copyFromThreadInfo(this.kWg);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.ajO, m.aSb(), "", this.icg);
            if (this.kWg != null && this.kWg.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.kWg.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cQu() {
        if (this.kWG == this.kWy) {
            cWh();
        }
    }

    public void cWh() {
        BW(this.kWz);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cWg() {
        return false;
    }
}
