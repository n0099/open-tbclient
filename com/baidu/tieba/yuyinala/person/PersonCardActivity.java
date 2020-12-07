package com.baidu.tieba.yuyinala.person;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.animation.Animation;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.fsg.base.utils.ResUtils;
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
import com.baidu.live.data.ar;
import com.baidu.live.data.bt;
import com.baidu.live.data.cw;
import com.baidu.live.message.FollowPersonSucc;
import com.baidu.live.message.FollowPersonSuccMessage;
import com.baidu.live.personmanager.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
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
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.yuyinala.person.view.PersonCardViewNew;
/* loaded from: classes4.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private boolean aLj;
    private String appId;
    private b bUW;
    private String bcY;
    private String groupId;
    private String hIC;
    private PersonUserData hID;
    private boolean hII;
    private boolean hIK;
    private boolean hIL;
    private String liveId;
    private String metaKey;
    private String otherParams;
    private PersonCardViewNew ozl;
    private Intent ozm;
    private String ozn;
    private bt ozo;
    private bt ozp;
    private String portrait;
    private String roomId;
    private String userId;
    private String vid;
    private boolean hIJ = false;
    CustomMessageListener gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.ozl != null) {
                    PersonCardActivity.this.ozl.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener gDs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && TextUtils.equals(updateAttentionMessage.getData().toUid, ExtraParamsManager.getEncryptionUserId(PersonCardActivity.this.userId))) {
                    if (updateAttentionMessage.getData().isSucc) {
                        PersonCardActivity.this.edC();
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && message.getTag().equals(PersonCardActivity.this.getUniqueId())) {
                            if (updateAttentionMessage.getData().isAttention) {
                                if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
                                    PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.h.sdk_attention_success_toast));
                                    PersonCardActivity.this.finish();
                                    return;
                                }
                                PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.h.sdk_attention_success_toast));
                                return;
                            }
                            PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.h.sdk_unfollow_success_toast));
                            return;
                        }
                        return;
                    }
                    if (!updateAttentionMessage.isAttention()) {
                        PersonCardActivity.this.ozl.xx(0);
                    } else {
                        PersonCardActivity.this.ozl.xx(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !g.YG().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener aWM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hIM = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hIN = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.liveId, PersonCardActivity.this.groupId, "", PersonCardActivity.this.hIC);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.sdk_transparent)));
            }
            cml();
            initView();
            this.ozl.a(this.hID, true);
            setContentView(this.ozl.getRootView());
            initListener();
            KR();
            if (!cmm()) {
                j(this.userId, this.liveId, this.groupId, "", this.hIC);
            }
            i.af(this.ozl.getRootView());
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.hIJ) {
            this.ozl.getRootView().setVisibility(0);
            setContentView(this.ozl.getRootView());
            i.af(this.ozl.getRootView());
        }
    }

    private void cml() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.ozn = getIntent().getStringExtra(YuyinAlaPersonCardActivityConfig.PERSON_USER_KEY);
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.hIC = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.bcY = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aLj = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.hIK = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.hIL = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.ozm = (Intent) getIntent().getParcelableExtra(YuyinAlaPersonCardActivityConfig.PERSON_REENTER_GIFTCARD);
        this.hID = new PersonUserData();
        this.hID.user_info = new ar();
        this.hID.location_info = new AlaLocationData();
        this.hID.relation_info = new AlaRelationData();
        this.hID.user_info.user_id = this.userId;
        this.hID.user_info.user_name = stringExtra;
        this.hID.user_info.user_nickname = this.hIC;
        this.hID.user_info.sex = intExtra;
        this.hID.user_info.level_id = intExtra2;
        this.hID.user_info.description = stringExtra4;
        this.hID.user_info.send_count = longExtra;
        this.hID.user_info.fans_count = longExtra2;
        this.hID.user_info.follow_count = longExtra3;
        this.hID.user_info.portrait = stringExtra2;
        this.hID.user_info.third_app_id = this.appId;
        this.hID.location_info.location = stringExtra3;
    }

    private void initView() {
        if (this.hIL && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hIL = com.baidu.live.ae.a.RB().brA.aNV;
        }
        this.ozl = new PersonCardViewNew(this, false);
        this.ozl.aT(this.liveId, this.bcY);
        this.ozl.setOtherParams(this.otherParams);
        this.ozl.os(this.hIK);
        this.ozl.ot(this.hIL);
        this.ozl.av(this.ozm);
        this.ozl.getRootView().setVisibility(0);
        this.ozl.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.a
            public void cms() {
                PersonCardActivity.this.cmr();
            }
        });
    }

    private void initListener() {
        registerListener(this.aWM);
        registerListener(this.gDs);
        registerListener(this.gDE);
        registerListener(this.hIM);
        registerListener(this.hIN);
    }

    private void KR() {
        this.bUW = new b(getPageContext());
        this.bUW.a(new b.a() { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.2
            @Override // com.baidu.live.personmanager.b.a
            public void b(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aPp;
                    }
                    if (personUserData.mYuyinAlaSdkData != null) {
                        PersonCardActivity.this.roomId = personUserData.mYuyinAlaSdkData.roomId;
                    }
                    PersonCardActivity.this.ozl.a(personUserData, false);
                }
            }

            @Override // com.baidu.live.personmanager.b.a
            public void b(bt btVar) {
                PersonCardActivity.this.ozo = btVar;
            }

            @Override // com.baidu.live.personmanager.b.a
            public void c(bt btVar) {
                PersonCardActivity.this.ozp = btVar;
            }

            @Override // com.baidu.live.personmanager.b.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.ozo = null;
        this.ozp = null;
        this.bUW.b(str, this.ozn, str2, str3, str4, str5);
    }

    public boolean cmm() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.bcY)) ? false : true;
    }

    public boolean IS(String str) {
        return (TextUtils.isEmpty(this.bcY) || TextUtils.isEmpty(str) || !str.equals(this.bcY)) ? false : true;
    }

    public String cmn() {
        return this.bcY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hII = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.hII) {
            this.ozl.onResume();
        }
        this.hII = false;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.ozl == null) {
            return super.onKeyDown(i, keyEvent);
        }
        this.ozl.egu();
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edC() {
        MessageManager.getInstance().dispatchResponsedMessage(new FollowPersonSuccMessage(new FollowPersonSucc()));
    }

    public void cmo() {
        g.YG().a(ExtraParamsManager.getEncryptionUserId(this.userId), new cw(ExtraParamsManager.getEncryptionUserId(this.userId), this.liveId, true, getUniqueId()));
    }

    public void cmp() {
        g.YG().a(ExtraParamsManager.getEncryptionUserId(this.userId), new cw(ExtraParamsManager.getEncryptionUserId(this.userId), this.liveId, false, getUniqueId()));
    }

    public void cmq() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        aa aaVar = new aa(getPageContext().getPageActivity());
        aaVar.am(this.liveId, this.roomId);
        aaVar.gu(ExtraParamsManager.getEncryptionUserId(this.userId));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, aaVar));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmr() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new x(this, this.userId, this.groupId, this.liveId, this.aLj, this.bcY, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0205a.alpha_in, 0);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
                overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", ResUtils.ANIM));
            } else {
                overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_in", ResUtils.ANIM), 0);
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bUW != null) {
            this.bUW.onDestroy();
        }
        if (this.ozl != null) {
            this.ozl.onDestroy();
        }
        if (this.hIM != null) {
            MessageManager.getInstance().unRegisterListener(this.hIM);
        }
        if (this.hIN != null) {
            MessageManager.getInstance().unRegisterListener(this.hIN);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.hIJ) {
            this.hIJ = true;
            Animation animation = null;
            if (this.ozl != null) {
                animation = this.ozl.bXh();
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
                        if (PersonCardActivity.this instanceof Activity) {
                            PersonCardActivity.this.overridePendingTransition(a.C0205a.alpha_in, a.C0205a.alpha_out);
                        } else {
                            PersonCardActivity.this.overridePendingTransition(0, Util.getHostResourcesId(PersonCardActivity.this.getActivity(), TbConfig.PACKAGE_NAME, "sdk_fade_out", ResUtils.ANIM));
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
            }
        }
    }

    public void closeActivity() {
        super.finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }
}
