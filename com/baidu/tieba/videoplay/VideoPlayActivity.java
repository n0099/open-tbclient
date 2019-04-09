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
    private String byE;
    private int cZx;
    private String dky;
    private VideoPlayView jfn;
    private List<VideoItemData> jfo;
    private String jfp;
    private VideoPlayModel jfr;
    private String mFrom;
    private String mLocate;
    private Rect mRect;
    private String mStType;
    private boolean mHasMore = true;
    private long mStartTime = 0;
    private CustomMessageListener jfq = new CustomMessageListener(2921320) { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                List<VideoItemData> list = hVar.mVideoItemDatas;
                if (!v.T(list)) {
                    if (VideoPlayActivity.this.jfo == null) {
                        VideoPlayActivity.this.jfo = new ArrayList();
                    }
                    VideoPlayActivity.this.jfo.clear();
                    VideoPlayActivity.this.jfo.addAll(list);
                }
                if (VideoPlayActivity.this.jfn != null) {
                    VideoPlayActivity.this.jfn.notifyDataSetChanged();
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
        registerListener(this.jfq);
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
        if (this.jfn != null) {
            this.jfn.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.jfn != null) {
            this.jfn.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jfn != null) {
            this.jfn.onDestroy();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str = "a002";
            if ("index".equals(this.jfp)) {
                str = "a002";
            } else if ("concern_tab".equals(this.jfp)) {
                str = "a038";
            } else if ("frs".equals(this.jfp)) {
                str = "a006";
            } else if ("homepage".equals(this.jfp)) {
                str = "a002";
            }
            TiebaStatic.log(new am("stime").bJ("obj_type", "a023").k("obj_duration", currentTimeMillis).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str).bJ("is_vertical", "1"));
            return;
        }
        TiebaStatic.log(new am("stime").bJ("obj_type", "a023").k("obj_duration", currentTimeMillis).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a020"));
    }

    private void cmq() {
        this.jfn = new VideoPlayView(this, this.dky);
        this.jfn.a(new VideoPlayView.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.2
            @Override // com.baidu.tieba.videoplay.VideoPlayView.a
            public void cmr() {
                if (VideoPlayActivity.this.mHasMore) {
                    if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(VideoPlayActivity.this.mFrom)) {
                        if (VideoPlayActivity.this.jfr != null) {
                            VideoPlayActivity.this.jfr.setFrom(VideoPlayActivity.this.dky);
                            VideoPlayActivity.this.jfr.aAZ();
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921319));
                }
            }
        });
        this.jfn.a(this.jfo, this.cZx, this.mRect);
        this.jfn.DY(this.mFrom);
        this.jfn.Eb(this.byE);
    }

    private void initData() {
        this.jfo = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.cZx = getIntent().getIntExtra(VideoPlayActivityConfig.VIDEO_INDEX, 0);
        this.mRect = getIntent().getSourceBounds();
        this.mFrom = getIntent().getStringExtra(VideoPlayActivityConfig.PAGE_FROM);
        this.dky = getIntent().getStringExtra("from");
        this.jfp = getIntent().getStringExtra(VideoPlayActivityConfig.SOURCE_FROM);
        this.mStType = getIntent().getStringExtra("st_type");
        this.mLocate = getIntent().getStringExtra("yuelaou_locate");
        if (v.T(this.jfo) && !v.T(VideoPlayActivityConfig.bigDataList)) {
            this.jfo = new ArrayList();
            this.jfo.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (v.T(this.jfo)) {
            l.showToast(this, d.j.net_error);
            finish();
        } else if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            this.jfr = new VideoPlayModel(this);
            this.jfr.setFrom(this.dky);
            this.jfr.a(new VideoPlayModel.a() { // from class: com.baidu.tieba.videoplay.VideoPlayActivity.3
                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void s(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.T(list) && !v.T(VideoPlayActivity.this.jfo)) {
                        VideoPlayActivity.this.jfo.clear();
                        VideoPlayActivity.this.jfo.addAll(list);
                        if (VideoPlayActivity.this.jfn != null) {
                            VideoPlayActivity.this.jfn.notifyDataSetChanged();
                        }
                    }
                }

                @Override // com.baidu.tieba.videoplay.VideoPlayModel.a
                public void t(List<VideoItemData> list, boolean z) {
                    VideoPlayActivity.this.mHasMore = z;
                    if (!v.T(list) && !v.T(VideoPlayActivity.this.jfo)) {
                        VideoPlayActivity.this.jfo.addAll(list);
                        if (VideoPlayActivity.this.jfn != null) {
                            VideoPlayActivity.this.jfn.notifyDataSetChanged();
                        }
                    }
                }
            });
            if (this.jfo.get(0) != null) {
                this.byE = this.jfo.get(0).thread_id;
            }
            this.jfr.setFrom(this.dky);
            this.jfr.a(this.jfo.get(0), this.mStType, this.mLocate);
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
            if (this.jfn == null || !this.jfn.cmD()) {
                if (this.jfn.jgx != this.jfn.jgw && this.jfn.jgw >= 0 && this.jfn.jgw < this.jfo.size() && (videoItemData = this.jfo.get(this.jfn.jgw)) != null && !StringUtils.isNull(videoItemData.thread_id)) {
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
        if (this.jfn != null) {
            this.jfn.a(i, i2, intent);
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
