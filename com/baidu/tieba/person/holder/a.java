package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class a extends y.a {
    private View eCA;
    private RelativeLayout eCr;
    private ImageView eCs;
    private TextView eCt;
    private TextView eCu;
    private BookShelfItemView eCv;
    private BookShelfItemView eCw;
    private BookShelfItemView eCx;
    private BookShelfItemView eCy;
    private LinearLayout eCz;

    public a(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eCr = (RelativeLayout) view.findViewById(t.g.book_info);
        this.eCs = (ImageView) view.findViewById(t.g.person_book_icon);
        this.eCt = (TextView) view.findViewById(t.g.book_title);
        this.eCu = (TextView) view.findViewById(t.g.book_hint);
        this.eCA = view.findViewById(t.g.book_divider);
        this.eCz = (LinearLayout) view.findViewById(t.g.book_items);
        this.eCv = (BookShelfItemView) view.findViewById(t.g.book_1);
        this.eCw = (BookShelfItemView) view.findViewById(t.g.book_2);
        this.eCx = (BookShelfItemView) view.findViewById(t.g.book_3);
        this.eCy = (BookShelfItemView) view.findViewById(t.g.book_4);
        if (onClickListener != null) {
            this.eCr.setOnClickListener(onClickListener);
        }
    }

    public void a(com.baidu.tieba.person.data.b bVar) {
        if (bVar != null) {
            this.eCt.setText(bVar.eBZ);
            if (bVar.eCd > 0) {
                this.eCu.setText(String.valueOf(bVar.eCd));
            } else if (!StringUtils.isNull(bVar.eCc)) {
                this.eCu.setText(bVar.eCc);
            }
            if (bVar.eCe != null && bVar.eCe.size() > 0) {
                this.eCz.setVisibility(0);
                this.eCA.setVisibility(0);
                List<com.baidu.tieba.personInfo.b> list = bVar.eCe;
                if (list.size() > 0) {
                    this.eCv.a(list.get(0));
                    this.eCv.setVisibility(0);
                } else {
                    this.eCv.setVisibility(4);
                }
                if (list.size() > 1) {
                    this.eCw.a(list.get(1));
                    this.eCw.setVisibility(0);
                } else {
                    this.eCw.setVisibility(4);
                }
                if (list.size() > 2) {
                    this.eCx.a(list.get(2));
                    this.eCx.setVisibility(0);
                } else {
                    this.eCx.setVisibility(4);
                }
                if (list.size() > 3) {
                    this.eCy.a(list.get(3));
                    this.eCy.setVisibility(0);
                    return;
                }
                this.eCy.setVisibility(4);
                return;
            }
            this.eCz.setVisibility(8);
            this.eCA.setVisibility(8);
        }
    }
}
