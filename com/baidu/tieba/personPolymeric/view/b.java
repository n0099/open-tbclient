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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes18.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener ePQ;
    private CustomMessageListener ePR;
    private LikeModel emT;
    private boolean isHost;
    private TextView kYU;
    private TextView kYV;
    private TextView kYW;
    private TextView kYX;
    private BarImageView kYY;
    private TextView kYZ;
    private TextView kZa;
    private TextView kZb;
    private com.baidu.tieba.personPolymeric.c.b kZc;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ePR = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.kZc.forumId) {
                            if (aVar.isSuccess) {
                                b.this.kZc.isAttention = true;
                                b.this.kZb.setVisibility(0);
                                b.this.uc(true);
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
        this.ePQ = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.kZc.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.kZc.isAttention = false;
                            b.this.kZb.setVisibility(0);
                            b.this.uc(b.this.kZc.isAttention);
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
        this.emT = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.kYU = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.kYV = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.kYW = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.kYX = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.kYY = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.kYZ = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.kZa = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.kZb = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.kZb.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.ePR);
        this.mTbPageContext.registerListener(this.ePQ);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ao.setViewTextColor(this.kYU, R.color.cp_cont_f, 1);
            ao.setViewTextColor(this.kYV, R.color.cp_cont_f, 1);
            ao.setViewTextColor(this.kYW, R.color.cp_cont_f, 1);
            ao.setViewTextColor(this.kYX, R.color.cp_cont_f, 1);
            ao.setViewTextColor(this.kYZ, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.kZa, R.color.cp_cont_c, 1);
            if (this.kZc != null) {
                uc(this.kZc.isAttention);
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
        this.kZc = bVar;
        this.isHost = bVar.isHost;
        this.kYU.setVisibility(bVar.haX ? 0 : 4);
        this.kYV.setVisibility(bVar.haX ? 0 : 4);
        this.kYU.setText(bVar.haR);
        this.kYV.setText(bVar.haQ);
        TextView textView = this.kYW;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.kYY.startLoad(bVar.avatar, 10, false);
        String str = bVar.iSY;
        if (ae.getTextLength(str) > 10) {
            str = ae.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.kYZ.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = as.numFormatOverWanNa(bVar.kWG);
        this.kZa.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, as.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.kZb.setVisibility(8);
            return;
        }
        this.kZb.setVisibility(0);
        uc(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ap("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.kZc.iSY, "")));
        } else if (this.kZb == view) {
            TiebaStatic.log(new ap("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bf.skipToLoginActivity(this.mContext);
            } else if (as.isForumName(this.kZc.iSY) && !this.kZc.isAttention) {
                this.emT.fz(this.kZc.iSY, String.valueOf(this.kZc.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc(boolean z) {
        if (z) {
            this.kZb.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ao.setViewTextColor(this.kZb, R.color.cp_cont_e);
            ao.setBackgroundResource(this.kZb, R.color.transparent);
            this.kZb.setClickable(false);
            return;
        }
        this.kZb.setText(this.mContext.getString(R.string.focus_text));
        ao.setViewTextColor(this.kZb, R.color.cp_link_tip_a, 1);
        ao.setBackgroundResource(this.kZb, R.drawable.polymeric_attention_btn_bg);
        this.kZb.setClickable(true);
    }
}
