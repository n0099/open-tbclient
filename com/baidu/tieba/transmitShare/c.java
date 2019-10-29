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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c implements View.OnClickListener, a {
    private CustomMessageListener cfN = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.transmitShare.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.ckR();
                c.this.f(c.this.jwc);
            }
        }
    };
    private TextView iXT;
    private b jwa;
    private boolean jwb;
    private ShareDialogConfig jwc;
    private Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private LinearLayout mRootView;
    private TextView mTitle;
    private static final int jwd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds130);
    private static final int jwe = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
    private static final int aeX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds34);
    private static final int iOJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);

    public c(Context context) {
        this.mContext = context;
        this.mRootView = new LinearLayout(context);
        this.mRootView.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, aeX);
        this.mTitle.setPadding(jwe, 0, jwe, 0);
        this.mTitle.setGravity(17);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (TextUtils.isEmpty(sharePanelText)) {
            this.mTitle.setText(R.string.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(sharePanelText);
        }
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, jwd));
        this.mRootView.addView(this.mTitle);
        this.jwa = new b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ShareGridLayout.jvT;
        layoutParams.rightMargin = ShareGridLayout.jvT;
        this.mRootView.addView(this.jwa.csa(), layoutParams);
        this.iXT = new TextView(context);
        this.iXT.setTextSize(0, iOJ);
        this.iXT.setGravity(17);
        this.iXT.setText(R.string.cancel);
        this.iXT.setLayoutParams(new LinearLayout.LayoutParams(-1, jwd));
        this.iXT.setOnClickListener(this);
        this.mRootView.addView(this.iXT);
        this.jwa.a(this);
    }

    public void f(ShareDialogConfig shareDialogConfig) {
        if (!TextUtils.isEmpty(shareDialogConfig.shareItem.cyK)) {
            shareDialogConfig.shareItem.content = shareDialogConfig.shareItem.cyK;
        }
        this.jwa.a(shareDialogConfig, this.jwb);
        this.jwc = shareDialogConfig;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void rm(boolean z) {
        this.jwb = z;
    }

    public void show() {
        ckR();
        this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.transmitShare.c.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mOnDismissListener != null) {
                    c.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS);
                if (c.this.jwa != null) {
                    c.this.jwa.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.showDialog(this.mDialog, (Activity) this.mContext);
        }
        am.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            window.setBackgroundDrawable(am.getDrawable(R.drawable.transmit_share_dialog_background));
            aMl();
            i.ab(this.mContext).registerListener(this.cfN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckR() {
        am.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (TextUtils.isEmpty(sharePanelText)) {
            this.mTitle.setText(R.string.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(sharePanelText);
        }
        am.setViewTextColor(this.iXT, R.color.cp_cont_j, 1);
    }

    private void aMl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.transmitShare.c.3
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
            g.dismissDialog(this.mDialog, (Activity) this.mContext);
            MessageManager.getInstance().unRegisterListener(this.cfN);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iXT) {
            j("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void j(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.transmitShare.a
    public void cS(View view) {
        dismiss();
    }
}
