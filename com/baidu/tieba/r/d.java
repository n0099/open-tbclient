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
    private LinearLayout aGg;
    private AlertDialog asS;
    private TextView gSU;
    private View hrA;
    private FlexibleHorizontalScrollView hrB;
    private FlexibleHorizontalScrollView hrC;
    private b hrD;
    private c hrE;
    private boolean hrF;
    private View hrz;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;
    private static final int hrG = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds90);
    private static final int hrH = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds96);
    private static final int DS32 = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds32);
    private static final int hrI = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds50);
    private static final int hrJ = l.h(TbadkCoreApplication.getInst(), e.C0200e.fontsize24);
    private static final int dzL = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds1);

    public d(Context context) {
        this.mContext = context;
        this.aGg = new LinearLayout(context);
        this.aGg.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, hrJ);
        this.mTitle.setPadding(hrI, 0, hrI, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setText(e.j.transmit_share_add_experience);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, hrG));
        this.aGg.addView(this.mTitle);
        this.hrz = new View(this.mContext);
        this.hrz.setLayoutParams(new LinearLayout.LayoutParams(-1, dzL));
        this.aGg.addView(this.hrz);
        this.hrB = new FlexibleHorizontalScrollView(this.mContext);
        this.hrB.setFillViewport(true);
        this.hrB.setHorizontalScrollBarEnabled(false);
        this.hrB.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.hrB.setVerticalScrollBarEnabled(false);
        this.aGg.addView(this.hrB);
        this.hrA = new View(this.mContext);
        this.hrA.setLayoutParams(new LinearLayout.LayoutParams(-1, dzL));
        this.aGg.addView(this.hrA);
        this.hrC = new FlexibleHorizontalScrollView(this.mContext);
        this.hrC.setFillViewport(true);
        this.hrC.setHorizontalScrollBarEnabled(false);
        this.hrC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.hrC.setVerticalScrollBarEnabled(false);
        this.aGg.addView(this.hrC);
        this.gSU = new TextView(context);
        this.gSU.setTextSize(0, DS32);
        this.gSU.setGravity(17);
        this.gSU.setText(e.j.cancel);
        this.gSU.setLayoutParams(new LinearLayout.LayoutParams(-1, hrH));
        this.gSU.setOnClickListener(this);
        this.aGg.addView(this.gSU);
        this.hrD = new b(context);
        this.hrE = new c(context);
        this.hrD.a(this);
        this.hrE.a(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.hrD.a(dVar, arrayList, i);
        if (this.mShareItem.aOS) {
            this.hrE.o(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void nQ(boolean z) {
        this.hrF = z;
    }

    public void show() {
        bFm();
        bwT();
        this.asS = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
        this.asS.setCanceledOnTouchOutside(true);
        this.asS.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.r.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.hrD != null) {
                    d.this.hrD.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.asS, (Activity) this.mContext);
        }
        Window window = this.asS.getWindow();
        window.setWindowAnimations(e.k.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.aGg);
        abd();
    }

    private void bFm() {
        if (this.hrF) {
            this.hrB.addView(this.hrD.getView());
            this.hrB.setVisibility(0);
            this.hrz.setVisibility(0);
        } else {
            this.hrB.setVisibility(8);
            this.hrz.setVisibility(8);
        }
        if (this.mShareItem.aOS) {
            this.hrC.addView(this.hrE.bFl());
        } else {
            this.hrC.setVisibility(8);
        }
    }

    private void bwT() {
        al.i(this.aGg, e.d.cp_bg_line_e);
        al.h(this.mTitle, e.d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.aOE) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(e.j.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.aOS) {
            this.mTitle.setText(e.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(e.j.transmit_share_not_include_outer);
        }
        al.j(this.hrz, e.d.cp_bg_line_b);
        al.j(this.hrA, e.d.cp_bg_line_b);
        al.c(this.gSU, e.d.cp_cont_b, 1);
        al.i(this.gSU, e.f.dialog_share_cancel_button_bg_selector);
    }

    private void abd() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.r.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.asS != null && d.this.asS.isShowing()) {
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
        if (this.asS != null && (this.mContext instanceof Activity)) {
            g.b(this.asS, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gSU) {
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
