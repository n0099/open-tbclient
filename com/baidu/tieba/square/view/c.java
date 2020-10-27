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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ad;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.square.data.b> {
    private BarImageView aiN;
    private TextView aiP;
    private TextView aiQ;
    private LikeModel eTL;
    private TBSpecificationBtn imN;
    private ad imP;
    private boolean isLoading;
    private TextView jgw;
    private TextView jgx;
    private String mOc;
    private String mOd;
    private com.baidu.tieba.square.data.b mOe;
    private View mRootView;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.mOc = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.mOd = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.aiN = (BarImageView) view.findViewById(R.id.bar_image);
        this.aiP = (TextView) view.findViewById(R.id.bar_name);
        this.aiQ = (TextView) view.findViewById(R.id.desc);
        this.jgw = (TextView) view.findViewById(R.id.member_text);
        this.jgx = (TextView) view.findViewById(R.id.post_text);
        this.imN = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.mOe = bVar;
            this.aiN.setShowOval(true);
            this.aiN.setShowOuterBorder(false);
            this.aiN.setShowInnerBorder(true);
            this.aiN.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.aiN.setStrokeColorResId(R.color.cp_border_a);
            this.aiN.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.aiP.setText(forumName);
            this.jgw.setText(this.mOc + " " + at.numberUniformFormatExtra(bVar.getMemberCount()));
            this.jgx.setText(this.mOd + " " + at.numberUniformFormatExtra(bVar.dFJ()));
            Sl(bVar.bhA());
            oN(this.mOe.isLike());
            this.mRootView.setOnClickListener(this);
            this.imN.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Sl(String str) {
        if (at.isEmpty(str)) {
            if (this.aiQ.getVisibility() != 8) {
                this.aiQ.setVisibility(8);
                if (this.aiP.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.aiP.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.aiP.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.aiQ.getVisibility() != 0) {
            this.aiQ.setVisibility(0);
            if (this.aiP.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aiP.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.aiP.requestLayout();
            }
        }
        this.aiQ.setText(str);
    }

    public void oN(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pY(R.color.cp_link_tip_a);
            this.imN.setConfig(bVar);
            this.imN.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.qa(R.color.cp_cont_d);
            this.imN.setConfig(bVar2);
            this.imN.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.mOe.setLike(z);
    }

    private void crm() {
        if (this.mOe != null) {
            String forumName = this.mOe.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void crn() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mOe != null && !StringUtils.isNull(this.mOe.getForumName()) && this.mOe.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.eTL == null) {
                    this.eTL = new LikeModel(this.mTbPageContext);
                    this.eTL.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.eTL.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.eTL.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.eTL.getErrorString());
                                } else {
                                    c.this.oN(true);
                                }
                            }
                        }
                    });
                }
                if (at.isForumName(this.mOe.getForumName())) {
                    this.isLoading = true;
                    this.eTL.dGQ();
                    this.eTL.gp(this.mOe.getForumName(), String.valueOf(this.mOe.getForumId()));
                }
            }
        }
    }

    private void cro() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mOe != null && !StringUtils.isNull(this.mOe.getForumName()) && this.mOe.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.imP == null) {
                    this.imP = new ad();
                    this.imP.a(new ad.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void C(String str, long j) {
                            c.this.isLoading = false;
                            c.this.oN(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void D(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.imP.O(this.mOe.getForumName(), this.mOe.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.aiP, R.color.cp_cont_b);
        ap.setViewTextColor(this.jgw, R.color.cp_cont_d);
        ap.setViewTextColor(this.jgx, R.color.cp_cont_d);
        ap.setViewTextColor(this.aiQ, R.color.cp_cont_d);
        this.imN.bqd();
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar;
        if (this.mOe != null) {
            if (this.mRootView == view) {
                crm();
                if (this.hPF != null) {
                    this.hPF.a(view, this.mOe);
                }
            } else if (this.imN == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).dFs().getClassName();
                    if (!"推荐".equals(className)) {
                        aqVar = new aq("c13653");
                        aqVar.dR("resource_id", className);
                    } else {
                        aqVar = new aq("c13644");
                        aqVar.aj("obj_locate", 3);
                    }
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.w("fid", this.mOe.forumId);
                    aqVar.aj(TiebaInitialize.Params.OBJ_TO, this.mOe.isLike() ? 2 : 1);
                    TiebaStatic.log(aqVar);
                }
                if (this.mOe.isLike()) {
                    cro();
                } else {
                    crn();
                }
            }
        }
    }
}
