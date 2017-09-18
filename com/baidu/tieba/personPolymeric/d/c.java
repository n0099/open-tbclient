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
    private boolean bwa;
    public TextView fmh;
    public TextView fmi;
    public TextView fmj;
    public TextView fmk;
    public ClickableHeaderImageView fml;
    public ClickableHeaderImageView fmm;
    public ClickableHeaderImageView fmn;
    public TextView fmo;
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
        this.fmi = (TextView) view.findViewById(d.h.month_num);
        this.fmh = (TextView) view.findViewById(d.h.day_num);
        this.fmj = (TextView) view.findViewById(d.h.identity);
        this.fmk = (TextView) view.findViewById(d.h.attention_str);
        this.fml = (ClickableHeaderImageView) view.findViewById(d.h.header1);
        this.fml.setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds100));
        this.fml.setAutoChangeStyle(true);
        this.fml.setOnClickListener(this.mOnClickListener);
        this.fmm = (ClickableHeaderImageView) view.findViewById(d.h.header2);
        this.fmm.setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds100));
        this.fmm.setAutoChangeStyle(true);
        this.fmm.setOnClickListener(this.mOnClickListener);
        this.fmn = (ClickableHeaderImageView) view.findViewById(d.h.header3);
        this.fmn.setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds100));
        this.fmn.setAutoChangeStyle(true);
        this.fmn.setOnClickListener(this.mOnClickListener);
        this.fmo = (TextView) view.findViewById(d.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.home_thread_card_item_bg);
            aj.k(this.bottomLine, d.e.cp_bg_line_c);
            aj.i(this.fmi, d.e.cp_cont_f);
            aj.i(this.fmh, d.e.cp_cont_f);
            aj.i(this.fmj, d.e.cp_cont_f);
            aj.i(this.fmk, d.e.cp_cont_f);
            aj.i(this.fmo, d.e.cp_cont_c);
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
        this.bwa = dVar.bwa;
        this.fmh.setText(dVar.fls);
        this.fmi.setText(dVar.bOC);
        this.fmh.setVisibility(dVar.bOJ ? 0 : 4);
        this.fmi.setVisibility(dVar.bOJ ? 0 : 4);
        if (dVar.bwa) {
            this.fmj.setText(this.mF.getString(d.l.me));
        } else {
            this.fmj.setText(am.cZ(dVar.sex));
        }
        int u = v.u(dVar.users);
        if (u > 3) {
            this.fmo.setVisibility(0);
            this.fmo.setText(String.format(this.mF.getString(d.l.attention_etc_person), Integer.valueOf(u)));
        } else {
            this.fmo.setVisibility(8);
        }
        if (u >= 3) {
            this.fmn.setVisibility(0);
            this.fmn.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.fmn.setIsGod(true);
            } else {
                this.fmn.setIsGod(false);
            }
            this.fmn.c(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.fmn.setVisibility(8);
        }
        if (u >= 2) {
            this.fmm.setVisibility(0);
            this.fmm.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.fmm.setIsGod(true);
            } else {
                this.fmm.setIsGod(false);
            }
            this.fmm.c(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.fmm.setVisibility(8);
        }
        if (u >= 1) {
            this.fml.setVisibility(0);
            this.fml.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.fml.setIsGod(true);
            } else {
                this.fml.setIsGod(false);
            }
            this.fml.c(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.fml.setVisibility(8);
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
                    if (!c.this.bwa) {
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
