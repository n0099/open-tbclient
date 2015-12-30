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
    private static final String cKl = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    public static boolean cWk = false;
    private BaseFragmentActivity aJl;
    private ViewEventCenter aUs;
    private boolean aUv;
    private UserMuteAddAndDelModel cFo;
    private com.baidu.tieba.usermute.i cFp;
    private bb cRx;
    private be cWi;
    private BlackListModel cWj;
    private LinearLayout cWm;
    private NoNetworkView cWn;
    private NavigationBar cWo;
    private FrameLayout cWp;
    private com.baidu.tieba.person.a.ah cWq;
    private List<com.baidu.tbadk.data.g> cWs;
    public boolean cWv;
    private com.baidu.tbadk.f.f cWx;
    private boolean cWy;
    private boolean mIsLogin;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private NoNetworkView mNoNetworkView;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tbadk.f.h refreshView;
    private View rootView;
    private boolean cWh = false;
    private boolean mIsHost = true;
    private com.baidu.tieba.tbadkCore.d.a aUT = null;
    private boolean cBJ = false;
    private boolean cWl = false;
    private String userId = "";
    private int cWr = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean cWt = true;
    private int cWu = -1;
    private String cWw = "c10474";
    private final CustomMessageListener cWz = new e(this, CmdConfigCustom.CMD_YINJIN_CHANGE);
    private HttpMessageListener cWA = new p(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener cWB = new aa(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private CustomMessageListener cWC = new am(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);
    private Handler cWD = new Handler();
    private Runnable mRunnable = new at(this);
    private com.baidu.adp.framework.listener.a cWE = new au(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
    private CustomMessageListener aUB = new av(this, CmdConfigCustom.MAINTAB_TAB_RESET_TABS);
    private final com.baidu.adp.framework.listener.a cWF = new aw(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    private final com.baidu.adp.framework.listener.e cWG = new ax(this, 104102);
    final com.baidu.adp.framework.listener.e cWH = new f(this, 304102);
    final CustomMessageListener cWI = new g(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final CustomMessageListener aKQ = new h(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    private final com.baidu.adp.framework.listener.e cWJ = new i(this, 304103);
    private final CustomMessageListener cBO = new j(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener cjp = new k(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private i.a cFF = new l(this);
    private final CustomMessageListener cWK = new m(this, CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    private UserMuteAddAndDelModel.a cFE = new n(this);
    private UserMuteAddAndDelModel.b cWL = new o(this);
    private final CustomMessageListener cWM = new q(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    final CustomMessageListener cWN = new r(this, CmdConfigCustom.CMD_BUY_YINJI_SUCCESS);
    private CustomMessageListener cWO = new s(this, CmdConfigCustom.CMD_LEFT_NAV_DRESSUP_CENTER_TIP);
    private CustomMessageListener cWP = new t(this, CmdConfigCustom.CMD_PHOTO_LIVE_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener cWQ = new u(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener cWR = new v(this, CmdConfigCustom.CMD_FORUMFEED_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener cWS = new w(this, CmdConfigCustom.CMD_COLLECTION_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener cir = new x(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
    private CustomMessageListener cWT = new y(this, CmdConfigCustom.CMD_PERSON_INFO_CHANGED);
    private CustomMessageListener cWU = new z(this, CmdConfigCustom.CMD_FORUM_FEED_SWITCH_CHANGE);

    public bb apO() {
        return this.cRx;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aJl = getBaseFragmentActivity();
        this.aUs = new ViewEventCenter();
        this.aUs.addEventDelegate(this);
        this.cWv = this.aJl instanceof PersonInfoActivity;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        apT();
        i(bundle);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (!this.mIsLogin) {
            this.cBJ = true;
        }
        this.mIsHost = this.cRx.getIsSelf();
        this.userId = this.cRx.getId();
        this.cWr = this.cRx.aqH();
        registerListener();
        apY();
        if (!this.mIsHost) {
            apP();
        }
    }

    private void registerListener() {
        registerListener(this.aUB);
        registerListener(this.cWF);
        registerListener(this.cWG);
        registerListener(this.cWH);
        registerListener(this.cWI);
        registerListener(this.cWJ);
        registerListener(this.aKQ);
        registerListener(this.cBO);
        registerListener(this.cWA);
        registerListener(this.cWB);
        registerListener(this.cjp);
        registerListener(this.cWz);
        registerListener(this.cWK);
        registerListener(this.cWM);
        registerListener(this.cWN);
        registerListener(this.cWO);
        registerListener(this.cWC);
        registerListener(this.cWE);
        registerListener(this.cWP);
        registerListener(this.cWS);
        registerListener(this.cir);
        registerListener(this.cWQ);
        registerListener(this.cWR);
        registerListener(this.cWT);
        registerListener(this.cWU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cRx.aqs();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = c(layoutInflater);
        if (this.cRx != null) {
            this.cWp = (FrameLayout) this.rootView.findViewById(n.g.root_layout);
            this.cWm = (LinearLayout) this.rootView.findViewById(n.g.unlogin_no_network_root);
            this.cWn = (NoNetworkView) this.cWm.findViewById(n.g.view_unlogin_no_network);
            this.mNoNetworkView = (NoNetworkView) this.rootView.findViewById(n.g.view_no_network);
            this.mNoNetworkView.a(new ab(this));
            this.mNoNetworkView.setAlpha(0.95f);
            this.cWo = (NavigationBar) this.rootView.findViewById(n.g.nologin_navigation_bar);
            if (!this.mIsLogin && this.mIsHost) {
                this.cWm.setVisibility(0);
                at(this.rootView);
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
            } else {
                this.cWm.setVisibility(8);
                B(this.rootView);
            }
            this.cWq = new com.baidu.tieba.person.a.ah(this);
            this.cWq.apm();
        }
        this.rootView.setOnTouchListener(new ac(this));
        return this.rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cRx != null && this.cWi != null && this.cWi.aqO() != null) {
            if (isPrimary()) {
                UserData userData = this.cRx != null ? this.cRx.getUserData() : null;
                if (this.cWi != null && this.cWi.aqO() != null) {
                    this.cWi.aqO().g(userData);
                }
            } else if (this.cWi != null && this.cWi.aqO() != null) {
                this.cWi.aqO().aqg();
            }
            if (this.cWq != null) {
                this.cWq.fE(isPrimary());
                this.cWq.apo();
            }
            if (isPrimary() && com.baidu.adp.lib.util.i.iQ()) {
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    int memberType = currentAccountObj.getMemberType();
                    if (memberType == 0) {
                        memberType = 0;
                    } else if (memberType > 0) {
                        memberType = 1;
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10407").r("obj_type", memberType));
                }
                if (!this.cBJ && this.mIsLogin) {
                    a((View) this.cWp, false, -1);
                    this.cRx.aqu();
                } else if (this.cWl) {
                    this.cRx.aqu();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && TbadkCoreApplication.isLogin() && Boolean.valueOf(com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("need_show_yinji", true)).booleanValue() && TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("need_show_yinji", false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cFp.onDestroy();
        this.cFo.onDestory();
        if (this.cWi != null) {
            this.cWi.onDestroy();
        }
        if (this.cWx != null) {
            this.cWx.u(this.rootView);
            this.cWx = null;
        }
        if (this.mIsHost) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_PORTRAIT_CLICK));
        }
        this.cWD.removeCallbacks(this.mRunnable);
        if (this.cWq != null) {
            this.cWq.onDestroy();
        }
    }

    private void B(View view) {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        if (this.cWo != null) {
            this.cWo.setVisibility(8);
        }
        this.cWi = new be(this, this.mIsHost, view);
        this.cWi.setPersonListRefreshListener(new ad(this));
        if (this.mIsHost) {
            this.cRx.aqt();
        } else {
            a((View) this.cWp, false, -1);
            this.cRx.aqu();
        }
        this.cWi.b(new ae(this));
        this.cWi.H(new af(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apP() {
        long c = com.baidu.adp.lib.h.b.c(this.cRx.getId(), 0L);
        this.cFp.d(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        if (gVar != null) {
            if (!com.baidu.adp.lib.util.k.jh()) {
                showToast(n.j.neterror);
            } else if (!this.mIsHost) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10617").aa("obj_id", this.userId));
                d(gVar, list, i);
            } else if (gVar.isAdded()) {
                apQ();
            } else if (gVar.AR()) {
                b(gVar, list, i);
            } else {
                c(gVar, list, i);
            }
        }
    }

    private void b(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        String[] strArr = {getPageContext().getString(n.j.hd_photo), getPageContext().getString(n.j.change_photo), getPageContext().getString(n.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bJ(n.j.operation);
        cVar.a(strArr, new ag(this, gVar, list, i));
        cVar.d(getPageContext());
        cVar.tj();
    }

    private void apQ() {
        String[] strArr = {getPageContext().getString(n.j.choose_local_photo), getPageContext().getString(n.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bJ(n.j.operation);
        cVar.a(strArr, new ah(this));
        cVar.d(getPageContext());
        cVar.tj();
    }

    private void c(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        String[] strArr = {getPageContext().getString(n.j.look_big_photo), getPageContext().getString(n.j.set_as_portrait_photo), getPageContext().getString(n.j.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bJ(n.j.operation);
        cVar.a(strArr, new ai(this, gVar, list, i));
        cVar.d(getPageContext());
        cVar.tj();
    }

    private String kU(String str) {
        return ((float) getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        if (gVar != null && list != null && !StringUtils.isNull(gVar.AQ())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.tbadk.data.g gVar2 : list) {
                if (gVar2 != null && !gVar2.isAdded()) {
                    if (gVar2.AR()) {
                        arrayList.add(kU(gVar2.AQ()));
                    } else {
                        arrayList.add(gVar2.AQ());
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
    public void apR() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.aJl.getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.aJl.getPageContext().getPageActivity(), 12014, this.cWt)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.g gVar) {
        if (gVar != null && !StringUtils.isNull(gVar.AQ())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
            httpMessage.addParam("pic_url", gVar.AQ());
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.data.g gVar, List<com.baidu.tbadk.data.g> list, int i) {
        if (gVar != null && list != null && list.size() > 2 && !StringUtils.isNull(gVar.AQ())) {
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tbadk.data.g gVar2 = list.get(i2);
                if (gVar2 != null && !gVar2.isAdded() && !gVar2.AR() && i2 != i) {
                    jSONArray.put(gVar2.AQ());
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
                if (gVar != null && !gVar.isAdded() && !gVar.AR()) {
                    jSONArray.put(gVar.AQ());
                }
            }
            jSONArray.put(str);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SET_USER_PICS);
            httpMessage.addParam("pic_list", jSONArray.toString());
            sendMessage(httpMessage);
        }
    }

    private void apT() {
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
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.cWt)));
            }
            this.writeImagesInfo.clear();
        }
    }

    private void J(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.cRx.getUserData() != null && this.mIsHost) {
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                if (this.cRx.getUserData() != null) {
                    com.baidu.tbadk.imageManager.c.CM().fH(this.cRx.getUserData().getPortrait());
                }
            }
            this.cWl = true;
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
                        getAlbumDataFromImage(intent);
                    }
                }
            } else if (i == 12010 || i == 12009) {
                if (intent != null) {
                    int intExtra = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra == 1) {
                        apU();
                    } else if (intExtra == 2) {
                        apW();
                    }
                }
            } else if (i == 12014) {
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra("upload_image_type", 0);
                    if (intExtra2 == 1) {
                        apU();
                    } else if (intExtra2 == 2) {
                        apW();
                    }
                }
            } else if (i == 24001 && intent != null && this.cWi != null) {
                this.cWi.startLoad();
                this.cWi.aqO().fL(false);
            }
        }
    }

    private void apU() {
        if (this.cRx.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.CM().fH(this.cRx.getUserData().getPortrait());
        }
        this.cWl = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apV() {
        if (!this.cWy) {
            this.cWy = true;
            this.cWD.postDelayed(this.mRunnable, 300L);
        }
    }

    private void apW() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new aj(this));
    }

    private void apX() {
        if (this.cRx != null && this.cRx.aqp() != null && this.cWj != null && this.cWi != null) {
            this.cWi.a(this.cRx.aqp().getIsFriend() == 1, this.cWj.getMaskType() == 1, this.cWu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.person.data.d dVar) {
        UserData userData = this.cRx.getUserData();
        switch (dVar.mType) {
            case 0:
                this.cWq.c(false, 3);
                this.cWq.fF(true);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10597"));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(getActivity().getApplicationContext())));
                return;
            case 1:
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10602"));
                this.cWq.c(false, 1);
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
                if (this.cRx.getIsSelf()) {
                    TiebaStatic.log("person_self_attentionme_click");
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10599"));
                } else {
                    TiebaStatic.log("person_guid_attentionme_click");
                }
                this.cWq.c(false, 2);
                if (userData != null) {
                    if (this.cWi != null) {
                        this.cWi.fO(false);
                    }
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(getPageContext().getPageActivity(), false, userData.getUserId(), userData.getSex())));
                    return;
                }
                return;
            case 4:
                if (this.cRx.getIsSelf()) {
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
        return layoutInflater.inflate(n.h.personinfo_tab_view, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    private void i(Bundle bundle) {
        this.cRx = new bb(getBaseFragmentActivity());
        this.cRx.apf();
        this.cWj = new BlackListModel(getPageContext());
        this.mPersonChangeData = new PersonChangeData();
        a(this.cRx, bundle);
        this.cRx.setLoadDataCallBack(new ak(this));
        this.cFo = new UserMuteAddAndDelModel(getPageContext());
        this.cFo.a(this.cFE);
        this.cFo.a(this.cWL);
        this.cFp = new com.baidu.tieba.usermute.i(getPageContext(), this.cFF);
    }

    private void a(bb bbVar, Bundle bundle) {
        if (bundle != null) {
            bbVar.kW(bundle.getString("from"));
            bbVar.setIsSelf(bundle.getBoolean("self", true));
            bbVar.setId(bundle.getString("un"));
            bbVar.setName(bundle.getString("name"));
            bbVar.fM(bundle.getBoolean("tab_page", false));
            bbVar.fN(bundle.getBoolean("tab_msg", false));
            bbVar.setStType(bundle.getString("st_type"));
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getStringExtra("un") != null) {
            bbVar.kW(intent.getStringExtra("from"));
            bbVar.setIsSelf(intent.getBooleanExtra("self", false));
            bbVar.setId(intent.getStringExtra("un"));
            bbVar.setName(intent.getStringExtra("name"));
            bbVar.fM(intent.getBooleanExtra("tab_page", false));
            bbVar.fN(intent.getBooleanExtra("tab_msg", false));
            bbVar.setStType(intent.getStringExtra("st_type"));
            return;
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        bbVar.setIsSelf(true);
        if (currentAccountObj != null) {
            bbVar.setId(currentAccountObj.getID());
            bbVar.setName(currentAccountObj.getAccount());
        }
    }

    private void at(View view) {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(n.j.unlogin_person_button_text), new an(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(n.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(n.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(n.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(n.e.ds60);
        NoDataViewFactory.b a = NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(n.e.ds20));
        this.cWp.setVisibility(8);
        this.cWo.setVisibility(0);
        this.cWo.switchNaviBarStatus(this.mIsLogin);
        this.cWo.setLoginClickListener(new ao(this));
        this.cWo.setRegisterClickListener(new ap(this));
        this.mNoDataView = NoDataViewFactory.a(getActivity(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, n.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(n.j.unlogin_person_msg_text, dimensionPixelSize4), a);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void apY() {
        if (this.aUT == null) {
            this.aUT = new com.baidu.tieba.tbadkCore.d.a("profileStat");
            this.aUT.start();
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean on() {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.as.j(this.rootView, n.d.cp_bg_line_d);
        if (this.mNoNetworkView != null) {
            this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        }
        if (this.cWn != null) {
            this.cWn.onChangeSkinType(getPageContext(), i);
        }
        if (this.cWi != null) {
            this.cWi.onChangeSkinType(i);
        }
        if (this.cWo != null) {
            this.cWo.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public com.baidu.tieba.person.a.ah apZ() {
        return this.cWq;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData userData;
        if (this.cWi != null) {
            if (this.cWi.aqV() != null && view.getId() == this.cWi.aqV().getId()) {
                this.aJl.finish();
                return;
            }
            boolean isSelf = this.cRx.getIsSelf();
            String id = this.cRx.getId();
            if (view.getId() == this.cWi.aqj().getId()) {
                UserData userData2 = this.cRx.getUserData();
                if (userData2 != null) {
                    com.baidu.tbadk.data.g gVar = new com.baidu.tbadk.data.g();
                    gVar.eT(userData2.getPortraitH());
                    gVar.eU(userData2.getPortrait());
                    gVar.bb(true);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(gVar);
                    if (this.mIsHost) {
                        b(gVar, arrayList, 0);
                    } else {
                        d(gVar, arrayList, 0);
                    }
                }
            } else if (this.cWi.aqU() != null && view.getId() == this.cWi.aqU().getId()) {
                if (!this.mIsHost) {
                    if (id != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10623").aa("obj_id", id));
                    }
                    apX();
                }
            } else if (view.getId() == this.cWi.aqO().aqn().getId()) {
                TiebaStatic.log(this.cWw);
                if (com.baidu.tbadk.core.util.bj.ah(getActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(getActivity())));
                }
            } else if (view.getId() == this.cWi.aqm().getId()) {
                if (com.baidu.tbadk.core.util.bj.ah(getActivity())) {
                    this.cRx.aqr();
                }
            } else if (view.getId() == this.cWi.aqP().getId()) {
                if (com.baidu.tbadk.core.util.bj.ah(getActivity())) {
                    if (id != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10622").aa("obj_id", id));
                    }
                    aqc();
                }
            } else if (view.getId() == this.cWi.aqk().getId()) {
                if (isSelf) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10603"));
                } else if (id != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10607").aa("obj_id", id));
                }
                aqa();
            } else if (view.getId() == this.cWi.aqO().aql().getId()) {
                TiebaStatic.log("igift_icon_ck");
                if (com.baidu.tbadk.core.util.bj.ah(getActivity()) && (userData = this.cRx.getUserData()) != null) {
                    if (!com.baidu.adp.lib.util.k.jh()) {
                        showToast(n.j.no_signall_data);
                        return;
                    }
                    this.cWh = true;
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10613").aa("obj_id", id).r("obj_param1", this.cWr));
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData.getUserIdLong(), userData.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001)));
                    this.cWi.aqO().fL(true);
                }
            } else if (view.getId() == this.cWi.aql().getId()) {
                if (com.baidu.tbadk.core.util.bj.ah(getActivity())) {
                    TiebaStatic.log("igift_icon_ck");
                    UserData userData3 = this.cRx.getUserData();
                    if (userData3 != null) {
                        if (!com.baidu.adp.lib.util.k.jh()) {
                            showToast(n.j.no_signall_data);
                            return;
                        }
                        this.cWh = true;
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(getPageContext().getPageActivity(), userData3.getUserIdLong(), userData3.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER)));
                    }
                }
            } else if (this.cWi.apa() != null && view.getId() == this.cWi.apa().getId()) {
                this.cWi.aqT();
                aqb();
            } else if (this.cWi.aoZ() != null && view.getId() == this.cWi.aoZ().getId()) {
                this.cWi.aqT();
                if (this.cRx.getUserData() != null) {
                    com.baidu.tbadk.newFriends.a.DX().I(this.cRx.getUserData().getUserIdLong());
                }
            } else if (this.cWi.apb() != null && view.getId() == this.cWi.apb().getId()) {
                this.cWi.aqT();
                if (this.cRx != null) {
                    if (!com.baidu.adp.lib.util.i.iQ()) {
                        showToast(n.j.neterror);
                    } else if (this.cWu == 0) {
                        this.cFo.a(false, this.cRx.getUserData().getUserId(), this.cRx.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    } else if (this.cWu == 1) {
                        this.cFo.a(true, this.cRx.getUserData().getUserId(), this.cRx.getUserData().getUserName(), null, null, UserMuteAddAndDelModel.From.PersonInfo);
                    }
                }
            }
        }
    }

    private void aqa() {
        if (this.cRx.getUserData() != null) {
            com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getPageContext().getString(n.j.user_icon_web_view_title), String.valueOf(cKl) + "?user_id=" + this.cRx.getUserData().getUserId(), true, true, true);
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10134").r("obj_type", 1));
        }
    }

    private void aqb() {
        String format;
        String userName = this.cRx.getUserData() != null ? this.cRx.getUserData().getUserName() : null;
        if (userName != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.a(n.j.confirm, new aq(this));
            aVar.b(n.j.cancel, new ar(this));
            if (this.cWj.getMaskType() == 1) {
                format = String.format(getPageContext().getString(n.j.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getPageContext().getString(n.j.block_chat_message_alert), userName);
            }
            aVar.cF(format);
            aVar.b(getPageContext());
            aVar.tf();
        }
    }

    private void aqc() {
        if (this.cRx.getUserData() != null && this.cRx.getUserData().getIsOfficialAccount() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(this.cRx.getUserData().getUserId(), 0L), this.cRx.getUserData().getUserName(), this.cRx.getUserData().getPortrait(), 0, 4)));
        } else if (this.mIsHost) {
            if (this.cRx.ala() != null) {
                com.baidu.tbadk.browser.f.B(getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/userappeal");
            }
        } else {
            PersonTainInfo aqp = this.cRx.aqp();
            if (aqp != null) {
                int isFriend = aqp.getIsFriend();
                if (isFriend == 0) {
                    UserData userData = this.cRx.getUserData();
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), this.cRx.aqq(), aqp.getUserClientVersionLower(), this.cRx.getStType())));
                    }
                } else if (isFriend == 1) {
                    UserData userData2 = this.cRx.getUserData();
                    if (userData2 != null) {
                        if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(n.j.login_to_chat), true, 11028)));
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
                    com.baidu.tbadk.newFriends.a.DX().b(com.baidu.adp.lib.h.b.c(this.cRx.getId(), 0L), "pers_pg");
                }
            }
        }
    }

    public void aqd() {
        long j = com.baidu.tbadk.core.sharedPref.b.tJ().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
        if (this.cWi != null && this.cWi.cYa != null) {
            if (j < TbadkCoreApplication.m411getInst().getLastUpdateThemeTime()) {
                com.baidu.tbadk.core.util.as.c(this.cWi.cYa, n.f.icon_news_down_bar_one);
                this.cWi.cYa.setVisibility(0);
                com.baidu.tbadk.core.sharedPref.b.tJ().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
                if (!isPrimary()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_PERSON_TIP, new com.baidu.tbadk.mainTab.a(true)));
                }
            } else if (this.cWi.cYa != null) {
                this.cWi.cYa.setImageDrawable(null);
                this.cWi.cYa.setVisibility(8);
            }
        }
    }

    public void a(View view, boolean z, int i) {
        this.cWo.setVisibility(0);
        this.cWo.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this).setOnClickListener(this);
        if (this.cWx == null) {
            if (i < 0) {
                this.cWx = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.cWx = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.cWx.tr();
        }
        this.cWx.b(view, z);
    }

    public void au(View view) {
        this.cWo.setVisibility(8);
        if (this.cWx != null) {
            this.cWx.u(view);
            this.cWx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        this.cWo.setVisibility(0);
        this.cWo.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this).setOnClickListener(this);
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new as(this));
        }
        this.refreshView.ev(getResources().getDimensionPixelSize(n.e.ds160));
        this.refreshView.fP(str);
        this.refreshView.b(view, z);
        this.refreshView.Dc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqe() {
        this.cWo.setVisibility(8);
        if (this.refreshView != null) {
            this.refreshView.u(this.cWp);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqf() {
        if (this.cRx != null) {
            this.cRx.aqG();
            if (this.cWi != null && this.cWi.cYm != null) {
                this.cWi.cYm.Z(this.cRx.getDataList());
                this.cWi.cYm.notifyDataSetChanged();
            }
        }
    }
}
