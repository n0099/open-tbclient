package com.baidu.tieba.slumdogMillionaire;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener, com.baidu.tieba.r.a {
    private AlertDialog alf;
    private TextView cDS;
    private ImageView gFh;
    private TextView gFi;
    private TextView gFj;
    private TextView gFk;
    private TextView gFl;
    private TextView gFm;
    private SlumdogMillionaireChannelView gFn;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRootView;
    private TextView mTitleView;

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.i.slumdog_millionaire_share_dialog, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_title);
        this.gFh = (ImageView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_one_img);
        this.gFi = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_one_txt);
        this.gFj = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_two_txt);
        this.gFk = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_three_txt);
        this.gFl = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_invitation_code_txt);
        this.gFm = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_invitation_txt);
        this.gFn = (SlumdogMillionaireChannelView) this.mRootView.findViewById(d.g.slumdog_millionaire_outer_container);
        this.cDS = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_cancel);
        this.cDS.setOnClickListener(this);
        this.gFn.setShareItemClickListener(this);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShareData(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            this.gFl.setText(dVar.extData);
            this.gFn.setShareData(dVar);
        }
    }

    public void show() {
        onChangeSkinType();
        this.alf = new AlertDialog.Builder(this.mContext).create();
        this.alf.setCanceledOnTouchOutside(true);
        this.alf.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.slumdogMillionaire.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.mOnDismissListener != null) {
                    a.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001451);
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.alf, (Activity) this.mContext);
        }
        Window window = this.alf.getWindow();
        window.setWindowAnimations(d.l.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.mRootView);
        Vm();
    }

    private void Vm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001451, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.slumdogMillionaire.a.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.alf != null && a.this.alf.isShowing()) {
                    a.this.dismiss();
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cDS) {
            TiebaStatic.log(new an("c12916").r("obj_locate", 6));
            dismiss();
        }
    }

    @Override // com.baidu.tieba.r.a
    public void bx(View view) {
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (num.intValue() == 4) {
                TiebaStatic.log(new an("c12916").r("obj_locate", 1));
            } else if (num.intValue() == 3) {
                TiebaStatic.log(new an("c12916").r("obj_locate", 2));
            } else if (num.intValue() == 9) {
                TiebaStatic.log(new an("c12916").r("obj_locate", 3));
            } else if (num.intValue() == 5) {
                TiebaStatic.log(new an("c12916").r("obj_locate", 4));
            } else if (num.intValue() == 7) {
                TiebaStatic.log(new an("c12916").r("obj_locate", 5));
            }
        }
        dismiss();
    }

    public void onChangeSkinType() {
        am.i(this.mRootView, d.C0142d.cp_bg_line_e);
        am.h(this.mTitleView, d.C0142d.cp_cont_f);
        am.c(this.gFh, d.f.blue_circle_icon);
        am.h(this.gFi, d.C0142d.cp_cont_j);
        am.h(this.gFj, d.C0142d.cp_cont_j);
        this.gFj.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.blue_circle_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        am.h(this.gFk, d.C0142d.cp_cont_j);
        this.gFk.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.blue_circle_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        am.h(this.gFl, d.C0142d.cp_cont_b);
        am.h(this.gFm, d.C0142d.cp_cont_j);
        this.gFn.onChangeSkinType();
        am.h(this.cDS, d.C0142d.cp_cont_f);
        am.i(this.cDS, d.C0142d.cp_bg_line_d);
    }

    public void dismiss() {
        if (this.alf != null && (this.mContext instanceof Activity)) {
            g.b(this.alf, (Activity) this.mContext);
        }
    }
}
