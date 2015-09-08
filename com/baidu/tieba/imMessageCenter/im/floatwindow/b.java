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
    private static b bHB;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a bHE;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e bHF;
    private f bHG;
    private boolean bHC = false;
    private boolean isBackground = false;
    private boolean bHD = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a bHH = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> bHI = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e bHJ = new e();
    private d bHK = new d();
    private a bHL = new a();
    private C0061b bHM = new C0061b();
    private c bHN = new c();
    private i bHO = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0062a bHP = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b Xz() {
        b bVar;
        synchronized (b.class) {
            if (bHB == null) {
                bHB = new b();
            }
            bVar = bHB;
        }
        return bVar;
    }

    public boolean iv(String str) {
        return this.bHI.contains(str);
    }

    public void iw(String str) {
        if (!StringUtils.isNull(str) && !this.bHI.contains(str)) {
            this.bHI.add(str);
        }
    }

    public void ix(String str) {
        if (!StringUtils.isNull(str)) {
            this.bHI.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.bHK);
        MessageManager.getInstance().registerListener(this.bHL);
        MessageManager.getInstance().registerListener(this.bHJ);
        MessageManager.getInstance().registerListener(this.bHM);
        MessageManager.getInstance().registerListener(this.bHN);
    }

    public void dB(boolean z) {
        if (!XA()) {
            if (this.bHH.Xy()) {
                XC();
                if (!XE().XO()) {
                    XE().a(this.handler, z);
                    return;
                }
                return;
            }
            dC(false);
        }
    }

    private boolean XA() {
        return TbadkCoreApplication.m411getInst().isMIUIRom() || !TbadkCoreApplication.m411getInst().isFloatingWindowOpened() || this.bHC || !XB() || com.baidu.tbadk.coreExtra.messageCenter.c.xw().xz() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.xw().xE();
    }

    private boolean XB() {
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

    public void iy(String str) {
        if (!StringUtils.isNull(str)) {
            this.bHH.is(str);
            XE().E(this.bHH.Xv());
        }
    }

    public void iz(String str) {
        this.bHH.it(str);
        if (!this.bHH.Xy()) {
            dC(false);
        } else {
            XC();
        }
    }

    private void XC() {
        XE().E(this.bHH.Xv());
        XE().hC(this.bHH.Xu());
    }

    public void dC(boolean z) {
        if (this.bHE != null) {
            XF().c(this.handler);
            this.bHE.XQ();
            if (z) {
                this.bHE.am(0, getPaddingTop());
                this.bHH.removeAll();
            }
        }
    }

    public void N(String str, int i) {
        if (XG().XO()) {
            XG().O(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        XG().b(i, i2, str, i3);
        XF().b(this.handler);
    }

    public void ai(int i, int i2) {
        XG().al(i, i2);
        if (a(XG().XM(), this.bHF.Yd())) {
            XF().Ye();
        } else {
            XF().Yf();
        }
    }

    public void a(h.a aVar) {
        if (a(XG().XM(), XF().Yd())) {
            aVar.Ym();
        }
        XG().XQ();
        XF().c(this.handler);
    }

    public void XD() {
        this.bHD = true;
        XE().Yb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a XE() {
        if (this.bHE == null) {
            this.bHE = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m411getInst());
            this.bHE.a(this.bHO);
            this.bHE.a(this.bHP);
            this.bHE.am(0, getPaddingTop());
        }
        return this.bHE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XF() {
        if (this.bHF == null) {
            this.bHF = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m411getInst());
        }
        return this.bHF;
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

    private f XG() {
        if (this.bHG == null) {
            this.bHG = new f();
        }
        return this.bHG;
    }

    public void XH() {
        this.bHC = true;
        this.bHH.Xs();
        XE().setTouchable(false);
    }

    public void XI() {
        this.bHC = false;
        this.bHH.Xt();
        XE().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m411getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.xw().xN() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.xw().xz() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xw().xE()) {
                ImMessageCenterPojo data = ((MemoryChangedMessage) customResponsedMessage).getData();
                if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.bHI.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.xw().xA() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.WA().aM(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.bHH.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.bHH.v(data) : 0;
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
                        if (!isOpen && b.this.bHH.Xx()) {
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
