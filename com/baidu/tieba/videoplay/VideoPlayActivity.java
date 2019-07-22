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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.b;
import com.baidu.tbadk.BdToken.c;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
    private String bGR;
    private int dlN;
    private String dxn;
    private VideoPlayView jEu;
    private List<VideoItemData> jEv;
    private String jEw;
    private VideoPlayModel jEy;
    private String mFrom;
    private String mLocate;
    private Rect mRect;
    private String mStType;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener jEx = new CustomMessageListener(2921320) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!v.aa(list)) {
                    if (VideoPlayActivity.this.jEv == null) {
                        VideoPlayActivity.this.jEv = new ArrayList();
                    }
                    VideoPlayActivity.this.jEv.clear();
                    VideoPlayActivity.this.jEv.addAll(list);
                }
                if (VideoPlayActivity.this.jEu != null) {
                    VideoPlayActivity.this.jEu.notifyDataSetChanged();
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
        registerListener(this.jEx);
        initData();
        cxj();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.Zg().k(b.bxU, getMissionTid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jEu != null) {
            this.jEu.onPause();
        }
        c.Zg().Zl();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.jEu != null) {
            this.jEu.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jEu != null) {
            this.jEu.onDestroy();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str = "a002";
            if ("index".equals(this.jEw)) {
                str = "a002";
            } else if ("concern_tab".equals(this.jEw)) {
                str = "a038";
            } else if ("frs".equals(this.jEw)) {
                str = "a006";
            } else if ("homepage".equals(this.jEw)) {
                str = "a002";
            }
            TiebaStatic.log(new an("stime").bT("obj_type", "a023").l("obj_duration", currentTimeMillis).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).bT("is_vertical", "1"));
            return;
        }
        TiebaStatic.log(new an("stime").bT("obj_type", "a023").l("obj_duration", currentTimeMillis).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a020"));
    }

    private void cxj() {
        this.jEu = new VideoPlayView(this, this.dxn);
        this.jEu.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void cxk() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.jEy != null) {
                            VideoPlayActivity.this.jEy.setFrom(VideoPlayActivity.this.dxn);
                            VideoPlayActivity.this.jEy.aIQ();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921319));
                }
            }
        });
        this.jEu.a(this.jEv, this.dlN, this.mRect);
        this.jEu.Gl(this.mFrom);
        this.jEu.Go(this.bGR);
    }

    private void initData() {
        this.jEv = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.dlN = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.dxn = getIntent().getStringExtra("from");
        this.jEw = getIntent().getStringExtra(VideoPlayActivityConfig.SOURCE_FROM);
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        if (v.aa(this.jEv) && !v.aa(VideoPlayActivityConfig.bigDataList)) {
            this.jEv = new ArrayList();
            this.jEv.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (v.aa(this.jEv)) {
            l.showToast(this, (int) R.string.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.jEy = new VideoPlayModel(this);
            this.jEy.setFrom(this.dxn);
            this.jEy.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void t(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.aa(list) && !v.aa(VideoPlayActivity.this.jEv)) {
                        VideoPlayActivity.this.jEv.clear();
                        VideoPlayActivity.this.jEv.addAll(list);
                        if (VideoPlayActivity.this.jEu != null) {
                            VideoPlayActivity.this.jEu.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void u(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.aa(list) && !v.aa(VideoPlayActivity.this.jEv)) {
                        VideoPlayActivity.this.jEv.addAll(list);
                        if (VideoPlayActivity.this.jEu != null) {
                            VideoPlayActivity.this.jEu.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.jEv.get(0) != null) {
                this.bGR = this.jEv.get(0).thread_id;
            }
            this.jEy.setFrom(this.dxn);
            this.jEy.a(this.jEv.get(0), this.mStType, this.mLocate);
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
            if (this.jEu == null || !this.jEu.cxw()) {
                if (this.jEu.jFE != this.jEu.jFD && this.jEu.jFD >= 0 && this.jEu.jFD < this.jEv.size() && (videoItemData = this.jEv.get(this.jEu.jFD)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, videoItemData.thread_id));
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
        if (this.jEu != null) {
            this.jEu.a(i, i2, intent);
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
        VideoItemData videoItemData = (VideoItemData) v.c(this.jEv, this.dlN);
        if (videoItemData == null || TextUtils.isEmpty(videoItemData.thread_id)) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(videoItemData.thread_id, 0L);
    }
}
