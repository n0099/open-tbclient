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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class c implements View.OnClickListener, a {
    private TextView lBI;
    private Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private LinearLayout mRootView;
    private TextView mTitle;
    private b maR;
    private boolean maS;
    private ShareDialogConfig maT;
    private CustomMessageListener skinChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.transmitShare.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dht();
                c.this.g(c.this.maT);
            }
        }
    };
    private static final int maU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds130);
    private static final int maV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
    private static final int maW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds34);
    private static final int eUa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);

    public c(Context context) {
        this.mContext = context;
        this.mRootView = new LinearLayout(context);
        this.mRootView.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, maW);
        this.mTitle.setPadding(maV, 0, maV, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, maU));
        this.mRootView.addView(this.mTitle);
        this.maR = new b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ShareGridLayout.maL;
        layoutParams.rightMargin = ShareGridLayout.maL;
        this.mRootView.addView(this.maR.doS(), layoutParams);
        this.lBI = new TextView(context);
        this.lBI.setTextSize(0, eUa);
        this.lBI.setGravity(17);
        this.lBI.setText(R.string.cancel);
        this.lBI.setLayoutParams(new LinearLayout.LayoutParams(-1, maU));
        this.lBI.setOnClickListener(this);
        this.mRootView.addView(this.lBI);
        this.maR.a(this);
    }

    public void g(ShareDialogConfig shareDialogConfig) {
        if (!TextUtils.isEmpty(shareDialogConfig.shareItem.etQ)) {
            shareDialogConfig.shareItem.content = shareDialogConfig.shareItem.etQ;
        }
        if (!shareDialogConfig.shareItem.eud) {
            this.mTitle.setText(R.string.transmit_share_no_outer);
        } else {
            String sharePanelText = TbSingleton.getInstance().getSharePanelText();
            if (!TextUtils.isEmpty(sharePanelText)) {
                this.mTitle.setText(sharePanelText);
            } else {
                this.mTitle.setText(R.string.transmit_share_not_add_experience);
            }
        }
        this.maR.a(shareDialogConfig, this.maS);
        this.maT = shareDialogConfig;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void vH(boolean z) {
        this.maS = z;
    }

    public void show() {
        dht();
        this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.transmitShare.c.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mOnDismissListener != null) {
                    c.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS);
                if (c.this.maR != null) {
                    c.this.maR.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.showDialog(this.mDialog, (Activity) this.mContext);
        }
        ao.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            bBM();
            i.G(this.mContext).registerListener(this.skinChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dht() {
        ao.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_c);
        ao.setViewTextColor(this.lBI, R.color.cp_cont_j, 1);
    }

    private void bBM() {
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
            MessageManager.getInstance().unRegisterListener(this.skinChangeListener);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lBI) {
            h("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.transmitShare.a
    public void dl(View view) {
        dismiss();
    }

    public void b(ShareDialogConfig.From from) {
        aa sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bej() && !as.isEmpty(sharePanelConfData.getText())) {
            this.mTitle.setText(sharePanelConfData.getText());
        }
    }
}
