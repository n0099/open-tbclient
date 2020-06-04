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
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel dYI;
    private CustomMessageListener eAf;
    private CustomMessageListener eAg;
    private boolean isHost;
    private TextView kvZ;
    private TextView kwa;
    private TextView kwb;
    private TextView kwc;
    private BarImageView kwd;
    private TextView kwe;
    private TextView kwf;
    private TextView kwg;
    private com.baidu.tieba.personPolymeric.c.b kwh;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eAg = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.kwh.forumId) {
                            if (aVar.isSuccess) {
                                b.this.kwh.isAttention = true;
                                b.this.kwg.setVisibility(0);
                                b.this.ti(true);
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
        this.eAf = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.kwh.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.kwh.isAttention = false;
                            b.this.kwg.setVisibility(0);
                            b.this.ti(b.this.kwh.isAttention);
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
        this.dYI = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.kvZ = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.kwa = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.kwb = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.kwc = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.kwd = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.kwe = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.kwf = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.kwg = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.kwg.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.eAg);
        this.mTbPageContext.registerListener(this.eAf);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            am.setViewTextColor(this.kvZ, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kwa, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kwb, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kwc, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kwe, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kwf, R.color.cp_cont_c, 1);
            if (this.kwh != null) {
                ti(this.kwh.isAttention);
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
        this.kwh = bVar;
        this.isHost = bVar.isHost;
        this.kvZ.setVisibility(bVar.gIt ? 0 : 4);
        this.kwa.setVisibility(bVar.gIt ? 0 : 4);
        this.kvZ.setText(bVar.gIn);
        this.kwa.setText(bVar.gIm);
        TextView textView = this.kwb;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.kwd.startLoad(bVar.avatar, 10, false);
        String str = bVar.ktJ;
        if (ae.getTextLength(str) > 10) {
            str = ae.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.kwe.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = aq.numFormatOverWanNa(bVar.ktK);
        this.kwf.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, aq.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.kwg.setVisibility(8);
            return;
        }
        this.kwg.setVisibility(0);
        ti(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.kwh.ktJ, "")));
        } else if (this.kwg == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(this.mContext);
            } else if (aq.isForumName(this.kwh.ktJ) && !this.kwh.isAttention) {
                this.dYI.fq(this.kwh.ktJ, String.valueOf(this.kwh.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(boolean z) {
        if (z) {
            this.kwg.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            am.setViewTextColor(this.kwg, (int) R.color.cp_cont_e);
            am.setBackgroundResource(this.kwg, R.color.transparent);
            this.kwg.setClickable(false);
            return;
        }
        this.kwg.setText(this.mContext.getString(R.string.focus_text));
        am.setViewTextColor(this.kwg, R.color.cp_link_tip_a, 1);
        am.setBackgroundResource(this.kwg, R.drawable.polymeric_attention_btn_bg);
        this.kwg.setClickable(true);
    }
}
