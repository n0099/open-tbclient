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
    private ba egk;
    private int esA;
    private com.baidu.tieba.tbadkCore.data.p esB;
    private final Queue<a> esC;
    private View esD;
    private ViewGroup.MarginLayoutParams esE;
    private View.OnClickListener esx;
    private View.OnLongClickListener esy;
    private View.OnTouchListener esz;
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
        this.esA = 0;
        this.mRootView = null;
        this.esC = new LinkedList();
        this.esE = new ViewGroup.MarginLayoutParams(-1, -2);
        this.esD = LayoutInflater.from(context).inflate(r.j.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.esD, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.esx = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.esy = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.esz = onTouchListener;
    }

    public void setSubPbAdapter(ba baVar) {
        this.egk = baVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.p pVar, View view) {
        this.esB = pVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<com.baidu.tieba.tbadkCore.data.p> bhN;
        SparseArray sparseArray;
        if (this.egk == null || this.esB == null || this.esB.bhN() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.esB.bhK()) {
            bhN = this.esB.bhJ();
        } else {
            bhN = this.esB.bhN();
        }
        int r = com.baidu.tbadk.core.util.w.r(bhN);
        this.esA = r;
        if (!this.esB.bhK()) {
            if (r <= 2) {
                this.esA = r;
            } else {
                this.esA = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.esA) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.esD)) {
                childAt = this.egk.kg();
                childAt.setPadding(0, 0, 0, (int) getResources().getDimension(r.f.ds18));
                this.esC.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.esx);
            view.setOnLongClickListener(this.esy);
            view.setOnTouchListener(this.esz);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(r.h.tag_load_sub_data) != this.esB) {
                sparseArray.put(r.h.tag_load_sub_data, this.esB);
            }
            sparseArray.put(r.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(r.h.tag_is_subpb, true);
            if (bhN.get(i3) != null && bhN.get(i3).getAuthor() != null) {
                sparseArray.put(r.h.tag_photo_username, bhN.get(i3).getAuthor().getUserName());
                sparseArray.put(r.h.tag_photo_userid, bhN.get(i3).getAuthor().getUserId());
                sparseArray.put(r.h.tag_clip_board, bhN.get(i3));
            }
            this.egk.a((ba.b) sparseArray.get(r.h.tag_holder), bhN.get(i3), this.esB.bhU() > bhN.size() || bhN.size() - i3 > 1, i3 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bhN != null && bhN.size() > 0 && this.esB.bhU() > this.esA) {
            a(getContext(), (TextView) this.esD.findViewById(r.h.sub_pb_more_text), this.esB.bhU() - this.esA);
            this.esD.setOnClickListener(this.esx);
            SparseArray sparseArray4 = (SparseArray) this.esD.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.esD.setTag(sparseArray4);
            }
            sparseArray4.put(r.h.tag_load_sub_data, this.esB);
            sparseArray4.put(r.h.tag_load_sub_view, this.mRootView);
            this.esD.setVisibility(0);
            this.esD.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.esD.setBackgroundColor(0);
        } else {
            this.esD.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.esD.getVisibility() == 0 ? this.esD.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.esB != null && this.esB.bhN() != null) {
            int size = this.esC.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.esC.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.esE, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.esA;
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
            if (this.esD.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.esD.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.esD.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.esD.getMeasuredWidth(), this.esD.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m9getInst().getApp().getString(r.l.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_c)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.ap.c(textView, r.e.cp_cont_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.esB != null && this.esB.bhN() != null) {
            int i = this.esA;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.esD.getVisibility() == 0) {
                drawChild(canvas, this.esD, drawingTime);
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
    /* renamed from: aPm */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
