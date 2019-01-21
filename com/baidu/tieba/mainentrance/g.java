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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class g {
    private View anp;
    private TextView fxq;
    private View fxr;
    private TbPageContext<?> mContext;
    private TableLayout mTableLayout;

    public g(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public View oH() {
        this.anp = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.search_topic, (ViewGroup) null);
        this.fxr = this.anp.findViewById(e.g.titleTopDivider);
        this.fxr.setVisibility(0);
        this.mTableLayout = (TableLayout) this.anp.findViewById(e.g.search_topic_layout);
        this.fxq = (TextView) this.anp.findViewById(e.g.square_search_fourm_header_text);
        this.fxq.setText(this.mContext.getResources().getString(e.j.hot_topic_title));
        return this.anp;
    }

    public void setTitleText(String str) {
        if (this.fxq != null) {
            if (!StringUtils.isNull(str)) {
                this.fxq.setText(str);
            } else {
                this.fxq.setText(this.mContext.getResources().getString(e.j.hot_topic_title));
            }
        }
    }

    public void clear() {
        this.mTableLayout.removeAllViews();
        this.anp.setVisibility(8);
        this.mTableLayout.setVisibility(8);
        this.fxq.setVisibility(8);
    }

    public View a(c cVar, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.search_topic_item, (ViewGroup) null);
        TextView textView = (TextView) linearLayout.findViewById(e.g.text_search_topic_item_text);
        ImageView imageView = (ImageView) linearLayout.findViewById(e.g.image_search_topic_item);
        if (cVar != null) {
            int tag = cVar.getTag();
            imageView.setVisibility(0);
            imageView.setTag(Integer.valueOf(tag));
            d(imageView, tag, TbadkCoreApplication.getInst().getSkinType());
            textView.setText(aj(cVar.getName(), 8));
            linearLayout.setTag(cVar);
        } else {
            textView.setText(e.j.hot_forum_title_more);
            textView.setTextColor(al.getColor(e.d.cp_link_tip_a));
            imageView.setVisibility(8);
        }
        a(linearLayout, i, this.mTableLayout, 2);
        return linearLayout;
    }

    private void d(ImageView imageView, int i, int i2) {
        if (imageView != null) {
            imageView.setImageDrawable(null);
            switch (i) {
                case 1:
                    al.b(imageView, e.f.icon_topic_new, i2);
                    return;
                case 2:
                    al.b(imageView, e.f.icon_topic_hot, i2);
                    return;
                case 3:
                    al.b(imageView, e.f.icon_topic_recommend, i2);
                    return;
                default:
                    imageView.setVisibility(8);
                    return;
            }
        }
    }

    private String aj(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > i) {
            return str.substring(0, i - 1) + this.mContext.getString(e.j.ellipsis);
        }
        return str;
    }

    private void a(View view, int i, TableLayout tableLayout, int i2) {
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds360), -2);
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
        this.mContext.getLayoutMode().onModeChanged(this.anp);
        int childCount = this.mTableLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            TableRow tableRow = (TableRow) this.mTableLayout.getChildAt(i2);
            int childCount2 = tableRow.getChildCount();
            for (int i3 = 0; i3 < childCount2; i3++) {
                LinearLayout linearLayout = (LinearLayout) tableRow.getChildAt(i3);
                if (linearLayout.getChildCount() != 0) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (i2 == childCount - 1 && i3 == childCount2 - 1) {
                        textView.setTextColor(al.getColor(e.d.cp_link_tip_a));
                    } else {
                        d(imageView, imageView.getTag() != null ? ((Integer) imageView.getTag()).intValue() : 0, i);
                        al.b(textView, e.d.cp_cont_b, 1, i);
                    }
                    al.d(textView, e.f.square_search_item_bg, i);
                }
            }
        }
    }

    public void jF(boolean z) {
        this.fxr.setVisibility(z ? 0 : 8);
    }

    public void show() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.anp.setVisibility(0);
        this.mTableLayout.setVisibility(0);
        this.fxq.setVisibility(0);
    }
}
