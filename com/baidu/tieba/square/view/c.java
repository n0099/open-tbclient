package com.baidu.tieba.square.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.square.data.b> {
    private BarImageView akt;
    private TextView akv;
    private TextView akw;
    private LikeModel fpO;
    private TBSpecificationBtn iQF;
    private ae iQH;
    private boolean isLoading;
    private TextView jNi;
    private TextView jNj;
    private View mRootView;
    private String noH;
    private String noI;
    private com.baidu.tieba.square.data.b noJ;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.noH = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.noI = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.akt = (BarImageView) view.findViewById(R.id.bar_image);
        this.akv = (TextView) view.findViewById(R.id.bar_name);
        this.akw = (TextView) view.findViewById(R.id.desc);
        this.jNi = (TextView) view.findViewById(R.id.member_text);
        this.jNj = (TextView) view.findViewById(R.id.post_text);
        this.iQF = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.noJ = bVar;
            this.akt.setShowOval(true);
            this.akt.setShowOuterBorder(false);
            this.akt.setShowInnerBorder(true);
            this.akt.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.akt.setStrokeColorResId(R.color.CAM_X0401);
            this.akt.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.akv.setText(forumName);
            this.jNi.setText(this.noH + " " + at.numberUniformFormatExtra(bVar.getMemberCount()));
            this.jNj.setText(this.noI + " " + at.numberUniformFormatExtra(bVar.dNl()));
            Ta(bVar.boP());
            pS(this.noJ.isLike());
            this.mRootView.setOnClickListener(this);
            this.iQF.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Ta(String str) {
        if (at.isEmpty(str)) {
            if (this.akw.getVisibility() != 8) {
                this.akw.setVisibility(8);
                if (this.akv.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.akv.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.akv.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.akw.getVisibility() != 0) {
            this.akw.setVisibility(0);
            if (this.akv.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.akv.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.akv.requestLayout();
            }
        }
        this.akw.setText(str);
    }

    public void pS(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.rs(R.color.CAM_X0302);
            this.iQF.setConfig(bVar);
            this.iQF.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.ru(R.color.CAM_X0109);
            this.iQF.setConfig(bVar2);
            this.iQF.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.noJ.setLike(z);
    }

    private void cAz() {
        if (this.noJ != null) {
            String forumName = this.noJ.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void cAA() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.noJ != null && !StringUtils.isNull(this.noJ.getForumName()) && this.noJ.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.fpO == null) {
                    this.fpO = new LikeModel(this.mTbPageContext);
                    this.fpO.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.fpO.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.fpO.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.fpO.getErrorString());
                                } else {
                                    c.this.pS(true);
                                }
                            }
                        }
                    });
                }
                if (at.isForumName(this.noJ.getForumName())) {
                    this.isLoading = true;
                    this.fpO.dOt();
                    this.fpO.gr(this.noJ.getForumName(), String.valueOf(this.noJ.getForumId()));
                }
            }
        }
    }

    private void cAB() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.noJ != null && !StringUtils.isNull(this.noJ.getForumName()) && this.noJ.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.iQH == null) {
                    this.iQH = new ae();
                    this.iQH.a(new ae.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ae.a
                        public void C(String str, long j) {
                            c.this.isLoading = false;
                            c.this.pS(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ae.a
                        public void D(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.iQH.P(this.noJ.getForumName(), this.noJ.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.akv, R.color.CAM_X0105);
        ao.setViewTextColor(this.jNi, R.color.CAM_X0109);
        ao.setViewTextColor(this.jNj, R.color.CAM_X0109);
        ao.setViewTextColor(this.akw, R.color.CAM_X0109);
        this.iQF.bxO();
        ao.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar;
        if (this.noJ != null) {
            if (this.mRootView == view) {
                cAz();
                if (this.itw != null) {
                    this.itw.a(view, this.noJ);
                }
            } else if (this.iQF == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).dMU().getClassName();
                    if (!"推荐".equals(className)) {
                        aqVar = new aq("c13653");
                        aqVar.dX("resource_id", className);
                    } else {
                        aqVar = new aq("c13644");
                        aqVar.an("obj_locate", 3);
                    }
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.w("fid", this.noJ.forumId);
                    aqVar.an(TiebaInitialize.Params.OBJ_TO, this.noJ.isLike() ? 2 : 1);
                    TiebaStatic.log(aqVar);
                }
                if (this.noJ.isLike()) {
                    cAB();
                } else {
                    cAA();
                }
            }
        }
    }
}
