package com.baidu.tieba.videoplay;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.g;
import com.baidu.tieba.videoplay.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private int bXc;
    private c hxv;
    private List<VideoItemData> hxw;
    private Rect lQ;
    private String mFrom;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener hxx = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_LIST) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                List<VideoItemData> list = gVar.hng;
                if (!v.E(list)) {
                    if (VideoPlayActivity.this.hxw == null) {
                        VideoPlayActivity.this.hxw = new ArrayList();
                    }
                    VideoPlayActivity.this.hxw.clear();
                    VideoPlayActivity.this.hxw.addAll(list);
                }
                if (VideoPlayActivity.this.hxv != null) {
                    VideoPlayActivity.this.hxv.notifyDataSetChanged();
                }
                VideoPlayActivity.this.mHasMore = gVar.mHasMore;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        setContentView(d.h.video_play_activity);
        registerListener(this.hxx);
        initData();
        bDI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hxv != null) {
            this.hxv.onDestroy();
        }
        TiebaStatic.log(new ak("stime").aa("obj_type", "a023").f("obj_duration", (System.currentTimeMillis() - this.mStartTime) / 1000).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a020"));
    }

    private void bDI() {
        this.hxv = new c(this);
        this.hxv.a(new c.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.c.a
            public void bDJ() {
                if (VideoPlayActivity.this.mHasMore) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOAD_MORE_VIDEO_IN_SQUARE));
                }
            }
        });
        this.hxv.a(this.hxw, this.bXc, this.lQ);
        this.hxv.uc(this.mFrom);
    }

    private void initData() {
        this.hxw = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.bXc = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.lQ = getIntent().getSourceBounds();
        if (v.E(this.hxw)) {
            l.showToast(this, d.j.net_error);
            finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        VideoItemData videoItemData;
        if (i == 4) {
            if (this.hxv.hyk != this.hxv.hyj && this.hxv.hyj >= 0 && this.hxv.hyj < this.hxw.size() && (videoItemData = this.hxw.get(this.hxv.hyj)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, videoItemData.thread_id));
            }
            finish();
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
