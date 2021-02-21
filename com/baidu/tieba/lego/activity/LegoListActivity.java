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
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.v;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes9.dex */
public class LegoListActivity extends BaseFragmentActivity implements SwipeBackLayout.c, VoiceManager.c, b {
    VoiceManager jgu;
    LegoListFragment laB;
    LegoTabFragment laC;
    j laD;
    RelativeLayout laE;
    TbImageView laG;
    private String laH;
    private String laI;
    private String laJ;
    private String laK;
    private c laL;
    private long lastResumeTime;
    String params;
    int rn;
    long kZK = 0;
    int pageType = 1;
    String itemId = "";
    boolean kZT = false;
    boolean hasAnimation = false;
    boolean laF = false;
    private WeakReference<Context> kmK = null;
    private boolean laM = false;
    private LegoBottomView laN = null;
    private CustomMessageListener laO = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_LOAD_DATA_SUCCESS) { // from class: com.baidu.tieba.lego.activity.LegoListActivity.1
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
    public final View.OnClickListener jjj = new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == LegoListActivity.this.laD.fLW) {
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
            this.kZK = getIntent().getLongExtra("page_id", 0L);
            if (getIntent().hasExtra(LegoListActivityConfig.ITEM_ID)) {
                this.itemId = getIntent().getStringExtra(LegoListActivityConfig.ITEM_ID);
            }
            this.kZT = getIntent().getIntExtra(LegoListActivityConfig.IS_IMMERSIVE, 0) == 1;
            this.laF = getIntent().getIntExtra(LegoListActivityConfig.IS_LANDINGPAGE, 0) == 1;
            this.hasAnimation = getIntent().getIntExtra(LegoListActivityConfig.HAS_ANIMATION, 0) == 1;
            this.rn = getIntent().getIntExtra("rn", 30);
            if (getIntent().hasExtra("params")) {
                this.params = getIntent().getStringExtra("params");
            }
            this.laI = getIntent().getStringExtra(LegoListActivityConfig.NEXT_PAGE);
            this.laH = getIntent().getStringExtra(LegoListActivityConfig.ANIMATION_INFO);
            if (!TextUtils.isEmpty(this.laH)) {
                this.laH = URLDecoder.decode(this.laH);
            }
            if (!TextUtils.isEmpty(this.laI)) {
                this.laI = URLDecoder.decode(this.laI);
            }
            this.laJ = getIntent().getStringExtra(LegoListActivityConfig.PRE_LOAD);
            if (!TextUtils.isEmpty(this.laJ)) {
                this.laJ = URLDecoder.decode(this.laJ);
            }
            this.laK = getIntent().getStringExtra("source");
        }
        super.setHideStatusImmersiveStyle(this.kZT);
        super.onCreate(bundle);
        setContentView(R.layout.lego_list_activity);
        registerListener(this.laO);
        e eVar = new e();
        eVar.lfS = this.kZK;
        eVar.lfT = this.pageType;
        eVar.itemId = this.itemId;
        eVar.rn = this.rn;
        eVar.params = this.params;
        eVar.refresh();
        this.jgu = getVoiceManager();
        this.jgu.onCreate(getPageContext());
        this.laD = new j(this);
        this.laG = (TbImageView) findViewById(R.id.float_btn);
        this.laN = (LegoBottomView) findViewById(R.id.lego_bottom_view);
        this.laE = (RelativeLayout) findViewById(R.id.navi_landingpage);
        this.laL = new c(getPageContext(), findViewById(R.id.layout_float_video));
        this.laL.setSwipeControlInterface(this);
        this.laL.hide();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (this.pageType == 1) {
            this.laC = new LegoTabFragment();
            this.laC.b(this.laD);
            this.laC.hg(this.kZK);
            this.laC.setItemId(this.itemId);
            this.laC.setPrimary(true);
            beginTransaction.replace(R.id.fl_lego, this.laC);
        } else {
            LegoListFragment.dbt();
            this.laB = new LegoListFragment();
            this.laB.b(this.laD);
            this.laB.b(this.laE);
            this.laB.a(this.laL);
            this.laB.hg(this.kZK);
            this.laB.setItemId(this.itemId);
            this.laB.setImmersive(this.kZT);
            this.laB.setPrimary(true);
            this.laB.NC(this.laI);
            this.laB.fI(this.laH, this.laJ);
            this.laB.tC(this.hasAnimation);
            this.laB.tD(this.laF);
            this.laB.setFrom(this.laK);
            beginTransaction.replace(R.id.fl_lego, this.laB);
        }
        if (this.kZT) {
            this.laD.hide();
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.laL.a(this, configuration);
        if (configuration.orientation == 2 && this.laL.isShow()) {
            if (this.laN != null) {
                this.laN.setIsVideoLandscape(true);
                this.laN.setVisibility(8);
            }
        } else if (this.laN != null && this.laN.isShow()) {
            this.laN.setIsVideoLandscape(false);
            this.laN.setVisibility(0);
        }
        if (this.laB != null) {
            this.laB.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.laL == null || !this.laL.isShow() || this.laL.dcx()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.laL.TZ();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("bottom_card");
            if (optJSONObject != null) {
                com.baidu.tieba.lego.card.b.dbz();
                ICardInfo ey = com.baidu.tieba.lego.card.b.ey(optJSONObject);
                if (ey != null && ey.isValid()) {
                    this.laN.a((BaseCardView) com.baidu.tieba.lego.card.b.dbz().a(getPageContext(), ey, 5), ey);
                    this.laN.setVisibility(0);
                    this.laN.setIsShow(true);
                    if (this.laB != null) {
                        this.laB.a(this.laN);
                    }
                } else {
                    this.laN.setVisibility(8);
                    this.laN.setIsShow(false);
                    if (this.laB != null) {
                        this.laB.a((k) null);
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
            this.laG.setVisibility(0);
            this.laG.startLoad(optString2, 10, false);
            this.laG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListActivity.2
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
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.jgu = getVoiceManager();
        this.jgu.onStart(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.laM = true;
        this.jgu = getVoiceManager();
        this.jgu.onResume(getPageContext());
        this.lastResumeTime = System.currentTimeMillis();
        this.kmK = new WeakReference<>(TbadkCoreApplication.getInst());
        ak.a(this.kmK, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.laM = false;
        this.jgu = getVoiceManager();
        this.jgu.onPause(getPageContext());
        if (this.lastResumeTime != 0 && this.laF) {
            s.dDt().dDp().b(this.kZK, this.itemId, this.laK, System.currentTimeMillis() - this.lastResumeTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onStop(getPageContext());
        }
        ak.a(this.kmK, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.laL != null) {
            this.laL.destroy();
        }
        this.jgu = getVoiceManager();
        this.jgu.onDestory(getPageContext());
        this.laH = null;
        if (this.laN != null) {
            this.laN.destory();
            this.laN = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.laD.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.pageType == 1) {
            if (this.laC != null) {
                this.laC.onChangeSkinType(i);
            }
        } else if (this.laB != null) {
            this.laB.onChangeSkinType(i);
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
        if (this.jgu == null) {
            this.jgu = VoiceManager.instance();
        }
        return this.jgu;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        if (this.hasAnimation && !TextUtils.isEmpty(this.laH)) {
            super.overridePendingTransition(0, R.anim.landingpage_quit);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.hasAnimation && !TextUtils.isEmpty(this.laH) && this.laB != null) {
            this.laB.endAnimation();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tieba.lego.b
    public n getPlaySwitchController() {
        if (this.laB != null) {
            return this.laB.getPlaySwitchController();
        }
        return null;
    }

    @Override // com.baidu.tieba.lego.b
    public c dbj() {
        return this.laL;
    }

    @Override // com.baidu.tieba.lego.b
    public LegoListFragment dbk() {
        return this.laB;
    }
}
