package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    private TbPageContext<?> ajr;
    private boolean bjW;
    public View bottomLine;
    public TextView eEm;
    public TextView eEn;
    public TextView eEo;
    public TextView eEp;
    public ClickableHeaderImageView eEq;
    public ClickableHeaderImageView eEr;
    public ClickableHeaderImageView eEs;
    public TextView eEt;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajr = tbPageContext;
        View view = getView();
        initListener();
        this.bottomLine = view.findViewById(w.h.bottom_divider);
        this.eEn = (TextView) view.findViewById(w.h.month_num);
        this.eEm = (TextView) view.findViewById(w.h.day_num);
        this.eEo = (TextView) view.findViewById(w.h.identity);
        this.eEp = (TextView) view.findViewById(w.h.attention_str);
        this.eEq = (ClickableHeaderImageView) view.findViewById(w.h.header1);
        this.eEq.setRadius(com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds100));
        this.eEq.setAutoChangeStyle(true);
        this.eEq.setOnClickListener(this.mOnClickListener);
        this.eEr = (ClickableHeaderImageView) view.findViewById(w.h.header2);
        this.eEr.setRadius(com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds100));
        this.eEr.setAutoChangeStyle(true);
        this.eEr.setOnClickListener(this.mOnClickListener);
        this.eEs = (ClickableHeaderImageView) view.findViewById(w.h.header3);
        this.eEs.setRadius(com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds100));
        this.eEs.setAutoChangeStyle(true);
        this.eEs.setOnClickListener(this.mOnClickListener);
        this.eEt = (TextView) view.findViewById(w.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(getView(), w.g.home_thread_card_item_bg);
            aq.k(this.bottomLine, w.e.cp_bg_line_c);
            aq.i(this.eEn, w.e.cp_cont_f);
            aq.i(this.eEm, w.e.cp_cont_f);
            aq.i(this.eEo, w.e.cp_cont_f);
            aq.i(this.eEp, w.e.cp_cont_f);
            aq.i(this.eEt, w.e.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.person_info_attention_card;
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
        this.bjW = cVar.bjW;
        this.eEm.setText(cVar.eDa);
        this.eEn.setText(cVar.bxY);
        this.eEm.setVisibility(cVar.byg ? 0 : 4);
        this.eEn.setVisibility(cVar.byg ? 0 : 4);
        if (cVar.bjW) {
            this.eEo.setText(this.ajr.getString(w.l.me));
        } else {
            this.eEo.setText(au.cR(cVar.sex));
        }
        int q = com.baidu.tbadk.core.util.x.q(cVar.users);
        if (q > 3) {
            this.eEt.setVisibility(0);
            this.eEt.setText(String.format(this.ajr.getString(w.l.attention_etc_person), Integer.valueOf(q)));
        } else {
            this.eEt.setVisibility(8);
        }
        if (q >= 3) {
            this.eEs.setVisibility(0);
            this.eEs.setTag(cVar.users.get(2));
            if (cVar.users.get(2).getGodUserData() != null && cVar.users.get(2).getGodUserData().getType() == 2) {
                this.eEs.setIsGod(true);
            } else {
                this.eEs.setIsGod(false);
            }
            this.eEs.c(cVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.eEs.setVisibility(8);
        }
        if (q >= 2) {
            this.eEr.setVisibility(0);
            this.eEr.setTag(cVar.users.get(1));
            if (cVar.users.get(1).getGodUserData() != null && cVar.users.get(1).getGodUserData().getType() == 2) {
                this.eEr.setIsGod(true);
            } else {
                this.eEr.setIsGod(false);
            }
            this.eEr.c(cVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.eEr.setVisibility(8);
        }
        if (q >= 1) {
            this.eEq.setVisibility(0);
            this.eEq.setTag(cVar.users.get(0));
            if (cVar.users.get(0).getGodUserData() != null && cVar.users.get(0).getGodUserData().getType() == 2) {
                this.eEq.setIsGod(true);
            } else {
                this.eEq.setIsGod(false);
            }
            this.eEq.c(cVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.eEq.setVisibility(8);
        }
        onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initListener() {
        this.mOnClickListener = new f(this);
    }
}
