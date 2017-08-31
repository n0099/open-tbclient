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
import com.baidu.adp.lib.util.k;
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
    private float aRn;
    private int bfp;
    private d eFM;
    private int eKb;
    private int eKc;
    private View.OnClickListener eWN;
    private View.OnLongClickListener eWO;
    private View.OnTouchListener eWP;
    private int eWQ;
    private int eWR;
    private PostData eWS;
    private final Queue<a> eWT;
    private TextView eWU;
    private ViewGroup.MarginLayoutParams eWV;
    private CustomMessageListener eWW;
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
        this.eKb = 0;
        this.eKc = 0;
        this.bfp = 0;
        this.eWQ = 0;
        this.eWR = 0;
        this.mRootView = null;
        this.aRn = TbConfig.getContentSizeOfLzl();
        this.eWT = new LinkedList();
        this.eWV = new ViewGroup.MarginLayoutParams(-1, -2);
        this.eWW = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.sub.SubPbLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                float contentSizeOfLzl = TbConfig.getContentSizeOfLzl();
                if (contentSizeOfLzl != SubPbLayout.this.aRn) {
                    SubPbLayout.this.aRn = contentSizeOfLzl;
                    SubPbLayout.this.eWU.setTextSize(0, contentSizeOfLzl);
                }
            }
        };
        this.eKb = k.g(context, d.f.ds8);
        this.eKc = k.g(context, d.f.ds20);
        this.bfp = k.g(context, d.f.ds16);
        this.eWQ = k.g(context, d.f.ds12);
        this.mEmptyView = new View(context);
        addView(this.mEmptyView, -1, this.eWQ);
        this.eWU = new TextView(context);
        this.eWU.setPadding(0, 0, 0, this.bfp);
        this.eWU.setId(d.h.pb_floor_reply_more);
        this.eWU.setTextSize(0, this.aRn);
        aj.i(this.eWU, d.e.cp_link_tip_c);
        addView(this.eWU, -1, -2);
        com.baidu.adp.base.e<?> X = i.X(getContext());
        if (X != null) {
            X.registerListener(this.eWW);
        }
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.eWN = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.eWO = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eWP = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.eFM = dVar;
    }

    public void a(PostData postData, View view) {
        this.eWS = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bsl;
        int i3;
        SparseArray sparseArray;
        if (this.eFM == null || this.eWS == null || this.eWS.bsl() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int i4 = 0;
        if (this.eWS.bsj()) {
            bsl = this.eWS.bsi();
        } else {
            bsl = this.eWS.bsl();
        }
        int u = v.u(bsl);
        this.eWR = u;
        if (!this.eWS.bsj()) {
            if (u <= 2) {
                this.eWR = u;
            } else {
                this.eWR = 2;
            }
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i3 = i4;
            if (i6 >= this.eWR) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt == null || childAt.equals(this.eWU) || childAt.equals(this.mEmptyView)) {
                childAt = this.eFM.lb();
                childAt.setPadding(0, 0, 0, this.eKb);
                this.eWT.offer(new a(i6, childAt));
            }
            View view = childAt;
            view.setOnClickListener(this.eWN);
            view.setOnLongClickListener(this.eWO);
            view.setOnTouchListener(this.eWP);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(d.h.tag_load_sub_data) != this.eWS) {
                sparseArray.put(d.h.tag_load_sub_data, this.eWS);
            }
            sparseArray.put(d.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(d.h.tag_is_subpb, true);
            if (bsl.get(i6) != null && bsl.get(i6).getAuthor() != null) {
                sparseArray.put(d.h.tag_photo_username, bsl.get(i6).getAuthor().getUserName());
                sparseArray.put(d.h.tag_photo_userid, bsl.get(i6).getAuthor().getUserId());
                sparseArray.put(d.h.tag_clip_board, bsl.get(i6));
            }
            this.eFM.a((d.b) sparseArray.get(d.h.tag_holder), bsl.get(i6), this.eWS.bss() > bsl.size() || bsl.size() - i6 > 1, i6 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i4 = i3 + view.getMeasuredHeight();
            i5 = i6 + 1;
        }
        if (bsl != null && bsl.size() > 0 && this.eWS.bss() > this.eWR) {
            this.eWU.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.l.sub_pb_load_more), Integer.valueOf(this.eWS.bss() - this.eWR)));
            this.eWU.setOnClickListener(this.eWN);
            SparseArray sparseArray4 = (SparseArray) this.eWU.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.eWU.setTag(sparseArray4);
            }
            sparseArray4.put(d.h.tag_load_sub_data, this.eWS);
            sparseArray4.put(d.h.tag_load_sub_view, this.mRootView);
            this.eWU.setVisibility(0);
            this.eWU.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.mEmptyView.setVisibility(8);
        } else {
            this.eWU.setVisibility(8);
            this.mEmptyView.setVisibility(0);
            this.mEmptyView.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, this.eWQ + 1073741824);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop() + i3;
        if (this.eWU.getVisibility() == 0) {
            paddingBottom += this.eWU.getMeasuredHeight();
        }
        if (this.mEmptyView.getVisibility() == 0) {
            paddingBottom += this.mEmptyView.getMeasuredHeight();
        }
        setMeasuredDimension(size, paddingBottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eWS != null && this.eWS.bsl() != null) {
            int size = this.eWT.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.eWT.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.eWV, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.eWR;
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
            if (this.eWU.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.eWU.getLayoutParams();
                int i12 = i9 + marginLayoutParams3.topMargin;
                this.eWU.layout(marginLayoutParams3.leftMargin + paddingLeft, i12, marginLayoutParams3.leftMargin + paddingLeft + this.eWU.getMeasuredWidth(), this.eWU.getMeasuredHeight() + i12);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eWS != null && this.eWS.bsl() != null) {
            int i = this.eWR;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.mEmptyView.getVisibility() == 0) {
                drawChild(canvas, this.mEmptyView, drawingTime);
            }
            if (this.eWU.getVisibility() == 0) {
                drawChild(canvas, this.eWU, drawingTime);
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
    /* renamed from: aVj */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
