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
    private com.baidu.tbadk.n.a.a Bk;
    private int bgColor;
    private TbPageContext cQU;
    private a kHK;
    private boolean kHL;
    private g kHM;
    private String kHN;
    private String kHO;
    private g.a kHP;
    private ForumWriteData kyf;
    private String mFrom;
    private ViewGroup mParentView;
    private int mSkinType;
    private String writeCallFrom;

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str) {
        this(tbPageContext, viewGroup, str, 1);
    }

    public f(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i) {
        this.kHL = false;
        this.mSkinType = 3;
        this.kHN = "";
        this.mFrom = "write";
        this.kHO = "0";
        this.kHP = new g.a() { // from class: com.baidu.tieba.write.f.1
            @Override // com.baidu.tieba.write.g.a
            public void DT(int i2) {
                if (i2 == 1) {
                    f.this.kHL = true;
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.kHM instanceof d)) {
                        if (f.this.Bk == null) {
                            f.this.Bk = new com.baidu.tbadk.n.a.a("anim_switch_sendthread_maintab");
                        }
                        f.this.Bk.aOH();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                } else if (i2 == 2) {
                    if (f.this.Bk != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_sendthread_maintab") && (f.this.kHM instanceof d)) {
                        f.this.Bk.aOI();
                    }
                } else if (i2 == 4) {
                    f.this.kHL = false;
                    if (f.this.kHK.mRootView.getParent() == f.this.mParentView && f.this.mParentView != null && f.this.kHK.mRootView != null && f.this.mParentView.indexOfChild(f.this.kHK.mRootView) > 0) {
                        f.this.mParentView.removeView(f.this.kHK.mRootView);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 7));
                }
            }
        };
        this.cQU = tbPageContext;
        this.mParentView = viewGroup;
        this.mFrom = str;
        if (i == 2) {
            a.C0617a c0617a = new a.C0617a(this.cQU, this);
            this.kHK = c0617a;
            this.kHM = new d(tbPageContext.getPageActivity(), c0617a);
        } else {
            a.b bVar = new a.b(this.cQU, this);
            this.kHK = bVar;
            this.kHM = new e(tbPageContext.getPageActivity(), bVar);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.kHM.a(this.kHP);
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void Ko(String str) {
        if (str == null) {
            str = "";
        }
        this.kHN = str;
    }

    public String bHN() {
        return this.kHN;
    }

    public void a(ForumWriteData forumWriteData) {
        this.kyf = forumWriteData;
    }

    public void Kp(String str) {
        if ("3".equals(str)) {
            this.writeCallFrom = "1";
        } else {
            this.writeCallFrom = str;
        }
        this.kHO = str;
    }

    public boolean isShowing() {
        return this.kHL;
    }

    public void DR(int i) {
        this.bgColor = i;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void a(boolean z, View view, View view2) {
        if (this.mParentView != null) {
            if (this.kHK.mRootView.getParent() == null) {
                com.baidu.tbadk.k.e.bd(this.mParentView).attachView(this.mParentView, this.kHK.mRootView, z);
            }
            this.kHM.g(view, view2);
            this.kHM.show();
            TiebaStatic.log(new an("c12052").cp("obj_locate", this.kHO));
            if (j.isMobileNet()) {
                String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP, "");
                if (!aq.isEmpty(string)) {
                    BdToast.b(this.cQU.getContext(), string).aCb();
                    com.baidu.tbadk.core.sharedPref.b.aCY().remove(SharedPrefConfig.KEY_BAIDU_SIM_CARD_WRITTING_TIP);
                }
            }
        }
    }

    public void DS(int i) {
        if (this.kHK instanceof a.b) {
            ((a.b) this.kHK).kHc.setIconFade(i);
        }
    }

    public void ts(boolean z) {
        this.kHM.dh(z);
        if (!z && (this.kHK instanceof a.b)) {
            ((a.b) this.kHK).kHc.aNh();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            this.kHK.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        if (this.kHK.mRootView != null && this.kHK.mRootView.getParent() == this.mParentView) {
            this.mParentView.removeView(this.kHK.mRootView);
        }
        this.kHM.onDestroy();
    }

    public void cRS() {
        ts(false);
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cQU.getPageActivity());
            aVar.setAutoNight(false);
            aVar.jE(R.string.prompt);
            aVar.sz(this.cQU.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.write.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.cQU).aBW();
            return;
        }
        a(this.cQU, this.kHO, this.kyf);
    }

    public void a(TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (tbPageContext != null) {
            com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
            aVar.clearRequestPermissionList();
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            aVar.a(new a.InterfaceC0366a() { // from class: com.baidu.tieba.write.f.3
                @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0366a
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(f.this.cQU.getPageActivity(), str2, str4, TbadkCoreApplication.getCurrentAccount(), str3)));
                }
            });
            aVar.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public void cRT() {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        ts(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.kyf == null) {
            str = "";
            str2 = "";
            i = 0;
            str3 = null;
            i2 = -1;
            str4 = null;
            str5 = "0";
        } else {
            String str6 = this.kyf.forumId;
            String str7 = this.kyf.forumName;
            postPrefixData = this.kyf.prefixData;
            antiData = this.kyf.antiData;
            int i3 = this.kyf.forumLevel;
            String str8 = this.kyf.avatar;
            int i4 = this.kyf.privateThread;
            String str9 = this.kyf.firstDir;
            str = this.kyf.secondDir;
            str2 = str9;
            i = i4;
            str3 = str8;
            i2 = i3;
            str4 = str7;
            str5 = str6;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cp("obj_locate", this.kHO).Z("obj_type", 3));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            com.baidu.tbadk.data.h aLb = com.baidu.tbadk.data.h.aLb();
            if (aLb != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, aLb));
                return;
            }
            return;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cQU.getPageActivity(), 0, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str3);
        writeActivityConfig.setAlbumThread(1);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setProfessionZone(this.kyf != null ? this.kyf.defaultZone : -1);
        writeActivityConfig.setForumDir(str2, str);
        if (!StringUtils.isNull(this.kHN)) {
            writeActivityConfig.setTitle(this.kHN, true);
        }
        if (!a(this.cQU.getPageActivity(), writeActivityConfig)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public void cRU() {
        com.baidu.tbadk.data.h aLc;
        ts(false);
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cp("obj_locate", this.kHO).Z("obj_type", 2));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            if (PluginCheckUtil.vn("com.baidu.tieba.pluginPublisher") && (aLc = com.baidu.tbadk.data.h.aLc()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921429, aLc));
                return;
            }
            return;
        }
        if (this.kyf == null) {
            this.kyf = new ForumWriteData("0", null, null, null);
        }
        this.kyf.mFrom = this.mFrom;
        this.kyf.writeCallFrom = this.writeCallFrom;
        i.b(this.cQU, "", this.kyf);
    }

    public void Kq(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        ts(false);
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.kyf == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.kyf.forumId;
            String str8 = this.kyf.forumName;
            postPrefixData = this.kyf.prefixData;
            antiData = this.kyf.antiData;
            int i3 = this.kyf.forumLevel;
            String str9 = this.kyf.avatar;
            int i4 = this.kyf.privateThread;
            String str10 = this.kyf.firstDir;
            str2 = this.kyf.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        TiebaStatic.log(new an(CommonStatisticKey.KEY_ENTRANCE_CLICKED).cp("obj_locate", this.kHO).Z("obj_type", 1));
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            com.baidu.tbadk.data.h aLa = com.baidu.tbadk.data.h.aLa();
            if (aLa != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, aLa));
                return;
            }
            return;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cQU.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.writeCallFrom);
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.kyf != null ? this.kyf.defaultZone : -1);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    private static boolean a(Activity activity, final WriteActivityConfig writeActivityConfig) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.clearRequestPermissionList();
        aVar.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0366a() { // from class: com.baidu.tieba.write.f.4
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0366a
            public void onPermissionsGranted() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, WriteActivityConfig.this));
            }
        });
        return aVar.startRequestPermission(activity);
    }

    public void cRV() {
        if (this.kHK != null) {
            this.kHK.cRF();
        }
    }
}
