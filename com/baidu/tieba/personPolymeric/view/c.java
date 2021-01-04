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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.d> {
    private boolean isHost;
    public View iwv;
    public ClickableHeaderImageView mAa;
    public ClickableHeaderImageView mAb;
    public ClickableHeaderImageView mAc;
    public TextView mAd;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mzW;
    public TextView mzX;
    public TextView mzY;
    public TextView mzZ;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.iwv = view.findViewById(R.id.bottom_divider);
        this.mzX = (TextView) view.findViewById(R.id.month_num);
        this.mzW = (TextView) view.findViewById(R.id.day_num);
        this.mzY = (TextView) view.findViewById(R.id.identity);
        this.mzZ = (TextView) view.findViewById(R.id.attention_str);
        this.mAa = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.mAa.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mAa.setAutoChangeStyle(true);
        this.mAa.setOnClickListener(this.mOnClickListener);
        this.mAb = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.mAb.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mAb.setAutoChangeStyle(true);
        this.mAb.setOnClickListener(this.mOnClickListener);
        this.mAc = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.mAc.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mAc.setAutoChangeStyle(true);
        this.mAc.setOnClickListener(this.mOnClickListener);
        this.mAd = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ao.setBackgroundColor(this.iwv, R.color.CAM_X0204);
            ao.setViewTextColor(this.mzX, R.color.CAM_X0106);
            ao.setViewTextColor(this.mzW, R.color.CAM_X0106);
            ao.setViewTextColor(this.mzY, R.color.CAM_X0106);
            ao.setViewTextColor(this.mzZ, R.color.CAM_X0106);
            ao.setViewTextColor(this.mAd, R.color.CAM_X0108);
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
        this.mzW.setText(dVar.iAo);
        this.mzX.setText(dVar.iAn);
        this.mzW.setVisibility(dVar.iAu ? 0 : 4);
        this.mzX.setVisibility(dVar.iAu ? 0 : 4);
        if (dVar.isHost) {
            this.mzY.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.mzY.setText(at.getUserDescByGender(dVar.sex));
        }
        int count = x.getCount(dVar.users);
        if (count > 3) {
            this.mAd.setVisibility(0);
            this.mAd.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.mAd.setVisibility(8);
        }
        if (count >= 3) {
            this.mAc.setVisibility(0);
            this.mAc.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.mAc.setIsGod(true);
            } else {
                this.mAc.setIsGod(false);
            }
            this.mAc.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.mAc.setVisibility(8);
        }
        if (count >= 2) {
            this.mAb.setVisibility(0);
            this.mAb.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.mAb.setIsGod(true);
            } else {
                this.mAb.setIsGod(false);
            }
            this.mAb.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.mAb.setVisibility(8);
        }
        if (count >= 1) {
            this.mAa.setVisibility(0);
            this.mAa.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.mAa.setIsGod(true);
            } else {
                this.mAa.setIsGod(false);
            }
            this.mAa.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.mAa.setVisibility(8);
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
