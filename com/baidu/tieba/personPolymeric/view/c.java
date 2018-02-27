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
    public View cIg;
    public ClickableHeaderImageView gqA;
    public ClickableHeaderImageView gqB;
    public ClickableHeaderImageView gqC;
    public TextView gqD;
    public TextView gqw;
    public TextView gqx;
    public TextView gqy;
    public TextView gqz;
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
        this.cIg = view.findViewById(d.g.bottom_divider);
        this.gqx = (TextView) view.findViewById(d.g.month_num);
        this.gqw = (TextView) view.findViewById(d.g.day_num);
        this.gqy = (TextView) view.findViewById(d.g.identity);
        this.gqz = (TextView) view.findViewById(d.g.attention_str);
        this.gqA = (ClickableHeaderImageView) view.findViewById(d.g.header1);
        this.gqA.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds100));
        this.gqA.setAutoChangeStyle(true);
        this.gqA.setOnClickListener(this.mOnClickListener);
        this.gqB = (ClickableHeaderImageView) view.findViewById(d.g.header2);
        this.gqB.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds100));
        this.gqB.setAutoChangeStyle(true);
        this.gqB.setOnClickListener(this.mOnClickListener);
        this.gqC = (ClickableHeaderImageView) view.findViewById(d.g.header3);
        this.gqC.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds100));
        this.gqC.setAutoChangeStyle(true);
        this.gqC.setOnClickListener(this.mOnClickListener);
        this.gqD = (TextView) view.findViewById(d.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.t(this.cIg, d.C0141d.cp_bg_line_c);
            aj.r(this.gqx, d.C0141d.cp_cont_f);
            aj.r(this.gqw, d.C0141d.cp_cont_f);
            aj.r(this.gqy, d.C0141d.cp_cont_f);
            aj.r(this.gqz, d.C0141d.cp_cont_f);
            aj.r(this.gqD, d.C0141d.cp_cont_c);
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
        this.gqw.setText(dVar.daD);
        this.gqx.setText(dVar.daC);
        this.gqw.setVisibility(dVar.daK ? 0 : 4);
        this.gqx.setVisibility(dVar.daK ? 0 : 4);
        if (dVar.isHost) {
            this.gqy.setText(this.mPageContext.getString(d.j.me));
        } else {
            this.gqy.setText(am.fU(dVar.sex));
        }
        int D = v.D(dVar.users);
        if (D > 3) {
            this.gqD.setVisibility(0);
            this.gqD.setText(String.format(this.mPageContext.getString(d.j.attention_etc_person), Integer.valueOf(D)));
        } else {
            this.gqD.setVisibility(8);
        }
        if (D >= 3) {
            this.gqC.setVisibility(0);
            this.gqC.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.gqC.setIsGod(true);
            } else {
                this.gqC.setIsGod(false);
            }
            this.gqC.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.gqC.setVisibility(8);
        }
        if (D >= 2) {
            this.gqB.setVisibility(0);
            this.gqB.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.gqB.setIsGod(true);
            } else {
                this.gqB.setIsGod(false);
            }
            this.gqB.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.gqB.setVisibility(8);
        }
        if (D >= 1) {
            this.gqA.setVisibility(0);
            this.gqA.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.gqA.setIsGod(true);
            } else {
                this.gqA.setIsGod(false);
            }
            this.gqA.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.gqA.setVisibility(8);
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
