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
import com.baidu.tieba.pb.pb.sub.au;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private au dNf;
    private View.OnClickListener dXJ;
    private View.OnLongClickListener dXK;
    private View.OnTouchListener dXL;
    private int dXM;
    private com.baidu.tieba.tbadkCore.data.s dXN;
    private final Queue<a> dXO;
    private View dXP;
    private ViewGroup.MarginLayoutParams dXQ;
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
        this.dXM = 0;
        this.mRootView = null;
        this.dXO = new LinkedList();
        this.dXQ = new ViewGroup.MarginLayoutParams(-1, -2);
        this.dXP = LayoutInflater.from(context).inflate(u.h.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.dXP, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.dXJ = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.dXK = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.dXL = onTouchListener;
    }

    public void setSubPbAdapter(au auVar) {
        this.dNf = auVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.s sVar, View view) {
        this.dXN = sVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.dNf == null || this.dXN == null || this.dXN.bci() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.data.s> bci = this.dXN.bci();
        int size2 = bci.size();
        if (this.dXN.bcu()) {
            this.dXN.kk(true);
            if (size2 <= 10) {
                this.dXM = size2;
            } else {
                this.dXM = 10;
            }
        } else {
            this.dXN.kk(false);
            if (size2 <= 2) {
                this.dXM = size2;
            } else {
                this.dXM = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.dXM) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.dXP)) {
                childAt = this.dNf.jq();
                childAt.setPadding(0, (int) getResources().getDimension(u.e.ds6), (int) getResources().getDimension(u.e.ds6), 0);
                this.dXO.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.dXJ);
            view.setOnLongClickListener(this.dXK);
            view.setOnTouchListener(this.dXL);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(u.g.tag_load_sub_data) != this.dXN) {
                sparseArray.put(u.g.tag_load_sub_data, this.dXN);
            }
            sparseArray.put(u.g.tag_load_sub_view, this.mRootView);
            sparseArray.put(u.g.tag_is_subpb, true);
            if (bci.get(i3) != null && bci.get(i3).getAuthor() != null) {
                sparseArray.put(u.g.tag_photo_username, bci.get(i3).getAuthor().getUserName());
                sparseArray.put(u.g.tag_photo_userid, bci.get(i3).getAuthor().getUserId());
                sparseArray.put(u.g.tag_clip_board, bci.get(i3));
            }
            this.dNf.a((au.a) sparseArray.get(u.g.tag_holder), bci.get(i3), this.dXN.bcq() > bci.size() || bci.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bci != null && bci.size() > 0 && this.dXN.bcq() > this.dXM) {
            a(getContext(), (TextView) this.dXP.findViewById(u.g.sub_pb_more_text), this.dXN.bcq() - this.dXM);
            this.dXP.setOnClickListener(this.dXJ);
            SparseArray sparseArray4 = (SparseArray) this.dXP.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.dXP.setTag(sparseArray4);
            }
            sparseArray4.put(u.g.tag_load_sub_data, this.dXN);
            sparseArray4.put(u.g.tag_load_sub_view, this.mRootView);
            this.dXP.setVisibility(0);
            this.dXP.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.dXP.setBackgroundColor(0);
        } else {
            this.dXP.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.dXP.getVisibility() == 0 ? this.dXP.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.dXN != null && this.dXN.bci() != null) {
            int size = this.dXO.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.dXO.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.dXQ, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.dXM;
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
            if (this.dXP.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.dXP.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.dXP.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.dXP.getMeasuredWidth(), this.dXP.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m9getInst().getApp().getString(u.j.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(u.d.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.av.c(textView, u.d.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.dXN != null && this.dXN.bci() != null) {
            int i = this.dXM;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.dXP.getVisibility() == 0) {
                drawChild(canvas, this.dXP, drawingTime);
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
    /* renamed from: aIG */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
