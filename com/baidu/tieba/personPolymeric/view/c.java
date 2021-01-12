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
/* loaded from: classes7.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.d> {
    public View irO;
    private boolean isHost;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mvr;
    public TextView mvs;
    public TextView mvt;
    public TextView mvu;
    public ClickableHeaderImageView mvv;
    public ClickableHeaderImageView mvw;
    public ClickableHeaderImageView mvx;
    public TextView mvy;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.irO = view.findViewById(R.id.bottom_divider);
        this.mvs = (TextView) view.findViewById(R.id.month_num);
        this.mvr = (TextView) view.findViewById(R.id.day_num);
        this.mvt = (TextView) view.findViewById(R.id.identity);
        this.mvu = (TextView) view.findViewById(R.id.attention_str);
        this.mvv = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.mvv.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mvv.setAutoChangeStyle(true);
        this.mvv.setOnClickListener(this.mOnClickListener);
        this.mvw = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.mvw.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mvw.setAutoChangeStyle(true);
        this.mvw.setOnClickListener(this.mOnClickListener);
        this.mvx = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.mvx.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.mvx.setAutoChangeStyle(true);
        this.mvx.setOnClickListener(this.mOnClickListener);
        this.mvy = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ao.setBackgroundColor(this.irO, R.color.CAM_X0204);
            ao.setViewTextColor(this.mvs, R.color.CAM_X0106);
            ao.setViewTextColor(this.mvr, R.color.CAM_X0106);
            ao.setViewTextColor(this.mvt, R.color.CAM_X0106);
            ao.setViewTextColor(this.mvu, R.color.CAM_X0106);
            ao.setViewTextColor(this.mvy, R.color.CAM_X0108);
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
        this.mvr.setText(dVar.ivH);
        this.mvs.setText(dVar.ivG);
        this.mvr.setVisibility(dVar.ivN ? 0 : 4);
        this.mvs.setVisibility(dVar.ivN ? 0 : 4);
        if (dVar.isHost) {
            this.mvt.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.mvt.setText(at.getUserDescByGender(dVar.sex));
        }
        int count = x.getCount(dVar.users);
        if (count > 3) {
            this.mvy.setVisibility(0);
            this.mvy.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.mvy.setVisibility(8);
        }
        if (count >= 3) {
            this.mvx.setVisibility(0);
            this.mvx.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.mvx.setIsGod(true);
            } else {
                this.mvx.setIsGod(false);
            }
            this.mvx.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.mvx.setVisibility(8);
        }
        if (count >= 2) {
            this.mvw.setVisibility(0);
            this.mvw.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.mvw.setIsGod(true);
            } else {
                this.mvw.setIsGod(false);
            }
            this.mvw.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.mvw.setVisibility(8);
        }
        if (count >= 1) {
            this.mvv.setVisibility(0);
            this.mvv.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.mvv.setIsGod(true);
            } else {
                this.mvv.setIsGod(false);
            }
            this.mvv.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.mvv.setVisibility(8);
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
