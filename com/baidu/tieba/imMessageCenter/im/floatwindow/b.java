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
    private static b btc;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a btf;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.f btg;
    private k bth;
    private boolean btd = false;
    private boolean isBackground = false;
    private boolean bte = false;
    private a bti = new a();
    private ArrayList<String> btj = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private i btk = new i(this);
    private h btl = new h(this);
    private e btm = new e(this);
    private f bto = new f(this);
    private g btp = new g(this);
    private n btq = new c(this);
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e btr = new d(this);

    public static synchronized b VQ() {
        b bVar;
        synchronized (b.class) {
            if (btc == null) {
                btc = new b();
            }
            bVar = btc;
        }
        return bVar;
    }

    public boolean hJ(String str) {
        return this.btj.contains(str);
    }

    public void hK(String str) {
        if (!StringUtils.isNull(str) && !this.btj.contains(str)) {
            this.btj.add(str);
        }
    }

    public void hL(String str) {
        if (!StringUtils.isNull(str)) {
            this.btj.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.btl);
        MessageManager.getInstance().registerListener(this.btm);
        MessageManager.getInstance().registerListener(this.btk);
        MessageManager.getInstance().registerListener(this.bto);
        MessageManager.getInstance().registerListener(this.btp);
    }

    public void dt(boolean z) {
        if (!VR()) {
            if (this.bti.VP()) {
                VT();
                if (!VV().Wf()) {
                    VV().a(this.handler, z);
                    return;
                }
                return;
            }
            du(false);
        }
    }

    private boolean VR() {
        return TbadkCoreApplication.m411getInst().isMIUIRom() || !TbadkCoreApplication.m411getInst().isFloatingWindowOpened() || this.btd || !VS() || com.baidu.tbadk.coreExtra.messageCenter.c.wg().wj() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo();
    }

    private boolean VS() {
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
            this.bti.hG(str);
            VV().z(this.bti.VM());
        }
    }

    public void hN(String str) {
        this.bti.hH(str);
        if (!this.bti.VP()) {
            du(false);
        } else {
            VT();
        }
    }

    private void VT() {
        VV().z(this.bti.VM());
        VV().gO(this.bti.VL());
    }

    public void du(boolean z) {
        if (this.btf != null) {
            VW().c(this.handler);
            this.btf.Wh();
            if (z) {
                this.btf.Z(0, getPaddingTop());
                this.bti.removeAll();
            }
        }
    }

    public void J(String str, int i) {
        if (VX().Wf()) {
            VX().K(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        VX().b(i, i2, str, i3);
        VW().b(this.handler);
    }

    public void V(int i, int i2) {
        VX().Y(i, i2);
        if (a(VX().Wd(), this.btg.Wu())) {
            VW().Wv();
        } else {
            VW().Ww();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.im.floatwindow.view.m mVar) {
        if (a(VX().Wd(), VW().Wu())) {
            mVar.WD();
        }
        VX().Wh();
        VW().c(this.handler);
    }

    public void VU() {
        this.bte = true;
        VV().Ws();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(j jVar, j jVar2) {
        return jVar.a(jVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a VV() {
        if (this.btf == null) {
            this.btf = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m411getInst());
            this.btf.a(this.btq);
            this.btf.a(this.btr);
            this.btf.Z(0, getPaddingTop());
        }
        return this.btf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VW() {
        if (this.btg == null) {
            this.btg = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.f(TbadkCoreApplication.m411getInst());
        }
        return this.btg;
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

    private k VX() {
        if (this.bth == null) {
            this.bth = new k();
        }
        return this.bth;
    }

    public void VY() {
        this.btd = true;
        this.bti.VJ();
        VV().setTouchable(false);
    }

    public void VZ() {
        this.btd = false;
        this.bti.VK();
        VV().setTouchable(true);
    }
}
