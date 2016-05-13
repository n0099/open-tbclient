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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.pb.pb.sub.an;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private an dha;
    private View.OnClickListener dqY;
    private View.OnLongClickListener dqZ;
    private View.OnTouchListener dra;
    private int drb;
    private com.baidu.tieba.tbadkCore.data.s drc;
    private final Queue<a> drd;
    private View dre;
    private ViewGroup.MarginLayoutParams drf;
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
        this.drb = 0;
        this.mRootView = null;
        this.drd = new LinkedList();
        this.drf = new ViewGroup.MarginLayoutParams(-1, -2);
        this.dre = LayoutInflater.from(context).inflate(t.h.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.dre, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.dqY = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.dqZ = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.dra = onTouchListener;
    }

    public void setSubPbAdapter(an anVar) {
        this.dha = anVar;
    }

    public void a(com.baidu.tieba.tbadkCore.data.s sVar, View view) {
        this.drc = sVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.dha == null || this.drc == null || this.drc.aTU() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aTU = this.drc.aTU();
        int size2 = aTU.size();
        if (this.drc.aUg()) {
            this.drc.jz(true);
            if (size2 <= 10) {
                this.drb = size2;
            } else {
                this.drb = 10;
            }
        } else {
            this.drc.jz(false);
            if (size2 <= 2) {
                this.drb = size2;
            } else {
                this.drb = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.drb) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.dre)) {
                childAt = this.dha.jn();
                this.drd.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.dqY);
            view.setOnLongClickListener(this.dqZ);
            view.setOnTouchListener(this.dra);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(t.g.tag_load_sub_data) != this.drc) {
                sparseArray.put(t.g.tag_load_sub_data, this.drc);
            }
            sparseArray.put(t.g.tag_load_sub_view, this.mRootView);
            sparseArray.put(t.g.tag_is_subpb, true);
            if (aTU.get(i3) != null && aTU.get(i3).getAuthor() != null) {
                sparseArray.put(t.g.tag_photo_username, aTU.get(i3).getAuthor().getUserName());
                sparseArray.put(t.g.tag_photo_userid, aTU.get(i3).getAuthor().getUserId());
                sparseArray.put(t.g.tag_clip_board, aTU.get(i3));
            }
            this.dha.a((an.a) sparseArray.get(t.g.tag_holder), aTU.get(i3), this.drc.aUc() > aTU.size() || aTU.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (aTU != null && aTU.size() > 0 && this.drc.aUc() > this.drb) {
            a(getContext(), (TextView) this.dre.findViewById(t.g.sub_pb_more_text), this.drc.aUc() - this.drb);
            this.dre.setOnClickListener(this.dqY);
            SparseArray sparseArray4 = (SparseArray) this.dre.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.dre.setTag(sparseArray4);
            }
            sparseArray4.put(t.g.tag_load_sub_data, this.drc);
            sparseArray4.put(t.g.tag_load_sub_view, this.mRootView);
            this.dre.setVisibility(0);
            this.dre.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.dre.setBackgroundColor(0);
        } else {
            this.dre.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.dre.getVisibility() == 0 ? this.dre.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.drc != null && this.drc.aTU() != null) {
            int size = this.drd.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.drd.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.drf, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.drb;
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
            if (this.dre.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.dre.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.dre.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.dre.getMeasuredWidth(), this.dre.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m11getInst().getApp().getString(t.j.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(at.getColor(t.d.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        at.c(textView, t.d.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.drc != null && this.drc.aTU() != null) {
            int i = this.drb;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.dre.getVisibility() == 0) {
                drawChild(canvas, this.dre, drawingTime);
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
    /* renamed from: aAp */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
