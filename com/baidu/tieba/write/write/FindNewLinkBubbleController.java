package com.baidu.tieba.write.write;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FindNewLinkBubbleController {
    private com.baidu.tieba.c.e kuN;
    private a mAm;
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
        this.mAm = aVar;
    }

    public void KC() {
        if (this.kuN != null) {
            this.kuN.HN();
        }
    }

    public void a(@NonNull View view, @NonNull final String str, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !as.isEmpty(str)) {
            if (this.kuN == null) {
                this.kuN = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.kuN.cS(R.drawable.pic_post_findlink);
                this.kuN.ts(2);
                this.kuN.mQ(true);
                this.kuN.setTextViewGravity(19);
                this.kuN.setTextColor(R.color.cp_cont_b);
                this.kuN.cT(3000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.kuN.cR(32);
                this.kuN.tn(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.kuN.z(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.kuN.tr(0);
                this.kuN.setYOffset(-dimensionPixelSize2);
                this.kuN.setHeight(R.dimen.tbds177);
                this.kuN.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.kuN.cR(32);
                this.kuN.tn(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.kuN.z(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.kuN.tr(0);
                this.kuN.setYOffset(-dimensionPixelSize4);
                this.kuN.setHeight(R.dimen.tbds177);
                this.kuN.setWidth(R.dimen.tbds484);
            }
            this.kuN.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FindNewLinkBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (FindNewLinkBubbleController.this.mAm != null) {
                        FindNewLinkBubbleController.this.mAm.f(view2, str);
                    }
                }
            });
            this.kuN.EJ(this.mPageContext.getResources().getString(R.string.find_new_link) + "\n" + str);
            TiebaStatic.log("c13801");
        }
    }
}
