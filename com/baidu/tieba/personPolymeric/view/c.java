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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View bYn;
    public TextView fLk;
    public TextView fLl;
    public TextView fLm;
    public TextView fLn;
    public ClickableHeaderImageView fLo;
    public ClickableHeaderImageView fLp;
    public ClickableHeaderImageView fLq;
    public TextView fLr;
    private boolean isHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view2 = getView();
        initListener();
        this.bYn = view2.findViewById(d.g.bottom_divider);
        this.fLl = (TextView) view2.findViewById(d.g.month_num);
        this.fLk = (TextView) view2.findViewById(d.g.day_num);
        this.fLm = (TextView) view2.findViewById(d.g.identity);
        this.fLn = (TextView) view2.findViewById(d.g.attention_str);
        this.fLo = (ClickableHeaderImageView) view2.findViewById(d.g.header1);
        this.fLo.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fLo.setAutoChangeStyle(true);
        this.fLo.setOnClickListener(this.mOnClickListener);
        this.fLp = (ClickableHeaderImageView) view2.findViewById(d.g.header2);
        this.fLp.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fLp.setAutoChangeStyle(true);
        this.fLp.setOnClickListener(this.mOnClickListener);
        this.fLq = (ClickableHeaderImageView) view2.findViewById(d.g.header3);
        this.fLq.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fLq.setAutoChangeStyle(true);
        this.fLq.setOnClickListener(this.mOnClickListener);
        this.fLr = (TextView) view2.findViewById(d.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.home_thread_card_item_bg);
            ak.j(this.bYn, d.C0126d.cp_bg_line_c);
            ak.h(this.fLl, d.C0126d.cp_cont_f);
            ak.h(this.fLk, d.C0126d.cp_cont_f);
            ak.h(this.fLm, d.C0126d.cp_cont_f);
            ak.h(this.fLn, d.C0126d.cp_cont_f);
            ak.h(this.fLr, d.C0126d.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.person_info_attention_card;
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
        this.fLk.setText(dVar.csw);
        this.fLl.setText(dVar.csv);
        this.fLk.setVisibility(dVar.csC ? 0 : 4);
        this.fLl.setVisibility(dVar.csC ? 0 : 4);
        if (dVar.isHost) {
            this.fLm.setText(this.mPageContext.getString(d.k.me));
        } else {
            this.fLm.setText(an.cT(dVar.sex));
        }
        int v = v.v(dVar.users);
        if (v > 3) {
            this.fLr.setVisibility(0);
            this.fLr.setText(String.format(this.mPageContext.getString(d.k.attention_etc_person), Integer.valueOf(v)));
        } else {
            this.fLr.setVisibility(8);
        }
        if (v >= 3) {
            this.fLq.setVisibility(0);
            this.fLq.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.fLq.setIsGod(true);
            } else {
                this.fLq.setIsGod(false);
            }
            this.fLq.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.fLq.setVisibility(8);
        }
        if (v >= 2) {
            this.fLp.setVisibility(0);
            this.fLp.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.fLp.setIsGod(true);
            } else {
                this.fLp.setIsGod(false);
            }
            this.fLp.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.fLp.setVisibility(8);
        }
        if (v >= 1) {
            this.fLo.setVisibility(0);
            this.fLo.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.fLo.setIsGod(true);
            } else {
                this.fLo.setIsGod(false);
            }
            this.fLo.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.fLo.setVisibility(8);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 != null) {
                    if (!c.this.isHost) {
                        TiebaStatic.log(new al("c11595"));
                    }
                    if (view2.getTag() instanceof UserData) {
                        UserData userData = (UserData) view2.getTag();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
    }
}
