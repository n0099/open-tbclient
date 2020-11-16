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
/* loaded from: classes23.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel eYI;
    private CustomMessageListener fDy;
    private CustomMessageListener fDz;
    private boolean isHost;
    private View mRootView;
    private TextView mgr;
    private TextView mgs;
    private TextView mgt;
    private TextView mgu;
    private BarImageView mgv;
    private TextView mgw;
    private TextView mgx;
    private TextView mgy;
    private com.baidu.tieba.personPolymeric.c.b mgz;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fDz = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.mgz.forumId) {
                            if (aVar.isSuccess) {
                                b.this.mgz.isAttention = true;
                                b.this.mgy.setVisibility(0);
                                b.this.wi(true);
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
        this.fDy = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.mgz.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.mgz.isAttention = false;
                            b.this.mgy.setVisibility(0);
                            b.this.wi(b.this.mgz.isAttention);
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
        this.eYI = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.mgr = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.mgs = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.mgt = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.mgu = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.mgv = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.mgw = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.mgx = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.mgy = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.mgy.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.fDz);
        this.mTbPageContext.registerListener(this.fDy);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ap.setViewTextColor(this.mgr, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mgs, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mgt, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mgu, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mgw, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.mgx, R.color.CAM_X0108, 1);
            if (this.mgz != null) {
                wi(this.mgz.isAttention);
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
        this.mgz = bVar;
        this.isHost = bVar.isHost;
        this.mgr.setVisibility(bVar.ida ? 0 : 4);
        this.mgs.setVisibility(bVar.ida ? 0 : 4);
        this.mgr.setText(bVar.icU);
        this.mgs.setText(bVar.icT);
        TextView textView = this.mgt;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.mgv.startLoad(bVar.avatar, 10, false);
        String str = bVar.jxU;
        if (ae.getTextLength(str) > 10) {
            str = ae.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.mgw.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = au.numFormatOverWanNa(bVar.mdE);
        this.mgx.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, au.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.mgy.setVisibility(8);
            return;
        }
        this.mgy.setVisibility(0);
        wi(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ar("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.mgz.jxU, "")));
        } else if (this.mgy == view) {
            TiebaStatic.log(new ar("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(this.mContext);
            } else if (au.isForumName(this.mgz.jxU) && !this.mgz.isAttention) {
                this.eYI.gp(this.mgz.jxU, String.valueOf(this.mgz.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi(boolean z) {
        if (z) {
            this.mgy.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ap.setViewTextColor(this.mgy, R.color.CAM_X0110);
            ap.setBackgroundResource(this.mgy, R.color.transparent);
            this.mgy.setClickable(false);
            return;
        }
        this.mgy.setText(this.mContext.getString(R.string.focus_text));
        ap.setViewTextColor(this.mgy, R.color.CAM_X0302, 1);
        ap.setBackgroundResource(this.mgy, R.drawable.polymeric_attention_btn_bg);
        this.mgy.setClickable(true);
    }
}
