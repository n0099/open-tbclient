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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.h;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String dYo;
    private String mEA;
    private boolean mEB;
    private VideoPlayModel mED;
    private VideoPlayView mEx;
    private List<VideoItemData> mEy;
    private int mEz;
    private String mFrom;
    private String mFromPage;
    private String mLocate;
    private String mNid;
    private Rect mRect;
    private String mStType;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener mEC = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_LIST) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!y.isEmpty(list)) {
                    if (VideoPlayActivity.this.mEy == null) {
                        VideoPlayActivity.this.mEy = new ArrayList();
                    }
                    VideoPlayActivity.this.mEy.clear();
                    VideoPlayActivity.this.mEy.addAll(list);
                }
                if (VideoPlayActivity.this.mEx != null) {
                    VideoPlayActivity.this.mEx.notifyDataSetChanged();
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
        registerListener(this.mEC);
        initData();
        dEq();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        cus();
    }

    private void cus() {
        aq aqVar = new aq("c12664");
        if (TextUtils.isEmpty(this.mNid)) {
            aqVar.dD("obj_type", "1");
        } else {
            aqVar.dD("obj_type", "2");
            aqVar.dD("obj_id", this.mNid);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.aYs().p(b.dNM, getMissionTid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mEx != null) {
            this.mEx.onPause();
        }
        c.aYs().aYC();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.mEx != null) {
            this.mEx.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mEx != null) {
            this.mEx.onDestroy();
        }
        String str = TextUtils.isEmpty(this.mNid) ? "0" : "1";
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            if ("index".equals(this.mEA)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            } else if ("concern_tab".equals(this.mEA)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_CONCERN;
            } else if ("frs".equals(this.mEA)) {
                str2 = PageStayDurationConstants.PageName.FRS;
            } else if ("homepage".equals(this.mEA)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            }
            if (this.mEB) {
                TiebaStatic.log(new aq(PageStayDurationConstants.URL_KEY).dD("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).u("obj_duration", currentTimeMillis).dD("obj_source", str2).dD("is_vertical", "1").dD("is_dynamic", str).dD("obj_location", this.mFromPage));
                return;
            } else {
                TiebaStatic.log(new aq(PageStayDurationConstants.URL_KEY).dD("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).u("obj_duration", currentTimeMillis).dD("obj_source", str2).dD("is_dynamic", str).dD("is_vertical", "1"));
                return;
            }
        }
        TiebaStatic.log(new aq(PageStayDurationConstants.URL_KEY).dD("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).u("obj_duration", currentTimeMillis).dD("is_dynamic", str).dD("obj_source", PageStayDurationConstants.PageName.SQUARE_RECOMMEND));
    }

    private void dEq() {
        this.mEx = new VideoPlayView(this, this.mFromPage);
        this.mEx.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void bKC() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.mED != null) {
                            VideoPlayActivity.this.mED.setFrom(VideoPlayActivity.this.mFromPage);
                            if (VideoPlayActivity.this.mEy.size() > 0) {
                                VideoPlayActivity.this.mED.b((VideoItemData) VideoPlayActivity.this.mEy.get(0));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOAD_MORE_VIDEO_IN_SQUARE));
                }
            }
        });
        this.mEx.a(this.mEy, this.mEz, this.mRect);
        this.mEx.Si(this.mFrom);
        this.mEx.Sl(this.dYo);
    }

    private void initData() {
        this.mEy = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.mEz = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra("page_from");
        this.mFromPage = getIntent().getStringExtra("from");
        this.mEA = getIntent().getStringExtra("source_from");
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        this.mEB = getIntent().getBooleanExtra(VideoPlayActivityConfig.IS_FROM_BJH_PB, false);
        this.mNid = getIntent().getStringExtra("key_nid");
        if (y.isEmpty(this.mEy) && !y.isEmpty(VideoPlayActivityConfig.bigDataList)) {
            this.mEy = new ArrayList();
            this.mEy.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (y.isEmpty(this.mEy)) {
            l.showToast(this, R.string.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.mED = new VideoPlayModel(this);
            this.mED.setFrom(this.mFromPage);
            this.mED.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void t(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!y.isEmpty(list) && !y.isEmpty(VideoPlayActivity.this.mEy)) {
                        VideoPlayActivity.this.mEy.clear();
                        VideoPlayActivity.this.mEy.addAll(list);
                        if (VideoPlayActivity.this.mEx != null) {
                            VideoPlayActivity.this.mEx.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void u(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!y.isEmpty(list) && !y.isEmpty(VideoPlayActivity.this.mEy)) {
                        VideoPlayActivity.this.mEy.addAll(list);
                        if (VideoPlayActivity.this.mEx != null) {
                            VideoPlayActivity.this.mEx.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.mEy.get(0) != null) {
                this.dYo = this.mEy.get(0).thread_id;
            }
            this.mED.setFrom(this.mFromPage);
            this.mED.a(this.mEy.get(0), this.mStType, this.mLocate);
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
            if (this.mEx == null || !this.mEx.dEE()) {
                if (this.mEx.mFJ != this.mEx.mFI && this.mEx.mFI >= 0 && this.mEx.mFI < this.mEy.size() && (videoItemData = this.mEy.get(this.mEx.mFI)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.mEx != null) {
            this.mEx.c(i, i2, intent);
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
        VideoItemData videoItemData = (VideoItemData) y.getItem(this.mEy, this.mEz);
        if (videoItemData == null || TextUtils.isEmpty(videoItemData.thread_id)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(videoItemData.thread_id, 0L);
    }
}
