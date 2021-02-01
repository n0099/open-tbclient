package com.baidu.tieba.lego.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.b;
import com.baidu.tieba.lego.c.e;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseCardView;
import com.baidu.tieba.lego.card.view.c;
import com.baidu.tieba.lego.card.view.n;
import com.baidu.tieba.lego.j;
import com.baidu.tieba.lego.k;
import com.baidu.tieba.lego.view.LegoBottomView;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.v;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes9.dex */
public class LegoListActivity extends BaseFragmentActivity implements SwipeBackLayout.c, VoiceManager.c, b {
    VoiceManager jgg;
    LegoListFragment lam;
    LegoTabFragment lan;
    j lao;
    RelativeLayout lap;
    TbImageView lar;
    private String las;
    private long lastResumeTime;
    private String lau;
    private String lav;
    private String law;
    private c lax;
    String params;
    int rn;
    long kZw = 0;
    int pageType = 1;
    String itemId = "";
    boolean kZF = false;
    boolean hasAnimation = false;
    boolean laq = false;
    private WeakReference<Context> kmw = null;
    private boolean lay = false;
    private LegoBottomView laz = null;
    private CustomMessageListener laA = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_LOAD_DATA_SUCCESS) { // from class: com.baidu.tieba.lego.activity.LegoListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str = "";
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof DataRes) {
                    str = ((DataRes) customResponsedMessage.getData()).page_info;
                } else if (customResponsedMessage.getData() instanceof String) {
                    str = (String) customResponsedMessage.getData();
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject != null) {
                        LegoListActivity.this.ex(jSONObject);
                        LegoListActivity.this.ew(jSONObject);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public final View.OnClickListener jiV = new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == LegoListActivity.this.lao.fLW) {
                LegoListActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(32);
        }
        if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra("page_type", 1);
            this.kZw = getIntent().getLongExtra("page_id", 0L);
            if (getIntent().hasExtra(LegoListActivityConfig.ITEM_ID)) {
                this.itemId = getIntent().getStringExtra(LegoListActivityConfig.ITEM_ID);
            }
            this.kZF = getIntent().getIntExtra(LegoListActivityConfig.IS_IMMERSIVE, 0) == 1;
            this.laq = getIntent().getIntExtra(LegoListActivityConfig.IS_LANDINGPAGE, 0) == 1;
            this.hasAnimation = getIntent().getIntExtra(LegoListActivityConfig.HAS_ANIMATION, 0) == 1;
            this.rn = getIntent().getIntExtra("rn", 30);
            if (getIntent().hasExtra("params")) {
                this.params = getIntent().getStringExtra("params");
            }
            this.lau = getIntent().getStringExtra(LegoListActivityConfig.NEXT_PAGE);
            this.las = getIntent().getStringExtra(LegoListActivityConfig.ANIMATION_INFO);
            if (!TextUtils.isEmpty(this.las)) {
                this.las = URLDecoder.decode(this.las);
            }
            if (!TextUtils.isEmpty(this.lau)) {
                this.lau = URLDecoder.decode(this.lau);
            }
            this.lav = getIntent().getStringExtra(LegoListActivityConfig.PRE_LOAD);
            if (!TextUtils.isEmpty(this.lav)) {
                this.lav = URLDecoder.decode(this.lav);
            }
            this.law = getIntent().getStringExtra("source");
        }
        super.setHideStatusImmersiveStyle(this.kZF);
        super.onCreate(bundle);
        setContentView(R.layout.lego_list_activity);
        registerListener(this.laA);
        e eVar = new e();
        eVar.lfE = this.kZw;
        eVar.lfF = this.pageType;
        eVar.itemId = this.itemId;
        eVar.rn = this.rn;
        eVar.params = this.params;
        eVar.refresh();
        this.jgg = getVoiceManager();
        this.jgg.onCreate(getPageContext());
        this.lao = new j(this);
        this.lar = (TbImageView) findViewById(R.id.float_btn);
        this.laz = (LegoBottomView) findViewById(R.id.lego_bottom_view);
        this.lap = (RelativeLayout) findViewById(R.id.navi_landingpage);
        this.lax = new c(getPageContext(), findViewById(R.id.layout_float_video));
        this.lax.setSwipeControlInterface(this);
        this.lax.hide();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (this.pageType == 1) {
            this.lan = new LegoTabFragment();
            this.lan.b(this.lao);
            this.lan.hg(this.kZw);
            this.lan.setItemId(this.itemId);
            this.lan.setPrimary(true);
            beginTransaction.replace(R.id.fl_lego, this.lan);
        } else {
            LegoListFragment.dbm();
            this.lam = new LegoListFragment();
            this.lam.b(this.lao);
            this.lam.b(this.lap);
            this.lam.a(this.lax);
            this.lam.hg(this.kZw);
            this.lam.setItemId(this.itemId);
            this.lam.setImmersive(this.kZF);
            this.lam.setPrimary(true);
            this.lam.NB(this.lau);
            this.lam.fI(this.las, this.lav);
            this.lam.tC(this.hasAnimation);
            this.lam.tD(this.laq);
            this.lam.setFrom(this.law);
            beginTransaction.replace(R.id.fl_lego, this.lam);
        }
        if (this.kZF) {
            this.lao.hide();
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.lax.a(this, configuration);
        if (configuration.orientation == 2 && this.lax.isShow()) {
            if (this.laz != null) {
                this.laz.setIsVideoLandscape(true);
                this.laz.setVisibility(8);
            }
        } else if (this.laz != null && this.laz.isShow()) {
            this.laz.setIsVideoLandscape(false);
            this.laz.setVisibility(0);
        }
        if (this.lam != null) {
            this.lam.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.lax == null || !this.lax.isShow() || this.lax.dcq()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.lax.TZ();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("bottom_card");
            if (optJSONObject != null) {
                com.baidu.tieba.lego.card.b.dbs();
                ICardInfo ey = com.baidu.tieba.lego.card.b.ey(optJSONObject);
                if (ey != null && ey.isValid()) {
                    this.laz.a((BaseCardView) com.baidu.tieba.lego.card.b.dbs().a(getPageContext(), ey, 5), ey);
                    this.laz.setVisibility(0);
                    this.laz.setIsShow(true);
                    if (this.lam != null) {
                        this.lam.a(this.laz);
                    }
                } else {
                    this.laz.setVisibility(8);
                    this.laz.setIsShow(false);
                    if (this.lam != null) {
                        this.lam.a((k) null);
                    }
                }
            }
        } catch (CardParseException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("float_btn");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("icon_url");
            String optString2 = optJSONObject.optString("icon_url_night");
            final String optString3 = optJSONObject.optString("scheme");
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                optString2 = optString;
            }
            this.lar.setVisibility(0);
            this.lar.startLoad(optString2, 10, false);
            this.lar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(optString3)) {
                        v.j(LegoListActivity.this.getPageContext(), optString3);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jgg = getVoiceManager();
        if (this.jgg != null) {
            this.jgg.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.jgg = getVoiceManager();
        this.jgg.onStart(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lay = true;
        this.jgg = getVoiceManager();
        this.jgg.onResume(getPageContext());
        this.lastResumeTime = System.currentTimeMillis();
        this.kmw = new WeakReference<>(TbadkCoreApplication.getInst());
        ak.a(this.kmw, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lay = false;
        this.jgg = getVoiceManager();
        this.jgg.onPause(getPageContext());
        if (this.lastResumeTime != 0 && this.laq) {
            r.dDm().dDi().b(this.kZw, this.itemId, this.law, System.currentTimeMillis() - this.lastResumeTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jgg = getVoiceManager();
        if (this.jgg != null) {
            this.jgg.onStop(getPageContext());
        }
        ak.a(this.kmw, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.lax != null) {
            this.lax.destroy();
        }
        this.jgg = getVoiceManager();
        this.jgg.onDestory(getPageContext());
        this.las = null;
        if (this.laz != null) {
            this.laz.destory();
            this.laz = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.lao.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.pageType == 1) {
            if (this.lan != null) {
                this.lan.onChangeSkinType(i);
            }
        } else if (this.lam != null) {
            this.lam.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void enableSwipeBack() {
        setSwipeBackEnabled(true);
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void disableSwipeBack() {
        setSwipeBackEnabled(false);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jgg == null) {
            this.jgg = VoiceManager.instance();
        }
        return this.jgg;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        if (this.hasAnimation && !TextUtils.isEmpty(this.las)) {
            super.overridePendingTransition(0, R.anim.landingpage_quit);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.hasAnimation && !TextUtils.isEmpty(this.las) && this.lam != null) {
            this.lam.endAnimation();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tieba.lego.b
    public n getPlaySwitchController() {
        if (this.lam != null) {
            return this.lam.getPlaySwitchController();
        }
        return null;
    }

    @Override // com.baidu.tieba.lego.b
    public c dbc() {
        return this.lax;
    }

    @Override // com.baidu.tieba.lego.b
    public LegoListFragment dbd() {
        return this.lam;
    }
}
