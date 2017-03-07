package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ag;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.a> {
    private boolean bhu;
    private LikeModel brY;
    private CustomMessageListener bsf;
    private CustomMessageListener bsg;
    private TextView cnX;
    private ag eGm;
    private TextView eIn;
    private TextView eIo;
    private TextView eIp;
    private TextView eIq;
    private BarImageView eIr;
    private TextView eIs;
    private TextView eIt;
    private com.baidu.tieba.personPolymeric.c.a eIu;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bsg = new c(this, CmdConfigCustom.CMD_PERSON_LIKE_FORUM);
        this.bsf = new d(this, CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM);
        W(getView());
    }

    public void a(LikeModel likeModel) {
        this.brY = likeModel;
    }

    public void a(ag agVar) {
        this.eGm = agVar;
    }

    private void W(View view) {
        this.mRootView = view.findViewById(w.h.card_polymeric_attention_bar_rootview);
        this.eIn = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_day);
        this.eIo = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_month);
        this.eIp = (TextView) view.findViewById(w.h.card_polymeric_attention_sex);
        this.eIq = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_des);
        this.eIr = (BarImageView) view.findViewById(w.h.card_polymeric_attention_icon);
        this.eIs = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_name);
        this.eIt = (TextView) view.findViewById(w.h.card_polymeric_attention_post_num);
        this.cnX = (TextView) view.findViewById(w.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cnX.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bsg);
        this.mTbPageContext.registerListener(this.bsf);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.mRootView, w.g.item_person_header_attention_bg_selector);
            aq.c(this.eIn, w.e.cp_cont_f, 1);
            aq.c(this.eIo, w.e.cp_cont_f, 1);
            aq.c(this.eIp, w.e.cp_cont_f, 1);
            aq.c(this.eIq, w.e.cp_cont_f, 1);
            aq.c(this.eIs, w.e.cp_cont_b, 1);
            aq.c(this.eIt, w.e.cp_cont_c, 1);
            if (this.eIu != null) {
                jo(this.eIu.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_polymeric_attention_bar_view;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [134=5] */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eIu = aVar;
        this.bhu = aVar.bhu;
        this.eIn.setVisibility(aVar.bvW ? 0 : 4);
        this.eIo.setVisibility(aVar.bvW ? 0 : 4);
        this.eIn.setText(aVar.eHt);
        this.eIo.setText(aVar.bvP);
        this.eIp.setText(aVar.bhu ? this.mContext.getString(w.l.me) : aVar.sex == 2 ? this.mContext.getString(w.l.person_identity_she) : this.mContext.getString(w.l.he));
        this.eIr.c(aVar.avatar, 10, false);
        String str = aVar.eHu;
        if (com.baidu.tbadk.util.u.gk(str) > 10) {
            str = String.valueOf(com.baidu.tbadk.util.u.d(str, 0, 10)) + "...";
        }
        this.eIs.setText(String.format(this.mContext.getString(w.l.person_polymeric_bar_suffix), str));
        String x = au.x(aVar.eHv);
        this.eIt.setText(aVar.bhu ? String.format(this.mContext.getString(w.l.person_polymeric_attention_post_host), x, au.x(aVar.postNum)) : String.format(this.mContext.getString(w.l.person_polymeric_attention_post_guess), x));
        if (aVar.isAttention || aVar.bhu) {
            this.cnX.setVisibility(8);
            return;
        }
        this.cnX.setVisibility(0);
        jo(aVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.bhu) {
                TiebaStatic.log(new as("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.eIu.eHu, "")));
        } else if (this.cnX == view) {
            TiebaStatic.log(new as("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.aG(this.mContext);
            } else if (au.aG(this.eIu.eHu) && !this.eIu.isAttention) {
                this.brY.bY(this.eIu.eHu, String.valueOf(this.eIu.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jo(boolean z) {
        if (z) {
            this.cnX.setText(this.mContext.getString(w.l.relate_forum_is_followed));
            aq.i((View) this.cnX, w.e.cp_cont_e);
            aq.j(this.cnX, w.e.transparent);
            this.cnX.setClickable(false);
            return;
        }
        this.cnX.setText(this.mContext.getString(w.l.focus_text));
        aq.c(this.cnX, w.e.cp_link_tip_a, 1);
        aq.j(this.cnX, w.g.polymeric_attention_btn_bg);
        this.cnX.setClickable(true);
    }
}
