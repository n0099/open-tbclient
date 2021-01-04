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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.g;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String eQd;
    private String eVY;
    private String mFrom;
    private String mFromPage;
    private String mLocate;
    private Rect mRect;
    private String mStType;
    private VideoPlayView nPi;
    private List<VideoItemData> nPj;
    private int nPk;
    private String nPl;
    private boolean nPm;
    private VideoPlayModel nPo;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener nPn = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_LIST) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                g gVar = (g) customResponsedMessage.getData();
                List<VideoItemData> list = gVar.mVideoItemDatas;
                if (!x.isEmpty(list)) {
                    if (VideoPlayActivity.this.nPj == null) {
                        VideoPlayActivity.this.nPj = new ArrayList();
                    }
                    VideoPlayActivity.this.nPj.clear();
                    VideoPlayActivity.this.nPj.addAll(list);
                }
                if (VideoPlayActivity.this.nPi != null) {
                    VideoPlayActivity.this.nPi.notifyDataSetChanged();
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
        registerListener(this.nPn);
        initData();
        dWM();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        cOP();
    }

    private void cOP() {
        aq aqVar = new aq("c12664");
        if (TextUtils.isEmpty(this.eVY)) {
            aqVar.dX("obj_type", "1");
        } else {
            aqVar.dX("obj_type", "2");
            aqVar.dX("obj_id", this.eVY);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.bkT().p(b.eES, getMissionTid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nPi != null) {
            this.nPi.onPause();
        }
        c.bkT().ble();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.nPi != null) {
            this.nPi.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nPi != null) {
            this.nPi.onDestroy();
        }
        String str = TextUtils.isEmpty(this.eVY) ? "0" : "1";
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            if ("index".equals(this.nPl)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            } else if ("concern_tab".equals(this.nPl)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_CONCERN;
            } else if ("frs".equals(this.nPl)) {
                str2 = PageStayDurationConstants.PageName.FRS;
            } else if ("homepage".equals(this.nPl)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            }
            if (this.nPm) {
                TiebaStatic.log(new aq(PageStayDurationConstants.URL_KEY).dX("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).w("obj_duration", currentTimeMillis).dX("obj_source", str2).dX("is_vertical", "1").dX("is_dynamic", str).dX("obj_location", this.mFromPage));
                return;
            } else {
                TiebaStatic.log(new aq(PageStayDurationConstants.URL_KEY).dX("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).w("obj_duration", currentTimeMillis).dX("obj_source", str2).dX("is_dynamic", str).dX("is_vertical", "1"));
                return;
            }
        }
        TiebaStatic.log(new aq(PageStayDurationConstants.URL_KEY).dX("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).w("obj_duration", currentTimeMillis).dX("is_dynamic", str).dX("obj_source", PageStayDurationConstants.PageName.SQUARE_RECOMMEND));
    }

    private void dWM() {
        this.nPi = new VideoPlayView(this, this.mFromPage);
        this.nPi.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void bZk() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.nPo != null) {
                            VideoPlayActivity.this.nPo.setFrom(VideoPlayActivity.this.mFromPage);
                            if (VideoPlayActivity.this.nPj.size() > 0) {
                                VideoPlayActivity.this.nPo.b((VideoItemData) VideoPlayActivity.this.nPj.get(0));
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
        this.nPi.a(this.nPj, this.nPk, this.mRect);
        this.nPi.UR(this.mFrom);
        this.nPi.UU(this.eQd);
    }

    private void initData() {
        this.nPj = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.nPk = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra("page_from");
        this.mFromPage = getIntent().getStringExtra("from");
        this.nPl = getIntent().getStringExtra(VideoPlayActivityConfig.SOURCE_FROM);
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        this.nPm = getIntent().getBooleanExtra(VideoPlayActivityConfig.IS_FROM_BJH_PB, false);
        this.eVY = getIntent().getStringExtra("key_nid");
        if (x.isEmpty(this.nPj) && !x.isEmpty(VideoPlayActivityConfig.bigDataList)) {
            this.nPj = new ArrayList();
            this.nPj.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (x.isEmpty(this.nPj)) {
            l.showToast(this, R.string.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.nPo = new VideoPlayModel(this);
            this.nPo.setFrom(this.mFromPage);
            this.nPo.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void y(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!x.isEmpty(list) && !x.isEmpty(VideoPlayActivity.this.nPj)) {
                        VideoPlayActivity.this.G(VideoPlayActivity.this.nPj, list);
                        VideoPlayActivity.this.nPj.clear();
                        VideoPlayActivity.this.nPj.addAll(list);
                        if (VideoPlayActivity.this.nPi != null) {
                            VideoPlayActivity.this.nPi.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void z(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!x.isEmpty(list) && !x.isEmpty(VideoPlayActivity.this.nPj)) {
                        VideoPlayActivity.this.nPj.addAll(list);
                        if (VideoPlayActivity.this.nPi != null) {
                            VideoPlayActivity.this.nPi.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.nPj.get(0) != null) {
                this.eQd = this.nPj.get(0).thread_id;
            }
            this.nPo.setFrom(this.mFromPage);
            this.nPo.a(this.nPj.get(0), this.mStType, this.mLocate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(List<VideoItemData> list, List<VideoItemData> list2) {
        VideoItemData videoItemData = (VideoItemData) x.getItem(list, 0);
        VideoItemData videoItemData2 = (VideoItemData) x.getItem(list2, 0);
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
            if (this.nPi == null || !this.nPi.dXa()) {
                if (this.nPi.nQt != this.nPi.nQs && this.nPi.nQs >= 0 && this.nPi.nQs < this.nPj.size() && (videoItemData = this.nPj.get(this.nPi.nQs)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.nPi != null) {
            this.nPi.c(i, i2, intent);
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
        VideoItemData videoItemData = (VideoItemData) x.getItem(this.nPj, this.nPk);
        if (videoItemData == null || TextUtils.isEmpty(videoItemData.thread_id)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(videoItemData.thread_id, 0L);
    }
}
