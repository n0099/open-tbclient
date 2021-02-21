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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.g;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String eNE;
    private String eTz;
    private String mFrom;
    private String mFromPage;
    private String mLocate;
    private Rect mRect;
    private String mStType;
    private int mVideoIndex;
    private VideoPlayView nUK;
    private List<VideoItemData> nUL;
    private String nUM;
    private boolean nUN;
    private VideoPlayModel nUP;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener nUO = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_LIST) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                List<VideoItemData> list = gVar.mVideoItemDatas;
                if (!y.isEmpty(list)) {
                    if (VideoPlayActivity.this.nUL == null) {
                        VideoPlayActivity.this.nUL = new ArrayList();
                    }
                    VideoPlayActivity.this.nUL.clear();
                    VideoPlayActivity.this.nUL.addAll(list);
                }
                if (VideoPlayActivity.this.nUK != null) {
                    VideoPlayActivity.this.nUK.notifyDataSetChanged();
                }
                VideoPlayActivity.this.mHasMore = gVar.mHasMore;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (TbSingleton.getInstance().isNotchScreen(this) || TbSingleton.getInstance().isCutoutScreen(this)) {
            setUseStyleImmersiveSticky(false);
        }
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        setContentView(R.layout.video_play_activity);
        registerListener(this.nUO);
        initData();
        dVo();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        cMt();
    }

    private void cMt() {
        ar arVar = new ar("c12664");
        if (TextUtils.isEmpty(this.eTz)) {
            arVar.dR("obj_type", "1");
        } else {
            arVar.dR("obj_type", "2");
            arVar.dR("obj_id", this.eTz);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.bhn().q(b.eCm, getMissionTid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nUK != null) {
            this.nUK.onPause();
        }
        c.bhn().bhy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.nUK != null) {
            this.nUK.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nUK != null) {
            this.nUK.onDestroy();
        }
        String str = TextUtils.isEmpty(this.eTz) ? "0" : "1";
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            if ("index".equals(this.nUM)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            } else if ("concern_tab".equals(this.nUM)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_CONCERN;
            } else if ("frs".equals(this.nUM)) {
                str2 = PageStayDurationConstants.PageName.FRS;
            } else if ("homepage".equals(this.nUM)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            }
            if (this.nUN) {
                TiebaStatic.log(new ar(PageStayDurationConstants.URL_KEY).dR("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).v("obj_duration", currentTimeMillis).dR("obj_source", str2).dR("is_vertical", "1").dR("is_dynamic", str).dR("obj_location", this.mFromPage));
                return;
            } else {
                TiebaStatic.log(new ar(PageStayDurationConstants.URL_KEY).dR("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).v("obj_duration", currentTimeMillis).dR("obj_source", str2).dR("is_dynamic", str).dR("is_vertical", "1"));
                return;
            }
        }
        TiebaStatic.log(new ar(PageStayDurationConstants.URL_KEY).dR("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).v("obj_duration", currentTimeMillis).dR("is_dynamic", str).dR("obj_source", PageStayDurationConstants.PageName.SQUARE_RECOMMEND));
    }

    private void dVo() {
        this.nUK = new VideoPlayView(this, this.mFromPage);
        this.nUK.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void bWe() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.nUP != null) {
                            VideoPlayActivity.this.nUP.setFrom(VideoPlayActivity.this.mFromPage);
                            if (VideoPlayActivity.this.nUL.size() > 0) {
                                VideoPlayActivity.this.nUP.b((VideoItemData) VideoPlayActivity.this.nUL.get(0));
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
        this.nUK.a(this.nUL, this.mVideoIndex, this.mRect);
        this.nUK.US(this.mFrom);
        this.nUK.UV(this.eNE);
    }

    private void initData() {
        this.nUL = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.mVideoIndex = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra("page_from");
        this.mFromPage = getIntent().getStringExtra("from");
        this.nUM = getIntent().getStringExtra(VideoPlayActivityConfig.SOURCE_FROM);
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        this.nUN = getIntent().getBooleanExtra(VideoPlayActivityConfig.IS_FROM_BJH_PB, false);
        this.eTz = getIntent().getStringExtra("key_nid");
        if (y.isEmpty(this.nUL) && !y.isEmpty(VideoPlayActivityConfig.bigDataList)) {
            this.nUL = new ArrayList();
            this.nUL.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (y.isEmpty(this.nUL)) {
            l.showToast(this, R.string.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.nUP = new VideoPlayModel(this);
            this.nUP.setFrom(this.mFromPage);
            this.nUP.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void A(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!y.isEmpty(list) && !y.isEmpty(VideoPlayActivity.this.nUL)) {
                        VideoPlayActivity.this.F(VideoPlayActivity.this.nUL, list);
                        VideoPlayActivity.this.nUL.clear();
                        VideoPlayActivity.this.nUL.addAll(list);
                        if (VideoPlayActivity.this.nUK != null) {
                            VideoPlayActivity.this.nUK.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void B(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!y.isEmpty(list) && !y.isEmpty(VideoPlayActivity.this.nUL)) {
                        VideoPlayActivity.this.nUL.addAll(list);
                        if (VideoPlayActivity.this.nUK != null) {
                            VideoPlayActivity.this.nUK.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.nUL.get(0) != null) {
                this.eNE = this.nUL.get(0).thread_id;
            }
            this.nUP.setFrom(this.mFromPage);
            this.nUP.a(this.nUL.get(0), this.mStType, this.mLocate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(List<VideoItemData> list, List<VideoItemData> list2) {
        VideoItemData videoItemData = (VideoItemData) y.getItem(list, 0);
        VideoItemData videoItemData2 = (VideoItemData) y.getItem(list2, 0);
        if (videoItemData != null && videoItemData.author_info != null && videoItemData2 != null && videoItemData2.author_info != null && videoItemData2.author_info.user_id != null && videoItemData2.author_info.user_id.equals(videoItemData.author_info.user_id)) {
            videoItemData2.author_info.is_follow = videoItemData.author_info.is_follow;
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
            if (this.nUK == null || !this.nUK.dVC()) {
                if (this.nUK.nWb != this.nUK.nWa && this.nUK.nWa >= 0 && this.nUK.nWa < this.nUL.size() && (videoItemData = this.nUL.get(this.nUK.nWa)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.nUK != null) {
            this.nUK.c(i, i2, intent);
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
        VideoItemData videoItemData = (VideoItemData) y.getItem(this.nUL, this.mVideoIndex);
        if (videoItemData == null || TextUtils.isEmpty(videoItemData.thread_id)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(videoItemData.thread_id, 0L);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.VIDEO_LIST;
    }
}
