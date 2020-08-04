package com.baidu.tieba.write.write;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FindNewLinkBubbleController {
    private com.baidu.tieba.c.e kuP;
    private a mAo;
    private TbPageContext mPageContext;

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
        this.mAo = aVar;
    }

    public void KC() {
        if (this.kuP != null) {
            this.kuP.HN();
        }
    }

    public void a(@NonNull View view, @NonNull final String str, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !as.isEmpty(str)) {
            if (this.kuP == null) {
                this.kuP = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.kuP.cS(R.drawable.pic_post_findlink);
                this.kuP.ts(2);
                this.kuP.mQ(true);
                this.kuP.setTextViewGravity(19);
                this.kuP.setTextColor(R.color.cp_cont_b);
                this.kuP.cT(3000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.kuP.cR(32);
                this.kuP.tn(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.kuP.z(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.kuP.tr(0);
                this.kuP.setYOffset(-dimensionPixelSize2);
                this.kuP.setHeight(R.dimen.tbds177);
                this.kuP.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.kuP.cR(32);
                this.kuP.tn(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.kuP.z(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.kuP.tr(0);
                this.kuP.setYOffset(-dimensionPixelSize4);
                this.kuP.setHeight(R.dimen.tbds177);
                this.kuP.setWidth(R.dimen.tbds484);
            }
            this.kuP.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FindNewLinkBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (FindNewLinkBubbleController.this.mAo != null) {
                        FindNewLinkBubbleController.this.mAo.f(view2, str);
                    }
                }
            });
            this.kuP.EJ(this.mPageContext.getResources().getString(R.string.find_new_link) + "\n" + str);
            TiebaStatic.log("c13801");
        }
    }
}
