package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.Nullable;
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
/* loaded from: classes.dex */
public class NewFollowButton extends TBSpecificationBtn implements View.OnClickListener {
    private Animation animation;
    private int animationId;
    private long forumId;
    private String forumName;
    private int iconSize;
    private LikeModel kbT;
    private ae kbU;
    private boolean loading;
    private TBSpecificationButtonConfig nZb;
    private TBSpecificationButtonConfig nZc;
    private com.baidu.adp.base.e nZd;
    private ae.a nZe;
    private boolean nZf;
    private int nZg;
    private boolean nZh;
    private final int nZi;
    private boolean nZj;
    private boolean nZk;
    private com.baidu.tbadk.core.view.commonBtn.b nZl;
    private com.baidu.tbadk.core.view.commonBtn.b nZm;
    private a nZn;
    private TbPageContext<?> pageContext;

    public NewFollowButton(Context context) {
        this(context, null, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nZf = true;
        this.nZg = UtilHelper.getDimenPixelSize(R.dimen.tbds4);
        this.iconSize = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
        this.nZh = true;
        this.nZi = R.drawable.icon_pure_add12_svg;
        this.nZj = false;
        this.loading = false;
        setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(final boolean z, boolean z2) {
        if (z2 && this.animationId != 0 && this.animation == null) {
            this.animation = AnimationUtils.loadAnimation(this.pageContext.getPageActivity(), this.animationId);
            this.animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.NewFollowButton.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    NewFollowButton.this.aM(z);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        if (z2 && this.animation != null) {
            startAnimation(this.animation);
        } else {
            aM(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(boolean z) {
        if (z) {
            if (this.nZc == null) {
                if (this.nZm == null) {
                    this.nZm = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nZm.pT(R.color.CAM_X0109);
                    this.nZm.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                }
                setConfig(this.nZm);
            } else {
                setConfig(this.nZc);
            }
            setClickable(this.nZf);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            if (this.nZb == null) {
                if (this.nZl == null) {
                    this.nZl = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nZl.pR(R.color.CAM_X0302);
                    if (this.nZh) {
                        this.nZl.setIconSize(this.iconSize);
                        this.nZl.a(this.nZi, 0, TBSpecificationButtonConfig.IconType.SVG);
                        this.nZl.pQ(this.nZg);
                    }
                }
                setConfig(this.nZl);
            } else {
                setConfig(this.nZb);
            }
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        bup();
        this.nZk = z;
    }

    private void cxV() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nZn == null) {
                    this.nZn = new a();
                }
                if (this.kbT == null) {
                    this.kbT = new LikeModel(this.pageContext);
                    this.kbT.setLoadDataCallBack(this.nZn);
                }
                if (au.isForumName(this.forumName)) {
                    this.loading = true;
                    this.kbT.dMN();
                    this.kbT.gw(this.forumName, String.valueOf(this.forumId));
                }
            }
        }
    }

    private void cxW() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nZn == null) {
                    this.nZn = new a();
                }
                if (this.kbU == null) {
                    this.kbU = new ae();
                    this.kbU.a(this.nZn);
                }
                this.loading = true;
                this.kbU.O(this.forumName, this.forumId);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nZk) {
            cxV();
        } else {
            cxW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.base.e implements ae.a {
        private a() {
        }

        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (NewFollowButton.this.kbT.getErrorCode() == 22) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.pageContext.getString(R.string.had_liked_forum));
                NewFollowButton.this.loading = false;
            } else if (obj == null) {
                NewFollowButton.this.loading = false;
            } else if (NewFollowButton.this.kbT.getErrorCode() != 0) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.kbT.getErrorString());
                NewFollowButton.this.loading = false;
            } else {
                NewFollowButton.this.aC(true, NewFollowButton.this.nZj);
                if (NewFollowButton.this.nZd != null) {
                    NewFollowButton.this.nZd.callback(obj);
                }
                NewFollowButton.this.loading = false;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void B(String str, long j) {
            NewFollowButton.this.aC(false, NewFollowButton.this.nZj);
            if (NewFollowButton.this.nZe != null) {
                NewFollowButton.this.nZe.B(str, j);
            }
            NewFollowButton.this.loading = false;
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            if (NewFollowButton.this.nZe != null) {
                NewFollowButton.this.nZe.C(str, j);
            }
            NewFollowButton.this.loading = false;
        }
    }
}
