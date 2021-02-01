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
/* loaded from: classes9.dex */
public class a {
    private TextView eIO;
    private HeadImageView ipY;
    private TextView kbf;
    private TextView loA;
    private LinearLayout loB;
    private List<f.d> loC;
    private CardBoxMemberPayActivity lor;
    private TbImageView los;
    private TextView lot;
    private LinearLayout lou;
    private TextView lov;
    private TextView lox;
    private TextView loy;
    private TextView loz;
    private View mEmptyView;
    private View mRootView;
    private f.d loD = null;
    public String paymentPosKey = "";

    public a(CardBoxMemberPayActivity cardBoxMemberPayActivity) {
        this.lor = cardBoxMemberPayActivity;
        this.lor.setContentView(R.layout.card_box_member_pay_activity);
        this.mRootView = this.lor.findViewById(R.id.card_box_member_pay_root_view);
        this.loB = (LinearLayout) this.lor.findViewById(R.id.card_box_member_pay_info);
        this.loB.setOnClickListener(cardBoxMemberPayActivity);
        this.mEmptyView = this.lor.findViewById(R.id.empty_layout);
        this.mEmptyView.setOnClickListener(cardBoxMemberPayActivity);
        this.los = (TbImageView) this.lor.findViewById(R.id.title_image);
        this.lot = (TextView) this.lor.findViewById(R.id.title_info);
        this.ipY = (HeadImageView) this.lor.findViewById(R.id.head_portrait);
        this.eIO = (TextView) this.lor.findViewById(R.id.user_name);
        this.kbf = (TextView) this.lor.findViewById(R.id.desc_info);
        this.lou = (LinearLayout) this.lor.findViewById(R.id.choice_month_info);
        this.lov = (TextView) this.lor.findViewById(R.id.before_discount);
        this.lox = (TextView) this.lor.findViewById(R.id.after_discount);
        this.loy = (TextView) this.lor.findViewById(R.id.discount_desc);
        this.loz = (TextView) this.lor.findViewById(R.id.open_member_view);
        this.loz.setOnClickListener(cardBoxMemberPayActivity);
        this.loA = (TextView) this.lor.findViewById(R.id.card_box_member_agreement_view);
        this.loA.setOnClickListener(cardBoxMemberPayActivity);
        this.lov.getPaint().setFlags(16);
        this.ipY.setIsRound(true);
        this.ipY.setDrawBorder(false);
    }

    public void a(f fVar) {
        if (fVar != null) {
            c(fVar);
            dfl();
            b(fVar);
            dfn();
            dfm();
        }
    }

    private void b(f fVar) {
        if (fVar != null) {
            if (fVar.lpt != null) {
                this.ipY.startLoad(fVar.lpt.mPortrait, 12, false);
                this.eIO.setText(fVar.lpt.mNameShow);
                if (fVar.lpt.lql != null) {
                    if (fVar.lpt.lql.lqg > 0) {
                        this.loz.setText(this.lor.getResources().getString(R.string.renew_now));
                    }
                    this.los.startLoad(fVar.lpt.lql.mPicUrl, 21, false);
                }
            }
            if (fVar.lpu != null && fVar.lpu.lpW != null) {
                this.kbf.setText(fVar.lpu.lpW.lpT);
                this.lot.setText(fVar.lpu.lpW.mContent);
            }
        }
    }

    private void c(f fVar) {
        if (fVar != null && fVar.lpu != null && fVar.lpu.lpW != null) {
            this.loC = fVar.lpu.lpW.lpR;
        }
    }

    private void dfl() {
        if (this.loC != null && this.loC.size() > 0) {
            int size = this.loC.size();
            for (int i = 0; i < size; i++) {
                f.d dVar = this.loC.get(i);
                if (dVar != null && dVar.isChecked) {
                    this.loD = dVar;
                    return;
                }
            }
        }
    }

    private void dfm() {
        if (this.loC != null && this.loC.size() > 0) {
            this.lou.removeAllViews();
            int size = this.loC.size();
            for (int i = 0; i < size; i++) {
                f.d dVar = this.loC.get(i);
                if (dVar != null) {
                    TextView textView = new TextView(this.lor.getActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                    layoutParams.setMargins(0, 0, (int) this.lor.getResources().getDimension(R.dimen.ds16), 0);
                    textView.setLayoutParams(layoutParams);
                    textView.setText(bC(dVar.mTitle, 7));
                    textView.setGravity(17);
                    textView.setSingleLine(true);
                    textView.setTextSize(0, this.lor.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                    if (dVar.isChecked) {
                        this.paymentPosKey = dVar.lqa;
                        ap.setViewTextColor(textView, R.color.CAM_X0312);
                        ap.setBackgroundResource(textView, R.drawable.card_box_selected_bg);
                    } else {
                        ap.setViewTextColor(textView, R.color.CAM_X0105);
                        ap.setBackgroundResource(textView, R.drawable.card_box_normal_bg);
                    }
                    textView.setTag(dVar);
                    textView.setOnClickListener(new View$OnClickListenerC0793a(this.loC));
                    this.lou.addView(textView);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.memberCenter.memberpay.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC0793a implements View.OnClickListener {
        private List<f.d> iwk;

        public View$OnClickListenerC0793a(List<f.d> list) {
            this.iwk = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.lou != null) {
                for (int i = 0; i < a.this.lou.getChildCount(); i++) {
                    View childAt = a.this.lou.getChildAt(i);
                    if (childAt != null && childAt.getTag() != null) {
                        f.d dVar = null;
                        if (childAt.getTag() instanceof f.d) {
                            dVar = (f.d) childAt.getTag();
                        }
                        if (dVar != null) {
                            if (view == childAt) {
                                dVar.isChecked = true;
                                a.this.loD = dVar;
                                a.this.paymentPosKey = dVar.lqa;
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
                a.this.dfn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfn() {
        if (this.loD != null) {
            this.lox.setText(this.lor.getResources().getString(R.string.yuan) + (this.loD.lqc / 100));
            if (!au.isEmpty(this.loD.lpY)) {
                this.lov.setText(this.lor.getResources().getString(R.string.origin_price) + this.loD.lpY);
            }
            this.loy.setText(this.loD.lpZ);
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
        this.lor.getLayoutMode().setNightMode(i == 1);
        this.lor.getLayoutMode().onModeChanged(this.mRootView);
    }

    public LinearLayout dfo() {
        return this.loB;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public View dfp() {
        return this.loz;
    }

    public View dfq() {
        return this.loA;
    }

    public String dfr() {
        if (this.lot != null) {
            return this.lot.getText().toString();
        }
        return null;
    }

    public f.d dfs() {
        return this.loD;
    }
}
