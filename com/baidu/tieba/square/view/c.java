package com.baidu.tieba.square.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ac;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.square.data.b> {
    private TextView aJn;
    private TextView dVS;
    private LikeModel dYI;
    private BarImageView gOg;
    private TBSpecificationBtn gZu;
    private ac gZw;
    private TextView hQj;
    private TextView hQk;
    private boolean isLoading;
    private String ljh;
    private String lji;
    private com.baidu.tieba.square.data.b ljj;
    private View mRootView;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.ljh = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.lji = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.gOg = (BarImageView) view.findViewById(R.id.bar_image);
        this.dVS = (TextView) view.findViewById(R.id.bar_name);
        this.aJn = (TextView) view.findViewById(R.id.desc);
        this.hQj = (TextView) view.findViewById(R.id.member_text);
        this.hQk = (TextView) view.findViewById(R.id.post_text);
        this.gZu = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.ljj = bVar;
            this.gOg.setShowOval(true);
            this.gOg.setShowOuterBorder(false);
            this.gOg.setShowInnerBorder(true);
            this.gOg.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.gOg.setStrokeColorResId(R.color.cp_border_a);
            this.gOg.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            this.dVS.setText(forumName);
            this.hQj.setText(this.ljh + " " + aq.numberUniformFormatExtra(bVar.getMemberCount()));
            this.hQk.setText(this.lji + " " + aq.numberUniformFormatExtra(bVar.dbW()));
            Mn(bVar.aOj());
            mo(this.ljj.isLike());
            this.mRootView.setOnClickListener(this);
            this.gZu.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Mn(String str) {
        if (aq.isEmpty(str)) {
            if (this.aJn.getVisibility() != 8) {
                this.aJn.setVisibility(8);
                if (this.dVS.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.dVS.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.dVS.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.aJn.getVisibility() != 0) {
            this.aJn.setVisibility(0);
            if (this.dVS.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dVS.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.dVS.requestLayout();
            }
        }
        this.aJn.setText(str);
    }

    public void mo(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mk(R.color.cp_link_tip_a);
            this.gZu.setConfig(cVar);
            this.gZu.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mm(R.color.cp_cont_d);
            this.gZu.setConfig(cVar2);
            this.gZu.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.ljj.setLike(z);
    }

    private void bQQ() {
        if (this.ljj != null) {
            String forumName = this.ljj.getForumName();
            if (aq.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void bQR() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.ljj != null && !StringUtils.isNull(this.ljj.getForumName()) && this.ljj.getForumId() > 0 && bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.dYI == null) {
                    this.dYI = new LikeModel(this.mTbPageContext);
                    this.dYI.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.dYI.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.dYI.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.dYI.getErrorString());
                                } else {
                                    c.this.mo(true);
                                }
                            }
                        }
                    });
                }
                if (aq.isForumName(this.ljj.getForumName())) {
                    this.isLoading = true;
                    this.dYI.ddc();
                    this.dYI.fq(this.ljj.getForumName(), String.valueOf(this.ljj.getForumId()));
                }
            }
        }
    }

    private void bQS() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.ljj != null && !StringUtils.isNull(this.ljj.getForumName()) && this.ljj.getForumId() > 0 && bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.gZw == null) {
                    this.gZw = new ac();
                    this.gZw.a(new ac.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void z(String str, long j) {
                            c.this.isLoading = false;
                            c.this.mo(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void A(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.gZw.K(this.ljj.getForumName(), this.ljj.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.dVS, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hQj, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hQk, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.aJn, (int) R.color.cp_cont_d);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an anVar;
        if (this.ljj != null) {
            if (this.mRootView == view) {
                bQQ();
                if (this.gBT != null) {
                    this.gBT.a(view, this.ljj);
                }
            } else if (this.gZu == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).getClassName();
                    if (!"推荐".equals(className)) {
                        anVar = new an("c13653");
                        anVar.dh("resource_id", className);
                    } else {
                        anVar = new an("c13644");
                        anVar.ag("obj_locate", 3);
                    }
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.s("fid", this.ljj.forumId);
                    anVar.ag(TiebaInitialize.Params.OBJ_TO, this.ljj.isLike() ? 2 : 1);
                    TiebaStatic.log(anVar);
                }
                if (this.ljj.isLike()) {
                    bQS();
                } else {
                    bQR();
                }
            }
        }
    }
}
