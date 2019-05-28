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
    public View edE;
    public TextView ilA;
    public TextView ilB;
    public ClickableHeaderImageView ilC;
    public ClickableHeaderImageView ilD;
    public ClickableHeaderImageView ilE;
    public TextView ilF;
    public TextView ily;
    public TextView ilz;
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
        this.edE = view.findViewById(R.id.bottom_divider);
        this.ilz = (TextView) view.findViewById(R.id.month_num);
        this.ily = (TextView) view.findViewById(R.id.day_num);
        this.ilA = (TextView) view.findViewById(R.id.identity);
        this.ilB = (TextView) view.findViewById(R.id.attention_str);
        this.ilC = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.ilC.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.ilC.setAutoChangeStyle(true);
        this.ilC.setOnClickListener(this.mOnClickListener);
        this.ilD = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.ilD.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.ilD.setAutoChangeStyle(true);
        this.ilD.setOnClickListener(this.mOnClickListener);
        this.ilE = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.ilE.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.ilE.setAutoChangeStyle(true);
        this.ilE.setOnClickListener(this.mOnClickListener);
        this.ilF = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.drawable.home_thread_card_item_bg);
            al.l(this.edE, R.color.cp_bg_line_c);
            al.j(this.ilz, R.color.cp_cont_f);
            al.j(this.ily, R.color.cp_cont_f);
            al.j(this.ilA, R.color.cp_cont_f);
            al.j(this.ilB, R.color.cp_cont_f);
            al.j(this.ilF, R.color.cp_cont_c);
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
        this.ily.setText(dVar.eBG);
        this.ilz.setText(dVar.eBF);
        this.ily.setVisibility(dVar.eBM ? 0 : 4);
        this.ilz.setVisibility(dVar.eBM ? 0 : 4);
        if (dVar.isHost) {
            this.ilA.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.ilA.setText(ap.il(dVar.sex));
        }
        int Z = v.Z(dVar.users);
        if (Z > 3) {
            this.ilF.setVisibility(0);
            this.ilF.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(Z)));
        } else {
            this.ilF.setVisibility(8);
        }
        if (Z >= 3) {
            this.ilE.setVisibility(0);
            this.ilE.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.ilE.setIsGod(true);
            } else {
                this.ilE.setIsGod(false);
            }
            this.ilE.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.ilE.setVisibility(8);
        }
        if (Z >= 2) {
            this.ilD.setVisibility(0);
            this.ilD.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.ilD.setIsGod(true);
            } else {
                this.ilD.setIsGod(false);
            }
            this.ilD.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.ilD.setVisibility(8);
        }
        if (Z >= 1) {
            this.ilC.setVisibility(0);
            this.ilC.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.ilC.setIsGod(true);
            } else {
                this.ilC.setIsGod(false);
            }
            this.ilC.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.ilC.setVisibility(8);
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
