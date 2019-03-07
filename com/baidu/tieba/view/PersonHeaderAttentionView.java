package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener dJa;
    private TextView fAB;
    private TextView gil;
    private TextView hMw;
    private g hUb;
    private TextView jim;
    private ImageView jin;
    private TextView jio;
    private TextView jip;
    private TextView jiq;
    private TextView jir;
    private View jis;
    private View jit;
    private View jiu;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.dJa = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jiv = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cZ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.hMw.getId() && id != PersonHeaderAttentionView.this.jim.getId()) {
                        if (id != PersonHeaderAttentionView.this.fAB.getId() && id != PersonHeaderAttentionView.this.jio.getId()) {
                            if (id == PersonHeaderAttentionView.this.jip.getId() || id == PersonHeaderAttentionView.this.jiq.getId()) {
                                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AM(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().als() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().als() != 2)) {
                                    PersonHeaderAttentionView.this.AM(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jiv.eHC = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jiv.eHC = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "9"));
                        this.jiv.eHC = 4;
                    }
                    if (PersonHeaderAttentionView.this.hUb != null) {
                        this.jiv.eHD = new Bundle();
                        this.jiv.eHD.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.hUb.a(view, this.jiv);
                    }
                }
            }
        };
        init(context);
        cmO();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.dJa = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jiv = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cZ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.hMw.getId() && id != PersonHeaderAttentionView.this.jim.getId()) {
                        if (id != PersonHeaderAttentionView.this.fAB.getId() && id != PersonHeaderAttentionView.this.jio.getId()) {
                            if (id == PersonHeaderAttentionView.this.jip.getId() || id == PersonHeaderAttentionView.this.jiq.getId()) {
                                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AM(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().als() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().als() != 2)) {
                                    PersonHeaderAttentionView.this.AM(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jiv.eHC = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jiv.eHC = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "9"));
                        this.jiv.eHC = 4;
                    }
                    if (PersonHeaderAttentionView.this.hUb != null) {
                        this.jiv.eHD = new Bundle();
                        this.jiv.eHD.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.hUb.a(view, this.jiv);
                    }
                }
            }
        };
        init(context);
        cmO();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.dJa = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jiv = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cZ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.hMw.getId() && id != PersonHeaderAttentionView.this.jim.getId()) {
                        if (id != PersonHeaderAttentionView.this.fAB.getId() && id != PersonHeaderAttentionView.this.jio.getId()) {
                            if (id == PersonHeaderAttentionView.this.jip.getId() || id == PersonHeaderAttentionView.this.jiq.getId()) {
                                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AM(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().als() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().als() != 2)) {
                                    PersonHeaderAttentionView.this.AM(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jiv.eHC = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jiv.eHC = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "9"));
                        this.jiv.eHC = 4;
                    }
                    if (PersonHeaderAttentionView.this.hUb != null) {
                        this.jiv.eHD = new Bundle();
                        this.jiv.eHD.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.hUb.a(view, this.jiv);
                    }
                }
            }
        };
        init(context);
        cmO();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.fAB = (TextView) findViewById(d.g.person_header_fans_num);
        this.jio = (TextView) findViewById(d.g.person_header_fans_des);
        this.jin = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.hMw = (TextView) findViewById(d.g.person_header_attention_num);
        this.jim = (TextView) findViewById(d.g.person_header_attention_des);
        this.jip = (TextView) findViewById(d.g.person_header_bar_num);
        this.jiq = (TextView) findViewById(d.g.person_header_bar_des);
        this.gil = (TextView) findViewById(d.g.person_header_thread_num);
        this.gil.setVisibility(8);
        this.jir = (TextView) findViewById(d.g.person_header_thread_des);
        this.jir.setVisibility(8);
        this.jis = findViewById(d.g.divider_for_fans_and_attention);
        this.jit = findViewById(d.g.divider_for_attention_and_bar);
        this.jiu = findViewById(d.g.divider_for_bar_and_thread);
        this.jiu.setVisibility(8);
    }

    private void cmO() {
        this.fAB.setOnClickListener(this.dJa);
        this.jio.setOnClickListener(this.dJa);
        this.hMw.setOnClickListener(this.dJa);
        this.jim.setOnClickListener(this.dJa);
        this.jip.setOnClickListener(this.dJa);
        this.jiq.setOnClickListener(this.dJa);
        this.gil.setOnClickListener(this.dJa);
        this.jir.setOnClickListener(this.dJa);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.hUb = gVar;
    }

    private void u(String str, String str2, String str3, String str4) {
        this.hMw.setText(str);
        this.fAB.setText(str2);
        this.jip.setText(str4);
        this.gil.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.hMw.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.fAB.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.jip.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.gil.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        u(ap.ay(this.mUserData.getConcernNum()), ap.ay(this.mUserData.getFansNum()), ap.ay(this.mUserData.getPosts_num()), ap.ay(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.d(this.hMw, d.C0236d.cp_cont_b, 1);
            al.d(this.jim, d.C0236d.cp_cont_j, 1);
            al.d(this.fAB, d.C0236d.cp_cont_b, 1);
            al.d(this.jio, d.C0236d.cp_cont_j, 1);
            al.c(this.jin, d.f.icon_news_down_bar_one);
            al.d(this.jip, d.C0236d.cp_cont_b, 1);
            al.d(this.jiq, d.C0236d.cp_cont_j, 1);
            al.d(this.gil, d.C0236d.cp_cont_b, 1);
            al.d(this.jir, d.C0236d.cp_cont_j, 1);
            al.l(this.jis, d.C0236d.cp_bg_line_b);
            al.l(this.jit, d.C0236d.cp_bg_line_b);
            al.l(this.jiu, d.C0236d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AM(int i) {
        BdToast.c(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), ap.hy(i)), d.f.icon_toast_game_error).abh();
    }

    @Override // com.baidu.tieba.view.e
    public void qQ(boolean z) {
        if (this.jin != null) {
            if (z) {
                this.jin.setVisibility(0);
            } else {
                this.jin.setVisibility(8);
            }
        }
    }
}
