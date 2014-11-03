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
    private static boolean aBe;
    private static final String bzh;
    private PersonChangeData adW;
    private com.baidu.tieba.model.d bEF;
    private v bEG;
    private ae bEH;
    private boolean mIsHost;
    private com.baidu.tieba.b.a aAO = null;
    private boolean bEE = false;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private com.baidu.adp.framework.listener.a bEI = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e bEJ = new h(this, 104102);
    final com.baidu.adp.framework.listener.e bEK = new i(this, 304102);
    final CustomMessageListener bEL = new j(this, 2001178);
    private final CustomMessageListener aAZ = new k(this, 2001178);
    private final com.baidu.adp.framework.listener.e bEM = new l(this, 304103);
    private CustomMessageListener bEN = new m(this, 2001238);
    private CustomMessageListener bEO = new n(this, 2001118);
    private final CustomMessageListener bEP = new o(this, 2001124);
    private final CustomMessageListener bEQ = new b(this, 2001237);

    static {
        HQ();
        aBe = false;
        bzh = String.valueOf(com.baidu.tieba.data.e.ajC) + "mo/q/topic_page/135_1";
    }

    private static void HQ() {
        ai.a(303012, ProfileSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PROFILE_HTTP_CMD, ai.s("c/u/user/profile", 303012));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ProfileHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public v aar() {
        return this.bEG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k(bundle);
        this.mIsHost = this.bEG.getIsSelf();
        registerListener();
        aas();
        initUI();
        UZ();
    }

    private void registerListener() {
        registerListener(this.bEI);
        registerListener(this.bEJ);
        registerListener(this.bEK);
        registerListener(this.bEL);
        registerListener(this.bEM);
        registerListener(this.aAZ);
        registerListener(this.bEO);
        registerListener(this.bEP);
        registerListener(this.bEQ);
        registerListener(this.bEN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aas();
        this.bEG.aai();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgGiftNum();
        this.bEE = false;
        if (aBe) {
            this.bEG.abc();
            aBe = false;
            return;
        }
        long msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgFans();
        if (msgFans != this.bEG.aaT() && msgFans > 0) {
            this.bEG.X(msgFans);
            this.bEH.ey(true);
        }
        if (msgGiftNum > 0) {
            this.bEG.hd(msgGiftNum);
            this.bEH.hc(msgGiftNum);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.bEH.onStart();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.bEH.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bEG.aba();
    }

    private void aas() {
        com.baidu.tbadk.imageManager.e.si().cQ(TbConfig.getBigImageMaxUsedMemory() - (TbConfig.getBigImageMaxUsedMemory() - 1152000));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        com.baidu.tbadk.imageManager.e.si().cQ(TbConfig.getBigImageMaxUsedMemory());
        this.bEH.onStop();
        super.onStop();
    }

    private void initUI() {
        this.bEH = new ae(this, this.mIsHost);
        this.bEH.setExpandListRefreshListener(new c(this));
        if (this.mIsHost) {
            this.bEG.abb();
        }
        this.bEH.Nn();
    }

    public static void ex(boolean z) {
        aBe = z;
    }

    private void UZ() {
        if (this.aAO == null) {
            this.aAO = new com.baidu.tieba.b.a("profileStat");
            this.aAO.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bEH.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bEG != null) {
            bundle.putBoolean("self", this.bEG.getIsSelf());
            bundle.putString("un", this.bEG.getId());
            bundle.putString("name", this.bEG.getName());
            bundle.putBoolean("tab_page", this.bEG.aaW());
            bundle.putBoolean("tab_msg", this.bEG.aaX());
            bundle.putString("from", this.bEG.aaY());
            bundle.putString("st_type", this.bEG.getStType());
        }
    }

    private void k(Bundle bundle) {
        this.adW = new PersonChangeData();
        this.bEF = new com.baidu.tieba.model.d(this);
        this.bEG = new v(this);
        if (bundle != null) {
            this.bEG.hi(bundle.getString("from"));
            this.bEG.setIsSelf(bundle.getBoolean("self", false));
            this.bEG.setId(bundle.getString("un"));
            this.bEG.setName(bundle.getString("name"));
            this.bEG.ez(bundle.getBoolean("tab_page", false));
            this.bEG.eA(bundle.getBoolean("tab_msg", false));
            this.bEG.setStType(bundle.getString("st_type"));
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bEG.hi(intent.getStringExtra("from_forum"));
                this.bEG.setIsSelf(intent.getBooleanExtra("self", false));
                this.bEG.setId(intent.getStringExtra("un"));
                this.bEG.setName(intent.getStringExtra("name"));
                this.bEG.ez(intent.getBooleanExtra("tab_page", false));
                this.bEG.eA(intent.getBooleanExtra("tab_msg", false));
                this.bEG.setStType(intent.getStringExtra("st_type"));
            }
        }
        this.bEG.setLoadDataCallBack(new d(this));
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
                if (this.adW != null) {
                    this.adW.setPhotoChanged(true);
                }
                if (this.bEG.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.si().dr(this.bEG.getUserData().getPortrait());
                }
                this.bEG.abc();
            }
        } else if (i2 == 0 && i == 12010) {
            av.h(this);
        }
    }

    private void m(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
        if (personChangeData != null && this.bEG.getUserData() != null) {
            this.bEG.c(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.adW != null) {
                    this.adW.setPhotoChanged(true);
                }
                if (this.bEG.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.si().dr(this.bEG.getUserData().getPortrait());
                }
            }
        }
        this.bEG.abc();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getId() == this.bEH.xQ().getId()) {
            finish();
        } else if (view.getId() == this.bEH.abj().getId()) {
            if (!this.mIsHost) {
                aax();
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.bEG.getUserData() != null) {
                personChangeData.setName(this.bEG.getUserData().getName_show());
                personChangeData.setIntro(this.bEG.getUserData().getIntro());
                personChangeData.setSex(this.bEG.getUserData().getSex());
                personChangeData.setPortrait(this.bEG.getUserData().getPortrait());
            }
            PersonChangeActivity.a(this, 101, personChangeData, true);
            com.baidu.tbadk.core.j.l(this, "person_editprofile_click");
        } else if (view.getId() == this.bEH.aaO().getId()) {
            if (this.bEG.getUserData() != null) {
                if (this.bEG.getIsSelf()) {
                    aav();
                } else {
                    aaw();
                }
            }
        } else if (view.getId() == this.bEH.aaR().getId()) {
            this.bEG.aaZ();
        } else if (view.getId() == this.bEH.aaP().getId()) {
            if (this.bEG.getUserData() != null) {
                TbWebViewActivity.startActivity(this, getString(com.baidu.tieba.y.user_icon_intro), String.valueOf(bzh) + "?st_type=person_user_icon");
            }
        } else if (view.getId() == this.bEH.aaF().getId()) {
            if (this.bEG.getIsSelf()) {
                com.baidu.tbadk.core.j.l(this, "person_self_group_click");
            } else if (hb(3)) {
                com.baidu.tbadk.core.j.l(this, "person_guid_group_click");
            } else {
                return;
            }
            UserData userData = this.bEG.getUserData();
            if (userData != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this, this.bEG.getId(), userData.getSex())));
            }
        } else if (view.getId() == this.bEH.abg().getId()) {
            aau();
        } else if (view.getId() == this.bEH.aaA().getId()) {
            UserData userData2 = this.bEG.getUserData();
            if (userData2 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this, this.bEG.getId(), userData2.getSex(), 1)));
            }
        } else if (view.getId() == this.bEH.aaC().getId()) {
            UserData userData3 = this.bEG.getUserData();
            if (userData3 != null) {
                sendMessage(new CustomMessage(2002001, new PersonFriendActivityConfig(this, this.bEG.getId(), userData3.getSex(), 1)));
            }
        } else if (view.getId() == this.bEH.aaz().getId()) {
            UserData userData4 = this.bEG.getUserData();
            if (userData4 != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this, userData4.getUserId(), userData4.getSex(), 1)));
            }
        } else if (view.getId() == this.bEH.aay().getId()) {
            UserData userData5 = this.bEG.getUserData();
            if (userData5 != null) {
                if (this.mIsHost) {
                    str = "iowner_gift";
                } else {
                    str = "iguest_gift";
                }
                sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this, userData5.getUserId(), userData5.getSex(), str)));
                this.bEH.hc(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.oD().oS();
            }
        } else if (view.getId() == this.bEH.aaD().getId()) {
            if (this.bEG.getIsSelf()) {
                com.baidu.tbadk.core.j.l(this, "person_self_attentionme_click");
            } else {
                com.baidu.tbadk.core.j.l(this, "person_guid_attentionme_click");
            }
            UserData userData6 = this.bEG.getUserData();
            if (userData6 != null) {
                this.bEH.ey(false);
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this, false, userData6.getUserId(), userData6.getSex())));
            }
        } else if (view.getId() == this.bEH.aaE().getId()) {
            if (this.bEG.getIsSelf()) {
                com.baidu.tbadk.core.j.l(this, "person_self_attentionper_click");
            } else {
                com.baidu.tbadk.core.j.l(this, "person_guid_attentionper_click");
            }
            UserData userData7 = this.bEG.getUserData();
            if (userData7 != null) {
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this, true, userData7.getUserId(), userData7.getSex())));
            }
        } else if (view.getId() == this.bEH.aaG().getId()) {
            if (this.bEG.getIsSelf()) {
                com.baidu.tbadk.core.j.l(this, "person_self_attentionbar_click");
            } else if (hb(2)) {
                com.baidu.tbadk.core.j.l(this, "person_guid_attentionbar_click");
            } else {
                return;
            }
            UserData userData8 = this.bEG.getUserData();
            if (userData8 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this, this.bEG.getId(), userData8.getSex())));
            }
        } else if (view.getId() == this.bEH.aaH().getId()) {
            if (this.bEG.getIsSelf()) {
                com.baidu.tbadk.core.j.l(this, "person_self_thread_click");
            } else if (hb(4)) {
                com.baidu.tbadk.core.j.l(this, "person_guid_thread_click");
            } else {
                return;
            }
            UserData userData9 = this.bEG.getUserData();
            if (userData9 != null) {
                PersonPostActivity.a(this, userData9.getUserId(), userData9.getSex(), userData9.getPortrait());
            }
        } else if (view.getId() == this.bEH.aaB().getId()) {
            if (!this.bEE) {
                com.baidu.tbadk.core.j.l(this, "igift_icon_ck");
                UserData userData10 = this.bEG.getUserData();
                if (userData10 != null) {
                    if (!com.baidu.adp.lib.util.m.isNetOk()) {
                        showToast(com.baidu.tieba.y.no_signall_data);
                        return;
                    }
                    this.bEE = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(this, userData10.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bEH.aaQ().getId()) {
            if (!this.bEE) {
                com.baidu.tbadk.core.j.l(this, "igift_icon_ck");
                UserData userData11 = this.bEG.getUserData();
                if (userData11 != null) {
                    if (!com.baidu.adp.lib.util.m.isNetOk()) {
                        showToast(com.baidu.tieba.y.no_signall_data);
                        return;
                    }
                    this.bEE = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(this, userData11.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bEH.aaS().getId()) {
            sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(this)));
        } else if (view.getId() == this.bEH.aaf().getId()) {
            this.bEH.abi();
            aat();
        } else if (view.getId() == this.bEH.aae().getId()) {
            this.bEH.abi();
            if (this.bEG.getUserData() != null) {
                com.baidu.tbadk.newFriends.a.up().p(this.bEG.getUserData().getUserIdLong());
            }
        }
    }

    private void aat() {
        String format;
        String userName = this.bEG.getUserData() != null ? this.bEG.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
            aVar.a(com.baidu.tieba.y.confirm, new e(this));
            aVar.b(com.baidu.tieba.y.cancel, new f(this));
            if (this.bEF.getMaskType() == 1) {
                format = String.format(getString(com.baidu.tieba.y.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getString(com.baidu.tieba.y.block_chat_message_alert), userName);
            }
            aVar.bg(format);
            aVar.kT();
            aVar.kW();
        }
    }

    private void aau() {
        if (this.mIsHost) {
            AntiData Ap = this.bEG.Ap();
            if (Ap != null) {
                AppealActivity.b(this, Ap.getBlock_forum_id(), Ap.getUser_id(), Ap.getUser_name());
                return;
            }
            return;
        }
        PersonTainInfo aaV = this.bEG.aaV();
        if (aaV != null) {
            int isFriend = aaV.getIsFriend();
            if (isFriend == 0) {
                UserData userData = this.bEG.getUserData();
                if (userData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this, userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.bEG.aaY(), aaV.getUserClientVersionLower(), this.bEG.getStType())));
                }
            } else if (isFriend == 1) {
                UserData userData2 = this.bEG.getUserData();
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
                com.baidu.tbadk.newFriends.a.up().c(com.baidu.adp.lib.g.c.a(this.bEG.getId(), 0L), "pers_pg");
            }
        }
    }

    private boolean hb(int i) {
        int qX;
        if (this.bEG.getUserData() == null || this.bEG.getUserData().getPersonPrivate() == null) {
            return false;
        }
        com.baidu.tbadk.data.c personPrivate = this.bEG.getUserData().getPersonPrivate();
        switch (i) {
            case 2:
                qX = personPrivate.qU();
                break;
            case 3:
                qX = personPrivate.qV();
                break;
            case 4:
                qX = personPrivate.qW();
                break;
            case 5:
                qX = personPrivate.qX();
                break;
            default:
                qX = 1;
                break;
        }
        if (this.bEG.aaV() != null && this.bEG.aaV().getIsFriend() != 1 && qX == 2) {
            showToast(com.baidu.tieba.y.private_friend_open);
            return false;
        } else if (qX == 3) {
            showToast(com.baidu.tieba.y.private_hide);
            return false;
        } else {
            return true;
        }
    }

    public void aav() {
        String[] strArr = {getString(com.baidu.tieba.y.hd_photo), getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this);
        iVar.bc(com.baidu.tieba.y.operation);
        iVar.a(strArr, new g(this));
        iVar.kZ();
        iVar.la();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaw() {
        if (this.bEG != null && this.bEG.getUserData() != null) {
            PersonImageActivity.startActivity(this, hh(this.bEG.getUserData().getPortraitH()));
        }
    }

    private String hh(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void aax() {
        if (this.bEG != null && this.bEG.aaV() != null && this.bEF != null) {
            this.bEH.h(this.bEG.aaV().getIsFriend() == 1, this.bEF.getMaskType() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            if (this.bEG != null) {
                if (msgFans > 0) {
                    this.bEG.X(msgFans);
                    this.bEH.ey(true);
                }
                this.bEH.hc(msgGiftNum);
            }
        }
    }
}
