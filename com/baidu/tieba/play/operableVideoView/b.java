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
    private VideoSerializeVideoThreadInfo gNW;
    private VideoItemData jxp;
    private bj jxq;

    public b(Context context, View view) {
        super(context, view);
        this.jxr = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        rR(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jye.setOnTouchListener(null);
        this.jye.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.jxq = bjVar;
        if (this.Pi) {
            this.jxp = new VideoItemData();
            this.jxp.buildWithThreadData(bjVar);
            return;
        }
        this.gNW = new VideoSerializeVideoThreadInfo();
        this.gNW.copyFromThreadInfo(bjVar);
        this.gNW.source = bjVar.mRecomSource;
        this.gNW.extra = bjVar.mRecomExtra;
        this.gNW.ab_tag = bjVar.mRecomAbTag;
        this.gNW.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctT() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctS() {
        this.jxI = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                czG();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.Pi) {
                buP();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom)) {
                if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                    buQ();
                } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                    czy();
                } else {
                    buQ();
                }
            } else {
                buQ();
            }
            if (this.Nh != null) {
                this.Nh.onClick(cyr());
            }
        }
    }

    private void buP() {
        if (this.jxp != null) {
            ArrayList arrayList = new ArrayList();
            if (this.jxq != null) {
                this.jxp.buildWithThreadData(this.jxq);
            }
            arrayList.add(this.jxp);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.jxq != null && this.jxq.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.jxq.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void buQ() {
        if (this.gNW != null) {
            if (this.jxq != null) {
                this.gNW.copyFromThreadInfo(this.jxq);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.Pj, com.baidu.tieba.card.l.aCa(), "", this.gNW);
            if (this.jxq != null && this.jxq.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.jxq.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void czy() {
        if (this.Ke != null) {
            this.Ke.onClick(cyr());
        } else if (this.gNW != null) {
            String str = this.gNW.threadId;
            String str2 = this.gNW.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.jxq);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctO() {
        if (this.jxO == this.jxH) {
            czz();
        }
    }

    public void czz() {
        zy(this.jxI);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
