package com.baidu.tieba.imMessageCenter.im.floatwindow;

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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.chat.notify.WindowSwitchResponse;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private static b dvt;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a dvw;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e dvx;
    private f dvy;
    private boolean dvu = false;
    private boolean isBackground = false;
    private boolean dvv = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a dvz = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> dvA = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e dvB = new e();
    private d dvC = new d();
    private a dvD = new a();
    private C0069b dvE = new C0069b();
    private c dvF = new c();
    private i dvG = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0070a dvH = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b azI() {
        b bVar;
        synchronized (b.class) {
            if (dvt == null) {
                dvt = new b();
            }
            bVar = dvt;
        }
        return bVar;
    }

    public boolean mH(String str) {
        return this.dvA.contains(str);
    }

    public void mI(String str) {
        if (!StringUtils.isNull(str) && !this.dvA.contains(str)) {
            this.dvA.add(str);
        }
    }

    public void mJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.dvA.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.dvC);
        MessageManager.getInstance().registerListener(this.dvD);
        MessageManager.getInstance().registerListener(this.dvB);
        MessageManager.getInstance().registerListener(this.dvE);
        MessageManager.getInstance().registerListener(this.dvF);
    }

    public void gN(boolean z) {
        if (!azJ()) {
            if (this.dvz.azH()) {
                azL();
                if (!azN().azX()) {
                    azN().a(this.handler, z);
                    return;
                }
                return;
            }
            gO(false);
        }
    }

    private boolean azJ() {
        return TbadkCoreApplication.m9getInst().isMIUIRom() || !TbadkCoreApplication.m9getInst().isFloatingWindowOpened() || this.dvu || !azK() || com.baidu.tbadk.coreExtra.messageCenter.c.zh().zk() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.zh().zp();
    }

    private boolean azK() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return (StringUtils.isNull(topActivityClassName) || "com.baidu.tieba.LogoActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.guide.NewUserGuideActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.topRec.TopRecActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(topActivityClassName)) ? false : true;
    }

    public void mK(String str) {
        if (!StringUtils.isNull(str)) {
            this.dvz.mD(str);
            azN().Z(this.dvz.azE());
        }
    }

    public void mL(String str) {
        if (!StringUtils.isNull(str) && this.dvz != null) {
            this.dvz.mG(str);
        }
    }

    public void mM(String str) {
        this.dvz.mE(str);
        if (!this.dvz.azH()) {
            gO(false);
        } else {
            azL();
        }
    }

    private void azL() {
        azN().Z(this.dvz.azE());
        azN().mr(this.dvz.azD());
    }

    public void gO(boolean z) {
        if (this.dvw != null) {
            azO().c(this.handler);
            this.dvw.azZ();
            if (z) {
                this.dvw.bb(0, getPaddingTop());
                this.dvz.removeAll();
            }
        }
    }

    public void an(String str, int i) {
        if (azP().azX()) {
            azP().ao(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        azP().b(i, i2, str, i3);
        azO().b(this.handler);
    }

    public void aX(int i, int i2) {
        azP().ba(i, i2);
        if (a(azP().azV(), this.dvx.aAl())) {
            azO().aAm();
        } else {
            azO().aAn();
        }
    }

    public void a(h.a aVar) {
        if (a(azP().azV(), azO().aAl())) {
            aVar.aAu();
        }
        azP().azZ();
        azO().c(this.handler);
    }

    public void azM() {
        this.dvv = true;
        azN().aAj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a azN() {
        if (this.dvw == null) {
            this.dvw = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m9getInst());
            this.dvw.a(this.dvG);
            this.dvw.a(this.dvH);
            this.dvw.bb(0, getPaddingTop());
        }
        return this.dvw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e azO() {
        if (this.dvx == null) {
            this.dvx = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m9getInst());
        }
        return this.dvx;
    }

    private int getPaddingTop() {
        int G = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m9getInst());
        if (G == 0) {
            G = 25;
        }
        Resources resources = TbadkCoreApplication.m9getInst().getResources();
        int H = com.baidu.adp.lib.util.a.H(TbadkCoreApplication.m9getInst());
        if (H == 0) {
            H = resources.getDimensionPixelSize(r.e.ds92);
        }
        return G + H + resources.getDimensionPixelSize(r.e.ds40);
    }

    private f azP() {
        if (this.dvy == null) {
            this.dvy = new f();
        }
        return this.dvy;
    }

    public void azQ() {
        this.dvu = true;
        this.dvz.azB();
        azN().setTouchable(false);
    }

    public void azR() {
        this.dvu = false;
        this.dvz.azC();
        azN().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m9getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.zh().zy() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.zh().zk() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zh().zp()) {
                MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
                ImMessageCenterPojo data = memoryChangedMessage.getData();
                if (memoryChangedMessage.getType() == 2) {
                    b.this.mM(data.getGid());
                } else if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.dvA.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.zh().zl() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.ayG().bk(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.dvz.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.dvz.v(data) : 0;
                        }
                        if (v != 0 && v != 3) {
                            b.this.gN(true);
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
                            b.this.gO(true);
                            return;
                        }
                        return;
                    case 2:
                        if (!isOpen && b.this.dvz.azG()) {
                            b.this.gN(false);
                            return;
                        }
                        return;
                    case 4:
                        if (isOpen) {
                            b.this.gN(true);
                            return;
                        } else {
                            b.this.gO(false);
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
                b.this.gO(true);
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
                TbadkCoreApplication.m9getInst().setProcesBackground(data.booleanValue());
                if (data.booleanValue()) {
                    b.this.isBackground = true;
                    b.this.gO(false);
                    return;
                }
                b.this.isBackground = false;
                b.this.gN(true);
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
                b.this.gO(true);
            }
        }
    }
}
