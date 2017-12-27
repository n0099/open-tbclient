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
    private d fDy;
    private View.OnClickListener fVB;
    private View.OnLongClickListener fVC;
    private View.OnTouchListener fVD;
    private int fVE;
    private PostData fVF;
    private final Queue<a> fVG;
    private RelativeLayout fVH;
    private TextView fVI;
    private ViewGroup.MarginLayoutParams fVJ;
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
        this.fVE = 0;
        this.mRootView = null;
        this.fVG = new LinkedList();
        this.fVJ = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fVH = new RelativeLayout(context);
        this.fVH.setId(d.g.pb_floor_reply_more);
        this.fVI = new TextView(context);
        this.fVI.setPadding(0, l.s(context, d.e.tbds15), 0, l.s(context, d.e.tbds17));
        this.fVI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.fVI.setTextSize(0, l.s(context, d.e.tbfontsize33));
        aj.r(this.fVI, d.C0108d.cp_cont_d);
        this.fVH.addView(this.fVI);
        addView(this.fVH, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fVB = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fVC = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fVD = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.fDy = dVar;
    }

    public void a(PostData postData, View view) {
        this.fVF = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bCi;
        if (this.fDy == null || this.fVF == null || this.fVF.bCi() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fVF.bCg()) {
            bCi = this.fVF.bCd();
        } else {
            bCi = this.fVF.bCi();
        }
        setMeasuredDimension(size, cu(v.F(bCi), size) + q(bCi, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.fVF.bCC() == 1) {
            this.fVE = 0;
            return 0;
        } else if (v.F(list) != 0) {
            int F = v.F(list);
            this.fVE = F;
            if (!this.fVF.bCg()) {
                if (F <= 2) {
                    this.fVE = F;
                } else {
                    this.fVE = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.fVE) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.fVH)) {
                    childAt = this.fDy.su();
                    childAt.setPadding(0, 0, 0, 0);
                    this.fVG.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.fVB);
                view.setOnLongClickListener(this.fVC);
                view.setOnTouchListener(this.fVD);
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
                if (sparseArray.get(d.g.tag_load_sub_data) != this.fVF) {
                    sparseArray.put(d.g.tag_load_sub_data, this.fVF);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).yX() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).yX().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).yX().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.fDy.a((d.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.fVF.bCq() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cu(int i, int i2) {
        if (i > 0 && (this.fVF.bCC() == 1 || this.fVF.bCq() > this.fVE)) {
            this.fVI.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.fVF.bCq())));
            this.fVH.setOnClickListener(this.fVB);
            SparseArray sparseArray = (SparseArray) this.fVH.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.fVH.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.fVF);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.fVH.setVisibility(0);
            this.fVH.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.fVH.setVisibility(8);
        }
        if (this.fVH.getVisibility() == 0) {
            return this.fVH.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fVF != null && this.fVF.bCi() != null) {
            int size = this.fVG.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.fVG.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.fVJ, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fVE;
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
            if (this.fVH.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fVH.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.fVH.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.fVH.getMeasuredWidth(), this.fVH.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.fVE; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.fVH) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fVF != null && this.fVF.bCi() != null) {
            int i = this.fVE;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.fVH.getVisibility() == 0) {
                drawChild(canvas, this.fVH, drawingTime);
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
    /* renamed from: bff */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.fVI != null) {
            this.fVI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
            aj.r(this.fVI, d.C0108d.cp_cont_d);
        }
    }
}
