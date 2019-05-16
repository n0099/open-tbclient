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
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View edD;
    public ClickableHeaderImageView ilA;
    public ClickableHeaderImageView ilB;
    public TextView ilC;
    public TextView ilv;
    public TextView ilw;
    public TextView ilx;
    public TextView ily;
    public ClickableHeaderImageView ilz;
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
        this.edD = view.findViewById(R.id.bottom_divider);
        this.ilw = (TextView) view.findViewById(R.id.month_num);
        this.ilv = (TextView) view.findViewById(R.id.day_num);
        this.ilx = (TextView) view.findViewById(R.id.identity);
        this.ily = (TextView) view.findViewById(R.id.attention_str);
        this.ilz = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.ilz.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.ilz.setAutoChangeStyle(true);
        this.ilz.setOnClickListener(this.mOnClickListener);
        this.ilA = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.ilA.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.ilA.setAutoChangeStyle(true);
        this.ilA.setOnClickListener(this.mOnClickListener);
        this.ilB = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.ilB.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.ilB.setAutoChangeStyle(true);
        this.ilB.setOnClickListener(this.mOnClickListener);
        this.ilC = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.drawable.home_thread_card_item_bg);
            al.l(this.edD, R.color.cp_bg_line_c);
            al.j(this.ilw, R.color.cp_cont_f);
            al.j(this.ilv, R.color.cp_cont_f);
            al.j(this.ilx, R.color.cp_cont_f);
            al.j(this.ily, R.color.cp_cont_f);
            al.j(this.ilC, R.color.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_info_attention_card;
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
        this.ilv.setText(dVar.eBF);
        this.ilw.setText(dVar.eBE);
        this.ilv.setVisibility(dVar.eBL ? 0 : 4);
        this.ilw.setVisibility(dVar.eBL ? 0 : 4);
        if (dVar.isHost) {
            this.ilx.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.ilx.setText(ap.il(dVar.sex));
        }
        int Z = v.Z(dVar.users);
        if (Z > 3) {
            this.ilC.setVisibility(0);
            this.ilC.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(Z)));
        } else {
            this.ilC.setVisibility(8);
        }
        if (Z >= 3) {
            this.ilB.setVisibility(0);
            this.ilB.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.ilB.setIsGod(true);
            } else {
                this.ilB.setIsGod(false);
            }
            this.ilB.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.ilB.setVisibility(8);
        }
        if (Z >= 2) {
            this.ilA.setVisibility(0);
            this.ilA.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.ilA.setIsGod(true);
            } else {
                this.ilA.setIsGod(false);
            }
            this.ilA.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.ilA.setVisibility(8);
        }
        if (Z >= 1) {
            this.ilz.setVisibility(0);
            this.ilz.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.ilz.setIsGod(true);
            } else {
                this.ilz.setIsGod(false);
            }
            this.ilz.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.ilz.setVisibility(8);
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
