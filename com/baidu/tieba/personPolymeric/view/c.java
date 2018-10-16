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
    public View czB;
    public TextView gqL;
    public TextView gqM;
    public TextView gqN;
    public TextView gqO;
    public ClickableHeaderImageView gqP;
    public ClickableHeaderImageView gqQ;
    public ClickableHeaderImageView gqR;
    public TextView gqS;
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
        this.czB = view.findViewById(e.g.bottom_divider);
        this.gqM = (TextView) view.findViewById(e.g.month_num);
        this.gqL = (TextView) view.findViewById(e.g.day_num);
        this.gqN = (TextView) view.findViewById(e.g.identity);
        this.gqO = (TextView) view.findViewById(e.g.attention_str);
        this.gqP = (ClickableHeaderImageView) view.findViewById(e.g.header1);
        this.gqP.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0175e.ds100));
        this.gqP.setAutoChangeStyle(true);
        this.gqP.setOnClickListener(this.mOnClickListener);
        this.gqQ = (ClickableHeaderImageView) view.findViewById(e.g.header2);
        this.gqQ.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0175e.ds100));
        this.gqQ.setAutoChangeStyle(true);
        this.gqQ.setOnClickListener(this.mOnClickListener);
        this.gqR = (ClickableHeaderImageView) view.findViewById(e.g.header3);
        this.gqR.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0175e.ds100));
        this.gqR.setAutoChangeStyle(true);
        this.gqR.setOnClickListener(this.mOnClickListener);
        this.gqS = (TextView) view.findViewById(e.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.j(this.czB, e.d.cp_bg_line_c);
            al.h(this.gqM, e.d.cp_cont_f);
            al.h(this.gqL, e.d.cp_cont_f);
            al.h(this.gqN, e.d.cp_cont_f);
            al.h(this.gqO, e.d.cp_cont_f);
            al.h(this.gqS, e.d.cp_cont_c);
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
        this.gqL.setText(dVar.cQQ);
        this.gqM.setText(dVar.cQP);
        this.gqL.setVisibility(dVar.cQW ? 0 : 4);
        this.gqM.setVisibility(dVar.cQW ? 0 : 4);
        if (dVar.isHost) {
            this.gqN.setText(this.mPageContext.getString(e.j.me));
        } else {
            this.gqN.setText(ao.ds(dVar.sex));
        }
        int I = v.I(dVar.users);
        if (I > 3) {
            this.gqS.setVisibility(0);
            this.gqS.setText(String.format(this.mPageContext.getString(e.j.attention_etc_person), Integer.valueOf(I)));
        } else {
            this.gqS.setVisibility(8);
        }
        if (I >= 3) {
            this.gqR.setVisibility(0);
            this.gqR.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.gqR.setIsGod(true);
            } else {
                this.gqR.setIsGod(false);
            }
            this.gqR.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.gqR.setVisibility(8);
        }
        if (I >= 2) {
            this.gqQ.setVisibility(0);
            this.gqQ.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.gqQ.setIsGod(true);
            } else {
                this.gqQ.setIsGod(false);
            }
            this.gqQ.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.gqQ.setVisibility(8);
        }
        if (I >= 1) {
            this.gqP.setVisibility(0);
            this.gqP.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.gqP.setIsGod(true);
            } else {
                this.gqP.setIsGod(false);
            }
            this.gqP.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.gqP.setVisibility(8);
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
