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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener, a {
    private AlertDialog akE;
    private LinearLayout axG;
    private TextView gCt;
    private View haF;
    private View haG;
    private FlexibleHorizontalScrollView haH;
    private FlexibleHorizontalScrollView haI;
    private b haJ;
    private c haK;
    private boolean haL;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;
    private static final int haM = l.f(TbadkCoreApplication.getInst(), d.e.ds90);
    private static final int haN = l.f(TbadkCoreApplication.getInst(), d.e.ds96);
    private static final int bBf = l.f(TbadkCoreApplication.getInst(), d.e.ds32);
    private static final int haO = l.f(TbadkCoreApplication.getInst(), d.e.ds50);
    private static final int haP = l.f(TbadkCoreApplication.getInst(), d.e.fontsize24);
    private static final int dkB = l.f(TbadkCoreApplication.getInst(), d.e.ds1);

    public d(Context context) {
        this.mContext = context;
        this.axG = new LinearLayout(context);
        this.axG.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, haP);
        this.mTitle.setPadding(haO, 0, haO, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setText(d.j.transmit_share_add_experience);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, haM));
        this.axG.addView(this.mTitle);
        this.haF = new View(this.mContext);
        this.haF.setLayoutParams(new LinearLayout.LayoutParams(-1, dkB));
        this.axG.addView(this.haF);
        this.haH = new FlexibleHorizontalScrollView(this.mContext);
        this.haH.setFillViewport(true);
        this.haH.setHorizontalScrollBarEnabled(false);
        this.haH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.haH.setVerticalScrollBarEnabled(false);
        this.axG.addView(this.haH);
        this.haG = new View(this.mContext);
        this.haG.setLayoutParams(new LinearLayout.LayoutParams(-1, dkB));
        this.axG.addView(this.haG);
        this.haI = new FlexibleHorizontalScrollView(this.mContext);
        this.haI.setFillViewport(true);
        this.haI.setHorizontalScrollBarEnabled(false);
        this.haI.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.haI.setVerticalScrollBarEnabled(false);
        this.axG.addView(this.haI);
        this.gCt = new TextView(context);
        this.gCt.setTextSize(0, bBf);
        this.gCt.setGravity(17);
        this.gCt.setText(d.j.cancel);
        this.gCt.setLayoutParams(new LinearLayout.LayoutParams(-1, haN));
        this.gCt.setOnClickListener(this);
        this.axG.addView(this.gCt);
        this.haJ = new b(context);
        this.haK = new c(context);
        this.haJ.a(this);
        this.haK.a(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.haJ.a(dVar, arrayList, i);
        if (this.mShareItem.aGn) {
            this.haK.o(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void mO(boolean z) {
        this.haL = z;
    }

    public void show() {
        bzI();
        brD();
        this.akE = new AlertDialog.Builder(this.mContext, d.k.DialogTheme).create();
        this.akE.setCanceledOnTouchOutside(true);
        this.akE.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.r.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.haJ != null) {
                    d.this.haJ.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.akE, (Activity) this.mContext);
        }
        Window window = this.akE.getWindow();
        window.setWindowAnimations(d.k.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.axG);
        Vv();
    }

    private void bzI() {
        if (this.haL) {
            this.haH.addView(this.haJ.getView());
            this.haH.setVisibility(0);
            this.haF.setVisibility(0);
        } else {
            this.haH.setVisibility(8);
            this.haF.setVisibility(8);
        }
        if (this.mShareItem.aGn) {
            this.haI.addView(this.haK.bzH());
        } else {
            this.haI.setVisibility(8);
        }
    }

    private void brD() {
        am.i(this.axG, d.C0140d.cp_bg_line_e);
        am.h(this.mTitle, d.C0140d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.aFZ) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(d.j.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0140d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0140d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.aGn) {
            this.mTitle.setText(d.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(d.j.transmit_share_not_include_outer);
        }
        am.j(this.haF, d.C0140d.cp_bg_line_b);
        am.j(this.haG, d.C0140d.cp_bg_line_b);
        am.c(this.gCt, d.C0140d.cp_cont_b, 1);
        am.i(this.gCt, d.f.dialog_share_cancel_button_bg_selector);
    }

    private void Vv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.r.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.akE != null && d.this.akE.isShowing()) {
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
        if (this.akE != null && (this.mContext instanceof Activity)) {
            g.b(this.akE, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gCt) {
            l("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.r.a
    public void bE(View view) {
        dismiss();
    }
}
