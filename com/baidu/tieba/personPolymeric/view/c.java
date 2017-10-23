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
    public View bAC;
    public TextView fhE;
    public TextView fhF;
    public TextView fhG;
    public TextView fhH;
    public ClickableHeaderImageView fhI;
    public ClickableHeaderImageView fhJ;
    public ClickableHeaderImageView fhK;
    public TextView fhL;
    private boolean isHost;
    private TbPageContext<?> mH;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mH = tbPageContext;
        View view = getView();
        initListener();
        this.bAC = view.findViewById(d.h.bottom_divider);
        this.fhF = (TextView) view.findViewById(d.h.month_num);
        this.fhE = (TextView) view.findViewById(d.h.day_num);
        this.fhG = (TextView) view.findViewById(d.h.identity);
        this.fhH = (TextView) view.findViewById(d.h.attention_str);
        this.fhI = (ClickableHeaderImageView) view.findViewById(d.h.header1);
        this.fhI.setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds100));
        this.fhI.setAutoChangeStyle(true);
        this.fhI.setOnClickListener(this.mOnClickListener);
        this.fhJ = (ClickableHeaderImageView) view.findViewById(d.h.header2);
        this.fhJ.setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds100));
        this.fhJ.setAutoChangeStyle(true);
        this.fhJ.setOnClickListener(this.mOnClickListener);
        this.fhK = (ClickableHeaderImageView) view.findViewById(d.h.header3);
        this.fhK.setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds100));
        this.fhK.setAutoChangeStyle(true);
        this.fhK.setOnClickListener(this.mOnClickListener);
        this.fhL = (TextView) view.findViewById(d.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.home_thread_card_item_bg);
            aj.k(this.bAC, d.e.cp_bg_line_c);
            aj.i(this.fhF, d.e.cp_cont_f);
            aj.i(this.fhE, d.e.cp_cont_f);
            aj.i(this.fhG, d.e.cp_cont_f);
            aj.i(this.fhH, d.e.cp_cont_f);
            aj.i(this.fhL, d.e.cp_cont_c);
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
        this.isHost = dVar.isHost;
        this.fhE.setText(dVar.fgC);
        this.fhF.setText(dVar.bNV);
        this.fhE.setVisibility(dVar.bOc ? 0 : 4);
        this.fhF.setVisibility(dVar.bOc ? 0 : 4);
        if (dVar.isHost) {
            this.fhG.setText(this.mH.getString(d.l.me));
        } else {
            this.fhG.setText(am.cW(dVar.sex));
        }
        int t = v.t(dVar.users);
        if (t > 3) {
            this.fhL.setVisibility(0);
            this.fhL.setText(String.format(this.mH.getString(d.l.attention_etc_person), Integer.valueOf(t)));
        } else {
            this.fhL.setVisibility(8);
        }
        if (t >= 3) {
            this.fhK.setVisibility(0);
            this.fhK.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.fhK.setIsGod(true);
            } else {
                this.fhK.setIsGod(false);
            }
            this.fhK.c(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.fhK.setVisibility(8);
        }
        if (t >= 2) {
            this.fhJ.setVisibility(0);
            this.fhJ.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.fhJ.setIsGod(true);
            } else {
                this.fhJ.setIsGod(false);
            }
            this.fhJ.c(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.fhJ.setVisibility(8);
        }
        if (t >= 1) {
            this.fhI.setVisibility(0);
            this.fhI.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.fhI.setIsGod(true);
            } else {
                this.fhI.setIsGod(false);
            }
            this.fhI.c(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.fhI.setVisibility(8);
        }
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mH.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
    }
}
