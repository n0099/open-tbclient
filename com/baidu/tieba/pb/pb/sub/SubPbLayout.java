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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes9.dex */
public class SubPbLayout extends ViewGroup {
    private PostData eez;
    private TextView gbh;
    private b kda;
    private int kuA;
    private final Queue<a> kuB;
    private RelativeLayout kuC;
    private ViewGroup.MarginLayoutParams kuD;
    private View.OnClickListener kux;
    private View.OnLongClickListener kuy;
    private View.OnTouchListener kuz;
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
        this.kuA = 0;
        this.mRootView = null;
        this.kuB = new LinkedList();
        this.kuD = new ViewGroup.MarginLayoutParams(-1, -2);
        this.kuC = new RelativeLayout(context);
        this.kuC.setId(R.id.pb_floor_reply_more);
        this.gbh = new TextView(context);
        this.gbh.setPadding(0, l.getDimens(context, R.dimen.tbds2), 0, l.getDimens(context, R.dimen.tbds12));
        this.gbh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.gbh.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.gbh.setTextSize(0, l.getDimens(context, R.dimen.tbds40));
        an.setViewTextColor(this.gbh, (int) R.color.cp_cont_c);
        this.kuC.addView(this.gbh);
        addView(this.kuC, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.kux = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.kuy = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.kuz = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.kda = bVar;
    }

    public void setData(PostData postData, View view) {
        this.eez = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dhV;
        if (this.kda == null || this.eez == null || this.eez.dhV() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.eez.dhU()) {
            dhV = this.eez.dhR();
        } else {
            dhV = this.eez.dhV();
        }
        setMeasuredDimension(size, cL(w.getCount(dhV), size) + p(dhV, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int p(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.eez.dik() == 1 || this.eez.dik() == 3) {
            this.kuA = 0;
            return 0;
        } else if (w.getCount(list) != 0) {
            int count = w.getCount(list);
            this.kuA = count;
            if (!this.eez.dhU()) {
                if (count <= 2) {
                    this.kuA = count;
                } else {
                    this.kuA = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.kuA) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.kuC)) {
                    childAt = this.kda.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.kuB.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.kux);
                view.setOnLongClickListener(this.kuy);
                view.setOnTouchListener(this.kuz);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.eez) {
                    sparseArray.put(R.id.tag_load_sub_data, this.eez);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).aSp() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).aSp().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).aSp().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.kda.a((b.C0711b) sparseArray.get(R.id.tag_holder), list.get(i2), this.eez.dic() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cL(int i, int i2) {
        if (i > 0 && (this.eez.dik() == 1 || this.eez.dik() == 3 || this.eez.dic() > this.kuA)) {
            this.gbh.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.eez.dic())));
            this.kuC.setOnClickListener(this.kux);
            SparseArray sparseArray = (SparseArray) this.kuC.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.kuC.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.eez);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.kuC.setVisibility(0);
            this.kuC.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.kuC.setVisibility(8);
        }
        if (this.kuC.getVisibility() == 0) {
            return this.kuC.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eez != null && this.eez.dhV() != null) {
            int size = this.kuB.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.kuB.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.kuD, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.kuA;
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
            if (this.kuC.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.kuC.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.kuC.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.kuC.getMeasuredWidth(), this.kuC.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.kuA; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.kuC) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eez != null && this.eez.dhV() != null) {
            int i = this.kuA;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.kuC.getVisibility() == 0) {
                drawChild(canvas, this.kuC, drawingTime);
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
    /* renamed from: cOs */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.gbh != null) {
            this.gbh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            an.setViewTextColor(this.gbh, (int) R.color.cp_cont_c);
        }
    }
}
