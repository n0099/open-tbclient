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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View bottomLine;
    private boolean bvm;
    public TextView flo;
    public TextView flp;
    public TextView flq;
    public TextView flr;
    public ClickableHeaderImageView fls;
    public ClickableHeaderImageView flt;
    public ClickableHeaderImageView flu;
    public TextView flv;
    private TbPageContext<?> mF;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mF = tbPageContext;
        View view = getView();
        initListener();
        this.bottomLine = view.findViewById(d.h.bottom_divider);
        this.flp = (TextView) view.findViewById(d.h.month_num);
        this.flo = (TextView) view.findViewById(d.h.day_num);
        this.flq = (TextView) view.findViewById(d.h.identity);
        this.flr = (TextView) view.findViewById(d.h.attention_str);
        this.fls = (ClickableHeaderImageView) view.findViewById(d.h.header1);
        this.fls.setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds100));
        this.fls.setAutoChangeStyle(true);
        this.fls.setOnClickListener(this.mOnClickListener);
        this.flt = (ClickableHeaderImageView) view.findViewById(d.h.header2);
        this.flt.setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds100));
        this.flt.setAutoChangeStyle(true);
        this.flt.setOnClickListener(this.mOnClickListener);
        this.flu = (ClickableHeaderImageView) view.findViewById(d.h.header3);
        this.flu.setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds100));
        this.flu.setAutoChangeStyle(true);
        this.flu.setOnClickListener(this.mOnClickListener);
        this.flv = (TextView) view.findViewById(d.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.home_thread_card_item_bg);
            aj.k(this.bottomLine, d.e.cp_bg_line_c);
            aj.i(this.flp, d.e.cp_cont_f);
            aj.i(this.flo, d.e.cp_cont_f);
            aj.i(this.flq, d.e.cp_cont_f);
            aj.i(this.flr, d.e.cp_cont_f);
            aj.i(this.flv, d.e.cp_cont_c);
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
        this.bvm = dVar.bvm;
        this.flo.setText(dVar.fkz);
        this.flp.setText(dVar.bNL);
        this.flo.setVisibility(dVar.bNS ? 0 : 4);
        this.flp.setVisibility(dVar.bNS ? 0 : 4);
        if (dVar.bvm) {
            this.flq.setText(this.mF.getString(d.l.me));
        } else {
            this.flq.setText(am.cZ(dVar.sex));
        }
        int u = v.u(dVar.users);
        if (u > 3) {
            this.flv.setVisibility(0);
            this.flv.setText(String.format(this.mF.getString(d.l.attention_etc_person), Integer.valueOf(u)));
        } else {
            this.flv.setVisibility(8);
        }
        if (u >= 3) {
            this.flu.setVisibility(0);
            this.flu.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.flu.setIsGod(true);
            } else {
                this.flu.setIsGod(false);
            }
            this.flu.c(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.flu.setVisibility(8);
        }
        if (u >= 2) {
            this.flt.setVisibility(0);
            this.flt.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.flt.setIsGod(true);
            } else {
                this.flt.setIsGod(false);
            }
            this.flt.c(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.flt.setVisibility(8);
        }
        if (u >= 1) {
            this.fls.setVisibility(0);
            this.fls.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.fls.setIsGod(true);
            } else {
                this.fls.setIsGod(false);
            }
            this.fls.c(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.fls.setVisibility(8);
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (!c.this.bvm) {
                        TiebaStatic.log(new ak("c11595"));
                    }
                    if (view.getTag() instanceof UserData) {
                        UserData userData = (UserData) view.getTag();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mF.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
    }
}
