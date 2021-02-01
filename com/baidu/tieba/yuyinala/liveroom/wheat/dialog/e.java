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
    private View bYd;
    public CustomMessageListener bgy;
    private TextView eIO;
    private HeadImageView oHG;
    private TextView oHH;
    private TextView oHI;
    private TextView oHJ;
    private TextView oHK;

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
        this.bYd = findViewById(a.f.view);
        this.oHG = (HeadImageView) findViewById(a.f.user_avatar);
        this.eIO = (TextView) findViewById(a.f.user_name);
        this.oHH = (TextView) findViewById(a.f.tv_connection_wheat_time);
        this.oHI = (TextView) findViewById(a.f.tv_new_fans_num);
        this.oHJ = (TextView) findViewById(a.f.tv_charm_earnings);
        this.oHK = (TextView) findViewById(a.f.tv_ok);
        this.bYd.setOnClickListener(this);
        this.oHK.setOnClickListener(this);
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
        } else if (view == this.oHK) {
            dismiss();
        }
    }

    public void d(String str, String str2, String str3, int i, int i2) {
        this.oHG.setIsRound(true);
        this.oHG.setAutoChangeStyle(false);
        this.oHG.setDefaultResource(a.e.yuyin_sdk_default_avatar);
        if (this.oHG != null && !TextUtils.isEmpty(str)) {
            this.oHG.setUrl(str);
            this.oHG.startLoad(str, 12, false);
        }
        if (this.eIO != null) {
            if (!TextUtils.isEmpty(str2)) {
                this.eIO.setText(str2);
            } else {
                this.eIO.setText("");
            }
        }
        if (this.oHH != null) {
            if (!TextUtils.isEmpty(str3)) {
                this.oHH.setText(str3);
            } else {
                this.oHH.setText("");
            }
        }
        if (this.oHI != null) {
            if (!TextUtils.isEmpty(Integer.toString(i))) {
                this.oHI.setText(Integer.toString(i));
            } else {
                this.oHI.setText("");
            }
        }
        if (this.oHJ != null) {
            if (!TextUtils.isEmpty(Integer.toString(i2))) {
                this.oHJ.setText(Integer.toString(i2));
            } else {
                this.oHJ.setText("");
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bgy);
    }
}
