package com.baidu.tieba.personInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.gift.BuyGiftActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.account.appeal.AppealActivity;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.person.PersonChangeActivity;
import com.baidu.tieba.person.PersonImageActivity;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.person.post.PersonPostActivity;
/* loaded from: classes.dex */
public class PersonInfoActivity extends BaseActivity {
    private static boolean aAU;
    private static final String byT;
    private PersonChangeData adR;
    private com.baidu.tieba.model.d bEr;
    private v bEs;
    private ae bEt;
    private boolean mIsHost;
    private com.baidu.tieba.b.a aAE = null;
    private boolean bEq = false;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private com.baidu.adp.framework.listener.a bEu = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e bEv = new h(this, 104102);
    final com.baidu.adp.framework.listener.e bEw = new i(this, 304102);
    final CustomMessageListener bEx = new j(this, 2001178);
    private final CustomMessageListener aAP = new k(this, 2001178);
    private final com.baidu.adp.framework.listener.e bEy = new l(this, 304103);
    private CustomMessageListener bEz = new m(this, 2001238);
    private CustomMessageListener bEA = new n(this, 2001118);
    private final CustomMessageListener bEB = new o(this, 2001124);
    private final CustomMessageListener bEC = new b(this, 2001237);

    static {
        HM();
        aAU = false;
        byT = String.valueOf(com.baidu.tieba.data.e.ajt) + "mo/q/topic_page/135_1";
    }

