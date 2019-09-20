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
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
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
    private LinearLayout bOF;
    private CustomMessageListener bOJ = new CustomMessageListener(2001304) { // from class: com.baidu.tieba.transmitShare.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.cnc();
                c.this.f(c.this.jwk);
            }
        }
    };
    private TextView iYe;
    private b jwi;
    private boolean jwj;
    private ShareDialogConfig jwk;
    private Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private TextView mTitle;
    private static final int jwl = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds130);
    private static final int jwm = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
    private static final int jwn = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds34);
    private static final int iPN = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44);

    public c(Context context) {
        this.mContext = context;
        this.bOF = new LinearLayout(context);
        this.bOF.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, jwn);
        this.mTitle.setPadding(jwm, 0, jwm, 0);
        this.mTitle.setGravity(17);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (TextUtils.isEmpty(sharePanelText)) {
            this.mTitle.setText(R.string.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(sharePanelText);
        }
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, jwl));
        this.bOF.addView(this.mTitle);
        this.jwi = new b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ShareGridLayout.jwb;
        layoutParams.rightMargin = ShareGridLayout.jwb;
        this.bOF.addView(this.jwi.cul(), layoutParams);
        this.iYe = new TextView(context);
        this.iYe.setTextSize(0, iPN);
        this.iYe.setGravity(17);
        this.iYe.setText(R.string.cancel);
        this.iYe.setLayoutParams(new LinearLayout.LayoutParams(-1, jwl));
        this.iYe.setOnClickListener(this);
        this.bOF.addView(this.iYe);
        this.jwi.a(this);
    }

    public void f(ShareDialogConfig shareDialogConfig) {
        if (!TextUtils.isEmpty(shareDialogConfig.shareItem.clK)) {
            shareDialogConfig.shareItem.content = shareDialogConfig.shareItem.clK;
        }
        this.jwi.a(shareDialogConfig, this.jwj);
        this.jwk = shareDialogConfig;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void rD(boolean z) {
        this.jwj = z;
    }

    public void show() {
        cnc();
        this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.transmitShare.c.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mOnDismissListener != null) {
                    c.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (c.this.jwi != null) {
                    c.this.jwi.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.mDialog, (Activity) this.mContext);
        }
        am.k(this.bOF, R.drawable.transmit_share_dialog_background);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.bOF);
            window.setBackgroundDrawable(am.getDrawable(R.drawable.transmit_share_dialog_background));
            aMb();
            i.ab(this.mContext).registerListener(this.bOJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnc() {
        am.k(this.bOF, R.drawable.transmit_share_dialog_background);
        am.j(this.mTitle, R.color.cp_cont_c);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (TextUtils.isEmpty(sharePanelText)) {
            this.mTitle.setText(R.string.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(sharePanelText);
        }
        am.f(this.iYe, R.color.cp_cont_j, 1);
    }

    private void aMb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.transmitShare.c.3
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
            MessageManager.getInstance().unRegisterListener(this.bOJ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iYe) {
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
