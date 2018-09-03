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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View clf;
    public TextView gbU;
    public TextView gbV;
    public TextView gbW;
    public TextView gbX;
    public ClickableHeaderImageView gbY;
    public ClickableHeaderImageView gbZ;
    public ClickableHeaderImageView gca;
    public TextView gcb;
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
        this.clf = view.findViewById(f.g.bottom_divider);
        this.gbV = (TextView) view.findViewById(f.g.month_num);
        this.gbU = (TextView) view.findViewById(f.g.day_num);
        this.gbW = (TextView) view.findViewById(f.g.identity);
        this.gbX = (TextView) view.findViewById(f.g.attention_str);
        this.gbY = (ClickableHeaderImageView) view.findViewById(f.g.header1);
        this.gbY.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), f.e.ds100));
        this.gbY.setAutoChangeStyle(true);
        this.gbY.setOnClickListener(this.mOnClickListener);
        this.gbZ = (ClickableHeaderImageView) view.findViewById(f.g.header2);
        this.gbZ.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), f.e.ds100));
        this.gbZ.setAutoChangeStyle(true);
        this.gbZ.setOnClickListener(this.mOnClickListener);
        this.gca = (ClickableHeaderImageView) view.findViewById(f.g.header3);
        this.gca.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), f.e.ds100));
        this.gca.setAutoChangeStyle(true);
        this.gca.setOnClickListener(this.mOnClickListener);
        this.gcb = (TextView) view.findViewById(f.g.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.C0146f.home_thread_card_item_bg);
            am.j(this.clf, f.d.cp_bg_line_c);
            am.h(this.gbV, f.d.cp_cont_f);
            am.h(this.gbU, f.d.cp_cont_f);
            am.h(this.gbW, f.d.cp_cont_f);
            am.h(this.gbX, f.d.cp_cont_f);
            am.h(this.gcb, f.d.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.person_info_attention_card;
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
        this.gbU.setText(dVar.cCG);
        this.gbV.setText(dVar.cCF);
        this.gbU.setVisibility(dVar.cCM ? 0 : 4);
        this.gbV.setVisibility(dVar.cCM ? 0 : 4);
        if (dVar.isHost) {
            this.gbW.setText(this.mPageContext.getString(f.j.me));
        } else {
            this.gbW.setText(ap.cZ(dVar.sex));
        }
        int y = w.y(dVar.users);
        if (y > 3) {
            this.gcb.setVisibility(0);
            this.gcb.setText(String.format(this.mPageContext.getString(f.j.attention_etc_person), Integer.valueOf(y)));
        } else {
            this.gcb.setVisibility(8);
        }
        if (y >= 3) {
            this.gca.setVisibility(0);
            this.gca.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.gca.setIsGod(true);
            } else {
                this.gca.setIsGod(false);
            }
            this.gca.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.gca.setVisibility(8);
        }
        if (y >= 2) {
            this.gbZ.setVisibility(0);
            this.gbZ.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.gbZ.setIsGod(true);
            } else {
                this.gbZ.setIsGod(false);
            }
            this.gbZ.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.gbZ.setVisibility(8);
        }
        if (y >= 1) {
            this.gbY.setVisibility(0);
            this.gbY.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.gbY.setIsGod(true);
            } else {
                this.gbY.setIsGod(false);
            }
            this.gbY.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.gbY.setVisibility(8);
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
