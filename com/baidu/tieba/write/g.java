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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.write.a;
import com.baidu.tieba.write.h;
import com.baidu.webkit.sdk.PermissionRequest;
import tbclient.ItemInfo;
/* loaded from: classes.dex */
public class g {
    private com.baidu.tbadk.n.a.a VX;
    private int bgColor;
    private TbPageContext dPv;
    private ItemInfo hHP;
    private ForumWriteData hLG;
    private h.a lMc;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private a mmb;
    private boolean mmc;
    private h mmd;
    private String mme;
    private String mmf;
    private h.a mmg;
    private String writeCallFrom;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.mmc = false;
        this.mSkinType = 3;
        this.mme = "";
        this.mFrom = "write";
        this.mmf = "0";
        this.mmg = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void Fp(int i2) {
                if (i2 == 1) {
                    g.this.mmc = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.mmd instanceof d)) {
                        if (g.this.VX == null) {
                            g.this.VX = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.VX.bhW();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i2 == 2) {
                    if (g.this.VX != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.mmd instanceof d)) {
                        g.this.VX.bhX();
                    }
                    g.this.drb();
                } else if (i2 == 4) {
                    g.this.mmc = false;
                    if (g.this.mmb.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.mmb.mRootView != null && g.this.mParentView.indexOfChild(g.this.mmb.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.mmb.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
                if (g.this.lMc != null) {
                    g.this.lMc.Fp(i2);
                }
            }
        };
        this.dPv = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.b bVar = new a.b(this.dPv, this);
            this.mmb = bVar;
            this.mmd = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0763a c0763a = new a.C0763a(this.dPv, this);
            this.mmb = c0763a;
            this.mmd = new f(tbPageContext.getPageActivity(), c0763a);
        } else {
            a.c cVar = new a.c(this.dPv, this);
            this.mmb = cVar;
            this.mmd = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mmd.b(this.mmg);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void OO(String str) {
        if (str == null) {
            str = "";
        }
        this.mme = str;
    }

    public String cfe() {
        return this.mme;
    }

    public void vG(boolean z) {
        if (this.mmb instanceof a.c) {
            ((a.c) this.mmb).vD(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.hLG = forumWriteData;
    }

    public void b(ItemInfo itemInfo) {
        this.hHP = itemInfo;
    }

    public void OP(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.mmf = str;
    }

    public boolean isShowing() {
        return this.mmc;
    }

    public void GC(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.mmb.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bk(this.mParentView).attachView(this.mParentView, this.mmb.mRootView, z);
            }
            this.mmd.d(view, view2);
            this.mmd.show();
            TiebaStatic.log(new ao("c12052").dk("obj_locate", this.mmf));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!ar.isEmpty(string)) {
                    BdToast.b(this.dPv.getContext(), string).aUS();
                    com.baidu.tbadk.core.sharedPref.b.aVP().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void GD(int i) {
        if (this.mmb instanceof a.c) {
            ((a.c) this.mmb).mlr.setIconFade(i);
        }
    }

    public void vH(boolean z) {
        this.mmd.eO(z);
        if (!z && (this.mmb instanceof a.c)) {
            ((a.c) this.mmb).mlr.bgF();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.mmb.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.mmb.mRootView != null && this.mmb.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.mmb.mRootView);
        }
        this.mmd.onDestroy();
    }

    public void dqX() {
        TiebaStatic.log(new ao(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dk("obj_locate", this.mmf).ag("obj_type", 6));
        vH(false);
        UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(this.dPv.getPageActivity(), RequestResponseCode.REQUEST_WRITE_NEW);
        if (this.hLG != null) {
            universityEvaluationConfig.setWriteData(this.hLG);
        }
        if (this.hHP != null) {
            universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(this.hHP));
            universityEvaluationConfig.setItemIsSchool(this.hHP.is_school.intValue() == 1);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
        if (this.hLG != null && this.hHP != null) {
            TiebaStatic.log(new ao("c13722").dk("fid", this.hLG.forumId).dk("fname", this.hLG.forumName).ag("obj_param1", this.hHP.id.intValue()));
        }
    }

    public void OQ(String str) {
        TiebaStatic.log(new ao(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dk("obj_locate", this.mmf).ag("obj_type", 5));
        if (this.hLG != null && this.hLG.antiData != null) {
            int pollLevel = this.hLG.antiData.getPollLevel();
            if (this.hLG.forumLevel < pollLevel) {
                l.showToast(this.dPv.getPageActivity(), String.format(this.dPv.getString(R.string.vote_level_tip), Integer.valueOf(pollLevel)));
                return;
            }
            vH(false);
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.dPv.getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
            writeVoteActivityConfig.setExtraTitle(str);
            writeVoteActivityConfig.setExtraData(this.hLG);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
            TiebaStatic.log(new ao("c13800").ag("obj_source", 1));
        }
    }

    public void dqY() {
        if (this.mmb instanceof a.b) {
            TiebaStatic.log("c13619");
            drb();
        }
        vH(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPv.getPageActivity());
            aVar.setAutoNight(false);
            aVar.kS(R.string.prompt);
            aVar.we(this.dPv.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.dPv).aUN();
            return;
        }
        a(this.dPv, this.mmf, this.hLG);
    }

    public void a(TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (tbPageContext != null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.write.g.3
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
                public void onPermissionsGranted() {
                    String str2;
                    String str3 = null;
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    String str4 = "0";
                    com.baidu.adp.lib.c.a.kG().getAddress(false);
                    if (forumWriteData != null) {
                        str4 = forumWriteData.forumId;
                        str2 = forumWriteData.forumName;
                        str3 = forumWriteData.specialForumType;
                    } else {
                        str2 = null;
                    }
                    TiebaStatic.log(new ao(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dk("obj_locate", str).ag("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.dPv.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dqZ() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        vH(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hLG == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.hLG.forumId;
            String str7 = this.hLG.forumName;
            postPrefixData = this.hLG.prefixData;
            antiData = this.hLG.antiData;
            int i3 = this.hLG.forumLevel;
            String str8 = this.hLG.avatar;
            int i4 = this.hLG.privateThread;
            String str9 = this.hLG.firstDir;
            str = this.hLG.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new ao(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dk("obj_locate", this.mmf).ag("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.dPv.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(0);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.hLG != null ? this.hLG.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.hLG != null ? this.hLG.frsTabInfo : null);
        if (!StringUtils.isNull(this.mme)) {
            writeActivityConfig.setTitle(this.mme, true);
        }
        if (!a(this.dPv.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void dra() {
        vH(false);
        TiebaStatic.log(new ao(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dk("obj_locate", this.mmf).ag("obj_type", 2));
        if (this.hLG == null) {
            this.hLG = new ForumWriteData("0", null, null, null);
        }
        this.hLG.mFrom = this.mFrom;
        this.hLG.writeCallFrom = this.writeCallFrom;
        j.b(this.dPv, "", this.hLG);
    }

    public void OR(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        vH(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hLG == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hLG.forumId;
            String str8 = this.hLG.forumName;
            postPrefixData = this.hLG.prefixData;
            antiData = this.hLG.antiData;
            int i3 = this.hLG.forumLevel;
            String str9 = this.hLG.avatar;
            int i4 = this.hLG.privateThread;
            String str10 = this.hLG.firstDir;
            str2 = this.hLG.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new ao(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dk("obj_locate", this.mmf).ag("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.dPv.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.hLG != null ? this.hLG.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.hLG != null ? this.hLG.frsTabInfo : null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    private static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.write.g.4
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
            public void onPermissionsGranted() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, WriteActivityConfig.this));
            }
        });
        return permissionJudgePolicy.startRequestPermission(activity);
    }

    public void bkf() {
        if (this.mmb != null) {
            this.mmb.dqK();
        }
    }

    public void a(h.a aVar) {
        this.lMc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drb() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("home_publish_ala_has_showed", false);
        if (this.mmb instanceof a.b) {
            ((a.b) this.mmb).vC(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("home_publish_ala_has_showed", true);
    }
}
