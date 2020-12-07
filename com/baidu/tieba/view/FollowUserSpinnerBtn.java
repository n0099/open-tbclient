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
/* loaded from: classes21.dex */
public class FollowUserSpinnerBtn extends LinearLayout implements com.baidu.tbadk.core.view.userLike.b {
    private RectF Hx;
    private int backgroundColor;
    private String content;
    private Drawable drawable;
    private boolean isOpen;
    private ImageView jAz;
    private a msX;
    private FrameLayout nOD;
    private FrameLayout nOE;
    private Paint nOF;
    private int nOG;
    private boolean nOH;
    private boolean nOI;
    private Path path;
    private TextView title;
    private static final int nOB = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds224);
    private static final int nOC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds58);
    private static final int aly = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);

    /* loaded from: classes21.dex */
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
        this.nOH = true;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.follow_user_spinner_btn_layout, this);
        setOrientation(0);
        this.nOD = (FrameLayout) findViewById(R.id.leftBox);
        this.nOE = (FrameLayout) findViewById(R.id.rightBox);
        this.title = (TextView) findViewById(R.id.title);
        this.jAz = (ImageView) findViewById(R.id.arrow);
        this.nOF = new Paint(1);
        this.nOF.setStyle(Paint.Style.STROKE);
        this.nOF.setStrokeCap(Paint.Cap.ROUND);
        this.nOF.setStrokeWidth(l.getDimens(context, R.dimen.tbds3));
        this.Hx = new RectF();
        this.path = new Path();
        this.nOG = R.color.CAM_X0105;
        this.drawable = SvgManager.btW().a(R.drawable.icon_pure_unfold12_svg, this.nOG, (SvgManager.SvgResourceStateType) null);
        this.jAz.setImageDrawable(this.drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.Hx.set(0.0f, 0.0f, getWidth(), getHeight());
        this.path.reset();
        this.path.addRoundRect(this.Hx, getHeight() / 2, getHeight() / 2, Path.Direction.CW);
        canvas.clipPath(this.path);
        super.draw(canvas);
        if (this.nOI) {
            this.nOF.setColor(ap.getColor(this.nOG));
            float right = this.nOD.getRight();
            canvas.drawLine(right, this.jAz.getTop(), right, this.jAz.getBottom(), this.nOF);
        }
    }

    public void aP(boolean z) {
        if (z) {
            this.content = getResources().getString(R.string.followed);
            this.nOG = R.color.CAM_X0101;
            this.backgroundColor = R.color.CAM_X0904;
        } else {
            this.content = getResources().getString(R.string.attention);
            this.nOG = R.color.CAM_X0105;
            this.backgroundColor = R.color.CAM_X0901;
        }
        this.title.setText(this.content);
        requestLayout();
        onChangeSkinType(0);
        if (this.nOI && !this.nOH && z && !this.isOpen && this.msX != null) {
            this.msX.at(true, true);
        }
        this.nOH = false;
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
    public void rq(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bB(View view) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void h(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setOpenListener(final a aVar) {
        this.msX = aVar;
        this.nOE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FollowUserSpinnerBtn.1
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
        ap.setViewTextColor(this.title, this.nOG);
        this.drawable = SvgManager.btW().a(R.drawable.icon_pure_unfold12_svg, this.nOG, (SvgManager.SvgResourceStateType) null);
        this.jAz.setImageDrawable(this.drawable);
        invalidate();
    }

    public void setFirstUpdate(boolean z) {
        this.nOH = z;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public void setShowPullBtn(boolean z) {
        this.nOI = z;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.title.getLayoutParams();
        if (z) {
            this.nOE.setVisibility(0);
            layoutParams.leftMargin = nOC;
            layoutParams.rightMargin = aly;
            layoutParams.gravity = 16;
            layoutParams.width = -2;
        } else {
            this.nOE.setVisibility(8);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.gravity = 17;
            layoutParams.width = nOB;
        }
        this.title.setLayoutParams(layoutParams);
        requestLayout();
    }

    public ImageView getArrow() {
        return this.jAz;
    }
}
