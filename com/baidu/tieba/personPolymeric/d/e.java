package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    private TbPageContext<?> GM;
    private boolean bcA;
    public View bottomLine;
    public TextView eJa;
    public TextView eJb;
    public TextView eJc;
    public TextView eJd;
    public ClickableHeaderImageView eJe;
    public ClickableHeaderImageView eJf;
    public ClickableHeaderImageView eJg;
    public TextView eJh;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.GM = tbPageContext;
        View view = getView();
        UA();
        this.bottomLine = view.findViewById(t.g.bottom_divider);
        this.eJb = (TextView) view.findViewById(t.g.month_num);
        this.eJa = (TextView) view.findViewById(t.g.day_num);
        this.eJc = (TextView) view.findViewById(t.g.identity);
        this.eJd = (TextView) view.findViewById(t.g.attention_str);
        this.eJe = (ClickableHeaderImageView) view.findViewById(t.g.header1);
        this.eJe.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds100));
        this.eJe.setAutoChangeStyle(true);
        this.eJe.setOnClickListener(this.mOnClickListener);
        this.eJf = (ClickableHeaderImageView) view.findViewById(t.g.header2);
        this.eJf.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds100));
        this.eJf.setAutoChangeStyle(true);
        this.eJf.setOnClickListener(this.mOnClickListener);
        this.eJg = (ClickableHeaderImageView) view.findViewById(t.g.header3);
        this.eJg.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds100));
        this.eJg.setAutoChangeStyle(true);
        this.eJg.setOnClickListener(this.mOnClickListener);
        this.eJh = (TextView) view.findViewById(t.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(getView(), t.f.home_thread_card_item_bg);
            av.l(this.bottomLine, t.d.cp_bg_line_c);
            av.j((View) this.eJb, t.d.cp_cont_f);
            av.j((View) this.eJa, t.d.cp_cont_f);
            av.j((View) this.eJc, t.d.cp_cont_f);
            av.j((View) this.eJd, t.d.cp_cont_f);
            av.j((View) this.eJh, t.d.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.person_info_attention_card;
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
        this.bcA = cVar.bcA;
        this.eJa.setText(cVar.eHW);
        this.eJb.setText(cVar.bcr);
        this.eJa.setVisibility(cVar.bcy ? 0 : 4);
        this.eJb.setVisibility(cVar.bcy ? 0 : 4);
        if (cVar.bcA) {
            this.eJc.setText(this.GM.getString(t.j.me));
        } else {
            this.eJc.setText(ba.cT(cVar.sex));
        }
        int s = com.baidu.tbadk.core.util.y.s(cVar.users);
        if (s > 3) {
            this.eJh.setVisibility(0);
            this.eJh.setText(String.format(this.GM.getString(t.j.attention_etc_person), Integer.valueOf(s)));
        } else {
            this.eJh.setVisibility(8);
        }
        if (s >= 3) {
            this.eJg.setVisibility(0);
            this.eJg.setTag(cVar.users.get(2));
            if (cVar.users.get(2).getGodUserData() != null && cVar.users.get(2).getGodUserData().getType() == 2) {
                this.eJg.setIsGod(true);
            } else {
                this.eJg.setIsGod(false);
            }
            this.eJg.c(cVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.eJg.setVisibility(8);
        }
        if (s >= 2) {
            this.eJf.setVisibility(0);
            this.eJf.setTag(cVar.users.get(1));
            if (cVar.users.get(1).getGodUserData() != null && cVar.users.get(1).getGodUserData().getType() == 2) {
                this.eJf.setIsGod(true);
            } else {
                this.eJf.setIsGod(false);
            }
            this.eJf.c(cVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.eJf.setVisibility(8);
        }
        if (s >= 1) {
            this.eJe.setVisibility(0);
            this.eJe.setTag(cVar.users.get(0));
            if (cVar.users.get(0).getGodUserData() != null && cVar.users.get(0).getGodUserData().getType() == 2) {
                this.eJe.setIsGod(true);
            } else {
                this.eJe.setIsGod(false);
            }
            this.eJe.c(cVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.eJe.setVisibility(8);
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void UA() {
        this.mOnClickListener = new f(this);
    }
}
