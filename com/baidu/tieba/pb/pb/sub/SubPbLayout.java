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
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private ba ehi;
    private View.OnClickListener etQ;
    private View.OnLongClickListener etR;
    private View.OnTouchListener etS;
    private int etT;
    private PostData etU;
    private final Queue<a> etV;
    private View etW;
    private ViewGroup.MarginLayoutParams etX;
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
        this.etT = 0;
        this.mRootView = null;
        this.etV = new LinkedList();
        this.etX = new ViewGroup.MarginLayoutParams(-1, -2);
        this.etW = LayoutInflater.from(context).inflate(w.j.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.etW, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.etQ = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.etR = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.etS = onTouchListener;
    }

    public void setSubPbAdapter(ba baVar) {
        this.ehi = baVar;
    }

    public void a(PostData postData, View view) {
        this.etU = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bil;
        SparseArray sparseArray;
        if (this.ehi == null || this.etU == null || this.etU.bil() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.etU.bii()) {
            bil = this.etU.bih();
        } else {
            bil = this.etU.bil();
        }
        int p = com.baidu.tbadk.core.util.x.p(bil);
        this.etT = p;
        if (!this.etU.bii()) {
            if (p <= 2) {
                this.etT = p;
            } else {
                this.etT = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.etT) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.etW)) {
                childAt = this.ehi.le();
                childAt.setPadding(0, 0, 0, (int) getResources().getDimension(w.f.ds18));
                this.etV.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.etQ);
            view.setOnLongClickListener(this.etR);
            view.setOnTouchListener(this.etS);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(w.h.tag_load_sub_data) != this.etU) {
                sparseArray.put(w.h.tag_load_sub_data, this.etU);
            }
            sparseArray.put(w.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(w.h.tag_is_subpb, true);
            if (bil.get(i3) != null && bil.get(i3).getAuthor() != null) {
                sparseArray.put(w.h.tag_photo_username, bil.get(i3).getAuthor().getUserName());
                sparseArray.put(w.h.tag_photo_userid, bil.get(i3).getAuthor().getUserId());
                sparseArray.put(w.h.tag_clip_board, bil.get(i3));
            }
            this.ehi.a((ba.b) sparseArray.get(w.h.tag_holder), bil.get(i3), this.etU.bis() > bil.size() || bil.size() - i3 > 1, i3 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bil != null && bil.size() > 0 && this.etU.bis() > this.etT) {
            a(getContext(), (TextView) this.etW.findViewById(w.h.sub_pb_more_text), this.etU.bis() - this.etT);
            this.etW.setOnClickListener(this.etQ);
            SparseArray sparseArray4 = (SparseArray) this.etW.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.etW.setTag(sparseArray4);
            }
            sparseArray4.put(w.h.tag_load_sub_data, this.etU);
            sparseArray4.put(w.h.tag_load_sub_view, this.mRootView);
            this.etW.setVisibility(0);
            this.etW.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.etW.setBackgroundColor(0);
        } else {
            this.etW.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.etW.getVisibility() == 0 ? this.etW.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.etU != null && this.etU.bil() != null) {
            int size = this.etV.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.etV.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.etX, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.etT;
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
            if (this.etW.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.etW.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.etW.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.etW.getMeasuredWidth(), this.etW.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_c)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_c, 1);
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.etU != null && this.etU.bil() != null) {
            int i = this.etT;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.etW.getVisibility() == 0) {
                drawChild(canvas, this.etW, drawingTime);
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
    /* renamed from: aOM */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
