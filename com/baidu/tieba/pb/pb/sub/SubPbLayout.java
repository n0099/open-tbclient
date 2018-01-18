package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes2.dex */
public class SubPbLayout extends ViewGroup {
    private d fEY;
    private View.OnClickListener fXb;
    private View.OnLongClickListener fXc;
    private View.OnTouchListener fXd;
    private int fXe;
    private PostData fXf;
    private final Queue<a> fXg;
    private RelativeLayout fXh;
    private TextView fXi;
    private ViewGroup.MarginLayoutParams fXj;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        int position;
        View view;

        private a(int i, View view) {
            this.position = i;
            this.view = view;
        }
    }

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fXe = 0;
        this.mRootView = null;
        this.fXg = new LinkedList();
        this.fXj = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fXh = new RelativeLayout(context);
        this.fXh.setId(d.g.pb_floor_reply_more);
        this.fXi = new TextView(context);
        this.fXi.setPadding(0, l.s(context, d.e.tbds15), 0, l.s(context, d.e.tbds17));
        this.fXi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.fXi.setTextSize(0, l.s(context, d.e.tbfontsize33));
        aj.r(this.fXi, d.C0107d.cp_cont_d);
        this.fXh.addView(this.fXi);
        addView(this.fXh, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fXb = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fXc = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fXd = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.fEY = dVar;
    }

    public void a(PostData postData, View view) {
        this.fXf = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bvE;
        if (this.fEY == null || this.fXf == null || this.fXf.bvE() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fXf.bvC()) {
            bvE = this.fXf.bvz();
        } else {
            bvE = this.fXf.bvE();
        }
        setMeasuredDimension(size, cu(v.D(bvE), size) + q(bvE, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.fXf.bvY() == 1) {
            this.fXe = 0;
            return 0;
        } else if (v.D(list) != 0) {
            int D = v.D(list);
            this.fXe = D;
            if (!this.fXf.bvC()) {
                if (D <= 2) {
                    this.fXe = D;
                } else {
                    this.fXe = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.fXe) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.fXh)) {
                    childAt = this.fEY.su();
                    childAt.setPadding(0, 0, 0, 0);
                    this.fXg.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.fXb);
                view.setOnLongClickListener(this.fXc);
                view.setOnTouchListener(this.fXd);
                view.setClickable(true);
                view.setVisibility(0);
                SparseArray sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 == null) {
                    SparseArray sparseArray3 = new SparseArray();
                    view.setTag(sparseArray3);
                    sparseArray = sparseArray3;
                } else {
                    sparseArray = sparseArray2;
                }
                if (sparseArray.get(d.g.tag_load_sub_data) != this.fXf) {
                    sparseArray.put(d.g.tag_load_sub_data, this.fXf);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).yS() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).yS().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).yS().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.fEY.a((d.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.fXf.bvM() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cu(int i, int i2) {
        if (i > 0 && (this.fXf.bvY() == 1 || this.fXf.bvM() > this.fXe)) {
            this.fXi.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.fXf.bvM())));
            this.fXh.setOnClickListener(this.fXb);
            SparseArray sparseArray = (SparseArray) this.fXh.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.fXh.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.fXf);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.fXh.setVisibility(0);
            this.fXh.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.fXh.setVisibility(8);
        }
        if (this.fXh.getVisibility() == 0) {
            return this.fXh.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fXf != null && this.fXf.bvE() != null) {
            int size = this.fXg.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.fXg.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.fXj, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fXe;
            int i8 = 0;
            int i9 = paddingTop;
            while (i8 < i7) {
                View childAt = getChildAt(i8);
                if (childAt == null) {
                    i5 = i9;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    if (marginLayoutParams == null) {
                        marginLayoutParams = generateDefaultLayoutParams();
                    }
                    int i10 = i9 + marginLayoutParams.topMargin;
                    int measuredWidth = marginLayoutParams.leftMargin + paddingLeft + childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight() + i10;
                    childAt.layout(marginLayoutParams.leftMargin + paddingLeft, i10, measuredWidth, measuredHeight);
                    i5 = marginLayoutParams.bottomMargin + measuredHeight;
                }
                i8++;
                i9 = i5;
            }
            if (this.fXh.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fXh.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.fXh.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.fXh.getMeasuredWidth(), this.fXh.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.fXe; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.fXh) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fXf != null && this.fXf.bvE() != null) {
            int i = this.fXe;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.fXh.getVisibility() == 0) {
                drawChild(canvas, this.fXh, drawingTime);
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: bfj */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.fXi != null) {
            this.fXi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
            aj.r(this.fXi, d.C0107d.cp_cont_d);
        }
    }
}
