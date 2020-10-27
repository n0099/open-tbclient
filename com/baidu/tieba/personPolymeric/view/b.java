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
    private LikeModel eTL;
    private CustomMessageListener fyf;
    private CustomMessageListener fyg;
    private boolean isHost;
    private TextView lZY;
    private TextView lZZ;
    private View mRootView;
    private TextView maa;
    private TextView mab;
    private BarImageView mad;
    private TextView mae;
    private TextView maf;
    private TextView mag;
    private com.baidu.tieba.personPolymeric.c.b mah;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fyg = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.mah.forumId) {
                            if (aVar.isSuccess) {
                                b.this.mah.isAttention = true;
                                b.this.mag.setVisibility(0);
                                b.this.vW(true);
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
        this.fyf = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.mah.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.mah.isAttention = false;
                            b.this.mag.setVisibility(0);
                            b.this.vW(b.this.mah.isAttention);
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
        this.eTL = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.lZY = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.lZZ = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.maa = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.mab = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.mad = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.mae = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.maf = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.mag = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.mag.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.fyg);
        this.mTbPageContext.registerListener(this.fyf);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ap.setViewTextColor(this.lZY, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lZZ, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.maa, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.mab, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.mae, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.maf, R.color.cp_cont_c, 1);
            if (this.mah != null) {
                vW(this.mah.isAttention);
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
        this.mah = bVar;
        this.isHost = bVar.isHost;
        this.lZY.setVisibility(bVar.hWo ? 0 : 4);
        this.lZZ.setVisibility(bVar.hWo ? 0 : 4);
        this.lZY.setText(bVar.hWi);
        this.lZZ.setText(bVar.hWh);
        TextView textView = this.maa;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.mad.startLoad(bVar.avatar, 10, false);
        String str = bVar.jrg;
        if (af.getTextLength(str) > 10) {
            str = af.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.mae.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = at.numFormatOverWanNa(bVar.lXn);
        this.maf.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, at.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.mag.setVisibility(8);
            return;
        }
        this.mag.setVisibility(0);
        vW(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new aq("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.mah.jrg, "")));
        } else if (this.mag == view) {
            TiebaStatic.log(new aq("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(this.mContext);
            } else if (at.isForumName(this.mah.jrg) && !this.mah.isAttention) {
                this.eTL.gp(this.mah.jrg, String.valueOf(this.mah.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vW(boolean z) {
        if (z) {
            this.mag.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ap.setViewTextColor(this.mag, R.color.cp_cont_e);
            ap.setBackgroundResource(this.mag, R.color.transparent);
            this.mag.setClickable(false);
            return;
        }
        this.mag.setText(this.mContext.getString(R.string.focus_text));
        ap.setViewTextColor(this.mag, R.color.cp_link_tip_a, 1);
        ap.setBackgroundResource(this.mag, R.drawable.polymeric_attention_btn_bg);
        this.mag.setClickable(true);
    }
}
