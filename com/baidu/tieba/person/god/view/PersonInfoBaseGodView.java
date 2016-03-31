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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import com.baidu.tieba.personInfo.bf;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PersonInfoBaseGodView extends LinearLayout implements View.OnClickListener {
    private UserIconBox ahO;
    private boolean bIP;
    private ViewEventCenter bbj;
    private View bhq;
    private View dxf;
    private View dxg;
    private View dxh;
    private TextView dxi;
    private TextView dxj;
    private TextView dxk;
    private View dxl;
    private View dxm;
    private View dxn;
    private TextView dxo;
    private TextView dxp;
    private PersonInfoGodBarListView dxq;
    private ImageView dxr;
    private bf dxs;
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
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.personinfo_base_god_view, this);
        this.bhq = inflate.findViewById(t.g.layout_blank_divider);
        this.dxi = (TextView) inflate.findViewById(t.g.user_sign);
        this.dxj = (TextView) inflate.findViewById(t.g.user_gender);
        this.dxk = (TextView) inflate.findViewById(t.g.user_age);
        this.dxo = (TextView) inflate.findViewById(t.g.user_city);
        this.dxh = inflate.findViewById(t.g.line_user_yinji);
        this.dxl = inflate.findViewById(t.g.line_city);
        this.dxm = inflate.findViewById(t.g.line_gender);
        this.dxn = inflate.findViewById(t.g.line_age);
        this.ahO = (UserIconBox) inflate.findViewById(t.g.user_icon);
        this.dxp = (TextView) inflate.findViewById(t.g.user_bar_age_num);
        this.dxq = (PersonInfoGodBarListView) inflate.findViewById(t.g.god_barlist_view);
        this.dxr = (ImageView) inflate.findViewById(t.g.god_barlist_icon);
        this.dxf = (LinearLayout) inflate.findViewById(t.g.layout_yinji);
        this.dxg = (LinearLayout) inflate.findViewById(t.g.layout_sign);
        this.ahO.setOnClickListener(this);
        this.dxr.setOnClickListener(this);
    }

    public void a(bf bfVar, ViewEventCenter viewEventCenter) {
        if (bfVar != null) {
            this.dxs = bfVar;
            this.bIP = bfVar.getIsSelf();
            this.bbj = viewEventCenter;
            aCl();
            aCk();
        }
    }

    private void aCk() {
        PersonUserGodInfo aDd;
        if (this.dxs != null && (aDd = this.dxs.aDd()) != null && aDd.getForumGodList() != null) {
            this.dxq.setData(aDd.getForumGodList());
        }
    }

    private void aCl() {
        if (this.dxs != null) {
            UserData userData = this.dxs.getUserData();
            if (userData != null) {
                int sex = userData.getSex();
                if (sex == 1) {
                    this.dxj.setVisibility(0);
                    this.dxm.setVisibility(0);
                    this.dxj.setText(t.j.man);
                } else if (sex == 2) {
                    this.dxj.setVisibility(0);
                    this.dxm.setVisibility(0);
                    this.dxj.setText(t.j.woman);
                } else {
                    this.dxj.setVisibility(8);
                    this.dxm.setVisibility(8);
                }
                String intro = userData.getIntro();
                if (!TextUtils.isEmpty(intro)) {
                    this.dxi.setText(intro);
                    at.b(this.dxi, t.d.cp_cont_f, 1);
                } else {
                    this.dxi.setText(t.j.no_person_sign);
                    at.b(this.dxi, t.d.cp_cont_d, 1);
                }
                float a = com.baidu.adp.lib.h.b.a(userData.getTb_age(), 0.0f);
                if (a < 0.0f || a > 100.0f) {
                    a = 0.0f;
                }
                this.dxp.setText(String.valueOf(a) + this.mContext.getResources().getString(t.j.user_info_center_head_viewpager_god_tb_age));
                ArrayList<IconData> iconInfo = userData.getIconInfo();
                if (y.p(iconInfo) > 0) {
                    this.dxf.setVisibility(0);
                    this.dxh.setVisibility(0);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(t.e.ds34);
                    this.ahO.a(iconInfo, 9, dimensionPixelSize, dimensionPixelSize, this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
                } else {
                    this.dxf.setVisibility(8);
                    this.dxh.setVisibility(8);
                }
            }
            PersonUserGodInfo aDd = this.dxs.aDd();
            if (aDd != null) {
                int age = aDd.getAge();
                if (age < 1 || age > 100) {
                    this.dxk.setVisibility(8);
                    this.dxn.setVisibility(8);
                } else {
                    this.dxk.setVisibility(0);
                    this.dxn.setVisibility(0);
                    this.dxk.setText(this.mContext.getResources().getString(t.j.person_age, Integer.valueOf(age)));
                }
                String address = aDd.getAddress();
                if (TextUtils.isEmpty(address)) {
                    this.dxo.setVisibility(8);
                    this.dxl.setVisibility(8);
                    return;
                }
                this.dxo.setVisibility(0);
                this.dxl.setVisibility(0);
                if (address.length() > 7) {
                    address = String.valueOf(address.substring(0, 7)) + "...";
                }
                this.dxo.setText(address);
            }
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        if (this.dxq != null) {
            this.dxq.f(tbPageContext);
        }
        at.b(this.bhq, t.d.cp_cont_j, 1);
        at.b(this.dxp, t.d.cp_cont_j, 1);
        at.k(this.dxf, t.d.cp_bg_line_d);
        at.k(this.dxg, t.d.cp_bg_line_d);
        at.k(this.dxm, t.d.cp_bg_line_b);
        at.k(this.dxn, t.d.cp_bg_line_b);
        at.k(this.dxl, t.d.cp_bg_line_b);
        at.b(this.dxp, t.d.cp_cont_j, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ahO) {
            if (this.bbj != null) {
                this.bbj.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
            }
        } else if (view == this.dxr && this.bbj != null) {
            this.bbj.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(5, null, null, null));
        }
    }
}
