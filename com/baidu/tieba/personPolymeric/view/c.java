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
    public View hkg;
    private boolean isHost;
    public TextView lpA;
    public TextView lpt;
    public TextView lpu;
    public TextView lpv;
    public TextView lpw;
    public ClickableHeaderImageView lpx;
    public ClickableHeaderImageView lpy;
    public ClickableHeaderImageView lpz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        View view = getView();
        initListener();
        this.hkg = view.findViewById(R.id.bottom_divider);
        this.lpu = (TextView) view.findViewById(R.id.month_num);
        this.lpt = (TextView) view.findViewById(R.id.day_num);
        this.lpv = (TextView) view.findViewById(R.id.identity);
        this.lpw = (TextView) view.findViewById(R.id.attention_str);
        this.lpx = (ClickableHeaderImageView) view.findViewById(R.id.header1);
        this.lpx.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.lpx.setAutoChangeStyle(true);
        this.lpx.setOnClickListener(this.mOnClickListener);
        this.lpy = (ClickableHeaderImageView) view.findViewById(R.id.header2);
        this.lpy.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.lpy.setAutoChangeStyle(true);
        this.lpy.setOnClickListener(this.mOnClickListener);
        this.lpz = (ClickableHeaderImageView) view.findViewById(R.id.header3);
        this.lpz.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds100));
        this.lpz.setAutoChangeStyle(true);
        this.lpz.setOnClickListener(this.mOnClickListener);
        this.lpA = (TextView) view.findViewById(R.id.etc_person);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setBackgroundColor(this.hkg, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.lpu, R.color.cp_cont_f);
            ap.setViewTextColor(this.lpt, R.color.cp_cont_f);
            ap.setViewTextColor(this.lpv, R.color.cp_cont_f);
            ap.setViewTextColor(this.lpw, R.color.cp_cont_f);
            ap.setViewTextColor(this.lpA, R.color.cp_cont_c);
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
        this.lpt.setText(dVar.hnI);
        this.lpu.setText(dVar.hnH);
        this.lpt.setVisibility(dVar.hnO ? 0 : 4);
        this.lpu.setVisibility(dVar.hnO ? 0 : 4);
        if (dVar.isHost) {
            this.lpv.setText(this.mPageContext.getString(R.string.me));
        } else {
            this.lpv.setText(at.getUserDescByGender(dVar.sex));
        }
        int count = y.getCount(dVar.users);
        if (count > 3) {
            this.lpA.setVisibility(0);
            this.lpA.setText(String.format(this.mPageContext.getString(R.string.attention_etc_person), Integer.valueOf(count)));
        } else {
            this.lpA.setVisibility(8);
        }
        if (count >= 3) {
            this.lpz.setVisibility(0);
            this.lpz.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.lpz.setIsGod(true);
            } else {
                this.lpz.setIsGod(false);
            }
            this.lpz.startLoad(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.lpz.setVisibility(8);
        }
        if (count >= 2) {
            this.lpy.setVisibility(0);
            this.lpy.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.lpy.setIsGod(true);
            } else {
                this.lpy.setIsGod(false);
            }
            this.lpy.startLoad(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.lpy.setVisibility(8);
        }
        if (count >= 1) {
            this.lpx.setVisibility(0);
            this.lpx.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.lpx.setIsGod(true);
            } else {
                this.lpx.setIsGod(false);
            }
            this.lpx.startLoad(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.lpx.setVisibility(8);
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
