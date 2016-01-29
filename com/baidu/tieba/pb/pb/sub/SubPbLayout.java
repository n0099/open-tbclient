package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.pb.pb.sub.am;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private am cLr;
    private final Queue<a> cUA;
    private View cUB;
    private ViewGroup.MarginLayoutParams cUC;
    private View.OnClickListener cUv;
    private View.OnLongClickListener cUw;
    private View.OnTouchListener cUx;
    private int cUy;
    private com.baidu.tieba.tbadkCore.data.r cUz;
    private View mRootView;

    /* loaded from: classes.dex */
    private static class a {
        int position;
        View view;

        private a(int i, View view) {
            this.position = i;
            this.view = view;
        }

        /* synthetic */ a(int i, View view, a aVar) {
            this(i, view);
        }
    }

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cUy = 0;
        this.mRootView = null;
        this.cUA = new LinkedList();
        this.cUC = new ViewGroup.MarginLayoutParams(-1, -2);
        this.cUB = LayoutInflater.from(context).inflate(t.h.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.cUB, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.cUv = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cUw = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.cUx = onTouchListener;
    }

    public void setSubPbAdapter(am amVar) {
        this.cLr = amVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.r rVar, View view) {
        this.cUz = rVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.cLr == null || this.cUz == null || this.cUz.aMs() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.data.r> aMs = this.cUz.aMs();
        int size2 = aMs.size();
        if (this.cUz.aMD()) {
            this.cUz.hU(true);
            if (size2 <= 10) {
                this.cUy = size2;
            } else {
                this.cUy = 10;
            }
        } else {
            this.cUz.hU(false);
            if (size2 <= 2) {
                this.cUy = size2;
            } else {
                this.cUy = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.cUy) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.cUB)) {
                childAt = this.cLr.ni();
                this.cUA.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.cUv);
            view.setOnLongClickListener(this.cUw);
            view.setOnTouchListener(this.cUx);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(t.g.tag_load_sub_data) != this.cUz) {
                sparseArray.put(t.g.tag_load_sub_data, this.cUz);
            }
            sparseArray.put(t.g.tag_load_sub_view, this.mRootView);
            sparseArray.put(t.g.tag_is_subpb, true);
            if (aMs.get(i3) != null && aMs.get(i3).getAuthor() != null) {
                sparseArray.put(t.g.tag_photo_username, aMs.get(i3).getAuthor().getUserName());
                sparseArray.put(t.g.tag_clip_board, aMs.get(i3));
            }
            this.cLr.a((am.a) sparseArray.get(t.g.tag_holder), aMs.get(i3), this.cUz.aMz() > aMs.size() || aMs.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (aMs != null && aMs.size() > 0 && this.cUz.aMz() > this.cUy) {
            a(getContext(), (TextView) this.cUB.findViewById(t.g.sub_pb_more_text), this.cUz.aMz() - this.cUy);
            this.cUB.setOnClickListener(this.cUv);
            SparseArray sparseArray4 = (SparseArray) this.cUB.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.cUB.setTag(sparseArray4);
            }
            sparseArray4.put(t.g.tag_load_sub_data, this.cUz);
            sparseArray4.put(t.g.tag_load_sub_view, this.mRootView);
            this.cUB.setVisibility(0);
            this.cUB.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.cUB.setBackgroundColor(0);
        } else {
            this.cUB.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.cUB.getVisibility() == 0 ? this.cUB.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.cUz != null && this.cUz.aMs() != null) {
            int size = this.cUA.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.cUA.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.cUC, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.cUy;
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
            if (this.cUB.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cUB.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.cUB.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.cUB.getMeasuredWidth(), this.cUB.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m411getInst().getApp().getString(t.j.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(ar.getColor(t.d.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        ar.b(textView, t.d.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.cUz != null && this.cUz.aMs() != null) {
            int i = this.cUy;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.cUB.getVisibility() == 0) {
                drawChild(canvas, this.cUB, drawingTime);
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
    /* renamed from: asv */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
