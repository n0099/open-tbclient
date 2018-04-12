package com.baidu.tieba.p;

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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener, a {
    private LinearLayout aMU;
    private AlertDialog acB;
    private View gIY;
    private View gIZ;
    private FlexibleHorizontalScrollView gJa;
    private FlexibleHorizontalScrollView gJb;
    private b gJc;
    private c gJd;
    private boolean gJe;
    private TextView gkR;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;
    private static final int gJf = l.e(TbadkCoreApplication.getInst(), d.e.ds90);
    private static final int gJg = l.e(TbadkCoreApplication.getInst(), d.e.ds96);
    private static final int bqz = l.e(TbadkCoreApplication.getInst(), d.e.ds32);
    private static final int gJh = l.e(TbadkCoreApplication.getInst(), d.e.ds50);
    private static final int gJi = l.e(TbadkCoreApplication.getInst(), d.e.fontsize24);
    private static final int cVE = l.e(TbadkCoreApplication.getInst(), d.e.ds1);

    public d(Context context) {
        this.mContext = context;
        this.aMU = new LinearLayout(context);
        this.aMU.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, gJi);
        this.mTitle.setPadding(gJh, 0, gJh, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setText(d.k.transmit_share_add_experience);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, gJf));
        this.aMU.addView(this.mTitle);
        this.gIY = new View(this.mContext);
        this.gIY.setLayoutParams(new LinearLayout.LayoutParams(-1, cVE));
        this.aMU.addView(this.gIY);
        this.gJa = new FlexibleHorizontalScrollView(this.mContext);
        this.gJa.setFillViewport(true);
        this.gJa.setHorizontalScrollBarEnabled(false);
        this.gJa.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.gJa.setVerticalScrollBarEnabled(false);
        this.aMU.addView(this.gJa);
        this.gIZ = new View(this.mContext);
        this.gIZ.setLayoutParams(new LinearLayout.LayoutParams(-1, cVE));
        this.aMU.addView(this.gIZ);
        this.gJb = new FlexibleHorizontalScrollView(this.mContext);
        this.gJb.setFillViewport(true);
        this.gJb.setHorizontalScrollBarEnabled(false);
        this.gJb.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.gJb.setVerticalScrollBarEnabled(false);
        this.aMU.addView(this.gJb);
        this.gkR = new TextView(context);
        this.gkR.setTextSize(0, bqz);
        this.gkR.setGravity(17);
        this.gkR.setText(d.k.cancel);
        this.gkR.setLayoutParams(new LinearLayout.LayoutParams(-1, gJg));
        this.gkR.setOnClickListener(this);
        this.aMU.addView(this.gkR);
        this.gJc = new b(context);
        this.gJd = new c(context);
        this.gJc.setShareItemClickListener(this);
        this.gJd.setShareItemClickListener(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.gJc.a(dVar, arrayList, i);
        if (this.mShareItem.axg) {
            this.gJd.setShareData(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void mO(boolean z) {
        this.gJe = z;
    }

    public void show() {
        bvB();
        bnC();
        this.acB = new AlertDialog.Builder(this.mContext).create();
        this.acB.setCanceledOnTouchOutside(true);
        this.acB.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.p.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.gJc != null) {
                    d.this.gJc.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.acB, (Activity) this.mContext);
        }
        Window window = this.acB.getWindow();
        window.setWindowAnimations(d.l.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.aMU);
        Rw();
    }

    private void bvB() {
        if (this.gJe) {
            this.gJa.addView(this.gJc.getView());
            this.gJa.setVisibility(0);
            this.gIY.setVisibility(0);
        } else {
            this.gJa.setVisibility(8);
            this.gIY.setVisibility(8);
        }
        if (this.mShareItem.axg) {
            this.gJb.addView(this.gJd.bvA());
        } else {
            this.gJb.setVisibility(8);
        }
    }

    private void bnC() {
        ak.i(this.aMU, d.C0126d.cp_bg_line_e);
        ak.h(this.mTitle, d.C0126d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.awR) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(d.k.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0126d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0126d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.axg) {
            this.mTitle.setText(d.k.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(d.k.transmit_share_not_include_outer);
        }
        ak.j(this.gIY, d.C0126d.cp_bg_line_b);
        ak.j(this.gIZ, d.C0126d.cp_bg_line_b);
        ak.c(this.gkR, d.C0126d.cp_cont_b, 1);
        ak.i(this.gkR, d.f.dialog_share_cancel_button_bg_selector);
    }

    private void Rw() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.p.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.acB != null && d.this.acB.isShowing()) {
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
        if (this.acB != null && (this.mContext instanceof Activity)) {
            g.b(this.acB, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.gkR) {
            l("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.p.a
    public void bt(View view2) {
        dismiss();
    }
}
