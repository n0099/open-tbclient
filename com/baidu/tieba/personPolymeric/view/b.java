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
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel dKs;
    private CustomMessageListener elp;
    private CustomMessageListener elq;
    private boolean isHost;
    private TextView kdc;
    private TextView kdd;
    private TextView kde;
    private TextView kdf;
    private BarImageView kdg;
    private TextView kdh;
    private TextView kdi;
    private TextView kdj;
    private com.baidu.tieba.personPolymeric.c.b kdk;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.elq = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.kdk.forumId) {
                            if (aVar.isSuccess) {
                                b.this.kdk.isAttention = true;
                                b.this.kdj.setVisibility(0);
                                b.this.sK(true);
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
        this.elp = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.kdk.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.kdk.isAttention = false;
                            b.this.kdj.setVisibility(0);
                            b.this.sK(b.this.kdk.isAttention);
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
        this.dKs = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.kdc = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.kdd = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.kde = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.kdf = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.kdg = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.kdh = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.kdi = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.kdj = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.kdj.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.elq);
        this.mTbPageContext.registerListener(this.elp);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            am.setViewTextColor(this.kdc, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kdd, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kde, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kdf, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kdh, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kdi, R.color.cp_cont_c, 1);
            if (this.kdk != null) {
                sK(this.kdk.isAttention);
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
        this.kdk = bVar;
        this.isHost = bVar.isHost;
        this.kdc.setVisibility(bVar.gtx ? 0 : 4);
        this.kdd.setVisibility(bVar.gtx ? 0 : 4);
        this.kdc.setText(bVar.gtr);
        this.kdd.setText(bVar.gtq);
        TextView textView = this.kde;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.kdg.startLoad(bVar.avatar, 10, false);
        String str = bVar.kaL;
        if (ad.getTextLength(str) > 10) {
            str = ad.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.kdh.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = aq.numFormatOverWanNa(bVar.kaM);
        this.kdi.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, aq.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.kdj.setVisibility(8);
            return;
        }
        this.kdj.setVisibility(0);
        sK(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.kdk.kaL, "")));
        } else if (this.kdj == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(this.mContext);
            } else if (aq.isForumName(this.kdk.kaL) && !this.kdk.isAttention) {
                this.dKs.eP(this.kdk.kaL, String.valueOf(this.kdk.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sK(boolean z) {
        if (z) {
            this.kdj.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            am.setViewTextColor(this.kdj, (int) R.color.cp_cont_e);
            am.setBackgroundResource(this.kdj, R.color.transparent);
            this.kdj.setClickable(false);
            return;
        }
        this.kdj.setText(this.mContext.getString(R.string.focus_text));
        am.setViewTextColor(this.kdj, R.color.cp_link_tip_a, 1);
        am.setBackgroundResource(this.kdj, R.drawable.polymeric_attention_btn_bg);
        this.kdj.setClickable(true);
    }
}
