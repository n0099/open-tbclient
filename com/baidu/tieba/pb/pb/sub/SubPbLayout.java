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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes2.dex */
public class SubPbLayout extends ViewGroup {
    private TextView bCs;
    private c fhF;
    private View.OnClickListener fuR;
    private View.OnLongClickListener fuS;
    private View.OnTouchListener fuT;
    private int fuU;
    private PostData fuV;
    private final Queue<a> fuW;
    private RelativeLayout fuX;
    private ViewGroup.MarginLayoutParams fuY;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        int position;

        /* renamed from: view  reason: collision with root package name */
        View f19view;

        private a(int i, View view2) {
            this.position = i;
            this.f19view = view2;
        }
    }

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fuU = 0;
        this.mRootView = null;
        this.fuW = new LinkedList();
        this.fuY = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fuX = new RelativeLayout(context);
        this.fuX.setId(d.g.pb_floor_reply_more);
        this.bCs = new TextView(context);
        this.bCs.setPadding(0, l.e(context, d.e.tbds14), 0, l.e(context, d.e.tbds22));
        this.bCs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.bCs.setTextSize(0, l.e(context, d.e.tbfontsize42));
        ak.h(this.bCs, d.C0126d.cp_cont_d);
        this.fuX.addView(this.bCs);
        addView(this.fuX, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fuR = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fuS = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fuT = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.fhF = cVar;
    }

    public void setData(PostData postData, View view2) {
        this.fuV = postData;
        requestLayout();
        this.mRootView = view2;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> brW;
        if (this.fhF == null || this.fuV == null || this.fuV.brW() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fuV.brV()) {
            brW = this.fuV.brS();
        } else {
            brW = this.fuV.brW();
        }
        setMeasuredDimension(size, br(v.v(brW), size) + l(brW, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int l(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.fuV.bsn() == 1) {
            this.fuU = 0;
            return 0;
        } else if (v.v(list) != 0) {
            int v = v.v(list);
            this.fuU = v;
            if (!this.fuV.brV()) {
                if (v <= 2) {
                    this.fuU = v;
                } else {
                    this.fuU = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.fuU) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.fuX)) {
                    childAt = this.fhF.kA();
                    childAt.setPadding(0, 0, 0, 0);
                    this.fuW.offer(new a(i2, childAt));
                }
                View view2 = childAt;
                view2.setOnClickListener(this.fuR);
                view2.setOnLongClickListener(this.fuS);
                view2.setOnTouchListener(this.fuT);
                view2.setClickable(true);
                view2.setVisibility(0);
                SparseArray sparseArray2 = (SparseArray) view2.getTag();
                if (sparseArray2 == null) {
                    SparseArray sparseArray3 = new SparseArray();
                    view2.setTag(sparseArray3);
                    sparseArray = sparseArray3;
                } else {
                    sparseArray = sparseArray2;
                }
                if (sparseArray.get(d.g.tag_load_sub_data) != this.fuV) {
                    sparseArray.put(d.g.tag_load_sub_data, this.fuV);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).rQ() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).rQ().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).rQ().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.fhF.a((c.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.fuV.bsd() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view2.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view2.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int br(int i, int i2) {
        if (i > 0 && (this.fuV.bsn() == 1 || this.fuV.bsd() > this.fuU)) {
            this.bCs.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.k.sub_pb_load_more), Integer.valueOf(this.fuV.bsd())));
            this.fuX.setOnClickListener(this.fuR);
            SparseArray sparseArray = (SparseArray) this.fuX.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.fuX.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.fuV);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.fuX.setVisibility(0);
            this.fuX.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.fuX.setVisibility(8);
        }
        if (this.fuX.getVisibility() == 0) {
            return this.fuX.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fuV != null && this.fuV.brW() != null) {
            int size = this.fuW.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.fuW.poll();
                if (poll.f19view.getParent() == null) {
                    addViewInLayout(poll.f19view, poll.position, this.fuY, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fuU;
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
            if (this.fuX.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fuX.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.fuX.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.fuX.getMeasuredWidth(), this.fuX.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.fuU; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.fuX) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fuV != null && this.fuV.brW() != null) {
            int i = this.fuU;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.fuX.getVisibility() == 0) {
                drawChild(canvas, this.fuX, drawingTime);
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
    /* renamed from: bbN */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bCs != null) {
            this.bCs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_lou_more), (Drawable) null);
            ak.h(this.bCs, d.C0126d.cp_cont_d);
        }
    }
}
