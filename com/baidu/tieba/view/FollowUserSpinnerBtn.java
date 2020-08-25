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
/* loaded from: classes15.dex */
public class FollowUserSpinnerBtn extends LinearLayout implements com.baidu.tbadk.core.view.userLike.b {
    private RectF Gl;
    private int backgroundColor;
    private String content;
    private Drawable drawable;
    private boolean isOpen;
    private ImageView ixA;
    private a lnG;
    private FrameLayout mHq;
    private FrameLayout mHr;
    private Paint mHs;
    private int mHt;
    private boolean mHu;
    private boolean mHv;
    private Path path;
    private TextView title;
    private static final int mHo = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds224);
    private static final int mHp = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds58);
    private static final int ajB = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);

    /* loaded from: classes15.dex */
    public interface a {
        void as(boolean z, boolean z2);
    }

    public FollowUserSpinnerBtn(Context context) {
        this(context, null);
    }

    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHu = true;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.follow_user_spinner_btn_layout, this);
        setOrientation(0);
        this.mHq = (FrameLayout) findViewById(R.id.leftBox);
        this.mHr = (FrameLayout) findViewById(R.id.rightBox);
        this.title = (TextView) findViewById(R.id.title);
        this.ixA = (ImageView) findViewById(R.id.arrow);
        this.mHs = new Paint(1);
        this.mHs.setStyle(Paint.Style.STROKE);
        this.mHs.setStrokeCap(Paint.Cap.ROUND);
        this.mHs.setStrokeWidth(l.getDimens(context, R.dimen.tbds3));
        this.Gl = new RectF();
        this.path = new Path();
        this.mHt = R.color.cp_cont_b;
        this.drawable = SvgManager.bjq().a(R.drawable.icon_pure_unfold12_svg, this.mHt, (SvgManager.SvgResourceStateType) null);
        this.ixA.setImageDrawable(this.drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.Gl.set(0.0f, 0.0f, getWidth(), getHeight());
        this.path.reset();
        this.path.addRoundRect(this.Gl, getHeight() / 2, getHeight() / 2, Path.Direction.CW);
        canvas.clipPath(this.path);
        super.draw(canvas);
        if (this.mHv) {
            this.mHs.setColor(ap.getColor(this.mHt));
            float right = this.mHq.getRight();
            canvas.drawLine(right, this.ixA.getTop(), right, this.ixA.getBottom(), this.mHs);
        }
    }

    public void aN(boolean z) {
        if (z) {
            this.content = getResources().getString(R.string.followed);
            this.mHt = R.color.cp_cont_a;
            this.backgroundColor = R.color.cp_btn_j;
        } else {
            this.content = getResources().getString(R.string.attention);
            this.mHt = R.color.cp_cont_b;
            this.backgroundColor = R.color.cp_btn_a;
        }
        this.title.setText(this.content);
        requestLayout();
        onChangeSkinType(0);
        if (this.mHv && !this.mHu && z && !this.isOpen && this.lnG != null) {
            this.lnG.as(true, true);
        }
        this.mHu = false;
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
    public void pk(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bk(View view) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setOpenListener(final a aVar) {
        this.lnG = aVar;
        this.mHr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FollowUserSpinnerBtn.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.as(!FollowUserSpinnerBtn.this.isOpen, false);
                }
            }
        });
    }

    public void onChangeSkinType(int i) {
        setBackgroundColor(ap.getColor(this.backgroundColor));
        ap.setViewTextColor(this.title, this.mHt);
        this.drawable = SvgManager.bjq().a(R.drawable.icon_pure_unfold12_svg, this.mHt, (SvgManager.SvgResourceStateType) null);
        this.ixA.setImageDrawable(this.drawable);
        invalidate();
    }

    public void setFirstUpdate(boolean z) {
        this.mHu = z;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public void setShowPullBtn(boolean z) {
        this.mHv = z;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.title.getLayoutParams();
        if (z) {
            this.mHr.setVisibility(0);
            layoutParams.leftMargin = mHp;
            layoutParams.rightMargin = ajB;
            layoutParams.gravity = 16;
            layoutParams.width = -2;
        } else {
            this.mHr.setVisibility(8);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.gravity = 17;
            layoutParams.width = mHo;
        }
        this.title.setLayoutParams(layoutParams);
        requestLayout();
    }

    public ImageView getArrow() {
        return this.ixA;
    }
}
