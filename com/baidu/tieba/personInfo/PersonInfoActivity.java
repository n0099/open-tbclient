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
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BuyGiftActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.data.PersonFriendActivityConfig;
import com.baidu.tieba.person.data.PersonImageActivityConfig;
import com.baidu.tieba.person.data.PersonListActivityConfig;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.i;
import java.util.HashMap;
/* loaded from: classes.dex */
public class PersonInfoActivity extends BaseActivity<PersonInfoActivity> {
    private static final String cnb = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private UserMuteAddAndDelModel<PersonInfoActivity> cjm;
    private com.baidu.tieba.usermute.i cjn;
    private BlackListModel ctQ;
    private y ctR;
    private aj ctS;
    private boolean mIsHost;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.tbadkCore.e.a aMt = null;
    private int ctO = -1;
    private boolean ctP = false;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private final int ctT = 2000;
    private final com.baidu.adp.framework.listener.a ctU = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e ctV = new l(this, 104102);
    final com.baidu.adp.framework.listener.e ctW = new m(this, 304102);
    final CustomMessageListener ctX = new n(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    final CustomMessageListener ctY = new o(this, CmdConfigCustom.CMD_BUY_YINJI_SUCCESS);
    private final CustomMessageListener aGt = new p(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e ctZ = new q(this, 304103);
    private final CustomMessageListener cua = new r(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    private final CustomMessageListener cfG = new s(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private final CustomMessageListener cub = new b(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    private i.a cjC = new c(this);
    private final CustomMessageListener cuc = new d(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private UserMuteAddAndDelModel.a cjB = new e(this);
    private UserMuteAddAndDelModel.b cud = new f(this);

    public y ajH() {
        return this.ctR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l(bundle);
        this.mIsHost = this.ctR.getIsSelf();
        registerListener();
        initUI();
        ajJ();
        ajI();
    }

    private void registerListener() {
        registerListener(this.ctU);
        registerListener(this.ctV);
        registerListener(this.ctW);
        registerListener(this.ctX);
        registerListener(this.ctZ);
        registerListener(this.aGt);
        registerListener(this.cfG);
        registerListener(this.cub);
        registerListener(this.cuc);
        registerListener(this.cua);
        registerListener(this.ctY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ctR.ajr();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgGiftNum();
        this.ctP = false;
        if (TbadkCoreApplication.getRefreshFlag()) {
            this.ctR.akw();
            TbadkCoreApplication.setRefreshFlag(false);
            return;
        }
        long msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgFans();
        if (msgFans != this.ctR.ako() && msgFans > 0) {
            this.ctR.aR(msgFans);
            this.ctS.fd(true);
        } else {
            this.ctR.aR(msgFans);
            this.ctS.fd(false);
        }
        this.ctR.jB(msgGiftNum);
        this.ctS.jA(msgGiftNum);
    }

    private void ajI() {
        if (com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("person_center_first_visit", true)) {
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("person_center_first_visit", false);
            showToast(i.h.person_user_icon_notify);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.ctR.akw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ctR.aku();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        com.baidu.tbadk.imageManager.c.BV().ek(TbConfig.getBigImageMaxUsedMemory());
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cjn.onDestroy();
        this.ctS.onDestroy();
        if (this.mIsHost) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK));
        }
    }

    private void initUI() {
        this.ctS = new aj(this, this.mIsHost);
        this.ctS.setExpandListRefreshListener(new g(this));
        if (this.mIsHost) {
            this.ctR.akv();
        }
        this.ctS.startLoad();
    }

    private void ajJ() {
        if (this.aMt == null) {
            this.aMt = new com.baidu.tieba.tbadkCore.e.a("profileStat");
            this.aMt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ctS.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.ctR != null) {
            bundle.putBoolean("self", this.ctR.getIsSelf());
            bundle.putString("un", this.ctR.getId());
            bundle.putString("name", this.ctR.getName());
            bundle.putBoolean("tab_page", this.ctR.akq());
            bundle.putBoolean("tab_msg", this.ctR.akr());
            bundle.putString("from", this.ctR.aks());
            bundle.putString("st_type", this.ctR.getStType());
        }
    }

    private void l(Bundle bundle) {
        this.mPersonChangeData = new PersonChangeData();
        this.ctQ = new BlackListModel(this);
        this.ctR = new y(this);
        a(this.ctR, bundle);
        this.ctR.setLoadDataCallBack(new h(this));
        this.cjm = new UserMuteAddAndDelModel<>(this);
        this.cjm.a(this.cjB);
        this.cjm.a(this.cud);
        this.cjn = new com.baidu.tieba.usermute.i(getPageContext(), this.cjC);
    }

    private void a(y yVar, Bundle bundle) {
        if (bundle != null) {
            yVar.kh(bundle.getString("from"));
            yVar.setIsSelf(bundle.getBoolean("self", false));
            yVar.setId(bundle.getString("un"));
            yVar.setName(bundle.getString("name"));
            yVar.fe(bundle.getBoolean("tab_page", false));
            yVar.ff(bundle.getBoolean("tab_msg", false));
            yVar.setStType(bundle.getString("st_type"));
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            yVar.kh(intent.getStringExtra("from"));
            yVar.setIsSelf(intent.getBooleanExtra("self", false));
            yVar.setId(intent.getStringExtra("un"));
            yVar.setName(intent.getStringExtra("name"));
            yVar.fe(intent.getBooleanExtra("tab_page", false));
            yVar.ff(intent.getBooleanExtra("tab_msg", false));
            yVar.setStType(intent.getStringExtra("st_type"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajK() {
        long c = com.baidu.adp.lib.g.b.c(this.ctR.getId(), 0L);
        this.cjn.e(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), c);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                R(intent);
            } else if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        K(intent);
                    } else {
                        getAlbumDataFromImage(intent);
                    }
                }
            } else if (i == 12010 || i == 12009) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.ctR.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.BV().fo(this.ctR.getUserData().getPortrait());
                }
                this.ctR.akw();
            } else if (i == 12014) {
                this.ctR.akw();
            }
        } else if (i2 == 0 && i == 12010) {
            am.c(getPageContext());
        }
    }

    private void getAlbumDataFromImage(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    private void K(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void R(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra(PersonChangeData.TAG_PERSON_INFO);
        if (personChangeData != null && this.ctR.getUserData() != null) {
            this.ctR.a(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.ctR.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.BV().fo(this.ctR.getUserData().getPortrait());
                }
            }
        }
        this.ctR.akw();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        UserData userData;
        if (view.getId() == this.ctS.akF().getId()) {
            finish();
        } else if (view.getId() == this.ctS.akj().getId()) {
            if (this.ctR.getUserData() != null) {
                if (this.ctR.getIsSelf()) {
                    ajb();
                } else {
                    ajO();
                }
            }
        } else if (view.getId() == this.ctS.aka().getId()) {
            if (this.ctR.getIsSelf()) {
                TiebaStatic.log("person_self_group_click");
            } else if (jz(3)) {
                TiebaStatic.log("person_guid_group_click");
            } else {
                return;
            }
            UserData userData2 = this.ctR.getUserData();
            if (userData2 != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(getPageContext().getPageActivity(), this.ctR.getId(), userData2.getSex())));
            }
        } else if (view.getId() == this.ctS.akb().getId()) {
            if (this.ctR.getIsSelf()) {
                TiebaStatic.log("person_self_attentionbar_click");
            } else if (jz(2)) {
                TiebaStatic.log("person_guid_attentionbar_click");
            } else {
                return;
            }
            UserData userData3 = this.ctR.getUserData();
            if (userData3 != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), userData3.getLike_bars(), this.ctR.getId(), userData3.getSex())));
            }
        } else if (view.getId() == this.ctS.akc().getId()) {
            if (this.ctR.getIsSelf()) {
                TiebaStatic.log("person_self_thread_click");
            } else if (jz(4)) {
                TiebaStatic.log("person_guid_thread_click");
            } else {
                return;
            }
            UserData userData4 = this.ctR.getUserData();
            if (userData4 != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(getPageContext().getPageActivity(), userData4.getUserId(), userData4.getSex(), userData4.getPortrait())));
            }
        } else if (view.getId() == this.ctS.akk().getId()) {
            ajL();
        } else if (bd.ah(getPageContext().getPageActivity())) {
            if (view.getId() == this.ctS.akE().getId()) {
                if (!this.mIsHost) {
                    ajP();
                    return;
                }
                PersonChangeData personChangeData = new PersonChangeData();
                if (this.ctR.getUserData() != null) {
                    personChangeData.setName(this.ctR.getUserData().getName_show());
                    personChangeData.setIntro(this.ctR.getUserData().getIntro());
                    personChangeData.setSex(this.ctR.getUserData().getSex());
                    personChangeData.setPortrait(this.ctR.getUserData().getPortrait());
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, personChangeData, true)));
                TiebaStatic.log("person_editprofile_click");
            } else if (view.getId() == this.ctS.akm().getId()) {
                this.ctR.akt();
            } else if (view.getId() == this.ctS.akB().getId()) {
                ajN();
            } else if (view.getId() == this.ctS.ajT().getId()) {
                UserData userData5 = this.ctR.getUserData();
                if (userData5 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), this.ctR.getId(), userData5.getSex(), 1)));
                }
            } else if (view.getId() == this.ctS.ajU().getId()) {
                if (this.ctR.getIsSelf() && (userData = this.ctR.getUserData()) != null) {
                    userData.setNewMarkCount(0);
                    if (this.ctS != null && this.ctS.akG() != null) {
                        this.ctS.akG().notifyDataSetChanged();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(getPageContext().getPageActivity())));
                }
            } else if (view.getId() == this.ctS.ajW().getId()) {
                UserData userData6 = this.ctR.getUserData();
                if (userData6 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonFriendActivityConfig(getPageContext().getPageActivity(), this.ctR.getId(), userData6.getSex(), 1)));
                }
            } else if (view.getId() == this.ctS.ajS().getId()) {
                UserData userData7 = this.ctR.getUserData();
                if (userData7 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(getPageContext().getPageActivity(), userData7.getUserId(), userData7.getSex(), 1)));
                }
            } else if (view.getId() == this.ctS.ajQ().getId()) {
                UserData userData8 = this.ctR.getUserData();
                if (userData8 != null) {
                    if (this.mIsHost) {
                        str = "iowner_gift";
                    } else {
                        str = "iguest_gift";
                    }
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(getPageContext().getPageActivity(), userData8.getUserId(), userData8.getSex(), str)));
                    this.ctS.jA(0);
                    com.baidu.tbadk.coreExtra.messageCenter.a.wM().xd();
                }
            } else if (view.getId() == this.ctS.ajX().getId()) {
                if (this.ctR.getIsSelf()) {
                    TiebaStatic.log("person_self_attentionme_click");
                } else {
                    TiebaStatic.log("person_guid_attentionme_click");
                }
                UserData userData9 = this.ctR.getUserData();
                if (userData9 != null) {
                    this.ctS.fd(false);
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData9.getUserId(), userData9.getSex())));
                }
            } else if (this.ctS.ajZ() != null && view.getId() == this.ctS.ajZ().getId()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(getPageContext().getPageActivity())));
            } else if (view.getId() == this.ctS.ajY().getId()) {
                if (this.ctR.getIsSelf()) {
                    TiebaStatic.log("person_self_attentionper_click");
                } else {
                    TiebaStatic.log("person_guid_attentionper_click");
                }
                UserData userData10 = this.ctR.getUserData();
                if (userData10 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData10.getUserId(), userData10.getSex())));
                }
            } else if (view.getId() == this.ctS.ajV().getId()) {
                if (!this.ctP) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData11 = this.ctR.getUserData();
                    if (userData11 != null) {
                        if (!com.baidu.adp.lib.util.k.je()) {
                            showToast(i.h.no_signall_data);
                            return;
                        }
                        this.ctP = true;
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData11.getUserIdLong())));
                    }
                }
            } else if (view.getId() == this.ctS.akl().getId()) {
                if (!this.ctP) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData12 = this.ctR.getUserData();
                    if (userData12 != null) {
                        if (!com.baidu.adp.lib.util.k.je()) {
                            showToast(i.h.no_signall_data);
                            return;
                        }
                        this.ctP = true;
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData12.getUserIdLong())));
                    }
                }
            } else if (view.getId() == this.ctS.akn().getId()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(getPageContext().getPageActivity())));
            } else if (this.ctS.ajm() != null && view.getId() == this.ctS.ajm().getId()) {
                this.ctS.akD();
                ajM();
            } else if (this.ctS.ajl() != null && view.getId() == this.ctS.ajl().getId()) {
                this.ctS.akD();
                if (this.ctR.getUserData() != null) {
                    com.baidu.tbadk.newFriends.a.Dh().A(this.ctR.getUserData().getUserIdLong());
                }
            } else if (view.getId() == this.ctS.ajn().getId()) {
                this.ctS.akD();
                if (this.ctR != null) {
                    if (!com.baidu.adp.lib.util.i.iN()) {
                        showToast(i.h.neterror);
                    } else if (this.ctO == 0) {
                        this.cjm.a(false, this.ctR.getUserData().getUserId(), this.ctR.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    } else if (this.ctO == 1) {
                        this.cjm.a(true, this.ctR.getUserData().getUserId(), this.ctR.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    }
                }
            }
        }
    }

    private void ajL() {
        if (this.ctR.getUserData() != null) {
            com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), getPageContext().getString(i.h.user_icon_web_view_title), String.valueOf(cnb) + "?user_id=" + this.ctR.getUserData().getUserId(), true, true, false);
            TiebaStatic.log(new aq("c10134").r("obj_type", 1));
        }
    }

    private void ajM() {
        String format;
        String userName = this.ctR.getUserData() != null ? this.ctR.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(i.h.confirm, new i(this));
            aVar.b(i.h.cancel, new j(this));
            if (this.ctQ.getMaskType() == 1) {
                format = String.format(getPageContext().getString(i.h.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(i.h.block_chat_message_alert), userName);
            }
            aVar.cu(format);
            aVar.b(getPageContext());
            aVar.sR();
        }
    }

    private void ajN() {
        if (this.ctR.getUserData() != null && this.ctR.getUserData().getIsOfficialAccount() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.ctR.getUserData().getUserId(), 0L), this.ctR.getUserData().getUserName(), this.ctR.getUserData().getPortrait(), 0, 4)));
        } else if (this.mIsHost) {
            if (this.ctR.afA() != null) {
                com.baidu.tbadk.browser.g.B(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
            }
        } else {
            PersonTainInfo akp = this.ctR.akp();
            if (akp != null) {
                int isFriend = akp.getIsFriend();
                if (isFriend == 0) {
                    UserData userData = this.ctR.getUserData();
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.ctR.aks(), akp.getUserClientVersionLower(), this.ctR.getStType())));
                    }
                } else if (isFriend == 1) {
                    UserData userData2 = this.ctR.getUserData();
                    if (userData2 != null) {
                        if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(i.h.login_to_chat), true, 11028)));
                        } else if (!this.mIsHost) {
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "enter_chat", "personclick", 1, new Object[0]);
                            try {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), Long.parseLong(userData2.getUserId()), userData2.getUserName(), userData2.getPortrait(), userData2.getSex())));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else if (isFriend == 2) {
                    com.baidu.tbadk.newFriends.a.Dh().b(com.baidu.adp.lib.g.b.c(this.ctR.getId(), 0L), "pers_pg");
                }
            }
        }
    }

    private boolean jz(int i) {
        int Ae;
        if (this.ctR.getUserData() == null || this.ctR.getUserData().getPersonPrivate() == null) {
            bd.ah(getPageContext().getPageActivity());
            return false;
        }
        com.baidu.tbadk.data.f personPrivate = this.ctR.getUserData().getPersonPrivate();
        switch (i) {
            case 2:
                Ae = personPrivate.Ab();
                break;
            case 3:
                Ae = personPrivate.Ac();
                break;
            case 4:
                Ae = personPrivate.Ad();
                break;
            case 5:
                Ae = personPrivate.Ae();
                break;
            default:
                Ae = 1;
                break;
        }
        if (this.ctR.akp() != null && this.ctR.akp().getIsFriend() != 1 && Ae == 2) {
            showToast(i.h.private_friend_open);
            return false;
        } else if (Ae != 3) {
            return bd.ah(getPageContext().getPageActivity());
        } else {
            showToast(i.h.private_hide);
            return false;
        }
    }

    public void ajb() {
        String[] strArr = {getPageContext().getString(i.h.hd_photo), getPageContext().getString(i.h.change_photo), getPageContext().getString(i.h.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bI(i.h.operation);
        cVar.a(strArr, new k(this));
        cVar.d(getPageContext());
        cVar.sU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajO() {
        if (this.ctR != null && this.ctR.getUserData() != null) {
            String kf = kf(this.ctR.getUserData().getPortraitH());
            HashMap hashMap = new HashMap();
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = this.ctR.getUserData().getPortrait();
            imageUrlData.urlType = 25;
            hashMap.put(kf, imageUrlData);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonImageActivityConfig(getPageContext().getPageActivity(), kf, hashMap)));
        }
    }

    private String kf(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void ajP() {
        if (this.ctR != null && this.ctR.akp() != null && this.ctQ != null) {
            this.ctS.a(this.ctR.akp().getIsFriend() == 1, this.ctQ.getMaskType() == 1, this.ctO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            if (this.ctR != null) {
                if (msgFans > 0) {
                    this.ctR.aR(msgFans);
                    this.ctS.fd(true);
                }
                this.ctS.jA(msgGiftNum);
            }
        }
    }
}
