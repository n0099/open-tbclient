package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes2.dex */
public class SubPbLayout extends ViewGroup {
    private d fIQ;
    private View.OnClickListener gaE;
    private View.OnLongClickListener gaF;
    private View.OnTouchListener gaG;
    private int gaH;
    private PostData gaI;
    private final Queue<a> gaJ;
    private RelativeLayout gaK;
    private TextView gaL;
    private ViewGroup.MarginLayoutParams gaM;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
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
        this.gaH = 0;
        this.mRootView = null;
        this.gaJ = new LinkedList();
        this.gaM = new ViewGroup.MarginLayoutParams(-1, -2);
        this.gaK = new RelativeLayout(context);
        this.gaK.setId(d.g.pb_floor_reply_more);
        this.gaL = new TextView(context);
        this.gaL.setPadding(0, l.t(context, d.e.tbds14), 0, l.t(context, d.e.tbds22));
        this.gaL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.gaL.setTextSize(0, l.t(context, d.e.tbfontsize42));
        aj.r(this.gaL, d.C0140d.cp_cont_d);
        this.gaK.addView(this.gaL);
        addView(this.gaK, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.gaE = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.gaF = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.gaG = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.fIQ = dVar;
    }

    public void a(PostData postData, View view) {
        this.gaI = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bwR;
        if (this.fIQ == null || this.gaI == null || this.gaI.bwR() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.gaI.bwQ()) {
            bwR = this.gaI.bwN();
        } else {
            bwR = this.gaI.bwR();
        }
        setMeasuredDimension(size, cq(v.D(bwR), size) + p(bwR, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int p(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.gaI.bxj() == 1) {
            this.gaH = 0;
            return 0;
        } else if (v.D(list) != 0) {
            int D = v.D(list);
            this.gaH = D;
            if (!this.gaI.bwQ()) {
                if (D <= 2) {
                    this.gaH = D;
                } else {
                    this.gaH = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.gaH) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.gaK)) {
                    childAt = this.fIQ.st();
                    childAt.setPadding(0, 0, 0, 0);
                    this.gaJ.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.gaE);
                view.setOnLongClickListener(this.gaF);
                view.setOnTouchListener(this.gaG);
                view.setClickable(true);
                view.setVisibility(0);
                SparseArray sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 == null) {
                    SparseArray sparseArray3 = new SparseArray();
                    view.setTag(sparseArray3);
                    sparseArray = sparseArray3;
                } else {
                    sparseArray = sparseArray2;
                }
                if (sparseArray.get(d.g.tag_load_sub_data) != this.gaI) {
                    sparseArray.put(d.g.tag_load_sub_data, this.gaI);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).zn() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).zn().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).zn().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.fIQ.a((d.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.gaI.bwZ() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cq(int i, int i2) {
        if (i > 0 && (this.gaI.bxj() == 1 || this.gaI.bwZ() > this.gaH)) {
            this.gaL.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.gaI.bwZ())));
            this.gaK.setOnClickListener(this.gaE);
            SparseArray sparseArray = (SparseArray) this.gaK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.gaK.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.gaI);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.gaK.setVisibility(0);
            this.gaK.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.gaK.setVisibility(8);
        }
        if (this.gaK.getVisibility() == 0) {
            return this.gaK.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.gaI != null && this.gaI.bwR() != null) {
            int size = this.gaJ.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.gaJ.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.gaM, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.gaH;
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
            if (this.gaK.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gaK.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.gaK.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.gaK.getMeasuredWidth(), this.gaK.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.gaH; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.gaK) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.gaI != null && this.gaI.bwR() != null) {
            int i = this.gaH;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.gaK.getVisibility() == 0) {
                drawChild(canvas, this.gaK, drawingTime);
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
    /* renamed from: bgO */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.gaL != null) {
            this.gaL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
            aj.r(this.gaL, d.C0140d.cp_cont_d);
        }
    }
}
