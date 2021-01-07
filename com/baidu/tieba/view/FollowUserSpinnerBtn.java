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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FollowUserSpinnerBtn extends LinearLayout implements com.baidu.tbadk.core.view.userLike.b {
    private int backgroundColor;
    private String content;
    private Drawable drawable;
    private boolean isOpen;
    private ImageView jNa;
    private a myl;
    private FrameLayout nSa;
    private FrameLayout nSb;
    private Paint nSc;
    private int nSd;
    private boolean nSe;
    private boolean nSf;
    private Path path;
    private RectF rectF;
    private TextView title;
    private static final int nRY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds224);
    private static final int nRZ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds58);
    private static final int ama = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);

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
        this.nSe = true;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.follow_user_spinner_btn_layout, this);
        setOrientation(0);
        this.nSa = (FrameLayout) findViewById(R.id.leftBox);
        this.nSb = (FrameLayout) findViewById(R.id.rightBox);
        this.title = (TextView) findViewById(R.id.title);
        this.jNa = (ImageView) findViewById(R.id.arrow);
        this.nSc = new Paint(1);
        this.nSc.setStyle(Paint.Style.STROKE);
        this.nSc.setStrokeCap(Paint.Cap.ROUND);
        this.nSc.setStrokeWidth(l.getDimens(context, R.dimen.tbds3));
        this.rectF = new RectF();
        this.path = new Path();
        this.nSd = R.color.CAM_X0105;
        this.drawable = SvgManager.bwr().a(R.drawable.icon_pure_unfold12_svg, this.nSd, (SvgManager.SvgResourceStateType) null);
        this.jNa.setImageDrawable(this.drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.rectF.set(0.0f, 0.0f, getWidth(), getHeight());
        this.path.reset();
        this.path.addRoundRect(this.rectF, getHeight() / 2, getHeight() / 2, Path.Direction.CW);
        canvas.clipPath(this.path);
        super.draw(canvas);
        if (this.nSf) {
            this.nSc.setColor(ao.getColor(this.nSd));
            float right = this.nSa.getRight();
            canvas.drawLine(right, this.jNa.getTop(), right, this.jNa.getBottom(), this.nSc);
        }
    }

    public void aM(boolean z) {
        if (z) {
            this.content = getResources().getString(R.string.followed);
            this.nSd = R.color.CAM_X0101;
            this.backgroundColor = R.color.CAM_X0904;
        } else {
            this.content = getResources().getString(R.string.attention);
            this.nSd = R.color.CAM_X0105;
            this.backgroundColor = R.color.CAM_X0901;
        }
        this.title.setText(this.content);
        requestLayout();
        onChangeSkinType(0);
        if (this.nSf && !this.nSe && z && !this.isOpen && this.myl != null) {
            this.myl.av(true, true);
        }
        this.nSe = false;
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
    public void rC(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bK(View view) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setOpenListener(final a aVar) {
        this.myl = aVar;
        this.nSb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.FollowUserSpinnerBtn.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.av(!FollowUserSpinnerBtn.this.isOpen, false);
                }
            }
        });
    }

    public void onChangeSkinType(int i) {
        setBackgroundColor(ao.getColor(this.backgroundColor));
        ao.setViewTextColor(this.title, this.nSd);
        this.drawable = SvgManager.bwr().a(R.drawable.icon_pure_unfold12_svg, this.nSd, (SvgManager.SvgResourceStateType) null);
        this.jNa.setImageDrawable(this.drawable);
        invalidate();
    }

    public void setFirstUpdate(boolean z) {
        this.nSe = z;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public void setShowPullBtn(boolean z) {
        this.nSf = z;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.title.getLayoutParams();
        if (z) {
            this.nSb.setVisibility(0);
            layoutParams.leftMargin = nRZ;
            layoutParams.rightMargin = ama;
            layoutParams.gravity = 16;
            layoutParams.width = -2;
        } else {
            this.nSb.setVisibility(8);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.gravity = 17;
            layoutParams.width = nRY;
        }
        this.title.setLayoutParams(layoutParams);
        requestLayout();
    }

    public ImageView getArrow() {
        return this.jNa;
    }
}
