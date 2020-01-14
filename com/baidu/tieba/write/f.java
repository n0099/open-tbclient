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
    private com.baidu.tbadk.n.a.a Bp;
    private int bgColor;
    private TbPageContext cRe;
    private ForumWriteData kBM;
    private a kLq;
    private boolean kLr;
    private g kLs;
    private String kLt;
    private String kLu;
    private g.a kLv;
    private g.a klD;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.kLr = false;
        this.mSkinType = 3;
        this.kLt = "";
        this.mFrom = "write";
        this.kLu = "0";
        this.kLv = new g.a() { // from class: com.baidu.tieba.write.f.1
            @Override // com.baidu.tieba.write.g.a
            public void CI(int i2) {
                if (i2 == 1) {
                    f.this.kLr = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.kLs instanceof d)) {
                        if (f.this.Bp == null) {
                            f.this.Bp = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        f.this.Bp.aPa();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 2) {
                    if (f.this.Bp != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.kLs instanceof d)) {
                        f.this.Bp.aPb();
                    }
                } else if (i2 == 4) {
                    f.this.kLr = false;
                    if (f.this.kLq.mRootView.getParent() == f.this.mParentView && f.this.mParentView != null && f.this.kLq.mRootView != null && f.this.mParentView.indexOfChild(f.this.kLq.mRootView) > 0) {
                        f.this.mParentView.removeView(f.this.kLq.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                }
                if (f.this.klD != null) {
                    f.this.klD.CI(i2);
                }
            }
        };
        this.cRe = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.C0622a c0622a = new a.C0622a(this.cRe, this);
            this.kLq = c0622a;
            this.kLs = new d(tbPageContext.getPageActivity(), c0622a);
        } else {
            a.b bVar = new a.b(this.cRe, this);
            this.kLq = bVar;
            this.kLs = new e(tbPageContext.getPageActivity(), bVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.kLs.b(this.kLv);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void Ky(String str) {
        if (str == null) {
            str = "";
        }
        this.kLt = str;
    }

    public String bIP() {
        return this.kLt;
    }

    public void a(ForumWriteData forumWriteData) {
        this.kBM = forumWriteData;
    }

    public void Kz(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.kLu = str;
    }

    public boolean isShowing() {
        return this.kLr;
    }

    public void DX(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.kLq.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bh(this.mParentView).attachView(this.mParentView, this.kLq.mRootView, z);
            }
            this.kLs.g(view, view2);
            this.kLs.show();
            TiebaStatic.log(new an("c12052").cp("obj_locate", this.kLu));
            if (j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.cRe.getContext(), string).aCu();
                    com.baidu.tbadk.core.sharedPref.b.aDr().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void DY(int i) {
        if (this.kLq instanceof a.b) {
            ((a.b) this.kLq).kKI.setIconFade(i);
        }
    }

    public void tE(boolean z) {
        this.kLs.dm(z);
        if (!z && (this.kLq instanceof a.b)) {
            ((a.b) this.kLq).kKI.aNA();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.kLq.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.kLq.mRootView != null && this.kLq.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.kLq.mRootView);
        }
        this.kLs.onDestroy();
    }

    public void cSX() {
        tE(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
            aVar.setAutoNight(false);
            aVar.jE(R.string.prompt);
            aVar.sC(this.cRe.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.cRe).aCp();
            return;
        }
        a(this.cRe, this.kLu, this.kBM);
    }

    public void a(TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (tbPageContext != null) {
            com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
            aVar.clearRequestPermissionList();
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            aVar.a(new a.InterfaceC0368a() { // from class: com.baidu.tieba.write.f.3
                @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0368a
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
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cp("obj_locate", str).Z("obj_type", 4));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(f.this.cRe.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            aVar.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void cSY() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        tE(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.kBM == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.kBM.forumId;
            String str7 = this.kBM.forumName;
            postPrefixData = this.kBM.prefixData;
            antiData = this.kBM.antiData;
            int i3 = this.kBM.forumLevel;
            String str8 = this.kBM.avatar;
            int i4 = this.kBM.privateThread;
            String str9 = this.kBM.firstDir;
            str = this.kBM.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cp("obj_locate", this.kLu).Z("obj_type", 3));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            com.baidu.tbadk.data.h aLu = com.baidu.tbadk.data.h.aLu();
            if (aLu != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, aLu));
                return;
            }
            return;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cRe.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.kBM != null ? this.kBM.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.kLt)) {
            writeActivityConfig.setTitle(this.kLt, true);
        }
        if (!a(this.cRe.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void cSZ() {
        com.baidu.tbadk.data.h aLv;
        tE(false);
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cp("obj_locate", this.kLu).Z("obj_type", 2));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            if (PluginCheckUtil.vs("com.baidu.tieba.pluginPublisher") && (aLv = com.baidu.tbadk.data.h.aLv()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921429, aLv));
                return;
            }
            return;
        }
        if (this.kBM == null) {
            this.kBM = new ForumWriteData("0", null, null, null);
        }
        this.kBM.mFrom = this.mFrom;
        this.kBM.writeCallFrom = this.writeCallFrom;
        i.b(this.cRe, "", this.kBM);
    }

    public void KA(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        tE(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.kBM == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.kBM.forumId;
            String str8 = this.kBM.forumName;
            postPrefixData = this.kBM.prefixData;
            antiData = this.kBM.antiData;
            int i3 = this.kBM.forumLevel;
            String str9 = this.kBM.avatar;
            int i4 = this.kBM.privateThread;
            String str10 = this.kBM.firstDir;
            str2 = this.kBM.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cp("obj_locate", this.kLu).Z("obj_type", 1));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            com.baidu.tbadk.data.h aLt = com.baidu.tbadk.data.h.aLt();
            if (aLt != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, aLt));
                return;
            }
            return;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cRe.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.kBM != null ? this.kBM.defaultZone : -1);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    private static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.clearRequestPermissionList();
        aVar.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0368a() { // from class: com.baidu.tieba.write.f.4
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0368a
            public void onPermissionsGranted() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, WriteActivityConfig.this));
            }
        });
        return aVar.startRequestPermission(activity);
    }

    public void cTa() {
        if (this.kLq != null) {
            this.kLq.cSK();
        }
    }

    public void a(g.a aVar) {
        this.klD = aVar;
    }
}
