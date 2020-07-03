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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.d> {
    public View gRI;
    private boolean isHost;
    public TextView kQg;
    public TextView kQh;
    public TextView kQi;
    public TextView kQj;
    public ClickableHeaderImageView kQk;
    public ClickableHeaderImageView kQl;
    public ClickableHeaderImageView kQm;
    public TextView kQn;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.gRI = view.findViewById(R.id.bottom_divider);
        this.kQh = (TextView) view.findViewById(R.id.month_num);
        this.kQg = (TextView) view.findViewById(R.id.day_num);
        this.kQi = (TextView) view.findViewById(R.id.identity);
        this.kQj = (TextView) view.findViewById(R.id.attention_str);
        this.kQk = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.kQk.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kQk.setAutoChangeStyle(true);
        this.kQk.setOnClickListener(this.mOnClickListener);
        this.kQl = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.kQl.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kQl.setAutoChangeStyle(true);
        this.kQl.setOnClickListener(this.mOnClickListener);
        this.kQm = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.kQm.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kQm.setAutoChangeStyle(true);
        this.kQm.setOnClickListener(this.mOnClickListener);
        this.kQn = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            an.setBackgroundColor(this.gRI, R.color.cp_bg_line_c);
            an.setViewTextColor(this.kQh, (int) R.color.cp_cont_f);
            an.setViewTextColor(this.kQg, (int) R.color.cp_cont_f);
            an.setViewTextColor(this.kQi, (int) R.color.cp_cont_f);
            an.setViewTextColor(this.kQj, (int) R.color.cp_cont_f);
            an.setViewTextColor(this.kQn, (int) R.color.cp_cont_c);
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
        this.kQg.setText(dVar.gVn);
        this.kQh.setText(dVar.gVm);
        this.kQg.setVisibility(dVar.gVt ? 0 : 4);
        this.kQh.setVisibility(dVar.gVt ? 0 : 4);
        if (dVar.isHost) {
            this.kQi.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.kQi.setText(ar.getUserDescByGender(dVar.sex));
        }
        int count = w.getCount(dVar.users);
        if (count > 3) {
            this.kQn.setVisibility(0);
            this.kQn.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.kQn.setVisibility(8);
        }
        if (count >= 3) {
            this.kQm.setVisibility(0);
            this.kQm.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.kQm.setIsGod(true);
            } else {
                this.kQm.setIsGod(false);
            }
            this.kQm.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.kQm.setVisibility(8);
        }
        if (count >= 2) {
            this.kQl.setVisibility(0);
            this.kQl.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.kQl.setIsGod(true);
            } else {
                this.kQl.setIsGod(false);
            }
            this.kQl.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.kQl.setVisibility(8);
        }
        if (count >= 1) {
            this.kQk.setVisibility(0);
            this.kQk.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.kQk.setIsGod(true);
            } else {
                this.kQk.setIsGod(false);
            }
            this.kQk.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.kQk.setVisibility(8);
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
                        TiebaStatic.log(new ao("c11595"));
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
