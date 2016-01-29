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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import com.baidu.tieba.personInfo.bf;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PersonInfoBaseGodView extends LinearLayout implements View.OnClickListener {
    private ViewEventCenter aWA;
    private UserIconBox ahJ;
    private boolean bDs;
    private View bcF;
    private View dcD;
    private View dcE;
    private View dcF;
    private TextView dcG;
    private TextView dcH;
    private TextView dcI;
    private View dcJ;
    private View dcK;
    private View dcL;
    private TextView dcM;
    private TextView dcN;
    private PersonInfoGodBarListView dcO;
    private ImageView dcP;
    private bf dcQ;
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
        this.bcF = inflate.findViewById(t.g.layout_blank_divider);
        this.dcG = (TextView) inflate.findViewById(t.g.user_sign);
        this.dcH = (TextView) inflate.findViewById(t.g.user_gender);
        this.dcI = (TextView) inflate.findViewById(t.g.user_age);
        this.dcM = (TextView) inflate.findViewById(t.g.user_city);
        this.dcF = inflate.findViewById(t.g.line_user_yinji);
        this.dcJ = inflate.findViewById(t.g.line_city);
        this.dcK = inflate.findViewById(t.g.line_gender);
        this.dcL = inflate.findViewById(t.g.line_age);
        this.ahJ = (UserIconBox) inflate.findViewById(t.g.user_icon);
        this.dcN = (TextView) inflate.findViewById(t.g.user_bar_age_num);
        this.dcO = (PersonInfoGodBarListView) inflate.findViewById(t.g.god_barlist_view);
        this.dcP = (ImageView) inflate.findViewById(t.g.god_barlist_icon);
        this.dcD = (LinearLayout) inflate.findViewById(t.g.layout_yinji);
        this.dcE = (LinearLayout) inflate.findViewById(t.g.layout_sign);
        this.ahJ.setOnClickListener(this);
        this.dcP.setOnClickListener(this);
    }

    public void a(bf bfVar, ViewEventCenter viewEventCenter) {
        if (bfVar != null) {
            this.dcQ = bfVar;
            this.bDs = bfVar.getIsSelf();
            this.aWA = viewEventCenter;
            auF();
            auE();
        }
    }

    private void auE() {
        PersonUserGodInfo avy;
        if (this.dcQ != null && (avy = this.dcQ.avy()) != null && avy.getForumGodList() != null) {
            this.dcO.setData(avy.getForumGodList());
        }
    }

    private void auF() {
        if (this.dcQ != null) {
            UserData userData = this.dcQ.getUserData();
            if (userData != null) {
                int sex = userData.getSex();
                if (sex == 1) {
                    this.dcH.setVisibility(0);
                    this.dcK.setVisibility(0);
                    this.dcH.setText(t.j.man);
                } else if (sex == 2) {
                    this.dcH.setVisibility(0);
                    this.dcK.setVisibility(0);
                    this.dcH.setText(t.j.woman);
                } else {
                    this.dcH.setVisibility(8);
                    this.dcK.setVisibility(8);
                }
                String intro = userData.getIntro();
                if (!TextUtils.isEmpty(intro)) {
                    this.dcG.setText(intro);
                    ar.b(this.dcG, t.d.cp_cont_f, 1);
                } else {
                    this.dcG.setText(t.j.no_person_sign);
                    ar.b(this.dcG, t.d.cp_cont_d, 1);
                }
                float a = com.baidu.adp.lib.h.b.a(userData.getTb_age(), 0.0f);
                if (a < 0.0f || a > 100.0f) {
                    a = 0.0f;
                }
                this.dcN.setText(String.valueOf(a) + this.mContext.getResources().getString(t.j.user_info_center_head_viewpager_god_tb_age));
                ArrayList<IconData> iconInfo = userData.getIconInfo();
                if (x.o(iconInfo) > 0) {
                    this.dcD.setVisibility(0);
                    this.dcF.setVisibility(0);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(t.e.ds34);
                    this.ahJ.a(iconInfo, 9, dimensionPixelSize, dimensionPixelSize, this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
                } else {
                    this.dcD.setVisibility(8);
                    this.dcF.setVisibility(8);
                }
            }
            PersonUserGodInfo avy = this.dcQ.avy();
            if (avy != null) {
                int age = avy.getAge();
                if (age < 1 || age > 100) {
                    this.dcI.setVisibility(8);
                    this.dcL.setVisibility(8);
                } else {
                    this.dcI.setVisibility(0);
                    this.dcL.setVisibility(0);
                    this.dcI.setText(this.mContext.getResources().getString(t.j.person_age, Integer.valueOf(age)));
                }
                String address = avy.getAddress();
                if (TextUtils.isEmpty(address)) {
                    this.dcM.setVisibility(8);
                    this.dcJ.setVisibility(8);
                    return;
                }
                this.dcM.setVisibility(0);
                this.dcJ.setVisibility(0);
                if (address.length() > 7) {
                    address = String.valueOf(address.substring(0, 7)) + "...";
                }
                this.dcM.setText(address);
            }
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        if (this.dcO != null) {
            this.dcO.f(tbPageContext);
        }
        ar.b(this.bcF, t.d.cp_cont_j, 1);
        ar.b(this.dcN, t.d.cp_cont_j, 1);
        ar.k(this.dcD, t.d.cp_bg_line_d);
        ar.k(this.dcE, t.d.cp_bg_line_d);
        ar.k(this.dcK, t.d.cp_bg_line_b);
        ar.k(this.dcL, t.d.cp_bg_line_b);
        ar.k(this.dcJ, t.d.cp_bg_line_b);
        ar.b(this.dcN, t.d.cp_cont_j, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ahJ) {
            if (this.aWA != null) {
                this.aWA.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
            }
        } else if (view == this.dcP && this.aWA != null) {
            this.aWA.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(5, null, null, null));
        }
    }
}
