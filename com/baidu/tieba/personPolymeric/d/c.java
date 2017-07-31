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
    private TbPageContext<?> alI;
    public View bottomLine;
    private boolean buk;
    public TextView fkY;
    public TextView fkZ;
    public TextView fla;
    public TextView flb;
    public ClickableHeaderImageView flc;
    public ClickableHeaderImageView fld;
    public ClickableHeaderImageView fle;
    public TextView flf;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.alI = tbPageContext;
        View view = getView();
        initListener();
        this.bottomLine = view.findViewById(d.h.bottom_divider);
        this.fkZ = (TextView) view.findViewById(d.h.month_num);
        this.fkY = (TextView) view.findViewById(d.h.day_num);
        this.fla = (TextView) view.findViewById(d.h.identity);
        this.flb = (TextView) view.findViewById(d.h.attention_str);
        this.flc = (ClickableHeaderImageView) view.findViewById(d.h.header1);
        this.flc.setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds100));
        this.flc.setAutoChangeStyle(true);
        this.flc.setOnClickListener(this.mOnClickListener);
        this.fld = (ClickableHeaderImageView) view.findViewById(d.h.header2);
        this.fld.setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds100));
        this.fld.setAutoChangeStyle(true);
        this.fld.setOnClickListener(this.mOnClickListener);
        this.fle = (ClickableHeaderImageView) view.findViewById(d.h.header3);
        this.fle.setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds100));
        this.fle.setAutoChangeStyle(true);
        this.fle.setOnClickListener(this.mOnClickListener);
        this.flf = (TextView) view.findViewById(d.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.k(this.bottomLine, d.e.cp_bg_line_c);
            ai.i(this.fkZ, d.e.cp_cont_f);
            ai.i(this.fkY, d.e.cp_cont_f);
            ai.i(this.fla, d.e.cp_cont_f);
            ai.i(this.flb, d.e.cp_cont_f);
            ai.i(this.flf, d.e.cp_cont_c);
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
        this.buk = dVar.buk;
        this.fkY.setText(dVar.fkj);
        this.fkZ.setText(dVar.bKi);
        this.fkY.setVisibility(dVar.bKp ? 0 : 4);
        this.fkZ.setVisibility(dVar.bKp ? 0 : 4);
        if (dVar.buk) {
            this.fla.setText(this.alI.getString(d.l.me));
        } else {
            this.fla.setText(al.cY(dVar.sex));
        }
        int u = u.u(dVar.users);
        if (u > 3) {
            this.flf.setVisibility(0);
            this.flf.setText(String.format(this.alI.getString(d.l.attention_etc_person), Integer.valueOf(u)));
        } else {
            this.flf.setVisibility(8);
        }
        if (u >= 3) {
            this.fle.setVisibility(0);
            this.fle.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.fle.setIsGod(true);
            } else {
                this.fle.setIsGod(false);
            }
            this.fle.c(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.fle.setVisibility(8);
        }
        if (u >= 2) {
            this.fld.setVisibility(0);
            this.fld.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.fld.setIsGod(true);
            } else {
                this.fld.setIsGod(false);
            }
            this.fld.c(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.fld.setVisibility(8);
        }
        if (u >= 1) {
            this.flc.setVisibility(0);
            this.flc.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.flc.setIsGod(true);
            } else {
                this.flc.setIsGod(false);
            }
            this.flc.c(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.flc.setVisibility(8);
        }
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (!c.this.buk) {
                        TiebaStatic.log(new aj("c11595"));
                    }
                    if (view.getTag() instanceof UserData) {
                        UserData userData = (UserData) view.getTag();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.alI.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
    }
}
