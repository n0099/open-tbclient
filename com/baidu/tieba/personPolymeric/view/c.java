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
    public View eig;
    public TextView irR;
    public TextView irS;
    public TextView irT;
    public TextView irU;
    public ClickableHeaderImageView irV;
    public ClickableHeaderImageView irW;
    public ClickableHeaderImageView irX;
    public TextView irY;
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
        this.eig = view.findViewById(R.id.bottom_divider);
        this.irS = (TextView) view.findViewById(R.id.month_num);
        this.irR = (TextView) view.findViewById(R.id.day_num);
        this.irT = (TextView) view.findViewById(R.id.identity);
        this.irU = (TextView) view.findViewById(R.id.attention_str);
        this.irV = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.irV.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.irV.setAutoChangeStyle(true);
        this.irV.setOnClickListener(this.mOnClickListener);
        this.irW = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.irW.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.irW.setAutoChangeStyle(true);
        this.irW.setOnClickListener(this.mOnClickListener);
        this.irX = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.irX.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.irX.setAutoChangeStyle(true);
        this.irX.setOnClickListener(this.mOnClickListener);
        this.irY = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.home_thread_card_item_bg);
            am.l(this.eig, R.color.cp_bg_line_c);
            am.j(this.irS, R.color.cp_cont_f);
            am.j(this.irR, R.color.cp_cont_f);
            am.j(this.irT, R.color.cp_cont_f);
            am.j(this.irU, R.color.cp_cont_f);
            am.j(this.irY, R.color.cp_cont_c);
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
        this.irR.setText(dVar.eGC);
        this.irS.setText(dVar.eGB);
        this.irR.setVisibility(dVar.eGI ? 0 : 4);
        this.irS.setVisibility(dVar.eGI ? 0 : 4);
        if (dVar.isHost) {
            this.irT.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.irT.setText(aq.ir(dVar.sex));
        }
        int Z = v.Z(dVar.users);
        if (Z > 3) {
            this.irY.setVisibility(0);
            this.irY.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(Z)));
        } else {
            this.irY.setVisibility(8);
        }
        if (Z >= 3) {
            this.irX.setVisibility(0);
            this.irX.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.irX.setIsGod(true);
            } else {
                this.irX.setIsGod(false);
            }
            this.irX.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.irX.setVisibility(8);
        }
        if (Z >= 2) {
            this.irW.setVisibility(0);
            this.irW.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.irW.setIsGod(true);
            } else {
                this.irW.setIsGod(false);
            }
            this.irW.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.irW.setVisibility(8);
        }
        if (Z >= 1) {
            this.irV.setVisibility(0);
            this.irV.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.irV.setIsGod(true);
            } else {
                this.irV.setIsGod(false);
            }
            this.irV.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.irV.setVisibility(8);
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
