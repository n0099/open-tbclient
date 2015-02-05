package com.baidu.tieba.personInfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AppealActivityConfig;
import com.baidu.tbadk.core.atomData.BuyGiftActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* loaded from: classes.dex */
public class PersonInfoActivity extends BaseActivity<PersonInfoActivity> {
    private static final String bEN;
    private BlackListModel bJL;
    private v bJM;
    private ae bJN;
    private boolean mIsHost;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.tbadkCore.d.a aDe = null;
    private boolean bJK = false;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private com.baidu.adp.framework.listener.a bJO = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e bJP = new h(this, 104102);
    final com.baidu.adp.framework.listener.e bJQ = new i(this, 304102);
    final CustomMessageListener bJR = new j(this, 2001178);
    private final CustomMessageListener aDy = new k(this, 2001178);
    private final com.baidu.adp.framework.listener.e bJS = new l(this, 304103);
    private CustomMessageListener bJT = new m(this, 2001238);
    private CustomMessageListener bJU = new n(this, 2001118);
    private final CustomMessageListener bJV = new o(this, 2001124);
    private final CustomMessageListener bJW = new b(this, 2001237);

    static {
        Jx();
        bEN = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/135_1";
    }

    private static void Jx() {
        com.baidu.tieba.tbadkCore.a.a.a(303012, ProfileSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PROFILE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.O("c/u/user/profile", 303012));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ProfileHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public v abl() {
        return this.bJM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k(bundle);
        this.mIsHost = this.bJM.getIsSelf();
        registerListener();
        initUI();
        VF();
    }

    private void registerListener() {
        registerListener(this.bJO);
        registerListener(this.bJP);
        registerListener(this.bJQ);
        registerListener(this.bJR);
        registerListener(this.bJS);
        registerListener(this.aDy);
        registerListener(this.bJU);
        registerListener(this.bJV);
        registerListener(this.bJW);
        registerListener(this.bJT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bJM.aaZ();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.rS().getMsgGiftNum();
        this.bJK = false;
        if (TbadkCoreApplication.getRefreshFlag()) {
            this.bJM.abX();
            TbadkCoreApplication.setRefreshFlag(false);
            return;
        }
        long msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.rS().getMsgFans();
        if (msgFans != this.bJM.abN() && msgFans > 0) {
            this.bJM.ai(msgFans);
            this.bJN.ek(true);
        }
        if (msgGiftNum > 0) {
            this.bJM.hv(msgGiftNum);
            this.bJN.hu(msgGiftNum);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.bJN.onStart();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.bJN.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bJM.abV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.bJN.onStop();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mIsHost) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001267));
        }
    }

    private void initUI() {
        this.bJN = new ae(this, this.mIsHost);
        this.bJN.setExpandListRefreshListener(new c(this));
        if (this.mIsHost) {
            this.bJM.abW();
        }
        this.bJN.startLoad();
    }

    private void VF() {
        if (this.aDe == null) {
            this.aDe = new com.baidu.tieba.tbadkCore.d.a("profileStat");
            this.aDe.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bJN.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bJM != null) {
            bundle.putBoolean("self", this.bJM.getIsSelf());
            bundle.putString("un", this.bJM.getId());
            bundle.putString("name", this.bJM.getName());
            bundle.putBoolean("tab_page", this.bJM.abR());
            bundle.putBoolean("tab_msg", this.bJM.abS());
            bundle.putString("from", this.bJM.abT());
            bundle.putString("st_type", this.bJM.getStType());
        }
    }

    private void k(Bundle bundle) {
        this.mPersonChangeData = new PersonChangeData();
        this.bJL = new BlackListModel(this);
        this.bJM = new v(this);
        if (bundle != null) {
            this.bJM.hN(bundle.getString("from"));
            this.bJM.setIsSelf(bundle.getBoolean("self", false));
            this.bJM.setId(bundle.getString("un"));
            this.bJM.setName(bundle.getString("name"));
            this.bJM.el(bundle.getBoolean("tab_page", false));
            this.bJM.em(bundle.getBoolean("tab_msg", false));
            this.bJM.setStType(bundle.getString("st_type"));
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bJM.hN(intent.getStringExtra("from_forum"));
                this.bJM.setIsSelf(intent.getBooleanExtra("self", false));
                this.bJM.setId(intent.getStringExtra("un"));
                this.bJM.setName(intent.getStringExtra("name"));
                this.bJM.el(intent.getBooleanExtra("tab_page", false));
                this.bJM.em(intent.getBooleanExtra("tab_msg", false));
                this.bJM.setStType(intent.getStringExtra("st_type"));
            }
        }
        this.bJM.setLoadDataCallBack(new d(this));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                V(intent);
            } else if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        K(intent);
                    } else {
                        J(intent);
                    }
                }
            } else if (i == 12010 || i == 12009) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.bJM.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.vY().ei(this.bJM.getUserData().getPortrait());
                }
                this.bJM.abX();
            }
        } else if (i2 == 0 && i == 12010) {
            bb.a(getPageContext());
        }
    }

    private void J(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath())));
            }
            this.writeImagesInfo.clear();
        }
    }

    private void K(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj())));
    }

    private void V(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra(PersonChangeData.TAG_PERSON_INFO);
        if (personChangeData != null && this.bJM.getUserData() != null) {
            this.bJM.b(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.bJM.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.vY().ei(this.bJM.getUserData().getPortrait());
                }
            }
        }
        this.bJM.abX();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getId() == this.bJN.BC().getId()) {
            finish();
        } else if (view.getId() == this.bJN.ace().getId()) {
            if (!this.mIsHost) {
                abq();
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.bJM.getUserData() != null) {
                personChangeData.setName(this.bJM.getUserData().getName_show());
                personChangeData.setIntro(this.bJM.getUserData().getIntro());
                personChangeData.setSex(this.bJM.getUserData().getSex());
                personChangeData.setPortrait(this.bJM.getUserData().getPortrait());
            }
            sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), PersonInfoActivityConfig.REQUSET_CHANGE, personChangeData, true)));
            com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_editprofile_click");
        } else if (view.getId() == this.bJN.abI().getId()) {
            if (this.bJM.getUserData() != null) {
                if (this.bJM.getIsSelf()) {
                    abo();
                } else {
                    abp();
                }
            }
        } else if (view.getId() == this.bJN.abL().getId()) {
            this.bJM.abU();
        } else if (view.getId() == this.bJN.abJ().getId()) {
            if (this.bJM.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.user_icon_intro), String.valueOf(bEN) + "?st_type=person_user_icon", true, true, false, false, false)));
            }
        } else if (view.getId() == this.bJN.abz().getId()) {
            if (this.bJM.getIsSelf()) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_self_group_click");
            } else if (ht(3)) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_guid_group_click");
            } else {
                return;
            }
            UserData userData = this.bJM.getUserData();
            if (userData != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), this.bJM.getId(), userData.getSex())));
            }
        } else if (view.getId() == this.bJN.acb().getId()) {
            abn();
        } else if (view.getId() == this.bJN.abu().getId()) {
            UserData userData2 = this.bJM.getUserData();
            if (userData2 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), this.bJM.getId(), userData2.getSex(), 1)));
            }
        } else if (view.getId() == this.bJN.abw().getId()) {
            UserData userData3 = this.bJM.getUserData();
            if (userData3 != null) {
                sendMessage(new CustomMessage(2002001, new PersonFriendActivityConfig(getPageContext().getPageActivity(), this.bJM.getId(), userData3.getSex(), 1)));
            }
        } else if (view.getId() == this.bJN.abt().getId()) {
            UserData userData4 = this.bJM.getUserData();
            if (userData4 != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), userData4.getUserId(), userData4.getSex(), 1)));
            }
        } else if (view.getId() == this.bJN.abr().getId()) {
            UserData userData5 = this.bJM.getUserData();
            if (userData5 != null) {
                if (this.mIsHost) {
                    str = "iowner_gift";
                } else {
                    str = "iguest_gift";
                }
                sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(getPageContext().getPageActivity(), userData5.getUserId(), userData5.getSex(), str)));
                this.bJN.hu(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.rS().si();
            }
        } else if (view.getId() == this.bJN.abx().getId()) {
            if (this.bJM.getIsSelf()) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_self_attentionme_click");
            } else {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_guid_attentionme_click");
            }
            UserData userData6 = this.bJM.getUserData();
            if (userData6 != null) {
                this.bJN.ek(false);
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData6.getUserId(), userData6.getSex())));
            }
        } else if (view.getId() == this.bJN.aby().getId()) {
            if (this.bJM.getIsSelf()) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_self_attentionper_click");
            } else {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_guid_attentionper_click");
            }
            UserData userData7 = this.bJM.getUserData();
            if (userData7 != null) {
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData7.getUserId(), userData7.getSex())));
            }
        } else if (view.getId() == this.bJN.abA().getId()) {
            if (this.bJM.getIsSelf()) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_self_attentionbar_click");
            } else if (ht(2)) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_guid_attentionbar_click");
            } else {
                return;
            }
            UserData userData8 = this.bJM.getUserData();
            if (userData8 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), userData8.getLike_bars(), this.bJM.getId(), userData8.getSex())));
            }
        } else if (view.getId() == this.bJN.abB().getId()) {
            if (this.bJM.getIsSelf()) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_self_thread_click");
            } else if (ht(4)) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_guid_thread_click");
            } else {
                return;
            }
            UserData userData9 = this.bJM.getUserData();
            if (userData9 != null) {
                sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(getPageContext().getPageActivity(), userData9.getUserId(), userData9.getSex(), userData9.getPortrait())));
            }
        } else if (view.getId() == this.bJN.abv().getId()) {
            if (!this.bJK) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "igift_icon_ck");
                UserData userData10 = this.bJM.getUserData();
                if (userData10 != null) {
                    if (!com.baidu.adp.lib.util.l.isNetOk()) {
                        showToast(com.baidu.tieba.z.no_signall_data);
                        return;
                    }
                    this.bJK = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData10.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bJN.abK().getId()) {
            if (!this.bJK) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "igift_icon_ck");
                UserData userData11 = this.bJM.getUserData();
                if (userData11 != null) {
                    if (!com.baidu.adp.lib.util.l.isNetOk()) {
                        showToast(com.baidu.tieba.z.no_signall_data);
                        return;
                    }
                    this.bJK = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData11.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bJN.abM().getId()) {
            sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(getPageContext().getPageActivity())));
        } else if (this.bJN.aaW() != null && view.getId() == this.bJN.aaW().getId()) {
            this.bJN.acd();
            abm();
        } else if (this.bJN.aaV() != null && view.getId() == this.bJN.aaV().getId()) {
            this.bJN.acd();
            if (this.bJM.getUserData() != null) {
                com.baidu.tbadk.newFriends.a.yM().u(this.bJM.getUserData().getUserIdLong());
            }
        }
    }

    private void abm() {
        String format;
        String userName = this.bJM.getUserData() != null ? this.bJM.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(com.baidu.tieba.z.confirm, new e(this));
            aVar.b(com.baidu.tieba.z.cancel, new f(this));
            if (this.bJL.getMaskType() == 1) {
                format = String.format(getPageContext().getString(com.baidu.tieba.z.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(com.baidu.tieba.z.block_chat_message_alert), userName);
            }
            aVar.bT(format);
            aVar.b(getPageContext());
            aVar.nQ();
        }
    }

    private void abn() {
        if (this.bJM.getUserData() != null && this.bJM.getUserData().getIsOfficialAccount() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(this.bJM.getUserData().getUserId(), 0L), this.bJM.getUserData().getUserName(), this.bJM.getUserData().getPortrait(), 0, 4)));
        } else if (this.mIsHost) {
            AntiData abO = this.bJM.abO();
            if (abO != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AppealActivityConfig(getPageContext().getPageActivity(), abO.getBlock_forum_id(), abO.getUser_id(), abO.getUser_name())));
            }
        } else {
            PersonTainInfo abQ = this.bJM.abQ();
            if (abQ != null) {
                int isFriend = abQ.getIsFriend();
                if (isFriend == 0) {
                    UserData userData = this.bJM.getUserData();
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.bJM.abT(), abQ.getUserClientVersionLower(), this.bJM.getStType())));
                    }
                } else if (isFriend == 1) {
                    UserData userData2 = this.bJM.getUserData();
                    if (userData2 != null) {
                        if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(com.baidu.tieba.z.login_to_chat), true, 11028)));
                        } else if (!this.mIsHost) {
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "enter_chat", "personclick", 1, new Object[0]);
                            try {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), Long.parseLong(userData2.getUserId()), userData2.getUserName(), userData2.getPortrait(), userData2.getSex())));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else if (isFriend == 2) {
                    com.baidu.tbadk.newFriends.a.yM().c(com.baidu.adp.lib.g.c.a(this.bJM.getId(), 0L), "pers_pg");
                }
            }
        }
    }

    private boolean ht(int i) {
        int uK;
        if (this.bJM.getUserData() == null || this.bJM.getUserData().getPersonPrivate() == null) {
            return false;
        }
        com.baidu.tbadk.data.h personPrivate = this.bJM.getUserData().getPersonPrivate();
        switch (i) {
            case 2:
                uK = personPrivate.uH();
                break;
            case 3:
                uK = personPrivate.uI();
                break;
            case 4:
                uK = personPrivate.uJ();
                break;
            case 5:
                uK = personPrivate.uK();
                break;
            default:
                uK = 1;
                break;
        }
        if (this.bJM.abQ() != null && this.bJM.abQ().getIsFriend() != 1 && uK == 2) {
            showToast(com.baidu.tieba.z.private_friend_open);
            return false;
        } else if (uK == 3) {
            showToast(com.baidu.tieba.z.private_hide);
            return false;
        } else {
            return true;
        }
    }

    public void abo() {
        String[] strArr = {getPageContext().getString(com.baidu.tieba.z.hd_photo), getPageContext().getString(com.baidu.tieba.z.change_photo)};
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(getPageContext().getPageActivity());
        iVar.bD(com.baidu.tieba.z.operation);
        iVar.a(strArr, new g(this));
        iVar.e(getPageContext());
        iVar.nS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abp() {
        if (this.bJM != null && this.bJM.getUserData() != null) {
            sendMessage(new CustomMessage(2002001, new PersonImageActivityConfig(getPageContext().getPageActivity(), hM(this.bJM.getUserData().getPortraitH()))));
        }
    }

    private String hM(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void abq() {
        if (this.bJM != null && this.bJM.abQ() != null && this.bJL != null) {
            this.bJN.j(this.bJM.abQ().getIsFriend() == 1, this.bJL.getMaskType() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            if (this.bJM != null) {
                if (msgFans > 0) {
                    this.bJM.ai(msgFans);
                    this.bJN.ek(true);
                }
                this.bJN.hu(msgGiftNum);
            }
        }
    }
}
