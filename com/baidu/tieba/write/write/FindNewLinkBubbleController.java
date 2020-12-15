package com.baidu.tieba.write.write;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FindNewLinkBubbleController {
    private com.baidu.tieba.d.e lOV;
    private TbPageContext mPageContext;
    private a oaG;

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
        this.oaG = aVar;
    }

    public void Yk() {
        if (this.lOV != null) {
            this.lOV.UG();
        }
    }

    public void a(@NonNull View view, @NonNull final String str, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !au.isEmpty(str)) {
            if (this.lOV == null) {
                this.lOV = new com.baidu.tieba.d.e(this.mPageContext, view);
                this.lOV.fO(R.drawable.pic_post_findlink);
                this.lOV.yu(2);
                this.lOV.pg(true);
                this.lOV.setTextViewGravity(19);
                this.lOV.setTextColor(R.color.CAM_X0105);
                this.lOV.fP(3000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.lOV.fN(32);
                this.lOV.setAnchor(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.lOV.F(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.lOV.yt(0);
                this.lOV.setYOffset(-dimensionPixelSize2);
                this.lOV.setHeight(R.dimen.tbds177);
                this.lOV.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.lOV.fN(32);
                this.lOV.setAnchor(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.lOV.F(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.lOV.yt(0);
                this.lOV.setYOffset(-dimensionPixelSize4);
                this.lOV.setHeight(R.dimen.tbds177);
                this.lOV.setWidth(R.dimen.tbds484);
            }
            this.lOV.d(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FindNewLinkBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (FindNewLinkBubbleController.this.oaG != null) {
                        FindNewLinkBubbleController.this.oaG.f(view2, str);
                    }
                }
            });
            this.lOV.JA(this.mPageContext.getResources().getString(R.string.find_new_link) + "\n" + str);
            TiebaStatic.log("c13801");
        }
    }
}
