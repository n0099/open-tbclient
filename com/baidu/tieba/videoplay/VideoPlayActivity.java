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
import com.baidu.tieba.video.g;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String agd;
    private String bBe;
    private int bsW;
    private VideoPlayView hlw;
    private List<VideoItemData> hlx;
    private VideoPlayModel hlz;
    private String mFrom;
    private String mLocate;
    private Rect mRect;
    private String mStType;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener hly = new CustomMessageListener(2921320) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                List<VideoItemData> list = gVar.mVideoItemDatas;
                if (!w.A(list)) {
                    if (VideoPlayActivity.this.hlx == null) {
                        VideoPlayActivity.this.hlx = new ArrayList();
                    }
                    VideoPlayActivity.this.hlx.clear();
                    VideoPlayActivity.this.hlx.addAll(list);
                }
                if (VideoPlayActivity.this.hlw != null) {
                    VideoPlayActivity.this.hlw.notifyDataSetChanged();
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
        registerListener(this.hly);
        initData();
        bFc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hlw != null) {
            this.hlw.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hlw != null) {
            this.hlw.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hlw != null) {
            this.hlw.onDestroy();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            TiebaStatic.log(new an("stime").ah("obj_type", "a023").f("obj_duration", currentTimeMillis / 1000).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a002").ah("is_vertical", "1"));
        } else {
            TiebaStatic.log(new an("stime").ah("obj_type", "a023").f("obj_duration", currentTimeMillis / 1000).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a020"));
        }
    }

    private void bFc() {
        this.hlw = new VideoPlayView(this, this.bBe);
        this.hlw.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void aBl() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.hlz != null) {
                            VideoPlayActivity.this.hlz.Tf();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921319));
                }
            }
        });
        this.hlw.a(this.hlx, this.bsW, this.mRect);
        this.hlw.vk(this.mFrom);
        this.hlw.vl(this.agd);
    }

    private void initData() {
        this.hlx = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.bsW = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.bBe = getIntent().getStringExtra("from");
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        if (w.A(this.hlx) && !w.A(VideoPlayActivityConfig.bigDataList)) {
            this.hlx = new ArrayList();
            this.hlx.addAll(VideoPlayActivityConfig.bigDataList);
            VideoPlayActivityConfig.bigDataList = null;
        }
        if (w.A(this.hlx)) {
            l.showToast(this, d.k.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.hlz = new VideoPlayModel(this);
            this.hlz.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void p(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!w.A(list) && !w.A(VideoPlayActivity.this.hlx)) {
                        VideoPlayActivity.this.hlx.clear();
                        VideoPlayActivity.this.hlx.addAll(list);
                        if (VideoPlayActivity.this.hlw != null) {
                            VideoPlayActivity.this.hlw.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void q(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!w.A(list) && !w.A(VideoPlayActivity.this.hlx)) {
                        VideoPlayActivity.this.hlx.addAll(list);
                        if (VideoPlayActivity.this.hlw != null) {
                            VideoPlayActivity.this.hlw.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.hlx.get(0) != null) {
                this.agd = this.hlx.get(0).thread_id;
            }
            this.hlz.a(this.hlx.get(0), this.mStType, this.mLocate);
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
            if (this.hlw == null || !this.hlw.bFo()) {
                if (this.hlw.hmA != this.hlw.hmz && this.hlw.hmz >= 0 && this.hlw.hmz < this.hlx.size() && (videoItemData = this.hlx.get(this.hlw.hmz)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.hlw != null) {
            this.hlw.b(i, i2, intent);
        }
    }
}
