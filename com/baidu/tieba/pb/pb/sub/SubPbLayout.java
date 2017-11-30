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
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private d ePP;
    private View.OnTouchListener fhA;
    private int fhB;
    private int fhC;
    private int fhD;
    private PostData fhE;
    private final Queue<a> fhF;
    private RelativeLayout fhG;
    private TextView fhH;
    private ViewGroup.MarginLayoutParams fhI;
    private View.OnClickListener fhy;
    private View.OnLongClickListener fhz;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
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
        this.fhB = 0;
        this.fhC = 0;
        this.fhD = 0;
        this.mRootView = null;
        this.fhF = new LinkedList();
        this.fhI = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fhB = l.f(context, d.e.tbds4);
        this.fhC = l.f(context, d.e.tbds17);
        this.fhG = new RelativeLayout(context);
        this.fhG.setId(d.g.pb_floor_reply_more);
        this.fhH = new TextView(context);
        this.fhH.setPadding(0, this.fhB, 0, this.fhC);
        this.fhH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.fhH.setTextSize(0, l.f(context, d.e.tbfontsize30));
        aj.i(this.fhH, d.C0082d.cp_cont_d);
        this.fhG.addView(this.fhH);
        addView(this.fhG, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fhy = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fhz = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fhA = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.ePP = dVar;
    }

    public void a(PostData postData, View view) {
        this.fhE = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bwl;
        if (this.ePP == null || this.fhE == null || this.fhE.bwl() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fhE.bwj()) {
            bwl = this.fhE.bwh();
        } else {
            bwl = this.fhE.bwl();
        }
        setMeasuredDimension(size, bv(v.v(bwl), size) + n(bwl, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.fhE.bwE()) {
            this.fhD = 0;
            return 0;
        } else if (v.v(list) != 0) {
            int v = v.v(list);
            this.fhD = v;
            if (!this.fhE.bwj()) {
                if (v <= 2) {
                    this.fhD = v;
                } else {
                    this.fhD = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.fhD) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.fhG)) {
                    childAt = this.ePP.kX();
                    childAt.setPadding(0, 0, 0, 0);
                    this.fhF.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.fhy);
                view.setOnLongClickListener(this.fhz);
                view.setOnTouchListener(this.fhA);
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
                if (sparseArray.get(d.g.tag_load_sub_data) != this.fhE) {
                    sparseArray.put(d.g.tag_load_sub_data, this.fhE);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).rx() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).rx().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).rx().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.ePP.a((d.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.fhE.bwt() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int bv(int i, int i2) {
        if (i > 0 && (this.fhE.bwE() || this.fhE.bwt() > this.fhD)) {
            this.fhH.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.fhE.bwt())));
            this.fhG.setOnClickListener(this.fhy);
            SparseArray sparseArray = (SparseArray) this.fhG.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.fhG.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.fhE);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.fhG.setVisibility(0);
            this.fhG.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.fhG.setVisibility(8);
        }
        if (this.fhG.getVisibility() == 0) {
            return this.fhG.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fhE != null && this.fhE.bwl() != null) {
            int size = this.fhF.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.fhF.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.fhI, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fhD;
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
            if (this.fhG.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fhG.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.fhG.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.fhG.getMeasuredWidth(), this.fhG.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.fhD; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.fhG) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fhE != null && this.fhE.bwl() != null) {
            int i = this.fhD;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.fhG.getVisibility() == 0) {
                drawChild(canvas, this.fhG, drawingTime);
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
    /* renamed from: aXH */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.fhH != null) {
            this.fhH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
            aj.i(this.fhH, d.C0082d.cp_cont_d);
        }
    }
}
