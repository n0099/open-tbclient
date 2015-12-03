package com.baidu.tieba.personInfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.n;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.data.PersonListActivityConfig;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class d extends BaseFragment implements com.baidu.tbadk.mvc.c.a {
    private static final String cGm = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    public static boolean cRJ = false;
    private BaseFragmentActivity aHN;
    private ViewEventCenter aQB;
    private boolean aQE;
    private UserMuteAddAndDelModel cBJ;
    private com.baidu.tieba.usermute.i cBK;
    private aw cMT;
    private az cRH;
    private BlackListModel cRI;
    private NavigationBar cRL;
    private FrameLayout cRM;
    private com.baidu.tieba.person.a.ad cRN;
    private List<com.baidu.tbadk.data.g> cRP;
    public boolean cRS;
    private com.baidu.tbadk.f.f cRU;
    private boolean mIsLogin;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private NoNetworkView mNoNetworkView;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tbadk.f.h refreshView;
    private View rootView;
    private boolean cRG = false;
    private boolean mIsHost = true;
    private com.baidu.tieba.tbadkCore.d.a aRc = null;
    private boolean cyc = false;
    private boolean cRK = false;
    private String userId = "";
    private int cRO = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean cRQ = true;
    private int cRR = -1;
    private String cRT = "c10474";
    private final CustomMessageListener cRV = new e(this, CmdConfigCustom.CMD_YINJIN_CHANGE);
    private HttpMessageListener cRW = new p(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener cRX = new aa(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private CustomMessageListener cRY = new am(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);
    private com.baidu.adp.framework.listener.a cRZ = new ao(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
    private CustomMessageListener aQK = new ap(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private final com.baidu.adp.framework.listener.a cSa = new aq(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e cSb = new ar(this, 104102);
    final com.baidu.adp.framework.listener.e cSc = new as(this, 304102);
    final CustomMessageListener cSd = new f(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener aJs = new g(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e cSe = new h(this, 304103);
    private final CustomMessageListener cyh = new i(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener cfl = new j(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private i.a cBZ = new k(this);
    private final CustomMessageListener cSf = new l(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private UserMuteAddAndDelModel.a cBY = new m(this);
    private UserMuteAddAndDelModel.b cSg = new n(this);
    private final CustomMessageListener cSh = new o(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    final CustomMessageListener cSi = new q(this, CmdConfigCustom.CMD_BUY_YINJI_SUCCESS);
    private CustomMessageListener cSj = new r(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
    private CustomMessageListener byd = new s(this, CmdConfigCustom.CMD_PHOTO_LIVE_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener cSk = new t(this, CmdConfigCustom.CMD_COLLECTION_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener cSl = new u(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener cSm = new v(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);

    public aw aoE() {
        return this.cMT;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aHN = getBaseFragmentActivity();
        this.aQB = new ViewEventCenter();
        this.aQB.addEventDelegate(this);
        this.cRS = this.aHN instanceof PersonInfoActivity;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aoJ();
        m(bundle);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        this.mIsHost = this.cMT.getIsSelf();
        this.userId = this.cMT.getId();
        this.cRO = this.cMT.aps();
        registerListener();
        aoN();
        if (!this.mIsHost) {
            aoF();
        }
    }

    private void registerListener() {
        registerListener(this.aQK);
        registerListener(this.cSa);
        registerListener(this.cSb);
        registerListener(this.cSc);
        registerListener(this.cSd);
        registerListener(this.cSe);
        registerListener(this.aJs);
        registerListener(this.cyh);
        registerListener(this.cRW);
        registerListener(this.cRX);
        registerListener(this.cfl);
        registerListener(this.cRV);
        registerListener(this.cSf);
        registerListener(this.cSh);
        registerListener(this.cSi);
        registerListener(this.cSj);
        registerListener(this.cRY);
        registerListener(this.cRZ);
        registerListener(this.byd);
        registerListener(this.cSk);
        registerListener(this.cSl);
        registerListener(this.cSm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cMT.apf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = c(layoutInflater);
        if (this.cMT != null) {
            this.cRM = (FrameLayout) this.rootView.findViewById(n.f.root_layout);
            this.mNoNetworkView = (NoNetworkView) this.rootView.findViewById(n.f.view_no_network);
            this.mNoNetworkView.a(new w(this));
            this.cRL = (NavigationBar) this.rootView.findViewById(n.f.nologin_navigation_bar);
            if (!this.mIsLogin && this.mIsHost) {
                an(this.rootView);
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
            } else {
                A(this.rootView);
            }
            this.cRN = new com.baidu.tieba.person.a.ad(this);
            this.cRN.aoc();
        }
        return this.rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.cRN.fF(isPrimary());
        this.cRN.aoe();
        if (!this.cyc && isPrimary() && com.baidu.adp.lib.util.i.iP()) {
            a((View) this.cRM, false, -1);
            this.cMT.aph();
        } else if (this.cRK && com.baidu.adp.lib.util.i.iP()) {
            this.cMT.aph();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && TbadkCoreApplication.isLogin() && Boolean.valueOf(com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("need_show_yinji", true)).booleanValue() && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("need_show_yinji", false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cBK.onDestroy();
        if (this.cRH != null) {
            this.cRH.onDestroy();
        }
        if (this.cRU != null) {
            this.cRU.v(this.rootView);
            this.cRU = null;
        }
        if (this.mIsHost) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK));
        }
    }

    private void A(View view) {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        if (this.cRL != null) {
            this.cRL.setVisibility(8);
        }
        this.cRH = new az(this, this.mIsHost, view);
        this.cRH.setPersonListRefreshListener(new x(this));
        if (this.mIsHost) {
            this.cMT.apg();
        } else {
            a((View) this.cRM, false, -1);
            this.cMT.aph();
        }
        this.cRH.b(new y(this));
        this.cRH.H(new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoF() {
        long c = com.baidu.adp.lib.h.b.c(this.cMT.getId(), 0L);
        this.cBK.e(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        if (gVar != null) {
            if (!com.baidu.adp.lib.util.k.jg()) {
                showToast(n.i.neterror);
            } else if (!this.mIsHost) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10617").ab("obj_id", this.userId));
                d(gVar, list, i);
            } else if (gVar.isAdded()) {
                aoG();
            } else if (gVar.Bb()) {
                b(gVar, list, i);
            } else {
                c(gVar, list, i);
            }
        }
    }

    private void b(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        String[] strArr = {getPageContext().getString(n.i.hd_photo), getPageContext().getString(n.i.change_photo), getPageContext().getString(n.i.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bQ(n.i.operation);
        cVar.a(strArr, new ab(this, gVar, list, i));
        cVar.d(getPageContext());
        cVar.tz();
    }

    private void aoG() {
        String[] strArr = {getPageContext().getString(n.i.choose_local_photo), getPageContext().getString(n.i.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bQ(n.i.operation);
        cVar.a(strArr, new ac(this));
        cVar.d(getPageContext());
        cVar.tz();
    }

    private void c(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        String[] strArr = {getPageContext().getString(n.i.look_big_photo), getPageContext().getString(n.i.set_as_portrait_photo), getPageContext().getString(n.i.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bQ(n.i.operation);
        cVar.a(strArr, new ad(this, gVar, list, i));
        cVar.d(getPageContext());
        cVar.tz();
    }

    private String kX(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        if (gVar != null && list != null && !StringUtils.isNull(gVar.Ba())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.tbadk.data.g gVar2 : list) {
                if (gVar2 != null && !gVar2.isAdded()) {
                    if (gVar2.Bb()) {
                        arrayList.add(kX(gVar2.Ba()));
                    } else {
                        arrayList.add(gVar2.Ba());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoH() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.aHN.getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoI() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.aHN.getPageContext().getPageActivity(), 12014, this.cRQ)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.g gVar) {
        if (gVar != null && !StringUtils.isNull(gVar.Ba())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
            httpMessage.addParam("pic_url", gVar.Ba());
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        if (gVar != null && list != null && list.size() > 2 && !StringUtils.isNull(gVar.Ba())) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tbadk.data.g gVar2 = list.get(i2);
                if (gVar2 != null && !gVar2.isAdded() && !gVar2.Bb() && i2 != i) {
                    jSONArray.put(gVar2.Ba());
                }
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
            httpMessage.addParam("pic_list", jSONArray.toString());
            if (jSONArray.length() <= 0) {
                httpMessage.addParam("truncat", (Object) 1);
            } else {
                httpMessage.addParam("truncat", (Object) 0);
            }
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, List<com.baidu.tbadk.data.g> list) {
        if (!StringUtils.isNull(str) && list != null) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.data.g gVar = list.get(i);
                if (gVar != null && !gVar.isAdded() && !gVar.Bb()) {
                    jSONArray.put(gVar.Ba());
                }
            }
            jSONArray.put(str);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
            httpMessage.addParam("pic_list", jSONArray.toString());
            sendMessage(httpMessage);
        }
    }

    private void aoJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_USER_PICS, TbConfig.SET_USER_PICS);
        tbHttpMessageTask.setResponsedClass(SetUserPicsResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CHANGE_PORTRAIT, TbConfig.CHANGE_USER_PORTRAIT);
        tbHttpMessageTask2.setResponsedClass(ChangePortraitResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    private void getAlbumDataFromImage(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.cRQ)));
            }
            this.writeImagesInfo.clear();
        }
    }

    private void K(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.cMT.getUserData() != null && this.mIsHost) {
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.cMT.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.CX().fD(this.cMT.getUserData().getPortrait());
                }
            }
            this.cRK = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        K(intent);
                    } else {
                        getAlbumDataFromImage(intent);
                    }
                }
            } else if (i == 12010 || i == 12009) {
                if (intent != null) {
                    int intExtra = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra == 1) {
                        aoK();
                    } else if (intExtra == 2) {
                        aoL();
                    }
                }
            } else if (i == 12014) {
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra2 == 1) {
                        aoK();
                    } else if (intExtra2 == 2) {
                        aoL();
                    }
                }
            } else if (i == 24001 && intent != null && this.cRH != null) {
                this.cRH.startLoad();
                this.cRH.apz().fM(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoK() {
        if (this.cMT.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.CX().fD(this.cMT.getUserData().getPortrait());
        }
        this.cRK = true;
    }

    private void aoL() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new ae(this));
    }

    private void aoM() {
        if (this.cMT != null && this.cMT.apc() != null && this.cRI != null && this.cRH != null) {
            this.cRH.a(this.cMT.apc().getIsFriend() == 1, this.cRI.getMaskType() == 1, this.cRR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.person.data.d dVar) {
        UserData userData = this.cMT.getUserData();
        switch (dVar.mType) {
            case 0:
                this.cRN.c(false, 3);
                this.cRN.fG(true);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10597"));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(getActivity().getApplicationContext())));
                return;
            case 1:
                this.cRN.c(false, 1);
                if (userData != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(getActivity().getApplicationContext())));
                    return;
                }
                return;
            case 2:
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10604"));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(getActivity().getApplicationContext())));
                return;
            case 3:
                if (this.cMT.getIsSelf()) {
                    TiebaStatic.log("person_self_attentionme_click");
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10599"));
                } else {
                    TiebaStatic.log("person_guid_attentionme_click");
                }
                this.cRN.c(false, 2);
                if (userData != null) {
                    if (this.cRH != null) {
                        this.cRH.fP(false);
                    }
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData.getUserId(), userData.getSex())));
                    return;
                }
                return;
            case 4:
                if (this.cMT.getIsSelf()) {
                    TiebaStatic.log("person_self_attentionper_click");
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10600"));
                } else {
                    TiebaStatic.log("person_guid_attentionper_click");
                }
                if (userData != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData.getUserId(), userData.getSex())));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private View c(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(n.g.personinfo_tab_view, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    private void m(Bundle bundle) {
        this.cMT = new aw(getBaseFragmentActivity());
        this.cMT.anU();
        this.cRI = new BlackListModel(getPageContext());
        this.mPersonChangeData = new PersonChangeData();
        a(this.cMT, bundle);
        this.cMT.setLoadDataCallBack(new af(this));
        this.cBJ = new UserMuteAddAndDelModel(getPageContext());
        this.cBJ.a(this.cBY);
        this.cBJ.a(this.cSg);
        this.cBK = new com.baidu.tieba.usermute.i(getPageContext(), this.cBZ);
    }

    private void a(aw awVar, Bundle bundle) {
        if (bundle != null) {
            awVar.kZ(bundle.getString("from"));
            awVar.setIsSelf(bundle.getBoolean("self", true));
            awVar.setId(bundle.getString("un"));
            awVar.setName(bundle.getString("name"));
            awVar.fN(bundle.getBoolean("tab_page", false));
            awVar.fO(bundle.getBoolean("tab_msg", false));
            awVar.setStType(bundle.getString("st_type"));
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getStringExtra("un") != null) {
            awVar.kZ(intent.getStringExtra("from"));
            awVar.setIsSelf(intent.getBooleanExtra("self", false));
            awVar.setId(intent.getStringExtra("un"));
            awVar.setName(intent.getStringExtra("name"));
            awVar.fN(intent.getBooleanExtra("tab_page", false));
            awVar.fO(intent.getBooleanExtra("tab_msg", false));
            awVar.setStType(intent.getStringExtra("st_type"));
            return;
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        awVar.setIsSelf(true);
        if (currentAccountObj != null) {
            awVar.setId(currentAccountObj.getID());
            awVar.setName(currentAccountObj.getAccount());
        }
    }

    private void an(View view) {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(n.i.unlogin_person_button_text), new ah(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(n.d.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(n.d.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(n.d.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(n.d.ds60);
        NoDataViewFactory.b a = NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(n.d.ds20));
        this.cRM.setVisibility(8);
        this.cRL.setVisibility(0);
        this.cRL.switchNaviBarStatus(this.mIsLogin);
        this.cRL.setLoginClickListener(new ai(this));
        this.cRL.setRegisterClickListener(new aj(this));
        this.mNoDataView = NoDataViewFactory.a(getActivity(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, n.e.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(n.i.unlogin_person_msg_text, dimensionPixelSize4), a);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void aoN() {
        if (this.aRc == null) {
            this.aRc = new com.baidu.tieba.tbadkCore.d.a("profileStat");
            this.aRc.start();
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oP() {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.as.j(this.rootView, n.c.cp_bg_line_d);
        if (this.mNoNetworkView != null) {
            this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        }
        if (this.cRH != null) {
            this.cRH.onChangeSkinType(i);
        }
        if (this.cRL != null) {
            this.cRL.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public com.baidu.tieba.person.a.ad aoO() {
        return this.cRN;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData userData;
        if (this.cRH != null) {
            if (this.cRH.apG() != null && view.getId() == this.cRH.apG().getId()) {
                this.aHN.finish();
                return;
            }
            boolean isSelf = this.cMT.getIsSelf();
            String id = this.cMT.getId();
            if (view.getId() == this.cRH.aoW().getId()) {
                UserData userData2 = this.cMT.getUserData();
                if (userData2 != null) {
                    com.baidu.tbadk.data.g gVar = new com.baidu.tbadk.data.g();
                    gVar.eQ(userData2.getPortraitH());
                    gVar.eR(userData2.getPortrait());
                    gVar.bc(true);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(gVar);
                    if (this.mIsHost) {
                        b(gVar, arrayList, 0);
                    } else {
                        d(gVar, arrayList, 0);
                    }
                }
            } else if (this.cRH.apF() != null && view.getId() == this.cRH.apF().getId()) {
                if (!this.mIsHost) {
                    if (id != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10623").ab("obj_id", id));
                    }
                    aoM();
                }
            } else if (view.getId() == this.cRH.apz().apa().getId()) {
                TiebaStatic.log(this.cRT);
                if (bj.ah(getActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(getActivity())));
                }
            } else if (view.getId() == this.cRH.aoZ().getId()) {
                if (bj.ah(getActivity())) {
                    this.cMT.ape();
                }
            } else if (view.getId() == this.cRH.apA().getId()) {
                if (bj.ah(getActivity())) {
                    if (id != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10622").ab("obj_id", id));
                    }
                    aoR();
                }
            } else if (view.getId() == this.cRH.aoX().getId()) {
                if (isSelf) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10603"));
                } else if (id != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10607").ab("obj_id", id));
                }
                aoP();
            } else if (view.getId() == this.cRH.apz().aoY().getId()) {
                TiebaStatic.log("igift_icon_ck");
                if (bj.ah(getActivity()) && (userData = this.cMT.getUserData()) != null) {
                    if (!com.baidu.adp.lib.util.k.jg()) {
                        showToast(n.i.no_signall_data);
                        return;
                    }
                    this.cRG = true;
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10613").ab("obj_id", id).r("obj_param1", this.cRO));
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData.getUserIdLong(), userData.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001)));
                    this.cRH.apz().fM(true);
                }
            } else if (view.getId() == this.cRH.aoY().getId()) {
                if (bj.ah(getActivity())) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData3 = this.cMT.getUserData();
                    if (userData3 != null) {
                        if (!com.baidu.adp.lib.util.k.jg()) {
                            showToast(n.i.no_signall_data);
                            return;
                        }
                        this.cRG = true;
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData3.getUserIdLong(), userData3.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                    }
                }
            } else if (this.cRH.anP() != null && view.getId() == this.cRH.anP().getId()) {
                this.cRH.apE();
                aoQ();
            } else if (this.cRH.anO() != null && view.getId() == this.cRH.anO().getId()) {
                this.cRH.apE();
                if (this.cMT.getUserData() != null) {
                    com.baidu.tbadk.newFriends.a.Ei().H(this.cMT.getUserData().getUserIdLong());
                }
            } else if (this.cRH.anQ() != null && view.getId() == this.cRH.anQ().getId()) {
                this.cRH.apE();
                if (this.cMT != null) {
                    if (!com.baidu.adp.lib.util.i.iP()) {
                        showToast(n.i.neterror);
                    } else if (this.cRR == 0) {
                        this.cBJ.a(false, this.cMT.getUserData().getUserId(), this.cMT.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    } else if (this.cRR == 1) {
                        this.cBJ.a(true, this.cMT.getUserData().getUserId(), this.cMT.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    }
                }
            }
        }
    }

    private void aoP() {
        if (this.cMT.getUserData() != null) {
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getPageContext().getString(n.i.user_icon_web_view_title), String.valueOf(cGm) + "?user_id=" + this.cMT.getUserData().getUserId(), true, true, true);
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10134").r("obj_type", 1));
        }
    }

    private void aoQ() {
        String format;
        String userName = this.cMT.getUserData() != null ? this.cMT.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(n.i.confirm, new ak(this));
            aVar.b(n.i.cancel, new al(this));
            if (this.cRI.getMaskType() == 1) {
                format = String.format(getPageContext().getString(n.i.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(n.i.block_chat_message_alert), userName);
            }
            aVar.cC(format);
            aVar.b(getPageContext());
            aVar.tv();
        }
    }

    private void aoR() {
        if (this.cMT.getUserData() != null && this.cMT.getUserData().getIsOfficialAccount() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.cMT.getUserData().getUserId(), 0L), this.cMT.getUserData().getUserName(), this.cMT.getUserData().getPortrait(), 0, 4)));
        } else if (this.mIsHost) {
            if (this.cMT.ajS() != null) {
                com.baidu.tbadk.browser.f.B(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
            }
        } else {
            PersonTainInfo apc = this.cMT.apc();
            if (apc != null) {
                int isFriend = apc.getIsFriend();
                if (isFriend == 0) {
                    UserData userData = this.cMT.getUserData();
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.cMT.apd(), apc.getUserClientVersionLower(), this.cMT.getStType())));
                    }
                } else if (isFriend == 1) {
                    UserData userData2 = this.cMT.getUserData();
                    if (userData2 != null) {
                        if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(n.i.login_to_chat), true, 11028)));
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
                    com.baidu.tbadk.newFriends.a.Ei().b(com.baidu.adp.lib.h.b.c(this.cMT.getId(), 0L), "pers_pg");
                }
            }
        }
    }

    public void aoS() {
        long j = com.baidu.tbadk.core.sharedPref.b.tZ().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
        if (this.cRH != null && this.cRH.cTo != null) {
            if (j < TbadkCoreApplication.m411getInst().getLastUpdateThemeTime()) {
                com.baidu.tbadk.core.util.as.c(this.cRH.cTo, n.e.icon_news_down_bar_one);
                this.cRH.cTo.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.tZ().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
                if (!isPrimary()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true)));
                }
            } else if (this.cRH.cTo != null) {
                this.cRH.cTo.setImageDrawable(null);
                this.cRH.cTo.setVisibility(8);
            }
        }
    }

    public void a(View view, boolean z, int i) {
        this.cRL.setVisibility(0);
        this.cRL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this).setOnClickListener(this);
        if (this.cRU == null) {
            if (i < 0) {
                this.cRU = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.cRU = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.cRU.tH();
        }
        this.cRU.b(view, z);
    }

    public void ao(View view) {
        this.cRL.setVisibility(8);
        if (this.cRU != null) {
            this.cRU.v(view);
            this.cRU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        this.cRL.setVisibility(0);
        this.cRL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this).setOnClickListener(this);
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new an(this));
        }
        this.refreshView.eB(getResources().getDimensionPixelSize(n.d.ds160));
        this.refreshView.fL(str);
        this.refreshView.b(view, z);
        this.refreshView.Dn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TI() {
        this.cRL.setVisibility(8);
        if (this.refreshView != null) {
            this.refreshView.v(this.cRM);
            this.refreshView = null;
        }
    }
}
