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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.h;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String afx;
    private String bBN;
    private int btF;
    private VideoPlayView hmK;
    private List<VideoItemData> hmL;
    private VideoPlayModel hmN;
    private String mFrom;
    private String mLocate;
    private Rect mRect;
    private String mStType;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener hmM = new CustomMessageListener(2921320) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!w.z(list)) {
                    if (VideoPlayActivity.this.hmL == null) {
                        VideoPlayActivity.this.hmL = new ArrayList();
                    }
                    VideoPlayActivity.this.hmL.clear();
                    VideoPlayActivity.this.hmL.addAll(list);
                }
                if (VideoPlayActivity.this.hmK != null) {
                    VideoPlayActivity.this.hmK.notifyDataSetChanged();
                }
                VideoPlayActivity.this.mHasMore = hVar.mHasMore;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        setContentView(f.h.video_play_activity);
        registerListener(this.hmM);
        initData();
        bDM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hmK != null) {
            this.hmK.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hmK != null) {
            this.hmK.onDestroy();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            TiebaStatic.log(new an("stime").ae("obj_type", "a023").f("obj_duration", currentTimeMillis / 1000).ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a002").ae("is_vertical", "1"));
        } else {
            TiebaStatic.log(new an("stime").ae("obj_type", "a023").f("obj_duration", currentTimeMillis / 1000).ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a020"));
        }
    }

    private void bDM() {
        this.hmK = new VideoPlayView(this, this.bBN);
        this.hmK.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void aBR() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.hmN != null) {
                            VideoPlayActivity.this.hmN.setFrom(VideoPlayActivity.this.bBN);
                            VideoPlayActivity.this.hmN.Tq();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921319));
                }
            }
        });
        this.hmK.a(this.hmL, this.btF, this.mRect);
        this.hmK.vn(this.mFrom);
        this.hmK.vq(this.afx);
    }

    private void initData() {
        this.hmL = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.btF = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.bBN = getIntent().getStringExtra("from");
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        if (w.z(this.hmL) && !w.z(VideoPlayActivityConfig.bigDataList)) {
            this.hmL = new ArrayList();
            this.hmL.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (w.z(this.hmL)) {
            l.showToast(this, f.j.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.hmN = new VideoPlayModel(this);
            this.hmN.setFrom(this.bBN);
            this.hmN.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void o(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!w.z(list) && !w.z(VideoPlayActivity.this.hmL)) {
                        VideoPlayActivity.this.hmL.clear();
                        VideoPlayActivity.this.hmL.addAll(list);
                        if (VideoPlayActivity.this.hmK != null) {
                            VideoPlayActivity.this.hmK.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void p(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!w.z(list) && !w.z(VideoPlayActivity.this.hmL)) {
                        VideoPlayActivity.this.hmL.addAll(list);
                        if (VideoPlayActivity.this.hmK != null) {
                            VideoPlayActivity.this.hmK.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.hmL.get(0) != null) {
                this.afx = this.hmL.get(0).thread_id;
            }
            this.hmN.setFrom(this.bBN);
            this.hmN.a(this.hmL.get(0), this.mStType, this.mLocate);
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
            if (this.hmK == null || !this.hmK.bDX()) {
                if (this.hmK.hnP != this.hmK.hnO && this.hmK.hnO >= 0 && this.hmK.hnO < this.hmL.size() && (videoItemData = this.hmL.get(this.hmK.hnO)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.hmK != null) {
            this.hmK.a(i, i2, intent);
        }
    }
}
