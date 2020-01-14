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
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View fHL;
    private boolean isHost;
    public TextView jqk;
    public TextView jql;
    public TextView jqm;
    public TextView jqn;
    public ClickableHeaderImageView jqo;
    public ClickableHeaderImageView jqp;
    public ClickableHeaderImageView jqq;
    public TextView jqr;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.fHL = view.findViewById(R.id.bottom_divider);
        this.jql = (TextView) view.findViewById(R.id.month_num);
        this.jqk = (TextView) view.findViewById(R.id.day_num);
        this.jqm = (TextView) view.findViewById(R.id.identity);
        this.jqn = (TextView) view.findViewById(R.id.attention_str);
        this.jqo = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.jqo.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jqo.setAutoChangeStyle(true);
        this.jqo.setOnClickListener(this.mOnClickListener);
        this.jqp = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.jqp.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jqp.setAutoChangeStyle(true);
        this.jqp.setOnClickListener(this.mOnClickListener);
        this.jqq = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.jqq.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jqq.setAutoChangeStyle(true);
        this.jqq.setOnClickListener(this.mOnClickListener);
        this.jqr = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setBackgroundColor(this.fHL, R.color.cp_bg_line_c);
            am.setViewTextColor(this.jql, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jqk, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jqm, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jqn, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jqr, (int) R.color.cp_cont_c);
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
        this.jqk.setText(dVar.fLl);
        this.jql.setText(dVar.fLk);
        this.jqk.setVisibility(dVar.fLr ? 0 : 4);
        this.jql.setVisibility(dVar.fLr ? 0 : 4);
        if (dVar.isHost) {
            this.jqm.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.jqm.setText(aq.getUserDescByGender(dVar.sex));
        }
        int count = v.getCount(dVar.users);
        if (count > 3) {
            this.jqr.setVisibility(0);
            this.jqr.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.jqr.setVisibility(8);
        }
        if (count >= 3) {
            this.jqq.setVisibility(0);
            this.jqq.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.jqq.setIsGod(true);
            } else {
                this.jqq.setIsGod(false);
            }
            this.jqq.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.jqq.setVisibility(8);
        }
        if (count >= 2) {
            this.jqp.setVisibility(0);
            this.jqp.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.jqp.setIsGod(true);
            } else {
                this.jqp.setIsGod(false);
            }
            this.jqp.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.jqp.setVisibility(8);
        }
        if (count >= 1) {
            this.jqo.setVisibility(0);
            this.jqo.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.jqo.setIsGod(true);
            } else {
                this.jqo.setIsGod(false);
            }
            this.jqo.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.jqo.setVisibility(8);
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
