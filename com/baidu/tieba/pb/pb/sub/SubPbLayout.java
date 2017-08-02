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
    private d eEk;
    private View.OnClickListener eUW;
    private View.OnLongClickListener eUX;
    private View.OnTouchListener eUY;
    private int eUZ;
    private PostData eVa;
    private final Queue<a> eVb;
    private TextView eVc;
    private ViewGroup.MarginLayoutParams eVd;
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
        this.eUZ = 0;
        this.mRootView = null;
        this.eVb = new LinkedList();
        this.eVd = new ViewGroup.MarginLayoutParams(-1, -2);
        this.eVc = new TextView(context);
        this.eVc.setPadding(0, 0, 0, k.g(context, d.f.ds16));
        this.eVc.setId(d.h.pb_floor_reply_more);
        this.eVc.setTextSize(0, k.g(context, d.f.fontsize28));
        ai.i(this.eVc, d.e.cp_link_tip_c);
        addView(this.eVc, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.eUW = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.eUX = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eUY = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.eEk = dVar;
    }

    public void a(PostData postData, View view) {
        this.eVa = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bso;
        SparseArray sparseArray;
        if (this.eEk == null || this.eVa == null || this.eVa.bso() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.eVa.bsm()) {
            bso = this.eVa.bsl();
        } else {
            bso = this.eVa.bso();
        }
        int u = u.u(bso);
        this.eUZ = u;
        if (!this.eVa.bsm()) {
            if (u <= 2) {
                this.eUZ = u;
            } else {
                this.eUZ = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.eUZ) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.eVc)) {
                childAt = this.eEk.la();
                childAt.setPadding(0, 0, 0, (int) getResources().getDimension(d.f.ds20));
                this.eVb.offer(new a(i3, childAt));
            }
            View view = childAt;
            view.setOnClickListener(this.eUW);
            view.setOnLongClickListener(this.eUX);
            view.setOnTouchListener(this.eUY);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(d.h.tag_load_sub_data) != this.eVa) {
                sparseArray.put(d.h.tag_load_sub_data, this.eVa);
            }
            sparseArray.put(d.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(d.h.tag_is_subpb, true);
            if (bso.get(i3) != null && bso.get(i3).getAuthor() != null) {
                sparseArray.put(d.h.tag_photo_username, bso.get(i3).getAuthor().getUserName());
                sparseArray.put(d.h.tag_photo_userid, bso.get(i3).getAuthor().getUserId());
                sparseArray.put(d.h.tag_clip_board, bso.get(i3));
            }
            this.eEk.a((d.b) sparseArray.get(d.h.tag_holder), bso.get(i3), this.eVa.bsv() > bso.size() || bso.size() - i3 > 1, i3 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bso != null && bso.size() > 0 && this.eVa.bsv() > this.eUZ) {
            this.eVc.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.l.sub_pb_load_more), Integer.valueOf(this.eVa.bsv() - this.eUZ)));
            this.eVc.setOnClickListener(this.eUW);
            SparseArray sparseArray4 = (SparseArray) this.eVc.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.eVc.setTag(sparseArray4);
            }
            sparseArray4.put(d.h.tag_load_sub_data, this.eVa);
            sparseArray4.put(d.h.tag_load_sub_view, this.mRootView);
            this.eVc.setVisibility(0);
            this.eVc.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.eVc.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.eVc.getVisibility() == 0 ? this.eVc.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eVa != null && this.eVa.bso() != null) {
            int size = this.eVb.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.eVb.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.eVd, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.eUZ;
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
            if (this.eVc.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.eVc.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.eVc.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.eVc.getMeasuredWidth(), this.eVc.getMeasuredHeight() + i11);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eVa != null && this.eVa.bso() != null) {
            int i = this.eUZ;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.eVc.getVisibility() == 0) {
                drawChild(canvas, this.eVc, drawingTime);
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
    /* renamed from: aVi */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
