package com.baidu.tieba.lego.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.b;
import com.baidu.tieba.lego.c.e;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseCardView;
import com.baidu.tieba.lego.card.view.c;
import com.baidu.tieba.lego.card.view.l;
import com.baidu.tieba.lego.j;
import com.baidu.tieba.lego.k;
import com.baidu.tieba.lego.view.LegoBottomView;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.q;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes2.dex */
public class LegoListActivity extends BaseFragmentActivity implements SwipeBackLayout.c, VoiceManager.c, b {
    VoiceManager eYS;
    TbImageView gFC;
    private String gFD;
    private String gFE;
    private String gFF;
    private String gFG;
    private c gFI;
    LegoListFragment gFw;
    LegoTabFragment gFx;
    j gFy;
    RelativeLayout gFz;
    private long lastResumeTime;
    String params;
    int rn;
    long gEF = 0;
    int pageType = 1;
    String itemId = "";
    boolean gEO = false;
    boolean gFA = false;
    boolean gFB = false;
    private WeakReference<Context> gFH = null;
    private boolean uD = false;
    private LegoBottomView gFJ = null;
    private CustomMessageListener gFK = new CustomMessageListener(2016455) { // from class: com.baidu.tieba.lego.activity.LegoListActivity.1
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
                        LegoListActivity.this.bs(jSONObject);
                        LegoListActivity.this.br(jSONObject);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public final View.OnClickListener faZ = new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == LegoListActivity.this.gFy.csE) {
                LegoListActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(32);
        }
        if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra("page_type", 1);
            this.gEF = getIntent().getLongExtra("page_id", 0L);
            if (getIntent().hasExtra(LegoListActivityConfig.ITEM_ID)) {
                this.itemId = getIntent().getStringExtra(LegoListActivityConfig.ITEM_ID);
            }
            this.gEO = getIntent().getIntExtra(LegoListActivityConfig.IS_IMMERSIVE, 0) == 1;
            this.gFB = getIntent().getIntExtra(LegoListActivityConfig.IS_LANDINGPAGE, 0) == 1;
            this.gFA = getIntent().getIntExtra(LegoListActivityConfig.HAS_ANIMATION, 0) == 1;
            this.rn = getIntent().getIntExtra(LegoListActivityConfig.RN, 30);
            if (getIntent().hasExtra(LegoListActivityConfig.PARAMS)) {
                this.params = getIntent().getStringExtra(LegoListActivityConfig.PARAMS);
            }
            this.gFE = getIntent().getStringExtra(LegoListActivityConfig.NEXT_PAGE);
            this.gFD = getIntent().getStringExtra(LegoListActivityConfig.ANIMATION_INFO);
            if (!TextUtils.isEmpty(this.gFD)) {
                this.gFD = URLDecoder.decode(this.gFD);
            }
            if (!TextUtils.isEmpty(this.gFE)) {
                this.gFE = URLDecoder.decode(this.gFE);
            }
            this.gFF = getIntent().getStringExtra(LegoListActivityConfig.PRE_LOAD);
            if (!TextUtils.isEmpty(this.gFF)) {
                this.gFF = URLDecoder.decode(this.gFF);
            }
            this.gFG = getIntent().getStringExtra("source");
        }
        super.setHideStatusImmersiveStyle(this.gEO);
        super.onCreate(bundle);
        setContentView(d.h.lego_list_activity);
        registerListener(this.gFK);
        e eVar = new e();
        eVar.gKV = this.gEF;
        eVar.gKW = this.pageType;
        eVar.itemId = this.itemId;
        eVar.rn = this.rn;
        eVar.params = this.params;
        eVar.refresh();
        this.eYS = getVoiceManager();
        this.eYS.onCreate(getPageContext());
        this.gFy = new j(this);
        this.gFC = (TbImageView) findViewById(d.g.float_btn);
        this.gFJ = (LegoBottomView) findViewById(d.g.lego_bottom_view);
        this.gFz = (RelativeLayout) findViewById(d.g.navi_landingpage);
        this.gFI = new c(getPageContext(), findViewById(d.g.layout_float_video));
        this.gFI.setSwipeControlInterface(this);
        this.gFI.hide();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (this.pageType == 1) {
            this.gFx = new LegoTabFragment();
            this.gFx.b(this.gFy);
            this.gFx.dp(this.gEF);
            this.gFx.setItemId(this.itemId);
            this.gFx.setPrimary(true);
            beginTransaction.replace(d.g.fl_lego, this.gFx);
        } else {
            LegoListFragment.bzB();
            this.gFw = new LegoListFragment();
            this.gFw.b(this.gFy);
            this.gFw.b(this.gFz);
            this.gFw.a(this.gFI);
            this.gFw.dp(this.gEF);
            this.gFw.setItemId(this.itemId);
            this.gFw.setImmersive(this.gEO);
            this.gFw.setPrimary(true);
            this.gFw.xU(this.gFE);
            this.gFw.dl(this.gFD, this.gFF);
            this.gFw.lT(this.gFA);
            this.gFw.lU(this.gFB);
            this.gFw.setFrom(this.gFG);
            beginTransaction.replace(d.g.fl_lego, this.gFw);
        }
        if (this.gEO) {
            this.gFy.hide();
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gFI.a(this, configuration);
        if (configuration.orientation == 2 && this.gFI.isShow()) {
            if (this.gFJ != null) {
                this.gFJ.setIsVideoLandscape(true);
                this.gFJ.setVisibility(8);
            }
        } else if (this.gFJ != null && this.gFJ.isShow()) {
            this.gFJ.setIsVideoLandscape(false);
            this.gFJ.setVisibility(0);
        }
        if (this.gFw != null) {
            this.gFw.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.gFI == null || !this.gFI.isShow() || this.gFI.bAI()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.gFI.bAB();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("bottom_card");
            if (optJSONObject != null) {
                com.baidu.tieba.lego.card.b.bzH();
                ICardInfo bt = com.baidu.tieba.lego.card.b.bt(optJSONObject);
                if (bt != null && bt.isValid()) {
                    this.gFJ.a((BaseCardView) com.baidu.tieba.lego.card.b.bzH().a(getPageContext(), bt, 5), bt);
                    this.gFJ.setVisibility(0);
                    this.gFJ.setIsShow(true);
                    if (this.gFw != null) {
                        this.gFw.a(this.gFJ);
                    }
                } else {
                    this.gFJ.setVisibility(8);
                    this.gFJ.setIsShow(false);
                    if (this.gFw != null) {
                        this.gFw.a((k) null);
                    }
                }
            }
        } catch (CardParseException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("float_btn");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("icon_url");
            String optString2 = optJSONObject.optString("icon_url_night");
            final String optString3 = optJSONObject.optString("scheme");
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                optString2 = optString;
            }
            this.gFC.setVisibility(0);
            this.gFC.startLoad(optString2, 10, false);
            this.gFC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(optString3)) {
                        q.f(LegoListActivity.this.getPageContext(), optString3);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eYS = getVoiceManager();
        if (this.eYS != null) {
            this.eYS.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.eYS = getVoiceManager();
        this.eYS.onStart(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.uD = true;
        this.eYS = getVoiceManager();
        this.eYS.onResume(getPageContext());
        this.lastResumeTime = System.currentTimeMillis();
        this.gFH = new WeakReference<>(TbadkCoreApplication.getInst());
        ad.a(this.gFH, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.uD = false;
        this.eYS = getVoiceManager();
        this.eYS.onPause(getPageContext());
        if (this.lastResumeTime != 0 && this.gFB) {
            r.bWG().bWC().a(this.gEF, this.itemId, this.gFG, System.currentTimeMillis() - this.lastResumeTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eYS = getVoiceManager();
        if (this.eYS != null) {
            this.eYS.onStop(getPageContext());
        }
        ad.a(this.gFH, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gFI != null) {
            this.gFI.destroy();
        }
        this.eYS = getVoiceManager();
        this.eYS.onDestory(getPageContext());
        this.gFD = null;
        if (this.gFJ != null) {
            this.gFJ.destory();
            this.gFJ = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gFy.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.pageType == 1) {
            if (this.gFx != null) {
                this.gFx.onChangeSkinType(i);
            }
        } else if (this.gFw != null) {
            this.gFw.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void po() {
        setSwipeBackEnabled(true);
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void pp() {
        setSwipeBackEnabled(false);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYS == null) {
            this.eYS = VoiceManager.instance();
        }
        return this.eYS;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        if (this.gFA && !TextUtils.isEmpty(this.gFD)) {
            super.overridePendingTransition(0, d.a.landingpage_quit);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.gFA && !TextUtils.isEmpty(this.gFD) && this.gFw != null) {
            this.gFw.oS();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tieba.lego.b
    public l getPlaySwitchController() {
        if (this.gFw != null) {
            return this.gFw.getPlaySwitchController();
        }
        return null;
    }

    @Override // com.baidu.tieba.lego.b
    public c bzr() {
        return this.gFI;
    }

    @Override // com.baidu.tieba.lego.b
    public LegoListFragment bzs() {
        return this.gFw;
    }
}
