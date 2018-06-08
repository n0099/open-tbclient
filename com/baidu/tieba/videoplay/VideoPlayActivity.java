package com.baidu.tieba.videoplay;

import android.content.Intent;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.g;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String afO;
    private int brw;
    private VideoPlayView hhp;
    private List<VideoItemData> hhq;
    private VideoPlayModel hhs;
    private String mFrom;
    private String mLocate;
    private Rect mRect;
    private String mStType;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener hhr = new CustomMessageListener(2921320) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                List<VideoItemData> list = gVar.mVideoItemDatas;
                if (!w.z(list)) {
                    if (VideoPlayActivity.this.hhq == null) {
                        VideoPlayActivity.this.hhq = new ArrayList();
                    }
                    VideoPlayActivity.this.hhq.clear();
                    VideoPlayActivity.this.hhq.addAll(list);
                }
                if (VideoPlayActivity.this.hhp != null) {
                    VideoPlayActivity.this.hhp.notifyDataSetChanged();
                }
                VideoPlayActivity.this.mHasMore = gVar.mHasMore;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        setContentView(d.i.video_play_activity);
        registerListener(this.hhr);
        initData();
        bEC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hhp != null) {
            this.hhp.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hhp != null) {
            this.hhp.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hhp != null) {
            this.hhp.onDestroy();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            TiebaStatic.log(new am("stime").ah("obj_type", "a023").f("obj_duration", currentTimeMillis / 1000).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a002").ah("is_vertical", "1"));
        } else {
            TiebaStatic.log(new am("stime").ah("obj_type", "a023").f("obj_duration", currentTimeMillis / 1000).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a020"));
        }
    }

    private void bEC() {
        this.hhp = new VideoPlayView(this);
        this.hhp.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void aAE() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.hhs != null) {
                            VideoPlayActivity.this.hhs.SJ();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921319));
                }
            }
        });
        this.hhp.a(this.hhq, this.brw, this.mRect);
        this.hhp.vo(this.mFrom);
        this.hhp.vp(this.afO);
    }

    private void initData() {
        this.hhq = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.brw = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        if (w.z(this.hhq)) {
            l.showToast(this, d.k.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.hhs = new VideoPlayModel(this);
            this.hhs.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void p(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!w.z(list) && !w.z(VideoPlayActivity.this.hhq)) {
                        VideoPlayActivity.this.hhq.clear();
                        VideoPlayActivity.this.hhq.addAll(list);
                        if (VideoPlayActivity.this.hhp != null) {
                            VideoPlayActivity.this.hhp.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void q(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!w.z(list) && !w.z(VideoPlayActivity.this.hhq)) {
                        VideoPlayActivity.this.hhq.addAll(list);
                        if (VideoPlayActivity.this.hhp != null) {
                            VideoPlayActivity.this.hhp.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.hhq.get(0) != null) {
                this.afO = this.hhq.get(0).thread_id;
            }
            this.hhs.a(this.hhq.get(0), this.mStType, this.mLocate);
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
            if (this.hhp == null || !this.hhp.bEO()) {
                if (this.hhp.hiv != this.hhp.hiu && this.hhp.hiu >= 0 && this.hhp.hiu < this.hhq.size() && (videoItemData = this.hhq.get(this.hhp.hiu)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, videoItemData.thread_id));
                }
                finish();
                return false;
            }
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hhp != null) {
            this.hhp.b(i, i2, intent);
        }
    }
}
