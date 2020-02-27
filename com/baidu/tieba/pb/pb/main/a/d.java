package com.baidu.tieba.pb.pb.main.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.al;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes9.dex */
public class d {
    private LayerDrawable Nu;
    private LayerDrawable Nv;
    private com.baidu.tieba.pb.a.c dqJ;
    private View.OnClickListener gqo;
    private PbFragment iDW;
    private UserIconBox iFS;
    private UserIconBox iFT;
    private com.baidu.tieba.c.d iQO;
    private ImageView iQQ;
    private com.baidu.tieba.pb.pb.main.e iQR;
    private ThreadSkinView iQT;
    private ImageView iQW;
    private HeadPendantView iQX;
    private TBLottieAnimationView iQY;
    private LinearLayout iRa;
    private LinearLayout iRb;
    private al iRe;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout iQP = null;
    private ColumnLayout iQS = null;
    private TextView iQU = null;
    private TextView iQV = null;
    private FrameLayout iQZ = null;
    private ClickableHeaderImageView iRc = null;
    private PbFirstFloorUserLikeButton iRd = null;
    private TextView iRf = null;
    private TextView iRg = null;
    private TextView iRh = null;
    private TextView iRi = null;
    private int iRj = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.gqo = null;
        this.iDW = pbFragment;
        this.dqJ = cVar;
        this.gqo = onClickListener;
        int dimens = l.getDimens(this.iDW.getContext(), R.dimen.tbds6);
        this.Nu = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHb(), com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(dimens).tM("#4D000000").aHb()});
        this.Nv = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHb(), com.baidu.tbadk.core.util.f.a.b.aGZ().kB(0).af(dimens).tM("#4D000000").aHb()});
        initView();
    }

    private void initView() {
        this.iQP = (RelativeLayout) LayoutInflater.from(this.iDW.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.iQQ = (ImageView) this.iQP.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.iQQ.getLayoutParams().height = am.cpa();
        this.iQR = new com.baidu.tieba.pb.pb.main.e(this.iDW.getBaseFragmentActivity(), this.iQP);
        this.iQR.init();
        this.iQR.setOnClickListener(this.iQR.clJ(), this.gqo);
        this.iQS = (ColumnLayout) this.iQP.findViewById(R.id.pb_head_owner_root);
        this.iQT = (ThreadSkinView) this.iQP.findViewById(R.id.pb_thread_skin);
        this.iQU = (TextView) this.iQS.findViewById(R.id.pb_head_owner_info_user_name);
        this.iQU.getPaint().setFakeBoldText(true);
        this.iQV = (TextView) this.iQS.findViewById(R.id.floor_owner);
        this.iQW = (ImageView) this.iQS.findViewById(R.id.icon_forum_level);
        this.iQZ = (FrameLayout) this.iQS.findViewById(R.id.pb_head_headImage_container);
        this.iQX = (HeadPendantView) this.iQS.findViewById(R.id.pb_pendant_head_owner_photo);
        this.iQX.setHasPendantStyle();
        this.iQY = (TBLottieAnimationView) this.iQS.findViewById(R.id.pb_head_living_lottie);
        this.iQS.setOnLongClickListener(this.mOnLongClickListener);
        this.iQS.setOnTouchListener(this.dqJ);
        this.iQS.setVisibility(8);
        if (this.iQX.getHeadView() != null) {
            this.iQX.getHeadView().setIsRound(true);
            this.iQX.getHeadView().setDrawBorder(false);
            this.iQX.getHeadView().setPlaceHolder(1);
        }
        this.iFS = (UserIconBox) this.iQS.findViewById(R.id.show_icon_vip);
        this.iFT = (UserIconBox) this.iQS.findViewById(R.id.show_icon_yinji);
        this.iRa = (LinearLayout) this.iQP.findViewById(R.id.pb_head_owner_info_root);
        this.iRb = (LinearLayout) this.iQS.findViewById(R.id.pb_first_floor_location_container);
        this.iRd = (PbFirstFloorUserLikeButton) this.iQS.findViewById(R.id.pb_like_button);
        this.iRf = (TextView) this.iQS.findViewById(R.id.pb_views);
        this.iRg = (TextView) this.iQS.findViewById(R.id.pb_item_first_floor_reply_time);
        this.iRh = (TextView) this.iQS.findViewById(R.id.pb_item_first_floor_location_address);
        this.iRi = (TextView) this.iQS.findViewById(R.id.pb_item_first_floor_bjh_desc);
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0281 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, com.baidu.tieba.pb.data.e eVar, PostData postData, View.OnClickListener onClickListener) {
        String cutChineseAndEnglishWithSuffix;
        ArrayList<IconData> tShowInfoNew;
        boolean z;
        if (postData != null && postData.aCm() != null) {
            MetaData aCm = postData.aCm();
            String string = aCm.getName_show() == null ? StringUtils.string(aCm.getUserName()) : StringUtils.string(aCm.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.aCm().getSealPrefix())) {
                i2 = k.byteLength(aCm.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = aCm.getIconInfo();
                    tShowInfoNew = aCm.getTShowInfoNew();
                    if (this.iFT != null) {
                        this.iFT.setTag(R.id.tag_user_id, aCm.getUserId());
                        if (this.iDW.cng() != null) {
                            this.iFT.setOnClickListener(this.iDW.cng().iEi.iSC);
                        }
                        this.iFT.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.iFS != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.iFS.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.iDW.cng() != null) {
                            this.iFS.setOnClickListener(this.iDW.cng().iEi.iSD);
                        }
                        this.iFS.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.iQU.setText(cB(aCm.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.iQU.setTag(R.id.tag_user_id, aCm.getUserId());
                    this.iQU.setTag(R.id.tag_user_name, aCm.getName_show());
                    if (v.isEmpty(tShowInfoNew) || aCm.isBigV()) {
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iQU, R.color.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iQU, R.color.cp_cont_b, 1);
                    }
                    if (!eVar.ckQ()) {
                        this.iQV.setVisibility(8);
                    } else if (aCm.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aCm.getBawu_type())) {
                        this.iQV.setText(R.string.bawu_member_bazhu_tip);
                        this.iQV.setVisibility(0);
                        if (i == 1) {
                            if (this.Nu.getDrawable(1) != null) {
                                this.Nu.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nu.getDrawable(1) != null) {
                            this.Nu.getDrawable(1).setAlpha(0);
                        }
                        this.iQV.setBackgroundDrawable(this.Nu);
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iQV, (int) R.color.cp_cont_a);
                    } else if (aCm.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aCm.getBawu_type())) {
                        this.iQV.setText(R.string.bawu_member_xbazhu_tip);
                        this.iQV.setVisibility(0);
                        if (i == 1) {
                            if (this.Nv.getDrawable(1) != null) {
                                this.Nv.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nv.getDrawable(1) != null) {
                            this.Nv.getDrawable(1).setAlpha(0);
                        }
                        this.iQV.setBackgroundDrawable(this.Nv);
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iQV, (int) R.color.cp_cont_a);
                    } else {
                        this.iQV.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                        this.iRg.setText(aq.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.iRg.setText(aq.getFormatTime(postData.getTime()));
                    }
                    if (!eVar.ckQ()) {
                        this.iRh.setVisibility(8);
                        if (this.iRb.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.iRb.getLayoutParams()).rightMargin = 0;
                        }
                        this.iQS.setSpacingRight(0);
                        String str = null;
                        if (aCm.getBaijiahaoInfo() != null) {
                            str = aCm.getBaijiahaoInfo().auth_desc;
                        }
                        if (!StringUtils.isNull(str)) {
                            this.iRi.setVisibility(0);
                            this.iRi.setText(str);
                        } else {
                            this.iRi.setVisibility(8);
                        }
                    } else {
                        this.iRi.setVisibility(8);
                        if (this.iRb.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.iRb.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.iQS.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        f cLb = postData.cLb();
                        if (cLb != null && !TextUtils.isEmpty(cLb.getName()) && !TextUtils.isEmpty(cLb.getName().trim())) {
                            this.iRh.setVisibility(0);
                            this.iRh.setText(cLb.getName());
                        } else {
                            this.iRh.setVisibility(8);
                        }
                    }
                    if (eVar.cks().aCm() != null || eVar.cks().aCm().getAlaUserData() == null) {
                        z = false;
                    } else if (eVar.cks().aCm().getAlaUserData().live_status != 1) {
                        z = false;
                    } else {
                        cqG();
                        z = true;
                    }
                    if (z) {
                        this.iQX.a(aCm, 0);
                        this.iQX.setIsclearmode(false);
                    } else {
                        this.iQX.setIsclearmode(true);
                    }
                    this.iQX.setVisibility(0);
                    if (this.iRc != null) {
                        this.iRc.setVisibility(8);
                    }
                    this.iQU.setOnClickListener(onClickListener);
                    this.iQX.getHeadView().setUserId(aCm.getUserId());
                    this.iQX.getHeadView().setUserName(aCm.getUserName());
                    this.iQX.getHeadView().setTid(postData.getId());
                    this.iQX.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.iQX.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.iQX.tT(aCm.getAvater());
                    } else {
                        this.iQX.a(aCm);
                    }
                    String name_show = aCm.getName_show();
                    String userName = aCm.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.iQU.setText(com.baidu.tieba.pb.c.ba(this.iDW.getPageContext().getPageActivity(), this.iQU.getText().toString()));
                        this.iQU.setGravity(16);
                        this.iQU.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.ckb());
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iQU, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = aCm.getIconInfo();
                tShowInfoNew = aCm.getTShowInfoNew();
                if (this.iFT != null) {
                }
                if (this.iFS != null) {
                }
                this.iQU.setText(cB(aCm.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.iQU.setTag(R.id.tag_user_id, aCm.getUserId());
                this.iQU.setTag(R.id.tag_user_name, aCm.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iQU, R.color.cp_cont_h, 1);
                if (!eVar.ckQ()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                }
                if (!eVar.ckQ()) {
                }
                if (eVar.cks().aCm() != null) {
                }
                z = false;
                if (z) {
                }
                this.iQX.setVisibility(0);
                if (this.iRc != null) {
                }
                this.iQU.setOnClickListener(onClickListener);
                this.iQX.getHeadView().setUserId(aCm.getUserId());
                this.iQX.getHeadView().setUserName(aCm.getUserName());
                this.iQX.getHeadView().setTid(postData.getId());
                this.iQX.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.iQX.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = aCm.getName_show();
                String userName2 = aCm.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.iQU.setText(com.baidu.tieba.pb.c.ba(this.iDW.getPageContext().getPageActivity(), this.iQU.getText().toString()));
                    this.iQU.setGravity(16);
                    this.iQU.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.ckb());
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.iQU, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = aCm.getIconInfo();
                    tShowInfoNew = aCm.getTShowInfoNew();
                    if (this.iFT != null) {
                    }
                    if (this.iFS != null) {
                    }
                    this.iQU.setText(cB(aCm.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.iQU.setTag(R.id.tag_user_id, aCm.getUserId());
                    this.iQU.setTag(R.id.tag_user_name, aCm.getName_show());
                    if (v.isEmpty(tShowInfoNew)) {
                    }
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.iQU, R.color.cp_cont_h, 1);
                    if (!eVar.ckQ()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                    }
                    if (!eVar.ckQ()) {
                    }
                    if (eVar.cks().aCm() != null) {
                    }
                    z = false;
                    if (z) {
                    }
                    this.iQX.setVisibility(0);
                    if (this.iRc != null) {
                    }
                    this.iQU.setOnClickListener(onClickListener);
                    this.iQX.getHeadView().setUserId(aCm.getUserId());
                    this.iQX.getHeadView().setUserName(aCm.getUserName());
                    this.iQX.getHeadView().setTid(postData.getId());
                    this.iQX.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.iQX.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = aCm.getName_show();
                    String userName22 = aCm.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = aCm.getIconInfo();
                tShowInfoNew = aCm.getTShowInfoNew();
                if (this.iFT != null) {
                }
                if (this.iFS != null) {
                }
                this.iQU.setText(cB(aCm.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.iQU.setTag(R.id.tag_user_id, aCm.getUserId());
                this.iQU.setTag(R.id.tag_user_name, aCm.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iQU, R.color.cp_cont_h, 1);
                if (!eVar.ckQ()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                }
                if (!eVar.ckQ()) {
                }
                if (eVar.cks().aCm() != null) {
                }
                z = false;
                if (z) {
                }
                this.iQX.setVisibility(0);
                if (this.iRc != null) {
                }
                this.iQU.setOnClickListener(onClickListener);
                this.iQX.getHeadView().setUserId(aCm.getUserId());
                this.iQX.getHeadView().setUserName(aCm.getUserName());
                this.iQX.getHeadView().setTid(postData.getId());
                this.iQX.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.iQX.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = aCm.getName_show();
                String userName222 = aCm.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (eVar != null) {
            this.iQR.aF(eVar.cks());
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z) {
        if (eVar != null && postData != null) {
            if (3 != eVar.ckT()) {
                this.iRd.setVisibility(0);
            }
            if (z) {
                this.iRd.setVisibility(8);
                if (eVar != null && eVar.cks() != null && eVar.cks().getBaijiahaoData() != null && eVar.cks().getBaijiahaoData().oriUgcType == 3) {
                    this.iRf.setVisibility(8);
                } else {
                    this.iRf.setVisibility(0);
                }
                this.iRf.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), aq.numberUniformFormatExtra(eVar.ckM())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aCm().hadConcerned()) {
                this.iRd.setVisibility(8);
                this.iRf.setVisibility(8);
            } else {
                this.iRf.setVisibility(8);
            }
            if (eVar.iBE || 3 == eVar.ckT()) {
                this.iRd.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z, boolean z2) {
        if (eVar != null && postData != null) {
            String threadId = eVar != null ? eVar.getThreadId() : "";
            int A = A(eVar);
            if (z && postData != null && postData.aCm() != null) {
                postData.aCm().setIsLike(postData.aCm().hadConcerned());
            }
            if (this.iRe == null) {
                bj cks = eVar.cks();
                int i = 1;
                if (cks != null) {
                    if (cks.aBb()) {
                        i = 4;
                    } else if (cks.aBc()) {
                        i = 6;
                    } else if (cks.aEf()) {
                        i = 7;
                    } else if (cks.aEe()) {
                        i = 5;
                    }
                }
                this.iRe = new al(this.iDW.getPageContext(), this.iRd, i);
                this.iRe.j(this.iDW.getUniqueId());
                this.iRe.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void fV(boolean z3) {
                        if (d.this.iDW != null && z3) {
                            l.showToast(d.this.iDW.getBaseFragmentActivity(), (int) R.string.attention_success);
                        }
                    }
                });
            }
            if (postData != null && postData.aCm() != null) {
                postData.aCm().setIsLike(postData.aCm().hadConcerned());
                this.iRe.a(postData.aCm());
                this.iRe.setTid(threadId);
            }
            this.iRe.iNC = z2;
            this.iRe.zc(A);
        }
    }

    public int A(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cks() == null) {
            return 0;
        }
        if (eVar.cks().aDE()) {
            return (v.isEmpty(eVar.ckL()) && (eVar.ckr() == null || StringUtils.isNull(eVar.ckr().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        if (postData != null && eVar != null) {
            if (postData.aCH() != null) {
                this.iQT.setData(this.iDW.getPageContext(), eVar.cku().get(0).aCH(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", eVar.getForum().getId(), eVar.getForum().getName(), eVar.cks().getId(), this.iDW.aEa() ? "FRS" : null));
                this.iQS.setPadding(this.iQS.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.iQS.getPaddingRight(), this.iQS.getPaddingBottom());
                return;
            }
            this.iQT.setData(null, null, null);
        }
    }

    public void a(PostData postData, boolean z) {
        if (this.iDW.clp()) {
            this.iRj = 0;
            if (postData != null && postData.aCm() != null) {
                this.iRj = postData.aCm().getLevel_id();
            }
            if (this.iRj > 0 && !z) {
                this.iQW.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(this.iQW, BitmapHelper.getGradeResourceIdInEnterForum(this.iRj));
                return;
            }
            this.iQW.setVisibility(8);
            return;
        }
        this.iQW.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.aHI()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.iQS.getPaddingBottom();
            if (eVar.ckQ()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.iQS.setPadding(this.iQS.getPaddingLeft(), dimens, this.iQS.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.iQS.getPaddingBottom();
        if (eVar != null && !eVar.cks().aAZ() && eVar.ckQ() && (!StringUtils.isNull(eVar.cks().getTitle()) || eVar.cks().aCT() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.iQS.setPadding(this.iQS.getPaddingLeft(), dimens2, this.iQS.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.iQS.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.iQP);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.iQP, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.iQP);
        }
    }

    public void setVisibility(int i) {
        this.iQS.setVisibility(i);
    }

    private void cqG() {
        if (this.iQY != null) {
            this.iQY.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iQY.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.iDW.cng(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.iDW.cng(), R.dimen.ds8);
            this.iQY.setLayoutParams(layoutParams);
            this.iQY.loop(true);
            this.iQY.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.iQY.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.iBF) {
            this.iQQ.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iQQ.setVisibility(0);
        } else if (z && z2) {
            this.iQQ.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iQQ.setVisibility(0);
        } else if (z) {
            this.iQQ.setImageResource(R.drawable.pic_pb_refined_n);
            this.iQQ.setVisibility(0);
        } else if (z2) {
            this.iQQ.setImageResource(R.drawable.pic_pb_stick_n);
            this.iQQ.setVisibility(0);
        } else {
            this.iQQ.setVisibility(8);
        }
    }

    private SpannableStringBuilder cB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str));
            return com.baidu.tieba.card.l.a((Context) this.iDW.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> cqH() {
        SparseArray<Object> sparseArray = (SparseArray) this.iQS.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.iQS.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView clJ() {
        return this.iQR.clJ();
    }

    public void pB(boolean z) {
        this.iQR.pB(z);
    }

    public void onChangeSkinType(int i) {
        if (this.iQW != null) {
            com.baidu.tbadk.core.util.am.setImageResource(this.iQW, BitmapHelper.getGradeResourceIdInEnterForum(this.iRj));
        }
        if (this.iRd != null) {
            this.iRd.onChangeSkinType(i);
        }
        if (this.iRh != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iRh, (int) R.color.cp_cont_d);
        }
        if (this.iRg != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iRg, (int) R.color.cp_cont_d);
        }
        if (this.iRf != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iRf, (int) R.color.cp_cont_d);
        }
        if (this.iRi != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iRi, (int) R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.iQY != null) {
                this.iQY.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.iQY != null) {
                this.iQY.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.iQY != null) {
            this.iQY.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.iQO != null) {
            this.iQO.zx();
        }
        if (this.iQS != null && this.iRc != null) {
            this.iQS.removeView(this.iQZ);
            this.iRc = null;
        }
        if (this.iQY != null) {
            this.iQY.cancelAnimation();
        }
    }

    public void cpW() {
        if (this.iQO != null) {
            this.iQO.zx();
        }
    }
}
