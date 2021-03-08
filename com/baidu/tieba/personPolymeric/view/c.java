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
/* loaded from: classes7.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.d> {
    private boolean isHost;
    public View izp;
    public TextView mGN;
    public TextView mGO;
    public TextView mGP;
    public TextView mGQ;
    public ClickableHeaderImageView mGR;
    public ClickableHeaderImageView mGS;
    public ClickableHeaderImageView mGT;
    public TextView mGU;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.izp = view.findViewById(R.id.bottom_divider);
        this.mGO = (TextView) view.findViewById(R.id.month_num);
        this.mGN = (TextView) view.findViewById(R.id.day_num);
        this.mGP = (TextView) view.findViewById(R.id.identity);
        this.mGQ = (TextView) view.findViewById(R.id.attention_str);
        this.mGR = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.mGR.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mGR.setAutoChangeStyle(true);
        this.mGR.setOnClickListener(this.mOnClickListener);
        this.mGS = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.mGS.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mGS.setAutoChangeStyle(true);
        this.mGS.setOnClickListener(this.mOnClickListener);
        this.mGT = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.mGT.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mGT.setAutoChangeStyle(true);
        this.mGT.setOnClickListener(this.mOnClickListener);
        this.mGU = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setBackgroundColor(this.izp, R.color.CAM_X0204);
            ap.setViewTextColor(this.mGO, R.color.CAM_X0106);
            ap.setViewTextColor(this.mGN, R.color.CAM_X0106);
            ap.setViewTextColor(this.mGP, R.color.CAM_X0106);
            ap.setViewTextColor(this.mGQ, R.color.CAM_X0106);
            ap.setViewTextColor(this.mGU, R.color.CAM_X0108);
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
        this.mGN.setText(dVar.iDo);
        this.mGO.setText(dVar.iDn);
        this.mGN.setVisibility(dVar.iDu ? 0 : 4);
        this.mGO.setVisibility(dVar.iDu ? 0 : 4);
        if (dVar.isHost) {
            this.mGP.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.mGP.setText(au.getUserDescByGender(dVar.sex));
        }
        int count = y.getCount(dVar.users);
        if (count > 3) {
            this.mGU.setVisibility(0);
            this.mGU.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.mGU.setVisibility(8);
        }
        if (count >= 3) {
            this.mGT.setVisibility(0);
            this.mGT.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.mGT.setIsGod(true);
            } else {
                this.mGT.setIsGod(false);
            }
            this.mGT.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.mGT.setVisibility(8);
        }
        if (count >= 2) {
            this.mGS.setVisibility(0);
            this.mGS.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.mGS.setIsGod(true);
            } else {
                this.mGS.setIsGod(false);
            }
            this.mGS.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.mGS.setVisibility(8);
        }
        if (count >= 1) {
            this.mGR.setVisibility(0);
            this.mGR.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.mGR.setIsGod(true);
            } else {
                this.mGR.setIsGod(false);
            }
            this.mGR.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.mGR.setVisibility(8);
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
