package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.an;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private View.OnClickListener a;
    private View.OnLongClickListener b;
    private View.OnTouchListener c;
    private a d;
    private an e;
    private View f;
    private final Queue<c> g;
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
        this.h = com.baidu.adp.lib.e.b.a().a(context, v.new_sub_pb_list_more, null);
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

    public void setSubPbAdapter(a aVar) {
        this.d = aVar;
    }

    public void a(an anVar, View view) {
        this.e = anVar;
        requestLayout();
        this.f = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.d == null || this.e == null || this.e.n_() == null || this.e.n_().size() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<an> n_ = this.e.n_();
        int size2 = n_.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size2) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.h)) {
                childAt = this.d.a();
                this.g.offer(new c(i3, childAt, null));
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
            if (sparseArray.get(u.tag_load_sub_data) != this.e) {
                sparseArray.put(u.tag_load_sub_data, this.e);
            }
            sparseArray.put(u.tag_load_sub_view, this.f);
            sparseArray.put(u.tag_is_subpb, true);
            if (n_.get(i3) != null && n_.get(i3).g() != null) {
                sparseArray.put(u.tag_photo_username, n_.get(i3).g().getUserName());
                sparseArray.put(u.tag_clip_board, n_.get(i3));
            }
            this.d.a((b) sparseArray.get(u.tag_holder), n_.get(i3), this.e.l() > n_.size() || n_.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (n_ != null && this.e.l() > n_.size()) {
            a(getContext(), (TextView) this.h.findViewById(u.sub_pb_more_text), this.e.l() - n_.size());
            this.h.setOnClickListener(this.a);
            SparseArray sparseArray4 = (SparseArray) this.h.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.h.setTag(sparseArray4);
            }
            sparseArray4.put(u.tag_load_sub_data, this.e);
            sparseArray4.put(u.tag_load_sub_view, this.f);
            this.h.setVisibility(0);
            this.h.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.h.setBackgroundColor(0);
        } else {
            this.h.setVisibility(8);
        }
        setMeasuredDimension(size, (this.h.getVisibility() == 0 ? this.h.getMeasuredHeight() : 0) + i4 + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.e != null && this.e.n_() != null) {
            int size = this.g.size();
            for (int i6 = 0; i6 < size; i6++) {
                c poll = this.g.poll();
                if (poll.b.getParent() == null) {
                    addViewInLayout(poll.b, poll.a, this.i, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int size2 = this.e.n_().size();
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
        String string = ai.c().d().getString(x.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(com.baidu.tieba.r.sub_pb_more_text_1)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(com.baidu.tieba.r.sub_pb_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(com.baidu.tieba.r.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(com.baidu.tieba.r.sub_pb_more_text));
        }
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.e != null && this.e.n_() != null) {
            int size = this.e.n_().size();
            for (int i = 0; i < size; i++) {
                if (size < getChildCount()) {
                    drawChild(canvas, getChildAt(i), drawingTime);
                }
            }
            if (this.h.getVisibility() == 0) {
                drawChild(canvas, this.h, drawingTime);
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
    /* renamed from: a */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
