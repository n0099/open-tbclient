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
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.square.data.b> {
    private TextView aDI;
    private TextView dHz;
    private LikeModel dKo;
    private TBSpecificationBtn gKr;
    private ac gKt;
    private BarImageView gzf;
    private TextView hAD;
    private TextView hAE;
    private boolean isLoading;
    private String kPE;
    private String kPF;
    private com.baidu.tieba.square.data.b kPG;
    private View mRootView;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.kPE = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.kPF = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.gzf = (BarImageView) view.findViewById(R.id.bar_image);
        this.dHz = (TextView) view.findViewById(R.id.bar_name);
        this.aDI = (TextView) view.findViewById(R.id.desc);
        this.hAD = (TextView) view.findViewById(R.id.member_text);
        this.hAE = (TextView) view.findViewById(R.id.post_text);
        this.gKr = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.kPG = bVar;
            this.gzf.setShowOval(true);
            this.gzf.setShowOuterBorder(false);
            this.gzf.setShowInnerBorder(true);
            this.gzf.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.gzf.setStrokeColorResId(R.color.cp_border_a);
            this.gzf.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            this.dHz.setText(forumName);
            this.hAD.setText(this.kPE + " " + aq.numberUniformFormatExtra(bVar.getMemberCount()));
            this.hAE.setText(this.kPF + " " + aq.numberUniformFormatExtra(bVar.cUF()));
            Kx(bVar.aIx());
            lT(this.kPG.isLike());
            this.mRootView.setOnClickListener(this);
            this.gKr.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Kx(String str) {
        if (aq.isEmpty(str)) {
            if (this.aDI.getVisibility() != 8) {
                this.aDI.setVisibility(8);
                if (this.dHz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.dHz.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.dHz.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.aDI.getVisibility() != 0) {
            this.aDI.setVisibility(0);
            if (this.dHz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dHz.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.dHz.requestLayout();
            }
        }
        this.aDI.setText(str);
    }

    public void lT(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.lG(R.color.cp_link_tip_a);
            this.gKr.setConfig(cVar);
            this.gKr.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.lI(R.color.cp_cont_d);
            this.gKr.setConfig(cVar2);
            this.gKr.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.kPG.setLike(z);
    }

    private void bKu() {
        if (this.kPG != null) {
            String forumName = this.kPG.getForumName();
            if (aq.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void bKv() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.kPG != null && !StringUtils.isNull(this.kPG.getForumName()) && this.kPG.getForumId() > 0 && bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.dKo == null) {
                    this.dKo = new LikeModel(this.mTbPageContext);
                    this.dKo.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.dKo.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.dKo.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.dKo.getErrorString());
                                } else {
                                    c.this.lT(true);
                                }
                            }
                        }
                    });
                }
                if (aq.isForumName(this.kPG.getForumName())) {
                    this.isLoading = true;
                    this.dKo.cVL();
                    this.dKo.eP(this.kPG.getForumName(), String.valueOf(this.kPG.getForumId()));
                }
            }
        }
    }

    private void bKw() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.kPG != null && !StringUtils.isNull(this.kPG.getForumName()) && this.kPG.getForumId() > 0 && bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.gKt == null) {
                    this.gKt = new ac();
                    this.gKt.a(new ac.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void A(String str, long j) {
                            c.this.isLoading = false;
                            c.this.lT(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void B(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.gKt.L(this.kPG.getForumName(), this.kPG.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.dHz, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hAD, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hAE, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.aDI, (int) R.color.cp_cont_d);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an anVar;
        if (this.kPG != null) {
            if (this.mRootView == view) {
                bKu();
                if (this.gmI != null) {
                    this.gmI.a(view, this.kPG);
                }
            } else if (this.gKr == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).getClassName();
                    if (!"推荐".equals(className)) {
                        anVar = new an("c13653");
                        anVar.cI("resource_id", className);
                    } else {
                        anVar = new an("c13644");
                        anVar.af("obj_locate", 3);
                    }
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.t("fid", this.kPG.forumId);
                    anVar.af(TiebaInitialize.Params.OBJ_TO, this.kPG.isLike() ? 2 : 1);
                    TiebaStatic.log(anVar);
                }
                if (this.kPG.isLike()) {
                    bKw();
                } else {
                    bKv();
                }
            }
        }
    }
}
