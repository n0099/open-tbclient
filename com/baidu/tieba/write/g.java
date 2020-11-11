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
    private com.baidu.tbadk.n.a.a Xa;
    private int bgColor;
    private TbPageContext eIc;
    private ItemInfo iQv;
    private ForumWriteData iUj;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private boolean nEA;
    private h nEB;
    private String nEC;
    private String nED;
    private h.a nEE;
    private a nEz;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.nEA = false;
        this.mSkinType = 3;
        this.nEC = "";
        this.mFrom = "write";
        this.nED = "0";
        this.nEE = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void Ll(int i2) {
                if (i2 == 1) {
                    g.this.nEA = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nEB instanceof d)) {
                        if (g.this.Xa == null) {
                            g.this.Xa = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.Xa.bCB();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i2 == 2) {
                    if (g.this.Xa != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nEB instanceof d)) {
                        g.this.Xa.bCC();
                    }
                    g.this.dTh();
                } else if (i2 == 4) {
                    g.this.nEA = false;
                    if (g.this.nEz.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.nEz.mRootView != null && g.this.mParentView.indexOfChild(g.this.nEz.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.nEz.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
            }
        };
        this.eIc = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.b bVar = new a.b(this.eIc, this);
            this.nEz = bVar;
            this.nEB = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0871a c0871a = new a.C0871a(this.eIc, this);
            this.nEz = c0871a;
            this.nEB = new f(tbPageContext.getPageActivity(), c0871a);
        } else {
            a.c cVar = new a.c(this.eIc, this);
            this.nEz = cVar;
            this.nEB = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.nEB.a(this.nEE);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void UB(String str) {
        if (str == null) {
            str = "";
        }
        this.nEC = str;
    }

    public String cFE() {
        return this.nEC;
    }

    public void yr(boolean z) {
        if (this.nEz instanceof a.c) {
            ((a.c) this.nEz).yo(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.iUj = forumWriteData;
    }

    public void b(ItemInfo itemInfo) {
        this.iQv = itemInfo;
    }

    public void UC(String str) {
        this.nED = str;
    }

    public boolean isShowing() {
        return this.nEA;
    }

    public void Lj(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.nEz.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bF(this.mParentView).attachView(this.mParentView, this.nEz.mRootView, z);
            }
            this.nEB.d(view, view2);
            this.nEB.show();
            TiebaStatic.log(new aq("c12052").dR("obj_locate", this.nED));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!at.isEmpty(string)) {
                    BdToast.b(this.eIc.getContext(), string).bpi();
                    com.baidu.tbadk.core.sharedPref.b.bqh().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
            if (this.iUj != null && this.iUj.antiData != null && this.iUj.antiData.getCanGoods()) {
                TiebaStatic.log(new aq("c13896").al("obj_locate", 1).dR("fid", this.iUj.forumId).dR("fname", this.iUj.forumName));
            }
        }
    }

    public void Lk(int i) {
        if (this.nEz instanceof a.c) {
            ((a.c) this.nEz).nDN.setIconFade(i);
        }
    }

    public void ys(boolean z) {
        this.nEB.gh(z);
        if (!z && (this.nEz instanceof a.c)) {
            ((a.c) this.nEz).nDN.bBj();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.nEz.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.nEz.mRootView != null && this.nEz.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.nEz.mRootView);
        }
        this.nEB.onDestroy();
    }

    public void dTc() {
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nED).al("obj_type", 6));
        ys(false);
        UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(this.eIc.getPageActivity(), RequestResponseCode.REQUEST_WRITE_NEW);
        if (this.iUj != null) {
            universityEvaluationConfig.setWriteData(this.iUj);
        }
        if (this.iQv != null) {
            universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(this.iQv));
            universityEvaluationConfig.setItemIsSchool(this.iQv.is_school.intValue() == 1);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
        if (this.iUj != null && this.iQv != null) {
            TiebaStatic.log(new aq("c13722").dR("fid", this.iUj.forumId).dR("fname", this.iUj.forumName).al("obj_param1", this.iQv.id.intValue()));
        }
    }

    public void dTd() {
        if (this.iUj != null) {
            TiebaStatic.log(new aq("c13897").al("obj_locate", 1).dR("fid", this.iUj.forumId).dR("fname", this.iUj.forumName));
        }
        ys(false);
        if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIc.getPageActivity());
            aVar.oz(2);
            aVar.iW(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.eIc.getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new aq("c13959").al("obj_locate", 1).dR("fid", g.this.iUj.forumId).dR("fname", g.this.iUj.forumName));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
                    }
                }
            });
            aVar.bf(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new aq("c13958").al("obj_locate", 1).dR("fid", this.iUj.forumId).dR("fname", this.iUj.forumName));
            aVar.b(this.eIc).bpc();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
    }

    public void UD(String str) {
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nED).al("obj_type", 5));
        ys(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.eIc.getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.iUj == null) {
            this.iUj = new ForumWriteData("0", null, null, null);
        }
        this.iUj.mFrom = this.mFrom;
        this.iUj.writeCallFrom = "2";
        writeVoteActivityConfig.setExtraData(this.iUj);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
        TiebaStatic.log(new aq("c13800").al("obj_source", 1));
    }

    public void dTe() {
        if (this.nEz instanceof a.b) {
            TiebaStatic.log("c13619");
            dTh();
        }
        ys(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIc.getPageActivity());
            aVar.setAutoNight(false);
            aVar.ov(R.string.prompt);
            aVar.Bo(this.eIc.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eIc).bpc();
            return;
        }
        a(this.eIc, this.nED, this.iUj);
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
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", str).al("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.eIc.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dTf() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        ys(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.iUj == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.iUj.forumId;
            String str7 = this.iUj.forumName;
            postPrefixData = this.iUj.prefixData;
            antiData = this.iUj.antiData;
            int i3 = this.iUj.forumLevel;
            String str8 = this.iUj.avatar;
            int i4 = this.iUj.privateThread;
            String str9 = this.iUj.firstDir;
            str = this.iUj.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nED).al("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.eIc.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom("2");
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(0);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.iUj != null ? this.iUj.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.iUj != null ? this.iUj.frsTabInfo : null);
        if (!StringUtils.isNull(this.nEC)) {
            writeActivityConfig.setTitle(this.nEC, true);
        }
        if (!a(this.eIc.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void dTg() {
        ys(false);
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nED).al("obj_type", 2));
        if (this.iUj == null) {
            this.iUj = new ForumWriteData("0", null, null, null);
        }
        this.iUj.mFrom = this.mFrom;
        this.iUj.writeCallFrom = "2";
        j.b(this.eIc, "", this.iUj);
    }

    public void UE(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        ys(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.iUj == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.iUj.forumId;
            String str8 = this.iUj.forumName;
            postPrefixData = this.iUj.prefixData;
            antiData = this.iUj.antiData;
            int i3 = this.iUj.forumLevel;
            String str9 = this.iUj.avatar;
            int i4 = this.iUj.privateThread;
            String str10 = this.iUj.firstDir;
            str2 = this.iUj.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nED).al("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.eIc.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom("2");
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.iUj != null ? this.iUj.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.iUj != null ? this.iUj.frsTabInfo : null);
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

    public void bEY() {
        if (this.nEz != null) {
            this.nEz.dSR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTh() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("home_publish_ala_has_showed", false);
        if (this.nEz instanceof a.b) {
            ((a.b) this.nEz).yn(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("home_publish_ala_has_showed", true);
    }

    public void setCanGoods(boolean z) {
        if ((this.nEz instanceof a.c) && ((a.c) this.nEz).nDK != null) {
            ((a.c) this.nEz).nDK.setVisibility(z ? 0 : 8);
        }
    }
}
