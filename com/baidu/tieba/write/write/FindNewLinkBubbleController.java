package com.baidu.tieba.write.write;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FindNewLinkBubbleController {
    private com.baidu.tieba.c.e kTb;
    private TbPageContext mPageContext;
    private a ncU;

    /* loaded from: classes3.dex */
    public enum ANCHOR_VIEW_FROM {
        FROM_EDITOR_TOOL,
        FROM_EDIT_TEXT
    }

    /* loaded from: classes3.dex */
    public interface a {
        void f(View view, String str);
    }

    public FindNewLinkBubbleController(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.ncU = aVar;
    }

    public void Rc() {
        if (this.kTb != null) {
            this.kTb.Oj();
        }
    }

    public void a(@NonNull View view, @NonNull final String str, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !at.isEmpty(str)) {
            if (this.kTb == null) {
                this.kTb = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.kTb.eW(R.drawable.pic_post_findlink);
                this.kTb.wf(2);
                this.kTb.nB(true);
                this.kTb.setTextViewGravity(19);
                this.kTb.setTextColor(R.color.cp_cont_b);
                this.kTb.eX(3000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.kTb.eV(32);
                this.kTb.setAnchor(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.kTb.z(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.kTb.we(0);
                this.kTb.setYOffset(-dimensionPixelSize2);
                this.kTb.setHeight(R.dimen.tbds177);
                this.kTb.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.kTb.eV(32);
                this.kTb.setAnchor(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.kTb.z(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.kTb.we(0);
                this.kTb.setYOffset(-dimensionPixelSize4);
                this.kTb.setHeight(R.dimen.tbds177);
                this.kTb.setWidth(R.dimen.tbds484);
            }
            this.kTb.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FindNewLinkBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (FindNewLinkBubbleController.this.ncU != null) {
                        FindNewLinkBubbleController.this.ncU.f(view2, str);
                    }
                }
            });
            this.kTb.HG(this.mPageContext.getResources().getString(R.string.find_new_link) + "\n" + str);
            TiebaStatic.log("c13801");
        }
    }
}
