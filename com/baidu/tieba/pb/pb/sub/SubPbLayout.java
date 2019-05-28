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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes4.dex */
public class SubPbLayout extends ViewGroup {
    private PostData cbh;
    private TextView dHl;
    private c hHg;
    private View.OnClickListener hUI;
    private View.OnLongClickListener hUJ;
    private View.OnTouchListener hUK;
    private int hUL;
    private final Queue<a> hUM;
    private RelativeLayout hUN;
    private ViewGroup.MarginLayoutParams hUO;
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
        this.hUL = 0;
        this.mRootView = null;
        this.hUM = new LinkedList();
        this.hUO = new ViewGroup.MarginLayoutParams(-1, -2);
        this.hUN = new RelativeLayout(context);
        this.hUN.setId(R.id.pb_floor_reply_more);
        this.dHl = new TextView(context);
        this.dHl.setPadding(0, l.g(context, R.dimen.tbds2), 0, l.g(context, R.dimen.tbds12));
        this.dHl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.dHl.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.dHl.setTextSize(0, l.g(context, R.dimen.tbds40));
        al.j(this.dHl, R.color.cp_cont_c);
        this.hUN.addView(this.dHl);
        addView(this.hUN, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.hUI = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.hUJ = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.hUK = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.hHg = cVar;
    }

    public void setData(PostData postData, View view) {
        this.cbh = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> cmt;
        if (this.hHg == null || this.cbh == null || this.cbh.cmt() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.cbh.cms()) {
            cmt = this.cbh.cmp();
        } else {
            cmt = this.cbh.cmt();
        }
        setMeasuredDimension(size, cd(v.Z(cmt), size) + n(cmt, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.cbh.cmI() == 1 || this.cbh.cmI() == 3) {
            this.hUL = 0;
            return 0;
        } else if (v.Z(list) != 0) {
            int Z = v.Z(list);
            this.hUL = Z;
            if (!this.cbh.cms()) {
                if (Z <= 2) {
                    this.hUL = Z;
                } else {
                    this.hUL = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.hUL) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.hUN)) {
                    childAt = this.hHg.nG();
                    childAt.setPadding(0, 0, 0, 0);
                    this.hUM.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.hUI);
                view.setOnLongClickListener(this.hUJ);
                view.setOnTouchListener(this.hUK);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.cbh) {
                    sparseArray.put(R.id.tag_load_sub_data, this.cbh);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).adv() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).adv().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).adv().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.hHg.a((c.b) sparseArray.get(R.id.tag_holder), list.get(i2), this.cbh.cmA() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cd(int i, int i2) {
        if (i > 0 && (this.cbh.cmI() == 1 || this.cbh.cmI() == 3 || this.cbh.cmA() > this.hUL)) {
            this.dHl.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.cbh.cmA())));
            this.hUN.setOnClickListener(this.hUI);
            SparseArray sparseArray = (SparseArray) this.hUN.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.hUN.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.cbh);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.hUN.setVisibility(0);
            this.hUN.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.hUN.setVisibility(8);
        }
        if (this.hUN.getVisibility() == 0) {
            return this.hUN.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.cbh != null && this.cbh.cmt() != null) {
            int size = this.hUM.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.hUM.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.hUO, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.hUL;
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
            if (this.hUN.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hUN.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.hUN.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.hUN.getMeasuredWidth(), this.hUN.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.hUL; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.hUN) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.cbh != null && this.cbh.cmt() != null) {
            int i = this.hUL;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.hUN.getVisibility() == 0) {
                drawChild(canvas, this.hUN, drawingTime);
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
    /* renamed from: bWw */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.dHl != null) {
            this.dHl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            al.j(this.dHl, R.color.cp_cont_c);
        }
    }
}
