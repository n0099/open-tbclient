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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes18.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel ewX;
    private CustomMessageListener faw;
    private CustomMessageListener fax;
    private boolean isHost;
    private TextView lpj;
    private TextView lpk;
    private TextView lpl;
    private TextView lpm;
    private BarImageView lpn;
    private TextView lpo;
    private TextView lpp;
    private TextView lpq;
    private com.baidu.tieba.personPolymeric.c.b lpr;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fax = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.lpr.forumId) {
                            if (aVar.isSuccess) {
                                b.this.lpr.isAttention = true;
                                b.this.lpq.setVisibility(0);
                                b.this.uO(true);
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, R.string.attention_success);
                            } else if (StringUtils.isNull(aVar.errorMessage)) {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, R.string.attention_fail);
                            } else {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, aVar.errorMessage);
                            }
                        }
                    }
                }
            }
        };
        this.faw = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.lpr.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.lpr.isAttention = false;
                            b.this.lpq.setVisibility(0);
                            b.this.uO(b.this.lpr.isAttention);
                            com.baidu.adp.lib.util.l.showToast(b.this.mContext, R.string.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.l.showToast(b.this.mContext, R.string.unlike_failure);
                    }
                }
            }
        };
        init(getView());
    }

    public void a(LikeModel likeModel) {
        this.ewX = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.lpj = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.lpk = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.lpl = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.lpm = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.lpn = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.lpo = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.lpp = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.lpq = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.lpq.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.fax);
        this.mTbPageContext.registerListener(this.faw);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ap.setViewTextColor(this.lpj, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lpk, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lpl, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lpm, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lpo, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.lpp, R.color.cp_cont_c, 1);
            if (this.lpr != null) {
                uO(this.lpr.isAttention);
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
        this.lpr = bVar;
        this.isHost = bVar.isHost;
        this.lpj.setVisibility(bVar.hnO ? 0 : 4);
        this.lpk.setVisibility(bVar.hnO ? 0 : 4);
        this.lpj.setText(bVar.hnI);
        this.lpk.setText(bVar.hnH);
        TextView textView = this.lpl;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.lpn.startLoad(bVar.avatar, 10, false);
        String str = bVar.jhV;
        if (ae.getTextLength(str) > 10) {
            str = ae.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.lpo.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = at.numFormatOverWanNa(bVar.lmx);
        this.lpp.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, at.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.lpq.setVisibility(8);
            return;
        }
        this.lpq.setVisibility(0);
        uO(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new aq("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.lpr.jhV, "")));
        } else if (this.lpq == view) {
            TiebaStatic.log(new aq("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(this.mContext);
            } else if (at.isForumName(this.lpr.jhV) && !this.lpr.isAttention) {
                this.ewX.fQ(this.lpr.jhV, String.valueOf(this.lpr.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uO(boolean z) {
        if (z) {
            this.lpq.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ap.setViewTextColor(this.lpq, R.color.cp_cont_e);
            ap.setBackgroundResource(this.lpq, R.color.transparent);
            this.lpq.setClickable(false);
            return;
        }
        this.lpq.setText(this.mContext.getString(R.string.focus_text));
        ap.setViewTextColor(this.lpq, R.color.cp_link_tip_a, 1);
        ap.setBackgroundResource(this.lpq, R.drawable.polymeric_attention_btn_bg);
        this.lpq.setClickable(true);
    }
}
