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
    private b lKC;
    private boolean lKD;
    private View mRootView;
    private View.OnClickListener mcY;
    private View.OnLongClickListener mcZ;
    private View.OnTouchListener mda;
    private int mdb;
    private final Queue<a> mdc;
    private RelativeLayout mdd;
    private ViewGroup.MarginLayoutParams mde;
    SparseArray<Object> mdf;

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
        this.mdb = 0;
        this.mRootView = null;
        this.mdc = new LinkedList();
        this.lKD = false;
        this.mde = new ViewGroup.MarginLayoutParams(-1, -2);
        this.mdd = new RelativeLayout(context);
        this.mdd.setId(R.id.pb_floor_reply_more);
        this.bSb = new TextView(context);
        this.bSb.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.bSb.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.lKD) {
            ao.setViewTextColor(this.bSb, R.color.CAM_X0304);
            this.bSb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ao.setViewTextColor(this.bSb, R.color.CAM_X0108);
            this.bSb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.bSb.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.mdd.addView(this.bSb);
        addView(this.mdd, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.mcY = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mcZ = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mda = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.lKC = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.lKD = z;
    }

    public void setData(PostData postData, View view) {
        this.fnu = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dPa;
        if (this.lKC == null || this.fnu == null || this.fnu.dPa() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fnu.dOZ()) {
            dPa = this.fnu.dOW();
        } else {
            dPa = this.fnu.dPa();
        }
        setMeasuredDimension(size, de(x.getCount(dPa), size) + q(dPa, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        int bmP = com.baidu.tbadk.a.d.bmP();
        if (this.fnu.dPp() == 1 || this.fnu.dPp() == 3) {
            this.mdb = 0;
            return 0;
        } else if (x.getCount(list) != 0) {
            int count = x.getCount(list);
            this.mdb = count;
            if (!this.fnu.dOZ()) {
                if (count <= bmP) {
                    this.mdb = count;
                } else {
                    this.mdb = bmP;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.mdb) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.mdd)) {
                    childAt = this.lKC.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.mdc.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.mcY);
                if (!this.lKD) {
                    view.setOnLongClickListener(this.mcZ);
                }
                view.setOnTouchListener(this.mda);
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
                if (list.get(i2) != null && list.get(i2).brq() != null) {
                    if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i2)) {
                        sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i2));
                    }
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).brq().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).brq().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                if (this.mdf != null) {
                    sparseArray.put(-1, this.mdf.get(-1));
                    sparseArray.put(-2, this.mdf.get(-2));
                    sparseArray.put(-3, this.mdf.get(-3));
                    sparseArray.put(-4, this.mdf.get(-4));
                }
                b.C0821b c0821b = (b.C0821b) sparseArray.get(R.id.tag_holder);
                this.lKC.a(c0821b, list.get(i2), this.fnu.dPh() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0821b.lMb.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
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
        if (i > 0 && (this.fnu.dPp() == 1 || this.fnu.dPp() == 3 || this.fnu.dPh() > this.mdb)) {
            if (this.lKD) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.fnu.dPh()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.fnu.dPh()));
            }
            this.bSb.setText(format);
            this.mdd.setOnClickListener(this.mcY);
            SparseArray sparseArray = (SparseArray) this.mdd.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.mdd.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.fnu);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.mdd.setVisibility(0);
            this.mdd.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.mdd.setVisibility(8);
        }
        if (this.mdd.getVisibility() == 0) {
            return this.mdd.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 0;
        if (this.fnu != null && this.fnu.dPa() != null) {
            int size = this.mdc.size();
            for (int i7 = 0; i7 < size; i7++) {
                a poll = this.mdc.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.mde, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i8 = this.mdb;
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
            if (this.mdd.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mdd.getLayoutParams();
                int i10 = paddingTop + marginLayoutParams2.topMargin;
                this.mdd.layout(marginLayoutParams2.leftMargin + paddingLeft, i10, marginLayoutParams2.leftMargin + paddingLeft + this.mdd.getMeasuredWidth(), this.mdd.getMeasuredHeight() + i10);
            }
            int childCount = getChildCount();
            for (int i11 = this.mdb; i11 < childCount; i11++) {
                View childAt2 = getChildAt(i11);
                if (childAt2 != null && childAt2 != this.mdd) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fnu != null && this.fnu.dPa() != null) {
            int i = this.mdb;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.mdd.getVisibility() == 0) {
                drawChild(canvas, this.mdd, drawingTime);
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
    /* renamed from: duB */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bSb != null) {
            if (this.lKD) {
                ao.setViewTextColor(this.bSb, R.color.CAM_X0304);
                this.bSb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.bSb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ao.setViewTextColor(this.bSb, R.color.CAM_X0108);
        }
    }

    public void setDefaultTag(SparseArray<Object> sparseArray) {
        this.mdf = sparseArray;
    }
}
