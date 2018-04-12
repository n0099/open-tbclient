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
    public View bYq;
    public TextView fLn;
    public TextView fLo;
    public TextView fLp;
    public TextView fLq;
    public ClickableHeaderImageView fLr;
    public ClickableHeaderImageView fLs;
    public ClickableHeaderImageView fLt;
    public TextView fLu;
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
        this.bYq = view2.findViewById(d.g.bottom_divider);
        this.fLo = (TextView) view2.findViewById(d.g.month_num);
        this.fLn = (TextView) view2.findViewById(d.g.day_num);
        this.fLp = (TextView) view2.findViewById(d.g.identity);
        this.fLq = (TextView) view2.findViewById(d.g.attention_str);
        this.fLr = (ClickableHeaderImageView) view2.findViewById(d.g.header1);
        this.fLr.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fLr.setAutoChangeStyle(true);
        this.fLr.setOnClickListener(this.mOnClickListener);
        this.fLs = (ClickableHeaderImageView) view2.findViewById(d.g.header2);
        this.fLs.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fLs.setAutoChangeStyle(true);
        this.fLs.setOnClickListener(this.mOnClickListener);
        this.fLt = (ClickableHeaderImageView) view2.findViewById(d.g.header3);
        this.fLt.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fLt.setAutoChangeStyle(true);
        this.fLt.setOnClickListener(this.mOnClickListener);
        this.fLu = (TextView) view2.findViewById(d.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.home_thread_card_item_bg);
            ak.j(this.bYq, d.C0126d.cp_bg_line_c);
            ak.h(this.fLo, d.C0126d.cp_cont_f);
            ak.h(this.fLn, d.C0126d.cp_cont_f);
            ak.h(this.fLp, d.C0126d.cp_cont_f);
            ak.h(this.fLq, d.C0126d.cp_cont_f);
            ak.h(this.fLu, d.C0126d.cp_cont_c);
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
        this.fLn.setText(dVar.csz);
        this.fLo.setText(dVar.csy);
        this.fLn.setVisibility(dVar.csF ? 0 : 4);
        this.fLo.setVisibility(dVar.csF ? 0 : 4);
        if (dVar.isHost) {
            this.fLp.setText(this.mPageContext.getString(d.k.me));
        } else {
            this.fLp.setText(an.cU(dVar.sex));
        }
        int v = v.v(dVar.users);
        if (v > 3) {
            this.fLu.setVisibility(0);
            this.fLu.setText(String.format(this.mPageContext.getString(d.k.attention_etc_person), Integer.valueOf(v)));
        } else {
            this.fLu.setVisibility(8);
        }
        if (v >= 3) {
            this.fLt.setVisibility(0);
            this.fLt.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.fLt.setIsGod(true);
            } else {
                this.fLt.setIsGod(false);
            }
            this.fLt.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.fLt.setVisibility(8);
        }
        if (v >= 2) {
            this.fLs.setVisibility(0);
            this.fLs.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.fLs.setIsGod(true);
            } else {
                this.fLs.setIsGod(false);
            }
            this.fLs.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.fLs.setVisibility(8);
        }
        if (v >= 1) {
            this.fLr.setVisibility(0);
            this.fLr.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.fLr.setIsGod(true);
            } else {
                this.fLr.setIsGod(false);
            }
            this.fLr.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.fLr.setVisibility(8);
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
