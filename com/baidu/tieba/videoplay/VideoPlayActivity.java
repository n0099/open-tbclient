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
    private String bHq;
    private int dnG;
    private String dzf;
    private VideoPlayView jHX;
    private List<VideoItemData> jHY;
    private String jHZ;
    private VideoPlayModel jIb;
    private String mFrom;
    private String mLocate;
    private Rect mRect;
    private String mStType;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener jIa = new CustomMessageListener(2921320) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!v.aa(list)) {
                    if (VideoPlayActivity.this.jHY == null) {
                        VideoPlayActivity.this.jHY = new ArrayList();
                    }
                    VideoPlayActivity.this.jHY.clear();
                    VideoPlayActivity.this.jHY.addAll(list);
                }
                if (VideoPlayActivity.this.jHX != null) {
                    VideoPlayActivity.this.jHX.notifyDataSetChanged();
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
        registerListener(this.jIa);
        initData();
        cyt();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.Zk().k(b.bys, getMissionTid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jHX != null) {
            this.jHX.onPause();
        }
        c.Zk().Zp();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.jHX != null) {
            this.jHX.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jHX != null) {
            this.jHX.onDestroy();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str = "a002";
            if ("index".equals(this.jHZ)) {
                str = "a002";
            } else if ("concern_tab".equals(this.jHZ)) {
                str = "a038";
            } else if ("frs".equals(this.jHZ)) {
                str = "a006";
            } else if ("homepage".equals(this.jHZ)) {
                str = "a002";
            }
            TiebaStatic.log(new an("stime").bT("obj_type", "a023").n("obj_duration", currentTimeMillis).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).bT("is_vertical", "1"));
            return;
        }
        TiebaStatic.log(new an("stime").bT("obj_type", "a023").n("obj_duration", currentTimeMillis).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a020"));
    }

    private void cyt() {
        this.jHX = new VideoPlayView(this, this.dzf);
        this.jHX.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void cyu() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.jIb != null) {
                            VideoPlayActivity.this.jIb.setFrom(VideoPlayActivity.this.dzf);
                            VideoPlayActivity.this.jIb.aJw();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921319));
                }
            }
        });
        this.jHX.a(this.jHY, this.dnG, this.mRect);
        this.jHX.GM(this.mFrom);
        this.jHX.GP(this.bHq);
    }

    private void initData() {
        this.jHY = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.dnG = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.dzf = getIntent().getStringExtra("from");
        this.jHZ = getIntent().getStringExtra(VideoPlayActivityConfig.SOURCE_FROM);
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        if (v.aa(this.jHY) && !v.aa(VideoPlayActivityConfig.bigDataList)) {
            this.jHY = new ArrayList();
            this.jHY.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (v.aa(this.jHY)) {
            l.showToast(this, (int) R.string.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.jIb = new VideoPlayModel(this);
            this.jIb.setFrom(this.dzf);
            this.jIb.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void t(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.aa(list) && !v.aa(VideoPlayActivity.this.jHY)) {
                        VideoPlayActivity.this.jHY.clear();
                        VideoPlayActivity.this.jHY.addAll(list);
                        if (VideoPlayActivity.this.jHX != null) {
                            VideoPlayActivity.this.jHX.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void u(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.aa(list) && !v.aa(VideoPlayActivity.this.jHY)) {
                        VideoPlayActivity.this.jHY.addAll(list);
                        if (VideoPlayActivity.this.jHX != null) {
                            VideoPlayActivity.this.jHX.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.jHY.get(0) != null) {
                this.bHq = this.jHY.get(0).thread_id;
            }
            this.jIb.setFrom(this.dzf);
            this.jIb.a(this.jHY.get(0), this.mStType, this.mLocate);
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
            if (this.jHX == null || !this.jHX.cyG()) {
                if (this.jHX.jJg != this.jHX.jJf && this.jHX.jJf >= 0 && this.jHX.jJf < this.jHY.size() && (videoItemData = this.jHY.get(this.jHX.jJf)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.jHX != null) {
            this.jHX.a(i, i2, intent);
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
        VideoItemData videoItemData = (VideoItemData) v.c(this.jHY, this.dnG);
        if (videoItemData == null || TextUtils.isEmpty(videoItemData.thread_id)) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.e(videoItemData.thread_id, 0L);
    }
}
