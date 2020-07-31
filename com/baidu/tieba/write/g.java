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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
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
    private com.baidu.tbadk.n.a.a VQ;
    private int bgColor;
    private TbPageContext dVN;
    private ItemInfo hNO;
    private ForumWriteData hRF;
    private h.a lTp;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private a mub;
    private boolean muc;
    private h mud;
    private String mue;
    private String muf;
    private h.a mug;
    private String writeCallFrom;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public g(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.muc = false;
        this.mSkinType = 3;
        this.mue = "";
        this.mFrom = "write";
        this.muf = "0";
        this.mug = new h.a() { // from class: com.baidu.tieba.write.g.1
            @Override // com.baidu.tieba.write.h.a
            public void FL(int i2) {
                if (i2 == 1) {
                    g.this.muc = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.mud instanceof d)) {
                        if (g.this.VQ == null) {
                            g.this.VQ = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        g.this.VQ.blH();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i2 == 2) {
                    if (g.this.VQ != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (g.this.mud instanceof d)) {
                        g.this.VQ.blI();
                    }
                    g.this.dun();
                } else if (i2 == 4) {
                    g.this.muc = false;
                    if (g.this.mub.mRootView.getParent() == g.this.mParentView && g.this.mParentView != null && g.this.mub.mRootView != null && g.this.mParentView.indexOfChild(g.this.mub.mRootView) > 0) {
                        g.this.mParentView.removeView(g.this.mub.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
                if (g.this.lTp != null) {
                    g.this.lTp.FL(i2);
                }
            }
        };
        this.dVN = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.b bVar = new a.b(this.dVN, this);
            this.mub = bVar;
            this.mud = new d(tbPageContext.getPageActivity(), bVar);
        } else if (i == 3) {
            a.C0773a c0773a = new a.C0773a(this.dVN, this);
            this.mub = c0773a;
            this.mud = new f(tbPageContext.getPageActivity(), c0773a);
        } else {
            a.c cVar = new a.c(this.dVN, this);
            this.mub = cVar;
            this.mud = new e(tbPageContext.getPageActivity(), cVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mud.b(this.mug);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void Pz(String str) {
        if (str == null) {
            str = "";
        }
        this.mue = str;
    }

    public String ciD() {
        return this.mue;
    }

    public void wk(boolean z) {
        if (this.mub instanceof a.c) {
            ((a.c) this.mub).wh(z);
        }
    }

    public void a(ForumWriteData forumWriteData) {
        this.hRF = forumWriteData;
    }

    public void b(ItemInfo itemInfo) {
        this.hNO = itemInfo;
    }

    public void PA(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.muf = str;
    }

    public boolean isShowing() {
        return this.muc;
    }

    public void GY(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.mub.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bq(this.mParentView).attachView(this.mParentView, this.mub.mRootView, z);
            }
            this.mud.d(view, view2);
            this.mud.show();
            TiebaStatic.log(new ap("c12052").dn("obj_locate", this.muf));
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!as.isEmpty(string)) {
                    BdToast.b(this.dVN.getContext(), string).aYR();
                    com.baidu.tbadk.core.sharedPref.b.aZP().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void GZ(int i) {
        if (this.mub instanceof a.c) {
            ((a.c) this.mub).mts.setIconFade(i);
        }
    }

    public void wl(boolean z) {
        this.mud.eX(z);
        if (!z && (this.mub instanceof a.c)) {
            ((a.c) this.mub).mts.bkq();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.mub.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.mub.mRootView != null && this.mub.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.mub.mRootView);
        }
        this.mud.onDestroy();
    }

    public void duj() {
        TiebaStatic.log(new ap(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dn("obj_locate", this.muf).ah("obj_type", 6));
        wl(false);
        UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(this.dVN.getPageActivity(), RequestResponseCode.REQUEST_WRITE_NEW);
        if (this.hRF != null) {
            universityEvaluationConfig.setWriteData(this.hRF);
        }
        if (this.hNO != null) {
            universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(this.hNO));
            universityEvaluationConfig.setItemIsSchool(this.hNO.is_school.intValue() == 1);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
        if (this.hRF != null && this.hNO != null) {
            TiebaStatic.log(new ap("c13722").dn("fid", this.hRF.forumId).dn("fname", this.hRF.forumName).ah("obj_param1", this.hNO.id.intValue()));
        }
    }

    public void PB(String str) {
        TiebaStatic.log(new ap(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dn("obj_locate", this.muf).ah("obj_type", 5));
        if (this.hRF != null && this.hRF.antiData != null) {
            int pollLevel = this.hRF.antiData.getPollLevel();
            if (this.hRF.forumLevel < pollLevel) {
                l.showToast(this.dVN.getPageActivity(), String.format(this.dVN.getString(R.string.vote_level_tip), Integer.valueOf(pollLevel)));
                return;
            }
            wl(false);
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.dVN.getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
            writeVoteActivityConfig.setExtraTitle(str);
            writeVoteActivityConfig.setExtraData(this.hRF);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
            TiebaStatic.log(new ap("c13800").ah("obj_source", 1));
        }
    }

    public void duk() {
        if (this.mub instanceof a.b) {
            TiebaStatic.log("c13619");
            dun();
        }
        wl(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVN.getPageActivity());
            aVar.setAutoNight(false);
            aVar.lm(R.string.prompt);
            aVar.xl(this.dVN.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.dVN).aYL();
            return;
        }
        a(this.dVN, this.muf, this.hRF);
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
                    TiebaStatic.log(new ap(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dn("obj_locate", str).ah("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(g.this.dVN.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void dul() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        wl(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hRF == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.hRF.forumId;
            String str7 = this.hRF.forumName;
            postPrefixData = this.hRF.prefixData;
            antiData = this.hRF.antiData;
            int i3 = this.hRF.forumLevel;
            String str8 = this.hRF.avatar;
            int i4 = this.hRF.privateThread;
            String str9 = this.hRF.firstDir;
            str = this.hRF.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new ap(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dn("obj_locate", this.muf).ah("obj_type", 3));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.dVN.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(0);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str2, str);
        writeActivityConfig.setProfessionZone(this.hRF != null ? this.hRF.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.hRF != null ? this.hRF.frsTabInfo : null);
        if (!StringUtils.isNull(this.mue)) {
            writeActivityConfig.setTitle(this.mue, true);
        }
        if (!a(this.dVN.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void dum() {
        wl(false);
        TiebaStatic.log(new ap(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dn("obj_locate", this.muf).ah("obj_type", 2));
        if (this.hRF == null) {
            this.hRF = new ForumWriteData("0", null, null, null);
        }
        this.hRF.mFrom = this.mFrom;
        this.hRF.writeCallFrom = this.writeCallFrom;
        j.b(this.dVN, "", this.hRF);
    }

    public void PC(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        wl(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hRF == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hRF.forumId;
            String str8 = this.hRF.forumName;
            postPrefixData = this.hRF.prefixData;
            antiData = this.hRF.antiData;
            int i3 = this.hRF.forumLevel;
            String str9 = this.hRF.avatar;
            int i4 = this.hRF.privateThread;
            String str10 = this.hRF.firstDir;
            str2 = this.hRF.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new ap(CommonStatisticKey.KEY_ENTRANCE_CLICKED).dn("obj_locate", this.muf).ah("obj_type", 1));
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.dVN.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.hRF != null ? this.hRF.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.hRF != null ? this.hRF.frsTabInfo : null);
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

    public void bnY() {
        if (this.mub != null) {
            this.mub.dtW();
        }
    }

    public void a(h.a aVar) {
        this.lTp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dun() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("home_publish_ala_has_showed", false);
        if (this.mub instanceof a.b) {
            ((a.b) this.mub).wg(z ? false : true);
        }
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("home_publish_ala_has_showed", true);
    }
}
