package com.baidu.tieba.recommendfrs.personalize.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.recommendfrs.data.k, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public y(Context context) {
        super(context, com.baidu.tieba.recommendfrs.data.k.dWP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bm */
    public a b(ViewGroup viewGroup) {
        return new a(View.inflate(this.mContext, t.h.new_user_guide, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendfrs.data.k kVar, a aVar) {
        aVar.a(kVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        cf.Lx().hd("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.recommendfrs.data.j jVar, int i) {
        if (jVar != null && !StringUtils.isNull(jVar.dWN)) {
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, jVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            } else if (i == 2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, jVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        private int aik;
        private TextView dYB;
        private TextView dYC;
        private LinearLayout dYD;
        private LinearLayout dYE;
        private com.baidu.tieba.recommendfrs.data.k dYF;
        private View.OnClickListener dYG;
        private View.OnClickListener dYH;
        private View.OnClickListener dYI;
        private TextView dYu;
        private View dYv;

        public a(View view) {
            super(view);
            this.aik = 3;
            this.dYG = new z(this);
            this.dYH = new aa(this);
            this.dYI = new ab(this);
            this.dYu = (TextView) view.findViewById(t.g.new_user_guide_tip);
            this.dYv = view.findViewById(t.g.new_user_guide_close);
            this.dYB = (TextView) view.findViewById(t.g.new_user_guide_man);
            this.dYC = (TextView) view.findViewById(t.g.new_user_guide_woman);
            this.dYD = (LinearLayout) view.findViewById(t.g.new_user_guide_sex_layout);
            this.dYE = (LinearLayout) view.findViewById(t.g.new_user_guide_age_layout);
            this.dYB.setOnClickListener(this.dYH);
            this.dYC.setOnClickListener(this.dYH);
            this.dYv.setOnClickListener(this.dYG);
        }

        protected void onChangeSkinType(int i) {
            if (this.aik != i) {
                at.l(getView(), t.d.cp_bg_line_d);
                at.j((View) this.dYu, t.d.cp_cont_d);
                at.k(this.dYv, t.f.icon_x_normal);
                this.aik = i;
            }
            if (this.dYF != null && this.dYF.dWQ.size() == 2) {
                if (this.dYF.dWQ.get(0).dWO) {
                    at.j((View) this.dYB, t.d.cp_cont_g);
                    at.k(this.dYB, t.f.shape_semi_circle_left_selected);
                } else {
                    at.j((View) this.dYB, t.d.cp_cont_f);
                    at.k(this.dYB, t.f.shape_semi_circle_left_line);
                }
                if (this.dYF.dWQ.get(1).dWO) {
                    at.j((View) this.dYC, t.d.cp_cont_g);
                    at.k(this.dYC, t.f.shape_semi_circle_right_selected);
                } else {
                    at.j((View) this.dYC, t.d.cp_cont_f);
                    at.k(this.dYC, t.f.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.dYE.getChildCount(); i2++) {
                View childAt = this.dYE.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.recommendfrs.data.j nu = nu(((TextView) childAt).getText().toString());
                    if (nu != null && nu.dWO) {
                        at.j(childAt, t.d.cp_cont_g);
                        at.k(childAt, t.f.shape_semi_circle_all_selected);
                    } else {
                        at.j(childAt, t.d.cp_cont_f);
                        at.k(childAt, t.f.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.recommendfrs.data.j nu(String str) {
            if (StringUtils.isNull(str) || this.dYF == null || this.dYF.dWR == null) {
                return null;
            }
            for (com.baidu.tieba.recommendfrs.data.j jVar : this.dYF.dWR) {
                if (jVar != null && str.equals(jVar.dWN)) {
                    return jVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.recommendfrs.data.k kVar) {
            if (kVar != null) {
                this.dYF = kVar;
                if (kVar.dWQ.size() == 2) {
                    this.dYB.setText(kVar.dWQ.get(0).dWN);
                    this.dYC.setText(kVar.dWQ.get(1).dWN);
                } else {
                    this.dYD.setVisibility(8);
                }
                this.dYE.removeAllViews();
                if (kVar.dWR.size() > 0) {
                    for (int i = 0; i < kVar.dWR.size(); i++) {
                        View nv = nv(kVar.dWR.get(i).dWN);
                        if (nv != null) {
                            this.dYE.addView(nv);
                            if (i != kVar.dWR.size() - 1) {
                                this.dYE.addView(aMC());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.recommendfrs.data.j> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.i.jf()) {
                    com.baidu.adp.lib.util.k.showToast(y.this.mContext, t.j.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.recommendfrs.data.j jVar = null;
                        for (com.baidu.tieba.recommendfrs.data.j jVar2 : list) {
                            if (charSequence.equals(jVar2.dWN)) {
                                jVar2.dWO = !jVar2.dWO;
                                jVar = jVar2;
                            } else {
                                jVar2.dWO = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
                        y.this.a(jVar, i);
                        TiebaStatic.log(new aw("c10982").ac("obj_name", charSequence));
                    }
                }
            }
        }

        private View nv(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10);
            TextView textView = new TextView(getView().getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.fontsize24));
            textView.setText(str);
            textView.setLayoutParams(new LinearLayout.LayoutParams(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds110), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60)));
            textView.setOnClickListener(this.dYI);
            return textView;
        }

        private View aMC() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
