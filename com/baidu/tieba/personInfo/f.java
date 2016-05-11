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
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
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
    private NoNetworkView Ep;
    private BaseFragmentActivity aJw;
    private PluginErrorTipView aXa;
    private ViewEventCenter aXs;
    private boolean aXv;
    private View awk;
    private com.baidu.tbadk.f.f cFC;
    private bj dFA;
    private BlackListModel dFB;
    private LinearLayout dFE;
    private NoNetworkView dFF;
    private NavigationBar dFG;
    private FrameLayout dFH;
    private com.baidu.tieba.person.a.as dFI;
    private List<com.baidu.adp.widget.ListView.v> dFK;
    public boolean dFO;
    private boolean dFQ;
    public int dFR;
    private UserMuteAddAndDelModel diP;
    private com.baidu.tieba.usermute.k diQ;
    private bg dyP;
    private com.baidu.tieba.person.god.h dzV;
    private boolean mIsLogin;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tbadk.f.h refreshView;
    private static String dyi = "http://tieba.baidu.com/mo/q/godIntro";
    private static final String dpI = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    public static boolean dFC = false;
    private boolean dFz = false;
    private boolean bIW = true;
    private com.baidu.tieba.tbadkCore.d.b aXX = null;
    private boolean cST = false;
    private boolean dFD = false;
    private String userId = "";
    private int dFJ = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean dFL = true;
    private int dFM = -1;
    private String dFN = "";
    private String dFP = "c10474";
    private boolean dFS = false;
    private final CustomMessageListener dFT = new g(this, CmdConfigCustom.CMD_YINJIN_CHANGE);
    private HttpMessageListener dFU = new r(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener dFV = new ac(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private CustomMessageListener dFW = new an(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);
    private Handler dFX = new Handler();
    private Runnable mRunnable = new ay(this);
    private com.baidu.adp.framework.listener.a dFY = new az(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
    private CustomMessageListener aXC = new ba(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private final com.baidu.adp.framework.listener.a dFZ = new bb(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e dGa = new bc(this, 104102);
    final com.baidu.adp.framework.listener.e dGb = new h(this, 304102);
    final CustomMessageListener dGc = new i(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener aLa = new j(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e dGd = new k(this, 304103);
    private final CustomMessageListener bhc = new l(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener czq = new m(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private k.a djk = new n(this);
    private final CustomMessageListener dGe = new o(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private UserMuteAddAndDelModel.a djj = new p(this);
    private UserMuteAddAndDelModel.b dGf = new q(this);
    private final CustomMessageListener dGg = new s(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    final CustomMessageListener dGh = new t(this, CmdConfigCustom.CMD_BUY_YINJI_SUCCESS);
    private CustomMessageListener dGi = new u(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
    private CustomMessageListener dGj = new v(this, CmdConfigCustom.CMD_PHOTO_LIVE_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener dGk = new w(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener dGl = new x(this, CmdConfigCustom.CMD_FORUMFEED_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener dGm = new y(this, CmdConfigCustom.CMD_COLLECTION_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener cyr = new z(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener dGn = new aa(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    private CustomMessageListener dGo = new ab(this, CmdConfigCustom.CMD_FORUM_FEED_SWITCH_CHANGE);
    private CustomMessageListener dGp = new ad(this, CmdConfigCustom.CMD_MY_ATTENTION_AND_FANS_PLUGIN_INSTALL_SUCCESS);

    public bg aDb() {
        return this.dyP;
    }

    public ViewEventCenter aDc() {
        return this.aXs;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aJw = getBaseFragmentActivity();
        this.aXs = new ViewEventCenter();
        this.aXs.addEventDelegate(this);
        this.dFO = this.aJw instanceof PersonInfoActivity;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aDi();
        s(bundle);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (!this.mIsLogin) {
            this.cST = true;
        }
        this.bIW = this.dyP.getIsSelf();
        this.userId = this.dyP.getId();
        this.dFJ = this.dyP.aDS();
        registerListener();
        aDq();
        if (!this.bIW && TbadkCoreApplication.isLogin()) {
            aDe();
        }
    }

    private void registerListener() {
        registerListener(this.aXC);
        registerListener(this.dFZ);
        registerListener(this.dGa);
        registerListener(this.dGb);
        registerListener(this.dGc);
        registerListener(this.dGd);
        registerListener(this.aLa);
        registerListener(this.bhc);
        registerListener(this.dFU);
        registerListener(this.dFV);
        registerListener(this.czq);
        registerListener(this.dFT);
        registerListener(this.dGe);
        registerListener(this.dGg);
        registerListener(this.dGh);
        registerListener(this.dGi);
        registerListener(this.dFW);
        registerListener(this.dFY);
        registerListener(this.dGj);
        registerListener(this.dGm);
        registerListener(this.cyr);
        registerListener(this.dGk);
        registerListener(this.dGl);
        registerListener(this.dGn);
        registerListener(this.dGo);
        registerListener(this.dGp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dyP.aDD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.awk = c(layoutInflater);
        this.dFI = new com.baidu.tieba.person.a.as(this);
        if (this.dyP != null) {
            this.dFH = (FrameLayout) this.awk.findViewById(t.g.root_layout);
            this.dFE = (LinearLayout) this.awk.findViewById(t.g.unlogin_no_network_root);
            this.dFF = (NoNetworkView) this.dFE.findViewById(t.g.view_unlogin_no_network);
            this.Ep = (NoNetworkView) this.awk.findViewById(t.g.view_no_network);
            ((FrameLayout.LayoutParams) this.Ep.getLayoutParams()).setMargins(0, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT), 0, 0);
            this.Ep.a(new ae(this));
            this.Ep.setAlpha(0.95f);
            this.dFG = (NavigationBar) this.awk.findViewById(t.g.nologin_navigation_bar);
            if (!this.mIsLogin && this.bIW) {
                this.dFE.setVisibility(0);
                aV(this.awk);
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
            } else {
                this.dFE.setVisibility(8);
                X(this.awk);
            }
            this.dFI.aCb();
            this.aXa = (PluginErrorTipView) this.awk.findViewById(t.g.view_plugin_error_tip);
            hz(true);
        }
        this.awk.setOnTouchListener(new af(this));
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        return this.awk;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.dyP != null && this.dFA != null && this.dFA.aEh() != null) {
            if (isPrimary()) {
                UserData userData = this.dyP != null ? this.dyP.getUserData() : null;
                if (this.dFA != null && this.dFA.aEh() != null) {
                    this.dFA.aEh().setBackBitmap(userData);
                }
            } else if (this.dFA != null && this.dFA.aEh() != null) {
                this.dFA.aEh().aCJ();
            }
            if (this.dFI != null) {
                this.dFI.hm(isPrimary());
                this.dFI.aCd();
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10407").s("obj_type", memberType));
                }
                if (!this.cST && this.mIsLogin) {
                    a((View) this.dFH, false, -1);
                    this.dyP.aDF();
                } else if (this.dFD) {
                    this.dyP.aDF();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && TbadkCoreApplication.isLogin() && Boolean.valueOf(com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("need_show_yinji", true)).booleanValue() && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("need_show_yinji", false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dyP != null && this.dyP.aDU() && TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "god_enter_info_expand", false);
        }
        this.diQ.onDestroy();
        this.diP.onDestory();
        if (this.dFA != null) {
            this.dFA.onDestroy();
        }
        if (this.cFC != null) {
            this.cFC.L(this.awk);
            this.cFC = null;
        }
        if (this.bIW) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK));
        }
        this.dFX.removeCallbacks(this.mRunnable);
        if (this.dFI != null) {
            this.dFI.onDestroy();
        }
        super.onDestroy();
    }

    private void X(View view) {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        if (this.dFG != null) {
            this.dFG.setVisibility(8);
        }
        this.dFA = new bj(this, this.bIW, this.aXs, view);
        this.dFA.setPersonListRefreshListener(new ag(this));
        if (this.bIW) {
            this.dyP.aDE();
        } else {
            a((View) this.dFH, false, -1);
            this.dyP.aDF();
        }
        this.dFA.b(new ah(this));
        this.dFA.M(new ai(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDd() {
        if (this.dFA != null && this.dyP != null && this.dyP.aDU()) {
            this.dzV.my(this.dyP.aDX());
            this.dFA.setOnSrollToBottomListener(new aj(this));
            this.dzV.a(new ak(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDe() {
        long c = com.baidu.adp.lib.h.b.c(this.dyP.getId(), 0L);
        this.diQ.e(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.ListView.v vVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (vVar != null) {
            if (!com.baidu.adp.lib.util.k.fH()) {
                showToast(t.j.neterror);
            } else if (!this.bIW) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10617").ac("obj_id", this.userId));
                if (vVar instanceof com.baidu.tbadk.data.i) {
                    c((com.baidu.tbadk.data.i) vVar, list, i);
                }
            } else if (vVar instanceof com.baidu.tieba.person.data.b) {
                aDf();
            } else if (vVar instanceof com.baidu.tbadk.data.i) {
                com.baidu.tbadk.data.i iVar = (com.baidu.tbadk.data.i) vVar;
                if (iVar.AG()) {
                    a(iVar, list, i);
                } else {
                    b(iVar, list, i);
                }
            }
        }
    }

    private void a(com.baidu.tbadk.data.i iVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (getPageContext() != null) {
            String[] strArr = {getPageContext().getString(t.j.hd_photo), getPageContext().getString(t.j.change_photo), getPageContext().getString(t.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            cVar.bP(t.j.operation);
            cVar.a(strArr, new al(this, iVar, list, i));
            cVar.d(getPageContext());
            cVar.rX();
        }
    }

    private void aDf() {
        if (getPageContext() != null) {
            String[] strArr = {getPageContext().getString(t.j.choose_local_photo), getPageContext().getString(t.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            cVar.bP(t.j.operation);
            cVar.a(strArr, new am(this));
            cVar.d(getPageContext());
            cVar.rX();
        }
    }

    private void b(com.baidu.tbadk.data.i iVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        String[] strArr = {getPageContext().getString(t.j.look_big_photo), getPageContext().getString(t.j.set_as_portrait_photo), getPageContext().getString(t.j.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bP(t.j.operation);
        cVar.a(strArr, new ao(this, iVar, list, i));
        cVar.d(getPageContext());
        cVar.rX();
    }

    private String mx(String str) {
        if ((isAdded() ? getResources() : TbadkCoreApplication.m11getInst().getResources()).getDisplayMetrics().densityDpi > 240.0f) {
            return "http://himg.baidu.com/sys/portraith/item/" + str;
        }
        return "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.data.i iVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (iVar != null && list != null && !StringUtils.isNull(iVar.AF())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tbadk.data.i) {
                    com.baidu.tbadk.data.i iVar2 = (com.baidu.tbadk.data.i) vVar;
                    if (iVar2.AG()) {
                        arrayList.add(mx(iVar2.AF()));
                    } else {
                        arrayList.add(iVar2.AF());
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
    public void aDg() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.aJw.getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDh() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.aJw.getPageContext().getPageActivity(), 12014, this.dFL)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.i iVar) {
        if (iVar != null && !StringUtils.isNull(iVar.AF())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
            httpMessage.addParam("pic_url", iVar.AF());
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.i iVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (iVar != null && list != null && list.size() > 2 && !StringUtils.isNull(iVar.AF())) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i != i2) {
                    com.baidu.adp.widget.ListView.v vVar = list.get(i2);
                    if (vVar instanceof com.baidu.tbadk.data.i) {
                        com.baidu.tbadk.data.i iVar2 = (com.baidu.tbadk.data.i) vVar;
                        if (!iVar2.AG()) {
                            jSONArray.put(iVar2.AF());
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
    public void g(String str, List<com.baidu.adp.widget.ListView.v> list) {
        if (!StringUtils.isNull(str) && list != null) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.v vVar = list.get(i);
                if (vVar instanceof com.baidu.tbadk.data.i) {
                    com.baidu.tbadk.data.i iVar = (com.baidu.tbadk.data.i) vVar;
                    if (!iVar.AG()) {
                        jSONArray.put(iVar.AF());
                    }
                }
            }
            jSONArray.put(str);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
            httpMessage.addParam("pic_list", jSONArray.toString());
            sendMessage(httpMessage);
        }
    }

    private void aDi() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_USER_PICS, TbConfig.SET_USER_PICS);
        tbHttpMessageTask.setResponsedClass(SetUserPicsResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CHANGE_PORTRAIT, TbConfig.CHANGE_USER_PORTRAIT);
        tbHttpMessageTask2.setResponsedClass(ChangePortraitResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    private void p(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.dFL)));
            }
            this.writeImagesInfo.clear();
        }
    }

    private void f(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.dyP.getUserData() != null && this.bIW) {
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.dyP.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.CH().fK(this.dyP.getUserData().getPortrait());
                }
            }
            this.dFD = true;
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
                        p(intent);
                    }
                }
            } else if (i == 12010 || i == 12009) {
                if (intent != null) {
                    int intExtra = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra == 1) {
                        aDj();
                    } else if (intExtra == 2) {
                        aDm();
                    }
                }
            } else if (i == 12014) {
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra2 == 1) {
                        aDj();
                    } else if (intExtra2 == 2) {
                        aDm();
                    }
                }
            } else if (i == 24001) {
                if (intent != null && this.dFA != null) {
                    this.dFA.aiJ();
                    this.dFA.aEh().setGiftIcon(false);
                }
            } else if (i == 24004 && intent != null && intent.getBooleanExtra(MissonDetailsActivityConfig.IS_UPGRADE_SUCCESS, false)) {
                com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).b(this);
            }
        }
    }

    private void aDj() {
        if (this.dyP != null && this.dyP.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.CH().fK(this.dyP.getUserData().getPortrait());
        }
        this.dFD = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDk() {
        if (!this.dFQ) {
            this.dFQ = true;
            this.dFX.postDelayed(this.mRunnable, 300L);
        }
    }

    public boolean aDl() {
        return this.dFS;
    }

    public void hy(boolean z) {
        this.dFS = z;
    }

    private void aDm() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new ap(this));
    }

    private void aDn() {
        if (this.dyP != null && this.dyP.aDA() != null && this.dFB != null && this.dFA != null) {
            this.dFA.a(this.dyP.aDA().getIsFriend() == 1, this.dFB.getMaskType() == 1, this.dFM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.person.data.e eVar) {
        UserData userData = this.dyP.getUserData();
        switch (eVar.mType) {
            case 0:
                if (com.baidu.tbadk.core.util.bl.ac(getPageContext().getPageActivity())) {
                    this.dFI.j(false, 3);
                    this.dFI.hn(true);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10597"));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(getActivity().getApplicationContext())));
                    return;
                }
                return;
            case 1:
                if (com.baidu.tbadk.core.util.bl.ac(getPageContext().getPageActivity())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10602"));
                    this.dFI.j(false, 1);
                    if (userData != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(getActivity().getApplicationContext())));
                        return;
                    }
                    return;
                }
                return;
            case 2:
                if (com.baidu.tbadk.core.util.bl.ac(getPageContext().getPageActivity())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10604"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(getActivity().getApplicationContext())));
                    return;
                }
                return;
            case 3:
                aDp();
                return;
            case 4:
                aDo();
                return;
            case 5:
                if (com.baidu.tbadk.core.util.bl.ac(getPageContext().getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void aDo() {
        if (com.baidu.tbadk.core.util.bl.ac(getPageContext().getPageActivity()) && this.dyP != null) {
            UserData userData = this.dyP.getUserData();
            if (this.dyP.getIsSelf()) {
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

    private void aDp() {
        if (com.baidu.tbadk.core.util.bl.ac(getPageContext().getPageActivity()) && this.dyP != null) {
            UserData userData = this.dyP.getUserData();
            if (this.dyP.getIsSelf()) {
                TiebaStatic.log("person_self_attentionme_click");
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10599"));
            } else {
                TiebaStatic.log("person_guid_attentionme_click");
            }
            this.dFI.j(false, 2);
            if (userData != null) {
                if (this.dFA != null) {
                    this.dFA.hC(false);
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

    private void s(Bundle bundle) {
        this.dyP = new bg(getBaseFragmentActivity());
        this.dyP.atR();
        this.dFB = new BlackListModel(getPageContext());
        this.mPersonChangeData = new PersonChangeData();
        a(this.dyP, bundle);
        this.dyP.setLoadDataCallBack(new aq(this));
        this.diP = new UserMuteAddAndDelModel(getPageContext());
        this.diP.a(this.djj);
        this.diP.a(this.dGf);
        this.diQ = new com.baidu.tieba.usermute.k(getPageContext(), this.djk);
        this.dzV = new com.baidu.tieba.person.god.h(getPageContext());
    }

    private void a(bg bgVar, Bundle bundle) {
        if (bundle != null) {
            bgVar.mA(bundle.getString("from"));
            String string = bundle.getString("un");
            bgVar.setId(string);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (string != null && currentAccount != null && string.equals(currentAccount)) {
                bgVar.setIsSelf(true);
            } else {
                bgVar.setIsSelf(false);
            }
            bgVar.setName(bundle.getString("name"));
            bgVar.hA(bundle.getBoolean("tab_page", false));
            bgVar.hB(bundle.getBoolean("tab_msg", false));
            bgVar.setStType(bundle.getString("st_type"));
            this.dFR = bundle.getInt(PersonInfoActivityConfig.FANS_NUM);
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getStringExtra("un") != null) {
            String stringExtra = intent.getStringExtra("un");
            bgVar.setId(stringExtra);
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && stringExtra.equals(currentAccount2)) {
                bgVar.setIsSelf(true);
            } else {
                bgVar.setIsSelf(false);
            }
            bgVar.setName(intent.getStringExtra("name"));
            bgVar.mA(intent.getStringExtra("from"));
            bgVar.hA(intent.getBooleanExtra("tab_page", false));
            bgVar.hB(intent.getBooleanExtra("tab_msg", false));
            bgVar.setStType(intent.getStringExtra("st_type"));
            this.dFR = intent.getIntExtra(PersonInfoActivityConfig.FANS_NUM, 0);
            return;
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        bgVar.setIsSelf(true);
        if (currentAccountObj != null) {
            bgVar.setId(currentAccountObj.getID());
            bgVar.setName(currentAccountObj.getAccount());
        }
    }

    private void aV(View view) {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(t.j.unlogin_person_button_text), new as(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds180);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(t.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(t.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(t.e.ds60);
        NoDataViewFactory.b a = NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(t.e.ds20));
        this.dFH.setVisibility(8);
        this.dFG.setVisibility(0);
        this.dFG.switchNaviBarStatus(this.mIsLogin);
        this.dFG.setLoginClickListener(new at(this));
        this.dFG.setRegisterClickListener(new au(this));
        this.mNoDataView = NoDataViewFactory.a(getActivity(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.u(t.j.unlogin_person_msg_text, dimensionPixelSize4), a);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
    }

    private void aDq() {
        if (this.aXX == null) {
            this.aXX = new com.baidu.tieba.tbadkCore.d.b("profileStat");
            this.aXX.start();
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int Dj = bVar.Dj();
        bVar.Dk();
        switch (Dj) {
            case 1:
                aDp();
                return true;
            case 2:
                aDo();
                return true;
            case 3:
                aDs();
                return true;
            case 4:
                aDu();
                return true;
            case 5:
                com.baidu.tbadk.core.util.bg.us().c(getPageContext(), new String[]{dyi});
                return true;
            default:
                return false;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean kO() {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.at.l(this.awk, t.d.cp_bg_line_d);
        if (this.Ep != null) {
            this.Ep.onChangeSkinType(getPageContext(), i);
        }
        if (this.dFF != null) {
            this.dFF.onChangeSkinType(getPageContext(), i);
        }
        if (this.dFA != null) {
            this.dFA.onChangeSkinType(i);
        }
        if (this.dFG != null) {
            this.dFG.onChangeSkinType(getPageContext(), i);
        }
        if (this.aXa != null) {
            this.aXa.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public com.baidu.tieba.person.a.as aDr() {
        return this.dFI;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        AccountData currentAccountInfo;
        UserData userData;
        String str;
        int i2 = 0;
        if (this.dFA != null) {
            if (this.dFA.aEo() != null && view.getId() == this.dFA.aEo().getId()) {
                this.aJw.finish();
                return;
            }
            this.dyP.getIsSelf();
            String id = this.dyP.getId();
            if (view.getId() == this.dFA.getHeadImage().getId()) {
                UserData userData2 = this.dyP.getUserData();
                if (userData2 != null) {
                    com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                    iVar.eW(userData2.getPortraitH());
                    iVar.eX(userData2.getPortrait());
                    iVar.bq(true);
                    List<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
                    arrayList.add(iVar);
                    if (this.bIW) {
                        a(iVar, arrayList, 0);
                    } else {
                        c(iVar, arrayList, 0);
                    }
                }
            } else if (this.dFA.aEn() != null && view.getId() == this.dFA.aEn().getId()) {
                if (!this.bIW) {
                    if (id != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10623").ac("obj_id", id));
                    }
                    aDn();
                }
            } else if (view.getId() == this.dFA.aEh().getVipIcon().getId()) {
                TiebaStatic.log(this.dFP);
                if (com.baidu.tbadk.core.util.bl.ac(getActivity())) {
                    UserIconBox vipIcon = this.dFA.aEh().getVipIcon();
                    if ((vipIcon.getTag() instanceof String) && (str = (String) vipIcon.getTag()) != null) {
                        com.baidu.tbadk.core.util.bg.us().c(getPageContext(), new String[]{str});
                    }
                }
            } else if (view.getId() == this.dFA.getAttentionView().getId()) {
                if (this.dyP != null && this.dyP.aDy() != null && this.dyP.aDy().getGodType() == 2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10803").s("obj_locate", 5).ac("obj_id", new StringBuilder(String.valueOf(this.dyP.getId())).toString()));
                }
                if (com.baidu.tbadk.core.util.bl.ac(getActivity())) {
                    this.dyP.aDC();
                }
            } else if (view.getId() == this.dFA.aEi().getId()) {
                aDu();
            } else if (view.getId() == this.dFA.getUserIcon().getId()) {
                aDs();
            } else if (view.getId() == this.dFA.aEh().getMyGiftIcon().getId()) {
                TiebaStatic.log("igift_icon_ck");
                if (com.baidu.tbadk.core.util.bl.ac(getActivity()) && (userData = this.dyP.getUserData()) != null) {
                    if (!com.baidu.adp.lib.util.k.fH()) {
                        showToast(t.j.no_signall_data);
                        return;
                    }
                    this.dFz = true;
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10613").ac("obj_id", id).s("obj_param1", this.dFJ));
                    sendMessage(new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData.getUserIdLong(), userData.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001)));
                    this.dFA.aEh().setGiftIcon(true);
                }
            } else if (view.getId() == this.dFA.getMyGiftIcon().getId()) {
                if (com.baidu.tbadk.core.util.bl.ac(getActivity())) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData3 = this.dyP.getUserData();
                    if (userData3 != null) {
                        if (!com.baidu.adp.lib.util.k.fH()) {
                            showToast(t.j.no_signall_data);
                            return;
                        }
                        this.dFz = true;
                        sendMessage(new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData3.getUserIdLong(), userData3.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                    }
                }
            } else if (this.dFA.aBT() != null && view.getId() == this.dFA.aBT().getId()) {
                this.dFA.aEm();
                aDt();
            } else if (this.dFA.aBS() != null && view.getId() == this.dFA.aBS().getId()) {
                this.dFA.aEm();
                if (this.dyP.getUserData() != null) {
                    com.baidu.tbadk.newFriends.a.DX().O(this.dyP.getUserData().getUserIdLong());
                }
            } else if (this.dFA.aBU() != null && view.getId() == this.dFA.aBU().getId()) {
                this.dFA.aEm();
                if (this.dyP != null) {
                    if (!com.baidu.adp.lib.util.i.fq()) {
                        showToast(t.j.neterror);
                    } else if (this.dFM == 0) {
                        this.diP.a(false, this.dyP.getUserData().getUserId(), this.dyP.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo, this.dFN);
                    } else if (this.dFM == 1) {
                        this.diP.a(true, this.dyP.getUserData().getUserId(), this.dyP.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    }
                }
            } else if (view.getId() == this.dFA.aEh().getExpandImg().getId()) {
                String bg_pic = this.dyP.getUserData().getBg_pic();
                try {
                    i = com.baidu.adp.lib.h.b.g(my(bg_pic).get("props_id"), -1);
                } catch (URISyntaxException e) {
                    i = -1;
                }
                if (this.bIW || i == -1) {
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

    private Map<String, String> my(final String str) {
        return new HashMap<String, String>(str) { // from class: com.baidu.tieba.personInfo.PersonInfoFragment$46
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), "UTF-8")) {
                    put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        };
    }

    private void aDs() {
        if (this.dyP.getUserData() != null) {
            boolean isSelf = this.dyP.getIsSelf();
            String id = this.dyP.getId();
            if (isSelf) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10603"));
            } else if (id != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10607").ac("obj_id", id));
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getPageContext().getString(t.j.user_icon_web_view_title), String.valueOf(dpI) + "?user_id=" + this.dyP.getUserData().getUserId(), true, true, true);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10134").s("obj_type", 1));
        }
    }

    private void aDt() {
        String format;
        String userName = this.dyP.getUserData() != null ? this.dyP.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(t.j.confirm, new av(this));
            aVar.b(t.j.cancel, new aw(this));
            if (this.dFB.getMaskType() == 1) {
                format = String.format(getPageContext().getString(t.j.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(t.j.block_chat_message_alert), userName);
            }
            aVar.cA(format);
            aVar.b(getPageContext());
            aVar.rU();
        }
    }

    private void aDu() {
        if (com.baidu.tbadk.core.util.bl.ac(getActivity())) {
            if (this.userId != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10622").ac("obj_id", this.userId));
            }
            if (this.dyP.getUserData() != null && this.dyP.getUserData().getIsOfficialAccount() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.dyP.getUserData().getUserId(), 0L), this.dyP.getUserData().getUserName(), this.dyP.getUserData().getPortrait(), 0, 4)));
            } else if (this.bIW) {
                if (this.dyP.getAntiData() != null) {
                    com.baidu.tbadk.browser.f.t(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
                }
            } else {
                PersonTainInfo aDA = this.dyP.aDA();
                if (aDA != null) {
                    int isFriend = aDA.getIsFriend();
                    if (this.dyP.aDU()) {
                        a(this.dyP.getUserData(), isFriend);
                    } else if (isFriend == 0) {
                        UserData userData = this.dyP.getUserData();
                        if (userData != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.dyP.aDB(), aDA.getUserClientVersionLower(), this.dyP.getStType())));
                        }
                    } else if (isFriend == 1) {
                        UserData userData2 = this.dyP.getUserData();
                        if (userData2 != null) {
                            if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(t.j.login_to_chat), true, 11028)));
                            } else if (!this.bIW) {
                                a(userData2, isFriend);
                            }
                        }
                    } else if (isFriend == 2) {
                        com.baidu.tbadk.newFriends.a.DX().b(com.baidu.adp.lib.h.b.c(this.dyP.getId(), 0L), "pers_pg");
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

    public void aDv() {
        long j = com.baidu.tbadk.core.sharedPref.b.sQ().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
        if (this.dFA != null && this.dFA.dHB != null) {
            if (j < TbadkCoreApplication.m11getInst().getLastUpdateThemeTime()) {
                com.baidu.tbadk.core.util.at.c(this.dFA.dHB, t.f.icon_news_down_bar_one);
                this.dFA.dHB.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.sQ().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
                if (!isPrimary()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true)));
                }
            } else if (this.dFA.dHB != null) {
                this.dFA.dHB.setImageDrawable(null);
                this.dFA.dHB.setVisibility(8);
            }
        }
    }

    public void a(View view, boolean z, int i) {
        this.dFG.setVisibility(0);
        this.dFG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this).setOnClickListener(this);
        if (this.cFC == null) {
            if (i < 0) {
                this.cFC = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.cFC = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.cFC.sf();
        }
        this.cFC.c(view, z);
    }

    public void aH(View view) {
        this.dFG.setVisibility(8);
        if (this.cFC != null) {
            this.cFC.L(view);
            this.cFC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        this.dFG.setVisibility(0);
        this.dFG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this).setOnClickListener(this);
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new ax(this));
        }
        this.refreshView.eB(getResources().getDimensionPixelSize(t.e.ds160));
        this.refreshView.fR(str);
        this.refreshView.c(view, z);
        this.refreshView.CZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pe() {
        this.dFG.setVisibility(8);
        if (this.refreshView != null) {
            this.refreshView.L(this.dFH);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDw() {
        if (this.dyP != null) {
            this.dyP.aDR();
            if (this.dFA != null && this.dFA.dHO != null) {
                this.dFA.dHO.ac(this.dyP.getDataList());
                this.dFA.dHO.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.b.b.a
    public void a(boolean z, int i, int i2, com.baidu.tbadk.core.data.w wVar) {
        if (z && i2 == 100) {
            this.dyP.b(wVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a011";
    }

    public void hz(boolean z) {
        if (this.aXa != null && (this.aXa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            if (z && UtilHelper.canUseStyleImmersiveSticky()) {
                ((ViewGroup.MarginLayoutParams) this.aXa.getLayoutParams()).setMargins(0, UtilHelper.getStatusBarHeight(), 0, 0);
                this.aXa.requestLayout();
                return;
            }
            ((ViewGroup.MarginLayoutParams) this.aXa.getLayoutParams()).setMargins(0, 0, 0, 0);
            this.aXa.requestLayout();
        }
    }
}
