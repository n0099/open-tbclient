package com.baidu.tieba.write.write;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FindNewLinkBubbleController {
    private com.baidu.tieba.c.e luR;
    private TbPageContext mPageContext;
    private a nES;

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
        this.nES = aVar;
    }

    public void TT() {
        if (this.luR != null) {
            this.luR.Qh();
        }
    }

    public void a(@NonNull View view, @NonNull final String str, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !at.isEmpty(str)) {
            if (this.luR == null) {
                this.luR = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.luR.fh(R.drawable.pic_post_findlink);
                this.luR.xe(2);
                this.luR.oy(true);
                this.luR.setTextViewGravity(19);
                this.luR.setTextColor(R.color.cp_cont_b);
                this.luR.fi(3000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.luR.fg(32);
                this.luR.setAnchor(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.luR.A(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.luR.xd(0);
                this.luR.setYOffset(-dimensionPixelSize2);
                this.luR.setHeight(R.dimen.tbds177);
                this.luR.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.luR.fg(32);
                this.luR.setAnchor(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.luR.A(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.luR.xd(0);
                this.luR.setYOffset(-dimensionPixelSize4);
                this.luR.setHeight(R.dimen.tbds177);
                this.luR.setWidth(R.dimen.tbds484);
            }
            this.luR.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FindNewLinkBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (FindNewLinkBubbleController.this.nES != null) {
                        FindNewLinkBubbleController.this.nES.f(view2, str);
                    }
                }
            });
            this.luR.IS(this.mPageContext.getResources().getString(R.string.find_new_link) + "\n" + str);
            TiebaStatic.log("c13801");
        }
    }
}
