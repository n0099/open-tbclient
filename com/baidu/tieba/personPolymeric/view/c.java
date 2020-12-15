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
    public View ika;
    private boolean isHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView muJ;
    public TextView muK;
    public TextView muL;
    public TextView muM;
    public ClickableHeaderImageView muN;
    public ClickableHeaderImageView muO;
    public ClickableHeaderImageView muP;
    public TextView muQ;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.ika = view.findViewById(R.id.bottom_divider);
        this.muK = (TextView) view.findViewById(R.id.month_num);
        this.muJ = (TextView) view.findViewById(R.id.day_num);
        this.muL = (TextView) view.findViewById(R.id.identity);
        this.muM = (TextView) view.findViewById(R.id.attention_str);
        this.muN = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.muN.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.muN.setAutoChangeStyle(true);
        this.muN.setOnClickListener(this.mOnClickListener);
        this.muO = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.muO.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.muO.setAutoChangeStyle(true);
        this.muO.setOnClickListener(this.mOnClickListener);
        this.muP = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.muP.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.muP.setAutoChangeStyle(true);
        this.muP.setOnClickListener(this.mOnClickListener);
        this.muQ = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setBackgroundColor(this.ika, R.color.CAM_X0204);
            ap.setViewTextColor(this.muK, (int) R.color.CAM_X0106);
            ap.setViewTextColor(this.muJ, (int) R.color.CAM_X0106);
            ap.setViewTextColor(this.muL, (int) R.color.CAM_X0106);
            ap.setViewTextColor(this.muM, (int) R.color.CAM_X0106);
            ap.setViewTextColor(this.muQ, (int) R.color.CAM_X0108);
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
        this.muJ.setText(dVar.inU);
        this.muK.setText(dVar.inT);
        this.muJ.setVisibility(dVar.ioa ? 0 : 4);
        this.muK.setVisibility(dVar.ioa ? 0 : 4);
        if (dVar.isHost) {
            this.muL.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.muL.setText(au.getUserDescByGender(dVar.sex));
        }
        int count = y.getCount(dVar.users);
        if (count > 3) {
            this.muQ.setVisibility(0);
            this.muQ.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.muQ.setVisibility(8);
        }
        if (count >= 3) {
            this.muP.setVisibility(0);
            this.muP.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.muP.setIsGod(true);
            } else {
                this.muP.setIsGod(false);
            }
            this.muP.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.muP.setVisibility(8);
        }
        if (count >= 2) {
            this.muO.setVisibility(0);
            this.muO.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.muO.setIsGod(true);
            } else {
                this.muO.setIsGod(false);
            }
            this.muO.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.muO.setVisibility(8);
        }
        if (count >= 1) {
            this.muN.setVisibility(0);
            this.muN.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.muN.setIsGod(true);
            } else {
                this.muN.setIsGod(false);
            }
            this.muN.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.muN.setVisibility(8);
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
