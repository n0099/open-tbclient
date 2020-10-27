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
    private TbPageContext eCn;
    private ItemInfo iKy;
    private ForumWriteData iOm;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private a nyF;
    private boolean nyG;
    private h nyH;
    private String nyI;
    private String nyJ;
    private h.a nyK;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.nyG = false;
        this.mSkinType = 3;
        this.nyI = "";
        this.mFrom = "write";
        this.nyJ = "0";
        this.nyK = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void KY(int i2) {
                if (i2 == 1) {
                    g.this.nyG = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nyH instanceof d)) {
                        if (g.this.Xa == null) {
                            g.this.Xa = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.Xa.bAc();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i2 == 2) {
                    if (g.this.Xa != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nyH instanceof d)) {
                        g.this.Xa.bAd();
                    }
                    g.this.dQH();
                } else if (i2 == 4) {
                    g.this.nyG = false;
                    if (g.this.nyF.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.nyF.mRootView != null && g.this.mParentView.indexOfChild(g.this.nyF.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.nyF.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
            }
        };
        this.eCn = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.b bVar = new a.b(this.eCn, this);
            this.nyF = bVar;
            this.nyH = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0856a c0856a = new a.C0856a(this.eCn, this);
            this.nyF = c0856a;
            this.nyH = new f(tbPageContext.getPageActivity(), c0856a);
        } else {
            a.c cVar = new a.c(this.eCn, this);
            this.nyF = cVar;
            this.nyH = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.nyH.a(this.nyK);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void Uk(String str) {
        if (str == null) {
            str = "";
        }
        this.nyI = str;
    }

    public String cDd() {
        return this.nyI;
    }

    public void yi(boolean z) {
        if (this.nyF instanceof a.c) {
            ((a.c) this.nyF).yf(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.iOm = forumWriteData;
    }

    public void b(ItemInfo itemInfo) {
        this.iKy = itemInfo;
    }

    public void Ul(String str) {
        this.nyJ = str;
    }

    public boolean isShowing() {
        return this.nyG;
    }

    public void KW(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.nyF.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bB(this.mParentView).attachView(this.mParentView, this.nyF.mRootView, z);
            }
            this.nyH.d(view, view2);
            this.nyH.show();
            TiebaStatic.log(new aq("c12052").dR("obj_locate", this.nyJ));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!at.isEmpty(string)) {
                    BdToast.b(this.eCn.getContext(), string).bmI();
                    com.baidu.tbadk.core.sharedPref.b.bnH().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
            if (this.iOm != null && this.iOm.antiData != null && this.iOm.antiData.getCanGoods()) {
                TiebaStatic.log(new aq("c13896").aj("obj_locate", 1).dR("fid", this.iOm.forumId).dR("fname", this.iOm.forumName));
            }
        }
    }

    public void KX(int i) {
        if (this.nyF instanceof a.c) {
            ((a.c) this.nyF).nxT.setIconFade(i);
        }
    }

    public void yj(boolean z) {
        this.nyH.fY(z);
        if (!z && (this.nyF instanceof a.c)) {
            ((a.c) this.nyF).nxT.byK();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.nyF.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.nyF.mRootView != null && this.nyF.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.nyF.mRootView);
        }
        this.nyH.onDestroy();
    }

    public void dQC() {
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nyJ).aj("obj_type", 6));
        yj(false);
        UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(this.eCn.getPageActivity(), RequestResponseCode.REQUEST_WRITE_NEW);
        if (this.iOm != null) {
            universityEvaluationConfig.setWriteData(this.iOm);
        }
        if (this.iKy != null) {
            universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(this.iKy));
            universityEvaluationConfig.setItemIsSchool(this.iKy.is_school.intValue() == 1);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
        if (this.iOm != null && this.iKy != null) {
            TiebaStatic.log(new aq("c13722").dR("fid", this.iOm.forumId).dR("fname", this.iOm.forumName).aj("obj_param1", this.iKy.id.intValue()));
        }
    }

    public void dQD() {
        if (this.iOm != null) {
            TiebaStatic.log(new aq("c13897").aj("obj_locate", 1).dR("fid", this.iOm.forumId).dR("fname", this.iOm.forumName));
        }
        yj(false);
        if (!com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCn.getPageActivity());
            aVar.op(2);
            aVar.iN(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.eCn.getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new aq("c13959").aj("obj_locate", 1).dR("fid", g.this.iOm.forumId).dR("fname", g.this.iOm.forumName));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
                    }
                }
            });
            aVar.bb(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new aq("c13958").aj("obj_locate", 1).dR("fid", this.iOm.forumId).dR("fname", this.iOm.forumName));
            aVar.b(this.eCn).bmC();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
    }

    public void Um(String str) {
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nyJ).aj("obj_type", 5));
        yj(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.eCn.getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.iOm == null) {
            this.iOm = new ForumWriteData("0", null, null, null);
        }
        this.iOm.mFrom = this.mFrom;
        this.iOm.writeCallFrom = "2";
        writeVoteActivityConfig.setExtraData(this.iOm);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
        TiebaStatic.log(new aq("c13800").aj("obj_source", 1));
    }

    public void dQE() {
        if (this.nyF instanceof a.b) {
            TiebaStatic.log("c13619");
            dQH();
        }
        yj(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCn.getPageActivity());
            aVar.setAutoNight(false);
            aVar.ol(R.string.prompt);
            aVar.Ba(this.eCn.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eCn).bmC();
            return;
        }
        a(this.eCn, this.nyJ, this.iOm);
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
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", str).aj("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.eCn.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dQF() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        yj(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.iOm == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.iOm.forumId;
            String str7 = this.iOm.forumName;
            postPrefixData = this.iOm.prefixData;
            antiData = this.iOm.antiData;
            int i3 = this.iOm.forumLevel;
            String str8 = this.iOm.avatar;
            int i4 = this.iOm.privateThread;
            String str9 = this.iOm.firstDir;
            str = this.iOm.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nyJ).aj("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.eCn.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom("2");
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(0);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.iOm != null ? this.iOm.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.iOm != null ? this.iOm.frsTabInfo : null);
        if (!StringUtils.isNull(this.nyI)) {
            writeActivityConfig.setTitle(this.nyI, true);
        }
        if (!a(this.eCn.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void dQG() {
        yj(false);
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nyJ).aj("obj_type", 2));
        if (this.iOm == null) {
            this.iOm = new ForumWriteData("0", null, null, null);
        }
        this.iOm.mFrom = this.mFrom;
        this.iOm.writeCallFrom = "2";
        j.b(this.eCn, "", this.iOm);
    }

    public void Un(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        yj(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.iOm == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.iOm.forumId;
            String str8 = this.iOm.forumName;
            postPrefixData = this.iOm.prefixData;
            antiData = this.iOm.antiData;
            int i3 = this.iOm.forumLevel;
            String str9 = this.iOm.avatar;
            int i4 = this.iOm.privateThread;
            String str10 = this.iOm.firstDir;
            str2 = this.iOm.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dR("obj_locate", this.nyJ).aj("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.eCn.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom("2");
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.iOm != null ? this.iOm.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.iOm != null ? this.iOm.frsTabInfo : null);
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

    public void bCz() {
        if (this.nyF != null) {
            this.nyF.dQp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQH() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("home_publish_ala_has_showed", false);
        if (this.nyF instanceof a.b) {
            ((a.b) this.nyF).ye(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("home_publish_ala_has_showed", true);
    }

    public void setCanGoods(boolean z) {
        if ((this.nyF instanceof a.c) && ((a.c) this.nyF).nxQ != null) {
            ((a.c) this.nyF).nxQ.setVisibility(z ? 0 : 8);
        }
    }
}
