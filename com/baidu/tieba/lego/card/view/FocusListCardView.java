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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.FocusListCard;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class FocusListCardView extends BaseCardView<FocusListCard> {
    View elg;
    LinearLayout fvH;
    List<LinearLayout> kVA;
    List<View> kVB;
    View kVx;
    View kVy;
    View kVz;
    TextView title;

    public FocusListCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        this.elg = LayoutInflater.from(getContext()).inflate(R.layout.card_focus_list, (ViewGroup) null);
        this.title = (TextView) z(this.elg, R.id.left_title);
        this.kVx = (View) z(this.elg, R.id.topView);
        this.kVy = (View) z(this.elg, R.id.bottomView);
        this.kVz = (View) z(this.elg, R.id.rightView);
        this.fvH = (LinearLayout) z(this.elg, R.id.container);
        this.kVA = new ArrayList();
        this.kVA.add((LinearLayout) z(this.fvH, R.id.one));
        this.kVA.add((LinearLayout) z(this.fvH, R.id.two));
        this.kVA.add((LinearLayout) z(this.fvH, R.id.three));
        this.kVA.add((LinearLayout) z(this.fvH, R.id.four));
        this.kVA.add((LinearLayout) z(this.fvH, R.id.five));
        this.kVB = new ArrayList();
        this.kVB.add((View) z(this.fvH, R.id.one_line));
        this.kVB.add((View) z(this.fvH, R.id.two_line));
        this.kVB.add((View) z(this.fvH, R.id.three_line));
        this.kVB.add((View) z(this.fvH, R.id.four_line));
        this.kVB.add((View) z(this.fvH, R.id.five_line));
        return this.elg;
    }

    private void a(FocusListCard focusListCard) {
        if (focusListCard == null) {
            ao.setBackgroundColor(this.title, R.color.CAM_X0308);
            ao.setBackgroundColor(this.kVx, R.color.CAM_X0308);
            ao.setBackgroundColor(this.kVy, R.color.CAM_X0308);
            ao.setBackgroundColor(this.kVz, R.color.CAM_X0308);
        } else {
            int bgColor = focusListCard.getBgColor();
            int bgColorNight = focusListCard.getBgColorNight();
            e(this.title, bgColor, bgColorNight, R.color.CAM_X0308);
            e(this.kVx, bgColor, bgColorNight, R.color.CAM_X0308);
            e(this.kVy, bgColor, bgColorNight, R.color.CAM_X0308);
            e(this.kVz, bgColor, bgColorNight, R.color.CAM_X0308);
        }
        if (focusListCard == null) {
            ao.setViewTextColor(this.title, R.color.CAM_X0101);
        } else {
            a(this.title, focusListCard.getTitleColor(), focusListCard.getTitleColorNight(), R.color.CAM_X0101);
        }
        ao.setBackgroundColor(this.fvH, R.color.CAM_X0201);
        if (this.kVA != null && this.kVA.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kVA.size()) {
                    ao.setBackgroundResource(this.kVA.get(i2), R.drawable.addresslist_item_bg);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(TextView textView, FocusListCard.a aVar) {
        if (textView != null && aVar != null) {
            a(textView, aVar.kTE, aVar.kTF, R.color.CAM_X0308);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(FocusListCard focusListCard, int i) {
        com.baidu.tbadk.r.a.a(this.eSJ, getRootView());
        if (focusListCard != null) {
            a(focusListCard);
        }
    }

    private void a(TextView textView, TextView textView2, TextView textView3, FocusListCard.a aVar) {
        ao.setViewTextColor(textView, R.color.CAM_X0105);
        a(textView2, aVar);
        ao.setViewTextColor(textView3, R.color.CAM_X0109);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final FocusListCard focusListCard) {
        if (focusListCard.getFocusItemList() != null && focusListCard.getFocusItemList().size() > 0) {
            this.title.setText(focusListCard.getCardTitle());
            int size = focusListCard.getFocusItemList().size();
            for (final int i = 0; i < size && i < 5; i++) {
                this.kVA.get(i).setVisibility(0);
                if (i < size - 1 && i < 4) {
                    this.kVB.get(i).setVisibility(0);
                    ao.setBackgroundColor(this.kVB.get(i), R.color.CAM_X0204);
                } else {
                    this.kVB.get(i).setVisibility(8);
                }
                TextView textView = (TextView) z(this.kVA.get(i), R.id.focus_title);
                TextView textView2 = (TextView) z(this.kVA.get(i), R.id.subtitle);
                TextView textView3 = (TextView) z(this.kVA.get(i), R.id.right);
                ImageView imageView = (ImageView) z(this.kVA.get(i), R.id.rightIcon);
                a(textView, textView2, textView3, focusListCard.getFocusItemList().get(i));
                textView.setText(focusListCard.getFocusItemList().get(i).title);
                textView2.setText(focusListCard.getFocusItemList().get(i).subtitle);
                textView3.setText(focusListCard.getFocusItemList().get(i).kTD);
                if (!TextUtils.isEmpty(focusListCard.getFocusItemList().get(i).scheme)) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    textView3.setLayoutParams(layoutParams);
                    imageView.setVisibility(0);
                    ao.setImageResource(imageView, R.drawable.icon_arrow_tab);
                    this.kVA.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.FocusListCardView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!TextUtils.isEmpty(focusListCard.getFocusItemList().get(i).scheme)) {
                                s.crj().mC(true);
                                com.baidu.tieba.lego.e a2 = com.baidu.tieba.lego.i.a((BaseLegoCardInfo) focusListCard);
                                a2.bA("obj_locate", i + 1);
                                a2.fF(TiebaInitialize.Params.OBJ_URL, focusListCard.getFocusItemList().get(i).scheme);
                                a2.O("obj_id", focusListCard.getFocusItemList().get(i).kTG);
                                a2.a(focusListCard);
                                v.h(FocusListCardView.this.eSJ, focusListCard.getFocusItemList().get(i).scheme);
                            }
                        }
                    });
                } else {
                    imageView.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds16), 0);
                    textView3.setLayoutParams(layoutParams2);
                    this.kVA.get(i).setOnClickListener(null);
                }
            }
            for (int size2 = focusListCard.getFocusItemList().size(); size2 < 5; size2++) {
                this.kVA.get(size2).setVisibility(8);
            }
        }
        a(focusListCard);
    }
}
