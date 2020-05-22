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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.a;
import com.baidu.tieba.write.h;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes.dex */
public class g {
    private com.baidu.tbadk.n.a.a Vt;
    private int bgColor;
    private TbPageContext dIF;
    private ForumWriteData lHN;
    private a lQD;
    private boolean lQE;
    private h lQF;
    private String lQG;
    private String lQH;
    private h.a lQI;
    private h.a lri;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.lQE = false;
        this.mSkinType = 3;
        this.lQG = "";
        this.mFrom = "write";
        this.lQH = "0";
        this.lQI = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void El(int i2) {
                if (i2 == 1) {
                    g.this.lQE = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.lQF instanceof d)) {
                        if (g.this.Vt == null) {
                            g.this.Vt = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.Vt.bfP();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 2) {
                    if (g.this.Vt != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.lQF instanceof d)) {
                        g.this.Vt.bfQ();
                    }
                    g.this.dmv();
                } else if (i2 == 4) {
                    g.this.lQE = false;
                    if (g.this.lQD.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.lQD.mRootView != null && g.this.mParentView.indexOfChild(g.this.lQD.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.lQD.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
                if (g.this.lri != null) {
                    g.this.lri.El(i2);
                }
            }
        };
        this.dIF = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.b bVar = new a.b(this.dIF, this);
            this.lQD = bVar;
            this.lQF = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0746a c0746a = new a.C0746a(this.dIF, this);
            this.lQD = c0746a;
            this.lQF = new f(tbPageContext.getPageActivity(), c0746a);
        } else {
            a.c cVar = new a.c(this.dIF, this);
            this.lQD = cVar;
            this.lQF = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lQF.b(this.lQI);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void Og(String str) {
        if (str == null) {
            str = "";
        }
        this.lQG = str;
    }

    public String cbD() {
        return this.lQG;
    }

    public void a(ForumWriteData forumWriteData) {
        this.lHN = forumWriteData;
    }

    public void Oh(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.lQH = str;
    }

    public boolean isShowing() {
        return this.lQE;
    }

    public void Fw(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.lQD.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bj(this.mParentView).attachView(this.mParentView, this.lQD.mRootView, z);
            }
            this.lQF.c(view, view2);
            this.lQF.show();
            TiebaStatic.log(new an("c12052").dh("obj_locate", this.lQH));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.dIF.getContext(), string).aSY();
                    com.baidu.tbadk.core.sharedPref.b.aTX().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void Fx(int i) {
        if (this.lQD instanceof a.c) {
            ((a.c) this.lQD).lPU.setIconFade(i);
        }
    }

    public void vn(boolean z) {
        this.lQF.eJ(z);
        if (!z && (this.lQD instanceof a.c)) {
            ((a.c) this.lQD).lPU.bez();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.lQD.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.lQD.mRootView != null && this.lQD.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.lQD.mRootView);
        }
        this.lQF.onDestroy();
    }

    public void dmr() {
        if (this.lQD instanceof a.b) {
            TiebaStatic.log("c13619");
            dmv();
        }
        vn(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
            aVar.setAutoNight(false);
            aVar.kC(R.string.prompt);
            aVar.vO(this.dIF.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.dIF).aST();
            return;
        }
        a(this.dIF, this.lQH, this.lHN);
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
                    com.baidu.adp.lib.c.a.kq().getAddress(false);
                    if (forumWriteData != null) {
                        str4 = forumWriteData.forumId;
                        str2 = forumWriteData.forumName;
                        str3 = forumWriteData.specialForumType;
                    } else {
                        str2 = null;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dh("obj_locate", str).ag("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.dIF.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dms() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        vn(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.lHN == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.lHN.forumId;
            String str7 = this.lHN.forumName;
            postPrefixData = this.lHN.prefixData;
            antiData = this.lHN.antiData;
            int i3 = this.lHN.forumLevel;
            String str8 = this.lHN.avatar;
            int i4 = this.lHN.privateThread;
            String str9 = this.lHN.firstDir;
            str = this.lHN.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dh("obj_locate", this.lQH).ag("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.dIF.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.lHN != null ? this.lHN.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.lHN != null ? this.lHN.frsTabInfo : null);
        if (!StringUtils.isNull(this.lQG)) {
            writeActivityConfig.setTitle(this.lQG, true);
        }
        if (!a(this.dIF.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void dmt() {
        vn(false);
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dh("obj_locate", this.lQH).ag("obj_type", 2));
        if (this.lHN == null) {
            this.lHN = new ForumWriteData("0", null, null, null);
        }
        this.lHN.mFrom = this.mFrom;
        this.lHN.writeCallFrom = this.writeCallFrom;
        j.b(this.dIF, "", this.lHN);
    }

    public void Oi(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        vn(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.lHN == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.lHN.forumId;
            String str8 = this.lHN.forumName;
            postPrefixData = this.lHN.prefixData;
            antiData = this.lHN.antiData;
            int i3 = this.lHN.forumLevel;
            String str9 = this.lHN.avatar;
            int i4 = this.lHN.privateThread;
            String str10 = this.lHN.firstDir;
            str2 = this.lHN.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dh("obj_locate", this.lQH).ag("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.dIF.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.lHN != null ? this.lHN.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.lHN != null ? this.lHN.frsTabInfo : null);
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

    public void dmu() {
        if (this.lQD != null) {
            this.lQD.dme();
        }
    }

    public void a(h.a aVar) {
        this.lri = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmv() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("home_publish_ala_has_showed", false);
        if (this.lQD instanceof a.b) {
            ((a.b) this.lQD).vk(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("home_publish_ala_has_showed", true);
    }
}
