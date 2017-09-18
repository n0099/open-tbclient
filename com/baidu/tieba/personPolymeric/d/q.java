package com.baidu.tieba.personPolymeric.d;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import tbclient.Profile.UserAgreeInfo;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.view.j {
    View.OnClickListener avg;
    private float cGR;
    private ImageView fna;
    private TextView fnb;
    private TextView fnc;
    private TextView fnd;
    private TextView fne;
    private View fnf;
    private View fng;
    private int fnh;
    private TextView fni;
    private TextView fnj;
    private Animation fnk;
    private Animation fnl;
    private TextView fnm;
    private TbPageContext mF;

    static /* synthetic */ int j(q qVar) {
        int i = qVar.fnh;
        qVar.fnh = i + 1;
        return i;
    }

    public q(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity(), z);
        this.cGR = 360.0f;
        this.fnh = 0;
        this.avg = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.q.3
            com.baidu.tieba.personPolymeric.event.a fno = new com.baidu.tieba.personPolymeric.event.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.ffP != null) {
                    this.fno.ceT = -1;
                    if (q.this.gxN != view) {
                        if (q.this.gxP != view) {
                            if (q.this.gxQ != view) {
                                if (q.this.gxM != view) {
                                    if (q.this.gxS != view) {
                                        if (q.this.fnd != view) {
                                            if (q.this.fng == view) {
                                                if (q.this.mUserData != null) {
                                                    if (!com.baidu.adp.lib.util.i.hi()) {
                                                        com.baidu.adp.lib.util.k.showToast(q.this.mContext, d.l.neterror);
                                                        return;
                                                    }
                                                    ak akVar = new ak("c11855");
                                                    akVar.ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                                                    akVar.ad("click_uid", q.this.mUserData.getUserId());
                                                    akVar.r("live_status", q.this.mUserData.getLiveStatus());
                                                    TiebaStatic.log(akVar);
                                                    if (q.this.mUserData.getPersonPrivate().Ct() != 3 && (q.this.mUserData.getPersonPrivate().Ct() != 2 || q.this.mUserData.getIsFriend() == 1)) {
                                                        if (q.this.mUserData.getLiveStatus() == 1) {
                                                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                                                            alaLiveInfoCoreData.setLiveID(Long.parseLong(q.this.mUserData.getLiveId()));
                                                            alaLiveInfoCoreData.setUserID(Long.parseLong(q.this.mUserData.getUserId()));
                                                            alaLiveInfoCoreData.setUserName(q.this.mUserData.getUserName());
                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(q.this.mContext, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, q.this.mUserData.getUserId(), false, "")));
                                                        } else {
                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(q.this.mContext, q.this.mUserData.getUserId(), q.this.mUserData.getUserName(), q.this.mUserData.getPortrait(), q.this.mUserData.getSex(), q.this.bmn)));
                                                        }
                                                    } else {
                                                        BdToast.b(q.this.mContext, String.format(q.this.mContext.getString(d.l.person_privacy_toast), am.cZ(q.this.mUserData.getSex())), d.g.icon_toast_game_error).tw();
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else if ((q.this.apj == view || q.this.fnc == view) && q.this.bmn) {
                                                this.fno.ceU = new Bundle();
                                                this.fno.ceU.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                                                if (q.this.gxU != null && q.this.gxU.flq != null) {
                                                    this.fno.ceU.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, q.this.gxU.flq.left_days.intValue());
                                                }
                                                this.fno.ceT = 11;
                                            }
                                        } else {
                                            this.fno.ceT = 14;
                                        }
                                    } else {
                                        this.fno.ceT = 13;
                                    }
                                } else {
                                    this.fno.ceT = 10;
                                    this.fno.ceU = new Bundle();
                                    this.fno.ceU.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                                }
                            } else {
                                this.fno.ceT = 3;
                                this.fno.ceU = new Bundle();
                                this.fno.ceU.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                            }
                        } else {
                            this.fno.ceT = 2;
                            this.fno.ceU = new Bundle();
                            if (q.this.mUserData != null && !v.v(q.this.mUserData.getTShowInfo())) {
                                this.fno.ceU.putString("vip_user_jump", q.this.mUserData.getTShowInfo().get(0).getUrl());
                            }
                        }
                    } else {
                        this.fno.ceT = 1;
                        this.fno.ceU = new Bundle();
                        this.fno.ceU.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                    }
                    q.this.ffP.a(view, this.fno);
                }
            }
        };
        this.mF = tbPageContext;
        TextView textView = this.gxR;
        if (this.bmn) {
        }
        textView.setVisibility(8);
        if (this.fnf != null && this.bmn) {
            this.fnf.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.j
    public View VB() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.j
    public void X(View view) {
        this.gxM = (BdExpandImageView) view.findViewById(d.h.person_polymeric_header_expand_img);
        this.fna = (ImageView) view.findViewById(d.h.person_polymeric_header_refresh_image);
        this.gxN = (HeadPendantView) view.findViewById(d.h.person_polymeric_header_user_img);
        this.gxO = (TbImageView) view.findViewById(d.h.person_polymeric_header_god_user_icon);
        this.gxP = (UserIconBox) view.findViewById(d.h.person_polymeric_header_user_vip_icon);
        this.apj = (TextView) view.findViewById(d.h.person_polymeric_header_user_name_txt);
        this.gxS = (TextView) view.findViewById(d.h.seal_prefix_view);
        this.gxQ = (UserIconBox) view.findViewById(d.h.person_polymeric_header_label_box);
        this.fnb = (TextView) view.findViewById(d.h.person_polymeric_header_bar_age_txt);
        this.gxR = (TextView) view.findViewById(d.h.person_polymeric_header_visitor_txt);
        this.fnc = (TextView) view.findViewById(d.h.person_polymeric_header_sign_txt);
        this.fnd = (TextView) view.findViewById(d.h.person_center_header_tdou_txt);
        this.fne = (TextView) view.findViewById(d.h.space_line);
        this.fnf = view.findViewById(d.h.person_polymeric_header_alaentry_layout_root);
        this.fng = view.findViewById(d.h.person_polymeric_header_alaentry_layout);
        this.fnm = (TextView) view.findViewById(d.h.person_praise_number);
        this.fnd.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gxT = (PersonHeaderAttentionView) view.findViewById(d.h.person_center_header_attention_container);
        bwJ();
        this.fnk = AnimationUtils.loadAnimation(this.mContext, d.a.user_live_info_fadeout);
        this.fnk.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.d.q.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                q.this.fng.setAnimation(q.this.fnl);
                if (q.this.fnh % 2 == 1) {
                    if (q.this.mUserData.getLiveStatus() == 1) {
                        q.this.fng.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(0);
                        q.this.fnj.setVisibility(8);
                        q.this.fni.setText(q.this.mContext.getResources().getString(d.l.person_polymeric_ala_entry_live));
                    } else {
                        q.this.fng.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(8);
                        q.this.fnj.setVisibility(0);
                        q.this.fni.setText(q.this.mContext.getResources().getString(d.l.go_to_live_post_prefix));
                    }
                } else {
                    q.this.fng.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(8);
                    q.this.fnj.setVisibility(0);
                    q.this.fni.setText(q.this.mContext.getResources().getString(d.l.person_polymeric_ala_live_title));
                }
                q.j(q.this);
                q.this.fnl.start();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fnl = AnimationUtils.loadAnimation(this.mContext, d.a.user_live_info_easeout);
        this.fnl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.d.q.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                q.this.fng.setAnimation(q.this.fnk);
                q.this.fnk.start();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override // com.baidu.tieba.view.j
    protected void agn() {
        super.agn();
        this.gxP.setOnClickListener(this.avg);
        this.gxQ.setOnClickListener(this.avg);
        this.gxM.setOnClickListener(this.avg);
        this.gxN.setOnClickListener(this.avg);
        this.gxR.setOnClickListener(this.avg);
        this.gxS.setOnClickListener(this.avg);
        this.fnd.setOnClickListener(this.avg);
        this.fng.setOnClickListener(this.avg);
        this.apj.setOnClickListener(this.avg);
        this.fnc.setOnClickListener(this.avg);
    }

    @Override // com.baidu.tieba.view.j
    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            super.e(aVar);
            this.fnb.setText(String.format(this.mContext.getString(d.l.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.bmn) {
                this.fne.setVisibility(0);
                this.fnd.setVisibility(0);
                this.fne.setText("|");
                this.fnd.setText(bQ(am.H(this.mUserData.getTDouNum()) + "   |   " + this.mContext.getString(d.l.get_tdou), "   |   "));
            } else {
                this.fne.setVisibility(8);
                this.fnd.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                intro = this.mContext.getString(d.l.no_person_sign);
            }
            if (intro.length() > 45) {
                intro = intro.substring(0, 45) + "...";
            }
            this.fnc.setText(intro);
            this.fni = (TextView) this.fng.findViewById(d.h.person_polymeric_header_alaentry_status);
            this.fnj = (TextView) this.fng.findViewById(d.h.person_polymeric_header_alalevel);
            ImageView imageView = (ImageView) this.fng.findViewById(d.h.person_polymeric_header_livepoint);
            this.fng.clearAnimation();
            if (this.mUserData.getLiveStatus() == 1) {
                this.fnj.setVisibility(8);
                imageView.setVisibility(0);
                this.fni.setText(this.mContext.getResources().getString(d.l.person_polymeric_ala_entry_live));
                this.fnj.setText(Integer.toString(this.mUserData.getLiveLevel()));
            } else {
                imageView.setVisibility(8);
                this.fni.setText(this.mContext.getResources().getString(d.l.person_polymeric_ala_live_title));
                this.fnj.setVisibility(0);
                this.fnj.setText(Integer.toString(this.mUserData.getLiveLevel()));
            }
            a(aVar.flp);
            if (this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Ct() != 3) {
                if (this.mUserData.getPersonPrivate().Ct() != 2 || this.mUserData.getIsFriend() == 1) {
                    this.fng.setAnimation(this.fnk);
                    this.fnk.start();
                }
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.fnm.setVisibility(8);
            return;
        }
        this.fnm.setVisibility(0);
        String A = am.A(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = aj.getDrawable(d.g.icon_floor_praised);
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds32), com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds32));
        this.fnm.setCompoundDrawables(drawable, null, null, null);
        this.fnm.setText(A);
    }

    private SpannableString bQ(String str, String str2) {
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        if (str2 != null && str.contains(str2)) {
            int indexOf = str.indexOf(str2);
            spannableString.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_cont_i_alpha60)), indexOf, str2.length() + indexOf, 17);
            return spannableString;
        }
        return spannableString;
    }

    @Override // com.baidu.tieba.view.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.c(this.gxR, d.e.cp_cont_i, 1);
        aj.c(this.fnb, d.e.cp_cont_i, 1);
        aj.c(this.fnc, d.e.cp_cont_i_alpha60, 1);
        aj.c(this.fnd, d.e.cp_cont_i, 1);
        aj.c(this.fne, d.e.cp_cont_i_alpha60, 1);
        aj.i(this.fnm, d.e.cp_cont_i);
        this.fnd.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable u = aj.u(i, d.g.icon_floor_praised);
        u.setBounds(0, 0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds32), com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds32));
        this.fnm.setCompoundDrawables(u, null, null, null);
    }

    @Override // com.baidu.tieba.view.j
    public void u(float f) {
        if (!this.fna.isShown()) {
            this.fna.setVisibility(0);
            this.fna.setImageDrawable(this.mContext.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cGR, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.fna.startAnimation(rotateAnimation);
        this.cGR = f;
    }

    @Override // com.baidu.tieba.view.j
    public void aly() {
        this.fna.clearAnimation();
        this.fna.setImageDrawable(null);
        this.fna.setVisibility(8);
    }

    @Override // com.baidu.tieba.view.j
    public void kY() {
        if (!this.fna.isShown()) {
            this.fna.setVisibility(0);
            this.fna.setImageDrawable(this.mContext.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        this.fna.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, d.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.view.j
    public void onDestory() {
        if (this.fni != null) {
            this.fni.clearAnimation();
        }
    }
}
