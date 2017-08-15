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
    View.OnClickListener avW;
    private float czE;
    private ImageView fnK;
    private TextView fnL;
    private TextView fnM;
    private TextView fnN;
    private TextView fnO;
    private View fnP;
    private View fnQ;
    private TextView fnR;
    private int fnS;
    private TextView fnT;
    private TextView fnU;
    private Animation fnV;
    private Animation fnW;
    private TextView fnX;
    private TbPageContext oV;

    static /* synthetic */ int j(q qVar) {
        int i = qVar.fnS;
        qVar.fnS = i + 1;
        return i;
    }

    public q(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity(), z);
        this.czE = 360.0f;
        this.fnS = 0;
        this.avW = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.q.4
            com.baidu.tieba.personPolymeric.event.a fnZ = new com.baidu.tieba.personPolymeric.event.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.fgE != null) {
                    this.fnZ.cbj = -1;
                    if (q.this.gyt != view) {
                        if (q.this.gyv != view) {
                            if (q.this.gyw != view) {
                                if (q.this.gys != view) {
                                    if (q.this.gyy != view) {
                                        if (q.this.fnN != view) {
                                            if (q.this.fnQ == view) {
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
                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(q.this.mContext, q.this.mUserData.getUserId(), q.this.mUserData.getUserName(), q.this.mUserData.getPortrait(), q.this.mUserData.getSex(), q.this.blR)));
                                                        }
                                                    } else {
                                                        BdToast.b(q.this.mContext, String.format(q.this.mContext.getString(d.l.person_privacy_toast), al.cY(q.this.mUserData.getSex())), d.g.icon_toast_game_error).tz();
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else if ((q.this.apH == view || q.this.fnM == view) && q.this.blR) {
                                                this.fnZ.cbk = new Bundle();
                                                this.fnZ.cbk.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                                                if (q.this.gyA != null && q.this.gyA.fma != null) {
                                                    this.fnZ.cbk.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, q.this.gyA.fma.left_days.intValue());
                                                }
                                                this.fnZ.cbj = 11;
                                            }
                                        } else {
                                            this.fnZ.cbj = 14;
                                        }
                                    } else {
                                        this.fnZ.cbj = 13;
                                    }
                                } else {
                                    this.fnZ.cbj = 10;
                                    this.fnZ.cbk = new Bundle();
                                    this.fnZ.cbk.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                                }
                            } else {
                                this.fnZ.cbj = 3;
                                this.fnZ.cbk = new Bundle();
                                this.fnZ.cbk.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                            }
                        } else {
                            this.fnZ.cbj = 2;
                            this.fnZ.cbk = new Bundle();
                            if (q.this.mUserData != null && !u.v(q.this.mUserData.getTShowInfo())) {
                                this.fnZ.cbk.putString("vip_user_jump", q.this.mUserData.getTShowInfo().get(0).getUrl());
                            }
                        }
                    } else {
                        this.fnZ.cbj = 1;
                        this.fnZ.cbk = new Bundle();
                        this.fnZ.cbk.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                    }
                    q.this.fgE.a(view, this.fnZ);
                }
            }
        };
        this.oV = tbPageContext;
        TextView textView = this.gyx;
        if (this.blR) {
        }
        textView.setVisibility(8);
        if (this.fnP != null && this.blR) {
            this.fnP.setVisibility(8);
        }
        if (this.fnR != null) {
            this.fnR.setVisibility(this.blR ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.j
    public View UG() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.j
    public void P(View view) {
        this.gys = (BdExpandImageView) view.findViewById(d.h.person_polymeric_header_expand_img);
        this.fnK = (ImageView) view.findViewById(d.h.person_polymeric_header_refresh_image);
        this.gyt = (HeadPendantView) view.findViewById(d.h.person_polymeric_header_user_img);
        this.gyu = (TbImageView) view.findViewById(d.h.person_polymeric_header_god_user_icon);
        this.gyv = (UserIconBox) view.findViewById(d.h.person_polymeric_header_user_vip_icon);
        this.apH = (TextView) view.findViewById(d.h.person_polymeric_header_user_name_txt);
        this.gyy = (TextView) view.findViewById(d.h.seal_prefix_view);
        this.gyw = (UserIconBox) view.findViewById(d.h.person_polymeric_header_label_box);
        this.fnL = (TextView) view.findViewById(d.h.person_polymeric_header_bar_age_txt);
        this.gyx = (TextView) view.findViewById(d.h.person_polymeric_header_visitor_txt);
        this.fnM = (TextView) view.findViewById(d.h.person_polymeric_header_sign_txt);
        this.fnN = (TextView) view.findViewById(d.h.person_center_header_tdou_txt);
        this.fnO = (TextView) view.findViewById(d.h.space_line);
        this.fnP = view.findViewById(d.h.person_polymeric_header_alaentry_layout_root);
        this.fnQ = view.findViewById(d.h.person_polymeric_header_alaentry_layout);
        this.fnX = (TextView) view.findViewById(d.h.person_praise_number);
        this.fnR = (TextView) view.findViewById(d.h.person_polymeric_header_bigV_entrance);
        this.fnN.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gyz = (PersonHeaderAttentionView) view.findViewById(d.h.person_center_header_attention_container);
        bxp();
        this.fnV = AnimationUtils.loadAnimation(this.mContext, d.a.user_live_info_fadeout);
        this.fnV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.d.q.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                q.this.fnQ.setAnimation(q.this.fnW);
                if (q.this.fnS % 2 == 1) {
                    if (q.this.mUserData.getLiveStatus() == 1) {
                        q.this.fnQ.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(0);
                        q.this.fnU.setVisibility(8);
                        q.this.fnT.setText(q.this.mContext.getResources().getString(d.l.person_polymeric_ala_entry_live));
                    } else {
                        q.this.fnQ.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(8);
                        q.this.fnU.setVisibility(0);
                        q.this.fnT.setText(q.this.mContext.getResources().getString(d.l.go_to_live_post_prefix));
                    }
                } else {
                    q.this.fnQ.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(8);
                    q.this.fnU.setVisibility(0);
                    q.this.fnT.setText(q.this.mContext.getResources().getString(d.l.person_polymeric_ala_live_title));
                }
                q.j(q.this);
                q.this.fnW.start();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fnW = AnimationUtils.loadAnimation(this.mContext, d.a.user_live_info_easeout);
        this.fnW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.d.q.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                q.this.fnQ.setAnimation(q.this.fnV);
                q.this.fnV.start();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fnR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.q.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.adp.lib.util.k.hI()) {
                    q.this.oV.showToast(d.l.no_network_guide);
                } else {
                    at.wf().c(q.this.oV, new String[]{TbConfig.BIG_V_APPLAY});
                }
            }
        });
    }

    @Override // com.baidu.tieba.view.j
    protected void aeK() {
        super.aeK();
        this.gyv.setOnClickListener(this.avW);
        this.gyw.setOnClickListener(this.avW);
        this.gys.setOnClickListener(this.avW);
        this.gyt.setOnClickListener(this.avW);
        this.gyx.setOnClickListener(this.avW);
        this.gyy.setOnClickListener(this.avW);
        this.fnN.setOnClickListener(this.avW);
        this.fnQ.setOnClickListener(this.avW);
        this.apH.setOnClickListener(this.avW);
        this.fnM.setOnClickListener(this.avW);
    }

    @Override // com.baidu.tieba.view.j
    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            super.e(aVar);
            this.fnL.setText(String.format(this.mContext.getString(d.l.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.blR) {
                this.fnO.setVisibility(0);
                this.fnN.setVisibility(0);
                this.fnO.setText("|");
                this.fnN.setText(bP(al.I(this.mUserData.getTDouNum()) + "   |   " + this.mContext.getString(d.l.get_tdou), "   |   "));
            } else {
                this.fnO.setVisibility(8);
                this.fnN.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                intro = this.mContext.getString(d.l.no_person_sign);
            }
            if (intro.length() > 45) {
                intro = intro.substring(0, 45) + "...";
            }
            this.fnM.setText(intro);
            this.fnT = (TextView) this.fnQ.findViewById(d.h.person_polymeric_header_alaentry_status);
            this.fnU = (TextView) this.fnQ.findViewById(d.h.person_polymeric_header_alalevel);
            ImageView imageView = (ImageView) this.fnQ.findViewById(d.h.person_polymeric_header_livepoint);
            this.fnQ.clearAnimation();
            if (this.mUserData.getLiveStatus() == 1) {
                this.fnU.setVisibility(8);
                imageView.setVisibility(0);
                this.fnT.setText(this.mContext.getResources().getString(d.l.person_polymeric_ala_entry_live));
                this.fnU.setText(Integer.toString(this.mUserData.getLiveLevel()));
            } else {
                imageView.setVisibility(8);
                this.fnT.setText(this.mContext.getResources().getString(d.l.person_polymeric_ala_live_title));
                this.fnU.setVisibility(0);
                this.fnU.setText(Integer.toString(this.mUserData.getLiveLevel()));
            }
            a(aVar.flZ);
            if (this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Cy() != 3) {
                if (this.mUserData.getPersonPrivate().Cy() != 2 || this.mUserData.getIsFriend() == 1) {
                    this.fnQ.setAnimation(this.fnV);
                    this.fnV.start();
                }
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.fnX.setVisibility(8);
            return;
        }
        this.fnX.setVisibility(0);
        String B = al.B(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = ai.getDrawable(d.g.icon_floor_praised);
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        this.fnX.setCompoundDrawables(drawable, null, null, null);
        this.fnX.setText(B);
    }

    private SpannableString bP(String str, String str2) {
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
        ai.i(this.fnR, d.e.cp_cont_i);
        ai.c(this.gyx, d.e.cp_cont_i, 1);
        ai.c(this.fnL, d.e.cp_cont_i, 1);
        ai.c(this.fnM, d.e.cp_cont_i_alpha60, 1);
        ai.c(this.fnN, d.e.cp_cont_i, 1);
        ai.c(this.fnO, d.e.cp_cont_i_alpha60, 1);
        ai.i(this.fnX, d.e.cp_cont_i);
        this.fnN.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable v = ai.v(i, d.g.icon_floor_praised);
        v.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        this.fnX.setCompoundDrawables(v, null, null, null);
    }

    @Override // com.baidu.tieba.view.j
    public void F(float f) {
        if (!this.fnK.isShown()) {
            this.fnK.setVisibility(0);
            this.fnK.setImageDrawable(this.mContext.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.czE, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.fnK.startAnimation(rotateAnimation);
        this.czE = f;
    }

    @Override // com.baidu.tieba.view.j
    public void ajJ() {
        this.fnK.clearAnimation();
        this.fnK.setImageDrawable(null);
        this.fnK.setVisibility(8);
    }

    @Override // com.baidu.tieba.view.j
    public void lh() {
        if (!this.fnK.isShown()) {
            this.fnK.setVisibility(0);
            this.fnK.setImageDrawable(this.mContext.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        this.fnK.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, d.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.view.j
    public void onDestory() {
        if (this.fnT != null) {
            this.fnT.clearAnimation();
        }
    }
}
