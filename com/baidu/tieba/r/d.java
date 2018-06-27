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
    private AlertDialog alf;
    private LinearLayout aya;
    private TextView gBl;
    private View gZF;
    private View gZG;
    private FlexibleHorizontalScrollView gZH;
    private FlexibleHorizontalScrollView gZI;
    private b gZJ;
    private c gZK;
    private boolean gZL;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;
    private static final int gZM = l.e(TbadkCoreApplication.getInst(), d.e.ds90);
    private static final int gZN = l.e(TbadkCoreApplication.getInst(), d.e.ds96);
    private static final int bAy = l.e(TbadkCoreApplication.getInst(), d.e.ds32);
    private static final int gZO = l.e(TbadkCoreApplication.getInst(), d.e.ds50);
    private static final int gZP = l.e(TbadkCoreApplication.getInst(), d.e.fontsize24);
    private static final int dhM = l.e(TbadkCoreApplication.getInst(), d.e.ds1);

    public d(Context context) {
        this.mContext = context;
        this.aya = new LinearLayout(context);
        this.aya.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, gZP);
        this.mTitle.setPadding(gZO, 0, gZO, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setText(d.k.transmit_share_add_experience);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, gZM));
        this.aya.addView(this.mTitle);
        this.gZF = new View(this.mContext);
        this.gZF.setLayoutParams(new LinearLayout.LayoutParams(-1, dhM));
        this.aya.addView(this.gZF);
        this.gZH = new FlexibleHorizontalScrollView(this.mContext);
        this.gZH.setFillViewport(true);
        this.gZH.setHorizontalScrollBarEnabled(false);
        this.gZH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.gZH.setVerticalScrollBarEnabled(false);
        this.aya.addView(this.gZH);
        this.gZG = new View(this.mContext);
        this.gZG.setLayoutParams(new LinearLayout.LayoutParams(-1, dhM));
        this.aya.addView(this.gZG);
        this.gZI = new FlexibleHorizontalScrollView(this.mContext);
        this.gZI.setFillViewport(true);
        this.gZI.setHorizontalScrollBarEnabled(false);
        this.gZI.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.gZI.setVerticalScrollBarEnabled(false);
        this.aya.addView(this.gZI);
        this.gBl = new TextView(context);
        this.gBl.setTextSize(0, bAy);
        this.gBl.setGravity(17);
        this.gBl.setText(d.k.cancel);
        this.gBl.setLayoutParams(new LinearLayout.LayoutParams(-1, gZN));
        this.gBl.setOnClickListener(this);
        this.aya.addView(this.gBl);
        this.gZJ = new b(context);
        this.gZK = new c(context);
        this.gZJ.setShareItemClickListener(this);
        this.gZK.setShareItemClickListener(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.gZJ.a(dVar, arrayList, i);
        if (this.mShareItem.aGn) {
            this.gZK.setShareData(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void nd(boolean z) {
        this.gZL = z;
    }

    public void show() {
        bBg();
        bta();
        this.alf = new AlertDialog.Builder(this.mContext, d.l.DialogTheme).create();
        this.alf.setCanceledOnTouchOutside(true);
        this.alf.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.r.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.gZJ != null) {
                    d.this.gZJ.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.alf, (Activity) this.mContext);
        }
        Window window = this.alf.getWindow();
        window.setWindowAnimations(d.l.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.aya);
        Vm();
    }

    private void bBg() {
        if (this.gZL) {
            this.gZH.addView(this.gZJ.getView());
            this.gZH.setVisibility(0);
            this.gZF.setVisibility(0);
        } else {
            this.gZH.setVisibility(8);
            this.gZF.setVisibility(8);
        }
        if (this.mShareItem.aGn) {
            this.gZI.addView(this.gZK.bBf());
        } else {
            this.gZI.setVisibility(8);
        }
    }

    private void bta() {
        am.i(this.aya, d.C0142d.cp_bg_line_e);
        am.h(this.mTitle, d.C0142d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.aFZ) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(d.k.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0142d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0142d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.aGn) {
            this.mTitle.setText(d.k.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(d.k.transmit_share_not_include_outer);
        }
        am.j(this.gZF, d.C0142d.cp_bg_line_b);
        am.j(this.gZG, d.C0142d.cp_bg_line_b);
        am.c(this.gBl, d.C0142d.cp_cont_b, 1);
        am.i(this.gBl, d.f.dialog_share_cancel_button_bg_selector);
    }

    private void Vm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.r.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.alf != null && d.this.alf.isShowing()) {
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
        if (this.alf != null && (this.mContext instanceof Activity)) {
            g.b(this.alf, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gBl) {
            l("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.r.a
    public void bx(View view) {
        dismiss();
    }
}
