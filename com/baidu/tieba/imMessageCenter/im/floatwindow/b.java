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
    private static b ctv;
    private f ctA;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a cty;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ctz;
    private boolean ctw = false;
    private boolean isBackground = false;
    private boolean ctx = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a ctB = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> ctC = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e ctD = new e();
    private d ctE = new d();
    private a ctF = new a();
    private C0067b ctG = new C0067b();
    private c ctH = new c();
    private i ctI = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0068a ctJ = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b ajq() {
        b bVar;
        synchronized (b.class) {
            if (ctv == null) {
                ctv = new b();
            }
            bVar = ctv;
        }
        return bVar;
    }

    public boolean jV(String str) {
        return this.ctC.contains(str);
    }

    public void jW(String str) {
        if (!StringUtils.isNull(str) && !this.ctC.contains(str)) {
            this.ctC.add(str);
        }
    }

    public void jX(String str) {
        if (!StringUtils.isNull(str)) {
            this.ctC.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.ctE);
        MessageManager.getInstance().registerListener(this.ctF);
        MessageManager.getInstance().registerListener(this.ctD);
        MessageManager.getInstance().registerListener(this.ctG);
        MessageManager.getInstance().registerListener(this.ctH);
    }

    public void eB(boolean z) {
        if (!ajr()) {
            if (this.ctB.ajp()) {
                ajt();
                if (!ajv().ajF()) {
                    ajv().a(this.handler, z);
                    return;
                }
                return;
            }
            eC(false);
        }
    }

    private boolean ajr() {
        return TbadkCoreApplication.m411getInst().isMIUIRom() || !TbadkCoreApplication.m411getInst().isFloatingWindowOpened() || this.ctw || !ajs() || com.baidu.tbadk.coreExtra.messageCenter.c.zM().zP() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.zM().zU();
    }

    private boolean ajs() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return (StringUtils.isNull(topActivityClassName) || "com.baidu.tieba.LogoActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.guide.NewUserGuideActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.topRec.TopRecActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(topActivityClassName)) ? false : true;
    }

    public void jY(String str) {
        if (!StringUtils.isNull(str)) {
            this.ctB.jR(str);
            ajv().J(this.ctB.ajm());
        }
    }

    public void jZ(String str) {
        if (!StringUtils.isNull(str) && this.ctB != null) {
            this.ctB.jU(str);
        }
    }

    public void ka(String str) {
        this.ctB.jS(str);
        if (!this.ctB.ajp()) {
            eC(false);
        } else {
            ajt();
        }
    }

    private void ajt() {
        ajv().J(this.ctB.ajm());
        ajv().km(this.ctB.ajl());
    }

    public void eC(boolean z) {
        if (this.cty != null) {
            ajw().c(this.handler);
            this.cty.ajH();
            if (z) {
                this.cty.aB(0, getPaddingTop());
                this.ctB.removeAll();
            }
        }
    }

    public void ac(String str, int i) {
        if (ajx().ajF()) {
            ajx().ad(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        ajx().b(i, i2, str, i3);
        ajw().b(this.handler);
    }

    public void ax(int i, int i2) {
        ajx().aA(i, i2);
        if (a(ajx().ajD(), this.ctz.ajU())) {
            ajw().ajV();
        } else {
            ajw().ajW();
        }
    }

    public void a(h.a aVar) {
        if (a(ajx().ajD(), ajw().ajU())) {
            aVar.akd();
        }
        ajx().ajH();
        ajw().c(this.handler);
    }

    public void aju() {
        this.ctx = true;
        ajv().ajS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajv() {
        if (this.cty == null) {
            this.cty = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m411getInst());
            this.cty.a(this.ctI);
            this.cty.a(this.ctJ);
            this.cty.aB(0, getPaddingTop());
        }
        return this.cty;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajw() {
        if (this.ctz == null) {
            this.ctz = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m411getInst());
        }
        return this.ctz;
    }

    private int getPaddingTop() {
        int x = com.baidu.adp.lib.util.a.x(TbadkCoreApplication.m411getInst());
        if (x == 0) {
            x = 25;
        }
        Resources resources = TbadkCoreApplication.m411getInst().getResources();
        int y = com.baidu.adp.lib.util.a.y(TbadkCoreApplication.m411getInst());
        if (y == 0) {
            y = resources.getDimensionPixelSize(t.e.navigation_bar_height);
        }
        return x + y + resources.getDimensionPixelSize(t.e.ds40);
    }

    private f ajx() {
        if (this.ctA == null) {
            this.ctA = new f();
        }
        return this.ctA;
    }

    public void ajy() {
        this.ctw = true;
        this.ctB.ajj();
        ajv().setTouchable(false);
    }

    public void ajz() {
        this.ctw = false;
        this.ctB.ajk();
        ajv().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m411getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ad() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.zM().zP() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zM().zU()) {
                MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
                ImMessageCenterPojo data = memoryChangedMessage.getData();
                if (memoryChangedMessage.getType() == 2) {
                    b.this.ka(data.getGid());
                } else if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.ctC.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.zM().zQ() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.ain().bc(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.ctB.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.ctB.v(data) : 0;
                        }
                        if (v != 0 && v != 3) {
                            b.this.eB(true);
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
                            b.this.eC(true);
                            return;
                        }
                        return;
                    case 2:
                        if (!isOpen && b.this.ctB.ajo()) {
                            b.this.eB(false);
                            return;
                        }
                        return;
                    case 4:
                        if (isOpen) {
                            b.this.eB(true);
                            return;
                        } else {
                            b.this.eC(false);
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
                b.this.eC(true);
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
                TbadkCoreApplication.m411getInst().setProcesBackground(data.booleanValue());
                if (data.booleanValue()) {
                    b.this.isBackground = true;
                    b.this.eC(false);
                    return;
                }
                b.this.isBackground = false;
                b.this.eB(true);
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
                b.this.eC(true);
            }
        }
    }
}
