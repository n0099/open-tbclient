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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.d> {
    private boolean isHost;
    public View ixG;
    public TextView mEK;
    public TextView mEL;
    public TextView mEM;
    public TextView mEN;
    public ClickableHeaderImageView mEO;
    public ClickableHeaderImageView mEP;
    public ClickableHeaderImageView mEQ;
    public TextView mER;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.ixG = view.findViewById(R.id.bottom_divider);
        this.mEL = (TextView) view.findViewById(R.id.month_num);
        this.mEK = (TextView) view.findViewById(R.id.day_num);
        this.mEM = (TextView) view.findViewById(R.id.identity);
        this.mEN = (TextView) view.findViewById(R.id.attention_str);
        this.mEO = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.mEO.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mEO.setAutoChangeStyle(true);
        this.mEO.setOnClickListener(this.mOnClickListener);
        this.mEP = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.mEP.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mEP.setAutoChangeStyle(true);
        this.mEP.setOnClickListener(this.mOnClickListener);
        this.mEQ = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.mEQ.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mEQ.setAutoChangeStyle(true);
        this.mEQ.setOnClickListener(this.mOnClickListener);
        this.mER = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setBackgroundColor(this.ixG, R.color.CAM_X0204);
            ap.setViewTextColor(this.mEL, R.color.CAM_X0106);
            ap.setViewTextColor(this.mEK, R.color.CAM_X0106);
            ap.setViewTextColor(this.mEM, R.color.CAM_X0106);
            ap.setViewTextColor(this.mEN, R.color.CAM_X0106);
            ap.setViewTextColor(this.mER, R.color.CAM_X0108);
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
        this.mEK.setText(dVar.iBF);
        this.mEL.setText(dVar.iBE);
        this.mEK.setVisibility(dVar.iBL ? 0 : 4);
        this.mEL.setVisibility(dVar.iBL ? 0 : 4);
        if (dVar.isHost) {
            this.mEM.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.mEM.setText(au.getUserDescByGender(dVar.sex));
        }
        int count = y.getCount(dVar.users);
        if (count > 3) {
            this.mER.setVisibility(0);
            this.mER.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.mER.setVisibility(8);
        }
        if (count >= 3) {
            this.mEQ.setVisibility(0);
            this.mEQ.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.mEQ.setIsGod(true);
            } else {
                this.mEQ.setIsGod(false);
            }
            this.mEQ.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.mEQ.setVisibility(8);
        }
        if (count >= 2) {
            this.mEP.setVisibility(0);
            this.mEP.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.mEP.setIsGod(true);
            } else {
                this.mEP.setIsGod(false);
            }
            this.mEP.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.mEP.setVisibility(8);
        }
        if (count >= 1) {
            this.mEO.setVisibility(0);
            this.mEO.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.mEO.setIsGod(true);
            } else {
                this.mEO.setIsGod(false);
            }
            this.mEO.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.mEO.setVisibility(8);
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
                        TiebaStatic.log(new ar("c11595"));
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
