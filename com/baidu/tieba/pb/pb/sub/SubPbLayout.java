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
    private PostData dIK;
    private TextView fAS;
    private View.OnClickListener jHM;
    private View.OnLongClickListener jHN;
    private View.OnTouchListener jHO;
    private int jHP;
    private final Queue<a> jHQ;
    private RelativeLayout jHR;
    private ViewGroup.MarginLayoutParams jHS;
    private b jrt;
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
        this.jHP = 0;
        this.mRootView = null;
        this.jHQ = new LinkedList();
        this.jHS = new ViewGroup.MarginLayoutParams(-1, -2);
        this.jHR = new RelativeLayout(context);
        this.jHR.setId(R.id.pb_floor_reply_more);
        this.fAS = new TextView(context);
        this.fAS.setPadding(0, l.getDimens(context, R.dimen.tbds2), 0, l.getDimens(context, R.dimen.tbds12));
        this.fAS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.fAS.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.fAS.setTextSize(0, l.getDimens(context, R.dimen.tbds40));
        am.setViewTextColor(this.fAS, (int) R.color.cp_cont_c);
        this.jHR.addView(this.fAS);
        addView(this.jHR, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.jHM = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.jHN = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.jHO = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.jrt = bVar;
    }

    public void setData(PostData postData, View view) {
        this.dIK = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> cWo;
        if (this.jrt == null || this.dIK == null || this.dIK.cWo() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.dIK.cWn()) {
            cWo = this.dIK.cWk();
        } else {
            cWo = this.dIK.cWo();
        }
        setMeasuredDimension(size, cA(v.getCount(cWo), size) + m(cWo, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int m(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.dIK.cWD() == 1 || this.dIK.cWD() == 3) {
            this.jHP = 0;
            return 0;
        } else if (v.getCount(list) != 0) {
            int count = v.getCount(list);
            this.jHP = count;
            if (!this.dIK.cWn()) {
                if (count <= 2) {
                    this.jHP = count;
                } else {
                    this.jHP = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.jHP) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.jHR)) {
                    childAt = this.jrt.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.jHQ.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.jHM);
                view.setOnLongClickListener(this.jHN);
                view.setOnTouchListener(this.jHO);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.dIK) {
                    sparseArray.put(R.id.tag_load_sub_data, this.dIK);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).aKE() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).aKE().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).aKE().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.jrt.a((b.C0620b) sparseArray.get(R.id.tag_holder), list.get(i2), this.dIK.cWv() > list.size() || list.size() - i2 > 1, i2 == 0, false);
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
        if (i > 0 && (this.dIK.cWD() == 1 || this.dIK.cWD() == 3 || this.dIK.cWv() > this.jHP)) {
            this.fAS.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.dIK.cWv())));
            this.jHR.setOnClickListener(this.jHM);
            SparseArray sparseArray = (SparseArray) this.jHR.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.jHR.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.dIK);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.jHR.setVisibility(0);
            this.jHR.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.jHR.setVisibility(8);
        }
        if (this.jHR.getVisibility() == 0) {
            return this.jHR.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.dIK != null && this.dIK.cWo() != null) {
            int size = this.jHQ.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.jHQ.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.jHS, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.jHP;
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
            if (this.jHR.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jHR.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.jHR.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.jHR.getMeasuredWidth(), this.jHR.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.jHP; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.jHR) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.dIK != null && this.dIK.cWo() != null) {
            int i = this.jHP;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.jHR.getVisibility() == 0) {
                drawChild(canvas, this.jHR, drawingTime);
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
    /* renamed from: cCP */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.fAS != null) {
            this.fAS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            am.setViewTextColor(this.fAS, (int) R.color.cp_cont_c);
        }
    }
}
