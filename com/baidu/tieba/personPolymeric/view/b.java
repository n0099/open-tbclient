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
    private LikeModel dKo;
    private CustomMessageListener elk;
    private CustomMessageListener ell;
    private boolean isHost;
    private TextView kcY;
    private TextView kcZ;
    private TextView kda;
    private TextView kdb;
    private BarImageView kdc;
    private TextView kdd;
    private TextView kde;
    private TextView kdf;
    private com.baidu.tieba.personPolymeric.c.b kdg;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ell = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.kdg.forumId) {
                            if (aVar.isSuccess) {
                                b.this.kdg.isAttention = true;
                                b.this.kdf.setVisibility(0);
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
        this.elk = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.kdg.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.kdg.isAttention = false;
                            b.this.kdf.setVisibility(0);
                            b.this.sK(b.this.kdg.isAttention);
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
        this.dKo = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.kcY = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.kcZ = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.kda = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.kdb = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.kdc = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.kdd = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.kde = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.kdf = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.kdf.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.ell);
        this.mTbPageContext.registerListener(this.elk);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            am.setViewTextColor(this.kcY, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kcZ, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kda, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kdb, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kdd, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kde, R.color.cp_cont_c, 1);
            if (this.kdg != null) {
                sK(this.kdg.isAttention);
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
        this.kdg = bVar;
        this.isHost = bVar.isHost;
        this.kcY.setVisibility(bVar.gtr ? 0 : 4);
        this.kcZ.setVisibility(bVar.gtr ? 0 : 4);
        this.kcY.setText(bVar.gtl);
        this.kcZ.setText(bVar.gtk);
        TextView textView = this.kda;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.kdc.startLoad(bVar.avatar, 10, false);
        String str = bVar.kaH;
        if (ad.getTextLength(str) > 10) {
            str = ad.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.kdd.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = aq.numFormatOverWanNa(bVar.kaI);
        this.kde.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, aq.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.kdf.setVisibility(8);
            return;
        }
        this.kdf.setVisibility(0);
        sK(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.kdg.kaH, "")));
        } else if (this.kdf == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(this.mContext);
            } else if (aq.isForumName(this.kdg.kaH) && !this.kdg.isAttention) {
                this.dKo.eP(this.kdg.kaH, String.valueOf(this.kdg.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sK(boolean z) {
        if (z) {
            this.kdf.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            am.setViewTextColor(this.kdf, (int) R.color.cp_cont_e);
            am.setBackgroundResource(this.kdf, R.color.transparent);
            this.kdf.setClickable(false);
            return;
        }
        this.kdf.setText(this.mContext.getString(R.string.focus_text));
        am.setViewTextColor(this.kdf, R.color.cp_link_tip_a, 1);
        am.setBackgroundResource(this.kdf, R.drawable.polymeric_attention_btn_bg);
        this.kdf.setClickable(true);
    }
}
