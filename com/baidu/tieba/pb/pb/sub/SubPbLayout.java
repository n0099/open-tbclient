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
/* loaded from: classes6.dex */
public class SubPbLayout extends ViewGroup {
    private PostData ddZ;
    private TextView eQC;
    private b iAp;
    private View.OnClickListener iQR;
    private View.OnLongClickListener iQS;
    private View.OnTouchListener iQT;
    private int iQU;
    private final Queue<a> iQV;
    private RelativeLayout iQW;
    private ViewGroup.MarginLayoutParams iQX;
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
        this.iQU = 0;
        this.mRootView = null;
        this.iQV = new LinkedList();
        this.iQX = new ViewGroup.MarginLayoutParams(-1, -2);
        this.iQW = new RelativeLayout(context);
        this.iQW.setId(R.id.pb_floor_reply_more);
        this.eQC = new TextView(context);
        this.eQC.setPadding(0, l.getDimens(context, R.dimen.tbds2), 0, l.getDimens(context, R.dimen.tbds12));
        this.eQC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.eQC.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.eQC.setTextSize(0, l.getDimens(context, R.dimen.tbds40));
        am.setViewTextColor(this.eQC, (int) R.color.cp_cont_c);
        this.iQW.addView(this.eQC);
        addView(this.iQW, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.iQR = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iQS = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.iQT = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.iAp = bVar;
    }

    public void setData(PostData postData, View view) {
        this.ddZ = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> cIq;
        if (this.iAp == null || this.ddZ == null || this.ddZ.cIq() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.ddZ.cIp()) {
            cIq = this.ddZ.cIm();
        } else {
            cIq = this.ddZ.cIq();
        }
        setMeasuredDimension(size, ct(v.getCount(cIq), size) + l(cIq, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int l(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.ddZ.cIF() == 1 || this.ddZ.cIF() == 3) {
            this.iQU = 0;
            return 0;
        } else if (v.getCount(list) != 0) {
            int count = v.getCount(list);
            this.iQU = count;
            if (!this.ddZ.cIp()) {
                if (count <= 2) {
                    this.iQU = count;
                } else {
                    this.iQU = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.iQU) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.iQW)) {
                    childAt = this.iAp.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.iQV.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.iQR);
                view.setOnLongClickListener(this.iQS);
                view.setOnTouchListener(this.iQT);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.ddZ) {
                    sparseArray.put(R.id.tag_load_sub_data, this.ddZ);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).azE() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).azE().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).azE().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.iAp.a((b.C0569b) sparseArray.get(R.id.tag_holder), list.get(i2), this.ddZ.cIx() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int ct(int i, int i2) {
        if (i > 0 && (this.ddZ.cIF() == 1 || this.ddZ.cIF() == 3 || this.ddZ.cIx() > this.iQU)) {
            this.eQC.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.ddZ.cIx())));
            this.iQW.setOnClickListener(this.iQR);
            SparseArray sparseArray = (SparseArray) this.iQW.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.iQW.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.ddZ);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.iQW.setVisibility(0);
            this.iQW.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.iQW.setVisibility(8);
        }
        if (this.iQW.getVisibility() == 0) {
            return this.iQW.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.ddZ != null && this.ddZ.cIq() != null) {
            int size = this.iQV.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.iQV.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.iQX, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.iQU;
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
            if (this.iQW.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iQW.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.iQW.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.iQW.getMeasuredWidth(), this.iQW.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.iQU; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.iQW) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.ddZ != null && this.ddZ.cIq() != null) {
            int i = this.iQU;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.iQW.getVisibility() == 0) {
                drawChild(canvas, this.iQW, drawingTime);
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
    /* renamed from: cpm */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.eQC != null) {
            this.eQC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            am.setViewTextColor(this.eQC, (int) R.color.cp_cont_c);
        }
    }
}
