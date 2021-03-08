package com.baidu.tieba.yuyinala.liveroom.wheat.dialog;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes10.dex */
public class e extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private View bZD;
    public CustomMessageListener bhY;
    private TextView eKp;
    private HeadImageView oKl;
    private TextView oKm;
    private TextView oKn;
    private TextView oKo;
    private TextView oKp;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    e.this.dismiss();
                }
            }
        };
        g(this);
    }

    protected void initView() {
        this.bZD = findViewById(a.f.view);
        this.oKl = (HeadImageView) findViewById(a.f.user_avatar);
        this.eKp = (TextView) findViewById(a.f.user_name);
        this.oKm = (TextView) findViewById(a.f.tv_connection_wheat_time);
        this.oKn = (TextView) findViewById(a.f.tv_new_fans_num);
        this.oKo = (TextView) findViewById(a.f.tv_charm_earnings);
        this.oKp = (TextView) findViewById(a.f.tv_ok);
        this.bZD.setOnClickListener(this);
        this.oKp.setOnClickListener(this);
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
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_layout_dialog_connnection_wheat_end, (ViewGroup) null);
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
        } else if (view == this.oKp) {
            dismiss();
        }
    }

    public void d(String str, String str2, String str3, int i, int i2) {
        this.oKl.setIsRound(true);
        this.oKl.setAutoChangeStyle(false);
        this.oKl.setDefaultResource(a.e.yuyin_sdk_default_avatar);
        if (this.oKl != null && !TextUtils.isEmpty(str)) {
            this.oKl.setUrl(str);
            this.oKl.startLoad(str, 12, false);
        }
        if (this.eKp != null) {
            if (!TextUtils.isEmpty(str2)) {
                this.eKp.setText(str2);
            } else {
                this.eKp.setText("");
            }
        }
        if (this.oKm != null) {
            if (!TextUtils.isEmpty(str3)) {
                this.oKm.setText(str3);
            } else {
                this.oKm.setText("");
            }
        }
        if (this.oKn != null) {
            if (!TextUtils.isEmpty(Integer.toString(i))) {
                this.oKn.setText(Integer.toString(i));
            } else {
                this.oKn.setText("");
            }
        }
        if (this.oKo != null) {
            if (!TextUtils.isEmpty(Integer.toString(i2))) {
                this.oKo.setText(Integer.toString(i2));
            } else {
                this.oKo.setText("");
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bhY);
    }
}
