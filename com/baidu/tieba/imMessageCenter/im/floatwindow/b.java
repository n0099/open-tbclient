package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.app.ActivityManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.notify.WindowSwitchResponse;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b bGU;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a bGX;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e bGY;
    private f bGZ;
    private boolean bGV = false;
    private boolean isBackground = false;
    private boolean bGW = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a bHa = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> bHb = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e bHc = new e();
    private d bHd = new d();
    private a bHe = new a();
    private C0061b bHf = new C0061b();
    private c bHg = new c();
    private i bHh = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0062a bHi = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b Xx() {
        b bVar;
        synchronized (b.class) {
            if (bGU == null) {
                bGU = new b();
            }
            bVar = bGU;
        }
        return bVar;
    }

    public boolean im(String str) {
        return this.bHb.contains(str);
    }

    public void in(String str) {
        if (!StringUtils.isNull(str) && !this.bHb.contains(str)) {
            this.bHb.add(str);
        }
    }

    public void io(String str) {
        if (!StringUtils.isNull(str)) {
            this.bHb.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.bHd);
        MessageManager.getInstance().registerListener(this.bHe);
        MessageManager.getInstance().registerListener(this.bHc);
        MessageManager.getInstance().registerListener(this.bHf);
        MessageManager.getInstance().registerListener(this.bHg);
    }

    public void dw(boolean z) {
        if (!Xy()) {
            if (this.bHa.Xw()) {
                XA();
                if (!XC().XM()) {
                    XC().a(this.handler, z);
                    return;
                }
                return;
            }
            dx(false);
        }
    }

    private boolean Xy() {
        return TbadkCoreApplication.m411getInst().isMIUIRom() || !TbadkCoreApplication.m411getInst().isFloatingWindowOpened() || this.bGV || !Xz() || com.baidu.tbadk.coreExtra.messageCenter.c.xq().xt() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.xq().xy();
    }

    private boolean Xz() {
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

    public void ip(String str) {
        if (!StringUtils.isNull(str)) {
            this.bHa.ij(str);
            XC().F(this.bHa.Xt());
        }
    }

    public void iq(String str) {
        this.bHa.ik(str);
        if (!this.bHa.Xw()) {
            dx(false);
        } else {
            XA();
        }
    }

    private void XA() {
        XC().F(this.bHa.Xt());
        XC().hs(this.bHa.Xs());
    }

    public void dx(boolean z) {
        if (this.bGX != null) {
            XD().c(this.handler);
            this.bGX.XO();
            if (z) {
                this.bGX.am(0, getPaddingTop());
                this.bHa.removeAll();
            }
        }
    }

    public void M(String str, int i) {
        if (XE().XM()) {
            XE().N(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        XE().b(i, i2, str, i3);
        XD().b(this.handler);
    }

    public void ai(int i, int i2) {
        XE().al(i, i2);
        if (a(XE().XK(), this.bGY.Yb())) {
            XD().Yc();
        } else {
            XD().Yd();
        }
    }

    public void a(h.a aVar) {
        if (a(XE().XK(), XD().Yb())) {
            aVar.Yk();
        }
        XE().XO();
        XD().c(this.handler);
    }

    public void XB() {
        this.bGW = true;
        XC().XZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a XC() {
        if (this.bGX == null) {
            this.bGX = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m411getInst());
            this.bGX.a(this.bHh);
            this.bGX.a(this.bHi);
            this.bGX.am(0, getPaddingTop());
        }
        return this.bGX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XD() {
        if (this.bGY == null) {
            this.bGY = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m411getInst());
        }
        return this.bGY;
    }

    private int getPaddingTop() {
        int G = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m411getInst());
        if (G == 0) {
            G = 25;
        }
        Resources resources = TbadkCoreApplication.m411getInst().getResources();
        int H = com.baidu.adp.lib.util.a.H(TbadkCoreApplication.m411getInst());
        if (H == 0) {
            H = resources.getDimensionPixelSize(i.d.navigation_bar_height);
        }
        return G + H + resources.getDimensionPixelSize(i.d.ds40);
    }

    private f XE() {
        if (this.bGZ == null) {
            this.bGZ = new f();
        }
        return this.bGZ;
    }

    public void XF() {
        this.bGV = true;
        this.bHa.Xq();
        XC().setTouchable(false);
    }

    public void XG() {
        this.bGV = false;
        this.bHa.Xr();
        XC().setTouchable(true);
    }

    /* loaded from: classes.dex */
    private class d extends CustomMessageListener {
        public d() {
            super(CmdConfigCustom.MEMORY_CHANGED);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int v;
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m411getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.xq().xH() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.xq().xt() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xq().xy()) {
                ImMessageCenterPojo data = ((MemoryChangedMessage) customResponsedMessage).getData();
                if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.bHb.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.xq().xu() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.Wy().aK(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.bHa.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.bHa.v(data) : 0;
                        }
                        if (v != 0 && v != 3) {
                            b.this.dw(true);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private class e extends CustomMessageListener {
        public e() {
            super(CmdConfigCustom.CMD_FLOAT_WINDOW_SWITCH_CHANGED);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof WindowSwitchResponse) {
                WindowSwitchResponse windowSwitchResponse = (WindowSwitchResponse) customResponsedMessage;
                int switchType = windowSwitchResponse.getSwitchType();
                boolean isOpen = windowSwitchResponse.isOpen();
                switch (switchType) {
                    case 0:
                    case 1:
                    case 3:
                        if (!isOpen) {
                            b.this.dx(true);
                            return;
                        }
                        return;
                    case 2:
                        if (!isOpen && b.this.bHa.Xv()) {
                            b.this.dw(false);
                            return;
                        }
                        return;
                    case 4:
                        if (isOpen) {
                            b.this.dw(true);
                            return;
                        } else {
                            b.this.dx(false);
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                b.this.dx(true);
            }
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0061b extends CustomMessageListener {
        public C0061b() {
            super(CmdConfigCustom.CMD_BACKGROUND_SWTICH);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                TbadkCoreApplication.m411getInst().setProcesBackground(data.booleanValue());
                if (data.booleanValue()) {
                    b.this.isBackground = true;
                    b.this.dx(false);
                    return;
                }
                b.this.isBackground = false;
                b.this.dw(true);
            }
        }
    }

    /* loaded from: classes.dex */
    private class c extends CustomMessageListener {
        public c() {
            super(CmdConfigCustom.IM_DELETE_IM_DB);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008015) {
                b.this.dx(true);
            }
        }
    }
}
