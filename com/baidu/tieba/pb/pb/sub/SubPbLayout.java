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
    private d fIF;
    private TextView gaA;
    private ViewGroup.MarginLayoutParams gaB;
    private View.OnClickListener gat;
    private View.OnLongClickListener gau;
    private View.OnTouchListener gav;
    private int gaw;
    private PostData gax;
    private final Queue<a> gay;
    private RelativeLayout gaz;
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
        this.gaw = 0;
        this.mRootView = null;
        this.gay = new LinkedList();
        this.gaB = new ViewGroup.MarginLayoutParams(-1, -2);
        this.gaz = new RelativeLayout(context);
        this.gaz.setId(d.g.pb_floor_reply_more);
        this.gaA = new TextView(context);
        this.gaA.setPadding(0, l.t(context, d.e.tbds14), 0, l.t(context, d.e.tbds22));
        this.gaA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.gaA.setTextSize(0, l.t(context, d.e.tbfontsize42));
        aj.r(this.gaA, d.C0141d.cp_cont_d);
        this.gaz.addView(this.gaA);
        addView(this.gaz, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.gat = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.gau = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.gav = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.fIF = dVar;
    }

    public void a(PostData postData, View view) {
        this.gax = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bwQ;
        if (this.fIF == null || this.gax == null || this.gax.bwQ() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.gax.bwP()) {
            bwQ = this.gax.bwM();
        } else {
            bwQ = this.gax.bwQ();
        }
        setMeasuredDimension(size, cq(v.D(bwQ), size) + p(bwQ, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int p(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.gax.bxi() == 1) {
            this.gaw = 0;
            return 0;
        } else if (v.D(list) != 0) {
            int D = v.D(list);
            this.gaw = D;
            if (!this.gax.bwP()) {
                if (D <= 2) {
                    this.gaw = D;
                } else {
                    this.gaw = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.gaw) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.gaz)) {
                    childAt = this.fIF.st();
                    childAt.setPadding(0, 0, 0, 0);
                    this.gay.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.gat);
                view.setOnLongClickListener(this.gau);
                view.setOnTouchListener(this.gav);
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
                if (sparseArray.get(d.g.tag_load_sub_data) != this.gax) {
                    sparseArray.put(d.g.tag_load_sub_data, this.gax);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).zn() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).zn().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).zn().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.fIF.a((d.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.gax.bwY() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cq(int i, int i2) {
        if (i > 0 && (this.gax.bxi() == 1 || this.gax.bwY() > this.gaw)) {
            this.gaA.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.gax.bwY())));
            this.gaz.setOnClickListener(this.gat);
            SparseArray sparseArray = (SparseArray) this.gaz.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.gaz.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.gax);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.gaz.setVisibility(0);
            this.gaz.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.gaz.setVisibility(8);
        }
        if (this.gaz.getVisibility() == 0) {
            return this.gaz.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.gax != null && this.gax.bwQ() != null) {
            int size = this.gay.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.gay.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.gaB, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.gaw;
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
            if (this.gaz.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gaz.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.gaz.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.gaz.getMeasuredWidth(), this.gaz.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.gaw; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.gaz) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.gax != null && this.gax.bwQ() != null) {
            int i = this.gaw;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.gaz.getVisibility() == 0) {
                drawChild(canvas, this.gaz, drawingTime);
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
    /* renamed from: bgN */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.gaA != null) {
            this.gaA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
            aj.r(this.gaA, d.C0141d.cp_cont_d);
        }
    }
}
