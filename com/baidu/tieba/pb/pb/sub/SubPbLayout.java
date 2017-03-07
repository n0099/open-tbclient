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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private ba ejc;
    private View.OnClickListener evL;
    private View.OnLongClickListener evM;
    private View.OnTouchListener evN;
    private int evO;
    private PostData evP;
    private final Queue<a> evQ;
    private View evR;
    private ViewGroup.MarginLayoutParams evS;
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
        this.evO = 0;
        this.mRootView = null;
        this.evQ = new LinkedList();
        this.evS = new ViewGroup.MarginLayoutParams(-1, -2);
        this.evR = LayoutInflater.from(context).inflate(w.j.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.evR, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.evL = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.evM = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.evN = onTouchListener;
    }

    public void setSubPbAdapter(ba baVar) {
        this.ejc = baVar;
    }

    public void a(PostData postData, View view) {
        this.evP = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bhA;
        SparseArray sparseArray;
        if (this.ejc == null || this.evP == null || this.evP.bhA() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.evP.bhx()) {
            bhA = this.evP.bhw();
        } else {
            bhA = this.evP.bhA();
        }
        int p = com.baidu.tbadk.core.util.x.p(bhA);
        this.evO = p;
        if (!this.evP.bhx()) {
            if (p <= 2) {
                this.evO = p;
            } else {
                this.evO = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.evO) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.evR)) {
                childAt = this.ejc.la();
                childAt.setPadding(0, 0, 0, (int) getResources().getDimension(w.f.ds18));
                this.evQ.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.evL);
            view.setOnLongClickListener(this.evM);
            view.setOnTouchListener(this.evN);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(w.h.tag_load_sub_data) != this.evP) {
                sparseArray.put(w.h.tag_load_sub_data, this.evP);
            }
            sparseArray.put(w.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(w.h.tag_is_subpb, true);
            if (bhA.get(i3) != null && bhA.get(i3).getAuthor() != null) {
                sparseArray.put(w.h.tag_photo_username, bhA.get(i3).getAuthor().getUserName());
                sparseArray.put(w.h.tag_photo_userid, bhA.get(i3).getAuthor().getUserId());
                sparseArray.put(w.h.tag_clip_board, bhA.get(i3));
            }
            this.ejc.a((ba.b) sparseArray.get(w.h.tag_holder), bhA.get(i3), this.evP.bhH() > bhA.size() || bhA.size() - i3 > 1, i3 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bhA != null && bhA.size() > 0 && this.evP.bhH() > this.evO) {
            a(getContext(), (TextView) this.evR.findViewById(w.h.sub_pb_more_text), this.evP.bhH() - this.evO);
            this.evR.setOnClickListener(this.evL);
            SparseArray sparseArray4 = (SparseArray) this.evR.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.evR.setTag(sparseArray4);
            }
            sparseArray4.put(w.h.tag_load_sub_data, this.evP);
            sparseArray4.put(w.h.tag_load_sub_view, this.mRootView);
            this.evR.setVisibility(0);
            this.evR.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.evR.setBackgroundColor(0);
        } else {
            this.evR.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.evR.getVisibility() == 0 ? this.evR.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.evP != null && this.evP.bhA() != null) {
            int size = this.evQ.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.evQ.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.evS, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.evO;
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
            if (this.evR.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.evR.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.evR.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.evR.getMeasuredWidth(), this.evR.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_c)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.evP != null && this.evP.bhA() != null) {
            int i = this.evO;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.evR.getVisibility() == 0) {
                drawChild(canvas, this.evR, drawingTime);
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
    /* renamed from: aOD */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
