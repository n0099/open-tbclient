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
    private VideoSerializeVideoThreadInfo gNU;
    private VideoItemData jxn;
    private bj jxo;

    public b(Context context, View view) {
        super(context, view);
        this.jxp = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        rR(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jyc.setOnTouchListener(null);
        this.jyc.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.jxo = bjVar;
        if (this.Pi) {
            this.jxn = new VideoItemData();
            this.jxn.buildWithThreadData(bjVar);
            return;
        }
        this.gNU = new VideoSerializeVideoThreadInfo();
        this.gNU.copyFromThreadInfo(bjVar);
        this.gNU.source = bjVar.mRecomSource;
        this.gNU.extra = bjVar.mRecomExtra;
        this.gNU.ab_tag = bjVar.mRecomAbTag;
        this.gNU.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctR() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctQ() {
        this.jxG = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                czE();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.Pi) {
                buN();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom)) {
                if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                    buO();
                } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                    czw();
                } else {
                    buO();
                }
            } else {
                buO();
            }
            if (this.Nh != null) {
                this.Nh.onClick(cyp());
            }
        }
    }

    private void buN() {
        if (this.jxn != null) {
            ArrayList arrayList = new ArrayList();
            if (this.jxo != null) {
                this.jxn.buildWithThreadData(this.jxo);
            }
            arrayList.add(this.jxn);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.jxo != null && this.jxo.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.jxo.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void buO() {
        if (this.gNU != null) {
            if (this.jxo != null) {
                this.gNU.copyFromThreadInfo(this.jxo);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.Pj, com.baidu.tieba.card.l.aBY(), "", this.gNU);
            if (this.jxo != null && this.jxo.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.jxo.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void czw() {
        if (this.Ke != null) {
            this.Ke.onClick(cyp());
        } else if (this.gNU != null) {
            String str = this.gNU.threadId;
            String str2 = this.gNU.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.jxo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ctM() {
        if (this.jxM == this.jxF) {
            czx();
        }
    }

    public void czx() {
        zy(this.jxG);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
