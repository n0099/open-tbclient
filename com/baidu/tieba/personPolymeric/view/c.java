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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View bHo;
    public TextView fqA;
    public TextView fqB;
    public TextView fqC;
    public TextView fqD;
    public ClickableHeaderImageView fqE;
    public ClickableHeaderImageView fqF;
    public ClickableHeaderImageView fqG;
    public TextView fqH;
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
        this.bHo = view.findViewById(d.g.bottom_divider);
        this.fqB = (TextView) view.findViewById(d.g.month_num);
        this.fqA = (TextView) view.findViewById(d.g.day_num);
        this.fqC = (TextView) view.findViewById(d.g.identity);
        this.fqD = (TextView) view.findViewById(d.g.attention_str);
        this.fqE = (ClickableHeaderImageView) view.findViewById(d.g.header1);
        this.fqE.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fqE.setAutoChangeStyle(true);
        this.fqE.setOnClickListener(this.mOnClickListener);
        this.fqF = (ClickableHeaderImageView) view.findViewById(d.g.header2);
        this.fqF.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fqF.setAutoChangeStyle(true);
        this.fqF.setOnClickListener(this.mOnClickListener);
        this.fqG = (ClickableHeaderImageView) view.findViewById(d.g.header3);
        this.fqG.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fqG.setAutoChangeStyle(true);
        this.fqG.setOnClickListener(this.mOnClickListener);
        this.fqH = (TextView) view.findViewById(d.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.home_thread_card_item_bg);
            aj.k(this.bHo, d.C0080d.cp_bg_line_c);
            aj.i(this.fqB, d.C0080d.cp_cont_f);
            aj.i(this.fqA, d.C0080d.cp_cont_f);
            aj.i(this.fqC, d.C0080d.cp_cont_f);
            aj.i(this.fqD, d.C0080d.cp_cont_f);
            aj.i(this.fqH, d.C0080d.cp_cont_c);
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
        this.fqA.setText(dVar.fpy);
        this.fqB.setText(dVar.bVN);
        this.fqA.setVisibility(dVar.bVU ? 0 : 4);
        this.fqB.setVisibility(dVar.bVU ? 0 : 4);
        if (dVar.isHost) {
            this.fqC.setText(this.mPageContext.getString(d.j.me));
        } else {
            this.fqC.setText(am.cW(dVar.sex));
        }
        int u = v.u(dVar.users);
        if (u > 3) {
            this.fqH.setVisibility(0);
            this.fqH.setText(String.format(this.mPageContext.getString(d.j.attention_etc_person), Integer.valueOf(u)));
        } else {
            this.fqH.setVisibility(8);
        }
        if (u >= 3) {
            this.fqG.setVisibility(0);
            this.fqG.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.fqG.setIsGod(true);
            } else {
                this.fqG.setIsGod(false);
            }
            this.fqG.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.fqG.setVisibility(8);
        }
        if (u >= 2) {
            this.fqF.setVisibility(0);
            this.fqF.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.fqF.setIsGod(true);
            } else {
                this.fqF.setIsGod(false);
            }
            this.fqF.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.fqF.setVisibility(8);
        }
        if (u >= 1) {
            this.fqE.setVisibility(0);
            this.fqE.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.fqE.setIsGod(true);
            } else {
                this.fqE.setIsGod(false);
            }
            this.fqE.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.fqE.setVisibility(8);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
    }
}
