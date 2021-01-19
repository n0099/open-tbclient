package com.baidu.tieba.yuyinala.liveroom.wheat.dialog;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.i;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.m;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes10.dex */
public class c extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    public CustomMessageListener bdo;
    private Runnable mRunnable;
    private Timer mTimer;
    private g owT;
    private TextView oxG;
    private LinearLayout oxH;
    private LinearLayout oxI;
    private long oxJ;
    private boolean oxK;
    private String oxL;
    private CustomMessageListener oxM;
    private i oxc;

    static /* synthetic */ long c(c cVar) {
        long j = cVar.oxJ;
        cVar.oxJ = 1 + j;
        return j;
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.4
            @Override // java.lang.Runnable
            public void run() {
                AlaWheatInfoData ie = o.ebo().ie(o.ebo().Wz());
                if (ie != null) {
                    c.this.oxI.setSelected(ie.isOpenMike());
                }
                c.this.Vt(c.this.oxL);
            }
        };
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    c.this.cancelTimer();
                    c.this.dismiss();
                }
            }
        };
        this.oxM = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501071) {
                    c.this.dismiss();
                }
            }
        };
        Ma(80);
        zP(true);
        zQ(true);
        g(this);
    }

    protected void initView() {
        this.oxG = (TextView) findViewById(a.f.tv_connecting_wheat_time);
        this.oxH = (LinearLayout) findViewById(a.f.ll_hang_up);
        this.oxI = (LinearLayout) findViewById(a.f.ll_mute);
        this.oxG.setOnClickListener(this);
        this.oxI.setOnClickListener(this);
        this.oxI.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oxH.setOnClickListener(this);
        this.oxH.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oxI.setSelected(true);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected View getView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_layout_dialog_connnecting_wheat, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean QI() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean QJ() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected int getDialogMargin() {
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    public void show() {
        try {
            super.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.oxG != null) {
            this.oxG.post(this.mRunnable);
        }
        MessageManager.getInstance().registerListener(this.bdo);
        MessageManager.getInstance().registerListener(this.oxM);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oxH) {
            if (this.owT == null) {
                this.owT = new g(this.ovA);
                this.owT.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.c.h.ebd().zK(true);
                        c.this.cancelTimer();
                        c.this.dismiss();
                        if (c.this.oxc == null) {
                            c.this.oxc = new i();
                        }
                        c.this.oxc.Vn(o.ebo().Wz());
                        c.this.oxc.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
                            public void Vo(String str) {
                                c.this.dismiss();
                            }
                        });
                    }
                });
            }
            this.owT.show();
            this.owT.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_remind_text));
        } else if (view == this.oxI) {
            String str = !this.oxI.isSelected() ? "0" : "1";
            m mVar = new m();
            m.b bVar = new m.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void zL(boolean z) {
                    AlaWheatInfoData bi = o.ebo().bi(o.ebo().Wz(), false);
                    if (bi != null) {
                        bi.mikeStatus = ebn();
                        c.this.oxI.setSelected(bi.isOpenMike());
                        if (bi.isOpenMike()) {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_open_txt)).show();
                        } else {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_close_txt)).show();
                        }
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void ebm() {
                }
            };
            bVar.Vr(str);
            mVar.a(bVar);
            mVar.gN(o.ebo().Wz(), str);
        }
    }

    public void startTimer() {
        if (!this.oxK) {
            this.oxK = true;
            this.mTimer = new Timer();
            this.oxJ = 0L;
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    String l;
                    String l2;
                    c.c(c.this);
                    long j = c.this.oxJ / 60;
                    long j2 = c.this.oxJ % 60;
                    if (j < 10) {
                        l = "0" + j;
                    } else {
                        l = Long.toString(j);
                    }
                    if (j2 < 10) {
                        l2 = "0" + j2;
                    } else {
                        l2 = Long.toString(j2);
                    }
                    c.this.oxL = l + ":" + l2;
                    if (c.this.isShowing()) {
                        c.this.ebF();
                    }
                }
            }, 0L, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebF() {
        this.oxG.post(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vt(String str) {
        if (this.oxG != null && str != null) {
            this.oxG.setText(str);
        }
    }

    public void cancelTimer() {
        this.oxK = false;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bdo);
        MessageManager.getInstance().unRegisterListener(this.oxM);
    }

    public boolean ebG() {
        return this.oxK;
    }
}
