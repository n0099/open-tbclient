package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View cIj;
    public TextView gqM;
    public TextView gqN;
    public TextView gqO;
    public TextView gqP;
    public ClickableHeaderImageView gqQ;
    public ClickableHeaderImageView gqR;
    public ClickableHeaderImageView gqS;
    public TextView gqT;
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
        this.cIj = view.findViewById(d.g.bottom_divider);
        this.gqN = (TextView) view.findViewById(d.g.month_num);
        this.gqM = (TextView) view.findViewById(d.g.day_num);
        this.gqO = (TextView) view.findViewById(d.g.identity);
        this.gqP = (TextView) view.findViewById(d.g.attention_str);
        this.gqQ = (ClickableHeaderImageView) view.findViewById(d.g.header1);
        this.gqQ.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds100));
        this.gqQ.setAutoChangeStyle(true);
        this.gqQ.setOnClickListener(this.mOnClickListener);
        this.gqR = (ClickableHeaderImageView) view.findViewById(d.g.header2);
        this.gqR.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds100));
        this.gqR.setAutoChangeStyle(true);
        this.gqR.setOnClickListener(this.mOnClickListener);
        this.gqS = (ClickableHeaderImageView) view.findViewById(d.g.header3);
        this.gqS.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds100));
        this.gqS.setAutoChangeStyle(true);
        this.gqS.setOnClickListener(this.mOnClickListener);
        this.gqT = (TextView) view.findViewById(d.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.t(this.cIj, d.C0141d.cp_bg_line_c);
            aj.r(this.gqN, d.C0141d.cp_cont_f);
            aj.r(this.gqM, d.C0141d.cp_cont_f);
            aj.r(this.gqO, d.C0141d.cp_cont_f);
            aj.r(this.gqP, d.C0141d.cp_cont_f);
            aj.r(this.gqT, d.C0141d.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_info_attention_card;
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
        this.gqM.setText(dVar.daG);
        this.gqN.setText(dVar.daF);
        this.gqM.setVisibility(dVar.daN ? 0 : 4);
        this.gqN.setVisibility(dVar.daN ? 0 : 4);
        if (dVar.isHost) {
            this.gqO.setText(this.mPageContext.getString(d.j.me));
        } else {
            this.gqO.setText(am.fU(dVar.sex));
        }
        int D = v.D(dVar.users);
        if (D > 3) {
            this.gqT.setVisibility(0);
            this.gqT.setText(String.format(this.mPageContext.getString(d.j.attention_etc_person), Integer.valueOf(D)));
        } else {
            this.gqT.setVisibility(8);
        }
        if (D >= 3) {
            this.gqS.setVisibility(0);
            this.gqS.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.gqS.setIsGod(true);
            } else {
                this.gqS.setIsGod(false);
            }
            this.gqS.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.gqS.setVisibility(8);
        }
        if (D >= 2) {
            this.gqR.setVisibility(0);
            this.gqR.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.gqR.setIsGod(true);
            } else {
                this.gqR.setIsGod(false);
            }
            this.gqR.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.gqR.setVisibility(8);
        }
        if (D >= 1) {
            this.gqQ.setVisibility(0);
            this.gqQ.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.gqQ.setIsGod(true);
            } else {
                this.gqQ.setIsGod(false);
            }
            this.gqQ.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.gqQ.setVisibility(8);
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
                        TiebaStatic.log(new ak("c11595"));
                    }
                    if (view.getTag() instanceof UserData) {
                        UserData userData = (UserData) view.getTag();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
    }
}
