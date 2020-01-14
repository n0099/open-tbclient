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
    private VideoSerializeVideoThreadInfo gLV;
    private VideoItemData jww;
    private bj jwx;

    public b(Context context, View view) {
        super(context, view);
        this.jwy = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        rO(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jxm.setOnTouchListener(null);
        this.jxm.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.jwx = bjVar;
        if (this.OF) {
            this.jww = new VideoItemData();
            this.jww.buildWithThreadData(bjVar);
            return;
        }
        this.gLV = new VideoSerializeVideoThreadInfo();
        this.gLV.copyFromThreadInfo(bjVar);
        this.gLV.source = bjVar.mRecomSource;
        this.gLV.extra = bjVar.mRecomExtra;
        this.gLV.ab_tag = bjVar.mRecomAbTag;
        this.gLV.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void csy() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void csx() {
        this.jwP = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cyj();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.OF) {
                btj();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom)) {
                if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                    btk();
                } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                    cyc();
                } else {
                    btk();
                }
            } else {
                btk();
            }
            if (this.MG != null) {
                this.MG.onClick(cwW());
            }
        }
    }

    private void btj() {
        if (this.jww != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.jww);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.jwx != null && this.jwx.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.jwx.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void btk() {
        if (this.gLV != null) {
            if (this.jwx != null) {
                this.gLV.copyFromThreadInfo(this.jwx);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.OG, com.baidu.tieba.card.l.azJ(), "", this.gLV);
            if (this.jwx != null && this.jwx.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.jwx.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cyc() {
        if (this.JI != null) {
            this.JI.onClick(cwW());
        } else if (this.gLV != null) {
            String str = this.gLV.threadId;
            String str2 = this.gLV.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.jwx);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cst() {
        if (this.jwV == this.jwO) {
            cyd();
        }
    }

    public void cyd() {
        zr(this.jwP);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
