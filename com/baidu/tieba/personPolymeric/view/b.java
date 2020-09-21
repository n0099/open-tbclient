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
/* loaded from: classes23.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel ezi;
    private CustomMessageListener fdt;
    private CustomMessageListener fdu;
    private boolean isHost;
    private TextView lym;
    private TextView lyn;
    private TextView lyp;
    private TextView lyq;
    private BarImageView lyr;
    private TextView lys;
    private TextView lyt;
    private TextView lyu;
    private com.baidu.tieba.personPolymeric.c.b lyv;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fdu = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.lyv.forumId) {
                            if (aVar.isSuccess) {
                                b.this.lyv.isAttention = true;
                                b.this.lyu.setVisibility(0);
                                b.this.uY(true);
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
        this.fdt = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.lyv.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.lyv.isAttention = false;
                            b.this.lyu.setVisibility(0);
                            b.this.uY(b.this.lyv.isAttention);
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
        this.ezi = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.lym = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.lyn = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.lyp = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.lyq = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.lyr = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.lys = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.lyt = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.lyu = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.lyu.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.fdu);
        this.mTbPageContext.registerListener(this.fdt);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ap.setViewTextColor(this.lym, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lyn, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lyp, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lyq, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lys, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.lyt, R.color.cp_cont_c, 1);
            if (this.lyv != null) {
                uY(this.lyv.isAttention);
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
        this.lyv = bVar;
        this.isHost = bVar.isHost;
        this.lym.setVisibility(bVar.huW ? 0 : 4);
        this.lyn.setVisibility(bVar.huW ? 0 : 4);
        this.lym.setText(bVar.huQ);
        this.lyn.setText(bVar.huP);
        TextView textView = this.lyp;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.lyr.startLoad(bVar.avatar, 10, false);
        String str = bVar.iPO;
        if (af.getTextLength(str) > 10) {
            str = af.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.lys.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = at.numFormatOverWanNa(bVar.lvF);
        this.lyt.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, at.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.lyu.setVisibility(8);
            return;
        }
        this.lyu.setVisibility(0);
        uY(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new aq("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.lyv.iPO, "")));
        } else if (this.lyu == view) {
            TiebaStatic.log(new aq("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(this.mContext);
            } else if (at.isForumName(this.lyv.iPO) && !this.lyv.isAttention) {
                this.ezi.gd(this.lyv.iPO, String.valueOf(this.lyv.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uY(boolean z) {
        if (z) {
            this.lyu.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ap.setViewTextColor(this.lyu, (int) R.color.cp_cont_e);
            ap.setBackgroundResource(this.lyu, R.color.transparent);
            this.lyu.setClickable(false);
            return;
        }
        this.lyu.setText(this.mContext.getString(R.string.focus_text));
        ap.setViewTextColor(this.lyu, R.color.cp_link_tip_a, 1);
        ap.setBackgroundResource(this.lyu, R.drawable.polymeric_attention_btn_bg);
        this.lyu.setClickable(true);
    }
}
