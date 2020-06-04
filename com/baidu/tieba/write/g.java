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
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.write.a;
import com.baidu.tieba.write.h;
import com.baidu.webkit.sdk.PermissionRequest;
import tbclient.ItemInfo;
/* loaded from: classes.dex */
public class g {
    private com.baidu.tbadk.n.a.a Vt;
    private int bgColor;
    private TbPageContext dIF;
    private ForumWriteData hyK;
    private a lRO;
    private boolean lRP;
    private h lRQ;
    private String lRR;
    private String lRS;
    private h.a lRT;
    private ItemInfo lRU;
    private h.a lsr;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.lRP = false;
        this.mSkinType = 3;
        this.lRR = "";
        this.mFrom = "write";
        this.lRS = "0";
        this.lRT = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void En(int i2) {
                if (i2 == 1) {
                    g.this.lRP = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.lRQ instanceof d)) {
                        if (g.this.Vt == null) {
                            g.this.Vt = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.Vt.bfQ();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 2) {
                    if (g.this.Vt != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.lRQ instanceof d)) {
                        g.this.Vt.bfR();
                    }
                    g.this.dmL();
                } else if (i2 == 4) {
                    g.this.lRP = false;
                    if (g.this.lRO.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.lRO.mRootView != null && g.this.mParentView.indexOfChild(g.this.lRO.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.lRO.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
                if (g.this.lsr != null) {
                    g.this.lsr.En(i2);
                }
            }
        };
        this.dIF = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.b bVar = new a.b(this.dIF, this);
            this.lRO = bVar;
            this.lRQ = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0747a c0747a = new a.C0747a(this.dIF, this);
            this.lRO = c0747a;
            this.lRQ = new f(tbPageContext.getPageActivity(), c0747a);
        } else {
            a.c cVar = new a.c(this.dIF, this);
            this.lRO = cVar;
            this.lRQ = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lRQ.b(this.lRT);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void Oh(String str) {
        if (str == null) {
            str = "";
        }
        this.lRR = str;
    }

    public String cbL() {
        return this.lRR;
    }

    public void vo(boolean z) {
        if (this.lRO instanceof a.c) {
            ((a.c) this.lRO).vl(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.hyK = forumWriteData;
    }

    public void a(ItemInfo itemInfo) {
        this.lRU = itemInfo;
    }

    public void Oi(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.lRS = str;
    }

    public boolean isShowing() {
        return this.lRP;
    }

    public void Fy(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.lRO.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bj(this.mParentView).attachView(this.mParentView, this.lRO.mRootView, z);
            }
            this.lRQ.c(view, view2);
            this.lRQ.show();
            TiebaStatic.log(new an("c12052").dh("obj_locate", this.lRS));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.dIF.getContext(), string).aSY();
                    com.baidu.tbadk.core.sharedPref.b.aTX().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void Fz(int i) {
        if (this.lRO instanceof a.c) {
            ((a.c) this.lRO).lRf.setIconFade(i);
        }
    }

    public void vp(boolean z) {
        this.lRQ.eJ(z);
        if (!z && (this.lRO instanceof a.c)) {
            ((a.c) this.lRO).lRf.beA();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.lRO.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.lRO.mRootView != null && this.lRO.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.lRO.mRootView);
        }
        this.lRQ.onDestroy();
    }

    public void dmG() {
        vp(false);
        UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(this.dIF.getPageActivity(), RequestResponseCode.REQUEST_WRITE_NEW);
        if (this.hyK != null) {
            universityEvaluationConfig.setWriteData(this.hyK);
        }
        if (this.lRU != null) {
            universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(this.lRU));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921459, universityEvaluationConfig));
        if (this.hyK != null && this.lRU != null) {
            TiebaStatic.log(new an("c13722").dh("fid", this.hyK.forumId).dh("fname", this.hyK.forumName).ag("obj_param1", this.lRU.id.intValue()));
        }
    }

    public void dmH() {
        if (this.lRO instanceof a.b) {
            TiebaStatic.log("c13619");
            dmL();
        }
        vp(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
            aVar.setAutoNight(false);
            aVar.kE(R.string.prompt);
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
        a(this.dIF, this.lRS, this.hyK);
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

    public void dmI() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        vp(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hyK == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.hyK.forumId;
            String str7 = this.hyK.forumName;
            postPrefixData = this.hyK.prefixData;
            antiData = this.hyK.antiData;
            int i3 = this.hyK.forumLevel;
            String str8 = this.hyK.avatar;
            int i4 = this.hyK.privateThread;
            String str9 = this.hyK.firstDir;
            str = this.hyK.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dh("obj_locate", this.lRS).ag("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.dIF.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.hyK != null ? this.hyK.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.hyK != null ? this.hyK.frsTabInfo : null);
        if (!StringUtils.isNull(this.lRR)) {
            writeActivityConfig.setTitle(this.lRR, true);
        }
        if (!a(this.dIF.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void dmJ() {
        vp(false);
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dh("obj_locate", this.lRS).ag("obj_type", 2));
        if (this.hyK == null) {
            this.hyK = new ForumWriteData("0", null, null, null);
        }
        this.hyK.mFrom = this.mFrom;
        this.hyK.writeCallFrom = this.writeCallFrom;
        j.b(this.dIF, "", this.hyK);
    }

    public void Oj(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        vp(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hyK == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hyK.forumId;
            String str8 = this.hyK.forumName;
            postPrefixData = this.hyK.prefixData;
            antiData = this.hyK.antiData;
            int i3 = this.hyK.forumLevel;
            String str9 = this.hyK.avatar;
            int i4 = this.hyK.privateThread;
            String str10 = this.hyK.firstDir;
            str2 = this.hyK.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dh("obj_locate", this.lRS).ag("obj_type", 1));
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
        writeActivityConfig.setProfessionZone(this.hyK != null ? this.hyK.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.hyK != null ? this.hyK.frsTabInfo : null);
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

    public void dmK() {
        if (this.lRO != null) {
            this.lRO.dmt();
        }
    }

    public void a(h.a aVar) {
        this.lsr = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmL() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("home_publish_ala_has_showed", false);
        if (this.lRO instanceof a.b) {
            ((a.b) this.lRO).vk(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("home_publish_ala_has_showed", true);
    }
}
