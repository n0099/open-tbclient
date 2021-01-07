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
    private View bYQ;
    public CustomMessageListener bih;
    private CountDownTimer gPY;
    private TextView oCJ;
    private TextView oCK;
    private TextView oCL;
    private TextView oCM;
    private TextView oCN;
    private TextView oCO;
    private a oCP;
    private int oCQ;
    private LinearLayout oCR;
    private boolean oCS;

    /* loaded from: classes11.dex */
    public interface a {
        void aod();

        void eeL();

        void eeM();
    }

    static /* synthetic */ int h(f fVar) {
        int i = fVar.oCQ;
        fVar.oCQ = i - 1;
        return i;
    }

    public f(Activity activity) {
        super(activity);
        this.oCS = false;
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.4
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
        this.bYQ = findViewById(a.f.view);
        this.oCJ = (TextView) findViewById(a.f.tv_name);
        this.oCK = (TextView) findViewById(a.f.temp_tv_name);
        this.oCL = (TextView) findViewById(a.f.tv_invite_info);
        this.oCM = (TextView) findViewById(a.f.tv_countdown);
        this.oCN = (TextView) findViewById(a.f.tv_give_up);
        this.oCO = (TextView) findViewById(a.f.tv_accept_invite);
        this.oCR = (LinearLayout) findViewById(a.f.ll_invite_info);
        this.bYQ.setOnClickListener(this);
        this.oCN.setOnClickListener(this);
        this.oCO.setOnClickListener(this);
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
    protected boolean UD() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean UE() {
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
        this.oCS = false;
        MessageManager.getInstance().registerListener(this.bih);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bYQ) {
            dismiss();
        } else if (view == this.oCN) {
            this.oCS = true;
            dismiss();
            if (this.oCP != null) {
                this.oCP.eeM();
            }
        } else if (view == this.oCO) {
            this.oCS = true;
            dismiss();
            if (this.oCP != null) {
                this.oCP.eeL();
            }
        }
    }

    public void WB(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oCK.setText(str);
        }
        this.oCJ.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.oCK.getMeasuredWidth() + f.this.oCL.getMeasuredWidth() > f.this.oCR.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) f.this.oCJ.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    f.this.oCJ.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) f.this.oCJ.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    f.this.oCJ.setLayoutParams(layoutParams2);
                }
                f.this.oCJ.setText(str);
            }
        });
    }

    public void NJ(int i) {
        efG();
        this.oCQ = i / 1000;
        this.gPY = new CountDownTimer(2147483647L, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                try {
                    if (f.this.oCQ >= 0) {
                        f.this.efG();
                        if (f.this.oCQ == 0) {
                            f.this.dismiss();
                            if (f.this.oCP != null) {
                                f.this.oCP.aod();
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
        this.gPY.start();
    }

    private void efF() {
        if (this.gPY != null) {
            this.gPY.cancel();
            this.gPY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efG() {
        if (this.oCM != null) {
            this.oCM.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.3
                @Override // java.lang.Runnable
                public void run() {
                    SpannableString spannableString = new SpannableString(String.format(f.this.mContext.getString(a.h.yuyin_ala_connection_wheat_give_up_invite_text), Integer.valueOf(f.this.oCQ)));
                    spannableString.setSpan(new ForegroundColorSpan(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66)), 0, 2, 34);
                    f.this.oCM.setText(spannableString);
                }
            });
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oCS) {
            efF();
        }
        MessageManager.getInstance().unRegisterListener(this.bih);
    }

    public void a(a aVar) {
        this.oCP = aVar;
    }
}
