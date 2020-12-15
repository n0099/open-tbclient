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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes24.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener fLk;
    private CustomMessageListener fLl;
    private LikeModel fgf;
    private boolean isHost;
    private View mRootView;
    private TextView muA;
    private TextView muB;
    private TextView muC;
    private BarImageView muD;
    private TextView muE;
    private TextView muF;
    private TextView muG;
    private com.baidu.tieba.personPolymeric.c.b muH;
    private TextView muz;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fLl = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.muH.forumId) {
                            if (aVar.isSuccess) {
                                b.this.muH.isAttention = true;
                                b.this.muG.setVisibility(0);
                                b.this.wM(true);
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
        this.fLk = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.muH.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.muH.isAttention = false;
                            b.this.muG.setVisibility(0);
                            b.this.wM(b.this.muH.isAttention);
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
        this.fgf = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.muz = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.muA = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.muB = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.muC = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.muD = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.muE = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.muF = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.muG = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.muG.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.fLl);
        this.mTbPageContext.registerListener(this.fLk);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ap.setViewTextColor(this.muz, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.muA, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.muB, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.muC, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.muE, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.muF, R.color.CAM_X0108, 1);
            if (this.muH != null) {
                wM(this.muH.isAttention);
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
        this.muH = bVar;
        this.isHost = bVar.isHost;
        this.muz.setVisibility(bVar.ioa ? 0 : 4);
        this.muA.setVisibility(bVar.ioa ? 0 : 4);
        this.muz.setText(bVar.inU);
        this.muA.setText(bVar.inT);
        TextView textView = this.muB;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.muD.startLoad(bVar.avatar, 10, false);
        String str = bVar.jLy;
        if (ae.getTextLength(str) > 10) {
            str = ae.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.muE.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = au.numFormatOverWanNa(bVar.mrM);
        this.muF.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, au.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.muG.setVisibility(8);
            return;
        }
        this.muG.setVisibility(0);
        wM(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ar("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.muH.jLy, "")));
        } else if (this.muG == view) {
            TiebaStatic.log(new ar("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(this.mContext);
            } else if (au.isForumName(this.muH.jLy) && !this.muH.isAttention) {
                this.fgf.gu(this.muH.jLy, String.valueOf(this.muH.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM(boolean z) {
        if (z) {
            this.muG.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ap.setViewTextColor(this.muG, (int) R.color.CAM_X0110);
            ap.setBackgroundResource(this.muG, R.color.transparent);
            this.muG.setClickable(false);
            return;
        }
        this.muG.setText(this.mContext.getString(R.string.focus_text));
        ap.setViewTextColor(this.muG, R.color.CAM_X0302, 1);
        ap.setBackgroundResource(this.muG, R.drawable.polymeric_attention_btn_bg);
        this.muG.setClickable(true);
    }
}
