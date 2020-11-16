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
import com.baidu.tieba.video.h;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String ezo;
    private String mFrom;
    private String mFromPage;
    private String mLocate;
    private String mNid;
    private Rect mRect;
    private String mStType;
    private VideoPlayView nxK;
    private List<VideoItemData> nxL;
    private int nxM;
    private String nxN;
    private boolean nxO;
    private VideoPlayModel nxQ;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener nxP = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_LIST) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!y.isEmpty(list)) {
                    if (VideoPlayActivity.this.nxL == null) {
                        VideoPlayActivity.this.nxL = new ArrayList();
                    }
                    VideoPlayActivity.this.nxL.clear();
                    VideoPlayActivity.this.nxL.addAll(list);
                }
                if (VideoPlayActivity.this.nxK != null) {
                    VideoPlayActivity.this.nxK.notifyDataSetChanged();
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
        registerListener(this.nxP);
        initData();
        dRO();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        cGw();
    }

    private void cGw() {
        ar arVar = new ar("c12664");
        if (TextUtils.isEmpty(this.mNid)) {
            arVar.dR("obj_type", "1");
        } else {
            arVar.dR("obj_type", "2");
            arVar.dR("obj_id", this.mNid);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.bfy().p(b.eoD, getMissionTid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nxK != null) {
            this.nxK.onPause();
        }
        c.bfy().bfJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.nxK != null) {
            this.nxK.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nxK != null) {
            this.nxK.onDestroy();
        }
        String str = TextUtils.isEmpty(this.mNid) ? "0" : "1";
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            if ("index".equals(this.nxN)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            } else if ("concern_tab".equals(this.nxN)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_CONCERN;
            } else if ("frs".equals(this.nxN)) {
                str2 = PageStayDurationConstants.PageName.FRS;
            } else if ("homepage".equals(this.nxN)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            }
            if (this.nxO) {
                TiebaStatic.log(new ar(PageStayDurationConstants.URL_KEY).dR("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).w("obj_duration", currentTimeMillis).dR("obj_source", str2).dR("is_vertical", "1").dR("is_dynamic", str).dR("obj_location", this.mFromPage));
                return;
            } else {
                TiebaStatic.log(new ar(PageStayDurationConstants.URL_KEY).dR("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).w("obj_duration", currentTimeMillis).dR("obj_source", str2).dR("is_dynamic", str).dR("is_vertical", "1"));
                return;
            }
        }
        TiebaStatic.log(new ar(PageStayDurationConstants.URL_KEY).dR("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).w("obj_duration", currentTimeMillis).dR("is_dynamic", str).dR("obj_source", PageStayDurationConstants.PageName.SQUARE_RECOMMEND));
    }

    private void dRO() {
        this.nxK = new VideoPlayView(this, this.mFromPage);
        this.nxK.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void bSU() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.nxQ != null) {
                            VideoPlayActivity.this.nxQ.setFrom(VideoPlayActivity.this.mFromPage);
                            if (VideoPlayActivity.this.nxL.size() > 0) {
                                VideoPlayActivity.this.nxQ.b((VideoItemData) VideoPlayActivity.this.nxL.get(0));
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
        this.nxK.a(this.nxL, this.nxM, this.mRect);
        this.nxK.TX(this.mFrom);
        this.nxK.Ua(this.ezo);
    }

    private void initData() {
        this.nxL = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.nxM = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra("page_from");
        this.mFromPage = getIntent().getStringExtra("from");
        this.nxN = getIntent().getStringExtra("source_from");
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        this.nxO = getIntent().getBooleanExtra(VideoPlayActivityConfig.IS_FROM_BJH_PB, false);
        this.mNid = getIntent().getStringExtra("key_nid");
        if (y.isEmpty(this.nxL) && !y.isEmpty(VideoPlayActivityConfig.bigDataList)) {
            this.nxL = new ArrayList();
            this.nxL.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (y.isEmpty(this.nxL)) {
            l.showToast(this, R.string.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.nxQ = new VideoPlayModel(this);
            this.nxQ.setFrom(this.mFromPage);
            this.nxQ.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void v(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!y.isEmpty(list) && !y.isEmpty(VideoPlayActivity.this.nxL)) {
                        VideoPlayActivity.this.nxL.clear();
                        VideoPlayActivity.this.nxL.addAll(list);
                        if (VideoPlayActivity.this.nxK != null) {
                            VideoPlayActivity.this.nxK.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void w(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!y.isEmpty(list) && !y.isEmpty(VideoPlayActivity.this.nxL)) {
                        VideoPlayActivity.this.nxL.addAll(list);
                        if (VideoPlayActivity.this.nxK != null) {
                            VideoPlayActivity.this.nxK.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.nxL.get(0) != null) {
                this.ezo = this.nxL.get(0).thread_id;
            }
            this.nxQ.setFrom(this.mFromPage);
            this.nxQ.a(this.nxL.get(0), this.mStType, this.mLocate);
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
            if (this.nxK == null || !this.nxK.dSc()) {
                if (this.nxK.nyV != this.nxK.nyU && this.nxK.nyU >= 0 && this.nxK.nyU < this.nxL.size() && (videoItemData = this.nxL.get(this.nxK.nyU)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.nxK != null) {
            this.nxK.c(i, i2, intent);
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
        VideoItemData videoItemData = (VideoItemData) y.getItem(this.nxL, this.nxM);
        if (videoItemData == null || TextUtils.isEmpty(videoItemData.thread_id)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(videoItemData.thread_id, 0L);
    }
}
