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
    private TextView bEk;
    private PostData eRs;
    private View.OnTouchListener lDA;
    private int lDB;
    private final Queue<a> lDC;
    private RelativeLayout lDD;
    private ViewGroup.MarginLayoutParams lDE;
    private View.OnClickListener lDy;
    private View.OnLongClickListener lDz;
    private b lll;
    private boolean lln;
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
        this.lDB = 0;
        this.mRootView = null;
        this.lDC = new LinkedList();
        this.lln = false;
        this.lDE = new ViewGroup.MarginLayoutParams(-1, -2);
        this.lDD = new RelativeLayout(context);
        this.lDD.setId(R.id.pb_floor_reply_more);
        this.bEk = new TextView(context);
        this.bEk.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.bEk.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.lln) {
            ap.setViewTextColor(this.bEk, R.color.cp_link_tip_c);
            this.bEk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ap.setViewTextColor(this.bEk, R.color.cp_cont_c);
            this.bEk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.bEk.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.lDD.addView(this.bEk);
        addView(this.lDD, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.lDy = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lDz = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.lDA = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.lll = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.lln = z;
    }

    public void setData(PostData postData, View view) {
        this.eRs = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dHu;
        if (this.lll == null || this.eRs == null || this.eRs.dHu() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.eRs.dHt()) {
            dHu = this.eRs.dHq();
        } else {
            dHu = this.eRs.dHu();
        }
        setMeasuredDimension(size, db(y.getCount(dHu), size) + q(dHu, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.eRs.dHJ() == 1 || this.eRs.dHJ() == 3) {
            this.lDB = 0;
            return 0;
        } else if (y.getCount(list) != 0) {
            int count = y.getCount(list);
            this.lDB = count;
            if (!this.eRs.dHt()) {
                if (count <= 2) {
                    this.lDB = count;
                } else {
                    this.lDB = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.lDB) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.lDD)) {
                    childAt = this.lll.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.lDC.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.lDy);
                if (!this.lln) {
                    view.setOnLongClickListener(this.lDz);
                }
                view.setOnTouchListener(this.lDA);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.eRs) {
                    sparseArray.put(R.id.tag_load_sub_data, this.eRs);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).bka() != null) {
                    if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i2)) {
                        sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i2));
                    }
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).bka().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).bka().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                b.C0804b c0804b = (b.C0804b) sparseArray.get(R.id.tag_holder);
                this.lll.a(c0804b, list.get(i2), this.eRs.dHB() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0804b.lmH.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                this.bEk.setTextSize(0, TbConfig.getContentSizeOfLzl());
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int db(int i, int i2) {
        String format;
        if (i > 0 && (this.eRs.dHJ() == 1 || this.eRs.dHJ() == 3 || this.eRs.dHB() > this.lDB)) {
            if (this.lln) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.eRs.dHB()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.eRs.dHB()));
            }
            this.bEk.setText(format);
            this.lDD.setOnClickListener(this.lDy);
            SparseArray sparseArray = (SparseArray) this.lDD.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.lDD.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.eRs);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.lDD.setVisibility(0);
            this.lDD.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.lDD.setVisibility(8);
        }
        if (this.lDD.getVisibility() == 0) {
            return this.lDD.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eRs != null && this.eRs.dHu() != null) {
            int size = this.lDC.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.lDC.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.lDE, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.lDB;
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
            if (this.lDD.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lDD.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.lDD.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.lDD.getMeasuredWidth(), this.lDD.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.lDB; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.lDD) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eRs != null && this.eRs.dHu() != null) {
            int i = this.lDB;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.lDD.getVisibility() == 0) {
                drawChild(canvas, this.lDD, drawingTime);
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
    /* renamed from: dnr */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bEk != null) {
            if (this.lln) {
                ap.setViewTextColor(this.bEk, R.color.cp_link_tip_c);
                this.bEk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.bEk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ap.setViewTextColor(this.bEk, R.color.cp_cont_c);
        }
    }
}
