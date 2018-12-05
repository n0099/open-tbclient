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
    public View cEB;
    public TextView gzb;
    public TextView gzc;
    public TextView gzd;
    public TextView gze;
    public ClickableHeaderImageView gzf;
    public ClickableHeaderImageView gzg;
    public ClickableHeaderImageView gzh;
    public TextView gzi;
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
        this.cEB = view.findViewById(e.g.bottom_divider);
        this.gzc = (TextView) view.findViewById(e.g.month_num);
        this.gzb = (TextView) view.findViewById(e.g.day_num);
        this.gzd = (TextView) view.findViewById(e.g.identity);
        this.gze = (TextView) view.findViewById(e.g.attention_str);
        this.gzf = (ClickableHeaderImageView) view.findViewById(e.g.header1);
        this.gzf.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds100));
        this.gzf.setAutoChangeStyle(true);
        this.gzf.setOnClickListener(this.mOnClickListener);
        this.gzg = (ClickableHeaderImageView) view.findViewById(e.g.header2);
        this.gzg.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds100));
        this.gzg.setAutoChangeStyle(true);
        this.gzg.setOnClickListener(this.mOnClickListener);
        this.gzh = (ClickableHeaderImageView) view.findViewById(e.g.header3);
        this.gzh.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds100));
        this.gzh.setAutoChangeStyle(true);
        this.gzh.setOnClickListener(this.mOnClickListener);
        this.gzi = (TextView) view.findViewById(e.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.j(this.cEB, e.d.cp_bg_line_c);
            al.h(this.gzc, e.d.cp_cont_f);
            al.h(this.gzb, e.d.cp_cont_f);
            al.h(this.gzd, e.d.cp_cont_f);
            al.h(this.gze, e.d.cp_cont_f);
            al.h(this.gzi, e.d.cp_cont_c);
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
        this.gzb.setText(dVar.cYD);
        this.gzc.setText(dVar.cYC);
        this.gzb.setVisibility(dVar.cYJ ? 0 : 4);
        this.gzc.setVisibility(dVar.cYJ ? 0 : 4);
        if (dVar.isHost) {
            this.gzd.setText(this.mPageContext.getString(e.j.me));
        } else {
            this.gzd.setText(ao.dU(dVar.sex));
        }
        int H = v.H(dVar.users);
        if (H > 3) {
            this.gzi.setVisibility(0);
            this.gzi.setText(String.format(this.mPageContext.getString(e.j.attention_etc_person), Integer.valueOf(H)));
        } else {
            this.gzi.setVisibility(8);
        }
        if (H >= 3) {
            this.gzh.setVisibility(0);
            this.gzh.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.gzh.setIsGod(true);
            } else {
                this.gzh.setIsGod(false);
            }
            this.gzh.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.gzh.setVisibility(8);
        }
        if (H >= 2) {
            this.gzg.setVisibility(0);
            this.gzg.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.gzg.setIsGod(true);
            } else {
                this.gzg.setIsGod(false);
            }
            this.gzg.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.gzg.setVisibility(8);
        }
        if (H >= 1) {
            this.gzf.setVisibility(0);
            this.gzf.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.gzf.setIsGod(true);
            } else {
                this.gzf.setIsGod(false);
            }
            this.gzf.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.gzf.setVisibility(8);
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
