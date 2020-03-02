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
    private PostData dip;
    private TextView eVT;
    private b iFz;
    private View.OnClickListener iVR;
    private View.OnLongClickListener iVS;
    private View.OnTouchListener iVT;
    private int iVU;
    private final Queue<a> iVV;
    private RelativeLayout iVW;
    private ViewGroup.MarginLayoutParams iVX;
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
        this.iVU = 0;
        this.mRootView = null;
        this.iVV = new LinkedList();
        this.iVX = new ViewGroup.MarginLayoutParams(-1, -2);
        this.iVW = new RelativeLayout(context);
        this.iVW.setId(R.id.pb_floor_reply_more);
        this.eVT = new TextView(context);
        this.eVT.setPadding(0, l.getDimens(context, R.dimen.tbds2), 0, l.getDimens(context, R.dimen.tbds12));
        this.eVT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.eVT.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.eVT.setTextSize(0, l.getDimens(context, R.dimen.tbds40));
        am.setViewTextColor(this.eVT, (int) R.color.cp_cont_c);
        this.iVW.addView(this.eVT);
        addView(this.iVW, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.iVR = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iVS = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.iVT = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.iFz = bVar;
    }

    public void setData(PostData postData, View view) {
        this.dip = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> cKX;
        if (this.iFz == null || this.dip == null || this.dip.cKX() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.dip.cKW()) {
            cKX = this.dip.cKT();
        } else {
            cKX = this.dip.cKX();
        }
        setMeasuredDimension(size, ct(v.getCount(cKX), size) + m(cKX, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int m(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.dip.cLm() == 1 || this.dip.cLm() == 3) {
            this.iVU = 0;
            return 0;
        } else if (v.getCount(list) != 0) {
            int count = v.getCount(list);
            this.iVU = count;
            if (!this.dip.cKW()) {
                if (count <= 2) {
                    this.iVU = count;
                } else {
                    this.iVU = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.iVU) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.iVW)) {
                    childAt = this.iFz.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.iVV.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.iVR);
                view.setOnLongClickListener(this.iVS);
                view.setOnTouchListener(this.iVT);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.dip) {
                    sparseArray.put(R.id.tag_load_sub_data, this.dip);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).aCo() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).aCo().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).aCo().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.iFz.a((b.C0581b) sparseArray.get(R.id.tag_holder), list.get(i2), this.dip.cLe() > list.size() || list.size() - i2 > 1, i2 == 0, false);
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
        if (i > 0 && (this.dip.cLm() == 1 || this.dip.cLm() == 3 || this.dip.cLe() > this.iVU)) {
            this.eVT.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.dip.cLe())));
            this.iVW.setOnClickListener(this.iVR);
            SparseArray sparseArray = (SparseArray) this.iVW.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.iVW.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.dip);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.iVW.setVisibility(0);
            this.iVW.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.iVW.setVisibility(8);
        }
        if (this.iVW.getVisibility() == 0) {
            return this.iVW.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.dip != null && this.dip.cKX() != null) {
            int size = this.iVV.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.iVV.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.iVX, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.iVU;
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
            if (this.iVW.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iVW.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.iVW.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.iVW.getMeasuredWidth(), this.iVW.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.iVU; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.iVW) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.dip != null && this.dip.cKX() != null) {
            int i = this.iVU;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.iVW.getVisibility() == 0) {
                drawChild(canvas, this.iVW, drawingTime);
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
    /* renamed from: crN */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.eVT != null) {
            this.eVT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            am.setViewTextColor(this.eVT, (int) R.color.cp_cont_c);
        }
    }
}
