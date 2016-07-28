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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.Message;
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
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.u;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
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
public class h extends BaseFragment implements b.a, com.baidu.tbadk.mvc.c.a {
    private NoNetworkView EV;
    private BaseFragmentActivity aNO;
    private View axO;
    private com.baidu.tbadk.e.a bEk;
    private ViewEventCenter bgJ;
    private com.baidu.tbadk.core.view.b bvD;
    private boolean bvE;
    private PluginErrorTipView bvl;
    private com.baidu.tbadk.g.f cqy;
    private NavigationBar eAA;
    private FrameLayout eAB;
    private com.baidu.tieba.person.a.ar eAC;
    private List<com.baidu.adp.widget.ListView.v> eAE;
    public boolean eAI;
    private boolean eAK;
    public int eAL;
    private BdUniqueId eAN;
    private bq eAu;
    private BlackListModel eAv;
    private LinearLayout eAy;
    private NoNetworkView eAz;
    private com.baidu.adp.base.h ebn;
    private com.baidu.tbadk.core.view.h ebo;
    private bn ers;
    private com.baidu.tieba.person.god.i esG;
    private boolean mIsLogin;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tbadk.g.h refreshView;
    private static String eqD = "http://tieba.baidu.com/mo/q/godIntro";
    private static final String eiI = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    public static boolean eAw = false;
    private boolean eAt = false;
    private boolean ciS = true;
    private com.baidu.tieba.tbadkCore.d.b bwf = null;
    private boolean dCV = false;
    private boolean eAx = false;
    private String userId = "";
    private int eAD = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean eAF = true;
    private int eAG = -1;
    private String eAH = "";
    private String eAJ = "c10474";
    private boolean eAM = false;
    private final CustomMessageListener eAO = new i(this, CmdConfigCustom.CMD_YINJIN_CHANGE);
    private HttpMessageListener eAP = new t(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener eAQ = new ae(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private CustomMessageListener eAR = new ap(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);
    private Handler eAS = new Handler();
    private Runnable mRunnable = new ba(this);
    private com.baidu.adp.framework.listener.a eAT = new bg(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
    private CustomMessageListener bvK = new bh(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private final com.baidu.adp.framework.listener.a eAU = new bi(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e eAV = new bj(this, 104102);
    final com.baidu.adp.framework.listener.e eAW = new j(this, 304102);
    final CustomMessageListener eAX = new k(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener aPs = new l(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e eAY = new m(this, 304103);
    private final CustomMessageListener bcm = new n(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener dhL = new o(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener eAZ = new p(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private CustomMessageListener ebx = new q(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener eby = new r(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private final CustomMessageListener eBa = new s(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    final CustomMessageListener eBb = new u(this, CmdConfigCustom.CMD_BUY_YINJI_SUCCESS);
    private CustomMessageListener eBc = new v(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
    private CustomMessageListener eBd = new w(this, CmdConfigCustom.CMD_PHOTO_LIVE_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener eBe = new x(this, CmdConfigCustom.CMD_COLLECTION_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener dgK = new y(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener eBf = new z(this, CmdConfigCustom.CMD_PERSON_EXTRA_NEW);
    private CustomMessageListener eBg = new aa(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    private CustomMessageListener eBh = new ab(this, CmdConfigCustom.CMD_MY_ATTENTION_AND_FANS_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener exf = new ac(this, CmdConfigCustom.CMD_ECOMM_REFRESH_WINDOW_LIST);
    private CustomMessageListener ebz = new ad(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);

    public bn aPe() {
        return this.ers;
    }

    public ViewEventCenter aPf() {
        return this.bgJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aNO = getBaseFragmentActivity();
        this.bgJ = new ViewEventCenter();
        this.bgJ.addEventDelegate(this);
        this.eAI = this.aNO instanceof PersonInfoActivity;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aPl();
        r(bundle);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (!this.mIsLogin) {
            this.dCV = true;
        }
        this.ciS = this.ers.getIsSelf();
        this.userId = this.ers.getId();
        this.eAD = this.ers.aPT();
        registerListener();
        aPt();
        this.eAN = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.eAN;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.eAN);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eAN;
        userMuteCheckCustomMessage.setTag(this.eAN);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        if (!this.ciS && TbadkCoreApplication.isLogin()) {
            aPh();
        }
        this.ebn = getPageContext();
        this.ebo = new com.baidu.tbadk.core.view.h();
        this.ebo.abS = 1000L;
    }

    private void registerListener() {
        registerListener(this.bvK);
        registerListener(this.eAU);
        registerListener(this.eAV);
        registerListener(this.eAW);
        registerListener(this.eAX);
        registerListener(this.eAY);
        registerListener(this.aPs);
        registerListener(this.bcm);
        registerListener(this.eAP);
        registerListener(this.eAQ);
        registerListener(this.dhL);
        registerListener(this.eAO);
        registerListener(this.eAZ);
        registerListener(this.eBa);
        registerListener(this.eBb);
        registerListener(this.eBc);
        registerListener(this.eAR);
        registerListener(this.eAT);
        registerListener(this.eBd);
        registerListener(this.eBe);
        registerListener(this.dgK);
        registerListener(this.eBg);
        registerListener(this.eBh);
        registerListener(this.ebz);
        registerListener(this.ebx);
        registerListener(this.eby);
        registerListener(this.eBf);
        if (EcommSwitchStatic.Fr()) {
            registerListener(this.exf);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ers.aPG();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.axO = c(layoutInflater);
        this.eAC = new com.baidu.tieba.person.a.ar(this);
        if (this.ers != null) {
            this.eAB = (FrameLayout) this.axO.findViewById(u.g.root_layout);
            this.eAy = (LinearLayout) this.axO.findViewById(u.g.unlogin_no_network_root);
            this.eAz = (NoNetworkView) this.eAy.findViewById(u.g.view_unlogin_no_network);
            this.EV = (NoNetworkView) this.axO.findViewById(u.g.view_no_network);
            ((FrameLayout.LayoutParams) this.EV.getLayoutParams()).setMargins(0, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT), 0, 0);
            this.EV.a(new af(this));
            this.EV.setAlpha(0.95f);
            this.eAA = (NavigationBar) this.axO.findViewById(u.g.nologin_navigation_bar);
            if (!this.mIsLogin && this.ciS) {
                this.eAy.setVisibility(0);
                bc(this.axO);
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
            } else {
                this.eAy.setVisibility(8);
                Z(this.axO);
            }
            this.eAC.aNA();
            this.bvl = (PluginErrorTipView) this.axO.findViewById(u.g.view_plugin_error_tip);
            iz(true);
        }
        this.axO.setOnTouchListener(new ag(this));
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        return this.axO;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.ers != null && this.eAu != null && this.eAu.aQh() != null) {
            if (isPrimary()) {
                UserData userData = this.ers != null ? this.ers.getUserData() : null;
                if (this.eAu != null && this.eAu.aQh() != null) {
                    this.eAu.aQh().setBackBitmap(userData);
                }
            } else if (this.eAu != null && this.eAu.aQh() != null) {
                this.eAu.aQh().aOj();
            }
            if (this.eAC != null) {
                this.eAC.iq(isPrimary());
                this.eAC.aNC();
            }
            if (isPrimary() && com.baidu.adp.lib.util.i.fq()) {
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    int memberType = currentAccountObj.getMemberType();
                    if (memberType == 0) {
                        memberType = 0;
                    } else if (memberType > 0) {
                        memberType = 1;
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10407").s("obj_type", memberType));
                }
                if (!this.dCV && this.mIsLogin) {
                    a((View) this.eAB, false, -1);
                    this.ers.aPI();
                } else if (this.eAx) {
                    this.ers.aPI();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && TbadkCoreApplication.isLogin() && Boolean.valueOf(com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("need_show_yinji", true)).booleanValue() && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("need_show_yinji", false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ers != null && this.ers.aPV() && TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.tbadk.core.sharedPref.b.sN().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "god_enter_info_expand", false);
        }
        if (this.eAu != null) {
            this.eAu.onDestroy();
        }
        if (this.cqy != null) {
            this.cqy.K(this.axO);
            this.cqy = null;
        }
        if (this.ciS) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK));
        }
        this.eAS.removeCallbacks(this.mRunnable);
        if (this.eAC != null) {
            this.eAC.onDestroy();
        }
        if (this.bEk != null) {
            this.bEk.destory();
        }
        MessageManager.getInstance().unRegisterListener(this.ebz);
        MessageManager.getInstance().unRegisterListener(this.ebx);
        MessageManager.getInstance().unRegisterListener(this.eby);
        MessageManager.getInstance().unRegisterListener(this.eAN);
        super.onDestroy();
    }

    private void Z(View view) {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        if (this.eAA != null) {
            this.eAA.setVisibility(8);
        }
        this.eAu = new bq(this, this.ciS, this.bgJ, view);
        this.eAu.setPersonListRefreshListener(new ah(this));
        if (this.ciS) {
            this.ers.aPH();
        } else {
            a((View) this.eAB, false, -1);
            this.ers.aPI();
        }
        this.eAu.b(new ai(this));
        this.eAu.N(new aj(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPg() {
        if (this.eAu != null && this.ers != null && this.ers.aPV()) {
            this.esG.ok(this.ers.aPY());
            this.eAu.setOnSrollToBottomListener(new ak(this));
            this.esG.a(new al(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPh() {
        long c = com.baidu.adp.lib.h.b.c(this.ers.getId(), 0L);
        long c2 = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = c2;
        userMuteCheckCustomMessage.userIdT = c;
        userMuteCheckCustomMessage.mId = this.eAN;
        userMuteCheckCustomMessage.setTag(this.eAN);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.ListView.v vVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (vVar != null) {
            if (!com.baidu.adp.lib.util.k.fH()) {
                showToast(u.j.neterror);
            } else if (!this.ciS) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10617").ab("obj_id", this.userId));
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    c((com.baidu.tbadk.data.k) vVar, list, i);
                }
            } else if (vVar instanceof com.baidu.tieba.person.data.b) {
                aPi();
            } else if (vVar instanceof com.baidu.tbadk.data.k) {
                com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) vVar;
                if (kVar.AQ()) {
                    a(kVar, list, i);
                } else {
                    b(kVar, list, i);
                }
            }
        }
    }

    private void a(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (getPageContext() != null) {
            String[] strArr = {getPageContext().getString(u.j.hd_photo), getPageContext().getString(u.j.change_photo), getPageContext().getString(u.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            cVar.bP(u.j.operation);
            cVar.a(strArr, new am(this, kVar, list, i));
            cVar.d(getPageContext());
            cVar.rV();
        }
    }

    private void aPi() {
        if (getPageContext() != null) {
            String[] strArr = {getPageContext().getString(u.j.choose_local_photo), getPageContext().getString(u.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            cVar.bP(u.j.operation);
            cVar.a(strArr, new an(this));
            cVar.d(getPageContext());
            cVar.rV();
        }
    }

    private void b(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        String[] strArr = {getPageContext().getString(u.j.look_big_photo), getPageContext().getString(u.j.set_as_portrait_photo), getPageContext().getString(u.j.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bP(u.j.operation);
        cVar.a(strArr, new ao(this, kVar, list, i));
        cVar.d(getPageContext());
        cVar.rV();
    }

    private String oP(String str) {
        if ((isAdded() ? getResources() : TbadkCoreApplication.m10getInst().getResources()).getDisplayMetrics().densityDpi > 240.0f) {
            return "http://himg.baidu.com/sys/portraith/item/" + str;
        }
        return "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (kVar != null && list != null && !StringUtils.isNull(kVar.AP())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    com.baidu.tbadk.data.k kVar2 = (com.baidu.tbadk.data.k) vVar;
                    if (kVar2.AQ()) {
                        arrayList.add(oP(kVar2.AP()));
                    } else {
                        arrayList.add(kVar2.AP());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            if (getPageContext() != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPj() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.aNO.getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPk() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.aNO.getPageContext().getPageActivity(), 12014, this.eAF)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && !StringUtils.isNull(kVar.AP())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
            httpMessage.addParam("pic_url", kVar.AP());
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (kVar != null && list != null && list.size() > 2 && !StringUtils.isNull(kVar.AP())) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i != i2) {
                    com.baidu.adp.widget.ListView.v vVar = list.get(i2);
                    if (vVar instanceof com.baidu.tbadk.data.k) {
                        com.baidu.tbadk.data.k kVar2 = (com.baidu.tbadk.data.k) vVar;
                        if (!kVar2.AQ()) {
                            jSONArray.put(kVar2.AP());
                        }
                    }
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
    public void h(String str, List<com.baidu.adp.widget.ListView.v> list) {
        if (!StringUtils.isNull(str) && list != null) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.v vVar = list.get(i);
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) vVar;
                    if (!kVar.AQ()) {
                        jSONArray.put(kVar.AP());
                    }
                }
            }
            jSONArray.put(str);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
            httpMessage.addParam("pic_list", jSONArray.toString());
            sendMessage(httpMessage);
        }
    }

    private void aPl() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_USER_PICS, TbConfig.SET_USER_PICS);
        tbHttpMessageTask.setResponsedClass(SetUserPicsResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CHANGE_PORTRAIT, TbConfig.CHANGE_USER_PORTRAIT);
        tbHttpMessageTask2.setResponsedClass(ChangePortraitResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    private void s(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.eAF)));
            }
            this.writeImagesInfo.clear();
        }
    }

    private void g(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.ers.getUserData() != null && this.ciS) {
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.ers.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.CP().fO(this.ers.getUserData().getPortrait());
                }
            }
            this.eAx = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        g(intent);
                    } else {
                        s(intent);
                    }
                }
            } else if (i == 12010 || i == 12009) {
                if (intent != null) {
                    int intExtra = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra == 1) {
                        aPm();
                    } else if (intExtra == 2) {
                        aPp();
                    }
                }
            } else if (i == 12014) {
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra2 == 1) {
                        aPm();
                    } else if (intExtra2 == 2) {
                        aPp();
                    }
                }
            } else if (i == 24001) {
                if (intent != null && this.eAu != null) {
                    this.eAu.ahV();
                    this.eAu.aQh().setGiftIcon(false);
                }
            } else if (i == 24004 && intent != null && intent.getBooleanExtra(MissonDetailsActivityConfig.IS_UPGRADE_SUCCESS, false)) {
                com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).b(this);
            }
        }
    }

    private void aPm() {
        if (this.ers != null && this.ers.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.CP().fO(this.ers.getUserData().getPortrait());
        }
        this.eAx = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPn() {
        if (!this.eAK) {
            this.eAK = true;
            this.eAS.postDelayed(this.mRunnable, 300L);
        }
    }

    public boolean aPo() {
        return this.eAM;
    }

    public void iy(boolean z) {
        this.eAM = z;
    }

    private void aPp() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new aq(this));
    }

    private void aPq() {
        if (this.ers != null && this.ers.aPD() != null && this.eAv != null && this.eAu != null) {
            this.eAu.a(this.ers.aPD().getIsFriend() == 1, this.eAv.getMaskType() == 1, this.eAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.person.data.f fVar) {
        UserData userData = this.ers.getUserData();
        switch (fVar.mType) {
            case 0:
                if (com.baidu.tbadk.core.util.bn.ab(getPageContext().getPageActivity())) {
                    this.eAC.n(false, 3);
                    this.eAC.ir(true);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10597"));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(getActivity().getApplicationContext())));
                    return;
                }
                return;
            case 1:
                if (com.baidu.tbadk.core.util.bn.ab(getPageContext().getPageActivity())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10602"));
                    this.eAC.n(false, 1);
                    if (userData != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(getActivity().getApplicationContext())));
                        return;
                    }
                    return;
                }
                return;
            case 2:
                if (com.baidu.tbadk.core.util.bn.ab(getPageContext().getPageActivity())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10604"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(getActivity().getApplicationContext())));
                    return;
                }
                return;
            case 3:
                aPs();
                return;
            case 4:
                aPr();
                return;
            default:
                return;
        }
    }

    private void aPr() {
        if (com.baidu.tbadk.core.util.bn.ab(getPageContext().getPageActivity()) && this.ers != null) {
            UserData userData = this.ers.getUserData();
            if (this.ers.getIsSelf()) {
                TiebaStatic.log("person_self_attentionper_click");
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10600"));
            } else {
                TiebaStatic.log("person_guid_attentionper_click");
            }
            if (userData != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData.getUserId(), userData.getSex())));
            }
        }
    }

    private void aPs() {
        if (com.baidu.tbadk.core.util.bn.ab(getPageContext().getPageActivity()) && this.ers != null) {
            UserData userData = this.ers.getUserData();
            if (this.ers.getIsSelf()) {
                TiebaStatic.log("person_self_attentionme_click");
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10599"));
            } else {
                TiebaStatic.log("person_guid_attentionme_click");
            }
            this.eAC.n(false, 2);
            if (userData != null) {
                if (this.eAu != null) {
                    this.eAu.iC(false);
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData.getUserId(), userData.getSex())));
            }
        }
    }

    private View c(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(u.h.personinfo_tab_view, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    private void r(Bundle bundle) {
        this.ers = new bn(getBaseFragmentActivity());
        this.ers.aDa();
        this.ers.setPageId(getUniqueId());
        this.eAv = new BlackListModel(getPageContext());
        this.mPersonChangeData = new PersonChangeData();
        a(this.ers, bundle);
        this.ers.setLoadDataCallBack(new ar(this));
        this.esG = new com.baidu.tieba.person.god.i(getPageContext());
    }

    private void a(bn bnVar, Bundle bundle) {
        if (bundle != null) {
            bnVar.oS(bundle.getString("from"));
            String string = bundle.getString("un");
            bnVar.setId(string);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (string != null && currentAccount != null && string.equals(currentAccount)) {
                bnVar.setIsSelf(true);
            } else {
                bnVar.setIsSelf(false);
            }
            bnVar.setName(bundle.getString("name"));
            bnVar.iA(bundle.getBoolean("tab_page", false));
            bnVar.iB(bundle.getBoolean("tab_msg", false));
            bnVar.setStType(bundle.getString("st_type"));
            this.eAL = bundle.getInt(PersonInfoActivityConfig.FANS_NUM);
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getStringExtra("un") != null) {
            String stringExtra = intent.getStringExtra("un");
            bnVar.setId(stringExtra);
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && stringExtra.equals(currentAccount2)) {
                bnVar.setIsSelf(true);
            } else {
                bnVar.setIsSelf(false);
            }
            bnVar.setName(intent.getStringExtra("name"));
            bnVar.oS(intent.getStringExtra("from"));
            bnVar.iA(intent.getBooleanExtra("tab_page", false));
            bnVar.iB(intent.getBooleanExtra("tab_msg", false));
            bnVar.setStType(intent.getStringExtra("st_type"));
            this.eAL = intent.getIntExtra(PersonInfoActivityConfig.FANS_NUM, 0);
            return;
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        bnVar.setIsSelf(true);
        if (currentAccountObj != null) {
            bnVar.setId(currentAccountObj.getID());
            bnVar.setName(currentAccountObj.getAccount());
        }
    }

    private void bc(View view) {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(u.j.unlogin_person_button_text), new at(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds180);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(u.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(u.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(u.e.ds60);
        NoDataViewFactory.b a = NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(u.e.ds20));
        this.eAB.setVisibility(8);
        this.eAA.setVisibility(0);
        this.eAA.switchNaviBarStatus(this.mIsLogin);
        this.eAA.setLoginClickListener(new au(this));
        this.eAA.setRegisterClickListener(new av(this));
        this.mNoDataView = NoDataViewFactory.a(getActivity(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, u.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.u(u.j.unlogin_person_msg_text, dimensionPixelSize4), a);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m10getInst().getSkinType());
    }

    private void aPt() {
        if (this.bwf == null) {
            this.bwf = new com.baidu.tieba.tbadkCore.d.b("profileStat");
            this.bwf.start();
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Dr = bVar.Dr();
        bVar.Ds();
        switch (Dr) {
            case 1:
                aPs();
                return true;
            case 2:
                aPr();
                return true;
            case 3:
                aPv();
                return true;
            case 4:
                aPx();
                return true;
            case 5:
                com.baidu.tbadk.core.util.bi.us().c(getPageContext(), new String[]{eqD});
                return true;
            default:
                return false;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean kN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.av.l(this.axO, u.d.cp_bg_line_d);
        if (this.EV != null) {
            this.EV.onChangeSkinType(getPageContext(), i);
        }
        if (this.eAz != null) {
            this.eAz.onChangeSkinType(getPageContext(), i);
        }
        if (this.eAu != null) {
            this.eAu.onChangeSkinType(i);
        }
        if (this.eAA != null) {
            this.eAA.onChangeSkinType(getPageContext(), i);
        }
        if (this.bvl != null) {
            this.bvl.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public com.baidu.tieba.person.a.ar aPu() {
        return this.eAC;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        UserData userData;
        String str;
        if (this.eAu != null) {
            if (this.eAu.aQp() != null && view.getId() == this.eAu.aQp().getId()) {
                this.aNO.finish();
                return;
            }
            this.ers.getIsSelf();
            String id = this.ers.getId();
            if (view.getId() == this.eAu.getHeadImage().getId()) {
                UserData userData2 = this.ers.getUserData();
                if (userData2 != null) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.fa(userData2.getPortraitH());
                    kVar.fb(userData2.getPortrait());
                    kVar.bq(true);
                    List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
                    arrayList.add(kVar);
                    if (this.ciS) {
                        a(kVar, arrayList, 0);
                    } else {
                        c(kVar, arrayList, 0);
                    }
                }
            } else if (this.eAu.aQo() != null && view.getId() == this.eAu.aQo().getId()) {
                if (!this.ciS) {
                    if (id != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10623").ab("obj_id", id));
                    }
                    aPq();
                }
            } else if (view.getId() == this.eAu.aQh().getVipIcon().getId()) {
                TiebaStatic.log(this.eAJ);
                if (com.baidu.tbadk.core.util.bn.ab(getActivity())) {
                    UserIconBox vipIcon = this.eAu.aQh().getVipIcon();
                    if ((vipIcon.getTag() instanceof String) && (str = (String) vipIcon.getTag()) != null) {
                        com.baidu.tbadk.core.util.bi.us().c(getPageContext(), new String[]{str});
                    }
                }
            } else if (view.getId() == this.eAu.getAttentionView().getId()) {
                if (this.ers != null && this.ers.aPB() != null && this.ers.aPB().getGodType() == 2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10803").s("obj_locate", 5).ab("obj_id", new StringBuilder(String.valueOf(this.ers.getId())).toString()));
                }
                if (com.baidu.tbadk.core.util.bn.ab(getActivity())) {
                    this.ers.aPF();
                }
            } else if (view.getId() == this.eAu.aQi().getId()) {
                aPx();
            } else if (view.getId() == this.eAu.getUserIcon().getId()) {
                aPv();
            } else if (view.getId() == this.eAu.aQh().getMyGiftIcon().getId()) {
                TiebaStatic.log("igift_icon_ck");
                if (com.baidu.tbadk.core.util.bn.ab(getActivity()) && (userData = this.ers.getUserData()) != null) {
                    if (!com.baidu.adp.lib.util.k.fH()) {
                        showToast(u.j.no_signall_data);
                        return;
                    }
                    this.eAt = true;
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10613").ab("obj_id", id).s("obj_param1", this.eAD));
                    sendMessage(new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData.getUserIdLong(), userData.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001)));
                    this.eAu.aQh().setGiftIcon(true);
                }
            } else if (view.getId() == this.eAu.getMyGiftIcon().getId()) {
                if (com.baidu.tbadk.core.util.bn.ab(getActivity())) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData3 = this.ers.getUserData();
                    if (userData3 != null) {
                        if (!com.baidu.adp.lib.util.k.fH()) {
                            showToast(u.j.no_signall_data);
                            return;
                        }
                        this.eAt = true;
                        sendMessage(new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData3.getUserIdLong(), userData3.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                    }
                }
            } else if (this.eAu.aNr() != null && view.getId() == this.eAu.aNr().getId()) {
                this.eAu.aQn();
                aPw();
            } else if (this.eAu.aNq() != null && view.getId() == this.eAu.aNq().getId()) {
                this.eAu.aQn();
                if (this.ers.getUserData() != null) {
                    com.baidu.tbadk.newFriends.a.Eg().M(this.ers.getUserData().getUserIdLong());
                }
            } else if (this.eAu.aNs() != null && view.getId() == this.eAu.aNs().getId()) {
                this.eAu.aQn();
                if (this.ers != null) {
                    if (!com.baidu.adp.lib.util.i.fq()) {
                        showToast(u.j.neterror);
                    } else if (this.eAG == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, this.ers.getUserData().getUserId(), this.ers.getUserData().getUserName(), null, null, 0, this.eAH, this.eAN);
                        userMuteAddAndDelCustomMessage.mId = this.eAN;
                        a(false, userMuteAddAndDelCustomMessage, this.eAH, this.ers.getUserData().getUserName());
                    } else if (this.eAG == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, this.ers.getUserData().getUserId(), this.ers.getUserData().getUserName(), null, null, 0, this.eAH, this.eAN);
                        userMuteAddAndDelCustomMessage2.mId = this.eAN;
                        a(true, userMuteAddAndDelCustomMessage2, (String) null, this.ers.getUserData().getUserName());
                    }
                }
            } else if (view.getId() == this.eAu.aQh().getExpandImg().getId()) {
                String bg_pic = this.ers.getUserData().getBg_pic();
                try {
                    i = com.baidu.adp.lib.h.b.g(oQ(bg_pic).get("props_id"), -1);
                } catch (URISyntaxException e) {
                    i = -1;
                }
                if (this.ciS || i == -1) {
                    if (getActivity() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(getActivity())));
                        return;
                    }
                    return;
                }
                int i2 = 0;
                if (!TbadkCoreApplication.isLogin()) {
                    i2 = 0;
                } else {
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo == null || StringUtils.isNull(bg_pic) || StringUtils.isNull(currentAccountInfo.getPersonalBgUrl())) {
                        i2 = 0;
                    } else if (bg_pic.equalsIgnoreCase(currentAccountInfo.getPersonalBgUrl())) {
                        i2 = 1;
                    }
                }
                if (getActivity() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(getActivity(), i, i2)));
                }
            }
        }
    }

