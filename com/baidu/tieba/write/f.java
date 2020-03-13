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
    private TbPageContext cVi;
    private ForumWriteData kCV;
    private a kMk;
    private boolean kMl;
    private g kMm;
    private String kMn;
    private String kMo;
    private g.a kMp;
    private g.a kmN;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.kMl = false;
        this.mSkinType = 3;
        this.kMn = "";
        this.mFrom = "write";
        this.kMo = "0";
        this.kMp = new g.a() { // from class: com.baidu.tieba.write.f.1
            @Override // com.baidu.tieba.write.g.a
            public void CO(int i2) {
                if (i2 == 1) {
                    f.this.kMl = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.kMm instanceof d)) {
                        if (f.this.BH == null) {
                            f.this.BH = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        f.this.BH.aRt();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 2) {
                    if (f.this.BH != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.kMm instanceof d)) {
                        f.this.BH.aRu();
                    }
                } else if (i2 == 4) {
                    f.this.kMl = false;
                    if (f.this.kMk.mRootView.getParent() == f.this.mParentView && f.this.mParentView != null && f.this.kMk.mRootView != null && f.this.mParentView.indexOfChild(f.this.kMk.mRootView) > 0) {
                        f.this.mParentView.removeView(f.this.kMk.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
                if (f.this.kmN != null) {
                    f.this.kmN.CO(i2);
                }
            }
        };
        this.cVi = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.C0630a c0630a = new a.C0630a(this.cVi, this);
            this.kMk = c0630a;
            this.kMm = new d(tbPageContext.getPageActivity(), c0630a);
        } else {
            a.b bVar = new a.b(this.cVi, this);
            this.kMk = bVar;
            this.kMm = new e(tbPageContext.getPageActivity(), bVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.kMm.b(this.kMp);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void KM(String str) {
        if (str == null) {
            str = "";
        }
        this.kMn = str;
    }

    public String bKu() {
        return this.kMn;
    }

    public void a(ForumWriteData forumWriteData) {
        this.kCV = forumWriteData;
    }

    public void KN(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.kMo = str;
    }

    public boolean isShowing() {
        return this.kMl;
    }

    public void Ec(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.kMk.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bh(this.mParentView).attachView(this.mParentView, this.kMk.mRootView, z);
            }
            this.kMm.g(view, view2);
            this.kMm.show();
            TiebaStatic.log(new an("c12052").cy("obj_locate", this.kMo));
            if (j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.cVi.getContext(), string).aEH();
                    com.baidu.tbadk.core.sharedPref.b.aFD().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void Ed(int i) {
        if (this.kMk instanceof a.b) {
            ((a.b) this.kMk).kLC.setIconFade(i);
        }
    }

    public void tI(boolean z) {
        this.kMm.dt(z);
        if (!z && (this.kMk instanceof a.b)) {
            ((a.b) this.kMk).kLC.aPX();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.kMk.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.kMk.mRootView != null && this.kMk.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.kMk.mRootView);
        }
        this.kMm.onDestroy();
    }

    public void cUo() {
        tI(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVi.getPageActivity());
            aVar.setAutoNight(false);
            aVar.jV(R.string.prompt);
            aVar.sS(this.cVi.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.cVi).aEC();
            return;
        }
        a(this.cVi, this.kMo, this.kCV);
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
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cy("obj_locate", str).X("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(f.this.cVi.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void cUp() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        tI(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.kCV == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.kCV.forumId;
            String str7 = this.kCV.forumName;
            postPrefixData = this.kCV.prefixData;
            antiData = this.kCV.antiData;
            int i3 = this.kCV.forumLevel;
            String str8 = this.kCV.avatar;
            int i4 = this.kCV.privateThread;
            String str9 = this.kCV.firstDir;
            str = this.kCV.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cy("obj_locate", this.kMo).X("obj_type", 3));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            com.baidu.tbadk.data.h aNT = com.baidu.tbadk.data.h.aNT();
            if (aNT != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, aNT));
                return;
            }
            return;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cVi.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.kCV != null ? this.kCV.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.kMn)) {
            writeActivityConfig.setTitle(this.kMn, true);
        }
        if (!a(this.cVi.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void cUq() {
        com.baidu.tbadk.data.h aNU;
        tI(false);
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cy("obj_locate", this.kMo).X("obj_type", 2));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            if (PluginCheckUtil.vN("com.baidu.tieba.pluginPublisher") && (aNU = com.baidu.tbadk.data.h.aNU()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921429, aNU));
                return;
            }
            return;
        }
        if (this.kCV == null) {
            this.kCV = new ForumWriteData("0", null, null, null);
        }
        this.kCV.mFrom = this.mFrom;
        this.kCV.writeCallFrom = this.writeCallFrom;
        i.b(this.cVi, "", this.kCV);
    }

    public void KO(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        tI(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.kCV == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.kCV.forumId;
            String str8 = this.kCV.forumName;
            postPrefixData = this.kCV.prefixData;
            antiData = this.kCV.antiData;
            int i3 = this.kCV.forumLevel;
            String str9 = this.kCV.avatar;
            int i4 = this.kCV.privateThread;
            String str10 = this.kCV.firstDir;
            str2 = this.kCV.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cy("obj_locate", this.kMo).X("obj_type", 1));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            com.baidu.tbadk.data.h aNS = com.baidu.tbadk.data.h.aNS();
            if (aNS != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, aNS));
                return;
            }
            return;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cVi.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.kCV != null ? this.kCV.defaultZone : -1);
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

    public void cUr() {
        if (this.kMk != null) {
            this.kMk.cUb();
        }
    }

    public void a(g.a aVar) {
        this.kmN = aVar;
    }
}
