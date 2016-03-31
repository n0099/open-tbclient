package com.baidu.tieba.mainentrance;

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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l {
    private TbPageContext<?> MX;
    private View PL;
    private TableLayout cKM;
    private TextView cKN;

    public l(TbPageContext<?> tbPageContext) {
        this.MX = tbPageContext;
    }

    public View mZ() {
        this.PL = LayoutInflater.from(this.MX.getPageActivity()).inflate(t.h.search_topic, (ViewGroup) null);
        this.cKM = (TableLayout) this.PL.findViewById(t.g.search_topic_layout);
        this.cKN = (TextView) this.PL.findViewById(t.g.square_search_fourm_header_text);
        this.cKN.setText(this.MX.getResources().getString(t.j.hot_topic_title));
        return this.PL;
    }

    public void setTitleText(String str) {
        if (this.cKN != null) {
            if (!StringUtils.isNull(str)) {
                this.cKN.setText(str);
            } else {
                this.cKN.setText(this.MX.getResources().getString(t.j.hot_topic_title));
            }
        }
    }

    public void clear() {
        this.cKM.removeAllViews();
        this.PL.setVisibility(8);
        this.cKM.setVisibility(8);
        this.cKN.setVisibility(8);
    }

    public View a(g gVar, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.MX.getPageActivity()).inflate(t.h.search_topic_item, (ViewGroup) null);
        TextView textView = (TextView) linearLayout.findViewById(t.g.text_search_topic_item_text);
        ImageView imageView = (ImageView) linearLayout.findViewById(t.g.image_search_topic_item);
        if (gVar != null) {
            int tag = gVar.getTag();
            imageView.setVisibility(0);
            imageView.setTag(Integer.valueOf(tag));
            c(imageView, tag, TbadkCoreApplication.m411getInst().getSkinType());
            textView.setText(L(gVar.getName(), 10));
            linearLayout.setTag(gVar);
        } else {
            textView.setText(t.j.hot_forum_title_more);
            textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.s_actionbar_text_line_color_s));
            imageView.setVisibility(8);
        }
        a(linearLayout, i, this.cKM, 2);
        return linearLayout;
    }

    private void c(ImageView imageView, int i, int i2) {
        if (imageView != null) {
            imageView.setImageDrawable(null);
            switch (i) {
                case 1:
                    com.baidu.tbadk.core.util.at.b(imageView, t.f.icon_topic_new, i2);
                    return;
                case 2:
                    com.baidu.tbadk.core.util.at.b(imageView, t.f.icon_topic_hot, i2);
                    return;
                case 3:
                    com.baidu.tbadk.core.util.at.b(imageView, t.f.icon_topic_recommend, i2);
                    return;
                default:
                    imageView.setVisibility(8);
                    return;
            }
        }
    }

    private String L(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > i) {
            return String.valueOf(str.substring(0, i - 1)) + this.MX.getString(t.j.topic_suffix);
        }
        return str;
    }

    private void a(View view, int i, TableLayout tableLayout, int i2) {
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.MX.getResources().getDimensionPixelSize(t.e.ds360), -2);
        if (i % i2 == 0) {
            TableRow tableRow = new TableRow(this.MX.getPageActivity());
            tableRow.addView(view, layoutParams);
            tableLayout.addView(tableRow);
        } else if (tableLayout.getChildCount() != 0) {
            ((TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1)).addView(view, layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        this.MX.getLayoutMode().x(this.PL);
        int childCount = this.cKM.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            TableRow tableRow = (TableRow) this.cKM.getChildAt(i2);
            int childCount2 = tableRow.getChildCount();
            for (int i3 = 0; i3 < childCount2; i3++) {
                LinearLayout linearLayout = (LinearLayout) tableRow.getChildAt(i3);
                if (linearLayout.getChildCount() != 0) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (i2 == childCount - 1 && i3 == childCount2 - 1) {
                        textView.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.s_actionbar_text_line_color_s));
                    } else {
                        c(imageView, imageView.getTag() != null ? ((Integer) imageView.getTag()).intValue() : 0, i);
                        com.baidu.tbadk.core.util.at.a(textView, t.d.cp_cont_b, 1, i);
                    }
                    com.baidu.tbadk.core.util.at.c(textView, t.f.square_search_item_bg, i);
                }
            }
        }
    }

    public void show() {
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.PL.setVisibility(0);
        this.cKM.setVisibility(0);
        this.cKN.setVisibility(0);
    }
}
