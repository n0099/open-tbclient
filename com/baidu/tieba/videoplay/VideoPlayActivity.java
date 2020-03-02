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
/* loaded from: classes11.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String cOR;
    private VideoPlayView kFJ;
    private List<VideoItemData> kFK;
    private int kFL;
    private boolean kFM;
    private VideoPlayModel kFO;
    private String mFrom;
    private String mFromPage;
    private String mLocate;
    private String mNid;
    private Rect mRect;
    private String mSourceFrom;
    private String mStType;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener kFN = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_LIST) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!v.isEmpty(list)) {
                    if (VideoPlayActivity.this.kFK == null) {
                        VideoPlayActivity.this.kFK = new ArrayList();
                    }
                    VideoPlayActivity.this.kFK.clear();
                    VideoPlayActivity.this.kFK.addAll(list);
                }
                if (VideoPlayActivity.this.kFJ != null) {
                    VideoPlayActivity.this.kFJ.notifyDataSetChanged();
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
        registerListener(this.kFN);
        initData();
        cSN();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bLv();
    }

    private void bLv() {
        an anVar = new an("c12664");
        if (TextUtils.isEmpty(this.mNid)) {
            anVar.cy("obj_type", "1");
        } else {
            anVar.cy("obj_type", "2");
            anVar.cy("obj_id", this.mNid);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.axz().o(b.cGS, getMissionTid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kFJ != null) {
            this.kFJ.onPause();
        }
        c.axz().axE();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.kFJ != null) {
            this.kFJ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kFJ != null) {
            this.kFJ.onDestroy();
        }
        String str = TextUtils.isEmpty(this.mNid) ? "0" : "1";
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            if ("index".equals(this.mSourceFrom)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            } else if ("concern_tab".equals(this.mSourceFrom)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_CONCERN;
            } else if ("frs".equals(this.mSourceFrom)) {
                str2 = PageStayDurationConstants.PageName.FRS;
            } else if ("homepage".equals(this.mSourceFrom)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            }
            if (this.kFM) {
                TiebaStatic.log(new an(PageStayDurationConstants.URL_KEY).cy("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).s("obj_duration", currentTimeMillis).cy("obj_source", str2).cy("is_vertical", "1").cy("is_dynamic", str).cy("obj_location", this.mFromPage));
                return;
            } else {
                TiebaStatic.log(new an(PageStayDurationConstants.URL_KEY).cy("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).s("obj_duration", currentTimeMillis).cy("obj_source", str2).cy("is_dynamic", str).cy("is_vertical", "1"));
                return;
            }
        }
        TiebaStatic.log(new an(PageStayDurationConstants.URL_KEY).cy("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).s("obj_duration", currentTimeMillis).cy("is_dynamic", str).cy("obj_source", PageStayDurationConstants.PageName.SQUARE_RECOMMEND));
    }

    private void cSN() {
        this.kFJ = new VideoPlayView(this, this.mFromPage);
        this.kFJ.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void bfJ() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.kFO != null) {
                            VideoPlayActivity.this.kFO.setFrom(VideoPlayActivity.this.mFromPage);
                            if (VideoPlayActivity.this.kFK.size() > 0) {
                                VideoPlayActivity.this.kFO.b((VideoItemData) VideoPlayActivity.this.kFK.get(0));
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
        this.kFJ.a(this.kFK, this.kFL, this.mRect);
        this.kFJ.KD(this.mFrom);
        this.kFJ.KG(this.cOR);
    }

    private void initData() {
        this.kFK = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.kFL = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = getIntent().getStringExtra("from");
        this.mSourceFrom = getIntent().getStringExtra("source_from");
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        this.kFM = getIntent().getBooleanExtra(VideoPlayActivityConfig.IS_FROM_BJH_PB, false);
        this.mNid = getIntent().getStringExtra("key_nid");
        if (v.isEmpty(this.kFK) && !v.isEmpty(VideoPlayActivityConfig.bigDataList)) {
            this.kFK = new ArrayList();
            this.kFK.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (v.isEmpty(this.kFK)) {
            l.showToast(this, (int) R.string.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.kFO = new VideoPlayModel(this);
            this.kFO.setFrom(this.mFromPage);
            this.kFO.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void w(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.isEmpty(list) && !v.isEmpty(VideoPlayActivity.this.kFK)) {
                        VideoPlayActivity.this.kFK.clear();
                        VideoPlayActivity.this.kFK.addAll(list);
                        if (VideoPlayActivity.this.kFJ != null) {
                            VideoPlayActivity.this.kFJ.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void x(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.isEmpty(list) && !v.isEmpty(VideoPlayActivity.this.kFK)) {
                        VideoPlayActivity.this.kFK.addAll(list);
                        if (VideoPlayActivity.this.kFJ != null) {
                            VideoPlayActivity.this.kFJ.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.kFK.get(0) != null) {
                this.cOR = this.kFK.get(0).thread_id;
            }
            this.kFO.setFrom(this.mFromPage);
            this.kFO.a(this.kFK.get(0), this.mStType, this.mLocate);
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
            if (this.kFJ == null || !this.kFJ.cSZ()) {
                if (this.kFJ.kGU != this.kFJ.kGT && this.kFJ.kGT >= 0 && this.kFJ.kGT < this.kFK.size() && (videoItemData = this.kFK.get(this.kFJ.kGT)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.kFJ != null) {
            this.kFJ.c(i, i2, intent);
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
        VideoItemData videoItemData = (VideoItemData) v.getItem(this.kFK, this.kFL);
        if (videoItemData == null || TextUtils.isEmpty(videoItemData.thread_id)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(videoItemData.thread_id, 0L);
    }
}
