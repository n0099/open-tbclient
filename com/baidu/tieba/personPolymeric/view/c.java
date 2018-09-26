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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View cqY;
    public TextView gjl;
    public TextView gjm;
    public TextView gjn;
    public TextView gjo;
    public ClickableHeaderImageView gjp;
    public ClickableHeaderImageView gjq;
    public ClickableHeaderImageView gjr;
    public TextView gjs;
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
        this.cqY = view.findViewById(e.g.bottom_divider);
        this.gjm = (TextView) view.findViewById(e.g.month_num);
        this.gjl = (TextView) view.findViewById(e.g.day_num);
        this.gjn = (TextView) view.findViewById(e.g.identity);
        this.gjo = (TextView) view.findViewById(e.g.attention_str);
        this.gjp = (ClickableHeaderImageView) view.findViewById(e.g.header1);
        this.gjp.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0141e.ds100));
        this.gjp.setAutoChangeStyle(true);
        this.gjp.setOnClickListener(this.mOnClickListener);
        this.gjq = (ClickableHeaderImageView) view.findViewById(e.g.header2);
        this.gjq.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0141e.ds100));
        this.gjq.setAutoChangeStyle(true);
        this.gjq.setOnClickListener(this.mOnClickListener);
        this.gjr = (ClickableHeaderImageView) view.findViewById(e.g.header3);
        this.gjr.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0141e.ds100));
        this.gjr.setAutoChangeStyle(true);
        this.gjr.setOnClickListener(this.mOnClickListener);
        this.gjs = (TextView) view.findViewById(e.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.j(this.cqY, e.d.cp_bg_line_c);
            al.h(this.gjm, e.d.cp_cont_f);
            al.h(this.gjl, e.d.cp_cont_f);
            al.h(this.gjn, e.d.cp_cont_f);
            al.h(this.gjo, e.d.cp_cont_f);
            al.h(this.gjs, e.d.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.person_info_attention_card;
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
        this.gjl.setText(dVar.cIx);
        this.gjm.setText(dVar.cIw);
        this.gjl.setVisibility(dVar.cID ? 0 : 4);
        this.gjm.setVisibility(dVar.cID ? 0 : 4);
        if (dVar.isHost) {
            this.gjn.setText(this.mPageContext.getString(e.j.me));
        } else {
            this.gjn.setText(ao.di(dVar.sex));
        }
        int y = v.y(dVar.users);
        if (y > 3) {
            this.gjs.setVisibility(0);
            this.gjs.setText(String.format(this.mPageContext.getString(e.j.attention_etc_person), Integer.valueOf(y)));
        } else {
            this.gjs.setVisibility(8);
        }
        if (y >= 3) {
            this.gjr.setVisibility(0);
            this.gjr.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.gjr.setIsGod(true);
            } else {
                this.gjr.setIsGod(false);
            }
            this.gjr.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.gjr.setVisibility(8);
        }
        if (y >= 2) {
            this.gjq.setVisibility(0);
            this.gjq.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.gjq.setIsGod(true);
            } else {
                this.gjq.setIsGod(false);
            }
            this.gjq.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.gjq.setVisibility(8);
        }
        if (y >= 1) {
            this.gjp.setVisibility(0);
            this.gjp.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.gjp.setIsGod(true);
            } else {
                this.gjp.setIsGod(false);
            }
            this.gjp.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.gjp.setVisibility(8);
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
