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
    public View hYB;
    private boolean isHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mgi;
    public TextView mgj;
    public TextView mgk;
    public TextView mgl;
    public ClickableHeaderImageView mgm;
    public ClickableHeaderImageView mgn;
    public ClickableHeaderImageView mgo;
    public TextView mgp;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.hYB = view.findViewById(R.id.bottom_divider);
        this.mgj = (TextView) view.findViewById(R.id.month_num);
        this.mgi = (TextView) view.findViewById(R.id.day_num);
        this.mgk = (TextView) view.findViewById(R.id.identity);
        this.mgl = (TextView) view.findViewById(R.id.attention_str);
        this.mgm = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.mgm.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mgm.setAutoChangeStyle(true);
        this.mgm.setOnClickListener(this.mOnClickListener);
        this.mgn = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.mgn.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mgn.setAutoChangeStyle(true);
        this.mgn.setOnClickListener(this.mOnClickListener);
        this.mgo = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.mgo.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mgo.setAutoChangeStyle(true);
        this.mgo.setOnClickListener(this.mOnClickListener);
        this.mgp = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setBackgroundColor(this.hYB, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.mgj, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.mgi, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.mgk, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.mgl, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.mgp, (int) R.color.cp_cont_c);
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
        this.mgi.setText(dVar.icf);
        this.mgj.setText(dVar.ice);
        this.mgi.setVisibility(dVar.icl ? 0 : 4);
        this.mgj.setVisibility(dVar.icl ? 0 : 4);
        if (dVar.isHost) {
            this.mgk.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.mgk.setText(at.getUserDescByGender(dVar.sex));
        }
        int count = y.getCount(dVar.users);
        if (count > 3) {
            this.mgp.setVisibility(0);
            this.mgp.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.mgp.setVisibility(8);
        }
        if (count >= 3) {
            this.mgo.setVisibility(0);
            this.mgo.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.mgo.setIsGod(true);
            } else {
                this.mgo.setIsGod(false);
            }
            this.mgo.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.mgo.setVisibility(8);
        }
        if (count >= 2) {
            this.mgn.setVisibility(0);
            this.mgn.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.mgn.setIsGod(true);
            } else {
                this.mgn.setIsGod(false);
            }
            this.mgn.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.mgn.setVisibility(8);
        }
        if (count >= 1) {
            this.mgm.setVisibility(0);
            this.mgm.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.mgm.setIsGod(true);
            } else {
                this.mgm.setIsGod(false);
            }
            this.mgm.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.mgm.setVisibility(8);
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
