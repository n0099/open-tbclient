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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.ae;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class c implements View.OnClickListener, a {
    private float eTm = 0.33f;
    private CustomMessageListener eTp = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.transmitShare.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                c.this.dHi();
                c.this.g(c.this.nzt);
            }
        }
    };
    private EMTextView jpl;
    private View lNP;
    private Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private LinearLayout mRootView;
    private EMTextView nbA;
    private b nzr;
    private boolean nzs;
    private ShareDialogConfig nzt;
    private static final int nzu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds130);
    private static final int nzv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
    private static final int nzw = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
    private static final int nzx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
    private static final int nzy = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    private static final int nzz = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X08);
    private static final int nzA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X06);
    private static final int nzB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);

    public c(Context context) {
        this.mContext = context;
        this.mRootView = new LinearLayout(context);
        this.mRootView.setOrientation(1);
        this.jpl = new EMTextView(context);
        this.jpl.setTextSize(0, nzz);
        this.jpl.setPadding(nzv, nzw, nzv, nzx);
        this.jpl.setGravity(1);
        this.jpl.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mRootView.addView(this.jpl);
        this.nzr = new b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ShareGridLayout.nzl;
        layoutParams.rightMargin = ShareGridLayout.nzl;
        this.mRootView.addView(this.nzr.dPf(), layoutParams);
        this.nbA = new EMTextView(context);
        this.nbA.setGravity(1);
        this.nbA.setTextSize(0, nzA);
        this.nbA.setText(R.string.cancel);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = nzB;
        this.nbA.setLayoutParams(layoutParams2);
        this.nbA.setPadding(0, nzy, 0, nzy);
        this.nbA.setOnClickListener(this);
        this.mRootView.addView(this.nbA);
        this.lNP = new View(context);
        this.lNP.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.bottom_enter_anim_place_holder_height)));
        this.mRootView.addView(this.lNP);
        this.nzr.a(this);
    }

    public void g(ShareDialogConfig shareDialogConfig) {
        if (!TextUtils.isEmpty(shareDialogConfig.shareItem.fsD)) {
            shareDialogConfig.shareItem.content = shareDialogConfig.shareItem.fsD;
        }
        if (!shareDialogConfig.shareItem.fsQ) {
            this.jpl.setText(R.string.transmit_share_no_outer);
        } else {
            String sharePanelText = TbSingleton.getInstance().getSharePanelText();
            if (!TextUtils.isEmpty(sharePanelText)) {
                this.jpl.setText(sharePanelText);
            } else {
                this.jpl.setText(R.string.transmit_share_not_add_experience);
            }
        }
        this.nzr.a(shareDialogConfig, this.nzs);
        this.nzt = shareDialogConfig;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void yz(boolean z) {
        this.nzs = z;
    }

    public void show() {
        dHi();
        this.mDialog = new AlertDialog.Builder(this.mContext, R.style.DialogTheme).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.transmitShare.c.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mOnDismissListener != null) {
                    c.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_TRANSMIT_SHARE_DIALOG_DISMISS);
                if (c.this.nzr != null) {
                    c.this.nzr.release();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
            }
        });
        if (this.mContext instanceof Activity) {
            g.showDialog(this.mDialog, (Activity) this.mContext);
        }
        com.baidu.tbadk.core.elementsMaven.c.bv(this.mRootView).od(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
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
            window.setDimAmount(this.eTm);
            bWo();
            j.K(this.mContext).registerListener(this.eTp);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHi() {
        com.baidu.tbadk.core.elementsMaven.c.bv(this.mRootView).od(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
        ao.setViewTextColor(this.jpl, R.color.CAM_X0109);
        ao.n(this.nbA, R.color.CAM_X0107);
    }

    private void bWo() {
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
            MessageManager.getInstance().unRegisterListener(this.eTp);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(false));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nbA) {
            f("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.transmitShare.a
    public void en(View view) {
        dismiss();
    }

    public void b(ShareDialogConfig.From from) {
        ae sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.a(from) && sharePanelConfData.bwh() && !at.isEmpty(sharePanelConfData.getText())) {
            this.jpl.setText(sharePanelConfData.getText());
        }
    }
}
