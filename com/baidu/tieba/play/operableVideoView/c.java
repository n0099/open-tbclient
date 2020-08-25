package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes2.dex */
public class c extends d {
    private VideoSerializeVideoThreadInfo iwp;
    private VideoItemData ltZ;
    private bw lua;

    public c(Context context, View view) {
        super(context, view);
        ve(false);
        setStageType(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void init() {
        super.init();
        this.luQ.setOnTouchListener(null);
        this.luQ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        super.setData(bwVar);
        this.lua = bwVar;
        if (this.akX) {
            this.ltZ = new VideoItemData();
            this.ltZ.buildWithThreadData(bwVar);
            return;
        }
        this.iwp = new VideoSerializeVideoThreadInfo();
        this.iwp.copyFromThreadInfo(bwVar);
        this.iwp.source = bwVar.mRecomSource;
        this.iwp.extra = bwVar.mRecomExtra;
        this.iwp.ab_tag = bwVar.mRecomAbTag;
        this.iwp.weight = bwVar.mRecomWeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfl() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfk() {
        this.lut = 32;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.video_mute) {
                dkG();
            } else if (!j.isNetWorkAvailable()) {
                l.showToast(this.mContext, R.string.no_network_guide);
            } else if (this.akX) {
                if (this.ltZ != null) {
                    fy(this.ltZ.forum_id, this.ltZ.thread_id);
                }
            } else if (this.iwp != null) {
                fy(this.iwp.forumId, this.iwp.threadId);
            }
        }
    }

    private void fy(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.lua);
        pbActivityConfig.setVideoOriginArea(ay.aY(this.luQ));
        pbActivityConfig.setNeedPreLoad(true);
        com.baidu.tieba.frs.l.ak(this.lua);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
        if (this.aiA != null) {
            this.aiA.onClick(djM());
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void dfi() {
        if (this.luA == this.lus) {
            dky();
        }
    }

    public void dky() {
        EQ(this.lut);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean dkx() {
        return false;
    }
}
