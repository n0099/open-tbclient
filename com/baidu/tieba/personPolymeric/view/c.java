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
    public TextView jqf;
    public TextView jqg;
    public TextView jqh;
    public TextView jqi;
    public ClickableHeaderImageView jqj;
    public ClickableHeaderImageView jqk;
    public ClickableHeaderImageView jql;
    public TextView jqm;
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
        this.jqg = (TextView) view.findViewById(R.id.month_num);
        this.jqf = (TextView) view.findViewById(R.id.day_num);
        this.jqh = (TextView) view.findViewById(R.id.identity);
        this.jqi = (TextView) view.findViewById(R.id.attention_str);
        this.jqj = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.jqj.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jqj.setAutoChangeStyle(true);
        this.jqj.setOnClickListener(this.mOnClickListener);
        this.jqk = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.jqk.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jqk.setAutoChangeStyle(true);
        this.jqk.setOnClickListener(this.mOnClickListener);
        this.jql = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.jql.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jql.setAutoChangeStyle(true);
        this.jql.setOnClickListener(this.mOnClickListener);
        this.jqm = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setBackgroundColor(this.fHL, R.color.cp_bg_line_c);
            am.setViewTextColor(this.jqg, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jqf, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jqh, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jqi, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jqm, (int) R.color.cp_cont_c);
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
        this.jqf.setText(dVar.fLl);
        this.jqg.setText(dVar.fLk);
        this.jqf.setVisibility(dVar.fLr ? 0 : 4);
        this.jqg.setVisibility(dVar.fLr ? 0 : 4);
        if (dVar.isHost) {
            this.jqh.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.jqh.setText(aq.getUserDescByGender(dVar.sex));
        }
        int count = v.getCount(dVar.users);
        if (count > 3) {
            this.jqm.setVisibility(0);
            this.jqm.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.jqm.setVisibility(8);
        }
        if (count >= 3) {
            this.jql.setVisibility(0);
            this.jql.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.jql.setIsGod(true);
            } else {
                this.jql.setIsGod(false);
            }
            this.jql.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.jql.setVisibility(8);
        }
        if (count >= 2) {
            this.jqk.setVisibility(0);
            this.jqk.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.jqk.setIsGod(true);
            } else {
                this.jqk.setIsGod(false);
            }
            this.jqk.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.jqk.setVisibility(8);
        }
        if (count >= 1) {
            this.jqj.setVisibility(0);
            this.jqj.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.jqj.setIsGod(true);
            } else {
                this.jqj.setIsGod(false);
            }
            this.jqj.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.jqj.setVisibility(8);
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
