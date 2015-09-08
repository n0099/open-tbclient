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
    private static final String cgj = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private UserMuteAddAndDelModel<PersonInfoActivity> cbJ;
    private com.baidu.tieba.usermute.i cbK;
    private BlackListModel cmE;
    private w cmF;
    private ag cmG;
    private boolean mIsHost;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.tbadkCore.e.a aNf = null;
    private int cmC = -1;
    private boolean cmD = false;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private final int cmH = 2000;
    private final com.baidu.adp.framework.listener.a cmI = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e cmJ = new k(this, 104102);
    final com.baidu.adp.framework.listener.e cmK = new l(this, 304102);
    final CustomMessageListener cmL = new m(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener aIv = new n(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e cmM = new o(this, 304103);
    private final CustomMessageListener cmN = new p(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    private final CustomMessageListener bZM = new q(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private final CustomMessageListener cmO = new r(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    private i.a cbY = new b(this);
    private final CustomMessageListener cmP = new c(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private UserMuteAddAndDelModel.a cbX = new d(this);
    private UserMuteAddAndDelModel.b cmQ = new e(this);

    public w ahd() {
        return this.cmF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k(bundle);
        this.mIsHost = this.cmF.getIsSelf();
        registerListener();
        initUI();
        ahf();
        ahe();
    }

    private void registerListener() {
        registerListener(this.cmI);
        registerListener(this.cmJ);
        registerListener(this.cmK);
        registerListener(this.cmL);
        registerListener(this.cmM);
        registerListener(this.aIv);
        registerListener(this.bZM);
        registerListener(this.cmO);
        registerListener(this.cmP);
        registerListener(this.cmN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cmG.onStart();
        this.cmF.agP();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgGiftNum();
        this.cmD = false;
        if (TbadkCoreApplication.getRefreshFlag()) {
            this.cmF.ahT();
            TbadkCoreApplication.setRefreshFlag(false);
            return;
        }
        long msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgFans();
        if (msgFans != this.cmF.ahL() && msgFans > 0) {
            this.cmF.av(msgFans);
            this.cmG.eU(true);
        } else {
            this.cmF.av(msgFans);
            this.cmG.eU(false);
        }
        this.cmF.jd(msgGiftNum);
        this.cmG.jc(msgGiftNum);
    }

    private void ahe() {
        if (com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("person_center_first_visit", true)) {
            com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("person_center_first_visit", false);
            showToast(i.h.person_user_icon_notify);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.cmF.ahT();
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
        this.cmF.ahR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        com.baidu.tbadk.imageManager.c.Cs().el(TbConfig.getBigImageMaxUsedMemory());
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cbK.onDestroy();
        this.cmG.onDestroy();
        if (this.mIsHost) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK));
        }
    }

    private void initUI() {
        this.cmG = new ag(this, this.mIsHost);
        this.cmG.setExpandListRefreshListener(new f(this));
        if (this.mIsHost) {
            this.cmF.ahS();
        }
        this.cmG.startLoad();
    }

    private void ahf() {
        if (this.aNf == null) {
            this.aNf = new com.baidu.tieba.tbadkCore.e.a("profileStat");
            this.aNf.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cmG.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.cmF != null) {
            bundle.putBoolean("self", this.cmF.getIsSelf());
            bundle.putString("un", this.cmF.getId());
            bundle.putString("name", this.cmF.getName());
            bundle.putBoolean("tab_page", this.cmF.ahN());
            bundle.putBoolean("tab_msg", this.cmF.ahO());
            bundle.putString("from", this.cmF.ahP());
            bundle.putString("st_type", this.cmF.getStType());
        }
    }

    private void k(Bundle bundle) {
        this.mPersonChangeData = new PersonChangeData();
        this.cmE = new BlackListModel(this);
        this.cmF = new w(this);
        a(this.cmF, bundle);
        this.cmF.setLoadDataCallBack(new g(this));
        this.cbJ = new UserMuteAddAndDelModel<>(this);
        this.cbJ.a(this.cbX);
        this.cbJ.a(this.cmQ);
        this.cbK = new com.baidu.tieba.usermute.i(getPageContext(), this.cbY);
    }

    private void a(w wVar, Bundle bundle) {
        if (bundle != null) {
            wVar.jI(bundle.getString("from"));
            wVar.setIsSelf(bundle.getBoolean("self", false));
            wVar.setId(bundle.getString("un"));
            wVar.setName(bundle.getString("name"));
            wVar.eV(bundle.getBoolean("tab_page", false));
            wVar.eW(bundle.getBoolean("tab_msg", false));
            wVar.setStType(bundle.getString("st_type"));
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            wVar.jI(intent.getStringExtra("from"));
            wVar.setIsSelf(intent.getBooleanExtra("self", false));
            wVar.setId(intent.getStringExtra("un"));
            wVar.setName(intent.getStringExtra("name"));
            wVar.eV(intent.getBooleanExtra("tab_page", false));
            wVar.eW(intent.getBooleanExtra("tab_msg", false));
            wVar.setStType(intent.getStringExtra("st_type"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahg() {
        long c = com.baidu.adp.lib.g.b.c(this.cmF.getId(), 0L);
        this.cbK.e(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), c);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                S(intent);
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
                if (this.cmF.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.Cs().fh(this.cmF.getUserData().getPortrait());
                }
                this.cmF.ahT();
            } else if (i == 12014) {
                this.cmF.ahT();
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

    private void S(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra(PersonChangeData.TAG_PERSON_INFO);
        if (personChangeData != null && this.cmF.getUserData() != null) {
            this.cmF.a(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.cmF.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.Cs().fh(this.cmF.getUserData().getPortrait());
                }
            }
        }
        this.cmF.ahT();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        UserData userData;
        if (view.getId() == this.cmG.aic().getId()) {
            finish();
        } else if (view.getId() == this.cmG.ahG().getId()) {
            if (this.cmF.getUserData() != null) {
                if (this.cmF.getIsSelf()) {
                    agA();
                } else {
                    ahk();
                }
            }
        } else if (view.getId() == this.cmG.ahw().getId()) {
            if (this.cmF.getIsSelf()) {
                TiebaStatic.log("person_self_group_click");
            } else if (jb(3)) {
                TiebaStatic.log("person_guid_group_click");
            } else {
                return;
            }
            UserData userData2 = this.cmF.getUserData();
            if (userData2 != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(getPageContext().getPageActivity(), this.cmF.getId(), userData2.getSex())));
            }
        } else if (view.getId() == this.cmG.ahx().getId()) {
            if (this.cmF.getIsSelf()) {
                TiebaStatic.log("person_self_attentionbar_click");
            } else if (jb(2)) {
                TiebaStatic.log("person_guid_attentionbar_click");
            } else {
                return;
            }
            UserData userData3 = this.cmF.getUserData();
            if (userData3 != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), userData3.getLike_bars(), this.cmF.getId(), userData3.getSex())));
            }
        } else if (view.getId() == this.cmG.ahy().getId()) {
            if (this.cmF.getIsSelf()) {
                TiebaStatic.log("person_self_thread_click");
            } else if (jb(4)) {
                TiebaStatic.log("person_guid_thread_click");
            } else {
                return;
            }
            UserData userData4 = this.cmF.getUserData();
            if (userData4 != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(getPageContext().getPageActivity(), userData4.getUserId(), userData4.getSex(), userData4.getPortrait())));
            }
        } else if (view.getId() == this.cmG.ahH().getId()) {
            ahh();
        } else if (bb.ah(getPageContext().getPageActivity())) {
            if (view.getId() == this.cmG.aib().getId()) {
                if (!this.mIsHost) {
                    ahl();
                    return;
                }
                PersonChangeData personChangeData = new PersonChangeData();
                if (this.cmF.getUserData() != null) {
                    personChangeData.setName(this.cmF.getUserData().getName_show());
                    personChangeData.setIntro(this.cmF.getUserData().getIntro());
                    personChangeData.setSex(this.cmF.getUserData().getSex());
                    personChangeData.setPortrait(this.cmF.getUserData().getPortrait());
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, personChangeData, true)));
                TiebaStatic.log("person_editprofile_click");
            } else if (view.getId() == this.cmG.ahJ().getId()) {
                this.cmF.ahQ();
            } else if (view.getId() == this.cmG.ahY().getId()) {
                ahj();
            } else if (view.getId() == this.cmG.ahp().getId()) {
                UserData userData5 = this.cmF.getUserData();
                if (userData5 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), this.cmF.getId(), userData5.getSex(), 1)));
                }
            } else if (view.getId() == this.cmG.ahq().getId()) {
                if (this.cmF.getIsSelf() && (userData = this.cmF.getUserData()) != null) {
                    userData.setNewMarkCount(0);
                    if (this.cmG != null && this.cmG.aid() != null) {
                        this.cmG.aid().notifyDataSetChanged();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(getPageContext().getPageActivity())));
                }
            } else if (view.getId() == this.cmG.ahs().getId()) {
                UserData userData6 = this.cmF.getUserData();
                if (userData6 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonFriendActivityConfig(getPageContext().getPageActivity(), this.cmF.getId(), userData6.getSex(), 1)));
                }
            } else if (view.getId() == this.cmG.aho().getId()) {
                UserData userData7 = this.cmF.getUserData();
                if (userData7 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(getPageContext().getPageActivity(), userData7.getUserId(), userData7.getSex(), 1)));
                }
            } else if (view.getId() == this.cmG.ahm().getId()) {
                UserData userData8 = this.cmF.getUserData();
                if (userData8 != null) {
                    if (this.mIsHost) {
                        str = "iowner_gift";
                    } else {
                        str = "iguest_gift";
                    }
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(getPageContext().getPageActivity(), userData8.getUserId(), userData8.getSex(), str)));
                    this.cmG.jc(0);
                    com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xq();
                }
            } else if (view.getId() == this.cmG.aht().getId()) {
                if (this.cmF.getIsSelf()) {
                    TiebaStatic.log("person_self_attentionme_click");
                } else {
                    TiebaStatic.log("person_guid_attentionme_click");
                }
                UserData userData9 = this.cmF.getUserData();
                if (userData9 != null) {
                    this.cmG.eU(false);
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData9.getUserId(), userData9.getSex())));
                }
            } else if (this.cmG.ahv() != null && view.getId() == this.cmG.ahv().getId()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(getPageContext().getPageActivity())));
            } else if (view.getId() == this.cmG.ahu().getId()) {
                if (this.cmF.getIsSelf()) {
                    TiebaStatic.log("person_self_attentionper_click");
                } else {
                    TiebaStatic.log("person_guid_attentionper_click");
                }
                UserData userData10 = this.cmF.getUserData();
                if (userData10 != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData10.getUserId(), userData10.getSex())));
                }
            } else if (view.getId() == this.cmG.ahr().getId()) {
                if (!this.cmD) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData11 = this.cmF.getUserData();
                    if (userData11 != null) {
                        if (!com.baidu.adp.lib.util.k.jc()) {
                            showToast(i.h.no_signall_data);
                            return;
                        }
                        this.cmD = true;
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData11.getUserIdLong())));
                    }
                }
            } else if (view.getId() == this.cmG.ahI().getId()) {
                if (!this.cmD) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData12 = this.cmF.getUserData();
                    if (userData12 != null) {
                        if (!com.baidu.adp.lib.util.k.jc()) {
                            showToast(i.h.no_signall_data);
                            return;
                        }
                        this.cmD = true;
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData12.getUserIdLong())));
                    }
                }
            } else if (view.getId() == this.cmG.ahK().getId()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(getPageContext().getPageActivity())));
            } else if (this.cmG.agK() != null && view.getId() == this.cmG.agK().getId()) {
                this.cmG.aia();
                ahi();
            } else if (this.cmG.agJ() != null && view.getId() == this.cmG.agJ().getId()) {
                this.cmG.aia();
                if (this.cmF.getUserData() != null) {
                    com.baidu.tbadk.newFriends.a.DE().v(this.cmF.getUserData().getUserIdLong());
                }
            } else if (view.getId() == this.cmG.agL().getId()) {
                this.cmG.aia();
                if (this.cmF != null) {
                    if (!com.baidu.adp.lib.util.i.iL()) {
                        showToast(i.h.neterror);
                    } else if (this.cmC == 0) {
                        this.cbJ.a(false, this.cmF.getUserData().getUserId(), this.cmF.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    } else if (this.cmC == 1) {
                        this.cbJ.a(true, this.cmF.getUserData().getUserId(), this.cmF.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    }
                }
            }
        }
    }

    private void ahh() {
        if (this.cmF.getUserData() != null) {
            com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), getPageContext().getString(i.h.user_icon_web_view_title), String.valueOf(cgj) + "?user_id=" + this.cmF.getUserData().getUserId(), true, true, false);
            TiebaStatic.log(new ao("c10134").r("obj_type", 1));
        }
    }

    private void ahi() {
        String format;
        String userName = this.cmF.getUserData() != null ? this.cmF.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(i.h.confirm, new h(this));
            aVar.b(i.h.cancel, new i(this));
            if (this.cmE.getMaskType() == 1) {
                format = String.format(getPageContext().getString(i.h.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(i.h.block_chat_message_alert), userName);
            }
            aVar.ct(format);
            aVar.b(getPageContext());
            aVar.sU();
        }
    }

    private void ahj() {
        if (this.cmF.getUserData() != null && this.cmF.getUserData().getIsOfficialAccount() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(this.cmF.getUserData().getUserId(), 0L), this.cmF.getUserData().getUserName(), this.cmF.getUserData().getPortrait(), 0, 4)));
        } else if (this.mIsHost) {
            AntiData adj = this.cmF.adj();
            if (adj != null && AppealActivityConfig.isExistActivity) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AppealActivityConfig(getPageContext().getPageActivity(), adj.getBlock_forum_id(), adj.getUser_id(), adj.getUser_name())));
            }
        } else {
            PersonTainInfo ahM = this.cmF.ahM();
            if (ahM != null) {
                int isFriend = ahM.getIsFriend();
                if (isFriend == 0) {
                    UserData userData = this.cmF.getUserData();
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.cmF.ahP(), ahM.getUserClientVersionLower(), this.cmF.getStType())));
                    }
                } else if (isFriend == 1) {
                    UserData userData2 = this.cmF.getUserData();
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
                    com.baidu.tbadk.newFriends.a.DE().b(com.baidu.adp.lib.g.b.c(this.cmF.getId(), 0L), "pers_pg");
                }
            }
        }
    }

    private boolean jb(int i) {
        int Ar;
        if (this.cmF.getUserData() == null || this.cmF.getUserData().getPersonPrivate() == null) {
            bb.ah(getPageContext().getPageActivity());
            return false;
        }
        com.baidu.tbadk.data.g personPrivate = this.cmF.getUserData().getPersonPrivate();
        switch (i) {
            case 2:
                Ar = personPrivate.Ao();
                break;
            case 3:
                Ar = personPrivate.Ap();
                break;
            case 4:
                Ar = personPrivate.Aq();
                break;
            case 5:
                Ar = personPrivate.Ar();
                break;
            default:
                Ar = 1;
                break;
        }
        if (this.cmF.ahM() != null && this.cmF.ahM().getIsFriend() != 1 && Ar == 2) {
            showToast(i.h.private_friend_open);
            return false;
        } else if (Ar != 3) {
            return bb.ah(getPageContext().getPageActivity());
        } else {
            showToast(i.h.private_hide);
            return false;
        }
    }

    public void agA() {
        String[] strArr = {getPageContext().getString(i.h.hd_photo), getPageContext().getString(i.h.change_photo), getPageContext().getString(i.h.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bI(i.h.operation);
        cVar.a(strArr, new j(this));
        cVar.d(getPageContext());
        cVar.sX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahk() {
        if (this.cmF != null && this.cmF.getUserData() != null) {
            String jH = jH(this.cmF.getUserData().getPortraitH());
            HashMap hashMap = new HashMap();
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = this.cmF.getUserData().getPortrait();
            imageUrlData.urlType = 25;
            hashMap.put(jH, imageUrlData);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonImageActivityConfig(getPageContext().getPageActivity(), jH, hashMap)));
        }
    }

    private String jH(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void ahl() {
        if (this.cmF != null && this.cmF.ahM() != null && this.cmE != null) {
            this.cmG.a(this.cmF.ahM().getIsFriend() == 1, this.cmE.getMaskType() == 1, this.cmC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            if (this.cmF != null) {
                if (msgFans > 0) {
                    this.cmF.av(msgFans);
                    this.cmG.eU(true);
                }
                this.cmG.jc(msgGiftNum);
            }
        }
    }
}
