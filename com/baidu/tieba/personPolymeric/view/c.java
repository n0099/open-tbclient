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
    public View dTd;
    public TextView hSI;
    public TextView hSJ;
    public TextView hSK;
    public TextView hSL;
    public ClickableHeaderImageView hSM;
    public ClickableHeaderImageView hSN;
    public ClickableHeaderImageView hSO;
    public TextView hSP;
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
        this.dTd = view.findViewById(d.g.bottom_divider);
        this.hSJ = (TextView) view.findViewById(d.g.month_num);
        this.hSI = (TextView) view.findViewById(d.g.day_num);
        this.hSK = (TextView) view.findViewById(d.g.identity);
        this.hSL = (TextView) view.findViewById(d.g.attention_str);
        this.hSM = (ClickableHeaderImageView) view.findViewById(d.g.header1);
        this.hSM.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds100));
        this.hSM.setAutoChangeStyle(true);
        this.hSM.setOnClickListener(this.mOnClickListener);
        this.hSN = (ClickableHeaderImageView) view.findViewById(d.g.header2);
        this.hSN.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds100));
        this.hSN.setAutoChangeStyle(true);
        this.hSN.setOnClickListener(this.mOnClickListener);
        this.hSO = (ClickableHeaderImageView) view.findViewById(d.g.header3);
        this.hSO.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds100));
        this.hSO.setAutoChangeStyle(true);
        this.hSO.setOnClickListener(this.mOnClickListener);
        this.hSP = (TextView) view.findViewById(d.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.home_thread_card_item_bg);
            al.l(this.dTd, d.C0277d.cp_bg_line_c);
            al.j(this.hSJ, d.C0277d.cp_cont_f);
            al.j(this.hSI, d.C0277d.cp_cont_f);
            al.j(this.hSK, d.C0277d.cp_cont_f);
            al.j(this.hSL, d.C0277d.cp_cont_f);
            al.j(this.hSP, d.C0277d.cp_cont_c);
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
        this.hSI.setText(dVar.elR);
        this.hSJ.setText(dVar.elQ);
        this.hSI.setVisibility(dVar.elX ? 0 : 4);
        this.hSJ.setVisibility(dVar.elX ? 0 : 4);
        if (dVar.isHost) {
            this.hSK.setText(this.mPageContext.getString(d.j.me));
        } else {
            this.hSK.setText(ap.hx(dVar.sex));
        }
        int S = v.S(dVar.users);
        if (S > 3) {
            this.hSP.setVisibility(0);
            this.hSP.setText(String.format(this.mPageContext.getString(d.j.attention_etc_person), Integer.valueOf(S)));
        } else {
            this.hSP.setVisibility(8);
        }
        if (S >= 3) {
            this.hSO.setVisibility(0);
            this.hSO.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.hSO.setIsGod(true);
            } else {
                this.hSO.setIsGod(false);
            }
            this.hSO.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.hSO.setVisibility(8);
        }
        if (S >= 2) {
            this.hSN.setVisibility(0);
            this.hSN.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.hSN.setIsGod(true);
            } else {
                this.hSN.setIsGod(false);
            }
            this.hSN.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.hSN.setVisibility(8);
        }
        if (S >= 1) {
            this.hSM.setVisibility(0);
            this.hSM.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.hSM.setIsGod(true);
            } else {
                this.hSM.setIsGod(false);
            }
            this.hSM.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.hSM.setVisibility(8);
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
