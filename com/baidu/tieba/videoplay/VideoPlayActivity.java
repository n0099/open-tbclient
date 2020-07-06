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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.i;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String dIK;
    private String mFrom;
    private String mFromPage;
    private String mLocate;
    private String mNid;
    private Rect mRect;
    private String mStType;
    private VideoPlayView mfs;
    private List<VideoItemData> mft;
    private int mfu;
    private String mfv;
    private boolean mfw;
    private VideoPlayModel mfy;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener mfx = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_LIST) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                List<VideoItemData> list = iVar.mVideoItemDatas;
                if (!w.isEmpty(list)) {
                    if (VideoPlayActivity.this.mft == null) {
                        VideoPlayActivity.this.mft = new ArrayList();
                    }
                    VideoPlayActivity.this.mft.clear();
                    VideoPlayActivity.this.mft.addAll(list);
                }
                if (VideoPlayActivity.this.mfs != null) {
                    VideoPlayActivity.this.mfs.notifyDataSetChanged();
                }
                VideoPlayActivity.this.mHasMore = iVar.mHasMore;
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
        registerListener(this.mfx);
        initData();
        dpM();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        cgp();
    }

    private void cgp() {
        ao aoVar = new ao("c12664");
        if (TextUtils.isEmpty(this.mNid)) {
            aoVar.dk("obj_type", "1");
        } else {
            aoVar.dk("obj_type", "2");
            aoVar.dk("obj_id", this.mNid);
        }
        TiebaStatic.log(aoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.aMo().p(b.dyI, getMissionTid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mfs != null) {
            this.mfs.onPause();
        }
        c.aMo().aMy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.mfs != null) {
            this.mfs.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mfs != null) {
            this.mfs.onDestroy();
        }
        String str = TextUtils.isEmpty(this.mNid) ? "0" : "1";
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            if ("index".equals(this.mfv)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            } else if ("concern_tab".equals(this.mfv)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_CONCERN;
            } else if ("frs".equals(this.mfv)) {
                str2 = PageStayDurationConstants.PageName.FRS;
            } else if ("homepage".equals(this.mfv)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            }
            if (this.mfw) {
                TiebaStatic.log(new ao(PageStayDurationConstants.URL_KEY).dk("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).s("obj_duration", currentTimeMillis).dk("obj_source", str2).dk("is_vertical", "1").dk("is_dynamic", str).dk("obj_location", this.mFromPage));
                return;
            } else {
                TiebaStatic.log(new ao(PageStayDurationConstants.URL_KEY).dk("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).s("obj_duration", currentTimeMillis).dk("obj_source", str2).dk("is_dynamic", str).dk("is_vertical", "1"));
                return;
            }
        }
        TiebaStatic.log(new ao(PageStayDurationConstants.URL_KEY).dk("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).s("obj_duration", currentTimeMillis).dk("is_dynamic", str).dk("obj_source", PageStayDurationConstants.PageName.SQUARE_RECOMMEND));
    }

    private void dpM() {
        this.mfs = new VideoPlayView(this, this.mFromPage);
        this.mfs.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void bxT() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.mfy != null) {
                            VideoPlayActivity.this.mfy.setFrom(VideoPlayActivity.this.mFromPage);
                            if (VideoPlayActivity.this.mft.size() > 0) {
                                VideoPlayActivity.this.mfy.b((VideoItemData) VideoPlayActivity.this.mft.get(0));
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
        this.mfs.a(this.mft, this.mfu, this.mRect);
        this.mfs.OC(this.mFrom);
        this.mfs.OF(this.dIK);
    }

    private void initData() {
        this.mft = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.mfu = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = getIntent().getStringExtra("from");
        this.mfv = getIntent().getStringExtra("source_from");
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        this.mfw = getIntent().getBooleanExtra(VideoPlayActivityConfig.IS_FROM_BJH_PB, false);
        this.mNid = getIntent().getStringExtra("key_nid");
        if (w.isEmpty(this.mft) && !w.isEmpty(VideoPlayActivityConfig.bigDataList)) {
            this.mft = new ArrayList();
            this.mft.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (w.isEmpty(this.mft)) {
            l.showToast(this, (int) R.string.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.mfy = new VideoPlayModel(this);
            this.mfy.setFrom(this.mFromPage);
            this.mfy.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void v(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!w.isEmpty(list) && !w.isEmpty(VideoPlayActivity.this.mft)) {
                        VideoPlayActivity.this.mft.clear();
                        VideoPlayActivity.this.mft.addAll(list);
                        if (VideoPlayActivity.this.mfs != null) {
                            VideoPlayActivity.this.mfs.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void w(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!w.isEmpty(list) && !w.isEmpty(VideoPlayActivity.this.mft)) {
                        VideoPlayActivity.this.mft.addAll(list);
                        if (VideoPlayActivity.this.mfs != null) {
                            VideoPlayActivity.this.mfs.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.mft.get(0) != null) {
                this.dIK = this.mft.get(0).thread_id;
            }
            this.mfy.setFrom(this.mFromPage);
            this.mfy.a(this.mft.get(0), this.mStType, this.mLocate);
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
            if (this.mfs == null || !this.mfs.dpZ()) {
                if (this.mfs.mgE != this.mfs.mgD && this.mfs.mgD >= 0 && this.mfs.mgD < this.mft.size() && (videoItemData = this.mft.get(this.mfs.mgD)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.mfs != null) {
            this.mfs.c(i, i2, intent);
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
        VideoItemData videoItemData = (VideoItemData) w.getItem(this.mft, this.mfu);
        if (videoItemData == null || TextUtils.isEmpty(videoItemData.thread_id)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(videoItemData.thread_id, 0L);
    }
}
