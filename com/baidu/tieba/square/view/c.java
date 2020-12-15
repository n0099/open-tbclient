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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.square.data.b> {
    private BarImageView ajR;
    private TextView ajT;
    private TextView ajU;
    private LikeModel fgf;
    private TBSpecificationBtn iEt;
    private ae iEv;
    private boolean isLoading;
    private TextView jAJ;
    private TextView jAK;
    private View mRootView;
    private String nja;
    private String njb;
    private com.baidu.tieba.square.data.b njc;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.nja = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.njb = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.ajR = (BarImageView) view.findViewById(R.id.bar_image);
        this.ajT = (TextView) view.findViewById(R.id.bar_name);
        this.ajU = (TextView) view.findViewById(R.id.desc);
        this.jAJ = (TextView) view.findViewById(R.id.member_text);
        this.jAK = (TextView) view.findViewById(R.id.post_text);
        this.iEt = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.njc = bVar;
            this.ajR.setShowOval(true);
            this.ajR.setShowOuterBorder(false);
            this.ajR.setShowInnerBorder(true);
            this.ajR.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.ajR.setStrokeColorResId(R.color.CAM_X0401);
            this.ajR.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (au.isEmpty(forumName)) {
                forumName = "";
            }
            this.ajT.setText(forumName);
            this.jAJ.setText(this.nja + " " + au.numberUniformFormatExtra(bVar.getMemberCount()));
            this.jAK.setText(this.njb + " " + au.numberUniformFormatExtra(bVar.dNt()));
            Tr(bVar.bmo());
            pv(this.njc.isLike());
            this.mRootView.setOnClickListener(this);
            this.iEt.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Tr(String str) {
        if (au.isEmpty(str)) {
            if (this.ajU.getVisibility() != 8) {
                this.ajU.setVisibility(8);
                if (this.ajT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.ajT.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.ajT.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.ajU.getVisibility() != 0) {
            this.ajU.setVisibility(0);
            if (this.ajT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ajT.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.ajT.requestLayout();
            }
        }
        this.ajU.setText(str);
    }

    public void pv(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.rh(R.color.CAM_X0302);
            this.iEt.setConfig(bVar);
            this.iEt.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.rj(R.color.CAM_X0109);
            this.iEt.setConfig(bVar2);
            this.iEt.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.njc.setLike(z);
    }

    private void cxG() {
        if (this.njc != null) {
            String forumName = this.njc.getForumName();
            if (au.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void cxH() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.njc != null && !StringUtils.isNull(this.njc.getForumName()) && this.njc.getForumId() > 0 && bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.fgf == null) {
                    this.fgf = new LikeModel(this.mTbPageContext);
                    this.fgf.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.fgf.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.fgf.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.fgf.getErrorString());
                                } else {
                                    c.this.pv(true);
                                }
                            }
                        }
                    });
                }
                if (au.isForumName(this.njc.getForumName())) {
                    this.isLoading = true;
                    this.fgf.dOB();
                    this.fgf.gu(this.njc.getForumName(), String.valueOf(this.njc.getForumId()));
                }
            }
        }
    }

    private void cxI() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.njc != null && !StringUtils.isNull(this.njc.getForumName()) && this.njc.getForumId() > 0 && bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.iEv == null) {
                    this.iEv = new ae();
                    this.iEv.a(new ae.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ae.a
                        public void C(String str, long j) {
                            c.this.isLoading = false;
                            c.this.pv(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ae.a
                        public void D(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.iEv.O(this.njc.getForumName(), this.njc.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.ajT, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.jAJ, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.jAK, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.ajU, (int) R.color.CAM_X0109);
        this.iEt.bvt();
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar arVar;
        if (this.njc != null) {
            if (this.mRootView == view) {
                cxG();
                if (this.ihb != null) {
                    this.ihb.a(view, this.njc);
                }
            } else if (this.iEt == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).dNc().getClassName();
                    if (!"推荐".equals(className)) {
                        arVar = new ar("c13653");
                        arVar.dY("resource_id", className);
                    } else {
                        arVar = new ar("c13644");
                        arVar.al("obj_locate", 3);
                    }
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.w("fid", this.njc.forumId);
                    arVar.al(TiebaInitialize.Params.OBJ_TO, this.njc.isLike() ? 2 : 1);
                    TiebaStatic.log(arVar);
                }
                if (this.njc.isLike()) {
                    cxI();
                } else {
                    cxH();
                }
            }
        }
    }
}
