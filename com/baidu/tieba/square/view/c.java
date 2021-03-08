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
    private BarImageView akJ;
    private TextView akL;
    private TextView akM;
    private LikeModel foW;
    private TBSpecificationBtn iTD;
    private ae iTF;
    private boolean isLoading;
    private TextView jRw;
    private TextView jRx;
    private View mRootView;
    private String nwn;
    private String nwo;
    private com.baidu.tieba.square.data.b nwp;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.nwn = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.nwo = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.akJ = (BarImageView) view.findViewById(R.id.bar_image);
        this.akL = (TextView) view.findViewById(R.id.bar_name);
        this.akM = (TextView) view.findViewById(R.id.desc);
        this.jRw = (TextView) view.findViewById(R.id.member_text);
        this.jRx = (TextView) view.findViewById(R.id.post_text);
        this.iTD = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.nwp = bVar;
            this.akJ.setShowOval(true);
            this.akJ.setShowOuterBorder(false);
            this.akJ.setShowInnerBorder(true);
            this.akJ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.akJ.setStrokeColorResId(R.color.CAM_X0401);
            this.akJ.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (au.isEmpty(forumName)) {
                forumName = "";
            }
            this.akL.setText(forumName);
            this.jRw.setText(this.nwn + " " + au.numberUniformFormatExtra(bVar.getMemberCount()));
            this.jRx.setText(this.nwo + " " + au.numberUniformFormatExtra(bVar.dLV()));
            Th(bVar.blq());
            pY(this.nwp.isLike());
            this.mRootView.setOnClickListener(this);
            this.iTD.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Th(String str) {
        if (au.isEmpty(str)) {
            if (this.akM.getVisibility() != 8) {
                this.akM.setVisibility(8);
                if (this.akL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.akL.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.akL.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.akM.getVisibility() != 0) {
            this.akM.setVisibility(0);
            if (this.akL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.akL.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.akL.requestLayout();
            }
        }
        this.akM.setText(str);
    }

    public void pY(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pS(R.color.CAM_X0302);
            this.iTD.setConfig(bVar);
            this.iTD.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pU(R.color.CAM_X0109);
            this.iTD.setConfig(bVar2);
            this.iTD.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.nwp.setLike(z);
    }

    private void cyh() {
        if (this.nwp != null) {
            String forumName = this.nwp.getForumName();
            if (au.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void cyi() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.nwp != null && !StringUtils.isNull(this.nwp.getForumName()) && this.nwp.getForumId() > 0 && bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.foW == null) {
                    this.foW = new LikeModel(this.mTbPageContext);
                    this.foW.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.foW.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.foW.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.foW.getErrorString());
                                } else {
                                    c.this.pY(true);
                                }
                            }
                        }
                    });
                }
                if (au.isForumName(this.nwp.getForumName())) {
                    this.isLoading = true;
                    this.foW.dNd();
                    this.foW.gy(this.nwp.getForumName(), String.valueOf(this.nwp.getForumId()));
                }
            }
        }
    }

    private void cyj() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.nwp != null && !StringUtils.isNull(this.nwp.getForumName()) && this.nwp.getForumId() > 0 && bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.iTF == null) {
                    this.iTF = new ae();
                    this.iTF.a(new ae.a() { // from class: com.baidu.tieba.square.view.c.2
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
                this.iTF.O(this.nwp.getForumName(), this.nwp.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.akL, R.color.CAM_X0105);
        ap.setViewTextColor(this.jRw, R.color.CAM_X0109);
        ap.setViewTextColor(this.jRx, R.color.CAM_X0109);
        ap.setViewTextColor(this.akM, R.color.CAM_X0109);
        this.iTD.bus();
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar arVar;
        if (this.nwp != null) {
            if (this.mRootView == view) {
                cyh();
                if (this.iwq != null) {
                    this.iwq.a(view, this.nwp);
                }
            } else if (this.iTD == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).dLE().getClassName();
                    if (!"推荐".equals(className)) {
                        arVar = new ar("c13653");
                        arVar.dR("resource_id", className);
                    } else {
                        arVar = new ar("c13644");
                        arVar.aq("obj_locate", 3);
                    }
                    arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.v("fid", this.nwp.forumId);
                    arVar.aq(TiebaInitialize.Params.OBJ_TO, this.nwp.isLike() ? 2 : 1);
                    TiebaStatic.log(arVar);
                }
                if (this.nwp.isLike()) {
                    cyj();
                } else {
                    cyi();
                }
            }
        }
    }
}
