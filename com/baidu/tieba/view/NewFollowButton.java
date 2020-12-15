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
    private LikeModel jLJ;
    private ae jLK;
    private boolean loading;
    private TBSpecificationButtonConfig nQg;
    private TBSpecificationButtonConfig nQh;
    private com.baidu.adp.base.d nQi;
    private ae.a nQj;
    private boolean nQk;
    private int nQl;
    private boolean nQm;
    private final int nQn;
    private boolean nQo;
    private int nQp;
    private boolean nQq;
    private com.baidu.tbadk.core.view.commonBtn.b nQr;
    private com.baidu.tbadk.core.view.commonBtn.b nQs;
    private a nQt;
    private TbPageContext<?> pageContext;

    public NewFollowButton(Context context) {
        this(context, null, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQk = true;
        this.nQl = UtilHelper.getDimenPixelSize(R.dimen.tbds4);
        this.ffO = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
        this.nQm = true;
        this.nQn = R.drawable.icon_pure_add12_svg;
        this.nQo = false;
        this.loading = false;
        setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(final boolean z, boolean z2) {
        if (z2 && this.nQp != 0 && this.animation == null) {
            this.animation = AnimationUtils.loadAnimation(this.pageContext.getPageActivity(), this.nQp);
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
            if (this.nQh == null) {
                if (this.nQs == null) {
                    this.nQs = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nQs.rj(R.color.CAM_X0109);
                    this.nQs.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                }
                setConfig(this.nQs);
            } else {
                setConfig(this.nQh);
            }
            setClickable(this.nQk);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            if (this.nQg == null) {
                if (this.nQr == null) {
                    this.nQr = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nQr.rh(R.color.CAM_X0302);
                    if (this.nQm) {
                        this.nQr.rc(this.ffO);
                        this.nQr.a(this.nQn, 0, TBSpecificationButtonConfig.IconType.SVG);
                        this.nQr.rg(this.nQl);
                    }
                }
                setConfig(this.nQr);
            } else {
                setConfig(this.nQg);
            }
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        bvt();
        this.nQq = z;
    }

    private void cxH() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nQt == null) {
                    this.nQt = new a();
                }
                if (this.jLJ == null) {
                    this.jLJ = new LikeModel(this.pageContext);
                    this.jLJ.setLoadDataCallBack(this.nQt);
                }
                if (au.isForumName(this.forumName)) {
                    this.loading = true;
                    this.jLJ.dOB();
                    this.jLJ.gu(this.forumName, String.valueOf(this.forumId));
                }
            }
        }
    }

    private void cxI() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nQt == null) {
                    this.nQt = new a();
                }
                if (this.jLK == null) {
                    this.jLK = new ae();
                    this.jLK.a(this.nQt);
                }
                this.loading = true;
                this.jLK.O(this.forumName, this.forumId);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nQq) {
            cxH();
        } else {
            cxI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends com.baidu.adp.base.d implements ae.a {
        private a() {
        }

        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (NewFollowButton.this.jLJ.getErrorCode() == 22) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.pageContext.getString(R.string.had_liked_forum));
                NewFollowButton.this.loading = false;
            } else if (obj == null) {
                NewFollowButton.this.loading = false;
            } else if (NewFollowButton.this.jLJ.getErrorCode() != 0) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.jLJ.getErrorString());
                NewFollowButton.this.loading = false;
            } else {
                NewFollowButton.this.aA(true, NewFollowButton.this.nQo);
                if (NewFollowButton.this.nQi != null) {
                    NewFollowButton.this.nQi.callback(obj);
                }
                NewFollowButton.this.loading = false;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            NewFollowButton.this.aA(false, NewFollowButton.this.nQo);
            if (NewFollowButton.this.nQj != null) {
                NewFollowButton.this.nQj.C(str, j);
            }
            NewFollowButton.this.loading = false;
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void D(String str, long j) {
            if (NewFollowButton.this.nQj != null) {
                NewFollowButton.this.nQj.D(str, j);
            }
            NewFollowButton.this.loading = false;
        }
    }
}
