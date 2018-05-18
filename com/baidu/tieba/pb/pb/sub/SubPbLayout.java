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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes2.dex */
public class SubPbLayout extends ViewGroup {
    private TextView bDn;
    private c fiL;
    private View.OnClickListener fvU;
    private View.OnLongClickListener fvV;
    private View.OnTouchListener fvW;
    private int fvX;
    private PostData fvY;
    private final Queue<a> fvZ;
    private RelativeLayout fwa;
    private ViewGroup.MarginLayoutParams fwb;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        int position;

        /* renamed from: view  reason: collision with root package name */
        View f16view;

        private a(int i, View view2) {
            this.position = i;
            this.f16view = view2;
        }
    }

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fvX = 0;
        this.mRootView = null;
        this.fvZ = new LinkedList();
        this.fwb = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fwa = new RelativeLayout(context);
        this.fwa.setId(d.g.pb_floor_reply_more);
        this.bDn = new TextView(context);
        this.bDn.setPadding(0, l.e(context, d.e.tbds14), 0, l.e(context, d.e.tbds22));
        this.bDn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.bDn.setTextSize(0, l.e(context, d.e.tbfontsize42));
        ak.h(this.bDn, d.C0126d.cp_cont_d);
        this.fwa.addView(this.bDn);
        addView(this.fwa, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fvU = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fvV = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fvW = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.fiL = cVar;
    }

    public void setData(PostData postData, View view2) {
        this.fvY = postData;
        requestLayout();
        this.mRootView = view2;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> brU;
        if (this.fiL == null || this.fvY == null || this.fvY.brU() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fvY.brT()) {
            brU = this.fvY.brQ();
        } else {
            brU = this.fvY.brU();
        }
        setMeasuredDimension(size, bq(v.v(brU), size) + l(brU, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int l(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.fvY.bsl() == 1) {
            this.fvX = 0;
            return 0;
        } else if (v.v(list) != 0) {
            int v = v.v(list);
            this.fvX = v;
            if (!this.fvY.brT()) {
                if (v <= 2) {
                    this.fvX = v;
                } else {
                    this.fvX = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.fvX) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.fwa)) {
                    childAt = this.fiL.kz();
                    childAt.setPadding(0, 0, 0, 0);
                    this.fvZ.offer(new a(i2, childAt));
                }
                View view2 = childAt;
                view2.setOnClickListener(this.fvU);
                view2.setOnLongClickListener(this.fvV);
                view2.setOnTouchListener(this.fvW);
                view2.setClickable(true);
                view2.setVisibility(0);
                SparseArray sparseArray2 = (SparseArray) view2.getTag();
                if (sparseArray2 == null) {
                    SparseArray sparseArray3 = new SparseArray();
                    view2.setTag(sparseArray3);
                    sparseArray = sparseArray3;
                } else {
                    sparseArray = sparseArray2;
                }
                if (sparseArray.get(d.g.tag_load_sub_data) != this.fvY) {
                    sparseArray.put(d.g.tag_load_sub_data, this.fvY);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).rP() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).rP().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).rP().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.fiL.a((c.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.fvY.bsb() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view2.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view2.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int bq(int i, int i2) {
        if (i > 0 && (this.fvY.bsl() == 1 || this.fvY.bsb() > this.fvX)) {
            this.bDn.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.k.sub_pb_load_more), Integer.valueOf(this.fvY.bsb())));
            this.fwa.setOnClickListener(this.fvU);
            SparseArray sparseArray = (SparseArray) this.fwa.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.fwa.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.fvY);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.fwa.setVisibility(0);
            this.fwa.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.fwa.setVisibility(8);
        }
        if (this.fwa.getVisibility() == 0) {
            return this.fwa.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fvY != null && this.fvY.brU() != null) {
            int size = this.fvZ.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.fvZ.poll();
                if (poll.f16view.getParent() == null) {
                    addViewInLayout(poll.f16view, poll.position, this.fwb, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fvX;
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
            if (this.fwa.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fwa.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.fwa.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.fwa.getMeasuredWidth(), this.fwa.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.fvX; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.fwa) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fvY != null && this.fvY.brU() != null) {
            int i = this.fvX;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.fwa.getVisibility() == 0) {
                drawChild(canvas, this.fwa, drawingTime);
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
    /* renamed from: bbN */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bDn != null) {
            this.bDn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_lou_more), (Drawable) null);
            ak.h(this.bDn, d.C0126d.cp_cont_d);
        }
    }
}
