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
    private com.baidu.tbadk.n.a.a WZ;
    private int bgColor;
    private TbPageContext etO;
    private ForumWriteData iBQ;
    private ItemInfo iyc;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private a nme;
    private boolean nmf;
    private h nmg;
    private String nmh;
    private String nmi;
    private h.a nmj;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.nmf = false;
        this.mSkinType = 3;
        this.nmh = "";
        this.mFrom = "write";
        this.nmi = "0";
        this.nmj = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void KG(int i2) {
                if (i2 == 1) {
                    g.this.nmf = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nmg instanceof d)) {
                        if (g.this.WZ == null) {
                            g.this.WZ = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.WZ.byj();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i2 == 2) {
                    if (g.this.WZ != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.nmg instanceof d)) {
                        g.this.WZ.byk();
                    }
                    g.this.dNz();
                } else if (i2 == 4) {
                    g.this.nmf = false;
                    if (g.this.nme.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.nme.mRootView != null && g.this.mParentView.indexOfChild(g.this.nme.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.nme.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
            }
        };
        this.etO = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.b bVar = new a.b(this.etO, this);
            this.nme = bVar;
            this.nmg = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0841a c0841a = new a.C0841a(this.etO, this);
            this.nme = c0841a;
            this.nmg = new f(tbPageContext.getPageActivity(), c0841a);
        } else {
            a.c cVar = new a.c(this.etO, this);
            this.nme = cVar;
            this.nmg = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.nmg.a(this.nmj);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void TL(String str) {
        if (str == null) {
            str = "";
        }
        this.nmh = str;
    }

    public String czW() {
        return this.nmh;
    }

    public void xR(boolean z) {
        if (this.nme instanceof a.c) {
            ((a.c) this.nme).xO(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.iBQ = forumWriteData;
    }

    public void b(ItemInfo itemInfo) {
        this.iyc = itemInfo;
    }

    public void TM(String str) {
        this.nmi = str;
    }

    public boolean isShowing() {
        return this.nmf;
    }

    public void KE(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.nme.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bA(this.mParentView).attachView(this.mParentView, this.nme.mRootView, z);
            }
            this.nmg.d(view, view2);
            this.nmg.show();
            TiebaStatic.log(new aq("c12052").dK("obj_locate", this.nmi));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.blO().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!at.isEmpty(string)) {
                    BdToast.b(this.etO.getContext(), string).bkP();
                    com.baidu.tbadk.core.sharedPref.b.blO().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
            if (this.iBQ != null && this.iBQ.antiData != null && this.iBQ.antiData.getCanGoods()) {
                TiebaStatic.log(new aq("c13896").aj("obj_locate", 1).dK("fid", this.iBQ.forumId).dK("fname", this.iBQ.forumName));
            }
        }
    }

    public void KF(int i) {
        if (this.nme instanceof a.c) {
            ((a.c) this.nme).nls.setIconFade(i);
        }
    }

    public void xS(boolean z) {
        this.nmg.fL(z);
        if (!z && (this.nme instanceof a.c)) {
            ((a.c) this.nme).nls.bwR();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.nme.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.nme.mRootView != null && this.nme.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.nme.mRootView);
        }
        this.nmg.onDestroy();
    }

    public void dNu() {
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dK("obj_locate", this.nmi).aj("obj_type", 6));
        xS(false);
        UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(this.etO.getPageActivity(), RequestResponseCode.REQUEST_WRITE_NEW);
        if (this.iBQ != null) {
            universityEvaluationConfig.setWriteData(this.iBQ);
        }
        if (this.iyc != null) {
            universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(this.iyc));
            universityEvaluationConfig.setItemIsSchool(this.iyc.is_school.intValue() == 1);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
        if (this.iBQ != null && this.iyc != null) {
            TiebaStatic.log(new aq("c13722").dK("fid", this.iBQ.forumId).dK("fname", this.iBQ.forumName).aj("obj_param1", this.iyc.id.intValue()));
        }
    }

    public void dNv() {
        if (this.iBQ != null) {
            TiebaStatic.log(new aq("c13897").aj("obj_locate", 1).dK("fid", this.iBQ.forumId).dK("fname", this.iBQ.forumName));
        }
        xS(false);
        if (!com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.etO.getPageActivity());
            aVar.oe(2);
            aVar.iA(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.etO.getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new aq("c13959").aj("obj_locate", 1).dK("fid", g.this.iBQ.forumId).dK("fname", g.this.iBQ.forumName));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
                    }
                }
            });
            aVar.ba(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new aq("c13958").aj("obj_locate", 1).dK("fid", this.iBQ.forumId).dK("fname", this.iBQ.forumName));
            aVar.b(this.etO).bkJ();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=10"));
    }

    public void TN(String str) {
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dK("obj_locate", this.nmi).aj("obj_type", 5));
        xS(false);
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.etO.getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
        writeVoteActivityConfig.setExtraTitle(str);
        if (this.iBQ == null) {
            this.iBQ = new ForumWriteData("0", null, null, null);
        }
        this.iBQ.mFrom = this.mFrom;
        this.iBQ.writeCallFrom = "2";
        writeVoteActivityConfig.setExtraData(this.iBQ);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
        TiebaStatic.log(new aq("c13800").aj("obj_source", 1));
    }

    public void dNw() {
        if (this.nme instanceof a.b) {
            TiebaStatic.log("c13619");
            dNz();
        }
        xS(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.etO.getPageActivity());
            aVar.setAutoNight(false);
            aVar.oa(R.string.prompt);
            aVar.AH(this.etO.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.etO).bkJ();
            return;
        }
        a(this.etO, this.nmi, this.iBQ);
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
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dK("obj_locate", str).aj("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.etO.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dNx() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        xS(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.iBQ == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.iBQ.forumId;
            String str7 = this.iBQ.forumName;
            postPrefixData = this.iBQ.prefixData;
            antiData = this.iBQ.antiData;
            int i3 = this.iBQ.forumLevel;
            String str8 = this.iBQ.avatar;
            int i4 = this.iBQ.privateThread;
            String str9 = this.iBQ.firstDir;
            str = this.iBQ.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dK("obj_locate", this.nmi).aj("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.etO.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom("2");
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(0);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.iBQ != null ? this.iBQ.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.iBQ != null ? this.iBQ.frsTabInfo : null);
        if (!StringUtils.isNull(this.nmh)) {
            writeActivityConfig.setTitle(this.nmh, true);
        }
        if (!a(this.etO.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void dNy() {
        xS(false);
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dK("obj_locate", this.nmi).aj("obj_type", 2));
        if (this.iBQ == null) {
            this.iBQ = new ForumWriteData("0", null, null, null);
        }
        this.iBQ.mFrom = this.mFrom;
        this.iBQ.writeCallFrom = "2";
        j.b(this.etO, "", this.iBQ);
    }

    public void TO(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        xS(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.iBQ == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.iBQ.forumId;
            String str8 = this.iBQ.forumName;
            postPrefixData = this.iBQ.prefixData;
            antiData = this.iBQ.antiData;
            int i3 = this.iBQ.forumLevel;
            String str9 = this.iBQ.avatar;
            int i4 = this.iBQ.privateThread;
            String str10 = this.iBQ.firstDir;
            str2 = this.iBQ.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dK("obj_locate", this.nmi).aj("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.etO.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom("2");
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.iBQ != null ? this.iBQ.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.iBQ != null ? this.iBQ.frsTabInfo : null);
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

    public void bAG() {
        if (this.nme != null) {
            this.nme.dNh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNz() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("home_publish_ala_has_showed", false);
        if (this.nme instanceof a.b) {
            ((a.b) this.nme).xN(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("home_publish_ala_has_showed", true);
    }

    public void setCanGoods(boolean z) {
        if ((this.nme instanceof a.c) && ((a.c) this.nme).nlp != null) {
            ((a.c) this.nme).nlp.setVisibility(z ? 0 : 8);
        }
    }
}
