package com.baidu.tieba.person.god.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import com.baidu.tieba.personInfo.bn;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PersonInfoBaseGodView extends LinearLayout implements View.OnClickListener {
    private UserIconBox aeU;
    private View bBv;
    private ViewEventCenter bgJ;
    private boolean ciS;
    private View esV;
    private View esW;
    private View esX;
    private TextView esY;
    private TextView esZ;
    private TextView eta;
    private View etb;
    private View etd;
    private View ete;
    private TextView etf;
    private TextView etg;
    private PersonInfoGodBarListView eth;
    private ImageView eti;
    private bn etj;
    private Context mContext;

    public PersonInfoBaseGodView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public PersonInfoBaseGodView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(u.h.personinfo_base_god_view, this);
        this.bBv = inflate.findViewById(u.g.layout_blank_divider);
        this.esY = (TextView) inflate.findViewById(u.g.user_sign);
        this.esZ = (TextView) inflate.findViewById(u.g.user_gender);
        this.eta = (TextView) inflate.findViewById(u.g.user_age);
        this.etf = (TextView) inflate.findViewById(u.g.user_city);
        this.esX = inflate.findViewById(u.g.line_user_yinji);
        this.etb = inflate.findViewById(u.g.line_city);
        this.etd = inflate.findViewById(u.g.line_gender);
        this.ete = inflate.findViewById(u.g.line_age);
        this.aeU = (UserIconBox) inflate.findViewById(u.g.user_icon);
        this.etg = (TextView) inflate.findViewById(u.g.user_bar_age_num);
        this.eth = (PersonInfoGodBarListView) inflate.findViewById(u.g.god_barlist_view);
        this.eti = (ImageView) inflate.findViewById(u.g.god_barlist_icon);
        this.esV = (LinearLayout) inflate.findViewById(u.g.layout_yinji);
        this.esW = (LinearLayout) inflate.findViewById(u.g.layout_sign);
        this.aeU.setOnClickListener(this);
        this.eti.setOnClickListener(this);
    }

    public void a(bn bnVar, ViewEventCenter viewEventCenter) {
        if (bnVar != null) {
            this.etj = bnVar;
            this.ciS = bnVar.getIsSelf();
            this.bgJ = viewEventCenter;
            aOc();
            aOb();
        }
    }

    private void aOb() {
        PersonUserGodInfo aPB;
        if (this.etj != null && (aPB = this.etj.aPB()) != null && aPB.getForumGodList() != null) {
            this.eth.setData(aPB.getForumGodList());
        }
    }

    private void aOc() {
        if (this.etj != null) {
            UserData userData = this.etj.getUserData();
            if (userData != null) {
                int sex = userData.getSex();
                if (sex == 1) {
                    this.esZ.setVisibility(0);
                    this.etd.setVisibility(0);
                    this.esZ.setText(u.j.man);
                } else if (sex == 2) {
                    this.esZ.setVisibility(0);
                    this.etd.setVisibility(0);
                    this.esZ.setText(u.j.woman);
                } else {
                    this.esZ.setVisibility(8);
                    this.etd.setVisibility(8);
                }
                String intro = userData.getIntro();
                if (!TextUtils.isEmpty(intro)) {
                    this.esY.setText(intro);
                    av.c(this.esY, u.d.cp_cont_f, 1);
                } else {
                    this.esY.setText(u.j.no_person_sign);
                    av.c(this.esY, u.d.cp_cont_d, 1);
                }
                float b = com.baidu.adp.lib.h.b.b(userData.getTb_age(), 0.0f);
                if (b < 0.0f || b > 100.0f) {
                    b = 0.0f;
                }
                this.etg.setText(String.valueOf(b) + this.mContext.getResources().getString(u.j.user_info_center_head_viewpager_god_tb_age));
                ArrayList<IconData> iconInfo = userData.getIconInfo();
                if (y.s(iconInfo) > 0) {
                    this.esV.setVisibility(0);
                    this.esX.setVisibility(0);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(u.e.ds34);
                    this.aeU.a(iconInfo, 9, dimensionPixelSize, dimensionPixelSize, this.mContext.getResources().getDimensionPixelSize(u.e.ds10), true);
                } else {
                    this.esV.setVisibility(8);
                    this.esX.setVisibility(8);
                }
            }
            PersonUserGodInfo aPB = this.etj.aPB();
            if (aPB != null) {
                int age = aPB.getAge();
                if (age < 1 || age > 100) {
                    this.eta.setVisibility(8);
                    this.ete.setVisibility(8);
                } else {
                    this.eta.setVisibility(0);
                    this.ete.setVisibility(0);
                    this.eta.setText(this.mContext.getResources().getString(u.j.person_age, Integer.valueOf(age)));
                }
                String address = aPB.getAddress();
                if (TextUtils.isEmpty(address)) {
                    this.etf.setVisibility(8);
                    this.etb.setVisibility(8);
                    return;
                }
                this.etf.setVisibility(0);
                this.etb.setVisibility(0);
                if (address.length() > 7) {
                    address = String.valueOf(address.substring(0, 7)) + "...";
                }
                this.etf.setText(address);
            }
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        if (this.eth != null) {
            this.eth.n(tbPageContext);
        }
        av.c(this.bBv, u.d.cp_cont_j, 1);
        av.c(this.etg, u.d.cp_cont_j, 1);
        av.k(this.esV, u.d.cp_bg_line_d);
        av.k(this.esW, u.d.cp_bg_line_d);
        av.k(this.etd, u.d.cp_bg_line_b);
        av.k(this.ete, u.d.cp_bg_line_b);
        av.k(this.etb, u.d.cp_bg_line_b);
        av.c(this.etg, u.d.cp_cont_j, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aeU) {
            if (this.bgJ != null) {
                this.bgJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
            }
        } else if (view == this.eti && this.bgJ != null) {
            this.bgJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(5, null, null, null));
        }
    }
}
