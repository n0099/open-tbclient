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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.UniversityEvaluationConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.write.a;
import com.baidu.tieba.write.h;
import com.baidu.webkit.sdk.PermissionRequest;
import tbclient.ItemInfo;
/* loaded from: classes.dex */
public class g {
    private com.baidu.tbadk.n.a.a Xf;
    private int bgColor;
    private TbPageContext eGu;
    private ItemInfo iRi;
    private ForumWriteData iUV;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private a nGa;
    private boolean nGb;
    private h nGc;
    private String nGd;
    private String nGe;
    private h.a nGf;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.nGb = false;
        this.mSkinType = 3;
        this.nGd = "";
        this.mFrom = "write";
        this.nGe = "0";
        this.nGf = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void LO(int i2) {
                if (i2 == 1) {
                    g.this.nGb = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nGc instanceof d)) {
                        if (g.this.Xf == null) {
                            g.this.Xf = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.Xf.bBU();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i2 == 2) {
                    if (g.this.Xf != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nGc instanceof d)) {
                        g.this.Xf.bBV();
                    }
                    g.this.dTg();
                } else if (i2 == 4) {
                    g.this.nGb = false;
                    if (g.this.nGa.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.nGa.mRootView != null && g.this.mParentView.indexOfChild(g.this.nGa.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.nGa.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
            }
        };
        this.eGu = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.b bVar = new a.b(this.eGu, this);
            this.nGa = bVar;
            this.nGc = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0874a c0874a = new a.C0874a(this.eGu, this);
            this.nGa = c0874a;
            this.nGc = new f(tbPageContext.getPageActivity(), c0874a);
        } else {
            a.c cVar = new a.c(this.eGu, this);
            this.nGa = cVar;
            this.nGc = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.nGc.a(this.nGf);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void Um(String str) {
        if (str == null) {
            str = "";
        }
        this.nGd = str;
    }

    public String cFj() {
        return this.nGd;
    }

    public void yy(boolean z) {
        if (this.nGa instanceof a.c) {
            ((a.c) this.nGa).yv(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.iUV = forumWriteData;
    }

    public void b(ItemInfo itemInfo) {
        this.iRi = itemInfo;
    }

    public void Un(String str) {
        this.nGe = str;
    }

    public boolean isShowing() {
        return this.nGb;
    }

    public void LM(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.nGa.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bI(this.mParentView).attachView(this.mParentView, this.nGa.mRootView, z);
            }
            this.nGc.d(view, view2);
            this.nGc.show();
            TiebaStatic.log(new ar("c12052").dR("obj_locate", this.nGe));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!au.isEmpty(string)) {
                    BdToast.b(this.eGu.getContext(), string).bom();
                    com.baidu.tbadk.core.sharedPref.b.bpu().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
            if (this.iUV != null && this.iUV.antiData != null && this.iUV.antiData.getCanGoods()) {
                TiebaStatic.log(new ar("c13896").ak("obj_locate", 1).dR("fid", this.iUV.forumId).dR("fname", this.iUV.forumName));
            }
        }
    }

    public void LN(int i) {
        if (this.nGa instanceof a.c) {
            ((a.c) this.nGa).nFk.setIconFade(i);
        }
    }

    public void yz(boolean z) {
        this.nGc.gk(z);
        if (!z && (this.nGa instanceof a.c)) {
            ((a.c) this.nGa).nFk.bAz();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.nGa.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.nGa.mRootView != null && this.nGa.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.nGa.mRootView);
        }
        this.nGc.onDestroy();
    }

