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
    private View bTg;
    public CustomMessageListener bgy;
    private TextView eBQ;
    private HeadImageView ovO;
    private TextView ovP;
    private TextView ovQ;
    private TextView ovR;
    private TextView ovS;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e.1
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
        this.bTg = findViewById(a.f.view);
        this.ovO = (HeadImageView) findViewById(a.f.user_avatar);
        this.eBQ = (TextView) findViewById(a.f.user_name);
        this.ovP = (TextView) findViewById(a.f.tv_connection_wheat_time);
        this.ovQ = (TextView) findViewById(a.f.tv_new_fans_num);
        this.ovR = (TextView) findViewById(a.f.tv_charm_earnings);
        this.ovS = (TextView) findViewById(a.f.tv_ok);
        this.bTg.setOnClickListener(this);
        this.ovS.setOnClickListener(this);
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
        return LayoutInflater.from(this.beD).inflate(a.g.yuyin_layout_dialog_connnection_wheat_end, (ViewGroup) null);
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
        } else if (view == this.ovS) {
            dismiss();
        }
    }

    public void c(String str, String str2, String str3, int i, int i2) {
        this.ovO.setIsRound(true);
        this.ovO.setAutoChangeStyle(false);
        this.ovO.setDefaultResource(a.e.yuyin_sdk_default_avatar);
        if (this.ovO != null && !TextUtils.isEmpty(str)) {
            this.ovO.setUrl(str);
            this.ovO.startLoad(str, 12, false);
        }
        if (this.eBQ != null) {
            if (!TextUtils.isEmpty(str2)) {
                this.eBQ.setText(str2);
            } else {
                this.eBQ.setText("");
            }
        }
        if (this.ovP != null) {
            if (!TextUtils.isEmpty(str3)) {
                this.ovP.setText(str3);
            } else {
                this.ovP.setText("");
            }
        }
        if (this.ovQ != null) {
            if (!TextUtils.isEmpty(Integer.toString(i))) {
                this.ovQ.setText(Integer.toString(i));
            } else {
                this.ovQ.setText("");
            }
        }
        if (this.ovR != null) {
            if (!TextUtils.isEmpty(Integer.toString(i2))) {
                this.ovR.setText(Integer.toString(i2));
            } else {
                this.ovR.setText("");
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bgy);
    }
}
