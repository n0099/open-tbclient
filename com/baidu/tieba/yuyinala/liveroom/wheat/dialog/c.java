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
    private g ouN;
    private i ouV;
    private long ovA;
    private boolean ovB;
    private String ovC;
    private CustomMessageListener ovD;
    private TextView ovx;
    private LinearLayout ovy;
    private LinearLayout ovz;

    static /* synthetic */ long c(c cVar) {
        long j = cVar.ovA;
        cVar.ovA = 1 + j;
        return j;
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.4
            @Override // java.lang.Runnable
            public void run() {
                AlaWheatInfoData jw = o.efe().jw(o.efe().Zc());
                if (jw != null) {
                    c.this.ovz.setSelected(jw.isOpenMike());
                }
                c.this.WR(c.this.ovC);
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
        this.ovD = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.6
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
        this.ovx = (TextView) findViewById(a.f.tv_connecting_wheat_time);
        this.ovy = (LinearLayout) findViewById(a.f.ll_hang_up);
        this.ovz = (LinearLayout) findViewById(a.f.ll_mute);
        this.ovx.setOnClickListener(this);
        this.ovz.setOnClickListener(this);
        this.ovz.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.ovy.setOnClickListener(this);
        this.ovy.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.ovz.setSelected(true);
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
        if (this.ovx != null) {
            this.ovx.post(this.mRunnable);
        }
        MessageManager.getInstance().registerListener(this.bgy);
        MessageManager.getInstance().registerListener(this.ovD);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ovy) {
            if (this.ouN == null) {
                this.ouN = new g(this.otA);
                this.ouN.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        h.eeT().zM(true);
                        c.this.cancelTimer();
                        c.this.dismiss();
                        if (c.this.ouV == null) {
                            c.this.ouV = new i();
                        }
                        c.this.ouV.WL(o.efe().Zc());
                        c.this.ouV.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.1.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
                            public void WM(String str) {
                                c.this.dismiss();
                            }
                        });
                    }
                });
            }
            this.ouN.show();
            this.ouN.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_hang_up_remind_text));
        } else if (view == this.ovz) {
            String str = !this.ovz.isSelected() ? "0" : "1";
            m mVar = new m();
            m.b bVar = new m.b() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void zN(boolean z) {
                    AlaWheatInfoData bj = o.efe().bj(o.efe().Zc(), false);
                    if (bj != null) {
                        bj.mikeStatus = efd();
                        c.this.ovz.setSelected(bj.isOpenMike());
                        if (bj.isOpenMike()) {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_open_txt)).show();
                        } else {
                            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_close_txt)).show();
                        }
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void efc() {
                }
            };
            bVar.WP(str);
            mVar.a(bVar);
            mVar.gQ(o.efe().Zc(), str);
        }
    }

    public void startTimer() {
        if (!this.ovB) {
            this.ovB = true;
            this.mTimer = new Timer();
            this.ovA = 0L;
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    String l;
                    String l2;
                    c.c(c.this);
                    long j = c.this.ovA / 60;
                    long j2 = c.this.ovA % 60;
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
                    c.this.ovC = l + ":" + l2;
                    if (c.this.isShowing()) {
                        c.this.eft();
                    }
                }
            }, 0L, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eft() {
        this.ovx.post(this.mRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WR(String str) {
        if (this.ovx != null && str != null) {
            this.ovx.setText(str);
        }
    }

    public void cancelTimer() {
        this.ovB = false;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.ovD);
    }

    public boolean efu() {
        return this.ovB;
    }
}
