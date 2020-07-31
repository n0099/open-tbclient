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
    public TextView kZc;
    public TextView kZd;
    public TextView kZe;
    public TextView kZf;
    public ClickableHeaderImageView kZg;
    public ClickableHeaderImageView kZh;
    public ClickableHeaderImageView kZi;
    public TextView kZj;
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
        this.kZd = (TextView) view.findViewById(R.id.month_num);
        this.kZc = (TextView) view.findViewById(R.id.day_num);
        this.kZe = (TextView) view.findViewById(R.id.identity);
        this.kZf = (TextView) view.findViewById(R.id.attention_str);
        this.kZg = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.kZg.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kZg.setAutoChangeStyle(true);
        this.kZg.setOnClickListener(this.mOnClickListener);
        this.kZh = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.kZh.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kZh.setAutoChangeStyle(true);
        this.kZh.setOnClickListener(this.mOnClickListener);
        this.kZi = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.kZi.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kZi.setAutoChangeStyle(true);
        this.kZi.setOnClickListener(this.mOnClickListener);
        this.kZj = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ao.setBackgroundColor(this.gXn, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.kZd, R.color.cp_cont_f);
            ao.setViewTextColor(this.kZc, R.color.cp_cont_f);
            ao.setViewTextColor(this.kZe, R.color.cp_cont_f);
            ao.setViewTextColor(this.kZf, R.color.cp_cont_f);
            ao.setViewTextColor(this.kZj, R.color.cp_cont_c);
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
        this.kZc.setText(dVar.haR);
        this.kZd.setText(dVar.haQ);
        this.kZc.setVisibility(dVar.haX ? 0 : 4);
        this.kZd.setVisibility(dVar.haX ? 0 : 4);
        if (dVar.isHost) {
            this.kZe.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.kZe.setText(as.getUserDescByGender(dVar.sex));
        }
        int count = x.getCount(dVar.users);
        if (count > 3) {
            this.kZj.setVisibility(0);
            this.kZj.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.kZj.setVisibility(8);
        }
        if (count >= 3) {
            this.kZi.setVisibility(0);
            this.kZi.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.kZi.setIsGod(true);
            } else {
                this.kZi.setIsGod(false);
            }
            this.kZi.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.kZi.setVisibility(8);
        }
        if (count >= 2) {
            this.kZh.setVisibility(0);
            this.kZh.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.kZh.setIsGod(true);
            } else {
                this.kZh.setIsGod(false);
            }
            this.kZh.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.kZh.setVisibility(8);
        }
        if (count >= 1) {
            this.kZg.setVisibility(0);
            this.kZg.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.kZg.setIsGod(true);
            } else {
                this.kZg.setIsGod(false);
            }
            this.kZg.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.kZg.setVisibility(8);
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
