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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private com.baidu.tbadk.n.a.a WJ;
    private int bgColor;
    private TbPageContext ehG;
    private ItemInfo ijf;
    private ForumWriteData imW;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private a mWF;
    private boolean mWG;
    private h mWH;
    private String mWI;
    private String mWJ;
    private h.a mWK;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.mWG = false;
        this.mSkinType = 3;
        this.mWI = "";
        this.mFrom = "write";
        this.mWJ = "0";
        this.mWK = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void Ka(int i2) {
                if (i2 == 1) {
                    g.this.mWG = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.mWH instanceof d)) {
                        if (g.this.WJ == null) {
                            g.this.WJ = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.WJ.bvz();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i2 == 2) {
                    if (g.this.WJ != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.mWH instanceof d)) {
                        g.this.WJ.bvA();
                    }
                    g.this.dJN();
                } else if (i2 == 4) {
                    g.this.mWG = false;
                    if (g.this.mWF.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.mWF.mRootView != null && g.this.mParentView.indexOfChild(g.this.mWF.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.mWF.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
            }
        };
        this.ehG = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.b bVar = new a.b(this.ehG, this);
            this.mWF = bVar;
            this.mWH = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0823a c0823a = new a.C0823a(this.ehG, this);
            this.mWF = c0823a;
            this.mWH = new f(tbPageContext.getPageActivity(), c0823a);
        } else {
            a.c cVar = new a.c(this.ehG, this);
            this.mWF = cVar;
            this.mWH = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mWH.a(this.mWK);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void SX(String str) {
        if (str == null) {
            str = "";
        }
        this.mWI = str;
    }

    public String cwz() {
        return this.mWI;
    }

    public void xk(boolean z) {
        if (this.mWF instanceof a.c) {
            ((a.c) this.mWF).xh(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.imW = forumWriteData;
    }

    public void b(ItemInfo itemInfo) {
        this.ijf = itemInfo;
    }

    public void SY(String str) {
        this.mWJ = str;
    }

    public boolean isShowing() {
        return this.mWG;
    }

    public void JY(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.mWF.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bw(this.mParentView).attachView(this.mParentView, this.mWF.mRootView, z);
            }
            this.mWH.d(view, view2);
            this.mWH.show();
            TiebaStatic.log(new aq("c12052").dF("obj_locate", this.mWJ));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!at.isEmpty(string)) {
                    BdToast.b(this.ehG.getContext(), string).big();
                    com.baidu.tbadk.core.sharedPref.b.bjf().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
            if (this.imW != null && this.imW.antiData != null && this.imW.antiData.getCanGoods()) {
                TiebaStatic.log(new aq("c13896").ai("obj_locate", 1).dF("fid", this.imW.forumId).dF("fname", this.imW.forumName));
            }
        }
    }

    public void JZ(int i) {
        if (this.mWF instanceof a.c) {
            ((a.c) this.mWF).mVT.setIconFade(i);
        }
    }

    public void xl(boolean z) {
        this.mWH.fp(z);
        if (!z && (this.mWF instanceof a.c)) {
            ((a.c) this.mWF).mVT.buh();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.mWF.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.mWF.mRootView != null && this.mWF.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.mWF.mRootView);
        }
        this.mWH.onDestroy();
    }

    public void dJI() {
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dF("obj_locate", this.mWJ).ai("obj_type", 6));
        xl(false);
        UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(this.ehG.getPageActivity(), RequestResponseCode.REQUEST_WRITE_NEW);
        if (this.imW != null) {
            universityEvaluationConfig.setWriteData(this.imW);
        }
        if (this.ijf != null) {
            universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(this.ijf));
            universityEvaluationConfig.setItemIsSchool(this.ijf.is_school.intValue() == 1);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
        if (this.imW != null && this.ijf != null) {
            TiebaStatic.log(new aq("c13722").dF("fid", this.imW.forumId).dF("fname", this.imW.forumName).ai("obj_param1", this.ijf.id.intValue()));
        }
    }

    public void dJJ() {
        if (this.imW != null) {
            TiebaStatic.log(new aq("c13897").ai("obj_locate", 1).dF("fid", this.imW.forumId).dF("fname", this.imW.forumName));
        }
        xl(false);
        if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehG.getPageActivity());
            aVar.nH(2);
            aVar.ie(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.ehG.getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new aq("c13959").ai("obj_locate", 1).dF("fid", g.this.imW.forumId).dF("fname", g.this.imW.forumName));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
                    }
                }
            });
            aVar.aZ(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new aq("c13958").ai("obj_locate", 1).dF("fid", this.imW.forumId).dF("fname", this.imW.forumName));
            aVar.b(this.ehG).bia();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
    }

    public void SZ(String str) {
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dF("obj_locate", this.mWJ).ai("obj_type", 5));
        xl(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.ehG.getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.imW == null) {
            this.imW = new ForumWriteData("0", null, null, null);
        }
        this.imW.mFrom = this.mFrom;
        this.imW.writeCallFrom = "2";
        writeVoteActivityConfig.setExtraData(this.imW);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
        TiebaStatic.log(new aq("c13800").ai("obj_source", 1));
    }

    public void dJK() {
        if (this.mWF instanceof a.b) {
            TiebaStatic.log("c13619");
            dJN();
        }
        xl(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehG.getPageActivity());
            aVar.setAutoNight(false);
            aVar.nD(R.string.prompt);
            aVar.zV(this.ehG.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.ehG).bia();
            return;
        }
        a(this.ehG, this.mWJ, this.imW);
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
                    com.baidu.adp.lib.c.a.mj().getAddress(false);
                    if (forumWriteData != null) {
                        str4 = forumWriteData.forumId;
                        str2 = forumWriteData.forumName;
                        str3 = forumWriteData.specialForumType;
                    } else {
                        str2 = null;
                    }
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dF("obj_locate", str).ai("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.ehG.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dJL() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        xl(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.imW == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.imW.forumId;
            String str7 = this.imW.forumName;
            postPrefixData = this.imW.prefixData;
            antiData = this.imW.antiData;
            int i3 = this.imW.forumLevel;
            String str8 = this.imW.avatar;
            int i4 = this.imW.privateThread;
            String str9 = this.imW.firstDir;
            str = this.imW.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dF("obj_locate", this.mWJ).ai("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.ehG.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom("2");
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(0);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.imW != null ? this.imW.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.imW != null ? this.imW.frsTabInfo : null);
        if (!StringUtils.isNull(this.mWI)) {
            writeActivityConfig.setTitle(this.mWI, true);
        }
        if (!a(this.ehG.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void dJM() {
        xl(false);
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dF("obj_locate", this.mWJ).ai("obj_type", 2));
        if (this.imW == null) {
            this.imW = new ForumWriteData("0", null, null, null);
        }
        this.imW.mFrom = this.mFrom;
        this.imW.writeCallFrom = "2";
        j.b(this.ehG, "", this.imW);
    }

    public void Ta(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        xl(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.imW == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.imW.forumId;
            String str8 = this.imW.forumName;
            postPrefixData = this.imW.prefixData;
            antiData = this.imW.antiData;
            int i3 = this.imW.forumLevel;
            String str9 = this.imW.avatar;
            int i4 = this.imW.privateThread;
            String str10 = this.imW.firstDir;
            str2 = this.imW.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dF("obj_locate", this.mWJ).ai("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.ehG.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom("2");
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.imW != null ? this.imW.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.imW != null ? this.imW.frsTabInfo : null);
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

    public void bxW() {
        if (this.mWF != null) {
            this.mWF.dJv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJN() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("home_publish_ala_has_showed", false);
        if (this.mWF instanceof a.b) {
            ((a.b) this.mWF).xg(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("home_publish_ala_has_showed", true);
    }

    public void setCanGoods(boolean z) {
        if ((this.mWF instanceof a.c) && ((a.c) this.mWF).mVQ != null) {
            ((a.c) this.mWF).mVQ.setVisibility(z ? 0 : 8);
        }
    }
}
