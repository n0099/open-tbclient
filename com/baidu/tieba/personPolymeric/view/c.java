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
/* loaded from: classes11.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.d> {
    public View gES;
    private boolean isHost;
    public TextView kwj;
    public TextView kwk;
    public TextView kwl;
    public TextView kwm;
    public ClickableHeaderImageView kwn;
    public ClickableHeaderImageView kwo;
    public ClickableHeaderImageView kwp;
    public TextView kwq;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.gES = view.findViewById(R.id.bottom_divider);
        this.kwk = (TextView) view.findViewById(R.id.month_num);
        this.kwj = (TextView) view.findViewById(R.id.day_num);
        this.kwl = (TextView) view.findViewById(R.id.identity);
        this.kwm = (TextView) view.findViewById(R.id.attention_str);
        this.kwn = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.kwn.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kwn.setAutoChangeStyle(true);
        this.kwn.setOnClickListener(this.mOnClickListener);
        this.kwo = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.kwo.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kwo.setAutoChangeStyle(true);
        this.kwo.setOnClickListener(this.mOnClickListener);
        this.kwp = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.kwp.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kwp.setAutoChangeStyle(true);
        this.kwp.setOnClickListener(this.mOnClickListener);
        this.kwq = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setBackgroundColor(this.gES, R.color.cp_bg_line_c);
            am.setViewTextColor(this.kwk, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kwj, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kwl, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kwm, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kwq, (int) R.color.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_info_attention_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
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
        this.kwj.setText(dVar.gIn);
        this.kwk.setText(dVar.gIm);
        this.kwj.setVisibility(dVar.gIt ? 0 : 4);
        this.kwk.setVisibility(dVar.gIt ? 0 : 4);
        if (dVar.isHost) {
            this.kwl.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.kwl.setText(aq.getUserDescByGender(dVar.sex));
        }
        int count = v.getCount(dVar.users);
        if (count > 3) {
            this.kwq.setVisibility(0);
            this.kwq.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.kwq.setVisibility(8);
        }
        if (count >= 3) {
            this.kwp.setVisibility(0);
            this.kwp.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.kwp.setIsGod(true);
            } else {
                this.kwp.setIsGod(false);
            }
            this.kwp.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.kwp.setVisibility(8);
        }
        if (count >= 2) {
            this.kwo.setVisibility(0);
            this.kwo.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.kwo.setIsGod(true);
            } else {
                this.kwo.setIsGod(false);
            }
            this.kwo.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.kwo.setVisibility(8);
        }
        if (count >= 1) {
            this.kwn.setVisibility(0);
            this.kwn.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.kwn.setIsGod(true);
            } else {
                this.kwn.setIsGod(false);
            }
            this.kwn.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.kwn.setVisibility(8);
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
