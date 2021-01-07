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
/* loaded from: classes9.dex */
public class FocusListCardView extends BaseCardView<FocusListCard> {
    View epV;
    LinearLayout fAp;
    View lac;
    View lad;
    View lae;
    List<LinearLayout> laf;
    List<View> lag;
    TextView title;

    public FocusListCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddI() {
        this.epV = LayoutInflater.from(getContext()).inflate(R.layout.card_focus_list, (ViewGroup) null);
        this.title = (TextView) z(this.epV, R.id.left_title);
        this.lac = (View) z(this.epV, R.id.topView);
        this.lad = (View) z(this.epV, R.id.bottomView);
        this.lae = (View) z(this.epV, R.id.rightView);
        this.fAp = (LinearLayout) z(this.epV, R.id.container);
        this.laf = new ArrayList();
        this.laf.add((LinearLayout) z(this.fAp, R.id.one));
        this.laf.add((LinearLayout) z(this.fAp, R.id.two));
        this.laf.add((LinearLayout) z(this.fAp, R.id.three));
        this.laf.add((LinearLayout) z(this.fAp, R.id.four));
        this.laf.add((LinearLayout) z(this.fAp, R.id.five));
        this.lag = new ArrayList();
        this.lag.add((View) z(this.fAp, R.id.one_line));
        this.lag.add((View) z(this.fAp, R.id.two_line));
        this.lag.add((View) z(this.fAp, R.id.three_line));
        this.lag.add((View) z(this.fAp, R.id.four_line));
        this.lag.add((View) z(this.fAp, R.id.five_line));
        return this.epV;
    }

    private void a(FocusListCard focusListCard) {
        if (focusListCard == null) {
            ao.setBackgroundColor(this.title, R.color.CAM_X0308);
            ao.setBackgroundColor(this.lac, R.color.CAM_X0308);
            ao.setBackgroundColor(this.lad, R.color.CAM_X0308);
            ao.setBackgroundColor(this.lae, R.color.CAM_X0308);
        } else {
            int bgColor = focusListCard.getBgColor();
            int bgColorNight = focusListCard.getBgColorNight();
            e(this.title, bgColor, bgColorNight, R.color.CAM_X0308);
            e(this.lac, bgColor, bgColorNight, R.color.CAM_X0308);
            e(this.lad, bgColor, bgColorNight, R.color.CAM_X0308);
            e(this.lae, bgColor, bgColorNight, R.color.CAM_X0308);
        }
        if (focusListCard == null) {
            ao.setViewTextColor(this.title, R.color.CAM_X0101);
        } else {
            a(this.title, focusListCard.getTitleColor(), focusListCard.getTitleColorNight(), R.color.CAM_X0101);
        }
        ao.setBackgroundColor(this.fAp, R.color.CAM_X0201);
        if (this.laf != null && this.laf.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.laf.size()) {
                    ao.setBackgroundResource(this.laf.get(i2), R.drawable.addresslist_item_bg);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(TextView textView, FocusListCard.a aVar) {
        if (textView != null && aVar != null) {
            a(textView, aVar.kYj, aVar.kYk, R.color.CAM_X0308);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(FocusListCard focusListCard, int i) {
        com.baidu.tbadk.r.a.a(this.eXu, getRootView());
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
                this.laf.get(i).setVisibility(0);
                if (i < size - 1 && i < 4) {
                    this.lag.get(i).setVisibility(0);
                    ao.setBackgroundColor(this.lag.get(i), R.color.CAM_X0204);
                } else {
                    this.lag.get(i).setVisibility(8);
                }
                TextView textView = (TextView) z(this.laf.get(i), R.id.focus_title);
                TextView textView2 = (TextView) z(this.laf.get(i), R.id.subtitle);
                TextView textView3 = (TextView) z(this.laf.get(i), R.id.right);
                ImageView imageView = (ImageView) z(this.laf.get(i), R.id.rightIcon);
                a(textView, textView2, textView3, focusListCard.getFocusItemList().get(i));
                textView.setText(focusListCard.getFocusItemList().get(i).title);
                textView2.setText(focusListCard.getFocusItemList().get(i).subtitle);
                textView3.setText(focusListCard.getFocusItemList().get(i).kYi);
                if (!TextUtils.isEmpty(focusListCard.getFocusItemList().get(i).scheme)) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    textView3.setLayoutParams(layoutParams);
                    imageView.setVisibility(0);
                    ao.setImageResource(imageView, R.drawable.icon_arrow_tab);
                    this.laf.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.FocusListCardView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!TextUtils.isEmpty(focusListCard.getFocusItemList().get(i).scheme)) {
                                s.cvb().mG(true);
                                com.baidu.tieba.lego.e a2 = com.baidu.tieba.lego.i.a((BaseLegoCardInfo) focusListCard);
                                a2.bz("obj_locate", i + 1);
                                a2.fG(TiebaInitialize.Params.OBJ_URL, focusListCard.getFocusItemList().get(i).scheme);
                                a2.O("obj_id", focusListCard.getFocusItemList().get(i).kYl);
                                a2.a(focusListCard);
                                v.h(FocusListCardView.this.eXu, focusListCard.getFocusItemList().get(i).scheme);
                            }
                        }
                    });
                } else {
                    imageView.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds16), 0);
                    textView3.setLayoutParams(layoutParams2);
                    this.laf.get(i).setOnClickListener(null);
                }
            }
            for (int size2 = focusListCard.getFocusItemList().size(); size2 < 5; size2++) {
                this.laf.get(size2).setVisibility(8);
            }
        }
        a(focusListCard);
    }
}
