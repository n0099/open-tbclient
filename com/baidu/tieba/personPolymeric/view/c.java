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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View ejX;
    private boolean isHost;
    public TextView iuT;
    public TextView iuU;
    public TextView iuV;
    public TextView iuW;
    public ClickableHeaderImageView iuX;
    public ClickableHeaderImageView iuY;
    public ClickableHeaderImageView iuZ;
    public TextView iva;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.ejX = view.findViewById(R.id.bottom_divider);
        this.iuU = (TextView) view.findViewById(R.id.month_num);
        this.iuT = (TextView) view.findViewById(R.id.day_num);
        this.iuV = (TextView) view.findViewById(R.id.identity);
        this.iuW = (TextView) view.findViewById(R.id.attention_str);
        this.iuX = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.iuX.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.iuX.setAutoChangeStyle(true);
        this.iuX.setOnClickListener(this.mOnClickListener);
        this.iuY = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.iuY.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.iuY.setAutoChangeStyle(true);
        this.iuY.setOnClickListener(this.mOnClickListener);
        this.iuZ = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.iuZ.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.iuZ.setAutoChangeStyle(true);
        this.iuZ.setOnClickListener(this.mOnClickListener);
        this.iva = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.home_thread_card_item_bg);
            am.l(this.ejX, R.color.cp_bg_line_c);
            am.j(this.iuU, R.color.cp_cont_f);
            am.j(this.iuT, R.color.cp_cont_f);
            am.j(this.iuV, R.color.cp_cont_f);
            am.j(this.iuW, R.color.cp_cont_f);
            am.j(this.iva, R.color.cp_cont_c);
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
        this.iuT.setText(dVar.eIs);
        this.iuU.setText(dVar.eIr);
        this.iuT.setVisibility(dVar.eIy ? 0 : 4);
        this.iuU.setVisibility(dVar.eIy ? 0 : 4);
        if (dVar.isHost) {
            this.iuV.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.iuV.setText(aq.is(dVar.sex));
        }
        int Z = v.Z(dVar.users);
        if (Z > 3) {
            this.iva.setVisibility(0);
            this.iva.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(Z)));
        } else {
            this.iva.setVisibility(8);
        }
        if (Z >= 3) {
            this.iuZ.setVisibility(0);
            this.iuZ.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.iuZ.setIsGod(true);
            } else {
                this.iuZ.setIsGod(false);
            }
            this.iuZ.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.iuZ.setVisibility(8);
        }
        if (Z >= 2) {
            this.iuY.setVisibility(0);
            this.iuY.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.iuY.setIsGod(true);
            } else {
                this.iuY.setIsGod(false);
            }
            this.iuY.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.iuY.setVisibility(8);
        }
        if (Z >= 1) {
            this.iuX.setVisibility(0);
            this.iuX.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.iuX.setIsGod(true);
            } else {
                this.iuX.setIsGod(false);
            }
            this.iuX.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.iuX.setVisibility(8);
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
