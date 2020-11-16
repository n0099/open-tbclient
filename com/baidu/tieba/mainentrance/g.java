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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class g {
    private TbPageContext<?> eGu;
    private View kMA;
    private TableLayout kMy;
    private TextView kMz;
    private View mRoot;

    public g(TbPageContext<?> tbPageContext) {
        this.eGu = tbPageContext;
    }

    public View createView() {
        this.mRoot = LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.search_topic, (ViewGroup) null);
        this.kMA = this.mRoot.findViewById(R.id.titleTopDivider);
        this.kMA.setVisibility(0);
        this.kMy = (TableLayout) this.mRoot.findViewById(R.id.search_topic_layout);
        this.kMz = (TextView) this.mRoot.findViewById(R.id.square_search_fourm_header_text);
        this.kMz.setText(this.eGu.getResources().getString(R.string.hot_topic_title));
        return this.mRoot;
    }

    public void setTitleText(String str) {
        if (this.kMz != null) {
            if (!StringUtils.isNull(str)) {
                this.kMz.setText(str);
            } else {
                this.kMz.setText(this.eGu.getResources().getString(R.string.hot_topic_title));
            }
        }
    }

    public void clear() {
        this.kMy.removeAllViews();
        this.mRoot.setVisibility(8);
        this.kMy.setVisibility(8);
        this.kMz.setVisibility(8);
    }

    public View a(c cVar, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.search_topic_item, (ViewGroup) null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.text_search_topic_item_text);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.image_search_topic_item);
        if (cVar != null) {
            int tag = cVar.getTag();
            imageView.setVisibility(0);
            imageView.setTag(Integer.valueOf(tag));
            a(imageView, tag, TbadkCoreApplication.getInst().getSkinType());
            textView.setText(aV(cVar.getName(), 8));
            linearLayout.setTag(cVar);
        } else {
            textView.setText(R.string.hot_forum_title_more);
            textView.setTextColor(ap.getColor(R.color.CAM_X0302));
            imageView.setVisibility(8);
        }
        a(linearLayout, i, this.kMy, 2);
        return linearLayout;
    }

    private void a(ImageView imageView, int i, int i2) {
        if (imageView != null) {
            imageView.setImageDrawable(null);
            switch (i) {
                case 1:
                    ap.setImageResource(imageView, R.drawable.icon_topic_new, i2);
                    return;
                case 2:
                    ap.setImageResource(imageView, R.drawable.icon_topic_hot, i2);
                    return;
                case 3:
                    ap.setImageResource(imageView, R.drawable.icon_topic_recommend, i2);
                    return;
                default:
                    imageView.setVisibility(8);
                    return;
            }
        }
    }

    private String aV(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > i) {
            return str.substring(0, i - 1) + this.eGu.getString(R.string.ellipsis);
        }
        return str;
    }

    private void a(View view, int i, TableLayout tableLayout, int i2) {
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.eGu.getResources().getDimensionPixelSize(R.dimen.ds360), -2);
        if (i % i2 == 0) {
            TableRow tableRow = new TableRow(this.eGu.getPageActivity());
            tableRow.addView(view, layoutParams);
            tableLayout.addView(tableRow);
        } else if (tableLayout.getChildCount() != 0) {
            ((TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1)).addView(view, layoutParams);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        this.eGu.getLayoutMode().onModeChanged(this.mRoot);
        int childCount = this.kMy.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            TableRow tableRow = (TableRow) this.kMy.getChildAt(i2);
            int childCount2 = tableRow.getChildCount();
            for (int i3 = 0; i3 < childCount2; i3++) {
                LinearLayout linearLayout = (LinearLayout) tableRow.getChildAt(i3);
                if (linearLayout.getChildCount() != 0) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (i2 == childCount - 1 && i3 == childCount2 - 1) {
                        textView.setTextColor(ap.getColor(R.color.CAM_X0302));
                    } else {
                        a(imageView, imageView.getTag() != null ? ((Integer) imageView.getTag()).intValue() : 0, i);
                        ap.setViewTextColor(textView, R.color.CAM_X0105, 1, i);
                    }
                    ap.setBackgroundResource(textView, R.drawable.square_search_item_bg, i);
                }
            }
        }
    }

    public void tc(boolean z) {
        this.kMA.setVisibility(z ? 0 : 8);
    }

    public void show() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mRoot.setVisibility(0);
        this.kMy.setVisibility(0);
        this.kMz.setVisibility(0);
    }
}
