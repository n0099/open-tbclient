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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonHeaderAttentionView extends LinearLayout implements g {
    private View.OnClickListener ctG;
    private TextView dQA;
    private TextView ewp;
    private TextView ggn;
    private i gob;
    private TextView hJq;
    private ImageView hJr;
    private TextView hJs;
    private TextView hJt;
    private TextView hJu;
    private TextView hJv;
    private View hJw;
    private View hJx;
    private View hJy;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.ctG = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hJz = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.be(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ggn.getId() && id != PersonHeaderAttentionView.this.hJq.getId()) {
                        if (id != PersonHeaderAttentionView.this.dQA.getId() && id != PersonHeaderAttentionView.this.hJs.getId()) {
                            if (id == PersonHeaderAttentionView.this.hJt.getId() || id == PersonHeaderAttentionView.this.hJu.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.yz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kd() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kd() != 2)) {
                                    PersonHeaderAttentionView.this.yz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hJz.djI = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", "8"));
                            this.hJz.djI = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hJz.djI = 4;
                    }
                    if (PersonHeaderAttentionView.this.gob != null) {
                        this.hJz.djJ = new Bundle();
                        this.hJz.djJ.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gob.a(view, this.hJz);
                    }
                }
            }
        };
        init(context);
        bKw();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.ctG = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hJz = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.be(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ggn.getId() && id != PersonHeaderAttentionView.this.hJq.getId()) {
                        if (id != PersonHeaderAttentionView.this.dQA.getId() && id != PersonHeaderAttentionView.this.hJs.getId()) {
                            if (id == PersonHeaderAttentionView.this.hJt.getId() || id == PersonHeaderAttentionView.this.hJu.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.yz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kd() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kd() != 2)) {
                                    PersonHeaderAttentionView.this.yz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hJz.djI = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", "8"));
                            this.hJz.djI = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hJz.djI = 4;
                    }
                    if (PersonHeaderAttentionView.this.gob != null) {
                        this.hJz.djJ = new Bundle();
                        this.hJz.djJ.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gob.a(view, this.hJz);
                    }
                }
            }
        };
        init(context);
        bKw();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.ctG = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.f.a hJz = new com.baidu.tieba.f.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && ax.be(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ggn.getId() && id != PersonHeaderAttentionView.this.hJq.getId()) {
                        if (id != PersonHeaderAttentionView.this.dQA.getId() && id != PersonHeaderAttentionView.this.hJs.getId()) {
                            if (id == PersonHeaderAttentionView.this.hJt.getId() || id == PersonHeaderAttentionView.this.hJu.getId()) {
                                TiebaStatic.log(new ak("c12502").ab("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.yz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kd() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().Kd() != 2)) {
                                    PersonHeaderAttentionView.this.yz(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.hJz.djI = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new ak("c12502").ab("obj_locate", "8"));
                            this.hJz.djI = 5;
                        }
                    } else {
                        TiebaStatic.log(new ak("c12502").ab("obj_locate", "9"));
                        this.hJz.djI = 4;
                    }
                    if (PersonHeaderAttentionView.this.gob != null) {
                        this.hJz.djJ = new Bundle();
                        this.hJz.djJ.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.gob.a(view, this.hJz);
                    }
                }
            }
        };
        init(context);
        bKw();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(d.h.item_person_header_attention_view, (ViewGroup) this, true);
        this.dQA = (TextView) findViewById(d.g.person_header_fans_num);
        this.hJs = (TextView) findViewById(d.g.person_header_fans_des);
        this.hJr = (ImageView) findViewById(d.g.person_header_fans_red_tip);
        this.ggn = (TextView) findViewById(d.g.person_header_attention_num);
        this.hJq = (TextView) findViewById(d.g.person_header_attention_des);
        this.hJt = (TextView) findViewById(d.g.person_header_bar_num);
        this.hJu = (TextView) findViewById(d.g.person_header_bar_des);
        this.ewp = (TextView) findViewById(d.g.person_header_thread_num);
        this.ewp.setVisibility(8);
        this.hJv = (TextView) findViewById(d.g.person_header_thread_des);
        this.hJv.setVisibility(8);
        this.hJw = findViewById(d.g.divider_for_fans_and_attention);
        this.hJx = findViewById(d.g.divider_for_attention_and_bar);
        this.hJy = findViewById(d.g.divider_for_bar_and_thread);
        this.hJy.setVisibility(8);
    }

    private void bKw() {
        this.dQA.setOnClickListener(this.ctG);
        this.hJs.setOnClickListener(this.ctG);
        this.ggn.setOnClickListener(this.ctG);
        this.hJq.setOnClickListener(this.ctG);
        this.hJt.setOnClickListener(this.ctG);
        this.hJu.setOnClickListener(this.ctG);
        this.ewp.setOnClickListener(this.ctG);
        this.hJv.setOnClickListener(this.ctG);
    }

    @Override // com.baidu.tieba.view.g
    public void setOnViewResponseListener(i iVar) {
        this.gob = iVar;
    }

    private void p(String str, String str2, String str3, String str4) {
        this.ggn.setText(str);
        this.dQA.setText(str2);
        this.hJt.setText(str4);
        this.ewp.setText(str3);
    }

    @Override // com.baidu.tieba.view.g
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.ggn.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.dQA.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.hJt.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.ewp.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds32));
        }
        p(am.H(this.mUserData.getConcernNum()), am.H(this.mUserData.getFansNum()), am.H(this.mUserData.getPosts_num()), am.H(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.g
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.e(this.ggn, d.C0108d.cp_cont_b, 1);
            aj.e(this.hJq, d.C0108d.cp_cont_j, 1);
            aj.e(this.dQA, d.C0108d.cp_cont_b, 1);
            aj.e(this.hJs, d.C0108d.cp_cont_j, 1);
            aj.c(this.hJr, d.f.icon_news_down_bar_one);
            aj.e(this.hJt, d.C0108d.cp_cont_b, 1);
            aj.e(this.hJu, d.C0108d.cp_cont_j, 1);
            aj.e(this.ewp, d.C0108d.cp_cont_b, 1);
            aj.e(this.hJv, d.C0108d.cp_cont_j, 1);
            aj.t(this.hJw, d.C0108d.cp_bg_line_b);
            aj.t(this.hJx, d.C0108d.cp_bg_line_b);
            aj.t(this.hJy, d.C0108d.cp_bg_line_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yz(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(d.j.person_privacy_toast), am.fW(i)), d.f.icon_toast_game_error).AQ();
    }

    @Override // com.baidu.tieba.view.g
    public void oj(boolean z) {
        if (this.hJr != null) {
            if (z) {
                this.hJr.setVisibility(0);
            } else {
                this.hJr.setVisibility(8);
            }
        }
    }
}
