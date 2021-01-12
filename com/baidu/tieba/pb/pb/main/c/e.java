package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a;
import com.baidu.card.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e extends a {
    private ItemCardView ahk;
    private com.baidu.tbadk.core.data.a lVo;
    private bz lVr;
    private af lVv;
    private LinearLayout mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = new LinearLayout(this.eSJ.getPageActivity());
            this.mRootView.setClipChildren(false);
            this.mRootView.setClipToPadding(false);
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            this.mRootView.setOrientation(1);
            this.mRootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.mRootView.removeAllViews();
        if (this.lVv == null) {
            this.lVv = new af(this.eSJ);
            this.lVv.c(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.mRootView.addView(this.lVv.getView(), layoutParams);
        if (this.ahk == null) {
            this.ahk = new ItemCardView(this.eSJ.getPageActivity());
        }
        this.ahk.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.leftMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.rightMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.bottomMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.ahk, layoutParams2);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lVn = originalThreadInfo;
        this.lVr = originalThreadInfo == null ? null : originalThreadInfo.blX();
        this.lVo = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.e.1
            @Override // com.baidu.tbadk.core.data.a
            public bz bkV() {
                return e.this.lVr;
            }

            @Override // com.baidu.tbadk.core.data.a
            public at bkX() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
            public BdUniqueId getType() {
                return null;
            }
        };
        if (this.ahk != null && originalThreadInfo != null) {
            this.ahk.setData(originalThreadInfo.item, 17);
        }
        if (this.lVv != null) {
            this.lVv.C(this.lVo);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0088a interfaceC0088a) {
        super.a(interfaceC0088a);
        if (this.lVv != null) {
            this.lVv.a(interfaceC0088a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.agp != null) {
                        e.this.agp.a(e.this.lVo);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0206);
            if (this.lVv != null) {
                this.lVv.onChangeSkinType(tbPageContext, i);
            }
            if (this.ahk != null) {
                this.ahk.onChangeSkinType();
            }
        }
    }
}
