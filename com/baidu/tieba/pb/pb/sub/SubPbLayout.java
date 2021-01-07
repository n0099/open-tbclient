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
    private TextView bSb;
    private PostData fnu;
    private b lKB;
    private boolean lKC;
    private View mRootView;
    private View.OnClickListener mcX;
    private View.OnLongClickListener mcY;
    private View.OnTouchListener mcZ;
    private int mda;
    private final Queue<a> mdb;
    private RelativeLayout mdc;
    private ViewGroup.MarginLayoutParams mdd;
    SparseArray<Object> mde;

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
        this.mda = 0;
        this.mRootView = null;
        this.mdb = new LinkedList();
        this.lKC = false;
        this.mdd = new ViewGroup.MarginLayoutParams(-1, -2);
        this.mdc = new RelativeLayout(context);
        this.mdc.setId(R.id.pb_floor_reply_more);
        this.bSb = new TextView(context);
        this.bSb.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.bSb.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.lKC) {
            ao.setViewTextColor(this.bSb, R.color.CAM_X0304);
            this.bSb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ao.setViewTextColor(this.bSb, R.color.CAM_X0108);
            this.bSb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.bSb.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.mdc.addView(this.bSb);
        addView(this.mdc, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.mcX = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mcY = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mcZ = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.lKB = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.lKC = z;
    }

    public void setData(PostData postData, View view) {
        this.fnu = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dPb;
        if (this.lKB == null || this.fnu == null || this.fnu.dPb() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fnu.dPa()) {
            dPb = this.fnu.dOX();
        } else {
            dPb = this.fnu.dPb();
        }
        setMeasuredDimension(size, de(x.getCount(dPb), size) + q(dPb, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        int bmQ = com.baidu.tbadk.a.d.bmQ();
        if (this.fnu.dPq() == 1 || this.fnu.dPq() == 3) {
            this.mda = 0;
            return 0;
        } else if (x.getCount(list) != 0) {
            int count = x.getCount(list);
            this.mda = count;
            if (!this.fnu.dPa()) {
                if (count <= bmQ) {
                    this.mda = count;
                } else {
                    this.mda = bmQ;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.mda) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.mdc)) {
                    childAt = this.lKB.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.mdb.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.mcX);
                if (!this.lKC) {
                    view.setOnLongClickListener(this.mcY);
                }
                view.setOnTouchListener(this.mcZ);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.fnu) {
                    sparseArray.put(R.id.tag_load_sub_data, this.fnu);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).brr() != null) {
                    if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i2)) {
                        sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i2));
                    }
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).brr().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).brr().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                if (this.mde != null) {
                    sparseArray.put(-1, this.mde.get(-1));
                    sparseArray.put(-2, this.mde.get(-2));
                    sparseArray.put(-3, this.mde.get(-3));
                    sparseArray.put(-4, this.mde.get(-4));
                }
                b.C0854b c0854b = (b.C0854b) sparseArray.get(R.id.tag_holder);
                this.lKB.a(c0854b, list.get(i2), this.fnu.dPi() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0854b.lMa.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                this.bSb.setTextSize(0, TbConfig.getContentSizeOfLzl());
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
        if (i > 0 && (this.fnu.dPq() == 1 || this.fnu.dPq() == 3 || this.fnu.dPi() > this.mda)) {
            if (this.lKC) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.fnu.dPi()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.fnu.dPi()));
            }
            this.bSb.setText(format);
            this.mdc.setOnClickListener(this.mcX);
            SparseArray sparseArray = (SparseArray) this.mdc.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.mdc.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.fnu);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.mdc.setVisibility(0);
            this.mdc.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.mdc.setVisibility(8);
        }
        if (this.mdc.getVisibility() == 0) {
            return this.mdc.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 0;
        if (this.fnu != null && this.fnu.dPb() != null) {
            int size = this.mdb.size();
            for (int i7 = 0; i7 < size; i7++) {
                a poll = this.mdb.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.mdd, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i8 = this.mda;
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
            if (this.mdc.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mdc.getLayoutParams();
                int i10 = paddingTop + marginLayoutParams2.topMargin;
                this.mdc.layout(marginLayoutParams2.leftMargin + paddingLeft, i10, marginLayoutParams2.leftMargin + paddingLeft + this.mdc.getMeasuredWidth(), this.mdc.getMeasuredHeight() + i10);
            }
            int childCount = getChildCount();
            for (int i11 = this.mda; i11 < childCount; i11++) {
                View childAt2 = getChildAt(i11);
                if (childAt2 != null && childAt2 != this.mdc) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fnu != null && this.fnu.dPb() != null) {
            int i = this.mda;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.mdc.getVisibility() == 0) {
                drawChild(canvas, this.mdc, drawingTime);
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
    /* renamed from: duC */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bSb != null) {
            if (this.lKC) {
                ao.setViewTextColor(this.bSb, R.color.CAM_X0304);
                this.bSb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.bSb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ao.setViewTextColor(this.bSb, R.color.CAM_X0108);
        }
    }

    public void setDefaultTag(SparseArray<Object> sparseArray) {
        this.mde = sparseArray;
    }
}
