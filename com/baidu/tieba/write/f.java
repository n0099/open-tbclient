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
    private com.baidu.tbadk.n.a.a Vb;
    private int bgColor;
    private TbPageContext duG;
    private g.a kYv;
    private ForumWriteData lpe;
    private a lxk;
    private boolean lxl;
    private g lxm;
    private String lxn;
    private String lxo;
    private g.a lxp;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.lxl = false;
        this.mSkinType = 3;
        this.lxn = "";
        this.mFrom = "write";
        this.lxo = "0";
        this.lxp = new g.a() { // from class: com.baidu.tieba.write.f.1
            @Override // com.baidu.tieba.write.g.a
            public void DA(int i2) {
                if (i2 == 1) {
                    f.this.lxl = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.lxm instanceof d)) {
                        if (f.this.Vb == null) {
                            f.this.Vb = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        f.this.Vb.aZH();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 2) {
                    if (f.this.Vb != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.lxm instanceof d)) {
                        f.this.Vb.aZI();
                    }
                    f.this.dfh();
                } else if (i2 == 4) {
                    f.this.lxl = false;
                    if (f.this.lxk.mRootView.getParent() == f.this.mParentView && f.this.mParentView != null && f.this.lxk.mRootView != null && f.this.mParentView.indexOfChild(f.this.lxk.mRootView) > 0) {
                        f.this.mParentView.removeView(f.this.lxk.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
                if (f.this.kYv != null) {
                    f.this.kYv.DA(i2);
                }
            }
        };
        this.duG = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.C0672a c0672a = new a.C0672a(this.duG, this);
            this.lxk = c0672a;
            this.lxm = new d(tbPageContext.getPageActivity(), c0672a);
        } else {
            a.b bVar = new a.b(this.duG, this);
            this.lxk = bVar;
            this.lxm = new e(tbPageContext.getPageActivity(), bVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lxm.b(this.lxp);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void Mq(String str) {
        if (str == null) {
            str = "";
        }
        this.lxn = str;
    }

    public String bVh() {
        return this.lxn;
    }

    public void a(ForumWriteData forumWriteData) {
        this.lpe = forumWriteData;
    }

    public void Mr(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.lxo = str;
    }

    public boolean isShowing() {
        return this.lxl;
    }

    public void EL(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.lxk.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bi(this.mParentView).attachView(this.mParentView, this.lxk.mRootView, z);
            }
            this.lxm.c(view, view2);
            this.lxm.show();
            TiebaStatic.log(new an("c12052").cI("obj_locate", this.lxo));
            if (j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.duG.getContext(), string).aMZ();
                    com.baidu.tbadk.core.sharedPref.b.aNV().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void EM(int i) {
        if (this.lxk instanceof a.b) {
            ((a.b) this.lxk).lwC.setIconFade(i);
        }
    }

    public void uP(boolean z) {
        this.lxm.eq(z);
        if (!z && (this.lxk instanceof a.b)) {
            ((a.b) this.lxk).lwC.aYs();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.lxk.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.lxk.mRootView != null && this.lxk.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.lxk.mRootView);
        }
        this.lxm.onDestroy();
    }

    public void dfd() {
        if (this.lxk instanceof a.C0672a) {
            TiebaStatic.log("c13619");
            dfh();
        }
        uP(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duG.getPageActivity());
            aVar.setAutoNight(false);
            aVar.kc(R.string.prompt);
            aVar.uf(this.duG.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.duG).aMU();
            return;
        }
        a(this.duG, this.lxo, this.lpe);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(f.this.duG.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dfe() {
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
        if (this.lpe == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.lpe.forumId;
            String str7 = this.lpe.forumName;
            postPrefixData = this.lpe.prefixData;
            antiData = this.lpe.antiData;
            int i3 = this.lpe.forumLevel;
            String str8 = this.lpe.avatar;
            int i4 = this.lpe.privateThread;
            String str9 = this.lpe.firstDir;
            str = this.lpe.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cI("obj_locate", this.lxo).af("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.duG.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.lpe != null ? this.lpe.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.lpe != null ? this.lpe.frsTabInfo : null);
        if (!StringUtils.isNull(this.lxn)) {
            writeActivityConfig.setTitle(this.lxn, true);
        }
        if (!a(this.duG.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void dff() {
        uP(false);
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cI("obj_locate", this.lxo).af("obj_type", 2));
        if (this.lpe == null) {
            this.lpe = new ForumWriteData("0", null, null, null);
        }
        this.lpe.mFrom = this.mFrom;
        this.lpe.writeCallFrom = this.writeCallFrom;
        i.b(this.duG, "", this.lpe);
    }

    public void Ms(String str) {
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
        if (this.lpe == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.lpe.forumId;
            String str8 = this.lpe.forumName;
            postPrefixData = this.lpe.prefixData;
            antiData = this.lpe.antiData;
            int i3 = this.lpe.forumLevel;
            String str9 = this.lpe.avatar;
            int i4 = this.lpe.privateThread;
            String str10 = this.lpe.firstDir;
            str2 = this.lpe.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cI("obj_locate", this.lxo).af("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.duG.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.lpe != null ? this.lpe.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.lpe != null ? this.lpe.frsTabInfo : null);
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

    public void dfg() {
        if (this.lxk != null) {
            this.lxk.deQ();
        }
    }

    public void a(g.a aVar) {
        this.kYv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfh() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("home_publish_ala_has_showed", false);
        if (this.lxk instanceof a.C0672a) {
            ((a.C0672a) this.lxk).uM(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("home_publish_ala_has_showed", true);
    }
}
