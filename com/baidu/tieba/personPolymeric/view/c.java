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
/* loaded from: classes24.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.d> {
    public View ijY;
    private boolean isHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView muH;
    public TextView muI;
    public TextView muJ;
    public TextView muK;
    public ClickableHeaderImageView muL;
    public ClickableHeaderImageView muM;
    public ClickableHeaderImageView muN;
    public TextView muO;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.ijY = view.findViewById(R.id.bottom_divider);
        this.muI = (TextView) view.findViewById(R.id.month_num);
        this.muH = (TextView) view.findViewById(R.id.day_num);
        this.muJ = (TextView) view.findViewById(R.id.identity);
        this.muK = (TextView) view.findViewById(R.id.attention_str);
        this.muL = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.muL.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.muL.setAutoChangeStyle(true);
        this.muL.setOnClickListener(this.mOnClickListener);
        this.muM = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.muM.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.muM.setAutoChangeStyle(true);
        this.muM.setOnClickListener(this.mOnClickListener);
        this.muN = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.muN.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.muN.setAutoChangeStyle(true);
        this.muN.setOnClickListener(this.mOnClickListener);
        this.muO = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setBackgroundColor(this.ijY, R.color.CAM_X0204);
            ap.setViewTextColor(this.muI, R.color.CAM_X0106);
            ap.setViewTextColor(this.muH, R.color.CAM_X0106);
            ap.setViewTextColor(this.muJ, R.color.CAM_X0106);
            ap.setViewTextColor(this.muK, R.color.CAM_X0106);
            ap.setViewTextColor(this.muO, R.color.CAM_X0108);
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
        this.muH.setText(dVar.inS);
        this.muI.setText(dVar.inR);
        this.muH.setVisibility(dVar.inY ? 0 : 4);
        this.muI.setVisibility(dVar.inY ? 0 : 4);
        if (dVar.isHost) {
            this.muJ.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.muJ.setText(au.getUserDescByGender(dVar.sex));
        }
        int count = y.getCount(dVar.users);
        if (count > 3) {
            this.muO.setVisibility(0);
            this.muO.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.muO.setVisibility(8);
        }
        if (count >= 3) {
            this.muN.setVisibility(0);
            this.muN.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.muN.setIsGod(true);
            } else {
                this.muN.setIsGod(false);
            }
            this.muN.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.muN.setVisibility(8);
        }
        if (count >= 2) {
            this.muM.setVisibility(0);
            this.muM.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.muM.setIsGod(true);
            } else {
                this.muM.setIsGod(false);
            }
            this.muM.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.muM.setVisibility(8);
        }
        if (count >= 1) {
            this.muL.setVisibility(0);
            this.muL.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.muL.setIsGod(true);
            } else {
                this.muL.setIsGod(false);
            }
            this.muL.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.muL.setVisibility(8);
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
