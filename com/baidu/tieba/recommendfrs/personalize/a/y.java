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
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.recommendfrs.data.k, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public y(Context context) {
        super(context, com.baidu.tieba.recommendfrs.data.k.dZZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bB */
    public a b(ViewGroup viewGroup) {
        return new a(View.inflate(this.mContext, t.h.new_user_guide, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendfrs.data.k kVar, a aVar) {
        aVar.a(kVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        bx.Ki().he("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.recommendfrs.data.j jVar, int i) {
        if (jVar != null && !StringUtils.isNull(jVar.dZX)) {
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
    public class a extends y.a {
        private int aej;
        private TextView ebB;
        private View ebC;
        private TextView ebI;
        private TextView ebJ;
        private LinearLayout ebK;
        private LinearLayout ebL;
        private com.baidu.tieba.recommendfrs.data.k ebM;
        private View.OnClickListener ebN;
        private View.OnClickListener ebO;
        private View.OnClickListener ebP;

        public a(View view) {
            super(view);
            this.aej = 3;
            this.ebN = new z(this);
            this.ebO = new aa(this);
            this.ebP = new ab(this);
            this.ebB = (TextView) view.findViewById(t.g.new_user_guide_tip);
            this.ebC = view.findViewById(t.g.new_user_guide_close);
            this.ebI = (TextView) view.findViewById(t.g.new_user_guide_man);
            this.ebJ = (TextView) view.findViewById(t.g.new_user_guide_woman);
            this.ebK = (LinearLayout) view.findViewById(t.g.new_user_guide_sex_layout);
            this.ebL = (LinearLayout) view.findViewById(t.g.new_user_guide_age_layout);
            this.ebI.setOnClickListener(this.ebO);
            this.ebJ.setOnClickListener(this.ebO);
            this.ebC.setOnClickListener(this.ebN);
        }

        protected void onChangeSkinType(int i) {
            if (this.aej != i) {
                at.l(getView(), t.d.cp_bg_line_d);
                at.j((View) this.ebB, t.d.cp_cont_d);
                at.k(this.ebC, t.f.icon_x_normal);
                this.aej = i;
            }
            if (this.ebM != null && this.ebM.eaa.size() == 2) {
                if (this.ebM.eaa.get(0).dZY) {
                    at.j((View) this.ebI, t.d.cp_cont_g);
                    at.k(this.ebI, t.f.shape_semi_circle_left_selected);
                } else {
                    at.j((View) this.ebI, t.d.cp_cont_f);
                    at.k(this.ebI, t.f.shape_semi_circle_left_line);
                }
                if (this.ebM.eaa.get(1).dZY) {
                    at.j((View) this.ebJ, t.d.cp_cont_g);
                    at.k(this.ebJ, t.f.shape_semi_circle_right_selected);
                } else {
                    at.j((View) this.ebJ, t.d.cp_cont_f);
                    at.k(this.ebJ, t.f.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.ebL.getChildCount(); i2++) {
                View childAt = this.ebL.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.recommendfrs.data.j nt = nt(((TextView) childAt).getText().toString());
                    if (nt != null && nt.dZY) {
                        at.j(childAt, t.d.cp_cont_g);
                        at.k(childAt, t.f.shape_semi_circle_all_selected);
                    } else {
                        at.j(childAt, t.d.cp_cont_f);
                        at.k(childAt, t.f.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.recommendfrs.data.j nt(String str) {
            if (StringUtils.isNull(str) || this.ebM == null || this.ebM.eab == null) {
                return null;
            }
            for (com.baidu.tieba.recommendfrs.data.j jVar : this.ebM.eab) {
                if (jVar != null && str.equals(jVar.dZX)) {
                    return jVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.recommendfrs.data.k kVar) {
            if (kVar != null) {
                this.ebM = kVar;
                if (kVar.eaa.size() == 2) {
                    this.ebI.setText(kVar.eaa.get(0).dZX);
                    this.ebJ.setText(kVar.eaa.get(1).dZX);
                } else {
                    this.ebK.setVisibility(8);
                }
                this.ebL.removeAllViews();
                if (kVar.eab.size() > 0) {
                    for (int i = 0; i < kVar.eab.size(); i++) {
                        View nu = nu(kVar.eab.get(i).dZX);
                        if (nu != null) {
                            this.ebL.addView(nu);
                            if (i != kVar.eab.size() - 1) {
                                this.ebL.addView(aMP());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.recommendfrs.data.j> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.i.fq()) {
                    com.baidu.adp.lib.util.k.showToast(y.this.mContext, t.j.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.recommendfrs.data.j jVar = null;
                        for (com.baidu.tieba.recommendfrs.data.j jVar2 : list) {
                            if (charSequence.equals(jVar2.dZX)) {
                                jVar2.dZY = !jVar2.dZY;
                                jVar = jVar2;
                            } else {
                                jVar2.dZY = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
                        y.this.a(jVar, i);
                        TiebaStatic.log(new aw("c10982").ac("obj_name", charSequence));
                    }
                }
            }
        }

        private View nu(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int dimensionPixelSize = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds10);
            TextView textView = new TextView(getView().getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.fontsize24));
            textView.setText(str);
            textView.setLayoutParams(new LinearLayout.LayoutParams(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds110), TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds60)));
            textView.setOnClickListener(this.ebP);
            return textView;
        }

        private View aMP() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
