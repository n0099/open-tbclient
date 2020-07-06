package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes.dex */
public class c extends d {
    private VideoSerializeVideoThreadInfo icg;
    private VideoItemData kWf;
    private bu kWg;

    public c(Context context, View view) {
        super(context, view);
        tO(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.kWW.setOnTouchListener(null);
        this.kWW.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bu buVar) {
        super.setData(buVar);
        this.kWg = buVar;
        if (this.ajN) {
            this.kWf = new VideoItemData();
            this.kWf.buildWithThreadData(buVar);
            return;
        }
        this.icg = new VideoSerializeVideoThreadInfo();
        this.icg.copyFromThreadInfo(buVar);
        this.icg.source = buVar.mRecomSource;
        this.icg.extra = buVar.mRecomExtra;
        this.icg.ab_tag = buVar.mRecomAbTag;
        this.icg.weight = buVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cQy() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cQx() {
        this.kWz = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                cWq();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, (int) R.string.no_network_guide);
            } else if (this.ajN) {
                if (this.kWf != null) {
                    ff(this.kWf.forum_id, this.kWf.thread_id);
                }
            } else if (this.icg != null) {
                ff(this.icg.forumId, this.icg.threadId);
            }
        }
    }

    private void ff(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.kWg);
        pbActivityConfig.setVideoOriginArea(aw.aQ(this.kWW));
        pbActivityConfig.setNeedPreLoad(true);
        k.an(this.kWg);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.ahw != null) {
            this.ahw.onClick(cUV());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void cQv() {
        if (this.kWG == this.kWy) {
            cWi();
        }
    }

    public void cWi() {
        BW(this.kWz);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean cWh() {
        return false;
    }
}
