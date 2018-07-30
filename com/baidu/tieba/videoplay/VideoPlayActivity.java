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
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.h;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String afx;
    private String bBL;
    private int btD;
    private VideoPlayView hmJ;
    private List<VideoItemData> hmK;
    private VideoPlayModel hmM;
    private String mFrom;
    private String mLocate;
    private Rect mRect;
    private String mStType;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener hmL = new CustomMessageListener(2921320) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!w.z(list)) {
                    if (VideoPlayActivity.this.hmK == null) {
                        VideoPlayActivity.this.hmK = new ArrayList();
                    }
                    VideoPlayActivity.this.hmK.clear();
                    VideoPlayActivity.this.hmK.addAll(list);
                }
                if (VideoPlayActivity.this.hmJ != null) {
                    VideoPlayActivity.this.hmJ.notifyDataSetChanged();
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
        setContentView(d.h.video_play_activity);
        registerListener(this.hmL);
        initData();
        bDK();
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
        if (this.hmJ != null) {
            this.hmJ.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hmJ != null) {
            this.hmJ.onDestroy();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            TiebaStatic.log(new an("stime").af("obj_type", "a023").f("obj_duration", currentTimeMillis / 1000).af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a002").af("is_vertical", "1"));
        } else {
            TiebaStatic.log(new an("stime").af("obj_type", "a023").f("obj_duration", currentTimeMillis / 1000).af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a020"));
        }
    }

    private void bDK() {
        this.hmJ = new VideoPlayView(this, this.bBL);
        this.hmJ.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void aBU() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.hmM != null) {
                            VideoPlayActivity.this.hmM.setFrom(VideoPlayActivity.this.bBL);
                            VideoPlayActivity.this.hmM.Tn();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921319));
                }
            }
        });
        this.hmJ.a(this.hmK, this.btD, this.mRect);
        this.hmJ.vj(this.mFrom);
        this.hmJ.vm(this.afx);
    }

    private void initData() {
        this.hmK = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.btD = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.bBL = getIntent().getStringExtra("from");
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        if (w.z(this.hmK) && !w.z(VideoPlayActivityConfig.bigDataList)) {
            this.hmK = new ArrayList();
            this.hmK.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (w.z(this.hmK)) {
            l.showToast(this, d.j.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.hmM = new VideoPlayModel(this);
            this.hmM.setFrom(this.bBL);
            this.hmM.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void o(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!w.z(list) && !w.z(VideoPlayActivity.this.hmK)) {
                        VideoPlayActivity.this.hmK.clear();
                        VideoPlayActivity.this.hmK.addAll(list);
                        if (VideoPlayActivity.this.hmJ != null) {
                            VideoPlayActivity.this.hmJ.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void p(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!w.z(list) && !w.z(VideoPlayActivity.this.hmK)) {
                        VideoPlayActivity.this.hmK.addAll(list);
                        if (VideoPlayActivity.this.hmJ != null) {
                            VideoPlayActivity.this.hmJ.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.hmK.get(0) != null) {
                this.afx = this.hmK.get(0).thread_id;
            }
            this.hmM.setFrom(this.bBL);
            this.hmM.a(this.hmK.get(0), this.mStType, this.mLocate);
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
            if (this.hmJ == null || !this.hmJ.bDV()) {
                if (this.hmJ.hnO != this.hmJ.hnN && this.hmJ.hnN >= 0 && this.hmJ.hnN < this.hmK.size() && (videoItemData = this.hmK.get(this.hmJ.hnN)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.hmJ != null) {
            this.hmJ.a(i, i2, intent);
        }
    }
}
