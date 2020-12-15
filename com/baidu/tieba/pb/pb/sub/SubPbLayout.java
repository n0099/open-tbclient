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
    private b lFm;
    private boolean lFn;
    private View.OnClickListener lXI;
    private View.OnLongClickListener lXJ;
    private View.OnTouchListener lXK;
    private int lXL;
    private final Queue<a> lXM;
    private RelativeLayout lXN;
    private ViewGroup.MarginLayoutParams lXO;
    SparseArray<Object> lXP;
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
        this.lXL = 0;
        this.mRootView = null;
        this.lXM = new LinkedList();
        this.lFn = false;
        this.lXO = new ViewGroup.MarginLayoutParams(-1, -2);
        this.lXN = new RelativeLayout(context);
        this.lXN.setId(R.id.pb_floor_reply_more);
        this.bNo = new TextView(context);
        this.bNo.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.bNo.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.lFn) {
            ap.setViewTextColor(this.bNo, R.color.CAM_X0304);
            this.bNo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ap.setViewTextColor(this.bNo, R.color.CAM_X0108);
            this.bNo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.bNo.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.lXN.addView(this.bNo);
        addView(this.lXN, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.lXI = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lXJ = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.lXK = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.lFm = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.lFn = z;
    }

    public void setData(PostData postData, View view) {
        this.fdL = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dPe;
        if (this.lFm == null || this.fdL == null || this.fdL.dPe() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fdL.dPd()) {
            dPe = this.fdL.dPa();
        } else {
            dPe = this.fdL.dPe();
        }
        setMeasuredDimension(size, di(y.getCount(dPe), size) + q(dPe, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        int bkC = com.baidu.tbadk.a.d.bkC();
        if (this.fdL.dPt() == 1 || this.fdL.dPt() == 3) {
            this.lXL = 0;
            return 0;
        } else if (y.getCount(list) != 0) {
            int count = y.getCount(list);
            this.lXL = count;
            if (!this.fdL.dPd()) {
                if (count <= bkC) {
                    this.lXL = count;
                } else {
                    this.lXL = bkC;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.lXL) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.lXN)) {
                    childAt = this.lFm.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.lXM.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.lXI);
                if (!this.lFn) {
                    view.setOnLongClickListener(this.lXJ);
                }
                view.setOnTouchListener(this.lXK);
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
                if (this.lXP != null) {
                    sparseArray.put(-1, this.lXP.get(-1));
                    sparseArray.put(-2, this.lXP.get(-2));
                    sparseArray.put(-3, this.lXP.get(-3));
                    sparseArray.put(-4, this.lXP.get(-4));
                }
                b.C0837b c0837b = (b.C0837b) sparseArray.get(R.id.tag_holder);
                this.lFm.a(c0837b, list.get(i2), this.fdL.dPl() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0837b.lGM.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
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
        if (i > 0 && (this.fdL.dPt() == 1 || this.fdL.dPt() == 3 || this.fdL.dPl() > this.lXL)) {
            if (this.lFn) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.fdL.dPl()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.fdL.dPl()));
            }
            this.bNo.setText(format);
            this.lXN.setOnClickListener(this.lXI);
            SparseArray sparseArray = (SparseArray) this.lXN.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.lXN.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.fdL);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.lXN.setVisibility(0);
            this.lXN.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.lXN.setVisibility(8);
        }
        if (this.lXN.getVisibility() == 0) {
            return this.lXN.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fdL != null && this.fdL.dPe() != null) {
            int size = this.lXM.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.lXM.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.lXO, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.lXL;
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
            if (this.lXN.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lXN.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.lXN.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.lXN.getMeasuredWidth(), this.lXN.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.lXL; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.lXN) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fdL != null && this.fdL.dPe() != null) {
            int i = this.lXL;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.lXN.getVisibility() == 0) {
                drawChild(canvas, this.lXN, drawingTime);
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
    /* renamed from: duM */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bNo != null) {
            if (this.lFn) {
                ap.setViewTextColor(this.bNo, R.color.CAM_X0304);
                this.bNo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.bNo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ap.setViewTextColor(this.bNo, R.color.CAM_X0108);
        }
    }

    public void setDefaultTag(SparseArray<Object> sparseArray) {
        this.lXP = sparseArray;
    }
}
