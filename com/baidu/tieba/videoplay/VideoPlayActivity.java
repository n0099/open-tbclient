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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.b;
import com.baidu.tbadk.BdToken.c;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.h;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String bZb;
    private String hcu;
    private VideoPlayView jHN;
    private List<VideoItemData> jHO;
    private int jHP;
    private String jHQ;
    private VideoPlayModel jHS;
    private String mFrom;
    private String mLocate;
    private Rect mRect;
    private String mStType;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener jHR = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_LIST) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!v.isEmpty(list)) {
                    if (VideoPlayActivity.this.jHO == null) {
                        VideoPlayActivity.this.jHO = new ArrayList();
                    }
                    VideoPlayActivity.this.jHO.clear();
                    VideoPlayActivity.this.jHO.addAll(list);
                }
                if (VideoPlayActivity.this.jHN != null) {
                    VideoPlayActivity.this.jHN.notifyDataSetChanged();
                }
                VideoPlayActivity.this.mHasMore = hVar.mHasMore;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (TbSingleton.getInstance().isNotchScreen(this) || TbSingleton.getInstance().isCutoutScreen(this)) {
            setUseStyleImmersiveSticky(false);
        }
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        setContentView(R.layout.video_play_activity);
        registerListener(this.jHR);
        initData();
        cwj();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.adZ().k(b.bQY, getMissionTid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jHN != null) {
            this.jHN.onPause();
        }
        c.adZ().aee();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.jHN != null) {
            this.jHN.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jHN != null) {
            this.jHN.onDestroy();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            if ("index".equals(this.jHQ)) {
                str = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            } else if ("concern_tab".equals(this.jHQ)) {
                str = PageStayDurationConstants.PageName.HOMEPAGE_CONCERN;
            } else if ("frs".equals(this.jHQ)) {
                str = PageStayDurationConstants.PageName.FRS;
            } else if ("homepage".equals(this.jHQ)) {
                str = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            }
            TiebaStatic.log(new an(PageStayDurationConstants.URL_KEY).bS("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).p("obj_duration", currentTimeMillis).bS("obj_source", str).bS("is_vertical", "1"));
            return;
        }
        TiebaStatic.log(new an(PageStayDurationConstants.URL_KEY).bS("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).p("obj_duration", currentTimeMillis).bS("obj_source", PageStayDurationConstants.PageName.SQUARE_RECOMMEND));
    }

    private void cwj() {
        this.jHN = new VideoPlayView(this, this.hcu);
        this.jHN.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void aLX() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.jHS != null) {
                            VideoPlayActivity.this.jHS.setFrom(VideoPlayActivity.this.hcu);
                            VideoPlayActivity.this.jHS.aIW();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOAD_MORE_VIDEO_IN_SQUARE));
                }
            }
        });
        this.jHN.a(this.jHO, this.jHP, this.mRect);
        this.jHN.Fo(this.mFrom);
        this.jHN.Fr(this.bZb);
    }

    private void initData() {
        this.jHO = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.jHP = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.hcu = getIntent().getStringExtra("from");
        this.jHQ = getIntent().getStringExtra(VideoPlayActivityConfig.SOURCE_FROM);
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        if (v.isEmpty(this.jHO) && !v.isEmpty(VideoPlayActivityConfig.bigDataList)) {
            this.jHO = new ArrayList();
            this.jHO.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (v.isEmpty(this.jHO)) {
            l.showToast(this, (int) R.string.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.jHS = new VideoPlayModel(this);
            this.jHS.setFrom(this.hcu);
            this.jHS.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void t(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.isEmpty(list) && !v.isEmpty(VideoPlayActivity.this.jHO)) {
                        VideoPlayActivity.this.jHO.clear();
                        VideoPlayActivity.this.jHO.addAll(list);
                        if (VideoPlayActivity.this.jHN != null) {
                            VideoPlayActivity.this.jHN.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void u(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.isEmpty(list) && !v.isEmpty(VideoPlayActivity.this.jHO)) {
                        VideoPlayActivity.this.jHO.addAll(list);
                        if (VideoPlayActivity.this.jHN != null) {
                            VideoPlayActivity.this.jHN.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.jHO.get(0) != null) {
                this.bZb = this.jHO.get(0).thread_id;
            }
            this.jHS.setFrom(this.hcu);
            this.jHS.a(this.jHO.get(0), this.mStType, this.mLocate);
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
            if (this.jHN == null || !this.jHN.cwv()) {
                if (this.jHN.jIY != this.jHN.jIX && this.jHN.jIX >= 0 && this.jHN.jIX < this.jHO.size() && (videoItemData = this.jHO.get(this.jHN.jIX)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_INDEX, videoItemData.thread_id));
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
        if (this.jHN != null) {
            this.jHN.b(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (Build.VERSION.SDK_INT >= 16 && !z && getActivity() != null && getActivity().getWindow() != null && getActivity().getWindow().getDecorView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(getActivity().getWindow().getDecorView().getSystemUiVisibility() | 4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        VideoItemData videoItemData = (VideoItemData) v.getItem(this.jHO, this.jHP);
        if (videoItemData == null || TextUtils.isEmpty(videoItemData.thread_id)) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.toLong(videoItemData.thread_id, 0L);
    }
}
