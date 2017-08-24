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
    private d eHt;
    private View.OnClickListener eYe;
    private View.OnLongClickListener eYf;
    private View.OnTouchListener eYg;
    private int eYh;
    private PostData eYi;
    private final Queue<a> eYj;
    private TextView eYk;
    private ViewGroup.MarginLayoutParams eYl;
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
        this.eYh = 0;
        this.mRootView = null;
        this.eYj = new LinkedList();
        this.eYl = new ViewGroup.MarginLayoutParams(-1, -2);
        this.eYk = new TextView(context);
        this.eYk.setPadding(0, 0, 0, k.g(context, d.f.ds16));
        this.eYk.setId(d.h.pb_floor_reply_more);
        this.eYk.setTextSize(0, k.g(context, d.f.fontsize28));
        ai.i(this.eYk, d.e.cp_link_tip_c);
        addView(this.eYk, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.eYe = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.eYf = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eYg = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.eHt = dVar;
    }

    public void a(PostData postData, View view) {
        this.eYi = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bsW;
        SparseArray sparseArray;
        if (this.eHt == null || this.eYi == null || this.eYi.bsW() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.eYi.bsU()) {
            bsW = this.eYi.bsT();
        } else {
            bsW = this.eYi.bsW();
        }
        int u = u.u(bsW);
        this.eYh = u;
        if (!this.eYi.bsU()) {
            if (u <= 2) {
                this.eYh = u;
            } else {
                this.eYh = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.eYh) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.eYk)) {
                childAt = this.eHt.lj();
                childAt.setPadding(0, 0, 0, (int) getResources().getDimension(d.f.ds20));
                this.eYj.offer(new a(i3, childAt));
            }
            View view = childAt;
            view.setOnClickListener(this.eYe);
            view.setOnLongClickListener(this.eYf);
            view.setOnTouchListener(this.eYg);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(d.h.tag_load_sub_data) != this.eYi) {
                sparseArray.put(d.h.tag_load_sub_data, this.eYi);
            }
            sparseArray.put(d.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(d.h.tag_is_subpb, true);
            if (bsW.get(i3) != null && bsW.get(i3).getAuthor() != null) {
                sparseArray.put(d.h.tag_photo_username, bsW.get(i3).getAuthor().getUserName());
                sparseArray.put(d.h.tag_photo_userid, bsW.get(i3).getAuthor().getUserId());
                sparseArray.put(d.h.tag_clip_board, bsW.get(i3));
            }
            this.eHt.a((d.b) sparseArray.get(d.h.tag_holder), bsW.get(i3), this.eYi.btd() > bsW.size() || bsW.size() - i3 > 1, i3 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bsW != null && bsW.size() > 0 && this.eYi.btd() > this.eYh) {
            this.eYk.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.l.sub_pb_load_more), Integer.valueOf(this.eYi.btd() - this.eYh)));
            this.eYk.setOnClickListener(this.eYe);
            SparseArray sparseArray4 = (SparseArray) this.eYk.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.eYk.setTag(sparseArray4);
            }
            sparseArray4.put(d.h.tag_load_sub_data, this.eYi);
            sparseArray4.put(d.h.tag_load_sub_view, this.mRootView);
            this.eYk.setVisibility(0);
            this.eYk.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.eYk.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.eYk.getVisibility() == 0 ? this.eYk.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eYi != null && this.eYi.bsW() != null) {
            int size = this.eYj.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.eYj.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.eYl, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.eYh;
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
            if (this.eYk.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.eYk.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.eYk.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.eYk.getMeasuredWidth(), this.eYk.getMeasuredHeight() + i11);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eYi != null && this.eYi.bsW() != null) {
            int i = this.eYh;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.eYk.getVisibility() == 0) {
                drawChild(canvas, this.eYk, drawingTime);
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
    /* renamed from: aVV */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
