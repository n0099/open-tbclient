package com.baidu.tieba.s;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
    private LinearLayout aKl;
    private AlertDialog awW;
    private View hDf;
    private View hDg;
    private FlexibleHorizontalScrollView hDh;
    private FlexibleHorizontalScrollView hDi;
    private b hDj;
    private c hDk;
    private boolean hDl;
    private TextView hdU;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;
    private static final int hDm = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds90);
    private static final int cwq = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds96);
    private static final int DS32 = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds32);
    private static final int hDn = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds50);
    private static final int hDo = l.h(TbadkCoreApplication.getInst(), e.C0210e.fontsize24);
    private static final int dJI = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds1);

    public d(Context context) {
        this.mContext = context;
        this.aKl = new LinearLayout(context);
        this.aKl.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, hDo);
        this.mTitle.setPadding(hDn, 0, hDn, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setText(e.j.transmit_share_add_experience);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, hDm));
        this.aKl.addView(this.mTitle);
        this.hDf = new View(this.mContext);
        this.hDf.setLayoutParams(new LinearLayout.LayoutParams(-1, dJI));
        this.aKl.addView(this.hDf);
        this.hDh = new FlexibleHorizontalScrollView(this.mContext);
        this.hDh.setFillViewport(true);
        this.hDh.setHorizontalScrollBarEnabled(false);
        this.hDh.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.hDh.setVerticalScrollBarEnabled(false);
        this.aKl.addView(this.hDh);
        this.hDg = new View(this.mContext);
        this.hDg.setLayoutParams(new LinearLayout.LayoutParams(-1, dJI));
        this.aKl.addView(this.hDg);
        this.hDi = new FlexibleHorizontalScrollView(this.mContext);
        this.hDi.setFillViewport(true);
        this.hDi.setHorizontalScrollBarEnabled(false);
        this.hDi.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.hDi.setVerticalScrollBarEnabled(false);
        this.aKl.addView(this.hDi);
        this.hdU = new TextView(context);
        this.hdU.setTextSize(0, DS32);
        this.hdU.setGravity(17);
        this.hdU.setText(e.j.cancel);
        this.hdU.setLayoutParams(new LinearLayout.LayoutParams(-1, cwq));
        this.hdU.setOnClickListener(this);
        this.aKl.addView(this.hdU);
        this.hDj = new b(context);
        this.hDk = new c(context);
        this.hDj.a(this);
        this.hDk.a(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (!TextUtils.isEmpty(dVar.aSR)) {
            dVar.content = dVar.aSR;
        }
        this.mShareItem = dVar;
        this.hDj.a(dVar, arrayList, i);
        if (this.mShareItem.aTb) {
            this.hDk.p(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void nW(boolean z) {
        this.hDl = z;
    }

    public void show() {
        bIO();
        bAl();
        this.awW = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
        this.awW.setCanceledOnTouchOutside(true);
        this.awW.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.s.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.hDj != null) {
                    d.this.hDj.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.awW, (Activity) this.mContext);
        }
        Window window = this.awW.getWindow();
        window.setWindowAnimations(e.k.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.aKl);
        acI();
    }

    private void bIO() {
        if (this.hDl) {
            this.hDh.addView(this.hDj.getView());
            this.hDh.setVisibility(0);
            this.hDf.setVisibility(0);
        } else {
            this.hDh.setVisibility(8);
            this.hDf.setVisibility(8);
        }
        if (this.mShareItem.aTb) {
            this.hDi.addView(this.hDk.bIN());
        } else {
            this.hDi.setVisibility(8);
        }
    }

    private void bAl() {
        al.i(this.aKl, e.d.cp_bg_line_e);
        al.h(this.mTitle, e.d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.aSK) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(e.j.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.aTb) {
            this.mTitle.setText(e.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(e.j.transmit_share_not_include_outer);
        }
        al.j(this.hDf, e.d.cp_bg_line_b);
        al.j(this.hDg, e.d.cp_bg_line_b);
        al.c(this.hdU, e.d.cp_cont_b, 1);
        al.i(this.hdU, e.f.dialog_share_cancel_button_bg_selector);
    }

    private void acI() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.s.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.awW != null && d.this.awW.isShowing()) {
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
        if (this.awW != null && (this.mContext instanceof Activity)) {
            g.b(this.awW, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hdU) {
            l("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, AiAppsUBCStatistic.TYPE_CLICK, 1, objArr);
    }

    @Override // com.baidu.tieba.s.a
    public void bW(View view) {
        dismiss();
    }
}
