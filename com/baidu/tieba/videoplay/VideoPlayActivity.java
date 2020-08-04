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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.h;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String dOV;
    private String mFrom;
    private String mFromPage;
    private String mLocate;
    private String mNid;
    private Rect mRect;
    private String mStType;
    private VideoPlayView mmK;
    private List<VideoItemData> mmL;
    private int mmM;
    private String mmN;
    private boolean mmO;
    private VideoPlayModel mmQ;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener mmP = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_LIST) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!x.isEmpty(list)) {
                    if (VideoPlayActivity.this.mmL == null) {
                        VideoPlayActivity.this.mmL = new ArrayList();
                    }
                    VideoPlayActivity.this.mmL.clear();
                    VideoPlayActivity.this.mmL.addAll(list);
                }
                if (VideoPlayActivity.this.mmK != null) {
                    VideoPlayActivity.this.mmK.notifyDataSetChanged();
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
        registerListener(this.mmP);
        initData();
        dsV();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        cjO();
    }

    private void cjO() {
        ap apVar = new ap("c12664");
        if (TextUtils.isEmpty(this.mNid)) {
            apVar.dn("obj_type", "1");
        } else {
            apVar.dn("obj_type", "2");
            apVar.dn("obj_id", this.mNid);
        }
        TiebaStatic.log(apVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.aQc().p(b.dEE, getMissionTid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mmK != null) {
            this.mmK.onPause();
        }
        c.aQc().aQm();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.mmK != null) {
            this.mmK.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mmK != null) {
            this.mmK.onDestroy();
        }
        String str = TextUtils.isEmpty(this.mNid) ? "0" : "1";
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            if ("index".equals(this.mmN)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            } else if ("concern_tab".equals(this.mmN)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_CONCERN;
            } else if ("frs".equals(this.mmN)) {
                str2 = PageStayDurationConstants.PageName.FRS;
            } else if ("homepage".equals(this.mmN)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            }
            if (this.mmO) {
                TiebaStatic.log(new ap(PageStayDurationConstants.URL_KEY).dn("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).t("obj_duration", currentTimeMillis).dn("obj_source", str2).dn("is_vertical", "1").dn("is_dynamic", str).dn("obj_location", this.mFromPage));
                return;
            } else {
                TiebaStatic.log(new ap(PageStayDurationConstants.URL_KEY).dn("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).t("obj_duration", currentTimeMillis).dn("obj_source", str2).dn("is_dynamic", str).dn("is_vertical", "1"));
                return;
            }
        }
        TiebaStatic.log(new ap(PageStayDurationConstants.URL_KEY).dn("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).t("obj_duration", currentTimeMillis).dn("is_dynamic", str).dn("obj_source", PageStayDurationConstants.PageName.SQUARE_RECOMMEND));
    }

    private void dsV() {
        this.mmK = new VideoPlayView(this, this.mFromPage);
        this.mmK.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void bBi() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.mmQ != null) {
                            VideoPlayActivity.this.mmQ.setFrom(VideoPlayActivity.this.mFromPage);
                            if (VideoPlayActivity.this.mmL.size() > 0) {
                                VideoPlayActivity.this.mmQ.b((VideoItemData) VideoPlayActivity.this.mmL.get(0));
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
        this.mmK.a(this.mmL, this.mmM, this.mRect);
        this.mmK.Pk(this.mFrom);
        this.mmK.Pn(this.dOV);
    }

    private void initData() {
        this.mmL = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.mmM = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.mFromPage = getIntent().getStringExtra("from");
        this.mmN = getIntent().getStringExtra("source_from");
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        this.mmO = getIntent().getBooleanExtra(VideoPlayActivityConfig.IS_FROM_BJH_PB, false);
        this.mNid = getIntent().getStringExtra("key_nid");
        if (x.isEmpty(this.mmL) && !x.isEmpty(VideoPlayActivityConfig.bigDataList)) {
            this.mmL = new ArrayList();
            this.mmL.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (x.isEmpty(this.mmL)) {
            l.showToast(this, R.string.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.mmQ = new VideoPlayModel(this);
            this.mmQ.setFrom(this.mFromPage);
            this.mmQ.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void t(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!x.isEmpty(list) && !x.isEmpty(VideoPlayActivity.this.mmL)) {
                        VideoPlayActivity.this.mmL.clear();
                        VideoPlayActivity.this.mmL.addAll(list);
                        if (VideoPlayActivity.this.mmK != null) {
                            VideoPlayActivity.this.mmK.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void u(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!x.isEmpty(list) && !x.isEmpty(VideoPlayActivity.this.mmL)) {
                        VideoPlayActivity.this.mmL.addAll(list);
                        if (VideoPlayActivity.this.mmK != null) {
                            VideoPlayActivity.this.mmK.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.mmL.get(0) != null) {
                this.dOV = this.mmL.get(0).thread_id;
            }
            this.mmQ.setFrom(this.mFromPage);
            this.mmQ.a(this.mmL.get(0), this.mStType, this.mLocate);
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
            if (this.mmK == null || !this.mmK.dtj()) {
                if (this.mmK.mnV != this.mmK.mnU && this.mmK.mnU >= 0 && this.mmK.mnU < this.mmL.size() && (videoItemData = this.mmL.get(this.mmK.mnU)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.mmK != null) {
            this.mmK.c(i, i2, intent);
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
        VideoItemData videoItemData = (VideoItemData) x.getItem(this.mmL, this.mmM);
        if (videoItemData == null || TextUtils.isEmpty(videoItemData.thread_id)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(videoItemData.thread_id, 0L);
    }
}
