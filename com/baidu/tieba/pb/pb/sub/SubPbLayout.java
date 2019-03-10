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
    private PostData bTl;
    private TextView dwI;
    private View.OnClickListener hCY;
    private View.OnLongClickListener hCZ;
    private View.OnTouchListener hDa;
    private int hDb;
    private final Queue<a> hDc;
    private RelativeLayout hDd;
    private ViewGroup.MarginLayoutParams hDe;
    private c hpU;
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
        this.hDb = 0;
        this.mRootView = null;
        this.hDc = new LinkedList();
        this.hDe = new ViewGroup.MarginLayoutParams(-1, -2);
        this.hDd = new RelativeLayout(context);
        this.hDd.setId(d.g.pb_floor_reply_more);
        this.dwI = new TextView(context);
        this.dwI.setPadding(0, l.h(context, d.e.tbds2), 0, l.h(context, d.e.tbds12));
        this.dwI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
        this.dwI.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.tbds4));
        this.dwI.setTextSize(0, l.h(context, d.e.tbds40));
        al.j(this.dwI, d.C0236d.cp_cont_c);
        this.hDd.addView(this.dwI);
        addView(this.hDd, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.hCY = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.hCZ = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.hDa = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.hpU = cVar;
    }

    public void setData(PostData postData, View view) {
        this.bTl = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> ceo;
        if (this.hpU == null || this.bTl == null || this.bTl.ceo() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.bTl.cen()) {
            ceo = this.bTl.cek();
        } else {
            ceo = this.bTl.ceo();
        }
        setMeasuredDimension(size, bW(v.S(ceo), size) + n(ceo, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.bTl.ceD() == 1 || this.bTl.ceD() == 3) {
            this.hDb = 0;
            return 0;
        } else if (v.S(list) != 0) {
            int S = v.S(list);
            this.hDb = S;
            if (!this.bTl.cen()) {
                if (S <= 2) {
                    this.hDb = S;
                } else {
                    this.hDb = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.hDb) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.hDd)) {
                    childAt = this.hpU.oM();
                    childAt.setPadding(0, 0, 0, 0);
                    this.hDc.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.hCY);
                view.setOnLongClickListener(this.hCZ);
                view.setOnTouchListener(this.hDa);
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
                if (sparseArray.get(d.g.tag_load_sub_data) != this.bTl) {
                    sparseArray.put(d.g.tag_load_sub_data, this.bTl);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).YR() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).YR().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).YR().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.hpU.a((c.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.bTl.cev() > list.size() || list.size() - i2 > 1, i2 == 0, false);
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
        if (i > 0 && (this.bTl.ceD() == 1 || this.bTl.ceD() == 3 || this.bTl.cev() > this.hDb)) {
            this.dwI.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.bTl.cev())));
            this.hDd.setOnClickListener(this.hCY);
            SparseArray sparseArray = (SparseArray) this.hDd.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.hDd.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.bTl);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.hDd.setVisibility(0);
            this.hDd.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.hDd.setVisibility(8);
        }
        if (this.hDd.getVisibility() == 0) {
            return this.hDd.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.bTl != null && this.bTl.ceo() != null) {
            int size = this.hDc.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.hDc.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.hDe, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.hDb;
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
            if (this.hDd.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hDd.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.hDd.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.hDd.getMeasuredWidth(), this.hDd.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.hDb; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.hDd) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.bTl != null && this.bTl.ceo() != null) {
            int i = this.hDb;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.hDd.getVisibility() == 0) {
                drawChild(canvas, this.hDd, drawingTime);
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
        if (this.dwI != null) {
            this.dwI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_pb_comment_more_n), (Drawable) null);
            al.j(this.dwI, d.C0236d.cp_cont_c);
        }
    }
}
