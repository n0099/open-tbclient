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
    private d fIV;
    private View.OnClickListener gaJ;
    private View.OnLongClickListener gaK;
    private View.OnTouchListener gaL;
    private int gaM;
    private PostData gaN;
    private final Queue<a> gaO;
    private RelativeLayout gaP;
    private TextView gaQ;
    private ViewGroup.MarginLayoutParams gaR;
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
        this.gaM = 0;
        this.mRootView = null;
        this.gaO = new LinkedList();
        this.gaR = new ViewGroup.MarginLayoutParams(-1, -2);
        this.gaP = new RelativeLayout(context);
        this.gaP.setId(d.g.pb_floor_reply_more);
        this.gaQ = new TextView(context);
        this.gaQ.setPadding(0, l.t(context, d.e.tbds14), 0, l.t(context, d.e.tbds22));
        this.gaQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.gaQ.setTextSize(0, l.t(context, d.e.tbfontsize42));
        aj.r(this.gaQ, d.C0141d.cp_cont_d);
        this.gaP.addView(this.gaQ);
        addView(this.gaP, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.gaJ = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.gaK = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.gaL = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.fIV = dVar;
    }

    public void a(PostData postData, View view) {
        this.gaN = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bwV;
        if (this.fIV == null || this.gaN == null || this.gaN.bwV() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.gaN.bwU()) {
            bwV = this.gaN.bwR();
        } else {
            bwV = this.gaN.bwV();
        }
        setMeasuredDimension(size, cq(v.D(bwV), size) + p(bwV, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int p(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.gaN.bxn() == 1) {
            this.gaM = 0;
            return 0;
        } else if (v.D(list) != 0) {
            int D = v.D(list);
            this.gaM = D;
            if (!this.gaN.bwU()) {
                if (D <= 2) {
                    this.gaM = D;
                } else {
                    this.gaM = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.gaM) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.gaP)) {
                    childAt = this.fIV.st();
                    childAt.setPadding(0, 0, 0, 0);
                    this.gaO.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.gaJ);
                view.setOnLongClickListener(this.gaK);
                view.setOnTouchListener(this.gaL);
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
                if (sparseArray.get(d.g.tag_load_sub_data) != this.gaN) {
                    sparseArray.put(d.g.tag_load_sub_data, this.gaN);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).zn() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).zn().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).zn().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.fIV.a((d.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.gaN.bxd() > list.size() || list.size() - i2 > 1, i2 == 0, false);
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
        if (i > 0 && (this.gaN.bxn() == 1 || this.gaN.bxd() > this.gaM)) {
            this.gaQ.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.gaN.bxd())));
            this.gaP.setOnClickListener(this.gaJ);
            SparseArray sparseArray = (SparseArray) this.gaP.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.gaP.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.gaN);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.gaP.setVisibility(0);
            this.gaP.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.gaP.setVisibility(8);
        }
        if (this.gaP.getVisibility() == 0) {
            return this.gaP.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.gaN != null && this.gaN.bwV() != null) {
            int size = this.gaO.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.gaO.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.gaR, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.gaM;
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
            if (this.gaP.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gaP.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.gaP.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.gaP.getMeasuredWidth(), this.gaP.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.gaM; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.gaP) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.gaN != null && this.gaN.bwV() != null) {
            int i = this.gaM;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.gaP.getVisibility() == 0) {
                drawChild(canvas, this.gaP, drawingTime);
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
        if (this.gaQ != null) {
            this.gaQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
            aj.r(this.gaQ, d.C0141d.cp_cont_d);
        }
    }
}
