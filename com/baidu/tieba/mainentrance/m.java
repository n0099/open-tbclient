package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class m {
    private View aWS;
    private TableLayout clg;
    private TextView clh;
    private boolean cli;
    private TbPageContext<?> mContext;
    private View mRoot;

    public m(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public View nv() {
        this.mRoot = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.search_topic, (ViewGroup) null);
        this.clg = (TableLayout) this.mRoot.findViewById(n.f.search_topic_layout);
        this.clh = (TextView) this.mRoot.findViewById(n.f.square_search_fourm_header_text);
        this.clh.setText(this.mContext.getResources().getString(n.i.hot_topic_title));
        this.aWS = this.mRoot.findViewById(n.f.bottomDivider);
        return this.mRoot;
    }

    public void clear() {
        this.clg.removeAllViews();
        this.mRoot.setVisibility(8);
        this.aWS.setVisibility(8);
        this.clg.setVisibility(8);
        this.clh.setVisibility(8);
    }

    public View a(g gVar, int i) {
        if (gVar == null) {
            return null;
        }
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.search_topic_item, (ViewGroup) null);
        ((TextView) frameLayout.findViewById(n.f.text_search_topic_item_text)).setText(aa(gVar.getName(), 10));
        frameLayout.setTag(gVar);
        a(frameLayout, i, this.clg, 2);
        return frameLayout;
    }

    private String aa(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > i) {
            return String.valueOf(str.substring(0, i - 2)) + this.mContext.getString(n.i.topic_suffix);
        }
        return str;
    }

    private void a(View view, int i, TableLayout tableLayout, int i2) {
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.mContext.getResources().getDimensionPixelSize(n.d.ds360), -2);
        if (i % i2 == 0) {
            TableRow tableRow = new TableRow(this.mContext.getPageActivity());
            tableRow.addView(view, layoutParams);
            tableLayout.addView(tableRow);
        } else if (tableLayout.getChildCount() != 0) {
            ((TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1)).addView(view, layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        this.mContext.getLayoutMode().k(this.mRoot);
        for (int i2 = 0; i2 < this.clg.getChildCount(); i2++) {
            TableRow tableRow = (TableRow) this.clg.getChildAt(i2);
            for (int i3 = 0; i3 < tableRow.getChildCount(); i3++) {
                FrameLayout frameLayout = (FrameLayout) tableRow.getChildAt(i3);
                if (frameLayout.getChildCount() != 0) {
                    TextView textView = (TextView) frameLayout.getChildAt(0);
                    com.baidu.tbadk.core.util.as.a(textView, n.c.cp_cont_b, 1, i);
                    com.baidu.tbadk.core.util.as.c(textView, n.e.square_search_item_bg, i);
                }
            }
        }
    }

    public void show() {
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.mRoot.setVisibility(0);
        if (this.cli) {
            this.aWS.setVisibility(0);
        }
        this.clg.setVisibility(0);
        this.clh.setVisibility(0);
    }

    public void el(boolean z) {
        this.cli = z;
        this.aWS.setVisibility(z ? 0 : 8);
    }
}
