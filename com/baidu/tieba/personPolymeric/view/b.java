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
    private BarImageView muB;
    private TextView muC;
    private TextView muD;
    private TextView muE;
    private com.baidu.tieba.personPolymeric.c.b muF;
    private TextView mux;
    private TextView muy;
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
                        if (aVar.forumId == b.this.muF.forumId) {
                            if (aVar.isSuccess) {
                                b.this.muF.isAttention = true;
                                b.this.muE.setVisibility(0);
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
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.muF.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.muF.isAttention = false;
                            b.this.muE.setVisibility(0);
                            b.this.wM(b.this.muF.isAttention);
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
        this.mux = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.muy = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.muz = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.muA = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.muB = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.muC = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.muD = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.muE = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.muE.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.fLl);
        this.mTbPageContext.registerListener(this.fLk);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ap.setViewTextColor(this.mux, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.muy, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.muz, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.muA, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.muC, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.muD, R.color.CAM_X0108, 1);
            if (this.muF != null) {
                wM(this.muF.isAttention);
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
        this.muF = bVar;
        this.isHost = bVar.isHost;
        this.mux.setVisibility(bVar.inY ? 0 : 4);
        this.muy.setVisibility(bVar.inY ? 0 : 4);
        this.mux.setText(bVar.inS);
        this.muy.setText(bVar.inR);
        TextView textView = this.muz;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.muB.startLoad(bVar.avatar, 10, false);
        String str = bVar.jLw;
        if (ae.getTextLength(str) > 10) {
            str = ae.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.muC.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = au.numFormatOverWanNa(bVar.mrK);
        this.muD.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, au.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.muE.setVisibility(8);
            return;
        }
        this.muE.setVisibility(0);
        wM(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ar("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.muF.jLw, "")));
        } else if (this.muE == view) {
            TiebaStatic.log(new ar("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(this.mContext);
            } else if (au.isForumName(this.muF.jLw) && !this.muF.isAttention) {
                this.fgf.gu(this.muF.jLw, String.valueOf(this.muF.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM(boolean z) {
        if (z) {
            this.muE.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ap.setViewTextColor(this.muE, (int) R.color.CAM_X0110);
            ap.setBackgroundResource(this.muE, R.color.transparent);
            this.muE.setClickable(false);
            return;
        }
        this.muE.setText(this.mContext.getString(R.string.focus_text));
        ap.setViewTextColor(this.muE, R.color.CAM_X0302, 1);
        ap.setBackgroundResource(this.muE, R.drawable.polymeric_attention_btn_bg);
        this.muE.setClickable(true);
    }
}
