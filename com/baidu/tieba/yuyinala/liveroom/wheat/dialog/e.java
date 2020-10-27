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
    private View bKe;
    public CustomMessageListener bcQ;
    private TextView eqE;
    private HeadImageView nXS;
    private TextView nXT;
    private TextView nXU;
    private TextView nXV;
    private TextView nXW;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e.1
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
        this.bKe = findViewById(a.g.view);
        this.nXS = (HeadImageView) findViewById(a.g.user_avatar);
        this.eqE = (TextView) findViewById(a.g.user_name);
        this.nXT = (TextView) findViewById(a.g.tv_connection_wheat_time);
        this.nXU = (TextView) findViewById(a.g.tv_new_fans_num);
        this.nXV = (TextView) findViewById(a.g.tv_charm_earnings);
        this.nXW = (TextView) findViewById(a.g.tv_ok);
        this.bKe.setOnClickListener(this);
        this.nXW.setOnClickListener(this);
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
        return LayoutInflater.from(this.bIs).inflate(a.h.yuyin_layout_dialog_connnection_wheat_end, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean QG() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean QH() {
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
        MessageManager.getInstance().registerListener(this.bcQ);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bKe) {
            dismiss();
        } else if (view == this.nXW) {
            dismiss();
        }
    }

    public void c(String str, String str2, String str3, int i, int i2) {
        this.nXS.setIsRound(true);
        this.nXS.setAutoChangeStyle(false);
        this.nXS.setDefaultResource(a.f.yuyin_sdk_default_avatar);
        if (this.nXS != null && !TextUtils.isEmpty(str)) {
            this.nXS.setUrl(str);
            this.nXS.startLoad(str, 12, false);
        }
        if (this.eqE != null) {
            if (!TextUtils.isEmpty(str2)) {
                this.eqE.setText(str2);
            } else {
                this.eqE.setText("");
            }
        }
        if (this.nXT != null) {
            if (!TextUtils.isEmpty(str3)) {
                this.nXT.setText(str3);
            } else {
                this.nXT.setText("");
            }
        }
        if (this.nXU != null) {
            if (!TextUtils.isEmpty(Integer.toString(i))) {
                this.nXU.setText(Integer.toString(i));
            } else {
                this.nXU.setText("");
            }
        }
        if (this.nXV != null) {
            if (!TextUtils.isEmpty(Integer.toString(i2))) {
                this.nXV.setText(Integer.toString(i2));
            } else {
                this.nXV.setText("");
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bcQ);
    }
}
