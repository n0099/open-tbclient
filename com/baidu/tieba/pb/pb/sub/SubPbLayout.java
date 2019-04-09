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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes4.dex */
public class SubPbLayout extends ViewGroup {
    private PostData bTp;
    private TextView dwK;
    private View.OnClickListener hCF;
    private View.OnLongClickListener hCG;
    private View.OnTouchListener hCH;
    private int hCI;
    private final Queue<a> hCJ;
    private RelativeLayout hCK;
    private ViewGroup.MarginLayoutParams hCL;
    private c hpB;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
        this.hCI = 0;
        this.mRootView = null;
        this.hCJ = new LinkedList();
        this.hCL = new ViewGroup.MarginLayoutParams(-1, -2);
        this.hCK = new RelativeLayout(context);
        this.hCK.setId(d.g.pb_floor_reply_more);
        this.dwK = new TextView(context);
        this.dwK.setPadding(0, l.h(context, d.e.tbds2), 0, l.h(context, d.e.tbds12));
        this.dwK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
        this.dwK.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds4));
        this.dwK.setTextSize(0, l.h(context, d.e.tbds40));
        al.j(this.dwK, d.C0277d.cp_cont_c);
        this.hCK.addView(this.dwK);
        addView(this.hCK, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.hCF = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.hCG = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.hCH = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.hpB = cVar;
    }

    public void setData(PostData postData, View view) {
        this.bTp = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> cem;
        if (this.hpB == null || this.bTp == null || this.bTp.cem() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.bTp.cel()) {
            cem = this.bTp.cei();
        } else {
            cem = this.bTp.cem();
        }
        setMeasuredDimension(size, bW(v.S(cem), size) + n(cem, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.bTp.ceB() == 1 || this.bTp.ceB() == 3) {
            this.hCI = 0;
            return 0;
        } else if (v.S(list) != 0) {
            int S = v.S(list);
            this.hCI = S;
            if (!this.bTp.cel()) {
                if (S <= 2) {
                    this.hCI = S;
                } else {
                    this.hCI = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.hCI) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.hCK)) {
                    childAt = this.hpB.oM();
                    childAt.setPadding(0, 0, 0, 0);
                    this.hCJ.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.hCF);
                view.setOnLongClickListener(this.hCG);
                view.setOnTouchListener(this.hCH);
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
                if (sparseArray.get(d.g.tag_load_sub_data) != this.bTp) {
                    sparseArray.put(d.g.tag_load_sub_data, this.bTp);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).YO() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).YO().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).YO().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.hpB.a((c.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.bTp.cet() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int bW(int i, int i2) {
        if (i > 0 && (this.bTp.ceB() == 1 || this.bTp.ceB() == 3 || this.bTp.cet() > this.hCI)) {
            this.dwK.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.bTp.cet())));
            this.hCK.setOnClickListener(this.hCF);
            SparseArray sparseArray = (SparseArray) this.hCK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.hCK.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.bTp);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.hCK.setVisibility(0);
            this.hCK.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.hCK.setVisibility(8);
        }
        if (this.hCK.getVisibility() == 0) {
            return this.hCK.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.bTp != null && this.bTp.cem() != null) {
            int size = this.hCJ.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.hCJ.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.hCL, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.hCI;
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
            if (this.hCK.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hCK.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.hCK.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.hCK.getMeasuredWidth(), this.hCK.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.hCI; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.hCK) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.bTp != null && this.bTp.cem() != null) {
            int i = this.hCI;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.hCK.getVisibility() == 0) {
                drawChild(canvas, this.hCK, drawingTime);
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
    /* renamed from: bOA */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.dwK != null) {
            this.dwK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
            al.j(this.dwK, d.C0277d.cp_cont_c);
        }
    }
}
