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
    private static b bKR;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a bKU;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e bKV;
    private f bKW;
    private boolean bKS = false;
    private boolean isBackground = false;
    private boolean bKT = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a bKX = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> bKY = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e bKZ = new e();
    private d bLa = new d();
    private a bLb = new a();
    private C0061b bLc = new C0061b();
    private c bLd = new c();
    private i bLe = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0062a bLf = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b Yd() {
        b bVar;
        synchronized (b.class) {
            if (bKR == null) {
                bKR = new b();
            }
            bVar = bKR;
        }
        return bVar;
    }

    public boolean iz(String str) {
        return this.bKY.contains(str);
    }

    public void iA(String str) {
        if (!StringUtils.isNull(str) && !this.bKY.contains(str)) {
            this.bKY.add(str);
        }
    }

    public void iB(String str) {
        if (!StringUtils.isNull(str)) {
            this.bKY.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.bLa);
        MessageManager.getInstance().registerListener(this.bLb);
        MessageManager.getInstance().registerListener(this.bKZ);
        MessageManager.getInstance().registerListener(this.bLc);
        MessageManager.getInstance().registerListener(this.bLd);
    }

    public void dB(boolean z) {
        if (!Ye()) {
            if (this.bKX.Yc()) {
                Yg();
                if (!Yi().Ys()) {
                    Yi().a(this.handler, z);
                    return;
                }
                return;
            }
            dC(false);
        }
    }

    private boolean Ye() {
        return TbadkCoreApplication.m411getInst().isMIUIRom() || !TbadkCoreApplication.m411getInst().isFloatingWindowOpened() || this.bKS || !Yf() || com.baidu.tbadk.coreExtra.messageCenter.c.xe().xh() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.xe().xm();
    }

    private boolean Yf() {
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

    public void iC(String str) {
        if (!StringUtils.isNull(str)) {
            this.bKX.iw(str);
            Yi().E(this.bKX.XZ());
        }
    }

    public void iD(String str) {
        this.bKX.ix(str);
        if (!this.bKX.Yc()) {
            dC(false);
        } else {
            Yg();
        }
    }

    private void Yg() {
        Yi().E(this.bKX.XZ());
        Yi().hI(this.bKX.XY());
    }

    public void dC(boolean z) {
        if (this.bKU != null) {
            Yj().c(this.handler);
            this.bKU.Yu();
            if (z) {
                this.bKU.an(0, getPaddingTop());
                this.bKX.removeAll();
            }
        }
    }

    public void P(String str, int i) {
        if (Yk().Ys()) {
            Yk().Q(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        Yk().b(i, i2, str, i3);
        Yj().b(this.handler);
    }

    public void aj(int i, int i2) {
        Yk().am(i, i2);
        if (a(Yk().Yq(), this.bKV.YH())) {
            Yj().YI();
        } else {
            Yj().YJ();
        }
    }

    public void a(h.a aVar) {
        if (a(Yk().Yq(), Yj().YH())) {
            aVar.YQ();
        }
        Yk().Yu();
        Yj().c(this.handler);
    }

    public void Yh() {
        this.bKT = true;
        Yi().YF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Yi() {
        if (this.bKU == null) {
            this.bKU = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m411getInst());
            this.bKU.a(this.bLe);
            this.bKU.a(this.bLf);
            this.bKU.an(0, getPaddingTop());
        }
        return this.bKU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yj() {
        if (this.bKV == null) {
            this.bKV = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m411getInst());
        }
        return this.bKV;
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

    private f Yk() {
        if (this.bKW == null) {
            this.bKW = new f();
        }
        return this.bKW;
    }

    public void Yl() {
        this.bKS = true;
        this.bKX.XW();
        Yi().setTouchable(false);
    }

    public void Ym() {
        this.bKS = false;
        this.bKX.XX();
        Yi().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m411getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.xe().xv() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.xe().xh() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xe().xm()) {
                ImMessageCenterPojo data = ((MemoryChangedMessage) customResponsedMessage).getData();
                if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.bKY.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.xe().xi() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.Xf().aL(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.bKX.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.bKX.v(data) : 0;
                        }
                        if (v != 0 && v != 3) {
                            b.this.dB(true);
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
                            b.this.dC(true);
                            return;
                        }
                        return;
                    case 2:
                        if (!isOpen && b.this.bKX.Yb()) {
                            b.this.dB(false);
                            return;
                        }
                        return;
                    case 4:
                        if (isOpen) {
                            b.this.dB(true);
                            return;
                        } else {
                            b.this.dC(false);
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
                b.this.dC(true);
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
                    b.this.dC(false);
                    return;
                }
                b.this.isBackground = false;
                b.this.dB(true);
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
                b.this.dC(true);
            }
        }
    }
}
