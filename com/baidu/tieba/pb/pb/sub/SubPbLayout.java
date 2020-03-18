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
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes9.dex */
public class SubPbLayout extends ViewGroup {
    private PostData diR;
    private TextView eWE;
    private b iHm;
    private View.OnClickListener iXE;
    private View.OnLongClickListener iXF;
    private View.OnTouchListener iXG;
    private int iXH;
    private final Queue<a> iXI;
    private RelativeLayout iXJ;
    private ViewGroup.MarginLayoutParams iXK;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
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
        this.iXH = 0;
        this.mRootView = null;
        this.iXI = new LinkedList();
        this.iXK = new ViewGroup.MarginLayoutParams(-1, -2);
        this.iXJ = new RelativeLayout(context);
        this.iXJ.setId(R.id.pb_floor_reply_more);
        this.eWE = new TextView(context);
        this.eWE.setPadding(0, l.getDimens(context, R.dimen.tbds2), 0, l.getDimens(context, R.dimen.tbds12));
        this.eWE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.eWE.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.eWE.setTextSize(0, l.getDimens(context, R.dimen.tbds40));
        am.setViewTextColor(this.eWE, (int) R.color.cp_cont_c);
        this.iXJ.addView(this.eWE);
        addView(this.iXJ, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.iXE = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iXF = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.iXG = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.iHm = bVar;
    }

    public void setData(PostData postData, View view) {
        this.diR = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> cLs;
        if (this.iHm == null || this.diR == null || this.diR.cLs() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.diR.cLr()) {
            cLs = this.diR.cLo();
        } else {
            cLs = this.diR.cLs();
        }
        setMeasuredDimension(size, cu(v.getCount(cLs), size) + l(cLs, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int l(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.diR.cLH() == 1 || this.diR.cLH() == 3) {
            this.iXH = 0;
            return 0;
        } else if (v.getCount(list) != 0) {
            int count = v.getCount(list);
            this.iXH = count;
            if (!this.diR.cLr()) {
                if (count <= 2) {
                    this.iXH = count;
                } else {
                    this.iXH = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.iXH) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.iXJ)) {
                    childAt = this.iHm.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.iXI.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.iXE);
                view.setOnLongClickListener(this.iXF);
                view.setOnTouchListener(this.iXG);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.diR) {
                    sparseArray.put(R.id.tag_load_sub_data, this.diR);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).aCr() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).aCr().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).aCr().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.iHm.a((b.C0582b) sparseArray.get(R.id.tag_holder), list.get(i2), this.diR.cLz() > list.size() || list.size() - i2 > 1, i2 == 0, false);
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
        if (i > 0 && (this.diR.cLH() == 1 || this.diR.cLH() == 3 || this.diR.cLz() > this.iXH)) {
            this.eWE.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.diR.cLz())));
            this.iXJ.setOnClickListener(this.iXE);
            SparseArray sparseArray = (SparseArray) this.iXJ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.iXJ.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.diR);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.iXJ.setVisibility(0);
            this.iXJ.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.iXJ.setVisibility(8);
        }
        if (this.iXJ.getVisibility() == 0) {
            return this.iXJ.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.diR != null && this.diR.cLs() != null) {
            int size = this.iXI.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.iXI.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.iXK, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.iXH;
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
            if (this.iXJ.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iXJ.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.iXJ.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.iXJ.getMeasuredWidth(), this.iXJ.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.iXH; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.iXJ) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.diR != null && this.diR.cLs() != null) {
            int i = this.iXH;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.iXJ.getVisibility() == 0) {
                drawChild(canvas, this.iXJ, drawingTime);
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
    /* renamed from: csj */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.eWE != null) {
            this.eWE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            am.setViewTextColor(this.eWE, (int) R.color.cp_cont_c);
        }
    }
}
