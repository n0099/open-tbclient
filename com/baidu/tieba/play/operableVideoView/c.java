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
    private VideoSerializeVideoThreadInfo hOU;
    private VideoItemData kCj;
    private bk kCk;

    public c(Context context, View view) {
        super(context, view);
        tz(false);
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
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.air) {
                if (this.kCj != null) {
                    eY(this.kCj.forum_id, this.kCj.thread_id);
                }
            } else if (this.hOU != null) {
                eY(this.hOU.forumId, this.hOU.threadId);
            }
        }
    }

    private void eY(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.kCk);
        pbActivityConfig.setVideoOriginArea(au.aQ(this.kDa));
        pbActivityConfig.setNeedPreLoad(true);
        i.an(this.kCk);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.ags != null) {
            this.ags.onClick(cQD());
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
