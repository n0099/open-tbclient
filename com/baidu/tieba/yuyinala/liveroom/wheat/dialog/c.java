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
import com.baidu.tieba.yuyinala.liveroom.wheat.b.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.l;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.n;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public class c extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    public CustomMessageListener bcQ;
    private Runnable mRunnable;
    private Timer mTimer;
    private g nWI;
    private h nWQ;
    private TextView nXA;
    private LinearLayout nXB;
    private LinearLayout nXC;
    private long nXD;
    private boolean nXE;
    private String nXF;
    private CustomMessageListener nXG;

    static /* synthetic */ long c(c cVar) {
        long j = cVar.nXD;
        cVar.nXD = 1 + j;
        return j;
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.4
            @Override // java.lang.Runnable
            public void run() {
                AlaWheatInfoData iL = n.dWB().iL(n.dWB().UN());
                if (iL != null) {
                    c.this.nXC.setSelected(iL.isOpenMike());
                }
                c.this.Vv(c.this.nXF);
            }
        };
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    c.this.cancelTimer();
                    c.this.dismiss();
                }
            }
        };
        this.nXG = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501071) {
                    c.this.dismiss();
                }
            }
        };
        Mf(80);
        yZ(true);
        za(true);
        g(this);
    }

    protected void initView() {
        this.nXA = (TextView) findViewById(a.g.tv_connecting_wheat_time);
        this.nXB = (LinearLayout) findViewById(a.g.ll_hang_up);
        this.nXC = (LinearLayout) findViewById(a.g.ll_mute);
        this.nXA.setOnClickListener(this);
        this.nXC.setOnClickListener(this);
        this.nXC.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.nXB.setOnClickListener(this);
        this.nXB.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.nXC.setSelected(true);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected View getView() {
        return LayoutInflater.from(this.bIs).inflate(a.h.yuyin_layout_dialog_connnecting_wheat, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean QG() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean QH() {
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
        if (this.nXA != null) {
            this.nXA.post(this.mRunnable);
        }
        MessageManager.getInstance().registerListener(this.bcQ);
        MessageManager.getInstance().registerListener(this.nXG);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nXB) {
            if (this.nWI == null) {
                this.nWI = new g(this.nVE);
                this.nWI.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.b.g.dWq().yT(true);
                        c.this.cancelTimer();
                        c.this.dismiss();
                        if (c.this.nWQ == null) {
                            c.this.nWQ = new h();
                        }
                        c.this.nWQ.Vo(n.dWB().UN());
                        c.this.nWQ.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.h.a
                            public void Vp(String str) {
                                c.this.dismiss();
                            }
                        });
                    }
                });
            }
            this.nWI.show();
            this.nWI.setText(TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_hang_up_remind_text));
        } else if (view == this.nXC) {
            String str = !this.nXC.isSelected() ? "0" : "1";
            l lVar = new l();
            l.b bVar = new l.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.l.a
                public void yU(boolean z) {
                    AlaWheatInfoData Vu = n.dWB().Vu(n.dWB().UN());
                    if (Vu != null) {
                        Vu.mikeStatus = dWA();
                        c.this.nXC.setSelected(Vu.isOpenMike());
                        if (Vu.isOpenMike()) {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_sdk_connect_wheat_mic_open_txt)).show();
                        } else {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_sdk_connect_wheat_mic_close_txt)).show();
                        }
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.l.a
                public void dWz() {
                }
            };
            bVar.Vs(str);
            lVar.a(bVar);
            lVar.gL(n.dWB().UN(), str);
        }
    }

    public void startTimer() {
        if (!this.nXE) {
            this.nXE = true;
            this.mTimer = new Timer();
            this.nXD = 0L;
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    String l;
                    String l2;
                    c.c(c.this);
                    long j = c.this.nXD / 60;
                    long j2 = c.this.nXD % 60;
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
                    c.this.nXF = l + ":" + l2;
                    if (c.this.isShowing()) {
                        c.this.dWP();
                    }
                }
            }, 0L, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWP() {
        this.nXA.post(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vv(String str) {
        if (this.nXA != null && str != null) {
            this.nXA.setText(str);
        }
    }

    public void cancelTimer() {
        this.nXE = false;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bcQ);
        MessageManager.getInstance().unRegisterListener(this.nXG);
    }

    public boolean dWQ() {
        return this.nXE;
    }
}
