package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    private TbPageContext<?> FY;
    private boolean baK;
    public View bottomLine;
    public TextView eEU;
    public TextView eEV;
    public TextView eEW;
    public TextView eEX;
    public ClickableHeaderImageView eEY;
    public ClickableHeaderImageView eEZ;
    public ClickableHeaderImageView eFa;
    public TextView eFb;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.FY = tbPageContext;
        View view = getView();
        Mj();
        this.bottomLine = view.findViewById(r.h.bottom_divider);
        this.eEV = (TextView) view.findViewById(r.h.month_num);
        this.eEU = (TextView) view.findViewById(r.h.day_num);
        this.eEW = (TextView) view.findViewById(r.h.identity);
        this.eEX = (TextView) view.findViewById(r.h.attention_str);
        this.eEY = (ClickableHeaderImageView) view.findViewById(r.h.header1);
        this.eEY.setRadius(com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds100));
        this.eEY.setAutoChangeStyle(true);
        this.eEY.setOnClickListener(this.mOnClickListener);
        this.eEZ = (ClickableHeaderImageView) view.findViewById(r.h.header2);
        this.eEZ.setRadius(com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds100));
        this.eEZ.setAutoChangeStyle(true);
        this.eEZ.setOnClickListener(this.mOnClickListener);
        this.eFa = (ClickableHeaderImageView) view.findViewById(r.h.header3);
        this.eFa.setRadius(com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds100));
        this.eFa.setAutoChangeStyle(true);
        this.eFa.setOnClickListener(this.mOnClickListener);
        this.eFb = (TextView) view.findViewById(r.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.j(getView(), r.g.home_thread_card_item_bg);
            ap.k(this.bottomLine, r.e.cp_bg_line_c);
            ap.i((View) this.eEV, r.e.cp_cont_f);
            ap.i((View) this.eEU, r.e.cp_cont_f);
            ap.i((View) this.eEW, r.e.cp_cont_f);
            ap.i((View) this.eEX, r.e.cp_cont_f);
            ap.i((View) this.eFb, r.e.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.person_info_attention_card;
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
        this.baK = cVar.baK;
        this.eEU.setText(cVar.eDR);
        this.eEV.setText(cVar.boU);
        this.eEU.setVisibility(cVar.bpb ? 0 : 4);
        this.eEV.setVisibility(cVar.bpb ? 0 : 4);
        if (cVar.baK) {
            this.eEW.setText(this.FY.getString(r.l.me));
        } else {
            this.eEW.setText(at.cW(cVar.sex));
        }
        int r = com.baidu.tbadk.core.util.w.r(cVar.users);
        if (r > 3) {
            this.eFb.setVisibility(0);
            this.eFb.setText(String.format(this.FY.getString(r.l.attention_etc_person), Integer.valueOf(r)));
        } else {
            this.eFb.setVisibility(8);
        }
        if (r >= 3) {
            this.eFa.setVisibility(0);
            this.eFa.setTag(cVar.users.get(2));
            if (cVar.users.get(2).getGodUserData() != null && cVar.users.get(2).getGodUserData().getType() == 2) {
                this.eFa.setIsGod(true);
            } else {
                this.eFa.setIsGod(false);
            }
            this.eFa.c(cVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.eFa.setVisibility(8);
        }
        if (r >= 2) {
            this.eEZ.setVisibility(0);
            this.eEZ.setTag(cVar.users.get(1));
            if (cVar.users.get(1).getGodUserData() != null && cVar.users.get(1).getGodUserData().getType() == 2) {
                this.eEZ.setIsGod(true);
            } else {
                this.eEZ.setIsGod(false);
            }
            this.eEZ.c(cVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.eEZ.setVisibility(8);
        }
        if (r >= 1) {
            this.eEY.setVisibility(0);
            this.eEY.setTag(cVar.users.get(0));
            if (cVar.users.get(0).getGodUserData() != null && cVar.users.get(0).getGodUserData().getType() == 2) {
                this.eEY.setIsGod(true);
            } else {
                this.eEY.setIsGod(false);
            }
            this.eEY.c(cVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.eEY.setVisibility(8);
        }
        onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void Mj() {
        this.mOnClickListener = new f(this);
    }
}
