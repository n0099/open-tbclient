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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener, a {
    private AlertDialog akE;
    private LinearLayout axD;
    private TextView gCw;
    private View haH;
    private View haI;
    private FlexibleHorizontalScrollView haJ;
    private FlexibleHorizontalScrollView haK;
    private b haL;
    private c haM;
    private boolean haN;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;
    private static final int haO = l.f(TbadkCoreApplication.getInst(), f.e.ds90);
    private static final int haP = l.f(TbadkCoreApplication.getInst(), f.e.ds96);
    private static final int bBh = l.f(TbadkCoreApplication.getInst(), f.e.ds32);
    private static final int haQ = l.f(TbadkCoreApplication.getInst(), f.e.ds50);
    private static final int haR = l.f(TbadkCoreApplication.getInst(), f.e.fontsize24);
    private static final int dkz = l.f(TbadkCoreApplication.getInst(), f.e.ds1);

    public d(Context context) {
        this.mContext = context;
        this.axD = new LinearLayout(context);
        this.axD.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, haR);
        this.mTitle.setPadding(haQ, 0, haQ, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setText(f.j.transmit_share_add_experience);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, haO));
        this.axD.addView(this.mTitle);
        this.haH = new View(this.mContext);
        this.haH.setLayoutParams(new LinearLayout.LayoutParams(-1, dkz));
        this.axD.addView(this.haH);
        this.haJ = new FlexibleHorizontalScrollView(this.mContext);
        this.haJ.setFillViewport(true);
        this.haJ.setHorizontalScrollBarEnabled(false);
        this.haJ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.haJ.setVerticalScrollBarEnabled(false);
        this.axD.addView(this.haJ);
        this.haI = new View(this.mContext);
        this.haI.setLayoutParams(new LinearLayout.LayoutParams(-1, dkz));
        this.axD.addView(this.haI);
        this.haK = new FlexibleHorizontalScrollView(this.mContext);
        this.haK.setFillViewport(true);
        this.haK.setHorizontalScrollBarEnabled(false);
        this.haK.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.haK.setVerticalScrollBarEnabled(false);
        this.axD.addView(this.haK);
        this.gCw = new TextView(context);
        this.gCw.setTextSize(0, bBh);
        this.gCw.setGravity(17);
        this.gCw.setText(f.j.cancel);
        this.gCw.setLayoutParams(new LinearLayout.LayoutParams(-1, haP));
        this.gCw.setOnClickListener(this);
        this.axD.addView(this.gCw);
        this.haL = new b(context);
        this.haM = new c(context);
        this.haL.a(this);
        this.haM.a(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.haL.a(dVar, arrayList, i);
        if (this.mShareItem.aGm) {
            this.haM.o(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void mO(boolean z) {
        this.haN = z;
    }

    public void show() {
        bzK();
        brE();
        this.akE = new AlertDialog.Builder(this.mContext, f.k.DialogTheme).create();
        this.akE.setCanceledOnTouchOutside(true);
        this.akE.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.r.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.haL != null) {
                    d.this.haL.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.akE, (Activity) this.mContext);
        }
        Window window = this.akE.getWindow();
        window.setWindowAnimations(f.k.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.axD);
        Vy();
    }

    private void bzK() {
        if (this.haN) {
            this.haJ.addView(this.haL.getView());
            this.haJ.setVisibility(0);
            this.haH.setVisibility(0);
        } else {
            this.haJ.setVisibility(8);
            this.haH.setVisibility(8);
        }
        if (this.mShareItem.aGm) {
            this.haK.addView(this.haM.bzJ());
        } else {
            this.haK.setVisibility(8);
        }
    }

    private void brE() {
        am.i(this.axD, f.d.cp_bg_line_e);
        am.h(this.mTitle, f.d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.aFY) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(f.j.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(f.d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(f.d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.aGm) {
            this.mTitle.setText(f.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(f.j.transmit_share_not_include_outer);
        }
        am.j(this.haH, f.d.cp_bg_line_b);
        am.j(this.haI, f.d.cp_bg_line_b);
        am.c(this.gCw, f.d.cp_cont_b, 1);
        am.i(this.gCw, f.C0146f.dialog_share_cancel_button_bg_selector);
    }

    private void Vy() {
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
        if (view == this.gCw) {
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
