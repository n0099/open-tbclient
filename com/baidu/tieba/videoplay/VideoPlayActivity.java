package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import d.b.b.e.p.l;
import d.b.i0.p3.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    public static final String FROM_VIDEO_PLAY = "nani_midpage";
    public boolean isFromBjhPb;
    public boolean isVertail;
    public String mFrom;
    public String mFromPage;
    public String mLocate;
    public String mNid;
    public String mObjId;
    public Rect mRect;
    public String mSourceFrom;
    public String mStType;
    public List<VideoItemData> mVideoDataList;
    public int mVideoIndex;
    public VideoPlayModel mVideoPlayModel;
    public VideoPlayView mVideoPlayView;
    public boolean mHasMore = true;
    public long mStartTime = 0;
    public CustomMessageListener syncVideoListListener = new a(2921320);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof g)) {
                return;
            }
            g gVar = (g) customResponsedMessage.getData();
            List<VideoItemData> list = gVar.f58912a;
            if (!ListUtils.isEmpty(list)) {
                if (VideoPlayActivity.this.mVideoDataList == null) {
                    VideoPlayActivity.this.mVideoDataList = new ArrayList();
                }
                VideoPlayActivity.this.mVideoDataList.clear();
                VideoPlayActivity.this.mVideoDataList.addAll(list);
            }
            if (VideoPlayActivity.this.mVideoPlayView != null) {
                VideoPlayActivity.this.mVideoPlayView.y();
            }
            VideoPlayActivity.this.mHasMore = gVar.f58913b;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements VideoPlayView.g {
        public b() {
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayView.g
        public void a() {
            if (VideoPlayActivity.this.mHasMore) {
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                    if (VideoPlayActivity.this.mVideoPlayModel != null) {
                        VideoPlayActivity.this.mVideoPlayModel.setFrom(VideoPlayActivity.this.mFromPage);
                        if (VideoPlayActivity.this.mVideoDataList.size() > 0) {
                            VideoPlayActivity.this.mVideoPlayModel.w((VideoItemData) VideoPlayActivity.this.mVideoDataList.get(0));
                            return;
                        }
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921319));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements VideoPlayModel.b {
        public c() {
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.b
        public void a(List<VideoItemData> list, boolean z) {
            VideoPlayActivity.this.mHasMore = z;
            if (ListUtils.isEmpty(list) || ListUtils.isEmpty(VideoPlayActivity.this.mVideoDataList)) {
                return;
            }
            VideoPlayActivity.this.mVideoDataList.addAll(list);
            if (VideoPlayActivity.this.mVideoPlayView != null) {
                VideoPlayActivity.this.mVideoPlayView.y();
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayModel.b
        public void b(List<VideoItemData> list, boolean z) {
            VideoPlayActivity.this.mHasMore = z;
            if (ListUtils.isEmpty(list) || ListUtils.isEmpty(VideoPlayActivity.this.mVideoDataList)) {
                return;
            }
            VideoPlayActivity videoPlayActivity = VideoPlayActivity.this;
            videoPlayActivity.syncFirstVideoFollowState(videoPlayActivity.mVideoDataList, list);
            VideoPlayActivity.this.mVideoDataList.clear();
            VideoPlayActivity.this.mVideoDataList.addAll(list);
            if (VideoPlayActivity.this.mVideoPlayView != null) {
                VideoPlayActivity.this.mVideoPlayView.y();
            }
        }
    }

    private void doEnterStatistic() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ENTER_VIDEO_PAGE);
        if (TextUtils.isEmpty(this.mNid)) {
            statisticItem.param("obj_type", "1");
        } else {
            statisticItem.param("obj_type", "2");
            statisticItem.param("obj_id", this.mNid);
        }
        TiebaStatic.log(statisticItem);
    }

    private void initData() {
        this.mVideoDataList = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.mVideoIndex = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra("page_from");
        this.mFromPage = getIntent().getStringExtra("from");
        this.mSourceFrom = getIntent().getStringExtra("source_from");
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        this.isVertail = getIntent().getBooleanExtra(VideoPlayActivityConfig.PARAM_IS_VERTAIL, true);
        this.isFromBjhPb = getIntent().getBooleanExtra(VideoPlayActivityConfig.IS_FROM_BJH_PB, false);
        this.mNid = getIntent().getStringExtra("key_nid");
        if (ListUtils.isEmpty(this.mVideoDataList) && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
            ArrayList arrayList = new ArrayList();
            this.mVideoDataList = arrayList;
            arrayList.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (ListUtils.isEmpty(this.mVideoDataList)) {
            l.K(this, R.string.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            VideoPlayModel videoPlayModel = new VideoPlayModel(this);
            this.mVideoPlayModel = videoPlayModel;
            videoPlayModel.setFrom(this.mFromPage);
            this.mVideoPlayModel.y(new c());
            if (this.mVideoDataList.get(0) != null) {
                this.mObjId = this.mVideoDataList.get(0).thread_id;
            }
            this.mVideoPlayModel.setFrom(this.mFromPage);
            this.mVideoPlayModel.x(this.mVideoDataList.get(0), this.mStType, this.mLocate, this.isVertail);
        }
    }

    private void showData() {
        VideoPlayView videoPlayView = new VideoPlayView(this, this.mFromPage);
        this.mVideoPlayView = videoPlayView;
        videoPlayView.L(new b());
        this.mVideoPlayView.P(this.mVideoDataList, this.mVideoIndex, this.mRect);
        this.mVideoPlayView.M(this.mFrom);
        this.mVideoPlayView.K(this.mObjId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncFirstVideoFollowState(List<VideoItemData> list, List<VideoItemData> list2) {
        UserItemData userItemData;
        UserItemData userItemData2;
        String str;
        VideoItemData videoItemData = (VideoItemData) ListUtils.getItem(list, 0);
        VideoItemData videoItemData2 = (VideoItemData) ListUtils.getItem(list2, 0);
        if (videoItemData == null || (userItemData = videoItemData.author_info) == null || videoItemData2 == null || (userItemData2 = videoItemData2.author_info) == null || (str = userItemData2.user_id) == null || !str.equals(userItemData.user_id)) {
            return;
        }
        videoItemData2.author_info.is_follow = videoItemData.author_info.is_follow;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        VideoItemData videoItemData = (VideoItemData) ListUtils.getItem(this.mVideoDataList, this.mVideoIndex);
        if (videoItemData == null || TextUtils.isEmpty(videoItemData.thread_id)) {
            return 0L;
        }
        return d.b.b.e.m.b.f(videoItemData.thread_id, 0L);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        VideoPlayView videoPlayView = this.mVideoPlayView;
        if (videoPlayView != null) {
            videoPlayView.q(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        VideoPlayView videoPlayView = this.mVideoPlayView;
        if (videoPlayView != null) {
            videoPlayView.z(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (TbSingleton.getInstance().isNotchScreen(this) || TbSingleton.getInstance().isCutoutScreen(this)) {
            setUseStyleImmersiveSticky(false);
        }
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        setContentView(R.layout.video_play_activity);
        registerListener(this.syncVideoListListener);
        initData();
        showData();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        doEnterStatistic();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        VideoPlayView videoPlayView = this.mVideoPlayView;
        if (videoPlayView != null) {
            videoPlayView.A();
        }
        String str = TextUtils.isEmpty(this.mNid) ? "0" : "1";
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str2 = "a002";
            if (!"index".equals(this.mSourceFrom)) {
                if ("concern_tab".equals(this.mSourceFrom)) {
                    str2 = "a038";
                } else if ("frs".equals(this.mSourceFrom)) {
                    str2 = "a006";
                } else {
                    "homepage".equals(this.mSourceFrom);
                }
            }
            if (this.isFromBjhPb) {
                TiebaStatic.log(new StatisticItem("stime").param("obj_type", "a023").param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis).param("obj_source", str2).param(TiebaStatic.Params.IS_VERTICAL, "1").param("is_dynamic", str).param("obj_location", this.mFromPage));
                return;
            } else {
                TiebaStatic.log(new StatisticItem("stime").param("obj_type", "a023").param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis).param("obj_source", str2).param("is_dynamic", str).param(TiebaStatic.Params.IS_VERTICAL, "1"));
                return;
            }
        }
        TiebaStatic.log(new StatisticItem("stime").param("obj_type", "a023").param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis).param("is_dynamic", str).param("obj_source", "a020"));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        VideoItemData videoItemData;
        if (i == 4) {
            VideoPlayView videoPlayView = this.mVideoPlayView;
            if (videoPlayView == null || !videoPlayView.r()) {
                VideoPlayView videoPlayView2 = this.mVideoPlayView;
                int i2 = videoPlayView2.i;
                int i3 = videoPlayView2.f21995h;
                if (i2 != i3 && i3 >= 0 && i3 < this.mVideoDataList.size() && (videoItemData = this.mVideoDataList.get(this.mVideoPlayView.f21995h)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, videoItemData.thread_id));
                }
                finish();
                return false;
            }
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (Build.VERSION.SDK_INT < 16 || z || getActivity() == null || getActivity().getWindow() == null || getActivity().getWindow().getDecorView() == null || TbSingleton.getInstance().isNotchScreen(this) || TbSingleton.getInstance().isCutoutScreen(this)) {
            return;
        }
        getActivity().getWindow().getDecorView().setSystemUiVisibility(getActivity().getWindow().getDecorView().getSystemUiVisibility() | 4);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        VideoPlayView videoPlayView = this.mVideoPlayView;
        if (videoPlayView != null) {
            videoPlayView.B();
        }
        d.b.h0.a.c.y().E();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d.b.h0.a.c.y().P(d.b.h0.a.b.Z, getMissionTid());
    }
}
