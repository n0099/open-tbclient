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
    private static b bLm;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a bLp;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e bLq;
    private f bLr;
    private boolean bLn = false;
    private boolean isBackground = false;
    private boolean bLo = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a bLs = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> bLt = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e bLu = new e();
    private d bLv = new d();
    private a bLw = new a();
    private C0061b bLx = new C0061b();
    private c bLy = new c();
    private i bLz = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0062a bLA = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b Yy() {
        b bVar;
        synchronized (b.class) {
            if (bLm == null) {
                bLm = new b();
            }
            bVar = bLm;
        }
        return bVar;
    }

    public boolean iB(String str) {
        return this.bLt.contains(str);
    }

    public void iC(String str) {
        if (!StringUtils.isNull(str) && !this.bLt.contains(str)) {
            this.bLt.add(str);
        }
    }

    public void iD(String str) {
        if (!StringUtils.isNull(str)) {
            this.bLt.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.bLv);
        MessageManager.getInstance().registerListener(this.bLw);
        MessageManager.getInstance().registerListener(this.bLu);
        MessageManager.getInstance().registerListener(this.bLx);
        MessageManager.getInstance().registerListener(this.bLy);
    }

    public void dD(boolean z) {
        if (!Yz()) {
            if (this.bLs.Yx()) {
                YB();
                if (!YD().YN()) {
                    YD().a(this.handler, z);
                    return;
                }
                return;
            }
            dE(false);
        }
    }

    private boolean Yz() {
        return TbadkCoreApplication.m411getInst().isMIUIRom() || !TbadkCoreApplication.m411getInst().isFloatingWindowOpened() || this.bLn || !YA() || com.baidu.tbadk.coreExtra.messageCenter.c.xj().xm() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.xj().xr();
    }

    private boolean YA() {
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

    public void iE(String str) {
        if (!StringUtils.isNull(str)) {
            this.bLs.iy(str);
            YD().E(this.bLs.Yu());
        }
    }

    public void iF(String str) {
        this.bLs.iz(str);
        if (!this.bLs.Yx()) {
            dE(false);
        } else {
            YB();
        }
    }

    private void YB() {
        YD().E(this.bLs.Yu());
        YD().hV(this.bLs.Yt());
    }

    public void dE(boolean z) {
        if (this.bLp != null) {
            YE().c(this.handler);
            this.bLp.YP();
            if (z) {
                this.bLp.ap(0, getPaddingTop());
                this.bLs.removeAll();
            }
        }
    }

    public void P(String str, int i) {
        if (YF().YN()) {
            YF().Q(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        YF().b(i, i2, str, i3);
        YE().b(this.handler);
    }

    public void al(int i, int i2) {
        YF().ao(i, i2);
        if (a(YF().YL(), this.bLq.Zc())) {
            YE().Zd();
        } else {
            YE().Ze();
        }
    }

    public void a(h.a aVar) {
        if (a(YF().YL(), YE().Zc())) {
            aVar.Zl();
        }
        YF().YP();
        YE().c(this.handler);
    }

    public void YC() {
        this.bLo = true;
        YD().Za();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a YD() {
        if (this.bLp == null) {
            this.bLp = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m411getInst());
            this.bLp.a(this.bLz);
            this.bLp.a(this.bLA);
            this.bLp.ap(0, getPaddingTop());
        }
        return this.bLp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e YE() {
        if (this.bLq == null) {
            this.bLq = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m411getInst());
        }
        return this.bLq;
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

    private f YF() {
        if (this.bLr == null) {
            this.bLr = new f();
        }
        return this.bLr;
    }

    public void YG() {
        this.bLn = true;
        this.bLs.Yr();
        YD().setTouchable(false);
    }

    public void YH() {
        this.bLn = false;
        this.bLs.Ys();
        YD().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m411getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.xj().xA() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.xj().xm() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xj().xr()) {
                ImMessageCenterPojo data = ((MemoryChangedMessage) customResponsedMessage).getData();
                if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.bLt.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.xj().xn() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.XA().aK(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.bLs.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.bLs.v(data) : 0;
                        }
                        if (v != 0 && v != 3) {
                            b.this.dD(true);
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
                            b.this.dE(true);
                            return;
                        }
                        return;
                    case 2:
                        if (!isOpen && b.this.bLs.Yw()) {
                            b.this.dD(false);
                            return;
                        }
                        return;
                    case 4:
                        if (isOpen) {
                            b.this.dD(true);
                            return;
                        } else {
                            b.this.dE(false);
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
                b.this.dE(true);
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
                    b.this.dE(false);
                    return;
                }
                b.this.isBackground = false;
                b.this.dD(true);
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
                b.this.dE(true);
            }
        }
    }
}
