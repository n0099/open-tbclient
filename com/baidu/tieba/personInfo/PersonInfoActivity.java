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
    private static final String clM = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private UserMuteAddAndDelModel<PersonInfoActivity> cik;
    private com.baidu.tieba.usermute.i cil;
    private BlackListModel csu;
    private y csv;
    private aj csw;
    private boolean mIsHost;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.tbadkCore.e.a aMl = null;
    private int css = -1;
    private boolean cst = false;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private final int csx = 2000;
    private final com.baidu.adp.framework.listener.a csy = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e csz = new l(this, 104102);
    final com.baidu.adp.framework.listener.e csA = new m(this, 304102);
    final CustomMessageListener csB = new n(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    final CustomMessageListener csC = new o(this, CmdConfigCustom.CMD_BUY_YINJI_SUCCESS);
    private final CustomMessageListener aHz = new p(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e csD = new q(this, 304103);
    private final CustomMessageListener csE = new r(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    private final CustomMessageListener cff = new s(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private final CustomMessageListener csF = new b(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    private i.a ciz = new c(this);
    private final CustomMessageListener csG = new d(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private UserMuteAddAndDelModel.a ciy = new e(this);
    private UserMuteAddAndDelModel.b csH = new f(this);

    public y ajf() {
        return this.csv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l(bundle);
        this.mIsHost = this.csv.getIsSelf();
        registerListener();
        initUI();
        ajh();
        ajg();
    }

    private void registerListener() {
        registerListener(this.csy);
        registerListener(this.csz);
        registerListener(this.csA);
        registerListener(this.csB);
        registerListener(this.csD);
        registerListener(this.aHz);
        registerListener(this.cff);
        registerListener(this.csF);
        registerListener(this.csG);
        registerListener(this.csE);
        registerListener(this.csC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.csv.aiP();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgGiftNum();
        this.cst = false;
        if (TbadkCoreApplication.getRefreshFlag()) {
            this.csv.ajU();
            TbadkCoreApplication.setRefreshFlag(false);
            return;
        }
        long msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgFans();
        if (msgFans != this.csv.ajM() && msgFans > 0) {
            this.csv.aT(msgFans);
            this.csw.fa(true);
        } else {
            this.csv.aT(msgFans);
            this.csw.fa(false);
        }
        this.csv.jn(msgGiftNum);
        this.csw.jm(msgGiftNum);
    }

    private void ajg() {
        if (com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("person_center_first_visit", true)) {
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("person_center_first_visit", false);
            showToast(i.h.person_user_icon_notify);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.csv.ajU();
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
        this.csv.ajS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        com.baidu.tbadk.imageManager.c.Cf().em(TbConfig.getBigImageMaxUsedMemory());
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cil.onDestroy();
        this.csw.onDestroy();
        if (this.mIsHost) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK));
        }
    }

    private void initUI() {
        this.csw = new aj(this, this.mIsHost);
        this.csw.setExpandListRefreshListener(new g(this));
        if (this.mIsHost) {
            this.csv.ajT();
        }
        this.csw.startLoad();
    }

    private void ajh() {
        if (this.aMl == null) {
            this.aMl = new com.baidu.tieba.tbadkCore.e.a("profileStat");
            this.aMl.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.csw.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.csv != null) {
            bundle.putBoolean("self", this.csv.getIsSelf());
            bundle.putString("un", this.csv.getId());
            bundle.putString("name", this.csv.getName());
            bundle.putBoolean("tab_page", this.csv.ajO());
            bundle.putBoolean("tab_msg", this.csv.ajP());
            bundle.putString("from", this.csv.ajQ());
            bundle.putString("st_type", this.csv.getStType());
        }
    }

    private void l(Bundle bundle) {
        this.mPersonChangeData = new PersonChangeData();
        this.csu = new BlackListModel(this);
        this.csv = new y(this);
        a(this.csv, bundle);
        this.csv.setLoadDataCallBack(new h(this));
        this.cik = new UserMuteAddAndDelModel<>(this);
        this.cik.a(this.ciy);
        this.cik.a(this.csH);
        this.cil = new com.baidu.tieba.usermute.i(getPageContext(), this.ciz);
    }

    private void a(y yVar, Bundle bundle) {
        if (bundle != null) {
            yVar.kd(bundle.getString("from"));
            yVar.setIsSelf(bundle.getBoolean("self", false));
            yVar.setId(bundle.getString("un"));
            yVar.setName(bundle.getString("name"));
            yVar.fb(bundle.getBoolean("tab_page", false));
            yVar.fc(bundle.getBoolean("tab_msg", false));
            yVar.setStType(bundle.getString("st_type"));
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            yVar.kd(intent.getStringExtra("from"));
            yVar.setIsSelf(intent.getBooleanExtra("self", false));
            yVar.setId(intent.getStringExtra("un"));
            yVar.setName(intent.getStringExtra("name"));
            yVar.fb(intent.getBooleanExtra("tab_page", false));
            yVar.fc(intent.getBooleanExtra("tab_msg", false));
            yVar.setStType(intent.getStringExtra("st_type"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aji() {
        long c = com.baidu.adp.lib.g.b.c(this.csv.getId(), 0L);
        this.cil.e(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), c);
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
                if (this.csv.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.Cf().fm(this.csv.getUserData().getPortrait());
                }
                this.csv.ajU();
            } else if (i == 12014) {
                this.csv.ajU();
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
        if (personChangeData != null && this.csv.getUserData() != null) {
            this.csv.a(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.csv.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.Cf().fm(this.csv.getUserData().getPortrait());
                }
            }
        }
        this.csv.ajU();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        UserData userData;
        if (view.getId() == this.csw.akd().getId()) {
            finish();
        } else if (view.getId() == this.csw.ajH().getId()) {
            if (this.csv.getUserData() != null) {
                if (this.csv.getIsSelf()) {
                    aiz();
                } else {
                    ajm();
                }
            }
        } else if (view.getId() == this.csw.ajy().getId()) {
            if (this.csv.getIsSelf()) {
                TiebaStatic.log("person_self_group_click");
            } else if (jl(3)) {
                TiebaStatic.log("person_guid_group_click");
            } else {
                return;
            }
            UserData userData2 = this.csv.getUserData();
            if (userData2 != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(getPageContext().getPageActivity(), this.csv.getId(), userData2.getSex())));
            }
        } else if (view.getId() == this.csw.ajz().getId()) {
            if (this.csv.getIsSelf()) {
                TiebaStatic.log("person_self_attentionbar_click");
            } else if (jl(2)) {
                TiebaStatic.log("person_guid_attentionbar_click");
            } else {
                return;
            }
            UserData userData3 = this.csv.getUserData();
            if (userData3 != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), userData3.getLike_bars(), this.csv.getId(), userData3.getSex())));
            }
        } else if (view.getId() == this.csw.ajA().getId()) {
            if (this.csv.getIsSelf()) {
                TiebaStatic.log("person_self_thread_click");
            } else if (jl(4)) {
                TiebaStatic.log("person_guid_thread_click");
            } else {
                return;
            }
            UserData userData4 = this.csv.getUserData();
            if (userData4 != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(getPageContext().getPageActivity(), userData4.getUserId(), userData4.getSex(), userData4.getPortrait())));
            }
        } else if (view.getId() == this.csw.ajI().getId()) {
            ajj();
        } else if (bd.ah(getPageContext().getPageActivity())) {
            if (view.getId() == this.csw.akc().getId()) {
                if (!this.mIsHost) {
                    ajn();
                    return;
                }
                PersonChangeData personChangeData = new PersonChangeData();
                if (this.csv.getUserData() != null) {
                    personChangeData.setName(this.csv.getUserData().getName_show());
                    personChangeData.setIntro(this.csv.getUserData().getIntro());
                    personChangeData.setSex(this.csv.getUserData().getSex());
                    personChangeData.setPortrait(this.csv.getUserData().getPortrait());
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, personChangeData, true)));
                TiebaStatic.log("person_editprofile_click");
            } else if (view.getId() == this.csw.ajK().getId()) {
                this.csv.ajR();
            } else if (view.getId() == this.csw.ajZ().getId()) {
                ajl();
            } else if (view.getId() == this.csw.ajr().getId()) {
                UserData userData5 = this.csv.getUserData();
                if (userData5 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), this.csv.getId(), userData5.getSex(), 1)));
                }
            } else if (view.getId() == this.csw.ajs().getId()) {
                if (this.csv.getIsSelf() && (userData = this.csv.getUserData()) != null) {
                    userData.setNewMarkCount(0);
                    if (this.csw != null && this.csw.ake() != null) {
                        this.csw.ake().notifyDataSetChanged();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(getPageContext().getPageActivity())));
                }
            } else if (view.getId() == this.csw.aju().getId()) {
                UserData userData6 = this.csv.getUserData();
                if (userData6 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonFriendActivityConfig(getPageContext().getPageActivity(), this.csv.getId(), userData6.getSex(), 1)));
                }
            } else if (view.getId() == this.csw.ajq().getId()) {
                UserData userData7 = this.csv.getUserData();
                if (userData7 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(getPageContext().getPageActivity(), userData7.getUserId(), userData7.getSex(), 1)));
                }
            } else if (view.getId() == this.csw.ajo().getId()) {
                UserData userData8 = this.csv.getUserData();
                if (userData8 != null) {
                    if (this.mIsHost) {
                        str = "iowner_gift";
                    } else {
                        str = "iguest_gift";
                    }
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(getPageContext().getPageActivity(), userData8.getUserId(), userData8.getSex(), str)));
                    this.csw.jm(0);
                    com.baidu.tbadk.coreExtra.messageCenter.a.wK().xb();
                }
            } else if (view.getId() == this.csw.ajv().getId()) {
                if (this.csv.getIsSelf()) {
                    TiebaStatic.log("person_self_attentionme_click");
                } else {
                    TiebaStatic.log("person_guid_attentionme_click");
                }
                UserData userData9 = this.csv.getUserData();
                if (userData9 != null) {
                    this.csw.fa(false);
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData9.getUserId(), userData9.getSex())));
                }
            } else if (this.csw.ajx() != null && view.getId() == this.csw.ajx().getId()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(getPageContext().getPageActivity())));
            } else if (view.getId() == this.csw.ajw().getId()) {
                if (this.csv.getIsSelf()) {
                    TiebaStatic.log("person_self_attentionper_click");
                } else {
                    TiebaStatic.log("person_guid_attentionper_click");
                }
                UserData userData10 = this.csv.getUserData();
                if (userData10 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData10.getUserId(), userData10.getSex())));
                }
            } else if (view.getId() == this.csw.ajt().getId()) {
                if (!this.cst) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData11 = this.csv.getUserData();
                    if (userData11 != null) {
                        if (!com.baidu.adp.lib.util.k.jd()) {
                            showToast(i.h.no_signall_data);
                            return;
                        }
                        this.cst = true;
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData11.getUserIdLong())));
                    }
                }
            } else if (view.getId() == this.csw.ajJ().getId()) {
                if (!this.cst) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData12 = this.csv.getUserData();
                    if (userData12 != null) {
                        if (!com.baidu.adp.lib.util.k.jd()) {
                            showToast(i.h.no_signall_data);
                            return;
                        }
                        this.cst = true;
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData12.getUserIdLong())));
                    }
                }
            } else if (view.getId() == this.csw.ajL().getId()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(getPageContext().getPageActivity())));
            } else if (this.csw.aiK() != null && view.getId() == this.csw.aiK().getId()) {
                this.csw.akb();
                ajk();
            } else if (this.csw.aiJ() != null && view.getId() == this.csw.aiJ().getId()) {
                this.csw.akb();
                if (this.csv.getUserData() != null) {
                    com.baidu.tbadk.newFriends.a.Dr().C(this.csv.getUserData().getUserIdLong());
                }
            } else if (view.getId() == this.csw.aiL().getId()) {
                this.csw.akb();
                if (this.csv != null) {
                    if (!com.baidu.adp.lib.util.i.iM()) {
                        showToast(i.h.neterror);
                    } else if (this.css == 0) {
                        this.cik.a(false, this.csv.getUserData().getUserId(), this.csv.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    } else if (this.css == 1) {
                        this.cik.a(true, this.csv.getUserData().getUserId(), this.csv.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    }
                }
            }
        }
    }

    private void ajj() {
        if (this.csv.getUserData() != null) {
            com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), getPageContext().getString(i.h.user_icon_web_view_title), String.valueOf(clM) + "?user_id=" + this.csv.getUserData().getUserId(), true, true, false);
            TiebaStatic.log(new aq("c10134").r("obj_type", 1));
        }
    }

    private void ajk() {
        String format;
        String userName = this.csv.getUserData() != null ? this.csv.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(i.h.confirm, new i(this));
            aVar.b(i.h.cancel, new j(this));
            if (this.csu.getMaskType() == 1) {
                format = String.format(getPageContext().getString(i.h.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(i.h.block_chat_message_alert), userName);
            }
            aVar.cu(format);
            aVar.b(getPageContext());
            aVar.sR();
        }
    }

    private void ajl() {
        if (this.csv.getUserData() != null && this.csv.getUserData().getIsOfficialAccount() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.csv.getUserData().getUserId(), 0L), this.csv.getUserData().getUserName(), this.csv.getUserData().getPortrait(), 0, 4)));
        } else if (this.mIsHost) {
            if (this.csv.afh() != null) {
                com.baidu.tbadk.browser.g.B(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
            }
        } else {
            PersonTainInfo ajN = this.csv.ajN();
            if (ajN != null) {
                int isFriend = ajN.getIsFriend();
                if (isFriend == 0) {
                    UserData userData = this.csv.getUserData();
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.csv.ajQ(), ajN.getUserClientVersionLower(), this.csv.getStType())));
                    }
                } else if (isFriend == 1) {
                    UserData userData2 = this.csv.getUserData();
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
                    com.baidu.tbadk.newFriends.a.Dr().b(com.baidu.adp.lib.g.b.c(this.csv.getId(), 0L), "pers_pg");
                }
            }
        }
    }

    private boolean jl(int i) {
        int Ac;
        if (this.csv.getUserData() == null || this.csv.getUserData().getPersonPrivate() == null) {
            bd.ah(getPageContext().getPageActivity());
            return false;
        }
        com.baidu.tbadk.data.f personPrivate = this.csv.getUserData().getPersonPrivate();
        switch (i) {
            case 2:
                Ac = personPrivate.zZ();
                break;
            case 3:
                Ac = personPrivate.Aa();
                break;
            case 4:
                Ac = personPrivate.Ab();
                break;
            case 5:
                Ac = personPrivate.Ac();
                break;
            default:
                Ac = 1;
                break;
        }
        if (this.csv.ajN() != null && this.csv.ajN().getIsFriend() != 1 && Ac == 2) {
            showToast(i.h.private_friend_open);
            return false;
        } else if (Ac != 3) {
            return bd.ah(getPageContext().getPageActivity());
        } else {
            showToast(i.h.private_hide);
            return false;
        }
    }

    public void aiz() {
        String[] strArr = {getPageContext().getString(i.h.hd_photo), getPageContext().getString(i.h.change_photo), getPageContext().getString(i.h.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bI(i.h.operation);
        cVar.a(strArr, new k(this));
        cVar.d(getPageContext());
        cVar.sU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajm() {
        if (this.csv != null && this.csv.getUserData() != null) {
            String kc = kc(this.csv.getUserData().getPortraitH());
            HashMap hashMap = new HashMap();
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = this.csv.getUserData().getPortrait();
            imageUrlData.urlType = 25;
            hashMap.put(kc, imageUrlData);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonImageActivityConfig(getPageContext().getPageActivity(), kc, hashMap)));
        }
    }

    private String kc(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void ajn() {
        if (this.csv != null && this.csv.ajN() != null && this.csu != null) {
            this.csw.a(this.csv.ajN().getIsFriend() == 1, this.csu.getMaskType() == 1, this.css);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            if (this.csv != null) {
                if (msgFans > 0) {
                    this.csv.aT(msgFans);
                    this.csw.fa(true);
                }
                this.csw.jm(msgGiftNum);
            }
        }
    }
}
