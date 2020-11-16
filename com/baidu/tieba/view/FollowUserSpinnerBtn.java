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
/* loaded from: classes20.dex */
public class FollowUserSpinnerBtn extends LinearLayout implements com.baidu.tbadk.core.view.userLike.b {
    private RectF GD;
    private int backgroundColor;
    private String content;
    private Drawable drawable;
    private boolean isOpen;
    private ImageView jmX;
    private a meR;
    private FrameLayout nAB;
    private FrameLayout nAC;
    private Paint nAD;
    private int nAE;
    private boolean nAF;
    private boolean nAG;
    private Path path;
    private TextView title;
    private static final int nAz = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds224);
    private static final int nAA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds58);
    private static final int akx = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);

    /* loaded from: classes20.dex */
    public interface a {
        void at(boolean z, boolean z2);
    }

    public FollowUserSpinnerBtn(Context context) {
        this(context, null);
    }

    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nAF = true;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.follow_user_spinner_btn_layout, this);
        setOrientation(0);
        this.nAB = (FrameLayout) findViewById(R.id.leftBox);
        this.nAC = (FrameLayout) findViewById(R.id.rightBox);
        this.title = (TextView) findViewById(R.id.title);
        this.jmX = (ImageView) findViewById(R.id.arrow);
        this.nAD = new Paint(1);
        this.nAD.setStyle(Paint.Style.STROKE);
        this.nAD.setStrokeCap(Paint.Cap.ROUND);
        this.nAD.setStrokeWidth(l.getDimens(context, R.dimen.tbds3));
        this.GD = new RectF();
        this.path = new Path();
        this.nAE = R.color.CAM_X0105;
        this.drawable = SvgManager.bqB().a(R.drawable.icon_pure_unfold12_svg, this.nAE, (SvgManager.SvgResourceStateType) null);
        this.jmX.setImageDrawable(this.drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.GD.set(0.0f, 0.0f, getWidth(), getHeight());
        this.path.reset();
        this.path.addRoundRect(this.GD, getHeight() / 2, getHeight() / 2, Path.Direction.CW);
        canvas.clipPath(this.path);
        super.draw(canvas);
        if (this.nAG) {
            this.nAD.setColor(ap.getColor(this.nAE));
            float right = this.nAB.getRight();
            canvas.drawLine(right, this.jmX.getTop(), right, this.jmX.getBottom(), this.nAD);
        }
    }

    public void aP(boolean z) {
        if (z) {
            this.content = getResources().getString(R.string.followed);
            this.nAE = R.color.CAM_X0101;
            this.backgroundColor = R.color.CAM_X0904;
        } else {
            this.content = getResources().getString(R.string.attention);
            this.nAE = R.color.CAM_X0105;
            this.backgroundColor = R.color.CAM_X0901;
        }
        this.title.setText(this.content);
        requestLayout();
        onChangeSkinType(0);
        if (this.nAG && !this.nAF && z && !this.isOpen && this.meR != null) {
            this.meR.at(true, true);
        }
        this.nAF = false;
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void s(boolean z, int i) {
        aP(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        s(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void qP(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void by(View view) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void h(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setOpenListener(final a aVar) {
        this.meR = aVar;
        this.nAC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FollowUserSpinnerBtn.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.at(!FollowUserSpinnerBtn.this.isOpen, false);
                }
            }
        });
    }

    public void onChangeSkinType(int i) {
        setBackgroundColor(ap.getColor(this.backgroundColor));
        ap.setViewTextColor(this.title, this.nAE);
        this.drawable = SvgManager.bqB().a(R.drawable.icon_pure_unfold12_svg, this.nAE, (SvgManager.SvgResourceStateType) null);
        this.jmX.setImageDrawable(this.drawable);
        invalidate();
    }

    public void setFirstUpdate(boolean z) {
        this.nAF = z;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public void setShowPullBtn(boolean z) {
        this.nAG = z;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.title.getLayoutParams();
        if (z) {
            this.nAC.setVisibility(0);
            layoutParams.leftMargin = nAA;
            layoutParams.rightMargin = akx;
            layoutParams.gravity = 16;
            layoutParams.width = -2;
        } else {
            this.nAC.setVisibility(8);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.gravity = 17;
            layoutParams.width = nAz;
        }
        this.title.setLayoutParams(layoutParams);
        requestLayout();
    }

    public ImageView getArrow() {
        return this.jmX;
    }
}
