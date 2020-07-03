package com.baidu.tieba.write.write;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FindNewLinkBubbleController {
    private com.baidu.tieba.c.e klQ;
    private TbPageContext mPageContext;
    private a msk;

    /* loaded from: classes2.dex */
    public enum ANCHOR_VIEW_FROM {
        FROM_EDITOR_TOOL,
        FROM_EDIT_TEXT
    }

    /* loaded from: classes2.dex */
    public interface a {
        void f(View view, String str);
    }

    public FindNewLinkBubbleController(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.msk = aVar;
    }

    public void Kv() {
        if (this.klQ != null) {
            this.klQ.HH();
        }
    }

    public void a(@NonNull View view, @NonNull final String str, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !ar.isEmpty(str)) {
            if (this.klQ == null) {
                this.klQ = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.klQ.cS(R.drawable.pic_post_findlink);
                this.klQ.ta(2);
                this.klQ.ml(true);
                this.klQ.setTextViewGravity(19);
                this.klQ.setTextColor(R.color.cp_cont_b);
                this.klQ.cT(3000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.klQ.cR(32);
                this.klQ.sV(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.klQ.y(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.klQ.sZ(0);
                this.klQ.setYOffset(-dimensionPixelSize2);
                this.klQ.setHeight(R.dimen.tbds177);
                this.klQ.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.klQ.cR(32);
                this.klQ.sV(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.klQ.y(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.klQ.sZ(0);
                this.klQ.setYOffset(-dimensionPixelSize4);
                this.klQ.setHeight(R.dimen.tbds177);
                this.klQ.setWidth(R.dimen.tbds484);
            }
            this.klQ.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FindNewLinkBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (FindNewLinkBubbleController.this.msk != null) {
                        FindNewLinkBubbleController.this.msk.f(view2, str);
                    }
                }
            });
            this.klQ.DY(this.mPageContext.getResources().getString(R.string.find_new_link) + "\n" + str);
            TiebaStatic.log("c13801");
        }
    }
}
