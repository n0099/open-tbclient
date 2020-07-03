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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener eJu;
    private CustomMessageListener eJv;
    private LikeModel egK;
    private boolean isHost;
    private TextView kPW;
    private TextView kPX;
    private TextView kPY;
    private TextView kPZ;
    private BarImageView kQa;
    private TextView kQb;
    private TextView kQc;
    private TextView kQd;
    private com.baidu.tieba.personPolymeric.c.b kQe;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eJv = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.kQe.forumId) {
                            if (aVar.isSuccess) {
                                b.this.kQe.isAttention = true;
                                b.this.kQd.setVisibility(0);
                                b.this.tw(true);
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
        this.eJu = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.kQe.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.kQe.isAttention = false;
                            b.this.kQd.setVisibility(0);
                            b.this.tw(b.this.kQe.isAttention);
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
        this.egK = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.kPW = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.kPX = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.kPY = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.kPZ = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.kQa = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.kQb = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.kQc = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.kQd = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.kQd.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.eJv);
        this.mTbPageContext.registerListener(this.eJu);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            an.setViewTextColor(this.kPW, R.color.cp_cont_f, 1);
            an.setViewTextColor(this.kPX, R.color.cp_cont_f, 1);
            an.setViewTextColor(this.kPY, R.color.cp_cont_f, 1);
            an.setViewTextColor(this.kPZ, R.color.cp_cont_f, 1);
            an.setViewTextColor(this.kQb, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.kQc, R.color.cp_cont_c, 1);
            if (this.kQe != null) {
                tw(this.kQe.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_polymeric_attention_bar_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personPolymeric.c.b bVar) {
        String string;
        if (bVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.kQe = bVar;
        this.isHost = bVar.isHost;
        this.kPW.setVisibility(bVar.gVt ? 0 : 4);
        this.kPX.setVisibility(bVar.gVt ? 0 : 4);
        this.kPW.setText(bVar.gVn);
        this.kPX.setText(bVar.gVm);
        TextView textView = this.kPY;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.kQa.startLoad(bVar.avatar, 10, false);
        String str = bVar.kNG;
        if (ae.getTextLength(str) > 10) {
            str = ae.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.kQb.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = ar.numFormatOverWanNa(bVar.kNH);
        this.kQc.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, ar.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.kQd.setVisibility(8);
            return;
        }
        this.kQd.setVisibility(0);
        tw(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ao("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.kQe.kNG, "")));
        } else if (this.kQd == view) {
            TiebaStatic.log(new ao("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                be.skipToLoginActivity(this.mContext);
            } else if (ar.isForumName(this.kQe.kNG) && !this.kQe.isAttention) {
                this.egK.fx(this.kQe.kNG, String.valueOf(this.kQe.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw(boolean z) {
        if (z) {
            this.kQd.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            an.setViewTextColor(this.kQd, (int) R.color.cp_cont_e);
            an.setBackgroundResource(this.kQd, R.color.transparent);
            this.kQd.setClickable(false);
            return;
        }
        this.kQd.setText(this.mContext.getString(R.string.focus_text));
        an.setViewTextColor(this.kQd, R.color.cp_link_tip_a, 1);
        an.setBackgroundResource(this.kQd, R.drawable.polymeric_attention_btn_bg);
        this.kQd.setClickable(true);
    }
}
