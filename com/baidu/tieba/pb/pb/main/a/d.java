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
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes6.dex */
public class d {
    private LayerDrawable MR;
    private LayerDrawable MS;
    private com.baidu.tieba.pb.a.c dmm;
    private View.OnClickListener gle;
    private UserIconBox iAK;
    private UserIconBox iAL;
    private com.baidu.tieba.c.d iLP;
    private ImageView iLR;
    private com.baidu.tieba.pb.pb.main.e iLS;
    private ThreadSkinView iLU;
    private ImageView iLX;
    private HeadPendantView iLY;
    private LinearLayout iMb;
    private LinearLayout iMc;
    private ao iMf;
    private PbFragment iyA;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout iLQ = null;
    private ColumnLayout iLT = null;
    private TextView iLV = null;
    private TextView iLW = null;
    private FrameLayout iLZ = null;
    private View iMa = null;
    private ClickableHeaderImageView iMd = null;
    private PbFirstFloorUserLikeButton iMe = null;
    private TextView iMg = null;
    private TextView iMh = null;
    private TextView iMi = null;
    private TextView iMj = null;
    private int iMk = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.gle = null;
        this.iyA = pbFragment;
        this.dmm = cVar;
        this.gle = onClickListener;
        int dimens = l.getDimens(this.iyA.getContext(), R.dimen.tbds6);
        this.MR = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aEw(), com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(dimens).ts("#4D000000").aEw()});
        this.MS = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aEw(), com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(dimens).ts("#4D000000").aEw()});
        initView();
    }

    private void initView() {
        this.iLQ = (RelativeLayout) LayoutInflater.from(this.iyA.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.iLR = (ImageView) this.iLQ.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.iLR.getLayoutParams().height = ap.cmC();
        this.iLS = new com.baidu.tieba.pb.pb.main.e(this.iyA.getBaseFragmentActivity(), this.iLQ);
        this.iLS.init();
        this.iLS.setOnClickListener(this.iLS.cjf(), this.gle);
        this.iLT = (ColumnLayout) this.iLQ.findViewById(R.id.pb_head_owner_root);
        this.iLU = (ThreadSkinView) this.iLQ.findViewById(R.id.pb_thread_skin);
        this.iLV = (TextView) this.iLT.findViewById(R.id.pb_head_owner_info_user_name);
        this.iLV.getPaint().setFakeBoldText(true);
        this.iLW = (TextView) this.iLT.findViewById(R.id.floor_owner);
        this.iLX = (ImageView) this.iLT.findViewById(R.id.icon_forum_level);
        this.iLZ = (FrameLayout) this.iLT.findViewById(R.id.pb_head_headImage_container);
        this.iLY = (HeadPendantView) this.iLT.findViewById(R.id.pb_pendant_head_owner_photo);
        this.iLY.setHasPendantStyle();
        this.iLT.setOnLongClickListener(this.mOnLongClickListener);
        this.iLT.setOnTouchListener(this.dmm);
        this.iLT.setVisibility(8);
        if (this.iLY.getHeadView() != null) {
            this.iLY.getHeadView().setIsRound(true);
            this.iLY.getHeadView().setDrawBorder(false);
            this.iLY.getHeadView().setPlaceHolder(1);
        }
        this.iAK = (UserIconBox) this.iLT.findViewById(R.id.show_icon_vip);
        this.iAL = (UserIconBox) this.iLT.findViewById(R.id.show_icon_yinji);
        this.iMb = (LinearLayout) this.iLQ.findViewById(R.id.pb_head_owner_info_root);
        this.iMc = (LinearLayout) this.iLT.findViewById(R.id.pb_first_floor_location_container);
        this.iMe = (PbFirstFloorUserLikeButton) this.iLT.findViewById(R.id.pb_like_button);
        this.iMg = (TextView) this.iLT.findViewById(R.id.pb_views);
        this.iMh = (TextView) this.iLT.findViewById(R.id.pb_item_first_floor_reply_time);
        this.iMi = (TextView) this.iLT.findViewById(R.id.pb_item_first_floor_location_address);
        this.iMj = (TextView) this.iLT.findViewById(R.id.pb_item_first_floor_bjh_desc);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x027f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, f fVar, PostData postData, View.OnClickListener onClickListener) {
        String cutChineseAndEnglishWithSuffix;
        ArrayList<IconData> tShowInfoNew;
        if (postData != null && postData.azE() != null) {
            MetaData azE = postData.azE();
            String string = azE.getName_show() == null ? StringUtils.string(azE.getUserName()) : StringUtils.string(azE.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.azE().getSealPrefix())) {
                i2 = k.byteLength(azE.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = azE.getIconInfo();
                    tShowInfoNew = azE.getTShowInfoNew();
                    if (this.iAL != null) {
                        this.iAL.setTag(R.id.tag_user_id, azE.getUserId());
                        if (this.iyA.ckE() != null) {
                            this.iAL.setOnClickListener(this.iyA.ckE().iyV.iND);
                        }
                        this.iAL.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.iAK != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.iAK.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.iyA.ckE() != null) {
                            this.iAK.setOnClickListener(this.iyA.ckE().iyV.iNE);
                        }
                        this.iAK.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.iLV.setText(cs(azE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.iLV.setTag(R.id.tag_user_id, azE.getUserId());
                    this.iLV.setTag(R.id.tag_user_name, azE.getName_show());
                    if (v.isEmpty(tShowInfoNew) || azE.isBigV()) {
                        am.setViewTextColor(this.iLV, R.color.cp_cont_h, 1);
                    } else {
                        am.setViewTextColor(this.iLV, R.color.cp_cont_b, 1);
                    }
                    if (!fVar.cik()) {
                        this.iLW.setVisibility(8);
                    } else if (azE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(azE.getBawu_type())) {
                        this.iLW.setText(R.string.bawu_member_bazhu_tip);
                        this.iLW.setVisibility(0);
                        if (i == 1) {
                            if (this.MR.getDrawable(1) != null) {
                                this.MR.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.MR.getDrawable(1) != null) {
                            this.MR.getDrawable(1).setAlpha(0);
                        }
                        this.iLW.setBackgroundDrawable(this.MR);
                        am.setViewTextColor(this.iLW, (int) R.color.cp_cont_a);
                    } else if (azE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(azE.getBawu_type())) {
                        this.iLW.setText(R.string.bawu_member_xbazhu_tip);
                        this.iLW.setVisibility(0);
                        if (i == 1) {
                            if (this.MS.getDrawable(1) != null) {
                                this.MS.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.MS.getDrawable(1) != null) {
                            this.MS.getDrawable(1).setAlpha(0);
                        }
                        this.iLW.setBackgroundDrawable(this.MS);
                        am.setViewTextColor(this.iLW, (int) R.color.cp_cont_a);
                    } else {
                        this.iLW.setVisibility(8);
                    }
                    if (fVar.chK().azE() != null && fVar.chK().azE().getAlaUserData() != null && this.iMa != null) {
                        if (fVar.chK().azE().getAlaUserData().anchor_live != 0) {
                            this.iMa.setVisibility(8);
                        } else {
                            this.iMa.setVisibility(0);
                            if (this.iLP == null) {
                                this.iLP = new com.baidu.tieba.c.d(this.iyA.getPageContext(), this.iMa);
                                this.iLP.rm(1);
                            }
                            this.iLP.Z(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_VIDEO_PB_ALA_TAIL_LIGHT_TIPS));
                            com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                            aVar.cFA = fVar.chK().azE().getAlaUserData();
                            aVar.type = 2;
                            this.iMa.setTag(aVar);
                        }
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                        this.iMh.setText(aq.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.iMh.setText(aq.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.cik()) {
                        this.iMi.setVisibility(8);
                        if (this.iMc.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.iMc.getLayoutParams()).rightMargin = 0;
                        }
                        this.iLT.setSpacingRight(0);
                        String str = null;
                        if (azE.getBaijiahaoInfo() != null) {
                            str = azE.getBaijiahaoInfo().auth_desc;
                        }
                        if (!StringUtils.isNull(str)) {
                            this.iMj.setVisibility(0);
                            this.iMj.setText(str);
                        } else {
                            this.iMj.setVisibility(8);
                        }
                    } else {
                        this.iMj.setVisibility(8);
                        if (this.iMc.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.iMc.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.iLT.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f cIw = postData.cIw();
                        if (cIw != null && !TextUtils.isEmpty(cIw.getName()) && !TextUtils.isEmpty(cIw.getName().trim())) {
                            this.iMi.setVisibility(0);
                            this.iMi.setText(cIw.getName());
                        } else {
                            this.iMi.setVisibility(8);
                        }
                    }
                    this.iLY.a(azE, 0);
                    this.iLY.setVisibility(0);
                    if (this.iMd != null) {
                        this.iMd.setVisibility(8);
                    }
                    this.iLV.setOnClickListener(onClickListener);
                    this.iLY.getHeadView().setUserId(azE.getUserId());
                    this.iLY.getHeadView().setUserName(azE.getUserName());
                    this.iLY.getHeadView().setTid(postData.getId());
                    this.iLY.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.iLY.getHeadView().setOnClickListener(onClickListener);
                    this.iLY.a(azE);
                    String name_show = azE.getName_show();
                    String userName = azE.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.iLV.setText(com.baidu.tieba.pb.d.aZ(this.iyA.getPageContext().getPageActivity(), this.iLV.getText().toString()));
                        this.iLV.setGravity(16);
                        this.iLV.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.d.chp());
                        am.setViewTextColor(this.iLV, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = azE.getIconInfo();
                tShowInfoNew = azE.getTShowInfoNew();
                if (this.iAL != null) {
                }
                if (this.iAK != null) {
                }
                this.iLV.setText(cs(azE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.iLV.setTag(R.id.tag_user_id, azE.getUserId());
                this.iLV.setTag(R.id.tag_user_name, azE.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                am.setViewTextColor(this.iLV, R.color.cp_cont_h, 1);
                if (!fVar.cik()) {
                }
                if (fVar.chK().azE() != null) {
                    if (fVar.chK().azE().getAlaUserData().anchor_live != 0) {
                    }
                }
                if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                }
                if (!fVar.cik()) {
                }
                this.iLY.a(azE, 0);
                this.iLY.setVisibility(0);
                if (this.iMd != null) {
                }
                this.iLV.setOnClickListener(onClickListener);
                this.iLY.getHeadView().setUserId(azE.getUserId());
                this.iLY.getHeadView().setUserName(azE.getUserName());
                this.iLY.getHeadView().setTid(postData.getId());
                this.iLY.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.iLY.getHeadView().setOnClickListener(onClickListener);
                this.iLY.a(azE);
                String name_show2 = azE.getName_show();
                String userName2 = azE.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.iLV.setText(com.baidu.tieba.pb.d.aZ(this.iyA.getPageContext().getPageActivity(), this.iLV.getText().toString()));
                    this.iLV.setGravity(16);
                    this.iLV.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.d.chp());
                    am.setViewTextColor(this.iLV, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = azE.getIconInfo();
                    tShowInfoNew = azE.getTShowInfoNew();
                    if (this.iAL != null) {
                    }
                    if (this.iAK != null) {
                    }
                    this.iLV.setText(cs(azE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.iLV.setTag(R.id.tag_user_id, azE.getUserId());
                    this.iLV.setTag(R.id.tag_user_name, azE.getName_show());
                    if (v.isEmpty(tShowInfoNew)) {
                    }
                    am.setViewTextColor(this.iLV, R.color.cp_cont_h, 1);
                    if (!fVar.cik()) {
                    }
                    if (fVar.chK().azE() != null) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                    }
                    if (!fVar.cik()) {
                    }
                    this.iLY.a(azE, 0);
                    this.iLY.setVisibility(0);
                    if (this.iMd != null) {
                    }
                    this.iLV.setOnClickListener(onClickListener);
                    this.iLY.getHeadView().setUserId(azE.getUserId());
                    this.iLY.getHeadView().setUserName(azE.getUserName());
                    this.iLY.getHeadView().setTid(postData.getId());
                    this.iLY.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.iLY.getHeadView().setOnClickListener(onClickListener);
                    this.iLY.a(azE);
                    String name_show22 = azE.getName_show();
                    String userName22 = azE.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = azE.getIconInfo();
                tShowInfoNew = azE.getTShowInfoNew();
                if (this.iAL != null) {
                }
                if (this.iAK != null) {
                }
                this.iLV.setText(cs(azE.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.iLV.setTag(R.id.tag_user_id, azE.getUserId());
                this.iLV.setTag(R.id.tag_user_name, azE.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                am.setViewTextColor(this.iLV, R.color.cp_cont_h, 1);
                if (!fVar.cik()) {
                }
                if (fVar.chK().azE() != null) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                }
                if (!fVar.cik()) {
                }
                this.iLY.a(azE, 0);
                this.iLY.setVisibility(0);
                if (this.iMd != null) {
                }
                this.iLV.setOnClickListener(onClickListener);
                this.iLY.getHeadView().setUserId(azE.getUserId());
                this.iLY.getHeadView().setUserName(azE.getUserName());
                this.iLY.getHeadView().setTid(postData.getId());
                this.iLY.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.iLY.getHeadView().setOnClickListener(onClickListener);
                this.iLY.a(azE);
                String name_show222 = azE.getName_show();
                String userName222 = azE.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.iLS.aA(fVar.chK());
        }
    }

    public void a(f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.cin()) {
                this.iMe.setVisibility(0);
            }
            if (z) {
                this.iMe.setVisibility(8);
                if (fVar != null && fVar.chK() != null && fVar.chK().getBaijiahaoData() != null && fVar.chK().getBaijiahaoData().oriUgcType == 3) {
                    this.iMg.setVisibility(8);
                } else {
                    this.iMg.setVisibility(0);
                }
                this.iMg.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), aq.numberUniformFormatExtra(fVar.cif())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.azE().hadConcerned()) {
                this.iMe.setVisibility(8);
                this.iMg.setVisibility(8);
            } else {
                this.iMg.setVisibility(8);
            }
            if (fVar.iwi || 3 == fVar.cin()) {
                this.iMe.setVisibility(8);
            }
        }
    }

    public void a(f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int z3 = z(fVar);
            if (z && postData != null && postData.azE() != null) {
                postData.azE().setIsLike(postData.azE().hadConcerned());
            }
            if (this.iMf == null) {
                bj chK = fVar.chK();
                int i = 1;
                if (chK != null) {
                    if (chK.ays()) {
                        i = 4;
                    } else if (chK.aBz()) {
                        i = 6;
                    } else if (chK.aBB()) {
                        i = 7;
                    } else if (chK.aBA()) {
                        i = 5;
                    }
                }
                this.iMf = new ao(this.iyA.getPageContext(), this.iMe, i);
                this.iMf.j(this.iyA.getUniqueId());
                this.iMf.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void fJ(boolean z4) {
                        if (d.this.iyA != null && z4) {
                            l.showToast(d.this.iyA.getBaseFragmentActivity(), (int) R.string.attention_success);
                        }
                    }
                });
            }
            if (postData != null && postData.azE() != null) {
                postData.azE().setIsLike(postData.azE().hadConcerned());
                this.iMf.a(postData.azE());
                this.iMf.setTid(threadId);
            }
            this.iMf.iIE = z2;
            this.iMf.yR(z3);
        }
    }

    public int z(f fVar) {
        if (fVar == null || fVar.chK() == null) {
            return 0;
        }
        if (fVar.chK().aAY()) {
            return (v.isEmpty(fVar.cie()) && (fVar.chJ() == null || StringUtils.isNull(fVar.chJ().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public void a(PostData postData, f fVar) {
        if (postData != null && fVar != null) {
            if (postData.azZ() != null) {
                this.iLU.setData(this.iyA.getPageContext(), fVar.chM().get(0).azZ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.chK().getId(), this.iyA.aBv() ? "FRS" : null));
                this.iLT.setPadding(this.iLT.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.iLT.getPaddingRight(), this.iLT.getPaddingBottom());
                return;
            }
            this.iLU.setData(null, null, null);
        }
    }

    public void a(PostData postData, boolean z) {
        if (this.iyA.ciJ()) {
            this.iMk = 0;
            if (postData != null && postData.azE() != null) {
                this.iMk = postData.azE().getLevel_id();
            }
            if (this.iMk > 0 && !z) {
                this.iLX.setVisibility(0);
                am.setImageResource(this.iLX, BitmapHelper.getGradeResourceIdInEnterForum(this.iMk));
                return;
            }
            this.iLX.setVisibility(8);
            return;
        }
        this.iLX.setVisibility(8);
    }

    public void A(f fVar) {
        if (fVar != null && fVar.cih()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.iLT.getPaddingBottom();
            if (fVar.cik()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.iLT.setPadding(this.iLT.getPaddingLeft(), dimens, this.iLT.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.iLT.getPaddingBottom();
        if (fVar != null && !fVar.chK().aAE() && fVar.cik() && (!StringUtils.isNull(fVar.chK().getTitle()) || fVar.chK().aAl() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.iLT.setPadding(this.iLT.getPaddingLeft(), dimens2, this.iLT.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.iLT.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.iLQ);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.iLQ, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.iLQ);
        }
    }

    public void setVisibility(int i) {
        this.iLT.setVisibility(i);
    }

    public void coh() {
        this.iMa = com.baidu.tbadk.ala.b.avT().u(this.iyA.getActivity(), 2);
        if (this.iMa != null) {
            this.iMa.setVisibility(8);
            FloatingLayout.LayoutParams layoutParams = new FloatingLayout.LayoutParams(-2, -2);
            if (this.iMa.getParent() == null) {
                this.iMb.addView(this.iMa, layoutParams);
            }
        }
    }

    public void d(f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.iwj) {
            this.iLR.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iLR.setVisibility(0);
        } else if (z && z2) {
            this.iLR.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iLR.setVisibility(0);
        } else if (z) {
            this.iLR.setImageResource(R.drawable.pic_pb_refined_n);
            this.iLR.setVisibility(0);
        } else if (z2) {
            this.iLR.setImageResource(R.drawable.pic_pb_stick_n);
            this.iLR.setVisibility(0);
        } else {
            this.iLR.setVisibility(8);
        }
    }

    private SpannableStringBuilder cs(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str));
            return com.baidu.tieba.card.l.a((Context) this.iyA.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> coi() {
        SparseArray<Object> sparseArray = (SparseArray) this.iLT.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.iLT.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView cjf() {
        return this.iLS.cjf();
    }

    public void pm(boolean z) {
        this.iLS.pm(z);
    }

    public void onChangeSkinType(int i) {
        if (this.iLX != null) {
            am.setImageResource(this.iLX, BitmapHelper.getGradeResourceIdInEnterForum(this.iMk));
        }
        if (this.iMe != null) {
            this.iMe.onChangeSkinType(i);
        }
        if (this.iMi != null) {
            am.setViewTextColor(this.iMi, (int) R.color.cp_cont_d);
        }
        if (this.iMh != null) {
            am.setViewTextColor(this.iMh, (int) R.color.cp_cont_d);
        }
        if (this.iMg != null) {
            am.setViewTextColor(this.iMg, (int) R.color.cp_cont_d);
        }
        if (this.iMj != null) {
            am.setViewTextColor(this.iMj, (int) R.color.cp_cont_d);
        }
    }

    public void onDestroy() {
        if (this.iLP != null) {
            this.iLP.wP();
        }
        if (this.iLT != null && this.iMd != null) {
            this.iLT.removeView(this.iLZ);
            this.iMd = null;
        }
    }

    public void cny() {
        if (this.iLP != null) {
            this.iLP.wP();
        }
    }
}
