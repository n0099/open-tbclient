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
    private PbFragment kkb;
    private UserIconBox kmq;
    private UserIconBox kmr;
    private ax kyB;
    private com.baidu.tieba.c.e kyl;
    private ImageView kyn;
    private f kyo;
    private ThreadSkinView kyq;
    private ImageView kyt;
    private HeadPendantView kyu;
    private TBLottieAnimationView kyv;
    private LinearLayout kyx;
    private LinearLayout kyy;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout kym = null;
    private ColumnLayout kyp = null;
    private TextView kyr = null;
    private TextView kys = null;
    private FrameLayout kyw = null;
    private ClickableHeaderImageView kyz = null;
    private PbFirstFloorUserLikeButton kyA = null;
    private TextView kyC = null;
    private TextView kyD = null;
    private TextView kyE = null;
    private TextView kyF = null;
    private int kyG = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.hIl = null;
        this.kkb = pbFragment;
        this.euG = cVar;
        this.hIl = onClickListener;
        int dimens = l.getDimens(this.kkb.getContext(), R.dimen.tbds6);
        this.ahB = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bbx(), com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(dimens).yi("#4D000000").bbx()});
        this.ahC = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bbx(), com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(dimens).yi("#4D000000").bbx()});
        initView();
    }

    private void initView() {
        this.kym = (RelativeLayout) LayoutInflater.from(this.kkb.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.kyn = (ImageView) this.kym.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.kyn.getLayoutParams().height = ay.cPs();
        this.kyo = new f(this.kkb.getBaseFragmentActivity(), this.kym);
        this.kyo.init();
        this.kyo.a(this.kyo.cLZ(), this.hIl);
        this.kyp = (ColumnLayout) this.kym.findViewById(R.id.pb_head_owner_root);
        this.kyq = (ThreadSkinView) this.kym.findViewById(R.id.pb_thread_skin);
        this.kyr = (TextView) this.kyp.findViewById(R.id.pb_head_owner_info_user_name);
        this.kys = (TextView) this.kyp.findViewById(R.id.floor_owner);
        this.kyt = (ImageView) this.kyp.findViewById(R.id.icon_forum_level);
        this.kyw = (FrameLayout) this.kyp.findViewById(R.id.pb_head_headImage_container);
        this.kyu = (HeadPendantView) this.kyp.findViewById(R.id.pb_pendant_head_owner_photo);
        this.kyu.setHasPendantStyle();
        this.kyv = (TBLottieAnimationView) this.kyp.findViewById(R.id.pb_head_living_lottie);
        this.kyp.setOnLongClickListener(this.mOnLongClickListener);
        this.kyp.setOnTouchListener(this.euG);
        this.kyp.setVisibility(8);
        if (this.kyu.getHeadView() != null) {
            this.kyu.getHeadView().setIsRound(true);
            this.kyu.getHeadView().setDrawBorder(false);
            this.kyu.getHeadView().setPlaceHolder(1);
        }
        this.kmq = (UserIconBox) this.kyp.findViewById(R.id.show_icon_vip);
        this.kmr = (UserIconBox) this.kyp.findViewById(R.id.show_icon_yinji);
        this.kyx = (LinearLayout) this.kym.findViewById(R.id.pb_head_owner_info_root);
        this.kyy = (LinearLayout) this.kyp.findViewById(R.id.pb_first_floor_location_container);
        this.kyA = (PbFirstFloorUserLikeButton) this.kyp.findViewById(R.id.pb_like_button);
        this.kyC = (TextView) this.kyp.findViewById(R.id.pb_views);
        this.kyD = (TextView) this.kyp.findViewById(R.id.pb_item_first_floor_reply_time);
        this.kyE = (TextView) this.kyp.findViewById(R.id.pb_item_first_floor_location_address);
        this.kyF = (TextView) this.kyp.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View cQZ() {
        return this.kym;
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
                    if (this.kmr != null) {
                        this.kmr.setTag(R.id.tag_user_id, aWl.getUserId());
                        if (this.kkb.cNt() != null) {
                            this.kmr.setOnClickListener(this.kkb.cNt().kkn.kzZ);
                        }
                        this.kmr.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.kmq != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.kmq.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.kkb.cNt() != null) {
                            this.kmq.setOnClickListener(this.kkb.cNt().kkn.kAa);
                        }
                        this.kmq.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.kyr.setText(dp(aWl.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.kyr.setTag(R.id.tag_user_id, aWl.getUserId());
                    this.kyr.setTag(R.id.tag_user_name, aWl.getName_show());
                    if (x.isEmpty(tShowInfoNew) || aWl.isBigV()) {
                        ao.setViewTextColor(this.kyr, R.color.cp_cont_h, 1);
                    } else {
                        ao.setViewTextColor(this.kyr, R.color.cp_cont_b, 1);
                    }
                    if (!fVar.cLa()) {
                        this.kys.setVisibility(8);
                    } else if (aWl.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aWl.getBawu_type())) {
                        this.kys.setText(R.string.bawu_member_bazhu_tip);
                        this.kys.setVisibility(0);
                        if (i == 1) {
                            if (this.ahB.getDrawable(1) != null) {
                                this.ahB.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ahB.getDrawable(1) != null) {
                            this.ahB.getDrawable(1).setAlpha(0);
                        }
                        this.kys.setBackgroundDrawable(this.ahB);
                        ao.setViewTextColor(this.kys, R.color.cp_cont_a);
                    } else if (aWl.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aWl.getBawu_type())) {
                        this.kys.setText(R.string.bawu_member_xbazhu_tip);
                        this.kys.setVisibility(0);
                        if (i == 1) {
                            if (this.ahC.getDrawable(1) != null) {
                                this.ahC.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ahC.getDrawable(1) != null) {
                            this.ahC.getDrawable(1).setAlpha(0);
                        }
                        this.kys.setBackgroundDrawable(this.ahC);
                        ao.setViewTextColor(this.kys, R.color.cp_cont_a);
                    } else {
                        this.kys.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.kyD.setText(as.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.kyD.setText(as.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.cLa()) {
                        this.kyE.setVisibility(8);
                        if (this.kyy.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.kyy.getLayoutParams()).rightMargin = 0;
                        }
                        this.kyp.setSpacingRight(0);
                        String str = null;
                        if (aWl.getBaijiahaoInfo() != null) {
                            str = aWl.getBaijiahaoInfo().auth_desc;
                        }
                        if (!StringUtils.isNull(str)) {
                            this.kyF.setVisibility(0);
                            this.kyF.setText(str);
                        } else if (aWl.showBazhuGrade()) {
                            this.kyF.setVisibility(0);
                            this.kyF.setText(as.cutChineseAndEnglishWithSuffix(aWl.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (aWl.isNewGod()) {
                            this.kyF.setVisibility(0);
                            this.kyF.setText(aWl.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else {
                            this.kyF.setVisibility(8);
                        }
                    } else {
                        if (aWl.showBazhuGrade()) {
                            this.kyF.setVisibility(0);
                            this.kyF.setText(as.cutChineseAndEnglishWithSuffix(aWl.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (aWl.isNewGod()) {
                            this.kyF.setVisibility(0);
                            this.kyF.setText(aWl.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else {
                            this.kyF.setVisibility(8);
                        }
                        if (this.kyy.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.kyy.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.kyp.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f dll = postData.dll();
                        if (dll != null && !TextUtils.isEmpty(dll.getName()) && !TextUtils.isEmpty(dll.getName().trim())) {
                            this.kyE.setVisibility(0);
                            this.kyE.setText(dll.getName());
                        } else {
                            this.kyE.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.cKx().aWl() != null && fVar.cKx().aWl().getAlaInfo() != null && fVar.cKx().aWl().getAlaInfo().live_status == 1) {
                        cRa();
                        z = true;
                    }
                    this.kyu.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.kyu.a(aWl, 4);
                        this.kyu.setIsclearmode(false);
                    } else {
                        this.kyu.setIsclearmode(true);
                    }
                    this.kyu.setVisibility(0);
                    if (this.kyz != null) {
                        this.kyz.setVisibility(8);
                    }
                    this.kyr.setOnClickListener(onClickListener);
                    this.kyu.getHeadView().setUserId(aWl.getUserId());
                    this.kyu.getHeadView().setUserName(aWl.getUserName());
                    this.kyu.getHeadView().setTid(postData.getId());
                    this.kyu.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.kyu.getHeadView().setFName(fVar.getForumName());
                    this.kyu.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.kyu.ym(aWl.getAvater());
                    } else {
                        this.kyu.a(aWl);
                    }
                    String name_show = aWl.getName_show();
                    String userName = aWl.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.kyr.setText(com.baidu.tieba.pb.c.aJ(this.kkb.getPageContext().getPageActivity(), this.kyr.getText().toString()));
                        this.kyr.setGravity(16);
                        this.kyr.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cKh());
                        ao.setViewTextColor(this.kyr, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = aWl.getIconInfo();
                tShowInfoNew = aWl.getTShowInfoNew();
                if (this.kmr != null) {
                }
                if (this.kmq != null) {
                }
                this.kyr.setText(dp(aWl.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.kyr.setTag(R.id.tag_user_id, aWl.getUserId());
                this.kyr.setTag(R.id.tag_user_name, aWl.getName_show());
                if (x.isEmpty(tShowInfoNew)) {
                }
                ao.setViewTextColor(this.kyr, R.color.cp_cont_h, 1);
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
                this.kyu.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.kyu.setVisibility(0);
                if (this.kyz != null) {
                }
                this.kyr.setOnClickListener(onClickListener);
                this.kyu.getHeadView().setUserId(aWl.getUserId());
                this.kyu.getHeadView().setUserName(aWl.getUserName());
                this.kyu.getHeadView().setTid(postData.getId());
                this.kyu.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.kyu.getHeadView().setFName(fVar.getForumName());
                this.kyu.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = aWl.getName_show();
                String userName2 = aWl.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.kyr.setText(com.baidu.tieba.pb.c.aJ(this.kkb.getPageContext().getPageActivity(), this.kyr.getText().toString()));
                    this.kyr.setGravity(16);
                    this.kyr.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cKh());
                    ao.setViewTextColor(this.kyr, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = as.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = aWl.getIconInfo();
                    tShowInfoNew = aWl.getTShowInfoNew();
                    if (this.kmr != null) {
                    }
                    if (this.kmq != null) {
                    }
                    this.kyr.setText(dp(aWl.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.kyr.setTag(R.id.tag_user_id, aWl.getUserId());
                    this.kyr.setTag(R.id.tag_user_name, aWl.getName_show());
                    if (x.isEmpty(tShowInfoNew)) {
                    }
                    ao.setViewTextColor(this.kyr, R.color.cp_cont_h, 1);
                    if (!fVar.cLa()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.cLa()) {
                    }
                    z = false;
                    if (fVar.cKx().aWl() != null) {
                    }
                    this.kyu.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.kyu.setVisibility(0);
                    if (this.kyz != null) {
                    }
                    this.kyr.setOnClickListener(onClickListener);
                    this.kyu.getHeadView().setUserId(aWl.getUserId());
                    this.kyu.getHeadView().setUserName(aWl.getUserName());
                    this.kyu.getHeadView().setTid(postData.getId());
                    this.kyu.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.kyu.getHeadView().setFName(fVar.getForumName());
                    this.kyu.getHeadView().setOnClickListener(onClickListener);
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
                if (this.kmr != null) {
                }
                if (this.kmq != null) {
                }
                this.kyr.setText(dp(aWl.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.kyr.setTag(R.id.tag_user_id, aWl.getUserId());
                this.kyr.setTag(R.id.tag_user_name, aWl.getName_show());
                if (x.isEmpty(tShowInfoNew)) {
                }
                ao.setViewTextColor(this.kyr, R.color.cp_cont_h, 1);
                if (!fVar.cLa()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.cLa()) {
                }
                z = false;
                if (fVar.cKx().aWl() != null) {
                }
                this.kyu.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.kyu.setVisibility(0);
                if (this.kyz != null) {
                }
                this.kyr.setOnClickListener(onClickListener);
                this.kyu.getHeadView().setUserId(aWl.getUserId());
                this.kyu.getHeadView().setUserName(aWl.getUserName());
                this.kyu.getHeadView().setTid(postData.getId());
                this.kyu.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.kyu.getHeadView().setFName(fVar.getForumName());
                this.kyu.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = aWl.getName_show();
                String userName222 = aWl.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.kyo.aE(fVar.cKx());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.cLd()) {
                this.kyA.setVisibility(0);
            }
            if (z) {
                this.kyA.setVisibility(8);
                if (fVar != null && fVar.cKx() != null && fVar.cKx().getBaijiahaoData() != null && fVar.cKx().getBaijiahaoData().oriUgcType == 3) {
                    this.kyC.setVisibility(8);
                } else {
                    this.kyC.setVisibility(0);
                }
                this.kyC.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), as.numberUniformFormatExtra(fVar.cKV())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aWl().hadConcerned()) {
                this.kyA.setVisibility(8);
                this.kyC.setVisibility(8);
            } else {
                this.kyC.setVisibility(8);
            }
            if (fVar.khr || 3 == fVar.cLd()) {
                this.kyA.setVisibility(8);
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
            if (this.kyB == null) {
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
                this.kyB = new ax(this.kkb.getPageContext(), this.kyA, i);
                this.kyB.m(this.kkb.getUniqueId());
                this.kyB.setThreadData(cKx);
            }
            if (postData != null && postData.aWl() != null) {
                postData.aWl().setIsLike(postData.aWl().hadConcerned());
                this.kyB.a(postData.aWl());
                this.kyB.setTid(threadId);
            }
            this.kyB.kuS = z2;
            this.kyB.BZ(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.aWH() != null) {
                this.kyq.setData(this.kkb.getPageContext(), fVar.cKz().get(0).aWH(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.cKx().getId(), this.kkb.aTV() ? "FRS" : null));
                this.kyp.setPadding(this.kyp.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.kyp.getPaddingRight(), this.kyp.getPaddingBottom());
                return;
            }
            this.kyq.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.kkb.cLF()) {
            this.kyG = 0;
            if (postData != null && postData.aWl() != null) {
                this.kyG = postData.aWl().getLevel_id();
            }
            if (this.kyG > 0 && !z) {
                this.kyt.setVisibility(0);
                ao.setImageResource(this.kyt, BitmapHelper.getGradeResourceIdInEnterForum(this.kyG));
                return;
            }
            this.kyt.setVisibility(8);
            return;
        }
        this.kyt.setVisibility(8);
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cKX()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.kyp.getPaddingBottom();
            if (fVar.cLa()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.kyp.setPadding(this.kyp.getPaddingLeft(), dimens, this.kyp.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.kyp.getPaddingBottom();
        if (fVar != null && !fVar.cKx().aUR() && fVar.cLa() && (!StringUtils.isNull(fVar.cKx().getTitle()) || fVar.cKx().aWV() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.kyp.setPadding(this.kyp.getPaddingLeft(), dimens2, this.kyp.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.kyp.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.kym);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.kym, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.kym);
        }
    }

    public void setVisibility(int i) {
        this.kyp.setVisibility(i);
    }

    private void cRa() {
        if (this.kyv != null) {
            this.kyv.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kyv.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.kkb.cNt(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.kkb.cNt(), R.dimen.ds8);
            this.kyv.setLayoutParams(layoutParams);
            this.kyv.loop(true);
            this.kyv.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kyv.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.khs) {
            this.kyn.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kyn.setVisibility(0);
        } else if (z && z2) {
            this.kyn.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kyn.setVisibility(0);
        } else if (z) {
            this.kyn.setImageResource(R.drawable.pic_pb_refined_n);
            this.kyn.setVisibility(0);
        } else if (z2) {
            this.kyn.setImageResource(R.drawable.pic_pb_stick_n);
            this.kyn.setVisibility(0);
        } else {
            this.kyn.setVisibility(8);
        }
    }

    private SpannableStringBuilder dp(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.kkb.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> cRb() {
        SparseArray<Object> sparseArray = (SparseArray) this.kyp.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.kyp.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView cLZ() {
        return this.kyo.cLZ();
    }

    public void sb(boolean z) {
        this.kyo.sb(z);
    }

    public void onChangeSkinType(int i) {
        if (this.kyt != null) {
            ao.setImageResource(this.kyt, BitmapHelper.getGradeResourceIdInEnterForum(this.kyG));
        }
        if (this.kyA != null) {
            this.kyA.onChangeSkinType(i);
        }
        if (this.kyE != null) {
            ao.setViewTextColor(this.kyE, R.color.cp_cont_d);
        }
        if (this.kyD != null) {
            ao.setViewTextColor(this.kyD, R.color.cp_cont_d);
        }
        if (this.kyC != null) {
            ao.setViewTextColor(this.kyC, R.color.cp_cont_d);
        }
        if (this.kyF != null) {
            ao.setViewTextColor(this.kyF, R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.kyv != null) {
                this.kyv.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.kyv != null) {
                this.kyv.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.kyv != null) {
            this.kyv.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.kyl != null) {
            this.kyl.HN();
        }
        if (this.kyp != null && this.kyz != null) {
            this.kyp.removeView(this.kyw);
            this.kyz = null;
        }
        if (this.kyv != null) {
            this.kyv.cancelAnimation();
        }
    }

    public void cQo() {
        if (this.kyl != null) {
            this.kyl.HN();
        }
    }
}
