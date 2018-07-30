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
    private TextView bOu;
    private View.OnClickListener fLD;
    private View.OnLongClickListener fLE;
    private View.OnTouchListener fLF;
    private int fLG;
    private PostData fLH;
    private final Queue<a> fLI;
    private RelativeLayout fLJ;
    private ViewGroup.MarginLayoutParams fLK;
    private c fyk;
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
        this.fLG = 0;
        this.mRootView = null;
        this.fLI = new LinkedList();
        this.fLK = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fLJ = new RelativeLayout(context);
        this.fLJ.setId(d.g.pb_floor_reply_more);
        this.bOu = new TextView(context);
        this.bOu.setPadding(0, l.f(context, d.e.tbds14), 0, l.f(context, d.e.tbds22));
        this.bOu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.bOu.setTextSize(0, l.f(context, d.e.tbfontsize42));
        am.h(this.bOu, d.C0140d.cp_cont_d);
        this.fLJ.addView(this.bOu);
        addView(this.fLJ, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fLD = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fLE = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fLF = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.fyk = cVar;
    }

    public void setData(PostData postData, View view) {
        this.fLH = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bwc;
        if (this.fyk == null || this.fLH == null || this.fLH.bwc() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fLH.bwb()) {
            bwc = this.fLH.bvY();
        } else {
            bwc = this.fLH.bwc();
        }
        setMeasuredDimension(size, bs(w.y(bwc), size) + n(bwc, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.fLH.bwt() == 1) {
            this.fLG = 0;
            return 0;
        } else if (w.y(list) != 0) {
            int y = w.y(list);
            this.fLG = y;
            if (!this.fLH.bwb()) {
                if (y <= 2) {
                    this.fLG = y;
                } else {
                    this.fLG = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.fLG) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.fLJ)) {
                    childAt = this.fyk.np();
                    childAt.setPadding(0, 0, 0, 0);
                    this.fLI.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.fLD);
                view.setOnLongClickListener(this.fLE);
                view.setOnTouchListener(this.fLF);
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
                if (sparseArray.get(d.g.tag_load_sub_data) != this.fLH) {
                    sparseArray.put(d.g.tag_load_sub_data, this.fLH);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).vk() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).vk().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).vk().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.fyk.a((c.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.fLH.bwj() > list.size() || list.size() - i2 > 1, i2 == 0, false);
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
        if (i > 0 && (this.fLH.bwt() == 1 || this.fLH.bwj() > this.fLG)) {
            this.bOu.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.fLH.bwj())));
            this.fLJ.setOnClickListener(this.fLD);
            SparseArray sparseArray = (SparseArray) this.fLJ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.fLJ.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.fLH);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.fLJ.setVisibility(0);
            this.fLJ.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.fLJ.setVisibility(8);
        }
        if (this.fLJ.getVisibility() == 0) {
            return this.fLJ.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fLH != null && this.fLH.bwc() != null) {
            int size = this.fLI.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.fLI.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.fLK, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fLG;
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
            if (this.fLJ.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fLJ.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.fLJ.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.fLJ.getMeasuredWidth(), this.fLJ.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.fLG; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.fLJ) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fLH != null && this.fLH.bwc() != null) {
            int i = this.fLG;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.fLJ.getVisibility() == 0) {
                drawChild(canvas, this.fLJ, drawingTime);
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
    /* renamed from: bfN */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bOu != null) {
            this.bOu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_lou_more), (Drawable) null);
            am.h(this.bOu, d.C0140d.cp_cont_d);
        }
    }
}
