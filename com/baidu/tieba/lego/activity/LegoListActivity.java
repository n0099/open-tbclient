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
/* loaded from: classes8.dex */
public class LegoListActivity extends BaseFragmentActivity implements SwipeBackLayout.c, VoiceManager.c, b {
    VoiceManager jie;
    private long lastResumeTime;
    LegoListFragment lcE;
    LegoTabFragment lcF;
    j lcG;
    RelativeLayout lcH;
    TbImageView lcJ;
    private String lcK;
    private String lcL;
    private String lcM;
    private String lcN;
    private c lcO;
    String params;
    int rn;
    long lbN = 0;
    int pageType = 1;
    String itemId = "";
    boolean lbW = false;
    boolean hasAnimation = false;
    boolean lcI = false;
    private WeakReference<Context> koM = null;
    private boolean lcP = false;
    private LegoBottomView lcQ = null;
    private CustomMessageListener lcR = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_LOAD_DATA_SUCCESS) { // from class: com.baidu.tieba.lego.activity.LegoListActivity.1
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
                        LegoListActivity.this.ez(jSONObject);
                        LegoListActivity.this.ey(jSONObject);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public final View.OnClickListener jkS = new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == LegoListActivity.this.lcG.fNw) {
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
            this.lbN = getIntent().getLongExtra("page_id", 0L);
            if (getIntent().hasExtra(LegoListActivityConfig.ITEM_ID)) {
                this.itemId = getIntent().getStringExtra(LegoListActivityConfig.ITEM_ID);
            }
            this.lbW = getIntent().getIntExtra(LegoListActivityConfig.IS_IMMERSIVE, 0) == 1;
            this.lcI = getIntent().getIntExtra(LegoListActivityConfig.IS_LANDINGPAGE, 0) == 1;
            this.hasAnimation = getIntent().getIntExtra(LegoListActivityConfig.HAS_ANIMATION, 0) == 1;
            this.rn = getIntent().getIntExtra("rn", 30);
            if (getIntent().hasExtra("params")) {
                this.params = getIntent().getStringExtra("params");
            }
            this.lcL = getIntent().getStringExtra(LegoListActivityConfig.NEXT_PAGE);
            this.lcK = getIntent().getStringExtra(LegoListActivityConfig.ANIMATION_INFO);
            if (!TextUtils.isEmpty(this.lcK)) {
                this.lcK = URLDecoder.decode(this.lcK);
            }
            if (!TextUtils.isEmpty(this.lcL)) {
                this.lcL = URLDecoder.decode(this.lcL);
            }
            this.lcM = getIntent().getStringExtra(LegoListActivityConfig.PRE_LOAD);
            if (!TextUtils.isEmpty(this.lcM)) {
                this.lcM = URLDecoder.decode(this.lcM);
            }
            this.lcN = getIntent().getStringExtra("source");
        }
        super.setHideStatusImmersiveStyle(this.lbW);
        super.onCreate(bundle);
        setContentView(R.layout.lego_list_activity);
        registerListener(this.lcR);
        e eVar = new e();
        eVar.lhU = this.lbN;
        eVar.lhV = this.pageType;
        eVar.itemId = this.itemId;
        eVar.rn = this.rn;
        eVar.params = this.params;
        eVar.refresh();
        this.jie = getVoiceManager();
        this.jie.onCreate(getPageContext());
        this.lcG = new j(this);
        this.lcJ = (TbImageView) findViewById(R.id.float_btn);
        this.lcQ = (LegoBottomView) findViewById(R.id.lego_bottom_view);
        this.lcH = (RelativeLayout) findViewById(R.id.navi_landingpage);
        this.lcO = new c(getPageContext(), findViewById(R.id.layout_float_video));
        this.lcO.setSwipeControlInterface(this);
        this.lcO.hide();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (this.pageType == 1) {
            this.lcF = new LegoTabFragment();
            this.lcF.b(this.lcG);
            this.lcF.hg(this.lbN);
            this.lcF.setItemId(this.itemId);
            this.lcF.setPrimary(true);
            beginTransaction.replace(R.id.fl_lego, this.lcF);
        } else {
            LegoListFragment.dbC();
            this.lcE = new LegoListFragment();
            this.lcE.b(this.lcG);
            this.lcE.b(this.lcH);
            this.lcE.a(this.lcO);
            this.lcE.hg(this.lbN);
            this.lcE.setItemId(this.itemId);
            this.lcE.setImmersive(this.lbW);
            this.lcE.setPrimary(true);
            this.lcE.NI(this.lcL);
            this.lcE.fI(this.lcK, this.lcM);
            this.lcE.tC(this.hasAnimation);
            this.lcE.tD(this.lcI);
            this.lcE.setFrom(this.lcN);
            beginTransaction.replace(R.id.fl_lego, this.lcE);
        }
        if (this.lbW) {
            this.lcG.hide();
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.lcO.a(this, configuration);
        if (configuration.orientation == 2 && this.lcO.isShow()) {
            if (this.lcQ != null) {
                this.lcQ.setIsVideoLandscape(true);
                this.lcQ.setVisibility(8);
            }
        } else if (this.lcQ != null && this.lcQ.isShow()) {
            this.lcQ.setIsVideoLandscape(false);
            this.lcQ.setVisibility(0);
        }
        if (this.lcE != null) {
            this.lcE.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.lcO == null || !this.lcO.isShow() || this.lcO.dcG()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.lcO.Uc();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ey(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("bottom_card");
            if (optJSONObject != null) {
                com.baidu.tieba.lego.card.b.dbI();
                ICardInfo eA = com.baidu.tieba.lego.card.b.eA(optJSONObject);
                if (eA != null && eA.isValid()) {
                    this.lcQ.a((BaseCardView) com.baidu.tieba.lego.card.b.dbI().a(getPageContext(), eA, 5), eA);
                    this.lcQ.setVisibility(0);
                    this.lcQ.setIsShow(true);
                    if (this.lcE != null) {
                        this.lcE.a(this.lcQ);
                    }
                } else {
                    this.lcQ.setVisibility(8);
                    this.lcQ.setIsShow(false);
                    if (this.lcE != null) {
                        this.lcE.a((k) null);
                    }
                }
            }
        } catch (CardParseException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("float_btn");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("icon_url");
            String optString2 = optJSONObject.optString("icon_url_night");
            final String optString3 = optJSONObject.optString("scheme");
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                optString2 = optString;
            }
            this.lcJ.setVisibility(0);
            this.lcJ.startLoad(optString2, 10, false);
            this.lcJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListActivity.2
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
        this.jie = getVoiceManager();
        if (this.jie != null) {
            this.jie.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.jie = getVoiceManager();
        this.jie.onStart(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lcP = true;
        this.jie = getVoiceManager();
        this.jie.onResume(getPageContext());
        this.lastResumeTime = System.currentTimeMillis();
        this.koM = new WeakReference<>(TbadkCoreApplication.getInst());
        ak.a(this.koM, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lcP = false;
        this.jie = getVoiceManager();
        this.jie.onPause(getPageContext());
        if (this.lastResumeTime != 0 && this.lcI) {
            s.dDB().dDx().b(this.lbN, this.itemId, this.lcN, System.currentTimeMillis() - this.lastResumeTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jie = getVoiceManager();
        if (this.jie != null) {
            this.jie.onStop(getPageContext());
        }
        ak.a(this.koM, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.lcO != null) {
            this.lcO.destroy();
        }
        this.jie = getVoiceManager();
        this.jie.onDestory(getPageContext());
        this.lcK = null;
        if (this.lcQ != null) {
            this.lcQ.destory();
            this.lcQ = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.lcG.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.pageType == 1) {
            if (this.lcF != null) {
                this.lcF.onChangeSkinType(i);
            }
        } else if (this.lcE != null) {
            this.lcE.onChangeSkinType(i);
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
        if (this.jie == null) {
            this.jie = VoiceManager.instance();
        }
        return this.jie;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        if (this.hasAnimation && !TextUtils.isEmpty(this.lcK)) {
            super.overridePendingTransition(0, R.anim.landingpage_quit);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.hasAnimation && !TextUtils.isEmpty(this.lcK) && this.lcE != null) {
            this.lcE.endAnimation();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tieba.lego.b
    public n getPlaySwitchController() {
        if (this.lcE != null) {
            return this.lcE.getPlaySwitchController();
        }
        return null;
    }

    @Override // com.baidu.tieba.lego.b
    public c dbs() {
        return this.lcO;
    }

    @Override // com.baidu.tieba.lego.b
    public LegoListFragment dbt() {
        return this.lcE;
    }
}
