package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class a extends y.a {
    private BookShelfItemView eEA;
    private BookShelfItemView eEB;
    private LinearLayout eEC;
    private View eED;
    private RelativeLayout eEu;
    private ImageView eEv;
    private TextView eEw;
    private TextView eEx;
    private BookShelfItemView eEy;
    private BookShelfItemView eEz;

    public a(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eEu = (RelativeLayout) view.findViewById(r.g.book_info);
        this.eEv = (ImageView) view.findViewById(r.g.person_book_icon);
        this.eEw = (TextView) view.findViewById(r.g.book_title);
        this.eEx = (TextView) view.findViewById(r.g.book_hint);
        this.eED = view.findViewById(r.g.book_divider);
        this.eEC = (LinearLayout) view.findViewById(r.g.book_items);
        this.eEy = (BookShelfItemView) view.findViewById(r.g.book_1);
        this.eEz = (BookShelfItemView) view.findViewById(r.g.book_2);
        this.eEA = (BookShelfItemView) view.findViewById(r.g.book_3);
        this.eEB = (BookShelfItemView) view.findViewById(r.g.book_4);
        if (onClickListener != null) {
            this.eEu.setOnClickListener(onClickListener);
        }
    }

    public void a(com.baidu.tieba.person.data.b bVar) {
        if (bVar != null) {
            this.eEw.setText(bVar.eEc);
            if (bVar.eEg > 0) {
                this.eEx.setText(String.valueOf(bVar.eEg));
            } else if (!StringUtils.isNull(bVar.eEf)) {
                this.eEx.setText(bVar.eEf);
            }
            if (bVar.eEh != null && bVar.eEh.size() > 0) {
                this.eEC.setVisibility(0);
                this.eED.setVisibility(0);
                List<com.baidu.tieba.personInfo.b> list = bVar.eEh;
                if (list.size() > 0) {
                    this.eEy.a(list.get(0));
                    this.eEy.setVisibility(0);
                } else {
                    this.eEy.setVisibility(4);
                }
                if (list.size() > 1) {
                    this.eEz.a(list.get(1));
                    this.eEz.setVisibility(0);
                } else {
                    this.eEz.setVisibility(4);
                }
                if (list.size() > 2) {
                    this.eEA.a(list.get(2));
                    this.eEA.setVisibility(0);
                } else {
                    this.eEA.setVisibility(4);
                }
                if (list.size() > 3) {
                    this.eEB.a(list.get(3));
                    this.eEB.setVisibility(0);
                    return;
                }
                this.eEB.setVisibility(4);
                return;
            }
            this.eEC.setVisibility(8);
            this.eED.setVisibility(8);
        }
    }
}
