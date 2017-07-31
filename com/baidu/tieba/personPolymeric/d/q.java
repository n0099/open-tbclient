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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import tbclient.Profile.UserAgreeInfo;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.view.j {
    private TbPageContext alI;
    View.OnClickListener avV;
    private float cxG;
    private ImageView flR;
    private TextView flS;
    private TextView flT;
    private TextView flU;
    private TextView flV;
    private View flW;
    private View flX;
    private TextView flY;
    private int flZ;
    private TextView fma;
    private TextView fmb;
    private Animation fmc;
    private Animation fmd;
    private TextView fme;

    static /* synthetic */ int j(q qVar) {
        int i = qVar.flZ;
        qVar.flZ = i + 1;
        return i;
    }

    public q(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity(), z);
        this.cxG = 360.0f;
        this.flZ = 0;
        this.avV = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.q.4
            com.baidu.tieba.personPolymeric.event.a fmg = new com.baidu.tieba.personPolymeric.event.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.feL != null) {
                    this.fmg.cax = -1;
                    if (q.this.gwB != view) {
                        if (q.this.gwD != view) {
                            if (q.this.gwE != view) {
                                if (q.this.gwA != view) {
                                    if (q.this.gwG != view) {
                                        if (q.this.flU != view) {
                                            if (q.this.flX == view) {
                                                if (q.this.mUserData != null) {
                                                    if (!com.baidu.adp.lib.util.i.hr()) {
                                                        com.baidu.adp.lib.util.k.showToast(q.this.mContext, d.l.neterror);
                                                        return;
                                                    }
                                                    aj ajVar = new aj("c11855");
                                                    ajVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                                                    ajVar.aa("click_uid", q.this.mUserData.getUserId());
                                                    ajVar.r("live_status", q.this.mUserData.getLiveStatus());
                                                    TiebaStatic.log(ajVar);
                                                    if (q.this.mUserData.getPersonPrivate().Cy() != 3 && (q.this.mUserData.getPersonPrivate().Cy() != 2 || q.this.mUserData.getIsFriend() == 1)) {
                                                        if (q.this.mUserData.getLiveStatus() == 1) {
                                                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                                                            alaLiveInfoCoreData.setLiveID(Long.parseLong(q.this.mUserData.getLiveId()));
                                                            alaLiveInfoCoreData.setUserID(Long.parseLong(q.this.mUserData.getUserId()));
                                                            alaLiveInfoCoreData.setUserName(q.this.mUserData.getUserName());
                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(q.this.mContext, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, q.this.mUserData.getUserId(), false, "")));
                                                        } else {
                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(q.this.mContext, q.this.mUserData.getUserId(), q.this.mUserData.getUserName(), q.this.mUserData.getPortrait(), q.this.mUserData.getSex(), q.this.blJ)));
                                                        }
                                                    } else {
                                                        BdToast.b(q.this.mContext, String.format(q.this.mContext.getString(d.l.person_privacy_toast), al.cY(q.this.mUserData.getSex())), d.g.icon_toast_game_error).tz();
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else if ((q.this.apG == view || q.this.flT == view) && q.this.blJ) {
                                                this.fmg.cay = new Bundle();
                                                this.fmg.cay.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                                                if (q.this.gwI != null && q.this.gwI.fkh != null) {
                                                    this.fmg.cay.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, q.this.gwI.fkh.left_days.intValue());
                                                }
                                                this.fmg.cax = 11;
                                            }
                                        } else {
                                            this.fmg.cax = 14;
                                        }
                                    } else {
                                        this.fmg.cax = 13;
                                    }
                                } else {
                                    this.fmg.cax = 10;
                                    this.fmg.cay = new Bundle();
                                    this.fmg.cay.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                                }
                            } else {
                                this.fmg.cax = 3;
                                this.fmg.cay = new Bundle();
                                this.fmg.cay.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                            }
                        } else {
                            this.fmg.cax = 2;
                            this.fmg.cay = new Bundle();
                            if (q.this.mUserData != null && !u.v(q.this.mUserData.getTShowInfo())) {
                                this.fmg.cay.putString("vip_user_jump", q.this.mUserData.getTShowInfo().get(0).getUrl());
                            }
                        }
                    } else {
                        this.fmg.cax = 1;
                        this.fmg.cay = new Bundle();
                        this.fmg.cay.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                    }
                    q.this.feL.a(view, this.fmg);
                }
            }
        };
        this.alI = tbPageContext;
        TextView textView = this.gwF;
        if (this.blJ) {
        }
        textView.setVisibility(8);
        if (this.flW != null && this.blJ) {
            this.flW.setVisibility(8);
        }
        if (this.flY != null) {
            this.flY.setVisibility(this.blJ ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.j
    public View Uk() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.j
    public void O(View view) {
        this.gwA = (BdExpandImageView) view.findViewById(d.h.person_polymeric_header_expand_img);
        this.flR = (ImageView) view.findViewById(d.h.person_polymeric_header_refresh_image);
        this.gwB = (HeadPendantView) view.findViewById(d.h.person_polymeric_header_user_img);
        this.gwC = (TbImageView) view.findViewById(d.h.person_polymeric_header_god_user_icon);
        this.gwD = (UserIconBox) view.findViewById(d.h.person_polymeric_header_user_vip_icon);
        this.apG = (TextView) view.findViewById(d.h.person_polymeric_header_user_name_txt);
        this.gwG = (TextView) view.findViewById(d.h.seal_prefix_view);
        this.gwE = (UserIconBox) view.findViewById(d.h.person_polymeric_header_label_box);
        this.flS = (TextView) view.findViewById(d.h.person_polymeric_header_bar_age_txt);
        this.gwF = (TextView) view.findViewById(d.h.person_polymeric_header_visitor_txt);
        this.flT = (TextView) view.findViewById(d.h.person_polymeric_header_sign_txt);
        this.flU = (TextView) view.findViewById(d.h.person_center_header_tdou_txt);
        this.flV = (TextView) view.findViewById(d.h.space_line);
        this.flW = view.findViewById(d.h.person_polymeric_header_alaentry_layout_root);
        this.flX = view.findViewById(d.h.person_polymeric_header_alaentry_layout);
        this.fme = (TextView) view.findViewById(d.h.person_praise_number);
        this.flY = (TextView) view.findViewById(d.h.person_polymeric_header_bigV_entrance);
        this.flU.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gwH = (PersonHeaderAttentionView) view.findViewById(d.h.person_center_header_attention_container);
        bwH();
        this.fmc = AnimationUtils.loadAnimation(this.mContext, d.a.user_live_info_fadeout);
        this.fmc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.d.q.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                q.this.flX.setAnimation(q.this.fmd);
                if (q.this.flZ % 2 == 1) {
                    if (q.this.mUserData.getLiveStatus() == 1) {
                        q.this.flX.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(0);
                        q.this.fmb.setVisibility(8);
                        q.this.fma.setText(q.this.mContext.getResources().getString(d.l.person_polymeric_ala_entry_live));
                    } else {
                        q.this.flX.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(8);
                        q.this.fmb.setVisibility(0);
                        q.this.fma.setText(q.this.mContext.getResources().getString(d.l.go_to_live_post_prefix));
                    }
                } else {
                    q.this.flX.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(8);
                    q.this.fmb.setVisibility(0);
                    q.this.fma.setText(q.this.mContext.getResources().getString(d.l.person_polymeric_ala_live_title));
                }
                q.j(q.this);
                q.this.fmd.start();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fmd = AnimationUtils.loadAnimation(this.mContext, d.a.user_live_info_easeout);
        this.fmd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.d.q.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                q.this.flX.setAnimation(q.this.fmc);
                q.this.fmc.start();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.flY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.q.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.adp.lib.util.k.hI()) {
                    q.this.alI.showToast(d.l.no_network_guide);
                } else {
                    at.wf().c(q.this.alI, new String[]{TbConfig.BIG_V_APPLAY});
                }
            }
        });
    }

    @Override // com.baidu.tieba.view.j
    protected void aep() {
        super.aep();
        this.gwD.setOnClickListener(this.avV);
        this.gwE.setOnClickListener(this.avV);
        this.gwA.setOnClickListener(this.avV);
        this.gwB.setOnClickListener(this.avV);
        this.gwF.setOnClickListener(this.avV);
        this.gwG.setOnClickListener(this.avV);
        this.flU.setOnClickListener(this.avV);
        this.flX.setOnClickListener(this.avV);
        this.apG.setOnClickListener(this.avV);
        this.flT.setOnClickListener(this.avV);
    }

    @Override // com.baidu.tieba.view.j
    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            super.e(aVar);
            this.flS.setText(String.format(this.mContext.getString(d.l.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.blJ) {
                this.flV.setVisibility(0);
                this.flU.setVisibility(0);
                this.flV.setText("|");
                this.flU.setText(bO(al.I(this.mUserData.getTDouNum()) + "   |   " + this.mContext.getString(d.l.get_tdou), "   |   "));
            } else {
                this.flV.setVisibility(8);
                this.flU.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                intro = this.mContext.getString(d.l.no_person_sign);
            }
            if (intro.length() > 45) {
                intro = intro.substring(0, 45) + "...";
            }
            this.flT.setText(intro);
            this.fma = (TextView) this.flX.findViewById(d.h.person_polymeric_header_alaentry_status);
            this.fmb = (TextView) this.flX.findViewById(d.h.person_polymeric_header_alalevel);
            ImageView imageView = (ImageView) this.flX.findViewById(d.h.person_polymeric_header_livepoint);
            this.flX.clearAnimation();
            if (this.mUserData.getLiveStatus() == 1) {
                this.fmb.setVisibility(8);
                imageView.setVisibility(0);
                this.fma.setText(this.mContext.getResources().getString(d.l.person_polymeric_ala_entry_live));
                this.fmb.setText(Integer.toString(this.mUserData.getLiveLevel()));
            } else {
                imageView.setVisibility(8);
                this.fma.setText(this.mContext.getResources().getString(d.l.person_polymeric_ala_live_title));
                this.fmb.setVisibility(0);
                this.fmb.setText(Integer.toString(this.mUserData.getLiveLevel()));
            }
            a(aVar.fkg);
            if (this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Cy() != 3) {
                if (this.mUserData.getPersonPrivate().Cy() != 2 || this.mUserData.getIsFriend() == 1) {
                    this.flX.setAnimation(this.fmc);
                    this.fmc.start();
                }
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.fme.setVisibility(8);
            return;
        }
        this.fme.setVisibility(0);
        String B = al.B(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = ai.getDrawable(d.g.icon_floor_praised);
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        this.fme.setCompoundDrawables(drawable, null, null, null);
        this.fme.setText(B);
    }

    private SpannableString bO(String str, String str2) {
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        if (str2 != null && str.contains(str2)) {
            int indexOf = str.indexOf(str2);
            spannableString.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_cont_i_alpha60)), indexOf, str2.length() + indexOf, 17);
            return spannableString;
        }
        return spannableString;
    }

    @Override // com.baidu.tieba.view.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ai.i(this.flY, d.e.cp_cont_i);
        ai.c(this.gwF, d.e.cp_cont_i, 1);
        ai.c(this.flS, d.e.cp_cont_i, 1);
        ai.c(this.flT, d.e.cp_cont_i_alpha60, 1);
        ai.c(this.flU, d.e.cp_cont_i, 1);
        ai.c(this.flV, d.e.cp_cont_i_alpha60, 1);
        ai.i(this.fme, d.e.cp_cont_i);
        this.flU.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable v = ai.v(i, d.g.icon_floor_praised);
        v.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        this.fme.setCompoundDrawables(v, null, null, null);
    }

    @Override // com.baidu.tieba.view.j
    public void F(float f) {
        if (!this.flR.isShown()) {
            this.flR.setVisibility(0);
            this.flR.setImageDrawable(this.mContext.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cxG, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.flR.startAnimation(rotateAnimation);
        this.cxG = f;
    }

    @Override // com.baidu.tieba.view.j
    public void ajc() {
        this.flR.clearAnimation();
        this.flR.setImageDrawable(null);
        this.flR.setVisibility(8);
    }

    @Override // com.baidu.tieba.view.j
    public void lh() {
        if (!this.flR.isShown()) {
            this.flR.setVisibility(0);
            this.flR.setImageDrawable(this.mContext.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        this.flR.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, d.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.view.j
    public void onDestory() {
        if (this.fma != null) {
            this.fma.clearAnimation();
        }
    }
}
