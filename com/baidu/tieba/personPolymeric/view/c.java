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
/* loaded from: classes18.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.d> {
    public View hkk;
    private boolean isHost;
    public TextView lpE;
    public TextView lpF;
    public TextView lpG;
    public TextView lpH;
    public ClickableHeaderImageView lpI;
    public ClickableHeaderImageView lpJ;
    public ClickableHeaderImageView lpK;
    public TextView lpL;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.hkk = view.findViewById(R.id.bottom_divider);
        this.lpF = (TextView) view.findViewById(R.id.month_num);
        this.lpE = (TextView) view.findViewById(R.id.day_num);
        this.lpG = (TextView) view.findViewById(R.id.identity);
        this.lpH = (TextView) view.findViewById(R.id.attention_str);
        this.lpI = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.lpI.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.lpI.setAutoChangeStyle(true);
        this.lpI.setOnClickListener(this.mOnClickListener);
        this.lpJ = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.lpJ.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.lpJ.setAutoChangeStyle(true);
        this.lpJ.setOnClickListener(this.mOnClickListener);
        this.lpK = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.lpK.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.lpK.setAutoChangeStyle(true);
        this.lpK.setOnClickListener(this.mOnClickListener);
        this.lpL = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setBackgroundColor(this.hkk, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.lpF, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.lpE, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.lpG, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.lpH, (int) R.color.cp_cont_f);
            ap.setViewTextColor(this.lpL, (int) R.color.cp_cont_c);
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
        this.lpE.setText(dVar.hnM);
        this.lpF.setText(dVar.hnL);
        this.lpE.setVisibility(dVar.hnS ? 0 : 4);
        this.lpF.setVisibility(dVar.hnS ? 0 : 4);
        if (dVar.isHost) {
            this.lpG.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.lpG.setText(at.getUserDescByGender(dVar.sex));
        }
        int count = y.getCount(dVar.users);
        if (count > 3) {
            this.lpL.setVisibility(0);
            this.lpL.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.lpL.setVisibility(8);
        }
        if (count >= 3) {
            this.lpK.setVisibility(0);
            this.lpK.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.lpK.setIsGod(true);
            } else {
                this.lpK.setIsGod(false);
            }
            this.lpK.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.lpK.setVisibility(8);
        }
        if (count >= 2) {
            this.lpJ.setVisibility(0);
            this.lpJ.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.lpJ.setIsGod(true);
            } else {
                this.lpJ.setIsGod(false);
            }
            this.lpJ.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.lpJ.setVisibility(8);
        }
        if (count >= 1) {
            this.lpI.setVisibility(0);
            this.lpI.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.lpI.setIsGod(true);
            } else {
                this.lpI.setIsGod(false);
            }
            this.lpI.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.lpI.setVisibility(8);
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
