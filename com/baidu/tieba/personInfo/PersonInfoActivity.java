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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.i;
import java.util.HashMap;
/* loaded from: classes.dex */
public class PersonInfoActivity extends BaseActivity<PersonInfoActivity> {
    private static final String cfm = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private UserMuteAddAndDelModel<PersonInfoActivity> caO;
    private com.baidu.tieba.usermute.i caP;
    private BlackListModel clB;
    private w clC;
    private ag clD;
    private boolean mIsHost;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.tbadkCore.e.a aMS = null;
    private int clz = -1;
    private boolean clA = false;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private final int clE = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
    private final com.baidu.adp.framework.listener.a clF = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e clG = new k(this, 104102);
    final com.baidu.adp.framework.listener.e clH = new l(this, 304102);
    final CustomMessageListener clI = new m(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener aIi = new n(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e clJ = new o(this, 304103);
    private final CustomMessageListener clK = new p(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    private final CustomMessageListener bYS = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private final CustomMessageListener clL = new r(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    private i.a cbd = new b(this);
    private final CustomMessageListener clM = new c(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private UserMuteAddAndDelModel.a cbc = new d(this);
    private UserMuteAddAndDelModel.b clN = new e(this);

    public w agL() {
        return this.clC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k(bundle);
        this.mIsHost = this.clC.getIsSelf();
        registerListener();
        initUI();
        agN();
        agM();
    }

    private void registerListener() {
        registerListener(this.clF);
        registerListener(this.clG);
        registerListener(this.clH);
        registerListener(this.clI);
        registerListener(this.clJ);
        registerListener(this.aIi);
        registerListener(this.bYS);
        registerListener(this.clL);
        registerListener(this.clM);
        registerListener(this.clK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.clD.onStart();
        this.clC.agz();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.wT().getMsgGiftNum();
        this.clA = false;
        if (TbadkCoreApplication.getRefreshFlag()) {
            this.clC.ahB();
            TbadkCoreApplication.setRefreshFlag(false);
            return;
        }
        long msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.wT().getMsgFans();
        if (msgFans != this.clC.aht() && msgFans > 0) {
            this.clC.au(msgFans);
            this.clD.eJ(true);
        } else {
            this.clC.au(msgFans);
            this.clD.eJ(false);
        }
        this.clC.iQ(msgGiftNum);
        this.clD.iP(msgGiftNum);
    }

    private void agM() {
        if (com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("person_center_first_visit", true)) {
            com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("person_center_first_visit", false);
            showToast(i.C0057i.person_user_icon_notify);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.clC.ahB();
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
        this.clC.ahz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        com.baidu.tbadk.imageManager.c.Ce().ed(TbConfig.getBigImageMaxUsedMemory());
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.caP.onDestroy();
        this.clD.onDestroy();
        if (this.mIsHost) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK));
        }
    }

    private void initUI() {
        this.clD = new ag(this, this.mIsHost);
        this.clD.setExpandListRefreshListener(new f(this));
        if (this.mIsHost) {
            this.clC.ahA();
        }
        this.clD.startLoad();
    }

    private void agN() {
        if (this.aMS == null) {
            this.aMS = new com.baidu.tieba.tbadkCore.e.a("profileStat");
            this.aMS.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.clD.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.clC != null) {
            bundle.putBoolean("self", this.clC.getIsSelf());
            bundle.putString("un", this.clC.getId());
            bundle.putString("name", this.clC.getName());
            bundle.putBoolean("tab_page", this.clC.ahv());
            bundle.putBoolean("tab_msg", this.clC.ahw());
            bundle.putString("from", this.clC.ahx());
            bundle.putString("st_type", this.clC.getStType());
        }
    }

    private void k(Bundle bundle) {
        this.mPersonChangeData = new PersonChangeData();
        this.clB = new BlackListModel(this);
        this.clC = new w(this);
        a(this.clC, bundle);
        this.clC.setLoadDataCallBack(new g(this));
        this.caO = new UserMuteAddAndDelModel<>(this);
        this.caO.a(this.cbc);
        this.caO.a(this.clN);
        this.caP = new com.baidu.tieba.usermute.i(getPageContext(), this.cbd);
    }

    private void a(w wVar, Bundle bundle) {
        if (bundle != null) {
            wVar.jB(bundle.getString("from"));
            wVar.setIsSelf(bundle.getBoolean("self", false));
            wVar.setId(bundle.getString("un"));
            wVar.setName(bundle.getString("name"));
            wVar.eK(bundle.getBoolean("tab_page", false));
            wVar.eL(bundle.getBoolean("tab_msg", false));
            wVar.setStType(bundle.getString("st_type"));
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            wVar.jB(intent.getStringExtra("from"));
            wVar.setIsSelf(intent.getBooleanExtra("self", false));
            wVar.setId(intent.getStringExtra("un"));
            wVar.setName(intent.getStringExtra("name"));
            wVar.eK(intent.getBooleanExtra("tab_page", false));
            wVar.eL(intent.getBooleanExtra("tab_msg", false));
            wVar.setStType(intent.getStringExtra("st_type"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agO() {
        long c = com.baidu.adp.lib.g.b.c(this.clC.getId(), 0L);
        this.caP.e(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), c);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                Q(intent);
            } else if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        L(intent);
                    } else {
                        getAlbumDataFromImage(intent);
                    }
                }
            } else if (i == 12010 || i == 12009) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.clC.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.Ce().eZ(this.clC.getUserData().getPortrait());
                }
                this.clC.ahB();
            } else if (i == 12014) {
                this.clC.ahB();
            }
        } else if (i2 == 0 && i == 12010) {
            ak.c(getPageContext());
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

    private void L(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void Q(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra(PersonChangeData.TAG_PERSON_INFO);
        if (personChangeData != null && this.clC.getUserData() != null) {
            this.clC.a(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.clC.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.Ce().eZ(this.clC.getUserData().getPortrait());
                }
            }
        }
        this.clC.ahB();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        UserData userData;
        if (view.getId() == this.clD.ahK().getId()) {
            finish();
        } else if (view.getId() == this.clD.aho().getId()) {
            if (this.clC.getUserData() != null) {
                if (this.clC.getIsSelf()) {
                    agk();
                } else {
                    agS();
                }
            }
        } else if (view.getId() == this.clD.ahe().getId()) {
            if (this.clC.getIsSelf()) {
                TiebaStatic.log("person_self_group_click");
            } else if (iO(3)) {
                TiebaStatic.log("person_guid_group_click");
            } else {
                return;
            }
            UserData userData2 = this.clC.getUserData();
            if (userData2 != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(getPageContext().getPageActivity(), this.clC.getId(), userData2.getSex())));
            }
        } else if (view.getId() == this.clD.ahf().getId()) {
            if (this.clC.getIsSelf()) {
                TiebaStatic.log("person_self_attentionbar_click");
            } else if (iO(2)) {
                TiebaStatic.log("person_guid_attentionbar_click");
            } else {
                return;
            }
            UserData userData3 = this.clC.getUserData();
            if (userData3 != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), userData3.getLike_bars(), this.clC.getId(), userData3.getSex())));
            }
        } else if (view.getId() == this.clD.ahg().getId()) {
            if (this.clC.getIsSelf()) {
                TiebaStatic.log("person_self_thread_click");
            } else if (iO(4)) {
                TiebaStatic.log("person_guid_thread_click");
            } else {
                return;
            }
            UserData userData4 = this.clC.getUserData();
            if (userData4 != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(getPageContext().getPageActivity(), userData4.getUserId(), userData4.getSex(), userData4.getPortrait())));
            }
        } else if (view.getId() == this.clD.ahp().getId()) {
            agP();
        } else if (bb.ah(getPageContext().getPageActivity())) {
            if (view.getId() == this.clD.ahJ().getId()) {
                if (!this.mIsHost) {
                    agT();
                    return;
                }
                PersonChangeData personChangeData = new PersonChangeData();
                if (this.clC.getUserData() != null) {
                    personChangeData.setName(this.clC.getUserData().getName_show());
                    personChangeData.setIntro(this.clC.getUserData().getIntro());
                    personChangeData.setSex(this.clC.getUserData().getSex());
                    personChangeData.setPortrait(this.clC.getUserData().getPortrait());
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, personChangeData, true)));
                TiebaStatic.log("person_editprofile_click");
            } else if (view.getId() == this.clD.ahr().getId()) {
                this.clC.ahy();
            } else if (view.getId() == this.clD.ahG().getId()) {
                agR();
            } else if (view.getId() == this.clD.agX().getId()) {
                UserData userData5 = this.clC.getUserData();
                if (userData5 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), this.clC.getId(), userData5.getSex(), 1)));
                }
            } else if (view.getId() == this.clD.agY().getId()) {
                if (this.clC.getIsSelf() && (userData = this.clC.getUserData()) != null) {
                    userData.setNewMarkCount(0);
                    if (this.clD != null && this.clD.ahL() != null) {
                        this.clD.ahL().notifyDataSetChanged();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(getPageContext().getPageActivity())));
                }
            } else if (view.getId() == this.clD.aha().getId()) {
                UserData userData6 = this.clC.getUserData();
                if (userData6 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonFriendActivityConfig(getPageContext().getPageActivity(), this.clC.getId(), userData6.getSex(), 1)));
                }
            } else if (view.getId() == this.clD.agW().getId()) {
                UserData userData7 = this.clC.getUserData();
                if (userData7 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(getPageContext().getPageActivity(), userData7.getUserId(), userData7.getSex(), 1)));
                }
            } else if (view.getId() == this.clD.agU().getId()) {
                UserData userData8 = this.clC.getUserData();
                if (userData8 != null) {
                    if (this.mIsHost) {
                        str = "iowner_gift";
                    } else {
                        str = "iguest_gift";
                    }
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(getPageContext().getPageActivity(), userData8.getUserId(), userData8.getSex(), str)));
                    this.clD.iP(0);
                    com.baidu.tbadk.coreExtra.messageCenter.a.wT().xk();
                }
            } else if (view.getId() == this.clD.ahb().getId()) {
                if (this.clC.getIsSelf()) {
                    TiebaStatic.log("person_self_attentionme_click");
                } else {
                    TiebaStatic.log("person_guid_attentionme_click");
                }
                UserData userData9 = this.clC.getUserData();
                if (userData9 != null) {
                    this.clD.eJ(false);
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData9.getUserId(), userData9.getSex())));
                }
            } else if (this.clD.ahd() != null && view.getId() == this.clD.ahd().getId()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(getPageContext().getPageActivity())));
            } else if (view.getId() == this.clD.ahc().getId()) {
                if (this.clC.getIsSelf()) {
                    TiebaStatic.log("person_self_attentionper_click");
                } else {
                    TiebaStatic.log("person_guid_attentionper_click");
                }
                UserData userData10 = this.clC.getUserData();
                if (userData10 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData10.getUserId(), userData10.getSex())));
                }
            } else if (view.getId() == this.clD.agZ().getId()) {
                if (!this.clA) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData11 = this.clC.getUserData();
                    if (userData11 != null) {
                        if (!com.baidu.adp.lib.util.k.jf()) {
                            showToast(i.C0057i.no_signall_data);
                            return;
                        }
                        this.clA = true;
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData11.getUserIdLong())));
                    }
                }
            } else if (view.getId() == this.clD.ahq().getId()) {
                if (!this.clA) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData12 = this.clC.getUserData();
                    if (userData12 != null) {
                        if (!com.baidu.adp.lib.util.k.jf()) {
                            showToast(i.C0057i.no_signall_data);
                            return;
                        }
                        this.clA = true;
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData12.getUserIdLong())));
                    }
                }
            } else if (view.getId() == this.clD.ahs().getId()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(getPageContext().getPageActivity())));
            } else if (this.clD.agu() != null && view.getId() == this.clD.agu().getId()) {
                this.clD.ahI();
                agQ();
            } else if (this.clD.agt() != null && view.getId() == this.clD.agt().getId()) {
                this.clD.ahI();
                if (this.clC.getUserData() != null) {
                    com.baidu.tbadk.newFriends.a.Du().u(this.clC.getUserData().getUserIdLong());
                }
            } else if (view.getId() == this.clD.agv().getId()) {
                this.clD.ahI();
                if (this.clC != null) {
                    if (!com.baidu.adp.lib.util.i.iO()) {
                        showToast(i.C0057i.neterror);
                    } else if (this.clz == 0) {
                        this.caO.a(false, this.clC.getUserData().getUserId(), this.clC.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    } else if (this.clz == 1) {
                        this.caO.a(true, this.clC.getUserData().getUserId(), this.clC.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    }
                }
            }
        }
    }

    private void agP() {
        if (this.clC.getUserData() != null) {
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getPageContext().getString(i.C0057i.user_icon_web_view_title), String.valueOf(cfm) + "?user_id=" + this.clC.getUserData().getUserId(), true, true, false);
            TiebaStatic.log(new ao("c10134").r("obj_type", 1));
        }
    }

    private void agQ() {
        String format;
        String userName = this.clC.getUserData() != null ? this.clC.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(i.C0057i.confirm, new h(this));
            aVar.b(i.C0057i.cancel, new i(this));
            if (this.clB.getMaskType() == 1) {
                format = String.format(getPageContext().getString(i.C0057i.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(i.C0057i.block_chat_message_alert), userName);
            }
            aVar.cn(format);
            aVar.b(getPageContext());
            aVar.sP();
        }
    }

    private void agR() {
        if (this.clC.getUserData() != null && this.clC.getUserData().getIsOfficialAccount() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.clC.getUserData().getUserId(), 0L), this.clC.getUserData().getUserName(), this.clC.getUserData().getPortrait(), 0, 4)));
        } else if (this.mIsHost) {
            AntiData acW = this.clC.acW();
            if (acW != null && AppealActivityConfig.isExistActivity) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AppealActivityConfig(getPageContext().getPageActivity(), acW.getBlock_forum_id(), acW.getUser_id(), acW.getUser_name())));
            }
        } else {
            PersonTainInfo ahu = this.clC.ahu();
            if (ahu != null) {
                int isFriend = ahu.getIsFriend();
                if (isFriend == 0) {
                    UserData userData = this.clC.getUserData();
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.clC.ahx(), ahu.getUserClientVersionLower(), this.clC.getStType())));
                    }
                } else if (isFriend == 1) {
                    UserData userData2 = this.clC.getUserData();
                    if (userData2 != null) {
                        if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(i.C0057i.login_to_chat), true, 11028)));
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
                    com.baidu.tbadk.newFriends.a.Du().b(com.baidu.adp.lib.g.b.c(this.clC.getId(), 0L), "pers_pg");
                }
            }
        }
    }

    private boolean iO(int i) {
        int Ae;
        if (this.clC.getUserData() == null || this.clC.getUserData().getPersonPrivate() == null) {
            bb.ah(getPageContext().getPageActivity());
            return false;
        }
        com.baidu.tbadk.data.g personPrivate = this.clC.getUserData().getPersonPrivate();
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
        if (this.clC.ahu() != null && this.clC.ahu().getIsFriend() != 1 && Ae == 2) {
            showToast(i.C0057i.private_friend_open);
            return false;
        } else if (Ae != 3) {
            return bb.ah(getPageContext().getPageActivity());
        } else {
            showToast(i.C0057i.private_hide);
            return false;
        }
    }

    public void agk() {
        String[] strArr = {getPageContext().getString(i.C0057i.hd_photo), getPageContext().getString(i.C0057i.change_photo), getPageContext().getString(i.C0057i.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bF(i.C0057i.operation);
        cVar.a(strArr, new j(this));
        cVar.d(getPageContext());
        cVar.sS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agS() {
        if (this.clC != null && this.clC.getUserData() != null) {
            String jA = jA(this.clC.getUserData().getPortraitH());
            HashMap hashMap = new HashMap();
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = this.clC.getUserData().getPortrait();
            imageUrlData.urlType = 25;
            hashMap.put(jA, imageUrlData);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonImageActivityConfig(getPageContext().getPageActivity(), jA, hashMap)));
        }
    }

    private String jA(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void agT() {
        if (this.clC != null && this.clC.ahu() != null && this.clB != null) {
            this.clD.a(this.clC.ahu().getIsFriend() == 1, this.clB.getMaskType() == 1, this.clz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            if (this.clC != null) {
                if (msgFans > 0) {
                    this.clC.au(msgFans);
                    this.clD.eJ(true);
                }
                this.clD.iP(msgGiftNum);
            }
        }
    }
}
