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
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.plugins.PluginCheckUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.a;
import com.baidu.tieba.write.g;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes.dex */
public class f {
    private com.baidu.tbadk.n.a.a BH;
    private int bgColor;
    private TbPageContext cVh;
    private ForumWriteData kCJ;
    private a kLY;
    private boolean kLZ;
    private g kMa;
    private String kMb;
    private String kMc;
    private g.a kMd;
    private g.a kmB;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.kLZ = false;
        this.mSkinType = 3;
        this.kMb = "";
        this.mFrom = "write";
        this.kMc = "0";
        this.kMd = new g.a() { // from class: com.baidu.tieba.write.f.1
            @Override // com.baidu.tieba.write.g.a
            public void CO(int i2) {
                if (i2 == 1) {
                    f.this.kLZ = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.kMa instanceof d)) {
                        if (f.this.BH == null) {
                            f.this.BH = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        f.this.BH.aRs();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 2) {
                    if (f.this.BH != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.kMa instanceof d)) {
                        f.this.BH.aRt();
                    }
                } else if (i2 == 4) {
                    f.this.kLZ = false;
                    if (f.this.kLY.mRootView.getParent() == f.this.mParentView && f.this.mParentView != null && f.this.kLY.mRootView != null && f.this.mParentView.indexOfChild(f.this.kLY.mRootView) > 0) {
                        f.this.mParentView.removeView(f.this.kLY.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
                if (f.this.kmB != null) {
                    f.this.kmB.CO(i2);
                }
            }
        };
        this.cVh = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.C0630a c0630a = new a.C0630a(this.cVh, this);
            this.kLY = c0630a;
            this.kMa = new d(tbPageContext.getPageActivity(), c0630a);
        } else {
            a.b bVar = new a.b(this.cVh, this);
            this.kLY = bVar;
            this.kMa = new e(tbPageContext.getPageActivity(), bVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.kMa.b(this.kMd);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void KL(String str) {
        if (str == null) {
            str = "";
        }
        this.kMb = str;
    }

    public String bKt() {
        return this.kMb;
    }

    public void a(ForumWriteData forumWriteData) {
        this.kCJ = forumWriteData;
    }

    public void KM(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.kMc = str;
    }

    public boolean isShowing() {
        return this.kLZ;
    }

    public void Ec(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.kLY.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bh(this.mParentView).attachView(this.mParentView, this.kLY.mRootView, z);
            }
            this.kMa.g(view, view2);
            this.kMa.show();
            TiebaStatic.log(new an("c12052").cy("obj_locate", this.kMc));
            if (j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.cVh.getContext(), string).aEH();
                    com.baidu.tbadk.core.sharedPref.b.aFD().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void Ed(int i) {
        if (this.kLY instanceof a.b) {
            ((a.b) this.kLY).kLq.setIconFade(i);
        }
    }

    public void tI(boolean z) {
        this.kMa.dt(z);
        if (!z && (this.kLY instanceof a.b)) {
            ((a.b) this.kLY).kLq.aPW();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.kLY.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.kLY.mRootView != null && this.kLY.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.kLY.mRootView);
        }
        this.kMa.onDestroy();
    }

    public void cUn() {
        tI(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVh.getPageActivity());
            aVar.setAutoNight(false);
            aVar.jV(R.string.prompt);
            aVar.sS(this.cVh.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.cVh).aEC();
            return;
        }
        a(this.cVh, this.kMc, this.kCJ);
    }

    public void a(TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (tbPageContext != null) {
            com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
            aVar.clearRequestPermissionList();
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            aVar.a(new a.InterfaceC0378a() { // from class: com.baidu.tieba.write.f.3
                @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0378a
                public void onPermissionsGranted() {
                    String str2;
                    String str3 = null;
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    String str4 = "0";
                    com.baidu.adp.lib.c.a.fK().getAddress(false);
                    if (forumWriteData != null) {
                        str4 = forumWriteData.forumId;
                        str2 = forumWriteData.forumName;
                        str3 = forumWriteData.specialForumType;
                    } else {
                        str2 = null;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cy("obj_locate", str).X("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(f.this.cVh.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            aVar.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void cUo() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        tI(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.kCJ == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.kCJ.forumId;
            String str7 = this.kCJ.forumName;
            postPrefixData = this.kCJ.prefixData;
            antiData = this.kCJ.antiData;
            int i3 = this.kCJ.forumLevel;
            String str8 = this.kCJ.avatar;
            int i4 = this.kCJ.privateThread;
            String str9 = this.kCJ.firstDir;
            str = this.kCJ.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cy("obj_locate", this.kMc).X("obj_type", 3));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            com.baidu.tbadk.data.h aNS = com.baidu.tbadk.data.h.aNS();
            if (aNS != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, aNS));
                return;
            }
            return;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cVh.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.kCJ != null ? this.kCJ.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.kMb)) {
            writeActivityConfig.setTitle(this.kMb, true);
        }
        if (!a(this.cVh.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void cUp() {
        com.baidu.tbadk.data.h aNT;
        tI(false);
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cy("obj_locate", this.kMc).X("obj_type", 2));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            if (PluginCheckUtil.vM("com.baidu.tieba.pluginPublisher") && (aNT = com.baidu.tbadk.data.h.aNT()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921429, aNT));
                return;
            }
            return;
        }
        if (this.kCJ == null) {
            this.kCJ = new ForumWriteData("0", null, null, null);
        }
        this.kCJ.mFrom = this.mFrom;
        this.kCJ.writeCallFrom = this.writeCallFrom;
        i.b(this.cVh, "", this.kCJ);
    }

    public void KN(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        tI(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.kCJ == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.kCJ.forumId;
            String str8 = this.kCJ.forumName;
            postPrefixData = this.kCJ.prefixData;
            antiData = this.kCJ.antiData;
            int i3 = this.kCJ.forumLevel;
            String str9 = this.kCJ.avatar;
            int i4 = this.kCJ.privateThread;
            String str10 = this.kCJ.firstDir;
            str2 = this.kCJ.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cy("obj_locate", this.kMc).X("obj_type", 1));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            com.baidu.tbadk.data.h aNR = com.baidu.tbadk.data.h.aNR();
            if (aNR != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, aNR));
                return;
            }
            return;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cVh.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.kCJ != null ? this.kCJ.defaultZone : -1);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    private static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.clearRequestPermissionList();
        aVar.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0378a() { // from class: com.baidu.tieba.write.f.4
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0378a
            public void onPermissionsGranted() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, WriteActivityConfig.this));
            }
        });
        return aVar.startRequestPermission(activity);
    }

    public void cUq() {
        if (this.kLY != null) {
            this.kLY.cUa();
        }
    }

    public void a(g.a aVar) {
        this.kmB = aVar;
    }
}
