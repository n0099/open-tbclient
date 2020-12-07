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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes22.dex */
public class SubPbLayout extends ViewGroup {
    private TextView bNo;
    private PostData fdL;
    private b lFk;
    private boolean lFl;
    private View.OnClickListener lXG;
    private View.OnLongClickListener lXH;
    private View.OnTouchListener lXI;
    private int lXJ;
    private final Queue<a> lXK;
    private RelativeLayout lXL;
    private ViewGroup.MarginLayoutParams lXM;
    SparseArray<Object> lXN;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
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
        this.lXJ = 0;
        this.mRootView = null;
        this.lXK = new LinkedList();
        this.lFl = false;
        this.lXM = new ViewGroup.MarginLayoutParams(-1, -2);
        this.lXL = new RelativeLayout(context);
        this.lXL.setId(R.id.pb_floor_reply_more);
        this.bNo = new TextView(context);
        this.bNo.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.bNo.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.lFl) {
            ap.setViewTextColor(this.bNo, R.color.CAM_X0304);
            this.bNo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ap.setViewTextColor(this.bNo, R.color.CAM_X0108);
            this.bNo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.bNo.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.lXL.addView(this.bNo);
        addView(this.lXL, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.lXG = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lXH = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.lXI = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.lFk = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.lFl = z;
    }

    public void setData(PostData postData, View view) {
        this.fdL = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dPd;
        if (this.lFk == null || this.fdL == null || this.fdL.dPd() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fdL.dPc()) {
            dPd = this.fdL.dOZ();
        } else {
            dPd = this.fdL.dPd();
        }
        setMeasuredDimension(size, di(y.getCount(dPd), size) + q(dPd, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        int bkC = com.baidu.tbadk.a.d.bkC();
        if (this.fdL.dPs() == 1 || this.fdL.dPs() == 3) {
            this.lXJ = 0;
            return 0;
        } else if (y.getCount(list) != 0) {
            int count = y.getCount(list);
            this.lXJ = count;
            if (!this.fdL.dPc()) {
                if (count <= bkC) {
                    this.lXJ = count;
                } else {
                    this.lXJ = bkC;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.lXJ) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.lXL)) {
                    childAt = this.lFk.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.lXK.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.lXG);
                if (!this.lFl) {
                    view.setOnLongClickListener(this.lXH);
                }
                view.setOnTouchListener(this.lXI);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.fdL) {
                    sparseArray.put(R.id.tag_load_sub_data, this.fdL);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).boP() != null) {
                    if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i2)) {
                        sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i2));
                    }
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).boP().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).boP().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                if (this.lXN != null) {
                    sparseArray.put(-1, this.lXN.get(-1));
                    sparseArray.put(-2, this.lXN.get(-2));
                    sparseArray.put(-3, this.lXN.get(-3));
                    sparseArray.put(-4, this.lXN.get(-4));
                }
                b.C0837b c0837b = (b.C0837b) sparseArray.get(R.id.tag_holder);
                this.lFk.a(c0837b, list.get(i2), this.fdL.dPk() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0837b.lGK.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                this.bNo.setTextSize(0, TbConfig.getContentSizeOfLzl());
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int di(int i, int i2) {
        String format;
        if (i > 0 && (this.fdL.dPs() == 1 || this.fdL.dPs() == 3 || this.fdL.dPk() > this.lXJ)) {
            if (this.lFl) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.fdL.dPk()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.fdL.dPk()));
            }
            this.bNo.setText(format);
            this.lXL.setOnClickListener(this.lXG);
            SparseArray sparseArray = (SparseArray) this.lXL.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.lXL.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.fdL);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.lXL.setVisibility(0);
            this.lXL.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.lXL.setVisibility(8);
        }
        if (this.lXL.getVisibility() == 0) {
            return this.lXL.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fdL != null && this.fdL.dPd() != null) {
            int size = this.lXK.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.lXK.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.lXM, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.lXJ;
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
            if (this.lXL.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lXL.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.lXL.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.lXL.getMeasuredWidth(), this.lXL.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.lXJ; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.lXL) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fdL != null && this.fdL.dPd() != null) {
            int i = this.lXJ;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.lXL.getVisibility() == 0) {
                drawChild(canvas, this.lXL, drawingTime);
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
    /* renamed from: duL */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bNo != null) {
            if (this.lFl) {
                ap.setViewTextColor(this.bNo, R.color.CAM_X0304);
                this.bNo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.bNo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ap.setViewTextColor(this.bNo, R.color.CAM_X0108);
        }
    }

    public void setDefaultTag(SparseArray<Object> sparseArray) {
        this.lXN = sparseArray;
    }
}
