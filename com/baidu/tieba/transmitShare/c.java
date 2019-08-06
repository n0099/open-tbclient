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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c implements View.OnClickListener, a {
    private LinearLayout bOg;
    private TextView iVJ;
    private b jtN;
    private boolean jtO;
    private Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private TextView mTitle;
    private static final int jtP = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds130);
    private static final int jtQ = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
    private static final int jtR = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds34);
    private static final int iNr = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44);

    public c(Context context) {
        this.mContext = context;
        this.bOg = new LinearLayout(context);
        this.bOg.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, jtR);
        this.mTitle.setPadding(jtQ, 0, jtQ, 0);
        this.mTitle.setGravity(17);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (TextUtils.isEmpty(sharePanelText)) {
            this.mTitle.setText(R.string.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(sharePanelText);
        }
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, jtP));
        this.bOg.addView(this.mTitle);
        this.jtN = new b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ShareGridLayout.jtG;
        layoutParams.rightMargin = ShareGridLayout.jtG;
        this.bOg.addView(this.jtN.ctx(), layoutParams);
        this.iVJ = new TextView(context);
        this.iVJ.setTextSize(0, iNr);
        this.iVJ.setGravity(17);
        this.iVJ.setText(R.string.cancel);
        this.iVJ.setLayoutParams(new LinearLayout.LayoutParams(-1, jtP));
        this.iVJ.setOnClickListener(this);
        this.bOg.addView(this.iVJ);
        this.jtN.a(this);
    }

    public void f(ShareDialogConfig shareDialogConfig) {
        if (!TextUtils.isEmpty(shareDialogConfig.shareItem.ckP)) {
            shareDialogConfig.shareItem.content = shareDialogConfig.shareItem.ckP;
        }
        this.jtN.a(shareDialogConfig, this.jtO);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void rA(boolean z) {
        this.jtO = z;
    }

    public void show() {
        cmq();
        this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.transmitShare.c.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mOnDismissListener != null) {
                    c.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (c.this.jtN != null) {
                    c.this.jtN.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.mDialog, (Activity) this.mContext);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.bOg.setBackgroundResource(R.drawable.transmit_share_dialog_background_1);
        } else {
            this.bOg.setBackgroundResource(R.drawable.transmit_share_dialog_background);
        }
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.bOg);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                window.setBackgroundDrawableResource(R.drawable.transmit_share_dialog_background_1);
            } else {
                window.setBackgroundDrawableResource(R.drawable.transmit_share_dialog_background);
            }
            aLx();
        }
    }

    private void cmq() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            am.k(this.bOg, R.drawable.transmit_share_dialog_background_1);
        } else {
            am.k(this.bOg, R.drawable.transmit_share_dialog_background);
        }
        am.j(this.mTitle, R.color.cp_cont_c);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (TextUtils.isEmpty(sharePanelText)) {
            this.mTitle.setText(R.string.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(sharePanelText);
        }
        am.f(this.iVJ, R.color.cp_cont_j, 1);
    }

    private void aLx() {
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
        if (view == this.iVJ) {
            k("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void k(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.transmitShare.a
    public void cW(View view) {
        dismiss();
    }
}
