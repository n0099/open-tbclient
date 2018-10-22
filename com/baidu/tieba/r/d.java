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
    private LinearLayout aFq;
    private AlertDialog asf;
    private TextView gRy;
    private View hpQ;
    private View hpR;
    private FlexibleHorizontalScrollView hpS;
    private FlexibleHorizontalScrollView hpT;
    private b hpU;
    private c hpV;
    private boolean hpW;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;
    private static final int hpX = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds90);
    private static final int hpY = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds96);
    private static final int bPz = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds32);
    private static final int hpZ = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds50);
    private static final int hqa = l.h(TbadkCoreApplication.getInst(), e.C0175e.fontsize24);
    private static final int dyt = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds1);

    public d(Context context) {
        this.mContext = context;
        this.aFq = new LinearLayout(context);
        this.aFq.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, hqa);
        this.mTitle.setPadding(hpZ, 0, hpZ, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setText(e.j.transmit_share_add_experience);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, hpX));
        this.aFq.addView(this.mTitle);
        this.hpQ = new View(this.mContext);
        this.hpQ.setLayoutParams(new LinearLayout.LayoutParams(-1, dyt));
        this.aFq.addView(this.hpQ);
        this.hpS = new FlexibleHorizontalScrollView(this.mContext);
        this.hpS.setFillViewport(true);
        this.hpS.setHorizontalScrollBarEnabled(false);
        this.hpS.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.hpS.setVerticalScrollBarEnabled(false);
        this.aFq.addView(this.hpS);
        this.hpR = new View(this.mContext);
        this.hpR.setLayoutParams(new LinearLayout.LayoutParams(-1, dyt));
        this.aFq.addView(this.hpR);
        this.hpT = new FlexibleHorizontalScrollView(this.mContext);
        this.hpT.setFillViewport(true);
        this.hpT.setHorizontalScrollBarEnabled(false);
        this.hpT.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.hpT.setVerticalScrollBarEnabled(false);
        this.aFq.addView(this.hpT);
        this.gRy = new TextView(context);
        this.gRy.setTextSize(0, bPz);
        this.gRy.setGravity(17);
        this.gRy.setText(e.j.cancel);
        this.gRy.setLayoutParams(new LinearLayout.LayoutParams(-1, hpY));
        this.gRy.setOnClickListener(this);
        this.aFq.addView(this.gRy);
        this.hpU = new b(context);
        this.hpV = new c(context);
        this.hpU.a(this);
        this.hpV.a(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.hpU.a(dVar, arrayList, i);
        if (this.mShareItem.aOc) {
            this.hpV.o(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void nC(boolean z) {
        this.hpW = z;
    }

    public void show() {
        bFN();
        bxy();
        this.asf = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
        this.asf.setCanceledOnTouchOutside(true);
        this.asf.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.r.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.hpU != null) {
                    d.this.hpU.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.asf, (Activity) this.mContext);
        }
        Window window = this.asf.getWindow();
        window.setWindowAnimations(e.k.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.aFq);
        aaT();
    }

    private void bFN() {
        if (this.hpW) {
            this.hpS.addView(this.hpU.getView());
            this.hpS.setVisibility(0);
            this.hpQ.setVisibility(0);
        } else {
            this.hpS.setVisibility(8);
            this.hpQ.setVisibility(8);
        }
        if (this.mShareItem.aOc) {
            this.hpT.addView(this.hpV.bFM());
        } else {
            this.hpT.setVisibility(8);
        }
    }

    private void bxy() {
        al.i(this.aFq, e.d.cp_bg_line_e);
        al.h(this.mTitle, e.d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.aNO) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(e.j.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.aOc) {
            this.mTitle.setText(e.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(e.j.transmit_share_not_include_outer);
        }
        al.j(this.hpQ, e.d.cp_bg_line_b);
        al.j(this.hpR, e.d.cp_bg_line_b);
        al.c(this.gRy, e.d.cp_cont_b, 1);
        al.i(this.gRy, e.f.dialog_share_cancel_button_bg_selector);
    }

    private void aaT() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.r.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.asf != null && d.this.asf.isShowing()) {
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
        if (this.asf != null && (this.mContext instanceof Activity)) {
            g.b(this.asf, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gRy) {
            l("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, AiAppsUBCStatistic.TYPE_CLICK, 1, objArr);
    }

    @Override // com.baidu.tieba.r.a
    public void bR(View view) {
        dismiss();
    }
}
