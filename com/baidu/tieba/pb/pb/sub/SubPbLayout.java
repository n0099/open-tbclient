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
    private d eHr;
    private View.OnClickListener eYc;
    private View.OnLongClickListener eYd;
    private View.OnTouchListener eYe;
    private int eYf;
    private PostData eYg;
    private final Queue<a> eYh;
    private TextView eYi;
    private ViewGroup.MarginLayoutParams eYj;
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
        this.eYf = 0;
        this.mRootView = null;
        this.eYh = new LinkedList();
        this.eYj = new ViewGroup.MarginLayoutParams(-1, -2);
        this.eYi = new TextView(context);
        this.eYi.setPadding(0, 0, 0, k.g(context, d.f.ds16));
        this.eYi.setId(d.h.pb_floor_reply_more);
        this.eYi.setTextSize(0, k.g(context, d.f.fontsize28));
        ai.i(this.eYi, d.e.cp_link_tip_c);
        addView(this.eYi, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.eYc = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.eYd = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eYe = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.eHr = dVar;
    }

    public void a(PostData postData, View view) {
        this.eYg = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> btd;
        SparseArray sparseArray;
        if (this.eHr == null || this.eYg == null || this.eYg.btd() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.eYg.btb()) {
            btd = this.eYg.bta();
        } else {
            btd = this.eYg.btd();
        }
        int u = u.u(btd);
        this.eYf = u;
        if (!this.eYg.btb()) {
            if (u <= 2) {
                this.eYf = u;
            } else {
                this.eYf = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.eYf) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.eYi)) {
                childAt = this.eHr.lk();
                childAt.setPadding(0, 0, 0, (int) getResources().getDimension(d.f.ds20));
                this.eYh.offer(new a(i3, childAt));
            }
            View view = childAt;
            view.setOnClickListener(this.eYc);
            view.setOnLongClickListener(this.eYd);
            view.setOnTouchListener(this.eYe);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(d.h.tag_load_sub_data) != this.eYg) {
                sparseArray.put(d.h.tag_load_sub_data, this.eYg);
            }
            sparseArray.put(d.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(d.h.tag_is_subpb, true);
            if (btd.get(i3) != null && btd.get(i3).getAuthor() != null) {
                sparseArray.put(d.h.tag_photo_username, btd.get(i3).getAuthor().getUserName());
                sparseArray.put(d.h.tag_photo_userid, btd.get(i3).getAuthor().getUserId());
                sparseArray.put(d.h.tag_clip_board, btd.get(i3));
            }
            this.eHr.a((d.b) sparseArray.get(d.h.tag_holder), btd.get(i3), this.eYg.btk() > btd.size() || btd.size() - i3 > 1, i3 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (btd != null && btd.size() > 0 && this.eYg.btk() > this.eYf) {
            this.eYi.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.l.sub_pb_load_more), Integer.valueOf(this.eYg.btk() - this.eYf)));
            this.eYi.setOnClickListener(this.eYc);
            SparseArray sparseArray4 = (SparseArray) this.eYi.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.eYi.setTag(sparseArray4);
            }
            sparseArray4.put(d.h.tag_load_sub_data, this.eYg);
            sparseArray4.put(d.h.tag_load_sub_view, this.mRootView);
            this.eYi.setVisibility(0);
            this.eYi.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.eYi.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.eYi.getVisibility() == 0 ? this.eYi.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eYg != null && this.eYg.btd() != null) {
            int size = this.eYh.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.eYh.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.eYj, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.eYf;
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
            if (this.eYi.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.eYi.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.eYi.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.eYi.getMeasuredWidth(), this.eYi.getMeasuredHeight() + i11);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eYg != null && this.eYg.btd() != null) {
            int i = this.eYf;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.eYi.getVisibility() == 0) {
                drawChild(canvas, this.eYi, drawingTime);
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
    /* renamed from: aWa */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
