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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes2.dex */
public class SubPbLayout extends ViewGroup {
    private TextView bNz;
    private View.OnClickListener fLp;
    private View.OnLongClickListener fLq;
    private View.OnTouchListener fLr;
    private int fLs;
    private PostData fLt;
    private final Queue<a> fLu;
    private RelativeLayout fLv;
    private ViewGroup.MarginLayoutParams fLw;
    private c fxY;
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
        this.fLs = 0;
        this.mRootView = null;
        this.fLu = new LinkedList();
        this.fLw = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fLv = new RelativeLayout(context);
        this.fLv.setId(d.g.pb_floor_reply_more);
        this.bNz = new TextView(context);
        this.bNz.setPadding(0, l.e(context, d.e.tbds14), 0, l.e(context, d.e.tbds22));
        this.bNz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.bNz.setTextSize(0, l.e(context, d.e.tbfontsize42));
        am.h(this.bNz, d.C0142d.cp_cont_d);
        this.fLv.addView(this.bNz);
        addView(this.fLv, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fLp = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fLq = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fLr = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.fxY = cVar;
    }

    public void setData(PostData postData, View view) {
        this.fLt = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bxz;
        if (this.fxY == null || this.fLt == null || this.fLt.bxz() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fLt.bxy()) {
            bxz = this.fLt.bxv();
        } else {
            bxz = this.fLt.bxz();
        }
        setMeasuredDimension(size, br(w.z(bxz), size) + n(bxz, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.fLt.bxQ() == 1) {
            this.fLs = 0;
            return 0;
        } else if (w.z(list) != 0) {
            int z = w.z(list);
            this.fLs = z;
            if (!this.fLt.bxy()) {
                if (z <= 2) {
                    this.fLs = z;
                } else {
                    this.fLs = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.fLs) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.fLv)) {
                    childAt = this.fxY.nn();
                    childAt.setPadding(0, 0, 0, 0);
                    this.fLu.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.fLp);
                view.setOnLongClickListener(this.fLq);
                view.setOnTouchListener(this.fLr);
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
                if (sparseArray.get(d.g.tag_load_sub_data) != this.fLt) {
                    sparseArray.put(d.g.tag_load_sub_data, this.fLt);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).vw() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).vw().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).vw().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.fxY.a((c.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.fLt.bxG() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int br(int i, int i2) {
        if (i > 0 && (this.fLt.bxQ() == 1 || this.fLt.bxG() > this.fLs)) {
            this.bNz.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.k.sub_pb_load_more), Integer.valueOf(this.fLt.bxG())));
            this.fLv.setOnClickListener(this.fLp);
            SparseArray sparseArray = (SparseArray) this.fLv.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.fLv.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.fLt);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.fLv.setVisibility(0);
            this.fLv.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.fLv.setVisibility(8);
        }
        if (this.fLv.getVisibility() == 0) {
            return this.fLv.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fLt != null && this.fLt.bxz() != null) {
            int size = this.fLu.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.fLu.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.fLw, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fLs;
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
            if (this.fLv.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fLv.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.fLv.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.fLv.getMeasuredWidth(), this.fLv.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.fLs; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.fLv) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fLt != null && this.fLt.bxz() != null) {
            int i = this.fLs;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.fLv.getVisibility() == 0) {
                drawChild(canvas, this.fLv, drawingTime);
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
    /* renamed from: bhu */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bNz != null) {
            this.bNz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_lou_more), (Drawable) null);
            am.h(this.bNz, d.C0142d.cp_cont_d);
        }
    }
}
