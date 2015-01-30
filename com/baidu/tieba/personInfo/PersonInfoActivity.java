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
    private static final String bEO;
    private BlackListModel bJM;
    private v bJN;
    private ae bJO;
    private boolean mIsHost;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.tbadkCore.d.a aDh = null;
    private boolean bJL = false;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private com.baidu.adp.framework.listener.a bJP = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e bJQ = new h(this, 104102);
    final com.baidu.adp.framework.listener.e bJR = new i(this, 304102);
    final CustomMessageListener bJS = new j(this, 2001178);
    private final CustomMessageListener aDB = new k(this, 2001178);
    private final com.baidu.adp.framework.listener.e bJT = new l(this, 304103);
    private CustomMessageListener bJU = new m(this, 2001238);
    private CustomMessageListener bJV = new n(this, 2001118);
    private final CustomMessageListener bJW = new o(this, 2001124);
    private final CustomMessageListener bJX = new b(this, 2001237);

    static {
        JC();
        bEO = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/135_1";
    }

    private static void JC() {
        com.baidu.tieba.tbadkCore.a.a.a(303012, ProfileSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PROFILE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.O("c/u/user/profile", 303012));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ProfileHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public v abq() {
        return this.bJN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k(bundle);
        this.mIsHost = this.bJN.getIsSelf();
        registerListener();
        initUI();
        VK();
    }

    private void registerListener() {
        registerListener(this.bJP);
        registerListener(this.bJQ);
        registerListener(this.bJR);
        registerListener(this.bJS);
        registerListener(this.bJT);
        registerListener(this.aDB);
        registerListener(this.bJV);
        registerListener(this.bJW);
        registerListener(this.bJX);
        registerListener(this.bJU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bJN.abe();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.rY().getMsgGiftNum();
        this.bJL = false;
        if (TbadkCoreApplication.getRefreshFlag()) {
            this.bJN.acc();
            TbadkCoreApplication.setRefreshFlag(false);
            return;
        }
        long msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.rY().getMsgFans();
        if (msgFans != this.bJN.abS() && msgFans > 0) {
            this.bJN.ai(msgFans);
            this.bJO.ek(true);
        }
        if (msgGiftNum > 0) {
            this.bJN.hv(msgGiftNum);
            this.bJO.hu(msgGiftNum);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.bJO.onStart();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.bJO.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bJN.aca();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        this.bJO.onStop();
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
        this.bJO = new ae(this, this.mIsHost);
        this.bJO.setExpandListRefreshListener(new c(this));
        if (this.mIsHost) {
            this.bJN.acb();
        }
        this.bJO.startLoad();
    }

    private void VK() {
        if (this.aDh == null) {
            this.aDh = new com.baidu.tieba.tbadkCore.d.a("profileStat");
            this.aDh.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bJO.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bJN != null) {
            bundle.putBoolean("self", this.bJN.getIsSelf());
            bundle.putString("un", this.bJN.getId());
            bundle.putString("name", this.bJN.getName());
            bundle.putBoolean("tab_page", this.bJN.abW());
            bundle.putBoolean("tab_msg", this.bJN.abX());
            bundle.putString("from", this.bJN.abY());
            bundle.putString("st_type", this.bJN.getStType());
        }
    }

    private void k(Bundle bundle) {
        this.mPersonChangeData = new PersonChangeData();
        this.bJM = new BlackListModel(this);
        this.bJN = new v(this);
        if (bundle != null) {
            this.bJN.hP(bundle.getString("from"));
            this.bJN.setIsSelf(bundle.getBoolean("self", false));
            this.bJN.setId(bundle.getString("un"));
            this.bJN.setName(bundle.getString("name"));
            this.bJN.el(bundle.getBoolean("tab_page", false));
            this.bJN.em(bundle.getBoolean("tab_msg", false));
            this.bJN.setStType(bundle.getString("st_type"));
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bJN.hP(intent.getStringExtra("from_forum"));
                this.bJN.setIsSelf(intent.getBooleanExtra("self", false));
                this.bJN.setId(intent.getStringExtra("un"));
                this.bJN.setName(intent.getStringExtra("name"));
                this.bJN.el(intent.getBooleanExtra("tab_page", false));
                this.bJN.em(intent.getBooleanExtra("tab_msg", false));
                this.bJN.setStType(intent.getStringExtra("st_type"));
            }
        }
        this.bJN.setLoadDataCallBack(new d(this));
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
                if (this.bJN.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.we().el(this.bJN.getUserData().getPortrait());
                }
                this.bJN.acc();
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
        if (personChangeData != null && this.bJN.getUserData() != null) {
            this.bJN.b(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.bJN.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.we().el(this.bJN.getUserData().getPortrait());
                }
            }
        }
        this.bJN.acc();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getId() == this.bJO.BI().getId()) {
            finish();
        } else if (view.getId() == this.bJO.acj().getId()) {
            if (!this.mIsHost) {
                abv();
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.bJN.getUserData() != null) {
                personChangeData.setName(this.bJN.getUserData().getName_show());
                personChangeData.setIntro(this.bJN.getUserData().getIntro());
                personChangeData.setSex(this.bJN.getUserData().getSex());
                personChangeData.setPortrait(this.bJN.getUserData().getPortrait());
            }
            sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), PersonInfoActivityConfig.REQUSET_CHANGE, personChangeData, true)));
            com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_editprofile_click");
        } else if (view.getId() == this.bJO.abN().getId()) {
            if (this.bJN.getUserData() != null) {
                if (this.bJN.getIsSelf()) {
                    abt();
                } else {
                    abu();
                }
            }
        } else if (view.getId() == this.bJO.abQ().getId()) {
            this.bJN.abZ();
        } else if (view.getId() == this.bJO.abO().getId()) {
            if (this.bJN.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.user_icon_intro), String.valueOf(bEO) + "?st_type=person_user_icon", true, true, false, false, false)));
            }
        } else if (view.getId() == this.bJO.abE().getId()) {
            if (this.bJN.getIsSelf()) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_self_group_click");
            } else if (ht(3)) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_guid_group_click");
            } else {
                return;
            }
            UserData userData = this.bJN.getUserData();
            if (userData != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), this.bJN.getId(), userData.getSex())));
            }
        } else if (view.getId() == this.bJO.acg().getId()) {
            abs();
        } else if (view.getId() == this.bJO.abz().getId()) {
            UserData userData2 = this.bJN.getUserData();
            if (userData2 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), this.bJN.getId(), userData2.getSex(), 1)));
            }
        } else if (view.getId() == this.bJO.abB().getId()) {
            UserData userData3 = this.bJN.getUserData();
            if (userData3 != null) {
                sendMessage(new CustomMessage(2002001, new PersonFriendActivityConfig(getPageContext().getPageActivity(), this.bJN.getId(), userData3.getSex(), 1)));
            }
        } else if (view.getId() == this.bJO.aby().getId()) {
            UserData userData4 = this.bJN.getUserData();
            if (userData4 != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), userData4.getUserId(), userData4.getSex(), 1)));
            }
        } else if (view.getId() == this.bJO.abw().getId()) {
            UserData userData5 = this.bJN.getUserData();
            if (userData5 != null) {
                if (this.mIsHost) {
                    str = "iowner_gift";
                } else {
                    str = "iguest_gift";
                }
                sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(getPageContext().getPageActivity(), userData5.getUserId(), userData5.getSex(), str)));
                this.bJO.hu(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.rY().so();
            }
        } else if (view.getId() == this.bJO.abC().getId()) {
            if (this.bJN.getIsSelf()) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_self_attentionme_click");
            } else {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_guid_attentionme_click");
            }
            UserData userData6 = this.bJN.getUserData();
            if (userData6 != null) {
                this.bJO.ek(false);
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData6.getUserId(), userData6.getSex())));
            }
        } else if (view.getId() == this.bJO.abD().getId()) {
            if (this.bJN.getIsSelf()) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_self_attentionper_click");
            } else {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_guid_attentionper_click");
            }
            UserData userData7 = this.bJN.getUserData();
            if (userData7 != null) {
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData7.getUserId(), userData7.getSex())));
            }
        } else if (view.getId() == this.bJO.abF().getId()) {
            if (this.bJN.getIsSelf()) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_self_attentionbar_click");
            } else if (ht(2)) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_guid_attentionbar_click");
            } else {
                return;
            }
            UserData userData8 = this.bJN.getUserData();
            if (userData8 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), userData8.getLike_bars(), this.bJN.getId(), userData8.getSex())));
            }
        } else if (view.getId() == this.bJO.abG().getId()) {
            if (this.bJN.getIsSelf()) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_self_thread_click");
            } else if (ht(4)) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "person_guid_thread_click");
            } else {
                return;
            }
            UserData userData9 = this.bJN.getUserData();
            if (userData9 != null) {
                sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(getPageContext().getPageActivity(), userData9.getUserId(), userData9.getSex(), userData9.getPortrait())));
            }
        } else if (view.getId() == this.bJO.abA().getId()) {
            if (!this.bJL) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "igift_icon_ck");
                UserData userData10 = this.bJN.getUserData();
                if (userData10 != null) {
                    if (!com.baidu.adp.lib.util.l.isNetOk()) {
                        showToast(com.baidu.tieba.z.no_signall_data);
                        return;
                    }
                    this.bJL = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData10.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bJO.abP().getId()) {
            if (!this.bJL) {
                com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "igift_icon_ck");
                UserData userData11 = this.bJN.getUserData();
                if (userData11 != null) {
                    if (!com.baidu.adp.lib.util.l.isNetOk()) {
                        showToast(com.baidu.tieba.z.no_signall_data);
                        return;
                    }
                    this.bJL = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData11.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bJO.abR().getId()) {
            sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(getPageContext().getPageActivity())));
        } else if (this.bJO.abb() != null && view.getId() == this.bJO.abb().getId()) {
            this.bJO.aci();
            abr();
        } else if (this.bJO.aba() != null && view.getId() == this.bJO.aba().getId()) {
            this.bJO.aci();
            if (this.bJN.getUserData() != null) {
                com.baidu.tbadk.newFriends.a.yS().u(this.bJN.getUserData().getUserIdLong());
            }
        }
    }

    private void abr() {
        String format;
        String userName = this.bJN.getUserData() != null ? this.bJN.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(com.baidu.tieba.z.confirm, new e(this));
            aVar.b(com.baidu.tieba.z.cancel, new f(this));
            if (this.bJM.getMaskType() == 1) {
                format = String.format(getPageContext().getString(com.baidu.tieba.z.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(com.baidu.tieba.z.block_chat_message_alert), userName);
            }
            aVar.bW(format);
            aVar.b(getPageContext());
            aVar.nX();
        }
    }

    private void abs() {
        if (this.bJN.getUserData() != null && this.bJN.getUserData().getIsOfficialAccount() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(this.bJN.getUserData().getUserId(), 0L), this.bJN.getUserData().getUserName(), this.bJN.getUserData().getPortrait(), 0, 4)));
        } else if (this.mIsHost) {
            AntiData abT = this.bJN.abT();
            if (abT != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AppealActivityConfig(getPageContext().getPageActivity(), abT.getBlock_forum_id(), abT.getUser_id(), abT.getUser_name())));
            }
        } else {
            PersonTainInfo abV = this.bJN.abV();
            if (abV != null) {
                int isFriend = abV.getIsFriend();
                if (isFriend == 0) {
                    UserData userData = this.bJN.getUserData();
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.bJN.abY(), abV.getUserClientVersionLower(), this.bJN.getStType())));
                    }
                } else if (isFriend == 1) {
                    UserData userData2 = this.bJN.getUserData();
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
                    com.baidu.tbadk.newFriends.a.yS().c(com.baidu.adp.lib.g.c.a(this.bJN.getId(), 0L), "pers_pg");
                }
            }
        }
    }

    private boolean ht(int i) {
        int uQ;
        if (this.bJN.getUserData() == null || this.bJN.getUserData().getPersonPrivate() == null) {
            return false;
        }
        com.baidu.tbadk.data.h personPrivate = this.bJN.getUserData().getPersonPrivate();
        switch (i) {
            case 2:
                uQ = personPrivate.uN();
                break;
            case 3:
                uQ = personPrivate.uO();
                break;
            case 4:
                uQ = personPrivate.uP();
                break;
            case 5:
                uQ = personPrivate.uQ();
                break;
            default:
                uQ = 1;
                break;
        }
        if (this.bJN.abV() != null && this.bJN.abV().getIsFriend() != 1 && uQ == 2) {
            showToast(com.baidu.tieba.z.private_friend_open);
            return false;
        } else if (uQ == 3) {
            showToast(com.baidu.tieba.z.private_hide);
            return false;
        } else {
            return true;
        }
    }

    public void abt() {
        String[] strArr = {getPageContext().getString(com.baidu.tieba.z.hd_photo), getPageContext().getString(com.baidu.tieba.z.change_photo)};
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(getPageContext().getPageActivity());
        iVar.bD(com.baidu.tieba.z.operation);
        iVar.a(strArr, new g(this));
        iVar.e(getPageContext());
        iVar.nZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abu() {
        if (this.bJN != null && this.bJN.getUserData() != null) {
            sendMessage(new CustomMessage(2002001, new PersonImageActivityConfig(getPageContext().getPageActivity(), hO(this.bJN.getUserData().getPortraitH()))));
        }
    }

    private String hO(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void abv() {
        if (this.bJN != null && this.bJN.abV() != null && this.bJM != null) {
            this.bJO.j(this.bJN.abV().getIsFriend() == 1, this.bJM.getMaskType() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            if (this.bJN != null) {
                if (msgFans > 0) {
                    this.bJN.ai(msgFans);
                    this.bJO.ek(true);
                }
                this.bJO.hu(msgGiftNum);
            }
        }
    }
}
