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
import com.baidu.tieba.pb.pb.sub.av;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private av elw;
    private ViewGroup.MarginLayoutParams ewA;
    private View.OnClickListener ewt;
    private View.OnLongClickListener ewu;
    private View.OnTouchListener ewv;
    private int eww;
    private com.baidu.tieba.tbadkCore.data.q ewx;
    private final Queue<a> ewy;
    private View ewz;
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
        this.eww = 0;
        this.mRootView = null;
        this.ewy = new LinkedList();
        this.ewA = new ViewGroup.MarginLayoutParams(-1, -2);
        this.ewz = LayoutInflater.from(context).inflate(t.h.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.ewz, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.ewt = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ewu = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.ewv = onTouchListener;
    }

    public void setSubPbAdapter(av avVar) {
        this.elw = avVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.q qVar, View view) {
        this.ewx = qVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.elw == null || this.ewx == null || this.ewx.biY() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.data.q> biY = this.ewx.biY();
        int size2 = biY.size();
        if (this.ewx.bjk()) {
            this.ewx.kK(true);
            if (size2 <= 10) {
                this.eww = size2;
            } else {
                this.eww = 10;
            }
        } else {
            this.ewx.kK(false);
            if (size2 <= 2) {
                this.eww = size2;
            } else {
                this.eww = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.eww) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.ewz)) {
                childAt = this.elw.kk();
                childAt.setPadding(0, (int) getResources().getDimension(t.e.ds6), (int) getResources().getDimension(t.e.ds6), 0);
                this.ewy.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.ewt);
            view.setOnLongClickListener(this.ewu);
            view.setOnTouchListener(this.ewv);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(t.g.tag_load_sub_data) != this.ewx) {
                sparseArray.put(t.g.tag_load_sub_data, this.ewx);
            }
            sparseArray.put(t.g.tag_load_sub_view, this.mRootView);
            sparseArray.put(t.g.tag_is_subpb, true);
            if (biY.get(i3) != null && biY.get(i3).getAuthor() != null) {
                sparseArray.put(t.g.tag_photo_username, biY.get(i3).getAuthor().getUserName());
                sparseArray.put(t.g.tag_photo_userid, biY.get(i3).getAuthor().getUserId());
                sparseArray.put(t.g.tag_clip_board, biY.get(i3));
            }
            this.elw.a((av.a) sparseArray.get(t.g.tag_holder), biY.get(i3), this.ewx.bjg() > biY.size() || biY.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (biY != null && biY.size() > 0 && this.ewx.bjg() > this.eww) {
            a(getContext(), (TextView) this.ewz.findViewById(t.g.sub_pb_more_text), this.ewx.bjg() - this.eww);
            this.ewz.setOnClickListener(this.ewt);
            SparseArray sparseArray4 = (SparseArray) this.ewz.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.ewz.setTag(sparseArray4);
            }
            sparseArray4.put(t.g.tag_load_sub_data, this.ewx);
            sparseArray4.put(t.g.tag_load_sub_view, this.mRootView);
            this.ewz.setVisibility(0);
            this.ewz.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.ewz.setBackgroundColor(0);
        } else {
            this.ewz.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.ewz.getVisibility() == 0 ? this.ewz.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.ewx != null && this.ewx.biY() != null) {
            int size = this.ewy.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.ewy.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.ewA, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.eww;
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
            if (this.ewz.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ewz.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.ewz.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.ewz.getMeasuredWidth(), this.ewz.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m9getInst().getApp().getString(t.j.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(t.d.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.av.c(textView, t.d.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.ewx != null && this.ewx.biY() != null) {
            int i = this.eww;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.ewz.getVisibility() == 0) {
                drawChild(canvas, this.ewz, drawingTime);
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
    /* renamed from: aQJ */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
