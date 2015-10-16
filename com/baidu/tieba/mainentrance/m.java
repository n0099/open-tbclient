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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class m {
    private View aRw;
    private TableLayout bUs;
    private TextView bUt;
    private boolean bUu;
    private TbPageContext<?> mContext;
    private View mRoot;

    public m(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public View no() {
        this.mRoot = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.search_topic, (ViewGroup) null);
        this.bUs = (TableLayout) this.mRoot.findViewById(i.f.search_topic_layout);
        this.bUt = (TextView) this.mRoot.findViewById(i.f.square_search_fourm_header_text);
        this.bUt.setText(this.mContext.getResources().getString(i.h.hot_topic_title));
        this.aRw = this.mRoot.findViewById(i.f.bottomDivider);
        return this.mRoot;
    }

    public void clear() {
        this.bUs.removeAllViews();
        this.mRoot.setVisibility(8);
        this.aRw.setVisibility(8);
        this.bUs.setVisibility(8);
        this.bUt.setVisibility(8);
    }

    public View a(g gVar, int i) {
        if (gVar == null) {
            return null;
        }
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.search_topic_item, (ViewGroup) null);
        ((TextView) frameLayout.findViewById(i.f.text_search_topic_item_text)).setText(V(gVar.getName(), 10));
        frameLayout.setTag(gVar);
        a(frameLayout, i, this.bUs, 2);
        return frameLayout;
    }

    private String V(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > i) {
            return String.valueOf(str.substring(0, i - 2)) + this.mContext.getString(i.h.topic_suffix);
        }
        return str;
    }

    private void a(View view, int i, TableLayout tableLayout, int i2) {
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.mContext.getResources().getDimensionPixelSize(i.d.ds360), -2);
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
        for (int i2 = 0; i2 < this.bUs.getChildCount(); i2++) {
            TableRow tableRow = (TableRow) this.bUs.getChildAt(i2);
            for (int i3 = 0; i3 < tableRow.getChildCount(); i3++) {
                FrameLayout frameLayout = (FrameLayout) tableRow.getChildAt(i3);
                if (frameLayout.getChildCount() != 0) {
                    TextView textView = (TextView) frameLayout.getChildAt(0);
                    com.baidu.tbadk.core.util.an.a(textView, i.c.cp_cont_b, 1, i);
                    com.baidu.tbadk.core.util.an.c(textView, i.e.square_search_item_bg, i);
                }
            }
        }
    }

    public void show() {
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.mRoot.setVisibility(0);
        if (this.bUu) {
            this.aRw.setVisibility(0);
        }
        this.bUs.setVisibility(0);
        this.bUt.setVisibility(0);
    }

    public void dK(boolean z) {
        this.bUu = z;
        this.aRw.setVisibility(z ? 0 : 8);
    }
}
