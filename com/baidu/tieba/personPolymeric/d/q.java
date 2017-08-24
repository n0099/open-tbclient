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
    View.OnClickListener avX;
    private float czE;
    private ImageView fnM;
    private TextView fnN;
    private TextView fnO;
    private TextView fnP;
    private TextView fnQ;
    private View fnR;
    private View fnS;
    private TextView fnT;
    private int fnU;
    private TextView fnV;
    private TextView fnW;
    private Animation fnX;
    private Animation fnY;
    private TextView fnZ;
    private TbPageContext oW;

    static /* synthetic */ int j(q qVar) {
        int i = qVar.fnU;
        qVar.fnU = i + 1;
        return i;
    }

    public q(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity(), z);
        this.czE = 360.0f;
        this.fnU = 0;
        this.avX = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.q.4
            com.baidu.tieba.personPolymeric.event.a fob = new com.baidu.tieba.personPolymeric.event.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.fgG != null) {
                    this.fob.cbk = -1;
                    if (q.this.gyt != view) {
                        if (q.this.gyv != view) {
                            if (q.this.gyw != view) {
                                if (q.this.gys != view) {
                                    if (q.this.gyy != view) {
                                        if (q.this.fnP != view) {
                                            if (q.this.fnS == view) {
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
                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(q.this.mContext, q.this.mUserData.getUserId(), q.this.mUserData.getUserName(), q.this.mUserData.getPortrait(), q.this.mUserData.getSex(), q.this.blT)));
                                                        }
                                                    } else {
                                                        BdToast.b(q.this.mContext, String.format(q.this.mContext.getString(d.l.person_privacy_toast), al.cY(q.this.mUserData.getSex())), d.g.icon_toast_game_error).tA();
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else if ((q.this.apH == view || q.this.fnO == view) && q.this.blT) {
                                                this.fob.cbl = new Bundle();
                                                this.fob.cbl.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                                                if (q.this.gyA != null && q.this.gyA.fmc != null) {
                                                    this.fob.cbl.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, q.this.gyA.fmc.left_days.intValue());
                                                }
                                                this.fob.cbk = 11;
                                            }
                                        } else {
                                            this.fob.cbk = 14;
                                        }
                                    } else {
                                        this.fob.cbk = 13;
                                    }
                                } else {
                                    this.fob.cbk = 10;
                                    this.fob.cbl = new Bundle();
                                    this.fob.cbl.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                                }
                            } else {
                                this.fob.cbk = 3;
                                this.fob.cbl = new Bundle();
                                this.fob.cbl.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                            }
                        } else {
                            this.fob.cbk = 2;
                            this.fob.cbl = new Bundle();
                            if (q.this.mUserData != null && !u.v(q.this.mUserData.getTShowInfo())) {
                                this.fob.cbl.putString("vip_user_jump", q.this.mUserData.getTShowInfo().get(0).getUrl());
                            }
                        }
                    } else {
                        this.fob.cbk = 1;
                        this.fob.cbl = new Bundle();
                        this.fob.cbl.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                    }
                    q.this.fgG.a(view, this.fob);
                }
            }
        };
        this.oW = tbPageContext;
        TextView textView = this.gyx;
        if (this.blT) {
        }
        textView.setVisibility(8);
        if (this.fnR != null && this.blT) {
            this.fnR.setVisibility(8);
        }
        if (this.fnT != null) {
            this.fnT.setVisibility(this.blT ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.j
    public View UE() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.j
    public void P(View view) {
        this.gys = (BdExpandImageView) view.findViewById(d.h.person_polymeric_header_expand_img);
        this.fnM = (ImageView) view.findViewById(d.h.person_polymeric_header_refresh_image);
        this.gyt = (HeadPendantView) view.findViewById(d.h.person_polymeric_header_user_img);
        this.gyu = (TbImageView) view.findViewById(d.h.person_polymeric_header_god_user_icon);
        this.gyv = (UserIconBox) view.findViewById(d.h.person_polymeric_header_user_vip_icon);
        this.apH = (TextView) view.findViewById(d.h.person_polymeric_header_user_name_txt);
        this.gyy = (TextView) view.findViewById(d.h.seal_prefix_view);
        this.gyw = (UserIconBox) view.findViewById(d.h.person_polymeric_header_label_box);
        this.fnN = (TextView) view.findViewById(d.h.person_polymeric_header_bar_age_txt);
        this.gyx = (TextView) view.findViewById(d.h.person_polymeric_header_visitor_txt);
        this.fnO = (TextView) view.findViewById(d.h.person_polymeric_header_sign_txt);
        this.fnP = (TextView) view.findViewById(d.h.person_center_header_tdou_txt);
        this.fnQ = (TextView) view.findViewById(d.h.space_line);
        this.fnR = view.findViewById(d.h.person_polymeric_header_alaentry_layout_root);
        this.fnS = view.findViewById(d.h.person_polymeric_header_alaentry_layout);
        this.fnZ = (TextView) view.findViewById(d.h.person_praise_number);
        this.fnT = (TextView) view.findViewById(d.h.person_polymeric_header_bigV_entrance);
        this.fnP.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gyz = (PersonHeaderAttentionView) view.findViewById(d.h.person_center_header_attention_container);
        bxi();
        this.fnX = AnimationUtils.loadAnimation(this.mContext, d.a.user_live_info_fadeout);
        this.fnX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.d.q.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                q.this.fnS.setAnimation(q.this.fnY);
                if (q.this.fnU % 2 == 1) {
                    if (q.this.mUserData.getLiveStatus() == 1) {
                        q.this.fnS.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(0);
                        q.this.fnW.setVisibility(8);
                        q.this.fnV.setText(q.this.mContext.getResources().getString(d.l.person_polymeric_ala_entry_live));
                    } else {
                        q.this.fnS.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(8);
                        q.this.fnW.setVisibility(0);
                        q.this.fnV.setText(q.this.mContext.getResources().getString(d.l.go_to_live_post_prefix));
                    }
                } else {
                    q.this.fnS.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(8);
                    q.this.fnW.setVisibility(0);
                    q.this.fnV.setText(q.this.mContext.getResources().getString(d.l.person_polymeric_ala_live_title));
                }
                q.j(q.this);
                q.this.fnY.start();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fnY = AnimationUtils.loadAnimation(this.mContext, d.a.user_live_info_easeout);
        this.fnY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.d.q.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                q.this.fnS.setAnimation(q.this.fnX);
                q.this.fnX.start();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fnT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.q.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.adp.lib.util.k.hI()) {
                    q.this.oW.showToast(d.l.no_network_guide);
                } else {
                    at.wg().c(q.this.oW, new String[]{TbConfig.BIG_V_APPLAY});
                }
            }
        });
    }

    @Override // com.baidu.tieba.view.j
    protected void aeE() {
        super.aeE();
        this.gyv.setOnClickListener(this.avX);
        this.gyw.setOnClickListener(this.avX);
        this.gys.setOnClickListener(this.avX);
        this.gyt.setOnClickListener(this.avX);
        this.gyx.setOnClickListener(this.avX);
        this.gyy.setOnClickListener(this.avX);
        this.fnP.setOnClickListener(this.avX);
        this.fnS.setOnClickListener(this.avX);
        this.apH.setOnClickListener(this.avX);
        this.fnO.setOnClickListener(this.avX);
    }

    @Override // com.baidu.tieba.view.j
    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            super.e(aVar);
            this.fnN.setText(String.format(this.mContext.getString(d.l.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.blT) {
                this.fnQ.setVisibility(0);
                this.fnP.setVisibility(0);
                this.fnQ.setText("|");
                this.fnP.setText(bQ(al.I(this.mUserData.getTDouNum()) + "   |   " + this.mContext.getString(d.l.get_tdou), "   |   "));
            } else {
                this.fnQ.setVisibility(8);
                this.fnP.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                intro = this.mContext.getString(d.l.no_person_sign);
            }
            if (intro.length() > 45) {
                intro = intro.substring(0, 45) + "...";
            }
            this.fnO.setText(intro);
            this.fnV = (TextView) this.fnS.findViewById(d.h.person_polymeric_header_alaentry_status);
            this.fnW = (TextView) this.fnS.findViewById(d.h.person_polymeric_header_alalevel);
            ImageView imageView = (ImageView) this.fnS.findViewById(d.h.person_polymeric_header_livepoint);
            this.fnS.clearAnimation();
            if (this.mUserData.getLiveStatus() == 1) {
                this.fnW.setVisibility(8);
                imageView.setVisibility(0);
                this.fnV.setText(this.mContext.getResources().getString(d.l.person_polymeric_ala_entry_live));
                this.fnW.setText(Integer.toString(this.mUserData.getLiveLevel()));
            } else {
                imageView.setVisibility(8);
                this.fnV.setText(this.mContext.getResources().getString(d.l.person_polymeric_ala_live_title));
                this.fnW.setVisibility(0);
                this.fnW.setText(Integer.toString(this.mUserData.getLiveLevel()));
            }
            a(aVar.fmb);
            if (this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Cy() != 3) {
                if (this.mUserData.getPersonPrivate().Cy() != 2 || this.mUserData.getIsFriend() == 1) {
                    this.fnS.setAnimation(this.fnX);
                    this.fnX.start();
                }
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.fnZ.setVisibility(8);
            return;
        }
        this.fnZ.setVisibility(0);
        String B = al.B(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = ai.getDrawable(d.g.icon_floor_praised);
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        this.fnZ.setCompoundDrawables(drawable, null, null, null);
        this.fnZ.setText(B);
    }

    private SpannableString bQ(String str, String str2) {
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
        ai.i(this.fnT, d.e.cp_cont_i);
        ai.c(this.gyx, d.e.cp_cont_i, 1);
        ai.c(this.fnN, d.e.cp_cont_i, 1);
        ai.c(this.fnO, d.e.cp_cont_i_alpha60, 1);
        ai.c(this.fnP, d.e.cp_cont_i, 1);
        ai.c(this.fnQ, d.e.cp_cont_i_alpha60, 1);
        ai.i(this.fnZ, d.e.cp_cont_i);
        this.fnP.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable v = ai.v(i, d.g.icon_floor_praised);
        v.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        this.fnZ.setCompoundDrawables(v, null, null, null);
    }

    @Override // com.baidu.tieba.view.j
    public void F(float f) {
        if (!this.fnM.isShown()) {
            this.fnM.setVisibility(0);
            this.fnM.setImageDrawable(this.mContext.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.czE, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.fnM.startAnimation(rotateAnimation);
        this.czE = f;
    }

    @Override // com.baidu.tieba.view.j
    public void ajD() {
        this.fnM.clearAnimation();
        this.fnM.setImageDrawable(null);
        this.fnM.setVisibility(8);
    }

    @Override // com.baidu.tieba.view.j
    public void lg() {
        if (!this.fnM.isShown()) {
            this.fnM.setVisibility(0);
            this.fnM.setImageDrawable(this.mContext.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        this.fnM.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, d.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.view.j
    public void onDestory() {
        if (this.fnV != null) {
            this.fnV.clearAnimation();
        }
    }
}
