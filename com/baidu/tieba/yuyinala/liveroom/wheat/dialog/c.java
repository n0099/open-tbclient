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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.k;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes10.dex */
public class c extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    public CustomMessageListener bhY;
    private Runnable mRunnable;
    private Timer mTimer;
    private TextView oJS;
    private LinearLayout oJT;
    private LinearLayout oJU;
    private long oJV;
    private boolean oJW;
    private String oJX;
    private CustomMessageListener oJY;
    private g oJa;
    private k oJi;

    static /* synthetic */ long c(c cVar) {
        long j = cVar.oJV;
        cVar.oJV = 1 + j;
        return j;
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.4
            @Override // java.lang.Runnable
            public void run() {
                AlaWheatInfoData iQ = q.edU().iQ(q.edU().Ys());
                if (iQ != null) {
                    c.this.oJU.setSelected(iQ.isOpenMike());
                }
                c.this.WL(c.this.oJX);
            }
        };
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    c.this.cancelTimer();
                    c.this.dismiss();
                }
            }
        };
        this.oJY = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501071) {
                    c.this.dismiss();
                }
            }
        };
        MB(80);
        Ah(true);
        Ai(true);
        g(this);
    }

    protected void initView() {
        this.oJS = (TextView) findViewById(a.f.tv_connecting_wheat_time);
        this.oJT = (LinearLayout) findViewById(a.f.ll_hang_up);
        this.oJU = (LinearLayout) findViewById(a.f.ll_mute);
        this.oJS.setOnClickListener(this);
        this.oJU.setOnClickListener(this);
        this.oJU.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oJT.setOnClickListener(this);
        this.oJT.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oJU.setSelected(true);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected View getView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_layout_dialog_connnecting_wheat, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Sv() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Sw() {
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
        if (this.oJS != null) {
            this.oJS.post(this.mRunnable);
        }
        MessageManager.getInstance().registerListener(this.bhY);
        MessageManager.getInstance().registerListener(this.oJY);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oJT) {
            if (this.oJa == null) {
                this.oJa = new g(this.oIJ);
                this.oJa.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        i.edF().Ac(true);
                        c.this.cancelTimer();
                        c.this.dismiss();
                        if (c.this.oJi == null) {
                            c.this.oJi = new k();
                        }
                        c.this.oJi.WD(q.edU().Ys());
                        c.this.oJi.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                            public void WE(String str) {
                                c.this.dismiss();
                            }
                        });
                    }
                });
            }
            this.oJa.show();
            this.oJa.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_remind_text));
        } else if (view == this.oJU) {
            String str = !this.oJU.isSelected() ? "0" : "1";
            o oVar = new o();
            o.b bVar = new o.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
                public void Ad(boolean z) {
                    AlaWheatInfoData bi = q.edU().bi(q.edU().Ys(), false);
                    if (bi != null) {
                        bi.mikeStatus = edQ();
                        c.this.oJU.setSelected(bi.isOpenMike());
                        if (bi.isOpenMike()) {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_open_txt)).show();
                        } else {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_close_txt)).show();
                        }
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
                public void edP() {
                }
            };
            bVar.WH(str);
            oVar.a(bVar);
            oVar.gW(q.edU().Ys(), str);
        }
    }

    public void startTimer() {
        if (!this.oJW) {
            this.oJW = true;
            this.mTimer = new Timer();
            this.oJV = 0L;
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    String l;
                    String l2;
                    c.c(c.this);
                    long j = c.this.oJV / 60;
                    long j2 = c.this.oJV % 60;
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
                    c.this.oJX = l + ":" + l2;
                    if (c.this.isShowing()) {
                        c.this.eej();
                    }
                }
            }, 0L, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eej() {
        this.oJS.post(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WL(String str) {
        if (this.oJS != null && str != null) {
            this.oJS.setText(str);
        }
    }

    public void cancelTimer() {
        this.oJW = false;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bhY);
        MessageManager.getInstance().unRegisterListener(this.oJY);
    }

    public boolean eek() {
        return this.oJW;
    }
}
