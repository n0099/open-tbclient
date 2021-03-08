package com.baidu.tieba.transmitShare;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.baidu.adp.base.j;
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
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.ae;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class c implements View.OnClickListener, a {
    private static final int nLK = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds130);
    private static final int nLL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
    private static final int nLM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
    private static final int nLN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
    private static final int nLO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    private static final int nLP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X08);
    private static final int nLQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X06);
    private static final int nLR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    private float eXb = 0.33f;
    private CustomMessageListener eXe = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.transmitShare.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dJJ();
                c.this.g(c.this.nLJ);
            }
        }
    };
    private EMTextView jwO;
    private View lZc;
    private Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private LinearLayout mRootView;
    private b nLH;
    private boolean nLI;
    private ShareDialogConfig nLJ;
    private EMTextView nnM;

    public c(Context context) {
        this.mContext = context;
        this.mRootView = new LinearLayout(context);
        this.mRootView.setOrientation(1);
        this.jwO = new EMTextView(context);
        this.jwO.setTextSize(0, nLP);
        this.jwO.setPadding(nLL, nLM, nLL, nLN);
        this.jwO.setGravity(1);
        this.jwO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mRootView.addView(this.jwO);
        this.nLH = new b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ShareGridLayout.nLB;
        layoutParams.rightMargin = ShareGridLayout.nLB;
        this.mRootView.addView(this.nLH.dRG(), layoutParams);
        this.nnM = new EMTextView(context);
        this.nnM.setGravity(1);
        this.nnM.setTextSize(0, nLQ);
        this.nnM.setText(R.string.cancel);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = nLR;
        this.nnM.setLayoutParams(layoutParams2);
        this.nnM.setPadding(0, nLO, 0, nLO);
        this.nnM.setOnClickListener(this);
        this.mRootView.addView(this.nnM);
        this.lZc = new View(context);
        this.lZc.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.bottom_enter_anim_place_holder_height)));
        this.mRootView.addView(this.lZc);
        this.nLH.a(this);
    }

    public void g(ShareDialogConfig shareDialogConfig) {
        if (!TextUtils.isEmpty(shareDialogConfig.shareItem.fwu)) {
            shareDialogConfig.shareItem.content = shareDialogConfig.shareItem.fwu;
        }
        if (!shareDialogConfig.shareItem.fwH) {
            this.jwO.setText(R.string.transmit_share_no_outer);
        } else {
            String sharePanelText = TbSingleton.getInstance().getSharePanelText();
            if (!TextUtils.isEmpty(sharePanelText)) {
                this.jwO.setText(sharePanelText);
            } else {
                this.jwO.setText(R.string.transmit_share_not_add_experience);
            }
        }
        this.nLH.a(shareDialogConfig, this.nLI);
        this.nLJ = shareDialogConfig;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void yR(boolean z) {
        this.nLI = z;
    }

    public void show() {
        dJJ();
        this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.transmitShare.c.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mOnDismissListener != null) {
                    c.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS);
                if (c.this.nLH != null) {
                    c.this.nLH.release();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
            }
        });
        if (this.mContext instanceof Activity) {
            g.showDialog(this.mDialog, (Activity) this.mContext);
        }
        com.baidu.tbadk.core.elementsMaven.c.br(this.mRootView).oh(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mRootView);
            window.setDimAmount(this.eXb);
            bXf();
            j.J(this.mContext).registerListener(this.eXe);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJJ() {
        com.baidu.tbadk.core.elementsMaven.c.br(this.mRootView).oh(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ap.setViewTextColor(this.jwO, R.color.CAM_X0109);
        ap.n(this.nnM, R.color.CAM_X0107);
    }

    private void bXf() {
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
            MessageManager.getInstance().unRegisterListener(this.eXe);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nnM) {
            f("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.transmitShare.a
    public void el(View view) {
        dismiss();
    }

    public void b(ShareDialogConfig.From from) {
        ae sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bwC() && !au.isEmpty(sharePanelConfData.getText())) {
            this.jwO.setText(sharePanelConfData.getText());
        }
    }
}
