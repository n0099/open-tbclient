package com.baidu.tieba.write.write;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FindNewLinkBubbleController {
    private com.baidu.tieba.c.e kKB;
    private TbPageContext mPageContext;
    private a mSZ;

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
        this.mSZ = aVar;
    }

    public void Qu() {
        if (this.kKB != null) {
            this.kKB.NG();
        }
    }

    public void a(@NonNull View view, @NonNull final String str, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !at.isEmpty(str)) {
            if (this.kKB == null) {
                this.kKB = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.kKB.eL(R.drawable.pic_post_findlink);
                this.kKB.vG(2);
                this.kKB.nv(true);
                this.kKB.setTextViewGravity(19);
                this.kKB.setTextColor(R.color.cp_cont_b);
                this.kKB.eM(3000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.kKB.eK(32);
                this.kKB.setAnchor(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.kKB.z(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.kKB.vF(0);
                this.kKB.setYOffset(-dimensionPixelSize2);
                this.kKB.setHeight(R.dimen.tbds177);
                this.kKB.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.kKB.eK(32);
                this.kKB.setAnchor(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.kKB.z(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.kKB.vF(0);
                this.kKB.setYOffset(-dimensionPixelSize4);
                this.kKB.setHeight(R.dimen.tbds177);
                this.kKB.setWidth(R.dimen.tbds484);
            }
            this.kKB.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FindNewLinkBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (FindNewLinkBubbleController.this.mSZ != null) {
                        FindNewLinkBubbleController.this.mSZ.f(view2, str);
                    }
                }
            });
            this.kKB.Hj(this.mPageContext.getResources().getString(R.string.find_new_link) + "\n" + str);
            TiebaStatic.log("c13801");
        }
    }
}
