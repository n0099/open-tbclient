package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    public View cGn;
    public TextView gCX;
    public TextView gCY;
    public TextView gCZ;
    public TextView gDa;
    public ClickableHeaderImageView gDb;
    public ClickableHeaderImageView gDc;
    public ClickableHeaderImageView gDd;
    public TextView gDe;
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
        this.cGn = view.findViewById(e.g.bottom_divider);
        this.gCY = (TextView) view.findViewById(e.g.month_num);
        this.gCX = (TextView) view.findViewById(e.g.day_num);
        this.gCZ = (TextView) view.findViewById(e.g.identity);
        this.gDa = (TextView) view.findViewById(e.g.attention_str);
        this.gDb = (ClickableHeaderImageView) view.findViewById(e.g.header1);
        this.gDb.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds100));
        this.gDb.setAutoChangeStyle(true);
        this.gDb.setOnClickListener(this.mOnClickListener);
        this.gDc = (ClickableHeaderImageView) view.findViewById(e.g.header2);
        this.gDc.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds100));
        this.gDc.setAutoChangeStyle(true);
        this.gDc.setOnClickListener(this.mOnClickListener);
        this.gDd = (ClickableHeaderImageView) view.findViewById(e.g.header3);
        this.gDd.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds100));
        this.gDd.setAutoChangeStyle(true);
        this.gDd.setOnClickListener(this.mOnClickListener);
        this.gDe = (TextView) view.findViewById(e.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.j(this.cGn, e.d.cp_bg_line_c);
            al.h(this.gCY, e.d.cp_cont_f);
            al.h(this.gCX, e.d.cp_cont_f);
            al.h(this.gCZ, e.d.cp_cont_f);
            al.h(this.gDa, e.d.cp_cont_f);
            al.h(this.gDe, e.d.cp_cont_c);
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
        this.gCX.setText(dVar.dci);
        this.gCY.setText(dVar.dch);
        this.gCX.setVisibility(dVar.dco ? 0 : 4);
        this.gCY.setVisibility(dVar.dco ? 0 : 4);
        if (dVar.isHost) {
            this.gCZ.setText(this.mPageContext.getString(e.j.me));
        } else {
            this.gCZ.setText(ao.dU(dVar.sex));
        }
        int H = v.H(dVar.users);
        if (H > 3) {
            this.gDe.setVisibility(0);
            this.gDe.setText(String.format(this.mPageContext.getString(e.j.attention_etc_person), Integer.valueOf(H)));
        } else {
            this.gDe.setVisibility(8);
        }
        if (H >= 3) {
            this.gDd.setVisibility(0);
            this.gDd.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.gDd.setIsGod(true);
            } else {
                this.gDd.setIsGod(false);
            }
            this.gDd.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.gDd.setVisibility(8);
        }
        if (H >= 2) {
            this.gDc.setVisibility(0);
            this.gDc.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.gDc.setIsGod(true);
            } else {
                this.gDc.setIsGod(false);
            }
            this.gDc.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.gDc.setVisibility(8);
        }
        if (H >= 1) {
            this.gDb.setVisibility(0);
            this.gDb.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.gDb.setIsGod(true);
            } else {
                this.gDb.setIsGod(false);
            }
            this.gDb.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.gDb.setVisibility(8);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), userData.getUserId(), userData.getUserName(), null, "focus")));
                    }
                }
            }
        };
    }
}
