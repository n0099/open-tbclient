package com.baidu.tieba.write.write;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FindNewLinkBubbleController {
    private com.baidu.tieba.d.e lBg;
    private TbPageContext mPageContext;
    private a nMn;

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
        this.nMn = aVar;
    }

    public void VK() {
        if (this.lBg != null) {
            this.lBg.Si();
        }
    }

    public void a(@NonNull View view, @NonNull final String str, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !au.isEmpty(str)) {
            if (this.lBg == null) {
                this.lBg = new com.baidu.tieba.d.e(this.mPageContext, view);
                this.lBg.fq(R.drawable.pic_post_findlink);
                this.lBg.xP(2);
                this.lBg.oK(true);
                this.lBg.setTextViewGravity(19);
                this.lBg.setTextColor(R.color.CAM_X0105);
                this.lBg.fr(3000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.lBg.fp(32);
                this.lBg.setAnchor(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.lBg.B(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.lBg.xO(0);
                this.lBg.setYOffset(-dimensionPixelSize2);
                this.lBg.setHeight(R.dimen.tbds177);
                this.lBg.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.lBg.fp(32);
                this.lBg.setAnchor(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.lBg.B(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.lBg.xO(0);
                this.lBg.setYOffset(-dimensionPixelSize4);
                this.lBg.setHeight(R.dimen.tbds177);
                this.lBg.setWidth(R.dimen.tbds484);
            }
            this.lBg.d(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FindNewLinkBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (FindNewLinkBubbleController.this.nMn != null) {
                        FindNewLinkBubbleController.this.nMn.f(view2, str);
                    }
                }
            });
            this.lBg.IK(this.mPageContext.getResources().getString(R.string.find_new_link) + "\n" + str);
            TiebaStatic.log("c13801");
        }
    }
}
