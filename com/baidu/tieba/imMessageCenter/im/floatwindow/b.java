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
    private static b cut;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a cuw;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e cux;
    private f cuy;
    private boolean cuu = false;
    private boolean isBackground = false;
    private boolean cuv = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a cuz = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> cuA = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e cuB = new e();
    private d cuC = new d();
    private a cuD = new a();
    private C0061b cuE = new C0061b();
    private c cuF = new c();
    private i cuG = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0062a cuH = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b ajw() {
        b bVar;
        synchronized (b.class) {
            if (cut == null) {
                cut = new b();
            }
            bVar = cut;
        }
        return bVar;
    }

    public boolean jY(String str) {
        return this.cuA.contains(str);
    }

    public void jZ(String str) {
        if (!StringUtils.isNull(str) && !this.cuA.contains(str)) {
            this.cuA.add(str);
        }
    }

    public void ka(String str) {
        if (!StringUtils.isNull(str)) {
            this.cuA.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.cuC);
        MessageManager.getInstance().registerListener(this.cuD);
        MessageManager.getInstance().registerListener(this.cuB);
        MessageManager.getInstance().registerListener(this.cuE);
        MessageManager.getInstance().registerListener(this.cuF);
    }

    public void fd(boolean z) {
        if (!ajx()) {
            if (this.cuz.ajv()) {
                ajz();
                if (!ajB().ajL()) {
                    ajB().a(this.handler, z);
                    return;
                }
                return;
            }
            fe(false);
        }
    }

    private boolean ajx() {
        return TbadkCoreApplication.m11getInst().isMIUIRom() || !TbadkCoreApplication.m11getInst().isFloatingWindowOpened() || this.cuu || !ajy() || com.baidu.tbadk.coreExtra.messageCenter.c.xF().xI() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.xF().xN();
    }

    private boolean ajy() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return (StringUtils.isNull(topActivityClassName) || "com.baidu.tieba.LogoActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.guide.NewUserGuideActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.topRec.TopRecActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(topActivityClassName)) ? false : true;
    }

    public void kb(String str) {
        if (!StringUtils.isNull(str)) {
            this.cuz.jU(str);
            ajB().K(this.cuz.ajs());
        }
    }

    public void kc(String str) {
        if (!StringUtils.isNull(str) && this.cuz != null) {
            this.cuz.jX(str);
        }
    }

    public void kd(String str) {
        this.cuz.jV(str);
        if (!this.cuz.ajv()) {
            fe(false);
        } else {
            ajz();
        }
    }

    private void ajz() {
        ajB().K(this.cuz.ajs());
        ajB().jR(this.cuz.ajr());
    }

    public void fe(boolean z) {
        if (this.cuw != null) {
            ajC().c(this.handler);
            this.cuw.ajN();
            if (z) {
                this.cuw.aA(0, getPaddingTop());
                this.cuz.removeAll();
            }
        }
    }

    public void ag(String str, int i) {
        if (ajD().ajL()) {
            ajD().ah(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        ajD().b(i, i2, str, i3);
        ajC().b(this.handler);
    }

    public void aw(int i, int i2) {
        ajD().az(i, i2);
        if (a(ajD().ajJ(), this.cux.aka())) {
            ajC().akb();
        } else {
            ajC().akc();
        }
    }

    public void a(h.a aVar) {
        if (a(ajD().ajJ(), ajC().aka())) {
            aVar.akj();
        }
        ajD().ajN();
        ajC().c(this.handler);
    }

    public void ajA() {
        this.cuv = true;
        ajB().ajY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajB() {
        if (this.cuw == null) {
            this.cuw = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m11getInst());
            this.cuw.a(this.cuG);
            this.cuw.a(this.cuH);
            this.cuw.aA(0, getPaddingTop());
        }
        return this.cuw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajC() {
        if (this.cux == null) {
            this.cux = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m11getInst());
        }
        return this.cux;
    }

    private int getPaddingTop() {
        int x = com.baidu.adp.lib.util.a.x(TbadkCoreApplication.m11getInst());
        if (x == 0) {
            x = 25;
        }
        Resources resources = TbadkCoreApplication.m11getInst().getResources();
        int y = com.baidu.adp.lib.util.a.y(TbadkCoreApplication.m11getInst());
        if (y == 0) {
            y = resources.getDimensionPixelSize(t.e.navigation_bar_height);
        }
        return x + y + resources.getDimensionPixelSize(t.e.ds40);
    }

    private f ajD() {
        if (this.cuy == null) {
            this.cuy = new f();
        }
        return this.cuy;
    }

    public void ajE() {
        this.cuu = true;
        this.cuz.ajp();
        ajB().setTouchable(false);
    }

    public void ajF() {
        this.cuu = false;
        this.cuz.ajq();
        ajB().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m11getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.xF().xW() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.xF().xI() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xF().xN()) {
                MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
                ImMessageCenterPojo data = memoryChangedMessage.getData();
                if (memoryChangedMessage.getType() == 2) {
                    b.this.kd(data.getGid());
                } else if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.cuA.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.xF().xJ() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.aiu().bg(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.cuz.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.cuz.v(data) : 0;
                        }
                        if (v != 0 && v != 3) {
                            b.this.fd(true);
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
                            b.this.fe(true);
                            return;
                        }
                        return;
                    case 2:
                        if (!isOpen && b.this.cuz.aju()) {
                            b.this.fd(false);
                            return;
                        }
                        return;
                    case 4:
                        if (isOpen) {
                            b.this.fd(true);
                            return;
                        } else {
                            b.this.fe(false);
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
                b.this.fe(true);
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
                TbadkCoreApplication.m11getInst().setProcesBackground(data.booleanValue());
                if (data.booleanValue()) {
                    b.this.isBackground = true;
                    b.this.fe(false);
                    return;
                }
                b.this.isBackground = false;
                b.this.fd(true);
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
                b.this.fe(true);
            }
        }
    }
}
