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
    public View ein;
    private boolean isHost;
    public TextView isU;
    public TextView isV;
    public TextView isW;
    public TextView isX;
    public ClickableHeaderImageView isY;
    public ClickableHeaderImageView isZ;
    public ClickableHeaderImageView ita;
    public TextView itb;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.ein = view.findViewById(R.id.bottom_divider);
        this.isV = (TextView) view.findViewById(R.id.month_num);
        this.isU = (TextView) view.findViewById(R.id.day_num);
        this.isW = (TextView) view.findViewById(R.id.identity);
        this.isX = (TextView) view.findViewById(R.id.attention_str);
        this.isY = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.isY.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.isY.setAutoChangeStyle(true);
        this.isY.setOnClickListener(this.mOnClickListener);
        this.isZ = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.isZ.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.isZ.setAutoChangeStyle(true);
        this.isZ.setOnClickListener(this.mOnClickListener);
        this.ita = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.ita.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.ita.setAutoChangeStyle(true);
        this.ita.setOnClickListener(this.mOnClickListener);
        this.itb = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.home_thread_card_item_bg);
            am.l(this.ein, R.color.cp_bg_line_c);
            am.j(this.isV, R.color.cp_cont_f);
            am.j(this.isU, R.color.cp_cont_f);
            am.j(this.isW, R.color.cp_cont_f);
            am.j(this.isX, R.color.cp_cont_f);
            am.j(this.itb, R.color.cp_cont_c);
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
        this.isU.setText(dVar.eGJ);
        this.isV.setText(dVar.eGI);
        this.isU.setVisibility(dVar.eGP ? 0 : 4);
        this.isV.setVisibility(dVar.eGP ? 0 : 4);
        if (dVar.isHost) {
            this.isW.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.isW.setText(aq.ir(dVar.sex));
        }
        int Z = v.Z(dVar.users);
        if (Z > 3) {
            this.itb.setVisibility(0);
            this.itb.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(Z)));
        } else {
            this.itb.setVisibility(8);
        }
        if (Z >= 3) {
            this.ita.setVisibility(0);
            this.ita.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.ita.setIsGod(true);
            } else {
                this.ita.setIsGod(false);
            }
            this.ita.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.ita.setVisibility(8);
        }
        if (Z >= 2) {
            this.isZ.setVisibility(0);
            this.isZ.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.isZ.setIsGod(true);
            } else {
                this.isZ.setIsGod(false);
            }
            this.isZ.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.isZ.setVisibility(8);
        }
        if (Z >= 1) {
            this.isY.setVisibility(0);
            this.isY.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.isY.setIsGod(true);
            } else {
                this.isY.setIsGod(false);
            }
            this.isY.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.isY.setVisibility(8);
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
