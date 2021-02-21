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
/* loaded from: classes8.dex */
public class c implements View.OnClickListener, a {
    private static final int nJF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds130);
    private static final int nJG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
    private static final int nJH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
    private static final int nJI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
    private static final int nJJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    private static final int nJK = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X08);
    private static final int nJL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X06);
    private static final int nJM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    private float eVC = 0.33f;
    private CustomMessageListener eVF = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.transmitShare.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dJB();
                c.this.g(c.this.nJE);
            }
        }
    };
    private EMTextView jvf;
    private View lXa;
    private Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private LinearLayout mRootView;
    private b nJC;
    private boolean nJD;
    private ShareDialogConfig nJE;
    private EMTextView nlI;

    public c(Context context) {
        this.mContext = context;
        this.mRootView = new LinearLayout(context);
        this.mRootView.setOrientation(1);
        this.jvf = new EMTextView(context);
        this.jvf.setTextSize(0, nJK);
        this.jvf.setPadding(nJG, nJH, nJG, nJI);
        this.jvf.setGravity(1);
        this.jvf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mRootView.addView(this.jvf);
        this.nJC = new b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ShareGridLayout.nJw;
        layoutParams.rightMargin = ShareGridLayout.nJw;
        this.mRootView.addView(this.nJC.dRy(), layoutParams);
        this.nlI = new EMTextView(context);
        this.nlI.setGravity(1);
        this.nlI.setTextSize(0, nJL);
        this.nlI.setText(R.string.cancel);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = nJM;
        this.nlI.setLayoutParams(layoutParams2);
        this.nlI.setPadding(0, nJJ, 0, nJJ);
        this.nlI.setOnClickListener(this);
        this.mRootView.addView(this.nlI);
        this.lXa = new View(context);
        this.lXa.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.bottom_enter_anim_place_holder_height)));
        this.mRootView.addView(this.lXa);
        this.nJC.a(this);
    }

    public void g(ShareDialogConfig shareDialogConfig) {
        if (!TextUtils.isEmpty(shareDialogConfig.shareItem.fuV)) {
            shareDialogConfig.shareItem.content = shareDialogConfig.shareItem.fuV;
        }
        if (!shareDialogConfig.shareItem.fvi) {
            this.jvf.setText(R.string.transmit_share_no_outer);
        } else {
            String sharePanelText = TbSingleton.getInstance().getSharePanelText();
            if (!TextUtils.isEmpty(sharePanelText)) {
                this.jvf.setText(sharePanelText);
            } else {
                this.jvf.setText(R.string.transmit_share_not_add_experience);
            }
        }
        this.nJC.a(shareDialogConfig, this.nJD);
        this.nJE = shareDialogConfig;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void yS(boolean z) {
        this.nJD = z;
    }

    public void show() {
        dJB();
        this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.transmitShare.c.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mOnDismissListener != null) {
                    c.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS);
                if (c.this.nJC != null) {
                    c.this.nJC.release();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
            }
        });
        if (this.mContext instanceof Activity) {
            g.showDialog(this.mDialog, (Activity) this.mContext);
        }
        com.baidu.tbadk.core.elementsMaven.c.br(this.mRootView).og(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
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
            window.setDimAmount(this.eVC);
            bWZ();
            j.K(this.mContext).registerListener(this.eVF);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJB() {
        com.baidu.tbadk.core.elementsMaven.c.br(this.mRootView).og(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ap.setViewTextColor(this.jvf, R.color.CAM_X0109);
        ap.n(this.nlI, R.color.CAM_X0107);
    }

    private void bWZ() {
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
            MessageManager.getInstance().unRegisterListener(this.eVF);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nlI) {
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
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bwz() && !au.isEmpty(sharePanelConfData.getText())) {
            this.jvf.setText(sharePanelConfData.getText());
        }
    }
}
