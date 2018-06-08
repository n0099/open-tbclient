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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener, a {
    private LinearLayout aUT;
    private AlertDialog akG;
    private View gVA;
    private View gVB;
    private FlexibleHorizontalScrollView gVC;
    private FlexibleHorizontalScrollView gVD;
    private b gVE;
    private c gVF;
    private boolean gVG;
    private TextView gxs;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;
    private static final int gVH = l.e(TbadkCoreApplication.getInst(), d.e.ds90);
    private static final int gVI = l.e(TbadkCoreApplication.getInst(), d.e.ds96);
    private static final int byT = l.e(TbadkCoreApplication.getInst(), d.e.ds32);
    private static final int gVJ = l.e(TbadkCoreApplication.getInst(), d.e.ds50);
    private static final int gVK = l.e(TbadkCoreApplication.getInst(), d.e.fontsize24);
    private static final int dfV = l.e(TbadkCoreApplication.getInst(), d.e.ds1);

    public d(Context context) {
        this.mContext = context;
        this.aUT = new LinearLayout(context);
        this.aUT.setOrientation(1);
        this.mTitle = new TextView(context);
        this.mTitle.setTextSize(0, gVK);
        this.mTitle.setPadding(gVJ, 0, gVJ, 0);
        this.mTitle.setGravity(17);
        this.mTitle.setText(d.k.transmit_share_add_experience);
        this.mTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, gVH));
        this.aUT.addView(this.mTitle);
        this.gVA = new View(this.mContext);
        this.gVA.setLayoutParams(new LinearLayout.LayoutParams(-1, dfV));
        this.aUT.addView(this.gVA);
        this.gVC = new FlexibleHorizontalScrollView(this.mContext);
        this.gVC.setFillViewport(true);
        this.gVC.setHorizontalScrollBarEnabled(false);
        this.gVC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.gVC.setVerticalScrollBarEnabled(false);
        this.aUT.addView(this.gVC);
        this.gVB = new View(this.mContext);
        this.gVB.setLayoutParams(new LinearLayout.LayoutParams(-1, dfV));
        this.aUT.addView(this.gVB);
        this.gVD = new FlexibleHorizontalScrollView(this.mContext);
        this.gVD.setFillViewport(true);
        this.gVD.setHorizontalScrollBarEnabled(false);
        this.gVD.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.gVD.setVerticalScrollBarEnabled(false);
        this.aUT.addView(this.gVD);
        this.gxs = new TextView(context);
        this.gxs.setTextSize(0, byT);
        this.gxs.setGravity(17);
        this.gxs.setText(d.k.cancel);
        this.gxs.setLayoutParams(new LinearLayout.LayoutParams(-1, gVI));
        this.gxs.setOnClickListener(this);
        this.aUT.addView(this.gxs);
        this.gVE = new b(context);
        this.gVF = new c(context);
        this.gVE.setShareItemClickListener(this);
        this.gVF.setShareItemClickListener(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.gVE.a(dVar, arrayList, i);
        if (this.mShareItem.aFu) {
            this.gVF.setShareData(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void mV(boolean z) {
        this.gVG = z;
    }

    public void show() {
        bAG();
        bsA();
        this.akG = new AlertDialog.Builder(this.mContext, d.l.DialogTheme).create();
        this.akG.setCanceledOnTouchOutside(true);
        this.akG.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.r.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.gVE != null) {
                    d.this.gVE.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.akG, (Activity) this.mContext);
        }
        Window window = this.akG.getWindow();
        window.setWindowAnimations(d.l.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.aUT);
        UR();
    }

    private void bAG() {
        if (this.gVG) {
            this.gVC.addView(this.gVE.getView());
            this.gVC.setVisibility(0);
            this.gVA.setVisibility(0);
        } else {
            this.gVC.setVisibility(8);
            this.gVA.setVisibility(8);
        }
        if (this.mShareItem.aFu) {
            this.gVD.addView(this.gVF.bAF());
        } else {
            this.gVD.setVisibility(8);
        }
    }

    private void bsA() {
        al.i(this.aUT, d.C0141d.cp_bg_line_e);
        al.h(this.mTitle, d.C0141d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.aFf) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(d.k.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0141d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0141d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.aFu) {
            this.mTitle.setText(d.k.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(d.k.transmit_share_not_include_outer);
        }
        al.j(this.gVA, d.C0141d.cp_bg_line_b);
        al.j(this.gVB, d.C0141d.cp_bg_line_b);
        al.c(this.gxs, d.C0141d.cp_cont_b, 1);
        al.i(this.gxs, d.f.dialog_share_cancel_button_bg_selector);
    }

    private void UR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.r.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.akG != null && d.this.akG.isShowing()) {
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
        if (this.akG != null && (this.mContext instanceof Activity)) {
            g.b(this.akG, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gxs) {
            l("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.r.a
    public void bw(View view) {
        dismiss();
    }
}
