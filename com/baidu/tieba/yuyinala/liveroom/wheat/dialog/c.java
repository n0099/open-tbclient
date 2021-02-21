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
/* loaded from: classes11.dex */
public class c extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    public CustomMessageListener bgy;
    private Runnable mRunnable;
    private Timer mTimer;
    private g oGV;
    private TextView oHN;
    private LinearLayout oHO;
    private LinearLayout oHP;
    private long oHQ;
    private boolean oHR;
    private String oHS;
    private CustomMessageListener oHT;
    private k oHd;

    static /* synthetic */ long c(c cVar) {
        long j = cVar.oHQ;
        cVar.oHQ = 1 + j;
        return j;
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.4
            @Override // java.lang.Runnable
            public void run() {
                AlaWheatInfoData iK = q.edM().iK(q.edM().Yp());
                if (iK != null) {
                    c.this.oHP.setSelected(iK.isOpenMike());
                }
                c.this.WE(c.this.oHS);
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
        this.oHT = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501071) {
                    c.this.dismiss();
                }
            }
        };
        Mx(80);
        Ai(true);
        Aj(true);
        g(this);
    }

    protected void initView() {
        this.oHN = (TextView) findViewById(a.f.tv_connecting_wheat_time);
        this.oHO = (LinearLayout) findViewById(a.f.ll_hang_up);
        this.oHP = (LinearLayout) findViewById(a.f.ll_mute);
        this.oHN.setOnClickListener(this);
        this.oHP.setOnClickListener(this);
        this.oHP.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oHO.setOnClickListener(this);
        this.oHO.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oHP.setSelected(true);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected View getView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_layout_dialog_connnecting_wheat, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Ss() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean St() {
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
        if (this.oHN != null) {
            this.oHN.post(this.mRunnable);
        }
        MessageManager.getInstance().registerListener(this.bgy);
        MessageManager.getInstance().registerListener(this.oHT);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oHO) {
            if (this.oGV == null) {
                this.oGV = new g(this.oGE);
                this.oGV.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        i.edx().Ad(true);
                        c.this.cancelTimer();
                        c.this.dismiss();
                        if (c.this.oHd == null) {
                            c.this.oHd = new k();
                        }
                        c.this.oHd.Ww(q.edM().Yp());
                        c.this.oHd.a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                            public void Wx(String str) {
                                c.this.dismiss();
                            }
                        });
                    }
                });
            }
            this.oGV.show();
            this.oGV.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_remind_text));
        } else if (view == this.oHP) {
            String str = !this.oHP.isSelected() ? "0" : "1";
            o oVar = new o();
            o.b bVar = new o.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
                public void Ae(boolean z) {
                    AlaWheatInfoData bi = q.edM().bi(q.edM().Yp(), false);
                    if (bi != null) {
                        bi.mikeStatus = edI();
                        c.this.oHP.setSelected(bi.isOpenMike());
                        if (bi.isOpenMike()) {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_open_txt)).show();
                        } else {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_close_txt)).show();
                        }
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
                public void edH() {
                }
            };
            bVar.WA(str);
            oVar.a(bVar);
            oVar.gW(q.edM().Yp(), str);
        }
    }

    public void startTimer() {
        if (!this.oHR) {
            this.oHR = true;
            this.mTimer = new Timer();
            this.oHQ = 0L;
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    String l;
                    String l2;
                    c.c(c.this);
                    long j = c.this.oHQ / 60;
                    long j2 = c.this.oHQ % 60;
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
                    c.this.oHS = l + ":" + l2;
                    if (c.this.isShowing()) {
                        c.this.eeb();
                    }
                }
            }, 0L, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeb() {
        this.oHN.post(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WE(String str) {
        if (this.oHN != null && str != null) {
            this.oHN.setText(str);
        }
    }

    public void cancelTimer() {
        this.oHR = false;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.oHT);
    }

    public boolean eec() {
        return this.oHR;
    }
}
