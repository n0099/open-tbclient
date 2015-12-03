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
import com.baidu.tieba.im.chat.notify.WindowSwitchResponse;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b caq;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a cat;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e cau;
    private f cav;
    private boolean car = false;
    private boolean isBackground = false;
    private boolean cas = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a caw = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> cax = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e cay = new e();
    private d caz = new d();
    private a caA = new a();
    private C0069b caB = new C0069b();
    private c caC = new c();
    private i caD = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0070a caE = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b abE() {
        b bVar;
        synchronized (b.class) {
            if (caq == null) {
                caq = new b();
            }
            bVar = caq;
        }
        return bVar;
    }

    public boolean iV(String str) {
        return this.cax.contains(str);
    }

    public void iW(String str) {
        if (!StringUtils.isNull(str) && !this.cax.contains(str)) {
            this.cax.add(str);
        }
    }

    public void iX(String str) {
        if (!StringUtils.isNull(str)) {
            this.cax.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.caz);
        MessageManager.getInstance().registerListener(this.caA);
        MessageManager.getInstance().registerListener(this.cay);
        MessageManager.getInstance().registerListener(this.caB);
        MessageManager.getInstance().registerListener(this.caC);
    }

    public void dY(boolean z) {
        if (!abF()) {
            if (this.caw.abD()) {
                abH();
                if (!abJ().abT()) {
                    abJ().a(this.handler, z);
                    return;
                }
                return;
            }
            dZ(false);
        }
    }

    private boolean abF() {
        return TbadkCoreApplication.m411getInst().isMIUIRom() || !TbadkCoreApplication.m411getInst().isFloatingWindowOpened() || this.car || !abG() || com.baidu.tbadk.coreExtra.messageCenter.c.yg().yj() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.yg().yo();
    }

    private boolean abG() {
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

    public void iY(String str) {
        if (!StringUtils.isNull(str)) {
            this.caw.iS(str);
            abJ().K(this.caw.abA());
        }
    }

    public void iZ(String str) {
        this.caw.iT(str);
        if (!this.caw.abD()) {
            dZ(false);
        } else {
            abH();
        }
    }

    private void abH() {
        abJ().K(this.caw.abA());
        abJ().iJ(this.caw.abz());
    }

    public void dZ(boolean z) {
        if (this.cat != null) {
            abK().c(this.handler);
            this.cat.abV();
            if (z) {
                this.cat.ar(0, getPaddingTop());
                this.caw.removeAll();
            }
        }
    }

    public void U(String str, int i) {
        if (abL().abT()) {
            abL().V(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        abL().b(i, i2, str, i3);
        abK().b(this.handler);
    }

    public void an(int i, int i2) {
        abL().aq(i, i2);
        if (a(abL().abR(), this.cau.aci())) {
            abK().acj();
        } else {
            abK().ack();
        }
    }

    public void a(h.a aVar) {
        if (a(abL().abR(), abK().aci())) {
            aVar.acr();
        }
        abL().abV();
        abK().c(this.handler);
    }

    public void abI() {
        this.cas = true;
        abJ().acg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a abJ() {
        if (this.cat == null) {
            this.cat = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m411getInst());
            this.cat.a(this.caD);
            this.cat.a(this.caE);
            this.cat.ar(0, getPaddingTop());
        }
        return this.cat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e abK() {
        if (this.cau == null) {
            this.cau = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m411getInst());
        }
        return this.cau;
    }

    private int getPaddingTop() {
        int G = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m411getInst());
        if (G == 0) {
            G = 25;
        }
        Resources resources = TbadkCoreApplication.m411getInst().getResources();
        int H = com.baidu.adp.lib.util.a.H(TbadkCoreApplication.m411getInst());
        if (H == 0) {
            H = resources.getDimensionPixelSize(n.d.navigation_bar_height);
        }
        return G + H + resources.getDimensionPixelSize(n.d.ds40);
    }

    private f abL() {
        if (this.cav == null) {
            this.cav = new f();
        }
        return this.cav;
    }

    public void abM() {
        this.car = true;
        this.caw.abx();
        abJ().setTouchable(false);
    }

    public void abN() {
        this.car = false;
        this.caw.aby();
        abJ().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m411getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.yg().yx() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.yg().yj() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yg().yo()) {
                ImMessageCenterPojo data = ((MemoryChangedMessage) customResponsedMessage).getData();
                if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.cax.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.yg().yk() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.aaG().aP(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.caw.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.caw.v(data) : 0;
                        }
                        if (v != 0 && v != 3) {
                            b.this.dY(true);
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
                            b.this.dZ(true);
                            return;
                        }
                        return;
                    case 2:
                        if (!isOpen && b.this.caw.abC()) {
                            b.this.dY(false);
                            return;
                        }
                        return;
                    case 4:
                        if (isOpen) {
                            b.this.dY(true);
                            return;
                        } else {
                            b.this.dZ(false);
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
                b.this.dZ(true);
            }
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0069b extends CustomMessageListener {
        public C0069b() {
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
                    b.this.dZ(false);
                    return;
                }
                b.this.isBackground = false;
                b.this.dY(true);
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
                b.this.dZ(true);
            }
        }
    }
}
