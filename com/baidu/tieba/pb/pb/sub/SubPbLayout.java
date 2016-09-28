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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private av ent;
    private View.OnClickListener eyB;
    private View.OnLongClickListener eyC;
    private View.OnTouchListener eyD;
    private int eyE;
    private com.baidu.tieba.tbadkCore.data.q eyF;
    private final Queue<a> eyG;
    private View eyH;
    private ViewGroup.MarginLayoutParams eyI;
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
        this.eyE = 0;
        this.mRootView = null;
        this.eyG = new LinkedList();
        this.eyI = new ViewGroup.MarginLayoutParams(-1, -2);
        this.eyH = LayoutInflater.from(context).inflate(r.h.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.eyH, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.eyB = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.eyC = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eyD = onTouchListener;
    }

    public void setSubPbAdapter(av avVar) {
        this.ent = avVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.q qVar, View view) {
        this.eyF = qVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.ent == null || this.eyF == null || this.eyF.bjK() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.data.q> bjK = this.eyF.bjK();
        int size2 = bjK.size();
        if (this.eyF.bjW()) {
            this.eyF.kN(true);
            if (size2 <= 10) {
                this.eyE = size2;
            } else {
                this.eyE = 10;
            }
        } else {
            this.eyF.kN(false);
            if (size2 <= 2) {
                this.eyE = size2;
            } else {
                this.eyE = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.eyE) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.eyH)) {
                childAt = this.ent.kk();
                childAt.setPadding(0, (int) getResources().getDimension(r.e.ds6), (int) getResources().getDimension(r.e.ds6), 0);
                this.eyG.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.eyB);
            view.setOnLongClickListener(this.eyC);
            view.setOnTouchListener(this.eyD);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(r.g.tag_load_sub_data) != this.eyF) {
                sparseArray.put(r.g.tag_load_sub_data, this.eyF);
            }
            sparseArray.put(r.g.tag_load_sub_view, this.mRootView);
            sparseArray.put(r.g.tag_is_subpb, true);
            if (bjK.get(i3) != null && bjK.get(i3).getAuthor() != null) {
                sparseArray.put(r.g.tag_photo_username, bjK.get(i3).getAuthor().getUserName());
                sparseArray.put(r.g.tag_photo_userid, bjK.get(i3).getAuthor().getUserId());
                sparseArray.put(r.g.tag_clip_board, bjK.get(i3));
            }
            this.ent.a((av.a) sparseArray.get(r.g.tag_holder), bjK.get(i3), this.eyF.bjS() > bjK.size() || bjK.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bjK != null && bjK.size() > 0 && this.eyF.bjS() > this.eyE) {
            a(getContext(), (TextView) this.eyH.findViewById(r.g.sub_pb_more_text), this.eyF.bjS() - this.eyE);
            this.eyH.setOnClickListener(this.eyB);
            SparseArray sparseArray4 = (SparseArray) this.eyH.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.eyH.setTag(sparseArray4);
            }
            sparseArray4.put(r.g.tag_load_sub_data, this.eyF);
            sparseArray4.put(r.g.tag_load_sub_view, this.mRootView);
            this.eyH.setVisibility(0);
            this.eyH.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.eyH.setBackgroundColor(0);
        } else {
            this.eyH.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.eyH.getVisibility() == 0 ? this.eyH.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eyF != null && this.eyF.bjK() != null) {
            int size = this.eyG.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.eyG.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.eyI, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.eyE;
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
            if (this.eyH.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.eyH.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.eyH.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.eyH.getMeasuredWidth(), this.eyH.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m9getInst().getApp().getString(r.j.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.av.getColor(r.d.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.av.c(textView, r.d.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eyF != null && this.eyF.bjK() != null) {
            int i = this.eyE;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.eyH.getVisibility() == 0) {
                drawChild(canvas, this.eyH, drawingTime);
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
    /* renamed from: aRr */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
