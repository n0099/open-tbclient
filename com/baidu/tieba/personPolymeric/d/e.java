package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    private TbPageContext<?> GM;
    private boolean bcU;
    public View bottomLine;
    public TextView eLd;
    public TextView eLe;
    public TextView eLf;
    public TextView eLg;
    public ClickableHeaderImageView eLh;
    public ClickableHeaderImageView eLi;
    public ClickableHeaderImageView eLj;
    public TextView eLk;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.GM = tbPageContext;
        View view = getView();
        UT();
        this.bottomLine = view.findViewById(r.g.bottom_divider);
        this.eLe = (TextView) view.findViewById(r.g.month_num);
        this.eLd = (TextView) view.findViewById(r.g.day_num);
        this.eLf = (TextView) view.findViewById(r.g.identity);
        this.eLg = (TextView) view.findViewById(r.g.attention_str);
        this.eLh = (ClickableHeaderImageView) view.findViewById(r.g.header1);
        this.eLh.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds100));
        this.eLh.setAutoChangeStyle(true);
        this.eLh.setOnClickListener(this.mOnClickListener);
        this.eLi = (ClickableHeaderImageView) view.findViewById(r.g.header2);
        this.eLi.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds100));
        this.eLi.setAutoChangeStyle(true);
        this.eLi.setOnClickListener(this.mOnClickListener);
        this.eLj = (ClickableHeaderImageView) view.findViewById(r.g.header3);
        this.eLj.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds100));
        this.eLj.setAutoChangeStyle(true);
        this.eLj.setOnClickListener(this.mOnClickListener);
        this.eLk = (TextView) view.findViewById(r.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(getView(), r.f.home_thread_card_item_bg);
            av.l(this.bottomLine, r.d.cp_bg_line_c);
            av.j((View) this.eLe, r.d.cp_cont_f);
            av.j((View) this.eLd, r.d.cp_cont_f);
            av.j((View) this.eLf, r.d.cp_cont_f);
            av.j((View) this.eLg, r.d.cp_cont_f);
            av.j((View) this.eLk, r.d.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.person_info_attention_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.bcU = cVar.bcU;
        this.eLd.setText(cVar.eKa);
        this.eLe.setText(cVar.bcL);
        this.eLd.setVisibility(cVar.bcS ? 0 : 4);
        this.eLe.setVisibility(cVar.bcS ? 0 : 4);
        if (cVar.bcU) {
            this.eLf.setText(this.GM.getString(r.j.me));
        } else {
            this.eLf.setText(az.cT(cVar.sex));
        }
        int s = com.baidu.tbadk.core.util.y.s(cVar.users);
        if (s > 3) {
            this.eLk.setVisibility(0);
            this.eLk.setText(String.format(this.GM.getString(r.j.attention_etc_person), Integer.valueOf(s)));
        } else {
            this.eLk.setVisibility(8);
        }
        if (s >= 3) {
            this.eLj.setVisibility(0);
            this.eLj.setTag(cVar.users.get(2));
            if (cVar.users.get(2).getGodUserData() != null && cVar.users.get(2).getGodUserData().getType() == 2) {
                this.eLj.setIsGod(true);
            } else {
                this.eLj.setIsGod(false);
            }
            this.eLj.c(cVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.eLj.setVisibility(8);
        }
        if (s >= 2) {
            this.eLi.setVisibility(0);
            this.eLi.setTag(cVar.users.get(1));
            if (cVar.users.get(1).getGodUserData() != null && cVar.users.get(1).getGodUserData().getType() == 2) {
                this.eLi.setIsGod(true);
            } else {
                this.eLi.setIsGod(false);
            }
            this.eLi.c(cVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.eLi.setVisibility(8);
        }
        if (s >= 1) {
            this.eLh.setVisibility(0);
            this.eLh.setTag(cVar.users.get(0));
            if (cVar.users.get(0).getGodUserData() != null && cVar.users.get(0).getGodUserData().getType() == 2) {
                this.eLh.setIsGod(true);
            } else {
                this.eLh.setIsGod(false);
            }
            this.eLh.c(cVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.eLh.setVisibility(8);
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void UT() {
        this.mOnClickListener = new f(this);
    }
}
