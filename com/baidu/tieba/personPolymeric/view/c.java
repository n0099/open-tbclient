package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View cAJ;
    public TextView gsl;
    public TextView gsm;
    public TextView gsn;
    public TextView gso;
    public ClickableHeaderImageView gsp;
    public ClickableHeaderImageView gsq;
    public ClickableHeaderImageView gsr;
    public TextView gss;
    private boolean isHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.cAJ = view.findViewById(e.g.bottom_divider);
        this.gsm = (TextView) view.findViewById(e.g.month_num);
        this.gsl = (TextView) view.findViewById(e.g.day_num);
        this.gsn = (TextView) view.findViewById(e.g.identity);
        this.gso = (TextView) view.findViewById(e.g.attention_str);
        this.gsp = (ClickableHeaderImageView) view.findViewById(e.g.header1);
        this.gsp.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0200e.ds100));
        this.gsp.setAutoChangeStyle(true);
        this.gsp.setOnClickListener(this.mOnClickListener);
        this.gsq = (ClickableHeaderImageView) view.findViewById(e.g.header2);
        this.gsq.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0200e.ds100));
        this.gsq.setAutoChangeStyle(true);
        this.gsq.setOnClickListener(this.mOnClickListener);
        this.gsr = (ClickableHeaderImageView) view.findViewById(e.g.header3);
        this.gsr.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0200e.ds100));
        this.gsr.setAutoChangeStyle(true);
        this.gsr.setOnClickListener(this.mOnClickListener);
        this.gss = (TextView) view.findViewById(e.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.j(this.cAJ, e.d.cp_bg_line_c);
            al.h(this.gsm, e.d.cp_cont_f);
            al.h(this.gsl, e.d.cp_cont_f);
            al.h(this.gsn, e.d.cp_cont_f);
            al.h(this.gso, e.d.cp_cont_f);
            al.h(this.gss, e.d.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.person_info_attention_card;
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
        this.isHost = dVar.isHost;
        this.gsl.setText(dVar.cRW);
        this.gsm.setText(dVar.cRV);
        this.gsl.setVisibility(dVar.cSc ? 0 : 4);
        this.gsm.setVisibility(dVar.cSc ? 0 : 4);
        if (dVar.isHost) {
            this.gsn.setText(this.mPageContext.getString(e.j.me));
        } else {
            this.gsn.setText(ao.dG(dVar.sex));
        }
        int H = v.H(dVar.users);
        if (H > 3) {
            this.gss.setVisibility(0);
            this.gss.setText(String.format(this.mPageContext.getString(e.j.attention_etc_person), Integer.valueOf(H)));
        } else {
            this.gss.setVisibility(8);
        }
        if (H >= 3) {
            this.gsr.setVisibility(0);
            this.gsr.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.gsr.setIsGod(true);
            } else {
                this.gsr.setIsGod(false);
            }
            this.gsr.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.gsr.setVisibility(8);
        }
        if (H >= 2) {
            this.gsq.setVisibility(0);
            this.gsq.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.gsq.setIsGod(true);
            } else {
                this.gsq.setIsGod(false);
            }
            this.gsq.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.gsq.setVisibility(8);
        }
        if (H >= 1) {
            this.gsp.setVisibility(0);
            this.gsp.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.gsp.setIsGod(true);
            } else {
                this.gsp.setIsGod(false);
            }
            this.gsp.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.gsp.setVisibility(8);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (!c.this.isHost) {
                        TiebaStatic.log(new am("c11595"));
                    }
                    if (view.getTag() instanceof UserData) {
                        UserData userData = (UserData) view.getTag();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), userData.getUserId(), userData.getUserName(), null, "focus")));
                    }
                }
            }
        };
    }
}
