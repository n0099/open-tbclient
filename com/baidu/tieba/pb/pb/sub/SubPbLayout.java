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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes2.dex */
public class SubPbLayout extends ViewGroup {
    private PostData avX;
    private TextView bUi;
    private c fFR;
    private View.OnClickListener fTf;
    private View.OnLongClickListener fTg;
    private View.OnTouchListener fTh;
    private int fTi;
    private final Queue<a> fTj;
    private RelativeLayout fTk;
    private ViewGroup.MarginLayoutParams fTl;
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
        this.fTi = 0;
        this.mRootView = null;
        this.fTj = new LinkedList();
        this.fTl = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fTk = new RelativeLayout(context);
        this.fTk.setId(e.g.pb_floor_reply_more);
        this.bUi = new TextView(context);
        this.bUi.setPadding(0, l.h(context, e.C0141e.tbds14), 0, l.h(context, e.C0141e.tbds22));
        this.bUi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_lou_more), (Drawable) null);
        this.bUi.setTextSize(0, l.h(context, e.C0141e.tbfontsize42));
        al.h(this.bUi, e.d.cp_cont_d);
        this.fTk.addView(this.bUi);
        addView(this.fTk, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fTf = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fTg = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fTh = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.fFR = cVar;
    }

    public void setData(PostData postData, View view) {
        this.avX = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> byJ;
        if (this.fFR == null || this.avX == null || this.avX.byJ() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.avX.byI()) {
            byJ = this.avX.byF();
        } else {
            byJ = this.avX.byJ();
        }
        setMeasuredDimension(size, bw(v.y(byJ), size) + n(byJ, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.avX.byY() == 1) {
            this.fTi = 0;
            return 0;
        } else if (v.y(list) != 0) {
            int y = v.y(list);
            this.fTi = y;
            if (!this.avX.byI()) {
                if (y <= 2) {
                    this.fTi = y;
                } else {
                    this.fTi = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.fTi) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.fTk)) {
                    childAt = this.fFR.ov();
                    childAt.setPadding(0, 0, 0, 0);
                    this.fTj.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.fTf);
                view.setOnLongClickListener(this.fTg);
                view.setOnTouchListener(this.fTh);
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
                if (sparseArray.get(e.g.tag_load_sub_data) != this.avX) {
                    sparseArray.put(e.g.tag_load_sub_data, this.avX);
                }
                sparseArray.put(e.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(e.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).wm() != null) {
                    sparseArray.put(e.g.tag_photo_username, list.get(i2).wm().getUserName());
                    sparseArray.put(e.g.tag_photo_userid, list.get(i2).wm().getUserId());
                    sparseArray.put(e.g.tag_clip_board, list.get(i2));
                }
                this.fFR.a((c.b) sparseArray.get(e.g.tag_holder), list.get(i2), this.avX.byQ() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int bw(int i, int i2) {
        if (i > 0 && (this.avX.byY() == 1 || this.avX.byQ() > this.fTi)) {
            this.bUi.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(e.j.sub_pb_load_more), Integer.valueOf(this.avX.byQ())));
            this.fTk.setOnClickListener(this.fTf);
            SparseArray sparseArray = (SparseArray) this.fTk.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.fTk.setTag(sparseArray);
            }
            sparseArray.put(e.g.tag_load_sub_data, this.avX);
            sparseArray.put(e.g.tag_load_sub_view, this.mRootView);
            this.fTk.setVisibility(0);
            this.fTk.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.fTk.setVisibility(8);
        }
        if (this.fTk.getVisibility() == 0) {
            return this.fTk.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.avX != null && this.avX.byJ() != null) {
            int size = this.fTj.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.fTj.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.fTl, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fTi;
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
            if (this.fTk.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fTk.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.fTk.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.fTk.getMeasuredWidth(), this.fTk.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.fTi; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.fTk) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.avX != null && this.avX.byJ() != null) {
            int i = this.fTi;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.fTk.getVisibility() == 0) {
                drawChild(canvas, this.fTk, drawingTime);
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
    /* renamed from: bim */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bUi != null) {
            this.bUi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_lou_more), (Drawable) null);
            al.h(this.bUi, e.d.cp_cont_d);
        }
    }
}
