package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes.dex */
public class c extends d {
    private VideoSerializeVideoThreadInfo hOh;
    private VideoItemData kBb;
    private bk kBc;

    public c(Context context, View view) {
        super(context, view);
        tz(false);
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
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.air) {
                if (this.kBb != null) {
                    eY(this.kBb.forum_id, this.kBb.thread_id);
                }
            } else if (this.hOh != null) {
                eY(this.hOh.forumId, this.hOh.threadId);
            }
        }
    }

    private void eY(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.kBc);
        pbActivityConfig.setVideoOriginArea(au.aQ(this.kBS));
        pbActivityConfig.setNeedPreLoad(true);
        i.an(this.kBc);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.ags != null) {
            this.ags.onClick(cQn());
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
