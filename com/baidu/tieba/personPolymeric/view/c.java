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
    public View fKi;
    private boolean isHost;
    public TextView jrf;
    public TextView jrg;
    public TextView jrh;
    public TextView jri;
    public ClickableHeaderImageView jrj;
    public ClickableHeaderImageView jrk;
    public ClickableHeaderImageView jrl;
    public TextView jrm;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.fKi = view.findViewById(R.id.bottom_divider);
        this.jrg = (TextView) view.findViewById(R.id.month_num);
        this.jrf = (TextView) view.findViewById(R.id.day_num);
        this.jrh = (TextView) view.findViewById(R.id.identity);
        this.jri = (TextView) view.findViewById(R.id.attention_str);
        this.jrj = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.jrj.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jrj.setAutoChangeStyle(true);
        this.jrj.setOnClickListener(this.mOnClickListener);
        this.jrk = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.jrk.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jrk.setAutoChangeStyle(true);
        this.jrk.setOnClickListener(this.mOnClickListener);
        this.jrl = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.jrl.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jrl.setAutoChangeStyle(true);
        this.jrl.setOnClickListener(this.mOnClickListener);
        this.jrm = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setBackgroundColor(this.fKi, R.color.cp_bg_line_c);
            am.setViewTextColor(this.jrg, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jrf, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jrh, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jri, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jrm, (int) R.color.cp_cont_c);
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
        this.jrf.setText(dVar.fNH);
        this.jrg.setText(dVar.fNG);
        this.jrf.setVisibility(dVar.fNN ? 0 : 4);
        this.jrg.setVisibility(dVar.fNN ? 0 : 4);
        if (dVar.isHost) {
            this.jrh.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.jrh.setText(aq.getUserDescByGender(dVar.sex));
        }
        int count = v.getCount(dVar.users);
        if (count > 3) {
            this.jrm.setVisibility(0);
            this.jrm.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.jrm.setVisibility(8);
        }
        if (count >= 3) {
            this.jrl.setVisibility(0);
            this.jrl.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.jrl.setIsGod(true);
            } else {
                this.jrl.setIsGod(false);
            }
            this.jrl.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.jrl.setVisibility(8);
        }
        if (count >= 2) {
            this.jrk.setVisibility(0);
            this.jrk.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.jrk.setIsGod(true);
            } else {
                this.jrk.setIsGod(false);
            }
            this.jrk.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.jrk.setVisibility(8);
        }
        if (count >= 1) {
            this.jrj.setVisibility(0);
            this.jrj.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.jrj.setIsGod(true);
            } else {
                this.jrj.setIsGod(false);
            }
            this.jrj.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.jrj.setVisibility(8);
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
