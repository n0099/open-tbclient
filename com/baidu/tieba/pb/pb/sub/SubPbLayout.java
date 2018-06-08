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
    private TextView bLq;
    private View.OnClickListener fHo;
    private View.OnLongClickListener fHp;
    private View.OnTouchListener fHq;
    private int fHr;
    private PostData fHs;
    private final Queue<a> fHt;
    private RelativeLayout fHu;
    private ViewGroup.MarginLayoutParams fHv;
    private c fug;
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
        this.fHr = 0;
        this.mRootView = null;
        this.fHt = new LinkedList();
        this.fHv = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fHu = new RelativeLayout(context);
        this.fHu.setId(d.g.pb_floor_reply_more);
        this.bLq = new TextView(context);
        this.bLq.setPadding(0, l.e(context, d.e.tbds14), 0, l.e(context, d.e.tbds22));
        this.bLq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.bLq.setTextSize(0, l.e(context, d.e.tbfontsize42));
        al.h(this.bLq, d.C0141d.cp_cont_d);
        this.fHu.addView(this.bLq);
        addView(this.fHu, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fHo = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fHp = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fHq = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.fug = cVar;
    }

    public void setData(PostData postData, View view) {
        this.fHs = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bwW;
        if (this.fug == null || this.fHs == null || this.fHs.bwW() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fHs.bwV()) {
            bwW = this.fHs.bwS();
        } else {
            bwW = this.fHs.bwW();
        }
        setMeasuredDimension(size, bs(w.y(bwW), size) + m(bwW, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int m(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.fHs.bxn() == 1) {
            this.fHr = 0;
            return 0;
        } else if (w.y(list) != 0) {
            int y = w.y(list);
            this.fHr = y;
            if (!this.fHs.bwV()) {
                if (y <= 2) {
                    this.fHr = y;
                } else {
                    this.fHr = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.fHr) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.fHu)) {
                    childAt = this.fug.nn();
                    childAt.setPadding(0, 0, 0, 0);
                    this.fHt.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.fHo);
                view.setOnLongClickListener(this.fHp);
                view.setOnTouchListener(this.fHq);
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
                if (sparseArray.get(d.g.tag_load_sub_data) != this.fHs) {
                    sparseArray.put(d.g.tag_load_sub_data, this.fHs);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).vm() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).vm().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).vm().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.fug.a((c.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.fHs.bxd() > list.size() || list.size() - i2 > 1, i2 == 0, false);
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
        if (i > 0 && (this.fHs.bxn() == 1 || this.fHs.bxd() > this.fHr)) {
            this.bLq.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.k.sub_pb_load_more), Integer.valueOf(this.fHs.bxd())));
            this.fHu.setOnClickListener(this.fHo);
            SparseArray sparseArray = (SparseArray) this.fHu.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.fHu.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.fHs);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.fHu.setVisibility(0);
            this.fHu.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.fHu.setVisibility(8);
        }
        if (this.fHu.getVisibility() == 0) {
            return this.fHu.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fHs != null && this.fHs.bwW() != null) {
            int size = this.fHt.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.fHt.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.fHv, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fHr;
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
            if (this.fHu.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fHu.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.fHu.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.fHu.getMeasuredWidth(), this.fHu.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.fHr; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.fHu) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fHs != null && this.fHs.bwW() != null) {
            int i = this.fHr;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.fHu.getVisibility() == 0) {
                drawChild(canvas, this.fHu, drawingTime);
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
    /* renamed from: bgN */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bLq != null) {
            this.bLq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_lou_more), (Drawable) null);
            al.h(this.bLq, d.C0141d.cp_cont_d);
        }
    }
}
