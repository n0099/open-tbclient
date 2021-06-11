package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.fragment.VideoVerticalPageFragment;
import d.a.c.a.b;
import d.a.c.e.p.l;
import d.a.m0.a.c;
import d.a.m0.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPlayActivity extends BaseFragmentActivity {
    public static final String FROM_VIDEO_PLAY = "nani_midpage";
    public boolean isFromBjhPb;
    public VideoVerticalPageFragment mFragment;
    public String mFrom;
    public String mFromPage;
    public String mNid;
    public String mSourceFrom;
    public List<VideoItemData> mVideoDataList;
    public long mStartTime = 0;
    public boolean mIsFromSchema = false;

    private void doEnterStatistic() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ENTER_VIDEO_PAGE);
        if (TextUtils.isEmpty(this.mNid)) {
            statisticItem.param("obj_type", "1");
        } else {
            statisticItem.param("obj_type", "2");
            statisticItem.param("obj_id", this.mNid);
        }
        TiebaStatic.log(statisticItem);
    }

    private void initData() {
        this.mVideoDataList = (List) getIntent().getSerializableExtra(VideoPlayActivityConfig.VIDEO_LIST);
        this.mFrom = getIntent().getStringExtra("page_from");
        this.mFromPage = getIntent().getStringExtra("from");
        this.mSourceFrom = getIntent().getStringExtra("source_from");
        this.isFromBjhPb = getIntent().getBooleanExtra(VideoPlayActivityConfig.IS_FROM_BJH_PB, false);
        this.mNid = getIntent().getStringExtra("key_nid");
    }

    private void initFragment() {
        if (ListUtils.isEmpty(this.mVideoDataList) && !ListUtils.isEmpty(VideoPlayActivityConfig.bigDataList)) {
            ArrayList arrayList = new ArrayList();
            this.mVideoDataList = arrayList;
            arrayList.addAll(VideoPlayActivityConfig.bigDataList);
        }
        if (ListUtils.isEmpty(this.mVideoDataList)) {
            l.L(this, R.string.net_error);
            finish();
            return;
        }
        VideoVerticalPageFragment videoVerticalPageFragment = new VideoVerticalPageFragment();
        this.mFragment = videoVerticalPageFragment;
        videoVerticalPageFragment.setArguments(getIntent().getExtras());
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(R.id.video_vertical_root, this.mFragment);
        beginTransaction.commitAllowingStateLoss();
        getSupportFragmentManager().executePendingTransactions();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
        if (videoVerticalPageFragment != null) {
            videoVerticalPageFragment.Q0(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !b.f().h("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        if (TbSingleton.getInstance().isNotchScreen(this) || TbSingleton.getInstance().isCutoutScreen(this)) {
            setUseStyleImmersiveSticky(false);
        }
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        setContentView(R.layout.video_play_activity);
        initData();
        initFragment();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        doEnterStatistic();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        String str = TextUtils.isEmpty(this.mNid) ? "0" : "1";
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.mFrom)) {
            String str2 = "a002";
            if (!"index".equals(this.mSourceFrom)) {
                if ("concern_tab".equals(this.mSourceFrom)) {
                    str2 = "a038";
                } else if ("frs".equals(this.mSourceFrom)) {
                    str2 = "a006";
                } else {
                    "homepage".equals(this.mSourceFrom);
                }
            }
            if (this.isFromBjhPb) {
                TiebaStatic.log(new StatisticItem("stime").param("obj_type", "a023").param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis).param("obj_source", str2).param(TiebaStatic.Params.IS_VERTICAL, "1").param("is_dynamic", str).param("obj_location", this.mFromPage));
                return;
            } else {
                TiebaStatic.log(new StatisticItem("stime").param("obj_type", "a023").param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis).param("obj_source", str2).param("is_dynamic", str).param(TiebaStatic.Params.IS_VERTICAL, "1"));
                return;
            }
        }
        TiebaStatic.log(new StatisticItem("stime").param("obj_type", "a023").param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis).param("is_dynamic", str).param("obj_source", "a020"));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
            if (videoVerticalPageFragment != null) {
                if (videoVerticalPageFragment.R0()) {
                    return false;
                }
                this.mFragment.S0();
            }
            finish();
            return false;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (Build.VERSION.SDK_INT < 16 || z || getActivity() == null || getActivity().getWindow() == null || getActivity().getWindow().getDecorView() == null || TbSingleton.getInstance().isNotchScreen(this) || TbSingleton.getInstance().isCutoutScreen(this)) {
            return;
        }
        getActivity().getWindow().getDecorView().setSystemUiVisibility(getActivity().getWindow().getDecorView().getSystemUiVisibility() | 4);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
        if (videoVerticalPageFragment != null) {
            videoVerticalPageFragment.setPrimary(false);
        }
        d.y().E();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        VideoVerticalPageFragment videoVerticalPageFragment = this.mFragment;
        if (videoVerticalPageFragment != null) {
            videoVerticalPageFragment.setPrimary(true);
            d.y().P(c.Z, this.mFragment.P0());
        }
    }
}
