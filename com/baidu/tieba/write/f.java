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
    private TbPageContext cVg;
    private ForumWriteData kCH;
    private a kLW;
    private boolean kLX;
    private g kLY;
    private String kLZ;
    private String kMa;
    private g.a kMb;
    private g.a kmz;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.kLX = false;
        this.mSkinType = 3;
        this.kLZ = "";
        this.mFrom = "write";
        this.kMa = "0";
        this.kMb = new g.a() { // from class: com.baidu.tieba.write.f.1
            @Override // com.baidu.tieba.write.g.a
            public void CO(int i2) {
                if (i2 == 1) {
                    f.this.kLX = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.kLY instanceof d)) {
                        if (f.this.BH == null) {
                            f.this.BH = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        f.this.BH.aRq();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 2) {
                    if (f.this.BH != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.kLY instanceof d)) {
                        f.this.BH.aRr();
                    }
                } else if (i2 == 4) {
                    f.this.kLX = false;
                    if (f.this.kLW.mRootView.getParent() == f.this.mParentView && f.this.mParentView != null && f.this.kLW.mRootView != null && f.this.mParentView.indexOfChild(f.this.kLW.mRootView) > 0) {
                        f.this.mParentView.removeView(f.this.kLW.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
                if (f.this.kmz != null) {
                    f.this.kmz.CO(i2);
                }
            }
        };
        this.cVg = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.C0630a c0630a = new a.C0630a(this.cVg, this);
            this.kLW = c0630a;
            this.kLY = new d(tbPageContext.getPageActivity(), c0630a);
        } else {
            a.b bVar = new a.b(this.cVg, this);
            this.kLW = bVar;
            this.kLY = new e(tbPageContext.getPageActivity(), bVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.kLY.b(this.kMb);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void KL(String str) {
        if (str == null) {
            str = "";
        }
        this.kLZ = str;
    }

    public String bKr() {
        return this.kLZ;
    }

    public void a(ForumWriteData forumWriteData) {
        this.kCH = forumWriteData;
    }

    public void KM(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.kMa = str;
    }

    public boolean isShowing() {
        return this.kLX;
    }

    public void Ec(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.kLW.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bh(this.mParentView).attachView(this.mParentView, this.kLW.mRootView, z);
            }
            this.kLY.g(view, view2);
            this.kLY.show();
            TiebaStatic.log(new an("c12052").cy("obj_locate", this.kMa));
            if (j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.cVg.getContext(), string).aEF();
                    com.baidu.tbadk.core.sharedPref.b.aFB().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void Ed(int i) {
        if (this.kLW instanceof a.b) {
            ((a.b) this.kLW).kLo.setIconFade(i);
        }
    }

    public void tI(boolean z) {
        this.kLY.dt(z);
        if (!z && (this.kLW instanceof a.b)) {
            ((a.b) this.kLW).kLo.aPU();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.kLW.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.kLW.mRootView != null && this.kLW.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.kLW.mRootView);
        }
        this.kLY.onDestroy();
    }

    public void cUl() {
        tI(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVg.getPageActivity());
            aVar.setAutoNight(false);
            aVar.jV(R.string.prompt);
            aVar.sS(this.cVg.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.cVg).aEA();
            return;
        }
        a(this.cVg, this.kMa, this.kCH);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(f.this.cVg.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            aVar.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void cUm() {
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
        if (this.kCH == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.kCH.forumId;
            String str7 = this.kCH.forumName;
            postPrefixData = this.kCH.prefixData;
            antiData = this.kCH.antiData;
            int i3 = this.kCH.forumLevel;
            String str8 = this.kCH.avatar;
            int i4 = this.kCH.privateThread;
            String str9 = this.kCH.firstDir;
            str = this.kCH.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cy("obj_locate", this.kMa).X("obj_type", 3));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            com.baidu.tbadk.data.h aNQ = com.baidu.tbadk.data.h.aNQ();
            if (aNQ != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, aNQ));
                return;
            }
            return;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cVg.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.kCH != null ? this.kCH.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.kLZ)) {
            writeActivityConfig.setTitle(this.kLZ, true);
        }
        if (!a(this.cVg.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void cUn() {
        com.baidu.tbadk.data.h aNR;
        tI(false);
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cy("obj_locate", this.kMa).X("obj_type", 2));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            if (PluginCheckUtil.vM("com.baidu.tieba.pluginPublisher") && (aNR = com.baidu.tbadk.data.h.aNR()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921429, aNR));
                return;
            }
            return;
        }
        if (this.kCH == null) {
            this.kCH = new ForumWriteData("0", null, null, null);
        }
        this.kCH.mFrom = this.mFrom;
        this.kCH.writeCallFrom = this.writeCallFrom;
        i.b(this.cVg, "", this.kCH);
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
        if (this.kCH == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.kCH.forumId;
            String str8 = this.kCH.forumName;
            postPrefixData = this.kCH.prefixData;
            antiData = this.kCH.antiData;
            int i3 = this.kCH.forumLevel;
            String str9 = this.kCH.avatar;
            int i4 = this.kCH.privateThread;
            String str10 = this.kCH.firstDir;
            str2 = this.kCH.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cy("obj_locate", this.kMa).X("obj_type", 1));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            com.baidu.tbadk.data.h aNP = com.baidu.tbadk.data.h.aNP();
            if (aNP != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, aNP));
                return;
            }
            return;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cVg.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.kCH != null ? this.kCH.defaultZone : -1);
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

    public void cUo() {
        if (this.kLW != null) {
            this.kLW.cTY();
        }
    }

    public void a(g.a aVar) {
        this.kmz = aVar;
    }
}
