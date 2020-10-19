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
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes24.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel eLp;
    private CustomMessageListener fpG;
    private CustomMessageListener fpH;
    private boolean isHost;
    private TextView lNC;
    private TextView lND;
    private TextView lNE;
    private TextView lNF;
    private BarImageView lNG;
    private TextView lNH;
    private TextView lNI;
    private TextView lNJ;
    private com.baidu.tieba.personPolymeric.c.b lNK;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fpH = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.lNK.forumId) {
                            if (aVar.isSuccess) {
                                b.this.lNK.isAttention = true;
                                b.this.lNJ.setVisibility(0);
                                b.this.vF(true);
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
        this.fpG = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.lNK.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.lNK.isAttention = false;
                            b.this.lNJ.setVisibility(0);
                            b.this.vF(b.this.lNK.isAttention);
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
        this.eLp = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.lNC = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.lND = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.lNE = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.lNF = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.lNG = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.lNH = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.lNI = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.lNJ = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.lNJ.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.fpH);
        this.mTbPageContext.registerListener(this.fpG);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ap.setViewTextColor(this.lNC, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lND, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lNE, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lNF, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lNH, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.lNI, R.color.cp_cont_c, 1);
            if (this.lNK != null) {
                vF(this.lNK.isAttention);
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
        this.lNK = bVar;
        this.isHost = bVar.isHost;
        this.lNC.setVisibility(bVar.hJR ? 0 : 4);
        this.lND.setVisibility(bVar.hJR ? 0 : 4);
        this.lNC.setText(bVar.hJL);
        this.lND.setText(bVar.hJK);
        TextView textView = this.lNE;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.lNG.startLoad(bVar.avatar, 10, false);
        String str = bVar.jeI;
        if (af.getTextLength(str) > 10) {
            str = af.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.lNH.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = at.numFormatOverWanNa(bVar.lKR);
        this.lNI.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, at.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.lNJ.setVisibility(8);
            return;
        }
        this.lNJ.setVisibility(0);
        vF(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new aq("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.lNK.jeI, "")));
        } else if (this.lNJ == view) {
            TiebaStatic.log(new aq("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(this.mContext);
            } else if (at.isForumName(this.lNK.jeI) && !this.lNK.isAttention) {
                this.eLp.gk(this.lNK.jeI, String.valueOf(this.lNK.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF(boolean z) {
        if (z) {
            this.lNJ.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ap.setViewTextColor(this.lNJ, R.color.cp_cont_e);
            ap.setBackgroundResource(this.lNJ, R.color.transparent);
            this.lNJ.setClickable(false);
            return;
        }
        this.lNJ.setText(this.mContext.getString(R.string.focus_text));
        ap.setViewTextColor(this.lNJ, R.color.cp_link_tip_a, 1);
        ap.setBackgroundResource(this.lNJ, R.drawable.polymeric_attention_btn_bg);
        this.lNJ.setClickable(true);
    }
}
