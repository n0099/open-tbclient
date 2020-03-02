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
    private com.baidu.tieba.pb.a.c dqK;
    private View.OnClickListener gqq;
    private PbFragment iDY;
    private UserIconBox iFU;
    private UserIconBox iFV;
    private com.baidu.tieba.c.d iQQ;
    private ImageView iQS;
    private com.baidu.tieba.pb.pb.main.e iQT;
    private ThreadSkinView iQV;
    private ImageView iQY;
    private HeadPendantView iQZ;
    private TBLottieAnimationView iRa;
    private LinearLayout iRc;
    private LinearLayout iRd;
    private al iRg;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout iQR = null;
    private ColumnLayout iQU = null;
    private TextView iQW = null;
    private TextView iQX = null;
    private FrameLayout iRb = null;
    private ClickableHeaderImageView iRe = null;
    private PbFirstFloorUserLikeButton iRf = null;
    private TextView iRh = null;
    private TextView iRi = null;
    private TextView iRj = null;
    private TextView iRk = null;
    private int iRl = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.gqq = null;
        this.iDY = pbFragment;
        this.dqK = cVar;
        this.gqq = onClickListener;
        int dimens = l.getDimens(this.iDY.getContext(), R.dimen.tbds6);
        this.Nu = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHd(), com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(dimens).tM("#4D000000").aHd()});
        this.Nv = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHd(), com.baidu.tbadk.core.util.f.a.b.aHb().kB(0).af(dimens).tM("#4D000000").aHd()});
        initView();
    }

    private void initView() {
        this.iQR = (RelativeLayout) LayoutInflater.from(this.iDY.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.iQS = (ImageView) this.iQR.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.iQS.getLayoutParams().height = am.cpc();
        this.iQT = new com.baidu.tieba.pb.pb.main.e(this.iDY.getBaseFragmentActivity(), this.iQR);
        this.iQT.init();
        this.iQT.setOnClickListener(this.iQT.clL(), this.gqq);
        this.iQU = (ColumnLayout) this.iQR.findViewById(R.id.pb_head_owner_root);
        this.iQV = (ThreadSkinView) this.iQR.findViewById(R.id.pb_thread_skin);
        this.iQW = (TextView) this.iQU.findViewById(R.id.pb_head_owner_info_user_name);
        this.iQW.getPaint().setFakeBoldText(true);
        this.iQX = (TextView) this.iQU.findViewById(R.id.floor_owner);
        this.iQY = (ImageView) this.iQU.findViewById(R.id.icon_forum_level);
        this.iRb = (FrameLayout) this.iQU.findViewById(R.id.pb_head_headImage_container);
        this.iQZ = (HeadPendantView) this.iQU.findViewById(R.id.pb_pendant_head_owner_photo);
        this.iQZ.setHasPendantStyle();
        this.iRa = (TBLottieAnimationView) this.iQU.findViewById(R.id.pb_head_living_lottie);
        this.iQU.setOnLongClickListener(this.mOnLongClickListener);
        this.iQU.setOnTouchListener(this.dqK);
        this.iQU.setVisibility(8);
        if (this.iQZ.getHeadView() != null) {
            this.iQZ.getHeadView().setIsRound(true);
            this.iQZ.getHeadView().setDrawBorder(false);
            this.iQZ.getHeadView().setPlaceHolder(1);
        }
        this.iFU = (UserIconBox) this.iQU.findViewById(R.id.show_icon_vip);
        this.iFV = (UserIconBox) this.iQU.findViewById(R.id.show_icon_yinji);
        this.iRc = (LinearLayout) this.iQR.findViewById(R.id.pb_head_owner_info_root);
        this.iRd = (LinearLayout) this.iQU.findViewById(R.id.pb_first_floor_location_container);
        this.iRf = (PbFirstFloorUserLikeButton) this.iQU.findViewById(R.id.pb_like_button);
        this.iRh = (TextView) this.iQU.findViewById(R.id.pb_views);
        this.iRi = (TextView) this.iQU.findViewById(R.id.pb_item_first_floor_reply_time);
        this.iRj = (TextView) this.iQU.findViewById(R.id.pb_item_first_floor_location_address);
        this.iRk = (TextView) this.iQU.findViewById(R.id.pb_item_first_floor_bjh_desc);
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
        if (postData != null && postData.aCo() != null) {
            MetaData aCo = postData.aCo();
            String string = aCo.getName_show() == null ? StringUtils.string(aCo.getUserName()) : StringUtils.string(aCo.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.aCo().getSealPrefix())) {
                i2 = k.byteLength(aCo.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = aCo.getIconInfo();
                    tShowInfoNew = aCo.getTShowInfoNew();
                    if (this.iFV != null) {
                        this.iFV.setTag(R.id.tag_user_id, aCo.getUserId());
                        if (this.iDY.cni() != null) {
                            this.iFV.setOnClickListener(this.iDY.cni().iEk.iSE);
                        }
                        this.iFV.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.iFU != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.iFU.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.iDY.cni() != null) {
                            this.iFU.setOnClickListener(this.iDY.cni().iEk.iSF);
                        }
                        this.iFU.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.iQW.setText(cB(aCo.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.iQW.setTag(R.id.tag_user_id, aCo.getUserId());
                    this.iQW.setTag(R.id.tag_user_name, aCo.getName_show());
                    if (v.isEmpty(tShowInfoNew) || aCo.isBigV()) {
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iQW, R.color.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iQW, R.color.cp_cont_b, 1);
                    }
                    if (!eVar.ckS()) {
                        this.iQX.setVisibility(8);
                    } else if (aCo.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aCo.getBawu_type())) {
                        this.iQX.setText(R.string.bawu_member_bazhu_tip);
                        this.iQX.setVisibility(0);
                        if (i == 1) {
                            if (this.Nu.getDrawable(1) != null) {
                                this.Nu.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nu.getDrawable(1) != null) {
                            this.Nu.getDrawable(1).setAlpha(0);
                        }
                        this.iQX.setBackgroundDrawable(this.Nu);
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iQX, (int) R.color.cp_cont_a);
                    } else if (aCo.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aCo.getBawu_type())) {
                        this.iQX.setText(R.string.bawu_member_xbazhu_tip);
                        this.iQX.setVisibility(0);
                        if (i == 1) {
                            if (this.Nv.getDrawable(1) != null) {
                                this.Nv.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.Nv.getDrawable(1) != null) {
                            this.Nv.getDrawable(1).setAlpha(0);
                        }
                        this.iQX.setBackgroundDrawable(this.Nv);
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iQX, (int) R.color.cp_cont_a);
                    } else {
                        this.iQX.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                        this.iRi.setText(aq.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.iRi.setText(aq.getFormatTime(postData.getTime()));
                    }
                    if (!eVar.ckS()) {
                        this.iRj.setVisibility(8);
                        if (this.iRd.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.iRd.getLayoutParams()).rightMargin = 0;
                        }
                        this.iQU.setSpacingRight(0);
                        String str = null;
                        if (aCo.getBaijiahaoInfo() != null) {
                            str = aCo.getBaijiahaoInfo().auth_desc;
                        }
                        if (!StringUtils.isNull(str)) {
                            this.iRk.setVisibility(0);
                            this.iRk.setText(str);
                        } else {
                            this.iRk.setVisibility(8);
                        }
                    } else {
                        this.iRk.setVisibility(8);
                        if (this.iRd.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.iRd.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.iQU.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        f cLd = postData.cLd();
                        if (cLd != null && !TextUtils.isEmpty(cLd.getName()) && !TextUtils.isEmpty(cLd.getName().trim())) {
                            this.iRj.setVisibility(0);
                            this.iRj.setText(cLd.getName());
                        } else {
                            this.iRj.setVisibility(8);
                        }
                    }
                    if (eVar.cku().aCo() != null || eVar.cku().aCo().getAlaUserData() == null) {
                        z = false;
                    } else if (eVar.cku().aCo().getAlaUserData().live_status != 1) {
                        z = false;
                    } else {
                        cqI();
                        z = true;
                    }
                    if (z) {
                        this.iQZ.a(aCo, 0);
                        this.iQZ.setIsclearmode(false);
                    } else {
                        this.iQZ.setIsclearmode(true);
                    }
                    this.iQZ.setVisibility(0);
                    if (this.iRe != null) {
                        this.iRe.setVisibility(8);
                    }
                    this.iQW.setOnClickListener(onClickListener);
                    this.iQZ.getHeadView().setUserId(aCo.getUserId());
                    this.iQZ.getHeadView().setUserName(aCo.getUserName());
                    this.iQZ.getHeadView().setTid(postData.getId());
                    this.iQZ.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.iQZ.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.iQZ.tT(aCo.getAvater());
                    } else {
                        this.iQZ.a(aCo);
                    }
                    String name_show = aCo.getName_show();
                    String userName = aCo.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.iQW.setText(com.baidu.tieba.pb.c.ba(this.iDY.getPageContext().getPageActivity(), this.iQW.getText().toString()));
                        this.iQW.setGravity(16);
                        this.iQW.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.ckd());
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.iQW, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = aCo.getIconInfo();
                tShowInfoNew = aCo.getTShowInfoNew();
                if (this.iFV != null) {
                }
                if (this.iFU != null) {
                }
                this.iQW.setText(cB(aCo.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.iQW.setTag(R.id.tag_user_id, aCo.getUserId());
                this.iQW.setTag(R.id.tag_user_name, aCo.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iQW, R.color.cp_cont_h, 1);
                if (!eVar.ckS()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                }
                if (!eVar.ckS()) {
                }
                if (eVar.cku().aCo() != null) {
                }
                z = false;
                if (z) {
                }
                this.iQZ.setVisibility(0);
                if (this.iRe != null) {
                }
                this.iQW.setOnClickListener(onClickListener);
                this.iQZ.getHeadView().setUserId(aCo.getUserId());
                this.iQZ.getHeadView().setUserName(aCo.getUserName());
                this.iQZ.getHeadView().setTid(postData.getId());
                this.iQZ.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.iQZ.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = aCo.getName_show();
                String userName2 = aCo.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.iQW.setText(com.baidu.tieba.pb.c.ba(this.iDY.getPageContext().getPageActivity(), this.iQW.getText().toString()));
                    this.iQW.setGravity(16);
                    this.iQW.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.ckd());
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.iQW, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = aCo.getIconInfo();
                    tShowInfoNew = aCo.getTShowInfoNew();
                    if (this.iFV != null) {
                    }
                    if (this.iFU != null) {
                    }
                    this.iQW.setText(cB(aCo.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.iQW.setTag(R.id.tag_user_id, aCo.getUserId());
                    this.iQW.setTag(R.id.tag_user_name, aCo.getName_show());
                    if (v.isEmpty(tShowInfoNew)) {
                    }
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.iQW, R.color.cp_cont_h, 1);
                    if (!eVar.ckS()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                    }
                    if (!eVar.ckS()) {
                    }
                    if (eVar.cku().aCo() != null) {
                    }
                    z = false;
                    if (z) {
                    }
                    this.iQZ.setVisibility(0);
                    if (this.iRe != null) {
                    }
                    this.iQW.setOnClickListener(onClickListener);
                    this.iQZ.getHeadView().setUserId(aCo.getUserId());
                    this.iQZ.getHeadView().setUserName(aCo.getUserName());
                    this.iQZ.getHeadView().setTid(postData.getId());
                    this.iQZ.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.iQZ.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = aCo.getName_show();
                    String userName22 = aCo.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = aCo.getIconInfo();
                tShowInfoNew = aCo.getTShowInfoNew();
                if (this.iFV != null) {
                }
                if (this.iFU != null) {
                }
                this.iQW.setText(cB(aCo.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.iQW.setTag(R.id.tag_user_id, aCo.getUserId());
                this.iQW.setTag(R.id.tag_user_name, aCo.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iQW, R.color.cp_cont_h, 1);
                if (!eVar.ckS()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                }
                if (!eVar.ckS()) {
                }
                if (eVar.cku().aCo() != null) {
                }
                z = false;
                if (z) {
                }
                this.iQZ.setVisibility(0);
                if (this.iRe != null) {
                }
                this.iQW.setOnClickListener(onClickListener);
                this.iQZ.getHeadView().setUserId(aCo.getUserId());
                this.iQZ.getHeadView().setUserName(aCo.getUserName());
                this.iQZ.getHeadView().setTid(postData.getId());
                this.iQZ.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.iQZ.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = aCo.getName_show();
                String userName222 = aCo.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (eVar != null) {
            this.iQT.aF(eVar.cku());
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z) {
        if (eVar != null && postData != null) {
            if (3 != eVar.ckV()) {
                this.iRf.setVisibility(0);
            }
            if (z) {
                this.iRf.setVisibility(8);
                if (eVar != null && eVar.cku() != null && eVar.cku().getBaijiahaoData() != null && eVar.cku().getBaijiahaoData().oriUgcType == 3) {
                    this.iRh.setVisibility(8);
                } else {
                    this.iRh.setVisibility(0);
                }
                this.iRh.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), aq.numberUniformFormatExtra(eVar.ckO())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aCo().hadConcerned()) {
                this.iRf.setVisibility(8);
                this.iRh.setVisibility(8);
            } else {
                this.iRh.setVisibility(8);
            }
            if (eVar.iBG || 3 == eVar.ckV()) {
                this.iRf.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z, boolean z2) {
        if (eVar != null && postData != null) {
            String threadId = eVar != null ? eVar.getThreadId() : "";
            int A = A(eVar);
            if (z && postData != null && postData.aCo() != null) {
                postData.aCo().setIsLike(postData.aCo().hadConcerned());
            }
            if (this.iRg == null) {
                bj cku = eVar.cku();
                int i = 1;
                if (cku != null) {
                    if (cku.aBd()) {
                        i = 4;
                    } else if (cku.aBe()) {
                        i = 6;
                    } else if (cku.aEh()) {
                        i = 7;
                    } else if (cku.aEg()) {
                        i = 5;
                    }
                }
                this.iRg = new al(this.iDY.getPageContext(), this.iRf, i);
                this.iRg.j(this.iDY.getUniqueId());
                this.iRg.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void fV(boolean z3) {
                        if (d.this.iDY != null && z3) {
                            l.showToast(d.this.iDY.getBaseFragmentActivity(), (int) R.string.attention_success);
                        }
                    }
                });
            }
            if (postData != null && postData.aCo() != null) {
                postData.aCo().setIsLike(postData.aCo().hadConcerned());
                this.iRg.a(postData.aCo());
                this.iRg.setTid(threadId);
            }
            this.iRg.iNE = z2;
            this.iRg.zc(A);
        }
    }

    public int A(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cku() == null) {
            return 0;
        }
        if (eVar.cku().aDG()) {
            return (v.isEmpty(eVar.ckN()) && (eVar.ckt() == null || StringUtils.isNull(eVar.ckt().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        if (postData != null && eVar != null) {
            if (postData.aCJ() != null) {
                this.iQV.setData(this.iDY.getPageContext(), eVar.ckw().get(0).aCJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", eVar.getForum().getId(), eVar.getForum().getName(), eVar.cku().getId(), this.iDY.aEc() ? "FRS" : null));
                this.iQU.setPadding(this.iQU.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.iQU.getPaddingRight(), this.iQU.getPaddingBottom());
                return;
            }
            this.iQV.setData(null, null, null);
        }
    }

    public void a(PostData postData, boolean z) {
        if (this.iDY.clr()) {
            this.iRl = 0;
            if (postData != null && postData.aCo() != null) {
                this.iRl = postData.aCo().getLevel_id();
            }
            if (this.iRl > 0 && !z) {
                this.iQY.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(this.iQY, BitmapHelper.getGradeResourceIdInEnterForum(this.iRl));
                return;
            }
            this.iQY.setVisibility(8);
            return;
        }
        this.iQY.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.aHK()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.iQU.getPaddingBottom();
            if (eVar.ckS()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.iQU.setPadding(this.iQU.getPaddingLeft(), dimens, this.iQU.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.iQU.getPaddingBottom();
        if (eVar != null && !eVar.cku().aBb() && eVar.ckS() && (!StringUtils.isNull(eVar.cku().getTitle()) || eVar.cku().aCV() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.iQU.setPadding(this.iQU.getPaddingLeft(), dimens2, this.iQU.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.iQU.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.iQR);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.iQR, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.iQR);
        }
    }

    public void setVisibility(int i) {
        this.iQU.setVisibility(i);
    }

    private void cqI() {
        if (this.iRa != null) {
            this.iRa.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iRa.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.iDY.cni(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.iDY.cni(), R.dimen.ds8);
            this.iRa.setLayoutParams(layoutParams);
            this.iRa.loop(true);
            this.iRa.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.iRa.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.iBH) {
            this.iQS.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iQS.setVisibility(0);
        } else if (z && z2) {
            this.iQS.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iQS.setVisibility(0);
        } else if (z) {
            this.iQS.setImageResource(R.drawable.pic_pb_refined_n);
            this.iQS.setVisibility(0);
        } else if (z2) {
            this.iQS.setImageResource(R.drawable.pic_pb_stick_n);
            this.iQS.setVisibility(0);
        } else {
            this.iQS.setVisibility(8);
        }
    }

    private SpannableStringBuilder cB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str));
            return com.baidu.tieba.card.l.a((Context) this.iDY.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> cqJ() {
        SparseArray<Object> sparseArray = (SparseArray) this.iQU.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.iQU.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView clL() {
        return this.iQT.clL();
    }

    public void pB(boolean z) {
        this.iQT.pB(z);
    }

    public void onChangeSkinType(int i) {
        if (this.iQY != null) {
            com.baidu.tbadk.core.util.am.setImageResource(this.iQY, BitmapHelper.getGradeResourceIdInEnterForum(this.iRl));
        }
        if (this.iRf != null) {
            this.iRf.onChangeSkinType(i);
        }
        if (this.iRj != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iRj, (int) R.color.cp_cont_d);
        }
        if (this.iRi != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iRi, (int) R.color.cp_cont_d);
        }
        if (this.iRh != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iRh, (int) R.color.cp_cont_d);
        }
        if (this.iRk != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iRk, (int) R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.iRa != null) {
                this.iRa.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.iRa != null) {
                this.iRa.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.iRa != null) {
            this.iRa.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.iQQ != null) {
            this.iQQ.zz();
        }
        if (this.iQU != null && this.iRe != null) {
            this.iQU.removeView(this.iRb);
            this.iRe = null;
        }
        if (this.iRa != null) {
            this.iRa.cancelAnimation();
        }
    }

    public void cpY() {
        if (this.iQQ != null) {
            this.iQQ.zz();
        }
    }
}
