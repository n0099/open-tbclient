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
    private View bOa;
    public CustomMessageListener bcy;
    private TextView euO;
    private HeadImageView ogO;
    private TextView ogP;
    private TextView ogQ;
    private TextView ogR;
    private TextView ogS;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e.1
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
        this.bOa = findViewById(a.f.view);
        this.ogO = (HeadImageView) findViewById(a.f.user_avatar);
        this.euO = (TextView) findViewById(a.f.user_name);
        this.ogP = (TextView) findViewById(a.f.tv_connection_wheat_time);
        this.ogQ = (TextView) findViewById(a.f.tv_new_fans_num);
        this.ogR = (TextView) findViewById(a.f.tv_charm_earnings);
        this.ogS = (TextView) findViewById(a.f.tv_ok);
        this.bOa.setOnClickListener(this);
        this.ogS.setOnClickListener(this);
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
        return LayoutInflater.from(this.bMo).inflate(a.g.yuyin_layout_dialog_connnection_wheat_end, (ViewGroup) null);
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
        } else if (view == this.ogS) {
            dismiss();
        }
    }

    public void c(String str, String str2, String str3, int i, int i2) {
        this.ogO.setIsRound(true);
        this.ogO.setAutoChangeStyle(false);
        this.ogO.setDefaultResource(a.e.yuyin_sdk_default_avatar);
        if (this.ogO != null && !TextUtils.isEmpty(str)) {
            this.ogO.setUrl(str);
            this.ogO.startLoad(str, 12, false);
        }
        if (this.euO != null) {
            if (!TextUtils.isEmpty(str2)) {
                this.euO.setText(str2);
            } else {
                this.euO.setText("");
            }
        }
        if (this.ogP != null) {
            if (!TextUtils.isEmpty(str3)) {
                this.ogP.setText(str3);
            } else {
                this.ogP.setText("");
            }
        }
        if (this.ogQ != null) {
            if (!TextUtils.isEmpty(Integer.toString(i))) {
                this.ogQ.setText(Integer.toString(i));
            } else {
                this.ogQ.setText("");
            }
        }
        if (this.ogR != null) {
            if (!TextUtils.isEmpty(Integer.toString(i2))) {
                this.ogR.setText(Integer.toString(i2));
            } else {
                this.ogR.setText("");
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bcy);
    }
}
