package com.baidu.tieba.mygiftlist;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.u;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetGiftMyList.DataRes;
import tbclient.GetGiftMyList.GiftList;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.f {
    View.OnClickListener Ie;
    private List<GiftList> Wx;
    private y Yc;
    private View aFZ;
    private NavigationBar aGJ;
    AdapterView.OnItemClickListener aIT;
    private TextView btA;
    private View btB;
    private com.baidu.tbadk.widget.i btC;
    private MyGiftListActivity btc;
    private NoNetworkView btm;
    private BdListView bto;
    private View btp;
    private View btq;
    private View btr;
    private aa bts;
    private TextView btt;
    private TextView btu;
    private TextView btv;
    private String btw;
    private String btx;
    private g bty;
    private RelativeLayout btz;
    private boolean mIsHost;

    public k(MyGiftListActivity myGiftListActivity, aa aaVar, boolean z) {
        super(myGiftListActivity);
        this.Yc = null;
        this.aIT = new l(this);
        this.Ie = new m(this);
        this.btc = myGiftListActivity;
        this.mIsHost = z;
        this.Wx = new ArrayList();
        this.bts = aaVar;
        nu();
        VI();
        if (this.mIsHost || !TbadkApplication.m251getInst().isGiftSwitchOn()) {
            this.btz.setVisibility(8);
        } else {
            this.btz.setVisibility(0);
        }
        this.btC = new com.baidu.tbadk.widget.i(this.btc);
    }

    private void nu() {
        this.btc.setContentView(w.my_gift_list_activity);
        this.btw = null;
        this.aFZ = this.btc.findViewById(v.root);
        this.bto = (BdListView) this.aFZ.findViewById(v.list_view);
        this.aGJ = (NavigationBar) this.aFZ.findViewById(v.navigation_bar);
        String format = String.format(this.btc.getString(com.baidu.tieba.y.he_gift_title), this.btc.VG());
        if (this.mIsHost) {
            this.aGJ.setTitleText(com.baidu.tieba.y.my_gift_list);
        } else {
            this.aGJ.setTitleText(format);
        }
        this.aGJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.btm = (NoNetworkView) this.aFZ.findViewById(v.no_networkview);
        this.btp = com.baidu.adp.lib.g.b.ek().a(this.btc, w.my_gift_list_head, null, false);
        this.btp.setVisibility(8);
        this.btt = (TextView) this.btp.findViewById(v.gift_total);
        this.btu = (TextView) this.btp.findViewById(v.dou_num);
        this.btv = (TextView) this.btp.findViewById(v.t_use);
        this.btv.setOnClickListener(this.Ie);
        this.btq = com.baidu.adp.lib.g.b.ek().a(this.btc, w.my_gift_list_footer, null, false);
        this.btr = this.btq.findViewById(v.gift_footer_lay);
        if (this.mIsHost) {
            this.bto.addHeaderView(this.btp);
        } else if (TbadkApplication.m251getInst().isGiftSwitchOn()) {
            this.btq.setPadding(0, 0, 0, com.baidu.adp.lib.util.m.c(this.btc, t.ds156));
        }
        this.bto.addFooterView(this.btq);
        this.bty = new g(this.btc, this.mIsHost);
        this.bto.setAdapter((ListAdapter) this.bty);
        this.Yc = new y(this.btc);
        this.bto.setPullRefresh(this.Yc);
        this.bto.setOnSrollToBottomListener(this.bts);
        this.bto.setOnItemClickListener(this.aIT);
    }

    private void VI() {
        this.btz = (RelativeLayout) this.btc.findViewById(v.gift_relation_ll);
        this.btA = (TextView) this.btc.findViewById(v.gift_relation_text);
        this.btA.setOnClickListener(this.btc.VE());
        this.btB = this.btc.findViewById(v.his_gift_line);
        if (!this.mIsHost && TbadkApplication.m251getInst().isGiftSwitchOn()) {
            this.bto.setOnScrollListener(new n(this));
        }
    }

    public View VJ() {
        return this.btr;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0100: IGET  (r2v0 java.lang.Integer A[REMOVE]) = (r6v0 tbclient.GetGiftMyList.DataRes) tbclient.GetGiftMyList.DataRes.total_num java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0115: IGET  (r2v1 java.lang.Integer A[REMOVE]) = (r6v0 tbclient.GetGiftMyList.DataRes) tbclient.GetGiftMyList.DataRes.money java.lang.Integer)] */
    public void a(DataRes dataRes, boolean z) {
        this.btp.setVisibility(0);
        if (dataRes == null || dataRes.gift_list == null || dataRes.gift_list.size() == 0) {
            if (this.Wx.size() == 0) {
                this.btt.setText("0");
                this.btu.setText("0");
                this.bty.setData(null);
                this.btq.setVisibility(8);
                this.btz.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mIsHost || !TbadkApplication.m251getInst().isGiftSwitchOn()) {
            this.btz.setVisibility(8);
        } else {
            this.btz.setVisibility(0);
        }
        if (dataRes.money_txt != null) {
            String str = "";
            if (!ay.aA(dataRes.money_txt.txt)) {
                str = String.valueOf(dataRes.money_txt.txt) + ">";
            }
            this.btv.setText(str);
            this.btw = dataRes.money_txt.url;
            this.btx = dataRes.money_txt.txt;
            if (TextUtils.isEmpty(dataRes.money_txt.txt) || TextUtils.isEmpty(this.btw)) {
                this.btv.setVisibility(8);
            }
        } else {
            this.btv.setVisibility(8);
        }
        if (dataRes.total_num.intValue() < 0) {
            this.btt.setText("0");
        } else {
            this.btt.setText(new StringBuilder().append(dataRes.total_num).toString());
        }
        if (dataRes.money.intValue() < 0) {
            this.btt.setText("0");
        } else {
            this.btu.setText(new StringBuilder().append(dataRes.money).toString());
        }
        if (dataRes.page != null) {
            if (dataRes.page.has_more.intValue() == 1) {
                this.btq.setVisibility(0);
            } else {
                this.btq.setVisibility(8);
            }
        }
        if (dataRes.gift_list != null) {
            if (!z) {
                this.Wx.clear();
                this.Wx.addAll(dataRes.gift_list);
            } else {
                this.Wx.addAll(dataRes.gift_list);
            }
        }
        this.bty.setData(this.Wx);
    }

    public void onChangeSkinType(int i) {
        this.btc.getLayoutMode().L(i == 1);
        this.btc.getLayoutMode().h(this.aFZ);
        this.btc.getLayoutMode().h(this.btp);
        this.btc.getLayoutMode().h(this.btq);
        this.aGJ.onChangeSkinType(i);
        this.btm.onChangeSkinType(i);
        this.Yc.bM(i);
    }

    public void VK() {
        this.bto.hN();
    }

    public void b(com.baidu.adp.widget.ListView.f fVar) {
        this.Yc.a(fVar);
    }

    public void g(u uVar) {
        this.bto.setVisibility(0);
        this.bto.hO();
        this.btm.a(uVar);
    }
}
