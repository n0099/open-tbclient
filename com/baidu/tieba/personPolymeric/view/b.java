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
    private TextView kYS;
    private TextView kYT;
    private TextView kYU;
    private TextView kYV;
    private BarImageView kYW;
    private TextView kYX;
    private TextView kYY;
    private TextView kYZ;
    private com.baidu.tieba.personPolymeric.c.b kZa;
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
                        if (aVar.forumId == b.this.kZa.forumId) {
                            if (aVar.isSuccess) {
                                b.this.kZa.isAttention = true;
                                b.this.kYZ.setVisibility(0);
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
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.kZa.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.kZa.isAttention = false;
                            b.this.kYZ.setVisibility(0);
                            b.this.uc(b.this.kZa.isAttention);
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
        this.kYS = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.kYT = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.kYU = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.kYV = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.kYW = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.kYX = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.kYY = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.kYZ = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.kYZ.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.ePR);
        this.mTbPageContext.registerListener(this.ePQ);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ao.setViewTextColor(this.kYS, R.color.cp_cont_f, 1);
            ao.setViewTextColor(this.kYT, R.color.cp_cont_f, 1);
            ao.setViewTextColor(this.kYU, R.color.cp_cont_f, 1);
            ao.setViewTextColor(this.kYV, R.color.cp_cont_f, 1);
            ao.setViewTextColor(this.kYX, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.kYY, R.color.cp_cont_c, 1);
            if (this.kZa != null) {
                uc(this.kZa.isAttention);
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
        this.kZa = bVar;
        this.isHost = bVar.isHost;
        this.kYS.setVisibility(bVar.haX ? 0 : 4);
        this.kYT.setVisibility(bVar.haX ? 0 : 4);
        this.kYS.setText(bVar.haR);
        this.kYT.setText(bVar.haQ);
        TextView textView = this.kYU;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.kYW.startLoad(bVar.avatar, 10, false);
        String str = bVar.iSW;
        if (ae.getTextLength(str) > 10) {
            str = ae.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.kYX.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = as.numFormatOverWanNa(bVar.kWE);
        this.kYY.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, as.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.kYZ.setVisibility(8);
            return;
        }
        this.kYZ.setVisibility(0);
        uc(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ap("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.kZa.iSW, "")));
        } else if (this.kYZ == view) {
            TiebaStatic.log(new ap("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bf.skipToLoginActivity(this.mContext);
            } else if (as.isForumName(this.kZa.iSW) && !this.kZa.isAttention) {
                this.emT.fz(this.kZa.iSW, String.valueOf(this.kZa.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc(boolean z) {
        if (z) {
            this.kYZ.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ao.setViewTextColor(this.kYZ, R.color.cp_cont_e);
            ao.setBackgroundResource(this.kYZ, R.color.transparent);
            this.kYZ.setClickable(false);
            return;
        }
        this.kYZ.setText(this.mContext.getString(R.string.focus_text));
        ao.setViewTextColor(this.kYZ, R.color.cp_link_tip_a, 1);
        ao.setBackgroundResource(this.kYZ, R.drawable.polymeric_attention_btn_bg);
        this.kYZ.setClickable(true);
    }
}