    private Map<String, String> oQ(final String str) throws URISyntaxException {
        return new HashMap<String, String>(str) { // from class: com.baidu.tieba.personInfo.PersonInfoFragment$45
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), "UTF-8")) {
                    put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        };
    }

    private void aPv() {
        if (this.ers.getUserData() != null) {
            boolean isSelf = this.ers.getIsSelf();
            String id = this.ers.getId();
            if (isSelf) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10603"));
            } else if (id != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10607").ab("obj_id", id));
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getPageContext().getString(u.j.user_icon_web_view_title), String.valueOf(eiI) + "?user_id=" + this.ers.getUserData().getUserId(), true, true, true);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10134").s("obj_type", 1));
        }
    }

    private void aPw() {
        String format;
        String userName = this.ers.getUserData() != null ? this.ers.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(u.j.confirm, new aw(this));
            aVar.b(u.j.cancel, new ax(this));
            if (this.eAv.getMaskType() == 1) {
                format = String.format(getPageContext().getString(u.j.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(u.j.block_chat_message_alert), userName);
            }
            aVar.cz(format);
            aVar.b(getPageContext());
            aVar.rS();
        }
    }

    private void aPx() {
        if (com.baidu.tbadk.core.util.bn.ab(getActivity())) {
            if (this.userId != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10622").ab("obj_id", this.userId));
            }
            if (this.ers.getUserData() != null && this.ers.getUserData().getIsOfficialAccount() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.ers.getUserData().getUserId(), 0L), this.ers.getUserData().getUserName(), this.ers.getUserData().getPortrait(), 0, 4)));
            } else if (this.ciS) {
                if (this.ers.getAntiData() != null) {
                    com.baidu.tbadk.browser.f.u(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
                }
            } else {
                PersonTainInfo aPD = this.ers.aPD();
                if (aPD != null) {
                    int isFriend = aPD.getIsFriend();
                    if (this.ers.aPV()) {
                        a(this.ers.getUserData(), isFriend);
                    } else if (isFriend == 0) {
                        UserData userData = this.ers.getUserData();
                        if (userData != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.ers.aPE(), aPD.getUserClientVersionLower(), this.ers.getStType())));
                        }
                    } else if (isFriend == 1) {
                        UserData userData2 = this.ers.getUserData();
                        if (userData2 != null) {
                            if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(u.j.login_to_chat), true, 11028)));
                            } else if (!this.ciS) {
                                a(userData2, isFriend);
                            }
                        }
                    } else if (isFriend == 2) {
                        com.baidu.tbadk.newFriends.a.Eg().b(com.baidu.adp.lib.h.b.c(this.ers.getId(), 0L), "pers_pg");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bEk == null) {
                this.bEk = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bEk.ap(updateAttentionMessage.getData().toUid, null);
        }
    }

    public void aPy() {
        long j = com.baidu.tbadk.core.sharedPref.b.sN().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
        if (this.eAu != null && this.eAu.eCr != null) {
            if (j < TbadkCoreApplication.m10getInst().getLastUpdateThemeTime()) {
                com.baidu.tbadk.core.util.av.c(this.eAu.eCr, u.f.icon_news_down_bar_one);
                this.eAu.eCr.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.sN().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
                if (!isPrimary()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true)));
                }
            } else if (this.eAu.eCr != null) {
                this.eAu.eCr.setImageDrawable(null);
                this.eAu.eCr.setVisibility(8);
            }
        }
    }

    public void a(View view, boolean z, int i) {
        if (this.cqy == null) {
            if (i < 0) {
                this.cqy = new com.baidu.tbadk.g.f(getActivity());
            } else {
                this.cqy = new com.baidu.tbadk.g.f(getActivity(), i);
            }
            this.cqy.sd();
        }
        this.cqy.c(view, z);
    }

    public void au(View view) {
        if (this.cqy != null) {
            this.cqy.K(view);
            this.cqy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        this.eAA.setVisibility(0);
        this.eAA.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this).setOnClickListener(this);
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.g.h(getPageContext().getPageActivity(), new ay(this));
        }
        this.refreshView.eF(getResources().getDimensionPixelSize(u.e.ds160));
        this.refreshView.fV(str);
        this.refreshView.c(view, z);
        this.refreshView.Dh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IL() {
        this.eAA.setVisibility(8);
        if (this.refreshView != null) {
            this.refreshView.K(this.eAB);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPz() {
        if (this.ers != null) {
            this.ers.aPS();
            if (this.eAu != null && this.eAu.eCE != null) {
                this.eAu.eCE.ap(this.ers.getDataList());
                this.eAu.eCE.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.b.b.a
    public void a(boolean z, int i, int i2, com.baidu.tbadk.core.data.ab abVar) {
        if (z && i2 == 100) {
            this.ers.b(abVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a011";
    }

    public void iz(boolean z) {
        if (this.bvl != null && (this.bvl.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            if (z && UtilHelper.canUseStyleImmersiveSticky()) {
                ((ViewGroup.MarginLayoutParams) this.bvl.getLayoutParams()).setMargins(0, UtilHelper.getStatusBarHeight(), 0, 0);
                this.bvl.requestLayout();
                return;
            }
            ((ViewGroup.MarginLayoutParams) this.bvl.getLayoutParams()).setMargins(0, 0, 0, 0);
            this.bvl.requestLayout();
        }
    }

    private void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            atw();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ebn.getPageActivity());
        if (com.baidu.tbadk.core.util.ba.isEmpty(str)) {
            aVar.cz(this.ebn.getResources().getString(u.j.block_mute_message_alert, str2));
        } else {
            aVar.cz(str);
        }
        aVar.a(u.j.confirm, new az(this, userMuteAddAndDelCustomMessage));
        aVar.b(u.j.cancel, new bb(this));
        aVar.b(this.ebn).rS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atw() {
        if (this.bvD == null) {
            this.bvD = new com.baidu.tbadk.core.view.b(getPageContext());
            this.bvD.c(new bc(this));
        }
        this.bvD.aE(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ebn.getPageActivity());
        aVar.cz(str);
        aVar.b(u.j.know, new bd(this));
        aVar.b(this.ebn).rS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cz(getResources().getString(u.j.mute_is_super_member_function));
        aVar.a(u.j.open_now, new be(this));
        aVar.b(u.j.cancel, new bf(this));
        aVar.b(this.ebn).rS();
    }
}
