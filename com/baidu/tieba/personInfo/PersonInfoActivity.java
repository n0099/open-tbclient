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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bq;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.im.model.BlackListModel;
import java.util.HashMap;
/* loaded from: classes.dex */
public class PersonInfoActivity extends BaseActivity<PersonInfoActivity> {
    private static final String bOJ = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/135_1";
    private BlackListModel bUT;
    private v bUU;
    private ad bUV;
    private boolean mIsHost;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.tbadkCore.e.a aFt = null;
    private boolean bUS = false;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private final com.baidu.adp.framework.listener.a bUW = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e bUX = new h(this, 104102);
    final com.baidu.adp.framework.listener.e bUY = new i(this, 304102);
    final CustomMessageListener bUZ = new j(this, 2001178);
    private final CustomMessageListener aAN = new k(this, 2001178);
    private final com.baidu.adp.framework.listener.e bVa = new l(this, 304103);
    private final CustomMessageListener bVb = new m(this, 2001238);
    private final CustomMessageListener bVc = new n(this, 2001118);
    private final CustomMessageListener bVd = new o(this, 2001124);
    private final CustomMessageListener bVe = new b(this, 2001237);

    public v aeU() {
        return this.bUU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l(bundle);
        this.mIsHost = this.bUU.getIsSelf();
        registerListener();
        initUI();
        aeV();
    }

