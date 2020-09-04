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
import com.baidu.adp.lib.util.l;
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
    private com.baidu.tbadk.n.a.a Wr;
    private int bgColor;
    private TbPageContext efr;
    private ItemInfo icb;
    private ForumWriteData ifV;
    private String mFrom;
    private a mMI;
    private boolean mMJ;
    private h mMK;
    private String mML;
    private String mMM;
    private h.a mMN;
    private h.a mMO;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.mMJ = false;
        this.mSkinType = 3;
        this.mML = "";
        this.mFrom = "write";
        this.mMM = "0";
        this.mMO = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void Jw(int i2) {
                if (i2 == 1) {
                    g.this.mMJ = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.mMK instanceof d)) {
                        if (g.this.Wr == null) {
                            g.this.Wr = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.Wr.buv();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i2 == 2) {
                    if (g.this.Wr != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.mMK instanceof d)) {
                        g.this.Wr.buw();
                    }
                    g.this.dFT();
                } else if (i2 == 4) {
                    g.this.mMJ = false;
                    if (g.this.mMI.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.mMI.mRootView != null && g.this.mParentView.indexOfChild(g.this.mMI.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.mMI.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
                if (g.this.mMN != null) {
                    g.this.mMN.Jw(i2);
                }
            }
        };
        this.efr = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.b bVar = new a.b(this.efr, this);
            this.mMI = bVar;
            this.mMK = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0826a c0826a = new a.C0826a(this.efr, this);
            this.mMI = c0826a;
            this.mMK = new f(tbPageContext.getPageActivity(), c0826a);
        } else {
            a.c cVar = new a.c(this.efr, this);
            this.mMI = cVar;
            this.mMK = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mMK.a(this.mMO);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void Sx(String str) {
        if (str == null) {
            str = "";
        }
        this.mML = str;
    }

    public String cti() {
        return this.mML;
    }

    public void xb(boolean z) {
        if (this.mMI instanceof a.c) {
            ((a.c) this.mMI).wY(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.ifV = forumWriteData;
    }

    public void b(ItemInfo itemInfo) {
        this.icb = itemInfo;
    }

    public void Sy(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.mMM = str;
    }

    public boolean isShowing() {
        return this.mMJ;
    }

    public void Ju(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.mMI.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bs(this.mParentView).attachView(this.mParentView, this.mMI.mRootView, z);
            }
            this.mMK.d(view, view2);
            this.mMK.show();
            TiebaStatic.log(new aq("c12052").dD("obj_locate", this.mMM));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!at.isEmpty(string)) {
                    BdToast.b(this.efr.getContext(), string).bhm();
                    com.baidu.tbadk.core.sharedPref.b.bik().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
            if (this.ifV != null && this.ifV.antiData != null && this.ifV.antiData.getCanGoods()) {
                TiebaStatic.log(new aq("c13896").ai("obj_locate", 1).dD("fid", this.ifV.forumId).dD("fname", this.ifV.forumName));
            }
        }
    }

    public void Jv(int i) {
        if (this.mMI instanceof a.c) {
            ((a.c) this.mMI).mLZ.setIconFade(i);
        }
    }

    public void xc(boolean z) {
        this.mMK.fr(z);
        if (!z && (this.mMI instanceof a.c)) {
            ((a.c) this.mMI).mLZ.btd();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.mMI.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.mMI.mRootView != null && this.mMI.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.mMI.mRootView);
        }
        this.mMK.onDestroy();
    }

    public void dFO() {
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dD("obj_locate", this.mMM).ai("obj_type", 6));
        xc(false);
        UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(this.efr.getPageActivity(), RequestResponseCode.REQUEST_WRITE_NEW);
        if (this.ifV != null) {
            universityEvaluationConfig.setWriteData(this.ifV);
        }
        if (this.icb != null) {
            universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(this.icb));
            universityEvaluationConfig.setItemIsSchool(this.icb.is_school.intValue() == 1);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
        if (this.ifV != null && this.icb != null) {
            TiebaStatic.log(new aq("c13722").dD("fid", this.ifV.forumId).dD("fname", this.ifV.forumName).ai("obj_param1", this.icb.id.intValue()));
        }
    }

    public void dFP() {
        if (this.ifV != null) {
            TiebaStatic.log(new aq("c13897").ai("obj_locate", 1).dD("fid", this.ifV.forumId).dD("fname", this.ifV.forumName));
        }
        xc(false);
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efr.getPageActivity());
            aVar.nw(2);
            aVar.ih(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.efr.getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new aq("c13959").ai("obj_locate", 1).dD("fid", g.this.ifV.forumId).dD("fname", g.this.ifV.forumName));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
                    }
                }
            });
            aVar.aX(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new aq("c13958").ai("obj_locate", 1).dD("fid", this.ifV.forumId).dD("fname", this.ifV.forumName));
            aVar.b(this.efr).bhg();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
    }

    public void Sz(String str) {
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dD("obj_locate", this.mMM).ai("obj_type", 5));
        if (this.ifV != null && this.ifV.antiData != null) {
            int pollLevel = this.ifV.antiData.getPollLevel();
            if (this.ifV.forumLevel < pollLevel) {
                l.showToast(this.efr.getPageActivity(), String.format(this.efr.getString(R.string.vote_level_tip), Integer.valueOf(pollLevel)));
                return;
            }
            xc(false);
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.efr.getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
            writeVoteActivityConfig.setExtraTitle(str);
            writeVoteActivityConfig.setExtraData(this.ifV);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
            TiebaStatic.log(new aq("c13800").ai("obj_source", 1));
        }
    }

    public void dFQ() {
        if (this.mMI instanceof a.b) {
            TiebaStatic.log("c13619");
            dFT();
        }
        xc(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efr.getPageActivity());
            aVar.setAutoNight(false);
            aVar.ns(R.string.prompt);
            aVar.zA(this.efr.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.efr).bhg();
            return;
        }
        a(this.efr, this.mMM, this.ifV);
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
                    com.baidu.adp.lib.c.a.mf().getAddress(false);
                    if (forumWriteData != null) {
                        str4 = forumWriteData.forumId;
                        str2 = forumWriteData.forumName;
                        str3 = forumWriteData.specialForumType;
                    } else {
                        str2 = null;
                    }
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dD("obj_locate", str).ai("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.efr.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dFR() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        xc(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.ifV == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.ifV.forumId;
            String str7 = this.ifV.forumName;
            postPrefixData = this.ifV.prefixData;
            antiData = this.ifV.antiData;
            int i3 = this.ifV.forumLevel;
            String str8 = this.ifV.avatar;
            int i4 = this.ifV.privateThread;
            String str9 = this.ifV.firstDir;
            str = this.ifV.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dD("obj_locate", this.mMM).ai("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.efr.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(0);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.ifV != null ? this.ifV.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.ifV != null ? this.ifV.frsTabInfo : null);
        if (!StringUtils.isNull(this.mML)) {
            writeActivityConfig.setTitle(this.mML, true);
        }
        if (!a(this.efr.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void dFS() {
        xc(false);
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dD("obj_locate", this.mMM).ai("obj_type", 2));
        if (this.ifV == null) {
            this.ifV = new ForumWriteData("0", null, null, null);
        }
        this.ifV.mFrom = this.mFrom;
        this.ifV.writeCallFrom = this.writeCallFrom;
        j.b(this.efr, "", this.ifV);
    }

    public void SA(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        xc(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.ifV == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.ifV.forumId;
            String str8 = this.ifV.forumName;
            postPrefixData = this.ifV.prefixData;
            antiData = this.ifV.antiData;
            int i3 = this.ifV.forumLevel;
            String str9 = this.ifV.avatar;
            int i4 = this.ifV.privateThread;
            String str10 = this.ifV.firstDir;
            str2 = this.ifV.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dD("obj_locate", this.mMM).ai("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.efr.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.ifV != null ? this.ifV.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.ifV != null ? this.ifV.frsTabInfo : null);
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

    public void bwN() {
        if (this.mMI != null) {
            this.mMI.dFB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFT() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("home_publish_ala_has_showed", false);
        if (this.mMI instanceof a.b) {
            ((a.b) this.mMI).wX(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("home_publish_ala_has_showed", true);
    }

    public void setCanGoods(boolean z) {
        if ((this.mMI instanceof a.c) && ((a.c) this.mMI).mLW != null) {
            ((a.c) this.mMI).mLW.setVisibility(z ? 0 : 8);
        }
    }
}
