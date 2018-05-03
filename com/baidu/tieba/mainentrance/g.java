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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g {
    private View Tl;
    private TbPageContext<?> adf;
    private TableLayout eCg;
    private TextView eCh;
    private View eCi;

    public g(TbPageContext<?> tbPageContext) {
        this.adf = tbPageContext;
    }

    public View kA() {
        this.Tl = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.search_topic, (ViewGroup) null);
        this.eCi = this.Tl.findViewById(d.g.titleTopDivider);
        this.eCi.setVisibility(0);
        this.eCg = (TableLayout) this.Tl.findViewById(d.g.search_topic_layout);
        this.eCh = (TextView) this.Tl.findViewById(d.g.square_search_fourm_header_text);
        this.eCh.setText(this.adf.getResources().getString(d.k.hot_topic_title));
        return this.Tl;
    }

    public void setTitleText(String str) {
        if (this.eCh != null) {
            if (!StringUtils.isNull(str)) {
                this.eCh.setText(str);
            } else {
                this.eCh.setText(this.adf.getResources().getString(d.k.hot_topic_title));
            }
        }
    }

    public void clear() {
        this.eCg.removeAllViews();
        this.Tl.setVisibility(8);
        this.eCg.setVisibility(8);
        this.eCh.setVisibility(8);
    }

    public View a(c cVar, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.search_topic_item, (ViewGroup) null);
        TextView textView = (TextView) linearLayout.findViewById(d.g.text_search_topic_item_text);
        ImageView imageView = (ImageView) linearLayout.findViewById(d.g.image_search_topic_item);
        if (cVar != null) {
            int tag = cVar.getTag();
            imageView.setVisibility(0);
            imageView.setTag(Integer.valueOf(tag));
            d(imageView, tag, TbadkCoreApplication.getInst().getSkinType());
            textView.setText(aa(cVar.getName(), 8));
            linearLayout.setTag(cVar);
        } else {
            textView.setText(d.k.hot_forum_title_more);
            textView.setTextColor(ak.getColor(d.C0126d.cp_link_tip_a));
            imageView.setVisibility(8);
        }
        a(linearLayout, i, this.eCg, 2);
        return linearLayout;
    }

    private void d(ImageView imageView, int i, int i2) {
        if (imageView != null) {
            imageView.setImageDrawable(null);
            switch (i) {
                case 1:
                    ak.b(imageView, d.f.icon_topic_new, i2);
                    return;
                case 2:
                    ak.b(imageView, d.f.icon_topic_hot, i2);
                    return;
                case 3:
                    ak.b(imageView, d.f.icon_topic_recommend, i2);
                    return;
                default:
                    imageView.setVisibility(8);
                    return;
            }
        }
    }

    private String aa(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > i) {
            return str.substring(0, i - 1) + this.adf.getString(d.k.ellipsis);
        }
        return str;
    }

    private void a(View view2, int i, TableLayout tableLayout, int i2) {
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.adf.getResources().getDimensionPixelSize(d.e.ds360), -2);
        if (i % i2 == 0) {
            TableRow tableRow = new TableRow(this.adf.getPageActivity());
            tableRow.addView(view2, layoutParams);
            tableLayout.addView(tableRow);
        } else if (tableLayout.getChildCount() != 0) {
            ((TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1)).addView(view2, layoutParams);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        this.adf.getLayoutMode().u(this.Tl);
        int childCount = this.eCg.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            TableRow tableRow = (TableRow) this.eCg.getChildAt(i2);
            int childCount2 = tableRow.getChildCount();
            for (int i3 = 0; i3 < childCount2; i3++) {
                LinearLayout linearLayout = (LinearLayout) tableRow.getChildAt(i3);
                if (linearLayout.getChildCount() != 0) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (i2 == childCount - 1 && i3 == childCount2 - 1) {
                        textView.setTextColor(ak.getColor(d.C0126d.cp_link_tip_a));
                    } else {
                        d(imageView, imageView.getTag() != null ? ((Integer) imageView.getTag()).intValue() : 0, i);
                        ak.b(textView, d.C0126d.cp_cont_b, 1, i);
                    }
                    ak.d(textView, d.f.square_search_item_bg, i);
                }
            }
        }
    }

    public void ie(boolean z) {
        this.eCi.setVisibility(z ? 0 : 8);
    }

    public void show() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.Tl.setVisibility(0);
        this.eCg.setVisibility(0);
        this.eCh.setVisibility(0);
    }
}
