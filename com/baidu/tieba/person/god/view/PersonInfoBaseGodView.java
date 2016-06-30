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
import com.baidu.tieba.personInfo.bp;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PersonInfoBaseGodView extends LinearLayout implements View.OnClickListener {
    private UserIconBox aeg;
    private ViewEventCenter bfx;
    private View bzh;
    private boolean cgJ;
    private View eiR;
    private View eiS;
    private View eiT;
    private TextView eiU;
    private TextView eiV;
    private TextView eiW;
    private View eiX;
    private View eiY;
    private View eiZ;
    private TextView eja;
    private TextView ejb;
    private PersonInfoGodBarListView ejc;
    private ImageView ejd;
    private bp eje;
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
        this.bzh = inflate.findViewById(u.g.layout_blank_divider);
        this.eiU = (TextView) inflate.findViewById(u.g.user_sign);
        this.eiV = (TextView) inflate.findViewById(u.g.user_gender);
        this.eiW = (TextView) inflate.findViewById(u.g.user_age);
        this.eja = (TextView) inflate.findViewById(u.g.user_city);
        this.eiT = inflate.findViewById(u.g.line_user_yinji);
        this.eiX = inflate.findViewById(u.g.line_city);
        this.eiY = inflate.findViewById(u.g.line_gender);
        this.eiZ = inflate.findViewById(u.g.line_age);
        this.aeg = (UserIconBox) inflate.findViewById(u.g.user_icon);
        this.ejb = (TextView) inflate.findViewById(u.g.user_bar_age_num);
        this.ejc = (PersonInfoGodBarListView) inflate.findViewById(u.g.god_barlist_view);
        this.ejd = (ImageView) inflate.findViewById(u.g.god_barlist_icon);
        this.eiR = (LinearLayout) inflate.findViewById(u.g.layout_yinji);
        this.eiS = (LinearLayout) inflate.findViewById(u.g.layout_sign);
        this.aeg.setOnClickListener(this);
        this.ejd.setOnClickListener(this);
    }

    public void a(bp bpVar, ViewEventCenter viewEventCenter) {
        if (bpVar != null) {
            this.eje = bpVar;
            this.cgJ = bpVar.getIsSelf();
            this.bfx = viewEventCenter;
            aLz();
            aLy();
        }
    }

    private void aLy() {
        PersonUserGodInfo aMw;
        if (this.eje != null && (aMw = this.eje.aMw()) != null && aMw.getForumGodList() != null) {
            this.ejc.setData(aMw.getForumGodList());
        }
    }

    private void aLz() {
        if (this.eje != null) {
            UserData userData = this.eje.getUserData();
            if (userData != null) {
                int sex = userData.getSex();
                if (sex == 1) {
                    this.eiV.setVisibility(0);
                    this.eiY.setVisibility(0);
                    this.eiV.setText(u.j.man);
                } else if (sex == 2) {
                    this.eiV.setVisibility(0);
                    this.eiY.setVisibility(0);
                    this.eiV.setText(u.j.woman);
                } else {
                    this.eiV.setVisibility(8);
                    this.eiY.setVisibility(8);
                }
                String intro = userData.getIntro();
                if (!TextUtils.isEmpty(intro)) {
                    this.eiU.setText(intro);
                    av.c(this.eiU, u.d.cp_cont_f, 1);
                } else {
                    this.eiU.setText(u.j.no_person_sign);
                    av.c(this.eiU, u.d.cp_cont_d, 1);
                }
                float a = com.baidu.adp.lib.h.b.a(userData.getTb_age(), 0.0f);
                if (a < 0.0f || a > 100.0f) {
                    a = 0.0f;
                }
                this.ejb.setText(String.valueOf(a) + this.mContext.getResources().getString(u.j.user_info_center_head_viewpager_god_tb_age));
                ArrayList<IconData> iconInfo = userData.getIconInfo();
                if (y.s(iconInfo) > 0) {
                    this.eiR.setVisibility(0);
                    this.eiT.setVisibility(0);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(u.e.ds34);
                    this.aeg.a(iconInfo, 9, dimensionPixelSize, dimensionPixelSize, this.mContext.getResources().getDimensionPixelSize(u.e.ds10), true);
                } else {
                    this.eiR.setVisibility(8);
                    this.eiT.setVisibility(8);
                }
            }
            PersonUserGodInfo aMw = this.eje.aMw();
            if (aMw != null) {
                int age = aMw.getAge();
                if (age < 1 || age > 100) {
                    this.eiW.setVisibility(8);
                    this.eiZ.setVisibility(8);
                } else {
                    this.eiW.setVisibility(0);
                    this.eiZ.setVisibility(0);
                    this.eiW.setText(this.mContext.getResources().getString(u.j.person_age, Integer.valueOf(age)));
                }
                String address = aMw.getAddress();
                if (TextUtils.isEmpty(address)) {
                    this.eja.setVisibility(8);
                    this.eiX.setVisibility(8);
                    return;
                }
                this.eja.setVisibility(0);
                this.eiX.setVisibility(0);
                if (address.length() > 7) {
                    address = String.valueOf(address.substring(0, 7)) + "...";
                }
                this.eja.setText(address);
            }
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        if (this.ejc != null) {
            this.ejc.n(tbPageContext);
        }
        av.c(this.bzh, u.d.cp_cont_j, 1);
        av.c(this.ejb, u.d.cp_cont_j, 1);
        av.k(this.eiR, u.d.cp_bg_line_d);
        av.k(this.eiS, u.d.cp_bg_line_d);
        av.k(this.eiY, u.d.cp_bg_line_b);
        av.k(this.eiZ, u.d.cp_bg_line_b);
        av.k(this.eiX, u.d.cp_bg_line_b);
        av.c(this.ejb, u.d.cp_cont_j, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aeg) {
            if (this.bfx != null) {
                this.bfx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
            }
        } else if (view == this.ejd && this.bfx != null) {
            this.bfx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(5, null, null, null));
        }
    }
}
