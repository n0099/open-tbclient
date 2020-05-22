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
    public View gEH;
    private boolean isHost;
    public TextView kvd;
    public TextView kve;
    public TextView kvf;
    public TextView kvg;
    public ClickableHeaderImageView kvh;
    public ClickableHeaderImageView kvi;
    public ClickableHeaderImageView kvj;
    public TextView kvk;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.gEH = view.findViewById(R.id.bottom_divider);
        this.kve = (TextView) view.findViewById(R.id.month_num);
        this.kvd = (TextView) view.findViewById(R.id.day_num);
        this.kvf = (TextView) view.findViewById(R.id.identity);
        this.kvg = (TextView) view.findViewById(R.id.attention_str);
        this.kvh = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.kvh.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kvh.setAutoChangeStyle(true);
        this.kvh.setOnClickListener(this.mOnClickListener);
        this.kvi = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.kvi.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kvi.setAutoChangeStyle(true);
        this.kvi.setOnClickListener(this.mOnClickListener);
        this.kvj = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.kvj.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kvj.setAutoChangeStyle(true);
        this.kvj.setOnClickListener(this.mOnClickListener);
        this.kvk = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setBackgroundColor(this.gEH, R.color.cp_bg_line_c);
            am.setViewTextColor(this.kve, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kvd, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kvf, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kvg, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kvk, (int) R.color.cp_cont_c);
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
        this.kvd.setText(dVar.gIc);
        this.kve.setText(dVar.gIb);
        this.kvd.setVisibility(dVar.gIi ? 0 : 4);
        this.kve.setVisibility(dVar.gIi ? 0 : 4);
        if (dVar.isHost) {
            this.kvf.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.kvf.setText(aq.getUserDescByGender(dVar.sex));
        }
        int count = v.getCount(dVar.users);
        if (count > 3) {
            this.kvk.setVisibility(0);
            this.kvk.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.kvk.setVisibility(8);
        }
        if (count >= 3) {
            this.kvj.setVisibility(0);
            this.kvj.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.kvj.setIsGod(true);
            } else {
                this.kvj.setIsGod(false);
            }
            this.kvj.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.kvj.setVisibility(8);
        }
        if (count >= 2) {
            this.kvi.setVisibility(0);
            this.kvi.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.kvi.setIsGod(true);
            } else {
                this.kvi.setIsGod(false);
            }
            this.kvi.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.kvi.setVisibility(8);
        }
        if (count >= 1) {
            this.kvh.setVisibility(0);
            this.kvh.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.kvh.setIsGod(true);
            } else {
                this.kvh.setIsGod(false);
            }
            this.kvh.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.kvh.setVisibility(8);
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
