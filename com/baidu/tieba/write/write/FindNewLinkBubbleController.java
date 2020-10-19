package com.baidu.tieba.write.write;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FindNewLinkBubbleController {
    private com.baidu.tieba.c.e lio;
    private TbPageContext mPageContext;
    private a nst;

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
        this.nst = aVar;
    }

    public void SU() {
        if (this.lio != null) {
            this.lio.Po();
        }
    }

    public void a(@NonNull View view, @NonNull final String str, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !at.isEmpty(str)) {
            if (this.lio == null) {
                this.lio = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.lio.ff(R.drawable.pic_post_findlink);
                this.lio.wL(2);
                this.lio.og(true);
                this.lio.setTextViewGravity(19);
                this.lio.setTextColor(R.color.cp_cont_b);
                this.lio.fg(3000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.lio.fe(32);
                this.lio.setAnchor(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.lio.z(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.lio.wK(0);
                this.lio.setYOffset(-dimensionPixelSize2);
                this.lio.setHeight(R.dimen.tbds177);
                this.lio.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.lio.fe(32);
                this.lio.setAnchor(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.lio.z(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.lio.wK(0);
                this.lio.setYOffset(-dimensionPixelSize4);
                this.lio.setHeight(R.dimen.tbds177);
                this.lio.setWidth(R.dimen.tbds484);
            }
            this.lio.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FindNewLinkBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (FindNewLinkBubbleController.this.nst != null) {
                        FindNewLinkBubbleController.this.nst.f(view2, str);
                    }
                }
            });
            this.lio.It(this.mPageContext.getResources().getString(R.string.find_new_link) + "\n" + str);
            TiebaStatic.log("c13801");
        }
    }
}
