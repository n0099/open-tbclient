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
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
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
public class f extends BaseFragment implements b.a, com.baidu.tbadk.mvc.c.a {
    private NoNetworkView Ev;
    private BaseFragmentActivity aMU;
    private View axa;
    private com.baidu.tbadk.e.a bDd;
    private ViewEventCenter bfx;
    private PluginErrorTipView bsW;
    private com.baidu.tbadk.core.view.b btp;
    private boolean btq;
    private com.baidu.tbadk.g.f cok;
    private com.baidu.adp.base.h dPa;
    private com.baidu.tbadk.core.view.h dPb;
    private bp eht;
    private com.baidu.tieba.person.god.i eiC;
    private bs eoE;
    private BlackListModel eoF;
    private LinearLayout eoI;
    private NoNetworkView eoJ;
    private NavigationBar eoK;
    private FrameLayout eoL;
    private com.baidu.tieba.person.a.at eoM;
    private List<com.baidu.adp.widget.ListView.v> eoO;
    public boolean eoS;
    private boolean eoU;
    public int eoV;
    private BdUniqueId eoX;
    private boolean mIsLogin;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tbadk.g.h refreshView;
    private static String egE = "http://tieba.baidu.com/mo/q/godIntro";
    private static final String dWf = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    public static boolean eoG = false;
    private boolean eoD = false;
    private boolean cgJ = true;
    private com.baidu.tieba.tbadkCore.d.b btR = null;
    private boolean dyP = false;
    private boolean eoH = false;
    private String userId = "";
    private int eoN = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean eoP = true;
    private int eoQ = -1;
    private String eoR = "";
    private String eoT = "c10474";
    private boolean eoW = false;
    private final CustomMessageListener eoY = new g(this, CmdConfigCustom.CMD_YINJIN_CHANGE);
    private HttpMessageListener eoZ = new r(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener epa = new ac(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private CustomMessageListener epb = new an(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);
    private Handler epc = new Handler();
    private Runnable mRunnable = new ay(this);
    private com.baidu.adp.framework.listener.a epd = new bi(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
    private CustomMessageListener btw = new bj(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private final com.baidu.adp.framework.listener.a epe = new bk(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e epf = new bl(this, 104102);
    final com.baidu.adp.framework.listener.e epg = new h(this, 304102);
    final CustomMessageListener eph = new i(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener aOy = new j(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e epi = new k(this, 304103);
    private final CustomMessageListener bbo = new l(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener deN = new m(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private final CustomMessageListener epj = new n(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private CustomMessageListener dPj = new o(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener dPk = new p(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private final CustomMessageListener epk = new q(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    final CustomMessageListener epl = new s(this, CmdConfigCustom.CMD_BUY_YINJI_SUCCESS);
    private CustomMessageListener epm = new t(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
    private CustomMessageListener epn = new u(this, CmdConfigCustom.CMD_PHOTO_LIVE_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener epo = new v(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener epp = new w(this, CmdConfigCustom.CMD_FORUMFEED_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener epq = new x(this, CmdConfigCustom.CMD_COLLECTION_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener ddO = new y(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener epr = new z(this, CmdConfigCustom.CMD_PERSON_EXTRA_NEW);
    private CustomMessageListener eps = new aa(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    private CustomMessageListener ept = new ab(this, CmdConfigCustom.CMD_FORUM_FEED_SWITCH_CHANGE);
    private CustomMessageListener epu = new ad(this, CmdConfigCustom.CMD_FRIEND_FEED_SWITCH_CHANGE);
    private CustomMessageListener epv = new ae(this, CmdConfigCustom.CMD_MY_ATTENTION_AND_FANS_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener emG = new af(this, CmdConfigCustom.CMD_ECOMM_REFRESH_WINDOW_LIST);
    private CustomMessageListener dPl = new ag(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);

    public bp aLZ() {
        return this.eht;
    }

    public ViewEventCenter aMa() {
        return this.bfx;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aMU = getBaseFragmentActivity();
        this.bfx = new ViewEventCenter();
        this.bfx.addEventDelegate(this);
        this.eoS = this.aMU instanceof PersonInfoActivity;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aMg();
        t(bundle);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (!this.mIsLogin) {
            this.dyP = true;
        }
        this.cgJ = this.eht.getIsSelf();
        this.userId = this.eht.getId();
        this.eoN = this.eht.aMQ();
        registerListener();
        aMo();
        this.eoX = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.mId = this.eoX;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(this.eoX);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eoX;
        userMuteCheckCustomMessage.setTag(this.eoX);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        if (!this.cgJ && TbadkCoreApplication.isLogin()) {
            aMc();
        }
        this.dPa = getPageContext();
        this.dPb = new com.baidu.tbadk.core.view.h();
        this.dPb.abh = 1000L;
    }

    private void registerListener() {
        registerListener(this.btw);
        registerListener(this.epe);
        registerListener(this.epf);
        registerListener(this.epg);
        registerListener(this.eph);
        registerListener(this.epi);
        registerListener(this.aOy);
        registerListener(this.bbo);
        registerListener(this.eoZ);
        registerListener(this.epa);
        registerListener(this.deN);
        registerListener(this.eoY);
        registerListener(this.epj);
        registerListener(this.epk);
        registerListener(this.epl);
        registerListener(this.epm);
        registerListener(this.epb);
        registerListener(this.epd);
        registerListener(this.epn);
        registerListener(this.epq);
        registerListener(this.ddO);
        registerListener(this.epo);
        registerListener(this.epp);
        registerListener(this.eps);
        registerListener(this.ept);
        registerListener(this.epu);
        registerListener(this.epv);
        registerListener(this.dPl);
        registerListener(this.dPj);
        registerListener(this.dPk);
        registerListener(this.epr);
        if (EcommSwitchStatic.Fq()) {
            registerListener(this.emG);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eht.aMB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.axa = c(layoutInflater);
        this.eoM = new com.baidu.tieba.person.a.at(this);
        if (this.eht != null) {
            this.eoL = (FrameLayout) this.axa.findViewById(u.g.root_layout);
            this.eoI = (LinearLayout) this.axa.findViewById(u.g.unlogin_no_network_root);
            this.eoJ = (NoNetworkView) this.eoI.findViewById(u.g.view_unlogin_no_network);
            this.Ev = (NoNetworkView) this.axa.findViewById(u.g.view_no_network);
            ((FrameLayout.LayoutParams) this.Ev.getLayoutParams()).setMargins(0, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT), 0, 0);
            this.Ev.a(new ah(this));
            this.Ev.setAlpha(0.95f);
            this.eoK = (NavigationBar) this.axa.findViewById(u.g.nologin_navigation_bar);
            if (!this.mIsLogin && this.cgJ) {
                this.eoI.setVisibility(0);
                bd(this.axa);
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
            } else {
                this.eoI.setVisibility(8);
                Z(this.axa);
            }
            this.eoM.aKX();
            this.bsW = (PluginErrorTipView) this.axa.findViewById(u.g.view_plugin_error_tip);
            iu(true);
        }
        this.axa.setOnTouchListener(new ai(this));
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        return this.axa;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.eht != null && this.eoE != null && this.eoE.aNe() != null) {
            if (isPrimary()) {
                UserData userData = this.eht != null ? this.eht.getUserData() : null;
                if (this.eoE != null && this.eoE.aNe() != null) {
                    this.eoE.aNe().setBackBitmap(userData);
                }
            } else if (this.eoE != null && this.eoE.aNe() != null) {
                this.eoE.aNe().aLG();
            }
            if (this.eoM != null) {
                this.eoM.ih(isPrimary());
                this.eoM.aKZ();
            }
            if (isPrimary() && com.baidu.adp.lib.util.i.fr()) {
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
                if (!this.dyP && this.mIsLogin) {
                    a((View) this.eoL, false, -1);
                    this.eht.aMD();
                } else if (this.eoH) {
                    this.eht.aMD();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && TbadkCoreApplication.isLogin() && Boolean.valueOf(com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("need_show_yinji", true)).booleanValue() && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("need_show_yinji", false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.eht != null && this.eht.aMS() && TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.tbadk.core.sharedPref.b.sO().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "god_enter_info_expand", false);
        }
        if (this.eoE != null) {
            this.eoE.onDestroy();
        }
        if (this.cok != null) {
            this.cok.K(this.axa);
            this.cok = null;
        }
        if (this.cgJ) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK));
        }
        this.epc.removeCallbacks(this.mRunnable);
        if (this.eoM != null) {
            this.eoM.onDestroy();
        }
        if (this.bDd != null) {
            this.bDd.destory();
        }
        MessageManager.getInstance().unRegisterListener(this.dPl);
        MessageManager.getInstance().unRegisterListener(this.dPj);
        MessageManager.getInstance().unRegisterListener(this.dPk);
        MessageManager.getInstance().unRegisterListener(this.eoX);
        super.onDestroy();
    }

    private void Z(View view) {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        if (this.eoK != null) {
            this.eoK.setVisibility(8);
        }
        this.eoE = new bs(this, this.cgJ, this.bfx, view);
        this.eoE.setPersonListRefreshListener(new aj(this));
        if (this.cgJ) {
            this.eht.aMC();
        } else {
            a((View) this.eoL, false, -1);
            this.eht.aMD();
        }
        this.eoE.b(new ak(this));
        this.eoE.N(new al(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMb() {
        if (this.eoE != null && this.eht != null && this.eht.aMS()) {
            this.eiC.nZ(this.eht.aMV());
            this.eoE.setOnSrollToBottomListener(new am(this));
            this.eiC.a(new ao(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMc() {
        long c = com.baidu.adp.lib.h.b.c(this.eht.getId(), 0L);
        long c2 = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = c2;
        userMuteCheckCustomMessage.userIdT = c;
        userMuteCheckCustomMessage.mId = this.eoX;
        userMuteCheckCustomMessage.setTag(this.eoX);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.ListView.v vVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (vVar != null) {
            if (!com.baidu.adp.lib.util.k.fI()) {
                showToast(u.j.neterror);
            } else if (!this.cgJ) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10617").ab("obj_id", this.userId));
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    c((com.baidu.tbadk.data.k) vVar, list, i);
                }
            } else if (vVar instanceof com.baidu.tieba.person.data.b) {
                aMd();
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
            cVar.a(strArr, new ap(this, kVar, list, i));
            cVar.d(getPageContext());
            cVar.rW();
        }
    }

    private void aMd() {
        if (getPageContext() != null) {
            String[] strArr = {getPageContext().getString(u.j.choose_local_photo), getPageContext().getString(u.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            cVar.bP(u.j.operation);
            cVar.a(strArr, new aq(this));
            cVar.d(getPageContext());
            cVar.rW();
        }
    }

    private void b(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        String[] strArr = {getPageContext().getString(u.j.look_big_photo), getPageContext().getString(u.j.set_as_portrait_photo), getPageContext().getString(u.j.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bP(u.j.operation);
        cVar.a(strArr, new ar(this, kVar, list, i));
        cVar.d(getPageContext());
        cVar.rW();
    }

    private String od(String str) {
        if ((isAdded() ? getResources() : TbadkCoreApplication.m9getInst().getResources()).getDisplayMetrics().densityDpi > 240.0f) {
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
                        arrayList.add(od(kVar2.AP()));
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
    public void aMe() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.aMU.getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMf() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.aMU.getPageContext().getPageActivity(), 12014, this.eoP)));
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

    private void aMg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_USER_PICS, TbConfig.SET_USER_PICS);
        tbHttpMessageTask.setResponsedClass(SetUserPicsResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CHANGE_PORTRAIT, TbConfig.CHANGE_USER_PORTRAIT);
        tbHttpMessageTask2.setResponsedClass(ChangePortraitResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    private void r(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.eoP)));
            }
            this.writeImagesInfo.clear();
        }
    }

    private void f(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.eht.getUserData() != null && this.cgJ) {
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.eht.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.CQ().fQ(this.eht.getUserData().getPortrait());
                }
            }
            this.eoH = true;
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
                        r(intent);
                    }
                }
            } else if (i == 12010 || i == 12009) {
                if (intent != null) {
                    int intExtra = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra == 1) {
                        aMh();
                    } else if (intExtra == 2) {
                        aMk();
                    }
                }
            } else if (i == 12014) {
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra2 == 1) {
                        aMh();
                    } else if (intExtra2 == 2) {
                        aMk();
                    }
                }
            } else if (i == 24001) {
                if (intent != null && this.eoE != null) {
                    this.eoE.ahm();
                    this.eoE.aNe().setGiftIcon(false);
                }
            } else if (i == 24004 && intent != null && intent.getBooleanExtra(MissonDetailsActivityConfig.IS_UPGRADE_SUCCESS, false)) {
                com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).b(this);
            }
        }
    }

    private void aMh() {
        if (this.eht != null && this.eht.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.CQ().fQ(this.eht.getUserData().getPortrait());
        }
        this.eoH = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMi() {
        if (!this.eoU) {
            this.eoU = true;
            this.epc.postDelayed(this.mRunnable, 300L);
        }
    }

    public boolean aMj() {
        return this.eoW;
    }

    public void it(boolean z) {
        this.eoW = z;
    }

    private void aMk() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new as(this));
    }

    private void aMl() {
        if (this.eht != null && this.eht.aMy() != null && this.eoF != null && this.eoE != null) {
            this.eoE.a(this.eht.aMy().getIsFriend() == 1, this.eoF.getMaskType() == 1, this.eoQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.person.data.e eVar) {
        UserData userData = this.eht.getUserData();
        switch (eVar.mType) {
            case 0:
                if (com.baidu.tbadk.core.util.bn.ab(getPageContext().getPageActivity())) {
                    this.eoM.m(false, 3);
                    this.eoM.ii(true);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10597"));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(getActivity().getApplicationContext())));
                    return;
                }
                return;
            case 1:
                if (com.baidu.tbadk.core.util.bn.ab(getPageContext().getPageActivity())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10602"));
                    this.eoM.m(false, 1);
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
                aMn();
                return;
            case 4:
                aMm();
                return;
            case 5:
                if (com.baidu.tbadk.core.util.bn.ab(getPageContext().getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void aMm() {
        if (com.baidu.tbadk.core.util.bn.ab(getPageContext().getPageActivity()) && this.eht != null) {
            UserData userData = this.eht.getUserData();
            if (this.eht.getIsSelf()) {
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

    private void aMn() {
        if (com.baidu.tbadk.core.util.bn.ab(getPageContext().getPageActivity()) && this.eht != null) {
            UserData userData = this.eht.getUserData();
            if (this.eht.getIsSelf()) {
                TiebaStatic.log("person_self_attentionme_click");
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10599"));
            } else {
                TiebaStatic.log("person_guid_attentionme_click");
            }
            this.eoM.m(false, 2);
            if (userData != null) {
                if (this.eoE != null) {
                    this.eoE.ix(false);
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

    private void t(Bundle bundle) {
        this.eht = new bp(getBaseFragmentActivity());
        this.eht.aBZ();
        this.eht.setPageId(getUniqueId());
        this.eoF = new BlackListModel(getPageContext());
        this.mPersonChangeData = new PersonChangeData();
        a(this.eht, bundle);
        this.eht.setLoadDataCallBack(new at(this));
        this.eiC = new com.baidu.tieba.person.god.i(getPageContext());
    }

    private void a(bp bpVar, Bundle bundle) {
        if (bundle != null) {
            bpVar.oh(bundle.getString("from"));
            String string = bundle.getString("un");
            bpVar.setId(string);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (string != null && currentAccount != null && string.equals(currentAccount)) {
                bpVar.setIsSelf(true);
            } else {
                bpVar.setIsSelf(false);
            }
            bpVar.setName(bundle.getString("name"));
            bpVar.iv(bundle.getBoolean("tab_page", false));
            bpVar.iw(bundle.getBoolean("tab_msg", false));
            bpVar.setStType(bundle.getString("st_type"));
            this.eoV = bundle.getInt(PersonInfoActivityConfig.FANS_NUM);
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getStringExtra("un") != null) {
            String stringExtra = intent.getStringExtra("un");
            bpVar.setId(stringExtra);
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && stringExtra.equals(currentAccount2)) {
                bpVar.setIsSelf(true);
            } else {
                bpVar.setIsSelf(false);
            }
            bpVar.setName(intent.getStringExtra("name"));
            bpVar.oh(intent.getStringExtra("from"));
            bpVar.iv(intent.getBooleanExtra("tab_page", false));
            bpVar.iw(intent.getBooleanExtra("tab_msg", false));
            bpVar.setStType(intent.getStringExtra("st_type"));
            this.eoV = intent.getIntExtra(PersonInfoActivityConfig.FANS_NUM, 0);
            return;
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        bpVar.setIsSelf(true);
        if (currentAccountObj != null) {
            bpVar.setId(currentAccountObj.getID());
            bpVar.setName(currentAccountObj.getAccount());
        }
    }

    private void bd(View view) {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(u.j.unlogin_person_button_text), new av(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds180);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(u.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(u.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(u.e.ds60);
        NoDataViewFactory.b a = NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(u.e.ds20));
        this.eoL.setVisibility(8);
        this.eoK.setVisibility(0);
        this.eoK.switchNaviBarStatus(this.mIsLogin);
        this.eoK.setLoginClickListener(new aw(this));
        this.eoK.setRegisterClickListener(new ax(this));
        this.mNoDataView = NoDataViewFactory.a(getActivity(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, u.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.u(u.j.unlogin_person_msg_text, dimensionPixelSize4), a);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void aMo() {
        if (this.btR == null) {
            this.btR = new com.baidu.tieba.tbadkCore.d.b("profileStat");
            this.btR.start();
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Ds = bVar.Ds();
        bVar.Dt();
        switch (Ds) {
            case 1:
                aMn();
                return true;
            case 2:
                aMm();
                return true;
            case 3:
                aMq();
                return true;
            case 4:
                aMs();
                return true;
            case 5:
                com.baidu.tbadk.core.util.bi.us().c(getPageContext(), new String[]{egE});
                return true;
            default:
                return false;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean kR() {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.av.l(this.axa, u.d.cp_bg_line_d);
        if (this.Ev != null) {
            this.Ev.onChangeSkinType(getPageContext(), i);
        }
        if (this.eoJ != null) {
            this.eoJ.onChangeSkinType(getPageContext(), i);
        }
        if (this.eoE != null) {
            this.eoE.onChangeSkinType(i);
        }
        if (this.eoK != null) {
            this.eoK.onChangeSkinType(getPageContext(), i);
        }
        if (this.bsW != null) {
            this.bsW.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public com.baidu.tieba.person.a.at aMp() {
        return this.eoM;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        UserData userData;
        String str;
        if (this.eoE != null) {
            if (this.eoE.aNm() != null && view.getId() == this.eoE.aNm().getId()) {
                this.aMU.finish();
                return;
            }
            this.eht.getIsSelf();
            String id = this.eht.getId();
            if (view.getId() == this.eoE.getHeadImage().getId()) {
                UserData userData2 = this.eht.getUserData();
                if (userData2 != null) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.fc(userData2.getPortraitH());
                    kVar.fd(userData2.getPortrait());
                    kVar.bn(true);
                    List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
                    arrayList.add(kVar);
                    if (this.cgJ) {
                        a(kVar, arrayList, 0);
                    } else {
                        c(kVar, arrayList, 0);
                    }
                }
            } else if (this.eoE.aNl() != null && view.getId() == this.eoE.aNl().getId()) {
                if (!this.cgJ) {
                    if (id != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10623").ab("obj_id", id));
                    }
                    aMl();
                }
            } else if (view.getId() == this.eoE.aNe().getVipIcon().getId()) {
                TiebaStatic.log(this.eoT);
                if (com.baidu.tbadk.core.util.bn.ab(getActivity())) {
                    UserIconBox vipIcon = this.eoE.aNe().getVipIcon();
                    if ((vipIcon.getTag() instanceof String) && (str = (String) vipIcon.getTag()) != null) {
                        com.baidu.tbadk.core.util.bi.us().c(getPageContext(), new String[]{str});
                    }
                }
            } else if (view.getId() == this.eoE.getAttentionView().getId()) {
                if (this.eht != null && this.eht.aMw() != null && this.eht.aMw().getGodType() == 2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10803").s("obj_locate", 5).ab("obj_id", new StringBuilder(String.valueOf(this.eht.getId())).toString()));
                }
                if (com.baidu.tbadk.core.util.bn.ab(getActivity())) {
                    this.eht.aMA();
                }
            } else if (view.getId() == this.eoE.aNf().getId()) {
                aMs();
            } else if (view.getId() == this.eoE.getUserIcon().getId()) {
                aMq();
            } else if (view.getId() == this.eoE.aNe().getMyGiftIcon().getId()) {
                TiebaStatic.log("igift_icon_ck");
                if (com.baidu.tbadk.core.util.bn.ab(getActivity()) && (userData = this.eht.getUserData()) != null) {
                    if (!com.baidu.adp.lib.util.k.fI()) {
                        showToast(u.j.no_signall_data);
                        return;
                    }
                    this.eoD = true;
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10613").ab("obj_id", id).s("obj_param1", this.eoN));
                    sendMessage(new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData.getUserIdLong(), userData.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001)));
                    this.eoE.aNe().setGiftIcon(true);
                }
            } else if (view.getId() == this.eoE.getMyGiftIcon().getId()) {
                if (com.baidu.tbadk.core.util.bn.ab(getActivity())) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData3 = this.eht.getUserData();
                    if (userData3 != null) {
                        if (!com.baidu.adp.lib.util.k.fI()) {
                            showToast(u.j.no_signall_data);
                            return;
                        }
                        this.eoD = true;
                        sendMessage(new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData3.getUserIdLong(), userData3.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                    }
                }
            } else if (this.eoE.aKO() != null && view.getId() == this.eoE.aKO().getId()) {
                this.eoE.aNk();
                aMr();
            } else if (this.eoE.aKN() != null && view.getId() == this.eoE.aKN().getId()) {
                this.eoE.aNk();
                if (this.eht.getUserData() != null) {
                    com.baidu.tbadk.newFriends.a.Eh().R(this.eht.getUserData().getUserIdLong());
                }
            } else if (this.eoE.aKP() != null && view.getId() == this.eoE.aKP().getId()) {
                this.eoE.aNk();
                if (this.eht != null) {
                    if (!com.baidu.adp.lib.util.i.fr()) {
                        showToast(u.j.neterror);
                    } else if (this.eoQ == 0) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage.setData(false, this.eht.getUserData().getUserId(), this.eht.getUserData().getUserName(), null, null, 0, this.eoR, this.eoX);
                        userMuteAddAndDelCustomMessage.mId = this.eoX;
                        a(false, userMuteAddAndDelCustomMessage, this.eoR, this.eht.getUserData().getUserName());
                    } else if (this.eoQ == 1) {
                        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                        userMuteAddAndDelCustomMessage2.setData(true, this.eht.getUserData().getUserId(), this.eht.getUserData().getUserName(), null, null, 0, this.eoR, this.eoX);
                        userMuteAddAndDelCustomMessage2.mId = this.eoX;
                        a(true, userMuteAddAndDelCustomMessage2, (String) null, this.eht.getUserData().getUserName());
                    }
                }
            } else if (view.getId() == this.eoE.aNe().getExpandImg().getId()) {
                String bg_pic = this.eht.getUserData().getBg_pic();
                try {
                    i = com.baidu.adp.lib.h.b.g(oe(bg_pic).get("props_id"), -1);
                } catch (URISyntaxException e) {
                    i = -1;
                }
                if (this.cgJ || i == -1) {
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

    private Map<String, String> oe(final String str) {
        return new HashMap<String, String>(str) { // from class: com.baidu.tieba.personInfo.PersonInfoFragment$49
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), "UTF-8")) {
                    put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        };
    }

    private void aMq() {
        if (this.eht.getUserData() != null) {
            boolean isSelf = this.eht.getIsSelf();
            String id = this.eht.getId();
            if (isSelf) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10603"));
            } else if (id != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10607").ab("obj_id", id));
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getPageContext().getString(u.j.user_icon_web_view_title), String.valueOf(dWf) + "?user_id=" + this.eht.getUserData().getUserId(), true, true, true);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10134").s("obj_type", 1));
        }
    }

    private void aMr() {
        String format;
        String userName = this.eht.getUserData() != null ? this.eht.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(u.j.confirm, new az(this));
            aVar.b(u.j.cancel, new ba(this));
            if (this.eoF.getMaskType() == 1) {
                format = String.format(getPageContext().getString(u.j.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(u.j.block_chat_message_alert), userName);
            }
            aVar.cz(format);
            aVar.b(getPageContext());
            aVar.rT();
        }
    }

    private void aMs() {
        if (com.baidu.tbadk.core.util.bn.ab(getActivity())) {
            if (this.userId != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10622").ab("obj_id", this.userId));
            }
            if (this.eht.getUserData() != null && this.eht.getUserData().getIsOfficialAccount() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.eht.getUserData().getUserId(), 0L), this.eht.getUserData().getUserName(), this.eht.getUserData().getPortrait(), 0, 4)));
            } else if (this.cgJ) {
                if (this.eht.getAntiData() != null) {
                    com.baidu.tbadk.browser.f.u(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
                }
            } else {
                PersonTainInfo aMy = this.eht.aMy();
                if (aMy != null) {
                    int isFriend = aMy.getIsFriend();
                    if (this.eht.aMS()) {
                        a(this.eht.getUserData(), isFriend);
                    } else if (isFriend == 0) {
                        UserData userData = this.eht.getUserData();
                        if (userData != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.eht.aMz(), aMy.getUserClientVersionLower(), this.eht.getStType())));
                        }
                    } else if (isFriend == 1) {
                        UserData userData2 = this.eht.getUserData();
                        if (userData2 != null) {
                            if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(u.j.login_to_chat), true, 11028)));
                            } else if (!this.cgJ) {
                                a(userData2, isFriend);
                            }
                        }
                    } else if (isFriend == 2) {
                        com.baidu.tbadk.newFriends.a.Eh().b(com.baidu.adp.lib.h.b.c(this.eht.getId(), 0L), "pers_pg");
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
            if (this.bDd == null) {
                this.bDd = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bDd.ap(updateAttentionMessage.getData().toUid, null);
        }
    }

    public void aMt() {
        long j = com.baidu.tbadk.core.sharedPref.b.sO().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
        if (this.eoE != null && this.eoE.eqG != null) {
            if (j < TbadkCoreApplication.m9getInst().getLastUpdateThemeTime()) {
                com.baidu.tbadk.core.util.av.c(this.eoE.eqG, u.f.icon_news_down_bar_one);
                this.eoE.eqG.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.sO().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
                if (!isPrimary()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true)));
                }
            } else if (this.eoE.eqG != null) {
                this.eoE.eqG.setImageDrawable(null);
                this.eoE.eqG.setVisibility(8);
            }
        }
    }

    public void a(View view, boolean z, int i) {
        this.eoK.setVisibility(0);
        this.eoK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this).setOnClickListener(this);
        if (this.cok == null) {
            if (i < 0) {
                this.cok = new com.baidu.tbadk.g.f(getActivity());
            } else {
                this.cok = new com.baidu.tbadk.g.f(getActivity(), i);
            }
            this.cok.se();
        }
        this.cok.c(view, z);
    }

    public void aw(View view) {
        this.eoK.setVisibility(8);
        if (this.cok != null) {
            this.cok.K(view);
            this.cok = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        this.eoK.setVisibility(0);
        this.eoK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this).setOnClickListener(this);
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.g.h(getPageContext().getPageActivity(), new bb(this));
        }
        this.refreshView.eF(getResources().getDimensionPixelSize(u.e.ds160));
        this.refreshView.fX(str);
        this.refreshView.c(view, z);
        this.refreshView.Di();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IM() {
        this.eoK.setVisibility(8);
        if (this.refreshView != null) {
            this.refreshView.K(this.eoL);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMu() {
        if (this.eht != null) {
            this.eht.aMP();
            if (this.eoE != null && this.eoE.eqT != null) {
                this.eoE.eqT.an(this.eht.getDataList());
                this.eoE.eqT.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.b.b.a
    public void a(boolean z, int i, int i2, com.baidu.tbadk.core.data.y yVar) {
        if (z && i2 == 100) {
            this.eht.b(yVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a011";
    }

    public void iu(boolean z) {
        if (this.bsW != null && (this.bsW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            if (z && UtilHelper.canUseStyleImmersiveSticky()) {
                ((ViewGroup.MarginLayoutParams) this.bsW.getLayoutParams()).setMargins(0, UtilHelper.getStatusBarHeight(), 0, 0);
                this.bsW.requestLayout();
                return;
            }
            ((ViewGroup.MarginLayoutParams) this.bsW.getLayoutParams()).setMargins(0, 0, 0, 0);
            this.bsW.requestLayout();
        }
    }

    private void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            asK();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPa.getPageActivity());
        if (com.baidu.tbadk.core.util.ba.isEmpty(str)) {
            aVar.cz(this.dPa.getResources().getString(u.j.block_mute_message_alert, str2));
        } else {
            aVar.cz(str);
        }
        aVar.a(u.j.confirm, new bc(this, userMuteAddAndDelCustomMessage));
        aVar.b(u.j.cancel, new bd(this));
        aVar.b(this.dPa).rT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asK() {
        if (this.btp == null) {
            this.btp = new com.baidu.tbadk.core.view.b(getPageContext());
            this.btp.c(new be(this));
        }
        this.btp.aB(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fH(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPa.getPageActivity());
        aVar.cz(str);
        aVar.b(u.j.know, new bf(this));
        aVar.b(this.dPa).rT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cz(getResources().getString(u.j.mute_is_super_member_function));
        aVar.a(u.j.open_now, new bg(this));
        aVar.b(u.j.cancel, new bh(this));
        aVar.b(this.dPa).rT();
    }
}
