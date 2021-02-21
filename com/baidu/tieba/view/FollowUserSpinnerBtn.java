package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FollowUserSpinnerBtn extends LinearLayout implements com.baidu.tbadk.core.view.userLike.b {
    private int backgroundColor;
    private String content;
    private Drawable drawable;
    private boolean isOpen;
    private ImageView jPF;
    private a mCX;
    private FrameLayout nYa;
    private FrameLayout nYb;
    private Paint nYc;
    private int nYd;
    private boolean nYe;
    private boolean nYf;
    private Path path;
    private RectF rectF;
    private TextView title;
    private static final int nXY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds224);
    private static final int nXZ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds58);
    private static final int akY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);

    /* loaded from: classes.dex */
    public interface a {
        void av(boolean z, boolean z2);
    }

    public FollowUserSpinnerBtn(Context context) {
        this(context, null);
    }

    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nYe = true;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.follow_user_spinner_btn_layout, this);
        setOrientation(0);
        this.nYa = (FrameLayout) findViewById(R.id.leftBox);
        this.nYb = (FrameLayout) findViewById(R.id.rightBox);
        this.title = (TextView) findViewById(R.id.title);
        this.jPF = (ImageView) findViewById(R.id.arrow);
        this.nYc = new Paint(1);
        this.nYc.setStyle(Paint.Style.STROKE);
        this.nYc.setStrokeCap(Paint.Cap.ROUND);
        this.nYc.setStrokeWidth(l.getDimens(context, R.dimen.tbds3));
        this.rectF = new RectF();
        this.path = new Path();
        this.nYd = R.color.CAM_X0105;
        this.drawable = SvgManager.bsR().a(R.drawable.icon_pure_unfold12_svg, this.nYd, (SvgManager.SvgResourceStateType) null);
        this.jPF.setImageDrawable(this.drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.rectF.set(0.0f, 0.0f, getWidth(), getHeight());
        this.path.reset();
        this.path.addRoundRect(this.rectF, getHeight() / 2, getHeight() / 2, Path.Direction.CW);
        canvas.clipPath(this.path);
        super.draw(canvas);
        if (this.nYf) {
            this.nYc.setColor(ap.getColor(this.nYd));
            float right = this.nYa.getRight();
            canvas.drawLine(right, this.jPF.getTop(), right, this.jPF.getBottom(), this.nYc);
        }
    }

    public void aM(boolean z) {
        if (z) {
            this.content = getResources().getString(R.string.followed);
            this.nYd = R.color.CAM_X0101;
            this.backgroundColor = R.color.CAM_X0904;
        } else {
            this.content = getResources().getString(R.string.attention);
            this.nYd = R.color.CAM_X0105;
            this.backgroundColor = R.color.CAM_X0901;
        }
        this.title.setText(this.content);
        requestLayout();
        onChangeSkinType(0);
        if (this.nYf && !this.nYe && z && !this.isOpen && this.mCX != null) {
            this.mCX.av(true, true);
        }
        this.nYe = false;
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        aM(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(boolean z, int i, boolean z2) {
        r(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void qb(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bG(View view) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setOpenListener(final a aVar) {
        this.mCX = aVar;
        this.nYb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FollowUserSpinnerBtn.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.av(!FollowUserSpinnerBtn.this.isOpen, false);
                }
            }
        });
    }

    public void onChangeSkinType(int i) {
        setBackgroundColor(ap.getColor(this.backgroundColor));
        ap.setViewTextColor(this.title, this.nYd);
        this.drawable = SvgManager.bsR().a(R.drawable.icon_pure_unfold12_svg, this.nYd, (SvgManager.SvgResourceStateType) null);
        this.jPF.setImageDrawable(this.drawable);
        invalidate();
    }

    public void setFirstUpdate(boolean z) {
        this.nYe = z;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public void setShowPullBtn(boolean z) {
        this.nYf = z;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.title.getLayoutParams();
        if (z) {
            this.nYb.setVisibility(0);
            layoutParams.leftMargin = nXZ;
            layoutParams.rightMargin = akY;
            layoutParams.gravity = 16;
            layoutParams.width = -2;
        } else {
            this.nYb.setVisibility(8);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.gravity = 17;
            layoutParams.width = nXY;
        }
        this.title.setLayoutParams(layoutParams);
        requestLayout();
    }

    public ImageView getArrow() {
        return this.jPF;
    }
}