    private void registerListener() {
        registerListener(this.bUW);
        registerListener(this.bUX);
        registerListener(this.bUY);
        registerListener(this.bUZ);
        registerListener(this.bVa);
        registerListener(this.aAN);
        registerListener(this.bVc);
        registerListener(this.bVd);
        registerListener(this.bVe);
        registerListener(this.bVb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bUV.onStart();
        this.bUU.aeH();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgGiftNum();
        this.bUS = false;
        if (TbadkCoreApplication.getRefreshFlag()) {
            this.bUU.afF();
            TbadkCoreApplication.setRefreshFlag(false);
            return;
        }
        long msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgFans();
        if (msgFans != this.bUU.afw() && msgFans > 0) {
            this.bUU.am(msgFans);
            this.bUV.er(true);
        } else {
            this.bUU.am(msgFans);
            this.bUV.er(false);
        }
        if (msgGiftNum > 0) {
            this.bUU.hW(msgGiftNum);
            this.bUV.hV(msgGiftNum);
            return;
        }
        this.bUU.hW(msgGiftNum);
        this.bUV.hV(msgGiftNum);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.bUU.afF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.bUV.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bUU.afD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        com.baidu.tbadk.imageManager.e.Am().dM(TbConfig.getBigImageMaxUsedMemory());
        this.bUV.onStop();
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
        this.bUV = new ad(this, this.mIsHost);
        this.bUV.setExpandListRefreshListener(new c(this));
        if (this.mIsHost) {
            this.bUU.afE();
        }
        this.bUV.startLoad();
    }

    private void aeV() {
        if (this.aFt == null) {
            this.aFt = new com.baidu.tieba.tbadkCore.e.a("profileStat");
            this.aFt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bUV.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bUU != null) {
            bundle.putBoolean("self", this.bUU.getIsSelf());
            bundle.putString("un", this.bUU.getId());
            bundle.putString("name", this.bUU.getName());
            bundle.putBoolean("tab_page", this.bUU.afz());
            bundle.putBoolean("tab_msg", this.bUU.afA());
            bundle.putString("from", this.bUU.afB());
            bundle.putString("st_type", this.bUU.getStType());
        }
    }

    private void l(Bundle bundle) {
        this.mPersonChangeData = new PersonChangeData();
        this.bUT = new BlackListModel(this);
        this.bUU = new v(this);
        if (bundle != null) {
            this.bUU.iH(bundle.getString("from"));
            this.bUU.setIsSelf(bundle.getBoolean("self", false));
            this.bUU.setId(bundle.getString("un"));
            this.bUU.setName(bundle.getString("name"));
            this.bUU.es(bundle.getBoolean("tab_page", false));
            this.bUU.et(bundle.getBoolean("tab_msg", false));
            this.bUU.setStType(bundle.getString("st_type"));
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bUU.iH(intent.getStringExtra("from_forum"));
                this.bUU.setIsSelf(intent.getBooleanExtra("self", false));
                this.bUU.setId(intent.getStringExtra("un"));
                this.bUU.setName(intent.getStringExtra("name"));
                this.bUU.es(intent.getBooleanExtra("tab_page", false));
                this.bUU.et(intent.getBooleanExtra("tab_msg", false));
                this.bUU.setStType(intent.getStringExtra("st_type"));
            }
        }
        this.bUU.setLoadDataCallBack(new d(this));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                T(intent);
            } else if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        I(intent);
                    } else {
                        getAlbumDataFromImage(intent);
                    }
                }
            } else if (i == 12010 || i == 12009) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.bUU.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.Am().eJ(this.bUU.getUserData().getPortrait());
                }
                this.bUU.afF();
            } else if (i == 12014) {
                this.bUU.afF();
            }
        } else if (i2 == 0 && i == 12010) {
            ax.b(getPageContext());
        }
    }

    private void getAlbumDataFromImage(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    private void I(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void T(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra(PersonChangeData.TAG_PERSON_INFO);
        if (personChangeData != null && this.bUU.getUserData() != null) {
            this.bUU.a(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.bUU.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.Am().eJ(this.bUU.getUserData().getPortrait());
                }
            }
        }
        this.bUU.afF();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getId() == this.bUV.afO().getId()) {
            finish();
        } else if (view.getId() == this.bUV.afr().getId()) {
            if (this.bUU.getUserData() != null) {
                if (this.bUU.getIsSelf()) {
                    aet();
                } else {
                    aeY();
                }
            }
        } else if (view.getId() == this.bUV.afi().getId()) {
            if (this.bUU.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_group_click");
            } else if (hU(3)) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_group_click");
            } else {
                return;
            }
            UserData userData = this.bUU.getUserData();
            if (userData != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), this.bUU.getId(), userData.getSex())));
            }
        } else if (view.getId() == this.bUV.afj().getId()) {
            if (this.bUU.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_attentionbar_click");
            } else if (hU(2)) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_attentionbar_click");
            } else {
                return;
            }
            UserData userData2 = this.bUU.getUserData();
            if (userData2 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), userData2.getLike_bars(), this.bUU.getId(), userData2.getSex())));
            }
        } else if (view.getId() == this.bUV.afk().getId()) {
            if (this.bUU.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_thread_click");
            } else if (hU(4)) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_thread_click");
            } else {
                return;
            }
            UserData userData3 = this.bUU.getUserData();
            if (userData3 != null) {
                sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(getPageContext().getPageActivity(), userData3.getUserId(), userData3.getSex(), userData3.getPortrait())));
            }
        } else if (bq.ae(getPageContext().getPageActivity())) {
            if (view.getId() == this.bUV.afN().getId()) {
                if (!this.mIsHost) {
                    aeZ();
                    return;
                }
                PersonChangeData personChangeData = new PersonChangeData();
                if (this.bUU.getUserData() != null) {
                    personChangeData.setName(this.bUU.getUserData().getName_show());
                    personChangeData.setIntro(this.bUU.getUserData().getIntro());
                    personChangeData.setSex(this.bUU.getUserData().getSex());
                    personChangeData.setPortrait(this.bUU.getUserData().getPortrait());
                }
                sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, personChangeData, true)));
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_editprofile_click");
            } else if (view.getId() == this.bUV.afu().getId()) {
                this.bUU.afC();
            } else if (view.getId() == this.bUV.afs().getId()) {
                if (this.bUU.getUserData() != null) {
                    com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.t.user_icon_intro), String.valueOf(bOJ) + "?st_type=person_user_icon", true, false, false);
                }
            } else if (view.getId() == this.bUV.afK().getId()) {
                aeX();
            } else if (view.getId() == this.bUV.afd().getId()) {
                UserData userData4 = this.bUU.getUserData();
                if (userData4 != null) {
                    sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), this.bUU.getId(), userData4.getSex(), 1)));
                }
            } else if (view.getId() == this.bUV.aff().getId()) {
                UserData userData5 = this.bUU.getUserData();
                if (userData5 != null) {
                    sendMessage(new CustomMessage(2002001, new PersonFriendActivityConfig(getPageContext().getPageActivity(), this.bUU.getId(), userData5.getSex(), 1)));
                }
            } else if (view.getId() == this.bUV.afc().getId()) {
                UserData userData6 = this.bUU.getUserData();
                if (userData6 != null) {
                    sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), userData6.getUserId(), userData6.getSex(), 1)));
                }
            } else if (view.getId() == this.bUV.afa().getId()) {
                UserData userData7 = this.bUU.getUserData();
                if (userData7 != null) {
                    if (this.mIsHost) {
                        str = "iowner_gift";
                    } else {
                        str = "iguest_gift";
                    }
                    sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(getPageContext().getPageActivity(), userData7.getUserId(), userData7.getSex(), str)));
                    this.bUV.hV(0);
                    com.baidu.tbadk.coreExtra.messageCenter.a.vJ().wa();
                }
            } else if (view.getId() == this.bUV.afg().getId()) {
                if (this.bUU.getIsSelf()) {
                    com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_attentionme_click");
                } else {
                    com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_attentionme_click");
                }
                UserData userData8 = this.bUU.getUserData();
                if (userData8 != null) {
                    this.bUV.er(false);
                    sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData8.getUserId(), userData8.getSex())));
                }
            } else if (view.getId() == this.bUV.afh().getId()) {
                if (this.bUU.getIsSelf()) {
                    com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_attentionper_click");
                } else {
                    com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_attentionper_click");
                }
                UserData userData9 = this.bUU.getUserData();
                if (userData9 != null) {
                    sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData9.getUserId(), userData9.getSex())));
                }
            } else if (view.getId() == this.bUV.afe().getId()) {
                if (!this.bUS) {
                    com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "igift_icon_ck");
                    UserData userData10 = this.bUU.getUserData();
                    if (userData10 != null) {
                        if (!com.baidu.adp.lib.util.n.isNetOk()) {
                            showToast(com.baidu.tieba.t.no_signall_data);
                            return;
                        }
                        this.bUS = true;
                        sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData10.getUserIdLong())));
                    }
                }
            } else if (view.getId() == this.bUV.aft().getId()) {
                if (!this.bUS) {
                    com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "igift_icon_ck");
                    UserData userData11 = this.bUU.getUserData();
                    if (userData11 != null) {
                        if (!com.baidu.adp.lib.util.n.isNetOk()) {
                            showToast(com.baidu.tieba.t.no_signall_data);
                            return;
                        }
                        this.bUS = true;
                        sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData11.getUserIdLong())));
                    }
                }
            } else if (view.getId() == this.bUV.afv().getId()) {
                sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(getPageContext().getPageActivity())));
            } else if (view.getId() == this.bUV.aeD().getId()) {
                this.bUV.afM();
                aeW();
            } else if (view.getId() == this.bUV.aeC().getId()) {
                this.bUV.afM();
                if (this.bUU.getUserData() != null) {
                    com.baidu.tbadk.newFriends.a.CS().w(this.bUU.getUserData().getUserIdLong());
                }
            }
        }
    }

    private void aeW() {
        String format;
        String userName = this.bUU.getUserData() != null ? this.bUU.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(com.baidu.tieba.t.confirm, new e(this));
            aVar.b(com.baidu.tieba.t.cancel, new f(this));
            if (this.bUT.getMaskType() == 1) {
                format = String.format(getPageContext().getString(com.baidu.tieba.t.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(com.baidu.tieba.t.block_chat_message_alert), userName);
            }
            aVar.cn(format);
            aVar.b(getPageContext());
            aVar.rL();
        }
    }

    private void aeX() {
        if (this.bUU.getUserData() != null && this.bUU.getUserData().getIsOfficialAccount() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.c(this.bUU.getUserData().getUserId(), 0L), this.bUU.getUserData().getUserName(), this.bUU.getUserData().getPortrait(), 0, 4)));
        } else if (this.mIsHost) {
            AntiData aaH = this.bUU.aaH();
            if (aaH != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AppealActivityConfig(getPageContext().getPageActivity(), aaH.getBlock_forum_id(), aaH.getUser_id(), aaH.getUser_name())));
            }
        } else {
            PersonTainInfo afy = this.bUU.afy();
            if (afy != null) {
                int isFriend = afy.getIsFriend();
                if (isFriend == 0) {
                    UserData userData = this.bUU.getUserData();
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.bUU.afB(), afy.getUserClientVersionLower(), this.bUU.getStType())));
                    }
                } else if (isFriend == 1) {
                    UserData userData2 = this.bUU.getUserData();
                    if (userData2 != null) {
                        if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(com.baidu.tieba.t.login_to_chat), true, 11028)));
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
                    com.baidu.tbadk.newFriends.a.CS().b(com.baidu.adp.lib.g.c.c(this.bUU.getId(), 0L), "pers_pg");
                }
            }
        }
    }

    private boolean hU(int i) {
        int yU;
        if (this.bUU.getUserData() == null || this.bUU.getUserData().getPersonPrivate() == null) {
            bq.ae(getPageContext().getPageActivity());
            return false;
        }
        com.baidu.tbadk.data.h personPrivate = this.bUU.getUserData().getPersonPrivate();
        switch (i) {
            case 2:
                yU = personPrivate.yR();
                break;
            case 3:
                yU = personPrivate.yS();
                break;
            case 4:
                yU = personPrivate.yT();
                break;
            case 5:
                yU = personPrivate.yU();
                break;
            default:
                yU = 1;
                break;
        }
        if (this.bUU.afy() != null && this.bUU.afy().getIsFriend() != 1 && yU == 2) {
            showToast(com.baidu.tieba.t.private_friend_open);
            return false;
        } else if (yU != 3) {
            return bq.ae(getPageContext().getPageActivity());
        } else {
            showToast(com.baidu.tieba.t.private_hide);
            return false;
        }
    }

    public void aet() {
        String[] strArr = {getPageContext().getString(com.baidu.tieba.t.hd_photo), getPageContext().getString(com.baidu.tieba.t.change_photo), getPageContext().getString(com.baidu.tieba.t.change_system_photo)};
        com.baidu.tbadk.core.dialog.e eVar = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        eVar.bx(com.baidu.tieba.t.operation);
        eVar.a(strArr, new g(this));
        eVar.d(getPageContext());
        eVar.rN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeY() {
        if (this.bUU != null && this.bUU.getUserData() != null) {
            String iG = iG(this.bUU.getUserData().getPortraitH());
            HashMap hashMap = new HashMap();
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = this.bUU.getUserData().getPortrait();
            imageUrlData.urlType = 25;
            hashMap.put(iG, imageUrlData);
            sendMessage(new CustomMessage(2002001, new PersonImageActivityConfig(getPageContext().getPageActivity(), iG, hashMap)));
        }
    }

    private String iG(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void aeZ() {
        if (this.bUU != null && this.bUU.afy() != null && this.bUT != null) {
            this.bUV.g(this.bUU.afy().getIsFriend() == 1, this.bUT.getMaskType() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            if (this.bUU != null) {
                if (msgFans > 0) {
                    this.bUU.am(msgFans);
                    this.bUV.er(true);
                }
                this.bUV.hV(msgGiftNum);
            }
        }
    }
}
