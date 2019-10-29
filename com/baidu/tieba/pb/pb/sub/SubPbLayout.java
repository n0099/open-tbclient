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
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes4.dex */
public class SubPbLayout extends ViewGroup {
    private PostData crz;
    private TextView ebx;
    private c hOQ;
    private View.OnClickListener icA;
    private View.OnLongClickListener icB;
    private View.OnTouchListener icC;
    private int icD;
    private final Queue<a> icE;
    private RelativeLayout icF;
    private ViewGroup.MarginLayoutParams icG;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
        this.icD = 0;
        this.mRootView = null;
        this.icE = new LinkedList();
        this.icG = new ViewGroup.MarginLayoutParams(-1, -2);
        this.icF = new RelativeLayout(context);
        this.icF.setId(R.id.pb_floor_reply_more);
        this.ebx = new TextView(context);
        this.ebx.setPadding(0, l.getDimens(context, R.dimen.tbds2), 0, l.getDimens(context, R.dimen.tbds12));
        this.ebx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.ebx.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.ebx.setTextSize(0, l.getDimens(context, R.dimen.tbds40));
        am.setViewTextColor(this.ebx, (int) R.color.cp_cont_c);
        this.icF.addView(this.ebx);
        addView(this.icF, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.icA = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.icB = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.icC = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.hOQ = cVar;
    }

    public void setData(PostData postData, View view) {
        this.crz = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> com2;
        if (this.hOQ == null || this.crz == null || this.crz.com() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.crz.col()) {
            com2 = this.crz.coi();
        } else {
            com2 = this.crz.com();
        }
        setMeasuredDimension(size, cc(v.getCount(com2), size) + l(com2, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int l(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.crz.coB() == 1 || this.crz.coB() == 3) {
            this.icD = 0;
            return 0;
        } else if (v.getCount(list) != 0) {
            int count = v.getCount(list);
            this.icD = count;
            if (!this.crz.col()) {
                if (count <= 2) {
                    this.icD = count;
                } else {
                    this.icD = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.icD) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.icF)) {
                    childAt = this.hOQ.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.icE.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.icA);
                view.setOnLongClickListener(this.icB);
                view.setOnTouchListener(this.icC);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.crz) {
                    sparseArray.put(R.id.tag_load_sub_data, this.crz);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).aiG() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).aiG().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).aiG().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.hOQ.a((c.b) sparseArray.get(R.id.tag_holder), list.get(i2), this.crz.cot() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cc(int i, int i2) {
        if (i > 0 && (this.crz.coB() == 1 || this.crz.coB() == 3 || this.crz.cot() > this.icD)) {
            this.ebx.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.crz.cot())));
            this.icF.setOnClickListener(this.icA);
            SparseArray sparseArray = (SparseArray) this.icF.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.icF.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.crz);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.icF.setVisibility(0);
            this.icF.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.icF.setVisibility(8);
        }
        if (this.icF.getVisibility() == 0) {
            return this.icF.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.crz != null && this.crz.com() != null) {
            int size = this.icE.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.icE.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.icG, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.icD;
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
            if (this.icF.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.icF.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.icF.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.icF.getMeasuredWidth(), this.icF.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.icD; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.icF) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.crz != null && this.crz.com() != null) {
            int i = this.icD;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.icF.getVisibility() == 0) {
                drawChild(canvas, this.icF, drawingTime);
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
    /* renamed from: bXt */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.ebx != null) {
            this.ebx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            am.setViewTextColor(this.ebx, (int) R.color.cp_cont_c);
        }
    }
}
