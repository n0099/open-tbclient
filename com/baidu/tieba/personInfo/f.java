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
import com.baidu.tieba.usermute.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class f extends BaseFragment implements b.a, com.baidu.tbadk.mvc.c.a {
    private NoNetworkView NR;
    private BaseFragmentActivity aKq;
    private ViewEventCenter aWA;
    private boolean aWD;
    private View azA;
    private UserMuteAddAndDelModel cMI;
    private com.baidu.tieba.usermute.i cMJ;
    private bf dbl;
    private com.baidu.tieba.person.god.h dcn;
    private bi dhR;
    private BlackListModel dhS;
    private LinearLayout dhV;
    private NoNetworkView dhW;
    private NavigationBar dhX;
    private FrameLayout dhY;
    private com.baidu.tieba.person.a.al dhZ;
    private List<com.baidu.tbadk.data.g> dib;
    public boolean die;
    private com.baidu.tbadk.f.f dig;
    private boolean dih;
    public int dii;
    private boolean mIsLogin;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tbadk.f.h refreshView;
    private static String daJ = "http://tieba.baidu.com/mo/q/godIntro";
    private static final String cSD = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    public static boolean dhT = false;
    private boolean dhQ = false;
    private boolean bDs = true;
    private com.baidu.tieba.tbadkCore.d.b aXf = null;
    private boolean cIp = false;
    private boolean dhU = false;
    private String userId = "";
    private int dia = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean dic = true;
    private int did = -1;
    private String dif = "c10474";
    private final CustomMessageListener dij = new g(this, CmdConfigCustom.CMD_YINJIN_CHANGE);
    private HttpMessageListener dik = new r(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener dil = new ac(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private CustomMessageListener din = new an(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);
    private Handler dio = new Handler();
    private Runnable mRunnable = new ax(this);
    private com.baidu.adp.framework.listener.a dip = new ay(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
    private CustomMessageListener aWK = new az(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private final com.baidu.adp.framework.listener.a diq = new ba(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e dir = new bb(this, 104102);
    final com.baidu.adp.framework.listener.e dis = new h(this, 304102);
    final CustomMessageListener dit = new i(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener aLV = new j(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e diu = new k(this, 304103);
    private final CustomMessageListener bgl = new l(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener cnP = new m(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private i.a cNc = new n(this);
    private final CustomMessageListener div = new o(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private UserMuteAddAndDelModel.a cNb = new p(this);
    private UserMuteAddAndDelModel.b diw = new q(this);
    private final CustomMessageListener dix = new s(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    final CustomMessageListener diy = new t(this, CmdConfigCustom.CMD_BUY_YINJI_SUCCESS);
    private CustomMessageListener diz = new u(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
    private CustomMessageListener diA = new v(this, CmdConfigCustom.CMD_PHOTO_LIVE_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener diB = new w(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener diC = new x(this, CmdConfigCustom.CMD_FORUMFEED_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener diD = new y(this, CmdConfigCustom.CMD_COLLECTION_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener cmR = new z(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener diE = new aa(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    private CustomMessageListener diF = new ab(this, CmdConfigCustom.CMD_FORUM_FEED_SWITCH_CHANGE);

    public bf avb() {
        return this.dbl;
    }

    public ViewEventCenter avc() {
        return this.aWA;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aKq = getBaseFragmentActivity();
        this.aWA = new ViewEventCenter();
        this.aWA.addEventDelegate(this);
        this.die = this.aKq instanceof PersonInfoActivity;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        avi();
        p(bundle);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (!this.mIsLogin) {
            this.cIp = true;
        }
        this.bDs = this.dbl.getIsSelf();
        this.userId = this.dbl.getId();
        this.dia = this.dbl.avR();
        registerListener();
        avp();
        if (!this.bDs && TbadkCoreApplication.isLogin()) {
            ave();
        }
    }

    private void registerListener() {
        registerListener(this.aWK);
        registerListener(this.diq);
        registerListener(this.dir);
        registerListener(this.dis);
        registerListener(this.dit);
        registerListener(this.diu);
        registerListener(this.aLV);
        registerListener(this.bgl);
        registerListener(this.dik);
        registerListener(this.dil);
        registerListener(this.cnP);
        registerListener(this.dij);
        registerListener(this.div);
        registerListener(this.dix);
        registerListener(this.diy);
        registerListener(this.diz);
        registerListener(this.din);
        registerListener(this.dip);
        registerListener(this.diA);
        registerListener(this.diD);
        registerListener(this.cmR);
        registerListener(this.diB);
        registerListener(this.diC);
        registerListener(this.diE);
        registerListener(this.diF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dbl.avD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.azA = c(layoutInflater);
        this.dhZ = new com.baidu.tieba.person.a.al(this);
        if (this.dbl != null) {
            this.dhY = (FrameLayout) this.azA.findViewById(t.g.root_layout);
            this.dhV = (LinearLayout) this.azA.findViewById(t.g.unlogin_no_network_root);
            this.dhW = (NoNetworkView) this.dhV.findViewById(t.g.view_unlogin_no_network);
            this.NR = (NoNetworkView) this.azA.findViewById(t.g.view_no_network);
            this.NR.a(new ad(this));
            this.NR.setAlpha(0.95f);
            this.dhX = (NavigationBar) this.azA.findViewById(t.g.nologin_navigation_bar);
            if (!this.mIsLogin && this.bDs) {
                this.dhV.setVisibility(0);
                aJ(this.azA);
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
            } else {
                this.dhV.setVisibility(8);
                R(this.azA);
            }
            this.dhZ.aue();
        }
        this.azA.setOnTouchListener(new ae(this));
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return this.azA;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.dbl != null && this.dhR != null && this.dhR.awf() != null) {
            if (isPrimary()) {
                UserData userData = this.dbl != null ? this.dbl.getUserData() : null;
                if (this.dhR != null && this.dhR.awf() != null) {
                    this.dhR.awf().setBackBitmap(userData);
                }
            } else if (this.dhR != null && this.dhR.awf() != null) {
                this.dhR.awf().auL();
            }
            if (this.dhZ != null) {
                this.dhZ.fT(isPrimary());
                this.dhZ.aug();
            }
            if (isPrimary() && com.baidu.adp.lib.util.i.iZ()) {
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    int memberType = currentAccountObj.getMemberType();
                    if (memberType == 0) {
                        memberType = 0;
                    } else if (memberType > 0) {
                        memberType = 1;
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10407").r("obj_type", memberType));
                }
                if (!this.cIp && this.mIsLogin) {
                    a((View) this.dhY, false, -1);
                    this.dbl.avF();
                } else if (this.dhU) {
                    this.dbl.avF();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && TbadkCoreApplication.isLogin() && Boolean.valueOf(com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("need_show_yinji", true)).booleanValue() && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("need_show_yinji", false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dbl != null && this.dbl.avT()) {
            com.baidu.tbadk.core.sharedPref.b.uO().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "god_enter_info_expand", false);
        }
        this.cMJ.onDestroy();
        this.cMI.onDestory();
        if (this.dhR != null) {
            this.dhR.onDestroy();
        }
        if (this.dig != null) {
            this.dig.H(this.azA);
            this.dig = null;
        }
        if (this.bDs) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK));
        }
        this.dio.removeCallbacks(this.mRunnable);
        if (this.dhZ != null) {
            this.dhZ.onDestroy();
        }
    }

    private void R(View view) {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        if (this.dhX != null) {
            this.dhX.setVisibility(8);
        }
        this.dhR = new bi(this, this.bDs, this.aWA, view);
        this.dhR.setPersonListRefreshListener(new af(this));
        if (this.bDs) {
            this.dbl.avE();
        } else {
            a((View) this.dhY, false, -1);
            this.dbl.avF();
        }
        this.dhR.b(new ag(this));
        this.dhR.N(new ah(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avd() {
        if (this.dhR != null && this.dbl != null && this.dbl.avT()) {
            this.dcn.lx(this.dbl.avW());
            this.dhR.setOnSrollToBottomListener(new ai(this));
            this.dcn.a(new aj(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ave() {
        long c = com.baidu.adp.lib.h.b.c(this.dbl.getId(), 0L);
        this.cMJ.e(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        if (gVar != null) {
            if (!com.baidu.adp.lib.util.k.jq()) {
                showToast(t.j.neterror);
            } else if (!this.bDs) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10617").aa("obj_id", this.userId));
                d(gVar, list, i);
            } else if (gVar.isAdded()) {
                avf();
            } else if (gVar.Ch()) {
                b(gVar, list, i);
            } else {
                c(gVar, list, i);
            }
        }
    }

    private void b(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        if (getPageContext() != null) {
            String[] strArr = {getPageContext().getString(t.j.hd_photo), getPageContext().getString(t.j.change_photo), getPageContext().getString(t.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            cVar.cb(t.j.operation);
            cVar.a(strArr, new ak(this, gVar, list, i));
            cVar.d(getPageContext());
            cVar.un();
        }
    }

    private void avf() {
        if (getPageContext() != null) {
            String[] strArr = {getPageContext().getString(t.j.choose_local_photo), getPageContext().getString(t.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            cVar.cb(t.j.operation);
            cVar.a(strArr, new al(this));
            cVar.d(getPageContext());
            cVar.un();
        }
    }

    private void c(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        String[] strArr = {getPageContext().getString(t.j.look_big_photo), getPageContext().getString(t.j.set_as_portrait_photo), getPageContext().getString(t.j.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.cb(t.j.operation);
        cVar.a(strArr, new am(this, gVar, list, i));
        cVar.d(getPageContext());
        cVar.un();
    }

    private String le(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        if (gVar != null && list != null && !StringUtils.isNull(gVar.Cg())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.tbadk.data.g gVar2 : list) {
                if (gVar2 != null && !gVar2.isAdded()) {
                    if (gVar2.Ch()) {
                        arrayList.add(le(gVar2.Cg()));
                    } else {
                        arrayList.add(gVar2.Cg());
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
    public void avg() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.aKq.getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avh() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.aKq.getPageContext().getPageActivity(), 12014, this.dic)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.g gVar) {
        if (gVar != null && !StringUtils.isNull(gVar.Cg())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
            httpMessage.addParam("pic_url", gVar.Cg());
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        if (gVar != null && list != null && list.size() > 2 && !StringUtils.isNull(gVar.Cg())) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tbadk.data.g gVar2 = list.get(i2);
                if (gVar2 != null && !gVar2.isAdded() && !gVar2.Ch() && i2 != i) {
                    jSONArray.put(gVar2.Cg());
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
                if (gVar != null && !gVar.isAdded() && !gVar.Ch()) {
                    jSONArray.put(gVar.Cg());
                }
            }
            jSONArray.put(str);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
            httpMessage.addParam("pic_list", jSONArray.toString());
            sendMessage(httpMessage);
        }
    }

    private void avi() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_USER_PICS, TbConfig.SET_USER_PICS);
        tbHttpMessageTask.setResponsedClass(SetUserPicsResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CHANGE_PORTRAIT, TbConfig.CHANGE_USER_PORTRAIT);
        tbHttpMessageTask2.setResponsedClass(ChangePortraitResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    private void R(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.dic)));
            }
            this.writeImagesInfo.clear();
        }
    }

    private void J(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.dbl.getUserData() != null && this.bDs) {
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.dbl.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.Ed().fF(this.dbl.getUserData().getPortrait());
                }
            }
            this.dhU = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        J(intent);
                    } else {
                        R(intent);
                    }
                }
            } else if (i == 12010 || i == 12009) {
                if (intent != null) {
                    int intExtra = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra == 1) {
                        avj();
                    } else if (intExtra == 2) {
                        avl();
                    }
                }
            } else if (i == 12014) {
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra2 == 1) {
                        avj();
                    } else if (intExtra2 == 2) {
                        avl();
                    }
                }
            } else if (i == 24001) {
                if (intent != null && this.dhR != null) {
                    this.dhR.startLoad();
                    this.dhR.awf().setGiftIcon(false);
                }
            } else if (i == 24004 && intent != null && intent.getBooleanExtra(MissonDetailsActivityConfig.IS_UPGRADE_SUCCESS, false)) {
                com.baidu.tbadk.b.a.a(getBaseFragmentActivity()).b(this);
            }
        }
    }

    private void avj() {
        if (this.dbl != null && this.dbl.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.Ed().fF(this.dbl.getUserData().getPortrait());
        }
        this.dhU = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avk() {
        if (!this.dih) {
            this.dih = true;
            this.dio.postDelayed(this.mRunnable, 300L);
        }
    }

    private void avl() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new ao(this));
    }

    private void avm() {
        if (this.dbl != null && this.dbl.avA() != null && this.dhS != null && this.dhR != null) {
            this.dhR.a(this.dbl.avA().getIsFriend() == 1, this.dhS.getMaskType() == 1, this.did);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.person.data.d dVar) {
        UserData userData = this.dbl.getUserData();
        switch (dVar.mType) {
            case 0:
                if (com.baidu.tbadk.core.util.bi.ah(getPageContext().getPageActivity())) {
                    this.dhZ.f(false, 3);
                    this.dhZ.fU(true);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10597"));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(getActivity().getApplicationContext())));
                    return;
                }
                return;
            case 1:
                if (com.baidu.tbadk.core.util.bi.ah(getPageContext().getPageActivity())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10602"));
                    this.dhZ.f(false, 1);
                    if (userData != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(getActivity().getApplicationContext())));
                        return;
                    }
                    return;
                }
                return;
            case 2:
                if (com.baidu.tbadk.core.util.bi.ah(getPageContext().getPageActivity())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10604"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(getActivity().getApplicationContext())));
                    return;
                }
                return;
            case 3:
                avo();
                return;
            case 4:
                avn();
                return;
            case 5:
                if (com.baidu.tbadk.core.util.bi.ah(getPageContext().getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void avn() {
        if (com.baidu.tbadk.core.util.bi.ah(getPageContext().getPageActivity()) && this.dbl != null) {
            UserData userData = this.dbl.getUserData();
            if (this.dbl.getIsSelf()) {
                TiebaStatic.log("person_self_attentionper_click");
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10600"));
            } else {
                TiebaStatic.log("person_guid_attentionper_click");
            }
            if (userData != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), true, userData.getUserId(), userData.getSex())));
            }
        }
    }

    private void avo() {
        if (com.baidu.tbadk.core.util.bi.ah(getPageContext().getPageActivity()) && this.dbl != null) {
            UserData userData = this.dbl.getUserData();
            if (this.dbl.getIsSelf()) {
                TiebaStatic.log("person_self_attentionme_click");
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10599"));
            } else {
                TiebaStatic.log("person_guid_attentionme_click");
            }
            this.dhZ.f(false, 2);
            if (userData != null) {
                if (this.dhR != null) {
                    this.dhR.gf(false);
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

    private void p(Bundle bundle) {
        this.dbl = new bf(getBaseFragmentActivity());
        this.dbl.atY();
        this.dhS = new BlackListModel(getPageContext());
        this.mPersonChangeData = new PersonChangeData();
        a(this.dbl, bundle);
        this.dbl.setLoadDataCallBack(new ap(this));
        this.cMI = new UserMuteAddAndDelModel(getPageContext());
        this.cMI.a(this.cNb);
        this.cMI.a(this.diw);
        this.cMJ = new com.baidu.tieba.usermute.i(getPageContext(), this.cNc);
        this.dcn = new com.baidu.tieba.person.god.h(getPageContext());
    }

    private void a(bf bfVar, Bundle bundle) {
        if (bundle != null) {
            bfVar.lg(bundle.getString("from"));
            String string = bundle.getString("un");
            bfVar.setId(string);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (string != null && currentAccount != null && string.equals(currentAccount)) {
                bfVar.setIsSelf(true);
            } else {
                bfVar.setIsSelf(false);
            }
            bfVar.setName(bundle.getString("name"));
            bfVar.gd(bundle.getBoolean("tab_page", false));
            bfVar.ge(bundle.getBoolean("tab_msg", false));
            bfVar.setStType(bundle.getString("st_type"));
            this.dii = bundle.getInt(PersonInfoActivityConfig.FANS_NUM);
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
            bfVar.lg(intent.getStringExtra("from"));
            bfVar.gd(intent.getBooleanExtra("tab_page", false));
            bfVar.ge(intent.getBooleanExtra("tab_msg", false));
            bfVar.setStType(intent.getStringExtra("st_type"));
            this.dii = intent.getIntExtra(PersonInfoActivityConfig.FANS_NUM, 0);
            return;
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        bfVar.setIsSelf(true);
        if (currentAccountObj != null) {
            bfVar.setId(currentAccountObj.getID());
            bfVar.setName(currentAccountObj.getAccount());
        }
    }

    private void aJ(View view) {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(t.j.unlogin_person_button_text), new ar(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(t.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(t.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(t.e.ds60);
        NoDataViewFactory.b a = NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(t.e.ds20));
        this.dhY.setVisibility(8);
        this.dhX.setVisibility(0);
        this.dhX.switchNaviBarStatus(this.mIsLogin);
        this.dhX.setLoginClickListener(new as(this));
        this.dhX.setRegisterClickListener(new at(this));
        this.mNoDataView = NoDataViewFactory.a(getActivity(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.x(t.j.unlogin_person_msg_text, dimensionPixelSize4), a);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void avp() {
        if (this.aXf == null) {
            this.aXf = new com.baidu.tieba.tbadkCore.d.b("profileStat");
            this.aXf.start();
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        int EE = bVar.EE();
        bVar.EF();
        switch (EE) {
            case 1:
                avo();
                return true;
            case 2:
                avn();
                return true;
            case 3:
                avr();
                return true;
            case 4:
                avt();
                return true;
            case 5:
                com.baidu.tbadk.core.util.be.wt().c(getPageContext(), new String[]{daJ});
                return true;
            default:
                return false;
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.ar.l(this.azA, t.d.cp_bg_line_d);
        if (this.NR != null) {
            this.NR.onChangeSkinType(getPageContext(), i);
        }
        if (this.dhW != null) {
            this.dhW.onChangeSkinType(getPageContext(), i);
        }
        if (this.dhR != null) {
            this.dhR.onChangeSkinType(i);
        }
        if (this.dhX != null) {
            this.dhX.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public com.baidu.tieba.person.a.al avq() {
        return this.dhZ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData userData;
        if (this.dhR != null) {
            if (this.dhR.awm() != null && view.getId() == this.dhR.awm().getId()) {
                this.aKq.finish();
                return;
            }
            this.dbl.getIsSelf();
            String id = this.dbl.getId();
            if (view.getId() == this.dhR.getHeadImage().getId()) {
                UserData userData2 = this.dbl.getUserData();
                if (userData2 != null) {
                    com.baidu.tbadk.data.g gVar = new com.baidu.tbadk.data.g();
                    gVar.eS(userData2.getPortraitH());
                    gVar.eT(userData2.getPortrait());
                    gVar.bd(true);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(gVar);
                    if (this.bDs) {
                        b(gVar, arrayList, 0);
                    } else {
                        d(gVar, arrayList, 0);
                    }
                }
            } else if (this.dhR.awl() != null && view.getId() == this.dhR.awl().getId()) {
                if (!this.bDs) {
                    if (id != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10623").aa("obj_id", id));
                    }
                    avm();
                }
            } else if (view.getId() == this.dhR.awf().getVipIcon().getId()) {
                TiebaStatic.log(this.dif);
                if (com.baidu.tbadk.core.util.bi.ah(getActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(getActivity())));
                }
            } else if (view.getId() == this.dhR.getAttentionView().getId()) {
                if (com.baidu.tbadk.core.util.bi.ah(getActivity())) {
                    this.dbl.avC();
                }
            } else if (view.getId() == this.dhR.awg().getId()) {
                avt();
            } else if (view.getId() == this.dhR.getUserIcon().getId()) {
                avr();
            } else if (view.getId() == this.dhR.awf().getMyGiftIcon().getId()) {
                TiebaStatic.log("igift_icon_ck");
                if (com.baidu.tbadk.core.util.bi.ah(getActivity()) && (userData = this.dbl.getUserData()) != null) {
                    if (!com.baidu.adp.lib.util.k.jq()) {
                        showToast(t.j.no_signall_data);
                        return;
                    }
                    this.dhQ = true;
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10613").aa("obj_id", id).r("obj_param1", this.dia));
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData.getUserIdLong(), userData.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001)));
                    this.dhR.awf().setGiftIcon(true);
                }
            } else if (view.getId() == this.dhR.getMyGiftIcon().getId()) {
                if (com.baidu.tbadk.core.util.bi.ah(getActivity())) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData3 = this.dbl.getUserData();
                    if (userData3 != null) {
                        if (!com.baidu.adp.lib.util.k.jq()) {
                            showToast(t.j.no_signall_data);
                            return;
                        }
                        this.dhQ = true;
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData3.getUserIdLong(), userData3.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                    }
                }
            } else if (this.dhR.atT() != null && view.getId() == this.dhR.atT().getId()) {
                this.dhR.awk();
                avs();
            } else if (this.dhR.atS() != null && view.getId() == this.dhR.atS().getId()) {
                this.dhR.awk();
                if (this.dbl.getUserData() != null) {
                    com.baidu.tbadk.newFriends.a.Fs().L(this.dbl.getUserData().getUserIdLong());
                }
            } else if (this.dhR.atU() != null && view.getId() == this.dhR.atU().getId()) {
                this.dhR.awk();
                if (this.dbl != null) {
                    if (!com.baidu.adp.lib.util.i.iZ()) {
                        showToast(t.j.neterror);
                    } else if (this.did == 0) {
                        this.cMI.a(false, this.dbl.getUserData().getUserId(), this.dbl.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    } else if (this.did == 1) {
                        this.cMI.a(true, this.dbl.getUserData().getUserId(), this.dbl.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    }
                }
            }
        }
    }

    private void avr() {
        if (this.dbl.getUserData() != null) {
            boolean isSelf = this.dbl.getIsSelf();
            String id = this.dbl.getId();
            if (isSelf) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10603"));
            } else if (id != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10607").aa("obj_id", id));
            }
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getPageContext().getString(t.j.user_icon_web_view_title), String.valueOf(cSD) + "?user_id=" + this.dbl.getUserData().getUserId(), true, true, true);
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10134").r("obj_type", 1));
        }
    }

    private void avs() {
        String format;
        String userName = this.dbl.getUserData() != null ? this.dbl.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(t.j.confirm, new au(this));
            aVar.b(t.j.cancel, new av(this));
            if (this.dhS.getMaskType() == 1) {
                format = String.format(getPageContext().getString(t.j.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(t.j.block_chat_message_alert), userName);
            }
            aVar.cE(format);
            aVar.b(getPageContext());
            aVar.uj();
        }
    }

    private void avt() {
        if (com.baidu.tbadk.core.util.bi.ah(getActivity())) {
            if (this.userId != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10622").aa("obj_id", this.userId));
            }
            if (this.dbl.getUserData() != null && this.dbl.getUserData().getIsOfficialAccount() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.dbl.getUserData().getUserId(), 0L), this.dbl.getUserData().getUserName(), this.dbl.getUserData().getPortrait(), 0, 4)));
            } else if (this.bDs) {
                if (this.dbl.ajb() != null) {
                    com.baidu.tbadk.browser.f.B(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
                }
            } else {
                PersonTainInfo avA = this.dbl.avA();
                if (avA != null) {
                    int isFriend = avA.getIsFriend();
                    if (this.dbl.avT()) {
                        a(this.dbl.getUserData(), isFriend);
                    } else if (isFriend == 0) {
                        UserData userData = this.dbl.getUserData();
                        if (userData != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.dbl.avB(), avA.getUserClientVersionLower(), this.dbl.getStType())));
                        }
                    } else if (isFriend == 1) {
                        UserData userData2 = this.dbl.getUserData();
                        if (userData2 != null) {
                            if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(t.j.login_to_chat), true, 11028)));
                            } else if (!this.bDs) {
                                a(userData2, isFriend);
                            }
                        }
                    } else if (isFriend == 2) {
                        com.baidu.tbadk.newFriends.a.Fs().b(com.baidu.adp.lib.h.b.c(this.dbl.getId(), 0L), "pers_pg");
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

    public void avu() {
        long j = com.baidu.tbadk.core.sharedPref.b.uO().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
        if (this.dhR != null && this.dhR.djM != null) {
            if (j < TbadkCoreApplication.m411getInst().getLastUpdateThemeTime()) {
                com.baidu.tbadk.core.util.ar.c(this.dhR.djM, t.f.icon_news_down_bar_one);
                this.dhR.djM.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.uO().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
                if (!isPrimary()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true)));
                }
            } else if (this.dhR.djM != null) {
                this.dhR.djM.setImageDrawable(null);
                this.dhR.djM.setVisibility(8);
            }
        }
    }

    public void a(View view, boolean z, int i) {
        this.dhX.setVisibility(0);
        this.dhX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this).setOnClickListener(this);
        if (this.dig == null) {
            if (i < 0) {
                this.dig = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.dig = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.dig.uv();
        }
        this.dig.c(view, z);
    }

    public void aK(View view) {
        this.dhX.setVisibility(8);
        if (this.dig != null) {
            this.dig.H(view);
            this.dig = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        this.dhX.setVisibility(0);
        this.dhX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this).setOnClickListener(this);
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new aw(this));
        }
        this.refreshView.eP(getResources().getDimensionPixelSize(t.e.ds160));
        this.refreshView.fN(str);
        this.refreshView.c(view, z);
        this.refreshView.Eu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avv() {
        this.dhX.setVisibility(8);
        if (this.refreshView != null) {
            this.refreshView.H(this.dhY);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avw() {
        if (this.dbl != null) {
            this.dbl.avQ();
            if (this.dhR != null && this.dhR.djZ != null) {
                this.dhR.djZ.aa(this.dbl.getDataList());
                this.dhR.djZ.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.b.b.a
    public void a(boolean z, int i, int i2, com.baidu.tbadk.core.data.q qVar) {
        if (z && i2 == 100) {
            this.dbl.b(qVar);
        }
    }
}
