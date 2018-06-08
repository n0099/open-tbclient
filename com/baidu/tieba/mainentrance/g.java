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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g {
    private View abp;
    private TableLayout eOI;
    private TextView eOJ;
    private View eOK;
    private TbPageContext<?> mContext;

    public g(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public View nn() {
        this.abp = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.search_topic, (ViewGroup) null);
        this.eOK = this.abp.findViewById(d.g.titleTopDivider);
        this.eOK.setVisibility(0);
        this.eOI = (TableLayout) this.abp.findViewById(d.g.search_topic_layout);
        this.eOJ = (TextView) this.abp.findViewById(d.g.square_search_fourm_header_text);
        this.eOJ.setText(this.mContext.getResources().getString(d.k.hot_topic_title));
        return this.abp;
    }

    public void setTitleText(String str) {
        if (this.eOJ != null) {
            if (!StringUtils.isNull(str)) {
                this.eOJ.setText(str);
            } else {
                this.eOJ.setText(this.mContext.getResources().getString(d.k.hot_topic_title));
            }
        }
    }

    public void clear() {
        this.eOI.removeAllViews();
        this.abp.setVisibility(8);
        this.eOI.setVisibility(8);
        this.eOJ.setVisibility(8);
    }

    public View a(c cVar, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.search_topic_item, (ViewGroup) null);
        TextView textView = (TextView) linearLayout.findViewById(d.g.text_search_topic_item_text);
        ImageView imageView = (ImageView) linearLayout.findViewById(d.g.image_search_topic_item);
        if (cVar != null) {
            int tag = cVar.getTag();
            imageView.setVisibility(0);
            imageView.setTag(Integer.valueOf(tag));
            d(imageView, tag, TbadkCoreApplication.getInst().getSkinType());
            textView.setText(ad(cVar.getName(), 8));
            linearLayout.setTag(cVar);
        } else {
            textView.setText(d.k.hot_forum_title_more);
            textView.setTextColor(al.getColor(d.C0141d.cp_link_tip_a));
            imageView.setVisibility(8);
        }
        a(linearLayout, i, this.eOI, 2);
        return linearLayout;
    }

    private void d(ImageView imageView, int i, int i2) {
        if (imageView != null) {
            imageView.setImageDrawable(null);
            switch (i) {
                case 1:
                    al.b(imageView, d.f.icon_topic_new, i2);
                    return;
                case 2:
                    al.b(imageView, d.f.icon_topic_hot, i2);
                    return;
                case 3:
                    al.b(imageView, d.f.icon_topic_recommend, i2);
                    return;
                default:
                    imageView.setVisibility(8);
                    return;
            }
        }
    }

    private String ad(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > i) {
            return str.substring(0, i - 1) + this.mContext.getString(d.k.ellipsis);
        }
        return str;
    }

    private void a(View view, int i, TableLayout tableLayout, int i2) {
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.mContext.getResources().getDimensionPixelSize(d.e.ds360), -2);
        if (i % i2 == 0) {
            TableRow tableRow = new TableRow(this.mContext.getPageActivity());
            tableRow.addView(view, layoutParams);
            tableLayout.addView(tableRow);
        } else if (tableLayout.getChildCount() != 0) {
            ((TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1)).addView(view, layoutParams);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().onModeChanged(this.abp);
        int childCount = this.eOI.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            TableRow tableRow = (TableRow) this.eOI.getChildAt(i2);
            int childCount2 = tableRow.getChildCount();
            for (int i3 = 0; i3 < childCount2; i3++) {
                LinearLayout linearLayout = (LinearLayout) tableRow.getChildAt(i3);
                if (linearLayout.getChildCount() != 0) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (i2 == childCount - 1 && i3 == childCount2 - 1) {
                        textView.setTextColor(al.getColor(d.C0141d.cp_link_tip_a));
                    } else {
                        d(imageView, imageView.getTag() != null ? ((Integer) imageView.getTag()).intValue() : 0, i);
                        al.b(textView, d.C0141d.cp_cont_b, 1, i);
                    }
                    al.d(textView, d.f.square_search_item_bg, i);
                }
            }
        }
    }

    public void il(boolean z) {
        this.eOK.setVisibility(z ? 0 : 8);
    }

    public void show() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.abp.setVisibility(0);
        this.eOI.setVisibility(0);
        this.eOJ.setVisibility(0);
    }
}
