package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.SparseArray;
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
    private ba ekd;
    private View.OnClickListener eza;
    private View.OnLongClickListener ezb;
    private View.OnTouchListener ezc;
    private int ezd;
    private PostData eze;
    private final Queue<a> ezf;
    private TextView ezg;
    private ViewGroup.MarginLayoutParams ezh;
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
        this.ezd = 0;
        this.mRootView = null;
        this.ezf = new LinkedList();
        this.ezh = new ViewGroup.MarginLayoutParams(-1, -2);
        this.ezg = new TextView(context);
        this.ezg.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(context, w.f.ds16));
        this.ezg.setId(w.h.pb_floor_reply_more);
        this.ezg.setTextSize(0, com.baidu.adp.lib.util.k.g(context, w.f.fontsize28));
        com.baidu.tbadk.core.util.aq.i(this.ezg, w.e.cp_link_tip_c);
        addView(this.ezg, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.eza = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ezb = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.ezc = onTouchListener;
    }

    public void setSubPbAdapter(ba baVar) {
        this.ekd = baVar;
    }

    public void a(PostData postData, View view) {
        this.eze = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bid;
        SparseArray sparseArray;
        if (this.ekd == null || this.eze == null || this.eze.bid() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.eze.bib()) {
            bid = this.eze.bia();
        } else {
            bid = this.eze.bid();
        }
        int q = com.baidu.tbadk.core.util.x.q(bid);
        this.ezd = q;
        if (!this.eze.bib()) {
            if (q <= 2) {
                this.ezd = q;
            } else {
                this.ezd = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.ezd) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.ezg)) {
                childAt = this.ekd.le();
                childAt.setPadding(0, 0, 0, (int) getResources().getDimension(w.f.ds20));
                this.ezf.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.eza);
            view.setOnLongClickListener(this.ezb);
            view.setOnTouchListener(this.ezc);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(w.h.tag_load_sub_data) != this.eze) {
                sparseArray.put(w.h.tag_load_sub_data, this.eze);
            }
            sparseArray.put(w.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(w.h.tag_is_subpb, true);
            if (bid.get(i3) != null && bid.get(i3).getAuthor() != null) {
                sparseArray.put(w.h.tag_photo_username, bid.get(i3).getAuthor().getUserName());
                sparseArray.put(w.h.tag_photo_userid, bid.get(i3).getAuthor().getUserId());
                sparseArray.put(w.h.tag_clip_board, bid.get(i3));
            }
            this.ekd.a((ba.b) sparseArray.get(w.h.tag_holder), bid.get(i3), this.eze.bik() > bid.size() || bid.size() - i3 > 1, i3 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bid != null && bid.size() > 0 && this.eze.bik() > this.ezd) {
            this.ezg.setText(String.format(TbadkCoreApplication.m9getInst().getApp().getString(w.l.sub_pb_load_more), Integer.valueOf(this.eze.bik() - this.ezd)));
            this.ezg.setOnClickListener(this.eza);
            SparseArray sparseArray4 = (SparseArray) this.ezg.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.ezg.setTag(sparseArray4);
            }
            sparseArray4.put(w.h.tag_load_sub_data, this.eze);
            sparseArray4.put(w.h.tag_load_sub_view, this.mRootView);
            this.ezg.setVisibility(0);
            this.ezg.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.ezg.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.ezg.getVisibility() == 0 ? this.ezg.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eze != null && this.eze.bid() != null) {
            int size = this.ezf.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.ezf.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.ezh, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.ezd;
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
            if (this.ezg.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ezg.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.ezg.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.ezg.getMeasuredWidth(), this.ezg.getMeasuredHeight() + i11);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eze != null && this.eze.bid() != null) {
            int i = this.ezd;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.ezg.getVisibility() == 0) {
                drawChild(canvas, this.ezg, drawingTime);
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
    /* renamed from: aOm */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
