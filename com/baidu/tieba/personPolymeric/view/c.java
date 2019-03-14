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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View dTL;
    public TextView hSW;
    public TextView hSX;
    public TextView hSY;
    public TextView hSZ;
    public ClickableHeaderImageView hTa;
    public ClickableHeaderImageView hTb;
    public ClickableHeaderImageView hTc;
    public TextView hTd;
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
        this.dTL = view.findViewById(d.g.bottom_divider);
        this.hSX = (TextView) view.findViewById(d.g.month_num);
        this.hSW = (TextView) view.findViewById(d.g.day_num);
        this.hSY = (TextView) view.findViewById(d.g.identity);
        this.hSZ = (TextView) view.findViewById(d.g.attention_str);
        this.hTa = (ClickableHeaderImageView) view.findViewById(d.g.header1);
        this.hTa.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds100));
        this.hTa.setAutoChangeStyle(true);
        this.hTa.setOnClickListener(this.mOnClickListener);
        this.hTb = (ClickableHeaderImageView) view.findViewById(d.g.header2);
        this.hTb.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds100));
        this.hTb.setAutoChangeStyle(true);
        this.hTb.setOnClickListener(this.mOnClickListener);
        this.hTc = (ClickableHeaderImageView) view.findViewById(d.g.header3);
        this.hTc.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds100));
        this.hTc.setAutoChangeStyle(true);
        this.hTc.setOnClickListener(this.mOnClickListener);
        this.hTd = (TextView) view.findViewById(d.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.home_thread_card_item_bg);
            al.l(this.dTL, d.C0277d.cp_bg_line_c);
            al.j(this.hSX, d.C0277d.cp_cont_f);
            al.j(this.hSW, d.C0277d.cp_cont_f);
            al.j(this.hSY, d.C0277d.cp_cont_f);
            al.j(this.hSZ, d.C0277d.cp_cont_f);
            al.j(this.hTd, d.C0277d.cp_cont_c);
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
        this.hSW.setText(dVar.emf);
        this.hSX.setText(dVar.eme);
        this.hSW.setVisibility(dVar.eml ? 0 : 4);
        this.hSX.setVisibility(dVar.eml ? 0 : 4);
        if (dVar.isHost) {
            this.hSY.setText(this.mPageContext.getString(d.j.me));
        } else {
            this.hSY.setText(ap.hy(dVar.sex));
        }
        int S = v.S(dVar.users);
        if (S > 3) {
            this.hTd.setVisibility(0);
            this.hTd.setText(String.format(this.mPageContext.getString(d.j.attention_etc_person), Integer.valueOf(S)));
        } else {
            this.hTd.setVisibility(8);
        }
        if (S >= 3) {
            this.hTc.setVisibility(0);
            this.hTc.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.hTc.setIsGod(true);
            } else {
                this.hTc.setIsGod(false);
            }
            this.hTc.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.hTc.setVisibility(8);
        }
        if (S >= 2) {
            this.hTb.setVisibility(0);
            this.hTb.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.hTb.setIsGod(true);
            } else {
                this.hTb.setIsGod(false);
            }
            this.hTb.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.hTb.setVisibility(8);
        }
        if (S >= 1) {
            this.hTa.setVisibility(0);
            this.hTa.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.hTa.setIsGod(true);
            } else {
                this.hTa.setIsGod(false);
            }
            this.hTa.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.hTa.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
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
                        TiebaStatic.log(new am("c11595"));
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
