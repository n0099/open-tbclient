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
    public View bHb;
    public TextView fqd;
    public TextView fqe;
    public TextView fqf;
    public TextView fqg;
    public ClickableHeaderImageView fqh;
    public ClickableHeaderImageView fqi;
    public ClickableHeaderImageView fqj;
    public TextView fqk;
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
        this.bHb = view.findViewById(d.g.bottom_divider);
        this.fqe = (TextView) view.findViewById(d.g.month_num);
        this.fqd = (TextView) view.findViewById(d.g.day_num);
        this.fqf = (TextView) view.findViewById(d.g.identity);
        this.fqg = (TextView) view.findViewById(d.g.attention_str);
        this.fqh = (ClickableHeaderImageView) view.findViewById(d.g.header1);
        this.fqh.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fqh.setAutoChangeStyle(true);
        this.fqh.setOnClickListener(this.mOnClickListener);
        this.fqi = (ClickableHeaderImageView) view.findViewById(d.g.header2);
        this.fqi.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fqi.setAutoChangeStyle(true);
        this.fqi.setOnClickListener(this.mOnClickListener);
        this.fqj = (ClickableHeaderImageView) view.findViewById(d.g.header3);
        this.fqj.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fqj.setAutoChangeStyle(true);
        this.fqj.setOnClickListener(this.mOnClickListener);
        this.fqk = (TextView) view.findViewById(d.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.home_thread_card_item_bg);
            aj.k(this.bHb, d.C0080d.cp_bg_line_c);
            aj.i(this.fqe, d.C0080d.cp_cont_f);
            aj.i(this.fqd, d.C0080d.cp_cont_f);
            aj.i(this.fqf, d.C0080d.cp_cont_f);
            aj.i(this.fqg, d.C0080d.cp_cont_f);
            aj.i(this.fqk, d.C0080d.cp_cont_c);
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
        this.fqd.setText(dVar.fpa);
        this.fqe.setText(dVar.bVA);
        this.fqd.setVisibility(dVar.bVH ? 0 : 4);
        this.fqe.setVisibility(dVar.bVH ? 0 : 4);
        if (dVar.isHost) {
            this.fqf.setText(this.mPageContext.getString(d.j.me));
        } else {
            this.fqf.setText(am.cX(dVar.sex));
        }
        int u = v.u(dVar.users);
        if (u > 3) {
            this.fqk.setVisibility(0);
            this.fqk.setText(String.format(this.mPageContext.getString(d.j.attention_etc_person), Integer.valueOf(u)));
        } else {
            this.fqk.setVisibility(8);
        }
        if (u >= 3) {
            this.fqj.setVisibility(0);
            this.fqj.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.fqj.setIsGod(true);
            } else {
                this.fqj.setIsGod(false);
            }
            this.fqj.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.fqj.setVisibility(8);
        }
        if (u >= 2) {
            this.fqi.setVisibility(0);
            this.fqi.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.fqi.setIsGod(true);
            } else {
                this.fqi.setIsGod(false);
            }
            this.fqi.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.fqi.setVisibility(8);
        }
        if (u >= 1) {
            this.fqh.setVisibility(0);
            this.fqh.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.fqh.setIsGod(true);
            } else {
                this.fqh.setIsGod(false);
            }
            this.fqh.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.fqh.setVisibility(8);
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
