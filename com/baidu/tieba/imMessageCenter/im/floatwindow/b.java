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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private static b doo;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a dor;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e dos;
    private f dot;
    private boolean dop = false;
    private boolean isBackground = false;
    private boolean doq = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a dou = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> dov = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e dow = new e();
    private d dox = new d();
    private a doy = new a();
    private C0067b doz = new C0067b();
    private c doA = new c();
    private i doB = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0068a doC = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b axm() {
        b bVar;
        synchronized (b.class) {
            if (doo == null) {
                doo = new b();
            }
            bVar = doo;
        }
        return bVar;
    }

    public boolean mh(String str) {
        return this.dov.contains(str);
    }

    public void mi(String str) {
        if (!StringUtils.isNull(str) && !this.dov.contains(str)) {
            this.dov.add(str);
        }
    }

    public void mj(String str) {
        if (!StringUtils.isNull(str)) {
            this.dov.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.dox);
        MessageManager.getInstance().registerListener(this.doy);
        MessageManager.getInstance().registerListener(this.dow);
        MessageManager.getInstance().registerListener(this.doz);
        MessageManager.getInstance().registerListener(this.doA);
    }

    public void gq(boolean z) {
        if (!axn()) {
            if (this.dou.axl()) {
                axp();
                if (!axr().axB()) {
                    axr().a(this.handler, z);
                    return;
                }
                return;
            }
            gr(false);
        }
    }

    private boolean axn() {
        return TbadkCoreApplication.m9getInst().isMIUIRom() || !TbadkCoreApplication.m9getInst().isFloatingWindowOpened() || this.dop || !axo() || com.baidu.tbadk.coreExtra.messageCenter.c.yX().za() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.yX().zf();
    }

    private boolean axo() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return (StringUtils.isNull(topActivityClassName) || "com.baidu.tieba.LogoActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.guide.NewUserGuideActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.topRec.TopRecActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(topActivityClassName)) ? false : true;
    }

    public void mk(String str) {
        if (!StringUtils.isNull(str)) {
            this.dou.md(str);
            axr().W(this.dou.axi());
        }
    }

    public void ml(String str) {
        if (!StringUtils.isNull(str) && this.dou != null) {
            this.dou.mg(str);
        }
    }

    public void mm(String str) {
        this.dou.me(str);
        if (!this.dou.axl()) {
            gr(false);
        } else {
            axp();
        }
    }

    private void axp() {
        axr().W(this.dou.axi());
        axr().mb(this.dou.axh());
    }

    public void gr(boolean z) {
        if (this.dor != null) {
            axs().c(this.handler);
            this.dor.axD();
            if (z) {
                this.dor.aY(0, getPaddingTop());
                this.dou.removeAll();
            }
        }
    }

    public void an(String str, int i) {
        if (axt().axB()) {
            axt().ao(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        axt().b(i, i2, str, i3);
        axs().b(this.handler);
    }

    public void aU(int i, int i2) {
        axt().aX(i, i2);
        if (a(axt().axz(), this.dos.axQ())) {
            axs().axR();
        } else {
            axs().axS();
        }
    }

    public void a(h.a aVar) {
        if (a(axt().axz(), axs().axQ())) {
            aVar.axZ();
        }
        axt().axD();
        axs().c(this.handler);
    }

    public void axq() {
        this.doq = true;
        axr().axO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a axr() {
        if (this.dor == null) {
            this.dor = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m9getInst());
            this.dor.a(this.doB);
            this.dor.a(this.doC);
            this.dor.aY(0, getPaddingTop());
        }
        return this.dor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axs() {
        if (this.dos == null) {
            this.dos = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m9getInst());
        }
        return this.dos;
    }

    private int getPaddingTop() {
        int G = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m9getInst());
        if (G == 0) {
            G = 25;
        }
        Resources resources = TbadkCoreApplication.m9getInst().getResources();
        int H = com.baidu.adp.lib.util.a.H(TbadkCoreApplication.m9getInst());
        if (H == 0) {
            H = resources.getDimensionPixelSize(t.e.ds92);
        }
        return G + H + resources.getDimensionPixelSize(t.e.ds40);
    }

    private f axt() {
        if (this.dot == null) {
            this.dot = new f();
        }
        return this.dot;
    }

    public void axu() {
        this.dop = true;
        this.dou.axf();
        axr().setTouchable(false);
    }

    public void axv() {
        this.dop = false;
        this.dou.axg();
        axr().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m9getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.yX().zo() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.yX().za() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yX().zf()) {
                MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
                ImMessageCenterPojo data = memoryChangedMessage.getData();
                if (memoryChangedMessage.getType() == 2) {
                    b.this.mm(data.getGid());
                } else if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.dov.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.yX().zb() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.awk().bi(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.dou.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.dou.v(data) : 0;
                        }
                        if (v != 0 && v != 3) {
                            b.this.gq(true);
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
                            b.this.gr(true);
                            return;
                        }
                        return;
                    case 2:
                        if (!isOpen && b.this.dou.axk()) {
                            b.this.gq(false);
                            return;
                        }
                        return;
                    case 4:
                        if (isOpen) {
                            b.this.gq(true);
                            return;
                        } else {
                            b.this.gr(false);
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
                b.this.gr(true);
            }
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0067b extends CustomMessageListener {
        public C0067b() {
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
                    b.this.gr(false);
                    return;
                }
                b.this.isBackground = false;
                b.this.gq(true);
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
                b.this.gr(true);
            }
        }
    }
}
