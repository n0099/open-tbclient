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
    private LinearLayout aMV;
    private AlertDialog acC;
    private View gJY;
    private View gJZ;
    private FlexibleHorizontalScrollView gKa;
    private FlexibleHorizontalScrollView gKb;
    private b gKc;
    private c gKd;
    private boolean gKe;
    private TextView glU;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;
    private static final int gKf = l.e(TbadkCoreApplication.getInst(), d.e.ds90);
    private static final int gKg = l.e(TbadkCoreApplication.getInst(), d.e.ds96);
    private static final int bqO = l.e(TbadkCoreApplication.getInst(), d.e.ds32);
    private static final int gKh = l.e(TbadkCoreApplication.getInst(), d.e.ds50);
    private static final int gKi = l.e(TbadkCoreApplication.getInst(), d.e.fontsize24);
    private static final int cWI = l.e(TbadkCoreApplication.getInst(), d.e.ds1);

    public d(Context context) {
        this.mContext = context;
        this.aMV = new LinearLayout(context);
        this.aMV.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, gKi);
        this.mTitle.setPadding(gKh, 0, gKh, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setText(d.k.transmit_share_add_experience);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, gKf));
        this.aMV.addView(this.mTitle);
        this.gJY = new View(this.mContext);
        this.gJY.setLayoutParams(new LinearLayout.LayoutParams(-1, cWI));
        this.aMV.addView(this.gJY);
        this.gKa = new FlexibleHorizontalScrollView(this.mContext);
        this.gKa.setFillViewport(true);
        this.gKa.setHorizontalScrollBarEnabled(false);
        this.gKa.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.gKa.setVerticalScrollBarEnabled(false);
        this.aMV.addView(this.gKa);
        this.gJZ = new View(this.mContext);
        this.gJZ.setLayoutParams(new LinearLayout.LayoutParams(-1, cWI));
        this.aMV.addView(this.gJZ);
        this.gKb = new FlexibleHorizontalScrollView(this.mContext);
        this.gKb.setFillViewport(true);
        this.gKb.setHorizontalScrollBarEnabled(false);
        this.gKb.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.gKb.setVerticalScrollBarEnabled(false);
        this.aMV.addView(this.gKb);
        this.glU = new TextView(context);
        this.glU.setTextSize(0, bqO);
        this.glU.setGravity(17);
        this.glU.setText(d.k.cancel);
        this.glU.setLayoutParams(new LinearLayout.LayoutParams(-1, gKg));
        this.glU.setOnClickListener(this);
        this.aMV.addView(this.glU);
        this.gKc = new b(context);
        this.gKd = new c(context);
        this.gKc.setShareItemClickListener(this);
        this.gKd.setShareItemClickListener(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.gKc.a(dVar, arrayList, i);
        if (this.mShareItem.axh) {
            this.gKd.setShareData(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void mP(boolean z) {
        this.gKe = z;
    }

    public void show() {
        bvz();
        bnA();
        this.acC = new AlertDialog.Builder(this.mContext).create();
        this.acC.setCanceledOnTouchOutside(true);
        this.acC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.p.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.gKc != null) {
                    d.this.gKc.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.acC, (Activity) this.mContext);
        }
        Window window = this.acC.getWindow();
        window.setWindowAnimations(d.l.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.aMV);
        Rt();
    }

    private void bvz() {
        if (this.gKe) {
            this.gKa.addView(this.gKc.getView());
            this.gKa.setVisibility(0);
            this.gJY.setVisibility(0);
        } else {
            this.gKa.setVisibility(8);
            this.gJY.setVisibility(8);
        }
        if (this.mShareItem.axh) {
            this.gKb.addView(this.gKd.bvy());
        } else {
            this.gKb.setVisibility(8);
        }
    }

    private void bnA() {
        ak.i(this.aMV, d.C0126d.cp_bg_line_e);
        ak.h(this.mTitle, d.C0126d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.awS) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(d.k.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0126d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0126d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.axh) {
            this.mTitle.setText(d.k.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(d.k.transmit_share_not_include_outer);
        }
        ak.j(this.gJY, d.C0126d.cp_bg_line_b);
        ak.j(this.gJZ, d.C0126d.cp_bg_line_b);
        ak.c(this.glU, d.C0126d.cp_cont_b, 1);
        ak.i(this.glU, d.f.dialog_share_cancel_button_bg_selector);
    }

    private void Rt() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.p.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.acC != null && d.this.acC.isShowing()) {
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
        if (this.acC != null && (this.mContext instanceof Activity)) {
            g.b(this.acC, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.glU) {
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
