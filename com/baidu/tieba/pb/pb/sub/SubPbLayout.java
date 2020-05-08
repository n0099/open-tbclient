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
    private PostData dIO;
    private TextView fAX;
    private View.OnClickListener jHQ;
    private View.OnLongClickListener jHR;
    private View.OnTouchListener jHS;
    private int jHT;
    private final Queue<a> jHU;
    private RelativeLayout jHV;
    private ViewGroup.MarginLayoutParams jHW;
    private b jrx;
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
        this.jHT = 0;
        this.mRootView = null;
        this.jHU = new LinkedList();
        this.jHW = new ViewGroup.MarginLayoutParams(-1, -2);
        this.jHV = new RelativeLayout(context);
        this.jHV.setId(R.id.pb_floor_reply_more);
        this.fAX = new TextView(context);
        this.fAX.setPadding(0, l.getDimens(context, R.dimen.tbds2), 0, l.getDimens(context, R.dimen.tbds12));
        this.fAX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.fAX.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.fAX.setTextSize(0, l.getDimens(context, R.dimen.tbds40));
        am.setViewTextColor(this.fAX, (int) R.color.cp_cont_c);
        this.jHV.addView(this.fAX);
        addView(this.jHV, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.jHQ = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.jHR = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.jHS = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.jrx = bVar;
    }

    public void setData(PostData postData, View view) {
        this.dIO = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> cWl;
        if (this.jrx == null || this.dIO == null || this.dIO.cWl() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.dIO.cWk()) {
            cWl = this.dIO.cWh();
        } else {
            cWl = this.dIO.cWl();
        }
        setMeasuredDimension(size, cA(v.getCount(cWl), size) + m(cWl, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int m(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.dIO.cWA() == 1 || this.dIO.cWA() == 3) {
            this.jHT = 0;
            return 0;
        } else if (v.getCount(list) != 0) {
            int count = v.getCount(list);
            this.jHT = count;
            if (!this.dIO.cWk()) {
                if (count <= 2) {
                    this.jHT = count;
                } else {
                    this.jHT = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.jHT) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.jHV)) {
                    childAt = this.jrx.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.jHU.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.jHQ);
                view.setOnLongClickListener(this.jHR);
                view.setOnTouchListener(this.jHS);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.dIO) {
                    sparseArray.put(R.id.tag_load_sub_data, this.dIO);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).aKC() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).aKC().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).aKC().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.jrx.a((b.C0641b) sparseArray.get(R.id.tag_holder), list.get(i2), this.dIO.cWs() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cA(int i, int i2) {
        if (i > 0 && (this.dIO.cWA() == 1 || this.dIO.cWA() == 3 || this.dIO.cWs() > this.jHT)) {
            this.fAX.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.dIO.cWs())));
            this.jHV.setOnClickListener(this.jHQ);
            SparseArray sparseArray = (SparseArray) this.jHV.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.jHV.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.dIO);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.jHV.setVisibility(0);
            this.jHV.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.jHV.setVisibility(8);
        }
        if (this.jHV.getVisibility() == 0) {
            return this.jHV.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.dIO != null && this.dIO.cWl() != null) {
            int size = this.jHU.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.jHU.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.jHW, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.jHT;
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
            if (this.jHV.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jHV.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.jHV.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.jHV.getMeasuredWidth(), this.jHV.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.jHT; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.jHV) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.dIO != null && this.dIO.cWl() != null) {
            int i = this.jHT;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.jHV.getVisibility() == 0) {
                drawChild(canvas, this.jHV, drawingTime);
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
    /* renamed from: cCM */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.fAX != null) {
            this.fAX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            am.setViewTextColor(this.fAX, (int) R.color.cp_cont_c);
        }
    }
}
