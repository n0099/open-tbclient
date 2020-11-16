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
    public CustomMessageListener bcy;
    private Runnable mRunnable;
    private Timer mTimer;
    private g ofL;
    private i ofT;
    private String ogA;
    private CustomMessageListener ogB;
    private TextView ogv;
    private LinearLayout ogw;
    private LinearLayout ogx;
    private long ogy;
    private boolean ogz;

    static /* synthetic */ long c(c cVar) {
        long j = cVar.ogy;
        cVar.ogy = 1 + j;
        return j;
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.4
            @Override // java.lang.Runnable
            public void run() {
                AlaWheatInfoData iS = o.dZz().iS(o.dZz().WD());
                if (iS != null) {
                    c.this.ogx.setSelected(iS.isOpenMike());
                }
                c.this.VC(c.this.ogA);
            }
        };
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    c.this.cancelTimer();
                    c.this.dismiss();
                }
            }
        };
        this.ogB = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501071) {
                    c.this.dismiss();
                }
            }
        };
        MZ(80);
        zo(true);
        zp(true);
        g(this);
    }

    protected void initView() {
        this.ogv = (TextView) findViewById(a.f.tv_connecting_wheat_time);
        this.ogw = (LinearLayout) findViewById(a.f.ll_hang_up);
        this.ogx = (LinearLayout) findViewById(a.f.ll_mute);
        this.ogv.setOnClickListener(this);
        this.ogx.setOnClickListener(this);
        this.ogx.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.ogw.setOnClickListener(this);
        this.ogw.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.ogx.setSelected(true);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected View getView() {
        return LayoutInflater.from(this.bMo).inflate(a.g.yuyin_layout_dialog_connnecting_wheat, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Ra() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Rb() {
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
        if (this.ogv != null) {
            this.ogv.post(this.mRunnable);
        }
        MessageManager.getInstance().registerListener(this.bcy);
        MessageManager.getInstance().registerListener(this.ogB);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ogw) {
            if (this.ofL == null) {
                this.ofL = new g(this.oey);
                this.ofL.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        h.dZo().zi(true);
                        c.this.cancelTimer();
                        c.this.dismiss();
                        if (c.this.ofT == null) {
                            c.this.ofT = new i();
                        }
                        c.this.ofT.Vw(o.dZz().WD());
                        c.this.ofT.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
                            public void Vx(String str) {
                                c.this.dismiss();
                            }
                        });
                    }
                });
            }
            this.ofL.show();
            this.ofL.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_remind_text));
        } else if (view == this.ogx) {
            String str = !this.ogx.isSelected() ? "0" : "1";
            m mVar = new m();
            m.b bVar = new m.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void zj(boolean z) {
                    AlaWheatInfoData bi = o.dZz().bi(o.dZz().WD(), false);
                    if (bi != null) {
                        bi.mikeStatus = dZy();
                        c.this.ogx.setSelected(bi.isOpenMike());
                        if (bi.isOpenMike()) {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_open_txt)).show();
                        } else {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_close_txt)).show();
                        }
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void dZx() {
                }
            };
            bVar.VA(str);
            mVar.a(bVar);
            mVar.gL(o.dZz().WD(), str);
        }
    }

    public void startTimer() {
        if (!this.ogz) {
            this.ogz = true;
            this.mTimer = new Timer();
            this.ogy = 0L;
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    String l;
                    String l2;
                    c.c(c.this);
                    long j = c.this.ogy / 60;
                    long j2 = c.this.ogy % 60;
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
                    c.this.ogA = l + ":" + l2;
                    if (c.this.isShowing()) {
                        c.this.dZN();
                    }
                }
            }, 0L, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZN() {
        this.ogv.post(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VC(String str) {
        if (this.ogv != null && str != null) {
            this.ogv.setText(str);
        }
    }

    public void cancelTimer() {
        this.ogz = false;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bcy);
        MessageManager.getInstance().unRegisterListener(this.ogB);
    }

    public boolean dZO() {
        return this.ogz;
    }
}
