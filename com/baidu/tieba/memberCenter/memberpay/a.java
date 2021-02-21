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
    private HeadImageView iqm;
    private TextView kbt;
    private CardBoxMemberPayActivity loG;
    private TbImageView loH;
    private TextView loI;
    private LinearLayout loJ;
    private TextView loK;
    private TextView loL;
    private TextView loM;
    private TextView loN;
    private TextView loO;
    private LinearLayout loP;
    private List<f.d> loQ;
    private View mEmptyView;
    private View mRootView;
    private f.d loR = null;
    public String paymentPosKey = "";

    public a(CardBoxMemberPayActivity cardBoxMemberPayActivity) {
        this.loG = cardBoxMemberPayActivity;
        this.loG.setContentView(R.layout.card_box_member_pay_activity);
        this.mRootView = this.loG.findViewById(R.id.card_box_member_pay_root_view);
        this.loP = (LinearLayout) this.loG.findViewById(R.id.card_box_member_pay_info);
        this.loP.setOnClickListener(cardBoxMemberPayActivity);
        this.mEmptyView = this.loG.findViewById(R.id.empty_layout);
        this.mEmptyView.setOnClickListener(cardBoxMemberPayActivity);
        this.loH = (TbImageView) this.loG.findViewById(R.id.title_image);
        this.loI = (TextView) this.loG.findViewById(R.id.title_info);
        this.iqm = (HeadImageView) this.loG.findViewById(R.id.head_portrait);
        this.eIO = (TextView) this.loG.findViewById(R.id.user_name);
        this.kbt = (TextView) this.loG.findViewById(R.id.desc_info);
        this.loJ = (LinearLayout) this.loG.findViewById(R.id.choice_month_info);
        this.loK = (TextView) this.loG.findViewById(R.id.before_discount);
        this.loL = (TextView) this.loG.findViewById(R.id.after_discount);
        this.loM = (TextView) this.loG.findViewById(R.id.discount_desc);
        this.loN = (TextView) this.loG.findViewById(R.id.open_member_view);
        this.loN.setOnClickListener(cardBoxMemberPayActivity);
        this.loO = (TextView) this.loG.findViewById(R.id.card_box_member_agreement_view);
        this.loO.setOnClickListener(cardBoxMemberPayActivity);
        this.loK.getPaint().setFlags(16);
        this.iqm.setIsRound(true);
        this.iqm.setDrawBorder(false);
    }

    public void a(f fVar) {
        if (fVar != null) {
            c(fVar);
            dfs();
            b(fVar);
            dfu();
            dft();
        }
    }

    private void b(f fVar) {
        if (fVar != null) {
            if (fVar.lpH != null) {
                this.iqm.startLoad(fVar.lpH.mPortrait, 12, false);
                this.eIO.setText(fVar.lpH.mNameShow);
                if (fVar.lpH.lqz != null) {
                    if (fVar.lpH.lqz.lqu > 0) {
                        this.loN.setText(this.loG.getResources().getString(R.string.renew_now));
                    }
                    this.loH.startLoad(fVar.lpH.lqz.mPicUrl, 21, false);
                }
            }
            if (fVar.lpI != null && fVar.lpI.lqk != null) {
                this.kbt.setText(fVar.lpI.lqk.lqh);
                this.loI.setText(fVar.lpI.lqk.mContent);
            }
        }
    }

    private void c(f fVar) {
        if (fVar != null && fVar.lpI != null && fVar.lpI.lqk != null) {
            this.loQ = fVar.lpI.lqk.lqf;
        }
    }

    private void dfs() {
        if (this.loQ != null && this.loQ.size() > 0) {
            int size = this.loQ.size();
            for (int i = 0; i < size; i++) {
                f.d dVar = this.loQ.get(i);
                if (dVar != null && dVar.isChecked) {
                    this.loR = dVar;
                    return;
                }
            }
        }
    }

    private void dft() {
        if (this.loQ != null && this.loQ.size() > 0) {
            this.loJ.removeAllViews();
            int size = this.loQ.size();
            for (int i = 0; i < size; i++) {
                f.d dVar = this.loQ.get(i);
                if (dVar != null) {
                    TextView textView = new TextView(this.loG.getActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                    layoutParams.setMargins(0, 0, (int) this.loG.getResources().getDimension(R.dimen.ds16), 0);
                    textView.setLayoutParams(layoutParams);
                    textView.setText(bC(dVar.mTitle, 7));
                    textView.setGravity(17);
                    textView.setSingleLine(true);
                    textView.setTextSize(0, this.loG.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                    if (dVar.isChecked) {
                        this.paymentPosKey = dVar.lqo;
                        ap.setViewTextColor(textView, R.color.CAM_X0312);
                        ap.setBackgroundResource(textView, R.drawable.card_box_selected_bg);
                    } else {
                        ap.setViewTextColor(textView, R.color.CAM_X0105);
                        ap.setBackgroundResource(textView, R.drawable.card_box_normal_bg);
                    }
                    textView.setTag(dVar);
                    textView.setOnClickListener(new View$OnClickListenerC0794a(this.loQ));
                    this.loJ.addView(textView);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.memberCenter.memberpay.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC0794a implements View.OnClickListener {
        private List<f.d> iwy;

        public View$OnClickListenerC0794a(List<f.d> list) {
            this.iwy = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.loJ != null) {
                for (int i = 0; i < a.this.loJ.getChildCount(); i++) {
                    View childAt = a.this.loJ.getChildAt(i);
                    if (childAt != null && childAt.getTag() != null) {
                        f.d dVar = null;
                        if (childAt.getTag() instanceof f.d) {
                            dVar = (f.d) childAt.getTag();
                        }
                        if (dVar != null) {
                            if (view == childAt) {
                                dVar.isChecked = true;
                                a.this.loR = dVar;
                                a.this.paymentPosKey = dVar.lqo;
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
                a.this.dfu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfu() {
        if (this.loR != null) {
            this.loL.setText(this.loG.getResources().getString(R.string.yuan) + (this.loR.lqq / 100));
            if (!au.isEmpty(this.loR.lqm)) {
                this.loK.setText(this.loG.getResources().getString(R.string.origin_price) + this.loR.lqm);
            }
            this.loM.setText(this.loR.lqn);
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
        this.loG.getLayoutMode().setNightMode(i == 1);
        this.loG.getLayoutMode().onModeChanged(this.mRootView);
    }

    public LinearLayout dfv() {
        return this.loP;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public View dfw() {
        return this.loN;
    }

    public View dfx() {
        return this.loO;
    }

    public String dfy() {
        if (this.loI != null) {
            return this.loI.getText().toString();
        }
        return null;
    }

    public f.d dfz() {
        return this.loR;
    }
}
