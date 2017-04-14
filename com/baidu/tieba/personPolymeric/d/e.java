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
    private TbPageContext<?> ajT;
    private boolean bho;
    public View bottomLine;
    public TextView eGr;
    public TextView eGs;
    public TextView eGt;
    public TextView eGu;
    public ClickableHeaderImageView eGv;
    public ClickableHeaderImageView eGw;
    public ClickableHeaderImageView eGx;
    public TextView eGy;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajT = tbPageContext;
        View view = getView();
        initListener();
        this.bottomLine = view.findViewById(w.h.bottom_divider);
        this.eGs = (TextView) view.findViewById(w.h.month_num);
        this.eGr = (TextView) view.findViewById(w.h.day_num);
        this.eGt = (TextView) view.findViewById(w.h.identity);
        this.eGu = (TextView) view.findViewById(w.h.attention_str);
        this.eGv = (ClickableHeaderImageView) view.findViewById(w.h.header1);
        this.eGv.setRadius(com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds100));
        this.eGv.setAutoChangeStyle(true);
        this.eGv.setOnClickListener(this.mOnClickListener);
        this.eGw = (ClickableHeaderImageView) view.findViewById(w.h.header2);
        this.eGw.setRadius(com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds100));
        this.eGw.setAutoChangeStyle(true);
        this.eGw.setOnClickListener(this.mOnClickListener);
        this.eGx = (ClickableHeaderImageView) view.findViewById(w.h.header3);
        this.eGx.setRadius(com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds100));
        this.eGx.setAutoChangeStyle(true);
        this.eGx.setOnClickListener(this.mOnClickListener);
        this.eGy = (TextView) view.findViewById(w.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(getView(), w.g.home_thread_card_item_bg);
            aq.k(this.bottomLine, w.e.cp_bg_line_c);
            aq.i(this.eGs, w.e.cp_cont_f);
            aq.i(this.eGr, w.e.cp_cont_f);
            aq.i(this.eGt, w.e.cp_cont_f);
            aq.i(this.eGu, w.e.cp_cont_f);
            aq.i(this.eGy, w.e.cp_cont_c);
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
        this.bho = cVar.bho;
        this.eGr.setText(cVar.eFp);
        this.eGs.setText(cVar.bvI);
        this.eGr.setVisibility(cVar.bvP ? 0 : 4);
        this.eGs.setVisibility(cVar.bvP ? 0 : 4);
        if (cVar.bho) {
            this.eGt.setText(this.ajT.getString(w.l.me));
        } else {
            this.eGt.setText(au.cV(cVar.sex));
        }
        int p = com.baidu.tbadk.core.util.x.p(cVar.users);
        if (p > 3) {
            this.eGy.setVisibility(0);
            this.eGy.setText(String.format(this.ajT.getString(w.l.attention_etc_person), Integer.valueOf(p)));
        } else {
            this.eGy.setVisibility(8);
        }
        if (p >= 3) {
            this.eGx.setVisibility(0);
            this.eGx.setTag(cVar.users.get(2));
            if (cVar.users.get(2).getGodUserData() != null && cVar.users.get(2).getGodUserData().getType() == 2) {
                this.eGx.setIsGod(true);
            } else {
                this.eGx.setIsGod(false);
            }
            this.eGx.c(cVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.eGx.setVisibility(8);
        }
        if (p >= 2) {
            this.eGw.setVisibility(0);
            this.eGw.setTag(cVar.users.get(1));
            if (cVar.users.get(1).getGodUserData() != null && cVar.users.get(1).getGodUserData().getType() == 2) {
                this.eGw.setIsGod(true);
            } else {
                this.eGw.setIsGod(false);
            }
            this.eGw.c(cVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.eGw.setVisibility(8);
        }
        if (p >= 1) {
            this.eGv.setVisibility(0);
            this.eGv.setTag(cVar.users.get(0));
            if (cVar.users.get(0).getGodUserData() != null && cVar.users.get(0).getGodUserData().getType() == 2) {
                this.eGv.setIsGod(true);
            } else {
                this.eGv.setIsGod(false);
            }
            this.eGv.c(cVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.eGv.setVisibility(8);
        }
        onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initListener() {
        this.mOnClickListener = new f(this);
    }
}
