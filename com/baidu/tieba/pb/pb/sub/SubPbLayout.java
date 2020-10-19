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
    private TextView bBo;
    private PostData eIW;
    private b kYM;
    private boolean kYO;
    private View.OnClickListener lqZ;
    private View.OnLongClickListener lra;
    private View.OnTouchListener lrb;
    private int lrc;
    private final Queue<a> lrd;
    private RelativeLayout lre;
    private ViewGroup.MarginLayoutParams lrf;
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
        this.lrc = 0;
        this.mRootView = null;
        this.lrd = new LinkedList();
        this.kYO = false;
        this.lrf = new ViewGroup.MarginLayoutParams(-1, -2);
        this.lre = new RelativeLayout(context);
        this.lre.setId(R.id.pb_floor_reply_more);
        this.bBo = new TextView(context);
        this.bBo.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.bBo.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.kYO) {
            ap.setViewTextColor(this.bBo, R.color.cp_link_tip_c);
            this.bBo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ap.setViewTextColor(this.bBo, R.color.cp_cont_c);
            this.bBo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.bBo.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.lre.addView(this.bBo);
        addView(this.lre, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.lqZ = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lra = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.lrb = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.kYM = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.kYO = z;
    }

    public void setData(PostData postData, View view) {
        this.eIW = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dEm;
        if (this.kYM == null || this.eIW == null || this.eIW.dEm() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.eIW.dEl()) {
            dEm = this.eIW.dEi();
        } else {
            dEm = this.eIW.dEm();
        }
        setMeasuredDimension(size, cZ(y.getCount(dEm), size) + q(dEm, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.eIW.dEB() == 1 || this.eIW.dEB() == 3) {
            this.lrc = 0;
            return 0;
        } else if (y.getCount(list) != 0) {
            int count = y.getCount(list);
            this.lrc = count;
            if (!this.eIW.dEl()) {
                if (count <= 2) {
                    this.lrc = count;
                } else {
                    this.lrc = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.lrc) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.lre)) {
                    childAt = this.kYM.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.lrd.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.lqZ);
                if (!this.kYO) {
                    view.setOnLongClickListener(this.lra);
                }
                view.setOnTouchListener(this.lrb);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.eIW) {
                    sparseArray.put(R.id.tag_load_sub_data, this.eIW);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).bih() != null) {
                    if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i2)) {
                        sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i2));
                    }
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).bih().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).bih().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                b.C0789b c0789b = (b.C0789b) sparseArray.get(R.id.tag_holder);
                this.kYM.a(c0789b, list.get(i2), this.eIW.dEt() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0789b.lai.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                this.bBo.setTextSize(0, TbConfig.getContentSizeOfLzl());
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cZ(int i, int i2) {
        String format;
        if (i > 0 && (this.eIW.dEB() == 1 || this.eIW.dEB() == 3 || this.eIW.dEt() > this.lrc)) {
            if (this.kYO) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.eIW.dEt()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.eIW.dEt()));
            }
            this.bBo.setText(format);
            this.lre.setOnClickListener(this.lqZ);
            SparseArray sparseArray = (SparseArray) this.lre.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.lre.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.eIW);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.lre.setVisibility(0);
            this.lre.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.lre.setVisibility(8);
        }
        if (this.lre.getVisibility() == 0) {
            return this.lre.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eIW != null && this.eIW.dEm() != null) {
            int size = this.lrd.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.lrd.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.lrf, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.lrc;
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
            if (this.lre.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lre.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.lre.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.lre.getMeasuredWidth(), this.lre.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.lrc; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.lre) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eIW != null && this.eIW.dEm() != null) {
            int i = this.lrc;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.lre.getVisibility() == 0) {
                drawChild(canvas, this.lre, drawingTime);
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
    /* renamed from: dkk */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bBo != null) {
            if (this.kYO) {
                ap.setViewTextColor(this.bBo, R.color.cp_link_tip_c);
                this.bBo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.bBo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ap.setViewTextColor(this.bBo, R.color.cp_cont_c);
        }
    }
}
