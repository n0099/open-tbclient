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
    private View bTg;
    public CustomMessageListener bgy;
    private CountDownTimer gEo;
    private TextView ovW;
    private TextView ovX;
    private TextView ovY;
    private TextView ovZ;
    private TextView owa;
    private TextView owb;
    private a owc;
    private int owd;
    private LinearLayout owe;
    private boolean owf;

    /* loaded from: classes4.dex */
    public interface a {
        void amS();

        void eeK();

        void eeL();
    }

    static /* synthetic */ int h(f fVar) {
        int i = fVar.owd;
        fVar.owd = i - 1;
        return i;
    }

    public f(Activity activity) {
        super(activity);
        this.owf = false;
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.4
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
        this.bTg = findViewById(a.f.view);
        this.ovW = (TextView) findViewById(a.f.tv_name);
        this.ovX = (TextView) findViewById(a.f.temp_tv_name);
        this.ovY = (TextView) findViewById(a.f.tv_invite_info);
        this.ovZ = (TextView) findViewById(a.f.tv_countdown);
        this.owa = (TextView) findViewById(a.f.tv_give_up);
        this.owb = (TextView) findViewById(a.f.tv_accept_invite);
        this.owe = (LinearLayout) findViewById(a.f.ll_invite_info);
        this.bTg.setOnClickListener(this);
        this.owa.setOnClickListener(this);
        this.owb.setOnClickListener(this);
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
        return LayoutInflater.from(this.beD).inflate(a.g.yuyin_layout_dialog_connnection_wheat_invite, (ViewGroup) null);
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
        this.owf = false;
        MessageManager.getInstance().registerListener(this.bgy);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bTg) {
            dismiss();
        } else if (view == this.owa) {
            this.owf = true;
            dismiss();
            if (this.owc != null) {
                this.owc.eeL();
            }
        } else if (view == this.owb) {
            this.owf = true;
            dismiss();
            if (this.owc != null) {
                this.owc.eeK();
            }
        }
    }

    public void WS(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ovX.setText(str);
        }
        this.ovW.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.ovX.getMeasuredWidth() + f.this.ovY.getMeasuredWidth() > f.this.owe.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) f.this.ovW.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    f.this.ovW.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) f.this.ovW.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    f.this.ovW.setLayoutParams(layoutParams2);
                }
                f.this.ovW.setText(str);
            }
        });
    }

    public void NS(int i) {
        efz();
        this.owd = i / 1000;
        this.gEo = new CountDownTimer(2147483647L, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                try {
                    if (f.this.owd >= 0) {
                        f.this.efz();
                        if (f.this.owd == 0) {
                            f.this.dismiss();
                            if (f.this.owc != null) {
                                f.this.owc.amS();
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
        this.gEo.start();
    }

    private void efy() {
        if (this.gEo != null) {
            this.gEo.cancel();
            this.gEo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efz() {
        this.ovZ.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.3
            @Override // java.lang.Runnable
            public void run() {
                SpannableString spannableString = new SpannableString(String.format(f.this.beD.getString(a.h.yuyin_ala_connection_wheat_give_up_invite_text), Integer.valueOf(f.this.owd)));
                spannableString.setSpan(new ForegroundColorSpan(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66)), 0, 2, 34);
                f.this.ovZ.setText(spannableString);
            }
        });
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.owf) {
            efy();
        }
        MessageManager.getInstance().unRegisterListener(this.bgy);
    }

    public void a(a aVar) {
        this.owc = aVar;
    }
}
