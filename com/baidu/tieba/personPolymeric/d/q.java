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
    private TbPageContext ako;
    View.OnClickListener auE;
    private float cwm;
    private ImageView fkF;
    private TextView fkG;
    private TextView fkH;
    private TextView fkI;
    private TextView fkJ;
    private View fkK;
    private View fkL;
    private TextView fkM;
    private int fkN;
    private TextView fkO;
    private TextView fkP;
    private Animation fkQ;
    private Animation fkR;
    private TextView fkS;

    static /* synthetic */ int j(q qVar) {
        int i = qVar.fkN;
        qVar.fkN = i + 1;
        return i;
    }

    public q(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity(), z);
        this.cwm = 360.0f;
        this.fkN = 0;
        this.auE = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.q.4
            com.baidu.tieba.personPolymeric.event.a fkU = new com.baidu.tieba.personPolymeric.event.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.fdz != null) {
                    this.fkU.bZr = -1;
                    if (q.this.gvq != view) {
                        if (q.this.gvs != view) {
                            if (q.this.gvt != view) {
                                if (q.this.gvp != view) {
                                    if (q.this.gvv != view) {
                                        if (q.this.fkI != view) {
                                            if (q.this.fkL == view) {
                                                if (q.this.mUserData != null) {
                                                    if (!com.baidu.adp.lib.util.i.hh()) {
                                                        com.baidu.adp.lib.util.k.showToast(q.this.mContext, d.l.neterror);
                                                        return;
                                                    }
                                                    aj ajVar = new aj("c11855");
                                                    ajVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                                                    ajVar.aa("click_uid", q.this.mUserData.getUserId());
                                                    ajVar.r("live_status", q.this.mUserData.getLiveStatus());
                                                    TiebaStatic.log(ajVar);
                                                    if (q.this.mUserData.getPersonPrivate().Cq() != 3 && (q.this.mUserData.getPersonPrivate().Cq() != 2 || q.this.mUserData.getIsFriend() == 1)) {
                                                        if (q.this.mUserData.getLiveStatus() == 1) {
                                                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                                                            alaLiveInfoCoreData.setLiveID(Long.parseLong(q.this.mUserData.getLiveId()));
                                                            alaLiveInfoCoreData.setUserID(Long.parseLong(q.this.mUserData.getUserId()));
                                                            alaLiveInfoCoreData.setUserName(q.this.mUserData.getUserName());
                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(q.this.mContext, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, q.this.mUserData.getUserId(), false, "")));
                                                        } else {
                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(q.this.mContext, q.this.mUserData.getUserId(), q.this.mUserData.getUserName(), q.this.mUserData.getPortrait(), q.this.mUserData.getSex(), q.this.bkz)));
                                                        }
                                                    } else {
                                                        BdToast.b(q.this.mContext, String.format(q.this.mContext.getString(d.l.person_privacy_toast), al.cW(q.this.mUserData.getSex())), d.g.icon_toast_game_error).tp();
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else if ((q.this.aom == view || q.this.fkH == view) && q.this.bkz) {
                                                this.fkU.bZs = new Bundle();
                                                this.fkU.bZs.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                                                if (q.this.gvx != null && q.this.gvx.fiV != null) {
                                                    this.fkU.bZs.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, q.this.gvx.fiV.left_days.intValue());
                                                }
                                                this.fkU.bZr = 11;
                                            }
                                        } else {
                                            this.fkU.bZr = 14;
                                        }
                                    } else {
                                        this.fkU.bZr = 13;
                                    }
                                } else {
                                    this.fkU.bZr = 10;
                                    this.fkU.bZs = new Bundle();
                                    this.fkU.bZs.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                                }
                            } else {
                                this.fkU.bZr = 3;
                                this.fkU.bZs = new Bundle();
                                this.fkU.bZs.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                            }
                        } else {
                            this.fkU.bZr = 2;
                            this.fkU.bZs = new Bundle();
                            if (q.this.mUserData != null && !u.v(q.this.mUserData.getTShowInfo())) {
                                this.fkU.bZs.putString("vip_user_jump", q.this.mUserData.getTShowInfo().get(0).getUrl());
                            }
                        }
                    } else {
                        this.fkU.bZr = 1;
                        this.fkU.bZs = new Bundle();
                        this.fkU.bZs.putSerializable(UserData.TYPE_USER, q.this.mUserData);
                    }
                    q.this.fdz.a(view, this.fkU);
                }
            }
        };
        this.ako = tbPageContext;
        TextView textView = this.gvu;
        if (this.bkz) {
        }
        textView.setVisibility(8);
        if (this.fkK != null && this.bkz) {
            this.fkK.setVisibility(8);
        }
        if (this.fkM != null) {
            this.fkM.setVisibility(this.bkz ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.j
    public View Uf() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.j
    public void O(View view) {
        this.gvp = (BdExpandImageView) view.findViewById(d.h.person_polymeric_header_expand_img);
        this.fkF = (ImageView) view.findViewById(d.h.person_polymeric_header_refresh_image);
        this.gvq = (HeadPendantView) view.findViewById(d.h.person_polymeric_header_user_img);
        this.gvr = (TbImageView) view.findViewById(d.h.person_polymeric_header_god_user_icon);
        this.gvs = (UserIconBox) view.findViewById(d.h.person_polymeric_header_user_vip_icon);
        this.aom = (TextView) view.findViewById(d.h.person_polymeric_header_user_name_txt);
        this.gvv = (TextView) view.findViewById(d.h.seal_prefix_view);
        this.gvt = (UserIconBox) view.findViewById(d.h.person_polymeric_header_label_box);
        this.fkG = (TextView) view.findViewById(d.h.person_polymeric_header_bar_age_txt);
        this.gvu = (TextView) view.findViewById(d.h.person_polymeric_header_visitor_txt);
        this.fkH = (TextView) view.findViewById(d.h.person_polymeric_header_sign_txt);
        this.fkI = (TextView) view.findViewById(d.h.person_center_header_tdou_txt);
        this.fkJ = (TextView) view.findViewById(d.h.space_line);
        this.fkK = view.findViewById(d.h.person_polymeric_header_alaentry_layout_root);
        this.fkL = view.findViewById(d.h.person_polymeric_header_alaentry_layout);
        this.fkS = (TextView) view.findViewById(d.h.person_praise_number);
        this.fkM = (TextView) view.findViewById(d.h.person_polymeric_header_bigV_entrance);
        this.fkI.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gvw = (PersonHeaderAttentionView) view.findViewById(d.h.person_center_header_attention_container);
        bwA();
        this.fkQ = AnimationUtils.loadAnimation(this.mContext, d.a.user_live_info_fadeout);
        this.fkQ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.d.q.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                q.this.fkL.setAnimation(q.this.fkR);
                if (q.this.fkN % 2 == 1) {
                    if (q.this.mUserData.getLiveStatus() == 1) {
                        q.this.fkL.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(0);
                        q.this.fkP.setVisibility(8);
                        q.this.fkO.setText(q.this.mContext.getResources().getString(d.l.person_polymeric_ala_entry_live));
                    } else {
                        q.this.fkL.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(8);
                        q.this.fkP.setVisibility(0);
                        q.this.fkO.setText(q.this.mContext.getResources().getString(d.l.go_to_live_post_prefix));
                    }
                } else {
                    q.this.fkL.findViewById(d.h.person_polymeric_header_livepoint).setVisibility(8);
                    q.this.fkP.setVisibility(0);
                    q.this.fkO.setText(q.this.mContext.getResources().getString(d.l.person_polymeric_ala_live_title));
                }
                q.j(q.this);
                q.this.fkR.start();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fkR = AnimationUtils.loadAnimation(this.mContext, d.a.user_live_info_easeout);
        this.fkR.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.d.q.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                q.this.fkL.setAnimation(q.this.fkQ);
                q.this.fkQ.start();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fkM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.q.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.adp.lib.util.k.hy()) {
                    q.this.ako.showToast(d.l.no_network_guide);
                } else {
                    at.vV().c(q.this.ako, new String[]{TbConfig.BIG_V_APPLAY});
                }
            }
        });
    }

    @Override // com.baidu.tieba.view.j
    protected void aek() {
        super.aek();
        this.gvs.setOnClickListener(this.auE);
        this.gvt.setOnClickListener(this.auE);
        this.gvp.setOnClickListener(this.auE);
        this.gvq.setOnClickListener(this.auE);
        this.gvu.setOnClickListener(this.auE);
        this.gvv.setOnClickListener(this.auE);
        this.fkI.setOnClickListener(this.auE);
        this.fkL.setOnClickListener(this.auE);
        this.aom.setOnClickListener(this.auE);
        this.fkH.setOnClickListener(this.auE);
    }

    @Override // com.baidu.tieba.view.j
    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            super.e(aVar);
            this.fkG.setText(String.format(this.mContext.getString(d.l.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.bkz) {
                this.fkJ.setVisibility(0);
                this.fkI.setVisibility(0);
                this.fkJ.setText("|");
                this.fkI.setText(bO(al.I(this.mUserData.getTDouNum()) + "   |   " + this.mContext.getString(d.l.get_tdou), "   |   "));
            } else {
                this.fkJ.setVisibility(8);
                this.fkI.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                intro = this.mContext.getString(d.l.no_person_sign);
            }
            if (intro.length() > 45) {
                intro = intro.substring(0, 45) + "...";
            }
            this.fkH.setText(intro);
            this.fkO = (TextView) this.fkL.findViewById(d.h.person_polymeric_header_alaentry_status);
            this.fkP = (TextView) this.fkL.findViewById(d.h.person_polymeric_header_alalevel);
            ImageView imageView = (ImageView) this.fkL.findViewById(d.h.person_polymeric_header_livepoint);
            this.fkL.clearAnimation();
            if (this.mUserData.getLiveStatus() == 1) {
                this.fkP.setVisibility(8);
                imageView.setVisibility(0);
                this.fkO.setText(this.mContext.getResources().getString(d.l.person_polymeric_ala_entry_live));
                this.fkP.setText(Integer.toString(this.mUserData.getLiveLevel()));
            } else {
                imageView.setVisibility(8);
                this.fkO.setText(this.mContext.getResources().getString(d.l.person_polymeric_ala_live_title));
                this.fkP.setVisibility(0);
                this.fkP.setText(Integer.toString(this.mUserData.getLiveLevel()));
            }
            a(aVar.fiU);
            if (this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Cq() != 3) {
                if (this.mUserData.getPersonPrivate().Cq() != 2 || this.mUserData.getIsFriend() == 1) {
                    this.fkL.setAnimation(this.fkQ);
                    this.fkQ.start();
                }
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.fkS.setVisibility(8);
            return;
        }
        this.fkS.setVisibility(0);
        String B = al.B(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = ai.getDrawable(d.g.icon_floor_praised);
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        this.fkS.setCompoundDrawables(drawable, null, null, null);
        this.fkS.setText(B);
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
        ai.i(this.fkM, d.e.cp_cont_i);
        ai.c(this.gvu, d.e.cp_cont_i, 1);
        ai.c(this.fkG, d.e.cp_cont_i, 1);
        ai.c(this.fkH, d.e.cp_cont_i_alpha60, 1);
        ai.c(this.fkI, d.e.cp_cont_i, 1);
        ai.c(this.fkJ, d.e.cp_cont_i_alpha60, 1);
        ai.i(this.fkS, d.e.cp_cont_i);
        this.fkI.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable u = ai.u(i, d.g.icon_floor_praised);
        u.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds32));
        this.fkS.setCompoundDrawables(u, null, null, null);
    }

    @Override // com.baidu.tieba.view.j
    public void F(float f) {
        if (!this.fkF.isShown()) {
            this.fkF.setVisibility(0);
            this.fkF.setImageDrawable(this.mContext.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cwm, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.fkF.startAnimation(rotateAnimation);
        this.cwm = f;
    }

    @Override // com.baidu.tieba.view.j
    public void aiQ() {
        this.fkF.clearAnimation();
        this.fkF.setImageDrawable(null);
        this.fkF.setVisibility(8);
    }

    @Override // com.baidu.tieba.view.j
    public void kX() {
        if (!this.fkF.isShown()) {
            this.fkF.setVisibility(0);
            this.fkF.setImageDrawable(this.mContext.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        this.fkF.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, d.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.view.j
    public void onDestory() {
        if (this.fkO != null) {
            this.fkO.clearAnimation();
        }
    }
}
