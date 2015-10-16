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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.ai;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private ai cgP;
    private View.OnClickListener cni;
    private View.OnLongClickListener cnj;
    private View.OnTouchListener cnk;
    private int cnl;
    private com.baidu.tieba.tbadkCore.data.k cnm;
    private final Queue<a> cnn;
    private View cno;
    private ViewGroup.MarginLayoutParams cnp;
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
        this.cnl = 0;
        this.mRootView = null;
        this.cnn = new LinkedList();
        this.cnp = new ViewGroup.MarginLayoutParams(-1, -2);
        this.cno = LayoutInflater.from(context).inflate(i.g.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.cno, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.cni = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnj = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.cnk = onTouchListener;
    }

    public void setSubPbAdapter(ai aiVar) {
        this.cgP = aiVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.k kVar, View view) {
        this.cnm = kVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.cgP == null || this.cnm == null || this.cnm.awE() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.data.k> awE = this.cnm.awE();
        int size2 = awE.size();
        if (this.cnm.awQ()) {
            this.cnm.gt(true);
            if (size2 <= 10) {
                this.cnl = size2;
            } else {
                this.cnl = 10;
            }
        } else {
            this.cnm.gt(false);
            if (size2 <= 2) {
                this.cnl = size2;
            } else {
                this.cnl = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.cnl) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.cno)) {
                childAt = this.cgP.no();
                this.cnn.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.cni);
            view.setOnLongClickListener(this.cnj);
            view.setOnTouchListener(this.cnk);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(i.f.tag_load_sub_data) != this.cnm) {
                sparseArray.put(i.f.tag_load_sub_data, this.cnm);
            }
            sparseArray.put(i.f.tag_load_sub_view, this.mRootView);
            sparseArray.put(i.f.tag_is_subpb, true);
            if (awE.get(i3) != null && awE.get(i3).getAuthor() != null) {
                sparseArray.put(i.f.tag_photo_username, awE.get(i3).getAuthor().getUserName());
                sparseArray.put(i.f.tag_clip_board, awE.get(i3));
            }
            this.cgP.a((ai.a) sparseArray.get(i.f.tag_holder), awE.get(i3), this.cnm.awM() > awE.size() || awE.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (awE != null && awE.size() > 0 && this.cnm.awM() > this.cnl) {
            a(getContext(), (TextView) this.cno.findViewById(i.f.sub_pb_more_text), this.cnm.awM() - this.cnl);
            this.cno.setOnClickListener(this.cni);
            SparseArray sparseArray4 = (SparseArray) this.cno.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.cno.setTag(sparseArray4);
            }
            sparseArray4.put(i.f.tag_load_sub_data, this.cnm);
            sparseArray4.put(i.f.tag_load_sub_view, this.mRootView);
            this.cno.setVisibility(0);
            this.cno.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.cno.setBackgroundColor(0);
        } else {
            this.cno.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.cno.getVisibility() == 0 ? this.cno.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.cnm != null && this.cnm.awE() != null) {
            int size = this.cnn.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.cnn.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.cnp, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.cnl;
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
            if (this.cno.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cno.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.cno.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.cno.getMeasuredWidth(), this.cno.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m411getInst().getApp().getString(i.h.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(an.getColor(i.c.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        an.b(textView, i.c.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.cnm != null && this.cnm.awE() != null) {
            int i = this.cnl;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.cno.getVisibility() == 0) {
                drawChild(canvas, this.cno, drawingTime);
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
    /* renamed from: ahz */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
