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
/* loaded from: classes9.dex */
public class LegoListActivity extends BaseFragmentActivity implements SwipeBackLayout.c, VoiceManager.c, b {
    VoiceManager jfh;
    LegoListFragment kWP;
    LegoTabFragment kWQ;
    j kWR;
    RelativeLayout kWS;
    TbImageView kWU;
    private String kWV;
    private String kWW;
    private String kWX;
    private String kWY;
    private c kWZ;
    private long lastResumeTime;
    String params;
    int rn;
    long kVZ = 0;
    int pageType = 1;
    String itemId = "";
    boolean kWi = false;
    boolean hasAnimation = false;
    boolean kWT = false;
    private WeakReference<Context> kiU = null;
    private boolean kXa = false;
    private LegoBottomView kXb = null;
    private CustomMessageListener kXc = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_LOAD_DATA_SUCCESS) { // from class: com.baidu.tieba.lego.activity.LegoListActivity.1
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
    public final View.OnClickListener jhV = new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == LegoListActivity.this.kWR.fOs) {
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
            this.kVZ = getIntent().getLongExtra("page_id", 0L);
            if (getIntent().hasExtra(LegoListActivityConfig.ITEM_ID)) {
                this.itemId = getIntent().getStringExtra(LegoListActivityConfig.ITEM_ID);
            }
            this.kWi = getIntent().getIntExtra(LegoListActivityConfig.IS_IMMERSIVE, 0) == 1;
            this.kWT = getIntent().getIntExtra(LegoListActivityConfig.IS_LANDINGPAGE, 0) == 1;
            this.hasAnimation = getIntent().getIntExtra(LegoListActivityConfig.HAS_ANIMATION, 0) == 1;
            this.rn = getIntent().getIntExtra("rn", 30);
            if (getIntent().hasExtra("params")) {
                this.params = getIntent().getStringExtra("params");
            }
            this.kWW = getIntent().getStringExtra(LegoListActivityConfig.NEXT_PAGE);
            this.kWV = getIntent().getStringExtra(LegoListActivityConfig.ANIMATION_INFO);
            if (!TextUtils.isEmpty(this.kWV)) {
                this.kWV = URLDecoder.decode(this.kWV);
            }
            if (!TextUtils.isEmpty(this.kWW)) {
                this.kWW = URLDecoder.decode(this.kWW);
            }
            this.kWX = getIntent().getStringExtra(LegoListActivityConfig.PRE_LOAD);
            if (!TextUtils.isEmpty(this.kWX)) {
                this.kWX = URLDecoder.decode(this.kWX);
            }
            this.kWY = getIntent().getStringExtra("source");
        }
        super.setHideStatusImmersiveStyle(this.kWi);
        super.onCreate(bundle);
        setContentView(R.layout.lego_list_activity);
        registerListener(this.kXc);
        e eVar = new e();
        eVar.lcg = this.kVZ;
        eVar.lch = this.pageType;
        eVar.itemId = this.itemId;
        eVar.rn = this.rn;
        eVar.params = this.params;
        eVar.refresh();
        this.jfh = getVoiceManager();
        this.jfh.onCreate(getPageContext());
        this.kWR = new j(this);
        this.kWU = (TbImageView) findViewById(R.id.float_btn);
        this.kXb = (LegoBottomView) findViewById(R.id.lego_bottom_view);
        this.kWS = (RelativeLayout) findViewById(R.id.navi_landingpage);
        this.kWZ = new c(getPageContext(), findViewById(R.id.layout_float_video));
        this.kWZ.setSwipeControlInterface(this);
        this.kWZ.hide();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (this.pageType == 1) {
            this.kWQ = new LegoTabFragment();
            this.kWQ.b(this.kWR);
            this.kWQ.hb(this.kVZ);
            this.kWQ.setItemId(this.itemId);
            this.kWQ.setPrimary(true);
            beginTransaction.replace(R.id.fl_lego, this.kWQ);
        } else {
            LegoListFragment.ddg();
            this.kWP = new LegoListFragment();
            this.kWP.b(this.kWR);
            this.kWP.b(this.kWS);
            this.kWP.a(this.kWZ);
            this.kWP.hb(this.kVZ);
            this.kWP.setItemId(this.itemId);
            this.kWP.setImmersive(this.kWi);
            this.kWP.setPrimary(true);
            this.kWP.NU(this.kWW);
            this.kWP.fJ(this.kWV, this.kWX);
            this.kWP.tt(this.hasAnimation);
            this.kWP.tu(this.kWT);
            this.kWP.setFrom(this.kWY);
            beginTransaction.replace(R.id.fl_lego, this.kWP);
        }
        if (this.kWi) {
            this.kWR.hide();
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kWZ.a(this, configuration);
        if (configuration.orientation == 2 && this.kWZ.isShow()) {
            if (this.kXb != null) {
                this.kXb.setIsVideoLandscape(true);
                this.kXb.setVisibility(8);
            }
        } else if (this.kXb != null && this.kXb.isShow()) {
            this.kXb.setIsVideoLandscape(false);
            this.kXb.setVisibility(0);
        }
        if (this.kWP != null) {
            this.kWP.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.kWZ == null || !this.kWZ.isShow() || this.kWZ.dek()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.kWZ.Wl();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("bottom_card");
            if (optJSONObject != null) {
                com.baidu.tieba.lego.card.b.ddm();
                ICardInfo ex = com.baidu.tieba.lego.card.b.ex(optJSONObject);
                if (ex != null && ex.isValid()) {
                    this.kXb.a((BaseCardView) com.baidu.tieba.lego.card.b.ddm().a(getPageContext(), ex, 5), ex);
                    this.kXb.setVisibility(0);
                    this.kXb.setIsShow(true);
                    if (this.kWP != null) {
                        this.kWP.a(this.kXb);
                    }
                } else {
                    this.kXb.setVisibility(8);
                    this.kXb.setIsShow(false);
                    if (this.kWP != null) {
                        this.kWP.a((k) null);
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
            this.kWU.setVisibility(0);
            this.kWU.startLoad(optString2, 10, false);
            this.kWU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListActivity.2
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
        this.jfh = getVoiceManager();
        if (this.jfh != null) {
            this.jfh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.jfh = getVoiceManager();
        this.jfh.onStart(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kXa = true;
        this.jfh = getVoiceManager();
        this.jfh.onResume(getPageContext());
        this.lastResumeTime = System.currentTimeMillis();
        this.kiU = new WeakReference<>(TbadkCoreApplication.getInst());
        ah.a(this.kiU, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kXa = false;
        this.jfh = getVoiceManager();
        this.jfh.onPause(getPageContext());
        if (this.lastResumeTime != 0 && this.kWT) {
            r.dEW().dES().b(this.kVZ, this.itemId, this.kWY, System.currentTimeMillis() - this.lastResumeTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jfh = getVoiceManager();
        if (this.jfh != null) {
            this.jfh.onStop(getPageContext());
        }
        ah.a(this.kiU, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.kWZ != null) {
            this.kWZ.destroy();
        }
        this.jfh = getVoiceManager();
        this.jfh.onDestory(getPageContext());
        this.kWV = null;
        if (this.kXb != null) {
            this.kXb.destory();
            this.kXb = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.kWR.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.pageType == 1) {
            if (this.kWQ != null) {
                this.kWQ.onChangeSkinType(i);
            }
        } else if (this.kWP != null) {
            this.kWP.onChangeSkinType(i);
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
        if (this.jfh == null) {
            this.jfh = VoiceManager.instance();
        }
        return this.jfh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        if (this.hasAnimation && !TextUtils.isEmpty(this.kWV)) {
            super.overridePendingTransition(0, R.anim.landingpage_quit);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.hasAnimation && !TextUtils.isEmpty(this.kWV) && this.kWP != null) {
            this.kWP.endAnimation();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tieba.lego.b
    public n getPlaySwitchController() {
        if (this.kWP != null) {
            return this.kWP.getPlaySwitchController();
        }
        return null;
    }

    @Override // com.baidu.tieba.lego.b
    public c dcW() {
        return this.kWZ;
    }

    @Override // com.baidu.tieba.lego.b
    public LegoListFragment dcX() {
        return this.kWP;
    }
}
