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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ax;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes16.dex */
public class d {
    private LayerDrawable ahB;
    private LayerDrawable ahC;
    private com.baidu.tieba.pb.a.c euG;
    private View.OnClickListener hIl;
    private PbFragment kjZ;
    private UserIconBox kmo;
    private UserIconBox kmp;
    private com.baidu.tieba.c.e kyj;
    private ImageView kyl;
    private f kym;
    private ThreadSkinView kyo;
    private ImageView kyr;
    private HeadPendantView kys;
    private TBLottieAnimationView kyt;
    private LinearLayout kyv;
    private LinearLayout kyw;
    private ax kyz;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout kyk = null;
    private ColumnLayout kyn = null;
    private TextView kyp = null;
    private TextView kyq = null;
    private FrameLayout kyu = null;
    private ClickableHeaderImageView kyx = null;
    private PbFirstFloorUserLikeButton kyy = null;
    private TextView kyA = null;
    private TextView kyB = null;
    private TextView kyC = null;
    private TextView kyD = null;
    private int kyE = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.hIl = null;
        this.kjZ = pbFragment;
        this.euG = cVar;
        this.hIl = onClickListener;
        int dimens = l.getDimens(this.kjZ.getContext(), R.dimen.tbds6);
        this.ahB = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bbx(), com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(dimens).yi("#4D000000").bbx()});
        this.ahC = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bbx(), com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(dimens).yi("#4D000000").bbx()});
        initView();
    }

    private void initView() {
        this.kyk = (RelativeLayout) LayoutInflater.from(this.kjZ.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.kyl = (ImageView) this.kyk.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.kyl.getLayoutParams().height = ay.cPs();
        this.kym = new f(this.kjZ.getBaseFragmentActivity(), this.kyk);
        this.kym.init();
        this.kym.a(this.kym.cLZ(), this.hIl);
        this.kyn = (ColumnLayout) this.kyk.findViewById(R.id.pb_head_owner_root);
        this.kyo = (ThreadSkinView) this.kyk.findViewById(R.id.pb_thread_skin);
        this.kyp = (TextView) this.kyn.findViewById(R.id.pb_head_owner_info_user_name);
        this.kyq = (TextView) this.kyn.findViewById(R.id.floor_owner);
        this.kyr = (ImageView) this.kyn.findViewById(R.id.icon_forum_level);
        this.kyu = (FrameLayout) this.kyn.findViewById(R.id.pb_head_headImage_container);
        this.kys = (HeadPendantView) this.kyn.findViewById(R.id.pb_pendant_head_owner_photo);
        this.kys.setHasPendantStyle();
        this.kyt = (TBLottieAnimationView) this.kyn.findViewById(R.id.pb_head_living_lottie);
        this.kyn.setOnLongClickListener(this.mOnLongClickListener);
        this.kyn.setOnTouchListener(this.euG);
        this.kyn.setVisibility(8);
        if (this.kys.getHeadView() != null) {
            this.kys.getHeadView().setIsRound(true);
            this.kys.getHeadView().setDrawBorder(false);
            this.kys.getHeadView().setPlaceHolder(1);
        }
        this.kmo = (UserIconBox) this.kyn.findViewById(R.id.show_icon_vip);
        this.kmp = (UserIconBox) this.kyn.findViewById(R.id.show_icon_yinji);
        this.kyv = (LinearLayout) this.kyk.findViewById(R.id.pb_head_owner_info_root);
        this.kyw = (LinearLayout) this.kyn.findViewById(R.id.pb_first_floor_location_container);
        this.kyy = (PbFirstFloorUserLikeButton) this.kyn.findViewById(R.id.pb_like_button);
        this.kyA = (TextView) this.kyn.findViewById(R.id.pb_views);
        this.kyB = (TextView) this.kyn.findViewById(R.id.pb_item_first_floor_reply_time);
        this.kyC = (TextView) this.kyn.findViewById(R.id.pb_item_first_floor_location_address);
        this.kyD = (TextView) this.kyn.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View cQZ() {
        return this.kyk;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x028a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0303  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, com.baidu.tieba.pb.data.f fVar, PostData postData, View.OnClickListener onClickListener) {
        String cutChineseAndEnglishWithSuffix;
        ArrayList<IconData> tShowInfoNew;
        boolean z;
        if (postData != null && postData.aWl() != null) {
            MetaData aWl = postData.aWl();
            String string = aWl.getName_show() == null ? StringUtils.string(aWl.getUserName()) : StringUtils.string(aWl.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.aWl().getSealPrefix())) {
                i2 = k.byteLength(aWl.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = as.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = aWl.getIconInfo();
                    tShowInfoNew = aWl.getTShowInfoNew();
                    if (this.kmp != null) {
                        this.kmp.setTag(R.id.tag_user_id, aWl.getUserId());
                        if (this.kjZ.cNt() != null) {
                            this.kmp.setOnClickListener(this.kjZ.cNt().kkl.kzX);
                        }
                        this.kmp.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.kmo != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.kmo.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.kjZ.cNt() != null) {
                            this.kmo.setOnClickListener(this.kjZ.cNt().kkl.kzY);
                        }
                        this.kmo.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.kyp.setText(dp(aWl.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.kyp.setTag(R.id.tag_user_id, aWl.getUserId());
                    this.kyp.setTag(R.id.tag_user_name, aWl.getName_show());
                    if (x.isEmpty(tShowInfoNew) || aWl.isBigV()) {
                        ao.setViewTextColor(this.kyp, R.color.cp_cont_h, 1);
                    } else {
                        ao.setViewTextColor(this.kyp, R.color.cp_cont_b, 1);
                    }
                    if (!fVar.cLa()) {
                        this.kyq.setVisibility(8);
                    } else if (aWl.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aWl.getBawu_type())) {
                        this.kyq.setText(R.string.bawu_member_bazhu_tip);
                        this.kyq.setVisibility(0);
                        if (i == 1) {
                            if (this.ahB.getDrawable(1) != null) {
                                this.ahB.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ahB.getDrawable(1) != null) {
                            this.ahB.getDrawable(1).setAlpha(0);
                        }
                        this.kyq.setBackgroundDrawable(this.ahB);
                        ao.setViewTextColor(this.kyq, R.color.cp_cont_a);
                    } else if (aWl.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aWl.getBawu_type())) {
                        this.kyq.setText(R.string.bawu_member_xbazhu_tip);
                        this.kyq.setVisibility(0);
                        if (i == 1) {
                            if (this.ahC.getDrawable(1) != null) {
                                this.ahC.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ahC.getDrawable(1) != null) {
                            this.ahC.getDrawable(1).setAlpha(0);
                        }
                        this.kyq.setBackgroundDrawable(this.ahC);
                        ao.setViewTextColor(this.kyq, R.color.cp_cont_a);
                    } else {
                        this.kyq.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.kyB.setText(as.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.kyB.setText(as.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.cLa()) {
                        this.kyC.setVisibility(8);
                        if (this.kyw.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.kyw.getLayoutParams()).rightMargin = 0;
                        }
                        this.kyn.setSpacingRight(0);
                        String str = null;
                        if (aWl.getBaijiahaoInfo() != null) {
                            str = aWl.getBaijiahaoInfo().auth_desc;
                        }
                        if (!StringUtils.isNull(str)) {
                            this.kyD.setVisibility(0);
                            this.kyD.setText(str);
                        } else if (aWl.showBazhuGrade()) {
                            this.kyD.setVisibility(0);
                            this.kyD.setText(as.cutChineseAndEnglishWithSuffix(aWl.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (aWl.isNewGod()) {
                            this.kyD.setVisibility(0);
                            this.kyD.setText(aWl.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else {
                            this.kyD.setVisibility(8);
                        }
                    } else {
                        if (aWl.showBazhuGrade()) {
                            this.kyD.setVisibility(0);
                            this.kyD.setText(as.cutChineseAndEnglishWithSuffix(aWl.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (aWl.isNewGod()) {
                            this.kyD.setVisibility(0);
                            this.kyD.setText(aWl.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else {
                            this.kyD.setVisibility(8);
                        }
                        if (this.kyw.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.kyw.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.kyn.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f dlk = postData.dlk();
                        if (dlk != null && !TextUtils.isEmpty(dlk.getName()) && !TextUtils.isEmpty(dlk.getName().trim())) {
                            this.kyC.setVisibility(0);
                            this.kyC.setText(dlk.getName());
                        } else {
                            this.kyC.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.cKx().aWl() != null && fVar.cKx().aWl().getAlaInfo() != null && fVar.cKx().aWl().getAlaInfo().live_status == 1) {
                        cRa();
                        z = true;
                    }
                    this.kys.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.kys.a(aWl, 4);
                        this.kys.setIsclearmode(false);
                    } else {
                        this.kys.setIsclearmode(true);
                    }
                    this.kys.setVisibility(0);
                    if (this.kyx != null) {
                        this.kyx.setVisibility(8);
                    }
                    this.kyp.setOnClickListener(onClickListener);
                    this.kys.getHeadView().setUserId(aWl.getUserId());
                    this.kys.getHeadView().setUserName(aWl.getUserName());
                    this.kys.getHeadView().setTid(postData.getId());
                    this.kys.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.kys.getHeadView().setFName(fVar.getForumName());
                    this.kys.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.kys.ym(aWl.getAvater());
                    } else {
                        this.kys.a(aWl);
                    }
                    String name_show = aWl.getName_show();
                    String userName = aWl.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.kyp.setText(com.baidu.tieba.pb.c.aJ(this.kjZ.getPageContext().getPageActivity(), this.kyp.getText().toString()));
                        this.kyp.setGravity(16);
                        this.kyp.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cKh());
                        ao.setViewTextColor(this.kyp, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = aWl.getIconInfo();
                tShowInfoNew = aWl.getTShowInfoNew();
                if (this.kmp != null) {
                }
                if (this.kmo != null) {
                }
                this.kyp.setText(dp(aWl.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.kyp.setTag(R.id.tag_user_id, aWl.getUserId());
                this.kyp.setTag(R.id.tag_user_name, aWl.getName_show());
                if (x.isEmpty(tShowInfoNew)) {
                }
                ao.setViewTextColor(this.kyp, R.color.cp_cont_h, 1);
                if (!fVar.cLa()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.cLa()) {
                }
                z = false;
                if (fVar.cKx().aWl() != null) {
                    cRa();
                    z = true;
                }
                this.kys.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.kys.setVisibility(0);
                if (this.kyx != null) {
                }
                this.kyp.setOnClickListener(onClickListener);
                this.kys.getHeadView().setUserId(aWl.getUserId());
                this.kys.getHeadView().setUserName(aWl.getUserName());
                this.kys.getHeadView().setTid(postData.getId());
                this.kys.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.kys.getHeadView().setFName(fVar.getForumName());
                this.kys.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = aWl.getName_show();
                String userName2 = aWl.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.kyp.setText(com.baidu.tieba.pb.c.aJ(this.kjZ.getPageContext().getPageActivity(), this.kyp.getText().toString()));
                    this.kyp.setGravity(16);
                    this.kyp.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cKh());
                    ao.setViewTextColor(this.kyp, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = as.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = aWl.getIconInfo();
                    tShowInfoNew = aWl.getTShowInfoNew();
                    if (this.kmp != null) {
                    }
                    if (this.kmo != null) {
                    }
                    this.kyp.setText(dp(aWl.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.kyp.setTag(R.id.tag_user_id, aWl.getUserId());
                    this.kyp.setTag(R.id.tag_user_name, aWl.getName_show());
                    if (x.isEmpty(tShowInfoNew)) {
                    }
                    ao.setViewTextColor(this.kyp, R.color.cp_cont_h, 1);
                    if (!fVar.cLa()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.cLa()) {
                    }
                    z = false;
                    if (fVar.cKx().aWl() != null) {
                    }
                    this.kys.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.kys.setVisibility(0);
                    if (this.kyx != null) {
                    }
                    this.kyp.setOnClickListener(onClickListener);
                    this.kys.getHeadView().setUserId(aWl.getUserId());
                    this.kys.getHeadView().setUserName(aWl.getUserName());
                    this.kys.getHeadView().setTid(postData.getId());
                    this.kys.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.kys.getHeadView().setFName(fVar.getForumName());
                    this.kys.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = aWl.getName_show();
                    String userName22 = aWl.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = aWl.getIconInfo();
                tShowInfoNew = aWl.getTShowInfoNew();
                if (this.kmp != null) {
                }
                if (this.kmo != null) {
                }
                this.kyp.setText(dp(aWl.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.kyp.setTag(R.id.tag_user_id, aWl.getUserId());
                this.kyp.setTag(R.id.tag_user_name, aWl.getName_show());
                if (x.isEmpty(tShowInfoNew)) {
                }
                ao.setViewTextColor(this.kyp, R.color.cp_cont_h, 1);
                if (!fVar.cLa()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.cLa()) {
                }
                z = false;
                if (fVar.cKx().aWl() != null) {
                }
                this.kys.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.kys.setVisibility(0);
                if (this.kyx != null) {
                }
                this.kyp.setOnClickListener(onClickListener);
                this.kys.getHeadView().setUserId(aWl.getUserId());
                this.kys.getHeadView().setUserName(aWl.getUserName());
                this.kys.getHeadView().setTid(postData.getId());
                this.kys.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.kys.getHeadView().setFName(fVar.getForumName());
                this.kys.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = aWl.getName_show();
                String userName222 = aWl.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.kym.aE(fVar.cKx());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.cLd()) {
                this.kyy.setVisibility(0);
            }
            if (z) {
                this.kyy.setVisibility(8);
                if (fVar != null && fVar.cKx() != null && fVar.cKx().getBaijiahaoData() != null && fVar.cKx().getBaijiahaoData().oriUgcType == 3) {
                    this.kyA.setVisibility(8);
                } else {
                    this.kyA.setVisibility(0);
                }
                this.kyA.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), as.numberUniformFormatExtra(fVar.cKV())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aWl().hadConcerned()) {
                this.kyy.setVisibility(8);
                this.kyA.setVisibility(8);
            } else {
                this.kyA.setVisibility(8);
            }
            if (fVar.khp || 3 == fVar.cLd()) {
                this.kyy.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ay.r(fVar);
            if (z && postData != null && postData.aWl() != null) {
                postData.aWl().setIsLike(postData.aWl().hadConcerned());
            }
            if (this.kyz == null) {
                bv cKx = fVar.cKx();
                int i = 1;
                if (cKx != null) {
                    if (cKx.aUT()) {
                        i = 4;
                    } else if (cKx.aUU()) {
                        i = 6;
                    } else if (cKx.aYh()) {
                        i = 7;
                    } else if (cKx.aYg()) {
                        i = 5;
                    }
                }
                this.kyz = new ax(this.kjZ.getPageContext(), this.kyy, i);
                this.kyz.m(this.kjZ.getUniqueId());
                this.kyz.setThreadData(cKx);
            }
            if (postData != null && postData.aWl() != null) {
                postData.aWl().setIsLike(postData.aWl().hadConcerned());
                this.kyz.a(postData.aWl());
                this.kyz.setTid(threadId);
            }
            this.kyz.kuQ = z2;
            this.kyz.BZ(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.aWH() != null) {
                this.kyo.setData(this.kjZ.getPageContext(), fVar.cKz().get(0).aWH(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.cKx().getId(), this.kjZ.aTV() ? "FRS" : null));
                this.kyn.setPadding(this.kyn.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.kyn.getPaddingRight(), this.kyn.getPaddingBottom());
                return;
            }
            this.kyo.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.kjZ.cLF()) {
            this.kyE = 0;
            if (postData != null && postData.aWl() != null) {
                this.kyE = postData.aWl().getLevel_id();
            }
            if (this.kyE > 0 && !z) {
                this.kyr.setVisibility(0);
                ao.setImageResource(this.kyr, BitmapHelper.getGradeResourceIdInEnterForum(this.kyE));
                return;
            }
            this.kyr.setVisibility(8);
            return;
        }
        this.kyr.setVisibility(8);
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cKX()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.kyn.getPaddingBottom();
            if (fVar.cLa()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.kyn.setPadding(this.kyn.getPaddingLeft(), dimens, this.kyn.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.kyn.getPaddingBottom();
        if (fVar != null && !fVar.cKx().aUR() && fVar.cLa() && (!StringUtils.isNull(fVar.cKx().getTitle()) || fVar.cKx().aWV() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.kyn.setPadding(this.kyn.getPaddingLeft(), dimens2, this.kyn.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.kyn.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.kyk);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.kyk, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.kyk);
        }
    }

    public void setVisibility(int i) {
        this.kyn.setVisibility(i);
    }

    private void cRa() {
        if (this.kyt != null) {
            this.kyt.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kyt.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.kjZ.cNt(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.kjZ.cNt(), R.dimen.ds8);
            this.kyt.setLayoutParams(layoutParams);
            this.kyt.loop(true);
            this.kyt.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kyt.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.khq) {
            this.kyl.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kyl.setVisibility(0);
        } else if (z && z2) {
            this.kyl.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kyl.setVisibility(0);
        } else if (z) {
            this.kyl.setImageResource(R.drawable.pic_pb_refined_n);
            this.kyl.setVisibility(0);
        } else if (z2) {
            this.kyl.setImageResource(R.drawable.pic_pb_stick_n);
            this.kyl.setVisibility(0);
        } else {
            this.kyl.setVisibility(8);
        }
    }

    private SpannableStringBuilder dp(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.kjZ.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> cRb() {
        SparseArray<Object> sparseArray = (SparseArray) this.kyn.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.kyn.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView cLZ() {
        return this.kym.cLZ();
    }

    public void sb(boolean z) {
        this.kym.sb(z);
    }

    public void onChangeSkinType(int i) {
        if (this.kyr != null) {
            ao.setImageResource(this.kyr, BitmapHelper.getGradeResourceIdInEnterForum(this.kyE));
        }
        if (this.kyy != null) {
            this.kyy.onChangeSkinType(i);
        }
        if (this.kyC != null) {
            ao.setViewTextColor(this.kyC, R.color.cp_cont_d);
        }
        if (this.kyB != null) {
            ao.setViewTextColor(this.kyB, R.color.cp_cont_d);
        }
        if (this.kyA != null) {
            ao.setViewTextColor(this.kyA, R.color.cp_cont_d);
        }
        if (this.kyD != null) {
            ao.setViewTextColor(this.kyD, R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.kyt != null) {
                this.kyt.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.kyt != null) {
                this.kyt.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.kyt != null) {
            this.kyt.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.kyj != null) {
            this.kyj.HN();
        }
        if (this.kyn != null && this.kyx != null) {
            this.kyn.removeView(this.kyu);
            this.kyx = null;
        }
        if (this.kyt != null) {
            this.kyt.cancelAnimation();
        }
    }

    public void cQo() {
        if (this.kyj != null) {
            this.kyj.HN();
        }
    }
}
