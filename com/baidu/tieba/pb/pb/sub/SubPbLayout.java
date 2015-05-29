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
    private ag bLl;
    private View.OnClickListener bQd;
    private View.OnLongClickListener bQe;
    private View.OnTouchListener bQf;
    private int bQg;
    private com.baidu.tieba.tbadkCore.data.j bQh;
    private final Queue<ai> bQi;
    private View bQj;
    private ViewGroup.MarginLayoutParams bQk;
    private View mRootView;

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQg = 0;
        this.mRootView = null;
        this.bQi = new LinkedList();
        this.bQk = new ViewGroup.MarginLayoutParams(-1, -2);
        this.bQj = com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.new_sub_pb_list_more, null);
        addView(this.bQj, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.bQd = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bQe = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.bQf = onTouchListener;
    }

    public void setSubPbAdapter(ag agVar) {
        this.bLl = agVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.j jVar, View view) {
        this.bQh = jVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.bLl == null || this.bQh == null || this.bQh.aoy() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.data.j> aoy = this.bQh.aoy();
        int size2 = aoy.size();
        if (this.bQh.aoJ()) {
            this.bQh.fg(true);
            if (size2 <= 10) {
                this.bQg = size2;
            } else {
                this.bQg = 10;
            }
        } else {
            this.bQh.fg(false);
            if (size2 <= 2) {
                this.bQg = size2;
            } else {
                this.bQg = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.bQg) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.bQj)) {
                childAt = this.bLl.ng();
                this.bQi.offer(new ai(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.bQd);
            view.setOnLongClickListener(this.bQe);
            view.setOnTouchListener(this.bQf);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(com.baidu.tieba.q.tag_load_sub_data) != this.bQh) {
                sparseArray.put(com.baidu.tieba.q.tag_load_sub_data, this.bQh);
            }
            sparseArray.put(com.baidu.tieba.q.tag_load_sub_view, this.mRootView);
            sparseArray.put(com.baidu.tieba.q.tag_is_subpb, true);
            if (aoy.get(i3) != null && aoy.get(i3).getAuthor() != null) {
                sparseArray.put(com.baidu.tieba.q.tag_photo_username, aoy.get(i3).getAuthor().getUserName());
                sparseArray.put(com.baidu.tieba.q.tag_clip_board, aoy.get(i3));
            }
            this.bLl.a((ah) sparseArray.get(com.baidu.tieba.q.tag_holder), aoy.get(i3), this.bQh.aoF() > aoy.size() || aoy.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (aoy != null && this.bQh.aoF() > this.bQg) {
            a(getContext(), (TextView) this.bQj.findViewById(com.baidu.tieba.q.sub_pb_more_text), this.bQh.aoF() - this.bQg);
            this.bQj.setOnClickListener(this.bQd);
            SparseArray sparseArray4 = (SparseArray) this.bQj.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.bQj.setTag(sparseArray4);
            }
            sparseArray4.put(com.baidu.tieba.q.tag_load_sub_data, this.bQh);
            sparseArray4.put(com.baidu.tieba.q.tag_load_sub_view, this.mRootView);
            this.bQj.setVisibility(0);
            this.bQj.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.bQj.setBackgroundColor(0);
        } else {
            this.bQj.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.bQj.getVisibility() == 0 ? this.bQj.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.bQh != null && this.bQh.aoy() != null) {
            int size = this.bQi.size();
            for (int i6 = 0; i6 < size; i6++) {
                ai poll = this.bQi.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.bQk, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.bQg;
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
            if (this.bQj.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bQj.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.bQj.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.bQj.getMeasuredWidth(), this.bQj.getMeasuredHeight() + i11);
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
        if (this.bQh != null && this.bQh.aoy() != null) {
            int i = this.bQg;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.bQj.getVisibility() == 0) {
                drawChild(canvas, this.bQj, drawingTime);
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
    /* renamed from: adz */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
