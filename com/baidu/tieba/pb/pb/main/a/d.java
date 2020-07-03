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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
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
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes9.dex */
public class d {
    private LayerDrawable ahK;
    private LayerDrawable ahL;
    private com.baidu.tieba.pb.a.c eor;
    private View.OnClickListener hCn;
    private PbFragment kbv;
    private UserIconBox kdB;
    private UserIconBox kdC;
    private at kpB;
    private com.baidu.tieba.c.e kpl;
    private ImageView kpn;
    private f kpo;
    private ThreadSkinView kpq;
    private ImageView kpt;
    private HeadPendantView kpu;
    private TBLottieAnimationView kpv;
    private LinearLayout kpx;
    private LinearLayout kpy;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout kpm = null;
    private ColumnLayout kpp = null;
    private TextView kpr = null;
    private TextView kps = null;
    private FrameLayout kpw = null;
    private ClickableHeaderImageView kpz = null;
    private PbFirstFloorUserLikeButton kpA = null;
    private TextView kpC = null;
    private TextView kpD = null;
    private TextView kpE = null;
    private TextView kpF = null;
    private int kpG = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.hCn = null;
        this.kbv = pbFragment;
        this.eor = cVar;
        this.hCn = onClickListener;
        int dimens = l.getDimens(this.kbv.getContext(), R.dimen.tbds6);
        this.ahK = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aXu().lG(0).Q(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aXw(), com.baidu.tbadk.core.util.e.a.c.aXu().lG(0).Q(dimens).xa("#4D000000").aXw()});
        this.ahL = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aXu().lG(0).Q(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aXw(), com.baidu.tbadk.core.util.e.a.c.aXu().lG(0).Q(dimens).xa("#4D000000").aXw()});
        initView();
    }

    private void initView() {
        this.kpm = (RelativeLayout) LayoutInflater.from(this.kbv.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.kpn = (ImageView) this.kpm.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.kpn.getLayoutParams().height = au.cLF();
        this.kpo = new f(this.kbv.getBaseFragmentActivity(), this.kpm);
        this.kpo.init();
        this.kpo.a(this.kpo.cIo(), this.hCn);
        this.kpp = (ColumnLayout) this.kpm.findViewById(R.id.pb_head_owner_root);
        this.kpq = (ThreadSkinView) this.kpm.findViewById(R.id.pb_thread_skin);
        this.kpr = (TextView) this.kpp.findViewById(R.id.pb_head_owner_info_user_name);
        this.kps = (TextView) this.kpp.findViewById(R.id.floor_owner);
        this.kpt = (ImageView) this.kpp.findViewById(R.id.icon_forum_level);
        this.kpw = (FrameLayout) this.kpp.findViewById(R.id.pb_head_headImage_container);
        this.kpu = (HeadPendantView) this.kpp.findViewById(R.id.pb_pendant_head_owner_photo);
        this.kpu.setHasPendantStyle();
        this.kpv = (TBLottieAnimationView) this.kpp.findViewById(R.id.pb_head_living_lottie);
        this.kpp.setOnLongClickListener(this.mOnLongClickListener);
        this.kpp.setOnTouchListener(this.eor);
        this.kpp.setVisibility(8);
        if (this.kpu.getHeadView() != null) {
            this.kpu.getHeadView().setIsRound(true);
            this.kpu.getHeadView().setDrawBorder(false);
            this.kpu.getHeadView().setPlaceHolder(1);
        }
        this.kdB = (UserIconBox) this.kpp.findViewById(R.id.show_icon_vip);
        this.kdC = (UserIconBox) this.kpp.findViewById(R.id.show_icon_yinji);
        this.kpx = (LinearLayout) this.kpm.findViewById(R.id.pb_head_owner_info_root);
        this.kpy = (LinearLayout) this.kpp.findViewById(R.id.pb_first_floor_location_container);
        this.kpA = (PbFirstFloorUserLikeButton) this.kpp.findViewById(R.id.pb_like_button);
        this.kpC = (TextView) this.kpp.findViewById(R.id.pb_views);
        this.kpD = (TextView) this.kpp.findViewById(R.id.pb_item_first_floor_reply_time);
        this.kpE = (TextView) this.kpp.findViewById(R.id.pb_item_first_floor_location_address);
        this.kpF = (TextView) this.kpp.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View cNl() {
        return this.kpm;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0295 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0311  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, com.baidu.tieba.pb.data.e eVar, PostData postData, View.OnClickListener onClickListener) {
        String cutChineseAndEnglishWithSuffix;
        ArrayList<IconData> tShowInfoNew;
        boolean z;
        if (postData != null && postData.aSp() != null) {
            MetaData aSp = postData.aSp();
            String string = aSp.getName_show() == null ? StringUtils.string(aSp.getUserName()) : StringUtils.string(aSp.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.aSp().getSealPrefix())) {
                i2 = k.byteLength(aSp.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = ar.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = aSp.getIconInfo();
                    tShowInfoNew = aSp.getTShowInfoNew();
                    if (this.kdC != null) {
                        this.kdC.setTag(R.id.tag_user_id, aSp.getUserId());
                        if (this.kbv.cJI() != null) {
                            this.kdC.setOnClickListener(this.kbv.cJI().kbH.kqZ);
                        }
                        this.kdC.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.kdB != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.kdB.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.kbv.cJI() != null) {
                            this.kdB.setOnClickListener(this.kbv.cJI().kbH.kra);
                        }
                        this.kdB.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.kpr.setText(dn(aSp.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.kpr.setTag(R.id.tag_user_id, aSp.getUserId());
                    this.kpr.setTag(R.id.tag_user_name, aSp.getName_show());
                    if (w.isEmpty(tShowInfoNew) || aSp.isBigV()) {
                        an.setViewTextColor(this.kpr, R.color.cp_cont_h, 1);
                    } else {
                        an.setViewTextColor(this.kpr, R.color.cp_cont_b, 1);
                    }
                    if (!eVar.cHp()) {
                        this.kps.setVisibility(8);
                    } else if (aSp.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aSp.getBawu_type())) {
                        this.kps.setText(R.string.bawu_member_bazhu_tip);
                        this.kps.setVisibility(0);
                        if (i == 1) {
                            if (this.ahK.getDrawable(1) != null) {
                                this.ahK.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ahK.getDrawable(1) != null) {
                            this.ahK.getDrawable(1).setAlpha(0);
                        }
                        this.kps.setBackgroundDrawable(this.ahK);
                        an.setViewTextColor(this.kps, (int) R.color.cp_cont_a);
                    } else if (aSp.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aSp.getBawu_type())) {
                        this.kps.setText(R.string.bawu_member_xbazhu_tip);
                        this.kps.setVisibility(0);
                        if (i == 1) {
                            if (this.ahL.getDrawable(1) != null) {
                                this.ahL.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ahL.getDrawable(1) != null) {
                            this.ahL.getDrawable(1).setAlpha(0);
                        }
                        this.kps.setBackgroundDrawable(this.ahL);
                        an.setViewTextColor(this.kps, (int) R.color.cp_cont_a);
                    } else {
                        this.kps.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.kpD.setText(ar.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.kpD.setText(ar.getFormatTime(postData.getTime()));
                    }
                    if (!eVar.cHp()) {
                        this.kpE.setVisibility(8);
                        if (this.kpy.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.kpy.getLayoutParams()).rightMargin = 0;
                        }
                        this.kpp.setSpacingRight(0);
                        String str = null;
                        if (aSp.getBaijiahaoInfo() != null) {
                            str = aSp.getBaijiahaoInfo().auth_desc;
                        }
                        if (!StringUtils.isNull(str)) {
                            this.kpF.setVisibility(0);
                            this.kpF.setText(str);
                        } else if (aSp.showBazhuGrade()) {
                            this.kpF.setVisibility(0);
                            this.kpF.setText(ar.cutChineseAndEnglishWithSuffix(aSp.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (aSp.isNewGod()) {
                            this.kpF.setVisibility(0);
                            this.kpF.setText(aSp.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else {
                            this.kpF.setVisibility(8);
                        }
                    } else {
                        if (aSp.showBazhuGrade()) {
                            this.kpF.setVisibility(0);
                            this.kpF.setText(ar.cutChineseAndEnglishWithSuffix(aSp.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (aSp.isNewGod()) {
                            this.kpF.setVisibility(0);
                            this.kpF.setText(aSp.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else {
                            this.kpF.setVisibility(8);
                        }
                        if (this.kpy.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.kpy.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.kpp.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f dib = postData.dib();
                        if (dib != null && !TextUtils.isEmpty(dib.getName()) && !TextUtils.isEmpty(dib.getName().trim())) {
                            this.kpE.setVisibility(0);
                            this.kpE.setText(dib.getName());
                        } else {
                            this.kpE.setVisibility(8);
                        }
                    }
                    z = false;
                    if (eVar.cGN().aSp() != null && eVar.cGN().aSp().getAlaInfo() != null && eVar.cGN().aSp().getAlaInfo().live_status == 1) {
                        cNm();
                        z = true;
                    }
                    this.kpu.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.kpu.a(aSp, 4);
                        this.kpu.setIsclearmode(false);
                    } else {
                        this.kpu.setIsclearmode(true);
                    }
                    this.kpu.setVisibility(0);
                    if (this.kpz != null) {
                        this.kpz.setVisibility(8);
                    }
                    this.kpr.setOnClickListener(onClickListener);
                    this.kpu.getHeadView().setUserId(aSp.getUserId());
                    this.kpu.getHeadView().setUserName(aSp.getUserName());
                    this.kpu.getHeadView().setTid(postData.getId());
                    this.kpu.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.kpu.getHeadView().setFName(eVar.getForumName());
                    this.kpu.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.kpu.xh(aSp.getAvater());
                    } else {
                        this.kpu.a(aSp);
                    }
                    String name_show = aSp.getName_show();
                    String userName = aSp.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.kpr.setText(com.baidu.tieba.pb.c.aK(this.kbv.getPageContext().getPageActivity(), this.kpr.getText().toString()));
                        this.kpr.setGravity(16);
                        this.kpr.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cGx());
                        an.setViewTextColor(this.kpr, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = aSp.getIconInfo();
                tShowInfoNew = aSp.getTShowInfoNew();
                if (this.kdC != null) {
                }
                if (this.kdB != null) {
                }
                this.kpr.setText(dn(aSp.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.kpr.setTag(R.id.tag_user_id, aSp.getUserId());
                this.kpr.setTag(R.id.tag_user_name, aSp.getName_show());
                if (w.isEmpty(tShowInfoNew)) {
                }
                an.setViewTextColor(this.kpr, R.color.cp_cont_h, 1);
                if (!eVar.cHp()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!eVar.cHp()) {
                }
                z = false;
                if (eVar.cGN().aSp() != null) {
                    cNm();
                    z = true;
                }
                this.kpu.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.kpu.setVisibility(0);
                if (this.kpz != null) {
                }
                this.kpr.setOnClickListener(onClickListener);
                this.kpu.getHeadView().setUserId(aSp.getUserId());
                this.kpu.getHeadView().setUserName(aSp.getUserName());
                this.kpu.getHeadView().setTid(postData.getId());
                this.kpu.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.kpu.getHeadView().setFName(eVar.getForumName());
                this.kpu.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = aSp.getName_show();
                String userName2 = aSp.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.kpr.setText(com.baidu.tieba.pb.c.aK(this.kbv.getPageContext().getPageActivity(), this.kpr.getText().toString()));
                    this.kpr.setGravity(16);
                    this.kpr.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cGx());
                    an.setViewTextColor(this.kpr, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = ar.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = aSp.getIconInfo();
                    tShowInfoNew = aSp.getTShowInfoNew();
                    if (this.kdC != null) {
                    }
                    if (this.kdB != null) {
                    }
                    this.kpr.setText(dn(aSp.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.kpr.setTag(R.id.tag_user_id, aSp.getUserId());
                    this.kpr.setTag(R.id.tag_user_name, aSp.getName_show());
                    if (w.isEmpty(tShowInfoNew)) {
                    }
                    an.setViewTextColor(this.kpr, R.color.cp_cont_h, 1);
                    if (!eVar.cHp()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!eVar.cHp()) {
                    }
                    z = false;
                    if (eVar.cGN().aSp() != null) {
                    }
                    this.kpu.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.kpu.setVisibility(0);
                    if (this.kpz != null) {
                    }
                    this.kpr.setOnClickListener(onClickListener);
                    this.kpu.getHeadView().setUserId(aSp.getUserId());
                    this.kpu.getHeadView().setUserName(aSp.getUserName());
                    this.kpu.getHeadView().setTid(postData.getId());
                    this.kpu.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.kpu.getHeadView().setFName(eVar.getForumName());
                    this.kpu.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = aSp.getName_show();
                    String userName22 = aSp.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = aSp.getIconInfo();
                tShowInfoNew = aSp.getTShowInfoNew();
                if (this.kdC != null) {
                }
                if (this.kdB != null) {
                }
                this.kpr.setText(dn(aSp.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.kpr.setTag(R.id.tag_user_id, aSp.getUserId());
                this.kpr.setTag(R.id.tag_user_name, aSp.getName_show());
                if (w.isEmpty(tShowInfoNew)) {
                }
                an.setViewTextColor(this.kpr, R.color.cp_cont_h, 1);
                if (!eVar.cHp()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!eVar.cHp()) {
                }
                z = false;
                if (eVar.cGN().aSp() != null) {
                }
                this.kpu.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.kpu.setVisibility(0);
                if (this.kpz != null) {
                }
                this.kpr.setOnClickListener(onClickListener);
                this.kpu.getHeadView().setUserId(aSp.getUserId());
                this.kpu.getHeadView().setUserName(aSp.getUserName());
                this.kpu.getHeadView().setTid(postData.getId());
                this.kpu.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.kpu.getHeadView().setFName(eVar.getForumName());
                this.kpu.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = aSp.getName_show();
                String userName222 = aSp.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (eVar != null) {
            this.kpo.aH(eVar.cGN());
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z) {
        if (eVar != null && postData != null) {
            if (3 != eVar.cHs()) {
                this.kpA.setVisibility(0);
            }
            if (z) {
                this.kpA.setVisibility(8);
                if (eVar != null && eVar.cGN() != null && eVar.cGN().getBaijiahaoData() != null && eVar.cGN().getBaijiahaoData().oriUgcType == 3) {
                    this.kpC.setVisibility(8);
                } else {
                    this.kpC.setVisibility(0);
                }
                this.kpC.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), ar.numberUniformFormatExtra(eVar.cHk())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aSp().hadConcerned()) {
                this.kpA.setVisibility(8);
                this.kpC.setVisibility(8);
            } else {
                this.kpC.setVisibility(8);
            }
            if (eVar.jYO || 3 == eVar.cHs()) {
                this.kpA.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z, boolean z2) {
        if (eVar != null && postData != null) {
            String threadId = eVar != null ? eVar.getThreadId() : "";
            int r = au.r(eVar);
            if (z && postData != null && postData.aSp() != null) {
                postData.aSp().setIsLike(postData.aSp().hadConcerned());
            }
            if (this.kpB == null) {
                bu cGN = eVar.cGN();
                int i = 1;
                if (cGN != null) {
                    if (cGN.aQX()) {
                        i = 4;
                    } else if (cGN.aQY()) {
                        i = 6;
                    } else if (cGN.aUm()) {
                        i = 7;
                    } else if (cGN.aUl()) {
                        i = 5;
                    }
                }
                this.kpB = new at(this.kbv.getPageContext(), this.kpA, i);
                this.kpB.l(this.kbv.getUniqueId());
                this.kpB.setThreadData(cGN);
            }
            if (postData != null && postData.aSp() != null) {
                postData.aSp().setIsLike(postData.aSp().hadConcerned());
                this.kpB.a(postData.aSp());
                this.kpB.setTid(threadId);
            }
            this.kpB.klT = z2;
            this.kpB.BA(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        if (postData != null && eVar != null) {
            if (postData.aSL() != null) {
                this.kpq.setData(this.kbv.getPageContext(), eVar.cGP().get(0).aSL(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", eVar.getForum().getId(), eVar.getForum().getName(), eVar.cGN().getId(), this.kbv.aUi() ? "FRS" : null));
                this.kpp.setPadding(this.kpp.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.kpp.getPaddingRight(), this.kpp.getPaddingBottom());
                return;
            }
            this.kpq.setData(null, null, null);
        }
    }

    public void a(PostData postData, boolean z) {
        if (this.kbv.cHU()) {
            this.kpG = 0;
            if (postData != null && postData.aSp() != null) {
                this.kpG = postData.aSp().getLevel_id();
            }
            if (this.kpG > 0 && !z) {
                this.kpt.setVisibility(0);
                an.setImageResource(this.kpt, BitmapHelper.getGradeResourceIdInEnterForum(this.kpG));
                return;
            }
            this.kpt.setVisibility(8);
            return;
        }
        this.kpt.setVisibility(8);
    }

    public void E(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cHm()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.kpp.getPaddingBottom();
            if (eVar.cHp()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.kpp.setPadding(this.kpp.getPaddingLeft(), dimens, this.kpp.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.kpp.getPaddingBottom();
        if (eVar != null && !eVar.cGN().aQV() && eVar.cHp() && (!StringUtils.isNull(eVar.cGN().getTitle()) || eVar.cGN().aSZ() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.kpp.setPadding(this.kpp.getPaddingLeft(), dimens2, this.kpp.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.kpp.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.kpm);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.kpm, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.kpm);
        }
    }

    public void setVisibility(int i) {
        this.kpp.setVisibility(i);
    }

    private void cNm() {
        if (this.kpv != null) {
            this.kpv.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kpv.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.kbv.cJI(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.kbv.cJI(), R.dimen.ds8);
            this.kpv.setLayoutParams(layoutParams);
            this.kpv.loop(true);
            this.kpv.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kpv.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.jYP) {
            this.kpn.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kpn.setVisibility(0);
        } else if (z && z2) {
            this.kpn.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kpn.setVisibility(0);
        } else if (z) {
            this.kpn.setImageResource(R.drawable.pic_pb_refined_n);
            this.kpn.setVisibility(0);
        } else if (z2) {
            this.kpn.setImageResource(R.drawable.pic_pb_stick_n);
            this.kpn.setVisibility(0);
        } else {
            this.kpn.setVisibility(8);
        }
    }

    private SpannableStringBuilder dn(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.kbv.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> cNn() {
        SparseArray<Object> sparseArray = (SparseArray) this.kpp.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.kpp.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView cIo() {
        return this.kpo.cIo();
    }

    public void rw(boolean z) {
        this.kpo.rw(z);
    }

    public void onChangeSkinType(int i) {
        if (this.kpt != null) {
            an.setImageResource(this.kpt, BitmapHelper.getGradeResourceIdInEnterForum(this.kpG));
        }
        if (this.kpA != null) {
            this.kpA.onChangeSkinType(i);
        }
        if (this.kpE != null) {
            an.setViewTextColor(this.kpE, (int) R.color.cp_cont_d);
        }
        if (this.kpD != null) {
            an.setViewTextColor(this.kpD, (int) R.color.cp_cont_d);
        }
        if (this.kpC != null) {
            an.setViewTextColor(this.kpC, (int) R.color.cp_cont_d);
        }
        if (this.kpF != null) {
            an.setViewTextColor(this.kpF, (int) R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.kpv != null) {
                this.kpv.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.kpv != null) {
                this.kpv.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.kpv != null) {
            this.kpv.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.kpl != null) {
            this.kpl.HH();
        }
        if (this.kpp != null && this.kpz != null) {
            this.kpp.removeView(this.kpw);
            this.kpz = null;
        }
        if (this.kpv != null) {
            this.kpv.cancelAnimation();
        }
    }

    public void cMB() {
        if (this.kpl != null) {
            this.kpl.HH();
        }
    }
}
