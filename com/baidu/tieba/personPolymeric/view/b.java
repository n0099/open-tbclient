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
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener dGK;
    private CustomMessageListener dGL;
    private LikeModel dfN;
    private boolean isHost;
    private TextView jqa;
    private TextView jqb;
    private TextView jqc;
    private TextView jqd;
    private BarImageView jqe;
    private TextView jqf;
    private TextView jqg;
    private TextView jqh;
    private com.baidu.tieba.personPolymeric.c.b jqi;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dGL = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.jqi.forumId) {
                            if (aVar.isSuccess) {
                                b.this.jqi.isAttention = true;
                                b.this.jqh.setVisibility(0);
                                b.this.rx(true);
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
        this.dGK = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.jqi.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.jqi.isAttention = false;
                            b.this.jqh.setVisibility(0);
                            b.this.rx(b.this.jqi.isAttention);
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
        this.dfN = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.jqa = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.jqb = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.jqc = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.jqd = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.jqe = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.jqf = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.jqg = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.jqh = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.jqh.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.dGL);
        this.mTbPageContext.registerListener(this.dGK);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            am.setViewTextColor(this.jqa, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jqb, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jqc, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jqd, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jqf, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jqg, R.color.cp_cont_c, 1);
            if (this.jqi != null) {
                rx(this.jqi.isAttention);
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
        this.jqi = bVar;
        this.isHost = bVar.isHost;
        this.jqa.setVisibility(bVar.fLr ? 0 : 4);
        this.jqb.setVisibility(bVar.fLr ? 0 : 4);
        this.jqa.setText(bVar.fLl);
        this.jqb.setText(bVar.fLk);
        TextView textView = this.jqc;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.jqe.startLoad(bVar.avatar, 10, false);
        String str = bVar.jnL;
        if (ad.getTextLength(str) > 10) {
            str = ad.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.jqf.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = aq.numFormatOverWanNa(bVar.jnM);
        this.jqg.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, aq.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.jqh.setVisibility(8);
            return;
        }
        this.jqh.setVisibility(0);
        rx(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.jqi.jnL, "")));
        } else if (this.jqh == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(this.mContext);
            } else if (aq.isForumName(this.jqi.jnL) && !this.jqi.isAttention) {
                this.dfN.et(this.jqi.jnL, String.valueOf(this.jqi.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rx(boolean z) {
        if (z) {
            this.jqh.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            am.setViewTextColor(this.jqh, (int) R.color.cp_cont_e);
            am.setBackgroundResource(this.jqh, R.color.transparent);
            this.jqh.setClickable(false);
            return;
        }
        this.jqh.setText(this.mContext.getString(R.string.focus_text));
        am.setViewTextColor(this.jqh, R.color.cp_link_tip_a, 1);
        am.setBackgroundResource(this.jqh, R.drawable.polymeric_attention_btn_bg);
        this.jqh.setClickable(true);
    }
}
