package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class a extends y.a {
    private TextView eoA;
    private TextView eoB;
    private BookShelfItemView eoC;
    private BookShelfItemView eoD;
    private BookShelfItemView eoE;
    private BookShelfItemView eoF;
    private LinearLayout eoG;
    private View eoH;
    private RelativeLayout eoy;
    private ImageView eoz;

    public a(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eoy = (RelativeLayout) view.findViewById(r.g.book_info);
        this.eoz = (ImageView) view.findViewById(r.g.person_book_icon);
        this.eoA = (TextView) view.findViewById(r.g.book_title);
        this.eoB = (TextView) view.findViewById(r.g.book_hint);
        this.eoH = view.findViewById(r.g.book_divider);
        this.eoG = (LinearLayout) view.findViewById(r.g.book_items);
        this.eoC = (BookShelfItemView) view.findViewById(r.g.book_1);
        this.eoD = (BookShelfItemView) view.findViewById(r.g.book_2);
        this.eoE = (BookShelfItemView) view.findViewById(r.g.book_3);
        this.eoF = (BookShelfItemView) view.findViewById(r.g.book_4);
        if (onClickListener != null) {
            this.eoy.setOnClickListener(onClickListener);
        }
    }

    public void a(com.baidu.tieba.person.data.b bVar) {
        if (bVar != null) {
            this.eoA.setText(bVar.eoq);
            if (bVar.eou > 0) {
                this.eoB.setText(String.valueOf(bVar.eou));
            } else if (!StringUtils.isNull(bVar.eot)) {
                this.eoB.setText(bVar.eot);
            }
            if (bVar.eov != null && bVar.eov.size() > 0) {
                this.eoG.setVisibility(0);
                this.eoH.setVisibility(0);
                List<com.baidu.tieba.personInfo.b> list = bVar.eov;
                if (list.size() > 0) {
                    this.eoC.a(list.get(0));
                    this.eoC.setVisibility(0);
                } else {
                    this.eoC.setVisibility(4);
                }
                if (list.size() > 1) {
                    this.eoD.a(list.get(1));
                    this.eoD.setVisibility(0);
                } else {
                    this.eoD.setVisibility(4);
                }
                if (list.size() > 2) {
                    this.eoE.a(list.get(2));
                    this.eoE.setVisibility(0);
                } else {
                    this.eoE.setVisibility(4);
                }
                if (list.size() > 3) {
                    this.eoF.a(list.get(3));
                    this.eoF.setVisibility(0);
                } else {
                    this.eoF.setVisibility(4);
                }
            } else {
                this.eoG.setVisibility(8);
                this.eoH.setVisibility(8);
            }
            ar.k(this.eoz, r.f.icon_mine_book);
        }
    }
}
