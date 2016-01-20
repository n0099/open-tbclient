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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private static b cer;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ceu;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e cev;
    private f cew;
    private boolean ces = false;
    private boolean isBackground = false;
    private boolean cet = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a cex = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> cey = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e cez = new e();
    private d ceA = new d();
    private a ceB = new a();
    private C0064b ceC = new C0064b();
    private c ceD = new c();
    private i ceE = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0065a ceF = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b acN() {
        b bVar;
        synchronized (b.class) {
            if (cer == null) {
                cer = new b();
            }
            bVar = cer;
        }
        return bVar;
    }

    public boolean jj(String str) {
        return this.cey.contains(str);
    }

    public void jk(String str) {
        if (!StringUtils.isNull(str) && !this.cey.contains(str)) {
            this.cey.add(str);
        }
    }

    public void jl(String str) {
        if (!StringUtils.isNull(str)) {
            this.cey.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.ceA);
        MessageManager.getInstance().registerListener(this.ceB);
        MessageManager.getInstance().registerListener(this.cez);
        MessageManager.getInstance().registerListener(this.ceC);
        MessageManager.getInstance().registerListener(this.ceD);
    }

    public void dY(boolean z) {
        if (!acO()) {
            if (this.cex.acM()) {
                acQ();
                if (!acS().adc()) {
                    acS().a(this.handler, z);
                    return;
                }
                return;
            }
            dZ(false);
        }
    }

    private boolean acO() {
        return TbadkCoreApplication.m411getInst().isMIUIRom() || !TbadkCoreApplication.m411getInst().isFloatingWindowOpened() || this.ces || !acP() || com.baidu.tbadk.coreExtra.messageCenter.c.xS().xV() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.xS().ya();
    }

    private boolean acP() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return (StringUtils.isNull(topActivityClassName) || "com.baidu.tieba.LogoActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.guide.NewUserGuideActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.topRec.TopRecActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(topActivityClassName)) ? false : true;
    }

    public void jm(String str) {
        if (!StringUtils.isNull(str)) {
            this.cex.jg(str);
            acS().J(this.cex.acJ());
        }
    }

    public void jn(String str) {
        this.cex.jh(str);
        if (!this.cex.acM()) {
            dZ(false);
        } else {
            acQ();
        }
    }

    private void acQ() {
        acS().J(this.cex.acJ());
        acS().ji(this.cex.acI());
    }

    public void dZ(boolean z) {
        if (this.ceu != null) {
            acT().c(this.handler);
            this.ceu.ade();
            if (z) {
                this.ceu.aD(0, getPaddingTop());
                this.cex.removeAll();
            }
        }
    }

    public void U(String str, int i) {
        if (acU().adc()) {
            acU().V(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        acU().b(i, i2, str, i3);
        acT().b(this.handler);
    }

    public void az(int i, int i2) {
        acU().aC(i, i2);
        if (a(acU().ada(), this.cev.adr())) {
            acT().ads();
        } else {
            acT().adt();
        }
    }

    public void a(h.a aVar) {
        if (a(acU().ada(), acT().adr())) {
            aVar.adA();
        }
        acU().ade();
        acT().c(this.handler);
    }

    public void acR() {
        this.cet = true;
        acS().adp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a acS() {
        if (this.ceu == null) {
            this.ceu = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m411getInst());
            this.ceu.a(this.ceE);
            this.ceu.a(this.ceF);
            this.ceu.aD(0, getPaddingTop());
        }
        return this.ceu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e acT() {
        if (this.cev == null) {
            this.cev = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m411getInst());
        }
        return this.cev;
    }

    private int getPaddingTop() {
        int G = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m411getInst());
        if (G == 0) {
            G = 25;
        }
        Resources resources = TbadkCoreApplication.m411getInst().getResources();
        int H = com.baidu.adp.lib.util.a.H(TbadkCoreApplication.m411getInst());
        if (H == 0) {
            H = resources.getDimensionPixelSize(n.e.navigation_bar_height);
        }
        return G + H + resources.getDimensionPixelSize(n.e.ds40);
    }

    private f acU() {
        if (this.cew == null) {
            this.cew = new f();
        }
        return this.cew;
    }

    public void acV() {
        this.ces = true;
        this.cex.acG();
        acS().setTouchable(false);
    }

    public void acW() {
        this.ces = false;
        this.cex.acH();
        acS().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m411getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.xS().yj() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.xS().xV() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xS().ya()) {
                ImMessageCenterPojo data = ((MemoryChangedMessage) customResponsedMessage).getData();
                if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.cey.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.xS().xW() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.abO().aK(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.cex.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.cex.v(data) : 0;
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
                        if (!isOpen && b.this.cex.acL()) {
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
    private class C0064b extends CustomMessageListener {
        public C0064b() {
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
