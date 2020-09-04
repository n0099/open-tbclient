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
    private LikeModel exb;
    private CustomMessageListener faA;
    private CustomMessageListener faB;
    private boolean isHost;
    private TextView lpA;
    private TextView lpB;
    private com.baidu.tieba.personPolymeric.c.b lpC;
    private TextView lpu;
    private TextView lpv;
    private TextView lpw;
    private TextView lpx;
    private BarImageView lpy;
    private TextView lpz;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.faB = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.lpC.forumId) {
                            if (aVar.isSuccess) {
                                b.this.lpC.isAttention = true;
                                b.this.lpB.setVisibility(0);
                                b.this.uQ(true);
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
        this.faA = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.lpC.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.lpC.isAttention = false;
                            b.this.lpB.setVisibility(0);
                            b.this.uQ(b.this.lpC.isAttention);
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
        this.exb = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.lpu = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.lpv = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.lpw = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.lpx = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.lpy = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.lpz = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.lpA = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.lpB = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.lpB.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.faB);
        this.mTbPageContext.registerListener(this.faA);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ap.setViewTextColor(this.lpu, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lpv, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lpw, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lpx, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.lpz, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.lpA, R.color.cp_cont_c, 1);
            if (this.lpC != null) {
                uQ(this.lpC.isAttention);
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
        this.lpC = bVar;
        this.isHost = bVar.isHost;
        this.lpu.setVisibility(bVar.hnS ? 0 : 4);
        this.lpv.setVisibility(bVar.hnS ? 0 : 4);
        this.lpu.setText(bVar.hnM);
        this.lpv.setText(bVar.hnL);
        TextView textView = this.lpw;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.lpy.startLoad(bVar.avatar, 10, false);
        String str = bVar.jib;
        if (ae.getTextLength(str) > 10) {
            str = ae.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.lpz.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = at.numFormatOverWanNa(bVar.lmI);
        this.lpA.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, at.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.lpB.setVisibility(8);
            return;
        }
        this.lpB.setVisibility(0);
        uQ(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new aq("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.lpC.jib, "")));
        } else if (this.lpB == view) {
            TiebaStatic.log(new aq("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(this.mContext);
            } else if (at.isForumName(this.lpC.jib) && !this.lpC.isAttention) {
                this.exb.fR(this.lpC.jib, String.valueOf(this.lpC.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ(boolean z) {
        if (z) {
            this.lpB.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ap.setViewTextColor(this.lpB, (int) R.color.cp_cont_e);
            ap.setBackgroundResource(this.lpB, R.color.transparent);
            this.lpB.setClickable(false);
            return;
        }
        this.lpB.setText(this.mContext.getString(R.string.focus_text));
        ap.setViewTextColor(this.lpB, R.color.cp_link_tip_a, 1);
        ap.setBackgroundResource(this.lpB, R.drawable.polymeric_attention_btn_bg);
        this.lpB.setClickable(true);
    }
}
