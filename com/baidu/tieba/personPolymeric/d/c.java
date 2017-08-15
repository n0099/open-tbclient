package com.baidu.tieba.personPolymeric.d;

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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View bottomLine;
    private boolean buA;
    public TextView fmR;
    public TextView fmS;
    public TextView fmT;
    public TextView fmU;
    public ClickableHeaderImageView fmV;
    public ClickableHeaderImageView fmW;
    public ClickableHeaderImageView fmX;
    public TextView fmY;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TbPageContext<?> oV;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.oV = tbPageContext;
        View view = getView();
        initListener();
        this.bottomLine = view.findViewById(d.h.bottom_divider);
        this.fmS = (TextView) view.findViewById(d.h.month_num);
        this.fmR = (TextView) view.findViewById(d.h.day_num);
        this.fmT = (TextView) view.findViewById(d.h.identity);
        this.fmU = (TextView) view.findViewById(d.h.attention_str);
        this.fmV = (ClickableHeaderImageView) view.findViewById(d.h.header1);
        this.fmV.setRadius(com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds100));
        this.fmV.setAutoChangeStyle(true);
        this.fmV.setOnClickListener(this.mOnClickListener);
        this.fmW = (ClickableHeaderImageView) view.findViewById(d.h.header2);
        this.fmW.setRadius(com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds100));
        this.fmW.setAutoChangeStyle(true);
        this.fmW.setOnClickListener(this.mOnClickListener);
        this.fmX = (ClickableHeaderImageView) view.findViewById(d.h.header3);
        this.fmX.setRadius(com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds100));
        this.fmX.setAutoChangeStyle(true);
        this.fmX.setOnClickListener(this.mOnClickListener);
        this.fmY = (TextView) view.findViewById(d.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.k(this.bottomLine, d.e.cp_bg_line_c);
            ai.i(this.fmS, d.e.cp_cont_f);
            ai.i(this.fmR, d.e.cp_cont_f);
            ai.i(this.fmT, d.e.cp_cont_f);
            ai.i(this.fmU, d.e.cp_cont_f);
            ai.i(this.fmY, d.e.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.person_info_attention_card;
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
        this.buA = dVar.buA;
        this.fmR.setText(dVar.fmc);
        this.fmS.setText(dVar.bKR);
        this.fmR.setVisibility(dVar.bKY ? 0 : 4);
        this.fmS.setVisibility(dVar.bKY ? 0 : 4);
        if (dVar.buA) {
            this.fmT.setText(this.oV.getString(d.l.me));
        } else {
            this.fmT.setText(al.cY(dVar.sex));
        }
        int u = u.u(dVar.users);
        if (u > 3) {
            this.fmY.setVisibility(0);
            this.fmY.setText(String.format(this.oV.getString(d.l.attention_etc_person), Integer.valueOf(u)));
        } else {
            this.fmY.setVisibility(8);
        }
        if (u >= 3) {
            this.fmX.setVisibility(0);
            this.fmX.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.fmX.setIsGod(true);
            } else {
                this.fmX.setIsGod(false);
            }
            this.fmX.c(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.fmX.setVisibility(8);
        }
        if (u >= 2) {
            this.fmW.setVisibility(0);
            this.fmW.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.fmW.setIsGod(true);
            } else {
                this.fmW.setIsGod(false);
            }
            this.fmW.c(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.fmW.setVisibility(8);
        }
        if (u >= 1) {
            this.fmV.setVisibility(0);
            this.fmV.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.fmV.setIsGod(true);
            } else {
                this.fmV.setIsGod(false);
            }
            this.fmV.c(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.fmV.setVisibility(8);
        }
        d(this.oV, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (!c.this.buA) {
                        TiebaStatic.log(new aj("c11595"));
                    }
                    if (view.getTag() instanceof UserData) {
                        UserData userData = (UserData) view.getTag();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.oV.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
    }
}
