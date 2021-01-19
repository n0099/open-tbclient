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
    private View bUe;
    public CustomMessageListener bdo;
    private TextView eGI;
    private HeadImageView oxZ;
    private TextView oya;
    private TextView oyb;
    private TextView oyc;
    private TextView oyd;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.e.1
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
        this.bUe = findViewById(a.f.view);
        this.oxZ = (HeadImageView) findViewById(a.f.user_avatar);
        this.eGI = (TextView) findViewById(a.f.user_name);
        this.oya = (TextView) findViewById(a.f.tv_connection_wheat_time);
        this.oyb = (TextView) findViewById(a.f.tv_new_fans_num);
        this.oyc = (TextView) findViewById(a.f.tv_charm_earnings);
        this.oyd = (TextView) findViewById(a.f.tv_ok);
        this.bUe.setOnClickListener(this);
        this.oyd.setOnClickListener(this);
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
        } else if (view == this.oyd) {
            dismiss();
        }
    }

    public void d(String str, String str2, String str3, int i, int i2) {
        this.oxZ.setIsRound(true);
        this.oxZ.setAutoChangeStyle(false);
        this.oxZ.setDefaultResource(a.e.yuyin_sdk_default_avatar);
        if (this.oxZ != null && !TextUtils.isEmpty(str)) {
            this.oxZ.setUrl(str);
            this.oxZ.startLoad(str, 12, false);
        }
        if (this.eGI != null) {
            if (!TextUtils.isEmpty(str2)) {
                this.eGI.setText(str2);
            } else {
                this.eGI.setText("");
            }
        }
        if (this.oya != null) {
            if (!TextUtils.isEmpty(str3)) {
                this.oya.setText(str3);
            } else {
                this.oya.setText("");
            }
        }
        if (this.oyb != null) {
            if (!TextUtils.isEmpty(Integer.toString(i))) {
                this.oyb.setText(Integer.toString(i));
            } else {
                this.oyb.setText("");
            }
        }
        if (this.oyc != null) {
            if (!TextUtils.isEmpty(Integer.toString(i2))) {
                this.oyc.setText(Integer.toString(i2));
            } else {
                this.oyc.setText("");
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bdo);
    }
}
