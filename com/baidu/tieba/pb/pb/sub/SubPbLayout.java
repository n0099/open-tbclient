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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes2.dex */
public class SubPbLayout extends ViewGroup {
    private TextView bOt;
    private PostData fLA;
    private final Queue<a> fLB;
    private RelativeLayout fLC;
    private ViewGroup.MarginLayoutParams fLD;
    private View.OnClickListener fLw;
    private View.OnLongClickListener fLx;
    private View.OnTouchListener fLy;
    private int fLz;
    private c fyd;
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
        this.fLz = 0;
        this.mRootView = null;
        this.fLB = new LinkedList();
        this.fLD = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fLC = new RelativeLayout(context);
        this.fLC.setId(f.g.pb_floor_reply_more);
        this.bOt = new TextView(context);
        this.bOt.setPadding(0, l.f(context, f.e.tbds14), 0, l.f(context, f.e.tbds22));
        this.bOt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_lou_more), (Drawable) null);
        this.bOt.setTextSize(0, l.f(context, f.e.tbfontsize42));
        am.h(this.bOt, f.d.cp_cont_d);
        this.fLC.addView(this.bOt);
        addView(this.fLC, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fLw = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fLx = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fLy = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.fyd = cVar;
    }

    public void setData(PostData postData, View view) {
        this.fLA = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bwd;
        if (this.fyd == null || this.fLA == null || this.fLA.bwd() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fLA.bwc()) {
            bwd = this.fLA.bvZ();
        } else {
            bwd = this.fLA.bwd();
        }
        setMeasuredDimension(size, bs(w.y(bwd), size) + n(bwd, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.fLA.bwu() == 1) {
            this.fLz = 0;
            return 0;
        } else if (w.y(list) != 0) {
            int y = w.y(list);
            this.fLz = y;
            if (!this.fLA.bwc()) {
                if (y <= 2) {
                    this.fLz = y;
                } else {
                    this.fLz = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.fLz) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.fLC)) {
                    childAt = this.fyd.np();
                    childAt.setPadding(0, 0, 0, 0);
                    this.fLB.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.fLw);
                view.setOnLongClickListener(this.fLx);
                view.setOnTouchListener(this.fLy);
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
                if (sparseArray.get(f.g.tag_load_sub_data) != this.fLA) {
                    sparseArray.put(f.g.tag_load_sub_data, this.fLA);
                }
                sparseArray.put(f.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(f.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).vj() != null) {
                    sparseArray.put(f.g.tag_photo_username, list.get(i2).vj().getUserName());
                    sparseArray.put(f.g.tag_photo_userid, list.get(i2).vj().getUserId());
                    sparseArray.put(f.g.tag_clip_board, list.get(i2));
                }
                this.fyd.a((c.b) sparseArray.get(f.g.tag_holder), list.get(i2), this.fLA.bwk() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int bs(int i, int i2) {
        if (i > 0 && (this.fLA.bwu() == 1 || this.fLA.bwk() > this.fLz)) {
            this.bOt.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(f.j.sub_pb_load_more), Integer.valueOf(this.fLA.bwk())));
            this.fLC.setOnClickListener(this.fLw);
            SparseArray sparseArray = (SparseArray) this.fLC.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.fLC.setTag(sparseArray);
            }
            sparseArray.put(f.g.tag_load_sub_data, this.fLA);
            sparseArray.put(f.g.tag_load_sub_view, this.mRootView);
            this.fLC.setVisibility(0);
            this.fLC.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.fLC.setVisibility(8);
        }
        if (this.fLC.getVisibility() == 0) {
            return this.fLC.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fLA != null && this.fLA.bwd() != null) {
            int size = this.fLB.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.fLB.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.fLD, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fLz;
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
            if (this.fLC.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fLC.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.fLC.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.fLC.getMeasuredWidth(), this.fLC.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.fLz; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.fLC) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fLA != null && this.fLA.bwd() != null) {
            int i = this.fLz;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.fLC.getVisibility() == 0) {
                drawChild(canvas, this.fLC, drawingTime);
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
    /* renamed from: bfI */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bOt != null) {
            this.bOt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_lou_more), (Drawable) null);
            am.h(this.bOt, f.d.cp_cont_d);
        }
    }
}
