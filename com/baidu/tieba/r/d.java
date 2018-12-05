package com.baidu.tieba.r;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener, a {
    private LinearLayout aJG;
    private AlertDialog aws;
    private TextView gZK;
    private View hyL;
    private View hyM;
    private FlexibleHorizontalScrollView hyN;
    private FlexibleHorizontalScrollView hyO;
    private b hyP;
    private c hyQ;
    private boolean hyR;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;
    private static final int hyS = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds90);
    private static final int hyT = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds96);
    private static final int DS32 = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds32);
    private static final int hyU = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds50);
    private static final int hyV = l.h(TbadkCoreApplication.getInst(), e.C0210e.fontsize24);
    private static final int dGk = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds1);

    public d(Context context) {
        this.mContext = context;
        this.aJG = new LinearLayout(context);
        this.aJG.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, hyV);
        this.mTitle.setPadding(hyU, 0, hyU, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setText(e.j.transmit_share_add_experience);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, hyS));
        this.aJG.addView(this.mTitle);
        this.hyL = new View(this.mContext);
        this.hyL.setLayoutParams(new LinearLayout.LayoutParams(-1, dGk));
        this.aJG.addView(this.hyL);
        this.hyN = new FlexibleHorizontalScrollView(this.mContext);
        this.hyN.setFillViewport(true);
        this.hyN.setHorizontalScrollBarEnabled(false);
        this.hyN.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.hyN.setVerticalScrollBarEnabled(false);
        this.aJG.addView(this.hyN);
        this.hyM = new View(this.mContext);
        this.hyM.setLayoutParams(new LinearLayout.LayoutParams(-1, dGk));
        this.aJG.addView(this.hyM);
        this.hyO = new FlexibleHorizontalScrollView(this.mContext);
        this.hyO.setFillViewport(true);
        this.hyO.setHorizontalScrollBarEnabled(false);
        this.hyO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.hyO.setVerticalScrollBarEnabled(false);
        this.aJG.addView(this.hyO);
        this.gZK = new TextView(context);
        this.gZK.setTextSize(0, DS32);
        this.gZK.setGravity(17);
        this.gZK.setText(e.j.cancel);
        this.gZK.setLayoutParams(new LinearLayout.LayoutParams(-1, hyT));
        this.gZK.setOnClickListener(this);
        this.aJG.addView(this.gZK);
        this.hyP = new b(context);
        this.hyQ = new c(context);
        this.hyP.a(this);
        this.hyQ.a(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.hyP.a(dVar, arrayList, i);
        if (this.mShareItem.aSr) {
            this.hyQ.o(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void nS(boolean z) {
        this.hyR = z;
    }

    public void show() {
        bHq();
        byN();
        this.aws = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
        this.aws.setCanceledOnTouchOutside(true);
        this.aws.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.r.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.hyP != null) {
                    d.this.hyP.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.aws, (Activity) this.mContext);
        }
        Window window = this.aws.getWindow();
        window.setWindowAnimations(e.k.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.aJG);
        acj();
    }

    private void bHq() {
        if (this.hyR) {
            this.hyN.addView(this.hyP.getView());
            this.hyN.setVisibility(0);
            this.hyL.setVisibility(0);
        } else {
            this.hyN.setVisibility(8);
            this.hyL.setVisibility(8);
        }
        if (this.mShareItem.aSr) {
            this.hyO.addView(this.hyQ.bHp());
        } else {
            this.hyO.setVisibility(8);
        }
    }

    private void byN() {
        al.i(this.aJG, e.d.cp_bg_line_e);
        al.h(this.mTitle, e.d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.aSd) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(e.j.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.aSr) {
            this.mTitle.setText(e.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(e.j.transmit_share_not_include_outer);
        }
        al.j(this.hyL, e.d.cp_bg_line_b);
        al.j(this.hyM, e.d.cp_bg_line_b);
        al.c(this.gZK, e.d.cp_cont_b, 1);
        al.i(this.gZK, e.f.dialog_share_cancel_button_bg_selector);
    }

    private void acj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.r.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.aws != null && d.this.aws.isShowing()) {
                    d.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void dismiss() {
        if (this.aws != null && (this.mContext instanceof Activity)) {
            g.b(this.aws, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gZK) {
            l("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, AiAppsUBCStatistic.TYPE_CLICK, 1, objArr);
    }

    @Override // com.baidu.tieba.r.a
    public void bT(View view) {
        dismiss();
    }
}
