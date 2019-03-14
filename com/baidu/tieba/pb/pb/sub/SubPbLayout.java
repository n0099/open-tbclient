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
    private PostData bTm;
    private TextView dwE;
    private View.OnClickListener hCS;
    private View.OnLongClickListener hCT;
    private View.OnTouchListener hCU;
    private int hCV;
    private final Queue<a> hCW;
    private RelativeLayout hCX;
    private ViewGroup.MarginLayoutParams hCY;
    private c hpN;
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
        this.hCV = 0;
        this.mRootView = null;
        this.hCW = new LinkedList();
        this.hCY = new ViewGroup.MarginLayoutParams(-1, -2);
        this.hCX = new RelativeLayout(context);
        this.hCX.setId(d.g.pb_floor_reply_more);
        this.dwE = new TextView(context);
        this.dwE.setPadding(0, l.h(context, d.e.tbds2), 0, l.h(context, d.e.tbds12));
        this.dwE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
        this.dwE.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds4));
        this.dwE.setTextSize(0, l.h(context, d.e.tbds40));
        al.j(this.dwE, d.C0277d.cp_cont_c);
        this.hCX.addView(this.dwE);
        addView(this.hCX, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.hCS = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.hCT = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.hCU = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.hpN = cVar;
    }

    public void setData(PostData postData, View view) {
        this.bTm = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> ceq;
        if (this.hpN == null || this.bTm == null || this.bTm.ceq() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.bTm.cep()) {
            ceq = this.bTm.cem();
        } else {
            ceq = this.bTm.ceq();
        }
        setMeasuredDimension(size, bW(v.S(ceq), size) + n(ceq, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.bTm.ceF() == 1 || this.bTm.ceF() == 3) {
            this.hCV = 0;
            return 0;
        } else if (v.S(list) != 0) {
            int S = v.S(list);
            this.hCV = S;
            if (!this.bTm.cep()) {
                if (S <= 2) {
                    this.hCV = S;
                } else {
                    this.hCV = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.hCV) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.hCX)) {
                    childAt = this.hpN.oM();
                    childAt.setPadding(0, 0, 0, 0);
                    this.hCW.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.hCS);
                view.setOnLongClickListener(this.hCT);
                view.setOnTouchListener(this.hCU);
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
                if (sparseArray.get(d.g.tag_load_sub_data) != this.bTm) {
                    sparseArray.put(d.g.tag_load_sub_data, this.bTm);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).YR() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).YR().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).YR().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.hpN.a((c.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.bTm.cex() > list.size() || list.size() - i2 > 1, i2 == 0, false);
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
        if (i > 0 && (this.bTm.ceF() == 1 || this.bTm.ceF() == 3 || this.bTm.cex() > this.hCV)) {
            this.dwE.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.bTm.cex())));
            this.hCX.setOnClickListener(this.hCS);
            SparseArray sparseArray = (SparseArray) this.hCX.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.hCX.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.bTm);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.hCX.setVisibility(0);
            this.hCX.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.hCX.setVisibility(8);
        }
        if (this.hCX.getVisibility() == 0) {
            return this.hCX.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.bTm != null && this.bTm.ceq() != null) {
            int size = this.hCW.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.hCW.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.hCY, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.hCV;
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
            if (this.hCX.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hCX.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.hCX.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.hCX.getMeasuredWidth(), this.hCX.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.hCV; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.hCX) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.bTm != null && this.bTm.ceq() != null) {
            int i = this.hCV;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.hCX.getVisibility() == 0) {
                drawChild(canvas, this.hCX, drawingTime);
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
    /* renamed from: bOD */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.dwE != null) {
            this.dwE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
            al.j(this.dwE, d.C0277d.cp_cont_c);
        }
    }
}
