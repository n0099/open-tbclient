package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private ag bLm;
    private View.OnClickListener bQe;
    private View.OnLongClickListener bQf;
    private View.OnTouchListener bQg;
    private int bQh;
    private com.baidu.tieba.tbadkCore.data.j bQi;
    private final Queue<ai> bQj;
    private View bQk;
    private ViewGroup.MarginLayoutParams bQl;
    private View mRootView;

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQh = 0;
        this.mRootView = null;
        this.bQj = new LinkedList();
        this.bQl = new ViewGroup.MarginLayoutParams(-1, -2);
        this.bQk = com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.new_sub_pb_list_more, null);
        addView(this.bQk, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.bQe = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bQf = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.bQg = onTouchListener;
    }

    public void setSubPbAdapter(ag agVar) {
        this.bLm = agVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.j jVar, View view) {
        this.bQi = jVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.bLm == null || this.bQi == null || this.bQi.aoz() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.data.j> aoz = this.bQi.aoz();
        int size2 = aoz.size();
        if (this.bQi.aoK()) {
            this.bQi.fg(true);
            if (size2 <= 10) {
                this.bQh = size2;
            } else {
                this.bQh = 10;
            }
        } else {
            this.bQi.fg(false);
            if (size2 <= 2) {
                this.bQh = size2;
            } else {
                this.bQh = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.bQh) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.bQk)) {
                childAt = this.bLm.ng();
                this.bQj.offer(new ai(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.bQe);
            view.setOnLongClickListener(this.bQf);
            view.setOnTouchListener(this.bQg);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(com.baidu.tieba.q.tag_load_sub_data) != this.bQi) {
                sparseArray.put(com.baidu.tieba.q.tag_load_sub_data, this.bQi);
            }
            sparseArray.put(com.baidu.tieba.q.tag_load_sub_view, this.mRootView);
            sparseArray.put(com.baidu.tieba.q.tag_is_subpb, true);
            if (aoz.get(i3) != null && aoz.get(i3).getAuthor() != null) {
                sparseArray.put(com.baidu.tieba.q.tag_photo_username, aoz.get(i3).getAuthor().getUserName());
                sparseArray.put(com.baidu.tieba.q.tag_clip_board, aoz.get(i3));
            }
            this.bLm.a((ah) sparseArray.get(com.baidu.tieba.q.tag_holder), aoz.get(i3), this.bQi.aoG() > aoz.size() || aoz.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (aoz != null && this.bQi.aoG() > this.bQh) {
            a(getContext(), (TextView) this.bQk.findViewById(com.baidu.tieba.q.sub_pb_more_text), this.bQi.aoG() - this.bQh);
            this.bQk.setOnClickListener(this.bQe);
            SparseArray sparseArray4 = (SparseArray) this.bQk.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.bQk.setTag(sparseArray4);
            }
            sparseArray4.put(com.baidu.tieba.q.tag_load_sub_data, this.bQi);
            sparseArray4.put(com.baidu.tieba.q.tag_load_sub_view, this.mRootView);
            this.bQk.setVisibility(0);
            this.bQk.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.bQk.setBackgroundColor(0);
        } else {
            this.bQk.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.bQk.getVisibility() == 0 ? this.bQk.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.bQi != null && this.bQi.aoz() != null) {
            int size = this.bQj.size();
            for (int i6 = 0; i6 < size; i6++) {
                ai poll = this.bQj.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.bQl, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.bQh;
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
            if (this.bQk.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bQk.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.bQk.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.bQk.getMeasuredWidth(), this.bQk.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m411getInst().getApp().getString(com.baidu.tieba.t.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(ay.getColor(com.baidu.tieba.n.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        ay.b(textView, com.baidu.tieba.n.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.bQi != null && this.bQi.aoz() != null) {
            int i = this.bQh;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.bQk.getVisibility() == 0) {
                drawChild(canvas, this.bQk, drawingTime);
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
    /* renamed from: adA */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
