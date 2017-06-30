package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    private TbPageContext<?> ajP;
    private boolean boT;
    public View bottomLine;
    public TextView eXk;
    public TextView eXl;
    public TextView eXm;
    public TextView eXn;
    public ClickableHeaderImageView eXo;
    public ClickableHeaderImageView eXp;
    public ClickableHeaderImageView eXq;
    public TextView eXr;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajP = tbPageContext;
        View view = getView();
        initListener();
        this.bottomLine = view.findViewById(w.h.bottom_divider);
        this.eXl = (TextView) view.findViewById(w.h.month_num);
        this.eXk = (TextView) view.findViewById(w.h.day_num);
        this.eXm = (TextView) view.findViewById(w.h.identity);
        this.eXn = (TextView) view.findViewById(w.h.attention_str);
        this.eXo = (ClickableHeaderImageView) view.findViewById(w.h.header1);
        this.eXo.setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds100));
        this.eXo.setAutoChangeStyle(true);
        this.eXo.setOnClickListener(this.mOnClickListener);
        this.eXp = (ClickableHeaderImageView) view.findViewById(w.h.header2);
        this.eXp.setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds100));
        this.eXp.setAutoChangeStyle(true);
        this.eXp.setOnClickListener(this.mOnClickListener);
        this.eXq = (ClickableHeaderImageView) view.findViewById(w.h.header3);
        this.eXq.setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds100));
        this.eXq.setAutoChangeStyle(true);
        this.eXq.setOnClickListener(this.mOnClickListener);
        this.eXr = (TextView) view.findViewById(w.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            as.j(getView(), w.g.home_thread_card_item_bg);
            as.k(this.bottomLine, w.e.cp_bg_line_c);
            as.i(this.eXl, w.e.cp_cont_f);
            as.i(this.eXk, w.e.cp_cont_f);
            as.i(this.eXm, w.e.cp_cont_f);
            as.i(this.eXn, w.e.cp_cont_f);
            as.i(this.eXr, w.e.cp_cont_c);
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
        this.boT = dVar.boT;
        this.eXk.setText(dVar.eWw);
        this.eXl.setText(dVar.bEM);
        this.eXk.setVisibility(dVar.bET ? 0 : 4);
        this.eXl.setVisibility(dVar.bET ? 0 : 4);
        if (dVar.boT) {
            this.eXm.setText(this.ajP.getString(w.l.me));
        } else {
            this.eXm.setText(aw.cU(dVar.sex));
        }
        int s = com.baidu.tbadk.core.util.z.s(dVar.users);
        if (s > 3) {
            this.eXr.setVisibility(0);
            this.eXr.setText(String.format(this.ajP.getString(w.l.attention_etc_person), Integer.valueOf(s)));
        } else {
            this.eXr.setVisibility(8);
        }
        if (s >= 3) {
            this.eXq.setVisibility(0);
            this.eXq.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.eXq.setIsGod(true);
            } else {
                this.eXq.setIsGod(false);
            }
            this.eXq.c(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.eXq.setVisibility(8);
        }
        if (s >= 2) {
            this.eXp.setVisibility(0);
            this.eXp.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.eXp.setIsGod(true);
            } else {
                this.eXp.setIsGod(false);
            }
            this.eXp.c(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.eXp.setVisibility(8);
        }
        if (s >= 1) {
            this.eXo.setVisibility(0);
            this.eXo.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.eXo.setIsGod(true);
            } else {
                this.eXo.setIsGod(false);
            }
            this.eXo.c(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.eXo.setVisibility(8);
        }
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initListener() {
        this.mOnClickListener = new f(this);
    }
}
