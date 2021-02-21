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
/* loaded from: classes11.dex */
public class f extends com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private View bYd;
    public CustomMessageListener bgy;
    private CountDownTimer gOm;
    private TextView oIm;
    private TextView oIn;
    private TextView oIo;
    private TextView oIp;
    private TextView oIq;
    private TextView oIr;
    private a oIs;
    private int oIt;
    private LinearLayout oIu;
    private boolean oIv;

    /* loaded from: classes11.dex */
    public interface a {
        void akH();

        void edm();

        void edn();
    }

    static /* synthetic */ int h(f fVar) {
        int i = fVar.oIt;
        fVar.oIt = i - 1;
        return i;
    }

    public f(Activity activity) {
        super(activity);
        this.oIv = false;
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
        this.bYd = findViewById(a.f.view);
        this.oIm = (TextView) findViewById(a.f.tv_name);
        this.oIn = (TextView) findViewById(a.f.temp_tv_name);
        this.oIo = (TextView) findViewById(a.f.tv_invite_info);
        this.oIp = (TextView) findViewById(a.f.tv_countdown);
        this.oIq = (TextView) findViewById(a.f.tv_give_up);
        this.oIr = (TextView) findViewById(a.f.tv_accept_invite);
        this.oIu = (LinearLayout) findViewById(a.f.ll_invite_info);
        this.bYd.setOnClickListener(this);
        this.oIq.setOnClickListener(this);
        this.oIr.setOnClickListener(this);
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
        this.oIv = false;
        MessageManager.getInstance().registerListener(this.bgy);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bYd) {
            dismiss();
        } else if (view == this.oIq) {
            this.oIv = true;
            dismiss();
            if (this.oIs != null) {
                this.oIs.edn();
            }
        } else if (view == this.oIr) {
            this.oIv = true;
            dismiss();
            if (this.oIs != null) {
                this.oIs.edm();
            }
        }
    }

    public void WF(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oIn.setText(str);
        }
        this.oIm.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.oIn.getMeasuredWidth() + f.this.oIo.getMeasuredWidth() > f.this.oIu.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) f.this.oIm.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    f.this.oIm.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) f.this.oIm.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    f.this.oIm.setLayoutParams(layoutParams2);
                }
                f.this.oIm.setText(str);
            }
        });
    }

    public void Mz(int i) {
        eek();
        this.oIt = i / 1000;
        this.gOm = new CountDownTimer(2147483647L, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                try {
                    if (f.this.oIt >= 0) {
                        f.this.eek();
                        if (f.this.oIt == 0) {
                            f.this.dismiss();
                            if (f.this.oIs != null) {
                                f.this.oIs.akH();
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
        this.gOm.start();
    }

    private void eej() {
        if (this.gOm != null) {
            this.gOm.cancel();
            this.gOm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eek() {
        if (this.oIp != null) {
            this.oIp.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.3
                @Override // java.lang.Runnable
                public void run() {
                    SpannableString spannableString = new SpannableString(String.format(f.this.mContext.getString(a.h.yuyin_ala_connection_wheat_give_up_invite_text), Integer.valueOf(f.this.oIt)));
                    spannableString.setSpan(new ForegroundColorSpan(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66)), 0, 2, 34);
                    f.this.oIp.setText(spannableString);
                }
            });
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oIv) {
            eej();
        }
        MessageManager.getInstance().unRegisterListener(this.bgy);
    }

    public void a(a aVar) {
        this.oIs = aVar;
    }
}
