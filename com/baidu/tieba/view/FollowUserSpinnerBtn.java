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
    private RectF GD;
    private int backgroundColor;
    private String content;
    private Drawable drawable;
    private boolean isOpen;
    private ImageView jmm;
    private a mez;
    private FrameLayout nzu;
    private FrameLayout nzv;
    private Paint nzw;
    private int nzx;
    private boolean nzy;
    private boolean nzz;
    private Path path;
    private TextView title;
    private static final int nzs = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds224);
    private static final int nzt = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds58);
    private static final int aku = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);

    /* loaded from: classes21.dex */
    public interface a {
        void aw(boolean z, boolean z2);
    }

    public FollowUserSpinnerBtn(Context context) {
        this(context, null);
    }

    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nzy = true;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.follow_user_spinner_btn_layout, this);
        setOrientation(0);
        this.nzu = (FrameLayout) findViewById(R.id.leftBox);
        this.nzv = (FrameLayout) findViewById(R.id.rightBox);
        this.title = (TextView) findViewById(R.id.title);
        this.jmm = (ImageView) findViewById(R.id.arrow);
        this.nzw = new Paint(1);
        this.nzw.setStyle(Paint.Style.STROKE);
        this.nzw.setStrokeCap(Paint.Cap.ROUND);
        this.nzw.setStrokeWidth(l.getDimens(context, R.dimen.tbds3));
        this.GD = new RectF();
        this.path = new Path();
        this.nzx = R.color.cp_cont_b;
        this.drawable = SvgManager.brn().a(R.drawable.icon_pure_unfold12_svg, this.nzx, (SvgManager.SvgResourceStateType) null);
        this.jmm.setImageDrawable(this.drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.GD.set(0.0f, 0.0f, getWidth(), getHeight());
        this.path.reset();
        this.path.addRoundRect(this.GD, getHeight() / 2, getHeight() / 2, Path.Direction.CW);
        canvas.clipPath(this.path);
        super.draw(canvas);
        if (this.nzz) {
            this.nzw.setColor(ap.getColor(this.nzx));
            float right = this.nzu.getRight();
            canvas.drawLine(right, this.jmm.getTop(), right, this.jmm.getBottom(), this.nzw);
        }
    }

    public void aN(boolean z) {
        if (z) {
            this.content = getResources().getString(R.string.followed);
            this.nzx = R.color.cp_cont_a;
            this.backgroundColor = R.color.cp_btn_j;
        } else {
            this.content = getResources().getString(R.string.attention);
            this.nzx = R.color.cp_cont_b;
            this.backgroundColor = R.color.cp_btn_a;
        }
        this.title.setText(this.content);
        requestLayout();
        onChangeSkinType(0);
        if (this.nzz && !this.nzy && z && !this.isOpen && this.mez != null) {
            this.mez.aw(true, true);
        }
        this.nzy = false;
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void s(boolean z, int i) {
        aN(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        s(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void qr(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bv(View view) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void h(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setOpenListener(final a aVar) {
        this.mez = aVar;
        this.nzv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FollowUserSpinnerBtn.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.aw(!FollowUserSpinnerBtn.this.isOpen, false);
                }
            }
        });
    }

    public void onChangeSkinType(int i) {
        setBackgroundColor(ap.getColor(this.backgroundColor));
        ap.setViewTextColor(this.title, this.nzx);
        this.drawable = SvgManager.brn().a(R.drawable.icon_pure_unfold12_svg, this.nzx, (SvgManager.SvgResourceStateType) null);
        this.jmm.setImageDrawable(this.drawable);
        invalidate();
    }

    public void setFirstUpdate(boolean z) {
        this.nzy = z;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public void setShowPullBtn(boolean z) {
        this.nzz = z;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.title.getLayoutParams();
        if (z) {
            this.nzv.setVisibility(0);
            layoutParams.leftMargin = nzt;
            layoutParams.rightMargin = aku;
            layoutParams.gravity = 16;
            layoutParams.width = -2;
        } else {
            this.nzv.setVisibility(8);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.gravity = 17;
            layoutParams.width = nzs;
        }
        this.title.setLayoutParams(layoutParams);
        requestLayout();
    }

    public ImageView getArrow() {
        return this.jmm;
    }
}
