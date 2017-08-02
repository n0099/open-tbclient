package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.d> {
    private TbPageContext<?> ako;
    public View bottomLine;
    private boolean bsZ;
    public TextView fjM;
    public TextView fjN;
    public TextView fjO;
    public TextView fjP;
    public ClickableHeaderImageView fjQ;
    public ClickableHeaderImageView fjR;
    public ClickableHeaderImageView fjS;
    public TextView fjT;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ako = tbPageContext;
        View view = getView();
        initListener();
        this.bottomLine = view.findViewById(d.h.bottom_divider);
        this.fjN = (TextView) view.findViewById(d.h.month_num);
        this.fjM = (TextView) view.findViewById(d.h.day_num);
        this.fjO = (TextView) view.findViewById(d.h.identity);
        this.fjP = (TextView) view.findViewById(d.h.attention_str);
        this.fjQ = (ClickableHeaderImageView) view.findViewById(d.h.header1);
        this.fjQ.setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds100));
        this.fjQ.setAutoChangeStyle(true);
        this.fjQ.setOnClickListener(this.mOnClickListener);
        this.fjR = (ClickableHeaderImageView) view.findViewById(d.h.header2);
        this.fjR.setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds100));
        this.fjR.setAutoChangeStyle(true);
        this.fjR.setOnClickListener(this.mOnClickListener);
        this.fjS = (ClickableHeaderImageView) view.findViewById(d.h.header3);
        this.fjS.setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds100));
        this.fjS.setAutoChangeStyle(true);
        this.fjS.setOnClickListener(this.mOnClickListener);
        this.fjT = (TextView) view.findViewById(d.h.etc_person);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.k(this.bottomLine, d.e.cp_bg_line_c);
            ai.i(this.fjN, d.e.cp_cont_f);
            ai.i(this.fjM, d.e.cp_cont_f);
            ai.i(this.fjO, d.e.cp_cont_f);
            ai.i(this.fjP, d.e.cp_cont_f);
            ai.i(this.fjT, d.e.cp_cont_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.person_info_attention_card;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
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
        this.bsZ = dVar.bsZ;
        this.fjM.setText(dVar.fiX);
        this.fjN.setText(dVar.bIY);
        this.fjM.setVisibility(dVar.bJf ? 0 : 4);
        this.fjN.setVisibility(dVar.bJf ? 0 : 4);
        if (dVar.bsZ) {
            this.fjO.setText(this.ako.getString(d.l.me));
        } else {
            this.fjO.setText(al.cW(dVar.sex));
        }
        int u = u.u(dVar.users);
        if (u > 3) {
            this.fjT.setVisibility(0);
            this.fjT.setText(String.format(this.ako.getString(d.l.attention_etc_person), Integer.valueOf(u)));
        } else {
            this.fjT.setVisibility(8);
        }
        if (u >= 3) {
            this.fjS.setVisibility(0);
            this.fjS.setTag(dVar.users.get(2));
            if (dVar.users.get(2).getGodUserData() != null && dVar.users.get(2).getGodUserData().getType() == 2) {
                this.fjS.setIsGod(true);
            } else {
                this.fjS.setIsGod(false);
            }
            this.fjS.c(dVar.users.get(2).getPortrait(), 12, false);
        } else {
            this.fjS.setVisibility(8);
        }
        if (u >= 2) {
            this.fjR.setVisibility(0);
            this.fjR.setTag(dVar.users.get(1));
            if (dVar.users.get(1).getGodUserData() != null && dVar.users.get(1).getGodUserData().getType() == 2) {
                this.fjR.setIsGod(true);
            } else {
                this.fjR.setIsGod(false);
            }
            this.fjR.c(dVar.users.get(1).getPortrait(), 12, false);
        } else {
            this.fjR.setVisibility(8);
        }
        if (u >= 1) {
            this.fjQ.setVisibility(0);
            this.fjQ.setTag(dVar.users.get(0));
            if (dVar.users.get(0).getGodUserData() != null && dVar.users.get(0).getGodUserData().getType() == 2) {
                this.fjQ.setIsGod(true);
            } else {
                this.fjQ.setIsGod(false);
            }
            this.fjQ.c(dVar.users.get(0).getPortrait(), 12, false);
        } else {
            this.fjQ.setVisibility(8);
        }
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (!c.this.bsZ) {
                        TiebaStatic.log(new aj("c11595"));
                    }
                    if (view.getTag() instanceof UserData) {
                        UserData userData = (UserData) view.getTag();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.ako.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
    }
}
