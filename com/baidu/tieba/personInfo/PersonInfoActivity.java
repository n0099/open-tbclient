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
    private static final String bMK = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/135_1";
    private BlackListModel bSl;
    private v bSm;
    private ae bSn;
    private boolean mIsHost;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.tbadkCore.e.a aDq = null;
    private boolean bSk = false;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private final com.baidu.adp.framework.listener.a bSo = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e bSp = new h(this, 104102);
    final com.baidu.adp.framework.listener.e bSq = new i(this, 304102);
    final CustomMessageListener bSr = new j(this, 2001178);
    private final CustomMessageListener azb = new k(this, 2001178);
    private final com.baidu.adp.framework.listener.e bSs = new l(this, 304103);
    private final CustomMessageListener bSt = new m(this, 2001238);
    private final CustomMessageListener bSu = new n(this, 2001118);
    private final CustomMessageListener bSv = new o(this, 2001124);
    private final CustomMessageListener bSw = new b(this, 2001237);

    public v adN() {
        return this.bSm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k(bundle);
        this.mIsHost = this.bSm.getIsSelf();
        registerListener();
        initUI();
        adO();
    }

    private void registerListener() {
        registerListener(this.bSo);
        registerListener(this.bSp);
        registerListener(this.bSq);
        registerListener(this.bSr);
        registerListener(this.bSs);
        registerListener(this.azb);
        registerListener(this.bSu);
        registerListener(this.bSv);
        registerListener(this.bSw);
        registerListener(this.bSt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bSn.onStart();
        this.bSm.ady();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.uZ().getMsgGiftNum();
        this.bSk = false;
        if (TbadkCoreApplication.getRefreshFlag()) {
            this.bSm.aez();
            TbadkCoreApplication.setRefreshFlag(false);
            return;
        }
        long msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.uZ().getMsgFans();
        if (msgFans != this.bSm.aeq() && msgFans > 0) {
            this.bSm.al(msgFans);
            this.bSn.ef(true);
        } else {
            this.bSm.al(msgFans);
            this.bSn.ef(false);
        }
        if (msgGiftNum > 0) {
            this.bSm.hH(msgGiftNum);
            this.bSn.hG(msgGiftNum);
            return;
        }
        this.bSm.hH(msgGiftNum);
        this.bSn.hG(msgGiftNum);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.bSn.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bSm.aex();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        com.baidu.tbadk.imageManager.e.zy().dD(TbConfig.getBigImageMaxUsedMemory());
        this.bSn.onStop();
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
        this.bSn = new ae(this, this.mIsHost);
        this.bSn.setExpandListRefreshListener(new c(this));
        if (this.mIsHost) {
            this.bSm.aey();
        }
        this.bSn.startLoad();
    }

    private void adO() {
        if (this.aDq == null) {
            this.aDq = new com.baidu.tieba.tbadkCore.e.a("profileStat");
            this.aDq.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bSn.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bSm != null) {
            bundle.putBoolean("self", this.bSm.getIsSelf());
            bundle.putString("un", this.bSm.getId());
            bundle.putString("name", this.bSm.getName());
            bundle.putBoolean("tab_page", this.bSm.aet());
            bundle.putBoolean("tab_msg", this.bSm.aeu());
            bundle.putString("from", this.bSm.aev());
            bundle.putString("st_type", this.bSm.getStType());
        }
    }

    private void k(Bundle bundle) {
        this.mPersonChangeData = new PersonChangeData();
        this.bSl = new BlackListModel(this);
        this.bSm = new v(this);
        if (bundle != null) {
            this.bSm.ic(bundle.getString("from"));
            this.bSm.setIsSelf(bundle.getBoolean("self", false));
            this.bSm.setId(bundle.getString("un"));
            this.bSm.setName(bundle.getString("name"));
            this.bSm.eg(bundle.getBoolean("tab_page", false));
            this.bSm.eh(bundle.getBoolean("tab_msg", false));
            this.bSm.setStType(bundle.getString("st_type"));
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bSm.ic(intent.getStringExtra("from_forum"));
                this.bSm.setIsSelf(intent.getBooleanExtra("self", false));
                this.bSm.setId(intent.getStringExtra("un"));
                this.bSm.setName(intent.getStringExtra("name"));
                this.bSm.eg(intent.getBooleanExtra("tab_page", false));
                this.bSm.eh(intent.getBooleanExtra("tab_msg", false));
                this.bSm.setStType(intent.getStringExtra("st_type"));
            }
        }
        this.bSm.setLoadDataCallBack(new d(this));
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
                if (this.bSm.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.zy().es(this.bSm.getUserData().getPortrait());
                }
                this.bSm.aez();
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
        if (personChangeData != null && this.bSm.getUserData() != null) {
            this.bSm.a(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.bSm.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.zy().es(this.bSm.getUserData().getPortrait());
                }
            }
        }
        this.bSm.aez();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getId() == this.bSn.aeH().getId()) {
            finish();
        } else if (view.getId() == this.bSn.aeG().getId()) {
            if (!this.mIsHost) {
                adT();
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.bSm.getUserData() != null) {
                personChangeData.setName(this.bSm.getUserData().getName_show());
                personChangeData.setIntro(this.bSm.getUserData().getIntro());
                personChangeData.setSex(this.bSm.getUserData().getSex());
                personChangeData.setPortrait(this.bSm.getUserData().getPortrait());
            }
            sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, personChangeData, true)));
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_editprofile_click");
        } else if (view.getId() == this.bSn.ael().getId()) {
            if (this.bSm.getUserData() != null) {
                if (this.bSm.getIsSelf()) {
                    adR();
                } else {
                    adS();
                }
            }
        } else if (view.getId() == this.bSn.aeo().getId()) {
            this.bSm.aew();
        } else if (view.getId() == this.bSn.aem().getId()) {
            if (this.bSm.getUserData() != null) {
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.y.user_icon_intro), String.valueOf(bMK) + "?st_type=person_user_icon", true, false, false);
            }
        } else if (view.getId() == this.bSn.aec().getId()) {
            if (this.bSm.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_group_click");
            } else if (hF(3)) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_group_click");
            } else {
                return;
            }
            UserData userData = this.bSm.getUserData();
            if (userData != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), this.bSm.getId(), userData.getSex())));
            }
        } else if (view.getId() == this.bSn.aeD().getId()) {
            adQ();
        } else if (view.getId() == this.bSn.adX().getId()) {
            UserData userData2 = this.bSm.getUserData();
            if (userData2 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), this.bSm.getId(), userData2.getSex(), 1)));
            }
        } else if (view.getId() == this.bSn.adZ().getId()) {
            UserData userData3 = this.bSm.getUserData();
            if (userData3 != null) {
                sendMessage(new CustomMessage(2002001, new PersonFriendActivityConfig(getPageContext().getPageActivity(), this.bSm.getId(), userData3.getSex(), 1)));
            }
        } else if (view.getId() == this.bSn.adW().getId()) {
            UserData userData4 = this.bSm.getUserData();
            if (userData4 != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), userData4.getUserId(), userData4.getSex(), 1)));
            }
        } else if (view.getId() == this.bSn.adU().getId()) {
            UserData userData5 = this.bSm.getUserData();
            if (userData5 != null) {
                if (this.mIsHost) {
                    str = "iowner_gift";
                } else {
                    str = "iguest_gift";
                }
                sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(getPageContext().getPageActivity(), userData5.getUserId(), userData5.getSex(), str)));
                this.bSn.hG(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vq();
            }
        } else if (view.getId() == this.bSn.aea().getId()) {
            if (this.bSm.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_attentionme_click");
            } else {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_attentionme_click");
            }
            UserData userData6 = this.bSm.getUserData();
            if (userData6 != null) {
                this.bSn.ef(false);
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData6.getUserId(), userData6.getSex())));
            }
        } else if (view.getId() == this.bSn.aeb().getId()) {
            if (this.bSm.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_attentionper_click");
            } else {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_attentionper_click");
            }
            UserData userData7 = this.bSm.getUserData();
            if (userData7 != null) {
                sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData7.getUserId(), userData7.getSex())));
            }
        } else if (view.getId() == this.bSn.aed().getId()) {
            if (this.bSm.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_attentionbar_click");
            } else if (hF(2)) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_attentionbar_click");
            } else {
                return;
            }
            UserData userData8 = this.bSm.getUserData();
            if (userData8 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), userData8.getLike_bars(), this.bSm.getId(), userData8.getSex())));
            }
        } else if (view.getId() == this.bSn.aee().getId()) {
            if (this.bSm.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_thread_click");
            } else if (hF(4)) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_thread_click");
            } else {
                return;
            }
            UserData userData9 = this.bSm.getUserData();
            if (userData9 != null) {
                sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(getPageContext().getPageActivity(), userData9.getUserId(), userData9.getSex(), userData9.getPortrait())));
            }
        } else if (view.getId() == this.bSn.adY().getId()) {
            if (!this.bSk) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "igift_icon_ck");
                UserData userData10 = this.bSm.getUserData();
                if (userData10 != null) {
                    if (!com.baidu.adp.lib.util.n.isNetOk()) {
                        showToast(com.baidu.tieba.y.no_signall_data);
                        return;
                    }
                    this.bSk = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData10.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bSn.aen().getId()) {
            if (!this.bSk) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "igift_icon_ck");
                UserData userData11 = this.bSm.getUserData();
                if (userData11 != null) {
                    if (!com.baidu.adp.lib.util.n.isNetOk()) {
                        showToast(com.baidu.tieba.y.no_signall_data);
                        return;
                    }
                    this.bSk = true;
                    sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData11.getUserIdLong())));
                }
            }
        } else if (view.getId() == this.bSn.aep().getId()) {
            sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(getPageContext().getPageActivity())));
        } else if (view.getId() == this.bSn.adu().getId()) {
            this.bSn.aeF();
            adP();
        } else if (view.getId() == this.bSn.adt().getId()) {
            this.bSn.aeF();
            if (this.bSm.getUserData() != null) {
                com.baidu.tbadk.newFriends.a.Cg().u(this.bSm.getUserData().getUserIdLong());
            }
        }
    }

    private void adP() {
        String format;
        String userName = this.bSm.getUserData() != null ? this.bSm.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(com.baidu.tieba.y.confirm, new e(this));
            aVar.b(com.baidu.tieba.y.cancel, new f(this));
            if (this.bSl.getMaskType() == 1) {
                format = String.format(getPageContext().getString(com.baidu.tieba.y.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(com.baidu.tieba.y.block_chat_message_alert), userName);
            }
            aVar.ca(format);
            aVar.b(getPageContext());
            aVar.re();
        }
    }

    private void adQ() {
        if (this.bSm.getUserData() != null && this.bSm.getUserData().getIsOfficialAccount() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(this.bSm.getUserData().getUserId(), 0L), this.bSm.getUserData().getUserName(), this.bSm.getUserData().getPortrait(), 0, 4)));
        } else if (this.mIsHost) {
            AntiData Zp = this.bSm.Zp();
            if (Zp != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AppealActivityConfig(getPageContext().getPageActivity(), Zp.getBlock_forum_id(), Zp.getUser_id(), Zp.getUser_name())));
            }
        } else {
            PersonTainInfo aes = this.bSm.aes();
            if (aes != null) {
                int isFriend = aes.getIsFriend();
                if (isFriend == 0) {
                    UserData userData = this.bSm.getUserData();
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.bSm.aev(), aes.getUserClientVersionLower(), this.bSm.getStType())));
                    }
                } else if (isFriend == 1) {
                    UserData userData2 = this.bSm.getUserData();
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
                    com.baidu.tbadk.newFriends.a.Cg().a(com.baidu.adp.lib.g.c.a(this.bSm.getId(), 0L), "pers_pg");
                }
            }
        }
    }

    private boolean hF(int i) {
        int yg;
        if (this.bSm.getUserData() == null || this.bSm.getUserData().getPersonPrivate() == null) {
            return false;
        }
        com.baidu.tbadk.data.h personPrivate = this.bSm.getUserData().getPersonPrivate();
        switch (i) {
            case 2:
                yg = personPrivate.yd();
                break;
            case 3:
                yg = personPrivate.ye();
                break;
            case 4:
                yg = personPrivate.yf();
                break;
            case 5:
                yg = personPrivate.yg();
                break;
            default:
                yg = 1;
                break;
        }
        if (this.bSm.aes() != null && this.bSm.aes().getIsFriend() != 1 && yg == 2) {
            showToast(com.baidu.tieba.y.private_friend_open);
            return false;
        } else if (yg == 3) {
            showToast(com.baidu.tieba.y.private_hide);
            return false;
        } else {
            return true;
        }
    }

    public void adR() {
        String[] strArr = {getPageContext().getString(com.baidu.tieba.y.hd_photo), getPageContext().getString(com.baidu.tieba.y.change_photo)};
        com.baidu.tbadk.core.dialog.e eVar = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        eVar.by(com.baidu.tieba.y.operation);
        eVar.a(strArr, new g(this));
        eVar.d(getPageContext());
        eVar.rg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adS() {
        if (this.bSm != null && this.bSm.getUserData() != null) {
            String ib = ib(this.bSm.getUserData().getPortraitH());
            HashMap hashMap = new HashMap();
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = this.bSm.getUserData().getPortrait();
            imageUrlData.urlType = 25;
            hashMap.put(ib, imageUrlData);
            sendMessage(new CustomMessage(2002001, new PersonImageActivityConfig(getPageContext().getPageActivity(), ib, hashMap)));
        }
    }

    private String ib(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void adT() {
        if (this.bSm != null && this.bSm.aes() != null && this.bSl != null) {
            this.bSn.f(this.bSm.aes().getIsFriend() == 1, this.bSl.getMaskType() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            if (this.bSm != null) {
                if (msgFans > 0) {
                    this.bSm.al(msgFans);
                    this.bSn.ef(true);
                }
                this.bSn.hG(msgGiftNum);
            }
        }
    }
}
