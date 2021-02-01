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
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes8.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener fSw;
    private CustomMessageListener fSx;
    private LikeModel fnw;
    private boolean isHost;
    private TextView mEl;
    private TextView mEm;
    private TextView mEn;
    private TextView mEo;
    private BarImageView mEp;
    private TextView mEq;
    private TextView mEr;
    private TextView mEs;
    private com.baidu.tieba.personPolymeric.c.b mEt;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fSx = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.e) {
                        com.baidu.tieba.tbadkCore.writeModel.e eVar = (com.baidu.tieba.tbadkCore.writeModel.e) data;
                        if (eVar.forumId == b.this.mEt.forumId) {
                            if (eVar.isSuccess) {
                                b.this.mEt.isAttention = true;
                                b.this.mEs.setVisibility(0);
                                b.this.xa(true);
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, R.string.attention_success);
                            } else if (StringUtils.isNull(eVar.errorMessage)) {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, R.string.attention_fail);
                            } else {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, eVar.errorMessage);
                            }
                        }
                    }
                }
            }
        };
        this.fSw = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.e) && ((com.baidu.tieba.tbadkCore.writeModel.e) data).forumId == b.this.mEt.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.e) data).isSuccess) {
                            b.this.mEt.isAttention = false;
                            b.this.mEs.setVisibility(0);
                            b.this.xa(b.this.mEt.isAttention);
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
        this.fnw = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.mEl = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.mEm = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.mEn = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.mEo = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.mEp = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.mEq = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.mEr = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.mEs = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.mEs.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.fSx);
        this.mTbPageContext.registerListener(this.fSw);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ap.setViewTextColor(this.mEl, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mEm, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mEn, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mEo, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mEq, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.mEr, R.color.CAM_X0108, 1);
            if (this.mEt != null) {
                xa(this.mEt.isAttention);
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
        this.mEt = bVar;
        this.isHost = bVar.isHost;
        this.mEl.setVisibility(bVar.iBx ? 0 : 4);
        this.mEm.setVisibility(bVar.iBx ? 0 : 4);
        this.mEl.setText(bVar.iBr);
        this.mEm.setText(bVar.iBq);
        TextView textView = this.mEn;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.mEp.startLoad(bVar.avatar, 10, false);
        String str = bVar.kbI;
        if (ag.getTextLength(str) > 10) {
            str = ag.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.mEq.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = au.numFormatOverWanNa(bVar.mBv);
        this.mEr.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, au.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.mEs.setVisibility(8);
            return;
        }
        this.mEs.setVisibility(0);
        xa(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ar("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.mEt.kbI, "")));
        } else if (this.mEs == view) {
            TiebaStatic.log(new ar("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(this.mContext);
            } else if (au.isForumName(this.mEt.kbI) && !this.mEt.isAttention) {
                this.fnw.gw(this.mEt.kbI, String.valueOf(this.mEt.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa(boolean z) {
        if (z) {
            this.mEs.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ap.setViewTextColor(this.mEs, R.color.CAM_X0110);
            ap.setBackgroundResource(this.mEs, R.color.transparent);
            this.mEs.setClickable(false);
            return;
        }
        this.mEs.setText(this.mContext.getString(R.string.focus_text));
        ap.setViewTextColor(this.mEs, R.color.CAM_X0302, 1);
        ap.setBackgroundResource(this.mEs, R.drawable.polymeric_attention_btn_bg);
        this.mEs.setClickable(true);
    }
}
