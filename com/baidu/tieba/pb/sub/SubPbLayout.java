package com.baidu.tieba.pb.sub;

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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private a bBm;
    private View.OnClickListener bFB;
    private View.OnLongClickListener bFC;
    private View.OnTouchListener bFD;
    private com.baidu.tieba.tbadkCore.b.k bFE;
    private final Queue<c> bFF;
    private View bFG;
    private ViewGroup.MarginLayoutParams bFH;
    private View mRootView;

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.bFF = new LinkedList();
        this.bFH = new ViewGroup.MarginLayoutParams(-1, -2);
        this.bFG = com.baidu.adp.lib.g.b.ei().inflate(context, x.new_sub_pb_list_more, null);
        addView(this.bFG, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.bFB = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bFC = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.bFD = onTouchListener;
    }

    public void setSubPbAdapter(a aVar) {
        this.bBm = aVar;
    }

    public void a(com.baidu.tieba.tbadkCore.b.k kVar, View view) {
        this.bFE = kVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.bBm == null || this.bFE == null || this.bFE.ahv() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahv = this.bFE.ahv();
        int size2 = ahv.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size2) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.bFG)) {
                childAt = this.bBm.jy();
                this.bFF.offer(new c(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.bFB);
            view.setOnLongClickListener(this.bFC);
            view.setOnTouchListener(this.bFD);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(w.tag_load_sub_data) != this.bFE) {
                sparseArray.put(w.tag_load_sub_data, this.bFE);
            }
            sparseArray.put(w.tag_load_sub_view, this.mRootView);
            sparseArray.put(w.tag_is_subpb, true);
            if (ahv.get(i3) != null && ahv.get(i3).getAuthor() != null) {
                sparseArray.put(w.tag_photo_username, ahv.get(i3).getAuthor().getUserName());
                sparseArray.put(w.tag_clip_board, ahv.get(i3));
            }
            this.bBm.a((b) sparseArray.get(w.tag_holder), ahv.get(i3), this.bFE.ahC() > ahv.size() || ahv.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (ahv != null && this.bFE.ahC() > ahv.size()) {
            a(getContext(), (TextView) this.bFG.findViewById(w.sub_pb_more_text), this.bFE.ahC() - ahv.size());
            this.bFG.setOnClickListener(this.bFB);
            SparseArray sparseArray4 = (SparseArray) this.bFG.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.bFG.setTag(sparseArray4);
            }
            sparseArray4.put(w.tag_load_sub_data, this.bFE);
            sparseArray4.put(w.tag_load_sub_view, this.mRootView);
            this.bFG.setVisibility(0);
            this.bFG.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.bFG.setBackgroundColor(0);
        } else {
            this.bFG.setVisibility(8);
        }
        setMeasuredDimension(size, (this.bFG.getVisibility() == 0 ? this.bFG.getMeasuredHeight() : 0) + i4 + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.bFE != null && this.bFE.ahv() != null) {
            int size = this.bFF.size();
            for (int i6 = 0; i6 < size; i6++) {
                c poll = this.bFF.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.bFH, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int size2 = this.bFE.ahv().size();
            int i7 = 0;
            int i8 = paddingTop;
            while (i7 < size2) {
                View childAt = getChildAt(i7);
                if (childAt == null) {
                    i5 = i8;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    if (marginLayoutParams == null) {
                        marginLayoutParams = generateDefaultLayoutParams();
                    }
                    int i9 = i8 + marginLayoutParams.topMargin;
                    int measuredWidth = marginLayoutParams.leftMargin + paddingLeft + childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight() + i9;
                    childAt.layout(marginLayoutParams.leftMargin + paddingLeft, i9, measuredWidth, measuredHeight);
                    i5 = marginLayoutParams.bottomMargin + measuredHeight;
                }
                i7++;
                i8 = i5;
            }
            if (this.bFG.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bFG.getLayoutParams();
                int i10 = i8 + marginLayoutParams2.topMargin;
                this.bFG.layout(marginLayoutParams2.leftMargin + paddingLeft, i10, marginLayoutParams2.leftMargin + paddingLeft + this.bFG.getMeasuredWidth(), this.bFG.getMeasuredHeight() + i10);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m255getInst().getApp().getString(z.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(bc.getColor(t.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        bc.b(textView, t.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.bFE != null && this.bFE.ahv() != null) {
            int size = this.bFE.ahv().size();
            for (int i = 0; i < size; i++) {
                if (size < getChildCount()) {
                    drawChild(canvas, getChildAt(i), drawingTime);
                }
            }
            if (this.bFG.getVisibility() == 0) {
                drawChild(canvas, this.bFG, drawingTime);
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
    /* renamed from: ZJ */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
