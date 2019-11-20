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
    private CustomMessageListener cSl;
    private CustomMessageListener cSm;
    private LikeModel crO;
    private TextView gaU;
    private TextView isA;
    private com.baidu.tieba.personPolymeric.c.b isB;
    private boolean isHost;
    private TextView isu;
    private TextView isv;
    private TextView isw;
    private TextView isx;
    private BarImageView isy;
    private TextView isz;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cSm = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.isB.forumId) {
                            if (aVar.isSuccess) {
                                b.this.isB.isAttention = true;
                                b.this.gaU.setVisibility(0);
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
        this.cSl = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.isB.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.isB.isAttention = false;
                            b.this.gaU.setVisibility(0);
                            b.this.pD(b.this.isB.isAttention);
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
        this.crO = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.isu = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.isv = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.isw = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.isx = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.isy = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.isz = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.isA = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.gaU = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.gaU.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.cSm);
        this.mTbPageContext.registerListener(this.cSl);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            am.setViewTextColor(this.isu, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.isv, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.isw, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.isx, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.isz, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.isA, R.color.cp_cont_c, 1);
            if (this.isB != null) {
                pD(this.isB.isAttention);
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
        this.isB = bVar;
        this.isHost = bVar.isHost;
        this.isu.setVisibility(bVar.eQm ? 0 : 4);
        this.isv.setVisibility(bVar.eQm ? 0 : 4);
        this.isu.setText(bVar.eQg);
        this.isv.setText(bVar.eQf);
        TextView textView = this.isw;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.isy.startLoad(bVar.avatar, 10, false);
        String str = bVar.irC;
        if (aa.getTextLength(str) > 10) {
            str = aa.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.isz.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = aq.numFormatOverWanNa(bVar.irD);
        this.isA.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, aq.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.gaU.setVisibility(8);
            return;
        }
        this.gaU.setVisibility(0);
        pD(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.isB.irC, "")));
        } else if (this.gaU == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(this.mContext);
            } else if (aq.isForumName(this.isB.irC) && !this.isB.isAttention) {
                this.crO.dY(this.isB.irC, String.valueOf(this.isB.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pD(boolean z) {
        if (z) {
            this.gaU.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            am.setViewTextColor(this.gaU, (int) R.color.cp_cont_e);
            am.setBackgroundResource(this.gaU, R.color.transparent);
            this.gaU.setClickable(false);
            return;
        }
        this.gaU.setText(this.mContext.getString(R.string.focus_text));
        am.setViewTextColor(this.gaU, R.color.cp_link_tip_a, 1);
        am.setBackgroundResource(this.gaU, R.drawable.polymeric_attention_btn_bg);
        this.gaU.setClickable(true);
    }
}
