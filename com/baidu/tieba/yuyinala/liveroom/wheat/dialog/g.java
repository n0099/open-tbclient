package com.baidu.tieba.yuyinala.liveroom.wheat.dialog;

import android.app.Activity;
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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class g extends com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private TextView bYR;
    private TextView bYS;
    public CustomMessageListener bih;
    private TextView mTitle;
    private a oCV;

    /* loaded from: classes11.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (g.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    g.this.dismiss();
                }
            }
        };
        g(this);
    }

    public g(Activity activity) {
        super(activity);
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (g.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    g.this.dismiss();
                }
            }
        };
    }

    private void initView() {
        this.mTitle = (TextView) findViewById(a.f.tv_title);
        this.bYR = (TextView) findViewById(a.f.tv_cancel);
        this.bYS = (TextView) findViewById(a.f.tv_confirm);
    }

    private void initListener() {
        this.bYR.setOnClickListener(this);
        this.bYS.setOnClickListener(this);
    }

    public void setText(String str) {
        if (this.mTitle != null && !TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void VM(String str) {
        if (this.bYR != null && !TextUtils.isEmpty(str)) {
            this.bYR.setText(str);
        }
    }

    public void cc(String str, int i) {
        if (this.bYR != null && !TextUtils.isEmpty(str)) {
            this.bYR.setText(str);
            this.bYR.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(i));
        }
    }

    public void cd(String str, int i) {
        if (this.bYS != null) {
            this.bYS.setText(str);
            this.bYS.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(i));
        }
    }

    public void efH() {
        if (this.bYS != null) {
            this.bYS.getPaint().setFakeBoldText(true);
        }
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
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_layout_dialog_connnection_wheat_remind, (ViewGroup) null);
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
        initListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bYR) {
            dismiss();
            if (this.oCV != null) {
                this.oCV.onCancel();
            }
        } else if (view == this.bYS) {
            dismiss();
            if (this.oCV != null) {
                this.oCV.onConfirm();
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bih);
    }

    public void a(a aVar) {
        this.oCV = aVar;
    }
}