    private static void HM() {
        ai.a(303012, ProfileSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PROFILE_HTTP_CMD, ai.s("c/u/user/profile", 303012));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ProfileHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public v aap() {
        return this.bEs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k(bundle);
        this.mIsHost = this.bEs.getIsSelf();
        registerListener();
        aaq();
        initUI();
        UW();
    }

    private void registerListener() {
        registerListener(this.bEu);
        registerListener(this.bEv);
        registerListener(this.bEw);
        registerListener(this.bEx);
        registerListener(this.bEy);
        registerListener(this.aAP);
        registerListener(this.bEA);
        registerListener(this.bEB);
        registerListener(this.bEC);
        registerListener(this.bEz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aaq();
        this.bEs.aag();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgGiftNum();
        this.bEq = false;
        if (aAU) {
            this.bEs.aaZ();
            aAU = false;
            return;
        }
        long msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgFans();
        if (msgFans != this.bEs.aaQ() && msgFans > 0) {
            this.bEs.X(msgFans);
            this.bEt.ey(true);
        }
        if (msgGiftNum > 0) {
            this.bEs.hd(msgGiftNum);
            this.bEt.hc(msgGiftNum);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.bEt.onStart();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.bEt.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bEs.aaX();
    }

    private void aaq() {
        com.baidu.tbadk.imageManager.e.sg().cQ(TbConfig.getBigImageMaxUsedMemory() - (TbConfig.getBigImageMaxUsedMemory() - 1152000));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        com.baidu.tbadk.imageManager.e.sg().cQ(TbConfig.getBigImageMaxUsedMemory());
        this.bEt.onStop();
        super.onStop();
    }

    private void initUI() {
        this.bEt = new ae(this, this.mIsHost);
        this.bEt.setExpandListRefreshListener(new c(this));
        if (this.mIsHost) {
            this.bEs.aaY();
        }
        this.bEt.Nj();
    }

    public static void ex(boolean z) {
        aAU = z;
    }

    private void UW() {
        if (this.aAE == null) {
            this.aAE = new com.baidu.tieba.b.a("profileStat");
            this.aAE.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bEt.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bEs != null) {
            bundle.putBoolean("self", this.bEs.getIsSelf());
            bundle.putString("un", this.bEs.getId());
            bundle.putString("name", this.bEs.getName());
            bundle.putBoolean("tab_page", this.bEs.aaT());
            bundle.putBoolean("tab_msg", this.bEs.aaU());
            bundle.putString("from", this.bEs.aaV());
            bundle.putString("st_type", this.bEs.getStType());
        }
    }

    private void k(Bundle bundle) {
        this.adR = new PersonChangeData();
        this.bEr = new com.baidu.tieba.model.d(this);
        this.bEs = new v(this);
        if (bundle != null) {
            this.bEs.hi(bundle.getString("from"));
            this.bEs.setIsSelf(bundle.getBoolean("self", false));
            this.bEs.setId(bundle.getString("un"));
            this.bEs.setName(bundle.getString("name"));
            this.bEs.ez(bundle.getBoolean("tab_page", false));
            this.bEs.eA(bundle.getBoolean("tab_msg", false));
            this.bEs.setStType(bundle.getString("st_type"));
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bEs.hi(intent.getStringExtra("from_forum"));
                this.bEs.setIsSelf(intent.getBooleanExtra("self", false));
                this.bEs.setId(intent.getStringExtra("un"));
                this.bEs.setName(intent.getStringExtra("name"));
                this.bEs.ez(intent.getBooleanExtra("tab_page", false));
                this.bEs.eA(intent.getBooleanExtra("tab_msg", false));
                this.bEs.setStType(intent.getStringExtra("st_type"));
            }
        }
        this.bEs.setLoadDataCallBack(new d(this));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                m(intent);
            } else if (i == 12002) {
                if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
                    this.writeImagesInfo.parseJson(stringExtra);
                    this.writeImagesInfo.updateQuality();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath());
                    }
                    this.writeImagesInfo.clear();
                }
            } else if (i == 12001) {
                EditHeadActivity.a(this, 12001, 12010, null, TbadkApplication.getCurrentAccountObj());
            } else if (i == 12010 || i == 12009) {
                if (this.adR != null) {
                    this.adR.setPhotoChanged(true);
                }
                if (this.bEs.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.sg().dr(this.bEs.getUserData().getPortrait());
                }
                this.bEs.aaZ();
            }
        } else if (i2 == 0 && i == 12010) {
            av.h(this);
        }
    }

    private void m(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
        if (personChangeData != null && this.bEs.getUserData() != null) {
            this.bEs.c(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.adR != null) {
                    this.adR.setPhotoChanged(true);
                }
                if (this.bEs.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.sg().dr(this.bEs.getUserData().getPortrait());
                }
            }
        }
        this.bEs.aaZ();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getId() == this.bEt.xO().getId()) {
            finish();
        } else if (view.getId() == this.bEt.abg().getId()) {
            if (!this.mIsHost) {
                aav();
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.bEs.getUserData() != null) {
                personChangeData.setName(this.bEs.getUserData().getName_show());
                personChangeData.setIntro(this.bEs.getUserData().getIntro());
                personChangeData.setSex(this.bEs.getUserData().getSex());
                personChangeData.setPortrait(this.bEs.getUserData().getPortrait());
            }
            PersonChangeActivity.a(this, 101, personChangeData, true);
            com.baidu.tbadk.core.i.l(this, "person_editprofile_click");
        } else if (view.getId() == this.bEt.aaL().getId()) {
            if (this.bEs.getUserData() != null) {
                if (this.bEs.getIsSelf()) {
                    aat();
                } else {
                    aau();
                }
            }
        } else if (view.getId() == this.bEt.aaO().getId()) {
            this.bEs.aaW();
        } else if (view.getId() == this.bEt.aaM().getId()) {
            if (this.bEs.getUserData() != null) {
                TbWebViewActivity.startActivity(this, getString(com.baidu.tieba.y.user_icon_intro), String.valueOf(byT) + "?st_type=person_user_icon");
            }
        } else if (view.getId() == this.bEt.aaD().getId()) {
            if (this.bEs.getIsSelf()) {
                com.baidu.tbadk.core.i.l(this, "person_self_group_click");
            } else if (hb(3)) {
                com.baidu.tbadk.core.i.l(this, "person_guid_group_click");
            } else {
                return;
            }
            UserData userData = this.bEs.getUserData();
            if (userData != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this, this.bEs.getId(), userData.getSex())));
            }
        } else if (view.getId() == this.bEt.abd().getId()) {
            aas();
        } else if (view.getId() == this.bEt.aay().getId()) {
            UserData userData2 = this.bEs.getUserData();
            if (userData2 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this, this.bEs.getId(), userData2.getSex(), 1)));
            }
        } else if (view.getId() == this.bEt.aaA().getId()) {
            UserData userData3 = this.bEs.getUserData();
            if (userData3 != null) {
                sendMessage(new CustomMessage(2002001, new PersonFriendActivityConfig(this, this.bEs.getId(), userData3.getSex(), 1)));
            }
        } else if (view.getId() == this.bEt.aax().getId()) {
            UserData userData4 = this.bEs.getUserData();
            if (userData4 != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this, userData4.getUserId(), userData4.getSex(), 1)));
            }
        } else if (view.getId() == this.bEt.aaw().getId()) {
            UserData userData5 = this.bEs.getUserData();
            if (userData5 != null) {
                if (this.mIsHost) {
                    str = "iowner_gift";
                } else {
                    str = "iguest_gift";
                }
                sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this, userData5.getUserId(), userData5.getSex(), str)));
                this.bEt.hc(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.oB().oQ();
            }
        } else if (view.getId() == this.bEt.aaB().getId()) {
            if (this.bEs.getIsSelf()) {
                com.baidu.tbadk.core.i.l(this, "person_self_attentionme_click");
            } else {
                com.baidu.tbadk.core.i.l(this, "person_guid_attentionme_click");
            }
            UserData userData6 = this.bEs.getUserData();
            if (userData6 != null) {
                this.bEt.ey(false);
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this, false, userData6.getUserId(), userData6.getSex())));
            }
        } else if (view.getId() == this.bEt.aaC().getId()) {
            if (this.bEs.getIsSelf()) {
                com.baidu.tbadk.core.i.l(this, "person_self_attentionper_click");
            } else {
                com.baidu.tbadk.core.i.l(this, "person_guid_attentionper_click");
            }
            UserData userData7 = this.bEs.getUserData();
            if (userData7 != null) {
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this, true, userData7.getUserId(), userData7.getSex())));
            }
        } else if (view.getId() == this.bEt.aaE().getId()) {
            if (this.bEs.getIsSelf()) {
                com.baidu.tbadk.core.i.l(this, "person_self_attentionbar_click");
            } else if (hb(2)) {
                com.baidu.tbadk.core.i.l(this, "person_guid_attentionbar_click");
            } else {
                return;
            }
            UserData userData8 = this.bEs.getUserData();
            if (userData8 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this, this.bEs.getId(), userData8.getSex())));
            }
        } else if (view.getId() == this.bEt.aaF().getId()) {
            if (this.bEs.getIsSelf()) {
                com.baidu.tbadk.core.i.l(this, "person_self_thread_click");
            } else if (hb(4)) {
                com.baidu.tbadk.core.i.l(this, "person_guid_thread_click");
            } else {
                return;
            }
            UserData userData9 = this.bEs.getUserData();
            if (userData9 != null) {
                PersonPostActivity.a(this, userData9.getUserId(), userData9.getSex(), userData9.getPortrait());
            }
        } else if (view.getId() == this.bEt.aaz().getId()) {
            if (!this.bEq) {
                com.baidu.tbadk.core.i.l(this, "igift_icon_ck");
                UserData userData10 = this.bEs.getUserData();
                if (userData10 != null) {
                    if (!com.baidu.adp.lib.util.m.isNetOk()) {
                        showToast(com.baidu.tieba.y.no_signall_data);
                        return;
                    }
                    this.bEq = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(this, userData10.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bEt.aaN().getId()) {
            if (!this.bEq) {
                com.baidu.tbadk.core.i.l(this, "igift_icon_ck");
                UserData userData11 = this.bEs.getUserData();
                if (userData11 != null) {
                    if (!com.baidu.adp.lib.util.m.isNetOk()) {
                        showToast(com.baidu.tieba.y.no_signall_data);
                        return;
                    }
                    this.bEq = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(this, userData11.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bEt.aaP().getId()) {
            sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(this)));
        } else if (view.getId() == this.bEt.aad().getId()) {
            this.bEt.abf();
            aar();
        } else if (view.getId() == this.bEt.aac().getId()) {
            this.bEt.abf();
            if (this.bEs.getUserData() != null) {
                com.baidu.tbadk.newFriends.a.un().p(this.bEs.getUserData().getUserIdLong());
            }
        }
    }

    private void aar() {
        String format;
        String userName = this.bEs.getUserData() != null ? this.bEs.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
            aVar.a(com.baidu.tieba.y.confirm, new e(this));
            aVar.b(com.baidu.tieba.y.cancel, new f(this));
            if (this.bEr.getMaskType() == 1) {
                format = String.format(getString(com.baidu.tieba.y.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getString(com.baidu.tieba.y.block_chat_message_alert), userName);
            }
            aVar.bg(format);
            aVar.kT();
            aVar.kW();
        }
    }

    private void aas() {
        if (this.mIsHost) {
            AntiData An = this.bEs.An();
            if (An != null) {
                AppealActivity.b(this, An.getBlock_forum_id(), An.getUser_id(), An.getUser_name());
                return;
            }
            return;
        }
        PersonTainInfo aaS = this.bEs.aaS();
        if (aaS != null) {
            int isFriend = aaS.getIsFriend();
            if (isFriend == 0) {
                UserData userData = this.bEs.getUserData();
                if (userData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this, userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.bEs.aaV(), aaS.getUserClientVersionLower(), this.bEs.getStType())));
                }
            } else if (isFriend == 1) {
                UserData userData2 = this.bEs.getUserData();
                if (userData2 != null) {
                    if (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccount().length() <= 0) {
                        LoginActivity.a((Activity) this, getResources().getString(com.baidu.tieba.y.login_to_chat), true, 11028);
                    } else if (!this.mIsHost) {
                        TiebaStatic.eventStat(this, "enter_chat", "personclick", 1, new Object[0]);
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, Long.parseLong(userData2.getUserId()), userData2.getUserName(), userData2.getPortrait(), userData2.getSex())));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (isFriend == 2) {
                com.baidu.tbadk.newFriends.a.un().c(com.baidu.adp.lib.g.c.a(this.bEs.getId(), 0L), "pers_pg");
            }
        }
    }

    private boolean hb(int i) {
        int qV;
        if (this.bEs.getUserData() == null || this.bEs.getUserData().getPersonPrivate() == null) {
            return false;
        }
        com.baidu.tbadk.data.c personPrivate = this.bEs.getUserData().getPersonPrivate();
        switch (i) {
            case 2:
                qV = personPrivate.qS();
                break;
            case 3:
                qV = personPrivate.qT();
                break;
            case 4:
                qV = personPrivate.qU();
                break;
            case 5:
                qV = personPrivate.qV();
                break;
            default:
                qV = 1;
                break;
        }
        if (this.bEs.aaS() != null && this.bEs.aaS().getIsFriend() != 1 && qV == 2) {
            showToast(com.baidu.tieba.y.private_friend_open);
            return false;
        } else if (qV == 3) {
            showToast(com.baidu.tieba.y.private_hide);
            return false;
        } else {
            return true;
        }
    }

    public void aat() {
        String[] strArr = {getString(com.baidu.tieba.y.hd_photo), getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this);
        iVar.bc(com.baidu.tieba.y.operation);
        iVar.a(strArr, new g(this));
        iVar.kZ();
        iVar.la();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aau() {
        if (this.bEs != null && this.bEs.getUserData() != null) {
            PersonImageActivity.startActivity(this, hh(this.bEs.getUserData().getPortraitH()));
        }
    }

    private String hh(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void aav() {
        if (this.bEs != null && this.bEs.aaS() != null && this.bEr != null) {
            this.bEt.h(this.bEs.aaS().getIsFriend() == 1, this.bEr.getMaskType() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            if (this.bEs != null) {
                if (msgFans > 0) {
                    this.bEs.X(msgFans);
                    this.bEt.ey(true);
                }
                this.bEt.hc(msgGiftNum);
            }
        }
    }
}
