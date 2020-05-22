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
    private PostData dXd;
    private TextView fPa;
    private b jIm;
    private View.OnLongClickListener jZA;
    private View.OnTouchListener jZB;
    private int jZC;
    private final Queue<a> jZD;
    private RelativeLayout jZE;
    private ViewGroup.MarginLayoutParams jZF;
    private View.OnClickListener jZz;
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
        this.jZC = 0;
        this.mRootView = null;
        this.jZD = new LinkedList();
        this.jZF = new ViewGroup.MarginLayoutParams(-1, -2);
        this.jZE = new RelativeLayout(context);
        this.jZE.setId(R.id.pb_floor_reply_more);
        this.fPa = new TextView(context);
        this.fPa.setPadding(0, l.getDimens(context, R.dimen.tbds2), 0, l.getDimens(context, R.dimen.tbds12));
        this.fPa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.fPa.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.fPa.setTextSize(0, l.getDimens(context, R.dimen.tbds40));
        am.setViewTextColor(this.fPa, (int) R.color.cp_cont_c);
        this.jZE.addView(this.fPa);
        addView(this.jZE, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.jZz = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.jZA = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.jZB = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.jIm = bVar;
    }

    public void setData(PostData postData, View view) {
        this.dXd = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> ddr;
        if (this.jIm == null || this.dXd == null || this.dXd.ddr() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.dXd.ddq()) {
            ddr = this.dXd.ddn();
        } else {
            ddr = this.dXd.ddr();
        }
        setMeasuredDimension(size, cF(v.getCount(ddr), size) + o(ddr, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int o(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.dXd.ddG() == 1 || this.dXd.ddG() == 3) {
            this.jZC = 0;
            return 0;
        } else if (v.getCount(list) != 0) {
            int count = v.getCount(list);
            this.jZC = count;
            if (!this.dXd.ddq()) {
                if (count <= 2) {
                    this.jZC = count;
                } else {
                    this.jZC = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.jZC) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.jZE)) {
                    childAt = this.jIm.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.jZD.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.jZz);
                view.setOnLongClickListener(this.jZA);
                view.setOnTouchListener(this.jZB);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.dXd) {
                    sparseArray.put(R.id.tag_load_sub_data, this.dXd);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).aQx() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).aQx().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).aQx().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.jIm.a((b.C0694b) sparseArray.get(R.id.tag_holder), list.get(i2), this.dXd.ddy() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cF(int i, int i2) {
        if (i > 0 && (this.dXd.ddG() == 1 || this.dXd.ddG() == 3 || this.dXd.ddy() > this.jZC)) {
            this.fPa.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.dXd.ddy())));
            this.jZE.setOnClickListener(this.jZz);
            SparseArray sparseArray = (SparseArray) this.jZE.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.jZE.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.dXd);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.jZE.setVisibility(0);
            this.jZE.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.jZE.setVisibility(8);
        }
        if (this.jZE.getVisibility() == 0) {
            return this.jZE.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.dXd != null && this.dXd.ddr() != null) {
            int size = this.jZD.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.jZD.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.jZF, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.jZC;
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
            if (this.jZE.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jZE.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.jZE.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.jZE.getMeasuredWidth(), this.jZE.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.jZC; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.jZE) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.dXd != null && this.dXd.ddr() != null) {
            int i = this.jZC;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.jZE.getVisibility() == 0) {
                drawChild(canvas, this.jZE, drawingTime);
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
    /* renamed from: cJL */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.fPa != null) {
            this.fPa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            am.setViewTextColor(this.fPa, (int) R.color.cp_cont_c);
        }
    }
}
