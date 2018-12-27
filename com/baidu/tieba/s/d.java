package com.baidu.tieba.s;

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
    private LinearLayout aJI;
    private AlertDialog awt;
    private View hBX;
    private View hBY;
    private FlexibleHorizontalScrollView hBZ;
    private FlexibleHorizontalScrollView hCa;
    private b hCb;
    private c hCc;
    private boolean hCd;
    private TextView hcO;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;
    private static final int hCe = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds90);
    private static final int cvE = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds96);
    private static final int DS32 = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds32);
    private static final int hCf = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds50);
    private static final int hCg = l.h(TbadkCoreApplication.getInst(), e.C0210e.fontsize24);
    private static final int dIY = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds1);

    public d(Context context) {
        this.mContext = context;
        this.aJI = new LinearLayout(context);
        this.aJI.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, hCg);
        this.mTitle.setPadding(hCf, 0, hCf, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setText(e.j.transmit_share_add_experience);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, hCe));
        this.aJI.addView(this.mTitle);
        this.hBX = new View(this.mContext);
        this.hBX.setLayoutParams(new LinearLayout.LayoutParams(-1, dIY));
        this.aJI.addView(this.hBX);
        this.hBZ = new FlexibleHorizontalScrollView(this.mContext);
        this.hBZ.setFillViewport(true);
        this.hBZ.setHorizontalScrollBarEnabled(false);
        this.hBZ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.hBZ.setVerticalScrollBarEnabled(false);
        this.aJI.addView(this.hBZ);
        this.hBY = new View(this.mContext);
        this.hBY.setLayoutParams(new LinearLayout.LayoutParams(-1, dIY));
        this.aJI.addView(this.hBY);
        this.hCa = new FlexibleHorizontalScrollView(this.mContext);
        this.hCa.setFillViewport(true);
        this.hCa.setHorizontalScrollBarEnabled(false);
        this.hCa.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.hCa.setVerticalScrollBarEnabled(false);
        this.aJI.addView(this.hCa);
        this.hcO = new TextView(context);
        this.hcO.setTextSize(0, DS32);
        this.hcO.setGravity(17);
        this.hcO.setText(e.j.cancel);
        this.hcO.setLayoutParams(new LinearLayout.LayoutParams(-1, cvE));
        this.hcO.setOnClickListener(this);
        this.aJI.addView(this.hcO);
        this.hCb = new b(context);
        this.hCc = new c(context);
        this.hCb.a(this);
        this.hCc.a(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.hCb.a(dVar, arrayList, i);
        if (this.mShareItem.aSt) {
            this.hCc.o(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void nV(boolean z) {
        this.hCd = z;
    }

    public void show() {
        bIf();
        bzC();
        this.awt = new AlertDialog.Builder(this.mContext, e.k.DialogTheme).create();
        this.awt.setCanceledOnTouchOutside(true);
        this.awt.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.s.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.hCb != null) {
                    d.this.hCb.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.awt, (Activity) this.mContext);
        }
        Window window = this.awt.getWindow();
        window.setWindowAnimations(e.k.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.aJI);
        acl();
    }

    private void bIf() {
        if (this.hCd) {
            this.hBZ.addView(this.hCb.getView());
            this.hBZ.setVisibility(0);
            this.hBX.setVisibility(0);
        } else {
            this.hBZ.setVisibility(8);
            this.hBX.setVisibility(8);
        }
        if (this.mShareItem.aSt) {
            this.hCa.addView(this.hCc.bIe());
        } else {
            this.hCa.setVisibility(8);
        }
    }

    private void bzC() {
        al.i(this.aJI, e.d.cp_bg_line_e);
        al.h(this.mTitle, e.d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.aSf) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(e.j.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(e.d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.aSt) {
            this.mTitle.setText(e.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(e.j.transmit_share_not_include_outer);
        }
        al.j(this.hBX, e.d.cp_bg_line_b);
        al.j(this.hBY, e.d.cp_bg_line_b);
        al.c(this.hcO, e.d.cp_cont_b, 1);
        al.i(this.hcO, e.f.dialog_share_cancel_button_bg_selector);
    }

    private void acl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.s.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.awt != null && d.this.awt.isShowing()) {
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
        if (this.awt != null && (this.mContext instanceof Activity)) {
            g.b(this.awt, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hcO) {
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
