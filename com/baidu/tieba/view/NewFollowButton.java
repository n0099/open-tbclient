package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
/* loaded from: classes21.dex */
public class NewFollowButton extends TBSpecificationBtn implements View.OnClickListener {
    private Animation animation;
    private int ffO;
    private long forumId;
    private String forumName;
    private LikeModel jLH;
    private ae jLI;
    private boolean loading;
    private TBSpecificationButtonConfig nQe;
    private TBSpecificationButtonConfig nQf;
    private com.baidu.adp.base.d nQg;
    private ae.a nQh;
    private boolean nQi;
    private int nQj;
    private boolean nQk;
    private final int nQl;
    private boolean nQm;
    private int nQn;
    private boolean nQo;
    private com.baidu.tbadk.core.view.commonBtn.b nQp;
    private com.baidu.tbadk.core.view.commonBtn.b nQq;
    private a nQr;
    private TbPageContext<?> pageContext;

    public NewFollowButton(Context context) {
        this(context, null, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQi = true;
        this.nQj = UtilHelper.getDimenPixelSize(R.dimen.tbds4);
        this.ffO = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
        this.nQk = true;
        this.nQl = R.drawable.icon_pure_add12_svg;
        this.nQm = false;
        this.loading = false;
        setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(final boolean z, boolean z2) {
        if (z2 && this.nQn != 0 && this.animation == null) {
            this.animation = AnimationUtils.loadAnimation(this.pageContext.getPageActivity(), this.nQn);
            this.animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.NewFollowButton.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    NewFollowButton.this.aP(z);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        if (z2 && this.animation != null) {
            startAnimation(this.animation);
        } else {
            aP(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(boolean z) {
        if (z) {
            if (this.nQf == null) {
                if (this.nQq == null) {
                    this.nQq = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nQq.rj(R.color.CAM_X0109);
                    this.nQq.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                }
                setConfig(this.nQq);
            } else {
                setConfig(this.nQf);
            }
            setClickable(this.nQi);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            if (this.nQe == null) {
                if (this.nQp == null) {
                    this.nQp = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nQp.rh(R.color.CAM_X0302);
                    if (this.nQk) {
                        this.nQp.rc(this.ffO);
                        this.nQp.a(this.nQl, 0, TBSpecificationButtonConfig.IconType.SVG);
                        this.nQp.rg(this.nQj);
                    }
                }
                setConfig(this.nQp);
            } else {
                setConfig(this.nQe);
            }
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        bvt();
        this.nQo = z;
    }

    private void cxG() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nQr == null) {
                    this.nQr = new a();
                }
                if (this.jLH == null) {
                    this.jLH = new LikeModel(this.pageContext);
                    this.jLH.setLoadDataCallBack(this.nQr);
                }
                if (au.isForumName(this.forumName)) {
                    this.loading = true;
                    this.jLH.dOA();
                    this.jLH.gu(this.forumName, String.valueOf(this.forumId));
                }
            }
        }
    }

    private void cxH() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nQr == null) {
                    this.nQr = new a();
                }
                if (this.jLI == null) {
                    this.jLI = new ae();
                    this.jLI.a(this.nQr);
                }
                this.loading = true;
                this.jLI.O(this.forumName, this.forumId);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nQo) {
            cxG();
        } else {
            cxH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends com.baidu.adp.base.d implements ae.a {
        private a() {
        }

        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (NewFollowButton.this.jLH.getErrorCode() == 22) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.pageContext.getString(R.string.had_liked_forum));
                NewFollowButton.this.loading = false;
            } else if (obj == null) {
                NewFollowButton.this.loading = false;
            } else if (NewFollowButton.this.jLH.getErrorCode() != 0) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.jLH.getErrorString());
                NewFollowButton.this.loading = false;
            } else {
                NewFollowButton.this.aA(true, NewFollowButton.this.nQm);
                if (NewFollowButton.this.nQg != null) {
                    NewFollowButton.this.nQg.callback(obj);
                }
                NewFollowButton.this.loading = false;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            NewFollowButton.this.aA(false, NewFollowButton.this.nQm);
            if (NewFollowButton.this.nQh != null) {
                NewFollowButton.this.nQh.C(str, j);
            }
            NewFollowButton.this.loading = false;
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void D(String str, long j) {
            if (NewFollowButton.this.nQh != null) {
                NewFollowButton.this.nQh.D(str, j);
            }
            NewFollowButton.this.loading = false;
        }
    }
}
