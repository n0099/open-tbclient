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
    private static b cZI;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a cZL;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e cZM;
    private f cZN;
    private boolean cZJ = false;
    private boolean isBackground = false;
    private boolean cZK = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a cZO = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> cZP = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e cZQ = new e();
    private d cZR = new d();
    private a cZS = new a();
    private C0066b cZT = new C0066b();
    private c cZU = new c();
    private i cZV = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0067a cZW = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b arM() {
        b bVar;
        synchronized (b.class) {
            if (cZI == null) {
                cZI = new b();
            }
            bVar = cZI;
        }
        return bVar;
    }

    public boolean lr(String str) {
        return this.cZP.contains(str);
    }

    public void ls(String str) {
        if (!StringUtils.isNull(str) && !this.cZP.contains(str)) {
            this.cZP.add(str);
        }
    }

    public void lt(String str) {
        if (!StringUtils.isNull(str)) {
            this.cZP.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.cZR);
        MessageManager.getInstance().registerListener(this.cZS);
        MessageManager.getInstance().registerListener(this.cZQ);
        MessageManager.getInstance().registerListener(this.cZT);
        MessageManager.getInstance().registerListener(this.cZU);
    }

    public void fR(boolean z) {
        if (!arN()) {
            if (this.cZO.arL()) {
                arP();
                if (!arR().asb()) {
                    arR().a(this.handler, z);
                    return;
                }
                return;
            }
            fS(false);
        }
    }

    private boolean arN() {
        return TbadkCoreApplication.m9getInst().isMIUIRom() || !TbadkCoreApplication.m9getInst().isFloatingWindowOpened() || this.cZJ || !arO() || com.baidu.tbadk.coreExtra.messageCenter.c.xK().xN() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.xK().xS();
    }

    private boolean arO() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return (StringUtils.isNull(topActivityClassName) || "com.baidu.tieba.LogoActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.guide.NewUserGuideActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.topRec.TopRecActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(topActivityClassName)) ? false : true;
    }

    public void lu(String str) {
        if (!StringUtils.isNull(str)) {
            this.cZO.ln(str);
            arR().U(this.cZO.arI());
        }
    }

    public void lv(String str) {
        if (!StringUtils.isNull(str) && this.cZO != null) {
            this.cZO.lq(str);
        }
    }

    public void lw(String str) {
        this.cZO.lo(str);
        if (!this.cZO.arL()) {
            fS(false);
        } else {
            arP();
        }
    }

    private void arP() {
        arR().U(this.cZO.arI());
        arR().ls(this.cZO.arH());
    }

    public void fS(boolean z) {
        if (this.cZL != null) {
            arS().c(this.handler);
            this.cZL.asd();
            if (z) {
                this.cZL.aR(0, getPaddingTop());
                this.cZO.removeAll();
            }
        }
    }

    public void an(String str, int i) {
        if (arT().asb()) {
            arT().ao(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        arT().b(i, i2, str, i3);
        arS().b(this.handler);
    }

    public void aN(int i, int i2) {
        arT().aQ(i, i2);
        if (a(arT().arZ(), this.cZM.asq())) {
            arS().asr();
        } else {
            arS().ass();
        }
    }

    public void a(h.a aVar) {
        if (a(arT().arZ(), arS().asq())) {
            aVar.asz();
        }
        arT().asd();
        arS().c(this.handler);
    }

    public void arQ() {
        this.cZK = true;
        arR().aso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a arR() {
        if (this.cZL == null) {
            this.cZL = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m9getInst());
            this.cZL.a(this.cZV);
            this.cZL.a(this.cZW);
            this.cZL.aR(0, getPaddingTop());
        }
        return this.cZL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e arS() {
        if (this.cZM == null) {
            this.cZM = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m9getInst());
        }
        return this.cZM;
    }

    private int getPaddingTop() {
        int w = com.baidu.adp.lib.util.a.w(TbadkCoreApplication.m9getInst());
        if (w == 0) {
            w = 25;
        }
        Resources resources = TbadkCoreApplication.m9getInst().getResources();
        int x = com.baidu.adp.lib.util.a.x(TbadkCoreApplication.m9getInst());
        if (x == 0) {
            x = resources.getDimensionPixelSize(u.e.ds92);
        }
        return w + x + resources.getDimensionPixelSize(u.e.ds40);
    }

    private f arT() {
        if (this.cZN == null) {
            this.cZN = new f();
        }
        return this.cZN;
    }

    public void arU() {
        this.cZJ = true;
        this.cZO.arF();
        arR().setTouchable(false);
    }

    public void arV() {
        this.cZJ = false;
        this.cZO.arG();
        arR().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m9getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.xK().yb() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.xK().xN() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xK().xS()) {
                MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
                ImMessageCenterPojo data = memoryChangedMessage.getData();
                if (memoryChangedMessage.getType() == 2) {
                    b.this.lw(data.getGid());
                } else if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.cZP.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.xK().xO() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.aqK().bg(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.cZO.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.cZO.v(data) : 0;
                        }
                        if (v != 0 && v != 3) {
                            b.this.fR(true);
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
                            b.this.fS(true);
                            return;
                        }
                        return;
                    case 2:
                        if (!isOpen && b.this.cZO.arK()) {
                            b.this.fR(false);
                            return;
                        }
                        return;
                    case 4:
                        if (isOpen) {
                            b.this.fR(true);
                            return;
                        } else {
                            b.this.fS(false);
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
                b.this.fS(true);
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
                TbadkCoreApplication.m9getInst().setProcesBackground(data.booleanValue());
                if (data.booleanValue()) {
                    b.this.isBackground = true;
                    b.this.fS(false);
                    return;
                }
                b.this.isBackground = false;
                b.this.fR(true);
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
                b.this.fS(true);
            }
        }
    }
}
