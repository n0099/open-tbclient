package com.baidu.tieba.yuyinala.person;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.animation.Animation;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.d.aa;
import com.baidu.live.d.x;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ax;
import com.baidu.live.data.ca;
import com.baidu.live.data.de;
import com.baidu.live.message.FollowPersonSucc;
import com.baidu.live.message.FollowPersonSuccMessage;
import com.baidu.live.personmanager.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.utils.i;
import com.baidu.live.view.g;
import com.baidu.tieba.yuyinala.person.view.PersonCardViewNew;
/* loaded from: classes11.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private boolean aJC;
    private String appId;
    private String bcX;
    private b cah;
    private String groupId;
    private PersonUserData hUO;
    private boolean hUT;
    private boolean hUV;
    private boolean hUW;
    private String liveId;
    private String metaKey;
    private PersonCardViewNew oMV;
    private Intent oMW;
    private String oMX;
    private ca oMY;
    private ca oMZ;
    private a oNa;
    private String otherParams;
    private String portrait;
    private String roomId;
    private String showName;
    private String userId;
    private String vid;
    private boolean hUU = false;
    CustomMessageListener gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.oMV != null) {
                    PersonCardActivity.this.oMV.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener gNu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && TextUtils.equals(updateAttentionMessage.getData().toUid, ExtraParamsManager.getEncryptionUserId(PersonCardActivity.this.userId))) {
                    if (updateAttentionMessage.getData().isSucc) {
                        PersonCardActivity.this.ebt();
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && message.getTag().equals(PersonCardActivity.this.getUniqueId())) {
                            if (updateAttentionMessage.getData().isAttention) {
                                if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
                                    PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.h.sdk_attention_success_toast));
                                } else {
                                    PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.h.sdk_attention_success_toast));
                                }
                                PersonCardActivity.this.oMV.wp(0);
                                return;
                            }
                            PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.h.sdk_unfollow_success_toast));
                            PersonCardActivity.this.oMV.wp(1);
                            return;
                        }
                        return;
                    }
                    if (!updateAttentionMessage.isAttention()) {
                        PersonCardActivity.this.oMV.wp(0);
                    } else {
                        PersonCardActivity.this.oMV.wp(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !g.XK().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener aWK = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hVc = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hVd = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.liveId, PersonCardActivity.this.groupId, "", PersonCardActivity.this.showName);
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void coC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.sdk_transparent)));
            }
            cmr();
            initView();
            this.oMV.a(this.hUO, true);
            setContentView(this.oMV.getRootView());
            initListener();
            initModel();
            if (!cms()) {
                j(this.userId, this.liveId, this.groupId, "", this.showName);
            }
            i.af(this.oMV.getRootView());
            TiebaInitialize.log("c11899");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.hUU) {
            this.oMV.getRootView().setVisibility(0);
            setContentView(this.oMV.getRootView());
            i.af(this.oMV.getRootView());
        }
    }

    private void cmr() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.oMX = getIntent().getStringExtra(YuyinAlaPersonCardActivityConfig.PERSON_USER_KEY);
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.showName = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.bcX = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aJC = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.hUV = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.hUW = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
        String stringExtra = getIntent().getStringExtra("PERSON_USER_NAME");
        String stringExtra2 = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        int intExtra = getIntent().getIntExtra("PERSON_SEX", 0);
        int intExtra2 = getIntent().getIntExtra("PERSON_LEVEL", 1);
        String stringExtra3 = getIntent().getStringExtra("PERSON_LOCATION");
        String stringExtra4 = getIntent().getStringExtra("PERSON_DESCRIPTION");
        long longExtra = getIntent().getLongExtra("PERSON_SEND_COUNT", 0L);
        long longExtra2 = getIntent().getLongExtra("PERSON_FANS_COUNT", 0L);
        long longExtra3 = getIntent().getLongExtra("PERSON_FOLLOWS_COUNT", 0L);
        getIntent().getIntExtra("PERSON_FOLLOW_STATUS", 0);
        this.oMW = (Intent) getIntent().getParcelableExtra(YuyinAlaPersonCardActivityConfig.PERSON_REENTER_GIFTCARD);
        this.hUO = new PersonUserData();
        this.hUO.user_info = new ax();
        this.hUO.location_info = new AlaLocationData();
        this.hUO.relation_info = new AlaRelationData();
        this.hUO.user_info.user_id = this.userId;
        this.hUO.user_info.user_name = stringExtra;
        this.hUO.user_info.user_nickname = this.showName;
        this.hUO.user_info.sex = intExtra;
        this.hUO.user_info.level_id = intExtra2;
        this.hUO.user_info.description = stringExtra4;
        this.hUO.user_info.send_count = longExtra;
        this.hUO.user_info.fans_count = longExtra2;
        this.hUO.user_info.follow_count = longExtra3;
        this.hUO.user_info.portrait = stringExtra2;
        this.hUO.user_info.third_app_id = this.appId;
        this.hUO.location_info.location = stringExtra3;
    }

    private void initView() {
        if (this.hUW && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hUW = com.baidu.live.ae.a.Qj().buX.aMw;
        }
        this.oMV = new PersonCardViewNew(this, false);
        this.oMV.aN(this.liveId, this.bcX);
        this.oMV.setOtherParams(this.otherParams);
        this.oMV.oX(this.hUV);
        this.oMV.oY(this.hUW);
        this.oMV.at(this.oMW);
        this.oMV.getRootView().setVisibility(0);
        this.oMV.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.a
            public void cmy() {
                PersonCardActivity.this.cmx();
            }
        });
    }

    private void initListener() {
        registerListener(this.aWK);
        registerListener(this.gNu);
        registerListener(this.gNG);
        registerListener(this.hVc);
        registerListener(this.hVd);
    }

    private void initModel() {
        this.cah = new b(getPageContext());
        this.cah.a(new b.a() { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.2
            @Override // com.baidu.live.personmanager.b.a
            public void b(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aOn;
                    }
                    if (personUserData.mYuyinAlaSdkData != null) {
                        PersonCardActivity.this.roomId = personUserData.mYuyinAlaSdkData.roomId;
                    }
                    PersonCardActivity.this.oMV.a(personUserData, false);
                }
            }

            @Override // com.baidu.live.personmanager.b.a
            public void b(ca caVar) {
                PersonCardActivity.this.oMY = caVar;
            }

            @Override // com.baidu.live.personmanager.b.a
            public void c(ca caVar) {
                PersonCardActivity.this.oMZ = caVar;
            }

            @Override // com.baidu.live.personmanager.b.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.oMY = null;
        this.oMZ = null;
        this.cah.c(str, this.oMX, str2, str3, str4, str5);
    }

    public boolean cms() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.bcX)) ? false : true;
    }

    public boolean Ij(String str) {
        return (TextUtils.isEmpty(this.bcX) || TextUtils.isEmpty(str) || !str.equals(this.bcX)) ? false : true;
    }

    public String cmt() {
        return this.bcX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hUT = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.hUT) {
            this.oMV.onResume();
        }
        this.hUT = false;
        UtilHelper.changeStatusBarIconAndTextColor(true, getPageContext().getPageActivity());
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.oMV == null) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebt() {
        MessageManager.getInstance().dispatchResponsedMessage(new FollowPersonSuccMessage(new FollowPersonSucc()));
    }

    public void cmu() {
        g.XK().a(ExtraParamsManager.getEncryptionUserId(this.userId), new de(ExtraParamsManager.getEncryptionUserId(this.userId), this.liveId, true, getUniqueId()));
    }

    public void cmv() {
        g.XK().a(ExtraParamsManager.getEncryptionUserId(this.userId), new de(ExtraParamsManager.getEncryptionUserId(this.userId), this.liveId, false, getUniqueId()));
    }

    public void cmw() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        aa aaVar = new aa(getPageContext().getPageActivity());
        aaVar.ak(this.liveId, this.roomId);
        aaVar.fk(ExtraParamsManager.getEncryptionUserId(this.userId));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, aaVar));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new x(this, this.userId, this.groupId, this.liveId, this.aJC, this.bcX, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cah != null) {
            this.cah.onDestroy();
        }
        if (this.oMV != null) {
            this.oMV.onDestroy();
        }
        if (this.hVc != null) {
            MessageManager.getInstance().unRegisterListener(this.hVc);
        }
        if (this.hVd != null) {
            MessageManager.getInstance().unRegisterListener(this.hVd);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.hUU) {
            this.hUU = true;
            Animation animation = null;
            if (this.oMV != null) {
                animation = this.oMV.bWH();
            }
            if (animation == null) {
                super.finish();
            } else {
                animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.8
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        PersonCardActivity.super.finish();
                        if (PersonCardActivity.this.oNa != null) {
                            PersonCardActivity.this.oNa.coC();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
            }
        }
    }

    public void a(a aVar) {
        this.oNa = aVar;
    }

    public void closeActivity() {
        super.finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
