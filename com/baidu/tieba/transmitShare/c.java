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
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.ae;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class c implements View.OnClickListener, a {
    private static final int nzS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds130);
    private static final int nzT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
    private static final int nzU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
    private static final int nzV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
    private static final int nzW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    private static final int nzX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X08);
    private static final int nzY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X06);
    private static final int nzZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    private float eOa = 0.33f;
    private CustomMessageListener eOd = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.transmitShare.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dLk();
                c.this.g(c.this.nzR);
            }
        }
    };
    private EMTextView jhr;
    private View lNh;
    private Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private LinearLayout mRootView;
    private EMTextView naC;
    private b nzP;
    private boolean nzQ;
    private ShareDialogConfig nzR;

    public c(Context context) {
        this.mContext = context;
        this.mRootView = new LinearLayout(context);
        this.mRootView.setOrientation(1);
        this.jhr = new EMTextView(context);
        this.jhr.setTextSize(0, nzX);
        this.jhr.setPadding(nzT, nzU, nzT, nzV);
        this.jhr.setGravity(1);
        this.jhr.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mRootView.addView(this.jhr);
        this.nzP = new b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ShareGridLayout.nzJ;
        layoutParams.rightMargin = ShareGridLayout.nzJ;
        this.mRootView.addView(this.nzP.dTf(), layoutParams);
        this.naC = new EMTextView(context);
        this.naC.setGravity(1);
        this.naC.setTextSize(0, nzY);
        this.naC.setText(R.string.cancel);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = nzZ;
        this.naC.setLayoutParams(layoutParams2);
        this.naC.setPadding(0, nzW, 0, nzW);
        this.naC.setOnClickListener(this);
        this.mRootView.addView(this.naC);
        this.lNh = new View(context);
        this.lNh.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.bottom_enter_anim_place_holder_height)));
        this.mRootView.addView(this.lNh);
        this.nzP.a(this);
    }

    public void g(ShareDialogConfig shareDialogConfig) {
        if (!TextUtils.isEmpty(shareDialogConfig.shareItem.fnC)) {
            shareDialogConfig.shareItem.content = shareDialogConfig.shareItem.fnC;
        }
        if (!shareDialogConfig.shareItem.fnP) {
            this.jhr.setText(R.string.transmit_share_no_outer);
        } else {
            String sharePanelText = TbSingleton.getInstance().getSharePanelText();
            if (!TextUtils.isEmpty(sharePanelText)) {
                this.jhr.setText(sharePanelText);
            } else {
                this.jhr.setText(R.string.transmit_share_not_add_experience);
            }
        }
        this.nzP.a(shareDialogConfig, this.nzQ);
        this.nzR = shareDialogConfig;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void yA(boolean z) {
        this.nzQ = z;
    }

    public void show() {
        dLk();
        this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.transmitShare.c.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mOnDismissListener != null) {
                    c.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS);
                if (c.this.nzP != null) {
                    c.this.nzP.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.showDialog(this.mDialog, (Activity) this.mContext);
        }
        com.baidu.tbadk.core.elementsMaven.c.bm(this.mRootView).pA(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
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
            window.setDimAmount(this.eOa);
            bXA();
            i.J(this.mContext).registerListener(this.eOd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLk() {
        com.baidu.tbadk.core.elementsMaven.c.bm(this.mRootView).pA(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ap.setViewTextColor(this.jhr, (int) R.color.CAM_X0109);
        ap.k(this.naC, R.color.CAM_X0107);
    }

    private void bXA() {
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
            MessageManager.getInstance().unRegisterListener(this.eOd);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.naC) {
            f("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.transmitShare.a
    public void ed(View view) {
        dismiss();
    }

    public void b(ShareDialogConfig.From from) {
        ae sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bxG() && !au.isEmpty(sharePanelConfData.getText())) {
            this.jhr.setText(sharePanelConfData.getText());
        }
    }
}
