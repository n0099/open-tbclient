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
    private VideoSerializeVideoThreadInfo gPp;
    private VideoItemData jza;
    private bj jzb;

    public b(Context context, View view) {
        super(context, view);
        this.jzc = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        rX(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jzP.setOnTouchListener(null);
        this.jzP.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.jzb = bjVar;
        if (this.Pj) {
            this.jza = new VideoItemData();
            this.jza.buildWithThreadData(bjVar);
            return;
        }
        this.gPp = new VideoSerializeVideoThreadInfo();
        this.gPp.copyFromThreadInfo(bjVar);
        this.gPp.source = bjVar.mRecomSource;
        this.gPp.extra = bjVar.mRecomExtra;
        this.gPp.ab_tag = bjVar.mRecomAbTag;
        this.gPp.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cun() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cum() {
        this.jzt = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cAb();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.Pj) {
                buV();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom)) {
                if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                    buW();
                } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                    czS();
                } else {
                    buW();
                }
            } else {
                buW();
            }
            if (this.Ni != null) {
                this.Ni.onClick(cyL());
            }
        }
    }

    private void buV() {
        if (this.jza != null) {
            ArrayList arrayList = new ArrayList();
            if (this.jzb != null) {
                this.jza.buildWithThreadData(this.jzb);
            }
            arrayList.add(this.jza);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.jzb != null && this.jzb.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.jzb.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void buW() {
        if (this.gPp != null) {
            if (this.jzb != null) {
                this.gPp.copyFromThreadInfo(this.jzb);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.Pk, com.baidu.tieba.card.l.aCd(), "", this.gPp);
            if (this.jzb != null && this.jzb.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.jzb.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void czS() {
        if (this.Ke != null) {
            this.Ke.onClick(cyL());
        } else if (this.gPp != null) {
            String str = this.gPp.threadId;
            String str2 = this.gPp.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.jzb);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cuk() {
        if (this.jzz == this.jzs) {
            czT();
        }
    }

    public void czT() {
        zG(this.jzt);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
