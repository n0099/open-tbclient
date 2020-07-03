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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ac;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.square.data.b> {
    private BarImageView agX;
    private TextView agZ;
    private TextView aha;
    private LikeModel egK;
    private TBSpecificationBtn hlG;
    private ac hlI;
    private TextView idE;
    private TextView idF;
    private boolean isLoading;
    private String lDc;
    private String lDd;
    private com.baidu.tieba.square.data.b lDe;
    private View mRootView;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.lDc = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.lDd = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.agX = (BarImageView) view.findViewById(R.id.bar_image);
        this.agZ = (TextView) view.findViewById(R.id.bar_name);
        this.aha = (TextView) view.findViewById(R.id.desc);
        this.idE = (TextView) view.findViewById(R.id.member_text);
        this.idF = (TextView) view.findViewById(R.id.post_text);
        this.hlG = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.lDe = bVar;
            this.agX.setShowOval(true);
            this.agX.setShowOuterBorder(false);
            this.agX.setShowInnerBorder(true);
            this.agX.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.agX.setStrokeColorResId(R.color.cp_border_a);
            this.agX.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (ar.isEmpty(forumName)) {
                forumName = "";
            }
            this.agZ.setText(forumName);
            this.idE.setText(this.lDc + " " + ar.numberUniformFormatExtra(bVar.getMemberCount()));
            this.idF.setText(this.lDd + " " + ar.numberUniformFormatExtra(bVar.dgl()));
            MP(bVar.aPT());
            mz(this.lDe.isLike());
            this.mRootView.setOnClickListener(this);
            this.hlG.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void MP(String str) {
        if (ar.isEmpty(str)) {
            if (this.aha.getVisibility() != 8) {
                this.aha.setVisibility(8);
                if (this.agZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.agZ.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.agZ.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.aha.getVisibility() != 0) {
            this.aha.setVisibility(0);
            if (this.agZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.agZ.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.agZ.requestLayout();
            }
        }
        this.aha.setText(str);
    }

    public void mz(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mC(R.color.cp_link_tip_a);
            this.hlG.setConfig(cVar);
            this.hlG.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mE(R.color.cp_cont_d);
            this.hlG.setConfig(cVar2);
            this.hlG.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.lDe.setLike(z);
    }

    private void bTM() {
        if (this.lDe != null) {
            String forumName = this.lDe.getForumName();
            if (ar.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void bTN() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.lDe != null && !StringUtils.isNull(this.lDe.getForumName()) && this.lDe.getForumId() > 0 && be.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.egK == null) {
                    this.egK = new LikeModel(this.mTbPageContext);
                    this.egK.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.egK.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.egK.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.egK.getErrorString());
                                } else {
                                    c.this.mz(true);
                                }
                            }
                        }
                    });
                }
                if (ar.isForumName(this.lDe.getForumName())) {
                    this.isLoading = true;
                    this.egK.dhr();
                    this.egK.fx(this.lDe.getForumName(), String.valueOf(this.lDe.getForumId()));
                }
            }
        }
    }

    private void bTO() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.lDe != null && !StringUtils.isNull(this.lDe.getForumName()) && this.lDe.getForumId() > 0 && be.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.hlI == null) {
                    this.hlI = new ac();
                    this.hlI.a(new ac.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void z(String str, long j) {
                            c.this.isLoading = false;
                            c.this.mz(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void A(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.hlI.K(this.lDe.getForumName(), this.lDe.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setViewTextColor(this.agZ, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.idE, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.idF, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.aha, (int) R.color.cp_cont_d);
        an.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ao aoVar;
        if (this.lDe != null) {
            if (this.mRootView == view) {
                bTM();
                if (this.gOJ != null) {
                    this.gOJ.a(view, this.lDe);
                }
            } else if (this.hlG == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).getClassName();
                    if (!"推荐".equals(className)) {
                        aoVar = new ao("c13653");
                        aoVar.dk("resource_id", className);
                    } else {
                        aoVar = new ao("c13644");
                        aoVar.ag("obj_locate", 3);
                    }
                    aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    aoVar.s("fid", this.lDe.forumId);
                    aoVar.ag(TiebaInitialize.Params.OBJ_TO, this.lDe.isLike() ? 2 : 1);
                    TiebaStatic.log(aoVar);
                }
                if (this.lDe.isLike()) {
                    bTO();
                } else {
                    bTN();
                }
            }
        }
    }
}
