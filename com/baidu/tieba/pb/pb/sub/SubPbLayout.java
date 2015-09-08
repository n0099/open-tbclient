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
    private ai ccF;
    private View.OnClickListener chB;
    private View.OnLongClickListener chC;
    private View.OnTouchListener chD;
    private int chE;
    private com.baidu.tieba.tbadkCore.data.i chF;
    private final Queue<a> chG;
    private View chH;
    private ViewGroup.MarginLayoutParams chI;
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
        this.chE = 0;
        this.mRootView = null;
        this.chG = new LinkedList();
        this.chI = new ViewGroup.MarginLayoutParams(-1, -2);
        this.chH = LayoutInflater.from(context).inflate(i.g.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.chH, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.chB = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.chC = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.chD = onTouchListener;
    }

    public void setSubPbAdapter(ai aiVar) {
        this.ccF = aiVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.i iVar, View view) {
        this.chF = iVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.ccF == null || this.chF == null || this.chF.auf() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.data.i> auf = this.chF.auf();
        int size2 = auf.size();
        if (this.chF.aur()) {
            this.chF.gj(true);
            if (size2 <= 10) {
                this.chE = size2;
            } else {
                this.chE = 10;
            }
        } else {
            this.chF.gj(false);
            if (size2 <= 2) {
                this.chE = size2;
            } else {
                this.chE = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.chE) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.chH)) {
                childAt = this.ccF.nn();
                this.chG.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.chB);
            view.setOnLongClickListener(this.chC);
            view.setOnTouchListener(this.chD);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(i.f.tag_load_sub_data) != this.chF) {
                sparseArray.put(i.f.tag_load_sub_data, this.chF);
            }
            sparseArray.put(i.f.tag_load_sub_view, this.mRootView);
            sparseArray.put(i.f.tag_is_subpb, true);
            if (auf.get(i3) != null && auf.get(i3).getAuthor() != null) {
                sparseArray.put(i.f.tag_photo_username, auf.get(i3).getAuthor().getUserName());
                sparseArray.put(i.f.tag_clip_board, auf.get(i3));
            }
            this.ccF.a((ai.a) sparseArray.get(i.f.tag_holder), auf.get(i3), this.chF.aun() > auf.size() || auf.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (auf != null && auf.size() > 0 && this.chF.aun() > this.chE) {
            a(getContext(), (TextView) this.chH.findViewById(i.f.sub_pb_more_text), this.chF.aun() - this.chE);
            this.chH.setOnClickListener(this.chB);
            SparseArray sparseArray4 = (SparseArray) this.chH.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.chH.setTag(sparseArray4);
            }
            sparseArray4.put(i.f.tag_load_sub_data, this.chF);
            sparseArray4.put(i.f.tag_load_sub_view, this.mRootView);
            this.chH.setVisibility(0);
            this.chH.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.chH.setBackgroundColor(0);
        } else {
            this.chH.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.chH.getVisibility() == 0 ? this.chH.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.chF != null && this.chF.auf() != null) {
            int size = this.chG.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.chG.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.chI, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.chE;
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
            if (this.chH.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.chH.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.chH.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.chH.getMeasuredWidth(), this.chH.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m411getInst().getApp().getString(i.h.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.al.b(textView, i.c.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.chF != null && this.chF.auf() != null) {
            int i = this.chE;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.chH.getVisibility() == 0) {
                drawChild(canvas, this.chH, drawingTime);
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
    /* renamed from: afC */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
