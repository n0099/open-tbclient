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
/* loaded from: classes16.dex */
public class SubPbLayout extends ViewGroup {
    private PostData ekJ;
    private TextView ggp;
    private View.OnClickListener kDp;
    private View.OnLongClickListener kDq;
    private View.OnTouchListener kDr;
    private int kDs;
    private final Queue<a> kDt;
    private RelativeLayout kDu;
    private ViewGroup.MarginLayoutParams kDv;
    private b klD;
    private boolean klF;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
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
        this.kDs = 0;
        this.mRootView = null;
        this.kDt = new LinkedList();
        this.klF = false;
        this.kDv = new ViewGroup.MarginLayoutParams(-1, -2);
        this.kDu = new RelativeLayout(context);
        this.kDu.setId(R.id.pb_floor_reply_more);
        this.ggp = new TextView(context);
        this.ggp.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.ggp.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.klF) {
            ao.setViewTextColor(this.ggp, R.color.cp_link_tip_c);
            this.ggp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ao.setViewTextColor(this.ggp, R.color.cp_cont_c);
            this.ggp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.ggp.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.kDu.addView(this.ggp);
        addView(this.kDu, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.kDp = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.kDq = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.kDr = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.klD = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.klF = z;
    }

    public void setData(PostData postData, View view) {
        this.ekJ = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dle;
        if (this.klD == null || this.ekJ == null || this.ekJ.dle() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.ekJ.dld()) {
            dle = this.ekJ.dla();
        } else {
            dle = this.ekJ.dle();
        }
        setMeasuredDimension(size, cO(x.getCount(dle), size) + n(dle, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.ekJ.dlt() == 1 || this.ekJ.dlt() == 3) {
            this.kDs = 0;
            return 0;
        } else if (x.getCount(list) != 0) {
            int count = x.getCount(list);
            this.kDs = count;
            if (!this.ekJ.dld()) {
                if (count <= 2) {
                    this.kDs = count;
                } else {
                    this.kDs = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.kDs) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.kDu)) {
                    childAt = this.klD.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.kDt.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.kDp);
                if (!this.klF) {
                    view.setOnLongClickListener(this.kDq);
                }
                view.setOnTouchListener(this.kDr);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.ekJ) {
                    sparseArray.put(R.id.tag_load_sub_data, this.ekJ);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).aWl() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).aWl().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).aWl().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                b.C0723b c0723b = (b.C0723b) sparseArray.get(R.id.tag_holder);
                this.klD.a(c0723b, list.get(i2), this.ekJ.dll() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0723b.kmZ.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                this.ggp.setTextSize(0, TbConfig.getContentSizeOfLzl());
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cO(int i, int i2) {
        String format;
        if (i > 0 && (this.ekJ.dlt() == 1 || this.ekJ.dlt() == 3 || this.ekJ.dll() > this.kDs)) {
            if (this.klF) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.ekJ.dll()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.ekJ.dll()));
            }
            this.ggp.setText(format);
            this.kDu.setOnClickListener(this.kDp);
            SparseArray sparseArray = (SparseArray) this.kDu.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.kDu.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.ekJ);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.kDu.setVisibility(0);
            this.kDu.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.kDu.setVisibility(8);
        }
        if (this.kDu.getVisibility() == 0) {
            return this.kDu.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.ekJ != null && this.ekJ.dle() != null) {
            int size = this.kDt.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.kDt.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.kDv, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.kDs;
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
            if (this.kDu.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.kDu.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.kDu.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.kDu.getMeasuredWidth(), this.kDu.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.kDs; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.kDu) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.ekJ != null && this.ekJ.dle() != null) {
            int i = this.kDs;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.kDu.getVisibility() == 0) {
                drawChild(canvas, this.kDu, drawingTime);
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
    /* renamed from: cSg */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.ggp != null) {
            if (this.klF) {
                ao.setViewTextColor(this.ggp, R.color.cp_link_tip_c);
                this.ggp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.ggp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ao.setViewTextColor(this.ggp, R.color.cp_cont_c);
        }
    }
}
