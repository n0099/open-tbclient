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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View chp;
    public TextView fXC;
    public TextView fXD;
    public TextView fXE;
    public TextView fXF;
    public ClickableHeaderImageView fXG;
    public ClickableHeaderImageView fXH;
    public ClickableHeaderImageView fXI;
    public TextView fXJ;
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
        this.chp = view.findViewById(d.g.bottom_divider);
        this.fXD = (TextView) view.findViewById(d.g.month_num);
        this.fXC = (TextView) view.findViewById(d.g.day_num);
        this.fXE = (TextView) view.findViewById(d.g.identity);
        this.fXF = (TextView) view.findViewById(d.g.attention_str);
        this.fXG = (ClickableHeaderImageView) view.findViewById(d.g.header1);
        this.fXG.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fXG.setAutoChangeStyle(true);
        this.fXG.setOnClickListener(this.mOnClickListener);
        this.fXH = (ClickableHeaderImageView) view.findViewById(d.g.header2);
        this.fXH.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fXH.setAutoChangeStyle(true);
        this.fXH.setOnClickListener(this.mOnClickListener);
        this.fXI = (ClickableHeaderImageView) view.findViewById(d.g.header3);
        this.fXI.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.fXI.setAutoChangeStyle(true);
        this.fXI.setOnClickListener(this.mOnClickListener);
        this.fXJ = (TextView) view.findViewById(d.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.f.home_thread_card_item_bg);
            al.j(this.chp, d.C0141d.cp_bg_line_c);
            al.h(this.fXD, d.C0141d.cp_cont_f);
            al.h(this.fXC, d.C0141d.cp_cont_f);
            al.h(this.fXE, d.C0141d.cp_cont_f);
            al.h(this.fXF, d.C0141d.cp_cont_f);
            al.h(this.fXJ, d.C0141d.cp_cont_c);
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
        this.fXC.setText(dVar.cCk);
        this.fXD.setText(dVar.cCj);
        this.fXC.setVisibility(dVar.cCq ? 0 : 4);
        this.fXD.setVisibility(dVar.cCq ? 0 : 4);
        if (dVar.isHost) {
            this.fXE.setText(this.mPageContext.getString(d.k.me));
        } else {
            this.fXE.setText(ao.cW(dVar.sex));
        }
        int y = w.y(dVar.users);
        if (y > 3) {
            this.fXJ.setVisibility(0);
            this.fXJ.setText(String.format(this.mPageContext.getString(d.k.attention_etc_person), Integer.valueOf(y)));
        } else {
            this.fXJ.setVisibility(8);
        }
        if (y >= 3) {
            this.fXI.setVisibility(0);
            this.fXI.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.fXI.setIsGod(true);
            } else {
                this.fXI.setIsGod(false);
            }
            this.fXI.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.fXI.setVisibility(8);
        }
        if (y >= 2) {
            this.fXH.setVisibility(0);
            this.fXH.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.fXH.setIsGod(true);
            } else {
                this.fXH.setIsGod(false);
            }
            this.fXH.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.fXH.setVisibility(8);
        }
        if (y >= 1) {
            this.fXG.setVisibility(0);
            this.fXG.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.fXG.setIsGod(true);
            } else {
                this.fXG.setIsGod(false);
            }
            this.fXG.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.fXG.setVisibility(8);
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
