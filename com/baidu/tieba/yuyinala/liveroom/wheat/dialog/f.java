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
    private View bUe;
    public CustomMessageListener bdo;
    private CountDownTimer gLs;
    private TextView oye;
    private TextView oyf;
    private TextView oyg;
    private TextView oyh;
    private TextView oyi;
    private TextView oyj;
    private a oyk;
    private int oyl;
    private LinearLayout oym;
    private boolean oyn;

    /* loaded from: classes10.dex */
    public interface a {
        void akj();

        void eaT();

        void eaU();
    }

    static /* synthetic */ int h(f fVar) {
        int i = fVar.oyl;
        fVar.oyl = i - 1;
        return i;
    }

    public f(Activity activity) {
        super(activity);
        this.oyn = false;
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.4
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
        this.bUe = findViewById(a.f.view);
        this.oye = (TextView) findViewById(a.f.tv_name);
        this.oyf = (TextView) findViewById(a.f.temp_tv_name);
        this.oyg = (TextView) findViewById(a.f.tv_invite_info);
        this.oyh = (TextView) findViewById(a.f.tv_countdown);
        this.oyi = (TextView) findViewById(a.f.tv_give_up);
        this.oyj = (TextView) findViewById(a.f.tv_accept_invite);
        this.oym = (LinearLayout) findViewById(a.f.ll_invite_info);
        this.bUe.setOnClickListener(this);
        this.oyi.setOnClickListener(this);
        this.oyj.setOnClickListener(this);
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
    protected boolean QI() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean QJ() {
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
        this.oyn = false;
        MessageManager.getInstance().registerListener(this.bdo);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bUe) {
            dismiss();
        } else if (view == this.oyi) {
            this.oyn = true;
            dismiss();
            if (this.oyk != null) {
                this.oyk.eaU();
            }
        } else if (view == this.oyj) {
            this.oyn = true;
            dismiss();
            if (this.oyk != null) {
                this.oyk.eaT();
            }
        }
    }

    public void Vt(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oyf.setText(str);
        }
        this.oye.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.oyf.getMeasuredWidth() + f.this.oyg.getMeasuredWidth() > f.this.oym.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) f.this.oye.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    f.this.oye.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) f.this.oye.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    f.this.oye.setLayoutParams(layoutParams2);
                }
                f.this.oye.setText(str);
            }
        });
    }

    public void Mc(int i) {
        ebO();
        this.oyl = i / 1000;
        this.gLs = new CountDownTimer(2147483647L, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                try {
                    if (f.this.oyl >= 0) {
                        f.this.ebO();
                        if (f.this.oyl == 0) {
                            f.this.dismiss();
                            if (f.this.oyk != null) {
                                f.this.oyk.akj();
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
        this.gLs.start();
    }

    private void ebN() {
        if (this.gLs != null) {
            this.gLs.cancel();
            this.gLs = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebO() {
        if (this.oyh != null) {
            this.oyh.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.3
                @Override // java.lang.Runnable
                public void run() {
                    SpannableString spannableString = new SpannableString(String.format(f.this.mContext.getString(a.h.yuyin_ala_connection_wheat_give_up_invite_text), Integer.valueOf(f.this.oyl)));
                    spannableString.setSpan(new ForegroundColorSpan(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66)), 0, 2, 34);
                    f.this.oyh.setText(spannableString);
                }
            });
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oyn) {
            ebN();
        }
        MessageManager.getInstance().unRegisterListener(this.bdo);
    }

    public void a(a aVar) {
        this.oyk = aVar;
    }
}
