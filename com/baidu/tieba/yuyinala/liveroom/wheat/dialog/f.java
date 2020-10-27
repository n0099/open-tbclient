package com.baidu.tieba.yuyinala.liveroom.wheat.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private View bKe;
    public CustomMessageListener bcQ;
    private CountDownTimer gqh;
    private TextView nXY;
    private TextView nXZ;
    private TextView nYa;
    private TextView nYb;
    private TextView nYc;
    private TextView nYd;
    private a nYe;
    private int nYf;
    private LinearLayout nYg;
    private boolean nYh;

    /* loaded from: classes4.dex */
    public interface a {
        void ahS();

        void dWh();

        void dWi();
    }

    static /* synthetic */ int h(f fVar) {
        int i = fVar.nYf;
        fVar.nYf = i - 1;
        return i;
    }

    public f(Activity activity) {
        super(activity);
        this.nYh = false;
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    f.this.dismiss();
                }
            }
        };
        g((DialogInterface.OnDismissListener) this);
    }

    protected void initView() {
        this.bKe = findViewById(a.g.view);
        this.nXY = (TextView) findViewById(a.g.tv_name);
        this.nXZ = (TextView) findViewById(a.g.temp_tv_name);
        this.nYa = (TextView) findViewById(a.g.tv_invite_info);
        this.nYb = (TextView) findViewById(a.g.tv_countdown);
        this.nYc = (TextView) findViewById(a.g.tv_give_up);
        this.nYd = (TextView) findViewById(a.g.tv_accept_invite);
        this.nYg = (LinearLayout) findViewById(a.g.ll_invite_info);
        this.bKe.setOnClickListener(this);
        this.nYc.setOnClickListener(this);
        this.nYd.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected View getView() {
        return LayoutInflater.from(this.bIs).inflate(a.h.yuyin_layout_dialog_connnection_wheat_invite, (ViewGroup) null);
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
        this.nYh = false;
        MessageManager.getInstance().registerListener(this.bcQ);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bKe) {
            dismiss();
        } else if (view == this.nYc) {
            this.nYh = true;
            dismiss();
            if (this.nYe != null) {
                this.nYe.dWi();
            }
        } else if (view == this.nYd) {
            this.nYh = true;
            dismiss();
            if (this.nYe != null) {
                this.nYe.dWh();
            }
        }
    }

    public void Vw(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.nXZ.setText(str);
        }
        this.nXY.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.nXZ.getMeasuredWidth() + f.this.nYa.getMeasuredWidth() > f.this.nYg.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) f.this.nXY.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    f.this.nXY.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) f.this.nXY.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    f.this.nXY.setLayoutParams(layoutParams2);
                }
                f.this.nXY.setText(str);
            }
        });
    }

    public void Mg(int i) {
        dWV();
        this.nYf = i / 1000;
        this.gqh = new CountDownTimer(2147483647L, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                try {
                    if (f.this.nYf >= 0) {
                        f.this.dWV();
                        if (f.this.nYf == 0) {
                            f.this.dismiss();
                            if (f.this.nYe != null) {
                                f.this.nYe.ahS();
                            }
                        }
                        f.h(f.this);
                    }
                } catch (Exception e) {
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }
        };
        this.gqh.start();
    }

    private void dWU() {
        if (this.gqh != null) {
            this.gqh.cancel();
            this.gqh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWV() {
        this.nYb.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.3
            @Override // java.lang.Runnable
            public void run() {
                SpannableString spannableString = new SpannableString(String.format(f.this.bIs.getString(a.i.yuyin_ala_connection_wheat_give_up_invite_text), Integer.valueOf(f.this.nYf)));
                spannableString.setSpan(new ForegroundColorSpan(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_color_ff1e66)), 0, 2, 34);
                f.this.nYb.setText(spannableString);
            }
        });
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.nYh) {
            dWU();
        }
        MessageManager.getInstance().unRegisterListener(this.bcQ);
    }

    public void a(a aVar) {
        this.nYe = aVar;
    }
}
