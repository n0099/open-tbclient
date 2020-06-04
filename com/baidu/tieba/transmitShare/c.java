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
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class c implements View.OnClickListener, a {
    private CustomMessageListener dJe = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.transmitShare.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.cZT();
                c.this.g(c.this.lzV);
            }
        }
    };
    private TextView lau;
    private b lzT;
    private boolean lzU;
    private ShareDialogConfig lzV;
    private Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private LinearLayout mRootView;
    private TextView mTitle;
    private static final int lzW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds130);
    private static final int lzX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
    private static final int lzY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds34);
    private static final int eDv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);

    public c(Context context) {
        this.mContext = context;
        this.mRootView = new LinearLayout(context);
        this.mRootView.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, lzY);
        this.mTitle.setPadding(lzX, 0, lzX, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, lzW));
        this.mRootView.addView(this.mTitle);
        this.lzT = new b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ShareGridLayout.lzN;
        layoutParams.rightMargin = ShareGridLayout.lzN;
        this.mRootView.addView(this.lzT.dhx(), layoutParams);
        this.lau = new TextView(context);
        this.lau.setTextSize(0, eDv);
        this.lau.setGravity(17);
        this.lau.setText(R.string.cancel);
        this.lau.setLayoutParams(new LinearLayout.LayoutParams(-1, lzW));
        this.lau.setOnClickListener(this);
        this.mRootView.addView(this.lau);
        this.lzT.a(this);
    }

    public void g(ShareDialogConfig shareDialogConfig) {
        if (!TextUtils.isEmpty(shareDialogConfig.shareItem.eeT)) {
            shareDialogConfig.shareItem.content = shareDialogConfig.shareItem.eeT;
        }
        if (!shareDialogConfig.shareItem.efg) {
            this.mTitle.setText(R.string.transmit_share_no_outer);
        } else {
            String sharePanelText = TbSingleton.getInstance().getSharePanelText();
            if (!TextUtils.isEmpty(sharePanelText)) {
                this.mTitle.setText(sharePanelText);
            } else {
                this.mTitle.setText(R.string.transmit_share_not_add_experience);
            }
        }
        this.lzT.a(shareDialogConfig, this.lzU);
        this.lzV = shareDialogConfig;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void uO(boolean z) {
        this.lzU = z;
    }

    public void show() {
        cZT();
        this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.transmitShare.c.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mOnDismissListener != null) {
                    c.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS);
                if (c.this.lzT != null) {
                    c.this.lzT.release();
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
            bvC();
            i.G(this.mContext).registerListener(this.dJe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZT() {
        am.setBackgroundResource(this.mRootView, R.drawable.transmit_share_dialog_background);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.lau, R.color.cp_cont_j, 1);
    }

    private void bvC() {
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
            MessageManager.getInstance().unRegisterListener(this.dJe);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lau) {
            h("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.transmitShare.a
    public void de(View view) {
        dismiss();
    }

    public void b(ShareDialogConfig.From from) {
        y sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.aYh() && !aq.isEmpty(sharePanelConfData.getText())) {
            this.mTitle.setText(sharePanelConfData.getText());
        }
    }
}
