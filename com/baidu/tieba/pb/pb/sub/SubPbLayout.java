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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.sub.al;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private al cAt;
    private View.OnClickListener cHL;
    private View.OnLongClickListener cHM;
    private View.OnTouchListener cHN;
    private int cHO;
    private com.baidu.tieba.tbadkCore.data.o cHP;
    private final Queue<a> cHQ;
    private View cHR;
    private ViewGroup.MarginLayoutParams cHS;
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
        this.cHO = 0;
        this.mRootView = null;
        this.cHQ = new LinkedList();
        this.cHS = new ViewGroup.MarginLayoutParams(-1, -2);
        this.cHR = LayoutInflater.from(context).inflate(n.g.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.cHR, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.cHL = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cHM = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.cHN = onTouchListener;
    }

    public void setSubPbAdapter(al alVar) {
        this.cAt = alVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.o oVar, View view) {
        this.cHP = oVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.cAt == null || this.cHP == null || this.cHP.aCZ() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.data.o> aCZ = this.cHP.aCZ();
        int size2 = aCZ.size();
        if (this.cHP.aDl()) {
            this.cHP.hk(true);
            if (size2 <= 10) {
                this.cHO = size2;
            } else {
                this.cHO = 10;
            }
        } else {
            this.cHP.hk(false);
            if (size2 <= 2) {
                this.cHO = size2;
            } else {
                this.cHO = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.cHO) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.cHR)) {
                childAt = this.cAt.nv();
                this.cHQ.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.cHL);
            view.setOnLongClickListener(this.cHM);
            view.setOnTouchListener(this.cHN);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(n.f.tag_load_sub_data) != this.cHP) {
                sparseArray.put(n.f.tag_load_sub_data, this.cHP);
            }
            sparseArray.put(n.f.tag_load_sub_view, this.mRootView);
            sparseArray.put(n.f.tag_is_subpb, true);
            if (aCZ.get(i3) != null && aCZ.get(i3).getAuthor() != null) {
                sparseArray.put(n.f.tag_photo_username, aCZ.get(i3).getAuthor().getUserName());
                sparseArray.put(n.f.tag_clip_board, aCZ.get(i3));
            }
            this.cAt.a((al.a) sparseArray.get(n.f.tag_holder), aCZ.get(i3), this.cHP.aDh() > aCZ.size() || aCZ.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (aCZ != null && aCZ.size() > 0 && this.cHP.aDh() > this.cHO) {
            a(getContext(), (TextView) this.cHR.findViewById(n.f.sub_pb_more_text), this.cHP.aDh() - this.cHO);
            this.cHR.setOnClickListener(this.cHL);
            SparseArray sparseArray4 = (SparseArray) this.cHR.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.cHR.setTag(sparseArray4);
            }
            sparseArray4.put(n.f.tag_load_sub_data, this.cHP);
            sparseArray4.put(n.f.tag_load_sub_view, this.mRootView);
            this.cHR.setVisibility(0);
            this.cHR.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.cHR.setBackgroundColor(0);
        } else {
            this.cHR.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.cHR.getVisibility() == 0 ? this.cHR.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.cHP != null && this.cHP.aCZ() != null) {
            int size = this.cHQ.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.cHQ.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.cHS, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.cHO;
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
            if (this.cHR.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cHR.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.cHR.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.cHR.getMeasuredWidth(), this.cHR.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m411getInst().getApp().getString(n.i.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(as.getColor(n.c.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        as.b(textView, n.c.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.cHP != null && this.cHP.aCZ() != null) {
            int i = this.cHO;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.cHR.getVisibility() == 0) {
                drawChild(canvas, this.cHR, drawingTime);
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
    /* renamed from: amE */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
