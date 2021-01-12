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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes2.dex */
public class SubPbLayout extends ViewGroup {
    private TextView bNp;
    private PostData fiL;
    private b lFX;
    private boolean lFY;
    private View.OnClickListener lYq;
    private View.OnLongClickListener lYr;
    private View.OnTouchListener lYs;
    private int lYt;
    private final Queue<a> lYu;
    private RelativeLayout lYv;
    private ViewGroup.MarginLayoutParams lYw;
    SparseArray<Object> lYx;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
        this.lYt = 0;
        this.mRootView = null;
        this.lYu = new LinkedList();
        this.lFY = false;
        this.lYw = new ViewGroup.MarginLayoutParams(-1, -2);
        this.lYv = new RelativeLayout(context);
        this.lYv.setId(R.id.pb_floor_reply_more);
        this.bNp = new TextView(context);
        this.bNp.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.bNp.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.lFY) {
            ao.setViewTextColor(this.bNp, R.color.CAM_X0304);
            this.bNp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ao.setViewTextColor(this.bNp, R.color.CAM_X0108);
            this.bNp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.bNp.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.lYv.addView(this.bNp);
        addView(this.lYv, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.lYq = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lYr = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.lYs = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.lFX = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.lFY = z;
    }

    public void setData(PostData postData, View view) {
        this.fiL = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dLj;
        if (this.lFX == null || this.fiL == null || this.fiL.dLj() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fiL.dLi()) {
            dLj = this.fiL.dLf();
        } else {
            dLj = this.fiL.dLj();
        }
        setMeasuredDimension(size, de(x.getCount(dLj), size) + q(dLj, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        int biW = com.baidu.tbadk.a.d.biW();
        if (this.fiL.dLy() == 1 || this.fiL.dLy() == 3) {
            this.lYt = 0;
            return 0;
        } else if (x.getCount(list) != 0) {
            int count = x.getCount(list);
            this.lYt = count;
            if (!this.fiL.dLi()) {
                if (count <= biW) {
                    this.lYt = count;
                } else {
                    this.lYt = biW;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.lYt) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.lYv)) {
                    childAt = this.lFX.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.lYu.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.lYq);
                if (!this.lFY) {
                    view.setOnLongClickListener(this.lYr);
                }
                view.setOnTouchListener(this.lYs);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.fiL) {
                    sparseArray.put(R.id.tag_load_sub_data, this.fiL);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).bnx() != null) {
                    if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i2)) {
                        sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i2));
                    }
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).bnx().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).bnx().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                if (this.lYx != null) {
                    sparseArray.put(-1, this.lYx.get(-1));
                    sparseArray.put(-2, this.lYx.get(-2));
                    sparseArray.put(-3, this.lYx.get(-3));
                    sparseArray.put(-4, this.lYx.get(-4));
                }
                b.C0837b c0837b = (b.C0837b) sparseArray.get(R.id.tag_holder);
                this.lFX.a(c0837b, list.get(i2), this.fiL.dLq() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0837b.lHw.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                this.bNp.setTextSize(0, TbConfig.getContentSizeOfLzl());
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int de(int i, int i2) {
        String format;
        if (i > 0 && (this.fiL.dLy() == 1 || this.fiL.dLy() == 3 || this.fiL.dLq() > this.lYt)) {
            if (this.lFY) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.fiL.dLq()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.fiL.dLq()));
            }
            this.bNp.setText(format);
            this.lYv.setOnClickListener(this.lYq);
            SparseArray sparseArray = (SparseArray) this.lYv.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.lYv.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.fiL);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.lYv.setVisibility(0);
            this.lYv.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.lYv.setVisibility(8);
        }
        if (this.lYv.getVisibility() == 0) {
            return this.lYv.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 0;
        if (this.fiL != null && this.fiL.dLj() != null) {
            int size = this.lYu.size();
            for (int i7 = 0; i7 < size; i7++) {
                a poll = this.lYu.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.lYw, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i8 = this.lYt;
            while (i6 < i8) {
                View childAt = getChildAt(i6);
                if (childAt == null) {
                    i5 = paddingTop;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    if (marginLayoutParams == null) {
                        marginLayoutParams = generateDefaultLayoutParams();
                    }
                    int i9 = paddingTop + marginLayoutParams.topMargin;
                    int measuredWidth = marginLayoutParams.leftMargin + paddingLeft + childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight() + i9;
                    childAt.layout(marginLayoutParams.leftMargin + paddingLeft, i9, measuredWidth, measuredHeight);
                    i5 = marginLayoutParams.bottomMargin + measuredHeight;
                }
                i6++;
                paddingTop = i5;
            }
            if (this.lYv.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lYv.getLayoutParams();
                int i10 = paddingTop + marginLayoutParams2.topMargin;
                this.lYv.layout(marginLayoutParams2.leftMargin + paddingLeft, i10, marginLayoutParams2.leftMargin + paddingLeft + this.lYv.getMeasuredWidth(), this.lYv.getMeasuredHeight() + i10);
            }
            int childCount = getChildCount();
            for (int i11 = this.lYt; i11 < childCount; i11++) {
                View childAt2 = getChildAt(i11);
                if (childAt2 != null && childAt2 != this.lYv) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fiL != null && this.fiL.dLj() != null) {
            int i = this.lYt;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.lYv.getVisibility() == 0) {
                drawChild(canvas, this.lYv, drawingTime);
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
    /* renamed from: dqK */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bNp != null) {
            if (this.lFY) {
                ao.setViewTextColor(this.bNp, R.color.CAM_X0304);
                this.bNp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.bNp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ao.setViewTextColor(this.bNp, R.color.CAM_X0108);
        }
    }

    public void setDefaultTag(SparseArray<Object> sparseArray) {
        this.lYx = sparseArray;
    }
}
