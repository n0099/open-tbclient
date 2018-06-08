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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener, com.baidu.tieba.r.a {
    private AlertDialog akG;
    private TextView cFZ;
    private ImageView gBo;
    private TextView gBp;
    private TextView gBq;
    private TextView gBr;
    private TextView gBs;
    private TextView gBt;
    private SlumdogMillionaireChannelView gBu;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRootView;
    private TextView mTitleView;

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.i.slumdog_millionaire_share_dialog, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_title);
        this.gBo = (ImageView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_one_img);
        this.gBp = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_one_txt);
        this.gBq = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_two_txt);
        this.gBr = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_three_txt);
        this.gBs = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_invitation_code_txt);
        this.gBt = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_invitation_txt);
        this.gBu = (SlumdogMillionaireChannelView) this.mRootView.findViewById(d.g.slumdog_millionaire_outer_container);
        this.cFZ = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_cancel);
        this.cFZ.setOnClickListener(this);
        this.gBu.setShareItemClickListener(this);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShareData(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            this.gBs.setText(dVar.extData);
            this.gBu.setShareData(dVar);
        }
    }

    public void show() {
        onChangeSkinType();
        this.akG = new AlertDialog.Builder(this.mContext).create();
        this.akG.setCanceledOnTouchOutside(true);
        this.akG.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.slumdogMillionaire.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.mOnDismissListener != null) {
                    a.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001451);
            }
        });
        if (this.mContext instanceof Activity) {
            g.a(this.akG, (Activity) this.mContext);
        }
        Window window = this.akG.getWindow();
        window.setWindowAnimations(d.l.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.mRootView);
        UR();
    }

    private void UR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001451, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.slumdogMillionaire.a.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.akG != null && a.this.akG.isShowing()) {
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
        if (view == this.cFZ) {
            TiebaStatic.log(new am("c12916").r("obj_locate", 6));
            dismiss();
        }
    }

    @Override // com.baidu.tieba.r.a
    public void bw(View view) {
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (num.intValue() == 4) {
                TiebaStatic.log(new am("c12916").r("obj_locate", 1));
            } else if (num.intValue() == 3) {
                TiebaStatic.log(new am("c12916").r("obj_locate", 2));
            } else if (num.intValue() == 9) {
                TiebaStatic.log(new am("c12916").r("obj_locate", 3));
            } else if (num.intValue() == 5) {
                TiebaStatic.log(new am("c12916").r("obj_locate", 4));
            } else if (num.intValue() == 7) {
                TiebaStatic.log(new am("c12916").r("obj_locate", 5));
            }
        }
        dismiss();
    }

    public void onChangeSkinType() {
        al.i(this.mRootView, d.C0141d.cp_bg_line_e);
        al.h(this.mTitleView, d.C0141d.cp_cont_f);
        al.c(this.gBo, d.f.blue_circle_icon);
        al.h(this.gBp, d.C0141d.cp_cont_j);
        al.h(this.gBq, d.C0141d.cp_cont_j);
        this.gBq.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.blue_circle_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this.gBr, d.C0141d.cp_cont_j);
        this.gBr.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.blue_circle_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this.gBs, d.C0141d.cp_cont_b);
        al.h(this.gBt, d.C0141d.cp_cont_j);
        this.gBu.onChangeSkinType();
        al.h(this.cFZ, d.C0141d.cp_cont_f);
        al.i(this.cFZ, d.C0141d.cp_bg_line_d);
    }

    public void dismiss() {
        if (this.akG != null && (this.mContext instanceof Activity)) {
            g.b(this.akG, (Activity) this.mContext);
        }
    }
}
