package com.baidu.tieba.memberCenter.memberpay;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberpay.f;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private TextView eKp;
    private HeadImageView irV;
    private TextView kdv;
    private CardBoxMemberPayActivity lqI;
    private TbImageView lqJ;
    private TextView lqK;
    private LinearLayout lqL;
    private TextView lqM;
    private TextView lqN;
    private TextView lqO;
    private TextView lqP;
    private TextView lqQ;
    private LinearLayout lqR;
    private List<f.d> lqS;
    private View mEmptyView;
    private View mRootView;
    private f.d lqT = null;
    public String paymentPosKey = "";

    public a(CardBoxMemberPayActivity cardBoxMemberPayActivity) {
        this.lqI = cardBoxMemberPayActivity;
        this.lqI.setContentView(R.layout.card_box_member_pay_activity);
        this.mRootView = this.lqI.findViewById(R.id.card_box_member_pay_root_view);
        this.lqR = (LinearLayout) this.lqI.findViewById(R.id.card_box_member_pay_info);
        this.lqR.setOnClickListener(cardBoxMemberPayActivity);
        this.mEmptyView = this.lqI.findViewById(R.id.empty_layout);
        this.mEmptyView.setOnClickListener(cardBoxMemberPayActivity);
        this.lqJ = (TbImageView) this.lqI.findViewById(R.id.title_image);
        this.lqK = (TextView) this.lqI.findViewById(R.id.title_info);
        this.irV = (HeadImageView) this.lqI.findViewById(R.id.head_portrait);
        this.eKp = (TextView) this.lqI.findViewById(R.id.user_name);
        this.kdv = (TextView) this.lqI.findViewById(R.id.desc_info);
        this.lqL = (LinearLayout) this.lqI.findViewById(R.id.choice_month_info);
        this.lqM = (TextView) this.lqI.findViewById(R.id.before_discount);
        this.lqN = (TextView) this.lqI.findViewById(R.id.after_discount);
        this.lqO = (TextView) this.lqI.findViewById(R.id.discount_desc);
        this.lqP = (TextView) this.lqI.findViewById(R.id.open_member_view);
        this.lqP.setOnClickListener(cardBoxMemberPayActivity);
        this.lqQ = (TextView) this.lqI.findViewById(R.id.card_box_member_agreement_view);
        this.lqQ.setOnClickListener(cardBoxMemberPayActivity);
        this.lqM.getPaint().setFlags(16);
        this.irV.setIsRound(true);
        this.irV.setDrawBorder(false);
    }

    public void a(f fVar) {
        if (fVar != null) {
            c(fVar);
            dfB();
            b(fVar);
            dfD();
            dfC();
        }
    }

    private void b(f fVar) {
        if (fVar != null) {
            if (fVar.lrJ != null) {
                this.irV.startLoad(fVar.lrJ.mPortrait, 12, false);
                this.eKp.setText(fVar.lrJ.mNameShow);
                if (fVar.lrJ.lsB != null) {
                    if (fVar.lrJ.lsB.lsw > 0) {
                        this.lqP.setText(this.lqI.getResources().getString(R.string.renew_now));
                    }
                    this.lqJ.startLoad(fVar.lrJ.lsB.mPicUrl, 21, false);
                }
            }
            if (fVar.lrK != null && fVar.lrK.lsm != null) {
                this.kdv.setText(fVar.lrK.lsm.lsj);
                this.lqK.setText(fVar.lrK.lsm.mContent);
            }
        }
    }

    private void c(f fVar) {
        if (fVar != null && fVar.lrK != null && fVar.lrK.lsm != null) {
            this.lqS = fVar.lrK.lsm.lsh;
        }
    }

    private void dfB() {
        if (this.lqS != null && this.lqS.size() > 0) {
            int size = this.lqS.size();
            for (int i = 0; i < size; i++) {
                f.d dVar = this.lqS.get(i);
                if (dVar != null && dVar.isChecked) {
                    this.lqT = dVar;
                    return;
                }
            }
        }
    }

    private void dfC() {
        if (this.lqS != null && this.lqS.size() > 0) {
            this.lqL.removeAllViews();
            int size = this.lqS.size();
            for (int i = 0; i < size; i++) {
                f.d dVar = this.lqS.get(i);
                if (dVar != null) {
                    TextView textView = new TextView(this.lqI.getActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                    layoutParams.setMargins(0, 0, (int) this.lqI.getResources().getDimension(R.dimen.ds16), 0);
                    textView.setLayoutParams(layoutParams);
                    textView.setText(bC(dVar.mTitle, 7));
                    textView.setGravity(17);
                    textView.setSingleLine(true);
                    textView.setTextSize(0, this.lqI.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                    if (dVar.isChecked) {
                        this.paymentPosKey = dVar.lsq;
                        ap.setViewTextColor(textView, R.color.CAM_X0312);
                        ap.setBackgroundResource(textView, R.drawable.card_box_selected_bg);
                    } else {
                        ap.setViewTextColor(textView, R.color.CAM_X0105);
                        ap.setBackgroundResource(textView, R.drawable.card_box_normal_bg);
                    }
                    textView.setTag(dVar);
                    textView.setOnClickListener(new View$OnClickListenerC0800a(this.lqS));
                    this.lqL.addView(textView);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.memberCenter.memberpay.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC0800a implements View.OnClickListener {
        private List<f.d> iyh;

        public View$OnClickListenerC0800a(List<f.d> list) {
            this.iyh = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.lqL != null) {
                for (int i = 0; i < a.this.lqL.getChildCount(); i++) {
                    View childAt = a.this.lqL.getChildAt(i);
                    if (childAt != null && childAt.getTag() != null) {
                        f.d dVar = null;
                        if (childAt.getTag() instanceof f.d) {
                            dVar = (f.d) childAt.getTag();
                        }
                        if (dVar != null) {
                            if (view == childAt) {
                                dVar.isChecked = true;
                                a.this.lqT = dVar;
                                a.this.paymentPosKey = dVar.lsq;
                                ap.setViewTextColor(childAt, R.color.CAM_X0305);
                                ap.setBackgroundResource(childAt, R.drawable.card_box_selected_bg);
                            } else {
                                dVar.isChecked = false;
                                ap.setViewTextColor(childAt, R.color.CAM_X0105);
                                ap.setBackgroundResource(childAt, R.drawable.card_box_normal_bg);
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                a.this.dfD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfD() {
        if (this.lqT != null) {
            this.lqN.setText(this.lqI.getResources().getString(R.string.yuan) + (this.lqT.lss / 100));
            if (!au.isEmpty(this.lqT.lso)) {
                this.lqM.setText(this.lqI.getResources().getString(R.string.origin_price) + this.lqT.lso);
            }
            this.lqO.setText(this.lqT.lsp);
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
        this.lqI.getLayoutMode().setNightMode(i == 1);
        this.lqI.getLayoutMode().onModeChanged(this.mRootView);
    }

    public LinearLayout dfE() {
        return this.lqR;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public View dfF() {
        return this.lqP;
    }

    public View dfG() {
        return this.lqQ;
    }

    public String dfH() {
        if (this.lqK != null) {
            return this.lqK.getText().toString();
        }
        return null;
    }

    public f.d dfI() {
        return this.lqT;
    }
}
