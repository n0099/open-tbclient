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
    private static b bqc;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a bqf;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.f bqg;
    private k bqh;
    private boolean bqd = false;
    private boolean isBackground = false;
    private boolean bqe = false;
    private a bqi = new a();
    private ArrayList<String> bqj = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private i bqk = new i(this);
    private h bql = new h(this);
    private e bqm = new e(this);
    private f bqn = new f(this);
    private g bqo = new g(this);
    private n bqp = new c(this);
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e bqq = new d(this);

    public static synchronized b Ul() {
        b bVar;
        synchronized (b.class) {
            if (bqc == null) {
                bqc = new b();
            }
            bVar = bqc;
        }
        return bVar;
    }

    public boolean hd(String str) {
        return this.bqj.contains(str);
    }

    public void he(String str) {
        if (!StringUtils.isNull(str) && !this.bqj.contains(str)) {
            this.bqj.add(str);
        }
    }

    public void hf(String str) {
        if (!StringUtils.isNull(str)) {
            this.bqj.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.bql);
        MessageManager.getInstance().registerListener(this.bqm);
        MessageManager.getInstance().registerListener(this.bqk);
        MessageManager.getInstance().registerListener(this.bqn);
        MessageManager.getInstance().registerListener(this.bqo);
    }

    public void dj(boolean z) {
        if (!Um()) {
            if (this.bqi.Uk()) {
                Uo();
                if (!Uq().UA()) {
                    Uq().a(this.handler, z);
                    return;
                }
                return;
            }
            dk(false);
        }
    }

    private boolean Um() {
        return TbadkCoreApplication.m411getInst().isMIUIRom() || !TbadkCoreApplication.m411getInst().isFloatingWindowOpened() || this.bqd || !Un() || com.baidu.tbadk.coreExtra.messageCenter.c.vq().vt() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy();
    }

    private boolean Un() {
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

    public void hg(String str) {
        if (!StringUtils.isNull(str)) {
            this.bqi.ha(str);
            Uq().z(this.bqi.Uh());
        }
    }

    public void hh(String str) {
        this.bqi.hb(str);
        if (!this.bqi.Uk()) {
            dk(false);
        } else {
            Uo();
        }
    }

    private void Uo() {
        Uq().z(this.bqi.Uh());
        Uq().gv(this.bqi.Ug());
    }

    public void dk(boolean z) {
        if (this.bqf != null) {
            Ur().c(this.handler);
            this.bqf.UC();
            if (z) {
                this.bqf.X(0, getPaddingTop());
                this.bqi.removeAll();
            }
        }
    }

    public void J(String str, int i) {
        if (Us().UA()) {
            Us().K(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        Us().b(i, i2, str, i3);
        Ur().b(this.handler);
    }

    public void T(int i, int i2) {
        Us().W(i, i2);
        if (a(Us().Uy(), this.bqg.UP())) {
            Ur().UQ();
        } else {
            Ur().UR();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.im.floatwindow.view.m mVar) {
        if (a(Us().Uy(), Ur().UP())) {
            mVar.UY();
        }
        Us().UC();
        Ur().c(this.handler);
    }

    public void Up() {
        this.bqe = true;
        Uq().UN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(j jVar, j jVar2) {
        return jVar.a(jVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Uq() {
        if (this.bqf == null) {
            this.bqf = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m411getInst());
            this.bqf.a(this.bqp);
            this.bqf.a(this.bqq);
            this.bqf.X(0, getPaddingTop());
        }
        return this.bqf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.f Ur() {
        if (this.bqg == null) {
            this.bqg = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.f(TbadkCoreApplication.m411getInst());
        }
        return this.bqg;
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

    private k Us() {
        if (this.bqh == null) {
            this.bqh = new k();
        }
        return this.bqh;
    }

    public void Ut() {
        this.bqd = true;
        this.bqi.Ue();
        Uq().setTouchable(false);
    }

    public void Uu() {
        this.bqd = false;
        this.bqi.Uf();
        Uq().setTouchable(true);
    }
}
