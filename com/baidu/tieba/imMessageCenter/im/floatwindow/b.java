package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.app.ActivityManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b bqs;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a bqv;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.f bqw;
    private k bqx;
    private boolean bqt = false;
    private boolean isBackground = false;
    private boolean bqu = false;
    private a bqy = new a();
    private ArrayList<String> bqz = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private i bqA = new i(this);
    private h bqB = new h(this);
    private e bqC = new e(this);
    private f bqD = new f(this);
    private g bqE = new g(this);
    private n bqF = new c(this);
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e bqG = new d(this);

    public static synchronized b Uy() {
        b bVar;
        synchronized (b.class) {
            if (bqs == null) {
                bqs = new b();
            }
            bVar = bqs;
        }
        return bVar;
    }

    public boolean hg(String str) {
        return this.bqz.contains(str);
    }

    public void hh(String str) {
        if (!StringUtils.isNull(str) && !this.bqz.contains(str)) {
            this.bqz.add(str);
        }
    }

    public void hi(String str) {
        if (!StringUtils.isNull(str)) {
            this.bqz.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.bqB);
        MessageManager.getInstance().registerListener(this.bqC);
        MessageManager.getInstance().registerListener(this.bqA);
        MessageManager.getInstance().registerListener(this.bqD);
        MessageManager.getInstance().registerListener(this.bqE);
    }

    public void dh(boolean z) {
        if (!Uz()) {
            if (this.bqy.Ux()) {
                UB();
                if (!UD().UN()) {
                    UD().a(this.handler, z);
                    return;
                }
                return;
            }
            di(false);
        }
    }

    private boolean Uz() {
        return TbadkCoreApplication.m411getInst().isMIUIRom() || !TbadkCoreApplication.m411getInst().isFloatingWindowOpened() || this.bqt || !UA() || com.baidu.tbadk.coreExtra.messageCenter.c.vw().vz() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vE();
    }

    private boolean UA() {
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

    public void hj(String str) {
        if (!StringUtils.isNull(str)) {
            this.bqy.hd(str);
            UD().A(this.bqy.Uu());
        }
    }

    public void hk(String str) {
        this.bqy.he(str);
        if (!this.bqy.Ux()) {
            di(false);
        } else {
            UB();
        }
    }

    private void UB() {
        UD().A(this.bqy.Uu());
        UD().gx(this.bqy.Ut());
    }

    public void di(boolean z) {
        if (this.bqv != null) {
            UE().c(this.handler);
            this.bqv.UP();
            if (z) {
                this.bqv.X(0, getPaddingTop());
                this.bqy.removeAll();
            }
        }
    }

    public void J(String str, int i) {
        if (UF().UN()) {
            UF().K(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        UF().b(i, i2, str, i3);
        UE().b(this.handler);
    }

    public void T(int i, int i2) {
        UF().W(i, i2);
        if (a(UF().UL(), this.bqw.Vc())) {
            UE().Vd();
        } else {
            UE().Ve();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.im.floatwindow.view.m mVar) {
        if (a(UF().UL(), UE().Vc())) {
            mVar.Vl();
        }
        UF().UP();
        UE().c(this.handler);
    }

    public void UC() {
        this.bqu = true;
        UD().Va();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(j jVar, j jVar2) {
        return jVar.a(jVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a UD() {
        if (this.bqv == null) {
            this.bqv = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m411getInst());
            this.bqv.a(this.bqF);
            this.bqv.a(this.bqG);
            this.bqv.X(0, getPaddingTop());
        }
        return this.bqv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.f UE() {
        if (this.bqw == null) {
            this.bqw = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.f(TbadkCoreApplication.m411getInst());
        }
        return this.bqw;
    }

    private int getPaddingTop() {
        int I = com.baidu.adp.lib.util.a.I(TbadkCoreApplication.m411getInst());
        if (I == 0) {
            I = 25;
        }
        Resources resources = TbadkCoreApplication.m411getInst().getResources();
        int J = com.baidu.adp.lib.util.a.J(TbadkCoreApplication.m411getInst());
        if (J == 0) {
            J = resources.getDimensionPixelSize(t.navigation_bar_height);
        }
        return I + J + resources.getDimensionPixelSize(t.ds40);
    }

    private k UF() {
        if (this.bqx == null) {
            this.bqx = new k();
        }
        return this.bqx;
    }

    public void UG() {
        this.bqt = true;
        this.bqy.Ur();
        UD().setTouchable(false);
    }

    public void UH() {
        this.bqt = false;
        this.bqy.Us();
        UD().setTouchable(true);
    }
}
