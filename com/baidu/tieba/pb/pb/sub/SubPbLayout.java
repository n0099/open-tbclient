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
    private PostData cck;
    private TextView dKU;
    private c hNu;
    private View.OnClickListener iaW;
    private View.OnLongClickListener iaX;
    private View.OnTouchListener iaY;
    private int iaZ;
    private final Queue<a> iba;
    private RelativeLayout ibb;
    private ViewGroup.MarginLayoutParams ibc;
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
        this.iaZ = 0;
        this.mRootView = null;
        this.iba = new LinkedList();
        this.ibc = new ViewGroup.MarginLayoutParams(-1, -2);
        this.ibb = new RelativeLayout(context);
        this.ibb.setId(R.id.pb_floor_reply_more);
        this.dKU = new TextView(context);
        this.dKU.setPadding(0, l.g(context, R.dimen.tbds2), 0, l.g(context, R.dimen.tbds12));
        this.dKU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.dKU.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.dKU.setTextSize(0, l.g(context, R.dimen.tbds40));
        am.j(this.dKU, R.color.cp_cont_c);
        this.ibb.addView(this.dKU);
        addView(this.ibb, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.iaW = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iaX = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.iaY = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.hNu = cVar;
    }

    public void setData(PostData postData, View view) {
        this.cck = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> cpm;
        if (this.hNu == null || this.cck == null || this.cck.cpm() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.cck.cpl()) {
            cpm = this.cck.cpi();
        } else {
            cpm = this.cck.cpm();
        }
        setMeasuredDimension(size, cj(v.Z(cpm), size) + n(cpm, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.cck.cpB() == 1 || this.cck.cpB() == 3) {
            this.iaZ = 0;
            return 0;
        } else if (v.Z(list) != 0) {
            int Z = v.Z(list);
            this.iaZ = Z;
            if (!this.cck.cpl()) {
                if (Z <= 2) {
                    this.iaZ = Z;
                } else {
                    this.iaZ = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.iaZ) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.ibb)) {
                    childAt = this.hNu.nZ();
                    childAt.setPadding(0, 0, 0, 0);
                    this.iba.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.iaW);
                view.setOnLongClickListener(this.iaX);
                view.setOnTouchListener(this.iaY);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.cck) {
                    sparseArray.put(R.id.tag_load_sub_data, this.cck);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).aex() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).aex().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).aex().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.hNu.a((c.b) sparseArray.get(R.id.tag_holder), list.get(i2), this.cck.cpt() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cj(int i, int i2) {
        if (i > 0 && (this.cck.cpB() == 1 || this.cck.cpB() == 3 || this.cck.cpt() > this.iaZ)) {
            this.dKU.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.cck.cpt())));
            this.ibb.setOnClickListener(this.iaW);
            SparseArray sparseArray = (SparseArray) this.ibb.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.ibb.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.cck);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.ibb.setVisibility(0);
            this.ibb.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.ibb.setVisibility(8);
        }
        if (this.ibb.getVisibility() == 0) {
            return this.ibb.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.cck != null && this.cck.cpm() != null) {
            int size = this.iba.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.iba.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.ibc, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.iaZ;
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
            if (this.ibb.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ibb.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.ibb.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.ibb.getMeasuredWidth(), this.ibb.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.iaZ; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.ibb) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.cck != null && this.cck.cpm() != null) {
            int i = this.iaZ;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.ibb.getVisibility() == 0) {
                drawChild(canvas, this.ibb, drawingTime);
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
    /* renamed from: bZl */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.dKU != null) {
            this.dKU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            am.j(this.dKU, R.color.cp_cont_c);
        }
    }
}
