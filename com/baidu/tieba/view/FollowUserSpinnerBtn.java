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
    private ImageView jAB;
    private a msZ;
    private FrameLayout nOF;
    private FrameLayout nOG;
    private Paint nOH;
    private int nOI;
    private boolean nOJ;
    private boolean nOK;
    private Path path;
    private TextView title;
    private static final int nOD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds224);
    private static final int nOE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds58);
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
        this.nOJ = true;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.follow_user_spinner_btn_layout, this);
        setOrientation(0);
        this.nOF = (FrameLayout) findViewById(R.id.leftBox);
        this.nOG = (FrameLayout) findViewById(R.id.rightBox);
        this.title = (TextView) findViewById(R.id.title);
        this.jAB = (ImageView) findViewById(R.id.arrow);
        this.nOH = new Paint(1);
        this.nOH.setStyle(Paint.Style.STROKE);
        this.nOH.setStrokeCap(Paint.Cap.ROUND);
        this.nOH.setStrokeWidth(l.getDimens(context, R.dimen.tbds3));
        this.Hx = new RectF();
        this.path = new Path();
        this.nOI = R.color.CAM_X0105;
        this.drawable = SvgManager.btW().a(R.drawable.icon_pure_unfold12_svg, this.nOI, (SvgManager.SvgResourceStateType) null);
        this.jAB.setImageDrawable(this.drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.Hx.set(0.0f, 0.0f, getWidth(), getHeight());
        this.path.reset();
        this.path.addRoundRect(this.Hx, getHeight() / 2, getHeight() / 2, Path.Direction.CW);
        canvas.clipPath(this.path);
        super.draw(canvas);
        if (this.nOK) {
            this.nOH.setColor(ap.getColor(this.nOI));
            float right = this.nOF.getRight();
            canvas.drawLine(right, this.jAB.getTop(), right, this.jAB.getBottom(), this.nOH);
        }
    }

    public void aP(boolean z) {
        if (z) {
            this.content = getResources().getString(R.string.followed);
            this.nOI = R.color.CAM_X0101;
            this.backgroundColor = R.color.CAM_X0904;
        } else {
            this.content = getResources().getString(R.string.attention);
            this.nOI = R.color.CAM_X0105;
            this.backgroundColor = R.color.CAM_X0901;
        }
        this.title.setText(this.content);
        requestLayout();
        onChangeSkinType(0);
        if (this.nOK && !this.nOJ && z && !this.isOpen && this.msZ != null) {
            this.msZ.at(true, true);
        }
        this.nOJ = false;
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
        this.msZ = aVar;
        this.nOG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FollowUserSpinnerBtn.1
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
        ap.setViewTextColor(this.title, this.nOI);
        this.drawable = SvgManager.btW().a(R.drawable.icon_pure_unfold12_svg, this.nOI, (SvgManager.SvgResourceStateType) null);
        this.jAB.setImageDrawable(this.drawable);
        invalidate();
    }

    public void setFirstUpdate(boolean z) {
        this.nOJ = z;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public void setShowPullBtn(boolean z) {
        this.nOK = z;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.title.getLayoutParams();
        if (z) {
            this.nOG.setVisibility(0);
            layoutParams.leftMargin = nOE;
            layoutParams.rightMargin = aly;
            layoutParams.gravity = 16;
            layoutParams.width = -2;
        } else {
            this.nOG.setVisibility(8);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.gravity = 17;
            layoutParams.width = nOD;
        }
        this.title.setLayoutParams(layoutParams);
        requestLayout();
    }

    public ImageView getArrow() {
        return this.jAB;
    }
}
