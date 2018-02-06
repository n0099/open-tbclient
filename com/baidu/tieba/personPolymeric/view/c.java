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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View cIs;
    public TextView gqH;
    public TextView gqI;
    public TextView gqJ;
    public TextView gqK;
    public ClickableHeaderImageView gqL;
    public ClickableHeaderImageView gqM;
    public ClickableHeaderImageView gqN;
    public TextView gqO;
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
        this.cIs = view.findViewById(d.g.bottom_divider);
        this.gqI = (TextView) view.findViewById(d.g.month_num);
        this.gqH = (TextView) view.findViewById(d.g.day_num);
        this.gqJ = (TextView) view.findViewById(d.g.identity);
        this.gqK = (TextView) view.findViewById(d.g.attention_str);
        this.gqL = (ClickableHeaderImageView) view.findViewById(d.g.header1);
        this.gqL.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds100));
        this.gqL.setAutoChangeStyle(true);
        this.gqL.setOnClickListener(this.mOnClickListener);
        this.gqM = (ClickableHeaderImageView) view.findViewById(d.g.header2);
        this.gqM.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds100));
        this.gqM.setAutoChangeStyle(true);
        this.gqM.setOnClickListener(this.mOnClickListener);
        this.gqN = (ClickableHeaderImageView) view.findViewById(d.g.header3);
        this.gqN.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds100));
        this.gqN.setAutoChangeStyle(true);
        this.gqN.setOnClickListener(this.mOnClickListener);
        this.gqO = (TextView) view.findViewById(d.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.t(this.cIs, d.C0140d.cp_bg_line_c);
            aj.r(this.gqI, d.C0140d.cp_cont_f);
            aj.r(this.gqH, d.C0140d.cp_cont_f);
            aj.r(this.gqJ, d.C0140d.cp_cont_f);
            aj.r(this.gqK, d.C0140d.cp_cont_f);
            aj.r(this.gqO, d.C0140d.cp_cont_c);
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
        this.gqH.setText(dVar.daP);
        this.gqI.setText(dVar.daO);
        this.gqH.setVisibility(dVar.daW ? 0 : 4);
        this.gqI.setVisibility(dVar.daW ? 0 : 4);
        if (dVar.isHost) {
            this.gqJ.setText(this.mPageContext.getString(d.j.me));
        } else {
            this.gqJ.setText(am.fU(dVar.sex));
        }
        int D = v.D(dVar.users);
        if (D > 3) {
            this.gqO.setVisibility(0);
            this.gqO.setText(String.format(this.mPageContext.getString(d.j.attention_etc_person), Integer.valueOf(D)));
        } else {
            this.gqO.setVisibility(8);
        }
        if (D >= 3) {
            this.gqN.setVisibility(0);
            this.gqN.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.gqN.setIsGod(true);
            } else {
                this.gqN.setIsGod(false);
            }
            this.gqN.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.gqN.setVisibility(8);
        }
        if (D >= 2) {
            this.gqM.setVisibility(0);
            this.gqM.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.gqM.setIsGod(true);
            } else {
                this.gqM.setIsGod(false);
            }
            this.gqM.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.gqM.setVisibility(8);
        }
        if (D >= 1) {
            this.gqL.setVisibility(0);
            this.gqL.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.gqL.setIsGod(true);
            } else {
                this.gqL.setIsGod(false);
            }
            this.gqL.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.gqL.setVisibility(8);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
    }
}
