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
    private View bPK;
    public CustomMessageListener bek;
    private CountDownTimer gvV;
    private boolean ofA;
    private TextView ofr;
    private TextView ofs;
    private TextView oft;
    private TextView ofu;
    private TextView ofv;
    private TextView ofw;
    private a ofx;
    private int ofy;
    private LinearLayout ofz;

    /* loaded from: classes4.dex */
    public interface a {
        void aks();

        void dZg();

        void dZh();
    }

    static /* synthetic */ int h(f fVar) {
        int i = fVar.ofy;
        fVar.ofy = i - 1;
        return i;
    }

    public f(Activity activity) {
        super(activity);
        this.ofA = false;
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.4
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
        this.bPK = findViewById(a.f.view);
        this.ofr = (TextView) findViewById(a.f.tv_name);
        this.ofs = (TextView) findViewById(a.f.temp_tv_name);
        this.oft = (TextView) findViewById(a.f.tv_invite_info);
        this.ofu = (TextView) findViewById(a.f.tv_countdown);
        this.ofv = (TextView) findViewById(a.f.tv_give_up);
        this.ofw = (TextView) findViewById(a.f.tv_accept_invite);
        this.ofz = (LinearLayout) findViewById(a.f.ll_invite_info);
        this.bPK.setOnClickListener(this);
        this.ofv.setOnClickListener(this);
        this.ofw.setOnClickListener(this);
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
        return LayoutInflater.from(this.bNY).inflate(a.g.yuyin_layout_dialog_connnection_wheat_invite, (ViewGroup) null);
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
        this.ofA = false;
        MessageManager.getInstance().registerListener(this.bek);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bPK) {
            dismiss();
        } else if (view == this.ofv) {
            this.ofA = true;
            dismiss();
            if (this.ofx != null) {
                this.ofx.dZh();
            }
        } else if (view == this.ofw) {
            this.ofA = true;
            dismiss();
            if (this.ofx != null) {
                this.ofx.dZg();
            }
        }
    }

    public void VS(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ofs.setText(str);
        }
        this.ofr.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.ofs.getMeasuredWidth() + f.this.oft.getMeasuredWidth() > f.this.ofz.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) f.this.ofr.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    f.this.ofr.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) f.this.ofr.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    f.this.ofr.setLayoutParams(layoutParams2);
                }
                f.this.ofr.setText(str);
            }
        });
    }

    public void Mx(int i) {
        dZU();
        this.ofy = i / 1000;
        this.gvV = new CountDownTimer(2147483647L, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                try {
                    if (f.this.ofy >= 0) {
                        f.this.dZU();
                        if (f.this.ofy == 0) {
                            f.this.dismiss();
                            if (f.this.ofx != null) {
                                f.this.ofx.aks();
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
        this.gvV.start();
    }

    private void dZT() {
        if (this.gvV != null) {
            this.gvV.cancel();
            this.gvV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZU() {
        this.ofu.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.f.3
            @Override // java.lang.Runnable
            public void run() {
                SpannableString spannableString = new SpannableString(String.format(f.this.bNY.getString(a.h.yuyin_ala_connection_wheat_give_up_invite_text), Integer.valueOf(f.this.ofy)));
                spannableString.setSpan(new ForegroundColorSpan(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_ff1e66)), 0, 2, 34);
                f.this.ofu.setText(spannableString);
            }
        });
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.ofA) {
            dZT();
        }
        MessageManager.getInstance().unRegisterListener(this.bek);
    }

    public void a(a aVar) {
        this.ofx = aVar;
    }
}
