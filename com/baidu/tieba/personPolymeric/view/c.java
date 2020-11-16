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
/* loaded from: classes23.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.d> {
    public View hZb;
    private boolean isHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mgB;
    public TextView mgC;
    public TextView mgD;
    public TextView mgE;
    public ClickableHeaderImageView mgF;
    public ClickableHeaderImageView mgG;
    public ClickableHeaderImageView mgH;
    public TextView mgI;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.hZb = view.findViewById(R.id.bottom_divider);
        this.mgC = (TextView) view.findViewById(R.id.month_num);
        this.mgB = (TextView) view.findViewById(R.id.day_num);
        this.mgD = (TextView) view.findViewById(R.id.identity);
        this.mgE = (TextView) view.findViewById(R.id.attention_str);
        this.mgF = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.mgF.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mgF.setAutoChangeStyle(true);
        this.mgF.setOnClickListener(this.mOnClickListener);
        this.mgG = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.mgG.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mgG.setAutoChangeStyle(true);
        this.mgG.setOnClickListener(this.mOnClickListener);
        this.mgH = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.mgH.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mgH.setAutoChangeStyle(true);
        this.mgH.setOnClickListener(this.mOnClickListener);
        this.mgI = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setBackgroundColor(this.hZb, R.color.CAM_X0204);
            ap.setViewTextColor(this.mgC, R.color.CAM_X0106);
            ap.setViewTextColor(this.mgB, R.color.CAM_X0106);
            ap.setViewTextColor(this.mgD, R.color.CAM_X0106);
            ap.setViewTextColor(this.mgE, R.color.CAM_X0106);
            ap.setViewTextColor(this.mgI, R.color.CAM_X0108);
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
        this.mgB.setText(dVar.icU);
        this.mgC.setText(dVar.icT);
        this.mgB.setVisibility(dVar.ida ? 0 : 4);
        this.mgC.setVisibility(dVar.ida ? 0 : 4);
        if (dVar.isHost) {
            this.mgD.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.mgD.setText(au.getUserDescByGender(dVar.sex));
        }
        int count = y.getCount(dVar.users);
        if (count > 3) {
            this.mgI.setVisibility(0);
            this.mgI.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.mgI.setVisibility(8);
        }
        if (count >= 3) {
            this.mgH.setVisibility(0);
            this.mgH.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.mgH.setIsGod(true);
            } else {
                this.mgH.setIsGod(false);
            }
            this.mgH.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.mgH.setVisibility(8);
        }
        if (count >= 2) {
            this.mgG.setVisibility(0);
            this.mgG.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.mgG.setIsGod(true);
            } else {
                this.mgG.setIsGod(false);
            }
            this.mgG.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.mgG.setVisibility(8);
        }
        if (count >= 1) {
            this.mgF.setVisibility(0);
            this.mgF.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.mgF.setIsGod(true);
            } else {
                this.mgF.setIsGod(false);
            }
            this.mgF.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.mgF.setVisibility(8);
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
