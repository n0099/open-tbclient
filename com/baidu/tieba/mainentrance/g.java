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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class g {
    private TbPageContext<?> cVh;
    private TableLayout ifg;
    private TextView ifh;
    private View ifi;
    private View mRoot;

    public g(TbPageContext<?> tbPageContext) {
        this.cVh = tbPageContext;
    }

    public View createView() {
        this.mRoot = LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.search_topic, (ViewGroup) null);
        this.ifi = this.mRoot.findViewById(R.id.titleTopDivider);
        this.ifi.setVisibility(0);
        this.ifg = (TableLayout) this.mRoot.findViewById(R.id.search_topic_layout);
        this.ifh = (TextView) this.mRoot.findViewById(R.id.square_search_fourm_header_text);
        this.ifh.setText(this.cVh.getResources().getString(R.string.hot_topic_title));
        return this.mRoot;
    }

    public void setTitleText(String str) {
        if (this.ifh != null) {
            if (!StringUtils.isNull(str)) {
                this.ifh.setText(str);
            } else {
                this.ifh.setText(this.cVh.getResources().getString(R.string.hot_topic_title));
            }
        }
    }

    public void clear() {
        this.ifg.removeAllViews();
        this.mRoot.setVisibility(8);
        this.ifg.setVisibility(8);
        this.ifh.setVisibility(8);
    }

    public View a(c cVar, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.search_topic_item, (ViewGroup) null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.text_search_topic_item_text);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.image_search_topic_item);
        if (cVar != null) {
            int tag = cVar.getTag();
            imageView.setVisibility(0);
            imageView.setTag(Integer.valueOf(tag));
            a(imageView, tag, TbadkCoreApplication.getInst().getSkinType());
            textView.setText(aG(cVar.getName(), 8));
            linearLayout.setTag(cVar);
        } else {
            textView.setText(R.string.hot_forum_title_more);
            textView.setTextColor(am.getColor(R.color.cp_link_tip_a));
            imageView.setVisibility(8);
        }
        a(linearLayout, i, this.ifg, 2);
        return linearLayout;
    }

    private void a(ImageView imageView, int i, int i2) {
        if (imageView != null) {
            imageView.setImageDrawable(null);
            switch (i) {
                case 1:
                    am.setImageResource(imageView, R.drawable.icon_topic_new, i2);
                    return;
                case 2:
                    am.setImageResource(imageView, R.drawable.icon_topic_hot, i2);
                    return;
                case 3:
                    am.setImageResource(imageView, R.drawable.icon_topic_recommend, i2);
                    return;
                default:
                    imageView.setVisibility(8);
                    return;
            }
        }
    }

    private String aG(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > i) {
            return str.substring(0, i - 1) + this.cVh.getString(R.string.ellipsis);
        }
        return str;
    }

    private void a(View view, int i, TableLayout tableLayout, int i2) {
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.cVh.getResources().getDimensionPixelSize(R.dimen.ds360), -2);
        if (i % i2 == 0) {
            TableRow tableRow = new TableRow(this.cVh.getPageActivity());
            tableRow.addView(view, layoutParams);
            tableLayout.addView(tableRow);
        } else if (tableLayout.getChildCount() != 0) {
            ((TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1)).addView(view, layoutParams);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        this.cVh.getLayoutMode().onModeChanged(this.mRoot);
        int childCount = this.ifg.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            TableRow tableRow = (TableRow) this.ifg.getChildAt(i2);
            int childCount2 = tableRow.getChildCount();
            for (int i3 = 0; i3 < childCount2; i3++) {
                LinearLayout linearLayout = (LinearLayout) tableRow.getChildAt(i3);
                if (linearLayout.getChildCount() != 0) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (i2 == childCount - 1 && i3 == childCount2 - 1) {
                        textView.setTextColor(am.getColor(R.color.cp_link_tip_a));
                    } else {
                        a(imageView, imageView.getTag() != null ? ((Integer) imageView.getTag()).intValue() : 0, i);
                        am.setViewTextColor(textView, R.color.cp_cont_b, 1, i);
                    }
                    am.setBackgroundResource(textView, R.drawable.square_search_item_bg, i);
                }
            }
        }
    }

    public void oD(boolean z) {
        this.ifi.setVisibility(z ? 0 : 8);
    }

    public void show() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mRoot.setVisibility(0);
        this.ifg.setVisibility(0);
        this.ifh.setVisibility(0);
    }
}
