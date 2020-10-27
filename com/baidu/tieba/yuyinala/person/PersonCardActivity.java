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
import com.baidu.live.data.ap;
import com.baidu.live.data.br;
import com.baidu.live.data.cq;
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
import com.baidu.live.view.h;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.yuyinala.person.view.PersonCardViewNew;
/* loaded from: classes4.dex */
public class PersonCardActivity extends BaseFragmentActivity {
    private boolean aJi;
    private String aZS;
    private String appId;
    private b bLO;
    private String groupId;
    private boolean htB;
    private boolean htC;
    private String htt;
    private PersonUserData htu;
    private boolean htz;
    private String liveId;
    private String metaKey;
    private PersonCardViewNew nZM;
    private Intent nZN;
    private String nZO;
    private br nZP;
    private br nZQ;
    private String otherParams;
    private String portrait;
    private String roomId;
    private String userId;
    private String vid;
    private boolean htA = false;
    CustomMessageListener gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                PersonCardActivity.this.otherParams = str;
                if (PersonCardActivity.this.nZM != null) {
                    PersonCardActivity.this.nZM.setOtherParams(PersonCardActivity.this.otherParams);
                }
            }
        }
    };
    private CustomMessageListener gpo = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && TextUtils.equals(updateAttentionMessage.getData().toUid, ExtraParamsManager.getEncryptionUserId(PersonCardActivity.this.userId))) {
                    if (updateAttentionMessage.getData().isSucc) {
                        PersonCardActivity.this.dVk();
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && message.getTag().equals(PersonCardActivity.this.getUniqueId())) {
                            if (updateAttentionMessage.getData().isAttention) {
                                if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
                                    PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.i.sdk_attention_success_toast));
                                    PersonCardActivity.this.finish();
                                    return;
                                }
                                PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.i.sdk_attention_success_toast));
                                return;
                            }
                            PersonCardActivity.this.showToast(PersonCardActivity.this.getResources().getString(a.i.sdk_unfollow_success_toast));
                            return;
                        }
                        return;
                    }
                    if (!updateAttentionMessage.isAttention()) {
                        PersonCardActivity.this.nZM.wh(0);
                    } else {
                        PersonCardActivity.this.nZM.wh(1);
                    }
                    Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                    if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonCardActivity.this.getUniqueId()) && !h.Up().a(updateAttentionMessage.getData(), (BdPageContext<?>) PersonCardActivity.this.getPageContext(), false) && updateAttentionMessage.getData().errorString != null) {
                        PersonCardActivity.this.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    CustomMessageListener aUb = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener htD = new CustomMessageListener(2913186) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.closeActivity();
        }
    };
    CustomMessageListener htE = new CustomMessageListener(2913203) { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PersonCardActivity.this.j(PersonCardActivity.this.userId, PersonCardActivity.this.liveId, PersonCardActivity.this.groupId, "", PersonCardActivity.this.htt);
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
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
            }
            cgw();
            initView();
            this.nZM.a(this.htu, true);
            setContentView(this.nZM.getRootView());
            initListener();
            IY();
            if (!cgx()) {
                j(this.userId, this.liveId, this.groupId, "", this.htt);
            }
            i.ab(this.nZM.getRootView());
            TiebaInitialize.log("c11899");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.htA) {
            this.nZM.getRootView().setVisibility(0);
            setContentView(this.nZM.getRootView());
            i.ab(this.nZM.getRootView());
        }
    }

    private void cgw() {
        this.userId = getIntent().getStringExtra("PERSON_USER_ID");
        this.nZO = getIntent().getStringExtra(YuyinAlaPersonCardActivityConfig.PERSON_USER_KEY);
        this.portrait = getIntent().getStringExtra("PERSON_PORTRAIT_URL");
        this.htt = getIntent().getStringExtra(AlaPersonCardActivityConfig.PERSON_SHOW_NAME);
        this.groupId = getIntent().getStringExtra("PERSON_GROUP_ID");
        this.liveId = getIntent().getStringExtra("PERSON_LIVE_ID");
        this.vid = getIntent().getStringExtra("vid");
        this.aZS = getIntent().getStringExtra("PERSON_LIVE_OWNER_UID");
        this.aJi = getIntent().getBooleanExtra("PERSON_LIVE_OWNER_FLAG", false);
        this.appId = getIntent().getStringExtra("PERSON_APP_ID");
        this.otherParams = getIntent().getStringExtra("other_params");
        this.htB = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_IS_FROM_GUARD_CLUB, false);
        this.htC = getIntent().getBooleanExtra(AlaPersonCardActivityConfig.PERSON_NAV_LIVEROOM_ENABLED, false);
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
        this.nZN = (Intent) getIntent().getParcelableExtra(YuyinAlaPersonCardActivityConfig.PERSON_REENTER_GIFTCARD);
        this.htu = new PersonUserData();
        this.htu.user_info = new ap();
        this.htu.location_info = new AlaLocationData();
        this.htu.relation_info = new AlaRelationData();
        this.htu.user_info.user_id = this.userId;
        this.htu.user_info.user_name = stringExtra;
        this.htu.user_info.user_nickname = this.htt;
        this.htu.user_info.sex = intExtra;
        this.htu.user_info.level_id = intExtra2;
        this.htu.user_info.description = stringExtra4;
        this.htu.user_info.send_count = longExtra;
        this.htu.user_info.fans_count = longExtra2;
        this.htu.user_info.follow_count = longExtra3;
        this.htu.user_info.portrait = stringExtra2;
        this.htu.user_info.third_app_id = this.appId;
        this.htu.location_info.location = stringExtra3;
    }

    private void initView() {
        if (this.htC && TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.htC = com.baidu.live.z.a.Pq().bmJ.aLL;
        }
        this.nZM = new PersonCardViewNew(this, false);
        this.nZM.aP(this.liveId, this.aZS);
        this.nZM.setOtherParams(this.otherParams);
        this.nZM.nN(this.htB);
        this.nZM.nO(this.htC);
        this.nZM.av(this.nZN);
        this.nZM.getRootView().setVisibility(0);
        this.nZM.a(new PersonCardViewNew.a() { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.1
            @Override // com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.a
            public void cgD() {
                PersonCardActivity.this.cgC();
            }
        });
    }

    private void initListener() {
        registerListener(this.aUb);
        registerListener(this.gpo);
        registerListener(this.gpA);
        registerListener(this.htD);
        registerListener(this.htE);
    }

    private void IY() {
        this.bLO = new b(getPageContext());
        this.bLO.a(new b.a() { // from class: com.baidu.tieba.yuyinala.person.PersonCardActivity.2
            @Override // com.baidu.live.personmanager.b.a
            public void b(PersonUserData personUserData) {
                if (personUserData != null) {
                    if (personUserData.user_info != null) {
                        PersonCardActivity.this.userId = personUserData.user_info.user_id;
                        PersonCardActivity.this.portrait = personUserData.user_info.portrait;
                        PersonCardActivity.this.metaKey = personUserData.user_info.aMZ;
                    }
                    if (personUserData.mYuyinAlaSdkData != null) {
                        PersonCardActivity.this.roomId = personUserData.mYuyinAlaSdkData.roomId;
                    }
                    PersonCardActivity.this.nZM.a(personUserData, false);
                }
            }

            @Override // com.baidu.live.personmanager.b.a
            public void b(br brVar) {
                PersonCardActivity.this.nZP = brVar;
            }

            @Override // com.baidu.live.personmanager.b.a
            public void c(br brVar) {
                PersonCardActivity.this.nZQ = brVar;
            }

            @Override // com.baidu.live.personmanager.b.a
            public void onFail(String str) {
                PersonCardActivity.this.showToast(str);
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.nZP = null;
        this.nZQ = null;
        this.bLO.b(str, this.nZO, str2, str3, str4, str5);
    }

    public boolean cgx() {
        return (TextUtils.isEmpty(this.appId) || this.userId == null || this.userId.equals(this.aZS)) ? false : true;
    }

    public boolean Il(String str) {
        return (TextUtils.isEmpty(this.aZS) || TextUtils.isEmpty(str) || !str.equals(this.aZS)) ? false : true;
    }

    public String cgy() {
        return this.aZS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.htz = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.htz) {
            this.nZM.onResume();
        }
        this.htz = false;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.nZM == null) {
            return super.onKeyDown(i, keyEvent);
        }
        this.nZM.dXk();
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVk() {
        MessageManager.getInstance().dispatchResponsedMessage(new FollowPersonSuccMessage(new FollowPersonSucc()));
    }

    public void cgz() {
        h.Up().a(ExtraParamsManager.getEncryptionUserId(this.userId), new cq(ExtraParamsManager.getEncryptionUserId(this.userId), this.liveId, true, getUniqueId()));
    }

    public void cgA() {
        h.Up().a(ExtraParamsManager.getEncryptionUserId(this.userId), new cq(ExtraParamsManager.getEncryptionUserId(this.userId), this.liveId, false, getUniqueId()));
    }

    public void cgB() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
            return;
        }
        z zVar = new z(getPageContext().getPageActivity());
        zVar.ah(this.liveId, this.roomId);
        zVar.fZ(ExtraParamsManager.getEncryptionUserId(this.userId));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, zVar));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgC() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new w(this, this.userId, this.groupId, this.liveId, this.aJi, this.aZS, this.otherParams)));
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            if (this instanceof Activity) {
                overridePendingTransition(a.C0195a.alpha_in, 0);
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
        if (this.bLO != null) {
            this.bLO.onDestroy();
        }
        if (this.nZM != null) {
            this.nZM.onDestroy();
        }
        if (this.htD != null) {
            MessageManager.getInstance().unRegisterListener(this.htD);
        }
        if (this.htE != null) {
            MessageManager.getInstance().unRegisterListener(this.htE);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (!this.htA) {
            this.htA = true;
            Animation animation = null;
            if (this.nZM != null) {
                animation = this.nZM.bRF();
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
                            PersonCardActivity.this.overridePendingTransition(a.C0195a.alpha_in, a.C0195a.alpha_out);
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
