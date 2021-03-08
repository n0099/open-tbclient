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
    private com.baidu.tbadk.n.a.a Zn;
    private int bgColor;
    private boolean canGoods;
    private TbPageContext eWx;
    private ItemInfo jrq;
    private ForumWriteData jvq;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private a ofK;
    private boolean ofL;
    private h ofM;
    private String ofN;
    private String ofO;
    private h.a ofP;
    private int statisticFrom;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        int i2 = 0;
        this.ofL = false;
        this.mSkinType = 3;
        this.ofN = "";
        this.mFrom = "write";
        this.ofO = "0";
        this.canGoods = false;
        this.ofP = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void Lm(int i3) {
                if (i3 == 1) {
                    g.this.ofL = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.ofM instanceof d)) {
                        if (g.this.Zn == null) {
                            g.this.Zn = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.Zn.bEv();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i3 == 2) {
                    if (g.this.Zn != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.ofM instanceof d)) {
                        g.this.Zn.bEw();
                    }
                    g.this.dWS();
                } else if (i3 == 4) {
                    g.this.ofL = false;
                    if (g.this.ofK.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.ofK.mRootView != null && g.this.mParentView.indexOfChild(g.this.ofK.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.ofK.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
            }
        };
        this.eWx = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if ("main_tab".equals(this.mFrom)) {
            i2 = 1;
        } else if ("frs".equals(this.mFrom)) {
            i2 = 2;
        }
        this.statisticFrom = i2;
        if (i == 2) {
            a.b bVar = new a.b(this.eWx, this);
            this.ofK = bVar;
            this.ofM = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0904a c0904a = new a.C0904a(this.eWx, this);
            this.ofK = c0904a;
            this.ofM = new f(tbPageContext.getPageActivity(), c0904a);
        } else {
            a.c cVar = new a.c(this.eWx, this);
            this.ofK = cVar;
            this.ofM = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ofM.a(this.ofP);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void Vp(String str) {
        if (str == null) {
            str = "";
        }
        this.ofN = str;
    }

    public String cLi() {
        return this.ofN;
    }

    public void zu(boolean z) {
        if (this.ofK instanceof a.c) {
            ((a.c) this.ofK).zr(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.jvq = forumWriteData;
    }

    private boolean dWM() {
        if (this.jvq == null || this.jvq.frsTabInfo == null || y.isEmpty(this.jvq.frsTabInfo.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.jvq.frsTabInfo.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    public void b(ItemInfo itemInfo) {
        this.jrq = itemInfo;
    }

    public void Vq(String str) {
        this.ofO = str;
    }

    public boolean isShowing() {
        return this.ofL;
    }

    public void Lk(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.ofK.mRootView.getParent() == null) {
                com.baidu.tbadk.l.e.bQ(this.mParentView).attachView(this.mParentView, this.ofK.mRootView, z);
            }
            this.ofM.d(view, view2);
            this.ofM.show();
            TiebaStatic.log(new ar("c12052").dR("obj_locate", this.ofO));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.brR().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!au.isEmpty(string)) {
                    BdToast.b(this.eWx.getContext(), string).bqF();
                    com.baidu.tbadk.core.sharedPref.b.brR().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
            if (this.jvq != null && this.jvq.antiData != null && this.jvq.antiData.getCanGoods()) {
                TiebaStatic.log(new ar("c13896").aq("obj_locate", 1).dR("fid", this.jvq.forumId).dR("fname", this.jvq.forumName));
            }
        }
    }

    public void Ll(int i) {
        if (this.ofK instanceof a.c) {
            ((a.c) this.ofK).oeT.setIconFade(i);
        }
    }

    public void zv(boolean z) {
        this.ofM.gG(z);
        if (!z && (this.ofK instanceof a.c)) {
            ((a.c) this.ofK).oeT.bCY();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.ofK.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.ofK.mRootView != null && this.ofK.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.ofK.mRootView);
        }
        this.ofM.onDestroy();
    }

    public void dWN() {
        if (!dWM()) {
            BdToast.b(this.eWx.getPageActivity(), this.eWx.getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
        } else if (!this.canGoods) {
            BdToast.b(this.eWx.getPageActivity(), this.eWx.getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
        } else {
            if (this.jvq != null) {
                TiebaStatic.log(new ar("c13897").aq("obj_locate", 1).dR("fid", this.jvq.forumId).dR("fname", this.jvq.forumName));
            }
            zv(false);
            if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("commodity_goods_show_first_dialog", false)) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eWx.getPageActivity());
                aVar.nB(2);
                aVar.jG(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.eWx.getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.g.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (aVar != null) {
                            aVar.dismiss();
                            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("commodity_goods_show_first_dialog", true);
                            TiebaStatic.log(new ar("c13959").aq("obj_locate", 1).dR("fid", g.this.jvq.forumId).dR("fname", g.this.jvq.forumName));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
                        }
                    }
                });
                aVar.bn(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new ar("c13958").aq("obj_locate", 1).dR("fid", this.jvq.forumId).dR("fname", this.jvq.forumName));
                aVar.b(this.eWx).bqz();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
        }
    }

    public void Vr(String str) {
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.ofO).aq("obj_type", 5));
        zv(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.eWx.getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.jvq == null) {
            this.jvq = new ForumWriteData("0", null, null, null);
        }
        this.jvq.mFrom = this.mFrom;
        this.jvq.writeCallFrom = "2";
        this.jvq.statisticFrom = this.statisticFrom;
        writeVoteActivityConfig.setExtraData(this.jvq);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
        TiebaStatic.log(new ar("c13800").aq("obj_source", 1));
    }

    public void dWO() {
        if (this.ofK instanceof a.b) {
            TiebaStatic.log("c13619");
            dWS();
        }
        zv(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eWx.getPageActivity());
            aVar.setAutoNight(false);
            aVar.nx(R.string.prompt);
            aVar.AB(this.eWx.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eWx).bqz();
            return;
        }
        a(this.eWx, this.ofO, this.jvq);
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
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", str).aq("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.eWx.getPageActivity(), str3, str4, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dWP() {
        zv(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.ofO).aq("obj_type", 3));
            WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.eWx.getPageActivity()).setType(0).setForumWriteData(this.jvq).setFrom(this.mFrom).setTitle(this.ofN).setAlbumThread(0).setCallFrom("2").setStatisticFrom(this.statisticFrom);
            if (!a(this.eWx.getPageActivity(), statisticFrom)) {
                statisticFrom.send();
            }
        }
    }

    public void dWQ() {
        zv(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.ofO).aq("obj_type", 2));
            if (this.jvq == null) {
                this.jvq = new ForumWriteData("0", null, null, null);
            }
            this.jvq.mFrom = this.mFrom;
            this.jvq.writeCallFrom = "2";
            this.jvq.statisticFrom = this.statisticFrom;
            j.b(this.eWx, "", this.jvq);
        }
    }

    public void dWR() {
        zv(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.eWx.getPageActivity()).setType(9).setForumWriteData(this.jvq).setIsEvaluate(true).setFrom(this.mFrom).setCallFrom("2").setStatisticFrom(this.statisticFrom);
            if (this.jrq != null) {
                statisticFrom.setScoreItemInfo(new SerializableItemInfo(this.jrq)).setItemIsSchool(this.jrq.is_school.intValue() == 1).setStarCount(this.jrq.score.comment_star.intValue());
            }
            statisticFrom.send();
        }
    }

    public void Vs(String str) {
        zv(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.ofO).aq("obj_type", 1));
            WriteActivityConfig.newInstance(this.eWx.getPageActivity()).setType(9).setForumWriteData(this.jvq).setFrom(this.mFrom).setTitle(str).setCallFrom("2").setStatisticFrom(this.statisticFrom).send();
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

    public void bGT() {
        if (this.ofK != null) {
            this.ofK.dWB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWS() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("home_publish_ala_has_showed", false);
        if (this.ofK instanceof a.b) {
            ((a.b) this.ofK).zq(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("home_publish_ala_has_showed", true);
    }

    public void zw(boolean z) {
        this.canGoods = z;
    }
}
