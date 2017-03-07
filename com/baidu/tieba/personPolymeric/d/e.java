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
    private TbPageContext<?> ajF;
    private boolean bhu;
    public View bottomLine;
    public ClickableHeaderImageView eIA;
    public ClickableHeaderImageView eIB;
    public ClickableHeaderImageView eIC;
    public TextView eID;
    public TextView eIw;
    public TextView eIx;
    public TextView eIy;
    public TextView eIz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajF = tbPageContext;
        View view = getView();
        MV();
        this.bottomLine = view.findViewById(w.h.bottom_divider);
        this.eIx = (TextView) view.findViewById(w.h.month_num);
        this.eIw = (TextView) view.findViewById(w.h.day_num);
        this.eIy = (TextView) view.findViewById(w.h.identity);
        this.eIz = (TextView) view.findViewById(w.h.attention_str);
        this.eIA = (ClickableHeaderImageView) view.findViewById(w.h.header1);
        this.eIA.setRadius(com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds100));
        this.eIA.setAutoChangeStyle(true);
        this.eIA.setOnClickListener(this.mOnClickListener);
        this.eIB = (ClickableHeaderImageView) view.findViewById(w.h.header2);
        this.eIB.setRadius(com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds100));
        this.eIB.setAutoChangeStyle(true);
        this.eIB.setOnClickListener(this.mOnClickListener);
        this.eIC = (ClickableHeaderImageView) view.findViewById(w.h.header3);
        this.eIC.setRadius(com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds100));
        this.eIC.setAutoChangeStyle(true);
        this.eIC.setOnClickListener(this.mOnClickListener);
        this.eID = (TextView) view.findViewById(w.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(getView(), w.g.home_thread_card_item_bg);
            aq.k(this.bottomLine, w.e.cp_bg_line_c);
            aq.i((View) this.eIx, w.e.cp_cont_f);
            aq.i((View) this.eIw, w.e.cp_cont_f);
            aq.i((View) this.eIy, w.e.cp_cont_f);
            aq.i((View) this.eIz, w.e.cp_cont_f);
            aq.i((View) this.eID, w.e.cp_cont_c);
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
        this.bhu = cVar.bhu;
        this.eIw.setText(cVar.eHt);
        this.eIx.setText(cVar.bvP);
        this.eIw.setVisibility(cVar.bvW ? 0 : 4);
        this.eIx.setVisibility(cVar.bvW ? 0 : 4);
        if (cVar.bhu) {
            this.eIy.setText(this.ajF.getString(w.l.me));
        } else {
            this.eIy.setText(au.cS(cVar.sex));
        }
        int p = com.baidu.tbadk.core.util.x.p(cVar.users);
        if (p > 3) {
            this.eID.setVisibility(0);
            this.eID.setText(String.format(this.ajF.getString(w.l.attention_etc_person), Integer.valueOf(p)));
        } else {
            this.eID.setVisibility(8);
        }
        if (p >= 3) {
            this.eIC.setVisibility(0);
            this.eIC.setTag(cVar.users.get(2));
            if (cVar.users.get(2).getGodUserData() != null && cVar.users.get(2).getGodUserData().getType() == 2) {
                this.eIC.setIsGod(true);
            } else {
                this.eIC.setIsGod(false);
            }
            this.eIC.c(cVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.eIC.setVisibility(8);
        }
        if (p >= 2) {
            this.eIB.setVisibility(0);
            this.eIB.setTag(cVar.users.get(1));
            if (cVar.users.get(1).getGodUserData() != null && cVar.users.get(1).getGodUserData().getType() == 2) {
                this.eIB.setIsGod(true);
            } else {
                this.eIB.setIsGod(false);
            }
            this.eIB.c(cVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.eIB.setVisibility(8);
        }
        if (p >= 1) {
            this.eIA.setVisibility(0);
            this.eIA.setTag(cVar.users.get(0));
            if (cVar.users.get(0).getGodUserData() != null && cVar.users.get(0).getGodUserData().getType() == 2) {
                this.eIA.setIsGod(true);
            } else {
                this.eIA.setIsGod(false);
            }
            this.eIA.c(cVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.eIA.setVisibility(8);
        }
        onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void MV() {
        this.mOnClickListener = new f(this);
    }
}
