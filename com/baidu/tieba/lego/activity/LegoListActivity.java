package com.baidu.tieba.lego.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseCardView;
import com.baidu.tieba.lego.view.LegoBottomView;
import d.a.m0.z0.m0;
import d.a.n0.e3.v;
import d.a.n0.k1.j;
import d.a.n0.k1.o.l.n;
import d.a.n0.k1.p.e;
import d.a.n0.t2.x;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class LegoListActivity extends BaseFragmentActivity implements SwipeBackLayout.c, VoiceManager.j, d.a.n0.k1.b {
    public String animationInfo;
    public TbImageView floatBtn;
    public String isFrom;
    public long lastResumeTime;
    public LegoListFragment legoListFragment;
    public LegoTabFragment legoTabFragment;
    public d.a.n0.k1.o.l.c mFloatVideoContainer;
    public VoiceManager mVoiceManager;
    public RelativeLayout navi_landingpage;
    public j navigationBarViewHolder;
    public String nextPage;
    public String params;
    public String preLoad;
    public int rn;
    public long pageId = 0;
    public int pageType = 1;
    public String itemId = "";
    public boolean isImmersive = false;
    public boolean hasAnimation = false;
    public boolean isLandingPage = false;
    public WeakReference<Context> weakContext = null;
    public boolean mIsResumed = false;
    public LegoBottomView mBottomView = null;
    public CustomMessageListener mShowComponentViewListener = new a(2016455);
    public final View.OnClickListener mCommonOnClickListener = new c();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof DataRes) {
                    str = ((DataRes) customResponsedMessage.getData()).page_info;
                } else {
                    str = customResponsedMessage.getData() instanceof String ? (String) customResponsedMessage.getData() : "";
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    LegoListActivity.this.showFloatButton(jSONObject);
                    LegoListActivity.this.showBottomCard(jSONObject);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17824e;

        public b(String str) {
            this.f17824e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f17824e)) {
                return;
            }
            v.c(LegoListActivity.this.getPageContext(), this.f17824e);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LegoListActivity legoListActivity = LegoListActivity.this;
            if (view == legoListActivity.navigationBarViewHolder.f56607e) {
                legoListActivity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBottomCard(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("bottom_card");
            if (optJSONObject == null) {
                return;
            }
            d.a.n0.k1.o.b.h();
            ICardInfo j = d.a.n0.k1.o.b.j(optJSONObject);
            if (j != null && j.isValid()) {
                this.mBottomView.b((BaseCardView) d.a.n0.k1.o.b.h().a(getPageContext(), j, 5), j);
                this.mBottomView.setVisibility(0);
                this.mBottomView.setIsShow(true);
                if (this.legoListFragment != null) {
                    this.legoListFragment.B1(this.mBottomView);
                }
            } else {
                this.mBottomView.setVisibility(8);
                this.mBottomView.setIsShow(false);
                if (this.legoListFragment != null) {
                    this.legoListFragment.B1(null);
                }
            }
        } catch (CardParseException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFloatButton(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("float_btn");
        if (optJSONObject == null) {
            return;
        }
        String optString = optJSONObject.optString("icon_url");
        String optString2 = optJSONObject.optString("icon_url_night");
        String optString3 = optJSONObject.optString("scheme");
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            optString = optString2;
        }
        this.floatBtn.setVisibility(0);
        this.floatBtn.V(optString, 10, false);
        this.floatBtn.setOnClickListener(new b(optString3));
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void disableSwipeBack() {
        setSwipeBackEnabled(false);
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void enableSwipeBack() {
        setSwipeBackEnabled(true);
    }

    public BaseAdapter getAdapter() {
        LegoListFragment legoListFragment = this.legoListFragment;
        if (legoListFragment != null) {
            return legoListFragment.j1();
        }
        return null;
    }

    @Override // d.a.n0.k1.b
    public d.a.n0.k1.o.l.c getFloatVideoContainer() {
        return this.mFloatVideoContainer;
    }

    @Override // d.a.n0.k1.b
    public LegoListFragment getLegoListFragment() {
        return this.legoListFragment;
    }

    @Override // d.a.n0.k1.b
    public n getPlaySwitchController() {
        LegoListFragment legoListFragment = this.legoListFragment;
        if (legoListFragment != null) {
            return legoListFragment.m1();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    public boolean isActivityResumed() {
        return this.mIsResumed;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        LegoListFragment legoListFragment;
        if (this.hasAnimation && !TextUtils.isEmpty(this.animationInfo) && (legoListFragment = this.legoListFragment) != null) {
            legoListFragment.h1();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        this.navigationBarViewHolder.f56603a.onChangeSkinType(getPageContext(), i2);
        if (this.pageType == 1) {
            LegoTabFragment legoTabFragment = this.legoTabFragment;
            if (legoTabFragment != null) {
                legoTabFragment.onChangeSkinType(i2);
                return;
            }
            return;
        }
        LegoListFragment legoListFragment = this.legoListFragment;
        if (legoListFragment != null) {
            legoListFragment.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFloatVideoContainer.n0(this, configuration);
        if (configuration.orientation == 2 && this.mFloatVideoContainer.m0()) {
            LegoBottomView legoBottomView = this.mBottomView;
            if (legoBottomView != null) {
                legoBottomView.setIsVideoLandscape(true);
                this.mBottomView.setVisibility(8);
            }
        } else {
            LegoBottomView legoBottomView2 = this.mBottomView;
            if (legoBottomView2 != null && legoBottomView2.e()) {
                this.mBottomView.setIsVideoLandscape(false);
                this.mBottomView.setVisibility(0);
            }
        }
        LegoListFragment legoListFragment = this.legoListFragment;
        if (legoListFragment != null) {
            legoListFragment.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(32);
        }
        if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra("page_type", 1);
            this.pageId = getIntent().getLongExtra("page_id", 0L);
            if (getIntent().hasExtra(LegoListActivityConfig.ITEM_ID)) {
                this.itemId = getIntent().getStringExtra(LegoListActivityConfig.ITEM_ID);
            }
            this.isImmersive = getIntent().getIntExtra(LegoListActivityConfig.IS_IMMERSIVE, 0) == 1;
            this.isLandingPage = getIntent().getIntExtra(LegoListActivityConfig.IS_LANDINGPAGE, 0) == 1;
            this.hasAnimation = getIntent().getIntExtra(LegoListActivityConfig.HAS_ANIMATION, 0) == 1;
            this.rn = getIntent().getIntExtra("rn", 30);
            if (getIntent().hasExtra("params")) {
                this.params = getIntent().getStringExtra("params");
            }
            this.nextPage = getIntent().getStringExtra(LegoListActivityConfig.NEXT_PAGE);
            String stringExtra = getIntent().getStringExtra(LegoListActivityConfig.ANIMATION_INFO);
            this.animationInfo = stringExtra;
            if (!TextUtils.isEmpty(stringExtra)) {
                this.animationInfo = URLDecoder.decode(this.animationInfo);
            }
            if (!TextUtils.isEmpty(this.nextPage)) {
                this.nextPage = URLDecoder.decode(this.nextPage);
            }
            String stringExtra2 = getIntent().getStringExtra(LegoListActivityConfig.PRE_LOAD);
            this.preLoad = stringExtra2;
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.preLoad = URLDecoder.decode(this.preLoad);
            }
            this.isFrom = getIntent().getStringExtra("source");
        }
        super.setHideStatusImmersiveStyle(this.isImmersive);
        super.onCreate(bundle);
        setContentView(R.layout.lego_list_activity);
        registerListener(this.mShowComponentViewListener);
        e eVar = new e();
        eVar.f56758a = this.pageId;
        eVar.f56759b = this.itemId;
        eVar.f56761d = this.rn;
        eVar.f56762e = this.params;
        eVar.b();
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        voiceManager.onCreate(getPageContext());
        this.navigationBarViewHolder = new j(this);
        this.floatBtn = (TbImageView) findViewById(R.id.float_btn);
        this.mBottomView = (LegoBottomView) findViewById(R.id.lego_bottom_view);
        this.navi_landingpage = (RelativeLayout) findViewById(R.id.navi_landingpage);
        d.a.n0.k1.o.l.c cVar = new d.a.n0.k1.o.l.c(getPageContext(), findViewById(R.id.layout_float_video));
        this.mFloatVideoContainer = cVar;
        cVar.E0(this);
        this.mFloatVideoContainer.j0();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (this.pageType == 1) {
            LegoTabFragment legoTabFragment = new LegoTabFragment();
            this.legoTabFragment = legoTabFragment;
            legoTabFragment.W0(this.navigationBarViewHolder);
            this.legoTabFragment.X0(this.pageId);
            this.legoTabFragment.V0(this.itemId);
            this.legoTabFragment.setPrimary(true);
            beginTransaction.replace(R.id.fl_lego, this.legoTabFragment);
        } else {
            LegoListFragment.p1();
            LegoListFragment legoListFragment = new LegoListFragment();
            this.legoListFragment = legoListFragment;
            legoListFragment.A1(this.navigationBarViewHolder);
            this.legoListFragment.y1(this.navi_landingpage);
            this.legoListFragment.u1(this.mFloatVideoContainer);
            this.legoListFragment.D1(this.pageId);
            this.legoListFragment.x1(this.itemId);
            this.legoListFragment.w1(this.isImmersive);
            this.legoListFragment.setPrimary(true);
            this.legoListFragment.C1(this.nextPage);
            this.legoListFragment.t1(this.animationInfo, this.preLoad);
            this.legoListFragment.v1(this.hasAnimation);
            this.legoListFragment.z1(this.isLandingPage);
            this.legoListFragment.setFrom(this.isFrom);
            beginTransaction.replace(R.id.fl_lego, this.legoListFragment);
        }
        if (this.isImmersive) {
            this.navigationBarViewHolder.d();
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        d.a.n0.k1.o.l.c cVar = this.mFloatVideoContainer;
        if (cVar != null) {
            cVar.V();
        }
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        voiceManager.onDestory(getPageContext());
        this.animationInfo = null;
        LegoBottomView legoBottomView = this.mBottomView;
        if (legoBottomView != null) {
            legoBottomView.c();
            this.mBottomView = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        d.a.n0.k1.o.l.c cVar;
        if (i2 == 4 && (cVar = this.mFloatVideoContainer) != null && cVar.m0() && !this.mFloatVideoContainer.e0()) {
            this.mFloatVideoContainer.Q0();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIsResumed = false;
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        voiceManager.onPause(getPageContext());
        if (this.lastResumeTime == 0 || !this.isLandingPage) {
            return;
        }
        x.p().m().a(this.pageId, this.itemId, this.isFrom, System.currentTimeMillis() - this.lastResumeTime);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsResumed = true;
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        voiceManager.onResume(getPageContext());
        this.lastResumeTime = System.currentTimeMillis();
        WeakReference<Context> weakReference = new WeakReference<>(TbadkCoreApplication.getInst());
        this.weakContext = weakReference;
        m0.e(weakReference, true);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        voiceManager.onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
        m0.e(this.weakContext, false);
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        if (!this.hasAnimation || TextUtils.isEmpty(this.animationInfo)) {
            return;
        }
        super.overridePendingTransition(0, R.anim.landingpage_quit);
    }

    public void stopVoice() {
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        voiceManager.stopPlay();
    }
}
