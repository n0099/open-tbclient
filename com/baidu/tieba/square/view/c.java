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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.square.data.b> {
    private BarImageView ajr;
    private TextView ajt;
    private TextView aju;
    private LikeModel fnw;
    private TBSpecificationBtn iRG;
    private ae iRI;
    private boolean isLoading;
    private TextView jPA;
    private TextView jPz;
    private View mRootView;
    private String ntI;
    private String ntJ;
    private com.baidu.tieba.square.data.b ntK;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.ntI = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.ntJ = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.ajr = (BarImageView) view.findViewById(R.id.bar_image);
        this.ajt = (TextView) view.findViewById(R.id.bar_name);
        this.aju = (TextView) view.findViewById(R.id.desc);
        this.jPz = (TextView) view.findViewById(R.id.member_text);
        this.jPA = (TextView) view.findViewById(R.id.post_text);
        this.iRG = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.ntK = bVar;
            this.ajr.setShowOval(true);
            this.ajr.setShowOuterBorder(false);
            this.ajr.setShowInnerBorder(true);
            this.ajr.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.ajr.setStrokeColorResId(R.color.CAM_X0401);
            this.ajr.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (au.isEmpty(forumName)) {
                forumName = "";
            }
            this.ajt.setText(forumName);
            this.jPz.setText(this.ntI + " " + au.numberUniformFormatExtra(bVar.getMemberCount()));
            this.jPA.setText(this.ntJ + " " + au.numberUniformFormatExtra(bVar.dLF()));
            SP(bVar.blo());
            pY(this.ntK.isLike());
            this.mRootView.setOnClickListener(this);
            this.iRG.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void SP(String str) {
        if (au.isEmpty(str)) {
            if (this.aju.getVisibility() != 8) {
                this.aju.setVisibility(8);
                if (this.ajt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.ajt.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.ajt.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.aju.getVisibility() != 0) {
            this.aju.setVisibility(0);
            if (this.ajt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ajt.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.ajt.requestLayout();
            }
        }
        this.aju.setText(str);
    }

    public void pY(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pR(R.color.CAM_X0302);
            this.iRG.setConfig(bVar);
            this.iRG.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pT(R.color.CAM_X0109);
            this.iRG.setConfig(bVar2);
            this.iRG.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.ntK.setLike(z);
    }

    private void cxU() {
        if (this.ntK != null) {
            String forumName = this.ntK.getForumName();
            if (au.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void cxV() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.ntK != null && !StringUtils.isNull(this.ntK.getForumName()) && this.ntK.getForumId() > 0 && bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.fnw == null) {
                    this.fnw = new LikeModel(this.mTbPageContext);
                    this.fnw.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.fnw.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.fnw.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.fnw.getErrorString());
                                } else {
                                    c.this.pY(true);
                                }
                            }
                        }
                    });
                }
                if (au.isForumName(this.ntK.getForumName())) {
                    this.isLoading = true;
                    this.fnw.dMN();
                    this.fnw.gw(this.ntK.getForumName(), String.valueOf(this.ntK.getForumId()));
                }
            }
        }
    }

    private void cxW() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.ntK != null && !StringUtils.isNull(this.ntK.getForumName()) && this.ntK.getForumId() > 0 && bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.iRI == null) {
                    this.iRI = new ae();
                    this.iRI.a(new ae.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ae.a
                        public void B(String str, long j) {
                            c.this.isLoading = false;
                            c.this.pY(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ae.a
                        public void C(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.iRI.O(this.ntK.getForumName(), this.ntK.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.ajt, R.color.CAM_X0105);
        ap.setViewTextColor(this.jPz, R.color.CAM_X0109);
        ap.setViewTextColor(this.jPA, R.color.CAM_X0109);
        ap.setViewTextColor(this.aju, R.color.CAM_X0109);
        this.iRG.bup();
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar arVar;
        if (this.ntK != null) {
            if (this.mRootView == view) {
                cxU();
                if (this.iut != null) {
                    this.iut.a(view, this.ntK);
                }
            } else if (this.iRG == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).dLo().getClassName();
                    if (!"推荐".equals(className)) {
                        arVar = new ar("c13653");
                        arVar.dR("resource_id", className);
                    } else {
                        arVar = new ar("c13644");
                        arVar.ap("obj_locate", 3);
                    }
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.v("fid", this.ntK.forumId);
                    arVar.ap(TiebaInitialize.Params.OBJ_TO, this.ntK.isLike() ? 2 : 1);
                    TiebaStatic.log(arVar);
                }
                if (this.ntK.isLike()) {
                    cxW();
                } else {
                    cxV();
                }
            }
        }
    }
}
