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
    private View.OnClickListener dIp;
    private TextView fAo;
    private TextView ghY;
    private TextView hMe;
    private g hTJ;
    private TextView jin;
    private ImageView jio;
    private TextView jip;
    private TextView jiq;
    private TextView jir;
    private TextView jis;
    private View jit;
    private View jiu;
    private View jiv;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.dIp = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jiw = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cZ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.hMe.getId() && id != PersonHeaderAttentionView.this.jin.getId()) {
                        if (id != PersonHeaderAttentionView.this.fAo.getId() && id != PersonHeaderAttentionView.this.jip.getId()) {
                            if (id == PersonHeaderAttentionView.this.jiq.getId() || id == PersonHeaderAttentionView.this.jir.getId()) {
                                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AJ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().alo() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().alo() != 2)) {
                                    PersonHeaderAttentionView.this.AJ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jiw.eHl = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jiw.eHl = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "9"));
                        this.jiw.eHl = 4;
                    }
                    if (PersonHeaderAttentionView.this.hTJ != null) {
                        this.jiw.eHm = new Bundle();
                        this.jiw.eHm.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.hTJ.a(view, this.jiw);
                    }
                }
            }
        };
        init(context);
        cmZ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.dIp = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jiw = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cZ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.hMe.getId() && id != PersonHeaderAttentionView.this.jin.getId()) {
                        if (id != PersonHeaderAttentionView.this.fAo.getId() && id != PersonHeaderAttentionView.this.jip.getId()) {
                            if (id == PersonHeaderAttentionView.this.jiq.getId() || id == PersonHeaderAttentionView.this.jir.getId()) {
                                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AJ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().alo() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().alo() != 2)) {
                                    PersonHeaderAttentionView.this.AJ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jiw.eHl = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jiw.eHl = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "9"));
                        this.jiw.eHl = 4;
                    }
                    if (PersonHeaderAttentionView.this.hTJ != null) {
                        this.jiw.eHm = new Bundle();
                        this.jiw.eHm.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.hTJ.a(view, this.jiw);
                    }
                }
            }
        };
        init(context);
        cmZ();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.dIp = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jiw = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.cZ(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.hMe.getId() && id != PersonHeaderAttentionView.this.jin.getId()) {
                        if (id != PersonHeaderAttentionView.this.fAo.getId() && id != PersonHeaderAttentionView.this.jip.getId()) {
                            if (id == PersonHeaderAttentionView.this.jiq.getId() || id == PersonHeaderAttentionView.this.jir.getId()) {
                                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.AJ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().alo() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().alo() != 2)) {
                                    PersonHeaderAttentionView.this.AJ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jiw.eHl = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jiw.eHl = 5;
                        }
                    } else {
                        TiebaStatic.log(new am("c12502").bJ("obj_locate", "9"));
                        this.jiw.eHl = 4;
                    }
                    if (PersonHeaderAttentionView.this.hTJ != null) {
                        this.jiw.eHm = new Bundle();
                        this.jiw.eHm.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.hTJ.a(view, this.jiw);
                    }
                }
            }
        };
        init(context);
        cmZ();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.fAo = (TextView) findViewById(d.g.person_header_fans_num);
        this.jip = (TextView) findViewById(d.g.person_header_fans_des);
        this.jio = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.hMe = (TextView) findViewById(d.g.person_header_attention_num);
        this.jin = (TextView) findViewById(d.g.person_header_attention_des);
        this.jiq = (TextView) findViewById(d.g.person_header_bar_num);
        this.jir = (TextView) findViewById(d.g.person_header_bar_des);
        this.ghY = (TextView) findViewById(d.g.person_header_thread_num);
        this.ghY.setVisibility(8);
        this.jis = (TextView) findViewById(d.g.person_header_thread_des);
        this.jis.setVisibility(8);
        this.jit = findViewById(d.g.divider_for_fans_and_attention);
        this.jiu = findViewById(d.g.divider_for_attention_and_bar);
        this.jiv = findViewById(d.g.divider_for_bar_and_thread);
        this.jiv.setVisibility(8);
    }

    private void cmZ() {
        this.fAo.setOnClickListener(this.dIp);
        this.jip.setOnClickListener(this.dIp);
        this.hMe.setOnClickListener(this.dIp);
        this.jin.setOnClickListener(this.dIp);
        this.jiq.setOnClickListener(this.dIp);
        this.jir.setOnClickListener(this.dIp);
        this.ghY.setOnClickListener(this.dIp);
        this.jis.setOnClickListener(this.dIp);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.hTJ = gVar;
    }

    private void u(String str, String str2, String str3, String str4) {
        this.hMe.setText(str);
        this.fAo.setText(str2);
        this.jiq.setText(str4);
        this.ghY.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.hMe.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.fAo.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.jiq.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.ghY.setTextSize(0, l.h(this.mContext, d.e.ds32));
        }
        u(ap.ay(this.mUserData.getConcernNum()), ap.ay(this.mUserData.getFansNum()), ap.ay(this.mUserData.getPosts_num()), ap.ay(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.d(this.hMe, d.C0277d.cp_cont_b, 1);
            al.d(this.jin, d.C0277d.cp_cont_j, 1);
            al.d(this.fAo, d.C0277d.cp_cont_b, 1);
            al.d(this.jip, d.C0277d.cp_cont_j, 1);
            al.c(this.jio, d.f.icon_news_down_bar_one);
            al.d(this.jiq, d.C0277d.cp_cont_b, 1);
            al.d(this.jir, d.C0277d.cp_cont_j, 1);
            al.d(this.ghY, d.C0277d.cp_cont_b, 1);
            al.d(this.jis, d.C0277d.cp_cont_j, 1);
            al.l(this.jit, d.C0277d.cp_bg_line_b);
            al.l(this.jiu, d.C0277d.cp_bg_line_b);
            al.l(this.jiv, d.C0277d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AJ(int i) {
        BdToast.c(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), ap.hx(i)), d.f.icon_toast_game_error).abe();
    }

    @Override // com.baidu.tieba.view.e
    public void qQ(boolean z) {
        if (this.jio != null) {
            if (z) {
                this.jio.setVisibility(0);
            } else {
                this.jio.setVisibility(8);
            }
        }
    }
}
