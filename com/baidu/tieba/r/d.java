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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener, a {
    private LinearLayout aAJ;
    private AlertDialog ank;
    private TextView gJZ;
    private View hiA;
    private FlexibleHorizontalScrollView hiB;
    private FlexibleHorizontalScrollView hiC;
    private b hiD;
    private c hiE;
    private boolean hiF;
    private View hiz;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;
    private static final int hiG = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds90);
    private static final int hiH = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds96);
    private static final int bGW = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds32);
    private static final int hiI = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds50);
    private static final int hiJ = l.h(TbadkCoreApplication.getInst(), e.C0141e.fontsize24);
    private static final int dqs = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds1);

    public d(Context context) {
        this.mContext = context;
        this.aAJ = new LinearLayout(context);
        this.aAJ.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, hiJ);
        this.mTitle.setPadding(hiI, 0, hiI, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setText(e.j.transmit_share_add_experience);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, hiG));
        this.aAJ.addView(this.mTitle);
        this.hiz = new View(this.mContext);
        this.hiz.setLayoutParams(new LinearLayout.LayoutParams(-1, dqs));
        this.aAJ.addView(this.hiz);
        this.hiB = new FlexibleHorizontalScrollView(this.mContext);
        this.hiB.setFillViewport(true);
        this.hiB.setHorizontalScrollBarEnabled(false);
        this.hiB.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.hiB.setVerticalScrollBarEnabled(false);
        this.aAJ.addView(this.hiB);
        this.hiA = new View(this.mContext);
        this.hiA.setLayoutParams(new LinearLayout.LayoutParams(-1, dqs));
        this.aAJ.addView(this.hiA);
        this.hiC = new FlexibleHorizontalScrollView(this.mContext);
        this.hiC.setFillViewport(true);
        this.hiC.setHorizontalScrollBarEnabled(false);
        this.hiC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.hiC.setVerticalScrollBarEnabled(false);
        this.aAJ.addView(this.hiC);
        this.gJZ = new TextView(context);
        this.gJZ.setTextSize(0, bGW);
        this.gJZ.setGravity(17);
        this.gJZ.setText(e.j.cancel);
        this.gJZ.setLayoutParams(new LinearLayout.LayoutParams(-1, hiH));
        this.gJZ.setOnClickListener(this);
        this.aAJ.addView(this.gJZ);
        this.hiD = new b(context);
        this.hiE = new c(context);
        this.hiD.a(this);
        this.hiE.a(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.hiD.a(dVar, arrayList, i);
        if (this.mShareItem.aJA) {
            this.hiE.o(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void nl(boolean z) {
        this.hiF = z;
    }

    public void show() {
        bCz();
        buj();
        this.ank = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
        this.ank.setCanceledOnTouchOutside(true);
        this.ank.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.r.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.hiD != null) {
                    d.this.hiD.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.ank, (Activity) this.mContext);
        }
        Window window = this.ank.getWindow();
        window.setWindowAnimations(e.k.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.aAJ);
        Xl();
    }

    private void bCz() {
        if (this.hiF) {
            this.hiB.addView(this.hiD.getView());
            this.hiB.setVisibility(0);
            this.hiz.setVisibility(0);
        } else {
            this.hiB.setVisibility(8);
            this.hiz.setVisibility(8);
        }
        if (this.mShareItem.aJA) {
            this.hiC.addView(this.hiE.bCy());
        } else {
            this.hiC.setVisibility(8);
        }
    }

    private void buj() {
        al.i(this.aAJ, e.d.cp_bg_line_e);
        al.h(this.mTitle, e.d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.aJm) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(e.j.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.aJA) {
            this.mTitle.setText(e.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(e.j.transmit_share_not_include_outer);
        }
        al.j(this.hiz, e.d.cp_bg_line_b);
        al.j(this.hiA, e.d.cp_bg_line_b);
        al.c(this.gJZ, e.d.cp_cont_b, 1);
        al.i(this.gJZ, e.f.dialog_share_cancel_button_bg_selector);
    }

    private void Xl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.r.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.ank != null && d.this.ank.isShowing()) {
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
        if (this.ank != null && (this.mContext instanceof Activity)) {
            g.b(this.ank, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gJZ) {
            l("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.r.a
    public void bR(View view) {
        dismiss();
    }
}
