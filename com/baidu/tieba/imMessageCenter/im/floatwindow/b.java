package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.app.ActivityManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b btb;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a bte;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.f btf;
    private k btg;
    private boolean btc = false;
    private boolean isBackground = false;
    private boolean btd = false;
    private a bth = new a();
    private ArrayList<String> bti = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private i btj = new i(this);
    private h btk = new h(this);
    private e btl = new e(this);
    private f btm = new f(this);
    private g bto = new g(this);
    private n btp = new c(this);
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e btq = new d(this);

    public static synchronized b VP() {
        b bVar;
        synchronized (b.class) {
            if (btb == null) {
                btb = new b();
            }
            bVar = btb;
        }
        return bVar;
    }

    public boolean hJ(String str) {
        return this.bti.contains(str);
    }

    public void hK(String str) {
        if (!StringUtils.isNull(str) && !this.bti.contains(str)) {
            this.bti.add(str);
        }
    }

    public void hL(String str) {
        if (!StringUtils.isNull(str)) {
            this.bti.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.btk);
        MessageManager.getInstance().registerListener(this.btl);
        MessageManager.getInstance().registerListener(this.btj);
        MessageManager.getInstance().registerListener(this.btm);
        MessageManager.getInstance().registerListener(this.bto);
    }

    public void dt(boolean z) {
        if (!VQ()) {
            if (this.bth.VO()) {
                VS();
                if (!VU().We()) {
                    VU().a(this.handler, z);
                    return;
                }
                return;
            }
            du(false);
        }
    }

    private boolean VQ() {
        return TbadkCoreApplication.m411getInst().isMIUIRom() || !TbadkCoreApplication.m411getInst().isFloatingWindowOpened() || this.btc || !VR() || com.baidu.tbadk.coreExtra.messageCenter.c.wg().wj() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo();
    }

    private boolean VR() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) TbadkCoreApplication.m411getInst().getSystemService("activity")).getRunningTasks(5);
        if (runningTasks == null || runningTasks.size() <= 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
        if (runningTaskInfo == null) {
            return false;
        }
        String className = runningTaskInfo.topActivity.getClassName();
        return ("com.baidu.tieba.LogoActivity".equalsIgnoreCase(className) || "com.baidu.tieba.guide.NewUserGuideActivity".equalsIgnoreCase(className) || "com.baidu.tieba.topRec.TopRecActivity".equalsIgnoreCase(className) || "com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(className)) ? false : true;
    }

    public void hM(String str) {
        if (!StringUtils.isNull(str)) {
            this.bth.hG(str);
            VU().z(this.bth.VL());
        }
    }

    public void hN(String str) {
        this.bth.hH(str);
        if (!this.bth.VO()) {
            du(false);
        } else {
            VS();
        }
    }

    private void VS() {
        VU().z(this.bth.VL());
        VU().gO(this.bth.VK());
    }

    public void du(boolean z) {
        if (this.bte != null) {
            VV().c(this.handler);
            this.bte.Wg();
            if (z) {
                this.bte.Z(0, getPaddingTop());
                this.bth.removeAll();
            }
        }
    }

    public void J(String str, int i) {
        if (VW().We()) {
            VW().K(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        VW().b(i, i2, str, i3);
        VV().b(this.handler);
    }

    public void V(int i, int i2) {
        VW().Y(i, i2);
        if (a(VW().Wc(), this.btf.Wt())) {
            VV().Wu();
        } else {
            VV().Wv();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.im.floatwindow.view.m mVar) {
        if (a(VW().Wc(), VV().Wt())) {
            mVar.WC();
        }
        VW().Wg();
        VV().c(this.handler);
    }

    public void VT() {
        this.btd = true;
        VU().Wr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(j jVar, j jVar2) {
        return jVar.a(jVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a VU() {
        if (this.bte == null) {
            this.bte = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m411getInst());
            this.bte.a(this.btp);
            this.bte.a(this.btq);
            this.bte.Z(0, getPaddingTop());
        }
        return this.bte;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VV() {
        if (this.btf == null) {
            this.btf = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.f(TbadkCoreApplication.m411getInst());
        }
        return this.btf;
    }

    private int getPaddingTop() {
        int I = com.baidu.adp.lib.util.a.I(TbadkCoreApplication.m411getInst());
        if (I == 0) {
            I = 25;
        }
        Resources resources = TbadkCoreApplication.m411getInst().getResources();
        int J = com.baidu.adp.lib.util.a.J(TbadkCoreApplication.m411getInst());
        if (J == 0) {
            J = resources.getDimensionPixelSize(com.baidu.tieba.o.navigation_bar_height);
        }
        return I + J + resources.getDimensionPixelSize(com.baidu.tieba.o.ds40);
    }

    private k VW() {
        if (this.btg == null) {
            this.btg = new k();
        }
        return this.btg;
    }

    public void VX() {
        this.btc = true;
        this.bth.VI();
        VU().setTouchable(false);
    }

    public void VY() {
        this.btc = false;
        this.bth.VJ();
        VU().setTouchable(true);
    }
}
