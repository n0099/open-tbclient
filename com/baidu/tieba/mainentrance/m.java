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
    private View aOM;
    private TableLayout cpk;
    private TextView cpl;
    private boolean cpm;
    private TbPageContext<?> mContext;
    private View mRoot;

    public m(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public View mT() {
        this.mRoot = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.search_topic, (ViewGroup) null);
        this.cpk = (TableLayout) this.mRoot.findViewById(n.g.search_topic_layout);
        this.cpl = (TextView) this.mRoot.findViewById(n.g.square_search_fourm_header_text);
        this.cpl.setText(this.mContext.getResources().getString(n.j.hot_topic_title));
        this.aOM = this.mRoot.findViewById(n.g.bottomDivider);
        return this.mRoot;
    }

    public void clear() {
        this.cpk.removeAllViews();
        this.mRoot.setVisibility(8);
        this.aOM.setVisibility(8);
        this.cpk.setVisibility(8);
        this.cpl.setVisibility(8);
    }

    public View a(g gVar, int i) {
        if (gVar == null) {
            return null;
        }
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.search_topic_item, (ViewGroup) null);
        ((TextView) frameLayout.findViewById(n.g.text_search_topic_item_text)).setText(aa(gVar.getName(), 10));
        frameLayout.setTag(gVar);
        a(frameLayout, i, this.cpk, 2);
        return frameLayout;
    }

    private String aa(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > i) {
            return String.valueOf(str.substring(0, i - 2)) + this.mContext.getString(n.j.topic_suffix);
        }
        return str;
    }

    private void a(View view, int i, TableLayout tableLayout, int i2) {
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.mContext.getResources().getDimensionPixelSize(n.e.ds360), -2);
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
        for (int i2 = 0; i2 < this.cpk.getChildCount(); i2++) {
            TableRow tableRow = (TableRow) this.cpk.getChildAt(i2);
            for (int i3 = 0; i3 < tableRow.getChildCount(); i3++) {
                FrameLayout frameLayout = (FrameLayout) tableRow.getChildAt(i3);
                if (frameLayout.getChildCount() != 0) {
                    TextView textView = (TextView) frameLayout.getChildAt(0);
                    com.baidu.tbadk.core.util.as.a(textView, n.d.cp_cont_b, 1, i);
                    com.baidu.tbadk.core.util.as.c(textView, n.f.square_search_item_bg, i);
                }
            }
        }
    }

    public void show() {
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.mRoot.setVisibility(0);
        if (this.cpm) {
            this.aOM.setVisibility(0);
        }
        this.cpk.setVisibility(0);
        this.cpl.setVisibility(0);
    }

    public void el(boolean z) {
        this.cpm = z;
        this.aOM.setVisibility(z ? 0 : 8);
    }
}
