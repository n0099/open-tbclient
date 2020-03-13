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
    public View fKx;
    private boolean isHost;
    public TextView jrA;
    public TextView jrt;
    public TextView jru;
    public TextView jrv;
    public TextView jrw;
    public ClickableHeaderImageView jrx;
    public ClickableHeaderImageView jry;
    public ClickableHeaderImageView jrz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.fKx = view.findViewById(R.id.bottom_divider);
        this.jru = (TextView) view.findViewById(R.id.month_num);
        this.jrt = (TextView) view.findViewById(R.id.day_num);
        this.jrv = (TextView) view.findViewById(R.id.identity);
        this.jrw = (TextView) view.findViewById(R.id.attention_str);
        this.jrx = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.jrx.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jrx.setAutoChangeStyle(true);
        this.jrx.setOnClickListener(this.mOnClickListener);
        this.jry = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.jry.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jry.setAutoChangeStyle(true);
        this.jry.setOnClickListener(this.mOnClickListener);
        this.jrz = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.jrz.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jrz.setAutoChangeStyle(true);
        this.jrz.setOnClickListener(this.mOnClickListener);
        this.jrA = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setBackgroundColor(this.fKx, R.color.cp_bg_line_c);
            am.setViewTextColor(this.jru, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jrt, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jrv, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jrw, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jrA, (int) R.color.cp_cont_c);
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
        this.jrt.setText(dVar.fNW);
        this.jru.setText(dVar.fNV);
        this.jrt.setVisibility(dVar.fOc ? 0 : 4);
        this.jru.setVisibility(dVar.fOc ? 0 : 4);
        if (dVar.isHost) {
            this.jrv.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.jrv.setText(aq.getUserDescByGender(dVar.sex));
        }
        int count = v.getCount(dVar.users);
        if (count > 3) {
            this.jrA.setVisibility(0);
            this.jrA.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.jrA.setVisibility(8);
        }
        if (count >= 3) {
            this.jrz.setVisibility(0);
            this.jrz.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.jrz.setIsGod(true);
            } else {
                this.jrz.setIsGod(false);
            }
            this.jrz.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.jrz.setVisibility(8);
        }
        if (count >= 2) {
            this.jry.setVisibility(0);
            this.jry.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.jry.setIsGod(true);
            } else {
                this.jry.setIsGod(false);
            }
            this.jry.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.jry.setVisibility(8);
        }
        if (count >= 1) {
            this.jrx.setVisibility(0);
            this.jrx.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.jrx.setIsGod(true);
            } else {
                this.jrx.setIsGod(false);
            }
            this.jrx.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.jrx.setVisibility(8);
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
