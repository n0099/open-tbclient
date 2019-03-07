package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.FocusListCard;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class FocusListCardView extends BaseCardView<FocusListCard> {
    LinearLayout ceE;
    View dcP;
    View gIP;
    View gIQ;
    View gIR;
    List<LinearLayout> gIS;
    List<View> gIT;
    TextView title;

    public FocusListCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.dcP = LayoutInflater.from(getContext()).inflate(d.h.card_focus_list, (ViewGroup) null);
        this.title = (TextView) A(this.dcP, d.g.left_title);
        this.gIP = (View) A(this.dcP, d.g.topView);
        this.gIQ = (View) A(this.dcP, d.g.bottomView);
        this.gIR = (View) A(this.dcP, d.g.rightView);
        this.ceE = (LinearLayout) A(this.dcP, d.g.container);
        this.gIS = new ArrayList();
        this.gIS.add((LinearLayout) A(this.ceE, d.g.one));
        this.gIS.add((LinearLayout) A(this.ceE, d.g.two));
        this.gIS.add((LinearLayout) A(this.ceE, d.g.three));
        this.gIS.add((LinearLayout) A(this.ceE, d.g.four));
        this.gIS.add((LinearLayout) A(this.ceE, d.g.five));
        this.gIT = new ArrayList();
        this.gIT.add((View) A(this.ceE, d.g.one_line));
        this.gIT.add((View) A(this.ceE, d.g.two_line));
        this.gIT.add((View) A(this.ceE, d.g.three_line));
        this.gIT.add((View) A(this.ceE, d.g.four_line));
        this.gIT.add((View) A(this.ceE, d.g.five_line));
        return this.dcP;
    }

    private void a(FocusListCard focusListCard) {
        if (focusListCard == null) {
            al.l(this.title, d.C0236d.cp_other_b);
            al.l(this.gIP, d.C0236d.cp_other_b);
            al.l(this.gIQ, d.C0236d.cp_other_b);
            al.l(this.gIR, d.C0236d.cp_other_b);
        } else {
            int bgColor = focusListCard.getBgColor();
            int bgColorNight = focusListCard.getBgColorNight();
            e(this.title, bgColor, bgColorNight, d.C0236d.cp_other_b);
            e(this.gIP, bgColor, bgColorNight, d.C0236d.cp_other_b);
            e(this.gIQ, bgColor, bgColorNight, d.C0236d.cp_other_b);
            e(this.gIR, bgColor, bgColorNight, d.C0236d.cp_other_b);
        }
        if (focusListCard == null) {
            al.j(this.title, d.C0236d.cp_btn_a);
        } else {
            a(this.title, focusListCard.getTitleColor(), focusListCard.getTitleColorNight(), d.C0236d.cp_btn_a);
        }
        al.l(this.ceE, d.C0236d.cp_bg_line_d);
        if (this.gIS != null && this.gIS.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gIS.size()) {
                    al.k(this.gIS.get(i2), d.f.addresslist_item_bg);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(TextView textView, FocusListCard.a aVar) {
        if (textView != null && aVar != null) {
            a(textView, aVar.gGU, aVar.gGV, d.C0236d.cp_other_b);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(FocusListCard focusListCard, int i) {
        com.baidu.tbadk.r.a.a(this.mContext, getRootView());
        if (focusListCard != null) {
            a(focusListCard);
        }
    }

    private void a(TextView textView, TextView textView2, TextView textView3, FocusListCard.a aVar) {
        al.j(textView, d.C0236d.cp_cont_b);
        a(textView2, aVar);
        al.j(textView3, d.C0236d.cp_cont_d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final FocusListCard focusListCard) {
        if (focusListCard.getFocusItemList() != null && focusListCard.getFocusItemList().size() > 0) {
            this.title.setText(focusListCard.getCardTitle());
            int size = focusListCard.getFocusItemList().size();
            for (final int i = 0; i < size && i < 5; i++) {
                this.gIS.get(i).setVisibility(0);
                if (i < size - 1 && i < 4) {
                    this.gIT.get(i).setVisibility(0);
                    al.l(this.gIT.get(i), d.C0236d.cp_bg_line_a);
                } else {
                    this.gIT.get(i).setVisibility(8);
                }
                TextView textView = (TextView) A(this.gIS.get(i), d.g.focus_title);
                TextView textView2 = (TextView) A(this.gIS.get(i), d.g.subtitle);
                TextView textView3 = (TextView) A(this.gIS.get(i), d.g.right);
                ImageView imageView = (ImageView) A(this.gIS.get(i), d.g.rightIcon);
                a(textView, textView2, textView3, focusListCard.getFocusItemList().get(i));
                textView.setText(focusListCard.getFocusItemList().get(i).title);
                textView2.setText(focusListCard.getFocusItemList().get(i).subtitle);
                textView3.setText(focusListCard.getFocusItemList().get(i).gGT);
                if (!TextUtils.isEmpty(focusListCard.getFocusItemList().get(i).scheme)) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    textView3.setLayoutParams(layoutParams);
                    imageView.setVisibility(0);
                    al.c(imageView, d.f.icon_arrow_tab);
                    this.gIS.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.FocusListCardView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!TextUtils.isEmpty(focusListCard.getFocusItemList().get(i).scheme)) {
                                t.aQF().go(true);
                                com.baidu.tieba.lego.e a = com.baidu.tieba.lego.i.a((BaseLegoCardInfo) focusListCard);
                                a.bb("obj_locate", i + 1);
                                a.di("obj_url", focusListCard.getFocusItemList().get(i).scheme);
                                a.z(VideoPlayActivityConfig.OBJ_ID, focusListCard.getFocusItemList().get(i).gGW);
                                a.a(focusListCard);
                                q.f(FocusListCardView.this.mContext, focusListCard.getFocusItemList().get(i).scheme);
                            }
                        }
                    });
                } else {
                    imageView.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.l.h(getContext(), d.e.ds16), 0);
                    textView3.setLayoutParams(layoutParams2);
                    this.gIS.get(i).setOnClickListener(null);
                }
            }
            for (int size2 = focusListCard.getFocusItemList().size(); size2 < 5; size2++) {
                this.gIS.get(size2).setVisibility(8);
            }
        }
        a(focusListCard);
    }
}
