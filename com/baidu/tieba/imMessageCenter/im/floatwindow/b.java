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
    private static b ciQ;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ciT;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ciU;
    private f ciV;
    private boolean ciR = false;
    private boolean isBackground = false;
    private boolean ciS = false;
    private com.baidu.tieba.imMessageCenter.im.floatwindow.a ciW = new com.baidu.tieba.imMessageCenter.im.floatwindow.a();
    private ArrayList<String> ciX = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private e ciY = new e();
    private d ciZ = new d();
    private a cja = new a();
    private C0066b cjb = new C0066b();
    private c cjc = new c();
    private i cjd = new com.baidu.tieba.imMessageCenter.im.floatwindow.c(this);
    private a.InterfaceC0067a cje = new com.baidu.tieba.imMessageCenter.im.floatwindow.d(this);

    public static synchronized b afW() {
        b bVar;
        synchronized (b.class) {
            if (ciQ == null) {
                ciQ = new b();
            }
            bVar = ciQ;
        }
        return bVar;
    }

    public boolean jm(String str) {
        return this.ciX.contains(str);
    }

    public void jn(String str) {
        if (!StringUtils.isNull(str) && !this.ciX.contains(str)) {
            this.ciX.add(str);
        }
    }

    public void jo(String str) {
        if (!StringUtils.isNull(str)) {
            this.ciX.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.ciZ);
        MessageManager.getInstance().registerListener(this.cja);
        MessageManager.getInstance().registerListener(this.ciY);
        MessageManager.getInstance().registerListener(this.cjb);
        MessageManager.getInstance().registerListener(this.cjc);
    }

    public void ef(boolean z) {
        if (!afX()) {
            if (this.ciW.afV()) {
                afZ();
                if (!agb().agl()) {
                    agb().a(this.handler, z);
                    return;
                }
                return;
            }
            eg(false);
        }
    }

    private boolean afX() {
        return TbadkCoreApplication.m411getInst().isMIUIRom() || !TbadkCoreApplication.m411getInst().isFloatingWindowOpened() || this.ciR || !afY() || com.baidu.tbadk.coreExtra.messageCenter.c.zk().zn() == 0 || !com.baidu.tbadk.coreExtra.messageCenter.c.zk().zs();
    }

    private boolean afY() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return (StringUtils.isNull(topActivityClassName) || "com.baidu.tieba.LogoActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.guide.NewUserGuideActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.topRec.TopRecActivity".equalsIgnoreCase(topActivityClassName) || "com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(topActivityClassName)) ? false : true;
    }

    public void jp(String str) {
        if (!StringUtils.isNull(str)) {
            this.ciW.ji(str);
            agb().K(this.ciW.afS());
        }
    }

    public void jq(String str) {
        if (!StringUtils.isNull(str) && this.ciW != null) {
            this.ciW.jl(str);
        }
    }

    public void jr(String str) {
        this.ciW.jj(str);
        if (!this.ciW.afV()) {
            eg(false);
        } else {
            afZ();
        }
    }

    private void afZ() {
        agb().K(this.ciW.afS());
        agb().jG(this.ciW.afR());
    }

    public void eg(boolean z) {
        if (this.ciT != null) {
            agc().c(this.handler);
            this.ciT.agn();
            if (z) {
                this.ciT.aE(0, getPaddingTop());
                this.ciW.removeAll();
            }
        }
    }

    public void V(String str, int i) {
        if (agd().agl()) {
            agd().W(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        agd().b(i, i2, str, i3);
        agc().b(this.handler);
    }

    public void aA(int i, int i2) {
        agd().aD(i, i2);
        if (a(agd().agj(), this.ciU.agA())) {
            agc().agB();
        } else {
            agc().agC();
        }
    }

    public void a(h.a aVar) {
        if (a(agd().agj(), agc().agA())) {
            aVar.agJ();
        }
        agd().agn();
        agc().c(this.handler);
    }

    public void aga() {
        this.ciS = true;
        agb().agy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar, com.baidu.tieba.imMessageCenter.im.floatwindow.e eVar2) {
        return eVar.a(eVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.a agb() {
        if (this.ciT == null) {
            this.ciT = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.a(TbadkCoreApplication.m411getInst());
            this.ciT.a(this.cjd);
            this.ciT.a(this.cje);
            this.ciT.aE(0, getPaddingTop());
        }
        return this.ciT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.imMessageCenter.im.floatwindow.view.e agc() {
        if (this.ciU == null) {
            this.ciU = new com.baidu.tieba.imMessageCenter.im.floatwindow.view.e(TbadkCoreApplication.m411getInst());
        }
        return this.ciU;
    }

    private int getPaddingTop() {
        int G = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m411getInst());
        if (G == 0) {
            G = 25;
        }
        Resources resources = TbadkCoreApplication.m411getInst().getResources();
        int H = com.baidu.adp.lib.util.a.H(TbadkCoreApplication.m411getInst());
        if (H == 0) {
            H = resources.getDimensionPixelSize(t.e.navigation_bar_height);
        }
        return G + H + resources.getDimensionPixelSize(t.e.ds40);
    }

    private f agd() {
        if (this.ciV == null) {
            this.ciV = new f();
        }
        return this.ciV;
    }

    public void age() {
        this.ciR = true;
        this.ciW.afP();
        agb().setTouchable(false);
    }

    public void agf() {
        this.ciR = false;
        this.ciW.afQ();
        agb().setTouchable(true);
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
            if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m411getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.zk().zB() && !b.this.isBackground && com.baidu.tbadk.coreExtra.messageCenter.c.zk().zn() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zk().zs()) {
                MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
                ImMessageCenterPojo data = memoryChangedMessage.getData();
                if (memoryChangedMessage.getType() == 2) {
                    b.this.jr(data.getGid());
                } else if ((2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) && !b.this.ciX.contains(data.getGid())) {
                    if ((com.baidu.tbadk.coreExtra.messageCenter.c.zk().zo() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.aeU().aP(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                        if (2 == data.getCustomGroupType()) {
                            v = b.this.ciW.u(data);
                        } else {
                            v = -7 == data.getCustomGroupType() ? b.this.ciW.v(data) : 0;
                        }
                        if (v != 0 && v != 3) {
                            b.this.ef(true);
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
                            b.this.eg(true);
                            return;
                        }
                        return;
                    case 2:
                        if (!isOpen && b.this.ciW.afU()) {
                            b.this.ef(false);
                            return;
                        }
                        return;
                    case 4:
                        if (isOpen) {
                            b.this.ef(true);
                            return;
                        } else {
                            b.this.eg(false);
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
                b.this.eg(true);
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
                TbadkCoreApplication.m411getInst().setProcesBackground(data.booleanValue());
                if (data.booleanValue()) {
                    b.this.isBackground = true;
                    b.this.eg(false);
                    return;
                }
                b.this.isBackground = false;
                b.this.ef(true);
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
                b.this.eg(true);
            }
        }
    }
}
