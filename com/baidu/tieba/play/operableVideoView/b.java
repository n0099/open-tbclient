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
    private VideoSerializeVideoThreadInfo gOi;
    private VideoItemData jxB;
    private bj jxC;

    public b(Context context, View view) {
        super(context, view);
        this.jxD = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        rR(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jyq.setOnTouchListener(null);
        this.jyq.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.jxC = bjVar;
        if (this.Pi) {
            this.jxB = new VideoItemData();
            this.jxB.buildWithThreadData(bjVar);
            return;
        }
        this.gOi = new VideoSerializeVideoThreadInfo();
        this.gOi.copyFromThreadInfo(bjVar);
        this.gOi.source = bjVar.mRecomSource;
        this.gOi.extra = bjVar.mRecomExtra;
        this.gOi.ab_tag = bjVar.mRecomAbTag;
        this.gOi.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctU() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctT() {
        this.jxU = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                czH();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.Pi) {
                buQ();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom)) {
                if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                    buR();
                } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                    czz();
                } else {
                    buR();
                }
            } else {
                buR();
            }
            if (this.Nh != null) {
                this.Nh.onClick(cys());
            }
        }
    }

    private void buQ() {
        if (this.jxB != null) {
            ArrayList arrayList = new ArrayList();
            if (this.jxC != null) {
                this.jxB.buildWithThreadData(this.jxC);
            }
            arrayList.add(this.jxB);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.jxC != null && this.jxC.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.jxC.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void buR() {
        if (this.gOi != null) {
            if (this.jxC != null) {
                this.gOi.copyFromThreadInfo(this.jxC);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.Pj, com.baidu.tieba.card.l.aCa(), "", this.gOi);
            if (this.jxC != null && this.jxC.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.jxC.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void czz() {
        if (this.Ke != null) {
            this.Ke.onClick(cys());
        } else if (this.gOi != null) {
            String str = this.gOi.threadId;
            String str2 = this.gOi.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.jxC);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctP() {
        if (this.jya == this.jxT) {
            czA();
        }
    }

    public void czA() {
        zy(this.jxU);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
