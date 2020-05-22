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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
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
    private LayerDrawable agG;
    private LayerDrawable agH;
    private com.baidu.tieba.pb.a.c efF;
    private View.OnClickListener hpu;
    private PbFragment jGF;
    private UserIconBox jIN;
    private UserIconBox jIO;
    private LinearLayout jUB;
    private LinearLayout jUC;
    private at jUF;
    private com.baidu.tieba.c.d jUp;
    private ImageView jUr;
    private f jUs;
    private ThreadSkinView jUu;
    private ImageView jUx;
    private HeadPendantView jUy;
    private TBLottieAnimationView jUz;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout jUq = null;
    private ColumnLayout jUt = null;
    private TextView jUv = null;
    private TextView jUw = null;
    private FrameLayout jUA = null;
    private ClickableHeaderImageView jUD = null;
    private PbFirstFloorUserLikeButton jUE = null;
    private TextView jUG = null;
    private TextView jUH = null;
    private TextView jUI = null;
    private TextView jUJ = null;
    private int jUK = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.hpu = null;
        this.jGF = pbFragment;
        this.efF = cVar;
        this.hpu = onClickListener;
        int dimens = l.getDimens(this.jGF.getContext(), R.dimen.tbds6);
        this.agG = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aVz().ln(0).O(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aVB(), com.baidu.tbadk.core.util.e.a.c.aVz().ln(0).O(dimens).wJ("#4D000000").aVB()});
        this.agH = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aVz().ln(0).O(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aVB(), com.baidu.tbadk.core.util.e.a.c.aVz().ln(0).O(dimens).wJ("#4D000000").aVB()});
        initView();
    }

    private void initView() {
        this.jUq = (RelativeLayout) LayoutInflater.from(this.jGF.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.jUr = (ImageView) this.jUq.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.jUr.getLayoutParams().height = au.cGY();
        this.jUs = new f(this.jGF.getBaseFragmentActivity(), this.jUq);
        this.jUs.init();
        this.jUs.a(this.jUs.cDI(), this.hpu);
        this.jUt = (ColumnLayout) this.jUq.findViewById(R.id.pb_head_owner_root);
        this.jUu = (ThreadSkinView) this.jUq.findViewById(R.id.pb_thread_skin);
        this.jUv = (TextView) this.jUt.findViewById(R.id.pb_head_owner_info_user_name);
        this.jUw = (TextView) this.jUt.findViewById(R.id.floor_owner);
        this.jUx = (ImageView) this.jUt.findViewById(R.id.icon_forum_level);
        this.jUA = (FrameLayout) this.jUt.findViewById(R.id.pb_head_headImage_container);
        this.jUy = (HeadPendantView) this.jUt.findViewById(R.id.pb_pendant_head_owner_photo);
        this.jUy.setHasPendantStyle();
        this.jUz = (TBLottieAnimationView) this.jUt.findViewById(R.id.pb_head_living_lottie);
        this.jUt.setOnLongClickListener(this.mOnLongClickListener);
        this.jUt.setOnTouchListener(this.efF);
        this.jUt.setVisibility(8);
        if (this.jUy.getHeadView() != null) {
            this.jUy.getHeadView().setIsRound(true);
            this.jUy.getHeadView().setDrawBorder(false);
            this.jUy.getHeadView().setPlaceHolder(1);
        }
        this.jIN = (UserIconBox) this.jUt.findViewById(R.id.show_icon_vip);
        this.jIO = (UserIconBox) this.jUt.findViewById(R.id.show_icon_yinji);
        this.jUB = (LinearLayout) this.jUq.findViewById(R.id.pb_head_owner_info_root);
        this.jUC = (LinearLayout) this.jUt.findViewById(R.id.pb_first_floor_location_container);
        this.jUE = (PbFirstFloorUserLikeButton) this.jUt.findViewById(R.id.pb_like_button);
        this.jUG = (TextView) this.jUt.findViewById(R.id.pb_views);
        this.jUH = (TextView) this.jUt.findViewById(R.id.pb_item_first_floor_reply_time);
        this.jUI = (TextView) this.jUt.findViewById(R.id.pb_item_first_floor_location_address);
        this.jUJ = (TextView) this.jUt.findViewById(R.id.pb_item_first_floor_bjh_desc);
    }

    public View cIE() {
        return this.jUq;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x046d  */
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
    /* JADX WARN: Removed duplicated region for block: B:72:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x028e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x030a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, com.baidu.tieba.pb.data.e eVar, PostData postData, View.OnClickListener onClickListener) {
        String cutChineseAndEnglishWithSuffix;
        ArrayList<IconData> tShowInfoNew;
        boolean z;
        if (postData != null && postData.aQx() != null) {
            MetaData aQx = postData.aQx();
            String string = aQx.getName_show() == null ? StringUtils.string(aQx.getUserName()) : StringUtils.string(aQx.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.aQx().getSealPrefix())) {
                i2 = k.byteLength(aQx.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = aQx.getIconInfo();
                    tShowInfoNew = aQx.getTShowInfoNew();
                    if (this.jIO != null) {
                        this.jIO.setTag(R.id.tag_user_id, aQx.getUserId());
                        if (this.jGF.cFc() != null) {
                            this.jIO.setOnClickListener(this.jGF.cFc().jGR.jWd);
                        }
                        this.jIO.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.jIN != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.jIN.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.jGF.cFc() != null) {
                            this.jIN.setOnClickListener(this.jGF.cFc().jGR.jWe);
                        }
                        this.jIN.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.jUv.setText(dk(aQx.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.jUv.setTag(R.id.tag_user_id, aQx.getUserId());
                    this.jUv.setTag(R.id.tag_user_name, aQx.getName_show());
                    if (v.isEmpty(tShowInfoNew) || aQx.isBigV()) {
                        am.setViewTextColor(this.jUv, R.color.cp_cont_h, 1);
                    } else {
                        am.setViewTextColor(this.jUv, R.color.cp_cont_b, 1);
                    }
                    if (!eVar.cCJ()) {
                        this.jUw.setVisibility(8);
                    } else if (aQx.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aQx.getBawu_type())) {
                        this.jUw.setText(R.string.bawu_member_bazhu_tip);
                        this.jUw.setVisibility(0);
                        if (i == 1) {
                            if (this.agG.getDrawable(1) != null) {
                                this.agG.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agG.getDrawable(1) != null) {
                            this.agG.getDrawable(1).setAlpha(0);
                        }
                        this.jUw.setBackgroundDrawable(this.agG);
                        am.setViewTextColor(this.jUw, (int) R.color.cp_cont_a);
                    } else if (aQx.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aQx.getBawu_type())) {
                        this.jUw.setText(R.string.bawu_member_xbazhu_tip);
                        this.jUw.setVisibility(0);
                        if (i == 1) {
                            if (this.agH.getDrawable(1) != null) {
                                this.agH.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agH.getDrawable(1) != null) {
                            this.agH.getDrawable(1).setAlpha(0);
                        }
                        this.jUw.setBackgroundDrawable(this.agH);
                        am.setViewTextColor(this.jUw, (int) R.color.cp_cont_a);
                    } else {
                        this.jUw.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.jUH.setText(aq.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.jUH.setText(aq.getFormatTime(postData.getTime()));
                    }
                    if (!eVar.cCJ()) {
                        this.jUI.setVisibility(8);
                        if (this.jUC.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.jUC.getLayoutParams()).rightMargin = 0;
                        }
                        this.jUt.setSpacingRight(0);
                        String str = null;
                        if (aQx.getBaijiahaoInfo() != null) {
                            str = aQx.getBaijiahaoInfo().auth_desc;
                        }
                        if (!StringUtils.isNull(str)) {
                            this.jUJ.setVisibility(0);
                            this.jUJ.setText(str);
                        } else {
                            this.jUJ.setVisibility(8);
                        }
                    } else {
                        this.jUJ.setVisibility(8);
                        if (this.jUC.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.jUC.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.jUt.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f ddx = postData.ddx();
                        if (ddx != null && !TextUtils.isEmpty(ddx.getName()) && !TextUtils.isEmpty(ddx.getName().trim())) {
                            this.jUI.setVisibility(0);
                            this.jUI.setText(ddx.getName());
                        } else {
                            this.jUI.setVisibility(8);
                        }
                    }
                    if (eVar.cCi().aQx() != null || eVar.cCi().aQx().getAlaInfo() == null) {
                        z = false;
                    } else if (eVar.cCi().aQx().getAlaInfo().live_status != 1) {
                        z = false;
                    } else {
                        cIF();
                        z = true;
                    }
                    if (z) {
                        this.jUy.a(aQx, 4);
                        this.jUy.setIsclearmode(false);
                    } else {
                        this.jUy.setIsclearmode(true);
                    }
                    this.jUy.setVisibility(0);
                    if (this.jUD != null) {
                        this.jUD.setVisibility(8);
                    }
                    this.jUv.setOnClickListener(onClickListener);
                    this.jUy.getHeadView().setUserId(aQx.getUserId());
                    this.jUy.getHeadView().setUserName(aQx.getUserName());
                    this.jUy.getHeadView().setTid(postData.getId());
                    this.jUy.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.jUy.getHeadView().setFName(eVar.getForumName());
                    this.jUy.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.jUy.wQ(aQx.getAvater());
                    } else {
                        this.jUy.a(aQx);
                    }
                    String name_show = aQx.getName_show();
                    String userName = aQx.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.jUv.setText(com.baidu.tieba.pb.c.aK(this.jGF.getPageContext().getPageActivity(), this.jUv.getText().toString()));
                        this.jUv.setGravity(16);
                        this.jUv.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cBR());
                        am.setViewTextColor(this.jUv, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = aQx.getIconInfo();
                tShowInfoNew = aQx.getTShowInfoNew();
                if (this.jIO != null) {
                }
                if (this.jIN != null) {
                }
                this.jUv.setText(dk(aQx.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.jUv.setTag(R.id.tag_user_id, aQx.getUserId());
                this.jUv.setTag(R.id.tag_user_name, aQx.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                am.setViewTextColor(this.jUv, R.color.cp_cont_h, 1);
                if (!eVar.cCJ()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!eVar.cCJ()) {
                }
                if (eVar.cCi().aQx() != null) {
                }
                z = false;
                if (z) {
                }
                this.jUy.setVisibility(0);
                if (this.jUD != null) {
                }
                this.jUv.setOnClickListener(onClickListener);
                this.jUy.getHeadView().setUserId(aQx.getUserId());
                this.jUy.getHeadView().setUserName(aQx.getUserName());
                this.jUy.getHeadView().setTid(postData.getId());
                this.jUy.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.jUy.getHeadView().setFName(eVar.getForumName());
                this.jUy.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = aQx.getName_show();
                String userName2 = aQx.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.jUv.setText(com.baidu.tieba.pb.c.aK(this.jGF.getPageContext().getPageActivity(), this.jUv.getText().toString()));
                    this.jUv.setGravity(16);
                    this.jUv.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cBR());
                    am.setViewTextColor(this.jUv, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = aQx.getIconInfo();
                    tShowInfoNew = aQx.getTShowInfoNew();
                    if (this.jIO != null) {
                    }
                    if (this.jIN != null) {
                    }
                    this.jUv.setText(dk(aQx.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.jUv.setTag(R.id.tag_user_id, aQx.getUserId());
                    this.jUv.setTag(R.id.tag_user_name, aQx.getName_show());
                    if (v.isEmpty(tShowInfoNew)) {
                    }
                    am.setViewTextColor(this.jUv, R.color.cp_cont_h, 1);
                    if (!eVar.cCJ()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!eVar.cCJ()) {
                    }
                    if (eVar.cCi().aQx() != null) {
                    }
                    z = false;
                    if (z) {
                    }
                    this.jUy.setVisibility(0);
                    if (this.jUD != null) {
                    }
                    this.jUv.setOnClickListener(onClickListener);
                    this.jUy.getHeadView().setUserId(aQx.getUserId());
                    this.jUy.getHeadView().setUserName(aQx.getUserName());
                    this.jUy.getHeadView().setTid(postData.getId());
                    this.jUy.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.jUy.getHeadView().setFName(eVar.getForumName());
                    this.jUy.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = aQx.getName_show();
                    String userName22 = aQx.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = aQx.getIconInfo();
                tShowInfoNew = aQx.getTShowInfoNew();
                if (this.jIO != null) {
                }
                if (this.jIN != null) {
                }
                this.jUv.setText(dk(aQx.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.jUv.setTag(R.id.tag_user_id, aQx.getUserId());
                this.jUv.setTag(R.id.tag_user_name, aQx.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                am.setViewTextColor(this.jUv, R.color.cp_cont_h, 1);
                if (!eVar.cCJ()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!eVar.cCJ()) {
                }
                if (eVar.cCi().aQx() != null) {
                }
                z = false;
                if (z) {
                }
                this.jUy.setVisibility(0);
                if (this.jUD != null) {
                }
                this.jUv.setOnClickListener(onClickListener);
                this.jUy.getHeadView().setUserId(aQx.getUserId());
                this.jUy.getHeadView().setUserName(aQx.getUserName());
                this.jUy.getHeadView().setTid(postData.getId());
                this.jUy.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.jUy.getHeadView().setFName(eVar.getForumName());
                this.jUy.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = aQx.getName_show();
                String userName222 = aQx.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (eVar != null) {
            this.jUs.aH(eVar.cCi());
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z) {
        if (eVar != null && postData != null) {
            if (3 != eVar.cCM()) {
                this.jUE.setVisibility(0);
            }
            if (z) {
                this.jUE.setVisibility(8);
                if (eVar != null && eVar.cCi() != null && eVar.cCi().getBaijiahaoData() != null && eVar.cCi().getBaijiahaoData().oriUgcType == 3) {
                    this.jUG.setVisibility(8);
                } else {
                    this.jUG.setVisibility(0);
                }
                this.jUG.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), aq.numberUniformFormatExtra(eVar.cCF())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aQx().hadConcerned()) {
                this.jUE.setVisibility(8);
                this.jUG.setVisibility(8);
            } else {
                this.jUG.setVisibility(8);
            }
            if (eVar.jDY || 3 == eVar.cCM()) {
                this.jUE.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z, boolean z2) {
        if (eVar != null && postData != null) {
            String threadId = eVar != null ? eVar.getThreadId() : "";
            int q = au.q(eVar);
            if (z && postData != null && postData.aQx() != null) {
                postData.aQx().setIsLike(postData.aQx().hadConcerned());
            }
            if (this.jUF == null) {
                bk cCi = eVar.cCi();
                int i = 1;
                if (cCi != null) {
                    if (cCi.aPm()) {
                        i = 4;
                    } else if (cCi.aPn()) {
                        i = 6;
                    } else if (cCi.aSw()) {
                        i = 7;
                    } else if (cCi.aSv()) {
                        i = 5;
                    }
                }
                this.jUF = new at(this.jGF.getPageContext(), this.jUE, i);
                this.jUF.l(this.jGF.getUniqueId());
                this.jUF.setThreadData(cCi);
            }
            if (postData != null && postData.aQx() != null) {
                postData.aQx().setIsLike(postData.aQx().hadConcerned());
                this.jUF.a(postData.aQx());
                this.jUF.setTid(threadId);
            }
            this.jUF.jQX = z2;
            this.jUF.Aw(q);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        if (postData != null && eVar != null) {
            if (postData.aQU() != null) {
                this.jUu.setData(this.jGF.getPageContext(), eVar.cCk().get(0).aQU(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", eVar.getForum().getId(), eVar.getForum().getName(), eVar.cCi().getId(), this.jGF.aSr() ? "FRS" : null));
                this.jUt.setPadding(this.jUt.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.jUt.getPaddingRight(), this.jUt.getPaddingBottom());
                return;
            }
            this.jUu.setData(null, null, null);
        }
    }

    public void a(PostData postData, boolean z) {
        if (this.jGF.cDo()) {
            this.jUK = 0;
            if (postData != null && postData.aQx() != null) {
                this.jUK = postData.aQx().getLevel_id();
            }
            if (this.jUK > 0 && !z) {
                this.jUx.setVisibility(0);
                am.setImageResource(this.jUx, BitmapHelper.getGradeResourceIdInEnterForum(this.jUK));
                return;
            }
            this.jUx.setVisibility(8);
            return;
        }
        this.jUx.setVisibility(8);
    }

    public void D(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.aWi()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.jUt.getPaddingBottom();
            if (eVar.cCJ()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.jUt.setPadding(this.jUt.getPaddingLeft(), dimens, this.jUt.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.jUt.getPaddingBottom();
        if (eVar != null && !eVar.cCi().aPk() && eVar.cCJ() && (!StringUtils.isNull(eVar.cCi().getTitle()) || eVar.cCi().aRi() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.jUt.setPadding(this.jUt.getPaddingLeft(), dimens2, this.jUt.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.jUt.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.jUq);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.jUq, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.jUq);
        }
    }

    public void setVisibility(int i) {
        this.jUt.setVisibility(i);
    }

    private void cIF() {
        if (this.jUz != null) {
            this.jUz.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jUz.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.jGF.cFc(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.jGF.cFc(), R.dimen.ds8);
            this.jUz.setLayoutParams(layoutParams);
            this.jUz.loop(true);
            this.jUz.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jUz.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.jDZ) {
            this.jUr.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jUr.setVisibility(0);
        } else if (z && z2) {
            this.jUr.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jUr.setVisibility(0);
        } else if (z) {
            this.jUr.setImageResource(R.drawable.pic_pb_refined_n);
            this.jUr.setVisibility(0);
        } else if (z2) {
            this.jUr.setImageResource(R.drawable.pic_pb_stick_n);
            this.jUr.setVisibility(0);
        } else {
            this.jUr.setVisibility(8);
        }
    }

    private SpannableStringBuilder dk(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.jGF.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> cIG() {
        SparseArray<Object> sparseArray = (SparseArray) this.jUt.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.jUt.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView cDI() {
        return this.jUs.cDI();
    }

    public void rj(boolean z) {
        this.jUs.rj(z);
    }

    public void onChangeSkinType(int i) {
        if (this.jUx != null) {
            am.setImageResource(this.jUx, BitmapHelper.getGradeResourceIdInEnterForum(this.jUK));
        }
        if (this.jUE != null) {
            this.jUE.onChangeSkinType(i);
        }
        if (this.jUI != null) {
            am.setViewTextColor(this.jUI, (int) R.color.cp_cont_d);
        }
        if (this.jUH != null) {
            am.setViewTextColor(this.jUH, (int) R.color.cp_cont_d);
        }
        if (this.jUG != null) {
            am.setViewTextColor(this.jUG, (int) R.color.cp_cont_d);
        }
        if (this.jUJ != null) {
            am.setViewTextColor(this.jUJ, (int) R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.jUz != null) {
                this.jUz.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.jUz != null) {
                this.jUz.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.jUz != null) {
            this.jUz.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.jUp != null) {
            this.jUp.Gu();
        }
        if (this.jUt != null && this.jUD != null) {
            this.jUt.removeView(this.jUA);
            this.jUD = null;
        }
        if (this.jUz != null) {
            this.jUz.cancelAnimation();
        }
    }

    public void cHU() {
        if (this.jUp != null) {
            this.jUp.Gu();
        }
    }
}
