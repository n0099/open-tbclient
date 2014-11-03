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
import com.baidu.tbadk.core.util.az;
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
    View.OnClickListener If;
    private List<GiftList> WB;
    private y Yg;
    private NavigationBar aGT;
    private View aGj;
    AdapterView.OnItemClickListener aJg;
    private NoNetworkView btB;
    private BdListView btC;
    private View btD;
    private View btE;
    private View btF;
    private aa btG;
    private TextView btH;
    private TextView btI;
    private TextView btJ;
    private String btK;
    private String btL;
    private g btM;
    private RelativeLayout btN;
    private TextView btO;
    private View btP;
    private com.baidu.tbadk.widget.i btQ;
    private MyGiftListActivity btr;
    private boolean mIsHost;

    public k(MyGiftListActivity myGiftListActivity, aa aaVar, boolean z) {
        super(myGiftListActivity);
        this.Yg = null;
        this.aJg = new l(this);
        this.If = new m(this);
        this.btr = myGiftListActivity;
        this.mIsHost = z;
        this.WB = new ArrayList();
        this.btG = aaVar;
        nu();
        VL();
        if (this.mIsHost || !TbadkApplication.m251getInst().isGiftSwitchOn()) {
            this.btN.setVisibility(8);
        } else {
            this.btN.setVisibility(0);
        }
        this.btQ = new com.baidu.tbadk.widget.i(this.btr);
    }

    private void nu() {
        this.btr.setContentView(w.my_gift_list_activity);
        this.btK = null;
        this.aGj = this.btr.findViewById(v.root);
        this.btC = (BdListView) this.aGj.findViewById(v.list_view);
        this.aGT = (NavigationBar) this.aGj.findViewById(v.navigation_bar);
        String format = String.format(this.btr.getString(com.baidu.tieba.y.he_gift_title), this.btr.VJ());
        if (this.mIsHost) {
            this.aGT.setTitleText(com.baidu.tieba.y.my_gift_list);
        } else {
            this.aGT.setTitleText(format);
        }
        this.aGT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.btB = (NoNetworkView) this.aGj.findViewById(v.no_networkview);
        this.btD = com.baidu.adp.lib.g.b.ek().a(this.btr, w.my_gift_list_head, null, false);
        this.btD.setVisibility(8);
        this.btH = (TextView) this.btD.findViewById(v.gift_total);
        this.btI = (TextView) this.btD.findViewById(v.dou_num);
        this.btJ = (TextView) this.btD.findViewById(v.t_use);
        this.btJ.setOnClickListener(this.If);
        this.btE = com.baidu.adp.lib.g.b.ek().a(this.btr, w.my_gift_list_footer, null, false);
        this.btF = this.btE.findViewById(v.gift_footer_lay);
        if (this.mIsHost) {
            this.btC.addHeaderView(this.btD);
        } else if (TbadkApplication.m251getInst().isGiftSwitchOn()) {
            this.btE.setPadding(0, 0, 0, com.baidu.adp.lib.util.m.c(this.btr, t.ds156));
        }
        this.btC.addFooterView(this.btE);
        this.btM = new g(this.btr, this.mIsHost);
        this.btC.setAdapter((ListAdapter) this.btM);
        this.Yg = new y(this.btr);
        this.btC.setPullRefresh(this.Yg);
        this.btC.setOnSrollToBottomListener(this.btG);
        this.btC.setOnItemClickListener(this.aJg);
    }

    private void VL() {
        this.btN = (RelativeLayout) this.btr.findViewById(v.gift_relation_ll);
        this.btO = (TextView) this.btr.findViewById(v.gift_relation_text);
        this.btO.setOnClickListener(this.btr.VH());
        this.btP = this.btr.findViewById(v.his_gift_line);
        if (!this.mIsHost && TbadkApplication.m251getInst().isGiftSwitchOn()) {
            this.btC.setOnScrollListener(new n(this));
        }
    }

    public View VM() {
        return this.btF;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0100: IGET  (r2v0 java.lang.Integer A[REMOVE]) = (r6v0 tbclient.GetGiftMyList.DataRes) tbclient.GetGiftMyList.DataRes.total_num java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0115: IGET  (r2v1 java.lang.Integer A[REMOVE]) = (r6v0 tbclient.GetGiftMyList.DataRes) tbclient.GetGiftMyList.DataRes.money java.lang.Integer)] */
    public void a(DataRes dataRes, boolean z) {
        this.btD.setVisibility(0);
        if (dataRes == null || dataRes.gift_list == null || dataRes.gift_list.size() == 0) {
            if (this.WB.size() == 0) {
                this.btH.setText("0");
                this.btI.setText("0");
                this.btM.setData(null);
                this.btE.setVisibility(8);
                this.btN.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mIsHost || !TbadkApplication.m251getInst().isGiftSwitchOn()) {
            this.btN.setVisibility(8);
        } else {
            this.btN.setVisibility(0);
        }
        if (dataRes.money_txt != null) {
            String str = "";
            if (!az.aA(dataRes.money_txt.txt)) {
                str = String.valueOf(dataRes.money_txt.txt) + ">";
            }
            this.btJ.setText(str);
            this.btK = dataRes.money_txt.url;
            this.btL = dataRes.money_txt.txt;
            if (TextUtils.isEmpty(dataRes.money_txt.txt) || TextUtils.isEmpty(this.btK)) {
                this.btJ.setVisibility(8);
            }
        } else {
            this.btJ.setVisibility(8);
        }
        if (dataRes.total_num.intValue() < 0) {
            this.btH.setText("0");
        } else {
            this.btH.setText(new StringBuilder().append(dataRes.total_num).toString());
        }
        if (dataRes.money.intValue() < 0) {
            this.btH.setText("0");
        } else {
            this.btI.setText(new StringBuilder().append(dataRes.money).toString());
        }
        if (dataRes.page != null) {
            if (dataRes.page.has_more.intValue() == 1) {
                this.btE.setVisibility(0);
            } else {
                this.btE.setVisibility(8);
            }
        }
        if (dataRes.gift_list != null) {
            if (!z) {
                this.WB.clear();
                this.WB.addAll(dataRes.gift_list);
            } else {
                this.WB.addAll(dataRes.gift_list);
            }
        }
        this.btM.setData(this.WB);
    }

    public void onChangeSkinType(int i) {
        this.btr.getLayoutMode().L(i == 1);
        this.btr.getLayoutMode().h(this.aGj);
        this.btr.getLayoutMode().h(this.btD);
        this.btr.getLayoutMode().h(this.btE);
        this.aGT.onChangeSkinType(i);
        this.btB.onChangeSkinType(i);
        this.Yg.bM(i);
    }

    public void VN() {
        this.btC.hN();
    }

    public void b(com.baidu.adp.widget.ListView.f fVar) {
        this.Yg.a(fVar);
    }

    public void g(u uVar) {
        this.btC.setVisibility(0);
        this.btC.hO();
        this.btB.a(uVar);
    }
}
