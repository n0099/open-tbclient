package com.baidu.tieba.write;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.plugins.PluginCheckUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.a;
import com.baidu.tieba.write.g;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes.dex */
public class f {
    private com.baidu.tbadk.n.a.a BH;
    private int bgColor;
    private TbPageContext cVv;
    private ForumWriteData kEC;
    private a kNT;
    private boolean kNU;
    private g kNV;
    private String kNW;
    private String kNX;
    private g.a kNY;
    private g.a kop;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.kNU = false;
        this.mSkinType = 3;
        this.kNW = "";
        this.mFrom = "write";
        this.kNX = "0";
        this.kNY = new g.a() { // from class: com.baidu.tieba.write.f.1
            @Override // com.baidu.tieba.write.g.a
            public void CW(int i2) {
                if (i2 == 1) {
                    f.this.kNU = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.kNV instanceof d)) {
                        if (f.this.BH == null) {
                            f.this.BH = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        f.this.BH.aRx();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 2) {
                    if (f.this.BH != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.kNV instanceof d)) {
                        f.this.BH.aRy();
                    }
                    f.this.cUM();
                } else if (i2 == 4) {
                    f.this.kNU = false;
                    if (f.this.kNT.mRootView.getParent() == f.this.mParentView && f.this.mParentView != null && f.this.kNT.mRootView != null && f.this.mParentView.indexOfChild(f.this.kNT.mRootView) > 0) {
                        f.this.mParentView.removeView(f.this.kNT.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
                if (f.this.kop != null) {
                    f.this.kop.CW(i2);
                }
            }
        };
        this.cVv = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.C0631a c0631a = new a.C0631a(this.cVv, this);
            this.kNT = c0631a;
            this.kNV = new d(tbPageContext.getPageActivity(), c0631a);
        } else {
            a.b bVar = new a.b(this.cVv, this);
            this.kNT = bVar;
            this.kNV = new e(tbPageContext.getPageActivity(), bVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.kNV.b(this.kNY);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void KM(String str) {
        if (str == null) {
            str = "";
        }
        this.kNW = str;
    }

    public String bKH() {
        return this.kNW;
    }

    public void a(ForumWriteData forumWriteData) {
        this.kEC = forumWriteData;
    }

    public void KN(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.kNX = str;
    }

    public boolean isShowing() {
        return this.kNU;
    }

    public void Ek(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.kNT.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bh(this.mParentView).attachView(this.mParentView, this.kNT.mRootView, z);
            }
            this.kNV.g(view, view2);
            this.kNV.show();
            TiebaStatic.log(new an("c12052").cx("obj_locate", this.kNX));
            if (j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.cVv.getContext(), string).aEL();
                    com.baidu.tbadk.core.sharedPref.b.aFH().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void El(int i) {
        if (this.kNT instanceof a.b) {
            ((a.b) this.kNT).kNl.setIconFade(i);
        }
    }

    public void tP(boolean z) {
        this.kNV.du(z);
        if (!z && (this.kNT instanceof a.b)) {
            ((a.b) this.kNT).kNl.aQb();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.kNT.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.kNT.mRootView != null && this.kNT.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.kNT.mRootView);
        }
        this.kNV.onDestroy();
    }

    public void cUI() {
        if (this.kNT instanceof a.C0631a) {
            TiebaStatic.log("c13619");
            cUM();
        }
        tP(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVv.getPageActivity());
            aVar.setAutoNight(false);
            aVar.jV(R.string.prompt);
            aVar.sS(this.cVv.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.cVv).aEG();
            return;
        }
        a(this.cVv, this.kNX, this.kEC);
    }

    public void a(TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (tbPageContext != null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.a(new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.write.f.3
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
                public void onPermissionsGranted() {
                    String str2;
                    String str3 = null;
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    String str4 = "0";
                    com.baidu.adp.lib.c.a.fK().getAddress(false);
                    if (forumWriteData != null) {
                        str4 = forumWriteData.forumId;
                        str2 = forumWriteData.forumName;
                        str3 = forumWriteData.specialForumType;
                    } else {
                        str2 = null;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cx("obj_locate", str).X("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(f.this.cVv.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void cUJ() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        tP(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.kEC == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.kEC.forumId;
            String str7 = this.kEC.forumName;
            postPrefixData = this.kEC.prefixData;
            antiData = this.kEC.antiData;
            int i3 = this.kEC.forumLevel;
            String str8 = this.kEC.avatar;
            int i4 = this.kEC.privateThread;
            String str9 = this.kEC.firstDir;
            str = this.kEC.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cx("obj_locate", this.kNX).X("obj_type", 3));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            com.baidu.tbadk.data.h aNX = com.baidu.tbadk.data.h.aNX();
            if (aNX != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, aNX));
                return;
            }
            return;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cVv.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.kEC != null ? this.kEC.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.kEC != null ? this.kEC.frsTabInfo : null);
        if (!StringUtils.isNull(this.kNW)) {
            writeActivityConfig.setTitle(this.kNW, true);
        }
        if (!a(this.cVv.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void cUK() {
        com.baidu.tbadk.data.h aNY;
        tP(false);
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cx("obj_locate", this.kNX).X("obj_type", 2));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            if (PluginCheckUtil.vO("com.baidu.tieba.pluginPublisher") && (aNY = com.baidu.tbadk.data.h.aNY()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921429, aNY));
                return;
            }
            return;
        }
        if (this.kEC == null) {
            this.kEC = new ForumWriteData("0", null, null, null);
        }
        this.kEC.mFrom = this.mFrom;
        this.kEC.writeCallFrom = this.writeCallFrom;
        i.b(this.cVv, "", this.kEC);
    }

    public void KO(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        tP(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.kEC == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.kEC.forumId;
            String str8 = this.kEC.forumName;
            postPrefixData = this.kEC.prefixData;
            antiData = this.kEC.antiData;
            int i3 = this.kEC.forumLevel;
            String str9 = this.kEC.avatar;
            int i4 = this.kEC.privateThread;
            String str10 = this.kEC.firstDir;
            str2 = this.kEC.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cx("obj_locate", this.kNX).X("obj_type", 1));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            com.baidu.tbadk.data.h aNW = com.baidu.tbadk.data.h.aNW();
            if (aNW != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, aNW));
                return;
            }
            return;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cVv.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.kEC != null ? this.kEC.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.kEC != null ? this.kEC.frsTabInfo : null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    private static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionJudgePolicy.a(new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.write.f.4
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
            public void onPermissionsGranted() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, WriteActivityConfig.this));
            }
        });
        return permissionJudgePolicy.startRequestPermission(activity);
    }

    public void cUL() {
        if (this.kNT != null) {
            this.kNT.cUv();
        }
    }

    public void a(g.a aVar) {
        this.kop = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUM() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("home_publish_ala_has_showed", false);
        if (this.kNT instanceof a.C0631a) {
            ((a.C0631a) this.kNT).tM(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("home_publish_ala_has_showed", true);
    }
}
