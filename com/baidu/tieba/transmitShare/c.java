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
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c implements View.OnClickListener, a {
    private static final int iTA = l.h(TbadkCoreApplication.getInst(), d.e.tbds130);
    private static final int iTB = l.h(TbadkCoreApplication.getInst(), d.e.tbds48);
    private static final int iTC = l.h(TbadkCoreApplication.getInst(), d.e.tbds34);
    private static final int ing = l.h(TbadkCoreApplication.getInst(), d.e.tbds44);
    private LinearLayout bFy;
    private b iTy;
    private boolean iTz;
    private TextView ivp;
    private Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private TextView mTitle;

    public c(Context context) {
        this.mContext = context;
        this.bFy = new LinearLayout(context);
        this.bFy.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, iTC);
        this.mTitle.setPadding(iTB, 0, iTB, 0);
        this.mTitle.setGravity(17);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (TextUtils.isEmpty(sharePanelText)) {
            this.mTitle.setText(d.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(sharePanelText);
        }
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, iTA));
        this.bFy.addView(this.mTitle);
        this.iTy = new b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ShareGridLayout.iTs;
        layoutParams.rightMargin = ShareGridLayout.iTs;
        this.bFy.addView(this.iTy.cil(), layoutParams);
        this.ivp = new TextView(context);
        this.ivp.setTextSize(0, ing);
        this.ivp.setGravity(17);
        this.ivp.setText(d.j.cancel);
        this.ivp.setLayoutParams(new LinearLayout.LayoutParams(-1, iTA));
        this.ivp.setOnClickListener(this);
        this.bFy.addView(this.ivp);
        this.iTy.a(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (!TextUtils.isEmpty(dVar.cbA)) {
            dVar.content = dVar.cbA;
        }
        this.iTy.a(dVar, arrayList, i, this.iTz);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void qw(boolean z) {
        this.iTz = z;
    }

    public void show() {
        caZ();
        this.mDialog = new AlertDialog.Builder(this.mContext, d.k.DialogTheme).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.transmitShare.c.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.mOnDismissListener != null) {
                    c.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (c.this.iTy != null) {
                    c.this.iTy.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.mDialog, (Activity) this.mContext);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.bFy.setBackgroundResource(d.f.transmit_share_dialog_background_1);
        } else {
            this.bFy.setBackgroundResource(d.f.transmit_share_dialog_background);
        }
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(d.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.bFy);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                window.setBackgroundDrawableResource(d.f.transmit_share_dialog_background_1);
            } else {
                window.setBackgroundDrawableResource(d.f.transmit_share_dialog_background);
            }
            aDA();
        }
    }

    private void caZ() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            al.k(this.bFy, d.f.transmit_share_dialog_background_1);
        } else {
            al.k(this.bFy, d.f.transmit_share_dialog_background);
        }
        al.j(this.mTitle, d.C0277d.cp_cont_c);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (TextUtils.isEmpty(sharePanelText)) {
            this.mTitle.setText(d.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(sharePanelText);
        }
        al.d(this.ivp, d.C0277d.cp_cont_j, 1);
    }

    private void aDA() {
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
        if (view == this.ivp) {
            k("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void k(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.transmitShare.a
    public void cJ(View view) {
        dismiss();
    }
}
