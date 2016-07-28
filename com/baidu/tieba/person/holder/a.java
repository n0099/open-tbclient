package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class a extends y.a {
    private RelativeLayout etR;
    private TbImageView etS;
    private TextView etT;
    private TextView etU;
    private BookShelfItemView etV;
    private BookShelfItemView etW;
    private BookShelfItemView etX;
    private BookShelfItemView etY;
    private LinearLayout etZ;
    private View eua;

    public a(View view, View.OnClickListener onClickListener) {
        super(view);
        this.etR = (RelativeLayout) view.findViewById(u.g.book_info);
        this.etS = (TbImageView) view.findViewById(u.g.book_icon);
        this.etT = (TextView) view.findViewById(u.g.book_title);
        this.etU = (TextView) view.findViewById(u.g.book_hint);
        this.eua = view.findViewById(u.g.book_divider);
        this.etZ = (LinearLayout) view.findViewById(u.g.book_items);
        this.etV = (BookShelfItemView) view.findViewById(u.g.book_1);
        this.etW = (BookShelfItemView) view.findViewById(u.g.book_2);
        this.etX = (BookShelfItemView) view.findViewById(u.g.book_3);
        this.etY = (BookShelfItemView) view.findViewById(u.g.book_4);
        if (onClickListener != null) {
            this.etR.setOnClickListener(onClickListener);
        }
    }

    public void a(com.baidu.tieba.person.data.d dVar) {
        if (dVar != null) {
            this.etS.c(dVar.erQ, 10, false);
            this.etT.setText(dVar.erP);
            if (dVar.erT > 0) {
                this.etU.setText(String.valueOf(dVar.erT));
            } else if (!StringUtils.isNull(dVar.erS)) {
                this.etU.setText(dVar.erS);
            }
            if (dVar.erU != null && dVar.erU.size() > 0) {
                this.etZ.setVisibility(0);
                this.eua.setVisibility(0);
                List<com.baidu.tieba.personInfo.c> list = dVar.erU;
                if (list.size() > 0) {
                    this.etV.a(list.get(0));
                    this.etV.setVisibility(0);
                } else {
                    this.etV.setVisibility(4);
                }
                if (list.size() > 1) {
                    this.etW.a(list.get(1));
                    this.etW.setVisibility(0);
                } else {
                    this.etW.setVisibility(4);
                }
                if (list.size() > 2) {
                    this.etX.a(list.get(2));
                    this.etX.setVisibility(0);
                } else {
                    this.etX.setVisibility(4);
                }
                if (list.size() > 3) {
                    this.etY.a(list.get(3));
                    this.etY.setVisibility(0);
                    return;
                }
                this.etY.setVisibility(4);
                return;
            }
            this.etZ.setVisibility(8);
            this.eua.setVisibility(8);
        }
    }
}
