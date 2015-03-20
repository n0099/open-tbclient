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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.im.model.BlackListModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class PersonInfoActivity extends BaseActivity<PersonInfoActivity> {
    private static final String bMu = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/135_1";
    private BlackListModel bRV;
    private v bRW;
    private ae bRX;
    private boolean mIsHost;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.tbadkCore.e.a aDi = null;
    private boolean bRU = false;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private final com.baidu.adp.framework.listener.a bRY = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e bRZ = new h(this, 104102);
    final com.baidu.adp.framework.listener.e bSa = new i(this, 304102);
    final CustomMessageListener bSb = new j(this, 2001178);
    private final CustomMessageListener ayT = new k(this, 2001178);
    private final com.baidu.adp.framework.listener.e bSc = new l(this, 304103);
    private final CustomMessageListener bSd = new m(this, 2001238);
    private final CustomMessageListener bSe = new n(this, 2001118);
    private final CustomMessageListener bSf = new o(this, 2001124);
    private final CustomMessageListener bSg = new b(this, 2001237);

    public v ady() {
        return this.bRW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k(bundle);
        this.mIsHost = this.bRW.getIsSelf();
        registerListener();
        initUI();
        adz();
    }

    private void registerListener() {
        registerListener(this.bRY);
        registerListener(this.bRZ);
        registerListener(this.bSa);
        registerListener(this.bSb);
        registerListener(this.bSc);
        registerListener(this.ayT);
        registerListener(this.bSe);
        registerListener(this.bSf);
        registerListener(this.bSg);
        registerListener(this.bSd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bRX.onStart();
        this.bRW.adj();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgGiftNum();
        this.bRU = false;
        if (TbadkCoreApplication.getRefreshFlag()) {
            this.bRW.aek();
            TbadkCoreApplication.setRefreshFlag(false);
            return;
        }
        long msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgFans();
        if (msgFans != this.bRW.aeb() && msgFans > 0) {
            this.bRW.al(msgFans);
            this.bRX.eh(true);
        } else {
            this.bRW.al(msgFans);
            this.bRX.eh(false);
        }
        if (msgGiftNum > 0) {
            this.bRW.hE(msgGiftNum);
            this.bRX.hD(msgGiftNum);
            return;
        }
        this.bRW.hE(msgGiftNum);
        this.bRX.hD(msgGiftNum);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.bRX.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bRW.aei();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        com.baidu.tbadk.imageManager.e.zs().dD(TbConfig.getBigImageMaxUsedMemory());
        this.bRX.onStop();
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
        this.bRX = new ae(this, this.mIsHost);
        this.bRX.setExpandListRefreshListener(new c(this));
        if (this.mIsHost) {
            this.bRW.aej();
        }
        this.bRX.startLoad();
    }

    private void adz() {
        if (this.aDi == null) {
            this.aDi = new com.baidu.tieba.tbadkCore.e.a("profileStat");
            this.aDi.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bRX.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bRW != null) {
            bundle.putBoolean("self", this.bRW.getIsSelf());
            bundle.putString("un", this.bRW.getId());
            bundle.putString("name", this.bRW.getName());
            bundle.putBoolean("tab_page", this.bRW.aee());
            bundle.putBoolean("tab_msg", this.bRW.aef());
            bundle.putString("from", this.bRW.aeg());
            bundle.putString("st_type", this.bRW.getStType());
        }
    }

    private void k(Bundle bundle) {
        this.mPersonChangeData = new PersonChangeData();
        this.bRV = new BlackListModel(this);
        this.bRW = new v(this);
        if (bundle != null) {
            this.bRW.hZ(bundle.getString("from"));
            this.bRW.setIsSelf(bundle.getBoolean("self", false));
            this.bRW.setId(bundle.getString("un"));
            this.bRW.setName(bundle.getString("name"));
            this.bRW.ei(bundle.getBoolean("tab_page", false));
            this.bRW.ej(bundle.getBoolean("tab_msg", false));
            this.bRW.setStType(bundle.getString("st_type"));
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bRW.hZ(intent.getStringExtra("from_forum"));
                this.bRW.setIsSelf(intent.getBooleanExtra("self", false));
                this.bRW.setId(intent.getStringExtra("un"));
                this.bRW.setName(intent.getStringExtra("name"));
                this.bRW.ei(intent.getBooleanExtra("tab_page", false));
                this.bRW.ej(intent.getBooleanExtra("tab_msg", false));
                this.bRW.setStType(intent.getStringExtra("st_type"));
            }
        }
        this.bRW.setLoadDataCallBack(new d(this));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                U(intent);
            } else if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        J(intent);
                    } else {
                        I(intent);
                    }
                }
            } else if (i == 12010 || i == 12009) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.bRW.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.zs().ep(this.bRW.getUserData().getPortrait());
                }
                this.bRW.aek();
            }
        } else if (i2 == 0 && i == 12010) {
            az.d(getPageContext());
        }
    }

    private void I(Intent intent) {
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

    private void J(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj())));
    }

    private void U(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra(PersonChangeData.TAG_PERSON_INFO);
        if (personChangeData != null && this.bRW.getUserData() != null) {
            this.bRW.a(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.bRW.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.zs().ep(this.bRW.getUserData().getPortrait());
                }
            }
        }
        this.bRW.aek();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getId() == this.bRX.aes().getId()) {
            finish();
        } else if (view.getId() == this.bRX.aer().getId()) {
            if (!this.mIsHost) {
                adE();
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.bRW.getUserData() != null) {
                personChangeData.setName(this.bRW.getUserData().getName_show());
                personChangeData.setIntro(this.bRW.getUserData().getIntro());
                personChangeData.setSex(this.bRW.getUserData().getSex());
                personChangeData.setPortrait(this.bRW.getUserData().getPortrait());
            }
            sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, personChangeData, true)));
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_editprofile_click");
        } else if (view.getId() == this.bRX.adW().getId()) {
            if (this.bRW.getUserData() != null) {
                if (this.bRW.getIsSelf()) {
                    adC();
                } else {
                    adD();
                }
            }
        } else if (view.getId() == this.bRX.adZ().getId()) {
            this.bRW.aeh();
        } else if (view.getId() == this.bRX.adX().getId()) {
            if (this.bRW.getUserData() != null) {
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.y.user_icon_intro), String.valueOf(bMu) + "?st_type=person_user_icon", true, false, false);
            }
        } else if (view.getId() == this.bRX.adN().getId()) {
            if (this.bRW.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_group_click");
            } else if (hC(3)) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_group_click");
            } else {
                return;
            }
            UserData userData = this.bRW.getUserData();
            if (userData != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), this.bRW.getId(), userData.getSex())));
            }
        } else if (view.getId() == this.bRX.aeo().getId()) {
            adB();
        } else if (view.getId() == this.bRX.adI().getId()) {
            UserData userData2 = this.bRW.getUserData();
            if (userData2 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), this.bRW.getId(), userData2.getSex(), 1)));
            }
        } else if (view.getId() == this.bRX.adK().getId()) {
            UserData userData3 = this.bRW.getUserData();
            if (userData3 != null) {
                sendMessage(new CustomMessage(2002001, new PersonFriendActivityConfig(getPageContext().getPageActivity(), this.bRW.getId(), userData3.getSex(), 1)));
            }
        } else if (view.getId() == this.bRX.adH().getId()) {
            UserData userData4 = this.bRW.getUserData();
            if (userData4 != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), userData4.getUserId(), userData4.getSex(), 1)));
            }
        } else if (view.getId() == this.bRX.adF().getId()) {
            UserData userData5 = this.bRW.getUserData();
            if (userData5 != null) {
                if (this.mIsHost) {
                    str = "iowner_gift";
                } else {
                    str = "iguest_gift";
                }
                sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(getPageContext().getPageActivity(), userData5.getUserId(), userData5.getSex(), str)));
                this.bRX.hD(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.uT().vk();
            }
        } else if (view.getId() == this.bRX.adL().getId()) {
            if (this.bRW.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_attentionme_click");
            } else {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_attentionme_click");
            }
            UserData userData6 = this.bRW.getUserData();
            if (userData6 != null) {
                this.bRX.eh(false);
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData6.getUserId(), userData6.getSex())));
            }
        } else if (view.getId() == this.bRX.adM().getId()) {
            if (this.bRW.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_attentionper_click");
            } else {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_attentionper_click");
            }
            UserData userData7 = this.bRW.getUserData();
            if (userData7 != null) {
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData7.getUserId(), userData7.getSex())));
            }
        } else if (view.getId() == this.bRX.adO().getId()) {
            if (this.bRW.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_attentionbar_click");
            } else if (hC(2)) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_attentionbar_click");
            } else {
                return;
            }
            UserData userData8 = this.bRW.getUserData();
            if (userData8 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), userData8.getLike_bars(), this.bRW.getId(), userData8.getSex())));
            }
        } else if (view.getId() == this.bRX.adP().getId()) {
            if (this.bRW.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_thread_click");
            } else if (hC(4)) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_thread_click");
            } else {
                return;
            }
            UserData userData9 = this.bRW.getUserData();
            if (userData9 != null) {
                sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(getPageContext().getPageActivity(), userData9.getUserId(), userData9.getSex(), userData9.getPortrait())));
            }
        } else if (view.getId() == this.bRX.adJ().getId()) {
            if (!this.bRU) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "igift_icon_ck");
                UserData userData10 = this.bRW.getUserData();
                if (userData10 != null) {
                    if (!com.baidu.adp.lib.util.n.isNetOk()) {
                        showToast(com.baidu.tieba.y.no_signall_data);
                        return;
                    }
                    this.bRU = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData10.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bRX.adY().getId()) {
            if (!this.bRU) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "igift_icon_ck");
                UserData userData11 = this.bRW.getUserData();
                if (userData11 != null) {
                    if (!com.baidu.adp.lib.util.n.isNetOk()) {
                        showToast(com.baidu.tieba.y.no_signall_data);
                        return;
                    }
                    this.bRU = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData11.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bRX.aea().getId()) {
            sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(getPageContext().getPageActivity())));
        } else if (view.getId() == this.bRX.adf().getId()) {
            this.bRX.aeq();
            adA();
        } else if (view.getId() == this.bRX.ade().getId()) {
            this.bRX.aeq();
            if (this.bRW.getUserData() != null) {
                com.baidu.tbadk.newFriends.a.Ca().u(this.bRW.getUserData().getUserIdLong());
            }
        }
    }

    private void adA() {
        String format;
        String userName = this.bRW.getUserData() != null ? this.bRW.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(com.baidu.tieba.y.confirm, new e(this));
            aVar.b(com.baidu.tieba.y.cancel, new f(this));
            if (this.bRV.getMaskType() == 1) {
                format = String.format(getPageContext().getString(com.baidu.tieba.y.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(com.baidu.tieba.y.block_chat_message_alert), userName);
            }
            aVar.ca(format);
            aVar.b(getPageContext());
            aVar.re();
        }
    }

    private void adB() {
        if (this.bRW.getUserData() != null && this.bRW.getUserData().getIsOfficialAccount() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(this.bRW.getUserData().getUserId(), 0L), this.bRW.getUserData().getUserName(), this.bRW.getUserData().getPortrait(), 0, 4)));
        } else if (this.mIsHost) {
            AntiData Zc = this.bRW.Zc();
            if (Zc != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AppealActivityConfig(getPageContext().getPageActivity(), Zc.getBlock_forum_id(), Zc.getUser_id(), Zc.getUser_name())));
            }
        } else {
            PersonTainInfo aed = this.bRW.aed();
            if (aed != null) {
                int isFriend = aed.getIsFriend();
                if (isFriend == 0) {
                    UserData userData = this.bRW.getUserData();
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.bRW.aeg(), aed.getUserClientVersionLower(), this.bRW.getStType())));
                    }
                } else if (isFriend == 1) {
                    UserData userData2 = this.bRW.getUserData();
                    if (userData2 != null) {
                        if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(com.baidu.tieba.y.login_to_chat), true, 11028)));
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
                    com.baidu.tbadk.newFriends.a.Ca().a(com.baidu.adp.lib.g.c.a(this.bRW.getId(), 0L), "pers_pg");
                }
            }
        }
    }

    private boolean hC(int i) {
        int ya;
        if (this.bRW.getUserData() == null || this.bRW.getUserData().getPersonPrivate() == null) {
            return false;
        }
        com.baidu.tbadk.data.h personPrivate = this.bRW.getUserData().getPersonPrivate();
        switch (i) {
            case 2:
                ya = personPrivate.xX();
                break;
            case 3:
                ya = personPrivate.xY();
                break;
            case 4:
                ya = personPrivate.xZ();
                break;
            case 5:
                ya = personPrivate.ya();
                break;
            default:
                ya = 1;
                break;
        }
        if (this.bRW.aed() != null && this.bRW.aed().getIsFriend() != 1 && ya == 2) {
            showToast(com.baidu.tieba.y.private_friend_open);
            return false;
        } else if (ya == 3) {
            showToast(com.baidu.tieba.y.private_hide);
            return false;
        } else {
            return true;
        }
    }

    public void adC() {
        String[] strArr = {getPageContext().getString(com.baidu.tieba.y.hd_photo), getPageContext().getString(com.baidu.tieba.y.change_photo)};
        com.baidu.tbadk.core.dialog.e eVar = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        eVar.by(com.baidu.tieba.y.operation);
        eVar.a(strArr, new g(this));
        eVar.d(getPageContext());
        eVar.rg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adD() {
        if (this.bRW != null && this.bRW.getUserData() != null) {
            String hY = hY(this.bRW.getUserData().getPortraitH());
            HashMap hashMap = new HashMap();
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = this.bRW.getUserData().getPortrait();
            imageUrlData.urlType = 25;
            hashMap.put(hY, imageUrlData);
            sendMessage(new CustomMessage(2002001, new PersonImageActivityConfig(getPageContext().getPageActivity(), hY, hashMap)));
        }
    }

    private String hY(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void adE() {
        if (this.bRW != null && this.bRW.aed() != null && this.bRV != null) {
            this.bRX.f(this.bRW.aed().getIsFriend() == 1, this.bRV.getMaskType() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            if (this.bRW != null) {
                if (msgFans > 0) {
                    this.bRW.al(msgFans);
                    this.bRX.eh(true);
                }
                this.bRX.hD(msgGiftNum);
            }
        }
    }
}
