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
    private RectF Gl;
    private int backgroundColor;
    private String content;
    private Drawable drawable;
    private ImageView iFc;
    private boolean isOpen;
    private a lwN;
    private FrameLayout mRu;
    private FrameLayout mRv;
    private Paint mRw;
    private int mRx;
    private boolean mRy;
    private boolean mRz;
    private Path path;
    private TextView title;
    private static final int mRs = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds224);
    private static final int mRt = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds58);
    private static final int akb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);

    /* loaded from: classes20.dex */
    public interface a {
        void au(boolean z, boolean z2);
    }

    public FollowUserSpinnerBtn(Context context) {
        this(context, null);
    }

    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRy = true;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.follow_user_spinner_btn_layout, this);
        setOrientation(0);
        this.mRu = (FrameLayout) findViewById(R.id.leftBox);
        this.mRv = (FrameLayout) findViewById(R.id.rightBox);
        this.title = (TextView) findViewById(R.id.title);
        this.iFc = (ImageView) findViewById(R.id.arrow);
        this.mRw = new Paint(1);
        this.mRw.setStyle(Paint.Style.STROKE);
        this.mRw.setStrokeCap(Paint.Cap.ROUND);
        this.mRw.setStrokeWidth(l.getDimens(context, R.dimen.tbds3));
        this.Gl = new RectF();
        this.path = new Path();
        this.mRx = R.color.cp_cont_b;
        this.drawable = SvgManager.bkl().a(R.drawable.icon_pure_unfold12_svg, this.mRx, (SvgManager.SvgResourceStateType) null);
        this.iFc.setImageDrawable(this.drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.Gl.set(0.0f, 0.0f, getWidth(), getHeight());
        this.path.reset();
        this.path.addRoundRect(this.Gl, getHeight() / 2, getHeight() / 2, Path.Direction.CW);
        canvas.clipPath(this.path);
        super.draw(canvas);
        if (this.mRz) {
            this.mRw.setColor(ap.getColor(this.mRx));
            float right = this.mRu.getRight();
            canvas.drawLine(right, this.iFc.getTop(), right, this.iFc.getBottom(), this.mRw);
        }
    }

    public void aN(boolean z) {
        if (z) {
            this.content = getResources().getString(R.string.followed);
            this.mRx = R.color.cp_cont_a;
            this.backgroundColor = R.color.cp_btn_j;
        } else {
            this.content = getResources().getString(R.string.attention);
            this.mRx = R.color.cp_cont_b;
            this.backgroundColor = R.color.cp_btn_a;
        }
        this.title.setText(this.content);
        requestLayout();
        onChangeSkinType(0);
        if (this.mRz && !this.mRy && z && !this.isOpen && this.lwN != null) {
            this.lwN.au(true, true);
        }
        this.mRy = false;
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        aN(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        r(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void py(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bm(View view) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setOpenListener(final a aVar) {
        this.lwN = aVar;
        this.mRv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FollowUserSpinnerBtn.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.au(!FollowUserSpinnerBtn.this.isOpen, false);
                }
            }
        });
    }

    public void onChangeSkinType(int i) {
        setBackgroundColor(ap.getColor(this.backgroundColor));
        ap.setViewTextColor(this.title, this.mRx);
        this.drawable = SvgManager.bkl().a(R.drawable.icon_pure_unfold12_svg, this.mRx, (SvgManager.SvgResourceStateType) null);
        this.iFc.setImageDrawable(this.drawable);
        invalidate();
    }

    public void setFirstUpdate(boolean z) {
        this.mRy = z;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public void setShowPullBtn(boolean z) {
        this.mRz = z;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.title.getLayoutParams();
        if (z) {
            this.mRv.setVisibility(0);
            layoutParams.leftMargin = mRt;
            layoutParams.rightMargin = akb;
            layoutParams.gravity = 16;
            layoutParams.width = -2;
        } else {
            this.mRv.setVisibility(8);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.gravity = 17;
            layoutParams.width = mRs;
        }
        this.title.setLayoutParams(layoutParams);
        requestLayout();
    }

    public ImageView getArrow() {
        return this.iFc;
    }
}
