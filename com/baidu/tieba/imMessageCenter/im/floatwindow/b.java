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
    private static b dpM;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a dpP;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e dpQ;
    private f dpR;
    private boolean dpN = false;
    private boolean isBackground = false;
    private boolean dpO = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a dpS = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> dpT = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e dpU = new e();
    private d dpV = new d();
    private a dpW = new a();
    private C0070b dpX = new C0070b();
    private c dpY = new c();
    private i dpZ = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0071a dqa = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b axL() {
        b bVar;
        synchronized (b.class) {
            if (dpM == null) {
                dpM = new b();
            }
            bVar = dpM;
        }
        return bVar;
    }

    public boolean mu(String str) {
        return this.dpT.contains(str);
    }

    public void mv(String str) {
        if (!StringUtils.isNull(str) && !this.dpT.contains(str)) {
            this.dpT.add(str);
        }
    }

    public void mw(String str) {
        if (!StringUtils.isNull(str)) {
            this.dpT.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.dpV);
        MessageManager.getInstance().registerListener(this.dpW);
        MessageManager.getInstance().registerListener(this.dpU);
        MessageManager.getInstance().registerListener(this.dpX);
        MessageManager.getInstance().registerListener(this.dpY);
    }

    public void gt(boolean z) {
        if (!axM()) {
            if (this.dpS.axK()) {
                axO();
                if (!axQ().aya()) {
                    axQ().a(this.handler, z);
                    return;
                }
                return;
            }
            gu(false);
        }
    }

    private boolean axM() {
        return TbadkCoreApplication.m9getInst().isMIUIRom() || !TbadkCoreApplication.m9getInst().isFloatingWindowOpened() || this.dpN || !axN() || com.baidu.tbadk.coreExtra.messageCenter.c.za().zd() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.za().zi();
    }

    private boolean axN() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return (StringUtils.isNull(topActivityClassName) || "com.baidu.tieba.LogoActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.guide.NewUserGuideActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.topRec.TopRecActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(topActivityClassName)) ? false : true;
    }

    public void mx(String str) {
        if (!StringUtils.isNull(str)) {
            this.dpS.mq(str);
            axQ().W(this.dpS.axH());
        }
    }

    public void my(String str) {
        if (!StringUtils.isNull(str) && this.dpS != null) {
            this.dpS.mt(str);
        }
    }

    public void mz(String str) {
        this.dpS.mr(str);
        if (!this.dpS.axK()) {
            gu(false);
        } else {
            axO();
        }
    }

    private void axO() {
        axQ().W(this.dpS.axH());
        axQ().mj(this.dpS.axG());
    }

    public void gu(boolean z) {
        if (this.dpP != null) {
            axR().c(this.handler);
            this.dpP.ayc();
            if (z) {
                this.dpP.ba(0, getPaddingTop());
                this.dpS.removeAll();
            }
        }
    }

    public void an(String str, int i) {
        if (axS().aya()) {
            axS().ao(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        axS().b(i, i2, str, i3);
        axR().b(this.handler);
    }

    public void aW(int i, int i2) {
        axS().aZ(i, i2);
        if (a(axS().axY(), this.dpQ.ayo())) {
            axR().ayp();
        } else {
            axR().ayq();
        }
    }

    public void a(h.a aVar) {
        if (a(axS().axY(), axR().ayo())) {
            aVar.ayx();
        }
        axS().ayc();
        axR().c(this.handler);
    }

    public void axP() {
        this.dpO = true;
        axQ().aym();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a axQ() {
        if (this.dpP == null) {
            this.dpP = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m9getInst());
            this.dpP.a(this.dpZ);
            this.dpP.a(this.dqa);
            this.dpP.ba(0, getPaddingTop());
        }
        return this.dpP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axR() {
        if (this.dpQ == null) {
            this.dpQ = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m9getInst());
        }
        return this.dpQ;
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

    private f axS() {
        if (this.dpR == null) {
            this.dpR = new f();
        }
        return this.dpR;
    }

    public void axT() {
        this.dpN = true;
        this.dpS.axE();
        axQ().setTouchable(false);
    }

    public void axU() {
        this.dpN = false;
        this.dpS.axF();
        axQ().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m9getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.za().zr() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.za().zd() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.za().zi()) {
                MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
                ImMessageCenterPojo data = memoryChangedMessage.getData();
                if (memoryChangedMessage.getType() == 2) {
                    b.this.mz(data.getGid());
                } else if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.dpT.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.za().ze() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.awJ().bk(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.dpS.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.dpS.v(data) : 0;
                        }
                        if (v != 0 && v != 3) {
                            b.this.gt(true);
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
                            b.this.gu(true);
                            return;
                        }
                        return;
                    case 2:
                        if (!isOpen && b.this.dpS.axJ()) {
                            b.this.gt(false);
                            return;
                        }
                        return;
                    case 4:
                        if (isOpen) {
                            b.this.gt(true);
                            return;
                        } else {
                            b.this.gu(false);
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
                b.this.gu(true);
            }
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0070b extends CustomMessageListener {
        public C0070b() {
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
                    b.this.gu(false);
                    return;
                }
                b.this.isBackground = false;
                b.this.gt(true);
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
                b.this.gu(true);
            }
        }
    }
}
