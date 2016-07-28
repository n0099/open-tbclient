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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private static b dcG;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a dcJ;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e dcK;
    private f dcL;
    private boolean dcH = false;
    private boolean isBackground = false;
    private boolean dcI = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a dcM = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> dcN = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e dcO = new e();
    private d dcP = new d();
    private a dcQ = new a();
    private C0066b dcR = new C0066b();
    private c dcS = new c();
    private i dcT = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0067a dcU = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b asy() {
        b bVar;
        synchronized (b.class) {
            if (dcG == null) {
                dcG = new b();
            }
            bVar = dcG;
        }
        return bVar;
    }

    public boolean ly(String str) {
        return this.dcN.contains(str);
    }

    public void lz(String str) {
        if (!StringUtils.isNull(str) && !this.dcN.contains(str)) {
            this.dcN.add(str);
        }
    }

    public void lA(String str) {
        if (!StringUtils.isNull(str)) {
            this.dcN.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.dcP);
        MessageManager.getInstance().registerListener(this.dcQ);
        MessageManager.getInstance().registerListener(this.dcO);
        MessageManager.getInstance().registerListener(this.dcR);
        MessageManager.getInstance().registerListener(this.dcS);
    }

    public void fU(boolean z) {
        if (!asz()) {
            if (this.dcM.asx()) {
                asB();
                if (!asD().asN()) {
                    asD().a(this.handler, z);
                    return;
                }
                return;
            }
            fV(false);
        }
    }

    private boolean asz() {
        return TbadkCoreApplication.m10getInst().isMIUIRom() || !TbadkCoreApplication.m10getInst().isFloatingWindowOpened() || this.dcH || !asA() || com.baidu.tbadk.coreExtra.messageCenter.c.xK().xN() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.xK().xS();
    }

    private boolean asA() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return (StringUtils.isNull(topActivityClassName) || "com.baidu.tieba.LogoActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.guide.NewUserGuideActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.topRec.TopRecActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(topActivityClassName)) ? false : true;
    }

    public void lB(String str) {
        if (!StringUtils.isNull(str)) {
            this.dcM.lu(str);
            asD().W(this.dcM.asu());
        }
    }

    public void lC(String str) {
        if (!StringUtils.isNull(str) && this.dcM != null) {
            this.dcM.lx(str);
        }
    }

    public void lD(String str) {
        this.dcM.lv(str);
        if (!this.dcM.asx()) {
            fV(false);
        } else {
            asB();
        }
    }

    private void asB() {
        asD().W(this.dcM.asu());
        asD().ly(this.dcM.ast());
    }

    public void fV(boolean z) {
        if (this.dcJ != null) {
            asE().c(this.handler);
            this.dcJ.asP();
            if (z) {
                this.dcJ.aU(0, getPaddingTop());
                this.dcM.removeAll();
            }
        }
    }

    public void an(String str, int i) {
        if (asF().asN()) {
            asF().ao(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        asF().b(i, i2, str, i3);
        asE().b(this.handler);
    }

    public void aQ(int i, int i2) {
        asF().aT(i, i2);
        if (a(asF().asL(), this.dcK.atc())) {
            asE().atd();
        } else {
            asE().ate();
        }
    }

    public void a(h.a aVar) {
        if (a(asF().asL(), asE().atc())) {
            aVar.atl();
        }
        asF().asP();
        asE().c(this.handler);
    }

    public void asC() {
        this.dcI = true;
        asD().ata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a asD() {
        if (this.dcJ == null) {
            this.dcJ = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m10getInst());
            this.dcJ.a(this.dcT);
            this.dcJ.a(this.dcU);
            this.dcJ.aU(0, getPaddingTop());
        }
        return this.dcJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e asE() {
        if (this.dcK == null) {
            this.dcK = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m10getInst());
        }
        return this.dcK;
    }

    private int getPaddingTop() {
        int w = com.baidu.adp.lib.util.a.w(TbadkCoreApplication.m10getInst());
        if (w == 0) {
            w = 25;
        }
        Resources resources = TbadkCoreApplication.m10getInst().getResources();
        int x = com.baidu.adp.lib.util.a.x(TbadkCoreApplication.m10getInst());
        if (x == 0) {
            x = resources.getDimensionPixelSize(u.e.ds92);
        }
        return w + x + resources.getDimensionPixelSize(u.e.ds40);
    }

    private f asF() {
        if (this.dcL == null) {
            this.dcL = new f();
        }
        return this.dcL;
    }

    public void asG() {
        this.dcH = true;
        this.dcM.asr();
        asD().setTouchable(false);
    }

    public void asH() {
        this.dcH = false;
        this.dcM.ass();
        asD().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m10getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.xK().yb() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.xK().xN() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xK().xS()) {
                MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
                ImMessageCenterPojo data = memoryChangedMessage.getData();
                if (memoryChangedMessage.getType() == 2) {
                    b.this.lD(data.getGid());
                } else if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.dcN.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.xK().xO() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.arw().bh(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.dcM.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.dcM.v(data) : 0;
                        }
                        if (v != 0 && v != 3) {
                            b.this.fU(true);
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
                            b.this.fV(true);
                            return;
                        }
                        return;
                    case 2:
                        if (!isOpen && b.this.dcM.asw()) {
                            b.this.fU(false);
                            return;
                        }
                        return;
                    case 4:
                        if (isOpen) {
                            b.this.fU(true);
                            return;
                        } else {
                            b.this.fV(false);
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
                b.this.fV(true);
            }
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0066b extends CustomMessageListener {
        public C0066b() {
            super(CmdConfigCustom.CMD_BACKGROUND_SWTICH);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                TbadkCoreApplication.m10getInst().setProcesBackground(data.booleanValue());
                if (data.booleanValue()) {
                    b.this.isBackground = true;
                    b.this.fV(false);
                    return;
                }
                b.this.isBackground = false;
                b.this.fU(true);
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
                b.this.fV(true);
            }
        }
    }
}
