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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View bZm;
    public TextView fMq;
    public TextView fMr;
    public TextView fMs;
    public TextView fMt;
    public ClickableHeaderImageView fMu;
    public ClickableHeaderImageView fMv;
    public ClickableHeaderImageView fMw;
    public TextView fMx;
    private boolean isHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view2 = getView();
        initListener();
        this.bZm = view2.findViewById(d.g.bottom_divider);
        this.fMr = (TextView) view2.findViewById(d.g.month_num);
        this.fMq = (TextView) view2.findViewById(d.g.day_num);
        this.fMs = (TextView) view2.findViewById(d.g.identity);
        this.fMt = (TextView) view2.findViewById(d.g.attention_str);
        this.fMu = (ClickableHeaderImageView) view2.findViewById(d.g.header1);
        this.fMu.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fMu.setAutoChangeStyle(true);
        this.fMu.setOnClickListener(this.mOnClickListener);
        this.fMv = (ClickableHeaderImageView) view2.findViewById(d.g.header2);
        this.fMv.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fMv.setAutoChangeStyle(true);
        this.fMv.setOnClickListener(this.mOnClickListener);
        this.fMw = (ClickableHeaderImageView) view2.findViewById(d.g.header3);
        this.fMw.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fMw.setAutoChangeStyle(true);
        this.fMw.setOnClickListener(this.mOnClickListener);
        this.fMx = (TextView) view2.findViewById(d.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.home_thread_card_item_bg);
            ak.j(this.bZm, d.C0126d.cp_bg_line_c);
            ak.h(this.fMr, d.C0126d.cp_cont_f);
            ak.h(this.fMq, d.C0126d.cp_cont_f);
            ak.h(this.fMs, d.C0126d.cp_cont_f);
            ak.h(this.fMt, d.C0126d.cp_cont_f);
            ak.h(this.fMx, d.C0126d.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.person_info_attention_card;
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
        this.fMq.setText(dVar.ctG);
        this.fMr.setText(dVar.ctF);
        this.fMq.setVisibility(dVar.ctM ? 0 : 4);
        this.fMr.setVisibility(dVar.ctM ? 0 : 4);
        if (dVar.isHost) {
            this.fMs.setText(this.mPageContext.getString(d.k.me));
        } else {
            this.fMs.setText(an.cU(dVar.sex));
        }
        int v = v.v(dVar.users);
        if (v > 3) {
            this.fMx.setVisibility(0);
            this.fMx.setText(String.format(this.mPageContext.getString(d.k.attention_etc_person), Integer.valueOf(v)));
        } else {
            this.fMx.setVisibility(8);
        }
        if (v >= 3) {
            this.fMw.setVisibility(0);
            this.fMw.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.fMw.setIsGod(true);
            } else {
                this.fMw.setIsGod(false);
            }
            this.fMw.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.fMw.setVisibility(8);
        }
        if (v >= 2) {
            this.fMv.setVisibility(0);
            this.fMv.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.fMv.setIsGod(true);
            } else {
                this.fMv.setIsGod(false);
            }
            this.fMv.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.fMv.setVisibility(8);
        }
        if (v >= 1) {
            this.fMu.setVisibility(0);
            this.fMu.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.fMu.setIsGod(true);
            } else {
                this.fMu.setIsGod(false);
            }
            this.fMu.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.fMu.setVisibility(8);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 != null) {
                    if (!c.this.isHost) {
                        TiebaStatic.log(new al("c11595"));
                    }
                    if (view2.getTag() instanceof UserData) {
                        UserData userData = (UserData) view2.getTag();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
    }
}
