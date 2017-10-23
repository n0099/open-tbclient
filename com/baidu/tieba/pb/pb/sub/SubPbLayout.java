package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private float aRZ;
    private int bgL;
    private int cVW;
    private int eEh;
    private View.OnClickListener eRC;
    private View.OnLongClickListener eRD;
    private View.OnTouchListener eRE;
    private int eRF;
    private int eRG;
    private PostData eRH;
    private final Queue<a> eRI;
    private TextView eRJ;
    private ViewGroup.MarginLayoutParams eRK;
    private CustomMessageListener eRL;
    private d ezP;
    private View mEmptyView;
    private View mRootView;

    /* loaded from: classes.dex */
    private static class a {
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
        this.eEh = 0;
        this.cVW = 0;
        this.bgL = 0;
        this.eRF = 0;
        this.eRG = 0;
        this.mRootView = null;
        this.aRZ = TbConfig.getContentSizeOfLzl();
        this.eRI = new LinkedList();
        this.eRK = new ViewGroup.MarginLayoutParams(-1, -2);
        this.eRL = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.sub.SubPbLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                float contentSizeOfLzl = TbConfig.getContentSizeOfLzl();
                if (contentSizeOfLzl != SubPbLayout.this.aRZ) {
                    SubPbLayout.this.aRZ = contentSizeOfLzl;
                    SubPbLayout.this.eRJ.setTextSize(0, contentSizeOfLzl);
                }
            }
        };
        this.eEh = l.f(context, d.f.ds8);
        this.cVW = l.f(context, d.f.ds20);
        this.bgL = l.f(context, d.f.ds16);
        this.eRF = l.f(context, d.f.ds12);
        this.mEmptyView = new View(context);
        addView(this.mEmptyView, -1, this.eRF);
        this.eRJ = new TextView(context);
        this.eRJ.setPadding(0, 0, 0, this.bgL);
        this.eRJ.setId(d.h.pb_floor_reply_more);
        this.eRJ.setTextSize(0, this.aRZ);
        aj.i(this.eRJ, d.e.cp_link_tip_c);
        addView(this.eRJ, -1, -2);
        com.baidu.adp.base.e<?> Y = i.Y(getContext());
        if (Y != null) {
            Y.registerListener(this.eRL);
        }
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.eRC = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.eRD = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eRE = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.ezP = dVar;
    }

    public void a(PostData postData, View view) {
        this.eRH = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> brn;
        int i3;
        SparseArray sparseArray;
        if (this.ezP == null || this.eRH == null || this.eRH.brn() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int i4 = 0;
        if (this.eRH.brl()) {
            brn = this.eRH.brj();
        } else {
            brn = this.eRH.brn();
        }
        int t = v.t(brn);
        this.eRG = t;
        if (!this.eRH.brl()) {
            if (t <= 2) {
                this.eRG = t;
            } else {
                this.eRG = 2;
            }
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i3 = i4;
            if (i6 >= this.eRG) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt == null || childAt.equals(this.eRJ) || childAt.equals(this.mEmptyView)) {
                childAt = this.ezP.ld();
                childAt.setPadding(0, 0, 0, this.eEh);
                this.eRI.offer(new a(i6, childAt));
            }
            View view = childAt;
            view.setOnClickListener(this.eRC);
            view.setOnLongClickListener(this.eRD);
            view.setOnTouchListener(this.eRE);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(d.h.tag_load_sub_data) != this.eRH) {
                sparseArray.put(d.h.tag_load_sub_data, this.eRH);
            }
            sparseArray.put(d.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(d.h.tag_is_subpb, true);
            if (brn.get(i6) != null && brn.get(i6).getAuthor() != null) {
                sparseArray.put(d.h.tag_photo_username, brn.get(i6).getAuthor().getUserName());
                sparseArray.put(d.h.tag_photo_userid, brn.get(i6).getAuthor().getUserId());
                sparseArray.put(d.h.tag_clip_board, brn.get(i6));
            }
            this.ezP.a((d.b) sparseArray.get(d.h.tag_holder), brn.get(i6), this.eRH.bru() > brn.size() || brn.size() - i6 > 1, i6 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i4 = i3 + view.getMeasuredHeight();
            i5 = i6 + 1;
        }
        if (brn != null && brn.size() > 0 && this.eRH.bru() > this.eRG) {
            this.eRJ.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.l.sub_pb_load_more), Integer.valueOf(this.eRH.bru() - this.eRG)));
            this.eRJ.setOnClickListener(this.eRC);
            SparseArray sparseArray4 = (SparseArray) this.eRJ.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.eRJ.setTag(sparseArray4);
            }
            sparseArray4.put(d.h.tag_load_sub_data, this.eRH);
            sparseArray4.put(d.h.tag_load_sub_view, this.mRootView);
            this.eRJ.setVisibility(0);
            this.eRJ.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.mEmptyView.setVisibility(8);
        } else {
            this.eRJ.setVisibility(8);
            this.mEmptyView.setVisibility(0);
            this.mEmptyView.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, this.eRF + 1073741824);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop() + i3;
        if (this.eRJ.getVisibility() == 0) {
            paddingBottom += this.eRJ.getMeasuredHeight();
        }
        if (this.mEmptyView.getVisibility() == 0) {
            paddingBottom += this.mEmptyView.getMeasuredHeight();
        }
        setMeasuredDimension(size, paddingBottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eRH != null && this.eRH.brn() != null) {
            int size = this.eRI.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.eRI.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.eRK, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.eRG;
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
            if (this.mEmptyView.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mEmptyView.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.mEmptyView.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.mEmptyView.getMeasuredWidth(), this.mEmptyView.getMeasuredHeight() + i11);
                i9 = i11 + marginLayoutParams2.bottomMargin;
            }
            if (this.eRJ.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.eRJ.getLayoutParams();
                int i12 = i9 + marginLayoutParams3.topMargin;
                this.eRJ.layout(marginLayoutParams3.leftMargin + paddingLeft, i12, marginLayoutParams3.leftMargin + paddingLeft + this.eRJ.getMeasuredWidth(), this.eRJ.getMeasuredHeight() + i12);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eRH != null && this.eRH.brn() != null) {
            int i = this.eRG;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.mEmptyView.getVisibility() == 0) {
                drawChild(canvas, this.mEmptyView, drawingTime);
            }
            if (this.eRJ.getVisibility() == 0) {
                drawChild(canvas, this.eRJ, drawingTime);
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
    /* renamed from: aTy */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
