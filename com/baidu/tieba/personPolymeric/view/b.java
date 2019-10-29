package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener cTc;
    private CustomMessageListener cTd;
    private LikeModel csF;
    private TextView gbL;
    private boolean isHost;
    private TextView itl;
    private TextView itm;
    private TextView itn;
    private TextView ito;
    private BarImageView itp;
    private TextView itq;
    private TextView itr;
    private com.baidu.tieba.personPolymeric.c.b its;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cTd = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.its.forumId) {
                            if (aVar.isSuccess) {
                                b.this.its.isAttention = true;
                                b.this.gbL.setVisibility(0);
                                b.this.pD(true);
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, (int) R.string.attention_success);
                            } else if (StringUtils.isNull(aVar.errorMessage)) {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, (int) R.string.attention_fail);
                            } else {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, aVar.errorMessage);
                            }
                        }
                    }
                }
            }
        };
        this.cTc = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.its.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.its.isAttention = false;
                            b.this.gbL.setVisibility(0);
                            b.this.pD(b.this.its.isAttention);
                            com.baidu.adp.lib.util.l.showToast(b.this.mContext, (int) R.string.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.l.showToast(b.this.mContext, (int) R.string.unlike_failure);
                    }
                }
            }
        };
        init(getView());
    }

    public void a(LikeModel likeModel) {
        this.csF = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.itl = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.itm = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.itn = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.ito = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.itp = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.itq = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.itr = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.gbL = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.gbL.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.cTd);
        this.mTbPageContext.registerListener(this.cTc);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            am.setViewTextColor(this.itl, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.itm, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.itn, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.ito, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.itq, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.itr, R.color.cp_cont_c, 1);
            if (this.its != null) {
                pD(this.its.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_polymeric_attention_bar_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.b bVar) {
        String string;
        if (bVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.its = bVar;
        this.isHost = bVar.isHost;
        this.itl.setVisibility(bVar.eRd ? 0 : 4);
        this.itm.setVisibility(bVar.eRd ? 0 : 4);
        this.itl.setText(bVar.eQX);
        this.itm.setText(bVar.eQW);
        TextView textView = this.itn;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.itp.startLoad(bVar.avatar, 10, false);
        String str = bVar.ist;
        if (aa.getTextLength(str) > 10) {
            str = aa.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.itq.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = aq.numFormatOverWanNa(bVar.isu);
        this.itr.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, aq.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.gbL.setVisibility(8);
            return;
        }
        this.gbL.setVisibility(0);
        pD(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.its.ist, "")));
        } else if (this.gbL == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(this.mContext);
            } else if (aq.isForumName(this.its.ist) && !this.its.isAttention) {
                this.csF.dY(this.its.ist, String.valueOf(this.its.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pD(boolean z) {
        if (z) {
            this.gbL.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            am.setViewTextColor(this.gbL, (int) R.color.cp_cont_e);
            am.setBackgroundResource(this.gbL, R.color.transparent);
            this.gbL.setClickable(false);
            return;
        }
        this.gbL.setText(this.mContext.getString(R.string.focus_text));
        am.setViewTextColor(this.gbL, R.color.cp_link_tip_a, 1);
        am.setBackgroundResource(this.gbL, R.drawable.polymeric_attention_btn_bg);
        this.gbL.setClickable(true);
    }
}
