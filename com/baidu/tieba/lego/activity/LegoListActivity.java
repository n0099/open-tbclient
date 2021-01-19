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
import com.baidu.tbadk.util.ah;
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
/* loaded from: classes8.dex */
public class LegoListActivity extends BaseFragmentActivity implements SwipeBackLayout.c, VoiceManager.c, b {
    VoiceManager jaA;
    LegoListFragment kSk;
    LegoTabFragment kSl;
    j kSm;
    RelativeLayout kSn;
    TbImageView kSp;
    private String kSq;
    private String kSr;
    private String kSs;
    private String kSt;
    private c kSu;
    private long lastResumeTime;
    String params;
    int rn;
    long kRu = 0;
    int pageType = 1;
    String itemId = "";
    boolean kRD = false;
    boolean hasAnimation = false;
    boolean kSo = false;
    private WeakReference<Context> ken = null;
    private boolean kSv = false;
    private LegoBottomView kSw = null;
    private CustomMessageListener kSx = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_LOAD_DATA_SUCCESS) { // from class: com.baidu.tieba.lego.activity.LegoListActivity.1
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
                        LegoListActivity.this.ew(jSONObject);
                        LegoListActivity.this.ev(jSONObject);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public final View.OnClickListener jdo = new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == LegoListActivity.this.kSm.fJL) {
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
            this.kRu = getIntent().getLongExtra("page_id", 0L);
            if (getIntent().hasExtra(LegoListActivityConfig.ITEM_ID)) {
                this.itemId = getIntent().getStringExtra(LegoListActivityConfig.ITEM_ID);
            }
            this.kRD = getIntent().getIntExtra(LegoListActivityConfig.IS_IMMERSIVE, 0) == 1;
            this.kSo = getIntent().getIntExtra(LegoListActivityConfig.IS_LANDINGPAGE, 0) == 1;
            this.hasAnimation = getIntent().getIntExtra(LegoListActivityConfig.HAS_ANIMATION, 0) == 1;
            this.rn = getIntent().getIntExtra("rn", 30);
            if (getIntent().hasExtra("params")) {
                this.params = getIntent().getStringExtra("params");
            }
            this.kSr = getIntent().getStringExtra(LegoListActivityConfig.NEXT_PAGE);
            this.kSq = getIntent().getStringExtra(LegoListActivityConfig.ANIMATION_INFO);
            if (!TextUtils.isEmpty(this.kSq)) {
                this.kSq = URLDecoder.decode(this.kSq);
            }
            if (!TextUtils.isEmpty(this.kSr)) {
                this.kSr = URLDecoder.decode(this.kSr);
            }
            this.kSs = getIntent().getStringExtra(LegoListActivityConfig.PRE_LOAD);
            if (!TextUtils.isEmpty(this.kSs)) {
                this.kSs = URLDecoder.decode(this.kSs);
            }
            this.kSt = getIntent().getStringExtra("source");
        }
        super.setHideStatusImmersiveStyle(this.kRD);
        super.onCreate(bundle);
        setContentView(R.layout.lego_list_activity);
        registerListener(this.kSx);
        e eVar = new e();
        eVar.kXA = this.kRu;
        eVar.kXB = this.pageType;
        eVar.itemId = this.itemId;
        eVar.rn = this.rn;
        eVar.params = this.params;
        eVar.refresh();
        this.jaA = getVoiceManager();
        this.jaA.onCreate(getPageContext());
        this.kSm = new j(this);
        this.kSp = (TbImageView) findViewById(R.id.float_btn);
        this.kSw = (LegoBottomView) findViewById(R.id.lego_bottom_view);
        this.kSn = (RelativeLayout) findViewById(R.id.navi_landingpage);
        this.kSu = new c(getPageContext(), findViewById(R.id.layout_float_video));
        this.kSu.setSwipeControlInterface(this);
        this.kSu.hide();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (this.pageType == 1) {
            this.kSl = new LegoTabFragment();
            this.kSl.b(this.kSm);
            this.kSl.hb(this.kRu);
            this.kSl.setItemId(this.itemId);
            this.kSl.setPrimary(true);
            beginTransaction.replace(R.id.fl_lego, this.kSl);
        } else {
            LegoListFragment.cZo();
            this.kSk = new LegoListFragment();
            this.kSk.b(this.kSm);
            this.kSk.b(this.kSn);
            this.kSk.a(this.kSu);
            this.kSk.hb(this.kRu);
            this.kSk.setItemId(this.itemId);
            this.kSk.setImmersive(this.kRD);
            this.kSk.setPrimary(true);
            this.kSk.MN(this.kSr);
            this.kSk.fI(this.kSq, this.kSs);
            this.kSk.tp(this.hasAnimation);
            this.kSk.tq(this.kSo);
            this.kSk.setFrom(this.kSt);
            beginTransaction.replace(R.id.fl_lego, this.kSk);
        }
        if (this.kRD) {
            this.kSm.hide();
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kSu.a(this, configuration);
        if (configuration.orientation == 2 && this.kSu.isShow()) {
            if (this.kSw != null) {
                this.kSw.setIsVideoLandscape(true);
                this.kSw.setVisibility(8);
            }
        } else if (this.kSw != null && this.kSw.isShow()) {
            this.kSw.setIsVideoLandscape(false);
            this.kSw.setVisibility(0);
        }
        if (this.kSk != null) {
            this.kSk.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.kSu == null || !this.kSu.isShow() || this.kSu.das()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.kSu.Ss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("bottom_card");
            if (optJSONObject != null) {
                com.baidu.tieba.lego.card.b.cZu();
                ICardInfo ex = com.baidu.tieba.lego.card.b.ex(optJSONObject);
                if (ex != null && ex.isValid()) {
                    this.kSw.a((BaseCardView) com.baidu.tieba.lego.card.b.cZu().a(getPageContext(), ex, 5), ex);
                    this.kSw.setVisibility(0);
                    this.kSw.setIsShow(true);
                    if (this.kSk != null) {
                        this.kSk.a(this.kSw);
                    }
                } else {
                    this.kSw.setVisibility(8);
                    this.kSw.setIsShow(false);
                    if (this.kSk != null) {
                        this.kSk.a((k) null);
                    }
                }
            }
        } catch (CardParseException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("float_btn");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("icon_url");
            String optString2 = optJSONObject.optString("icon_url_night");
            final String optString3 = optJSONObject.optString("scheme");
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                optString2 = optString;
            }
            this.kSp.setVisibility(0);
            this.kSp.startLoad(optString2, 10, false);
            this.kSp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(optString3)) {
                        v.h(LegoListActivity.this.getPageContext(), optString3);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jaA = getVoiceManager();
        if (this.jaA != null) {
            this.jaA.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.jaA = getVoiceManager();
        this.jaA.onStart(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kSv = true;
        this.jaA = getVoiceManager();
        this.jaA.onResume(getPageContext());
        this.lastResumeTime = System.currentTimeMillis();
        this.ken = new WeakReference<>(TbadkCoreApplication.getInst());
        ah.a(this.ken, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kSv = false;
        this.jaA = getVoiceManager();
        this.jaA.onPause(getPageContext());
        if (this.lastResumeTime != 0 && this.kSo) {
            r.dBe().dBa().b(this.kRu, this.itemId, this.kSt, System.currentTimeMillis() - this.lastResumeTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jaA = getVoiceManager();
        if (this.jaA != null) {
            this.jaA.onStop(getPageContext());
        }
        ah.a(this.ken, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.kSu != null) {
            this.kSu.destroy();
        }
        this.jaA = getVoiceManager();
        this.jaA.onDestory(getPageContext());
        this.kSq = null;
        if (this.kSw != null) {
            this.kSw.destory();
            this.kSw = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.kSm.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.pageType == 1) {
            if (this.kSl != null) {
                this.kSl.onChangeSkinType(i);
            }
        } else if (this.kSk != null) {
            this.kSk.onChangeSkinType(i);
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
        if (this.jaA == null) {
            this.jaA = VoiceManager.instance();
        }
        return this.jaA;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        if (this.hasAnimation && !TextUtils.isEmpty(this.kSq)) {
            super.overridePendingTransition(0, R.anim.landingpage_quit);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.hasAnimation && !TextUtils.isEmpty(this.kSq) && this.kSk != null) {
            this.kSk.endAnimation();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tieba.lego.b
    public n getPlaySwitchController() {
        if (this.kSk != null) {
            return this.kSk.getPlaySwitchController();
        }
        return null;
    }

    @Override // com.baidu.tieba.lego.b
    public c cZe() {
        return this.kSu;
    }

    @Override // com.baidu.tieba.lego.b
    public LegoListFragment cZf() {
        return this.kSk;
    }
}
