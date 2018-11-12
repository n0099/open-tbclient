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
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
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
/* loaded from: classes6.dex */
public class SubPbLayout extends ViewGroup {
    private PostData aBx;
    private TextView ccW;
    private c fOS;
    private View.OnClickListener gcc;
    private View.OnLongClickListener gcd;
    private View.OnTouchListener gce;
    private int gcf;
    private final Queue<a> gcg;
    private RelativeLayout gch;
    private ViewGroup.MarginLayoutParams gci;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
        this.gcf = 0;
        this.mRootView = null;
        this.gcg = new LinkedList();
        this.gci = new ViewGroup.MarginLayoutParams(-1, -2);
        this.gch = new RelativeLayout(context);
        this.gch.setId(e.g.pb_floor_reply_more);
        this.ccW = new TextView(context);
        this.ccW.setPadding(0, l.h(context, e.C0200e.tbds14), 0, l.h(context, e.C0200e.tbds22));
        this.ccW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_lou_more), (Drawable) null);
        this.ccW.setTextSize(0, l.h(context, e.C0200e.tbfontsize42));
        al.h(this.ccW, e.d.cp_cont_d);
        this.gch.addView(this.ccW);
        addView(this.gch, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.gcc = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.gcd = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.gce = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.fOS = cVar;
    }

    public void setData(PostData postData, View view) {
        this.aBx = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bBu;
        if (this.fOS == null || this.aBx == null || this.aBx.bBu() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.aBx.bBt()) {
            bBu = this.aBx.bBq();
        } else {
            bBu = this.aBx.bBu();
        }
        setMeasuredDimension(size, bB(v.H(bBu), size) + o(bBu, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int o(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.aBx.bBJ() == 1 || this.aBx.bBJ() == 3) {
            this.gcf = 0;
            return 0;
        } else if (v.H(list) != 0) {
            int H = v.H(list);
            this.gcf = H;
            if (!this.aBx.bBt()) {
                if (H <= 2) {
                    this.gcf = H;
                } else {
                    this.gcf = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.gcf) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.gch)) {
                    childAt = this.fOS.oE();
                    childAt.setPadding(0, 0, 0, 0);
                    this.gcg.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.gcc);
                view.setOnLongClickListener(this.gcd);
                view.setOnTouchListener(this.gce);
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
                if (sparseArray.get(e.g.tag_load_sub_data) != this.aBx) {
                    sparseArray.put(e.g.tag_load_sub_data, this.aBx);
                }
                sparseArray.put(e.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(e.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).yC() != null) {
                    sparseArray.put(e.g.tag_photo_username, list.get(i2).yC().getUserName());
                    sparseArray.put(e.g.tag_photo_userid, list.get(i2).yC().getUserId());
                    sparseArray.put(e.g.tag_clip_board, list.get(i2));
                }
                this.fOS.a((c.b) sparseArray.get(e.g.tag_holder), list.get(i2), this.aBx.bBB() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + AiAppsFileUtils.GB, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int bB(int i, int i2) {
        if (i > 0 && (this.aBx.bBJ() == 1 || this.aBx.bBJ() == 3 || this.aBx.bBB() > this.gcf)) {
            this.ccW.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(e.j.sub_pb_load_more), Integer.valueOf(this.aBx.bBB())));
            this.gch.setOnClickListener(this.gcc);
            SparseArray sparseArray = (SparseArray) this.gch.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.gch.setTag(sparseArray);
            }
            sparseArray.put(e.g.tag_load_sub_data, this.aBx);
            sparseArray.put(e.g.tag_load_sub_view, this.mRootView);
            this.gch.setVisibility(0);
            this.gch.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + AiAppsFileUtils.GB, 0);
        } else {
            this.gch.setVisibility(8);
        }
        if (this.gch.getVisibility() == 0) {
            return this.gch.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.aBx != null && this.aBx.bBu() != null) {
            int size = this.gcg.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.gcg.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.gci, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.gcf;
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
            if (this.gch.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gch.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.gch.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.gch.getMeasuredWidth(), this.gch.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.gcf; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.gch) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.aBx != null && this.aBx.bBu() != null) {
            int i = this.gcf;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.gch.getVisibility() == 0) {
                drawChild(canvas, this.gch, drawingTime);
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
    /* renamed from: bkU */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.ccW != null) {
            this.ccW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_lou_more), (Drawable) null);
            al.h(this.ccW, e.d.cp_cont_d);
        }
    }
}
