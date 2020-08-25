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
/* loaded from: classes16.dex */
public class SubPbLayout extends ViewGroup {
    private PostData euE;
    private TextView gsx;
    private b kAX;
    private boolean kAZ;
    private View.OnClickListener kSX;
    private View.OnLongClickListener kSY;
    private View.OnTouchListener kSZ;
    private int kTa;
    private final Queue<a> kTb;
    private RelativeLayout kTc;
    private ViewGroup.MarginLayoutParams kTd;
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
        this.kTa = 0;
        this.mRootView = null;
        this.kTb = new LinkedList();
        this.kAZ = false;
        this.kTd = new ViewGroup.MarginLayoutParams(-1, -2);
        this.kTc = new RelativeLayout(context);
        this.kTc.setId(R.id.pb_floor_reply_more);
        this.gsx = new TextView(context);
        this.gsx.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.gsx.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.kAZ) {
            ap.setViewTextColor(this.gsx, R.color.cp_link_tip_c);
            this.gsx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ap.setViewTextColor(this.gsx, R.color.cp_cont_c);
            this.gsx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.gsx.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.kTc.addView(this.gsx);
        addView(this.kTc, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.kSX = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.kSY = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.kSZ = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.kAX = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.kAZ = z;
    }

    public void setData(PostData postData, View view) {
        this.euE = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dwC;
        if (this.kAX == null || this.euE == null || this.euE.dwC() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.euE.dwB()) {
            dwC = this.euE.dwy();
        } else {
            dwC = this.euE.dwC();
        }
        setMeasuredDimension(size, cW(y.getCount(dwC), size) + q(dwC, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.euE.dwR() == 1 || this.euE.dwR() == 3) {
            this.kTa = 0;
            return 0;
        } else if (y.getCount(list) != 0) {
            int count = y.getCount(list);
            this.kTa = count;
            if (!this.euE.dwB()) {
                if (count <= 2) {
                    this.kTa = count;
                } else {
                    this.kTa = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.kTa) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.kTc)) {
                    childAt = this.kAX.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.kTb.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.kSX);
                if (!this.kAZ) {
                    view.setOnLongClickListener(this.kSY);
                }
                view.setOnTouchListener(this.kSZ);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.euE) {
                    sparseArray.put(R.id.tag_load_sub_data, this.euE);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).beE() != null) {
                    if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i2)) {
                        sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i2));
                    }
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).beE().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).beE().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                b.C0774b c0774b = (b.C0774b) sparseArray.get(R.id.tag_holder);
                this.kAX.a(c0774b, list.get(i2), this.euE.dwJ() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0774b.kCs.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                this.gsx.setTextSize(0, TbConfig.getContentSizeOfLzl());
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cW(int i, int i2) {
        String format;
        if (i > 0 && (this.euE.dwR() == 1 || this.euE.dwR() == 3 || this.euE.dwJ() > this.kTa)) {
            if (this.kAZ) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.euE.dwJ()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.euE.dwJ()));
            }
            this.gsx.setText(format);
            this.kTc.setOnClickListener(this.kSX);
            SparseArray sparseArray = (SparseArray) this.kTc.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.kTc.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.euE);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.kTc.setVisibility(0);
            this.kTc.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.kTc.setVisibility(8);
        }
        if (this.kTc.getVisibility() == 0) {
            return this.kTc.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.euE != null && this.euE.dwC() != null) {
            int size = this.kTb.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.kTb.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.kTd, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.kTa;
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
            if (this.kTc.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.kTc.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.kTc.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.kTc.getMeasuredWidth(), this.kTc.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.kTa; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.kTc) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.euE != null && this.euE.dwC() != null) {
            int i = this.kTa;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.kTc.getVisibility() == 0) {
                drawChild(canvas, this.kTc, drawingTime);
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
    /* renamed from: dcW */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.gsx != null) {
            if (this.kAZ) {
                ap.setViewTextColor(this.gsx, R.color.cp_link_tip_c);
                this.gsx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.gsx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ap.setViewTextColor(this.gsx, R.color.cp_cont_c);
        }
    }
}
