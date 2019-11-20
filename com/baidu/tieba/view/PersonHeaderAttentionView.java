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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class PersonHeaderAttentionView extends LinearLayout implements e {
    private View.OnClickListener ajc;
    private TextView fXw;
    private TextView gFo;
    private TextView ilE;
    private g itE;
    private TextView jJS;
    private ImageView jJT;
    private TextView jJU;
    private TextView jJV;
    private TextView jJW;
    private TextView jJX;
    private View jJY;
    private View jJZ;
    private View jKa;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jKb = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ilE.getId() && id != PersonHeaderAttentionView.this.jJS.getId()) {
                        if (id != PersonHeaderAttentionView.this.fXw.getId() && id != PersonHeaderAttentionView.this.jJU.getId()) {
                            if (id == PersonHeaderAttentionView.this.jJV.getId() || id == PersonHeaderAttentionView.this.jJW.getId()) {
                                TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Bj(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().atw() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().atw() != 2)) {
                                    PersonHeaderAttentionView.this.Bj(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jKb.fgD = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jKb.fgD = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bS("obj_locate", "9"));
                        this.jKb.fgD = 4;
                    }
                    if (PersonHeaderAttentionView.this.itE != null) {
                        this.jKb.aSz = new Bundle();
                        this.jKb.aSz.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.itE.a(view, this.jKb);
                    }
                }
            }
        };
        init(context);
        cwP();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jKb = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ilE.getId() && id != PersonHeaderAttentionView.this.jJS.getId()) {
                        if (id != PersonHeaderAttentionView.this.fXw.getId() && id != PersonHeaderAttentionView.this.jJU.getId()) {
                            if (id == PersonHeaderAttentionView.this.jJV.getId() || id == PersonHeaderAttentionView.this.jJW.getId()) {
                                TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Bj(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().atw() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().atw() != 2)) {
                                    PersonHeaderAttentionView.this.Bj(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jKb.fgD = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jKb.fgD = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bS("obj_locate", "9"));
                        this.jKb.fgD = 4;
                    }
                    if (PersonHeaderAttentionView.this.itE != null) {
                        this.jKb.aSz = new Bundle();
                        this.jKb.aSz.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.itE.a(view, this.jKb);
                    }
                }
            }
        };
        init(context);
        cwP();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a jKb = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.ilE.getId() && id != PersonHeaderAttentionView.this.jJS.getId()) {
                        if (id != PersonHeaderAttentionView.this.fXw.getId() && id != PersonHeaderAttentionView.this.jJU.getId()) {
                            if (id == PersonHeaderAttentionView.this.jJV.getId() || id == PersonHeaderAttentionView.this.jJW.getId()) {
                                TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.Bj(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().atw() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().atw() != 2)) {
                                    PersonHeaderAttentionView.this.Bj(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.jKb.fgD = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                            this.jKb.fgD = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").bS("obj_locate", "9"));
                        this.jKb.fgD = 4;
                    }
                    if (PersonHeaderAttentionView.this.itE != null) {
                        this.jKb.aSz = new Bundle();
                        this.jKb.aSz.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.itE.a(view, this.jKb);
                    }
                }
            }
        };
        init(context);
        cwP();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.fXw = (TextView) findViewById(R.id.person_header_fans_num);
        this.jJU = (TextView) findViewById(R.id.person_header_fans_des);
        this.jJT = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.ilE = (TextView) findViewById(R.id.person_header_attention_num);
        this.jJS = (TextView) findViewById(R.id.person_header_attention_des);
        this.jJV = (TextView) findViewById(R.id.person_header_bar_num);
        this.jJW = (TextView) findViewById(R.id.person_header_bar_des);
        this.gFo = (TextView) findViewById(R.id.person_header_thread_num);
        this.gFo.setVisibility(8);
        this.jJX = (TextView) findViewById(R.id.person_header_thread_des);
        this.jJX.setVisibility(8);
        this.jJY = findViewById(R.id.divider_for_fans_and_attention);
        this.jJZ = findViewById(R.id.divider_for_attention_and_bar);
        this.jKa = findViewById(R.id.divider_for_bar_and_thread);
        this.jKa.setVisibility(8);
    }

    private void cwP() {
        this.fXw.setOnClickListener(this.ajc);
        this.jJU.setOnClickListener(this.ajc);
        this.ilE.setOnClickListener(this.ajc);
        this.jJS.setOnClickListener(this.ajc);
        this.jJV.setOnClickListener(this.ajc);
        this.jJW.setOnClickListener(this.ajc);
        this.gFo.setOnClickListener(this.ajc);
        this.jJX.setOnClickListener(this.ajc);
    }

    @Override // com.baidu.tieba.view.e
    public void setOnViewResponseListener(g gVar) {
        this.itE = gVar;
    }

    private void y(String str, String str2, String str3, String str4) {
        this.ilE.setText(str);
        this.fXw.setText(str2);
        this.jJV.setText(str4);
        this.gFo.setText(str3);
    }

    @Override // com.baidu.tieba.view.e
    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.ilE.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.fXw.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.jJV.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.gFo.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        y(aq.numFormatOverWanNa(this.mUserData.getConcernNum()), aq.numFormatOverWanNa(this.mUserData.getFansNum()), aq.numFormatOverWanNa(this.mUserData.getPosts_num()), aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    @Override // com.baidu.tieba.view.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.ilE, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jJS, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.fXw, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jJU, R.color.cp_cont_j, 1);
            am.setImageResource(this.jJT, R.drawable.icon_news_down_bar_one);
            am.setViewTextColor(this.jJV, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jJW, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.gFo, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jJX, R.color.cp_cont_j, 1);
            am.setBackgroundColor(this.jJY, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jJZ, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.jKa, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bj(int i) {
        BdToast.b(this.mContext, String.format(this.mContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake_n_svg, true).akR();
    }

    @Override // com.baidu.tieba.view.e
    public void rG(boolean z) {
        if (this.jJT != null) {
            if (z) {
                this.jJT.setVisibility(0);
            } else {
                this.jJT.setVisibility(8);
            }
        }
    }
}
