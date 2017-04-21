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
    private TbPageContext<?> ajU;
    private boolean bjz;
    public View bottomLine;
    public TextView eIH;
    public TextView eII;
    public TextView eIJ;
    public TextView eIK;
    public ClickableHeaderImageView eIL;
    public ClickableHeaderImageView eIM;
    public ClickableHeaderImageView eIN;
    public TextView eIO;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajU = tbPageContext;
        View view = getView();
        initListener();
        this.bottomLine = view.findViewById(w.h.bottom_divider);
        this.eII = (TextView) view.findViewById(w.h.month_num);
        this.eIH = (TextView) view.findViewById(w.h.day_num);
        this.eIJ = (TextView) view.findViewById(w.h.identity);
        this.eIK = (TextView) view.findViewById(w.h.attention_str);
        this.eIL = (ClickableHeaderImageView) view.findViewById(w.h.header1);
        this.eIL.setRadius(com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds100));
        this.eIL.setAutoChangeStyle(true);
        this.eIL.setOnClickListener(this.mOnClickListener);
        this.eIM = (ClickableHeaderImageView) view.findViewById(w.h.header2);
        this.eIM.setRadius(com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds100));
        this.eIM.setAutoChangeStyle(true);
        this.eIM.setOnClickListener(this.mOnClickListener);
        this.eIN = (ClickableHeaderImageView) view.findViewById(w.h.header3);
        this.eIN.setRadius(com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds100));
        this.eIN.setAutoChangeStyle(true);
        this.eIN.setOnClickListener(this.mOnClickListener);
        this.eIO = (TextView) view.findViewById(w.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(getView(), w.g.home_thread_card_item_bg);
            aq.k(this.bottomLine, w.e.cp_bg_line_c);
            aq.i(this.eII, w.e.cp_cont_f);
            aq.i(this.eIH, w.e.cp_cont_f);
            aq.i(this.eIJ, w.e.cp_cont_f);
            aq.i(this.eIK, w.e.cp_cont_f);
            aq.i(this.eIO, w.e.cp_cont_c);
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
        this.bjz = cVar.bjz;
        this.eIH.setText(cVar.eHF);
        this.eII.setText(cVar.bxZ);
        this.eIH.setVisibility(cVar.byg ? 0 : 4);
        this.eII.setVisibility(cVar.byg ? 0 : 4);
        if (cVar.bjz) {
            this.eIJ.setText(this.ajU.getString(w.l.me));
        } else {
            this.eIJ.setText(au.cV(cVar.sex));
        }
        int p = com.baidu.tbadk.core.util.x.p(cVar.users);
        if (p > 3) {
            this.eIO.setVisibility(0);
            this.eIO.setText(String.format(this.ajU.getString(w.l.attention_etc_person), Integer.valueOf(p)));
        } else {
            this.eIO.setVisibility(8);
        }
        if (p >= 3) {
            this.eIN.setVisibility(0);
            this.eIN.setTag(cVar.users.get(2));
            if (cVar.users.get(2).getGodUserData() != null && cVar.users.get(2).getGodUserData().getType() == 2) {
                this.eIN.setIsGod(true);
            } else {
                this.eIN.setIsGod(false);
            }
            this.eIN.c(cVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.eIN.setVisibility(8);
        }
        if (p >= 2) {
            this.eIM.setVisibility(0);
            this.eIM.setTag(cVar.users.get(1));
            if (cVar.users.get(1).getGodUserData() != null && cVar.users.get(1).getGodUserData().getType() == 2) {
                this.eIM.setIsGod(true);
            } else {
                this.eIM.setIsGod(false);
            }
            this.eIM.c(cVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.eIM.setVisibility(8);
        }
        if (p >= 1) {
            this.eIL.setVisibility(0);
            this.eIL.setTag(cVar.users.get(0));
            if (cVar.users.get(0).getGodUserData() != null && cVar.users.get(0).getGodUserData().getType() == 2) {
                this.eIL.setIsGod(true);
            } else {
                this.eIL.setIsGod(false);
            }
            this.eIL.c(cVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.eIL.setVisibility(8);
        }
        onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initListener() {
        this.mOnClickListener = new f(this);
    }
}
