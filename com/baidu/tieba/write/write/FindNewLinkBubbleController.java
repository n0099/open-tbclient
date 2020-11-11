package com.baidu.tieba.write.write;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FindNewLinkBubbleController {
    private com.baidu.tieba.c.e lAO;
    private TbPageContext mPageContext;
    private a nKM;

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
        this.nKM = aVar;
    }

    public void Wt() {
        if (this.lAO != null) {
            this.lAO.SR();
        }
    }

    public void a(@NonNull View view, @NonNull final String str, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !at.isEmpty(str)) {
            if (this.lAO == null) {
                this.lAO = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.lAO.fu(R.drawable.pic_post_findlink);
                this.lAO.xr(2);
                this.lAO.oH(true);
                this.lAO.setTextViewGravity(19);
                this.lAO.setTextColor(R.color.cp_cont_b);
                this.lAO.fv(3000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.lAO.ft(32);
                this.lAO.setAnchor(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.lAO.A(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.lAO.xq(0);
                this.lAO.setYOffset(-dimensionPixelSize2);
                this.lAO.setHeight(R.dimen.tbds177);
                this.lAO.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.lAO.ft(32);
                this.lAO.setAnchor(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.lAO.A(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.lAO.xq(0);
                this.lAO.setYOffset(-dimensionPixelSize4);
                this.lAO.setHeight(R.dimen.tbds177);
                this.lAO.setWidth(R.dimen.tbds484);
            }
            this.lAO.d(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FindNewLinkBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (FindNewLinkBubbleController.this.nKM != null) {
                        FindNewLinkBubbleController.this.nKM.f(view2, str);
                    }
                }
            });
            this.lAO.Jj(this.mPageContext.getResources().getString(R.string.find_new_link) + "\n" + str);
            TiebaStatic.log("c13801");
        }
    }
}
