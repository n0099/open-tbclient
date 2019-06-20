package com.baidu.tieba.transmitShare;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c implements View.OnClickListener, a {
    private LinearLayout bNa;
    private TextView iOk;
    private boolean jmA;
    private b jmz;
    private Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private TextView mTitle;
    private static final int jmB = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds130);
    private static final int jmC = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
    private static final int jmD = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds34);
    private static final int iFV = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44);

    public c(Context context) {
        this.mContext = context;
        this.bNa = new LinearLayout(context);
        this.bNa.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, jmD);
        this.mTitle.setPadding(jmC, 0, jmC, 0);
        this.mTitle.setGravity(17);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (TextUtils.isEmpty(sharePanelText)) {
            this.mTitle.setText(R.string.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(sharePanelText);
        }
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, jmB));
        this.bNa.addView(this.mTitle);
        this.jmz = new b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ShareGridLayout.jms;
        layoutParams.rightMargin = ShareGridLayout.jms;
        this.bNa.addView(this.jmz.cqr(), layoutParams);
        this.iOk = new TextView(context);
        this.iOk.setTextSize(0, iFV);
        this.iOk.setGravity(17);
        this.iOk.setText(R.string.cancel);
        this.iOk.setLayoutParams(new LinearLayout.LayoutParams(-1, jmB));
        this.iOk.setOnClickListener(this);
        this.bNa.addView(this.iOk);
        this.jmz.a(this);
    }

    public void f(ShareDialogConfig shareDialogConfig) {
        if (!TextUtils.isEmpty(shareDialogConfig.shareItem.cjD)) {
            shareDialogConfig.shareItem.content = shareDialogConfig.shareItem.cjD;
        }
        this.jmz.a(shareDialogConfig, this.jmA);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void rm(boolean z) {
        this.jmA = z;
    }

    public void show() {
        cjh();
        this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.transmitShare.c.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mOnDismissListener != null) {
                    c.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (c.this.jmz != null) {
                    c.this.jmz.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.mDialog, (Activity) this.mContext);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.bNa.setBackgroundResource(R.drawable.transmit_share_dialog_background_1);
        } else {
            this.bNa.setBackgroundResource(R.drawable.transmit_share_dialog_background);
        }
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.bNa);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                window.setBackgroundDrawableResource(R.drawable.transmit_share_dialog_background_1);
            } else {
                window.setBackgroundDrawableResource(R.drawable.transmit_share_dialog_background);
            }
            aJQ();
        }
    }

    private void cjh() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            al.k(this.bNa, R.drawable.transmit_share_dialog_background_1);
        } else {
            al.k(this.bNa, R.drawable.transmit_share_dialog_background);
        }
        al.j(this.mTitle, R.color.cp_cont_c);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (TextUtils.isEmpty(sharePanelText)) {
            this.mTitle.setText(R.string.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(sharePanelText);
        }
        al.f(this.iOk, R.color.cp_cont_j, 1);
    }

    private void aJQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.transmitShare.c.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (c.this.mDialog != null && c.this.mDialog.isShowing()) {
                    c.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void dismiss() {
        if (this.mDialog != null && (this.mContext instanceof Activity)) {
            g.b(this.mDialog, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iOk) {
            k("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void k(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.transmitShare.a
    public void cR(View view) {
        dismiss();
    }
}
