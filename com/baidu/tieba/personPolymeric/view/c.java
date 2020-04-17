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
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View gpM;
    private boolean isHost;
    public TextView kdi;
    public TextView kdj;
    public TextView kdk;
    public TextView kdl;
    public ClickableHeaderImageView kdm;
    public ClickableHeaderImageView kdn;
    public ClickableHeaderImageView kdo;
    public TextView kdp;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.gpM = view.findViewById(R.id.bottom_divider);
        this.kdj = (TextView) view.findViewById(R.id.month_num);
        this.kdi = (TextView) view.findViewById(R.id.day_num);
        this.kdk = (TextView) view.findViewById(R.id.identity);
        this.kdl = (TextView) view.findViewById(R.id.attention_str);
        this.kdm = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.kdm.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kdm.setAutoChangeStyle(true);
        this.kdm.setOnClickListener(this.mOnClickListener);
        this.kdn = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.kdn.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kdn.setAutoChangeStyle(true);
        this.kdn.setOnClickListener(this.mOnClickListener);
        this.kdo = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.kdo.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kdo.setAutoChangeStyle(true);
        this.kdo.setOnClickListener(this.mOnClickListener);
        this.kdp = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setBackgroundColor(this.gpM, R.color.cp_bg_line_c);
            am.setViewTextColor(this.kdj, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kdi, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kdk, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kdl, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kdp, (int) R.color.cp_cont_c);
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
        this.kdi.setText(dVar.gtl);
        this.kdj.setText(dVar.gtk);
        this.kdi.setVisibility(dVar.gtr ? 0 : 4);
        this.kdj.setVisibility(dVar.gtr ? 0 : 4);
        if (dVar.isHost) {
            this.kdk.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.kdk.setText(aq.getUserDescByGender(dVar.sex));
        }
        int count = v.getCount(dVar.users);
        if (count > 3) {
            this.kdp.setVisibility(0);
            this.kdp.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.kdp.setVisibility(8);
        }
        if (count >= 3) {
            this.kdo.setVisibility(0);
            this.kdo.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.kdo.setIsGod(true);
            } else {
                this.kdo.setIsGod(false);
            }
            this.kdo.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.kdo.setVisibility(8);
        }
        if (count >= 2) {
            this.kdn.setVisibility(0);
            this.kdn.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.kdn.setIsGod(true);
            } else {
                this.kdn.setIsGod(false);
            }
            this.kdn.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.kdn.setVisibility(8);
        }
        if (count >= 1) {
            this.kdm.setVisibility(0);
            this.kdm.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.kdm.setIsGod(true);
            } else {
                this.kdm.setIsGod(false);
            }
            this.kdm.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.kdm.setVisibility(8);
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
