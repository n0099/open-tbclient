package com.baidu.tieba.pb.sub;

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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.ad;
import com.baidu.tieba.data.ah;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private View.OnClickListener a;
    private View.OnLongClickListener b;
    private View.OnTouchListener c;
    private b d;
    private ah e;
    private View f;
    private Queue<d> g;
    private View h;
    private ViewGroup.MarginLayoutParams i;

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = null;
        this.g = new LinkedList();
        this.i = new ViewGroup.MarginLayoutParams(-1, -2);
        this.h = LayoutInflater.from(getContext()).inflate(com.baidu.tieba.s.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.h, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.a = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.c = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.d = bVar;
    }

    public void a(ah ahVar, View view) {
        this.e = ahVar;
        requestLayout();
        this.f = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.e == null || this.e.a().size() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i3 = i & 1073741823;
        ArrayList<ah> a = this.e.a();
        int size = a.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            View childAt = getChildAt(i4);
            if (childAt == null || childAt.equals(this.h)) {
                BdLog.d("SubPbLayout", "onMeasure", "Item View Created for position: " + i4);
                childAt = this.d.b();
                this.g.offer(new d(i4, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.a);
            view.setOnLongClickListener(this.b);
            view.setOnTouchListener(this.c);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(com.baidu.tieba.r.tag_load_sub_data) != this.e) {
                sparseArray.put(com.baidu.tieba.r.tag_load_sub_data, this.e);
            }
            sparseArray.put(com.baidu.tieba.r.tag_load_sub_view, this.f);
            sparseArray.put(com.baidu.tieba.r.tag_is_subpb, true);
            if (a.get(i4) != null && a.get(i4).g() != null) {
                sparseArray.put(com.baidu.tieba.r.tag_photo_username, a.get(i4).g().getUserName());
                sparseArray.put(com.baidu.tieba.r.tag_clip_board, a.get(i4));
            }
            this.d.a((c) sparseArray.get(com.baidu.tieba.r.tag_holder), a.get(i4), this.e.k() > a.size() || a.size() - i4 > 1, i4 == 0);
            view.measure(((i3 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i4++;
            i5 += view.getMeasuredHeight();
        }
        if (a != null && this.e.k() > a.size()) {
            a(getContext(), (TextView) this.h.findViewById(com.baidu.tieba.r.sub_pb_more_text), this.e.k() - a.size());
            this.h.setOnClickListener(this.a);
            SparseArray sparseArray4 = (SparseArray) this.h.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.h.setTag(sparseArray4);
            }
            sparseArray4.put(com.baidu.tieba.r.tag_load_sub_data, this.e);
            sparseArray4.put(com.baidu.tieba.r.tag_load_sub_view, this.f);
            this.h.setVisibility(0);
            this.h.measure(((i3 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.h.setBackgroundColor(0);
        } else {
            this.h.setVisibility(8);
        }
        setMeasuredDimension(i3, (this.h.getVisibility() == 0 ? this.h.getMeasuredHeight() : 0) + i5 + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.e != null) {
            int size = this.g.size();
            for (int i6 = 0; i6 < size; i6++) {
                d poll = this.g.poll();
                if (poll.b.getParent() == null) {
                    BdLog.d("SubPbLayout", "onLayout", "add to position: " + poll.a);
                    addViewInLayout(poll.b, poll.a, this.i, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int size2 = this.e.a().size();
            int i7 = 0;
            int i8 = paddingTop;
            while (i7 < size2) {
                View childAt = getChildAt(i7);
                if (childAt == null) {
                    i5 = i8;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    if (marginLayoutParams == null) {
                        marginLayoutParams = generateDefaultLayoutParams();
                    }
                    int i9 = i8 + marginLayoutParams.topMargin;
                    int measuredWidth = marginLayoutParams.leftMargin + paddingLeft + childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight() + i9;
                    childAt.layout(marginLayoutParams.leftMargin + paddingLeft, i9, measuredWidth, measuredHeight);
                    i5 = marginLayoutParams.bottomMargin + measuredHeight;
                }
                i7++;
                i8 = i5;
            }
            if (this.h.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
                int i10 = i8 + marginLayoutParams2.topMargin;
                this.h.layout(marginLayoutParams2.leftMargin + paddingLeft, i10, marginLayoutParams2.leftMargin + paddingLeft + this.h.getMeasuredWidth(), this.h.getMeasuredHeight() + i10);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = ad.c().d().getString(com.baidu.tieba.u.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(com.baidu.tieba.o.sub_pb_more_text_1)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(com.baidu.tieba.o.sub_pb_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(com.baidu.tieba.o.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(com.baidu.tieba.o.sub_pb_more_text));
        }
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        int size = this.e.a().size();
        for (int i = 0; i < size; i++) {
            drawChild(canvas, getChildAt(i), drawingTime);
        }
        if (this.h.getVisibility() == 0) {
            drawChild(canvas, this.h, drawingTime);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
