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
    private LikeModel eZA;
    private CustomMessageListener fDV;
    private CustomMessageListener fDW;
    private boolean isHost;
    private View mRootView;
    private TextView mfY;
    private TextView mfZ;
    private TextView mga;
    private TextView mgb;
    private BarImageView mgc;
    private TextView mgd;
    private TextView mge;
    private TextView mgf;
    private com.baidu.tieba.personPolymeric.c.b mgg;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fDW = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.mgg.forumId) {
                            if (aVar.isSuccess) {
                                b.this.mgg.isAttention = true;
                                b.this.mgf.setVisibility(0);
                                b.this.wf(true);
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
        this.fDV = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.mgg.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.mgg.isAttention = false;
                            b.this.mgf.setVisibility(0);
                            b.this.wf(b.this.mgg.isAttention);
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
        this.eZA = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.mfY = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.mfZ = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.mga = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.mgb = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.mgc = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.mgd = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.mge = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.mgf = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.mgf.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.fDW);
        this.mTbPageContext.registerListener(this.fDV);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ap.setViewTextColor(this.mfY, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.mfZ, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.mga, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.mgb, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.mgd, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mge, R.color.cp_cont_c, 1);
            if (this.mgg != null) {
                wf(this.mgg.isAttention);
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
        this.mgg = bVar;
        this.isHost = bVar.isHost;
        this.mfY.setVisibility(bVar.icl ? 0 : 4);
        this.mfZ.setVisibility(bVar.icl ? 0 : 4);
        this.mfY.setText(bVar.icf);
        this.mfZ.setText(bVar.ice);
        TextView textView = this.mga;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.mgc.startLoad(bVar.avatar, 10, false);
        String str = bVar.jxd;
        if (af.getTextLength(str) > 10) {
            str = af.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.mgd.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = at.numFormatOverWanNa(bVar.mdm);
        this.mge.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, at.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.mgf.setVisibility(8);
            return;
        }
        this.mgf.setVisibility(0);
        wf(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new aq("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.mgg.jxd, "")));
        } else if (this.mgf == view) {
            TiebaStatic.log(new aq("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(this.mContext);
            } else if (at.isForumName(this.mgg.jxd) && !this.mgg.isAttention) {
                this.eZA.gp(this.mgg.jxd, String.valueOf(this.mgg.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wf(boolean z) {
        if (z) {
            this.mgf.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ap.setViewTextColor(this.mgf, (int) R.color.cp_cont_e);
            ap.setBackgroundResource(this.mgf, R.color.transparent);
            this.mgf.setClickable(false);
            return;
        }
        this.mgf.setText(this.mContext.getString(R.string.focus_text));
        ap.setViewTextColor(this.mgf, R.color.cp_link_tip_a, 1);
        ap.setBackgroundResource(this.mgf, R.drawable.polymeric_attention_btn_bg);
        this.mgf.setClickable(true);
    }
}
