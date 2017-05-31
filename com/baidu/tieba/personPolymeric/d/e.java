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
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    private TbPageContext<?> ajh;
    private boolean bld;
    public View bottomLine;
    public TextView eNb;
    public TextView eNc;
    public TextView eNd;
    public TextView eNe;
    public ClickableHeaderImageView eNf;
    public ClickableHeaderImageView eNg;
    public ClickableHeaderImageView eNh;
    public TextView eNi;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajh = tbPageContext;
        View view = getView();
        initListener();
        this.bottomLine = view.findViewById(w.h.bottom_divider);
        this.eNc = (TextView) view.findViewById(w.h.month_num);
        this.eNb = (TextView) view.findViewById(w.h.day_num);
        this.eNd = (TextView) view.findViewById(w.h.identity);
        this.eNe = (TextView) view.findViewById(w.h.attention_str);
        this.eNf = (ClickableHeaderImageView) view.findViewById(w.h.header1);
        this.eNf.setRadius(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds100));
        this.eNf.setAutoChangeStyle(true);
        this.eNf.setOnClickListener(this.mOnClickListener);
        this.eNg = (ClickableHeaderImageView) view.findViewById(w.h.header2);
        this.eNg.setRadius(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds100));
        this.eNg.setAutoChangeStyle(true);
        this.eNg.setOnClickListener(this.mOnClickListener);
        this.eNh = (ClickableHeaderImageView) view.findViewById(w.h.header3);
        this.eNh.setRadius(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds100));
        this.eNh.setAutoChangeStyle(true);
        this.eNh.setOnClickListener(this.mOnClickListener);
        this.eNi = (TextView) view.findViewById(w.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(getView(), w.g.home_thread_card_item_bg);
            aq.k(this.bottomLine, w.e.cp_bg_line_c);
            aq.i(this.eNc, w.e.cp_cont_f);
            aq.i(this.eNb, w.e.cp_cont_f);
            aq.i(this.eNd, w.e.cp_cont_f);
            aq.i(this.eNe, w.e.cp_cont_f);
            aq.i(this.eNi, w.e.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.person_info_attention_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.d dVar) {
        if (dVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.bld = dVar.bld;
        this.eNb.setText(dVar.eMn);
        this.eNc.setText(dVar.bDU);
        this.eNb.setVisibility(dVar.bEb ? 0 : 4);
        this.eNc.setVisibility(dVar.bEb ? 0 : 4);
        if (dVar.bld) {
            this.eNd.setText(this.ajh.getString(w.l.me));
        } else {
            this.eNd.setText(au.cS(dVar.sex));
        }
        int q = com.baidu.tbadk.core.util.x.q(dVar.users);
        if (q > 3) {
            this.eNi.setVisibility(0);
            this.eNi.setText(String.format(this.ajh.getString(w.l.attention_etc_person), Integer.valueOf(q)));
        } else {
            this.eNi.setVisibility(8);
        }
        if (q >= 3) {
            this.eNh.setVisibility(0);
            this.eNh.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.eNh.setIsGod(true);
            } else {
                this.eNh.setIsGod(false);
            }
            this.eNh.c(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.eNh.setVisibility(8);
        }
        if (q >= 2) {
            this.eNg.setVisibility(0);
            this.eNg.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.eNg.setIsGod(true);
            } else {
                this.eNg.setIsGod(false);
            }
            this.eNg.c(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.eNg.setVisibility(8);
        }
        if (q >= 1) {
            this.eNf.setVisibility(0);
            this.eNf.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.eNf.setIsGod(true);
            } else {
                this.eNf.setIsGod(false);
            }
            this.eNf.c(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.eNf.setVisibility(8);
        }
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initListener() {
        this.mOnClickListener = new f(this);
    }
}
