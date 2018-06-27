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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View cjz;
    public TextView gbC;
    public TextView gbD;
    public TextView gbE;
    public TextView gbF;
    public ClickableHeaderImageView gbG;
    public ClickableHeaderImageView gbH;
    public ClickableHeaderImageView gbI;
    public TextView gbJ;
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
        this.cjz = view.findViewById(d.g.bottom_divider);
        this.gbD = (TextView) view.findViewById(d.g.month_num);
        this.gbC = (TextView) view.findViewById(d.g.day_num);
        this.gbE = (TextView) view.findViewById(d.g.identity);
        this.gbF = (TextView) view.findViewById(d.g.attention_str);
        this.gbG = (ClickableHeaderImageView) view.findViewById(d.g.header1);
        this.gbG.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.gbG.setAutoChangeStyle(true);
        this.gbG.setOnClickListener(this.mOnClickListener);
        this.gbH = (ClickableHeaderImageView) view.findViewById(d.g.header2);
        this.gbH.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.gbH.setAutoChangeStyle(true);
        this.gbH.setOnClickListener(this.mOnClickListener);
        this.gbI = (ClickableHeaderImageView) view.findViewById(d.g.header3);
        this.gbI.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds100));
        this.gbI.setAutoChangeStyle(true);
        this.gbI.setOnClickListener(this.mOnClickListener);
        this.gbJ = (TextView) view.findViewById(d.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.home_thread_card_item_bg);
            am.j(this.cjz, d.C0142d.cp_bg_line_c);
            am.h(this.gbD, d.C0142d.cp_cont_f);
            am.h(this.gbC, d.C0142d.cp_cont_f);
            am.h(this.gbE, d.C0142d.cp_cont_f);
            am.h(this.gbF, d.C0142d.cp_cont_f);
            am.h(this.gbJ, d.C0142d.cp_cont_c);
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
        this.gbC.setText(dVar.cAe);
        this.gbD.setText(dVar.cAd);
        this.gbC.setVisibility(dVar.cAk ? 0 : 4);
        this.gbD.setVisibility(dVar.cAk ? 0 : 4);
        if (dVar.isHost) {
            this.gbE.setText(this.mPageContext.getString(d.k.me));
        } else {
            this.gbE.setText(ap.cX(dVar.sex));
        }
        int z = w.z(dVar.users);
        if (z > 3) {
            this.gbJ.setVisibility(0);
            this.gbJ.setText(String.format(this.mPageContext.getString(d.k.attention_etc_person), Integer.valueOf(z)));
        } else {
            this.gbJ.setVisibility(8);
        }
        if (z >= 3) {
            this.gbI.setVisibility(0);
            this.gbI.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.gbI.setIsGod(true);
            } else {
                this.gbI.setIsGod(false);
            }
            this.gbI.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.gbI.setVisibility(8);
        }
        if (z >= 2) {
            this.gbH.setVisibility(0);
            this.gbH.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.gbH.setIsGod(true);
            } else {
                this.gbH.setIsGod(false);
            }
            this.gbH.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.gbH.setVisibility(8);
        }
        if (z >= 1) {
            this.gbG.setVisibility(0);
            this.gbG.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.gbG.setIsGod(true);
            } else {
                this.gbG.setIsGod(false);
            }
            this.gbG.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.gbG.setVisibility(8);
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
                        TiebaStatic.log(new an("c11595"));
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
