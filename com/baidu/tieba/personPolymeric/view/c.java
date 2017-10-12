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
    public View bAO;
    public TextView fhS;
    public TextView fhT;
    public TextView fhU;
    public TextView fhV;
    public ClickableHeaderImageView fhW;
    public ClickableHeaderImageView fhX;
    public ClickableHeaderImageView fhY;
    public TextView fhZ;
    private boolean isHost;
    private TbPageContext<?> mG;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mG = tbPageContext;
        View view = getView();
        initListener();
        this.bAO = view.findViewById(d.h.bottom_divider);
        this.fhT = (TextView) view.findViewById(d.h.month_num);
        this.fhS = (TextView) view.findViewById(d.h.day_num);
        this.fhU = (TextView) view.findViewById(d.h.identity);
        this.fhV = (TextView) view.findViewById(d.h.attention_str);
        this.fhW = (ClickableHeaderImageView) view.findViewById(d.h.header1);
        this.fhW.setRadius(com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds100));
        this.fhW.setAutoChangeStyle(true);
        this.fhW.setOnClickListener(this.mOnClickListener);
        this.fhX = (ClickableHeaderImageView) view.findViewById(d.h.header2);
        this.fhX.setRadius(com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds100));
        this.fhX.setAutoChangeStyle(true);
        this.fhX.setOnClickListener(this.mOnClickListener);
        this.fhY = (ClickableHeaderImageView) view.findViewById(d.h.header3);
        this.fhY.setRadius(com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds100));
        this.fhY.setAutoChangeStyle(true);
        this.fhY.setOnClickListener(this.mOnClickListener);
        this.fhZ = (TextView) view.findViewById(d.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.home_thread_card_item_bg);
            aj.k(this.bAO, d.e.cp_bg_line_c);
            aj.i(this.fhT, d.e.cp_cont_f);
            aj.i(this.fhS, d.e.cp_cont_f);
            aj.i(this.fhU, d.e.cp_cont_f);
            aj.i(this.fhV, d.e.cp_cont_f);
            aj.i(this.fhZ, d.e.cp_cont_c);
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
        this.fhS.setText(dVar.fgQ);
        this.fhT.setText(dVar.bOh);
        this.fhS.setVisibility(dVar.bOo ? 0 : 4);
        this.fhT.setVisibility(dVar.bOo ? 0 : 4);
        if (dVar.isHost) {
            this.fhU.setText(this.mG.getString(d.l.me));
        } else {
            this.fhU.setText(am.cX(dVar.sex));
        }
        int t = v.t(dVar.users);
        if (t > 3) {
            this.fhZ.setVisibility(0);
            this.fhZ.setText(String.format(this.mG.getString(d.l.attention_etc_person), Integer.valueOf(t)));
        } else {
            this.fhZ.setVisibility(8);
        }
        if (t >= 3) {
            this.fhY.setVisibility(0);
            this.fhY.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.fhY.setIsGod(true);
            } else {
                this.fhY.setIsGod(false);
            }
            this.fhY.c(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.fhY.setVisibility(8);
        }
        if (t >= 2) {
            this.fhX.setVisibility(0);
            this.fhX.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.fhX.setIsGod(true);
            } else {
                this.fhX.setIsGod(false);
            }
            this.fhX.c(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.fhX.setVisibility(8);
        }
        if (t >= 1) {
            this.fhW.setVisibility(0);
            this.fhW.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.fhW.setIsGod(true);
            } else {
                this.fhW.setIsGod(false);
            }
            this.fhW.c(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.fhW.setVisibility(8);
        }
        d(this.mG, TbadkCoreApplication.getInst().getSkinType());
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mG.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
    }
}
