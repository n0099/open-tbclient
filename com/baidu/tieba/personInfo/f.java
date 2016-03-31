package com.baidu.tieba.personInfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.b.b;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.data.PersonListActivityConfig;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.k;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class f extends BaseFragment implements b.a, com.baidu.tbadk.mvc.c.a {
    private NoNetworkView NZ;
    private View aAh;
    private BaseFragmentActivity aNm;
    private ViewEventCenter bbj;
    private boolean bbm;
    private com.baidu.tbadk.f.f cFK;
    private FrameLayout dCA;
    private com.baidu.tieba.person.a.al dCB;
    private List<com.baidu.tbadk.data.h> dCD;
    public boolean dCH;
    private boolean dCJ;
    public int dCK;
    private bi dCt;
    private BlackListModel dCu;
    private LinearLayout dCx;
    private NoNetworkView dCy;
    private NavigationBar dCz;
    private UserMuteAddAndDelModel dgD;
    private com.baidu.tieba.usermute.k dgE;
    private bf dvN;
    private com.baidu.tieba.person.god.h dwQ;
    private boolean mIsLogin;
    private com.baidu.tbadk.core.view.p mNoDataView;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tbadk.f.h refreshView;
    private static String dvl = "http://tieba.baidu.com/mo/q/godIntro";
    private static final String dnv = String.valueOf(com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    public static boolean dCv = false;
    private boolean dCs = false;
    private boolean bIP = true;
    private com.baidu.tieba.tbadkCore.d.b bbO = null;
    private boolean dbx = false;
    private boolean dCw = false;
    private String userId = "";
    private int dCC = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean dCE = true;
    private int dCF = -1;
    private String dCG = "";
    private String dCI = "c10474";
    private final CustomMessageListener dCL = new g(this, CmdConfigCustom.CMD_YINJIN_CHANGE);
    private HttpMessageListener dCM = new r(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener dCN = new ac(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private CustomMessageListener dCO = new an(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);
    private Handler dCP = new Handler();
    private Runnable mRunnable = new ax(this);
    private com.baidu.adp.framework.listener.a dCQ = new ay(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
    private CustomMessageListener bbt = new az(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private final com.baidu.adp.framework.listener.a dCR = new ba(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e dCS = new bb(this, 104102);
    final com.baidu.adp.framework.listener.e dCT = new h(this, 304102);
    final CustomMessageListener dCU = new i(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener aOQ = new j(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e dCV = new k(this, 304103);
    private final CustomMessageListener bkX = new l(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener cyr = new m(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private k.a dgZ = new n(this);
    private final CustomMessageListener dCW = new o(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private UserMuteAddAndDelModel.a dgY = new p(this);
    private UserMuteAddAndDelModel.b dCX = new q(this);
    private final CustomMessageListener dCY = new s(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    final CustomMessageListener dCZ = new t(this, CmdConfigCustom.CMD_BUY_YINJI_SUCCESS);
    private CustomMessageListener dDa = new u(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
    private CustomMessageListener dDb = new v(this, CmdConfigCustom.CMD_PHOTO_LIVE_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener dDc = new w(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener dDd = new x(this, CmdConfigCustom.CMD_FORUMFEED_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener dDe = new y(this, CmdConfigCustom.CMD_COLLECTION_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener cxt = new z(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener dDf = new aa(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    private CustomMessageListener dDg = new ab(this, CmdConfigCustom.CMD_FORUM_FEED_SWITCH_CHANGE);

    public bf aCH() {
        return this.dvN;
    }

    public ViewEventCenter aCI() {
        return this.bbj;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aNm = getBaseFragmentActivity();
        this.bbj = new ViewEventCenter();
        this.bbj.addEventDelegate(this);
        this.dCH = this.aNm instanceof PersonInfoActivity;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aCO();
        r(bundle);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (!this.mIsLogin) {
            this.dbx = true;
        }
        this.bIP = this.dvN.getIsSelf();
        this.userId = this.dvN.getId();
        this.dCC = this.dvN.aDw();
        registerListener();
        aCV();
        if (!this.bIP && TbadkCoreApplication.isLogin()) {
            aCK();
        }
    }

    private void registerListener() {
        registerListener(this.bbt);
        registerListener(this.dCR);
        registerListener(this.dCS);
        registerListener(this.dCT);
        registerListener(this.dCU);
        registerListener(this.dCV);
        registerListener(this.aOQ);
        registerListener(this.bkX);
        registerListener(this.dCM);
        registerListener(this.dCN);
        registerListener(this.cyr);
        registerListener(this.dCL);
        registerListener(this.dCW);
        registerListener(this.dCY);
        registerListener(this.dCZ);
        registerListener(this.dDa);
        registerListener(this.dCO);
        registerListener(this.dCQ);
        registerListener(this.dDb);
        registerListener(this.dDe);
        registerListener(this.cxt);
        registerListener(this.dDc);
        registerListener(this.dDd);
        registerListener(this.dDf);
        registerListener(this.dDg);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dvN.aDi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aAh = c(layoutInflater);
        this.dCB = new com.baidu.tieba.person.a.al(this);
        if (this.dvN != null) {
            this.dCA = (FrameLayout) this.aAh.findViewById(t.g.root_layout);
            this.dCx = (LinearLayout) this.aAh.findViewById(t.g.unlogin_no_network_root);
            this.dCy = (NoNetworkView) this.dCx.findViewById(t.g.view_unlogin_no_network);
            this.NZ = (NoNetworkView) this.aAh.findViewById(t.g.view_no_network);
            this.NZ.a(new ad(this));
            this.NZ.setAlpha(0.95f);
            this.dCz = (NavigationBar) this.aAh.findViewById(t.g.nologin_navigation_bar);
            if (!this.mIsLogin && this.bIP) {
                this.dCx.setVisibility(0);
                aR(this.aAh);
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
            } else {
                this.dCx.setVisibility(8);
                V(this.aAh);
            }
            this.dCB.aBK();
        }
        this.aAh.setOnTouchListener(new ae(this));
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return this.aAh;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.dvN != null && this.dCt != null && this.dCt.aDK() != null) {
            if (isPrimary()) {
                UserData userData = this.dvN != null ? this.dvN.getUserData() : null;
                if (this.dCt != null && this.dCt.aDK() != null) {
                    this.dCt.aDK().setBackBitmap(userData);
                }
            } else if (this.dCt != null && this.dCt.aDK() != null) {
                this.dCt.aDK().aCr();
            }
            if (this.dCB != null) {
                this.dCB.gG(isPrimary());
                this.dCB.aBM();
            }
            if (isPrimary() && com.baidu.adp.lib.util.i.jf()) {
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    int memberType = currentAccountObj.getMemberType();
                    if (memberType == 0) {
                        memberType = 0;
                    } else if (memberType > 0) {
                        memberType = 1;
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10407").r("obj_type", memberType));
                }
                if (!this.dbx && this.mIsLogin) {
                    a((View) this.dCA, false, -1);
                    this.dvN.aDk();
                } else if (this.dCw) {
                    this.dvN.aDk();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && TbadkCoreApplication.isLogin() && Boolean.valueOf(com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("need_show_yinji", true)).booleanValue() && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("need_show_yinji", false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dvN != null && this.dvN.aDy()) {
            com.baidu.tbadk.core.sharedPref.b.vk().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "god_enter_info_expand", false);
        }
        this.dgE.onDestroy();
        this.dgD.onDestory();
        if (this.dCt != null) {
            this.dCt.onDestroy();
        }
        if (this.cFK != null) {
            this.cFK.K(this.aAh);
            this.cFK = null;
        }
        if (this.bIP) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK));
        }
        this.dCP.removeCallbacks(this.mRunnable);
        if (this.dCB != null) {
            this.dCB.onDestroy();
        }
        super.onDestroy();
    }

    private void V(View view) {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        if (this.dCz != null) {
            this.dCz.setVisibility(8);
        }
        this.dCt = new bi(this, this.bIP, this.bbj, view);
        this.dCt.setPersonListRefreshListener(new af(this));
        if (this.bIP) {
            this.dvN.aDj();
        } else {
            a((View) this.dCA, false, -1);
            this.dvN.aDk();
        }
        this.dCt.b(new ag(this));
        this.dCt.Q(new ah(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCJ() {
        if (this.dCt != null && this.dvN != null && this.dvN.aDy()) {
            this.dwQ.mG(this.dvN.aDB());
            this.dCt.setOnSrollToBottomListener(new ai(this));
            this.dwQ.a(new aj(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCK() {
        long c = com.baidu.adp.lib.h.b.c(this.dvN.getId(), 0L);
        this.dgE.d(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.h hVar, List<com.baidu.tbadk.data.h> list, int i) {
        if (hVar != null) {
            if (!com.baidu.adp.lib.util.k.jw()) {
                showToast(t.j.neterror);
            } else if (!this.bIP) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10617").ac("obj_id", this.userId));
                d(hVar, list, i);
            } else if (hVar.isAdded()) {
                aCL();
            } else if (hVar.CM()) {
                b(hVar, list, i);
            } else {
                c(hVar, list, i);
            }
        }
    }

    private void b(com.baidu.tbadk.data.h hVar, List<com.baidu.tbadk.data.h> list, int i) {
        if (getPageContext() != null) {
            String[] strArr = {getPageContext().getString(t.j.hd_photo), getPageContext().getString(t.j.change_photo), getPageContext().getString(t.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            cVar.cd(t.j.operation);
            cVar.a(strArr, new ak(this, hVar, list, i));
            cVar.d(getPageContext());
            cVar.us();
        }
    }

    private void aCL() {
        if (getPageContext() != null) {
            String[] strArr = {getPageContext().getString(t.j.choose_local_photo), getPageContext().getString(t.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            cVar.cd(t.j.operation);
            cVar.a(strArr, new al(this));
            cVar.d(getPageContext());
            cVar.us();
        }
    }

    private void c(com.baidu.tbadk.data.h hVar, List<com.baidu.tbadk.data.h> list, int i) {
        String[] strArr = {getPageContext().getString(t.j.look_big_photo), getPageContext().getString(t.j.set_as_portrait_photo), getPageContext().getString(t.j.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.cd(t.j.operation);
        cVar.a(strArr, new am(this, hVar, list, i));
        cVar.d(getPageContext());
        cVar.us();
    }

    private String ms(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.h hVar, List<com.baidu.tbadk.data.h> list, int i) {
        if (hVar != null && list != null && !StringUtils.isNull(hVar.CL())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.tbadk.data.h hVar2 : list) {
                if (hVar2 != null && !hVar2.isAdded()) {
                    if (hVar2.CM()) {
                        arrayList.add(ms(hVar2.CL()));
                    } else {
                        arrayList.add(hVar2.CL());
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
    public void aCM() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.aNm.getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCN() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.aNm.getPageContext().getPageActivity(), 12014, this.dCE)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && !StringUtils.isNull(hVar.CL())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
            httpMessage.addParam("pic_url", hVar.CL());
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.data.h hVar, List<com.baidu.tbadk.data.h> list, int i) {
        if (hVar != null && list != null && list.size() > 2 && !StringUtils.isNull(hVar.CL())) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tbadk.data.h hVar2 = list.get(i2);
                if (hVar2 != null && !hVar2.isAdded() && !hVar2.CM() && i2 != i) {
                    jSONArray.put(hVar2.CL());
                }
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
            httpMessage.addParam("pic_list", jSONArray.toString());
            if (jSONArray.length() <= 0) {
                httpMessage.addParam("truncat", 1);
            } else {
                httpMessage.addParam("truncat", 0);
            }
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, List<com.baidu.tbadk.data.h> list) {
        if (!StringUtils.isNull(str) && list != null) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tbadk.data.h hVar = list.get(i);
                if (hVar != null && !hVar.isAdded() && !hVar.CM()) {
                    jSONArray.put(hVar.CL());
                }
            }
            jSONArray.put(str);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
            httpMessage.addParam("pic_list", jSONArray.toString());
            sendMessage(httpMessage);
        }
    }

    private void aCO() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_USER_PICS, TbConfig.SET_USER_PICS);
        tbHttpMessageTask.setResponsedClass(SetUserPicsResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CHANGE_PORTRAIT, TbConfig.CHANGE_USER_PORTRAIT);
        tbHttpMessageTask2.setResponsedClass(ChangePortraitResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    private void o(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.dCE)));
            }
            this.writeImagesInfo.clear();
        }
    }

    private void f(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.dvN.getUserData() != null && this.bIP) {
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.dvN.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.EO().fN(this.dvN.getUserData().getPortrait());
                }
            }
            this.dCw = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        f(intent);
                    } else {
                        o(intent);
                    }
                }
            } else if (i == 12010 || i == 12009) {
                if (intent != null) {
                    int intExtra = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra == 1) {
                        aCP();
                    } else if (intExtra == 2) {
                        aCR();
                    }
                }
            } else if (i == 12014) {
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra2 == 1) {
                        aCP();
                    } else if (intExtra2 == 2) {
                        aCR();
                    }
                }
            } else if (i == 24001) {
                if (intent != null && this.dCt != null) {
                    this.dCt.aiC();
                    this.dCt.aDK().setGiftIcon(false);
                }
            } else if (i == 24004 && intent != null && intent.getBooleanExtra(MissonDetailsActivityConfig.IS_UPGRADE_SUCCESS, false)) {
                com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).b(this);
            }
        }
    }

    private void aCP() {
        if (this.dvN != null && this.dvN.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.EO().fN(this.dvN.getUserData().getPortrait());
        }
        this.dCw = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCQ() {
        if (!this.dCJ) {
            this.dCJ = true;
            this.dCP.postDelayed(this.mRunnable, 300L);
        }
    }

    private void aCR() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new ao(this));
    }

    private void aCS() {
        if (this.dvN != null && this.dvN.aDf() != null && this.dCu != null && this.dCt != null) {
            this.dCt.a(this.dvN.aDf().getIsFriend() == 1, this.dCu.getMaskType() == 1, this.dCF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.person.data.d dVar) {
        UserData userData = this.dvN.getUserData();
        switch (dVar.mType) {
            case 0:
                if (com.baidu.tbadk.core.util.bl.ad(getPageContext().getPageActivity())) {
                    this.dCB.h(false, 3);
                    this.dCB.gH(true);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10597"));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(getActivity().getApplicationContext())));
                    return;
                }
                return;
            case 1:
                if (com.baidu.tbadk.core.util.bl.ad(getPageContext().getPageActivity())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10602"));
                    this.dCB.h(false, 1);
                    if (userData != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(getActivity().getApplicationContext())));
                        return;
                    }
                    return;
                }
                return;
            case 2:
                if (com.baidu.tbadk.core.util.bl.ad(getPageContext().getPageActivity())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10604"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(getActivity().getApplicationContext())));
                    return;
                }
                return;
            case 3:
                aCU();
                return;
            case 4:
                aCT();
                return;
            case 5:
                if (com.baidu.tbadk.core.util.bl.ad(getPageContext().getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void aCT() {
        if (com.baidu.tbadk.core.util.bl.ad(getPageContext().getPageActivity()) && this.dvN != null) {
            UserData userData = this.dvN.getUserData();
            if (this.dvN.getIsSelf()) {
                TiebaStatic.log("person_self_attentionper_click");
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10600"));
            } else {
                TiebaStatic.log("person_guid_attentionper_click");
            }
            if (userData != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData.getUserId(), userData.getSex())));
            }
        }
    }

    private void aCU() {
        if (com.baidu.tbadk.core.util.bl.ad(getPageContext().getPageActivity()) && this.dvN != null) {
            UserData userData = this.dvN.getUserData();
            if (this.dvN.getIsSelf()) {
                TiebaStatic.log("person_self_attentionme_click");
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10599"));
            } else {
                TiebaStatic.log("person_guid_attentionme_click");
            }
            this.dCB.h(false, 2);
            if (userData != null) {
                if (this.dCt != null) {
                    this.dCt.gT(false);
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData.getUserId(), userData.getSex())));
            }
        }
    }

    private View c(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(t.h.personinfo_tab_view, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    private void r(Bundle bundle) {
        this.dvN = new bf(getBaseFragmentActivity());
        this.dvN.aBD();
        this.dCu = new BlackListModel(getPageContext());
        this.mPersonChangeData = new PersonChangeData();
        a(this.dvN, bundle);
        this.dvN.setLoadDataCallBack(new ap(this));
        this.dgD = new UserMuteAddAndDelModel(getPageContext());
        this.dgD.a(this.dgY);
        this.dgD.a(this.dCX);
        this.dgE = new com.baidu.tieba.usermute.k(getPageContext(), this.dgZ);
        this.dwQ = new com.baidu.tieba.person.god.h(getPageContext());
    }

    private void a(bf bfVar, Bundle bundle) {
        if (bundle != null) {
            bfVar.mv(bundle.getString("from"));
            String string = bundle.getString("un");
            bfVar.setId(string);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (string != null && currentAccount != null && string.equals(currentAccount)) {
                bfVar.setIsSelf(true);
            } else {
                bfVar.setIsSelf(false);
            }
            bfVar.setName(bundle.getString("name"));
            bfVar.gR(bundle.getBoolean("tab_page", false));
            bfVar.gS(bundle.getBoolean("tab_msg", false));
            bfVar.setStType(bundle.getString("st_type"));
            this.dCK = bundle.getInt(PersonInfoActivityConfig.FANS_NUM);
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getStringExtra("un") != null) {
            String stringExtra = intent.getStringExtra("un");
            bfVar.setId(stringExtra);
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && stringExtra.equals(currentAccount2)) {
                bfVar.setIsSelf(true);
            } else {
                bfVar.setIsSelf(false);
            }
            bfVar.setName(intent.getStringExtra("name"));
            bfVar.mv(intent.getStringExtra("from"));
            bfVar.gR(intent.getBooleanExtra("tab_page", false));
            bfVar.gS(intent.getBooleanExtra("tab_msg", false));
            bfVar.setStType(intent.getStringExtra("st_type"));
            this.dCK = intent.getIntExtra(PersonInfoActivityConfig.FANS_NUM, 0);
            return;
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        bfVar.setIsSelf(true);
        if (currentAccountObj != null) {
            bfVar.setId(currentAccountObj.getID());
            bfVar.setName(currentAccountObj.getAccount());
        }
    }

    private void aR(View view) {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(t.j.unlogin_person_button_text), new ar(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds180);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(t.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(t.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(t.e.ds60);
        NoDataViewFactory.b a = NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(t.e.ds20));
        this.dCA.setVisibility(8);
        this.dCz.setVisibility(0);
        this.dCz.switchNaviBarStatus(this.mIsLogin);
        this.dCz.setLoginClickListener(new as(this));
        this.dCz.setRegisterClickListener(new at(this));
        this.mNoDataView = NoDataViewFactory.a(getActivity(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.u(t.j.unlogin_person_msg_text, dimensionPixelSize4), a);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void aCV() {
        if (this.bbO == null) {
            this.bbO = new com.baidu.tieba.tbadkCore.d.b("profileStat");
            this.bbO.start();
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Fr = bVar.Fr();
        bVar.Fs();
        switch (Fr) {
            case 1:
                aCU();
                return true;
            case 2:
                aCT();
                return true;
            case 3:
                aCX();
                return true;
            case 4:
                aCZ();
                return true;
            case 5:
                com.baidu.tbadk.core.util.bg.wM().c(getPageContext(), new String[]{dvl});
                return true;
            default:
                return false;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oB() {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.at.l(this.aAh, t.d.cp_bg_line_d);
        if (this.NZ != null) {
            this.NZ.onChangeSkinType(getPageContext(), i);
        }
        if (this.dCy != null) {
            this.dCy.onChangeSkinType(getPageContext(), i);
        }
        if (this.dCt != null) {
            this.dCt.onChangeSkinType(i);
        }
        if (this.dCz != null) {
            this.dCz.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public com.baidu.tieba.person.a.al aCW() {
        return this.dCB;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        AccountData currentAccountInfo;
        UserData userData;
        int i2 = 0;
        if (this.dCt != null) {
            if (this.dCt.aDR() != null && view.getId() == this.dCt.aDR().getId()) {
                this.aNm.finish();
                return;
            }
            this.dvN.getIsSelf();
            String id = this.dvN.getId();
            if (view.getId() == this.dCt.getHeadImage().getId()) {
                UserData userData2 = this.dvN.getUserData();
                if (userData2 != null) {
                    com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
                    hVar.eZ(userData2.getPortraitH());
                    hVar.fa(userData2.getPortrait());
                    hVar.bj(true);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(hVar);
                    if (this.bIP) {
                        b(hVar, arrayList, 0);
                    } else {
                        d(hVar, arrayList, 0);
                    }
                }
            } else if (this.dCt.aDQ() != null && view.getId() == this.dCt.aDQ().getId()) {
                if (!this.bIP) {
                    if (id != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10623").ac("obj_id", id));
                    }
                    aCS();
                }
            } else if (view.getId() == this.dCt.aDK().getVipIcon().getId()) {
                TiebaStatic.log(this.dCI);
                if (com.baidu.tbadk.core.util.bl.ad(getActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(getActivity())));
                }
            } else if (view.getId() == this.dCt.getAttentionView().getId()) {
                if (this.dvN != null && this.dvN.aDd() != null && this.dvN.aDd().getGodType() == 2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10803").r("obj_locate", 5).ac("obj_id", new StringBuilder(String.valueOf(this.dvN.getId())).toString()));
                }
                if (com.baidu.tbadk.core.util.bl.ad(getActivity())) {
                    this.dvN.aDh();
                }
            } else if (view.getId() == this.dCt.aDL().getId()) {
                aCZ();
            } else if (view.getId() == this.dCt.getUserIcon().getId()) {
                aCX();
            } else if (view.getId() == this.dCt.aDK().getMyGiftIcon().getId()) {
                TiebaStatic.log("igift_icon_ck");
                if (com.baidu.tbadk.core.util.bl.ad(getActivity()) && (userData = this.dvN.getUserData()) != null) {
                    if (!com.baidu.adp.lib.util.k.jw()) {
                        showToast(t.j.no_signall_data);
                        return;
                    }
                    this.dCs = true;
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10613").ac("obj_id", id).r("obj_param1", this.dCC));
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData.getUserIdLong(), userData.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001)));
                    this.dCt.aDK().setGiftIcon(true);
                }
            } else if (view.getId() == this.dCt.getMyGiftIcon().getId()) {
                if (com.baidu.tbadk.core.util.bl.ad(getActivity())) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData3 = this.dvN.getUserData();
                    if (userData3 != null) {
                        if (!com.baidu.adp.lib.util.k.jw()) {
                            showToast(t.j.no_signall_data);
                            return;
                        }
                        this.dCs = true;
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData3.getUserIdLong(), userData3.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                    }
                }
            } else if (this.dCt.aBz() != null && view.getId() == this.dCt.aBz().getId()) {
                this.dCt.aDP();
                aCY();
            } else if (this.dCt.aBy() != null && view.getId() == this.dCt.aBy().getId()) {
                this.dCt.aDP();
                if (this.dvN.getUserData() != null) {
                    com.baidu.tbadk.newFriends.a.Gf().N(this.dvN.getUserData().getUserIdLong());
                }
            } else if (this.dCt.aBA() != null && view.getId() == this.dCt.aBA().getId()) {
                this.dCt.aDP();
                if (this.dvN != null) {
                    if (!com.baidu.adp.lib.util.i.jf()) {
                        showToast(t.j.neterror);
                    } else if (this.dCF == 0) {
                        this.dgD.a(false, this.dvN.getUserData().getUserId(), this.dvN.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo, this.dCG);
                    } else if (this.dCF == 1) {
                        this.dgD.a(true, this.dvN.getUserData().getUserId(), this.dvN.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    }
                }
            } else if (view.getId() == this.dCt.aDK().getExpandImg().getId()) {
                String bg_pic = this.dvN.getUserData().getBg_pic();
                try {
                    i = com.baidu.adp.lib.h.b.g(mt(bg_pic).get("props_id"), -1);
                } catch (URISyntaxException e) {
                    i = -1;
                }
                if (this.bIP || i == -1) {
                    if (getActivity() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(getActivity())));
                        return;
                    }
                    return;
                }
                if (TbadkCoreApplication.isLogin() && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null && !StringUtils.isNull(bg_pic) && !StringUtils.isNull(currentAccountInfo.getPersonalBgUrl()) && bg_pic.equalsIgnoreCase(currentAccountInfo.getPersonalBgUrl())) {
                    i2 = 1;
                }
                if (getActivity() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(getActivity(), i, i2)));
                }
            }
        }
    }

    private Map<String, String> mt(final String str) {
        return new HashMap<String, String>(str) { // from class: com.baidu.tieba.personInfo.PersonInfoFragment$45
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), "UTF-8")) {
                    put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        };
    }

    private void aCX() {
        if (this.dvN.getUserData() != null) {
            boolean isSelf = this.dvN.getIsSelf();
            String id = this.dvN.getId();
            if (isSelf) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10603"));
            } else if (id != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10607").ac("obj_id", id));
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getPageContext().getString(t.j.user_icon_web_view_title), String.valueOf(dnv) + "?user_id=" + this.dvN.getUserData().getUserId(), true, true, true);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10134").r("obj_type", 1));
        }
    }

    private void aCY() {
        String format;
        String userName = this.dvN.getUserData() != null ? this.dvN.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(t.j.confirm, new au(this));
            aVar.b(t.j.cancel, new av(this));
            if (this.dCu.getMaskType() == 1) {
                format = String.format(getPageContext().getString(t.j.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(t.j.block_chat_message_alert), userName);
            }
            aVar.cC(format);
            aVar.b(getPageContext());
            aVar.up();
        }
    }

    private void aCZ() {
        if (com.baidu.tbadk.core.util.bl.ad(getActivity())) {
            if (this.userId != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10622").ac("obj_id", this.userId));
            }
            if (this.dvN.getUserData() != null && this.dvN.getUserData().getIsOfficialAccount() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.dvN.getUserData().getUserId(), 0L), this.dvN.getUserData().getUserName(), this.dvN.getUserData().getPortrait(), 0, 4)));
            } else if (this.bIP) {
                if (this.dvN.amu() != null) {
                    com.baidu.tbadk.browser.f.s(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
                }
            } else {
                PersonTainInfo aDf = this.dvN.aDf();
                if (aDf != null) {
                    int isFriend = aDf.getIsFriend();
                    if (this.dvN.aDy()) {
                        a(this.dvN.getUserData(), isFriend);
                    } else if (isFriend == 0) {
                        UserData userData = this.dvN.getUserData();
                        if (userData != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.dvN.aDg(), aDf.getUserClientVersionLower(), this.dvN.getStType())));
                        }
                    } else if (isFriend == 1) {
                        UserData userData2 = this.dvN.getUserData();
                        if (userData2 != null) {
                            if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(t.j.login_to_chat), true, 11028)));
                            } else if (!this.bIP) {
                                a(userData2, isFriend);
                            }
                        }
                    } else if (isFriend == 2) {
                        com.baidu.tbadk.newFriends.a.Gf().b(com.baidu.adp.lib.h.b.c(this.dvN.getId(), 0L), "pers_pg");
                    }
                }
            }
        }
    }

    private void a(UserData userData, int i) {
        if (userData != null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "enter_chat", "personclick", 1, new Object[0]);
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getPortrait(), userData.getSex(), i)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void aDa() {
        long j = com.baidu.tbadk.core.sharedPref.b.vk().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
        if (this.dCt != null && this.dCt.dEm != null) {
            if (j < TbadkCoreApplication.m411getInst().getLastUpdateThemeTime()) {
                com.baidu.tbadk.core.util.at.c(this.dCt.dEm, t.f.icon_news_down_bar_one);
                this.dCt.dEm.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.vk().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
                if (!isPrimary()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true)));
                }
            } else if (this.dCt.dEm != null) {
                this.dCt.dEm.setImageDrawable(null);
                this.dCt.dEm.setVisibility(8);
            }
        }
    }

    public void a(View view, boolean z, int i) {
        this.dCz.setVisibility(0);
        this.dCz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this).setOnClickListener(this);
        if (this.cFK == null) {
            if (i < 0) {
                this.cFK = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.cFK = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.cFK.uA();
        }
        this.cFK.c(view, z);
    }

    public void aD(View view) {
        this.dCz.setVisibility(8);
        if (this.cFK != null) {
            this.cFK.K(view);
            this.cFK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        this.dCz.setVisibility(0);
        this.dCz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this).setOnClickListener(this);
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new aw(this));
        }
        this.refreshView.eV(getResources().getDimensionPixelSize(t.e.ds160));
        this.refreshView.fU(str);
        this.refreshView.c(view, z);
        this.refreshView.Fh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XY() {
        this.dCz.setVisibility(8);
        if (this.refreshView != null) {
            this.refreshView.K(this.dCA);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDb() {
        if (this.dvN != null) {
            this.dvN.aDv();
            if (this.dCt != null && this.dCt.dEz != null) {
                this.dCt.dEz.ab(this.dvN.getDataList());
                this.dCt.dEz.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.b.b.a
    public void a(boolean z, int i, int i2, com.baidu.tbadk.core.data.w wVar) {
        if (z && i2 == 100) {
            this.dvN.b(wVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a011";
    }
}
