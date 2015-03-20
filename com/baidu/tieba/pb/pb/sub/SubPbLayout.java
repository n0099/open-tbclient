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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private a bIR;
    private View.OnClickListener bNh;
    private View.OnLongClickListener bNi;
    private View.OnTouchListener bNj;
    private int bNk;
    private com.baidu.tieba.tbadkCore.c.j bNl;
    private final Queue<c> bNm;
    private View bNn;
    private ViewGroup.MarginLayoutParams bNo;
    private View mRootView;

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bNk = 0;
        this.mRootView = null;
        this.bNm = new LinkedList();
        this.bNo = new ViewGroup.MarginLayoutParams(-1, -2);
        this.bNn = com.baidu.adp.lib.g.b.hH().inflate(context, w.new_sub_pb_list_more, null);
        addView(this.bNn, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.bNh = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bNi = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.bNj = onTouchListener;
    }

    public void setSubPbAdapter(a aVar) {
        this.bIR = aVar;
    }

    public void a(com.baidu.tieba.tbadkCore.c.j jVar, View view) {
        this.bNl = jVar;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        SparseArray sparseArray;
        if (this.bIR == null || this.bNl == null || this.bNl.amx() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        ArrayList<com.baidu.tieba.tbadkCore.c.j> amx = this.bNl.amx();
        int size2 = amx.size();
        if (this.bNl.amI()) {
            this.bNl.eP(true);
            if (size2 <= 10) {
                this.bNk = size2;
            } else {
                this.bNk = 10;
            }
        } else {
            this.bNl.eP(false);
            if (size2 <= 2) {
                this.bNk = size2;
            } else {
                this.bNk = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.bNk) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.bNn)) {
                childAt = this.bIR.mN();
                this.bNm.offer(new c(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.bNh);
            view.setOnLongClickListener(this.bNi);
            view.setOnTouchListener(this.bNj);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(com.baidu.tieba.v.tag_load_sub_data) != this.bNl) {
                sparseArray.put(com.baidu.tieba.v.tag_load_sub_data, this.bNl);
            }
            sparseArray.put(com.baidu.tieba.v.tag_load_sub_view, this.mRootView);
            sparseArray.put(com.baidu.tieba.v.tag_is_subpb, true);
            if (amx.get(i3) != null && amx.get(i3).getAuthor() != null) {
                sparseArray.put(com.baidu.tieba.v.tag_photo_username, amx.get(i3).getAuthor().getUserName());
                sparseArray.put(com.baidu.tieba.v.tag_clip_board, amx.get(i3));
            }
            this.bIR.a((b) sparseArray.get(com.baidu.tieba.v.tag_holder), amx.get(i3), this.bNl.amE() > amx.size() || amx.size() - i3 > 1, i3 == 0);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (amx != null && this.bNl.amE() > this.bNk) {
            a(getContext(), (TextView) this.bNn.findViewById(com.baidu.tieba.v.sub_pb_more_text), this.bNl.amE() - this.bNk);
            this.bNn.setOnClickListener(this.bNh);
            SparseArray sparseArray4 = (SparseArray) this.bNn.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.bNn.setTag(sparseArray4);
            }
            sparseArray4.put(com.baidu.tieba.v.tag_load_sub_data, this.bNl);
            sparseArray4.put(com.baidu.tieba.v.tag_load_sub_view, this.mRootView);
            this.bNn.setVisibility(0);
            this.bNn.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.bNn.setBackgroundColor(0);
        } else {
            this.bNn.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.bNn.getVisibility() == 0 ? this.bNn.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.bNl != null && this.bNl.amx() != null) {
            int size = this.bNm.size();
            for (int i6 = 0; i6 < size; i6++) {
                c poll = this.bNm.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.bNo, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.bNk;
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
            if (this.bNn.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bNn.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.bNn.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.bNn.getMeasuredWidth(), this.bNn.getMeasuredHeight() + i11);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m411getInst().getApp().getString(y.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(com.baidu.tieba.s.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        ba.b(textView, com.baidu.tieba.s.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    public void setLookMoreTag(int i) {
        if (this.bNn != null) {
            this.bNn.setTag(com.baidu.tieba.v.tag_subpb_pos, Integer.valueOf(i));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.bNl != null && this.bNl.amx() != null) {
            int i = this.bNk;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.bNn.getVisibility() == 0) {
                drawChild(canvas, this.bNn, drawingTime);
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
    /* renamed from: abM */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
