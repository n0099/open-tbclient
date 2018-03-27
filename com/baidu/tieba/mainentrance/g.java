package com.baidu.tieba.mainentrance;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g {
    private View aHT;
    private TbPageContext<?> aRI;
    private TableLayout fhE;
    private TextView fhF;
    private View fhG;

    public g(TbPageContext<?> tbPageContext) {
        this.aRI = tbPageContext;
    }

    public View st() {
        this.aHT = LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.search_topic, (ViewGroup) null);
        this.fhG = this.aHT.findViewById(d.g.titleTopDivider);
        this.fhG.setVisibility(0);
        this.fhE = (TableLayout) this.aHT.findViewById(d.g.search_topic_layout);
        this.fhF = (TextView) this.aHT.findViewById(d.g.square_search_fourm_header_text);
        this.fhF.setText(this.aRI.getResources().getString(d.j.hot_topic_title));
        return this.aHT;
    }

    public void setTitleText(String str) {
        if (this.fhF != null) {
            if (!StringUtils.isNull(str)) {
                this.fhF.setText(str);
            } else {
                this.fhF.setText(this.aRI.getResources().getString(d.j.hot_topic_title));
            }
        }
    }

    public void clear() {
        this.fhE.removeAllViews();
        this.aHT.setVisibility(8);
        this.fhE.setVisibility(8);
        this.fhF.setVisibility(8);
    }

    public View a(c cVar, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.search_topic_item, (ViewGroup) null);
        TextView textView = (TextView) linearLayout.findViewById(d.g.text_search_topic_item_text);
        ImageView imageView = (ImageView) linearLayout.findViewById(d.g.image_search_topic_item);
        if (cVar != null) {
            int tag = cVar.getTag();
            imageView.setVisibility(0);
            imageView.setTag(Integer.valueOf(tag));
            d(imageView, tag, TbadkCoreApplication.getInst().getSkinType());
            textView.setText(Z(cVar.getName(), 8));
            linearLayout.setTag(cVar);
        } else {
            textView.setText(d.j.hot_forum_title_more);
            textView.setTextColor(aj.getColor(d.C0141d.cp_link_tip_a));
            imageView.setVisibility(8);
        }
        a(linearLayout, i, this.fhE, 2);
        return linearLayout;
    }

    private void d(ImageView imageView, int i, int i2) {
        if (imageView != null) {
            imageView.setImageDrawable(null);
            switch (i) {
                case 1:
                    aj.b(imageView, d.f.icon_topic_new, i2);
                    return;
                case 2:
                    aj.b(imageView, d.f.icon_topic_hot, i2);
                    return;
                case 3:
                    aj.b(imageView, d.f.icon_topic_recommend, i2);
                    return;
                default:
                    imageView.setVisibility(8);
                    return;
            }
        }
    }

    private String Z(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > i) {
            return str.substring(0, i - 1) + this.aRI.getString(d.j.ellipsis);
        }
        return str;
    }

    private void a(View view, int i, TableLayout tableLayout, int i2) {
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.aRI.getResources().getDimensionPixelSize(d.e.ds360), -2);
        if (i % i2 == 0) {
            TableRow tableRow = new TableRow(this.aRI.getPageActivity());
            tableRow.addView(view, layoutParams);
            tableLayout.addView(tableRow);
        } else if (tableLayout.getChildCount() != 0) {
            ((TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1)).addView(view, layoutParams);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        this.aRI.getLayoutMode().aM(this.aHT);
        int childCount = this.fhE.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            TableRow tableRow = (TableRow) this.fhE.getChildAt(i2);
            int childCount2 = tableRow.getChildCount();
            for (int i3 = 0; i3 < childCount2; i3++) {
                LinearLayout linearLayout = (LinearLayout) tableRow.getChildAt(i3);
                if (linearLayout.getChildCount() != 0) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (i2 == childCount - 1 && i3 == childCount2 - 1) {
                        textView.setTextColor(aj.getColor(d.C0141d.cp_link_tip_a));
                    } else {
                        d(imageView, imageView.getTag() != null ? ((Integer) imageView.getTag()).intValue() : 0, i);
                        aj.b(textView, d.C0141d.cp_cont_b, 1, i);
                    }
                    aj.f(textView, d.f.square_search_item_bg, i);
                }
            }
        }
    }

    public void iH(boolean z) {
        this.fhG.setVisibility(z ? 0 : 8);
    }

    public void show() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.aHT.setVisibility(0);
        this.fhE.setVisibility(0);
        this.fhF.setVisibility(0);
    }
}
