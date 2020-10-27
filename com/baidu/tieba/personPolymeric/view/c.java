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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.d> {
    public View hSE;
    private boolean isHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView maj;
    public TextView mak;
    public TextView mal;
    public TextView mam;
    public ClickableHeaderImageView man;
    public ClickableHeaderImageView mao;
    public ClickableHeaderImageView maq;
    public TextView mar;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.hSE = view.findViewById(R.id.bottom_divider);
        this.mak = (TextView) view.findViewById(R.id.month_num);
        this.maj = (TextView) view.findViewById(R.id.day_num);
        this.mal = (TextView) view.findViewById(R.id.identity);
        this.mam = (TextView) view.findViewById(R.id.attention_str);
        this.man = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.man.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.man.setAutoChangeStyle(true);
        this.man.setOnClickListener(this.mOnClickListener);
        this.mao = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.mao.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mao.setAutoChangeStyle(true);
        this.mao.setOnClickListener(this.mOnClickListener);
        this.maq = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.maq.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.maq.setAutoChangeStyle(true);
        this.maq.setOnClickListener(this.mOnClickListener);
        this.mar = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setBackgroundColor(this.hSE, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.mak, R.color.cp_cont_f);
            ap.setViewTextColor(this.maj, R.color.cp_cont_f);
            ap.setViewTextColor(this.mal, R.color.cp_cont_f);
            ap.setViewTextColor(this.mam, R.color.cp_cont_f);
            ap.setViewTextColor(this.mar, R.color.cp_cont_c);
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
        this.maj.setText(dVar.hWi);
        this.mak.setText(dVar.hWh);
        this.maj.setVisibility(dVar.hWo ? 0 : 4);
        this.mak.setVisibility(dVar.hWo ? 0 : 4);
        if (dVar.isHost) {
            this.mal.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.mal.setText(at.getUserDescByGender(dVar.sex));
        }
        int count = y.getCount(dVar.users);
        if (count > 3) {
            this.mar.setVisibility(0);
            this.mar.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.mar.setVisibility(8);
        }
        if (count >= 3) {
            this.maq.setVisibility(0);
            this.maq.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.maq.setIsGod(true);
            } else {
                this.maq.setIsGod(false);
            }
            this.maq.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.maq.setVisibility(8);
        }
        if (count >= 2) {
            this.mao.setVisibility(0);
            this.mao.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.mao.setIsGod(true);
            } else {
                this.mao.setIsGod(false);
            }
            this.mao.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.mao.setVisibility(8);
        }
        if (count >= 1) {
            this.man.setVisibility(0);
            this.man.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.man.setIsGod(true);
            } else {
                this.man.setIsGod(false);
            }
            this.man.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.man.setVisibility(8);
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
                        TiebaStatic.log(new aq("c11595"));
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
