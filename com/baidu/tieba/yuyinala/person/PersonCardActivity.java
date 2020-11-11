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
import com.baidu.live.b.w;
import com.baidu.live.b.z;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.aq;
import com.baidu.live.data.bs;
import com.baidu.live.data.cu;
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
    private boolean aKf;
    private String appId;
    private b bRw;
    private String bbl;
    private String groupId;
    private String hzq;
    private PersonUserData hzr;
    private boolean hzw;
    private boolean hzy;
    private boolean hzz;
    private String liveId;
    private String metaKey;
    private PersonCardViewNew oiI;
    private Intent oiJ;
    private String oiK;
    private bs oiL;
    private bs oiM;
    private String otherParams;
    private String portrait;
    private String roomId;
    private String userId;
    private String vid;
    private boolean hzx = false;
    CustomMessageListener gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.oiI != null) {
                    PersonCardActivity.this.oiI.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener gvc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && TextUtils.equals(updateAttentionMessage.getData().toUid, ExtraParamsManager.getEncryptionUserId(PersonCardActivity.this.userId))) {
                    if (updateAttentionMessage.getData().isSucc) {
                        PersonCardActivity.this.dXZ();
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
                        PersonCardActivity.this.oiI.wu(0);
                    } else {
                        PersonCardActivity.this.oiI.wu(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !g.WP().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener aVt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hzA = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener hzB = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.liveId, PersonCardActivity.this.groupId, "", PersonCardActivity.this.hzq);
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
            ciY();
            initView();
            this.oiI.a(this.hzr, true);
            setContentView(this.oiI.getRootView());
            initListener();
            Jz();
            if (!ciZ()) {
                j(this.userId, this.liveId, this.groupId, "", this.hzq);
            }
            i.af(this.oiI.getRootView());
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.hzx) {
            this.oiI.getRootView().setVisibility(0);
            setContentView(this.oiI.getRootView());
            i.af(this.oiI.getRootView());
        }
    }

    private void ciY() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.oiK = getIntent().getStringExtra(YuyinAlaPersonCardActivityConfig.PERSON_USER_KEY);
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.hzq = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.bbl = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aKf = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.hzy = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.hzz = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.oiJ = (Intent) getIntent().getParcelableExtra(YuyinAlaPersonCardActivityConfig.PERSON_REENTER_GIFTCARD);
        this.hzr = new PersonUserData();
        this.hzr.user_info = new aq();
        this.hzr.location_info = new AlaLocationData();
        this.hzr.relation_info = new AlaRelationData();
        this.hzr.user_info.user_id = this.userId;
        this.hzr.user_info.user_name = stringExtra;
        this.hzr.user_info.user_nickname = this.hzq;
        this.hzr.user_info.sex = intExtra;
        this.hzr.user_info.level_id = intExtra2;
        this.hzr.user_info.description = stringExtra4;
        this.hzr.user_info.send_count = longExtra;
        this.hzr.user_info.fans_count = longExtra2;
        this.hzr.user_info.follow_count = longExtra3;
        this.hzr.user_info.portrait = stringExtra2;
        this.hzr.user_info.third_app_id = this.appId;
        this.hzr.location_info.location = stringExtra3;
    }

    private void initView() {
        if (this.hzz && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hzz = com.baidu.live.aa.a.PQ().bod.aML;
        }
        this.oiI = new PersonCardViewNew(this, false);
        this.oiI.aQ(this.liveId, this.bbl);
        this.oiI.setOtherParams(this.otherParams);
        this.oiI.nW(this.hzy);
        this.oiI.nX(this.hzz);
        this.oiI.av(this.oiJ);
        this.oiI.getRootView().setVisibility(0);
        this.oiI.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.a
            public void cjf() {
                PersonCardActivity.this.cje();
            }
        });
    }

    private void initListener() {
        registerListener(this.aVt);
        registerListener(this.gvc);
        registerListener(this.gvo);
        registerListener(this.hzA);
        registerListener(this.hzB);
    }

    private void Jz() {
        this.bRw = new b(getPageContext());
        this.bRw.a(new b.a() { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.2
            @Override // com.baidu.live.personmanager.b.a
            public void b(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aOb;
                    }
                    if (personUserData.mYuyinAlaSdkData != null) {
                        PersonCardActivity.this.roomId = personUserData.mYuyinAlaSdkData.roomId;
                    }
                    PersonCardActivity.this.oiI.a(personUserData, false);
                }
            }

            @Override // com.baidu.live.personmanager.b.a
            public void b(bs bsVar) {
                PersonCardActivity.this.oiL = bsVar;
            }

            @Override // com.baidu.live.personmanager.b.a
            public void c(bs bsVar) {
                PersonCardActivity.this.oiM = bsVar;
            }

            @Override // com.baidu.live.personmanager.b.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.oiL = null;
        this.oiM = null;
        this.bRw.b(str, this.oiK, str2, str3, str4, str5);
    }

    public boolean ciZ() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.bbl)) ? false : true;
    }

    public boolean IC(String str) {
        return (TextUtils.isEmpty(this.bbl) || TextUtils.isEmpty(str) || !str.equals(this.bbl)) ? false : true;
    }

    public String cja() {
        return this.bbl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hzw = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.hzw) {
            this.oiI.onResume();
        }
        this.hzw = false;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.oiI == null) {
            return super.onKeyDown(i, keyEvent);
        }
        this.oiI.eaQ();
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXZ() {
        MessageManager.getInstance().dispatchResponsedMessage(new FollowPersonSuccMessage(new FollowPersonSucc()));
    }

    public void cjb() {
        g.WP().a(ExtraParamsManager.getEncryptionUserId(this.userId), new cu(ExtraParamsManager.getEncryptionUserId(this.userId), this.liveId, true, getUniqueId()));
    }

    public void cjc() {
        g.WP().a(ExtraParamsManager.getEncryptionUserId(this.userId), new cu(ExtraParamsManager.getEncryptionUserId(this.userId), this.liveId, false, getUniqueId()));
    }

    public void cjd() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        z zVar = new z(getPageContext().getPageActivity());
        zVar.ai(this.liveId, this.roomId);
        zVar.ge(ExtraParamsManager.getEncryptionUserId(this.userId));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, zVar));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cje() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new w(this, this.userId, this.groupId, this.liveId, this.aKf, this.bbl, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0197a.alpha_in, 0);
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
        if (this.bRw != null) {
            this.bRw.onDestroy();
        }
        if (this.oiI != null) {
            this.oiI.onDestroy();
        }
        if (this.hzA != null) {
            MessageManager.getInstance().unRegisterListener(this.hzA);
        }
        if (this.hzB != null) {
            MessageManager.getInstance().unRegisterListener(this.hzB);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.hzx) {
            this.hzx = true;
            Animation animation = null;
            if (this.oiI != null) {
                animation = this.oiI.bUe();
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
                            PersonCardActivity.this.overridePendingTransition(a.C0197a.alpha_in, a.C0197a.alpha_out);
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
