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
    private View bOa;
    public CustomMessageListener bcy;
    private CountDownTimer gvC;
    private TextView ogU;
    private TextView ogV;
    private TextView ogW;
    private TextView ogX;
    private TextView ogY;
    private TextView ogZ;
    private a oha;
    private int ohb;
    private LinearLayout ohc;
    private boolean ohd;

    /* loaded from: classes4.dex */
    public interface a {
        void ajK();

        void dZf();

        void dZg();
    }

    static /* synthetic */ int h(f fVar) {
        int i = fVar.ohb;
        fVar.ohb = i - 1;
        return i;
    }

    public f(Activity activity) {
        super(activity);
        this.ohd = false;
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.4
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
        this.bOa = findViewById(a.f.view);
        this.ogU = (TextView) findViewById(a.f.tv_name);
        this.ogV = (TextView) findViewById(a.f.temp_tv_name);
        this.ogW = (TextView) findViewById(a.f.tv_invite_info);
        this.ogX = (TextView) findViewById(a.f.tv_countdown);
        this.ogY = (TextView) findViewById(a.f.tv_give_up);
        this.ogZ = (TextView) findViewById(a.f.tv_accept_invite);
        this.ohc = (LinearLayout) findViewById(a.f.ll_invite_info);
        this.bOa.setOnClickListener(this);
        this.ogY.setOnClickListener(this);
        this.ogZ.setOnClickListener(this);
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
        return LayoutInflater.from(this.bMo).inflate(a.g.yuyin_layout_dialog_connnection_wheat_invite, (ViewGroup) null);
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
        this.ohd = false;
        MessageManager.getInstance().registerListener(this.bcy);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bOa) {
            dismiss();
        } else if (view == this.ogY) {
            this.ohd = true;
            dismiss();
            if (this.oha != null) {
                this.oha.dZg();
            }
        } else if (view == this.ogZ) {
            this.ohd = true;
            dismiss();
            if (this.oha != null) {
                this.oha.dZf();
            }
        }
    }

    public void VD(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ogV.setText(str);
        }
        this.ogU.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.ogV.getMeasuredWidth() + f.this.ogW.getMeasuredWidth() > f.this.ohc.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) f.this.ogU.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    f.this.ogU.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) f.this.ogU.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    f.this.ogU.setLayoutParams(layoutParams2);
                }
                f.this.ogU.setText(str);
            }
        });
    }

    public void Na(int i) {
        dZT();
        this.ohb = i / 1000;
        this.gvC = new CountDownTimer(2147483647L, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                try {
                    if (f.this.ohb >= 0) {
                        f.this.dZT();
                        if (f.this.ohb == 0) {
                            f.this.dismiss();
                            if (f.this.oha != null) {
                                f.this.oha.ajK();
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
        this.gvC.start();
    }

    private void dZS() {
        if (this.gvC != null) {
            this.gvC.cancel();
            this.gvC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZT() {
        this.ogX.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.3
            @Override // java.lang.Runnable
            public void run() {
                SpannableString spannableString = new SpannableString(String.format(f.this.bMo.getString(a.h.yuyin_ala_connection_wheat_give_up_invite_text), Integer.valueOf(f.this.ohb)));
                spannableString.setSpan(new ForegroundColorSpan(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66)), 0, 2, 34);
                f.this.ogX.setText(spannableString);
            }
        });
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.ohd) {
            dZS();
        }
        MessageManager.getInstance().unRegisterListener(this.bcy);
    }

    public void a(a aVar) {
        this.oha = aVar;
    }
}
