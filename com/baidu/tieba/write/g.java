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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
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
    private com.baidu.tbadk.n.a.a XT;
    private int bgColor;
    private boolean canGoods;
    private TbPageContext eUY;
    private ItemInfo jpt;
    private ForumWriteData jtt;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private a ode;
    private boolean odf;
    private h odg;
    private String odh;
    private String odi;
    private h.a odj;
    private int statisticFrom;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        int i2 = 0;
        this.odf = false;
        this.mSkinType = 3;
        this.odh = "";
        this.mFrom = "write";
        this.odi = "0";
        this.canGoods = false;
        this.odj = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void Lh(int i3) {
                if (i3 == 1) {
                    g.this.odf = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.odg instanceof d)) {
                        if (g.this.XT == null) {
                            g.this.XT = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.XT.bEr();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i3 == 2) {
                    if (g.this.XT != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.odg instanceof d)) {
                        g.this.XT.bEs();
                    }
                    g.this.dWC();
                } else if (i3 == 4) {
                    g.this.odf = false;
                    if (g.this.ode.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.ode.mRootView != null && g.this.mParentView.indexOfChild(g.this.ode.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.ode.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
            }
        };
        this.eUY = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if ("main_tab".equals(this.mFrom)) {
            i2 = 1;
        } else if ("frs".equals(this.mFrom)) {
            i2 = 2;
        }
        this.statisticFrom = i2;
        if (i == 2) {
            a.b bVar = new a.b(this.eUY, this);
            this.ode = bVar;
            this.odg = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0896a c0896a = new a.C0896a(this.eUY, this);
            this.ode = c0896a;
            this.odg = new f(tbPageContext.getPageActivity(), c0896a);
        } else {
            a.c cVar = new a.c(this.eUY, this);
            this.ode = cVar;
            this.odg = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.odg.a(this.odj);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void UW(String str) {
        if (str == null) {
            str = "";
        }
        this.odh = str;
    }

    public String cKV() {
        return this.odh;
    }

    public void zv(boolean z) {
        if (this.ode instanceof a.c) {
            ((a.c) this.ode).zs(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.jtt = forumWriteData;
    }

    private boolean dWw() {
        if (this.jtt == null || this.jtt.frsTabInfo == null || y.isEmpty(this.jtt.frsTabInfo.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.jtt.frsTabInfo.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    public void b(ItemInfo itemInfo) {
        this.jpt = itemInfo;
    }

    public void UX(String str) {
        this.odi = str;
    }

    public boolean isShowing() {
        return this.odf;
    }

    public void Lf(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.ode.mRootView.getParent() == null) {
                com.baidu.tbadk.l.e.bQ(this.mParentView).attachView(this.mParentView, this.ode.mRootView, z);
            }
            this.odg.d(view, view2);
            this.odg.show();
            TiebaStatic.log(new ar("c12052").dR("obj_locate", this.odi));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!au.isEmpty(string)) {
                    BdToast.b(this.eUY.getContext(), string).bqD();
                    com.baidu.tbadk.core.sharedPref.b.brQ().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
            if (this.jtt != null && this.jtt.antiData != null && this.jtt.antiData.getCanGoods()) {
                TiebaStatic.log(new ar("c13896").ap("obj_locate", 1).dR("fid", this.jtt.forumId).dR("fname", this.jtt.forumName));
            }
        }
    }

    public void Lg(int i) {
        if (this.ode instanceof a.c) {
            ((a.c) this.ode).ocn.setIconFade(i);
        }
    }

    public void zw(boolean z) {
        this.odg.gG(z);
        if (!z && (this.ode instanceof a.c)) {
            ((a.c) this.ode).ocn.bCV();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.ode.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.ode.mRootView != null && this.ode.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.ode.mRootView);
        }
        this.odg.onDestroy();
    }

    public void dWx() {
        if (!dWw()) {
            BdToast.b(this.eUY.getPageActivity(), this.eUY.getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
        } else if (!this.canGoods) {
            BdToast.b(this.eUY.getPageActivity(), this.eUY.getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
        } else {
            if (this.jtt != null) {
                TiebaStatic.log(new ar("c13897").ap("obj_locate", 1).dR("fid", this.jtt.forumId).dR("fname", this.jtt.forumName));
            }
            zw(false);
            if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("commodity_goods_show_first_dialog", false)) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
                aVar.nA(2);
                aVar.jG(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.eUY.getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.g.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (aVar != null) {
                            aVar.dismiss();
                            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("commodity_goods_show_first_dialog", true);
                            TiebaStatic.log(new ar("c13959").ap("obj_locate", 1).dR("fid", g.this.jtt.forumId).dR("fname", g.this.jtt.forumName));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
                        }
                    }
                });
                aVar.bn(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new ar("c13958").ap("obj_locate", 1).dR("fid", this.jtt.forumId).dR("fname", this.jtt.forumName));
                aVar.b(this.eUY).bqx();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
        }
    }

    public void UY(String str) {
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.odi).ap("obj_type", 5));
        zw(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.eUY.getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.jtt == null) {
            this.jtt = new ForumWriteData("0", null, null, null);
        }
        this.jtt.mFrom = this.mFrom;
        this.jtt.writeCallFrom = "2";
        this.jtt.statisticFrom = this.statisticFrom;
        writeVoteActivityConfig.setExtraData(this.jtt);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
        TiebaStatic.log(new ar("c13800").ap("obj_source", 1));
    }

    public void dWy() {
        if (this.ode instanceof a.b) {
            TiebaStatic.log("c13619");
            dWC();
        }
        zw(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
            aVar.setAutoNight(false);
            aVar.nw(R.string.prompt);
            aVar.Au(this.eUY.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eUY).bqx();
            return;
        }
        a(this.eUY, this.odi, this.jtt);
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
                    com.baidu.adp.lib.c.a.lH().getAddress(false);
                    if (forumWriteData != null) {
                        str4 = forumWriteData.forumId;
                        str3 = forumWriteData.forumName;
                        str2 = forumWriteData.specialForumType;
                    } else {
                        str2 = null;
                        str3 = null;
                    }
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", str).ap("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.eUY.getPageActivity(), str3, str4, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dWz() {
        zw(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.odi).ap("obj_type", 3));
            WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.eUY.getPageActivity()).setType(0).setForumWriteData(this.jtt).setFrom(this.mFrom).setTitle(this.odh).setAlbumThread(0).setCallFrom("2").setStatisticFrom(this.statisticFrom);
            if (!a(this.eUY.getPageActivity(), statisticFrom)) {
                statisticFrom.send();
            }
        }
    }

    public void dWA() {
        zw(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.odi).ap("obj_type", 2));
            if (this.jtt == null) {
                this.jtt = new ForumWriteData("0", null, null, null);
            }
            this.jtt.mFrom = this.mFrom;
            this.jtt.writeCallFrom = "2";
            this.jtt.statisticFrom = this.statisticFrom;
            j.b(this.eUY, "", this.jtt);
        }
    }

    public void dWB() {
        zw(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.eUY.getPageActivity()).setType(9).setForumWriteData(this.jtt).setIsEvaluate(true).setFrom(this.mFrom).setCallFrom("2").setStatisticFrom(this.statisticFrom);
            if (this.jpt != null) {
                statisticFrom.setScoreItemInfo(new SerializableItemInfo(this.jpt)).setItemIsSchool(this.jpt.is_school.intValue() == 1).setStarCount(this.jpt.score.comment_star.intValue());
            }
            statisticFrom.send();
        }
    }

    public void UZ(String str) {
        zw(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.odi).ap("obj_type", 1));
            WriteActivityConfig.newInstance(this.eUY.getPageActivity()).setType(9).setForumWriteData(this.jtt).setFrom(this.mFrom).setTitle(str).setCallFrom("2").setStatisticFrom(this.statisticFrom).send();
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

    public void bGP() {
        if (this.ode != null) {
            this.ode.dWl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWC() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("home_publish_ala_has_showed", false);
        if (this.ode instanceof a.b) {
            ((a.b) this.ode).zr(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("home_publish_ala_has_showed", true);
    }

    public void zx(boolean z) {
        this.canGoods = z;
    }
}
