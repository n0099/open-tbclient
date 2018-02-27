package com.baidu.tieba.o;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener, a {
    private AlertDialog aRc;
    private TextView gPv;
    private View hmW;
    private View hmX;
    private FlexibleHorizontalScrollView hmY;
    private FlexibleHorizontalScrollView hmZ;
    private b hna;
    private c hnb;
    private boolean hnc;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRootView;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.transmit_share_dialog, (ViewGroup) null);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.title);
        this.hmW = this.mRootView.findViewById(d.g.share_devider1);
        this.hmX = this.mRootView.findViewById(d.g.share_devider2);
        this.hmY = (FlexibleHorizontalScrollView) this.mRootView.findViewById(d.g.share_inner_container);
        this.hmZ = (FlexibleHorizontalScrollView) this.mRootView.findViewById(d.g.share_outer_container);
        this.hna = new b(context);
        this.hnb = new c(context);
        this.hna.setShareItemClickListener(this);
        this.hnb.setShareItemClickListener(this);
        this.gPv = (TextView) this.mRootView.findViewById(d.g.cancel_share);
        this.gPv.setOnClickListener(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.hna.a(dVar, arrayList, i);
        if (this.mShareItem.blz) {
            this.hnb.setShareData(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void nh(boolean z) {
        this.hnc = z;
    }

    public void show() {
        bAu();
        bss();
        this.aRc = new AlertDialog.Builder(this.mContext).create();
        this.aRc.setCanceledOnTouchOutside(true);
        this.aRc.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.o.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.hna != null) {
                    d.this.hna.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.aRc, (Activity) this.mContext);
        }
        Window window = this.aRc.getWindow();
        window.setWindowAnimations(d.k.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.mRootView);
        YX();
    }

    private void bAu() {
        if (this.hnc) {
            this.hmY.addView(this.hna.getView());
            this.hmY.setVisibility(0);
            this.hmW.setVisibility(0);
        } else {
            this.hmY.setVisibility(8);
            this.hmW.setVisibility(8);
        }
        if (this.mShareItem.blz) {
            this.hmZ.addView(this.hnb.bAt());
        } else {
            this.hmZ.setVisibility(8);
        }
    }

    private void bss() {
        aj.s(this.mRootView, d.C0141d.cp_bg_line_e);
        aj.r(this.mTitle, d.C0141d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.blk) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(d.j.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0141d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0141d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.blz) {
            this.mTitle.setText(d.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(d.j.transmit_share_not_include_outer);
        }
        aj.t(this.hmW, d.C0141d.cp_bg_line_b);
        aj.t(this.hmX, d.C0141d.cp_bg_line_b);
        aj.e(this.gPv, d.C0141d.cp_cont_b, 1);
        aj.s(this.gPv, d.f.dialog_share_cancel_button_bg_selector);
    }

    private void YX() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.o.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.aRc != null && d.this.aRc.isShowing()) {
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
        if (this.aRc != null && (this.mContext instanceof Activity)) {
            g.b(this.aRc, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gPv) {
            l("share_cancel", new Object[0]);
            dismiss();
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    @Override // com.baidu.tieba.o.a
    public void cN(View view) {
        dismiss();
    }
}
