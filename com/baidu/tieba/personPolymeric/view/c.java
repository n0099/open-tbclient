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
    public View gpS;
    private boolean isHost;
    public TextView kdm;
    public TextView kdn;
    public TextView kdo;
    public TextView kdp;
    public ClickableHeaderImageView kdq;
    public ClickableHeaderImageView kdr;
    public ClickableHeaderImageView kds;
    public TextView kdt;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.gpS = view.findViewById(R.id.bottom_divider);
        this.kdn = (TextView) view.findViewById(R.id.month_num);
        this.kdm = (TextView) view.findViewById(R.id.day_num);
        this.kdo = (TextView) view.findViewById(R.id.identity);
        this.kdp = (TextView) view.findViewById(R.id.attention_str);
        this.kdq = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.kdq.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kdq.setAutoChangeStyle(true);
        this.kdq.setOnClickListener(this.mOnClickListener);
        this.kdr = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.kdr.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kdr.setAutoChangeStyle(true);
        this.kdr.setOnClickListener(this.mOnClickListener);
        this.kds = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.kds.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.kds.setAutoChangeStyle(true);
        this.kds.setOnClickListener(this.mOnClickListener);
        this.kdt = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setBackgroundColor(this.gpS, R.color.cp_bg_line_c);
            am.setViewTextColor(this.kdn, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kdm, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kdo, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kdp, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.kdt, (int) R.color.cp_cont_c);
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
        this.kdm.setText(dVar.gtr);
        this.kdn.setText(dVar.gtq);
        this.kdm.setVisibility(dVar.gtx ? 0 : 4);
        this.kdn.setVisibility(dVar.gtx ? 0 : 4);
        if (dVar.isHost) {
            this.kdo.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.kdo.setText(aq.getUserDescByGender(dVar.sex));
        }
        int count = v.getCount(dVar.users);
        if (count > 3) {
            this.kdt.setVisibility(0);
            this.kdt.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.kdt.setVisibility(8);
        }
        if (count >= 3) {
            this.kds.setVisibility(0);
            this.kds.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.kds.setIsGod(true);
            } else {
                this.kds.setIsGod(false);
            }
            this.kds.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.kds.setVisibility(8);
        }
        if (count >= 2) {
            this.kdr.setVisibility(0);
            this.kdr.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.kdr.setIsGod(true);
            } else {
                this.kdr.setIsGod(false);
            }
            this.kdr.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.kdr.setVisibility(8);
        }
        if (count >= 1) {
            this.kdq.setVisibility(0);
            this.kdq.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.kdq.setIsGod(true);
            } else {
                this.kdq.setIsGod(false);
            }
            this.kdq.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.kdq.setVisibility(8);
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
