package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    private TbPageContext<?> GO;
    private boolean bfT;
    public View bottomLine;
    public TextView eRB;
    public TextView eRC;
    public TextView eRD;
    public TextView eRE;
    public ClickableHeaderImageView eRF;
    public ClickableHeaderImageView eRG;
    public ClickableHeaderImageView eRH;
    public TextView eRI;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.GO = tbPageContext;
        View view = getView();
        VV();
        this.bottomLine = view.findViewById(r.g.bottom_divider);
        this.eRC = (TextView) view.findViewById(r.g.month_num);
        this.eRB = (TextView) view.findViewById(r.g.day_num);
        this.eRD = (TextView) view.findViewById(r.g.identity);
        this.eRE = (TextView) view.findViewById(r.g.attention_str);
        this.eRF = (ClickableHeaderImageView) view.findViewById(r.g.header1);
        this.eRF.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds100));
        this.eRF.setAutoChangeStyle(true);
        this.eRF.setOnClickListener(this.mOnClickListener);
        this.eRG = (ClickableHeaderImageView) view.findViewById(r.g.header2);
        this.eRG.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds100));
        this.eRG.setAutoChangeStyle(true);
        this.eRG.setOnClickListener(this.mOnClickListener);
        this.eRH = (ClickableHeaderImageView) view.findViewById(r.g.header3);
        this.eRH.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds100));
        this.eRH.setAutoChangeStyle(true);
        this.eRH.setOnClickListener(this.mOnClickListener);
        this.eRI = (TextView) view.findViewById(r.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            at.k(getView(), r.f.home_thread_card_item_bg);
            at.l(this.bottomLine, r.d.cp_bg_line_c);
            at.j((View) this.eRC, r.d.cp_cont_f);
            at.j((View) this.eRB, r.d.cp_cont_f);
            at.j((View) this.eRD, r.d.cp_cont_f);
            at.j((View) this.eRE, r.d.cp_cont_f);
            at.j((View) this.eRI, r.d.cp_cont_c);
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
        this.bfT = cVar.bfT;
        this.eRB.setText(cVar.eQy);
        this.eRC.setText(cVar.bfK);
        this.eRB.setVisibility(cVar.bfR ? 0 : 4);
        this.eRC.setVisibility(cVar.bfR ? 0 : 4);
        if (cVar.bfT) {
            this.eRD.setText(this.GO.getString(r.j.me));
        } else {
            this.eRD.setText(ax.cU(cVar.sex));
        }
        int s = com.baidu.tbadk.core.util.x.s(cVar.users);
        if (s > 3) {
            this.eRI.setVisibility(0);
            this.eRI.setText(String.format(this.GO.getString(r.j.attention_etc_person), Integer.valueOf(s)));
        } else {
            this.eRI.setVisibility(8);
        }
        if (s >= 3) {
            this.eRH.setVisibility(0);
            this.eRH.setTag(cVar.users.get(2));
            if (cVar.users.get(2).getGodUserData() != null && cVar.users.get(2).getGodUserData().getType() == 2) {
                this.eRH.setIsGod(true);
            } else {
                this.eRH.setIsGod(false);
            }
            this.eRH.c(cVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.eRH.setVisibility(8);
        }
        if (s >= 2) {
            this.eRG.setVisibility(0);
            this.eRG.setTag(cVar.users.get(1));
            if (cVar.users.get(1).getGodUserData() != null && cVar.users.get(1).getGodUserData().getType() == 2) {
                this.eRG.setIsGod(true);
            } else {
                this.eRG.setIsGod(false);
            }
            this.eRG.c(cVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.eRG.setVisibility(8);
        }
        if (s >= 1) {
            this.eRF.setVisibility(0);
            this.eRF.setTag(cVar.users.get(0));
            if (cVar.users.get(0).getGodUserData() != null && cVar.users.get(0).getGodUserData().getType() == 2) {
                this.eRF.setIsGod(true);
            } else {
                this.eRF.setIsGod(false);
            }
            this.eRF.c(cVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.eRF.setVisibility(8);
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void VV() {
        this.mOnClickListener = new f(this);
    }
}
