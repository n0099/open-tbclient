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
    private TextView bZE;
    private TextView bZF;
    public CustomMessageListener bhY;
    private TextView mTitle;
    private a oKD;

    /* loaded from: classes10.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.1
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
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.1
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
        this.bZE = (TextView) findViewById(a.f.tv_cancel);
        this.bZF = (TextView) findViewById(a.f.tv_confirm);
    }

    private void initListener() {
        this.bZE.setOnClickListener(this);
        this.bZF.setOnClickListener(this);
    }

    public void setText(String str) {
        if (this.mTitle != null && !TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void VW(String str) {
        if (this.bZE != null && !TextUtils.isEmpty(str)) {
            this.bZE.setText(str);
        }
    }

    public void ce(String str, int i) {
        if (this.bZE != null && !TextUtils.isEmpty(str)) {
            this.bZE.setText(str);
            this.bZE.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(i));
        }
    }

    public void cf(String str, int i) {
        if (this.bZF != null) {
            this.bZF.setText(str);
            this.bZF.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(i));
        }
    }

    public void eet() {
        if (this.bZF != null) {
            this.bZF.getPaint().setFakeBoldText(true);
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
        initListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bZE) {
            dismiss();
            if (this.oKD != null) {
                this.oKD.onCancel();
            }
        } else if (view == this.bZF) {
            dismiss();
            if (this.oKD != null) {
                this.oKD.onConfirm();
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bhY);
    }

    public void a(a aVar) {
        this.oKD = aVar;
    }
}
