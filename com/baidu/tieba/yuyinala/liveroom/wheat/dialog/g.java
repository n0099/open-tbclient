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
    private TextView bYe;
    private TextView bYf;
    public CustomMessageListener bgy;
    private TextView mTitle;
    private a oIy;

    /* loaded from: classes11.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.1
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
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.1
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
        this.bYe = (TextView) findViewById(a.f.tv_cancel);
        this.bYf = (TextView) findViewById(a.f.tv_confirm);
    }

    private void initListener() {
        this.bYe.setOnClickListener(this);
        this.bYf.setOnClickListener(this);
    }

    public void setText(String str) {
        if (this.mTitle != null && !TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void VP(String str) {
        if (this.bYe != null && !TextUtils.isEmpty(str)) {
            this.bYe.setText(str);
        }
    }

    public void ce(String str, int i) {
        if (this.bYe != null && !TextUtils.isEmpty(str)) {
            this.bYe.setText(str);
            this.bYe.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(i));
        }
    }

    public void cf(String str, int i) {
        if (this.bYf != null) {
            this.bYf.setText(str);
            this.bYf.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(i));
        }
    }

    public void eel() {
        if (this.bYf != null) {
            this.bYf.getPaint().setFakeBoldText(true);
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
        initListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bYe) {
            dismiss();
            if (this.oIy != null) {
                this.oIy.onCancel();
            }
        } else if (view == this.bYf) {
            dismiss();
            if (this.oIy != null) {
                this.oIy.onConfirm();
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bgy);
    }

    public void a(a aVar) {
        this.oIy = aVar;
    }
}
