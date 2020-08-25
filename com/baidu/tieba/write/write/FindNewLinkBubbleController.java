package com.baidu.tieba.write.write;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FindNewLinkBubbleController {
    private com.baidu.tieba.c.e kKu;
    private TbPageContext mPageContext;
    private a mSG;

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
        this.mSG = aVar;
    }

    public void Qu() {
        if (this.kKu != null) {
            this.kKu.NG();
        }
    }

    public void a(@NonNull View view, @NonNull final String str, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !at.isEmpty(str)) {
            if (this.kKu == null) {
                this.kKu = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.kKu.eL(R.drawable.pic_post_findlink);
                this.kKu.vG(2);
                this.kKu.nt(true);
                this.kKu.setTextViewGravity(19);
                this.kKu.setTextColor(R.color.cp_cont_b);
                this.kKu.eM(3000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.kKu.eK(32);
                this.kKu.setAnchor(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.kKu.z(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.kKu.vF(0);
                this.kKu.setYOffset(-dimensionPixelSize2);
                this.kKu.setHeight(R.dimen.tbds177);
                this.kKu.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.kKu.eK(32);
                this.kKu.setAnchor(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.kKu.z(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.kKu.vF(0);
                this.kKu.setYOffset(-dimensionPixelSize4);
                this.kKu.setHeight(R.dimen.tbds177);
                this.kKu.setWidth(R.dimen.tbds484);
            }
            this.kKu.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FindNewLinkBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (FindNewLinkBubbleController.this.mSG != null) {
                        FindNewLinkBubbleController.this.mSG.f(view2, str);
                    }
                }
            });
            this.kKu.Hi(this.mPageContext.getResources().getString(R.string.find_new_link) + "\n" + str);
            TiebaStatic.log("c13801");
        }
    }
}
