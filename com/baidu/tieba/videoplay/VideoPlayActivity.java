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
    private int bYZ;
    private c hyw;
    private List<VideoItemData> hyx;
    private Rect lQ;
    private String mFrom;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener hyy = new CustomMessageListener(2921320) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                List<VideoItemData> list = gVar.hoi;
                if (!v.E(list)) {
                    if (VideoPlayActivity.this.hyx == null) {
                        VideoPlayActivity.this.hyx = new ArrayList();
                    }
                    VideoPlayActivity.this.hyx.clear();
                    VideoPlayActivity.this.hyx.addAll(list);
                }
                if (VideoPlayActivity.this.hyw != null) {
                    VideoPlayActivity.this.hyw.notifyDataSetChanged();
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
        registerListener(this.hyy);
        initData();
        bEp();
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
        if (this.hyw != null) {
            this.hyw.onDestroy();
        }
        TiebaStatic.log(new ak("stime").ab("obj_type", "a023").f("obj_duration", (System.currentTimeMillis() - this.mStartTime) / 1000).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a020"));
    }

    private void bEp() {
        this.hyw = new c(this);
        this.hyw.a(new c.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.c.a
            public void bEq() {
                if (VideoPlayActivity.this.mHasMore) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921319));
                }
            }
        });
        this.hyw.a(this.hyx, this.bYZ, this.lQ);
        this.hyw.ug(this.mFrom);
    }

    private void initData() {
        this.hyx = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.bYZ = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.lQ = getIntent().getSourceBounds();
        if (v.E(this.hyx)) {
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
            if (this.hyw.hzl != this.hyw.hzk && this.hyw.hzk >= 0 && this.hyw.hzk < this.hyx.size() && (videoItemData = this.hyx.get(this.hyw.hzk)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, videoItemData.thread_id));
            }
            finish();
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
