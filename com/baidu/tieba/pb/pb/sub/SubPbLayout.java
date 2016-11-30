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
    private View.OnClickListener eFn;
    private View.OnLongClickListener eFo;
    private View.OnTouchListener eFp;
    private int eFq;
    private com.baidu.tieba.tbadkCore.data.q eFr;
    private final Queue<a> eFs;
    private View eFt;
    private ViewGroup.MarginLayoutParams eFu;
    private ba etj;
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
        this.eFq = 0;
        this.mRootView = null;
        this.eFs = new LinkedList();
        this.eFu = new ViewGroup.MarginLayoutParams(-1, -2);
        this.eFt = LayoutInflater.from(context).inflate(r.h.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.eFt, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.eFn = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.eFo = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eFp = onTouchListener;
    }

    public void setSubPbAdapter(ba baVar) {
        this.etj = baVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.q qVar, View view) {
        this.eFr = qVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> bmi;
        SparseArray sparseArray;
        if (this.etj == null || this.eFr == null || this.eFr.bmi() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.eFr.bmf()) {
            bmi = this.eFr.bme();
        } else {
            bmi = this.eFr.bmi();
        }
        int s = com.baidu.tbadk.core.util.x.s(bmi);
        this.eFq = s;
        if (!this.eFr.bmf()) {
            if (s <= 2) {
                this.eFq = s;
            } else {
                this.eFq = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.eFq) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.eFt)) {
                childAt = this.etj.kk();
                childAt.setPadding(0, 0, 0, (int) getResources().getDimension(r.e.ds18));
                this.eFs.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.eFn);
            view.setOnLongClickListener(this.eFo);
            view.setOnTouchListener(this.eFp);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(r.g.tag_load_sub_data) != this.eFr) {
                sparseArray.put(r.g.tag_load_sub_data, this.eFr);
            }
            sparseArray.put(r.g.tag_load_sub_view, this.mRootView);
            sparseArray.put(r.g.tag_is_subpb, true);
            if (bmi.get(i3) != null && bmi.get(i3).getAuthor() != null) {
                sparseArray.put(r.g.tag_photo_username, bmi.get(i3).getAuthor().getUserName());
                sparseArray.put(r.g.tag_photo_userid, bmi.get(i3).getAuthor().getUserId());
                sparseArray.put(r.g.tag_clip_board, bmi.get(i3));
            }
            this.etj.a((ba.b) sparseArray.get(r.g.tag_holder), bmi.get(i3), this.eFr.bmp() > bmi.size() || bmi.size() - i3 > 1, i3 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bmi != null && bmi.size() > 0 && this.eFr.bmp() > this.eFq) {
            a(getContext(), (TextView) this.eFt.findViewById(r.g.sub_pb_more_text), this.eFr.bmp() - this.eFq);
            this.eFt.setOnClickListener(this.eFn);
            SparseArray sparseArray4 = (SparseArray) this.eFt.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.eFt.setTag(sparseArray4);
            }
            sparseArray4.put(r.g.tag_load_sub_data, this.eFr);
            sparseArray4.put(r.g.tag_load_sub_view, this.mRootView);
            this.eFt.setVisibility(0);
            this.eFt.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.eFt.setBackgroundColor(0);
        } else {
            this.eFt.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.eFt.getVisibility() == 0 ? this.eFt.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eFr != null && this.eFr.bmi() != null) {
            int size = this.eFs.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.eFs.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.eFu, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.eFq;
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
            if (this.eFt.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.eFt.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.eFt.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.eFt.getMeasuredWidth(), this.eFt.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m9getInst().getApp().getString(r.j.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_c)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.at.c(textView, r.d.cp_cont_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eFr != null && this.eFr.bmi() != null) {
            int i = this.eFq;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.eFt.getVisibility() == 0) {
                drawChild(canvas, this.eFt, drawingTime);
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
    /* renamed from: aTz */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
