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
    private PostData eIA;
    private final Queue<a> eIB;
    private TextView eIC;
    private ViewGroup.MarginLayoutParams eID;
    private View.OnClickListener eIw;
    private View.OnLongClickListener eIx;
    private View.OnTouchListener eIy;
    private int eIz;
    private ba etb;
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
        this.eIz = 0;
        this.mRootView = null;
        this.eIB = new LinkedList();
        this.eID = new ViewGroup.MarginLayoutParams(-1, -2);
        this.eIC = new TextView(context);
        this.eIC.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(context, w.f.ds16));
        this.eIC.setId(w.h.pb_floor_reply_more);
        this.eIC.setTextSize(0, com.baidu.adp.lib.util.k.g(context, w.f.fontsize28));
        com.baidu.tbadk.core.util.as.i(this.eIC, w.e.cp_link_tip_c);
        addView(this.eIC, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.eIw = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.eIx = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eIy = onTouchListener;
    }

    public void setSubPbAdapter(ba baVar) {
        this.etb = baVar;
    }

    public void a(PostData postData, View view) {
        this.eIA = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bmr;
        SparseArray sparseArray;
        if (this.etb == null || this.eIA == null || this.eIA.bmr() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.eIA.bmp()) {
            bmr = this.eIA.bmo();
        } else {
            bmr = this.eIA.bmr();
        }
        int s = com.baidu.tbadk.core.util.z.s(bmr);
        this.eIz = s;
        if (!this.eIA.bmp()) {
            if (s <= 2) {
                this.eIz = s;
            } else {
                this.eIz = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.eIz) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.eIC)) {
                childAt = this.etb.lc();
                childAt.setPadding(0, 0, 0, (int) getResources().getDimension(w.f.ds20));
                this.eIB.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.eIw);
            view.setOnLongClickListener(this.eIx);
            view.setOnTouchListener(this.eIy);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(w.h.tag_load_sub_data) != this.eIA) {
                sparseArray.put(w.h.tag_load_sub_data, this.eIA);
            }
            sparseArray.put(w.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(w.h.tag_is_subpb, true);
            if (bmr.get(i3) != null && bmr.get(i3).getAuthor() != null) {
                sparseArray.put(w.h.tag_photo_username, bmr.get(i3).getAuthor().getUserName());
                sparseArray.put(w.h.tag_photo_userid, bmr.get(i3).getAuthor().getUserId());
                sparseArray.put(w.h.tag_clip_board, bmr.get(i3));
            }
            this.etb.a((ba.b) sparseArray.get(w.h.tag_holder), bmr.get(i3), this.eIA.bmy() > bmr.size() || bmr.size() - i3 > 1, i3 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bmr != null && bmr.size() > 0 && this.eIA.bmy() > this.eIz) {
            this.eIC.setText(String.format(TbadkCoreApplication.m9getInst().getApp().getString(w.l.sub_pb_load_more), Integer.valueOf(this.eIA.bmy() - this.eIz)));
            this.eIC.setOnClickListener(this.eIw);
            SparseArray sparseArray4 = (SparseArray) this.eIC.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.eIC.setTag(sparseArray4);
            }
            sparseArray4.put(w.h.tag_load_sub_data, this.eIA);
            sparseArray4.put(w.h.tag_load_sub_view, this.mRootView);
            this.eIC.setVisibility(0);
            this.eIC.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.eIC.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.eIC.getVisibility() == 0 ? this.eIC.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eIA != null && this.eIA.bmr() != null) {
            int size = this.eIB.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.eIB.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.eID, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.eIz;
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
            if (this.eIC.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.eIC.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.eIC.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.eIC.getMeasuredWidth(), this.eIC.getMeasuredHeight() + i11);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eIA != null && this.eIA.bmr() != null) {
            int i = this.eIz;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.eIC.getVisibility() == 0) {
                drawChild(canvas, this.eIC, drawingTime);
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
    /* renamed from: aSl */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
