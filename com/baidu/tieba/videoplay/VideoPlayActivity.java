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
/* loaded from: classes24.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String eGn;
    private String mFrom;
    private String mFromPage;
    private String mLocate;
    private String mNid;
    private Rect mRect;
    private String mStType;
    private VideoPlayView nLN;
    private List<VideoItemData> nLO;
    private int nLP;
    private String nLQ;
    private boolean nLR;
    private VideoPlayModel nLT;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener nLS = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_SQUARE_VIDEO_LIST) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!y.isEmpty(list)) {
                    if (VideoPlayActivity.this.nLO == null) {
                        VideoPlayActivity.this.nLO = new ArrayList();
                    }
                    VideoPlayActivity.this.nLO.clear();
                    VideoPlayActivity.this.nLO.addAll(list);
                }
                if (VideoPlayActivity.this.nLN != null) {
                    VideoPlayActivity.this.nLN.notifyDataSetChanged();
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
        registerListener(this.nLS);
        initData();
        dXj();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        cLM();
    }

    private void cLM() {
        ar arVar = new ar("c12664");
        if (TextUtils.isEmpty(this.mNid)) {
            arVar.dY("obj_type", "1");
        } else {
            arVar.dY("obj_type", "2");
            arVar.dY("obj_id", this.mNid);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.biD().p(b.evC, getMissionTid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nLN != null) {
            this.nLN.onPause();
        }
        c.biD().biO();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.nLN != null) {
            this.nLN.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nLN != null) {
            this.nLN.onDestroy();
        }
        String str = TextUtils.isEmpty(this.mNid) ? "0" : "1";
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            if ("index".equals(this.nLQ)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            } else if ("concern_tab".equals(this.nLQ)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_CONCERN;
            } else if ("frs".equals(this.nLQ)) {
                str2 = PageStayDurationConstants.PageName.FRS;
            } else if ("homepage".equals(this.nLQ)) {
                str2 = PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE;
            }
            if (this.nLR) {
                TiebaStatic.log(new ar(PageStayDurationConstants.URL_KEY).dY("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).w("obj_duration", currentTimeMillis).dY("obj_source", str2).dY("is_vertical", "1").dY("is_dynamic", str).dY("obj_location", this.mFromPage));
                return;
            } else {
                TiebaStatic.log(new ar(PageStayDurationConstants.URL_KEY).dY("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).w("obj_duration", currentTimeMillis).dY("obj_source", str2).dY("is_dynamic", str).dY("is_vertical", "1"));
                return;
            }
        }
        TiebaStatic.log(new ar(PageStayDurationConstants.URL_KEY).dY("obj_type", PageStayDurationConstants.PageName.VIDEO_LIST).w("obj_duration", currentTimeMillis).dY("is_dynamic", str).dY("obj_source", PageStayDurationConstants.PageName.SQUARE_RECOMMEND));
    }

    private void dXj() {
        this.nLN = new VideoPlayView(this, this.mFromPage);
        this.nLN.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void bWF() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.nLT != null) {
                            VideoPlayActivity.this.nLT.setFrom(VideoPlayActivity.this.mFromPage);
                            if (VideoPlayActivity.this.nLO.size() > 0) {
                                VideoPlayActivity.this.nLT.b((VideoItemData) VideoPlayActivity.this.nLO.get(0));
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
        this.nLN.a(this.nLO, this.nLP, this.mRect);
        this.nLN.Vm(this.mFrom);
        this.nLN.Vp(this.eGn);
    }

    private void initData() {
        this.nLO = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.nLP = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra("page_from");
        this.mFromPage = getIntent().getStringExtra("from");
        this.nLQ = getIntent().getStringExtra("source_from");
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        this.nLR = getIntent().getBooleanExtra(VideoPlayActivityConfig.IS_FROM_BJH_PB, false);
        this.mNid = getIntent().getStringExtra("key_nid");
        if (y.isEmpty(this.nLO) && !y.isEmpty(VideoPlayActivityConfig.bigDataList)) {
            this.nLO = new ArrayList();
            this.nLO.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (y.isEmpty(this.nLO)) {
            l.showToast(this, R.string.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.nLT = new VideoPlayModel(this);
            this.nLT.setFrom(this.mFromPage);
            this.nLT.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void x(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!y.isEmpty(list) && !y.isEmpty(VideoPlayActivity.this.nLO)) {
                        VideoPlayActivity.this.D(VideoPlayActivity.this.nLO, list);
                        VideoPlayActivity.this.nLO.clear();
                        VideoPlayActivity.this.nLO.addAll(list);
                        if (VideoPlayActivity.this.nLN != null) {
                            VideoPlayActivity.this.nLN.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void y(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!y.isEmpty(list) && !y.isEmpty(VideoPlayActivity.this.nLO)) {
                        VideoPlayActivity.this.nLO.addAll(list);
                        if (VideoPlayActivity.this.nLN != null) {
                            VideoPlayActivity.this.nLN.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.nLO.get(0) != null) {
                this.eGn = this.nLO.get(0).thread_id;
            }
            this.nLT.setFrom(this.mFromPage);
            this.nLT.a(this.nLO.get(0), this.mStType, this.mLocate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(List<VideoItemData> list, List<VideoItemData> list2) {
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
            if (this.nLN == null || !this.nLN.dXx()) {
                if (this.nLN.nMY != this.nLN.nMX && this.nLN.nMX >= 0 && this.nLN.nMX < this.nLO.size() && (videoItemData = this.nLO.get(this.nLN.nMX)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.nLN != null) {
            this.nLN.c(i, i2, intent);
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
        VideoItemData videoItemData = (VideoItemData) y.getItem(this.nLO, this.nLP);
        if (videoItemData == null || TextUtils.isEmpty(videoItemData.thread_id)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(videoItemData.thread_id, 0L);
    }
}
