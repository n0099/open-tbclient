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
    public View ixs;
    public ClickableHeaderImageView mEA;
    public ClickableHeaderImageView mEB;
    public TextView mEC;
    public TextView mEv;
    public TextView mEw;
    public TextView mEx;
    public TextView mEy;
    public ClickableHeaderImageView mEz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.ixs = view.findViewById(R.id.bottom_divider);
        this.mEw = (TextView) view.findViewById(R.id.month_num);
        this.mEv = (TextView) view.findViewById(R.id.day_num);
        this.mEx = (TextView) view.findViewById(R.id.identity);
        this.mEy = (TextView) view.findViewById(R.id.attention_str);
        this.mEz = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.mEz.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mEz.setAutoChangeStyle(true);
        this.mEz.setOnClickListener(this.mOnClickListener);
        this.mEA = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.mEA.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mEA.setAutoChangeStyle(true);
        this.mEA.setOnClickListener(this.mOnClickListener);
        this.mEB = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.mEB.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mEB.setAutoChangeStyle(true);
        this.mEB.setOnClickListener(this.mOnClickListener);
        this.mEC = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setBackgroundColor(this.ixs, R.color.CAM_X0204);
            ap.setViewTextColor(this.mEw, R.color.CAM_X0106);
            ap.setViewTextColor(this.mEv, R.color.CAM_X0106);
            ap.setViewTextColor(this.mEx, R.color.CAM_X0106);
            ap.setViewTextColor(this.mEy, R.color.CAM_X0106);
            ap.setViewTextColor(this.mEC, R.color.CAM_X0108);
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
        this.mEv.setText(dVar.iBr);
        this.mEw.setText(dVar.iBq);
        this.mEv.setVisibility(dVar.iBx ? 0 : 4);
        this.mEw.setVisibility(dVar.iBx ? 0 : 4);
        if (dVar.isHost) {
            this.mEx.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.mEx.setText(au.getUserDescByGender(dVar.sex));
        }
        int count = y.getCount(dVar.users);
        if (count > 3) {
            this.mEC.setVisibility(0);
            this.mEC.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.mEC.setVisibility(8);
        }
        if (count >= 3) {
            this.mEB.setVisibility(0);
            this.mEB.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.mEB.setIsGod(true);
            } else {
                this.mEB.setIsGod(false);
            }
            this.mEB.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.mEB.setVisibility(8);
        }
        if (count >= 2) {
            this.mEA.setVisibility(0);
            this.mEA.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.mEA.setIsGod(true);
            } else {
                this.mEA.setIsGod(false);
            }
            this.mEA.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.mEA.setVisibility(8);
        }
        if (count >= 1) {
            this.mEz.setVisibility(0);
            this.mEz.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.mEz.setIsGod(true);
            } else {
                this.mEz.setIsGod(false);
            }
            this.mEz.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.mEz.setVisibility(8);
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
