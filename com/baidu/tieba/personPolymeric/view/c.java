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
    public View hGh;
    private boolean isHost;
    public TextView lNM;
    public TextView lNN;
    public TextView lNO;
    public TextView lNP;
    public ClickableHeaderImageView lNQ;
    public ClickableHeaderImageView lNR;
    public ClickableHeaderImageView lNS;
    public TextView lNT;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.hGh = view.findViewById(R.id.bottom_divider);
        this.lNN = (TextView) view.findViewById(R.id.month_num);
        this.lNM = (TextView) view.findViewById(R.id.day_num);
        this.lNO = (TextView) view.findViewById(R.id.identity);
        this.lNP = (TextView) view.findViewById(R.id.attention_str);
        this.lNQ = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.lNQ.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.lNQ.setAutoChangeStyle(true);
        this.lNQ.setOnClickListener(this.mOnClickListener);
        this.lNR = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.lNR.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.lNR.setAutoChangeStyle(true);
        this.lNR.setOnClickListener(this.mOnClickListener);
        this.lNS = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.lNS.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.lNS.setAutoChangeStyle(true);
        this.lNS.setOnClickListener(this.mOnClickListener);
        this.lNT = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setBackgroundColor(this.hGh, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.lNN, R.color.cp_cont_f);
            ap.setViewTextColor(this.lNM, R.color.cp_cont_f);
            ap.setViewTextColor(this.lNO, R.color.cp_cont_f);
            ap.setViewTextColor(this.lNP, R.color.cp_cont_f);
            ap.setViewTextColor(this.lNT, R.color.cp_cont_c);
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
        this.lNM.setText(dVar.hJL);
        this.lNN.setText(dVar.hJK);
        this.lNM.setVisibility(dVar.hJR ? 0 : 4);
        this.lNN.setVisibility(dVar.hJR ? 0 : 4);
        if (dVar.isHost) {
            this.lNO.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.lNO.setText(at.getUserDescByGender(dVar.sex));
        }
        int count = y.getCount(dVar.users);
        if (count > 3) {
            this.lNT.setVisibility(0);
            this.lNT.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.lNT.setVisibility(8);
        }
        if (count >= 3) {
            this.lNS.setVisibility(0);
            this.lNS.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.lNS.setIsGod(true);
            } else {
                this.lNS.setIsGod(false);
            }
            this.lNS.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.lNS.setVisibility(8);
        }
        if (count >= 2) {
            this.lNR.setVisibility(0);
            this.lNR.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.lNR.setIsGod(true);
            } else {
                this.lNR.setIsGod(false);
            }
            this.lNR.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.lNR.setVisibility(8);
        }
        if (count >= 1) {
            this.lNQ.setVisibility(0);
            this.lNQ.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.lNQ.setIsGod(true);
            } else {
                this.lNQ.setIsGod(false);
            }
            this.lNQ.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.lNQ.setVisibility(8);
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
