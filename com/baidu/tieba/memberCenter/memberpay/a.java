package com.baidu.tieba.memberCenter.memberpay;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberpay.f;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private TextView eGI;
    private HeadImageView ikq;
    private TextView jTE;
    private CardBoxMemberPayActivity lgl;
    private TbImageView lgm;
    private TextView lgn;
    private LinearLayout lgo;
    private TextView lgp;
    private TextView lgq;
    private TextView lgr;
    private TextView lgs;
    private TextView lgt;
    private LinearLayout lgu;
    private List<f.d> lgv;
    private View mEmptyView;
    private View mRootView;
    private f.d lgw = null;
    public String paymentPosKey = "";

    public a(CardBoxMemberPayActivity cardBoxMemberPayActivity) {
        this.lgl = cardBoxMemberPayActivity;
        this.lgl.setContentView(R.layout.card_box_member_pay_activity);
        this.mRootView = this.lgl.findViewById(R.id.card_box_member_pay_root_view);
        this.lgu = (LinearLayout) this.lgl.findViewById(R.id.card_box_member_pay_info);
        this.lgu.setOnClickListener(cardBoxMemberPayActivity);
        this.mEmptyView = this.lgl.findViewById(R.id.empty_layout);
        this.mEmptyView.setOnClickListener(cardBoxMemberPayActivity);
        this.lgm = (TbImageView) this.lgl.findViewById(R.id.title_image);
        this.lgn = (TextView) this.lgl.findViewById(R.id.title_info);
        this.ikq = (HeadImageView) this.lgl.findViewById(R.id.head_portrait);
        this.eGI = (TextView) this.lgl.findViewById(R.id.user_name);
        this.jTE = (TextView) this.lgl.findViewById(R.id.desc_info);
        this.lgo = (LinearLayout) this.lgl.findViewById(R.id.choice_month_info);
        this.lgp = (TextView) this.lgl.findViewById(R.id.before_discount);
        this.lgq = (TextView) this.lgl.findViewById(R.id.after_discount);
        this.lgr = (TextView) this.lgl.findViewById(R.id.discount_desc);
        this.lgs = (TextView) this.lgl.findViewById(R.id.open_member_view);
        this.lgs.setOnClickListener(cardBoxMemberPayActivity);
        this.lgt = (TextView) this.lgl.findViewById(R.id.card_box_member_agreement_view);
        this.lgt.setOnClickListener(cardBoxMemberPayActivity);
        this.lgp.getPaint().setFlags(16);
        this.ikq.setIsRound(true);
        this.ikq.setDrawBorder(false);
    }

    public void a(f fVar) {
        if (fVar != null) {
            c(fVar);
            ddl();
            b(fVar);
            ddn();
            ddm();
        }
    }

    private void b(f fVar) {
        if (fVar != null) {
            if (fVar.lhm != null) {
                this.ikq.startLoad(fVar.lhm.mPortrait, 12, false);
                this.eGI.setText(fVar.lhm.mNameShow);
                if (fVar.lhm.lie != null) {
                    if (fVar.lhm.lie.lhZ > 0) {
                        this.lgs.setText(this.lgl.getResources().getString(R.string.renew_now));
                    }
                    this.lgm.startLoad(fVar.lhm.lie.mPicUrl, 21, false);
                }
            }
            if (fVar.lhn != null && fVar.lhn.lhP != null) {
                this.jTE.setText(fVar.lhn.lhP.lhM);
                this.lgn.setText(fVar.lhn.lhP.mContent);
            }
        }
    }

    private void c(f fVar) {
        if (fVar != null && fVar.lhn != null && fVar.lhn.lhP != null) {
            this.lgv = fVar.lhn.lhP.lhK;
        }
    }

    private void ddl() {
        if (this.lgv != null && this.lgv.size() > 0) {
            int size = this.lgv.size();
            for (int i = 0; i < size; i++) {
                f.d dVar = this.lgv.get(i);
                if (dVar != null && dVar.isChecked) {
                    this.lgw = dVar;
                    return;
                }
            }
        }
    }

    private void ddm() {
        if (this.lgv != null && this.lgv.size() > 0) {
            this.lgo.removeAllViews();
            int size = this.lgv.size();
            for (int i = 0; i < size; i++) {
                f.d dVar = this.lgv.get(i);
                if (dVar != null) {
                    TextView textView = new TextView(this.lgl.getActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                    layoutParams.setMargins(0, 0, (int) this.lgl.getResources().getDimension(R.dimen.ds16), 0);
                    textView.setLayoutParams(layoutParams);
                    textView.setText(bC(dVar.mTitle, 7));
                    textView.setGravity(17);
                    textView.setSingleLine(true);
                    textView.setTextSize(0, this.lgl.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                    if (dVar.isChecked) {
                        this.paymentPosKey = dVar.lhT;
                        ao.setViewTextColor(textView, R.color.CAM_X0312);
                        ao.setBackgroundResource(textView, R.drawable.card_box_selected_bg);
                    } else {
                        ao.setViewTextColor(textView, R.color.CAM_X0105);
                        ao.setBackgroundResource(textView, R.drawable.card_box_normal_bg);
                    }
                    textView.setTag(dVar);
                    textView.setOnClickListener(new View$OnClickListenerC0791a(this.lgv));
                    this.lgo.addView(textView);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.memberCenter.memberpay.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC0791a implements View.OnClickListener {
        private List<f.d> iqG;

        public View$OnClickListenerC0791a(List<f.d> list) {
            this.iqG = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.lgo != null) {
                for (int i = 0; i < a.this.lgo.getChildCount(); i++) {
                    View childAt = a.this.lgo.getChildAt(i);
                    if (childAt != null && childAt.getTag() != null) {
                        f.d dVar = null;
                        if (childAt.getTag() instanceof f.d) {
                            dVar = (f.d) childAt.getTag();
                        }
                        if (dVar != null) {
                            if (view == childAt) {
                                dVar.isChecked = true;
                                a.this.lgw = dVar;
                                a.this.paymentPosKey = dVar.lhT;
                                ao.setViewTextColor(childAt, R.color.CAM_X0305);
                                ao.setBackgroundResource(childAt, R.drawable.card_box_selected_bg);
                            } else {
                                dVar.isChecked = false;
                                ao.setViewTextColor(childAt, R.color.CAM_X0105);
                                ao.setBackgroundResource(childAt, R.drawable.card_box_normal_bg);
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                a.this.ddn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddn() {
        if (this.lgw != null) {
            this.lgq.setText(this.lgl.getResources().getString(R.string.yuan) + (this.lgw.lhV / 100));
            if (!at.isEmpty(this.lgw.lhR)) {
                this.lgp.setText(this.lgl.getResources().getString(R.string.origin_price) + this.lgw.lhR);
            }
            this.lgr.setText(this.lgw.lhS);
        }
    }

    public String bC(String str, int i) {
        if (str == null) {
            return "";
        }
        if (str.length() > i) {
            return str.substring(0, i - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public void onChangeSkinType(int i) {
        this.lgl.getLayoutMode().setNightMode(i == 1);
        this.lgl.getLayoutMode().onModeChanged(this.mRootView);
    }

    public LinearLayout ddo() {
        return this.lgu;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public View ddp() {
        return this.lgs;
    }

    public View ddq() {
        return this.lgt;
    }

    public String ddr() {
        if (this.lgn != null) {
            return this.lgn.getText().toString();
        }
        return null;
    }

    public f.d dds() {
        return this.lgw;
    }
}
