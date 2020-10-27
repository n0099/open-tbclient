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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class PersonHeaderAttentionView extends LinearLayout {
    private View.OnClickListener aFf;
    private TextView jYs;
    private TextView jjz;
    private TextView lQz;
    private ImageView lXM;
    private Context mContext;
    private int mSkinType;
    private UserData mUserData;
    private f maQ;
    private TextView nvA;
    private TextView nvB;
    private TextView nvC;
    private TextView nvD;
    private TextView nvE;
    private View nvF;
    private View nvG;
    private View nvH;

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.mSkinType = -1;
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nvI = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lQz.getId() && id != PersonHeaderAttentionView.this.nvA.getId()) {
                        if (id != PersonHeaderAttentionView.this.jjz.getId() && id != PersonHeaderAttentionView.this.nvB.getId()) {
                            if (id == PersonHeaderAttentionView.this.nvC.getId() || id == PersonHeaderAttentionView.this.nvD.getId()) {
                                TiebaStatic.log(new aq("c12502").dR("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.GV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bws() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bws() != 2)) {
                                    PersonHeaderAttentionView.this.GV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nvI.imR = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dR("obj_locate", "8"));
                            this.nvI.imR = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dR("obj_locate", "9"));
                        this.nvI.imR = 4;
                    }
                    if (PersonHeaderAttentionView.this.maQ != null) {
                        this.nvI.imS = new Bundle();
                        this.nvI.imS.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.maQ.a(view, this.nvI);
                    }
                }
            }
        };
        init(context);
        dQi();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = -1;
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nvI = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lQz.getId() && id != PersonHeaderAttentionView.this.nvA.getId()) {
                        if (id != PersonHeaderAttentionView.this.jjz.getId() && id != PersonHeaderAttentionView.this.nvB.getId()) {
                            if (id == PersonHeaderAttentionView.this.nvC.getId() || id == PersonHeaderAttentionView.this.nvD.getId()) {
                                TiebaStatic.log(new aq("c12502").dR("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.GV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bws() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bws() != 2)) {
                                    PersonHeaderAttentionView.this.GV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nvI.imR = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dR("obj_locate", "8"));
                            this.nvI.imR = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dR("obj_locate", "9"));
                        this.nvI.imR = 4;
                    }
                    if (PersonHeaderAttentionView.this.maQ != null) {
                        this.nvI.imS = new Bundle();
                        this.nvI.imS.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.maQ.a(view, this.nvI);
                    }
                }
            }
        };
        init(context);
        dQi();
        onChangeSkinType(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = -1;
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.view.PersonHeaderAttentionView.1
            com.baidu.tieba.g.a nvI = new com.baidu.tieba.g.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonHeaderAttentionView.this.mUserData != null && view != null && bg.checkUpIsLogin(PersonHeaderAttentionView.this.mContext)) {
                    boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.mUserData.getUserId());
                    boolean z = PersonHeaderAttentionView.this.mUserData.getIsFriend() == 1;
                    int id = view.getId();
                    if (id != PersonHeaderAttentionView.this.lQz.getId() && id != PersonHeaderAttentionView.this.nvA.getId()) {
                        if (id != PersonHeaderAttentionView.this.jjz.getId() && id != PersonHeaderAttentionView.this.nvB.getId()) {
                            if (id == PersonHeaderAttentionView.this.nvC.getId() || id == PersonHeaderAttentionView.this.nvD.getId()) {
                                TiebaStatic.log(new aq("c12502").dR("obj_locate", "10"));
                                if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate() == null) {
                                    PersonHeaderAttentionView.this.GV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else if (PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bws() != 1 && !equals && (!z || PersonHeaderAttentionView.this.mUserData.getPersonPrivate().bws() != 2)) {
                                    PersonHeaderAttentionView.this.GV(PersonHeaderAttentionView.this.mUserData.getSex());
                                    return;
                                } else {
                                    this.nvI.imR = 7;
                                }
                            }
                        } else {
                            TiebaStatic.log(new aq("c12502").dR("obj_locate", "8"));
                            this.nvI.imR = 5;
                        }
                    } else {
                        TiebaStatic.log(new aq("c12502").dR("obj_locate", "9"));
                        this.nvI.imR = 4;
                    }
                    if (PersonHeaderAttentionView.this.maQ != null) {
                        this.nvI.imS = new Bundle();
                        this.nvI.imS.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.mUserData);
                        PersonHeaderAttentionView.this.maQ.a(view, this.nvI);
                    }
                }
            }
        };
        init(context);
        dQi();
        onChangeSkinType(0);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.jjz = (TextView) findViewById(R.id.person_header_fans_num);
        this.nvB = (TextView) findViewById(R.id.person_header_fans_des);
        this.lXM = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.lQz = (TextView) findViewById(R.id.person_header_attention_num);
        this.nvA = (TextView) findViewById(R.id.person_header_attention_des);
        this.nvC = (TextView) findViewById(R.id.person_header_bar_num);
        this.nvD = (TextView) findViewById(R.id.person_header_bar_des);
        this.jYs = (TextView) findViewById(R.id.person_header_thread_num);
        this.jYs.setVisibility(8);
        this.nvE = (TextView) findViewById(R.id.person_header_thread_des);
        this.nvE.setVisibility(8);
        this.nvF = findViewById(R.id.divider_for_fans_and_attention);
        this.nvG = findViewById(R.id.divider_for_attention_and_bar);
        this.nvH = findViewById(R.id.divider_for_bar_and_thread);
        this.nvH.setVisibility(8);
    }

    private void dQi() {
        this.jjz.setOnClickListener(this.aFf);
        this.nvB.setOnClickListener(this.aFf);
        this.lQz.setOnClickListener(this.aFf);
        this.nvA.setOnClickListener(this.aFf);
        this.nvC.setOnClickListener(this.aFf);
        this.nvD.setOnClickListener(this.aFf);
        this.jYs.setOnClickListener(this.aFf);
        this.nvE.setOnClickListener(this.aFf);
    }

    public void setOnViewResponseListener(f fVar) {
        this.maQ = fVar;
    }

    private void J(String str, String str2, String str3, String str4) {
        this.lQz.setText(str);
        this.jjz.setText(str2);
        this.nvC.setText(str4);
        this.jYs.setText(str3);
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        if (this.mUserData.getConcernNum() >= 9999000) {
            this.lQz.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getFansNum() >= 9999000) {
            this.jjz.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getLike_bars() >= 9999000) {
            this.nvC.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        if (this.mUserData.getPosts_num() >= 9999000) {
            this.jYs.setTextSize(0, l.getDimens(this.mContext, R.dimen.ds32));
        }
        J(at.numFormatOverWanNa(this.mUserData.getConcernNum()), at.numFormatOverWanNa(this.mUserData.getFansNum()), at.numFormatOverWanNa(this.mUserData.getPosts_num()), at.numFormatOverWanNa(this.mUserData.getLike_bars()));
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.lQz, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.nvA, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.jjz, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.nvB, R.color.cp_cont_j, 1);
            ap.setImageResource(this.lXM, R.drawable.icon_news_down_bar_one);
            ap.setViewTextColor(this.nvC, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.nvD, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.jYs, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.nvE, R.color.cp_cont_j, 1);
            ap.setBackgroundColor(this.nvF, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.nvG, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.nvH, R.color.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GV(int i) {
        BdToast.a(this.mContext, (CharSequence) String.format(this.mContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bmI();
    }
}
