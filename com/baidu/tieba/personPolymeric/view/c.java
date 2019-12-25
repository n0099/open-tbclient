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
/* loaded from: classes8.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View fEB;
    private boolean isHost;
    public TextView jmD;
    public TextView jmE;
    public TextView jmF;
    public TextView jmG;
    public ClickableHeaderImageView jmH;
    public ClickableHeaderImageView jmI;
    public ClickableHeaderImageView jmJ;
    public TextView jmK;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.fEB = view.findViewById(R.id.bottom_divider);
        this.jmE = (TextView) view.findViewById(R.id.month_num);
        this.jmD = (TextView) view.findViewById(R.id.day_num);
        this.jmF = (TextView) view.findViewById(R.id.identity);
        this.jmG = (TextView) view.findViewById(R.id.attention_str);
        this.jmH = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.jmH.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jmH.setAutoChangeStyle(true);
        this.jmH.setOnClickListener(this.mOnClickListener);
        this.jmI = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.jmI.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jmI.setAutoChangeStyle(true);
        this.jmI.setOnClickListener(this.mOnClickListener);
        this.jmJ = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.jmJ.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jmJ.setAutoChangeStyle(true);
        this.jmJ.setOnClickListener(this.mOnClickListener);
        this.jmK = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setBackgroundColor(this.fEB, R.color.cp_bg_line_c);
            am.setViewTextColor(this.jmE, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jmD, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jmF, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jmG, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jmK, (int) R.color.cp_cont_c);
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
        this.jmD.setText(dVar.fIb);
        this.jmE.setText(dVar.fIa);
        this.jmD.setVisibility(dVar.fIh ? 0 : 4);
        this.jmE.setVisibility(dVar.fIh ? 0 : 4);
        if (dVar.isHost) {
            this.jmF.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.jmF.setText(aq.getUserDescByGender(dVar.sex));
        }
        int count = v.getCount(dVar.users);
        if (count > 3) {
            this.jmK.setVisibility(0);
            this.jmK.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.jmK.setVisibility(8);
        }
        if (count >= 3) {
            this.jmJ.setVisibility(0);
            this.jmJ.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.jmJ.setIsGod(true);
            } else {
                this.jmJ.setIsGod(false);
            }
            this.jmJ.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.jmJ.setVisibility(8);
        }
        if (count >= 2) {
            this.jmI.setVisibility(0);
            this.jmI.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.jmI.setIsGod(true);
            } else {
                this.jmI.setIsGod(false);
            }
            this.jmI.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.jmI.setVisibility(8);
        }
        if (count >= 1) {
            this.jmH.setVisibility(0);
            this.jmH.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.jmH.setIsGod(true);
            } else {
                this.jmH.setIsGod(false);
            }
            this.jmH.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.jmH.setVisibility(8);
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
