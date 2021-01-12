package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes2.dex */
public class f extends a {
    private ItemCardView ahk;
    private com.baidu.tbadk.core.data.a lVo;
    private bz lVr;
    private o lVx;
    private LinearLayout mRootView;

    public f(TbPageContext tbPageContext) {
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
        if (this.lVx == null) {
            this.lVx = new o(this.eSJ.getPageActivity());
            this.lVx.c(true);
            this.lVx.setFrom("pb");
            this.lVx.setFromForPb(0);
            this.lVx.e(this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
            this.lVx.aF(false);
            this.lVx.aG(true);
        }
        this.mRootView.addView(this.lVx.getView());
        if (this.ahk == null) {
            this.ahk = new ItemCardView(this.eSJ.getPageActivity());
        }
        this.ahk.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.mRootView.addView(this.ahk, layoutParams);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.lVn = originalThreadInfo;
        this.lVr = originalThreadInfo == null ? null : originalThreadInfo.blX();
        this.lVo = new com.baidu.tbadk.core.data.a() { // from class: com.baidu.tieba.pb.pb.main.c.f.1
            @Override // com.baidu.tbadk.core.data.a
            public bz bkV() {
                return f.this.lVr;
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
        if (this.lVx != null) {
            this.lVx.C(this.lVo);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
        if (this.lVx != null) {
            this.lVx.setOnCardSubClickListener(this.lVm);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0088a interfaceC0088a) {
        super.a(interfaceC0088a);
        if (this.lVx != null) {
            this.lVx.a(interfaceC0088a);
        }
        if (this.mRootView != null) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.c.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.agp != null) {
                        f.this.agp.a(f.this.lVo);
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
            if (this.lVx != null) {
                this.lVx.onChangeSkinType(tbPageContext, i);
            }
            if (this.ahk != null) {
                this.ahk.onChangeSkinType();
            }
        }
    }
}
