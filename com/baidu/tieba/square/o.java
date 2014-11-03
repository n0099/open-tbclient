package com.baidu.tieba.square;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.square.CarouselRecommendView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    private final /* synthetic */ int aQs;
    final /* synthetic */ CarouselRecommendView.n bMF;
    private final /* synthetic */ y bMG;
    private final /* synthetic */ TbImageView bMH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(CarouselRecommendView.n nVar, y yVar, TbImageView tbImageView, int i) {
        this.bMF = nVar;
        this.bMG = yVar;
        this.bMH = tbImageView;
        this.aQs = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CarouselRecommendView carouselRecommendView;
        Context context;
        Context context2;
        CarouselRecommendView carouselRecommendView2;
        String str;
        Context context3;
        Context context4;
        Context context5;
        String link = this.bMG.getLink();
        carouselRecommendView = CarouselRecommendView.this;
        if (carouselRecommendView.mIsForGameCenter) {
            int dl = com.baidu.tbadk.game.a.dl(link);
            if (dl == 2) {
                MessageManager messageManager = MessageManager.getInstance();
                context4 = this.bMF.mContext;
                context5 = this.bMF.mContext;
                messageManager.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(context4, context5.getResources().getString(com.baidu.tieba.y.game_center_title_detail), link, true)));
            } else if (dl == 1) {
                String dm = com.baidu.tbadk.game.a.dm(link);
                if (!TextUtils.isEmpty(dm)) {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    context2 = this.bMF.mContext;
                    carouselRecommendView2 = CarouselRecommendView.this;
                    str = carouselRecommendView2.mGameRefId;
                    messageManager2.sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(context2, dm, str)));
                } else {
                    return;
                }
            }
            Object tag = this.bMH.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                context3 = this.bMF.mContext;
                TiebaStatic.eventStat(context3, "screen_btn_" + intValue, "click", 1, new Object[0]);
                return;
            }
            return;
        }
        String aD = aa.aD(CarouselRecommendView.MODULE_NAME, String.valueOf(this.aQs));
        bg mR = bg.mR();
        context = this.bMF.mContext;
        String[] strArr = new String[3];
        strArr[0] = link;
        strArr[2] = aD;
        mR.b(context, strArr);
    }
}
