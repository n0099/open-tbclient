package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    private TbPageContext<?> GO;
    private boolean bfj;
    public View bottomLine;
    public TextView eva;
    public TextView evb;
    public TextView evc;
    public TextView evd;
    public ClickableHeaderImageView eve;
    public ClickableHeaderImageView evf;
    public ClickableHeaderImageView evg;
    public TextView evh;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.GO = tbPageContext;
        View view = getView();
        Tc();
        this.bottomLine = view.findViewById(r.g.bottom_divider);
        this.evb = (TextView) view.findViewById(r.g.month_num);
        this.eva = (TextView) view.findViewById(r.g.day_num);
        this.evc = (TextView) view.findViewById(r.g.identity);
        this.evd = (TextView) view.findViewById(r.g.attention_str);
        this.eve = (ClickableHeaderImageView) view.findViewById(r.g.header1);
        this.eve.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds100));
        this.eve.setAutoChangeStyle(true);
        this.eve.setOnClickListener(this.mOnClickListener);
        this.evf = (ClickableHeaderImageView) view.findViewById(r.g.header2);
        this.evf.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds100));
        this.evf.setAutoChangeStyle(true);
        this.evf.setOnClickListener(this.mOnClickListener);
        this.evg = (ClickableHeaderImageView) view.findViewById(r.g.header3);
        this.evg.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds100));
        this.evg.setAutoChangeStyle(true);
        this.evg.setOnClickListener(this.mOnClickListener);
        this.evh = (TextView) view.findViewById(r.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ar.k(getView(), r.f.home_thread_card_item_bg);
            ar.l(this.bottomLine, r.d.cp_bg_line_c);
            ar.j((View) this.evb, r.d.cp_cont_f);
            ar.j((View) this.eva, r.d.cp_cont_f);
            ar.j((View) this.evc, r.d.cp_cont_f);
            ar.j((View) this.evd, r.d.cp_cont_f);
            ar.j((View) this.evh, r.d.cp_cont_c);
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
        this.bfj = cVar.bfj;
        this.eva.setText(cVar.etX);
        this.evb.setText(cVar.beZ);
        this.eva.setVisibility(cVar.bfh ? 0 : 4);
        this.evb.setVisibility(cVar.bfh ? 0 : 4);
        if (cVar.bfj) {
            this.evc.setText(this.GO.getString(r.j.me));
        } else {
            this.evc.setText(av.cW(cVar.sex));
        }
        int s = com.baidu.tbadk.core.util.x.s(cVar.users);
        if (s > 3) {
            this.evh.setVisibility(0);
            this.evh.setText(String.format(this.GO.getString(r.j.attention_etc_person), Integer.valueOf(s)));
        } else {
            this.evh.setVisibility(8);
        }
        if (s >= 3) {
            this.evg.setVisibility(0);
            this.evg.setTag(cVar.users.get(2));
            if (cVar.users.get(2).getGodUserData() != null && cVar.users.get(2).getGodUserData().getType() == 2) {
                this.evg.setIsGod(true);
            } else {
                this.evg.setIsGod(false);
            }
            this.evg.c(cVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.evg.setVisibility(8);
        }
        if (s >= 2) {
            this.evf.setVisibility(0);
            this.evf.setTag(cVar.users.get(1));
            if (cVar.users.get(1).getGodUserData() != null && cVar.users.get(1).getGodUserData().getType() == 2) {
                this.evf.setIsGod(true);
            } else {
                this.evf.setIsGod(false);
            }
            this.evf.c(cVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.evf.setVisibility(8);
        }
        if (s >= 1) {
            this.eve.setVisibility(0);
            this.eve.setTag(cVar.users.get(0));
            if (cVar.users.get(0).getGodUserData() != null && cVar.users.get(0).getGodUserData().getType() == 2) {
                this.eve.setIsGod(true);
            } else {
                this.eve.setIsGod(false);
            }
            this.eve.c(cVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.eve.setVisibility(8);
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void Tc() {
        this.mOnClickListener = new f(this);
    }
}
