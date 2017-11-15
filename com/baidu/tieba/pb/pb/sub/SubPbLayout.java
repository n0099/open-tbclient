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
    private int DS12;
    private int DS8;
    private float aRm;
    private int bhG;
    private d eIm;
    private View.OnClickListener faG;
    private View.OnLongClickListener faH;
    private View.OnTouchListener faI;
    private int faJ;
    private PostData faK;
    private final Queue<a> faL;
    private TextView faM;
    private ViewGroup.MarginLayoutParams faN;
    private CustomMessageListener faO;
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
        this.DS8 = 0;
        this.bhG = 0;
        this.DS12 = 0;
        this.faJ = 0;
        this.mRootView = null;
        this.aRm = TbConfig.getContentSizeOfLzl();
        this.faL = new LinkedList();
        this.faN = new ViewGroup.MarginLayoutParams(-1, -2);
        this.faO = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.sub.SubPbLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                float contentSizeOfLzl = TbConfig.getContentSizeOfLzl();
                if (contentSizeOfLzl != SubPbLayout.this.aRm) {
                    SubPbLayout.this.aRm = contentSizeOfLzl;
                    SubPbLayout.this.faM.setTextSize(0, contentSizeOfLzl);
                }
            }
        };
        this.DS8 = l.f(context, d.e.ds8);
        this.bhG = l.f(context, d.e.ds16);
        this.DS12 = l.f(context, d.e.ds12);
        this.mEmptyView = new View(context);
        addView(this.mEmptyView, -1, this.DS12);
        this.faM = new TextView(context);
        this.faM.setPadding(0, 0, 0, this.bhG);
        this.faM.setId(d.g.pb_floor_reply_more);
        this.faM.setTextSize(0, this.aRm);
        aj.i(this.faM, d.C0080d.cp_link_tip_c);
        addView(this.faM, -1, -2);
        com.baidu.adp.base.e<?> Y = i.Y(getContext());
        if (Y != null) {
            Y.registerListener(this.faO);
        }
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.faG = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.faH = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.faI = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.eIm = dVar;
    }

    public void a(PostData postData, View view) {
        this.faK = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> buD;
        int i3;
        SparseArray sparseArray;
        if (this.eIm == null || this.faK == null || this.faK.buD() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int i4 = 0;
        if (this.faK.buB()) {
            buD = this.faK.buz();
        } else {
            buD = this.faK.buD();
        }
        int u = v.u(buD);
        this.faJ = u;
        if (!this.faK.buB()) {
            if (u <= 2) {
                this.faJ = u;
            } else {
                this.faJ = 2;
            }
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i3 = i4;
            if (i6 >= this.faJ) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt == null || childAt.equals(this.faM) || childAt.equals(this.mEmptyView)) {
                childAt = this.eIm.kX();
                childAt.setPadding(0, 0, 0, this.DS8);
                this.faL.offer(new a(i6, childAt));
            }
            View view = childAt;
            view.setOnClickListener(this.faG);
            view.setOnLongClickListener(this.faH);
            view.setOnTouchListener(this.faI);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(d.g.tag_load_sub_data) != this.faK) {
                sparseArray.put(d.g.tag_load_sub_data, this.faK);
            }
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            sparseArray.put(d.g.tag_is_subpb, true);
            if (buD.get(i6) != null && buD.get(i6).rt() != null) {
                sparseArray.put(d.g.tag_photo_username, buD.get(i6).rt().getUserName());
                sparseArray.put(d.g.tag_photo_userid, buD.get(i6).rt().getUserId());
                sparseArray.put(d.g.tag_clip_board, buD.get(i6));
            }
            this.eIm.a((d.b) sparseArray.get(d.g.tag_holder), buD.get(i6), this.faK.buK() > buD.size() || buD.size() - i6 > 1, i6 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i4 = i3 + view.getMeasuredHeight();
            i5 = i6 + 1;
        }
        if (buD != null && buD.size() > 0 && this.faK.buK() > this.faJ) {
            this.faM.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.faK.buK() - this.faJ)));
            this.faM.setOnClickListener(this.faG);
            SparseArray sparseArray4 = (SparseArray) this.faM.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.faM.setTag(sparseArray4);
            }
            sparseArray4.put(d.g.tag_load_sub_data, this.faK);
            sparseArray4.put(d.g.tag_load_sub_view, this.mRootView);
            this.faM.setVisibility(0);
            this.faM.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.mEmptyView.setVisibility(8);
        } else {
            this.faM.setVisibility(8);
            this.mEmptyView.setVisibility(0);
            this.mEmptyView.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, this.DS12 + 1073741824);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop() + i3;
        if (this.faM.getVisibility() == 0) {
            paddingBottom += this.faM.getMeasuredHeight();
        }
        if (this.mEmptyView.getVisibility() == 0) {
            paddingBottom += this.mEmptyView.getMeasuredHeight();
        }
        setMeasuredDimension(size, paddingBottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.faK != null && this.faK.buD() != null) {
            int size = this.faL.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.faL.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.faN, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.faJ;
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
            if (this.faM.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.faM.getLayoutParams();
                int i12 = i9 + marginLayoutParams3.topMargin;
                this.faM.layout(marginLayoutParams3.leftMargin + paddingLeft, i12, marginLayoutParams3.leftMargin + paddingLeft + this.faM.getMeasuredWidth(), this.faM.getMeasuredHeight() + i12);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.faK != null && this.faK.buD() != null) {
            int i = this.faJ;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.mEmptyView.getVisibility() == 0) {
                drawChild(canvas, this.mEmptyView, drawingTime);
            }
            if (this.faM.getVisibility() == 0) {
                drawChild(canvas, this.faM, drawingTime);
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
    /* renamed from: aWI */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
