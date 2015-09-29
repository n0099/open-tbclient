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
    private static b bKG;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a bKJ;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e bKK;
    private f bKL;
    private boolean bKH = false;
    private boolean isBackground = false;
    private boolean bKI = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a bKM = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> bKN = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e bKO = new e();
    private d bKP = new d();
    private a bKQ = new a();
    private C0061b bKR = new C0061b();
    private c bKS = new c();
    private i bKT = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0062a bKU = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b Yh() {
        b bVar;
        synchronized (b.class) {
            if (bKG == null) {
                bKG = new b();
            }
            bVar = bKG;
        }
        return bVar;
    }

    public boolean iz(String str) {
        return this.bKN.contains(str);
    }

    public void iA(String str) {
        if (!StringUtils.isNull(str) && !this.bKN.contains(str)) {
            this.bKN.add(str);
        }
    }

    public void iB(String str) {
        if (!StringUtils.isNull(str)) {
            this.bKN.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.bKP);
        MessageManager.getInstance().registerListener(this.bKQ);
        MessageManager.getInstance().registerListener(this.bKO);
        MessageManager.getInstance().registerListener(this.bKR);
        MessageManager.getInstance().registerListener(this.bKS);
    }

    public void dB(boolean z) {
        if (!Yi()) {
            if (this.bKM.Yg()) {
                Yk();
                if (!Ym().Yw()) {
                    Ym().a(this.handler, z);
                    return;
                }
                return;
            }
            dC(false);
        }
    }

    private boolean Yi() {
        return TbadkCoreApplication.m411getInst().isMIUIRom() || !TbadkCoreApplication.m411getInst().isFloatingWindowOpened() || this.bKH || !Yj() || com.baidu.tbadk.coreExtra.messageCenter.c.xh().xk() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.xh().xp();
    }

    private boolean Yj() {
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
            this.bKM.iw(str);
            Ym().E(this.bKM.Yd());
        }
    }

    public void iD(String str) {
        this.bKM.ix(str);
        if (!this.bKM.Yg()) {
            dC(false);
        } else {
            Yk();
        }
    }

    private void Yk() {
        Ym().E(this.bKM.Yd());
        Ym().hI(this.bKM.Yc());
    }

    public void dC(boolean z) {
        if (this.bKJ != null) {
            Yn().c(this.handler);
            this.bKJ.Yy();
            if (z) {
                this.bKJ.an(0, getPaddingTop());
                this.bKM.removeAll();
            }
        }
    }

    public void P(String str, int i) {
        if (Yo().Yw()) {
            Yo().Q(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        Yo().b(i, i2, str, i3);
        Yn().b(this.handler);
    }

    public void aj(int i, int i2) {
        Yo().am(i, i2);
        if (a(Yo().Yu(), this.bKK.YL())) {
            Yn().YM();
        } else {
            Yn().YN();
        }
    }

    public void a(h.a aVar) {
        if (a(Yo().Yu(), Yn().YL())) {
            aVar.YU();
        }
        Yo().Yy();
        Yn().c(this.handler);
    }

    public void Yl() {
        this.bKI = true;
        Ym().YJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Ym() {
        if (this.bKJ == null) {
            this.bKJ = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m411getInst());
            this.bKJ.a(this.bKT);
            this.bKJ.a(this.bKU);
            this.bKJ.an(0, getPaddingTop());
        }
        return this.bKJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yn() {
        if (this.bKK == null) {
            this.bKK = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m411getInst());
        }
        return this.bKK;
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

    private f Yo() {
        if (this.bKL == null) {
            this.bKL = new f();
        }
        return this.bKL;
    }

    public void Yp() {
        this.bKH = true;
        this.bKM.Ya();
        Ym().setTouchable(false);
    }

    public void Yq() {
        this.bKH = false;
        this.bKM.Yb();
        Ym().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m411getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.xh().xy() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.xh().xk() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xh().xp()) {
                ImMessageCenterPojo data = ((MemoryChangedMessage) customResponsedMessage).getData();
                if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.bKN.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.xh().xl() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.Xj().aL(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.bKM.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.bKM.v(data) : 0;
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
                        if (!isOpen && b.this.bKM.Yf()) {
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
