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
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private ba dXE;
    private View.OnClickListener ejn;
    private View.OnLongClickListener ejo;
    private View.OnTouchListener ejp;
    private int ejq;
    private com.baidu.tieba.tbadkCore.data.q ejr;
    private final Queue<a> ejs;
    private View ejt;
    private ViewGroup.MarginLayoutParams eju;
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
        this.ejq = 0;
        this.mRootView = null;
        this.ejs = new LinkedList();
        this.eju = new ViewGroup.MarginLayoutParams(-1, -2);
        this.ejt = LayoutInflater.from(context).inflate(r.h.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.ejt, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.ejn = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ejo = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.ejp = onTouchListener;
    }

    public void setSubPbAdapter(ba baVar) {
        this.dXE = baVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.q qVar, View view) {
        this.ejr = qVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> bfX;
        SparseArray sparseArray;
        if (this.dXE == null || this.ejr == null || this.ejr.bfX() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.ejr.bfU()) {
            bfX = this.ejr.bfT();
        } else {
            bfX = this.ejr.bfX();
        }
        int s = com.baidu.tbadk.core.util.x.s(bfX);
        this.ejq = s;
        if (!this.ejr.bfU()) {
            if (s <= 2) {
                this.ejq = s;
            } else {
                this.ejq = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.ejq) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.ejt)) {
                childAt = this.dXE.kk();
                childAt.setPadding(0, 0, 0, (int) getResources().getDimension(r.e.ds18));
                this.ejs.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.ejn);
            view.setOnLongClickListener(this.ejo);
            view.setOnTouchListener(this.ejp);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(r.g.tag_load_sub_data) != this.ejr) {
                sparseArray.put(r.g.tag_load_sub_data, this.ejr);
            }
            sparseArray.put(r.g.tag_load_sub_view, this.mRootView);
            sparseArray.put(r.g.tag_is_subpb, true);
            if (bfX.get(i3) != null && bfX.get(i3).getAuthor() != null) {
                sparseArray.put(r.g.tag_photo_username, bfX.get(i3).getAuthor().getUserName());
                sparseArray.put(r.g.tag_photo_userid, bfX.get(i3).getAuthor().getUserId());
                sparseArray.put(r.g.tag_clip_board, bfX.get(i3));
            }
            this.dXE.a((ba.b) sparseArray.get(r.g.tag_holder), bfX.get(i3), this.ejr.bge() > bfX.size() || bfX.size() - i3 > 1, i3 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bfX != null && bfX.size() > 0 && this.ejr.bge() > this.ejq) {
            a(getContext(), (TextView) this.ejt.findViewById(r.g.sub_pb_more_text), this.ejr.bge() - this.ejq);
            this.ejt.setOnClickListener(this.ejn);
            SparseArray sparseArray4 = (SparseArray) this.ejt.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.ejt.setTag(sparseArray4);
            }
            sparseArray4.put(r.g.tag_load_sub_data, this.ejr);
            sparseArray4.put(r.g.tag_load_sub_view, this.mRootView);
            this.ejt.setVisibility(0);
            this.ejt.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.ejt.setBackgroundColor(0);
        } else {
            this.ejt.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.ejt.getVisibility() == 0 ? this.ejt.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.ejr != null && this.ejr.bfX() != null) {
            int size = this.ejs.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.ejs.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.eju, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.ejq;
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
            if (this.ejt.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ejt.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.ejt.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.ejt.getMeasuredWidth(), this.ejt.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m9getInst().getApp().getString(r.j.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_c)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.ar.c(textView, r.d.cp_cont_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.ejr != null && this.ejr.bfX() != null) {
            int i = this.ejq;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.ejt.getVisibility() == 0) {
                drawChild(canvas, this.ejt, drawingTime);
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
    /* renamed from: aNq */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
