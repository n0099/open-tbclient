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
    public View fLf;
    private boolean isHost;
    public TextView jsS;
    public TextView jsT;
    public TextView jsU;
    public TextView jsV;
    public ClickableHeaderImageView jsW;
    public ClickableHeaderImageView jsX;
    public ClickableHeaderImageView jsY;
    public TextView jsZ;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.fLf = view.findViewById(R.id.bottom_divider);
        this.jsT = (TextView) view.findViewById(R.id.month_num);
        this.jsS = (TextView) view.findViewById(R.id.day_num);
        this.jsU = (TextView) view.findViewById(R.id.identity);
        this.jsV = (TextView) view.findViewById(R.id.attention_str);
        this.jsW = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.jsW.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jsW.setAutoChangeStyle(true);
        this.jsW.setOnClickListener(this.mOnClickListener);
        this.jsX = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.jsX.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jsX.setAutoChangeStyle(true);
        this.jsX.setOnClickListener(this.mOnClickListener);
        this.jsY = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.jsY.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.jsY.setAutoChangeStyle(true);
        this.jsY.setOnClickListener(this.mOnClickListener);
        this.jsZ = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setBackgroundColor(this.fLf, R.color.cp_bg_line_c);
            am.setViewTextColor(this.jsT, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jsS, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jsU, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jsV, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.jsZ, (int) R.color.cp_cont_c);
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
        this.jsS.setText(dVar.fOE);
        this.jsT.setText(dVar.fOD);
        this.jsS.setVisibility(dVar.fOK ? 0 : 4);
        this.jsT.setVisibility(dVar.fOK ? 0 : 4);
        if (dVar.isHost) {
            this.jsU.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.jsU.setText(aq.getUserDescByGender(dVar.sex));
        }
        int count = v.getCount(dVar.users);
        if (count > 3) {
            this.jsZ.setVisibility(0);
            this.jsZ.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.jsZ.setVisibility(8);
        }
        if (count >= 3) {
            this.jsY.setVisibility(0);
            this.jsY.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.jsY.setIsGod(true);
            } else {
                this.jsY.setIsGod(false);
            }
            this.jsY.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.jsY.setVisibility(8);
        }
        if (count >= 2) {
            this.jsX.setVisibility(0);
            this.jsX.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.jsX.setIsGod(true);
            } else {
                this.jsX.setIsGod(false);
            }
            this.jsX.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.jsX.setVisibility(8);
        }
        if (count >= 1) {
            this.jsW.setVisibility(0);
            this.jsW.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.jsW.setIsGod(true);
            } else {
                this.jsW.setIsGod(false);
            }
            this.jsW.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.jsW.setVisibility(8);
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
