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
    private static final String bOI = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/135_1";
    private BlackListModel bUS;
    private v bUT;
    private ad bUU;
    private boolean mIsHost;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.tbadkCore.e.a aFs = null;
    private boolean bUR = false;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private final com.baidu.adp.framework.listener.a bUV = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e bUW = new h(this, 104102);
    final com.baidu.adp.framework.listener.e bUX = new i(this, 304102);
    final CustomMessageListener bUY = new j(this, 2001178);
    private final CustomMessageListener aAM = new k(this, 2001178);
    private final com.baidu.adp.framework.listener.e bUZ = new l(this, 304103);
    private final CustomMessageListener bVa = new m(this, 2001238);
    private final CustomMessageListener bVb = new n(this, 2001118);
    private final CustomMessageListener bVc = new o(this, 2001124);
    private final CustomMessageListener bVd = new b(this, 2001237);

    public v aeT() {
        return this.bUT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l(bundle);
        this.mIsHost = this.bUT.getIsSelf();
        registerListener();
        initUI();
        aeU();
    }

    private void registerListener() {
        registerListener(this.bUV);
        registerListener(this.bUW);
        registerListener(this.bUX);
        registerListener(this.bUY);
        registerListener(this.bUZ);
        registerListener(this.aAM);
        registerListener(this.bVb);
        registerListener(this.bVc);
        registerListener(this.bVd);
        registerListener(this.bVa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bUU.onStart();
        this.bUT.aeG();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgGiftNum();
        this.bUR = false;
        if (TbadkCoreApplication.getRefreshFlag()) {
            this.bUT.afE();
            TbadkCoreApplication.setRefreshFlag(false);
            return;
        }
        long msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgFans();
        if (msgFans != this.bUT.afv() && msgFans > 0) {
            this.bUT.am(msgFans);
            this.bUU.er(true);
        } else {
            this.bUT.am(msgFans);
            this.bUU.er(false);
        }
        if (msgGiftNum > 0) {
            this.bUT.hW(msgGiftNum);
            this.bUU.hV(msgGiftNum);
            return;
        }
        this.bUT.hW(msgGiftNum);
        this.bUU.hV(msgGiftNum);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.bUT.afE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.bUU.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bUT.afC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        com.baidu.tbadk.imageManager.e.Al().dM(TbConfig.getBigImageMaxUsedMemory());
        this.bUU.onStop();
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
        this.bUU = new ad(this, this.mIsHost);
        this.bUU.setExpandListRefreshListener(new c(this));
        if (this.mIsHost) {
            this.bUT.afD();
        }
        this.bUU.startLoad();
    }

    private void aeU() {
        if (this.aFs == null) {
            this.aFs = new com.baidu.tieba.tbadkCore.e.a("profileStat");
            this.aFs.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bUU.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bUT != null) {
            bundle.putBoolean("self", this.bUT.getIsSelf());
            bundle.putString("un", this.bUT.getId());
            bundle.putString("name", this.bUT.getName());
            bundle.putBoolean("tab_page", this.bUT.afy());
            bundle.putBoolean("tab_msg", this.bUT.afz());
            bundle.putString("from", this.bUT.afA());
            bundle.putString("st_type", this.bUT.getStType());
        }
    }

    private void l(Bundle bundle) {
        this.mPersonChangeData = new PersonChangeData();
        this.bUS = new BlackListModel(this);
        this.bUT = new v(this);
        if (bundle != null) {
            this.bUT.iH(bundle.getString("from"));
            this.bUT.setIsSelf(bundle.getBoolean("self", false));
            this.bUT.setId(bundle.getString("un"));
            this.bUT.setName(bundle.getString("name"));
            this.bUT.es(bundle.getBoolean("tab_page", false));
            this.bUT.et(bundle.getBoolean("tab_msg", false));
            this.bUT.setStType(bundle.getString("st_type"));
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bUT.iH(intent.getStringExtra("from_forum"));
                this.bUT.setIsSelf(intent.getBooleanExtra("self", false));
                this.bUT.setId(intent.getStringExtra("un"));
                this.bUT.setName(intent.getStringExtra("name"));
                this.bUT.es(intent.getBooleanExtra("tab_page", false));
                this.bUT.et(intent.getBooleanExtra("tab_msg", false));
                this.bUT.setStType(intent.getStringExtra("st_type"));
            }
        }
        this.bUT.setLoadDataCallBack(new d(this));
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
                if (this.bUT.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.Al().eJ(this.bUT.getUserData().getPortrait());
                }
                this.bUT.afE();
            } else if (i == 12014) {
                this.bUT.afE();
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
        if (personChangeData != null && this.bUT.getUserData() != null) {
            this.bUT.a(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.bUT.getUserData() != null) {
                    com.baidu.tbadk.imageManager.e.Al().eJ(this.bUT.getUserData().getPortrait());
                }
            }
        }
        this.bUT.afE();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getId() == this.bUU.afN().getId()) {
            finish();
        } else if (view.getId() == this.bUU.afq().getId()) {
            if (this.bUT.getUserData() != null) {
                if (this.bUT.getIsSelf()) {
                    aes();
                } else {
                    aeX();
                }
            }
        } else if (view.getId() == this.bUU.afh().getId()) {
            if (this.bUT.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_group_click");
            } else if (hU(3)) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_group_click");
            } else {
                return;
            }
            UserData userData = this.bUT.getUserData();
            if (userData != null) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), this.bUT.getId(), userData.getSex())));
            }
        } else if (view.getId() == this.bUU.afi().getId()) {
            if (this.bUT.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_attentionbar_click");
            } else if (hU(2)) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_attentionbar_click");
            } else {
                return;
            }
            UserData userData2 = this.bUT.getUserData();
            if (userData2 != null) {
                sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), userData2.getLike_bars(), this.bUT.getId(), userData2.getSex())));
            }
        } else if (view.getId() == this.bUU.afj().getId()) {
            if (this.bUT.getIsSelf()) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_thread_click");
            } else if (hU(4)) {
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_thread_click");
            } else {
                return;
            }
            UserData userData3 = this.bUT.getUserData();
            if (userData3 != null) {
                sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(getPageContext().getPageActivity(), userData3.getUserId(), userData3.getSex(), userData3.getPortrait())));
            }
        } else if (bq.ae(getPageContext().getPageActivity())) {
            if (view.getId() == this.bUU.afM().getId()) {
                if (!this.mIsHost) {
                    aeY();
                    return;
                }
                PersonChangeData personChangeData = new PersonChangeData();
                if (this.bUT.getUserData() != null) {
                    personChangeData.setName(this.bUT.getUserData().getName_show());
                    personChangeData.setIntro(this.bUT.getUserData().getIntro());
                    personChangeData.setSex(this.bUT.getUserData().getSex());
                    personChangeData.setPortrait(this.bUT.getUserData().getPortrait());
                }
                sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(getPageContext().getPageActivity(), 101, personChangeData, true)));
                com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_editprofile_click");
            } else if (view.getId() == this.bUU.aft().getId()) {
                this.bUT.afB();
            } else if (view.getId() == this.bUU.afr().getId()) {
                if (this.bUT.getUserData() != null) {
                    com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.t.user_icon_intro), String.valueOf(bOI) + "?st_type=person_user_icon", true, false, false);
                }
            } else if (view.getId() == this.bUU.afJ().getId()) {
                aeW();
            } else if (view.getId() == this.bUU.afc().getId()) {
                UserData userData4 = this.bUT.getUserData();
                if (userData4 != null) {
                    sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), this.bUT.getId(), userData4.getSex(), 1)));
                }
            } else if (view.getId() == this.bUU.afe().getId()) {
                UserData userData5 = this.bUT.getUserData();
                if (userData5 != null) {
                    sendMessage(new CustomMessage(2002001, new PersonFriendActivityConfig(getPageContext().getPageActivity(), this.bUT.getId(), userData5.getSex(), 1)));
                }
            } else if (view.getId() == this.bUU.afb().getId()) {
                UserData userData6 = this.bUT.getUserData();
                if (userData6 != null) {
                    sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getPageContext().getPageActivity(), userData6.getUserId(), userData6.getSex(), 1)));
                }
            } else if (view.getId() == this.bUU.aeZ().getId()) {
                UserData userData7 = this.bUT.getUserData();
                if (userData7 != null) {
                    if (this.mIsHost) {
                        str = "iowner_gift";
                    } else {
                        str = "iguest_gift";
                    }
                    sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(getPageContext().getPageActivity(), userData7.getUserId(), userData7.getSex(), str)));
                    this.bUU.hV(0);
                    com.baidu.tbadk.coreExtra.messageCenter.a.vJ().wa();
                }
            } else if (view.getId() == this.bUU.aff().getId()) {
                if (this.bUT.getIsSelf()) {
                    com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_attentionme_click");
                } else {
                    com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_attentionme_click");
                }
                UserData userData8 = this.bUT.getUserData();
                if (userData8 != null) {
                    this.bUU.er(false);
                    sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData8.getUserId(), userData8.getSex())));
                }
            } else if (view.getId() == this.bUU.afg().getId()) {
                if (this.bUT.getIsSelf()) {
                    com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_self_attentionper_click");
                } else {
                    com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "person_guid_attentionper_click");
                }
                UserData userData9 = this.bUT.getUserData();
                if (userData9 != null) {
                    sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData9.getUserId(), userData9.getSex())));
                }
            } else if (view.getId() == this.bUU.afd().getId()) {
                if (!this.bUR) {
                    com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "igift_icon_ck");
                    UserData userData10 = this.bUT.getUserData();
                    if (userData10 != null) {
                        if (!com.baidu.adp.lib.util.n.isNetOk()) {
                            showToast(com.baidu.tieba.t.no_signall_data);
                            return;
                        }
                        this.bUR = true;
                        sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData10.getUserIdLong())));
                    }
                }
            } else if (view.getId() == this.bUU.afs().getId()) {
                if (!this.bUR) {
                    com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "igift_icon_ck");
                    UserData userData11 = this.bUT.getUserData();
                    if (userData11 != null) {
                        if (!com.baidu.adp.lib.util.n.isNetOk()) {
                            showToast(com.baidu.tieba.t.no_signall_data);
                            return;
                        }
                        this.bUR = true;
                        sendMessage(new CustomMessage(2002001, new BuyGiftActivityConfig(getPageContext().getPageActivity(), userData11.getUserIdLong())));
                    }
                }
            } else if (view.getId() == this.bUU.afu().getId()) {
                sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(getPageContext().getPageActivity())));
            } else if (view.getId() == this.bUU.aeC().getId()) {
                this.bUU.afL();
                aeV();
            } else if (view.getId() == this.bUU.aeB().getId()) {
                this.bUU.afL();
                if (this.bUT.getUserData() != null) {
                    com.baidu.tbadk.newFriends.a.CR().w(this.bUT.getUserData().getUserIdLong());
                }
            }
        }
    }

    private void aeV() {
        String format;
        String userName = this.bUT.getUserData() != null ? this.bUT.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(com.baidu.tieba.t.confirm, new e(this));
            aVar.b(com.baidu.tieba.t.cancel, new f(this));
            if (this.bUS.getMaskType() == 1) {
                format = String.format(getPageContext().getString(com.baidu.tieba.t.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(com.baidu.tieba.t.block_chat_message_alert), userName);
            }
            aVar.cn(format);
            aVar.b(getPageContext());
            aVar.rL();
        }
    }

    private void aeW() {
        if (this.bUT.getUserData() != null && this.bUT.getUserData().getIsOfficialAccount() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.c(this.bUT.getUserData().getUserId(), 0L), this.bUT.getUserData().getUserName(), this.bUT.getUserData().getPortrait(), 0, 4)));
        } else if (this.mIsHost) {
            AntiData aaG = this.bUT.aaG();
            if (aaG != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AppealActivityConfig(getPageContext().getPageActivity(), aaG.getBlock_forum_id(), aaG.getUser_id(), aaG.getUser_name())));
            }
        } else {
            PersonTainInfo afx = this.bUT.afx();
            if (afx != null) {
                int isFriend = afx.getIsFriend();
                if (isFriend == 0) {
                    UserData userData = this.bUT.getUserData();
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.bUT.afA(), afx.getUserClientVersionLower(), this.bUT.getStType())));
                    }
                } else if (isFriend == 1) {
                    UserData userData2 = this.bUT.getUserData();
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
                    com.baidu.tbadk.newFriends.a.CR().b(com.baidu.adp.lib.g.c.c(this.bUT.getId(), 0L), "pers_pg");
                }
            }
        }
    }

    private boolean hU(int i) {
        int yT;
        if (this.bUT.getUserData() == null || this.bUT.getUserData().getPersonPrivate() == null) {
            bq.ae(getPageContext().getPageActivity());
            return false;
        }
        com.baidu.tbadk.data.h personPrivate = this.bUT.getUserData().getPersonPrivate();
        switch (i) {
            case 2:
                yT = personPrivate.yQ();
                break;
            case 3:
                yT = personPrivate.yR();
                break;
            case 4:
                yT = personPrivate.yS();
                break;
            case 5:
                yT = personPrivate.yT();
                break;
            default:
                yT = 1;
                break;
        }
        if (this.bUT.afx() != null && this.bUT.afx().getIsFriend() != 1 && yT == 2) {
            showToast(com.baidu.tieba.t.private_friend_open);
            return false;
        } else if (yT != 3) {
            return bq.ae(getPageContext().getPageActivity());
        } else {
            showToast(com.baidu.tieba.t.private_hide);
            return false;
        }
    }

    public void aes() {
        String[] strArr = {getPageContext().getString(com.baidu.tieba.t.hd_photo), getPageContext().getString(com.baidu.tieba.t.change_photo), getPageContext().getString(com.baidu.tieba.t.change_system_photo)};
        com.baidu.tbadk.core.dialog.e eVar = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        eVar.bx(com.baidu.tieba.t.operation);
        eVar.a(strArr, new g(this));
        eVar.d(getPageContext());
        eVar.rN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeX() {
        if (this.bUT != null && this.bUT.getUserData() != null) {
            String iG = iG(this.bUT.getUserData().getPortraitH());
            HashMap hashMap = new HashMap();
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = this.bUT.getUserData().getPortrait();
            imageUrlData.urlType = 25;
            hashMap.put(iG, imageUrlData);
            sendMessage(new CustomMessage(2002001, new PersonImageActivityConfig(getPageContext().getPageActivity(), iG, hashMap)));
        }
    }

    private String iG(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void aeY() {
        if (this.bUT != null && this.bUT.afx() != null && this.bUS != null) {
            this.bUU.g(this.bUT.afx().getIsFriend() == 1, this.bUS.getMaskType() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            if (this.bUT != null) {
                if (msgFans > 0) {
                    this.bUT.am(msgFans);
                    this.bUU.er(true);
                }
                this.bUU.hV(msgGiftNum);
            }
        }
    }
}
