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
    private VideoSerializeVideoThreadInfo hzu;
    private VideoItemData kjg;
    private bj kjh;

    public b(Context context, View view) {
        super(context, view);
        this.kji = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        tb(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kjX.setOnTouchListener(null);
        this.kjX.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.kjh = bjVar;
        if (this.ahN) {
            this.kjg = new VideoItemData();
            this.kjg.buildWithThreadData(bjVar);
            return;
        }
        this.hzu = new VideoSerializeVideoThreadInfo();
        this.hzu.copyFromThreadInfo(bjVar);
        this.hzu.source = bjVar.mRecomSource;
        this.hzu.extra = bjVar.mRecomExtra;
        this.hzu.ab_tag = bjVar.mRecomAbTag;
        this.hzu.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cER() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cEQ() {
        this.kjA = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cKJ();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.ahN) {
                bEG();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom) || "14".equals(this.mFrom)) {
                if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                    bEH();
                } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                    cKA();
                } else {
                    bEH();
                }
            } else {
                bEH();
            }
            if (this.afV != null) {
                this.afV.onClick(cJo());
            }
        }
    }

    private void bEG() {
        if (this.kjg != null) {
            ArrayList arrayList = new ArrayList();
            if (this.kjh != null) {
                this.kjg.buildWithThreadData(this.kjh);
            }
            arrayList.add(this.kjg);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.kjh != null && this.kjh.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.kjh.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bEH() {
        if (this.hzu != null) {
            if (this.kjh != null) {
                this.hzu.copyFromThreadInfo(this.kjh);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.ahO, com.baidu.tieba.card.l.aKo(), "", this.hzu);
            if (this.kjh != null && this.kjh.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.kjh.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cKA() {
        if (this.adf != null) {
            this.adf.onClick(cJo());
        } else if (this.hzu != null) {
            String str = this.hzu.threadId;
            String str2 = this.hzu.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.kjh);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cEO() {
        if (this.kjH == this.kjz) {
            cKB();
        }
    }

    public void cKB() {
        Ah(this.kjA);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
