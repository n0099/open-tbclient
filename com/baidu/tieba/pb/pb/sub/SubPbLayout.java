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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.sub.am;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private am cDY;
    private View.OnClickListener cLN;
    private View.OnLongClickListener cLO;
    private View.OnTouchListener cLP;
    private int cLQ;
    private com.baidu.tieba.tbadkCore.data.r cLR;
    private final Queue<a> cLS;
    private View cLT;
    private ViewGroup.MarginLayoutParams cLU;
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
        this.cLQ = 0;
        this.mRootView = null;
        this.cLS = new LinkedList();
        this.cLU = new ViewGroup.MarginLayoutParams(-1, -2);
        this.cLT = LayoutInflater.from(context).inflate(n.h.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.cLT, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.cLN = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cLO = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.cLP = onTouchListener;
    }

    public void setSubPbAdapter(am amVar) {
        this.cDY = amVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.r rVar, View view) {
        this.cLR = rVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.cDY == null || this.cLR == null || this.cLR.aFm() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.data.r> aFm = this.cLR.aFm();
        int size2 = aFm.size();
        if (this.cLR.aFy()) {
            this.cLR.ht(true);
            if (size2 <= 10) {
                this.cLQ = size2;
            } else {
                this.cLQ = 10;
            }
        } else {
            this.cLR.ht(false);
            if (size2 <= 2) {
                this.cLQ = size2;
            } else {
                this.cLQ = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.cLQ) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.cLT)) {
                childAt = this.cDY.mT();
                this.cLS.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.cLN);
            view.setOnLongClickListener(this.cLO);
            view.setOnTouchListener(this.cLP);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(n.g.tag_load_sub_data) != this.cLR) {
                sparseArray.put(n.g.tag_load_sub_data, this.cLR);
            }
            sparseArray.put(n.g.tag_load_sub_view, this.mRootView);
            sparseArray.put(n.g.tag_is_subpb, true);
            if (aFm.get(i3) != null && aFm.get(i3).getAuthor() != null) {
                sparseArray.put(n.g.tag_photo_username, aFm.get(i3).getAuthor().getUserName());
                sparseArray.put(n.g.tag_clip_board, aFm.get(i3));
            }
            this.cDY.a((am.a) sparseArray.get(n.g.tag_holder), aFm.get(i3), this.cLR.aFu() > aFm.size() || aFm.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (aFm != null && aFm.size() > 0 && this.cLR.aFu() > this.cLQ) {
            a(getContext(), (TextView) this.cLT.findViewById(n.g.sub_pb_more_text), this.cLR.aFu() - this.cLQ);
            this.cLT.setOnClickListener(this.cLN);
            SparseArray sparseArray4 = (SparseArray) this.cLT.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.cLT.setTag(sparseArray4);
            }
            sparseArray4.put(n.g.tag_load_sub_data, this.cLR);
            sparseArray4.put(n.g.tag_load_sub_view, this.mRootView);
            this.cLT.setVisibility(0);
            this.cLT.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.cLT.setBackgroundColor(0);
        } else {
            this.cLT.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.cLT.getVisibility() == 0 ? this.cLT.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.cLR != null && this.cLR.aFm() != null) {
            int size = this.cLS.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.cLS.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.cLU, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.cLQ;
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
            if (this.cLT.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cLT.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.cLT.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.cLT.getMeasuredWidth(), this.cLT.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m411getInst().getApp().getString(n.j.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(as.getColor(n.d.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        as.b(textView, n.d.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.cLR != null && this.cLR.aFm() != null) {
            int i = this.cLQ;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.cLT.getVisibility() == 0) {
                drawChild(canvas, this.cLT, drawingTime);
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
    /* renamed from: anQ */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
