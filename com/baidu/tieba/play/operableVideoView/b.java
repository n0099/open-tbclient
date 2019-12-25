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
    private VideoSerializeVideoThreadInfo gII;
    private VideoItemData jsP;
    private bj jsQ;

    public b(Context context, View view) {
        super(context, view);
        this.jsR = 5000;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        rB(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.jtF.setOnTouchListener(null);
        this.jtF.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        super.setData(bjVar);
        this.jsQ = bjVar;
        if (this.OB) {
            this.jsP = new VideoItemData();
            this.jsP.buildWithThreadData(bjVar);
            return;
        }
        this.gII = new VideoSerializeVideoThreadInfo();
        this.gII.copyFromThreadInfo(bjVar);
        this.gII.source = bjVar.mRecomSource;
        this.gII.extra = bjVar.mRecomExtra;
        this.gII.ab_tag = bjVar.mRecomAbTag;
        this.gII.weight = bjVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void crp() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cro() {
        this.jti = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cxa();
                return;
            }
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.OB) {
                bsh();
            } else if ("index".equals(this.mFrom) || "frs".equals(this.mFrom) || "concern_tab".equals(this.mFrom) || "video_tab".equals(this.mFrom)) {
                if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                    bsi();
                } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_PB) {
                    cwT();
                } else {
                    bsi();
                }
            } else {
                bsi();
            }
            if (this.Mz != null) {
                this.Mz.onClick(cvN());
            }
        }
    }

    private void bsh() {
        if (this.jsP != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.jsP);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mContext, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", this.mFrom, this.mFrom);
            if (this.jsQ != null && this.jsQ.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.jsQ.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bsi() {
        if (this.gII != null) {
            if (this.jsQ != null) {
                this.gII.copyFromThreadInfo(this.jsQ);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.mContext, this.mFrom, this.OC, com.baidu.tieba.card.l.azq(), "", this.gII);
            if (this.jsQ != null && this.jsQ.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.jsQ.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cwT() {
        if (this.JC != null) {
            this.JC.onClick(cvN());
        } else if (this.gII != null) {
            String str = this.gII.threadId;
            String str2 = this.gII.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.jsQ);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void crk() {
        if (this.jto == this.jth) {
            cwU();
        }
    }

    public void cwU() {
        zm(this.jti);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        return false;
    }
}
