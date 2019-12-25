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
import com.baidu.searchbox.ugc.model.PublishType;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener aqZ;
    private TextView gLU;
    private TextView hts;
    private TextView jdA;
    private ImageView jkE;
    private e jnj;
    private TextView kEp;
    private TextView kEq;
    private TextView kEr;
    private TextView kEs;
    private TextView kEt;
    private View kEu;
    private View kEv;
    private View kEw;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aqZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kEx = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jdA.getId() && id != PersonHeaderAttentionView.this.kEp.getId()) {
                        if (id != PersonHeaderAttentionView.this.gLU.getId() && id != PersonHeaderAttentionView.this.kEq.getId()) {
                            if (id == PersonHeaderAttentionView.this.kEr.getId() || id == PersonHeaderAttentionView.this.kEs.getId()) {
                                TiebaStatic.log(new an("c12502").cp("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.zQ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aKX() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aKX() != 2)) {
                                    PersonHeaderAttentionView.this.zQ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kEx.fVg = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cp("obj_locate", "8"));
                            this.kEx.fVg = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cp("obj_locate", PublishType.TYPE_VIDEO_SHARE));
                        this.kEx.fVg = 4;
                    }
                    if (PersonHeaderAttentionView.this.jnj != null) {
                        this.kEx.fVh = new Bundle();
                        this.kEx.fVh.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jnj.a(view, this.kEx);
                    }
                }
            }
        };
        init(context);
        cQX();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aqZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kEx = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jdA.getId() && id != PersonHeaderAttentionView.this.kEp.getId()) {
                        if (id != PersonHeaderAttentionView.this.gLU.getId() && id != PersonHeaderAttentionView.this.kEq.getId()) {
                            if (id == PersonHeaderAttentionView.this.kEr.getId() || id == PersonHeaderAttentionView.this.kEs.getId()) {
                                TiebaStatic.log(new an("c12502").cp("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.zQ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aKX() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aKX() != 2)) {
                                    PersonHeaderAttentionView.this.zQ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kEx.fVg = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cp("obj_locate", "8"));
                            this.kEx.fVg = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cp("obj_locate", PublishType.TYPE_VIDEO_SHARE));
                        this.kEx.fVg = 4;
                    }
                    if (PersonHeaderAttentionView.this.jnj != null) {
                        this.kEx.fVh = new Bundle();
                        this.kEx.fVh.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jnj.a(view, this.kEx);
                    }
                }
            }
        };
        init(context);
        cQX();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aqZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a kEx = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bc.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.jdA.getId() && id != PersonHeaderAttentionView.this.kEp.getId()) {
                        if (id != PersonHeaderAttentionView.this.gLU.getId() && id != PersonHeaderAttentionView.this.kEq.getId()) {
                            if (id == PersonHeaderAttentionView.this.kEr.getId() || id == PersonHeaderAttentionView.this.kEs.getId()) {
                                TiebaStatic.log(new an("c12502").cp("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.zQ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aKX() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().aKX() != 2)) {
                                    PersonHeaderAttentionView.this.zQ(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.kEx.fVg = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new an("c12502").cp("obj_locate", "8"));
                            this.kEx.fVg = 5;
                        }
                    } else {
                        TiebaStatic.log(new an("c12502").cp("obj_locate", PublishType.TYPE_VIDEO_SHARE));
                        this.kEx.fVg = 4;
                    }
                    if (PersonHeaderAttentionView.this.jnj != null) {
                        this.kEx.fVh = new Bundle();
                        this.kEx.fVh.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.jnj.a(view, this.kEx);
                    }
                }
            }
        };
        init(context);
        cQX();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.gLU = (TextView) findViewById(R.id.person_header_fans_num);
        this.kEq = (TextView) findViewById(R.id.person_header_fans_des);
        this.jkE = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.jdA = (TextView) findViewById(R.id.person_header_attention_num);
        this.kEp = (TextView) findViewById(R.id.person_header_attention_des);
        this.kEr = (TextView) findViewById(R.id.person_header_bar_num);
        this.kEs = (TextView) findViewById(R.id.person_header_bar_des);
        this.hts = (TextView) findViewById(R.id.person_header_thread_num);
        this.hts.setVisibility(8);
        this.kEt = (TextView) findViewById(R.id.person_header_thread_des);
        this.kEt.setVisibility(8);
        this.kEu = findViewById(R.id.divider_for_fans_and_attention);
        this.kEv = findViewById(R.id.divider_for_attention_and_bar);
        this.kEw = findViewById(R.id.divider_for_bar_and_thread);
        this.kEw.setVisibility(8);
    }

    private void cQX() {
        this.gLU.setOnClickListener(this.aqZ);
        this.kEq.setOnClickListener(this.aqZ);
        this.jdA.setOnClickListener(this.aqZ);
        this.kEp.setOnClickListener(this.aqZ);
        this.kEr.setOnClickListener(this.aqZ);
        this.kEs.setOnClickListener(this.aqZ);
        this.hts.setOnClickListener(this.aqZ);
        this.kEt.setOnClickListener(this.aqZ);
    }

    public void setOnViewResponseListener(e eVar) {
        this.jnj = eVar;
    }

    private void A(String str, String str2, String str3, String str4) {
        this.jdA.setText(str);
        this.gLU.setText(str2);
        this.kEr.setText(str4);
        this.hts.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.jdA.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.gLU.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.kEr.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.hts.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        A(aq.numFormatOverWanNa(this.mUserData.getConcernNum()), aq.numFormatOverWanNa(this.mUserData.getFansNum()), aq.numFormatOverWanNa(this.mUserData.getPosts_num()), aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.jdA, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kEp, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.gLU, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kEq, R.color.cp_cont_j, 1);
            am.setImageResource(this.jkE, R.drawable.icon_news_down_bar_one);
            am.setViewTextColor(this.kEr, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kEs, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.hts, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kEt, R.color.cp_cont_j, 1);
            am.setBackgroundColor(this.kEu, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kEv, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.kEw, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zQ(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aCb();
    }
}
