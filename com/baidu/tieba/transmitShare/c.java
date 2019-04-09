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
    private static final int iTB = l.h(TbadkCoreApplication.getInst(), d.e.tbds130);
    private static final int iTC = l.h(TbadkCoreApplication.getInst(), d.e.tbds48);
    private static final int iTD = l.h(TbadkCoreApplication.getInst(), d.e.tbds34);
    private static final int inh = l.h(TbadkCoreApplication.getInst(), d.e.tbds44);
    private LinearLayout bFz;
    private boolean iTA;
    private b iTz;
    private TextView ivq;
    private Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private TextView mTitle;

    public c(Context context) {
        this.mContext = context;
        this.bFz = new LinearLayout(context);
        this.bFz.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, iTD);
        this.mTitle.setPadding(iTC, 0, iTC, 0);
        this.mTitle.setGravity(17);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (TextUtils.isEmpty(sharePanelText)) {
            this.mTitle.setText(d.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(sharePanelText);
        }
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, iTB));
        this.bFz.addView(this.mTitle);
        this.iTz = new b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ShareGridLayout.iTt;
        layoutParams.rightMargin = ShareGridLayout.iTt;
        this.bFz.addView(this.iTz.cil(), layoutParams);
        this.ivq = new TextView(context);
        this.ivq.setTextSize(0, inh);
        this.ivq.setGravity(17);
        this.ivq.setText(d.j.cancel);
        this.ivq.setLayoutParams(new LinearLayout.LayoutParams(-1, iTB));
        this.ivq.setOnClickListener(this);
        this.bFz.addView(this.ivq);
        this.iTz.a(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (!TextUtils.isEmpty(dVar.cbB)) {
            dVar.content = dVar.cbB;
        }
        this.iTz.a(dVar, arrayList, i, this.iTA);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void qw(boolean z) {
        this.iTA = z;
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
                if (c.this.iTz != null) {
                    c.this.iTz.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.mDialog, (Activity) this.mContext);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.bFz.setBackgroundResource(d.f.transmit_share_dialog_background_1);
        } else {
            this.bFz.setBackgroundResource(d.f.transmit_share_dialog_background);
        }
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(d.k.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.bFz);
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
            al.k(this.bFz, d.f.transmit_share_dialog_background_1);
        } else {
            al.k(this.bFz, d.f.transmit_share_dialog_background);
        }
        al.j(this.mTitle, d.C0277d.cp_cont_c);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (TextUtils.isEmpty(sharePanelText)) {
            this.mTitle.setText(d.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(sharePanelText);
        }
        al.d(this.ivq, d.C0277d.cp_cont_j, 1);
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
        if (view == this.ivq) {
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
