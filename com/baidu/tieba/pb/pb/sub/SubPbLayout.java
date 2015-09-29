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
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.ai;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private ai cgE;
    private View.OnClickListener cmX;
    private View.OnLongClickListener cmY;
    private View.OnTouchListener cmZ;
    private int cna;
    private com.baidu.tieba.tbadkCore.data.k cnb;
    private final Queue<a> cnc;
    private View cnd;
    private ViewGroup.MarginLayoutParams cne;
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
        this.cna = 0;
        this.mRootView = null;
        this.cnc = new LinkedList();
        this.cne = new ViewGroup.MarginLayoutParams(-1, -2);
        this.cnd = LayoutInflater.from(context).inflate(i.g.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.cnd, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.cmX = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmY = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.cmZ = onTouchListener;
    }

    public void setSubPbAdapter(ai aiVar) {
        this.cgE = aiVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.k kVar, View view) {
        this.cnb = kVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.cgE == null || this.cnb == null || this.cnb.awu() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.data.k> awu = this.cnb.awu();
        int size2 = awu.size();
        if (this.cnb.awG()) {
            this.cnb.gt(true);
            if (size2 <= 10) {
                this.cna = size2;
            } else {
                this.cna = 10;
            }
        } else {
            this.cnb.gt(false);
            if (size2 <= 2) {
                this.cna = size2;
            } else {
                this.cna = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.cna) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.cnd)) {
                childAt = this.cgE.no();
                this.cnc.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.cmX);
            view.setOnLongClickListener(this.cmY);
            view.setOnTouchListener(this.cmZ);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(i.f.tag_load_sub_data) != this.cnb) {
                sparseArray.put(i.f.tag_load_sub_data, this.cnb);
            }
            sparseArray.put(i.f.tag_load_sub_view, this.mRootView);
            sparseArray.put(i.f.tag_is_subpb, true);
            if (awu.get(i3) != null && awu.get(i3).getAuthor() != null) {
                sparseArray.put(i.f.tag_photo_username, awu.get(i3).getAuthor().getUserName());
                sparseArray.put(i.f.tag_clip_board, awu.get(i3));
            }
            this.cgE.a((ai.a) sparseArray.get(i.f.tag_holder), awu.get(i3), this.cnb.awC() > awu.size() || awu.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (awu != null && awu.size() > 0 && this.cnb.awC() > this.cna) {
            a(getContext(), (TextView) this.cnd.findViewById(i.f.sub_pb_more_text), this.cnb.awC() - this.cna);
            this.cnd.setOnClickListener(this.cmX);
            SparseArray sparseArray4 = (SparseArray) this.cnd.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.cnd.setTag(sparseArray4);
            }
            sparseArray4.put(i.f.tag_load_sub_data, this.cnb);
            sparseArray4.put(i.f.tag_load_sub_view, this.mRootView);
            this.cnd.setVisibility(0);
            this.cnd.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.cnd.setBackgroundColor(0);
        } else {
            this.cnd.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.cnd.getVisibility() == 0 ? this.cnd.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.cnb != null && this.cnb.awu() != null) {
            int size = this.cnc.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.cnc.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.cne, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.cna;
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
            if (this.cnd.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cnd.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.cnd.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.cnd.getMeasuredWidth(), this.cnd.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m411getInst().getApp().getString(i.h.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.am.getColor(i.c.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.am.b(textView, i.c.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.cnb != null && this.cnb.awu() != null) {
            int i = this.cna;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.cnd.getVisibility() == 0) {
                drawChild(canvas, this.cnd, drawingTime);
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
