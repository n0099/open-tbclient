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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
    private com.baidu.tbadk.n.a.a Yb;
    private int bgColor;
    private TbPageContext eNx;
    private ItemInfo jcc;
    private ForumWriteData jfT;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private a nUi;
    private boolean nUj;
    private h nUk;
    private String nUl;
    private String nUm;
    private h.a nUn;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.nUj = false;
        this.mSkinType = 3;
        this.nUl = "";
        this.mFrom = "write";
        this.nUm = "0";
        this.nUn = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void MG(int i2) {
                if (i2 == 1) {
                    g.this.nUj = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nUk instanceof d)) {
                        if (g.this.Yb == null) {
                            g.this.Yb = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.Yb.bFv();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i2 == 2) {
                    if (g.this.Yb != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nUk instanceof d)) {
                        g.this.Yb.bFw();
                    }
                    g.this.dYB();
                } else if (i2 == 4) {
                    g.this.nUj = false;
                    if (g.this.nUi.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.nUi.mRootView != null && g.this.mParentView.indexOfChild(g.this.nUi.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.nUi.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
            }
        };
        this.eNx = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.b bVar = new a.b(this.eNx, this);
            this.nUi = bVar;
            this.nUk = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0890a c0890a = new a.C0890a(this.eNx, this);
            this.nUi = c0890a;
            this.nUk = new f(tbPageContext.getPageActivity(), c0890a);
        } else {
            a.c cVar = new a.c(this.eNx, this);
            this.nUi = cVar;
            this.nUk = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.nUk.a(this.nUn);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void VB(String str) {
        if (str == null) {
            str = "";
        }
        this.nUl = str;
    }

    public String cKz() {
        return this.nUl;
    }

    public void zd(boolean z) {
        if (this.nUi instanceof a.c) {
            ((a.c) this.nUi).za(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.jfT = forumWriteData;
    }

    public void b(ItemInfo itemInfo) {
        this.jcc = itemInfo;
    }

    public void VC(String str) {
        this.nUm = str;
    }

    public boolean isShowing() {
        return this.nUj;
    }

    public void ME(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.nUi.mRootView.getParent() == null) {
                com.baidu.tbadk.l.e.bL(this.mParentView).attachView(this.mParentView, this.nUi.mRootView, z);
            }
            this.nUk.d(view, view2);
            this.nUk.show();
            TiebaStatic.log(new ar("c12052").dY("obj_locate", this.nUm));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!au.isEmpty(string)) {
                    BdToast.b(this.eNx.getContext(), string).brB();
                    com.baidu.tbadk.core.sharedPref.b.bsO().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
            if (this.jfT != null && this.jfT.antiData != null && this.jfT.antiData.getCanGoods()) {
                TiebaStatic.log(new ar("c13896").al("obj_locate", 1).dY("fid", this.jfT.forumId).dY("fname", this.jfT.forumName));
            }
        }
    }

    public void MF(int i) {
        if (this.nUi instanceof a.c) {
            ((a.c) this.nUi).nTs.setIconFade(i);
        }
    }

    public void ze(boolean z) {
        this.nUk.gz(z);
        if (!z && (this.nUi instanceof a.c)) {
            ((a.c) this.nUi).nTs.bEb();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.nUi.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.nUi.mRootView != null && this.nUi.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.nUi.mRootView);
        }
        this.nUk.onDestroy();
    }

    public void dYw() {
        if (this.jfT != null) {
            TiebaStatic.log(new ar("c13897").al("obj_locate", 1).dY("fid", this.jfT.forumId).dY("fname", this.jfT.forumName));
        }
        ze(false);
        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNx.getPageActivity());
            aVar.oT(2);
            aVar.jm(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.eNx.getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new ar("c13959").al("obj_locate", 1).dY("fid", g.this.jfT.forumId).dY("fname", g.this.jfT.forumName));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
                    }
                }
            });
            aVar.bi(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new ar("c13958").al("obj_locate", 1).dY("fid", this.jfT.forumId).dY("fname", this.jfT.forumName));
            aVar.b(this.eNx).brv();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
    }

    public void VD(String str) {
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dY("obj_locate", this.nUm).al("obj_type", 5));
        ze(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.eNx.getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.jfT == null) {
            this.jfT = new ForumWriteData("0", null, null, null);
        }
        this.jfT.mFrom = this.mFrom;
        this.jfT.writeCallFrom = "2";
        writeVoteActivityConfig.setExtraData(this.jfT);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
        TiebaStatic.log(new ar("c13800").al("obj_source", 1));
    }

    public void dYx() {
        if (this.nUi instanceof a.b) {
            TiebaStatic.log("c13619");
            dYB();
        }
        ze(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNx.getPageActivity());
            aVar.setAutoNight(false);
            aVar.oP(R.string.prompt);
            aVar.Bq(this.eNx.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eNx).brv();
            return;
        }
        a(this.eNx, this.nUm, this.jfT);
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
                    TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dY("obj_locate", str).al("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.eNx.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dYy() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        ze(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jfT == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.jfT.forumId;
            String str7 = this.jfT.forumName;
            postPrefixData = this.jfT.prefixData;
            antiData = this.jfT.antiData;
            int i3 = this.jfT.forumLevel;
            String str8 = this.jfT.avatar;
            int i4 = this.jfT.privateThread;
            String str9 = this.jfT.firstDir;
            str = this.jfT.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dY("obj_locate", this.nUm).al("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.eNx.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom("2");
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(0);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.jfT != null ? this.jfT.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.jfT != null ? this.jfT.frsTabInfo : null);
        if (!StringUtils.isNull(this.nUl)) {
            writeActivityConfig.setTitle(this.nUl, true);
        }
        if (!a(this.eNx.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void dYz() {
        ze(false);
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dY("obj_locate", this.nUm).al("obj_type", 2));
        if (this.jfT == null) {
            this.jfT = new ForumWriteData("0", null, null, null);
        }
        this.jfT.mFrom = this.mFrom;
        this.jfT.writeCallFrom = "2";
        j.b(this.eNx, "", this.jfT);
    }

    public void dYA() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        ze(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jfT == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.jfT.forumId;
            String str7 = this.jfT.forumName;
            postPrefixData = this.jfT.prefixData;
            antiData = this.jfT.antiData;
            int i3 = this.jfT.forumLevel;
            String str8 = this.jfT.avatar;
            int i4 = this.jfT.privateThread;
            String str9 = this.jfT.firstDir;
            str = this.jfT.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.eNx.getPageActivity(), 9, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.getIntent().putExtra(IntentConfig.IS_EVALUATE, true);
        writeActivityConfig.setCallFrom("2");
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        if (this.jcc != null) {
            writeActivityConfig.setScoreItemInfo(new SerializableItemInfo(this.jcc));
            writeActivityConfig.setItemIsSchool(this.jcc.is_school.intValue() == 1);
            writeActivityConfig.setStarCount(this.jcc.score.comment_star.intValue());
        }
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.jfT != null ? this.jfT.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.jfT != null ? this.jfT.frsTabInfo : null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    public void VE(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        ze(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.jfT == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.jfT.forumId;
            String str8 = this.jfT.forumName;
            postPrefixData = this.jfT.prefixData;
            antiData = this.jfT.antiData;
            int i3 = this.jfT.forumLevel;
            String str9 = this.jfT.avatar;
            int i4 = this.jfT.privateThread;
            String str10 = this.jfT.firstDir;
            str2 = this.jfT.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dY("obj_locate", this.nUm).al("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.eNx.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom("2");
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.jfT != null ? this.jfT.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.jfT != null ? this.jfT.frsTabInfo : null);
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

    public void bHS() {
        if (this.nUi != null) {
            this.nUi.dYl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYB() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("home_publish_ala_has_showed", false);
        if (this.nUi instanceof a.b) {
            ((a.b) this.nUi).yZ(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("home_publish_ala_has_showed", true);
    }

    public void setCanGoods(boolean z) {
        if ((this.nUi instanceof a.c) && ((a.c) this.nUi).nTp != null) {
            ((a.c) this.nUi).nTp.setVisibility(z ? 0 : 8);
        }
    }
}
