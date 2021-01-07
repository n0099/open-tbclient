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
/* loaded from: classes11.dex */
public class e extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private View bYQ;
    public CustomMessageListener bih;
    private TextView eLt;
    private HeadImageView oCD;
    private TextView oCE;
    private TextView oCF;
    private TextView oCG;
    private TextView oCH;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e.1
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
        this.bYQ = findViewById(a.f.view);
        this.oCD = (HeadImageView) findViewById(a.f.user_avatar);
        this.eLt = (TextView) findViewById(a.f.user_name);
        this.oCE = (TextView) findViewById(a.f.tv_connection_wheat_time);
        this.oCF = (TextView) findViewById(a.f.tv_new_fans_num);
        this.oCG = (TextView) findViewById(a.f.tv_charm_earnings);
        this.oCH = (TextView) findViewById(a.f.tv_ok);
        this.bYQ.setOnClickListener(this);
        this.oCH.setOnClickListener(this);
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
        } else if (view == this.oCH) {
            dismiss();
        }
    }

    public void d(String str, String str2, String str3, int i, int i2) {
        this.oCD.setIsRound(true);
        this.oCD.setAutoChangeStyle(false);
        this.oCD.setDefaultResource(a.e.yuyin_sdk_default_avatar);
        if (this.oCD != null && !TextUtils.isEmpty(str)) {
            this.oCD.setUrl(str);
            this.oCD.startLoad(str, 12, false);
        }
        if (this.eLt != null) {
            if (!TextUtils.isEmpty(str2)) {
                this.eLt.setText(str2);
            } else {
                this.eLt.setText("");
            }
        }
        if (this.oCE != null) {
            if (!TextUtils.isEmpty(str3)) {
                this.oCE.setText(str3);
            } else {
                this.oCE.setText("");
            }
        }
        if (this.oCF != null) {
            if (!TextUtils.isEmpty(Integer.toString(i))) {
                this.oCF.setText(Integer.toString(i));
            } else {
                this.oCF.setText("");
            }
        }
        if (this.oCG != null) {
            if (!TextUtils.isEmpty(Integer.toString(i2))) {
                this.oCG.setText(Integer.toString(i2));
            } else {
                this.oCG.setText("");
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bih);
    }
}
