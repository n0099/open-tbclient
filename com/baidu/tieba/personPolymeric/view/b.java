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
/* loaded from: classes8.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener dGB;
    private CustomMessageListener dGC;
    private LikeModel dfB;
    private boolean isHost;
    private TextView jmA;
    private com.baidu.tieba.personPolymeric.c.b jmB;
    private TextView jmt;
    private TextView jmu;
    private TextView jmv;
    private TextView jmw;
    private BarImageView jmx;
    private TextView jmy;
    private TextView jmz;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dGC = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.jmB.forumId) {
                            if (aVar.isSuccess) {
                                b.this.jmB.isAttention = true;
                                b.this.jmA.setVisibility(0);
                                b.this.rk(true);
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
        this.dGB = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.jmB.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.jmB.isAttention = false;
                            b.this.jmA.setVisibility(0);
                            b.this.rk(b.this.jmB.isAttention);
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
        this.dfB = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.jmt = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.jmu = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.jmv = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.jmw = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.jmx = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.jmy = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.jmz = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.jmA = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.jmA.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.dGC);
        this.mTbPageContext.registerListener(this.dGB);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            am.setViewTextColor(this.jmt, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jmu, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jmv, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jmw, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jmy, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jmz, R.color.cp_cont_c, 1);
            if (this.jmB != null) {
                rk(this.jmB.isAttention);
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
        this.jmB = bVar;
        this.isHost = bVar.isHost;
        this.jmt.setVisibility(bVar.fIh ? 0 : 4);
        this.jmu.setVisibility(bVar.fIh ? 0 : 4);
        this.jmt.setText(bVar.fIb);
        this.jmu.setText(bVar.fIa);
        TextView textView = this.jmv;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.jmx.startLoad(bVar.avatar, 10, false);
        String str = bVar.jke;
        if (ad.getTextLength(str) > 10) {
            str = ad.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.jmy.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = aq.numFormatOverWanNa(bVar.jkf);
        this.jmz.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, aq.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.jmA.setVisibility(8);
            return;
        }
        this.jmA.setVisibility(0);
        rk(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.jmB.jke, "")));
        } else if (this.jmA == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(this.mContext);
            } else if (aq.isForumName(this.jmB.jke) && !this.jmB.isAttention) {
                this.dfB.er(this.jmB.jke, String.valueOf(this.jmB.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(boolean z) {
        if (z) {
            this.jmA.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            am.setViewTextColor(this.jmA, (int) R.color.cp_cont_e);
            am.setBackgroundResource(this.jmA, R.color.transparent);
            this.jmA.setClickable(false);
            return;
        }
        this.jmA.setText(this.mContext.getString(R.string.focus_text));
        am.setViewTextColor(this.jmA, R.color.cp_link_tip_a, 1);
        am.setBackgroundResource(this.jmA, R.drawable.polymeric_attention_btn_bg);
        this.jmA.setClickable(true);
    }
}
