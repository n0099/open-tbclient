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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.aj;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private View HS;
    private a bvA;
    private View.OnClickListener bzR;
    private View.OnLongClickListener bzS;
    private View.OnTouchListener bzT;
    private ak bzU;
    private final Queue<c> bzV;
    private View bzW;
    private ViewGroup.MarginLayoutParams bzX;

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HS = null;
        this.bzV = new LinkedList();
        this.bzX = new ViewGroup.MarginLayoutParams(-1, -2);
        this.bzW = com.baidu.adp.lib.g.b.ek().inflate(context, w.new_sub_pb_list_more, null);
        addView(this.bzW, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.bzR = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bzS = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.bzT = onTouchListener;
    }

    public void setSubPbAdapter(a aVar) {
        this.bvA = aVar;
    }

    public void a(ak akVar, View view) {
        this.bzU = akVar;
        requestLayout();
        this.HS = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.bvA == null || this.bzU == null || this.bzU.Ab() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<ak> Ab = this.bzU.Ab();
        int size2 = Ab.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size2) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.bzW)) {
                childAt = this.bvA.hA();
                this.bzV.offer(new c(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.bzR);
            view.setOnLongClickListener(this.bzS);
            view.setOnTouchListener(this.bzT);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(v.tag_load_sub_data) != this.bzU) {
                sparseArray.put(v.tag_load_sub_data, this.bzU);
            }
            sparseArray.put(v.tag_load_sub_view, this.HS);
            sparseArray.put(v.tag_is_subpb, true);
            if (Ab.get(i3) != null && Ab.get(i3).getAuthor() != null) {
                sparseArray.put(v.tag_photo_username, Ab.get(i3).getAuthor().getUserName());
                sparseArray.put(v.tag_clip_board, Ab.get(i3));
            }
            this.bvA.a((b) sparseArray.get(v.tag_holder), Ab.get(i3), this.bzU.Ai() > Ab.size() || Ab.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (Ab != null && this.bzU.Ai() > Ab.size()) {
            a(getContext(), (TextView) this.bzW.findViewById(v.sub_pb_more_text), this.bzU.Ai() - Ab.size());
            this.bzW.setOnClickListener(this.bzR);
            SparseArray sparseArray4 = (SparseArray) this.bzW.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.bzW.setTag(sparseArray4);
            }
            sparseArray4.put(v.tag_load_sub_data, this.bzU);
            sparseArray4.put(v.tag_load_sub_view, this.HS);
            this.bzW.setVisibility(0);
            this.bzW.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.bzW.setBackgroundColor(0);
        } else {
            this.bzW.setVisibility(8);
        }
        setMeasuredDimension(size, (this.bzW.getVisibility() == 0 ? this.bzW.getMeasuredHeight() : 0) + i4 + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.bzU != null && this.bzU.Ab() != null) {
            int size = this.bzV.size();
            for (int i6 = 0; i6 < size; i6++) {
                c poll = this.bzV.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.bzX, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int size2 = this.bzU.Ab().size();
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
            if (this.bzW.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bzW.getLayoutParams();
                int i10 = i8 + marginLayoutParams2.topMargin;
                this.bzW.layout(marginLayoutParams2.leftMargin + paddingLeft, i10, marginLayoutParams2.leftMargin + paddingLeft + this.bzW.getMeasuredWidth(), this.bzW.getMeasuredHeight() + i10);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = aj.wk().getApp().getString(y.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(com.baidu.tieba.s.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
        aw.b(textView, com.baidu.tieba.s.sub_pb_more_text, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.bzU != null && this.bzU.Ab() != null) {
            int size = this.bzU.Ab().size();
            for (int i = 0; i < size; i++) {
                if (size < getChildCount()) {
                    drawChild(canvas, getChildAt(i), drawingTime);
                }
            }
            if (this.bzW.getVisibility() == 0) {
                drawChild(canvas, this.bzW, drawingTime);
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
    /* renamed from: YG */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
