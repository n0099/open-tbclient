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
    private au dZs;
    private View.OnClickListener ekl;
    private View.OnLongClickListener ekm;
    private View.OnTouchListener ekn;
    private int eko;
    private com.baidu.tieba.tbadkCore.data.s ekp;
    private final Queue<a> ekq;
    private View ekr;
    private ViewGroup.MarginLayoutParams eks;
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
        this.eko = 0;
        this.mRootView = null;
        this.ekq = new LinkedList();
        this.eks = new ViewGroup.MarginLayoutParams(-1, -2);
        this.ekr = LayoutInflater.from(context).inflate(u.h.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.ekr, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.ekl = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ekm = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.ekn = onTouchListener;
    }

    public void setSubPbAdapter(au auVar) {
        this.dZs = auVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.s sVar, View view) {
        this.ekp = sVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.dZs == null || this.ekp == null || this.ekp.bfx() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.data.s> bfx = this.ekp.bfx();
        int size2 = bfx.size();
        if (this.ekp.bfJ()) {
            this.ekp.ky(true);
            if (size2 <= 10) {
                this.eko = size2;
            } else {
                this.eko = 10;
            }
        } else {
            this.ekp.ky(false);
            if (size2 <= 2) {
                this.eko = size2;
            } else {
                this.eko = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.eko) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.ekr)) {
                childAt = this.dZs.jp();
                childAt.setPadding(0, (int) getResources().getDimension(u.e.ds6), (int) getResources().getDimension(u.e.ds6), 0);
                this.ekq.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.ekl);
            view.setOnLongClickListener(this.ekm);
            view.setOnTouchListener(this.ekn);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(u.g.tag_load_sub_data) != this.ekp) {
                sparseArray.put(u.g.tag_load_sub_data, this.ekp);
            }
            sparseArray.put(u.g.tag_load_sub_view, this.mRootView);
            sparseArray.put(u.g.tag_is_subpb, true);
            if (bfx.get(i3) != null && bfx.get(i3).getAuthor() != null) {
                sparseArray.put(u.g.tag_photo_username, bfx.get(i3).getAuthor().getUserName());
                sparseArray.put(u.g.tag_photo_userid, bfx.get(i3).getAuthor().getUserId());
                sparseArray.put(u.g.tag_clip_board, bfx.get(i3));
            }
            this.dZs.a((au.a) sparseArray.get(u.g.tag_holder), bfx.get(i3), this.ekp.bfF() > bfx.size() || bfx.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bfx != null && bfx.size() > 0 && this.ekp.bfF() > this.eko) {
            a(getContext(), (TextView) this.ekr.findViewById(u.g.sub_pb_more_text), this.ekp.bfF() - this.eko);
            this.ekr.setOnClickListener(this.ekl);
            SparseArray sparseArray4 = (SparseArray) this.ekr.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.ekr.setTag(sparseArray4);
            }
            sparseArray4.put(u.g.tag_load_sub_data, this.ekp);
            sparseArray4.put(u.g.tag_load_sub_view, this.mRootView);
            this.ekr.setVisibility(0);
            this.ekr.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.ekr.setBackgroundColor(0);
        } else {
            this.ekr.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.ekr.getVisibility() == 0 ? this.ekr.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.ekp != null && this.ekp.bfx() != null) {
            int size = this.ekq.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.ekq.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.eks, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.eko;
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
            if (this.ekr.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ekr.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.ekr.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.ekr.getMeasuredWidth(), this.ekr.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m10getInst().getApp().getString(u.j.sub_pb_load_more);
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
        if (this.ekp != null && this.ekp.bfx() != null) {
            int i = this.eko;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.ekr.getVisibility() == 0) {
                drawChild(canvas, this.ekr, drawingTime);
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
    /* renamed from: aLR */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
