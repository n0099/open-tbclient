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
    private d fFt;
    private PostData fXA;
    private final Queue<a> fXB;
    private RelativeLayout fXC;
    private TextView fXD;
    private ViewGroup.MarginLayoutParams fXE;
    private View.OnClickListener fXw;
    private View.OnLongClickListener fXx;
    private View.OnTouchListener fXy;
    private int fXz;
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
        this.fXz = 0;
        this.mRootView = null;
        this.fXB = new LinkedList();
        this.fXE = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fXC = new RelativeLayout(context);
        this.fXC.setId(d.g.pb_floor_reply_more);
        this.fXD = new TextView(context);
        this.fXD.setPadding(0, l.s(context, d.e.tbds15), 0, l.s(context, d.e.tbds17));
        this.fXD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.fXD.setTextSize(0, l.s(context, d.e.tbfontsize33));
        aj.r(this.fXD, d.C0108d.cp_cont_d);
        this.fXC.addView(this.fXD);
        addView(this.fXC, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fXw = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fXx = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fXy = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.fFt = dVar;
    }

    public void a(PostData postData, View view) {
        this.fXA = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bvG;
        if (this.fFt == null || this.fXA == null || this.fXA.bvG() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fXA.bvE()) {
            bvG = this.fXA.bvB();
        } else {
            bvG = this.fXA.bvG();
        }
        setMeasuredDimension(size, cu(v.D(bvG), size) + q(bvG, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.fXA.bwa() == 1) {
            this.fXz = 0;
            return 0;
        } else if (v.D(list) != 0) {
            int D = v.D(list);
            this.fXz = D;
            if (!this.fXA.bvE()) {
                if (D <= 2) {
                    this.fXz = D;
                } else {
                    this.fXz = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.fXz) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.fXC)) {
                    childAt = this.fFt.sv();
                    childAt.setPadding(0, 0, 0, 0);
                    this.fXB.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.fXw);
                view.setOnLongClickListener(this.fXx);
                view.setOnTouchListener(this.fXy);
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
                if (sparseArray.get(d.g.tag_load_sub_data) != this.fXA) {
                    sparseArray.put(d.g.tag_load_sub_data, this.fXA);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).yT() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).yT().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).yT().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.fFt.a((d.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.fXA.bvO() > list.size() || list.size() - i2 > 1, i2 == 0, false);
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
        if (i > 0 && (this.fXA.bwa() == 1 || this.fXA.bvO() > this.fXz)) {
            this.fXD.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.fXA.bvO())));
            this.fXC.setOnClickListener(this.fXw);
            SparseArray sparseArray = (SparseArray) this.fXC.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.fXC.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.fXA);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.fXC.setVisibility(0);
            this.fXC.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.fXC.setVisibility(8);
        }
        if (this.fXC.getVisibility() == 0) {
            return this.fXC.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fXA != null && this.fXA.bvG() != null) {
            int size = this.fXB.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.fXB.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.fXE, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fXz;
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
            if (this.fXC.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fXC.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.fXC.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.fXC.getMeasuredWidth(), this.fXC.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.fXz; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.fXC) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fXA != null && this.fXA.bvG() != null) {
            int i = this.fXz;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.fXC.getVisibility() == 0) {
                drawChild(canvas, this.fXC, drawingTime);
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
    /* renamed from: bfo */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.fXD != null) {
            this.fXD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
            aj.r(this.fXD, d.C0108d.cp_cont_d);
        }
    }
}
