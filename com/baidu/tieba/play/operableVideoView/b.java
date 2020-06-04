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
    private VideoSerializeVideoThreadInfo hOU;
    private VideoItemData kCj;
    private bk kCk;

    public b(Context context, View view) {
        super(context, view);
        this.kCl = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        tz(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kDa.setOnTouchListener(null);
        this.kDa.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bk bkVar) {
        super.setData(bkVar);
        this.kCk = bkVar;
        if (this.air) {
            this.kCj = new VideoItemData();
            this.kCj.buildWithThreadData(bkVar);
            return;
        }
        this.hOU = new VideoSerializeVideoThreadInfo();
        this.hOU.copyFromThreadInfo(bkVar);
        this.hOU.source = bkVar.mRecomSource;
        this.hOU.extra = bkVar.mRecomExtra;
        this.hOU.ab_tag = bkVar.mRecomAbTag;
        this.hOU.weight = bkVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cMg() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cMf() {
        this.kCD = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cRZ();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.air) {
                bLb();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                    bLc();
                } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                    cRQ();
                } else {
                    bLc();
                }
            } else {
                bLc();
            }
            if (this.ags != null) {
                this.ags.onClick(cQD());
            }
        }
    }

    private void bLb() {
        if (this.kCj != null) {
            ArrayList arrayList = new ArrayList();
            if (this.kCk != null) {
                this.kCj.buildWithThreadData(this.kCk);
            }
            arrayList.add(this.kCj);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.kCk != null && this.kCk.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.kCk.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bLc() {
        if (this.hOU != null) {
            if (this.kCk != null) {
                this.hOU.copyFromThreadInfo(this.kCk);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.ais, m.aQj(), "", this.hOU);
            if (this.kCk != null && this.kCk.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.kCk.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cRQ() {
        if (this.adx != null) {
            this.adx.onClick(cQD());
        } else if (this.hOU != null) {
            String str = this.hOU.threadId;
            String str2 = this.hOU.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.kCk);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cMd() {
        if (this.kCK == this.kCC) {
            cRR();
        }
    }

    public void cRR() {
        AU(this.kCD);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cRP() {
        return false;
    }
}
