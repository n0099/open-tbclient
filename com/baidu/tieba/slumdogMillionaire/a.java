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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener, com.baidu.tieba.o.a {
    private AlertDialog aRn;
    private TextView deJ;
    private ImageView gTG;
    private TextView gTH;
    private TextView gTI;
    private TextView gTJ;
    private TextView gTK;
    private TextView gTL;
    private SlumdogMillionaireChannelView gTM;
    private Context mContext;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRootView;
    private TextView mTitleView;

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(d.h.slumdog_millionaire_share_dialog, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_title);
        this.gTG = (ImageView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_one_img);
        this.gTH = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_one_txt);
        this.gTI = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_two_txt);
        this.gTJ = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_des_three_txt);
        this.gTK = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_invitation_code_txt);
        this.gTL = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_invitation_txt);
        this.gTM = (SlumdogMillionaireChannelView) this.mRootView.findViewById(d.g.slumdog_millionaire_outer_container);
        this.deJ = (TextView) this.mRootView.findViewById(d.g.slumdog_millionaire_cancel);
        this.deJ.setOnClickListener(this);
        this.gTM.setShareItemClickListener(this);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShareData(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            this.gTK.setText(dVar.extData);
            this.gTM.setShareData(dVar);
        }
    }

    public void show() {
        onChangeSkinType();
        this.aRn = new AlertDialog.Builder(this.mContext).create();
        this.aRn.setCanceledOnTouchOutside(true);
        this.aRn.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.slumdogMillionaire.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.mOnDismissListener != null) {
                    a.this.mOnDismissListener.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001451);
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

    private void YY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001451, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.slumdogMillionaire.a.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (a.this.aRn != null && a.this.aRn.isShowing()) {
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
        if (view == this.deJ) {
            TiebaStatic.log(new ak("c12916").s("obj_locate", 6));
            dismiss();
        }
    }

    @Override // com.baidu.tieba.o.a
    public void cN(View view) {
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (num.intValue() == 4) {
                TiebaStatic.log(new ak("c12916").s("obj_locate", 1));
            } else if (num.intValue() == 3) {
                TiebaStatic.log(new ak("c12916").s("obj_locate", 2));
            } else if (num.intValue() == 9) {
                TiebaStatic.log(new ak("c12916").s("obj_locate", 3));
            } else if (num.intValue() == 5) {
                TiebaStatic.log(new ak("c12916").s("obj_locate", 4));
            } else if (num.intValue() == 7) {
                TiebaStatic.log(new ak("c12916").s("obj_locate", 5));
            }
        }
        dismiss();
    }

    public void onChangeSkinType() {
        aj.s(this.mRootView, d.C0140d.cp_bg_line_e);
        aj.r(this.mTitleView, d.C0140d.cp_cont_f);
        aj.c(this.gTG, d.f.blue_circle_icon);
        aj.r(this.gTH, d.C0140d.cp_cont_j);
        aj.r(this.gTI, d.C0140d.cp_cont_j);
        this.gTI.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.blue_circle_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.r(this.gTJ, d.C0140d.cp_cont_j);
        this.gTJ.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.blue_circle_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.r(this.gTK, d.C0140d.cp_cont_b);
        aj.r(this.gTL, d.C0140d.cp_cont_j);
        this.gTM.onChangeSkinType();
        aj.r(this.deJ, d.C0140d.cp_cont_f);
        aj.s(this.deJ, d.C0140d.cp_bg_line_d);
    }

    public void dismiss() {
        if (this.aRn != null && (this.mContext instanceof Activity)) {
            g.b(this.aRn, (Activity) this.mContext);
        }
    }
}
