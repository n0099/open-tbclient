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
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    public View eMN;
    public TextView isD;
    public TextView isE;
    public TextView isF;
    public TextView isG;
    public ClickableHeaderImageView isH;
    private boolean isHost;
    public ClickableHeaderImageView isI;
    public ClickableHeaderImageView isJ;
    public TextView isK;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.eMN = view.findViewById(R.id.bottom_divider);
        this.isE = (TextView) view.findViewById(R.id.month_num);
        this.isD = (TextView) view.findViewById(R.id.day_num);
        this.isF = (TextView) view.findViewById(R.id.identity);
        this.isG = (TextView) view.findViewById(R.id.attention_str);
        this.isH = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.isH.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.isH.setAutoChangeStyle(true);
        this.isH.setOnClickListener(this.mOnClickListener);
        this.isI = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.isI.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.isI.setAutoChangeStyle(true);
        this.isI.setOnClickListener(this.mOnClickListener);
        this.isJ = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.isJ.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.isJ.setAutoChangeStyle(true);
        this.isJ.setOnClickListener(this.mOnClickListener);
        this.isK = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setBackgroundColor(this.eMN, R.color.cp_bg_line_c);
            am.setViewTextColor(this.isE, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.isD, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.isF, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.isG, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.isK, (int) R.color.cp_cont_c);
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
        this.isD.setText(dVar.eQg);
        this.isE.setText(dVar.eQf);
        this.isD.setVisibility(dVar.eQm ? 0 : 4);
        this.isE.setVisibility(dVar.eQm ? 0 : 4);
        if (dVar.isHost) {
            this.isF.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.isF.setText(aq.getUserDescByGender(dVar.sex));
        }
        int count = v.getCount(dVar.users);
        if (count > 3) {
            this.isK.setVisibility(0);
            this.isK.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.isK.setVisibility(8);
        }
        if (count >= 3) {
            this.isJ.setVisibility(0);
            this.isJ.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.isJ.setIsGod(true);
            } else {
                this.isJ.setIsGod(false);
            }
            this.isJ.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.isJ.setVisibility(8);
        }
        if (count >= 2) {
            this.isI.setVisibility(0);
            this.isI.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.isI.setIsGod(true);
            } else {
                this.isI.setIsGod(false);
            }
            this.isI.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.isI.setVisibility(8);
        }
        if (count >= 1) {
            this.isH.setVisibility(0);
            this.isH.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.isH.setIsGod(true);
            } else {
                this.isH.setIsGod(false);
            }
            this.isH.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.isH.setVisibility(8);
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
