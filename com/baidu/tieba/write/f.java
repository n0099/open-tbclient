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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.a;
import com.baidu.tieba.write.g;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes.dex */
public class f {
    private com.baidu.tbadk.n.a.a Vf;
    private int bgColor;
    private TbPageContext duK;
    private g.a kYz;
    private ForumWriteData lpi;
    private a lxo;
    private boolean lxp;
    private g lxq;
    private String lxr;
    private String lxs;
    private g.a lxt;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.lxp = false;
        this.mSkinType = 3;
        this.lxr = "";
        this.mFrom = "write";
        this.lxs = "0";
        this.lxt = new g.a() { // from class: com.baidu.tieba.write.f.1
            @Override // com.baidu.tieba.write.g.a
            public void DA(int i2) {
                if (i2 == 1) {
                    f.this.lxp = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.lxq instanceof d)) {
                        if (f.this.Vf == null) {
                            f.this.Vf = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        f.this.Vf.aZF();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 2) {
                    if (f.this.Vf != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.lxq instanceof d)) {
                        f.this.Vf.aZG();
                    }
                    f.this.dff();
                } else if (i2 == 4) {
                    f.this.lxp = false;
                    if (f.this.lxo.mRootView.getParent() == f.this.mParentView && f.this.mParentView != null && f.this.lxo.mRootView != null && f.this.mParentView.indexOfChild(f.this.lxo.mRootView) > 0) {
                        f.this.mParentView.removeView(f.this.lxo.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
                if (f.this.kYz != null) {
                    f.this.kYz.DA(i2);
                }
            }
        };
        this.duK = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.C0693a c0693a = new a.C0693a(this.duK, this);
            this.lxo = c0693a;
            this.lxq = new d(tbPageContext.getPageActivity(), c0693a);
        } else {
            a.b bVar = new a.b(this.duK, this);
            this.lxo = bVar;
            this.lxq = new e(tbPageContext.getPageActivity(), bVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lxq.b(this.lxt);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void Mt(String str) {
        if (str == null) {
            str = "";
        }
        this.lxr = str;
    }

    public String bVg() {
        return this.lxr;
    }

    public void a(ForumWriteData forumWriteData) {
        this.lpi = forumWriteData;
    }

    public void Mu(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.lxs = str;
    }

    public boolean isShowing() {
        return this.lxp;
    }

    public void EL(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.lxo.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bi(this.mParentView).attachView(this.mParentView, this.lxo.mRootView, z);
            }
            this.lxq.c(view, view2);
            this.lxq.show();
            TiebaStatic.log(new an("c12052").cI("obj_locate", this.lxs));
            if (j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.duK.getContext(), string).aMX();
                    com.baidu.tbadk.core.sharedPref.b.aNT().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void EM(int i) {
        if (this.lxo instanceof a.b) {
            ((a.b) this.lxo).lwG.setIconFade(i);
        }
    }

    public void uP(boolean z) {
        this.lxq.eq(z);
        if (!z && (this.lxo instanceof a.b)) {
            ((a.b) this.lxo).lwG.aYq();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.lxo.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.lxo.mRootView != null && this.lxo.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.lxo.mRootView);
        }
        this.lxq.onDestroy();
    }

    public void dfb() {
        if (this.lxo instanceof a.C0693a) {
            TiebaStatic.log("c13619");
            dff();
        }
        uP(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duK.getPageActivity());
            aVar.setAutoNight(false);
            aVar.kc(R.string.prompt);
            aVar.ui(this.duK.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.duK).aMS();
            return;
        }
        a(this.duK, this.lxs, this.lpi);
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
                    com.baidu.adp.lib.c.a.ko().getAddress(false);
                    if (forumWriteData != null) {
                        str4 = forumWriteData.forumId;
                        str2 = forumWriteData.forumName;
                        str3 = forumWriteData.specialForumType;
                    } else {
                        str2 = null;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cI("obj_locate", str).af("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(f.this.duK.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dfc() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        uP(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.lpi == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.lpi.forumId;
            String str7 = this.lpi.forumName;
            postPrefixData = this.lpi.prefixData;
            antiData = this.lpi.antiData;
            int i3 = this.lpi.forumLevel;
            String str8 = this.lpi.avatar;
            int i4 = this.lpi.privateThread;
            String str9 = this.lpi.firstDir;
            str = this.lpi.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cI("obj_locate", this.lxs).af("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.duK.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.lpi != null ? this.lpi.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.lpi != null ? this.lpi.frsTabInfo : null);
        if (!StringUtils.isNull(this.lxr)) {
            writeActivityConfig.setTitle(this.lxr, true);
        }
        if (!a(this.duK.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void dfd() {
        uP(false);
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cI("obj_locate", this.lxs).af("obj_type", 2));
        if (this.lpi == null) {
            this.lpi = new ForumWriteData("0", null, null, null);
        }
        this.lpi.mFrom = this.mFrom;
        this.lpi.writeCallFrom = this.writeCallFrom;
        i.b(this.duK, "", this.lpi);
    }

    public void Mv(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        uP(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.lpi == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.lpi.forumId;
            String str8 = this.lpi.forumName;
            postPrefixData = this.lpi.prefixData;
            antiData = this.lpi.antiData;
            int i3 = this.lpi.forumLevel;
            String str9 = this.lpi.avatar;
            int i4 = this.lpi.privateThread;
            String str10 = this.lpi.firstDir;
            str2 = this.lpi.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cI("obj_locate", this.lxs).af("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.duK.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.lpi != null ? this.lpi.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.lpi != null ? this.lpi.frsTabInfo : null);
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

    public void dfe() {
        if (this.lxo != null) {
            this.lxo.deO();
        }
    }

    public void a(g.a aVar) {
        this.kYz = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dff() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("home_publish_ala_has_showed", false);
        if (this.lxo instanceof a.C0693a) {
            ((a.C0693a) this.lxo).uM(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("home_publish_ala_has_showed", true);
    }
}
