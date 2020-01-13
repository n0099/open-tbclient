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
    private VideoItemData jwr;
    private bj jws;

    public b(Context context, View view) {
        super(context, view);
        this.jwt = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        rO(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jxh.setOnTouchListener(null);
        this.jxh.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.jws = bjVar;
        if (this.OF) {
            this.jwr = new VideoItemData();
            this.jwr.buildWithThreadData(bjVar);
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
    public void csw() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void csv() {
        this.jwK = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cyh();
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
                    cya();
                } else {
                    btk();
                }
            } else {
                btk();
            }
            if (this.MG != null) {
                this.MG.onClick(cwU());
            }
        }
    }

    private void btj() {
        if (this.jwr != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.jwr);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.jws != null && this.jws.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.jws.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void btk() {
        if (this.gLV != null) {
            if (this.jws != null) {
                this.gLV.copyFromThreadInfo(this.jws);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.OG, com.baidu.tieba.card.l.azJ(), "", this.gLV);
            if (this.jws != null && this.jws.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.jws.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cya() {
        if (this.JI != null) {
            this.JI.onClick(cwU());
        } else if (this.gLV != null) {
            String str = this.gLV.threadId;
            String str2 = this.gLV.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.jws);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void csr() {
        if (this.jwQ == this.jwJ) {
            cyb();
        }
    }

    public void cyb() {
        zr(this.jwK);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
