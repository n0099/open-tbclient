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
    public CustomMessageListener bek;
    private Runnable mRunnable;
    private Timer mTimer;
    private TextView oeR;
    private LinearLayout oeS;
    private LinearLayout oeT;
    private long oeU;
    private boolean oeV;
    private String oeW;
    private CustomMessageListener oeX;
    private g oeh;
    private i oep;

    static /* synthetic */ long c(c cVar) {
        long j = cVar.oeU;
        cVar.oeU = 1 + j;
        return j;
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.4
            @Override // java.lang.Runnable
            public void run() {
                AlaWheatInfoData iY = o.dZA().iY(o.dZA().Xm());
                if (iY != null) {
                    c.this.oeT.setSelected(iY.isOpenMike());
                }
                c.this.VR(c.this.oeW);
            }
        };
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    c.this.cancelTimer();
                    c.this.dismiss();
                }
            }
        };
        this.oeX = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501071) {
                    c.this.dismiss();
                }
            }
        };
        Mw(80);
        zh(true);
        zi(true);
        g(this);
    }

    protected void initView() {
        this.oeR = (TextView) findViewById(a.f.tv_connecting_wheat_time);
        this.oeS = (LinearLayout) findViewById(a.f.ll_hang_up);
        this.oeT = (LinearLayout) findViewById(a.f.ll_mute);
        this.oeR.setOnClickListener(this);
        this.oeT.setOnClickListener(this);
        this.oeT.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oeS.setOnClickListener(this);
        this.oeS.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oeT.setSelected(true);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected View getView() {
        return LayoutInflater.from(this.bNY).inflate(a.g.yuyin_layout_dialog_connnecting_wheat, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean RJ() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean RK() {
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
        if (this.oeR != null) {
            this.oeR.post(this.mRunnable);
        }
        MessageManager.getInstance().registerListener(this.bek);
        MessageManager.getInstance().registerListener(this.oeX);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oeS) {
            if (this.oeh == null) {
                this.oeh = new g(this.ocV);
                this.oeh.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        h.dZp().zb(true);
                        c.this.cancelTimer();
                        c.this.dismiss();
                        if (c.this.oep == null) {
                            c.this.oep = new i();
                        }
                        c.this.oep.VL(o.dZA().Xm());
                        c.this.oep.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
                            public void VM(String str) {
                                c.this.dismiss();
                            }
                        });
                    }
                });
            }
            this.oeh.show();
            this.oeh.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_remind_text));
        } else if (view == this.oeT) {
            String str = !this.oeT.isSelected() ? "0" : "1";
            m mVar = new m();
            m.b bVar = new m.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void zc(boolean z) {
                    AlaWheatInfoData bi = o.dZA().bi(o.dZA().Xm(), false);
                    if (bi != null) {
                        bi.mikeStatus = dZz();
                        c.this.oeT.setSelected(bi.isOpenMike());
                        if (bi.isOpenMike()) {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_open_txt)).show();
                        } else {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_close_txt)).show();
                        }
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void dZy() {
                }
            };
            bVar.VP(str);
            mVar.a(bVar);
            mVar.gL(o.dZA().Xm(), str);
        }
    }

    public void startTimer() {
        if (!this.oeV) {
            this.oeV = true;
            this.mTimer = new Timer();
            this.oeU = 0L;
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    String l;
                    String l2;
                    c.c(c.this);
                    long j = c.this.oeU / 60;
                    long j2 = c.this.oeU % 60;
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
                    c.this.oeW = l + ":" + l2;
                    if (c.this.isShowing()) {
                        c.this.dZO();
                    }
                }
            }, 0L, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZO() {
        this.oeR.post(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VR(String str) {
        if (this.oeR != null && str != null) {
            this.oeR.setText(str);
        }
    }

    public void cancelTimer() {
        this.oeV = false;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bek);
        MessageManager.getInstance().unRegisterListener(this.oeX);
    }

    public boolean dZP() {
        return this.oeV;
    }
}
