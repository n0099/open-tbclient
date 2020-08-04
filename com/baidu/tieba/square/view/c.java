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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ac;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.square.data.b> {
    private BarImageView agO;
    private TextView agQ;
    private TextView agR;
    private LikeModel emT;
    private TBSpecificationBtn hrs;
    private ac hru;
    private TextView ijE;
    private TextView ijF;
    private boolean isLoading;
    private String lKt;
    private String lKu;
    private com.baidu.tieba.square.data.b lKv;
    private View mRootView;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.lKt = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.lKu = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.agO = (BarImageView) view.findViewById(R.id.bar_image);
        this.agQ = (TextView) view.findViewById(R.id.bar_name);
        this.agR = (TextView) view.findViewById(R.id.desc);
        this.ijE = (TextView) view.findViewById(R.id.member_text);
        this.ijF = (TextView) view.findViewById(R.id.post_text);
        this.hrs = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.lKv = bVar;
            this.agO.setShowOval(true);
            this.agO.setShowOuterBorder(false);
            this.agO.setShowInnerBorder(true);
            this.agO.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.agO.setStrokeColorResId(R.color.cp_border_a);
            this.agO.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (as.isEmpty(forumName)) {
                forumName = "";
            }
            this.agQ.setText(forumName);
            this.ijE.setText(this.lKt + " " + as.numberUniformFormatExtra(bVar.getMemberCount()));
            this.ijF.setText(this.lKu + " " + as.numberUniformFormatExtra(bVar.djv()));
            Nx(bVar.aTO());
            ne(this.lKv.isLike());
            this.mRootView.setOnClickListener(this);
            this.hrs.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Nx(String str) {
        if (as.isEmpty(str)) {
            if (this.agR.getVisibility() != 8) {
                this.agR.setVisibility(8);
                if (this.agQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.agQ.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.agQ.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.agR.getVisibility() != 0) {
            this.agR.setVisibility(0);
            if (this.agQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.agQ.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.agQ.requestLayout();
            }
        }
        this.agR.setText(str);
    }

    public void ne(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mV(R.color.cp_link_tip_a);
            this.hrs.setConfig(cVar);
            this.hrs.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mX(R.color.cp_cont_d);
            this.hrs.setConfig(cVar2);
            this.hrs.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.lKv.setLike(z);
    }

    private void bXg() {
        if (this.lKv != null) {
            String forumName = this.lKv.getForumName();
            if (as.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void bXh() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.lKv != null && !StringUtils.isNull(this.lKv.getForumName()) && this.lKv.getForumId() > 0 && bf.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.emT == null) {
                    this.emT = new LikeModel(this.mTbPageContext);
                    this.emT.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.emT.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.emT.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.emT.getErrorString());
                                } else {
                                    c.this.ne(true);
                                }
                            }
                        }
                    });
                }
                if (as.isForumName(this.lKv.getForumName())) {
                    this.isLoading = true;
                    this.emT.dkB();
                    this.emT.fz(this.lKv.getForumName(), String.valueOf(this.lKv.getForumId()));
                }
            }
        }
    }

    private void bXi() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.lKv != null && !StringUtils.isNull(this.lKv.getForumName()) && this.lKv.getForumId() > 0 && bf.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.hru == null) {
                    this.hru = new ac();
                    this.hru.a(new ac.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void x(String str, long j) {
                            c.this.isLoading = false;
                            c.this.ne(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void y(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.hru.J(this.lKv.getForumName(), this.lKv.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.agQ, R.color.cp_cont_b);
        ao.setViewTextColor(this.ijE, R.color.cp_cont_d);
        ao.setViewTextColor(this.ijF, R.color.cp_cont_d);
        ao.setViewTextColor(this.agR, R.color.cp_cont_d);
        ao.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ap apVar;
        if (this.lKv != null) {
            if (this.mRootView == view) {
                bXg();
                if (this.gUp != null) {
                    this.gUp.a(view, this.lKv);
                }
            } else if (this.hrs == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).getClassName();
                    if (!"推荐".equals(className)) {
                        apVar = new ap("c13653");
                        apVar.dn("resource_id", className);
                    } else {
                        apVar = new ap("c13644");
                        apVar.ah("obj_locate", 3);
                    }
                    apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    apVar.t("fid", this.lKv.forumId);
                    apVar.ah(TiebaInitialize.Params.OBJ_TO, this.lKv.isLike() ? 2 : 1);
                    TiebaStatic.log(apVar);
                }
                if (this.lKv.isLike()) {
                    bXi();
                } else {
                    bXh();
                }
            }
        }
    }
}
