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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c implements View.OnClickListener, a {
    private CustomMessageListener cRD = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.transmitShare.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.cGb();
                c.this.g(c.this.ksW);
            }
        }
    };
    private TextView jUZ;
    private b ksU;
    private boolean ksV;
    private ShareDialogConfig ksW;
    private Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private LinearLayout mRootView;
    private TextView mTitle;
    private static final int ksX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds130);
    private static final int ksY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
    private static final int ant = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds34);
    private static final int dJZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);

    public c(Context context) {
        this.mContext = context;
        this.mRootView = new LinearLayout(context);
        this.mRootView.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, ant);
        this.mTitle.setPadding(ksY, 0, ksY, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, ksX));
        this.mRootView.addView(this.mTitle);
        this.ksU = new b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ShareGridLayout.ksN;
        layoutParams.rightMargin = ShareGridLayout.ksN;
        this.mRootView.addView(this.ksU.cNf(), layoutParams);
        this.jUZ = new TextView(context);
        this.jUZ.setTextSize(0, dJZ);
        this.jUZ.setGravity(17);
        this.jUZ.setText(R.string.cancel);
        this.jUZ.setLayoutParams(new LinearLayout.LayoutParams(-1, ksX));
        this.jUZ.setOnClickListener(this);
        this.mRootView.addView(this.jUZ);
        this.ksU.a(this);
    }

    public void g(ShareDialogConfig shareDialogConfig) {
        if (!TextUtils.isEmpty(shareDialogConfig.shareItem.dlS)) {
            shareDialogConfig.shareItem.content = shareDialogConfig.shareItem.dlS;
        }
        if (!shareDialogConfig.shareItem.dmf) {
            this.mTitle.setText(R.string.transmit_share_no_outer);
        } else {
            String sharePanelText = TbSingleton.getInstance().getSharePanelText();
            if (!TextUtils.isEmpty(sharePanelText)) {
                this.mTitle.setText(sharePanelText);
            } else {
                this.mTitle.setText(R.string.transmit_share_not_add_experience);
            }
        }
        this.ksU.a(shareDialogConfig, this.ksV);
        this.ksW = shareDialogConfig;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void tf(boolean z) {
        this.ksV = z;
    }

    public void show() {
        cGb();
        this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.transmitShare.c.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mOnDismissListener != null) {
                    c.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS);
                if (c.this.ksU != null) {
                    c.this.ksU.release();
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
            bec();
            i.ab(this.mContext).registerListener(this.cRD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGb() {
        am.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.jUZ, R.color.cp_cont_j, 1);
    }

    private void bec() {
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
            MessageManager.getInstance().unRegisterListener(this.cRD);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jUZ) {
            h("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.transmitShare.a
    public void cT(View view) {
        dismiss();
    }

    public void b(ShareDialogConfig.From from) {
        w sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.aHg() && !aq.isEmpty(sharePanelConfData.getText())) {
            this.mTitle.setText(sharePanelConfData.getText());
        }
    }
}
