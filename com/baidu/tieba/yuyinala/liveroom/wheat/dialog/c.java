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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.i;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.m;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public class c extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    public CustomMessageListener bgy;
    private Runnable mRunnable;
    private Timer mTimer;
    private g ouL;
    private i ouT;
    private String ovA;
    private CustomMessageListener ovB;
    private TextView ovv;
    private LinearLayout ovw;
    private LinearLayout ovx;
    private long ovy;
    private boolean ovz;

    static /* synthetic */ long c(c cVar) {
        long j = cVar.ovy;
        cVar.ovy = 1 + j;
        return j;
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.4
            @Override // java.lang.Runnable
            public void run() {
                AlaWheatInfoData jw = o.efd().jw(o.efd().Zc());
                if (jw != null) {
                    c.this.ovx.setSelected(jw.isOpenMike());
                }
                c.this.WR(c.this.ovA);
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    c.this.cancelTimer();
                    c.this.dismiss();
                }
            }
        };
        this.ovB = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501071) {
                    c.this.dismiss();
                }
            }
        };
        NR(80);
        zS(true);
        zT(true);
        g(this);
    }

    protected void initView() {
        this.ovv = (TextView) findViewById(a.f.tv_connecting_wheat_time);
        this.ovw = (LinearLayout) findViewById(a.f.ll_hang_up);
        this.ovx = (LinearLayout) findViewById(a.f.ll_mute);
        this.ovv.setOnClickListener(this);
        this.ovx.setOnClickListener(this);
        this.ovx.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.ovw.setOnClickListener(this);
        this.ovw.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.ovx.setSelected(true);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected View getView() {
        return LayoutInflater.from(this.beD).inflate(a.g.yuyin_layout_dialog_connnecting_wheat, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Ty() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Tz() {
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
        if (this.ovv != null) {
            this.ovv.post(this.mRunnable);
        }
        MessageManager.getInstance().registerListener(this.bgy);
        MessageManager.getInstance().registerListener(this.ovB);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ovw) {
            if (this.ouL == null) {
                this.ouL = new g(this.oty);
                this.ouL.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        h.eeS().zM(true);
                        c.this.cancelTimer();
                        c.this.dismiss();
                        if (c.this.ouT == null) {
                            c.this.ouT = new i();
                        }
                        c.this.ouT.WL(o.efd().Zc());
                        c.this.ouT.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
                            public void WM(String str) {
                                c.this.dismiss();
                            }
                        });
                    }
                });
            }
            this.ouL.show();
            this.ouL.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_remind_text));
        } else if (view == this.ovx) {
            String str = !this.ovx.isSelected() ? "0" : "1";
            m mVar = new m();
            m.b bVar = new m.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void zN(boolean z) {
                    AlaWheatInfoData bj = o.efd().bj(o.efd().Zc(), false);
                    if (bj != null) {
                        bj.mikeStatus = efc();
                        c.this.ovx.setSelected(bj.isOpenMike());
                        if (bj.isOpenMike()) {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_open_txt)).show();
                        } else {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_close_txt)).show();
                        }
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void efb() {
                }
            };
            bVar.WP(str);
            mVar.a(bVar);
            mVar.gQ(o.efd().Zc(), str);
        }
    }

    public void startTimer() {
        if (!this.ovz) {
            this.ovz = true;
            this.mTimer = new Timer();
            this.ovy = 0L;
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    String l;
                    String l2;
                    c.c(c.this);
                    long j = c.this.ovy / 60;
                    long j2 = c.this.ovy % 60;
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
                    c.this.ovA = l + ":" + l2;
                    if (c.this.isShowing()) {
                        c.this.efs();
                    }
                }
            }, 0L, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efs() {
        this.ovv.post(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WR(String str) {
        if (this.ovv != null && str != null) {
            this.ovv.setText(str);
        }
    }

    public void cancelTimer() {
        this.ovz = false;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.ovB);
    }

    public boolean eft() {
        return this.ovz;
    }
}
