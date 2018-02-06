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
    private AlertDialog aRn;
    private TextView gPK;
    private View hnj;
    private View hnk;
    private FlexibleHorizontalScrollView hnl;
    private FlexibleHorizontalScrollView hnm;
    private b hnn;
    private c hno;
    private boolean hnp;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRootView;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private TextView mTitle;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.transmit_share_dialog, (ViewGroup) null);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.title);
        this.hnj = this.mRootView.findViewById(d.g.share_devider1);
        this.hnk = this.mRootView.findViewById(d.g.share_devider2);
        this.hnl = (FlexibleHorizontalScrollView) this.mRootView.findViewById(d.g.share_inner_container);
        this.hnm = (FlexibleHorizontalScrollView) this.mRootView.findViewById(d.g.share_outer_container);
        this.hnn = new b(context);
        this.hno = new c(context);
        this.hnn.setShareItemClickListener(this);
        this.hno.setShareItemClickListener(this);
        this.gPK = (TextView) this.mRootView.findViewById(d.g.cancel_share);
        this.gPK.setOnClickListener(this);
    }

    public void a(ArrayList<TransmitForumData> arrayList, com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        this.mShareItem = dVar;
        this.hnn.a(dVar, arrayList, i);
        if (this.mShareItem.blM) {
            this.hno.setShareData(dVar);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void nh(boolean z) {
        this.hnp = z;
    }

    public void show() {
        bAv();
        bst();
        this.aRn = new AlertDialog.Builder(this.mContext).create();
        this.aRn.setCanceledOnTouchOutside(true);
        this.aRn.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.o.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.mOnDismissListener != null) {
                    d.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (d.this.hnn != null) {
                    d.this.hnn.release();
                }
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.aRn, (Activity) this.mContext);
        }
        Window window = this.aRn.getWindow();
        window.setWindowAnimations(d.k.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.mRootView);
        YY();
    }

    private void bAv() {
        if (this.hnp) {
            this.hnl.addView(this.hnn.getView());
            this.hnl.setVisibility(0);
            this.hnj.setVisibility(0);
        } else {
            this.hnl.setVisibility(8);
            this.hnj.setVisibility(8);
        }
        if (this.mShareItem.blM) {
            this.hnm.addView(this.hno.bAu());
        } else {
            this.hnm.setVisibility(8);
        }
    }

    private void bst() {
        aj.s(this.mRootView, d.C0140d.cp_bg_line_e);
        aj.r(this.mTitle, d.C0140d.cp_cont_j);
        if (this.mShareItem != null && this.mShareItem.blx) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mContext.getString(d.j.transmit_share_add_experience));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0140d.cp_cont_h)), 11, 16, 33);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(d.C0140d.cp_cont_h_1)), 11, 16, 33);
            }
            this.mTitle.setText(spannableStringBuilder);
        } else if (this.mShareItem != null && this.mShareItem.blM) {
            this.mTitle.setText(d.j.transmit_share_not_add_experience);
        } else {
            this.mTitle.setText(d.j.transmit_share_not_include_outer);
        }
        aj.t(this.hnj, d.C0140d.cp_bg_line_b);
        aj.t(this.hnk, d.C0140d.cp_bg_line_b);
        aj.e(this.gPK, d.C0140d.cp_cont_b, 1);
        aj.s(this.gPK, d.f.dialog_share_cancel_button_bg_selector);
    }

    private void YY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.o.d.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (d.this.aRn != null && d.this.aRn.isShowing()) {
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
        if (this.aRn != null && (this.mContext instanceof Activity)) {
            g.b(this.aRn, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gPK) {
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
