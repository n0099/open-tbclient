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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.d> {
    public View gXn;
    private boolean isHost;
    public TextView kZe;
    public TextView kZf;
    public TextView kZg;
    public TextView kZh;
    public ClickableHeaderImageView kZi;
    public ClickableHeaderImageView kZj;
    public ClickableHeaderImageView kZk;
    public TextView kZl;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.gXn = view.findViewById(R.id.bottom_divider);
        this.kZf = (TextView) view.findViewById(R.id.month_num);
        this.kZe = (TextView) view.findViewById(R.id.day_num);
        this.kZg = (TextView) view.findViewById(R.id.identity);
        this.kZh = (TextView) view.findViewById(R.id.attention_str);
        this.kZi = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.kZi.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kZi.setAutoChangeStyle(true);
        this.kZi.setOnClickListener(this.mOnClickListener);
        this.kZj = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.kZj.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kZj.setAutoChangeStyle(true);
        this.kZj.setOnClickListener(this.mOnClickListener);
        this.kZk = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.kZk.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kZk.setAutoChangeStyle(true);
        this.kZk.setOnClickListener(this.mOnClickListener);
        this.kZl = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ao.setBackgroundColor(this.gXn, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.kZf, R.color.cp_cont_f);
            ao.setViewTextColor(this.kZe, R.color.cp_cont_f);
            ao.setViewTextColor(this.kZg, R.color.cp_cont_f);
            ao.setViewTextColor(this.kZh, R.color.cp_cont_f);
            ao.setViewTextColor(this.kZl, R.color.cp_cont_c);
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
        this.kZe.setText(dVar.haR);
        this.kZf.setText(dVar.haQ);
        this.kZe.setVisibility(dVar.haX ? 0 : 4);
        this.kZf.setVisibility(dVar.haX ? 0 : 4);
        if (dVar.isHost) {
            this.kZg.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.kZg.setText(as.getUserDescByGender(dVar.sex));
        }
        int count = x.getCount(dVar.users);
        if (count > 3) {
            this.kZl.setVisibility(0);
            this.kZl.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.kZl.setVisibility(8);
        }
        if (count >= 3) {
            this.kZk.setVisibility(0);
            this.kZk.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.kZk.setIsGod(true);
            } else {
                this.kZk.setIsGod(false);
            }
            this.kZk.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.kZk.setVisibility(8);
        }
        if (count >= 2) {
            this.kZj.setVisibility(0);
            this.kZj.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.kZj.setIsGod(true);
            } else {
                this.kZj.setIsGod(false);
            }
            this.kZj.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.kZj.setVisibility(8);
        }
        if (count >= 1) {
            this.kZi.setVisibility(0);
            this.kZi.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.kZi.setIsGod(true);
            } else {
                this.kZi.setIsGod(false);
            }
            this.kZi.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.kZi.setVisibility(8);
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
                        TiebaStatic.log(new ap("c11595"));
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
