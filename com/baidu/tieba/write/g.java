package com.baidu.tieba.write;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.write.a;
import com.baidu.tieba.write.h;
import com.baidu.webkit.sdk.PermissionRequest;
import tbclient.ItemInfo;
/* loaded from: classes.dex */
public class g {
    private com.baidu.tbadk.n.a.a XZ;
    private int bgColor;
    private boolean canGoods;
    private TbPageContext eXu;
    private ItemInfo jot;
    private ForumWriteData jst;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private a nXD;
    private boolean nXE;
    private h nXF;
    private String nXG;
    private String nXH;
    private h.a nXI;
    private int statisticFrom;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        int i2 = 0;
        this.nXE = false;
        this.mSkinType = 3;
        this.nXG = "";
        this.mFrom = "write";
        this.nXH = "0";
        this.canGoods = false;
        this.nXI = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void Mt(int i3) {
                if (i3 == 1) {
                    g.this.nXE = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nXF instanceof d)) {
                        if (g.this.XZ == null) {
                            g.this.XZ = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.XZ.bHQ();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i3 == 2) {
                    if (g.this.XZ != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nXF instanceof d)) {
                        g.this.XZ.bHR();
                    }
                    g.this.dYf();
                } else if (i3 == 4) {
                    g.this.nXE = false;
                    if (g.this.nXD.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.nXD.mRootView != null && g.this.mParentView.indexOfChild(g.this.nXD.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.nXD.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
            }
        };
        this.eXu = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if ("main_tab".equals(this.mFrom)) {
            i2 = 1;
        } else if ("frs".equals(this.mFrom)) {
            i2 = 2;
        }
        this.statisticFrom = i2;
        if (i == 2) {
            a.b bVar = new a.b(this.eXu, this);
            this.nXD = bVar;
            this.nXF = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0872a c0872a = new a.C0872a(this.eXu, this);
            this.nXD = c0872a;
            this.nXF = new f(tbPageContext.getPageActivity(), c0872a);
        } else {
            a.c cVar = new a.c(this.eXu, this);
            this.nXD = cVar;
            this.nXF = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.nXF.a(this.nXI);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void Vg(String str) {
        if (str == null) {
            str = "";
        }
        this.nXG = str;
    }

    public String cNz() {
        return this.nXG;
    }

    public void zd(boolean z) {
        if (this.nXD instanceof a.c) {
            ((a.c) this.nXD).za(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.jst = forumWriteData;
    }

    private boolean dXZ() {
        if (this.jst == null || this.jst.frsTabInfo == null || x.isEmpty(this.jst.frsTabInfo.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.jst.frsTabInfo.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    public void b(ItemInfo itemInfo) {
        this.jot = itemInfo;
    }

    public void Vh(String str) {
        this.nXH = str;
    }

    public boolean isShowing() {
        return this.nXE;
    }

    public void Mr(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.nXD.mRootView.getParent() == null) {
                com.baidu.tbadk.l.e.bU(this.mParentView).attachView(this.mParentView, this.nXD.mRootView, z);
            }
            this.nXF.d(view, view2);
            this.nXF.show();
            TiebaStatic.log(new aq("c12052").dX("obj_locate", this.nXH));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.bvq().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!at.isEmpty(string)) {
                    BdToast.b(this.eXu.getContext(), string).bud();
                    com.baidu.tbadk.core.sharedPref.b.bvq().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
            if (this.jst != null && this.jst.antiData != null && this.jst.antiData.getCanGoods()) {
                TiebaStatic.log(new aq("c13896").an("obj_locate", 1).dX("fid", this.jst.forumId).dX("fname", this.jst.forumName));
            }
        }
    }

    public void Ms(int i) {
        if (this.nXD instanceof a.c) {
            ((a.c) this.nXD).nWN.setIconFade(i);
        }
    }

    public void ze(boolean z) {
        this.nXF.gI(z);
        if (!z && (this.nXD instanceof a.c)) {
            ((a.c) this.nXD).nWN.bGv();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.nXD.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.nXD.mRootView != null && this.nXD.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.nXD.mRootView);
        }
        this.nXF.onDestroy();
    }

    public void dYa() {
        if (!dXZ()) {
            BdToast.b(this.eXu.getPageActivity(), this.eXu.getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bud();
        } else if (!this.canGoods) {
            BdToast.b(this.eXu.getPageActivity(), this.eXu.getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bud();
        } else {
            if (this.jst != null) {
                TiebaStatic.log(new aq("c13897").an("obj_locate", 1).dX("fid", this.jst.forumId).dX("fname", this.jst.forumName));
            }
            ze(false);
            if (!com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("commodity_goods_show_first_dialog", false)) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
                aVar.pd(2);
                aVar.jI(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.eXu.getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.g.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (aVar != null) {
                            aVar.dismiss();
                            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("commodity_goods_show_first_dialog", true);
                            TiebaStatic.log(new aq("c13959").an("obj_locate", 1).dX("fid", g.this.jst.forumId).dX("fname", g.this.jst.forumName));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
                        }
                    }
                });
                aVar.br(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new aq("c13958").an("obj_locate", 1).dX("fid", this.jst.forumId).dX("fname", this.jst.forumName));
                aVar.b(this.eXu).btX();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
        }
    }

    public void Vi(String str) {
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dX("obj_locate", this.nXH).an("obj_type", 5));
        ze(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.eXu.getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.jst == null) {
            this.jst = new ForumWriteData("0", null, null, null);
        }
        this.jst.mFrom = this.mFrom;
        this.jst.writeCallFrom = "2";
        this.jst.statisticFrom = this.statisticFrom;
        writeVoteActivityConfig.setExtraData(this.jst);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
        TiebaStatic.log(new aq("c13800").an("obj_source", 1));
    }

    public void dYb() {
        if (this.nXD instanceof a.b) {
            TiebaStatic.log("c13619");
            dYf();
        }
        ze(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
            aVar.setAutoNight(false);
            aVar.oZ(R.string.prompt);
            aVar.Bp(this.eXu.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eXu).btX();
            return;
        }
        a(this.eXu, this.nXH, this.jst);
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
                    String str3;
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    String str4 = "0";
                    com.baidu.adp.lib.c.a.lI().getAddress(false);
                    if (forumWriteData != null) {
                        str4 = forumWriteData.forumId;
                        str3 = forumWriteData.forumName;
                        str2 = forumWriteData.specialForumType;
                    } else {
                        str2 = null;
                        str3 = null;
                    }
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dX("obj_locate", str).an("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.eXu.getPageActivity(), str3, str4, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dYc() {
        ze(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dX("obj_locate", this.nXH).an("obj_type", 3));
            WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.eXu.getPageActivity()).setType(0).setForumWriteData(this.jst).setFrom(this.mFrom).setTitle(this.nXG).setAlbumThread(0).setCallFrom("2").setStatisticFrom(this.statisticFrom);
            if (!a(this.eXu.getPageActivity(), statisticFrom)) {
                statisticFrom.send();
            }
        }
    }

    public void dYd() {
        ze(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dX("obj_locate", this.nXH).an("obj_type", 2));
            if (this.jst == null) {
                this.jst = new ForumWriteData("0", null, null, null);
            }
            this.jst.mFrom = this.mFrom;
            this.jst.writeCallFrom = "2";
            this.jst.statisticFrom = this.statisticFrom;
            j.b(this.eXu, "", this.jst);
        }
    }

    public void dYe() {
        ze(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.eXu.getPageActivity()).setType(9).setForumWriteData(this.jst).setIsEvaluate(true).setFrom(this.mFrom).setCallFrom("2").setStatisticFrom(this.statisticFrom);
            if (this.jot != null) {
                statisticFrom.setScoreItemInfo(new SerializableItemInfo(this.jot)).setItemIsSchool(this.jot.is_school.intValue() == 1).setStarCount(this.jot.score.comment_star.intValue());
            }
            statisticFrom.send();
        }
    }

    public void Vj(String str) {
        ze(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dX("obj_locate", this.nXH).an("obj_type", 1));
            WriteActivityConfig.newInstance(this.eXu.getPageActivity()).setType(9).setForumWriteData(this.jst).setFrom(this.mFrom).setTitle(str).setCallFrom("2").setStatisticFrom(this.statisticFrom).send();
        }
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

    public void bKm() {
        if (this.nXD != null) {
            this.nXD.dXO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYf() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("home_publish_ala_has_showed", false);
        if (this.nXD instanceof a.b) {
            ((a.b) this.nXD).yZ(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("home_publish_ala_has_showed", true);
    }

    public void zf(boolean z) {
        this.canGoods = z;
    }
}
