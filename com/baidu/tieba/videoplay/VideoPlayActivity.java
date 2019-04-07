package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.h;
import com.baidu.tieba.videoplay.VideoPlayModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    private String byD;
    private int cZw;
    private String dkx;
    private VideoPlayView jfm;
    private List<VideoItemData> jfn;
    private String jfo;
    private VideoPlayModel jfq;
    private String mFrom;
    private String mLocate;
    private Rect mRect;
    private String mStType;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener jfp = new CustomMessageListener(2921320) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!v.T(list)) {
                    if (VideoPlayActivity.this.jfn == null) {
                        VideoPlayActivity.this.jfn = new ArrayList();
                    }
                    VideoPlayActivity.this.jfn.clear();
                    VideoPlayActivity.this.jfn.addAll(list);
                }
                if (VideoPlayActivity.this.jfm != null) {
                    VideoPlayActivity.this.jfm.notifyDataSetChanged();
                }
                VideoPlayActivity.this.mHasMore = hVar.mHasMore;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        setContentView(d.h.video_play_activity);
        registerListener(this.jfp);
        initData();
        cmq();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jfm != null) {
            this.jfm.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.jfm != null) {
            this.jfm.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jfm != null) {
            this.jfm.onDestroy();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str = "a002";
            if ("index".equals(this.jfo)) {
                str = "a002";
            } else if ("concern_tab".equals(this.jfo)) {
                str = "a038";
            } else if ("frs".equals(this.jfo)) {
                str = "a006";
            } else if ("homepage".equals(this.jfo)) {
                str = "a002";
            }
            TiebaStatic.log(new am("stime").bJ("obj_type", "a023").k("obj_duration", currentTimeMillis).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).bJ("is_vertical", "1"));
            return;
        }
        TiebaStatic.log(new am("stime").bJ("obj_type", "a023").k("obj_duration", currentTimeMillis).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a020"));
    }

    private void cmq() {
        this.jfm = new VideoPlayView(this, this.dkx);
        this.jfm.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void cmr() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.jfq != null) {
                            VideoPlayActivity.this.jfq.setFrom(VideoPlayActivity.this.dkx);
                            VideoPlayActivity.this.jfq.aAZ();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921319));
                }
            }
        });
        this.jfm.a(this.jfn, this.cZw, this.mRect);
        this.jfm.DY(this.mFrom);
        this.jfm.Eb(this.byD);
    }

    private void initData() {
        this.jfn = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.cZw = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.dkx = getIntent().getStringExtra("from");
        this.jfo = getIntent().getStringExtra(VideoPlayActivityConfig.SOURCE_FROM);
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        if (v.T(this.jfn) && !v.T(VideoPlayActivityConfig.bigDataList)) {
            this.jfn = new ArrayList();
            this.jfn.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (v.T(this.jfn)) {
            l.showToast(this, d.j.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.jfq = new VideoPlayModel(this);
            this.jfq.setFrom(this.dkx);
            this.jfq.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void s(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.T(list) && !v.T(VideoPlayActivity.this.jfn)) {
                        VideoPlayActivity.this.jfn.clear();
                        VideoPlayActivity.this.jfn.addAll(list);
                        if (VideoPlayActivity.this.jfm != null) {
                            VideoPlayActivity.this.jfm.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void t(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.T(list) && !v.T(VideoPlayActivity.this.jfn)) {
                        VideoPlayActivity.this.jfn.addAll(list);
                        if (VideoPlayActivity.this.jfm != null) {
                            VideoPlayActivity.this.jfm.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.jfn.get(0) != null) {
                this.byD = this.jfn.get(0).thread_id;
            }
            this.jfq.setFrom(this.dkx);
            this.jfq.a(this.jfn.get(0), this.mStType, this.mLocate);
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
            if (this.jfm == null || !this.jfm.cmD()) {
                if (this.jfm.jgw != this.jfm.jgv && this.jfm.jgv >= 0 && this.jfm.jgv < this.jfn.size() && (videoItemData = this.jfn.get(this.jfm.jgv)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.jfm != null) {
            this.jfm.a(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (Build.VERSION.SDK_INT >= 16 && !z && getActivity() != null && getActivity().getWindow() != null && getActivity().getWindow().getDecorView() != null) {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(getActivity().getWindow().getDecorView().getSystemUiVisibility() | 4);
        }
    }
}
