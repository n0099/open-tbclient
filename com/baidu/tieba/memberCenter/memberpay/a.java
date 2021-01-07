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
/* loaded from: classes9.dex */
public class a {
    private TextView eLt;
    private HeadImageView ioZ;
    private TextView jYj;
    private CardBoxMemberPayActivity lkQ;
    private TbImageView lkR;
    private TextView lkS;
    private LinearLayout lkT;
    private TextView lkU;
    private TextView lkV;
    private TextView lkW;
    private TextView lkX;
    private TextView lkY;
    private LinearLayout lkZ;
    private List<f.d> lla;
    private View mEmptyView;
    private View mRootView;
    private f.d llb = null;
    public String paymentPosKey = "";

    public a(CardBoxMemberPayActivity cardBoxMemberPayActivity) {
        this.lkQ = cardBoxMemberPayActivity;
        this.lkQ.setContentView(R.layout.card_box_member_pay_activity);
        this.mRootView = this.lkQ.findViewById(R.id.card_box_member_pay_root_view);
        this.lkZ = (LinearLayout) this.lkQ.findViewById(R.id.card_box_member_pay_info);
        this.lkZ.setOnClickListener(cardBoxMemberPayActivity);
        this.mEmptyView = this.lkQ.findViewById(R.id.empty_layout);
        this.mEmptyView.setOnClickListener(cardBoxMemberPayActivity);
        this.lkR = (TbImageView) this.lkQ.findViewById(R.id.title_image);
        this.lkS = (TextView) this.lkQ.findViewById(R.id.title_info);
        this.ioZ = (HeadImageView) this.lkQ.findViewById(R.id.head_portrait);
        this.eLt = (TextView) this.lkQ.findViewById(R.id.user_name);
        this.jYj = (TextView) this.lkQ.findViewById(R.id.desc_info);
        this.lkT = (LinearLayout) this.lkQ.findViewById(R.id.choice_month_info);
        this.lkU = (TextView) this.lkQ.findViewById(R.id.before_discount);
        this.lkV = (TextView) this.lkQ.findViewById(R.id.after_discount);
        this.lkW = (TextView) this.lkQ.findViewById(R.id.discount_desc);
        this.lkX = (TextView) this.lkQ.findViewById(R.id.open_member_view);
        this.lkX.setOnClickListener(cardBoxMemberPayActivity);
        this.lkY = (TextView) this.lkQ.findViewById(R.id.card_box_member_agreement_view);
        this.lkY.setOnClickListener(cardBoxMemberPayActivity);
        this.lkU.getPaint().setFlags(16);
        this.ioZ.setIsRound(true);
        this.ioZ.setDrawBorder(false);
    }

    public void a(f fVar) {
        if (fVar != null) {
            c(fVar);
            dhd();
            b(fVar);
            dhf();
            dhe();
        }
    }

    private void b(f fVar) {
        if (fVar != null) {
            if (fVar.llR != null) {
                this.ioZ.startLoad(fVar.llR.mPortrait, 12, false);
                this.eLt.setText(fVar.llR.mNameShow);
                if (fVar.llR.lmJ != null) {
                    if (fVar.llR.lmJ.lmE > 0) {
                        this.lkX.setText(this.lkQ.getResources().getString(R.string.renew_now));
                    }
                    this.lkR.startLoad(fVar.llR.lmJ.mPicUrl, 21, false);
                }
            }
            if (fVar.llS != null && fVar.llS.lmu != null) {
                this.jYj.setText(fVar.llS.lmu.lmr);
                this.lkS.setText(fVar.llS.lmu.mContent);
            }
        }
    }

    private void c(f fVar) {
        if (fVar != null && fVar.llS != null && fVar.llS.lmu != null) {
            this.lla = fVar.llS.lmu.lmp;
        }
    }

    private void dhd() {
        if (this.lla != null && this.lla.size() > 0) {
            int size = this.lla.size();
            for (int i = 0; i < size; i++) {
                f.d dVar = this.lla.get(i);
                if (dVar != null && dVar.isChecked) {
                    this.llb = dVar;
                    return;
                }
            }
        }
    }

    private void dhe() {
        if (this.lla != null && this.lla.size() > 0) {
            this.lkT.removeAllViews();
            int size = this.lla.size();
            for (int i = 0; i < size; i++) {
                f.d dVar = this.lla.get(i);
                if (dVar != null) {
                    TextView textView = new TextView(this.lkQ.getActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                    layoutParams.setMargins(0, 0, (int) this.lkQ.getResources().getDimension(R.dimen.ds16), 0);
                    textView.setLayoutParams(layoutParams);
                    textView.setText(bB(dVar.mTitle, 7));
                    textView.setGravity(17);
                    textView.setSingleLine(true);
                    textView.setTextSize(0, this.lkQ.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                    if (dVar.isChecked) {
                        this.paymentPosKey = dVar.lmy;
                        ao.setViewTextColor(textView, R.color.CAM_X0312);
                        ao.setBackgroundResource(textView, R.drawable.card_box_selected_bg);
                    } else {
                        ao.setViewTextColor(textView, R.color.CAM_X0105);
                        ao.setBackgroundResource(textView, R.drawable.card_box_normal_bg);
                    }
                    textView.setTag(dVar);
                    textView.setOnClickListener(new View$OnClickListenerC0808a(this.lla));
                    this.lkT.addView(textView);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.memberCenter.memberpay.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC0808a implements View.OnClickListener {
        private List<f.d> ivn;

        public View$OnClickListenerC0808a(List<f.d> list) {
            this.ivn = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.lkT != null) {
                for (int i = 0; i < a.this.lkT.getChildCount(); i++) {
                    View childAt = a.this.lkT.getChildAt(i);
                    if (childAt != null && childAt.getTag() != null) {
                        f.d dVar = null;
                        if (childAt.getTag() instanceof f.d) {
                            dVar = (f.d) childAt.getTag();
                        }
                        if (dVar != null) {
                            if (view == childAt) {
                                dVar.isChecked = true;
                                a.this.llb = dVar;
                                a.this.paymentPosKey = dVar.lmy;
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
                a.this.dhf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhf() {
        if (this.llb != null) {
            this.lkV.setText(this.lkQ.getResources().getString(R.string.yuan) + (this.llb.lmA / 100));
            if (!at.isEmpty(this.llb.lmw)) {
                this.lkU.setText(this.lkQ.getResources().getString(R.string.origin_price) + this.llb.lmw);
            }
            this.lkW.setText(this.llb.lmx);
        }
    }

    public String bB(String str, int i) {
        if (str == null) {
            return "";
        }
        if (str.length() > i) {
            return str.substring(0, i - 1) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public void onChangeSkinType(int i) {
        this.lkQ.getLayoutMode().setNightMode(i == 1);
        this.lkQ.getLayoutMode().onModeChanged(this.mRootView);
    }

    public LinearLayout dhg() {
        return this.lkZ;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public View dhh() {
        return this.lkX;
    }

    public View dhi() {
        return this.lkY;
    }

    public String dhj() {
        if (this.lkS != null) {
            return this.lkS.getText().toString();
        }
        return null;
    }

    public f.d dhk() {
        return this.llb;
    }
}
