package com.baidu.tieba.write.write;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FindNewLinkBubbleController {
    private com.baidu.tieba.d.e lOT;
    private TbPageContext mPageContext;
    private a oaE;

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
        this.oaE = aVar;
    }

    public void Yk() {
        if (this.lOT != null) {
            this.lOT.UG();
        }
    }

    public void a(@NonNull View view, @NonNull final String str, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !au.isEmpty(str)) {
            if (this.lOT == null) {
                this.lOT = new com.baidu.tieba.d.e(this.mPageContext, view);
                this.lOT.fO(R.drawable.pic_post_findlink);
                this.lOT.yu(2);
                this.lOT.pg(true);
                this.lOT.setTextViewGravity(19);
                this.lOT.setTextColor(R.color.CAM_X0105);
                this.lOT.fP(3000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.lOT.fN(32);
                this.lOT.setAnchor(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.lOT.F(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.lOT.yt(0);
                this.lOT.setYOffset(-dimensionPixelSize2);
                this.lOT.setHeight(R.dimen.tbds177);
                this.lOT.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.lOT.fN(32);
                this.lOT.setAnchor(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.lOT.F(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.lOT.yt(0);
                this.lOT.setYOffset(-dimensionPixelSize4);
                this.lOT.setHeight(R.dimen.tbds177);
                this.lOT.setWidth(R.dimen.tbds484);
            }
            this.lOT.d(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FindNewLinkBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (FindNewLinkBubbleController.this.oaE != null) {
                        FindNewLinkBubbleController.this.oaE.f(view2, str);
                    }
                }
            });
            this.lOT.JA(this.mPageContext.getResources().getString(R.string.find_new_link) + "\n" + str);
            TiebaStatic.log("c13801");
        }
    }
}
