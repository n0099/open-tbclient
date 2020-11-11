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
/* loaded from: classes4.dex */
public class e extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private View bPK;
    public CustomMessageListener bek;
    private TextView ewx;
    private HeadImageView ofl;
    private TextView ofm;
    private TextView ofn;
    private TextView ofo;
    private TextView ofp;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e.1
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
        this.bPK = findViewById(a.f.view);
        this.ofl = (HeadImageView) findViewById(a.f.user_avatar);
        this.ewx = (TextView) findViewById(a.f.user_name);
        this.ofm = (TextView) findViewById(a.f.tv_connection_wheat_time);
        this.ofn = (TextView) findViewById(a.f.tv_new_fans_num);
        this.ofo = (TextView) findViewById(a.f.tv_charm_earnings);
        this.ofp = (TextView) findViewById(a.f.tv_ok);
        this.bPK.setOnClickListener(this);
        this.ofp.setOnClickListener(this);
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
        return LayoutInflater.from(this.bNY).inflate(a.g.yuyin_layout_dialog_connnection_wheat_end, (ViewGroup) null);
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
        } else if (view == this.ofp) {
            dismiss();
        }
    }

    public void c(String str, String str2, String str3, int i, int i2) {
        this.ofl.setIsRound(true);
        this.ofl.setAutoChangeStyle(false);
        this.ofl.setDefaultResource(a.e.yuyin_sdk_default_avatar);
        if (this.ofl != null && !TextUtils.isEmpty(str)) {
            this.ofl.setUrl(str);
            this.ofl.startLoad(str, 12, false);
        }
        if (this.ewx != null) {
            if (!TextUtils.isEmpty(str2)) {
                this.ewx.setText(str2);
            } else {
                this.ewx.setText("");
            }
        }
        if (this.ofm != null) {
            if (!TextUtils.isEmpty(str3)) {
                this.ofm.setText(str3);
            } else {
                this.ofm.setText("");
            }
        }
        if (this.ofn != null) {
            if (!TextUtils.isEmpty(Integer.toString(i))) {
                this.ofn.setText(Integer.toString(i));
            } else {
                this.ofn.setText("");
            }
        }
        if (this.ofo != null) {
            if (!TextUtils.isEmpty(Integer.toString(i2))) {
                this.ofo.setText(Integer.toString(i2));
            } else {
                this.ofo.setText("");
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bek);
    }
}
