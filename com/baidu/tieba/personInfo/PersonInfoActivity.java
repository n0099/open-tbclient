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
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* loaded from: classes.dex */
public class PersonInfoActivity extends BaseActivity<PersonInfoActivity> {
    private static final String bDd;
    private BlackListModel bIa;
    private v bIb;
    private ae bIc;
    private boolean mIsHost;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.tbadkCore.d.a aCg = null;
    private boolean bHZ = false;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private com.baidu.adp.framework.listener.a bId = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e bIe = new h(this, 104102);
    final com.baidu.adp.framework.listener.e bIf = new i(this, 304102);
    final CustomMessageListener bIg = new j(this, 2001178);
    private final CustomMessageListener aCA = new k(this, 2001178);
    private final com.baidu.adp.framework.listener.e bIh = new l(this, 304103);
    private CustomMessageListener bIi = new m(this, 2001238);
    private CustomMessageListener bIj = new n(this, 2001118);
    private final CustomMessageListener bIk = new o(this, 2001124);
    private final CustomMessageListener bIl = new b(this, 2001237);

    static {
        Je();
        bDd = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/135_1";
    }

    private static void Je() {
        com.baidu.tieba.tbadkCore.a.a.a(303012, ProfileSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PROFILE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.O("c/u/user/profile", 303012));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ProfileHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public v aaL() {
        return this.bIb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k(bundle);
        this.mIsHost = this.bIb.getIsSelf();
        registerListener();
        aaM();
        initUI();
        Vm();
    }

    private void registerListener() {
        registerListener(this.bId);
        registerListener(this.bIe);
        registerListener(this.bIf);
        registerListener(this.bIg);
        registerListener(this.bIh);
        registerListener(this.aCA);
        registerListener(this.bIj);
        registerListener(this.bIk);
        registerListener(this.bIl);
        registerListener(this.bIi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        aaM();
        this.bIb.aaz();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.rI().getMsgGiftNum();
        this.bHZ = false;
        if (TbadkCoreApplication.getRefreshFlag()) {
            this.bIb.aby();
            TbadkCoreApplication.setRefreshFlag(false);
            return;
        }
        long msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.rI().getMsgFans();
        if (msgFans != this.bIb.abo() && msgFans > 0) {
            this.bIb.ai(msgFans);
            this.bIc.ee(true);
        }
        if (msgGiftNum > 0) {
            this.bIb.hm(msgGiftNum);
            this.bIc.hl(msgGiftNum);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.bIc.onStart();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.bIc.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bIb.abw();
    }

    private void aaM() {
        com.baidu.tbadk.imageManager.e.vL().dp(TbConfig.getBigImageMaxUsedMemory() - (TbConfig.getBigImageMaxUsedMemory() - 1152000));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        com.baidu.tbadk.imageManager.e.vL().dp(TbConfig.getBigImageMaxUsedMemory());
        this.bIc.onStop();
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
        this.bIc = new ae(this, this.mIsHost);
        this.bIc.setExpandListRefreshListener(new c(this));
        if (this.mIsHost) {
            this.bIb.abx();
        }
        this.bIc.startLoad();
    }

    private void Vm() {
        if (this.aCg == null) {
            this.aCg = new com.baidu.tieba.tbadkCore.d.a("profileStat");
            this.aCg.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bIc.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bIb != null) {
            bundle.putBoolean("self", this.bIb.getIsSelf());
            bundle.putString("un", this.bIb.getId());
            bundle.putString("name", this.bIb.getName());
            bundle.putBoolean("tab_page", this.bIb.abs());
            bundle.putBoolean("tab_msg", this.bIb.abt());
            bundle.putString("from", this.bIb.abu());
            bundle.putString("st_type", this.bIb.getStType());
        }
    }

    private void k(Bundle bundle) {
        this.mPersonChangeData = new PersonChangeData();
        this.bIa = new BlackListModel(this);
        this.bIb = new v(this);
        if (bundle != null) {
            this.bIb.hI(bundle.getString("from"));
            this.bIb.setIsSelf(bundle.getBoolean("self", false));
            this.bIb.setId(bundle.getString("un"));
            this.bIb.setName(bundle.getString("name"));
            this.bIb.ef(bundle.getBoolean("tab_page", false));
            this.bIb.eg(bundle.getBoolean("tab_msg", false));
            this.bIb.setStType(bundle.getString("st_type"));
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bIb.hI(intent.getStringExtra("from_forum"));
                this.bIb.setIsSelf(intent.getBooleanExtra("self", false));
                this.bIb.setId(intent.getStringExtra("un"));
                this.bIb.setName(intent.getStringExtra("name"));
                this.bIb.ef(intent.getBooleanExtra("tab_page", false));
                this.bIb.eg(intent.getBooleanExtra("tab_msg", false));
                this.bIb.setStType(intent.getStringExtra("st_type"));
            }
        }
        this.bIb.setLoadDataCallBack(new d(this));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                S(intent);
            } else if (i == 12002) {
                if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
                    this.writeImagesInfo.parseJson(stringExtra);
                    this.writeImagesInfo.updateQuality();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath())));
                    }
                    this.writeImagesInfo.clear();
                }
            } else if (i == 12001) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj())));
            } else if (i == 12010 || i == 12009) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.bIb.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.vL().el(this.bIb.getUserData().getPortrait());
                }
                this.bIb.aby();
            }
        } else if (i2 == 0 && i == 12010) {
            aw.a(getPageContext());
        }
    }

    private void S(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra(PersonChangeData.TAG_PERSON_INFO);
        if (personChangeData != null && this.bIb.getUserData() != null) {
            this.bIb.b(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.bIb.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.vL().el(this.bIb.getUserData().getPortrait());
                }
            }
        }
        this.bIb.aby();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getId() == this.bIc.Bj().getId()) {
            finish();
        } else if (view.getId() == this.bIc.abF().getId()) {
            if (!this.mIsHost) {
                aaR();
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.bIb.getUserData() != null) {
                personChangeData.setName(this.bIb.getUserData().getName_show());
                personChangeData.setIntro(this.bIb.getUserData().getIntro());
                personChangeData.setSex(this.bIb.getUserData().getSex());
                personChangeData.setPortrait(this.bIb.getUserData().getPortrait());
            }
            sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, personChangeData, true)));
            com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "person_editprofile_click");
        } else if (view.getId() == this.bIc.abj().getId()) {
            if (this.bIb.getUserData() != null) {
                if (this.bIb.getIsSelf()) {
                    aaP();
                } else {
                    aaQ();
                }
            }
        } else if (view.getId() == this.bIc.abm().getId()) {
            this.bIb.abv();
        } else if (view.getId() == this.bIc.abk().getId()) {
            if (this.bIb.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.user_icon_intro), String.valueOf(bDd) + "?st_type=person_user_icon", true, true, false, false, false)));
            }
        } else if (view.getId() == this.bIc.aba().getId()) {
            if (this.bIb.getIsSelf()) {
                com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "person_self_group_click");
            } else if (hk(3)) {
                com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "person_guid_group_click");
            } else {
                return;
            }
            UserData userData = this.bIb.getUserData();
            if (userData != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), this.bIb.getId(), userData.getSex())));
            }
        } else if (view.getId() == this.bIc.abC().getId()) {
            aaO();
        } else if (view.getId() == this.bIc.aaV().getId()) {
            UserData userData2 = this.bIb.getUserData();
            if (userData2 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), this.bIb.getId(), userData2.getSex(), 1)));
            }
        } else if (view.getId() == this.bIc.aaX().getId()) {
            UserData userData3 = this.bIb.getUserData();
            if (userData3 != null) {
                sendMessage(new CustomMessage(2002001, new PersonFriendActivityConfig(getPageContext().getPageActivity(), this.bIb.getId(), userData3.getSex(), 1)));
            }
        } else if (view.getId() == this.bIc.aaU().getId()) {
            UserData userData4 = this.bIb.getUserData();
            if (userData4 != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), userData4.getUserId(), userData4.getSex(), 1)));
            }
        } else if (view.getId() == this.bIc.aaS().getId()) {
            UserData userData5 = this.bIb.getUserData();
            if (userData5 != null) {
                if (this.mIsHost) {
                    str = "iowner_gift";
                } else {
                    str = "iguest_gift";
                }
                sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(getPageContext().getPageActivity(), userData5.getUserId(), userData5.getSex(), str)));
                this.bIc.hl(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.rI().rY();
            }
        } else if (view.getId() == this.bIc.aaY().getId()) {
            if (this.bIb.getIsSelf()) {
                com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "person_self_attentionme_click");
            } else {
                com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "person_guid_attentionme_click");
            }
            UserData userData6 = this.bIb.getUserData();
            if (userData6 != null) {
                this.bIc.ee(false);
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData6.getUserId(), userData6.getSex())));
            }
        } else if (view.getId() == this.bIc.aaZ().getId()) {
            if (this.bIb.getIsSelf()) {
                com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "person_self_attentionper_click");
            } else {
                com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "person_guid_attentionper_click");
            }
            UserData userData7 = this.bIb.getUserData();
            if (userData7 != null) {
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData7.getUserId(), userData7.getSex())));
            }
        } else if (view.getId() == this.bIc.abb().getId()) {
            if (this.bIb.getIsSelf()) {
                com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "person_self_attentionbar_click");
            } else if (hk(2)) {
                com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "person_guid_attentionbar_click");
            } else {
                return;
            }
            UserData userData8 = this.bIb.getUserData();
            if (userData8 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), userData8.getLike_bars(), this.bIb.getId(), userData8.getSex())));
            }
        } else if (view.getId() == this.bIc.abc().getId()) {
            if (this.bIb.getIsSelf()) {
                com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "person_self_thread_click");
            } else if (hk(4)) {
                com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "person_guid_thread_click");
            } else {
                return;
            }
            UserData userData9 = this.bIb.getUserData();
            if (userData9 != null) {
                sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(getPageContext().getPageActivity(), userData9.getUserId(), userData9.getSex(), userData9.getPortrait())));
            }
        } else if (view.getId() == this.bIc.aaW().getId()) {
            if (!this.bHZ) {
                com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "igift_icon_ck");
                UserData userData10 = this.bIb.getUserData();
                if (userData10 != null) {
                    if (!com.baidu.adp.lib.util.l.isNetOk()) {
                        showToast(com.baidu.tieba.z.no_signall_data);
                        return;
                    }
                    this.bHZ = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData10.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bIc.abl().getId()) {
            if (!this.bHZ) {
                com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "igift_icon_ck");
                UserData userData11 = this.bIb.getUserData();
                if (userData11 != null) {
                    if (!com.baidu.adp.lib.util.l.isNetOk()) {
                        showToast(com.baidu.tieba.z.no_signall_data);
                        return;
                    }
                    this.bHZ = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData11.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bIc.abn().getId()) {
            sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(getPageContext().getPageActivity())));
        } else if (view.getId() == this.bIc.aaw().getId()) {
            this.bIc.abE();
            aaN();
        } else if (view.getId() == this.bIc.aav().getId()) {
            this.bIc.abE();
            if (this.bIb.getUserData() != null) {
                com.baidu.tbadk.newFriends.a.yC().u(this.bIb.getUserData().getUserIdLong());
            }
        }
    }

    private void aaN() {
        String format;
        String userName = this.bIb.getUserData() != null ? this.bIb.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(com.baidu.tieba.z.confirm, new e(this));
            aVar.b(com.baidu.tieba.z.cancel, new f(this));
            if (this.bIa.getMaskType() == 1) {
                format = String.format(getPageContext().getString(com.baidu.tieba.z.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(com.baidu.tieba.z.block_chat_message_alert), userName);
            }
            aVar.bY(format);
            aVar.b(getPageContext());
            aVar.nU();
        }
    }

    private void aaO() {
        if (this.bIb.getUserData() != null && this.bIb.getUserData().getIsOfficialAccount() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(this.bIb.getUserData().getUserId(), 0L), this.bIb.getUserData().getUserName(), this.bIb.getUserData().getPortrait(), 0, 4)));
        } else if (this.mIsHost) {
            AntiData abp = this.bIb.abp();
            if (abp != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AppealActivityConfig(getPageContext().getPageActivity(), abp.getBlock_forum_id(), abp.getUser_id(), abp.getUser_name())));
            }
        } else {
            PersonTainInfo abr = this.bIb.abr();
            if (abr != null) {
                int isFriend = abr.getIsFriend();
                if (isFriend == 0) {
                    UserData userData = this.bIb.getUserData();
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.bIb.abu(), abr.getUserClientVersionLower(), this.bIb.getStType())));
                    }
                } else if (isFriend == 1) {
                    UserData userData2 = this.bIb.getUserData();
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
                    com.baidu.tbadk.newFriends.a.yC().c(com.baidu.adp.lib.g.c.a(this.bIb.getId(), 0L), "pers_pg");
                }
            }
        }
    }

    private boolean hk(int i) {
        int uz;
        if (this.bIb.getUserData() == null || this.bIb.getUserData().getPersonPrivate() == null) {
            return false;
        }
        com.baidu.tbadk.data.h personPrivate = this.bIb.getUserData().getPersonPrivate();
        switch (i) {
            case 2:
                uz = personPrivate.uw();
                break;
            case 3:
                uz = personPrivate.ux();
                break;
            case 4:
                uz = personPrivate.uy();
                break;
            case 5:
                uz = personPrivate.uz();
                break;
            default:
                uz = 1;
                break;
        }
        if (this.bIb.abr() != null && this.bIb.abr().getIsFriend() != 1 && uz == 2) {
            showToast(com.baidu.tieba.z.private_friend_open);
            return false;
        } else if (uz == 3) {
            showToast(com.baidu.tieba.z.private_hide);
            return false;
        } else {
            return true;
        }
    }

    public void aaP() {
        String[] strArr = {getPageContext().getString(com.baidu.tieba.z.hd_photo), getPageContext().getString(com.baidu.tieba.z.take_photo), getPageContext().getString(com.baidu.tieba.z.album)};
        com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(getPageContext().getPageActivity());
        iVar.by(com.baidu.tieba.z.operation);
        iVar.a(strArr, new g(this));
        iVar.e(getPageContext());
        iVar.nW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaQ() {
        if (this.bIb != null && this.bIb.getUserData() != null) {
            sendMessage(new CustomMessage(2002001, new PersonImageActivityConfig(getPageContext().getPageActivity(), hH(this.bIb.getUserData().getPortraitH()))));
        }
    }

    private String hH(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void aaR() {
        if (this.bIb != null && this.bIb.abr() != null && this.bIa != null) {
            this.bIc.i(this.bIb.abr().getIsFriend() == 1, this.bIa.getMaskType() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            if (this.bIb != null) {
                if (msgFans > 0) {
                    this.bIb.ai(msgFans);
                    this.bIc.ee(true);
                }
                this.bIc.hl(msgGiftNum);
            }
        }
    }
}
