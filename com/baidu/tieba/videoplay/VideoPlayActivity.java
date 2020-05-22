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
    private String dCp;
    private VideoPlayView lKq;
    private List<VideoItemData> lKr;
    private int lKs;
    private String lKt;
    private boolean lKu;
    private VideoPlayModel lKw;
    private String mFrom;
    private String mFromPage;
    private String mLocate;
    private String mNid;
    private Rect mRect;
    private String mStType;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener lKv = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_LIST) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!v.isEmpty(list)) {
                    if (VideoPlayActivity.this.lKr == null) {
                        VideoPlayActivity.this.lKr = new ArrayList();
                    }
                    VideoPlayActivity.this.lKr.clear();
                    VideoPlayActivity.this.lKr.addAll(list);
                }
                if (VideoPlayActivity.this.lKq != null) {
                    VideoPlayActivity.this.lKq.notifyDataSetChanged();
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
        registerListener(this.lKv);
        initData();
        dlh();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        ccN();
    }

    private void ccN() {
        an anVar = new an("c12664");
        if (TextUtils.isEmpty(this.mNid)) {
            anVar.dh("obj_type", "1");
        } else {
            anVar.dh("obj_type", "2");
            anVar.dh("obj_id", this.mNid);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.aLi().o(b.dtZ, getMissionTid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.lKq != null) {
            this.lKq.onPause();
        }
        c.aLi().aLn();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.lKq != null) {
            this.lKq.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lKq != null) {
            this.lKq.onDestroy();
        }
        String str = TextUtils.isEmpty(this.mNid) ? "0" : "1";
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            if ("index".equals(this.lKt)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            } else if ("concern_tab".equals(this.lKt)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_CONCERN;
            } else if ("frs".equals(this.lKt)) {
                str2 = PageStayDurationConstants.PageName.FRS;
            } else if ("homepage".equals(this.lKt)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            }
            if (this.lKu) {
                TiebaStatic.log(new an(PageStayDurationConstants.URL_KEY).dh("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).s("obj_duration", currentTimeMillis).dh("obj_source", str2).dh("is_vertical", "1").dh("is_dynamic", str).dh("obj_location", this.mFromPage));
                return;
            } else {
                TiebaStatic.log(new an(PageStayDurationConstants.URL_KEY).dh("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).s("obj_duration", currentTimeMillis).dh("obj_source", str2).dh("is_dynamic", str).dh("is_vertical", "1"));
                return;
            }
        }
        TiebaStatic.log(new an(PageStayDurationConstants.URL_KEY).dh("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).s("obj_duration", currentTimeMillis).dh("is_dynamic", str).dh("obj_source", PageStayDurationConstants.PageName.SQUARE_RECOMMEND));
    }

    private void dlh() {
        this.lKq = new VideoPlayView(this, this.mFromPage);
        this.lKq.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void buV() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.lKw != null) {
                            VideoPlayActivity.this.lKw.setFrom(VideoPlayActivity.this.mFromPage);
                            if (VideoPlayActivity.this.lKr.size() > 0) {
                                VideoPlayActivity.this.lKw.b((VideoItemData) VideoPlayActivity.this.lKr.get(0));
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
        this.lKq.a(this.lKr, this.lKs, this.mRect);
        this.lKq.NY(this.mFrom);
        this.lKq.Ob(this.dCp);
    }

    private void initData() {
        this.lKr = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.lKs = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = getIntent().getStringExtra("from");
        this.lKt = getIntent().getStringExtra("source_from");
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        this.lKu = getIntent().getBooleanExtra(VideoPlayActivityConfig.IS_FROM_BJH_PB, false);
        this.mNid = getIntent().getStringExtra("key_nid");
        if (v.isEmpty(this.lKr) && !v.isEmpty(VideoPlayActivityConfig.bigDataList)) {
            this.lKr = new ArrayList();
            this.lKr.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (v.isEmpty(this.lKr)) {
            l.showToast(this, (int) R.string.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.lKw = new VideoPlayModel(this);
            this.lKw.setFrom(this.mFromPage);
            this.lKw.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void v(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.isEmpty(list) && !v.isEmpty(VideoPlayActivity.this.lKr)) {
                        VideoPlayActivity.this.lKr.clear();
                        VideoPlayActivity.this.lKr.addAll(list);
                        if (VideoPlayActivity.this.lKq != null) {
                            VideoPlayActivity.this.lKq.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void w(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.isEmpty(list) && !v.isEmpty(VideoPlayActivity.this.lKr)) {
                        VideoPlayActivity.this.lKr.addAll(list);
                        if (VideoPlayActivity.this.lKq != null) {
                            VideoPlayActivity.this.lKq.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.lKr.get(0) != null) {
                this.dCp = this.lKr.get(0).thread_id;
            }
            this.lKw.setFrom(this.mFromPage);
            this.lKw.a(this.lKr.get(0), this.mStType, this.mLocate);
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
            if (this.lKq == null || !this.lKq.dlu()) {
                if (this.lKq.lLC != this.lKq.lLB && this.lKq.lLB >= 0 && this.lKq.lLB < this.lKr.size() && (videoItemData = this.lKr.get(this.lKq.lLB)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.lKq != null) {
            this.lKq.c(i, i2, intent);
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
        VideoItemData videoItemData = (VideoItemData) v.getItem(this.lKr, this.lKs);
        if (videoItemData == null || TextUtils.isEmpty(videoItemData.thread_id)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(videoItemData.thread_id, 0L);
    }
}
