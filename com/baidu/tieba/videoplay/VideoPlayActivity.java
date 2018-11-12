package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
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
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.h;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String anG;
    private int bIO;
    private String bQP;
    private VideoPlayView hDw;
    private List<VideoItemData> hDx;
    private VideoPlayModel hDz;
    private String mFrom;
    private String mLocate;
    private Rect mRect;
    private String mStType;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener hDy = new CustomMessageListener(2921320) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!v.I(list)) {
                    if (VideoPlayActivity.this.hDx == null) {
                        VideoPlayActivity.this.hDx = new ArrayList();
                    }
                    VideoPlayActivity.this.hDx.clear();
                    VideoPlayActivity.this.hDx.addAll(list);
                }
                if (VideoPlayActivity.this.hDw != null) {
                    VideoPlayActivity.this.hDw.notifyDataSetChanged();
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
        setContentView(e.h.video_play_activity);
        registerListener(this.hDy);
        initData();
        bJm();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
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
        if (this.hDw != null) {
            this.hDw.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.hDw != null) {
            this.hDw.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hDw != null) {
            this.hDw.onDestroy();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            TiebaStatic.log(new am("stime").ax("obj_type", "a023").h("obj_duration", currentTimeMillis / 1000).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a002").ax("is_vertical", "1"));
        } else {
            TiebaStatic.log(new am("stime").ax("obj_type", "a023").h("obj_duration", currentTimeMillis / 1000).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a020"));
        }
    }

    private void bJm() {
        this.hDw = new VideoPlayView(this, this.bQP);
        this.hDw.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void aGU() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.hDz != null) {
                            VideoPlayActivity.this.hDz.setFrom(VideoPlayActivity.this.bQP);
                            VideoPlayActivity.this.hDz.YV();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921319));
                }
            }
        });
        this.hDw.a(this.hDx, this.bIO, this.mRect);
        this.hDw.wC(this.mFrom);
        this.hDw.wF(this.anG);
    }

    private void initData() {
        this.hDx = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.bIO = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.bQP = getIntent().getStringExtra("from");
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        if (v.I(this.hDx) && !v.I(VideoPlayActivityConfig.bigDataList)) {
            this.hDx = new ArrayList();
            this.hDx.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (v.I(this.hDx)) {
            l.showToast(this, e.j.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.hDz = new VideoPlayModel(this);
            this.hDz.setFrom(this.bQP);
            this.hDz.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void q(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.I(list) && !v.I(VideoPlayActivity.this.hDx)) {
                        VideoPlayActivity.this.hDx.clear();
                        VideoPlayActivity.this.hDx.addAll(list);
                        if (VideoPlayActivity.this.hDw != null) {
                            VideoPlayActivity.this.hDw.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void r(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.I(list) && !v.I(VideoPlayActivity.this.hDx)) {
                        VideoPlayActivity.this.hDx.addAll(list);
                        if (VideoPlayActivity.this.hDw != null) {
                            VideoPlayActivity.this.hDw.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.hDx.get(0) != null) {
                this.anG = this.hDx.get(0).thread_id;
            }
            this.hDz.setFrom(this.bQP);
            this.hDz.a(this.hDx.get(0), this.mStType, this.mLocate);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        VideoItemData videoItemData;
        if (i == 4) {
            if (this.hDw == null || !this.hDw.bJz()) {
                if (this.hDw.hEE != this.hDw.hED && this.hDw.hED >= 0 && this.hDw.hED < this.hDx.size() && (videoItemData = this.hDx.get(this.hDw.hED)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.hDw != null) {
            this.hDw.a(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (Build.VERSION.SDK_INT >= 16 && !z && getActivity() != null && getActivity().getWindow() != null && getActivity().getWindow().getDecorView() != null) {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(getActivity().getWindow().getDecorView().getSystemUiVisibility() | 4);
        }
    }
}
