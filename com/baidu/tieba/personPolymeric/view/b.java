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
    private CustomMessageListener dKP;
    private CustomMessageListener dKQ;
    private LikeModel djT;
    private boolean isHost;
    private TextView jqV;
    private TextView jqW;
    private TextView jqX;
    private TextView jqY;
    private BarImageView jqZ;
    private TextView jra;
    private TextView jrb;
    private TextView jrc;
    private com.baidu.tieba.personPolymeric.c.b jrd;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dKQ = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.jrd.forumId) {
                            if (aVar.isSuccess) {
                                b.this.jrd.isAttention = true;
                                b.this.jrc.setVisibility(0);
                                b.this.rA(true);
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
        this.dKP = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.jrd.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.jrd.isAttention = false;
                            b.this.jrc.setVisibility(0);
                            b.this.rA(b.this.jrd.isAttention);
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
        this.djT = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.jqV = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.jqW = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.jqX = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.jqY = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.jqZ = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.jra = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.jrb = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.jrc = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.jrc.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.dKQ);
        this.mTbPageContext.registerListener(this.dKP);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            am.setViewTextColor(this.jqV, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jqW, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jqX, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jqY, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jra, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jrb, R.color.cp_cont_c, 1);
            if (this.jrd != null) {
                rA(this.jrd.isAttention);
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
        this.jrd = bVar;
        this.isHost = bVar.isHost;
        this.jqV.setVisibility(bVar.fNN ? 0 : 4);
        this.jqW.setVisibility(bVar.fNN ? 0 : 4);
        this.jqV.setText(bVar.fNH);
        this.jqW.setText(bVar.fNG);
        TextView textView = this.jqX;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.jqZ.startLoad(bVar.avatar, 10, false);
        String str = bVar.joF;
        if (ad.getTextLength(str) > 10) {
            str = ad.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.jra.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = aq.numFormatOverWanNa(bVar.joG);
        this.jrb.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, aq.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.jrc.setVisibility(8);
            return;
        }
        this.jrc.setVisibility(0);
        rA(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.jrd.joF, "")));
        } else if (this.jrc == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(this.mContext);
            } else if (aq.isForumName(this.jrd.joF) && !this.jrd.isAttention) {
                this.djT.eC(this.jrd.joF, String.valueOf(this.jrd.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA(boolean z) {
        if (z) {
            this.jrc.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            am.setViewTextColor(this.jrc, (int) R.color.cp_cont_e);
            am.setBackgroundResource(this.jrc, R.color.transparent);
            this.jrc.setClickable(false);
            return;
        }
        this.jrc.setText(this.mContext.getString(R.string.focus_text));
        am.setViewTextColor(this.jrc, R.color.cp_link_tip_a, 1);
        am.setBackgroundResource(this.jrc, R.drawable.polymeric_attention_btn_bg);
        this.jrc.setClickable(true);
    }
}
