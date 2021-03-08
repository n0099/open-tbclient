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
/* loaded from: classes10.dex */
public class f extends com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private View bZD;
    public CustomMessageListener bhY;
    private CountDownTimer gPV;
    private boolean oKA;
    private TextView oKr;
    private TextView oKs;
    private TextView oKt;
    private TextView oKu;
    private TextView oKv;
    private TextView oKw;
    private a oKx;
    private int oKy;
    private LinearLayout oKz;

    /* loaded from: classes10.dex */
    public interface a {
        void akK();

        void edu();

        void edv();
    }

    static /* synthetic */ int h(f fVar) {
        int i = fVar.oKy;
        fVar.oKy = i - 1;
        return i;
    }

    public f(Activity activity) {
        super(activity);
        this.oKA = false;
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.4
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
        this.bZD = findViewById(a.f.view);
        this.oKr = (TextView) findViewById(a.f.tv_name);
        this.oKs = (TextView) findViewById(a.f.temp_tv_name);
        this.oKt = (TextView) findViewById(a.f.tv_invite_info);
        this.oKu = (TextView) findViewById(a.f.tv_countdown);
        this.oKv = (TextView) findViewById(a.f.tv_give_up);
        this.oKw = (TextView) findViewById(a.f.tv_accept_invite);
        this.oKz = (LinearLayout) findViewById(a.f.ll_invite_info);
        this.bZD.setOnClickListener(this);
        this.oKv.setOnClickListener(this);
        this.oKw.setOnClickListener(this);
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
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_layout_dialog_connnection_wheat_invite, (ViewGroup) null);
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
        this.oKA = false;
        MessageManager.getInstance().registerListener(this.bhY);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bZD) {
            dismiss();
        } else if (view == this.oKv) {
            this.oKA = true;
            dismiss();
            if (this.oKx != null) {
                this.oKx.edv();
            }
        } else if (view == this.oKw) {
            this.oKA = true;
            dismiss();
            if (this.oKx != null) {
                this.oKx.edu();
            }
        }
    }

    public void WM(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oKs.setText(str);
        }
        this.oKr.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.oKs.getMeasuredWidth() + f.this.oKt.getMeasuredWidth() > f.this.oKz.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) f.this.oKr.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    f.this.oKr.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) f.this.oKr.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    f.this.oKr.setLayoutParams(layoutParams2);
                }
                f.this.oKr.setText(str);
            }
        });
    }

    public void MD(int i) {
        ees();
        this.oKy = i / 1000;
        this.gPV = new CountDownTimer(2147483647L, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                try {
                    if (f.this.oKy >= 0) {
                        f.this.ees();
                        if (f.this.oKy == 0) {
                            f.this.dismiss();
                            if (f.this.oKx != null) {
                                f.this.oKx.akK();
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
        this.gPV.start();
    }

    private void eer() {
        if (this.gPV != null) {
            this.gPV.cancel();
            this.gPV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ees() {
        if (this.oKu != null) {
            this.oKu.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.3
                @Override // java.lang.Runnable
                public void run() {
                    SpannableString spannableString = new SpannableString(String.format(f.this.mContext.getString(a.h.yuyin_ala_connection_wheat_give_up_invite_text), Integer.valueOf(f.this.oKy)));
                    spannableString.setSpan(new ForegroundColorSpan(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66)), 0, 2, 34);
                    f.this.oKu.setText(spannableString);
                }
            });
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oKA) {
            eer();
        }
        MessageManager.getInstance().unRegisterListener(this.bhY);
    }

    public void a(a aVar) {
        this.oKx = aVar;
    }
}
