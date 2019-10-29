package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    public View eNE;
    private boolean isHost;
    public ClickableHeaderImageView itA;
    public TextView itB;
    public TextView itu;
    public TextView itv;
    public TextView itw;
    public TextView itx;
    public ClickableHeaderImageView ity;
    public ClickableHeaderImageView itz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.eNE = view.findViewById(R.id.bottom_divider);
        this.itv = (TextView) view.findViewById(R.id.month_num);
        this.itu = (TextView) view.findViewById(R.id.day_num);
        this.itw = (TextView) view.findViewById(R.id.identity);
        this.itx = (TextView) view.findViewById(R.id.attention_str);
        this.ity = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.ity.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.ity.setAutoChangeStyle(true);
        this.ity.setOnClickListener(this.mOnClickListener);
        this.itz = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.itz.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.itz.setAutoChangeStyle(true);
        this.itz.setOnClickListener(this.mOnClickListener);
        this.itA = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.itA.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.itA.setAutoChangeStyle(true);
        this.itA.setOnClickListener(this.mOnClickListener);
        this.itB = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setBackgroundColor(this.eNE, R.color.cp_bg_line_c);
            am.setViewTextColor(this.itv, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.itu, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.itw, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.itx, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.itB, (int) R.color.cp_cont_c);
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
        this.itu.setText(dVar.eQX);
        this.itv.setText(dVar.eQW);
        this.itu.setVisibility(dVar.eRd ? 0 : 4);
        this.itv.setVisibility(dVar.eRd ? 0 : 4);
        if (dVar.isHost) {
            this.itw.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.itw.setText(aq.getUserDescByGender(dVar.sex));
        }
        int count = v.getCount(dVar.users);
        if (count > 3) {
            this.itB.setVisibility(0);
            this.itB.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.itB.setVisibility(8);
        }
        if (count >= 3) {
            this.itA.setVisibility(0);
            this.itA.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.itA.setIsGod(true);
            } else {
                this.itA.setIsGod(false);
            }
            this.itA.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.itA.setVisibility(8);
        }
        if (count >= 2) {
            this.itz.setVisibility(0);
            this.itz.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.itz.setIsGod(true);
            } else {
                this.itz.setIsGod(false);
            }
            this.itz.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.itz.setVisibility(8);
        }
        if (count >= 1) {
            this.ity.setVisibility(0);
            this.ity.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.ity.setIsGod(true);
            } else {
                this.ity.setIsGod(false);
            }
            this.ity.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.ity.setVisibility(8);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mPageContext.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
    }
}
