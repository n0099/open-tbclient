package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.FocusListCard;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class FocusListCardView extends BaseCardView<FocusListCard> {
    View eno;
    LinearLayout fxX;
    View ldA;
    View ldB;
    View ldC;
    List<LinearLayout> ldD;
    List<View> ldE;
    TextView title;

    public FocusListCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbO() {
        this.eno = LayoutInflater.from(getContext()).inflate(R.layout.card_focus_list, (ViewGroup) null);
        this.title = (TextView) z(this.eno, R.id.left_title);
        this.ldA = (View) z(this.eno, R.id.topView);
        this.ldB = (View) z(this.eno, R.id.bottomView);
        this.ldC = (View) z(this.eno, R.id.rightView);
        this.fxX = (LinearLayout) z(this.eno, R.id.container);
        this.ldD = new ArrayList();
        this.ldD.add((LinearLayout) z(this.fxX, R.id.one));
        this.ldD.add((LinearLayout) z(this.fxX, R.id.two));
        this.ldD.add((LinearLayout) z(this.fxX, R.id.three));
        this.ldD.add((LinearLayout) z(this.fxX, R.id.four));
        this.ldD.add((LinearLayout) z(this.fxX, R.id.five));
        this.ldE = new ArrayList();
        this.ldE.add((View) z(this.fxX, R.id.one_line));
        this.ldE.add((View) z(this.fxX, R.id.two_line));
        this.ldE.add((View) z(this.fxX, R.id.three_line));
        this.ldE.add((View) z(this.fxX, R.id.four_line));
        this.ldE.add((View) z(this.fxX, R.id.five_line));
        return this.eno;
    }

    private void a(FocusListCard focusListCard) {
        if (focusListCard == null) {
            ap.setBackgroundColor(this.title, R.color.CAM_X0308);
            ap.setBackgroundColor(this.ldA, R.color.CAM_X0308);
            ap.setBackgroundColor(this.ldB, R.color.CAM_X0308);
            ap.setBackgroundColor(this.ldC, R.color.CAM_X0308);
        } else {
            int bgColor = focusListCard.getBgColor();
            int bgColorNight = focusListCard.getBgColorNight();
            e(this.title, bgColor, bgColorNight, R.color.CAM_X0308);
            e(this.ldA, bgColor, bgColorNight, R.color.CAM_X0308);
            e(this.ldB, bgColor, bgColorNight, R.color.CAM_X0308);
            e(this.ldC, bgColor, bgColorNight, R.color.CAM_X0308);
        }
        if (focusListCard == null) {
            ap.setViewTextColor(this.title, R.color.CAM_X0101);
        } else {
            a(this.title, focusListCard.getTitleColor(), focusListCard.getTitleColorNight(), R.color.CAM_X0101);
        }
        ap.setBackgroundColor(this.fxX, R.color.CAM_X0201);
        if (this.ldD != null && this.ldD.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ldD.size()) {
                    ap.setBackgroundResource(this.ldD.get(i2), R.drawable.addresslist_item_bg);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(TextView textView, FocusListCard.a aVar) {
        if (textView != null && aVar != null) {
            a(textView, aVar.lbH, aVar.lbI, R.color.CAM_X0308);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(FocusListCard focusListCard, int i) {
        com.baidu.tbadk.r.a.a(this.eUY, getRootView());
        if (focusListCard != null) {
            a(focusListCard);
        }
    }

    private void a(TextView textView, TextView textView2, TextView textView3, FocusListCard.a aVar) {
        ap.setViewTextColor(textView, R.color.CAM_X0105);
        a(textView2, aVar);
        ap.setViewTextColor(textView3, R.color.CAM_X0109);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final FocusListCard focusListCard) {
        if (focusListCard.getFocusItemList() != null && focusListCard.getFocusItemList().size() > 0) {
            this.title.setText(focusListCard.getCardTitle());
            int size = focusListCard.getFocusItemList().size();
            for (final int i = 0; i < size && i < 5; i++) {
                this.ldD.get(i).setVisibility(0);
                if (i < size - 1 && i < 4) {
                    this.ldE.get(i).setVisibility(0);
                    ap.setBackgroundColor(this.ldE.get(i), R.color.CAM_X0204);
                } else {
                    this.ldE.get(i).setVisibility(8);
                }
                TextView textView = (TextView) z(this.ldD.get(i), R.id.focus_title);
                TextView textView2 = (TextView) z(this.ldD.get(i), R.id.subtitle);
                TextView textView3 = (TextView) z(this.ldD.get(i), R.id.right);
                ImageView imageView = (ImageView) z(this.ldD.get(i), R.id.rightIcon);
                a(textView, textView2, textView3, focusListCard.getFocusItemList().get(i));
                textView.setText(focusListCard.getFocusItemList().get(i).title);
                textView2.setText(focusListCard.getFocusItemList().get(i).subtitle);
                textView3.setText(focusListCard.getFocusItemList().get(i).lbG);
                if (!TextUtils.isEmpty(focusListCard.getFocusItemList().get(i).scheme)) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    textView3.setLayoutParams(layoutParams);
                    imageView.setVisibility(0);
                    ap.setImageResource(imageView, R.drawable.icon_arrow_tab);
                    this.ldD.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.FocusListCardView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!TextUtils.isEmpty(focusListCard.getFocusItemList().get(i).scheme)) {
                                t.csu().mG(true);
                                com.baidu.tieba.lego.e a2 = com.baidu.tieba.lego.i.a((BaseLegoCardInfo) focusListCard);
                                a2.bA("obj_locate", i + 1);
                                a2.fF(TiebaInitialize.Params.OBJ_URL, focusListCard.getFocusItemList().get(i).scheme);
                                a2.N("obj_id", focusListCard.getFocusItemList().get(i).lbJ);
                                a2.a(focusListCard);
                                v.j(FocusListCardView.this.eUY, focusListCard.getFocusItemList().get(i).scheme);
                            }
                        }
                    });
                } else {
                    imageView.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds16), 0);
                    textView3.setLayoutParams(layoutParams2);
                    this.ldD.get(i).setOnClickListener(null);
                }
            }
            for (int size2 = focusListCard.getFocusItemList().size(); size2 < 5; size2++) {
                this.ldD.get(size2).setVisibility(8);
            }
        }
        a(focusListCard);
    }
}
