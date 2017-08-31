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
    View.OnClickListener avj;
    private float cFZ;
    private ImageView fmh;
    private TextView fmi;
    private TextView fmj;
    private TextView fmk;
    private TextView fml;
    private View fmm;
    private View fmn;
    private int fmo;
    private TextView fmp;
    private TextView fmq;
    private Animation fmr;
    private Animation fms;
    private TextView fmt;
    private TbPageContext mF;

    static /* synthetic */ int j(q qVar) {
        int i = qVar.fmo;
        qVar.fmo = i + 1;
        return i;
    }

    public q(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity(), z);
        this.cFZ = 360.0f;
        this.fmo = 0;
        this.avj = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.q.3
            com.baidu.tieba.personPolymeric.event.a fmv = new com.baidu.tieba.personPolymeric.event.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.feW != null) {
                    this.fmv.ceb = -1;
                    if (q.this.gwT != view) {
                        if (q.this.gwV != view) {
                            if (q.this.gwW != view) {
                                if (q.this.gwS != view) {
                                    if (q.this.gwY != view) {
                                        if (q.this.fmk != view) {
                                            if (q.this.fmn == view) {
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
                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(q.this.mContext, q.this.mUserData.getUserId(), q.this.mUserData.getUserName(), q.this.mUserData.getPortrait(), q.this.mUserData.getSex(), q.this.bmo)));
                                                        }
                                                    } else {
                                                        BdToast.b(q.this.mContext, String.format(q.this.mContext.getString(d.l.person_privacy_toast), am.cZ(q.this.mUserData.getSex())), d.g.icon_toast_game_error).tw();
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else if ((q.this.apl == view || q.this.fmj == view) && q.this.bmo) {
                                                this.fmv.cec = new Bundle();
                                                this.fmv.cec.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                                                if (q.this.gxa != null && q.this.gxa.fkx != null) {
                                                    this.fmv.cec.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, q.this.gxa.fkx.left_days.intValue());
                                                }
                                                this.fmv.ceb = 11;
                                            }
                                        } else {
                                            this.fmv.ceb = 14;
                                        }
                                    } else {
                                        this.fmv.ceb = 13;
                                    }
                                } else {
                                    this.fmv.ceb = 10;
                                    this.fmv.cec = new Bundle();
                                    this.fmv.cec.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                                }
                            } else {
                                this.fmv.ceb = 3;
                                this.fmv.cec = new Bundle();
                                this.fmv.cec.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                            }
                        } else {
                            this.fmv.ceb = 2;
                            this.fmv.cec = new Bundle();
                            if (q.this.mUserData != null && !v.v(q.this.mUserData.getTShowInfo())) {
                                this.fmv.cec.putString("vip_user_jump", q.this.mUserData.getTShowInfo().get(0).getUrl());
                            }
                        }
                    } else {
                        this.fmv.ceb = 1;
                        this.fmv.cec = new Bundle();
                        this.fmv.cec.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                    }
                    q.this.feW.a(view, this.fmv);
                }
            }
        };
        this.mF = tbPageContext;
        TextView textView = this.gwX;
        if (this.bmo) {
        }
        textView.setVisibility(8);
        if (this.fmm != null && this.bmo) {
            this.fmm.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.j
    public View Vq() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.j
    public void X(View view) {
        this.gwS = (BdExpandImageView) view.findViewById(d.h.person_polymeric_header_expand_img);
        this.fmh = (ImageView) view.findViewById(d.h.person_polymeric_header_refresh_image);
        this.gwT = (HeadPendantView) view.findViewById(d.h.person_polymeric_header_user_img);
        this.gwU = (TbImageView) view.findViewById(d.h.person_polymeric_header_god_user_icon);
        this.gwV = (UserIconBox) view.findViewById(d.h.person_polymeric_header_user_vip_icon);
        this.apl = (TextView) view.findViewById(d.h.person_polymeric_header_user_name_txt);
        this.gwY = (TextView) view.findViewById(d.h.seal_prefix_view);
        this.gwW = (UserIconBox) view.findViewById(d.h.person_polymeric_header_label_box);
        this.fmi = (TextView) view.findViewById(d.h.person_polymeric_header_bar_age_txt);
        this.gwX = (TextView) view.findViewById(d.h.person_polymeric_header_visitor_txt);
        this.fmj = (TextView) view.findViewById(d.h.person_polymeric_header_sign_txt);
        this.fmk = (TextView) view.findViewById(d.h.person_center_header_tdou_txt);
        this.fml = (TextView) view.findViewById(d.h.space_line);
        this.fmm = view.findViewById(d.h.person_polymeric_header_alaentry_layout_root);
        this.fmn = view.findViewById(d.h.person_polymeric_header_alaentry_layout);
        this.fmt = (TextView) view.findViewById(d.h.person_praise_number);
        this.fmk.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gwZ = (PersonHeaderAttentionView) view.findViewById(d.h.person_center_header_attention_container);
        bwy();
        this.fmr = AnimationUtils.loadAnimation(this.mContext, d.a.user_live_info_fadeout);
        this.fmr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.d.q.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                q.this.fmn.setAnimation(q.this.fms);
                if (q.this.fmo % 2 == 1) {
                    if (q.this.mUserData.getLiveStatus() == 1) {
                        q.this.fmn.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(0);
                        q.this.fmq.setVisibility(8);
                        q.this.fmp.setText(q.this.mContext.getResources().getString(d.l.person_polymeric_ala_entry_live));
                    } else {
                        q.this.fmn.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(8);
                        q.this.fmq.setVisibility(0);
                        q.this.fmp.setText(q.this.mContext.getResources().getString(d.l.go_to_live_post_prefix));
                    }
                } else {
                    q.this.fmn.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(8);
                    q.this.fmq.setVisibility(0);
                    q.this.fmp.setText(q.this.mContext.getResources().getString(d.l.person_polymeric_ala_live_title));
                }
                q.j(q.this);
                q.this.fms.start();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fms = AnimationUtils.loadAnimation(this.mContext, d.a.user_live_info_easeout);
        this.fms.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.d.q.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                q.this.fmn.setAnimation(q.this.fmr);
                q.this.fmr.start();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override // com.baidu.tieba.view.j
    protected void agc() {
        super.agc();
        this.gwV.setOnClickListener(this.avj);
        this.gwW.setOnClickListener(this.avj);
        this.gwS.setOnClickListener(this.avj);
        this.gwT.setOnClickListener(this.avj);
        this.gwX.setOnClickListener(this.avj);
        this.gwY.setOnClickListener(this.avj);
        this.fmk.setOnClickListener(this.avj);
        this.fmn.setOnClickListener(this.avj);
        this.apl.setOnClickListener(this.avj);
        this.fmj.setOnClickListener(this.avj);
    }

    @Override // com.baidu.tieba.view.j
    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            super.e(aVar);
            this.fmi.setText(String.format(this.mContext.getString(d.l.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.bmo) {
                this.fml.setVisibility(0);
                this.fmk.setVisibility(0);
                this.fml.setText("|");
                this.fmk.setText(bQ(am.H(this.mUserData.getTDouNum()) + "   |   " + this.mContext.getString(d.l.get_tdou), "   |   "));
            } else {
                this.fml.setVisibility(8);
                this.fmk.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                intro = this.mContext.getString(d.l.no_person_sign);
            }
            if (intro.length() > 45) {
                intro = intro.substring(0, 45) + "...";
            }
            this.fmj.setText(intro);
            this.fmp = (TextView) this.fmn.findViewById(d.h.person_polymeric_header_alaentry_status);
            this.fmq = (TextView) this.fmn.findViewById(d.h.person_polymeric_header_alalevel);
            ImageView imageView = (ImageView) this.fmn.findViewById(d.h.person_polymeric_header_livepoint);
            this.fmn.clearAnimation();
            if (this.mUserData.getLiveStatus() == 1) {
                this.fmq.setVisibility(8);
                imageView.setVisibility(0);
                this.fmp.setText(this.mContext.getResources().getString(d.l.person_polymeric_ala_entry_live));
                this.fmq.setText(Integer.toString(this.mUserData.getLiveLevel()));
            } else {
                imageView.setVisibility(8);
                this.fmp.setText(this.mContext.getResources().getString(d.l.person_polymeric_ala_live_title));
                this.fmq.setVisibility(0);
                this.fmq.setText(Integer.toString(this.mUserData.getLiveLevel()));
            }
            a(aVar.fkw);
            if (this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Ct() != 3) {
                if (this.mUserData.getPersonPrivate().Ct() != 2 || this.mUserData.getIsFriend() == 1) {
                    this.fmn.setAnimation(this.fmr);
                    this.fmr.start();
                }
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.fmt.setVisibility(8);
            return;
        }
        this.fmt.setVisibility(0);
        String A = am.A(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = aj.getDrawable(d.g.icon_floor_praised);
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        this.fmt.setCompoundDrawables(drawable, null, null, null);
        this.fmt.setText(A);
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
        aj.c(this.gwX, d.e.cp_cont_i, 1);
        aj.c(this.fmi, d.e.cp_cont_i, 1);
        aj.c(this.fmj, d.e.cp_cont_i_alpha60, 1);
        aj.c(this.fmk, d.e.cp_cont_i, 1);
        aj.c(this.fml, d.e.cp_cont_i_alpha60, 1);
        aj.i(this.fmt, d.e.cp_cont_i);
        this.fmk.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable u = aj.u(i, d.g.icon_floor_praised);
        u.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        this.fmt.setCompoundDrawables(u, null, null, null);
    }

    @Override // com.baidu.tieba.view.j
    public void u(float f) {
        if (!this.fmh.isShown()) {
            this.fmh.setVisibility(0);
            this.fmh.setImageDrawable(this.mContext.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cFZ, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.fmh.startAnimation(rotateAnimation);
        this.cFZ = f;
    }

    @Override // com.baidu.tieba.view.j
    public void aln() {
        this.fmh.clearAnimation();
        this.fmh.setImageDrawable(null);
        this.fmh.setVisibility(8);
    }

    @Override // com.baidu.tieba.view.j
    public void kY() {
        if (!this.fmh.isShown()) {
            this.fmh.setVisibility(0);
            this.fmh.setImageDrawable(this.mContext.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        this.fmh.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, d.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.view.j
    public void onDestory() {
        if (this.fmp != null) {
            this.fmp.clearAnimation();
        }
    }
}
