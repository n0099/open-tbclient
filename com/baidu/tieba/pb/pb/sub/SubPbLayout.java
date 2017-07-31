package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private d eFx;
    private View.OnClickListener eWj;
    private View.OnLongClickListener eWk;
    private View.OnTouchListener eWl;
    private int eWm;
    private PostData eWn;
    private final Queue<a> eWo;
    private TextView eWp;
    private ViewGroup.MarginLayoutParams eWq;
    private View mRootView;

    /* loaded from: classes.dex */
    private static class a {
        int position;
        View view;

        private a(int i, View view) {
            this.position = i;
            this.view = view;
        }
    }

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWm = 0;
        this.mRootView = null;
        this.eWo = new LinkedList();
        this.eWq = new ViewGroup.MarginLayoutParams(-1, -2);
        this.eWp = new TextView(context);
        this.eWp.setPadding(0, 0, 0, k.g(context, d.f.ds16));
        this.eWp.setId(d.h.pb_floor_reply_more);
        this.eWp.setTextSize(0, k.g(context, d.f.fontsize28));
        ai.i(this.eWp, d.e.cp_link_tip_c);
        addView(this.eWp, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.eWj = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.eWk = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eWl = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.eFx = dVar;
    }

    public void a(PostData postData, View view) {
        this.eWn = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bsv;
        SparseArray sparseArray;
        if (this.eFx == null || this.eWn == null || this.eWn.bsv() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.eWn.bst()) {
            bsv = this.eWn.bss();
        } else {
            bsv = this.eWn.bsv();
        }
        int u = u.u(bsv);
        this.eWm = u;
        if (!this.eWn.bst()) {
            if (u <= 2) {
                this.eWm = u;
            } else {
                this.eWm = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.eWm) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.eWp)) {
                childAt = this.eFx.lk();
                childAt.setPadding(0, 0, 0, (int) getResources().getDimension(d.f.ds20));
                this.eWo.offer(new a(i3, childAt));
            }
            View view = childAt;
            view.setOnClickListener(this.eWj);
            view.setOnLongClickListener(this.eWk);
            view.setOnTouchListener(this.eWl);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(d.h.tag_load_sub_data) != this.eWn) {
                sparseArray.put(d.h.tag_load_sub_data, this.eWn);
            }
            sparseArray.put(d.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(d.h.tag_is_subpb, true);
            if (bsv.get(i3) != null && bsv.get(i3).getAuthor() != null) {
                sparseArray.put(d.h.tag_photo_username, bsv.get(i3).getAuthor().getUserName());
                sparseArray.put(d.h.tag_photo_userid, bsv.get(i3).getAuthor().getUserId());
                sparseArray.put(d.h.tag_clip_board, bsv.get(i3));
            }
            this.eFx.a((d.b) sparseArray.get(d.h.tag_holder), bsv.get(i3), this.eWn.bsC() > bsv.size() || bsv.size() - i3 > 1, i3 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bsv != null && bsv.size() > 0 && this.eWn.bsC() > this.eWm) {
            this.eWp.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.l.sub_pb_load_more), Integer.valueOf(this.eWn.bsC() - this.eWm)));
            this.eWp.setOnClickListener(this.eWj);
            SparseArray sparseArray4 = (SparseArray) this.eWp.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.eWp.setTag(sparseArray4);
            }
            sparseArray4.put(d.h.tag_load_sub_data, this.eWn);
            sparseArray4.put(d.h.tag_load_sub_view, this.mRootView);
            this.eWp.setVisibility(0);
            this.eWp.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.eWp.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.eWp.getVisibility() == 0 ? this.eWp.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eWn != null && this.eWn.bsv() != null) {
            int size = this.eWo.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.eWo.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.eWq, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.eWm;
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
            if (this.eWp.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.eWp.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.eWp.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.eWp.getMeasuredWidth(), this.eWp.getMeasuredHeight() + i11);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eWn != null && this.eWn.bsv() != null) {
            int i = this.eWm;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.eWp.getVisibility() == 0) {
                drawChild(canvas, this.eWp, drawingTime);
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
    /* renamed from: aVt */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