    public void dTb() {
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nGe).ak("obj_type", 6));
        yz(false);
        UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(this.eGu.getPageActivity(), RequestResponseCode.REQUEST_WRITE_NEW);
        if (this.iUV != null) {
            universityEvaluationConfig.setWriteData(this.iUV);
        }
        if (this.iRi != null) {
            universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(this.iRi));
            universityEvaluationConfig.setItemIsSchool(this.iRi.is_school.intValue() == 1);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
        if (this.iUV != null && this.iRi != null) {
            TiebaStatic.log(new ar("c13722").dR("fid", this.iUV.forumId).dR("fname", this.iUV.forumName).ak("obj_param1", this.iRi.id.intValue()));
        }
    }

    public void dTc() {
        if (this.iUV != null) {
            TiebaStatic.log(new ar("c13897").ak("obj_locate", 1).dR("fid", this.iUV.forumId).dR("fname", this.iUV.forumName));
        }
        yz(false);
        if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGu.getPageActivity());
            aVar.ov(2);
            aVar.iX(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.eGu.getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new ar("c13959").ak("obj_locate", 1).dR("fid", g.this.iUV.forumId).dR("fname", g.this.iUV.forumName));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
                    }
                }
            });
            aVar.bg(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new ar("c13958").ak("obj_locate", 1).dR("fid", this.iUV.forumId).dR("fname", this.iUV.forumName));
            aVar.b(this.eGu).bog();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
    }

    public void Uo(String str) {
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nGe).ak("obj_type", 5));
        yz(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.eGu.getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.iUV == null) {
            this.iUV = new ForumWriteData("0", null, null, null);
        }
        this.iUV.mFrom = this.mFrom;
        this.iUV.writeCallFrom = "2";
        writeVoteActivityConfig.setExtraData(this.iUV);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
        TiebaStatic.log(new ar("c13800").ak("obj_source", 1));
    }

    public void dTd() {
        if (this.nGa instanceof a.b) {
            TiebaStatic.log("c13619");
            dTg();
        }
        yz(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGu.getPageActivity());
            aVar.setAutoNight(false);
            aVar.or(R.string.prompt);
            aVar.AJ(this.eGu.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eGu).bog();
            return;
        }
        a(this.eGu, this.nGe, this.iUV);
    }

    public void a(TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (tbPageContext != null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.write.g.4
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
                public void onPermissionsGranted() {
                    String str2;
                    String str3 = null;
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    String str4 = "0";
                    com.baidu.adp.lib.c.a.mk().getAddress(false);
                    if (forumWriteData != null) {
                        str4 = forumWriteData.forumId;
                        str2 = forumWriteData.forumName;
                        str3 = forumWriteData.specialForumType;
                    } else {
                        str2 = null;
                    }
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", str).ak("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.eGu.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dTe() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        yz(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.iUV == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.iUV.forumId;
            String str7 = this.iUV.forumName;
            postPrefixData = this.iUV.prefixData;
            antiData = this.iUV.antiData;
            int i3 = this.iUV.forumLevel;
            String str8 = this.iUV.avatar;
            int i4 = this.iUV.privateThread;
            String str9 = this.iUV.firstDir;
            str = this.iUV.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nGe).ak("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.eGu.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom("2");
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(0);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.iUV != null ? this.iUV.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.iUV != null ? this.iUV.frsTabInfo : null);
        if (!StringUtils.isNull(this.nGd)) {
            writeActivityConfig.setTitle(this.nGd, true);
        }
        if (!a(this.eGu.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void dTf() {
        yz(false);
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nGe).ak("obj_type", 2));
        if (this.iUV == null) {
            this.iUV = new ForumWriteData("0", null, null, null);
        }
        this.iUV.mFrom = this.mFrom;
        this.iUV.writeCallFrom = "2";
        j.b(this.eGu, "", this.iUV);
    }

    public void Up(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        yz(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.iUV == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.iUV.forumId;
            String str8 = this.iUV.forumName;
            postPrefixData = this.iUV.prefixData;
            antiData = this.iUV.antiData;
            int i3 = this.iUV.forumLevel;
            String str9 = this.iUV.avatar;
            int i4 = this.iUV.privateThread;
            String str10 = this.iUV.firstDir;
            str2 = this.iUV.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nGe).ak("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.eGu.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom("2");
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.iUV != null ? this.iUV.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.iUV != null ? this.iUV.frsTabInfo : null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    private static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.write.g.5
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
            public void onPermissionsGranted() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, WriteActivityConfig.this));
            }
        });
        return permissionJudgePolicy.startRequestPermission(activity);
    }

    public void bEr() {
        if (this.nGa != null) {
            this.nGa.dSQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTg() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("home_publish_ala_has_showed", false);
        if (this.nGa instanceof a.b) {
            ((a.b) this.nGa).yu(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("home_publish_ala_has_showed", true);
    }

    public void setCanGoods(boolean z) {
        if ((this.nGa instanceof a.c) && ((a.c) this.nGa).nFh != null) {
            ((a.c) this.nGa).nFh.setVisibility(z ? 0 : 8);
        }
    }
}
