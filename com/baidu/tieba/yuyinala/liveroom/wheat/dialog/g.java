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
/* loaded from: classes10.dex */
public class g extends com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private TextView bUf;
    private TextView bUg;
    public CustomMessageListener bdo;
    private TextView mTitle;
    private a oyq;

    /* loaded from: classes10.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.1
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
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.1
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
        this.bUf = (TextView) findViewById(a.f.tv_cancel);
        this.bUg = (TextView) findViewById(a.f.tv_confirm);
    }

    private void initListener() {
        this.bUf.setOnClickListener(this);
        this.bUg.setOnClickListener(this);
    }

    public void setText(String str) {
        if (this.mTitle != null && !TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void UE(String str) {
        if (this.bUf != null && !TextUtils.isEmpty(str)) {
            this.bUf.setText(str);
        }
    }

    public void cc(String str, int i) {
        if (this.bUf != null && !TextUtils.isEmpty(str)) {
            this.bUf.setText(str);
            this.bUf.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(i));
        }
    }

    public void cd(String str, int i) {
        if (this.bUg != null) {
            this.bUg.setText(str);
            this.bUg.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(i));
        }
    }

    public void ebP() {
        if (this.bUg != null) {
            this.bUg.getPaint().setFakeBoldText(true);
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
        initListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bUf) {
            dismiss();
            if (this.oyq != null) {
                this.oyq.onCancel();
            }
        } else if (view == this.bUg) {
            dismiss();
            if (this.oyq != null) {
                this.oyq.onConfirm();
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bdo);
    }

    public void a(a aVar) {
        this.oyq = aVar;
    }
}
