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
    private PostData dio;
    private TextView eVS;
    private b iFx;
    private View.OnClickListener iVP;
    private View.OnLongClickListener iVQ;
    private View.OnTouchListener iVR;
    private int iVS;
    private final Queue<a> iVT;
    private RelativeLayout iVU;
    private ViewGroup.MarginLayoutParams iVV;
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
        this.iVS = 0;
        this.mRootView = null;
        this.iVT = new LinkedList();
        this.iVV = new ViewGroup.MarginLayoutParams(-1, -2);
        this.iVU = new RelativeLayout(context);
        this.iVU.setId(R.id.pb_floor_reply_more);
        this.eVS = new TextView(context);
        this.eVS.setPadding(0, l.getDimens(context, R.dimen.tbds2), 0, l.getDimens(context, R.dimen.tbds12));
        this.eVS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.eVS.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.eVS.setTextSize(0, l.getDimens(context, R.dimen.tbds40));
        am.setViewTextColor(this.eVS, (int) R.color.cp_cont_c);
        this.iVU.addView(this.eVS);
        addView(this.iVU, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.iVP = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iVQ = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.iVR = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.iFx = bVar;
    }

    public void setData(PostData postData, View view) {
        this.dio = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> cKV;
        if (this.iFx == null || this.dio == null || this.dio.cKV() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.dio.cKU()) {
            cKV = this.dio.cKR();
        } else {
            cKV = this.dio.cKV();
        }
        setMeasuredDimension(size, ct(v.getCount(cKV), size) + m(cKV, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int m(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.dio.cLk() == 1 || this.dio.cLk() == 3) {
            this.iVS = 0;
            return 0;
        } else if (v.getCount(list) != 0) {
            int count = v.getCount(list);
            this.iVS = count;
            if (!this.dio.cKU()) {
                if (count <= 2) {
                    this.iVS = count;
                } else {
                    this.iVS = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.iVS) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.iVU)) {
                    childAt = this.iFx.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.iVT.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.iVP);
                view.setOnLongClickListener(this.iVQ);
                view.setOnTouchListener(this.iVR);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.dio) {
                    sparseArray.put(R.id.tag_load_sub_data, this.dio);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).aCm() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).aCm().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).aCm().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.iFx.a((b.C0581b) sparseArray.get(R.id.tag_holder), list.get(i2), this.dio.cLc() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int ct(int i, int i2) {
        if (i > 0 && (this.dio.cLk() == 1 || this.dio.cLk() == 3 || this.dio.cLc() > this.iVS)) {
            this.eVS.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.dio.cLc())));
            this.iVU.setOnClickListener(this.iVP);
            SparseArray sparseArray = (SparseArray) this.iVU.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.iVU.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.dio);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.iVU.setVisibility(0);
            this.iVU.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.iVU.setVisibility(8);
        }
        if (this.iVU.getVisibility() == 0) {
            return this.iVU.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.dio != null && this.dio.cKV() != null) {
            int size = this.iVT.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.iVT.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.iVV, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.iVS;
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
            if (this.iVU.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iVU.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.iVU.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.iVU.getMeasuredWidth(), this.iVU.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.iVS; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.iVU) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.dio != null && this.dio.cKV() != null) {
            int i = this.iVS;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.iVU.getVisibility() == 0) {
                drawChild(canvas, this.iVU, drawingTime);
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
    /* renamed from: crL */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.eVS != null) {
            this.eVS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            am.setViewTextColor(this.eVS, (int) R.color.cp_cont_c);
        }
    }
}
