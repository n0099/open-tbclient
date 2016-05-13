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
import com.baidu.tieba.personInfo.bg;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PersonInfoBaseGodView extends LinearLayout implements View.OnClickListener {
    private ViewEventCenter aXs;
    private UserIconBox adI;
    private boolean bIW;
    private View bdg;
    private View dAl;
    private View dAm;
    private View dAn;
    private TextView dAo;
    private TextView dAp;
    private TextView dAq;
    private View dAr;
    private View dAs;
    private View dAt;
    private TextView dAu;
    private TextView dAv;
    private PersonInfoGodBarListView dAw;
    private ImageView dAx;
    private bg dAy;
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
        this.bdg = inflate.findViewById(t.g.layout_blank_divider);
        this.dAo = (TextView) inflate.findViewById(t.g.user_sign);
        this.dAp = (TextView) inflate.findViewById(t.g.user_gender);
        this.dAq = (TextView) inflate.findViewById(t.g.user_age);
        this.dAu = (TextView) inflate.findViewById(t.g.user_city);
        this.dAn = inflate.findViewById(t.g.line_user_yinji);
        this.dAr = inflate.findViewById(t.g.line_city);
        this.dAs = inflate.findViewById(t.g.line_gender);
        this.dAt = inflate.findViewById(t.g.line_age);
        this.adI = (UserIconBox) inflate.findViewById(t.g.user_icon);
        this.dAv = (TextView) inflate.findViewById(t.g.user_bar_age_num);
        this.dAw = (PersonInfoGodBarListView) inflate.findViewById(t.g.god_barlist_view);
        this.dAx = (ImageView) inflate.findViewById(t.g.god_barlist_icon);
        this.dAl = (LinearLayout) inflate.findViewById(t.g.layout_yinji);
        this.dAm = (LinearLayout) inflate.findViewById(t.g.layout_sign);
        this.adI.setOnClickListener(this);
        this.dAx.setOnClickListener(this);
    }

    public void a(bg bgVar, ViewEventCenter viewEventCenter) {
        if (bgVar != null) {
            this.dAy = bgVar;
            this.bIW = bgVar.getIsSelf();
            this.aXs = viewEventCenter;
            aCF();
            aCE();
        }
    }

    private void aCE() {
        PersonUserGodInfo aDB;
        if (this.dAy != null && (aDB = this.dAy.aDB()) != null && aDB.getForumGodList() != null) {
            this.dAw.setData(aDB.getForumGodList());
        }
    }

    private void aCF() {
        if (this.dAy != null) {
            UserData userData = this.dAy.getUserData();
            if (userData != null) {
                int sex = userData.getSex();
                if (sex == 1) {
                    this.dAp.setVisibility(0);
                    this.dAs.setVisibility(0);
                    this.dAp.setText(t.j.man);
                } else if (sex == 2) {
                    this.dAp.setVisibility(0);
                    this.dAs.setVisibility(0);
                    this.dAp.setText(t.j.woman);
                } else {
                    this.dAp.setVisibility(8);
                    this.dAs.setVisibility(8);
                }
                String intro = userData.getIntro();
                if (!TextUtils.isEmpty(intro)) {
                    this.dAo.setText(intro);
                    at.c(this.dAo, t.d.cp_cont_f, 1);
                } else {
                    this.dAo.setText(t.j.no_person_sign);
                    at.c(this.dAo, t.d.cp_cont_d, 1);
                }
                float a = com.baidu.adp.lib.h.b.a(userData.getTb_age(), 0.0f);
                if (a < 0.0f || a > 100.0f) {
                    a = 0.0f;
                }
                this.dAv.setText(String.valueOf(a) + this.mContext.getResources().getString(t.j.user_info_center_head_viewpager_god_tb_age));
                ArrayList<IconData> iconInfo = userData.getIconInfo();
                if (y.r(iconInfo) > 0) {
                    this.dAl.setVisibility(0);
                    this.dAn.setVisibility(0);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(t.e.ds34);
                    this.adI.a(iconInfo, 9, dimensionPixelSize, dimensionPixelSize, this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
                } else {
                    this.dAl.setVisibility(8);
                    this.dAn.setVisibility(8);
                }
            }
            PersonUserGodInfo aDB = this.dAy.aDB();
            if (aDB != null) {
                int age = aDB.getAge();
                if (age < 1 || age > 100) {
                    this.dAq.setVisibility(8);
                    this.dAt.setVisibility(8);
                } else {
                    this.dAq.setVisibility(0);
                    this.dAt.setVisibility(0);
                    this.dAq.setText(this.mContext.getResources().getString(t.j.person_age, Integer.valueOf(age)));
                }
                String address = aDB.getAddress();
                if (TextUtils.isEmpty(address)) {
                    this.dAu.setVisibility(8);
                    this.dAr.setVisibility(8);
                    return;
                }
                this.dAu.setVisibility(0);
                this.dAr.setVisibility(0);
                if (address.length() > 7) {
                    address = String.valueOf(address.substring(0, 7)) + "...";
                }
                this.dAu.setText(address);
            }
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        if (this.dAw != null) {
            this.dAw.g(tbPageContext);
        }
        at.c(this.bdg, t.d.cp_cont_j, 1);
        at.c(this.dAv, t.d.cp_cont_j, 1);
        at.k(this.dAl, t.d.cp_bg_line_d);
        at.k(this.dAm, t.d.cp_bg_line_d);
        at.k(this.dAs, t.d.cp_bg_line_b);
        at.k(this.dAt, t.d.cp_bg_line_b);
        at.k(this.dAr, t.d.cp_bg_line_b);
        at.c(this.dAv, t.d.cp_cont_j, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.adI) {
            if (this.aXs != null) {
                this.aXs.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
            }
        } else if (view == this.dAx && this.aXs != null) {
            this.aXs.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(5, null, null, null));
        }
    }
}
