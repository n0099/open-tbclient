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
    private View gIV;
    private View gIW;
    private FlexibleHorizontalScrollView gIX;
    private FlexibleHorizontalScrollView gIY;
    private b gIZ;
    private c gJa;
    private boolean gJb;
    private TextView gkO;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;
    private static final int gJc = l.e(TbadkCoreApplication.getInst(), d.e.ds90);
    private static final int gJd = l.e(TbadkCoreApplication.getInst(), d.e.ds96);
    private static final int bqz = l.e(TbadkCoreApplication.getInst(), d.e.ds32);
    private static final int gJe = l.e(TbadkCoreApplication.getInst(), d.e.ds50);
    private static final int gJf = l.e(TbadkCoreApplication.getInst(), d.e.fontsize24);
    private static final int cVB = l.e(TbadkCoreApplication.getInst(), d.e.ds1);

    public d(Context context) {
        this.mContext = context;
        this.aMU = new LinearLayout(context);
        this.aMU.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, gJf);
        this.mTitle.setPadding(gJe, 0, gJe, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setText(d.k.transmit_share_add_experience);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, gJc));
        this.aMU.addView(this.mTitle);
        this.gIV = new View(this.mContext);
        this.gIV.setLayoutParams(new LinearLayout.LayoutParams(-1, cVB));
        this.aMU.addView(this.gIV);
        this.gIX = new FlexibleHorizontalScrollView(this.mContext);
        this.gIX.setFillViewport(true);
        this.gIX.setHorizontalScrollBarEnabled(false);
        this.gIX.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.gIX.setVerticalScrollBarEnabled(false);
        this.aMU.addView(this.gIX);
        this.gIW = new View(this.mContext);
        this.gIW.setLayoutParams(new LinearLayout.LayoutParams(-1, cVB));
        this.aMU.addView(this.gIW);
        this.gIY = new FlexibleHorizontalScrollView(this.mContext);
        this.gIY.setFillViewport(true);
        this.gIY.setHorizontalScrollBarEnabled(false);
        this.gIY.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.gIY.setVerticalScrollBarEnabled(false);
        this.aMU.addView(this.gIY);
        this.gkO = new TextView(context);
        this.gkO.setTextSize(0, bqz);
        this.gkO.setGravity(17);
        this.gkO.setText(d.k.cancel);
        this.gkO.setLayoutParams(new LinearLayout.LayoutParams(-1, gJd));
        this.gkO.setOnClickListener(this);
        this.aMU.addView(this.gkO);
        this.gIZ = new b(context);
        this.gJa = new c(context);
        this.gIZ.setShareItemClickListener(this);
        this.gJa.setShareItemClickListener(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.gIZ.a(dVar, arrayList, i);
        if (this.mShareItem.axg) {
            this.gJa.setShareData(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void mO(boolean z) {
        this.gJb = z;
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
                if (d.this.gIZ != null) {
                    d.this.gIZ.release();
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
        if (this.gJb) {
            this.gIX.addView(this.gIZ.getView());
            this.gIX.setVisibility(0);
            this.gIV.setVisibility(0);
        } else {
            this.gIX.setVisibility(8);
            this.gIV.setVisibility(8);
        }
        if (this.mShareItem.axg) {
            this.gIY.addView(this.gJa.bvA());
        } else {
            this.gIY.setVisibility(8);
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
        ak.j(this.gIV, d.C0126d.cp_bg_line_b);
        ak.j(this.gIW, d.C0126d.cp_bg_line_b);
        ak.c(this.gkO, d.C0126d.cp_cont_b, 1);
        ak.i(this.gkO, d.f.dialog_share_cancel_button_bg_selector);
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
        if (view2 == this.gkO) {
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
