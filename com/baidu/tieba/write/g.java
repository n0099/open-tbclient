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
    private com.baidu.tbadk.n.a.a XX;
    private int bgColor;
    private boolean canGoods;
    private TbPageContext eSJ;
    private ItemInfo jjM;
    private ForumWriteData jnN;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private a nSX;
    private boolean nSY;
    private h nSZ;
    private String nTa;
    private String nTb;
    private h.a nTc;
    private int statisticFrom;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        int i2 = 0;
        this.nSY = false;
        this.mSkinType = 3;
        this.nTa = "";
        this.mFrom = "write";
        this.nTb = "0";
        this.canGoods = false;
        this.nTc = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void KM(int i3) {
                if (i3 == 1) {
                    g.this.nSY = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nSZ instanceof d)) {
                        if (g.this.XX == null) {
                            g.this.XX = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.XX.bDZ();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i3 == 2) {
                    if (g.this.XX != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nSZ instanceof d)) {
                        g.this.XX.bEa();
                    }
                    g.this.dUo();
                } else if (i3 == 4) {
                    g.this.nSY = false;
                    if (g.this.nSX.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.nSX.mRootView != null && g.this.mParentView.indexOfChild(g.this.nSX.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.nSX.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
            }
        };
        this.eSJ = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if ("main_tab".equals(this.mFrom)) {
            i2 = 1;
        } else if ("frs".equals(this.mFrom)) {
            i2 = 2;
        }
        this.statisticFrom = i2;
        if (i == 2) {
            a.b bVar = new a.b(this.eSJ, this);
            this.nSX = bVar;
            this.nSZ = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0893a c0893a = new a.C0893a(this.eSJ, this);
            this.nSX = c0893a;
            this.nSZ = new f(tbPageContext.getPageActivity(), c0893a);
        } else {
            a.c cVar = new a.c(this.eSJ, this);
            this.nSX = cVar;
            this.nSZ = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.nSZ.a(this.nTc);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void TX(String str) {
        if (str == null) {
            str = "";
        }
        this.nTa = str;
    }

    public String cJI() {
        return this.nTa;
    }

    public void yZ(boolean z) {
        if (this.nSX instanceof a.c) {
            ((a.c) this.nSX).yW(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.jnN = forumWriteData;
    }

    private boolean dUi() {
        if (this.jnN == null || this.jnN.frsTabInfo == null || x.isEmpty(this.jnN.frsTabInfo.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.jnN.frsTabInfo.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    public void b(ItemInfo itemInfo) {
        this.jjM = itemInfo;
    }

    public void TY(String str) {
        this.nTb = str;
    }

    public boolean isShowing() {
        return this.nSY;
    }

    public void KK(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.nSX.mRootView.getParent() == null) {
                com.baidu.tbadk.l.e.bU(this.mParentView).attachView(this.mParentView, this.nSX.mRootView, z);
            }
            this.nSZ.d(view, view2);
            this.nSZ.show();
            TiebaStatic.log(new aq("c12052").dW("obj_locate", this.nTb));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.brx().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!at.isEmpty(string)) {
                    BdToast.b(this.eSJ.getContext(), string).bqk();
                    com.baidu.tbadk.core.sharedPref.b.brx().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
            if (this.jnN != null && this.jnN.antiData != null && this.jnN.antiData.getCanGoods()) {
                TiebaStatic.log(new aq("c13896").an("obj_locate", 1).dW("fid", this.jnN.forumId).dW("fname", this.jnN.forumName));
            }
        }
    }

    public void KL(int i) {
        if (this.nSX instanceof a.c) {
            ((a.c) this.nSX).nSh.setIconFade(i);
        }
    }

    public void za(boolean z) {
        this.nSZ.gE(z);
        if (!z && (this.nSX instanceof a.c)) {
            ((a.c) this.nSX).nSh.bCD();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.nSX.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.nSX.mRootView != null && this.nSX.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.nSX.mRootView);
        }
        this.nSZ.onDestroy();
    }

    public void dUj() {
        if (!dUi()) {
            BdToast.b(this.eSJ.getPageActivity(), this.eSJ.getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqk();
        } else if (!this.canGoods) {
            BdToast.b(this.eSJ.getPageActivity(), this.eSJ.getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqk();
        } else {
            if (this.jnN != null) {
                TiebaStatic.log(new aq("c13897").an("obj_locate", 1).dW("fid", this.jnN.forumId).dW("fname", this.jnN.forumName));
            }
            za(false);
            if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("commodity_goods_show_first_dialog", false)) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSJ.getPageActivity());
                aVar.nx(2);
                aVar.jE(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.eSJ.getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.g.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (aVar != null) {
                            aVar.dismiss();
                            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("commodity_goods_show_first_dialog", true);
                            TiebaStatic.log(new aq("c13959").an("obj_locate", 1).dW("fid", g.this.jnN.forumId).dW("fname", g.this.jnN.forumName));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
                        }
                    }
                });
                aVar.br(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new aq("c13958").an("obj_locate", 1).dW("fid", this.jnN.forumId).dW("fname", this.jnN.forumName));
                aVar.b(this.eSJ).bqe();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
        }
    }

    public void TZ(String str) {
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dW("obj_locate", this.nTb).an("obj_type", 5));
        za(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.eSJ.getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.jnN == null) {
            this.jnN = new ForumWriteData("0", null, null, null);
        }
        this.jnN.mFrom = this.mFrom;
        this.jnN.writeCallFrom = "2";
        this.jnN.statisticFrom = this.statisticFrom;
        writeVoteActivityConfig.setExtraData(this.jnN);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
        TiebaStatic.log(new aq("c13800").an("obj_source", 1));
    }

    public void dUk() {
        if (this.nSX instanceof a.b) {
            TiebaStatic.log("c13619");
            dUo();
        }
        za(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSJ.getPageActivity());
            aVar.setAutoNight(false);
            aVar.nt(R.string.prompt);
            aVar.Ad(this.eSJ.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eSJ).bqe();
            return;
        }
        a(this.eSJ, this.nTb, this.jnN);
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
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dW("obj_locate", str).an("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.eSJ.getPageActivity(), str3, str4, TbadkCoreApplication.getCurrentAccount(), str2)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dUl() {
        za(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dW("obj_locate", this.nTb).an("obj_type", 3));
            WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.eSJ.getPageActivity()).setType(0).setForumWriteData(this.jnN).setFrom(this.mFrom).setTitle(this.nTa).setAlbumThread(0).setCallFrom("2").setStatisticFrom(this.statisticFrom);
            if (!a(this.eSJ.getPageActivity(), statisticFrom)) {
                statisticFrom.send();
            }
        }
    }

    public void dUm() {
        za(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dW("obj_locate", this.nTb).an("obj_type", 2));
            if (this.jnN == null) {
                this.jnN = new ForumWriteData("0", null, null, null);
            }
            this.jnN.mFrom = this.mFrom;
            this.jnN.writeCallFrom = "2";
            this.jnN.statisticFrom = this.statisticFrom;
            j.b(this.eSJ, "", this.jnN);
        }
    }

    public void dUn() {
        za(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.eSJ.getPageActivity()).setType(9).setForumWriteData(this.jnN).setIsEvaluate(true).setFrom(this.mFrom).setCallFrom("2").setStatisticFrom(this.statisticFrom);
            if (this.jjM != null) {
                statisticFrom.setScoreItemInfo(new SerializableItemInfo(this.jjM)).setItemIsSchool(this.jjM.is_school.intValue() == 1).setStarCount(this.jjM.score.comment_star.intValue());
            }
            statisticFrom.send();
        }
    }

    public void Ua(String str) {
        za(false);
        if (!WriteActivityConfig.isAsyncWriting()) {
            TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dW("obj_locate", this.nTb).an("obj_type", 1));
            WriteActivityConfig.newInstance(this.eSJ.getPageActivity()).setType(9).setForumWriteData(this.jnN).setFrom(this.mFrom).setTitle(str).setCallFrom("2").setStatisticFrom(this.statisticFrom).send();
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

    public void bGv() {
        if (this.nSX != null) {
            this.nSX.dTX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUo() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("home_publish_ala_has_showed", false);
        if (this.nSX instanceof a.b) {
            ((a.b) this.nSX).yV(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("home_publish_ala_has_showed", true);
    }

    public void zb(boolean z) {
        this.canGoods = z;
    }
}
