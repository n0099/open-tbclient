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
/* loaded from: classes2.dex */
public class SubPbLayout extends ViewGroup {
    private TextView bSF;
    private PostData fmC;
    private b lRe;
    private boolean lRf;
    private View mRootView;
    private View.OnClickListener mjO;
    private View.OnLongClickListener mjP;
    private View.OnTouchListener mjQ;
    private int mjR;
    private final Queue<a> mjS;
    private RelativeLayout mjT;
    private ViewGroup.MarginLayoutParams mjU;
    SparseArray<Object> mjV;

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
        this.mjR = 0;
        this.mRootView = null;
        this.mjS = new LinkedList();
        this.lRf = false;
        this.mjU = new ViewGroup.MarginLayoutParams(-1, -2);
        this.mjT = new RelativeLayout(context);
        this.mjT.setId(R.id.pb_floor_reply_more);
        this.bSF = new TextView(context);
        this.bSF.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.bSF.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.lRf) {
            ap.setViewTextColor(this.bSF, R.color.CAM_X0304);
            this.bSF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ap.setViewTextColor(this.bSF, R.color.CAM_X0108);
            this.bSF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.bSF.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.mjT.addView(this.bSF);
        addView(this.mjT, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.mjO = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mjP = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mjQ = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.lRe = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.lRf = z;
    }

    public void setData(PostData postData, View view) {
        this.fmC = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dNL;
        if (this.lRe == null || this.fmC == null || this.fmC.dNL() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fmC.dNK()) {
            dNL = this.fmC.dNH();
        } else {
            dNL = this.fmC.dNL();
        }
        setMeasuredDimension(size, dc(y.getCount(dNL), size) + q(dNL, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        int bjk = com.baidu.tbadk.a.d.bjk();
        if (this.fmC.dOa() == 1 || this.fmC.dOa() == 3) {
            this.mjR = 0;
            return 0;
        } else if (y.getCount(list) != 0) {
            int count = y.getCount(list);
            this.mjR = count;
            if (!this.fmC.dNK()) {
                if (count <= bjk) {
                    this.mjR = count;
                } else {
                    this.mjR = bjk;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.mjR) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.mjT)) {
                    childAt = this.lRe.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.mjS.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.mjO);
                if (!this.lRf) {
                    view.setOnLongClickListener(this.mjP);
                }
                view.setOnTouchListener(this.mjQ);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.fmC) {
                    sparseArray.put(R.id.tag_load_sub_data, this.fmC);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).bnS() != null) {
                    if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i2)) {
                        sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i2));
                    }
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).bnS().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).bnS().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                if (this.mjV != null) {
                    sparseArray.put(-1, this.mjV.get(-1));
                    sparseArray.put(-2, this.mjV.get(-2));
                    sparseArray.put(-3, this.mjV.get(-3));
                    sparseArray.put(-4, this.mjV.get(-4));
                }
                b.C0847b c0847b = (b.C0847b) sparseArray.get(R.id.tag_holder);
                this.lRe.a(c0847b, list.get(i2), this.fmC.dNS() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0847b.lSH.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                this.bSF.setTextSize(0, TbConfig.getContentSizeOfLzl());
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int dc(int i, int i2) {
        String format;
        if (i > 0 && (this.fmC.dOa() == 1 || this.fmC.dOa() == 3 || this.fmC.dNS() > this.mjR)) {
            if (this.lRf) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.fmC.dNS()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.fmC.dNS()));
            }
            this.bSF.setText(format);
            this.mjT.setOnClickListener(this.mjO);
            SparseArray sparseArray = (SparseArray) this.mjT.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.mjT.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.fmC);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.mjT.setVisibility(0);
            this.mjT.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.mjT.setVisibility(8);
        }
        if (this.mjT.getVisibility() == 0) {
            return this.mjT.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 0;
        if (this.fmC != null && this.fmC.dNL() != null) {
            int size = this.mjS.size();
            for (int i7 = 0; i7 < size; i7++) {
                a poll = this.mjS.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.mjU, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i8 = this.mjR;
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
            if (this.mjT.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mjT.getLayoutParams();
                int i10 = paddingTop + marginLayoutParams2.topMargin;
                this.mjT.layout(marginLayoutParams2.leftMargin + paddingLeft, i10, marginLayoutParams2.leftMargin + paddingLeft + this.mjT.getMeasuredWidth(), this.mjT.getMeasuredHeight() + i10);
            }
            int childCount = getChildCount();
            for (int i11 = this.mjR; i11 < childCount; i11++) {
                View childAt2 = getChildAt(i11);
                if (childAt2 != null && childAt2 != this.mjT) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fmC != null && this.fmC.dNL() != null) {
            int i = this.mjR;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.mjT.getVisibility() == 0) {
                drawChild(canvas, this.mjT, drawingTime);
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
    /* renamed from: dto */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bSF != null) {
            if (this.lRf) {
                ap.setViewTextColor(this.bSF, R.color.CAM_X0304);
                this.bSF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.bSF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ap.setViewTextColor(this.bSF, R.color.CAM_X0108);
        }
    }

    public void setDefaultTag(SparseArray<Object> sparseArray) {
        this.mjV = sparseArray;
    }
}
