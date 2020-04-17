package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends d {
    private VideoSerializeVideoThreadInfo hzo;
    private VideoItemData kjc;
    private bj kjd;

    public b(Context context, View view) {
        super(context, view);
        this.kje = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        tb(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kjT.setOnTouchListener(null);
        this.kjT.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.kjd = bjVar;
        if (this.ahK) {
            this.kjc = new VideoItemData();
            this.kjc.buildWithThreadData(bjVar);
            return;
        }
        this.hzo = new VideoSerializeVideoThreadInfo();
        this.hzo.copyFromThreadInfo(bjVar);
        this.hzo.source = bjVar.mRecomSource;
        this.hzo.extra = bjVar.mRecomExtra;
        this.hzo.ab_tag = bjVar.mRecomAbTag;
        this.hzo.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cET() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cES() {
        this.kjw = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cKL();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.ahK) {
                bEH();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                    bEI();
                } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                    cKC();
                } else {
                    bEI();
                }
            } else {
                bEI();
            }
            if (this.afS != null) {
                this.afS.onClick(cJq());
            }
        }
    }

    private void bEH() {
        if (this.kjc != null) {
            ArrayList arrayList = new ArrayList();
            if (this.kjd != null) {
                this.kjc.buildWithThreadData(this.kjd);
            }
            arrayList.add(this.kjc);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.kjd != null && this.kjd.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.kjd.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bEI() {
        if (this.hzo != null) {
            if (this.kjd != null) {
                this.hzo.copyFromThreadInfo(this.kjd);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.ahL, com.baidu.tieba.card.l.aKq(), "", this.hzo);
            if (this.kjd != null && this.kjd.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.kjd.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cKC() {
        if (this.adb != null) {
            this.adb.onClick(cJq());
        } else if (this.hzo != null) {
            String str = this.hzo.threadId;
            String str2 = this.hzo.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.kjd);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cEQ() {
        if (this.kjD == this.kjv) {
            cKD();
        }
    }

    public void cKD() {
        Ah(this.kjw);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
