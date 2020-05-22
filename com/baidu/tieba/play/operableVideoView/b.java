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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends d {
    private VideoSerializeVideoThreadInfo hOh;
    private VideoItemData kBb;
    private bk kBc;

    public b(Context context, View view) {
        super(context, view);
        this.kBd = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        tz(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kBS.setOnTouchListener(null);
        this.kBS.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bk bkVar) {
        super.setData(bkVar);
        this.kBc = bkVar;
        if (this.air) {
            this.kBb = new VideoItemData();
            this.kBb.buildWithThreadData(bkVar);
            return;
        }
        this.hOh = new VideoSerializeVideoThreadInfo();
        this.hOh.copyFromThreadInfo(bkVar);
        this.hOh.source = bkVar.mRecomSource;
        this.hOh.extra = bkVar.mRecomExtra;
        this.hOh.ab_tag = bkVar.mRecomAbTag;
        this.hOh.weight = bkVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cLQ() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cLP() {
        this.kBv = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cRJ();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.air) {
                bKZ();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                    bLa();
                } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                    cRA();
                } else {
                    bLa();
                }
            } else {
                bLa();
            }
            if (this.ags != null) {
                this.ags.onClick(cQn());
            }
        }
    }

    private void bKZ() {
        if (this.kBb != null) {
            ArrayList arrayList = new ArrayList();
            if (this.kBc != null) {
                this.kBb.buildWithThreadData(this.kBc);
            }
            arrayList.add(this.kBb);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.kBc != null && this.kBc.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.kBc.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bLa() {
        if (this.hOh != null) {
            if (this.kBc != null) {
                this.hOh.copyFromThreadInfo(this.kBc);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.ais, m.aQj(), "", this.hOh);
            if (this.kBc != null && this.kBc.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.kBc.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cRA() {
        if (this.adx != null) {
            this.adx.onClick(cQn());
        } else if (this.hOh != null) {
            String str = this.hOh.threadId;
            String str2 = this.hOh.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.kBc);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cLN() {
        if (this.kBC == this.kBu) {
            cRB();
        }
    }

    public void cRB() {
        AS(this.kBv);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cRz() {
        return false;
    }
}
