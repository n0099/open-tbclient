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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener, com.baidu.tieba.p.a {
    private AlertDialog acB;
    private TextView cwq;
    private ImageView goO;
    private TextView goP;
    private TextView goQ;
    private TextView goR;
    private TextView goS;
    private TextView goT;
    private SlumdogMillionaireChannelView goU;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRootView;
    private TextView mTitleView;

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.i.slumdog_millionaire_share_dialog, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_title);
        this.goO = (ImageView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_one_img);
        this.goP = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_one_txt);
        this.goQ = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_two_txt);
        this.goR = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_three_txt);
        this.goS = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_invitation_code_txt);
        this.goT = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_invitation_txt);
        this.goU = (SlumdogMillionaireChannelView) this.mRootView.findViewById(d.g.slumdog_millionaire_outer_container);
        this.cwq = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_cancel);
        this.cwq.setOnClickListener(this);
        this.goU.setShareItemClickListener(this);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShareData(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            this.goS.setText(dVar.extData);
            this.goU.setShareData(dVar);
        }
    }

    public void show() {
        onChangeSkinType();
        this.acB = new AlertDialog.Builder(this.mContext).create();
        this.acB.setCanceledOnTouchOutside(true);
        this.acB.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.slumdogMillionaire.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.mOnDismissListener != null) {
                    a.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001451);
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.acB, (Activity) this.mContext);
        }
        Window window = this.acB.getWindow();
        window.setWindowAnimations(d.l.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.mRootView);
        Rw();
    }

    private void Rw() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001451, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.slumdogMillionaire.a.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.acB != null && a.this.acB.isShowing()) {
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
    public void onClick(View view2) {
        if (view2 == this.cwq) {
            TiebaStatic.log(new al("c12916").r("obj_locate", 6));
            dismiss();
        }
    }

    @Override // com.baidu.tieba.p.a
    public void bt(View view2) {
        if (view2.getTag() instanceof Integer) {
            Integer num = (Integer) view2.getTag();
            if (num.intValue() == 4) {
                TiebaStatic.log(new al("c12916").r("obj_locate", 1));
            } else if (num.intValue() == 3) {
                TiebaStatic.log(new al("c12916").r("obj_locate", 2));
            } else if (num.intValue() == 9) {
                TiebaStatic.log(new al("c12916").r("obj_locate", 3));
            } else if (num.intValue() == 5) {
                TiebaStatic.log(new al("c12916").r("obj_locate", 4));
            } else if (num.intValue() == 7) {
                TiebaStatic.log(new al("c12916").r("obj_locate", 5));
            }
        }
        dismiss();
    }

    public void onChangeSkinType() {
        ak.i(this.mRootView, d.C0126d.cp_bg_line_e);
        ak.h(this.mTitleView, d.C0126d.cp_cont_f);
        ak.c(this.goO, d.f.blue_circle_icon);
        ak.h(this.goP, d.C0126d.cp_cont_j);
        ak.h(this.goQ, d.C0126d.cp_cont_j);
        this.goQ.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.blue_circle_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        ak.h(this.goR, d.C0126d.cp_cont_j);
        this.goR.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.blue_circle_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        ak.h(this.goS, d.C0126d.cp_cont_b);
        ak.h(this.goT, d.C0126d.cp_cont_j);
        this.goU.onChangeSkinType();
        ak.h(this.cwq, d.C0126d.cp_cont_f);
        ak.i(this.cwq, d.C0126d.cp_bg_line_d);
    }

    public void dismiss() {
        if (this.acB != null && (this.mContext instanceof Activity)) {
            g.b(this.acB, (Activity) this.mContext);
        }
    }
}
