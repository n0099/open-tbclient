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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
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
    private LikeModel jUs;
    private ae jUt;
    private boolean loading;
    private TBSpecificationButtonConfig nOX;
    private TBSpecificationButtonConfig nOY;
    private com.baidu.adp.base.e nOZ;
    private ae.a nPa;
    private boolean nPb;
    private int nPc;
    private boolean nPd;
    private final int nPe;
    private boolean nPf;
    private boolean nPg;
    private com.baidu.tbadk.core.view.commonBtn.b nPh;
    private com.baidu.tbadk.core.view.commonBtn.b nPi;
    private a nPj;
    private TbPageContext<?> pageContext;

    public NewFollowButton(Context context) {
        this(context, null, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nPb = true;
        this.nPc = UtilHelper.getDimenPixelSize(R.dimen.tbds4);
        this.iconSize = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
        this.nPd = true;
        this.nPe = R.drawable.icon_pure_add12_svg;
        this.nPf = false;
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
            if (this.nOY == null) {
                if (this.nPi == null) {
                    this.nPi = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nPi.pO(R.color.CAM_X0109);
                    this.nPi.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                }
                setConfig(this.nPi);
            } else {
                setConfig(this.nOY);
            }
            setClickable(this.nPb);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            if (this.nOX == null) {
                if (this.nPh == null) {
                    this.nPh = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nPh.pM(R.color.CAM_X0302);
                    if (this.nPd) {
                        this.nPh.setIconSize(this.iconSize);
                        this.nPh.a(this.nPe, 0, TBSpecificationButtonConfig.IconType.SVG);
                        this.nPh.pL(this.nPc);
                    }
                }
                setConfig(this.nPh);
            } else {
                setConfig(this.nOX);
            }
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        btV();
        this.nPg = z;
    }

    private void cwJ() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nPj == null) {
                    this.nPj = new a();
                }
                if (this.jUs == null) {
                    this.jUs = new LikeModel(this.pageContext);
                    this.jUs.setLoadDataCallBack(this.nPj);
                }
                if (at.isForumName(this.forumName)) {
                    this.loading = true;
                    this.jUs.dKC();
                    this.jUs.gq(this.forumName, String.valueOf(this.forumId));
                }
            }
        }
    }

    private void cwK() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nPj == null) {
                    this.nPj = new a();
                }
                if (this.jUt == null) {
                    this.jUt = new ae();
                    this.jUt.a(this.nPj);
                }
                this.loading = true;
                this.jUt.P(this.forumName, this.forumId);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nPg) {
            cwJ();
        } else {
            cwK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.base.e implements ae.a {
        private a() {
        }

        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (NewFollowButton.this.jUs.getErrorCode() == 22) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.pageContext.getString(R.string.had_liked_forum));
                NewFollowButton.this.loading = false;
            } else if (obj == null) {
                NewFollowButton.this.loading = false;
            } else if (NewFollowButton.this.jUs.getErrorCode() != 0) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.jUs.getErrorString());
                NewFollowButton.this.loading = false;
            } else {
                NewFollowButton.this.aC(true, NewFollowButton.this.nPf);
                if (NewFollowButton.this.nOZ != null) {
                    NewFollowButton.this.nOZ.callback(obj);
                }
                NewFollowButton.this.loading = false;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            NewFollowButton.this.aC(false, NewFollowButton.this.nPf);
            if (NewFollowButton.this.nPa != null) {
                NewFollowButton.this.nPa.C(str, j);
            }
            NewFollowButton.this.loading = false;
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void D(String str, long j) {
            if (NewFollowButton.this.nPa != null) {
                NewFollowButton.this.nPa.D(str, j);
            }
            NewFollowButton.this.loading = false;
        }
    }
}
