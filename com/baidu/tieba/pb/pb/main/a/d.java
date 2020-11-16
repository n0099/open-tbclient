package com.baidu.tieba.pb.pb.main.a;

import android.content.Context;
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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ax;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.pb.main.f;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes21.dex */
public class d {
    private com.baidu.tieba.pb.a.c fgS;
    private View.OnClickListener iKO;
    private com.baidu.tieba.d.e lEB;
    private ImageView lED;
    private f lEE;
    private ThreadSkinView lEG;
    private ImageView lEJ;
    private HeadPendantView lEK;
    private TBLottieAnimationView lEL;
    private LinearLayout lEN;
    private LinearLayout lEO;
    private ax lER;
    private PbFragment lpX;
    private UserIconBox lso;
    private UserIconBox lsp;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout lEC = null;
    private ColumnLayout lEF = null;
    private TextView lEH = null;
    private TextView lEI = null;
    private FrameLayout lEM = null;
    private ClickableHeaderImageView lEP = null;
    private PbFirstFloorUserLikeButton lEQ = null;
    private TextView lES = null;
    private TextView lET = null;
    private TextView lEU = null;
    private TextView lEV = null;
    private TextView lEW = null;
    private int lEX = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.iKO = null;
        this.lpX = pbFragment;
        this.fgS = cVar;
        this.iKO = onClickListener;
        initView();
    }

    private void initView() {
        this.lEC = (RelativeLayout) LayoutInflater.from(this.lpX.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.lED = (ImageView) this.lEC.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.lED.getLayoutParams().height = ay.dmD();
        this.lEE = new f(this.lpX.getBaseFragmentActivity(), this.lEC);
        this.lEE.init();
        this.lEE.setOnClickListener(this.lEE.djf(), this.iKO);
        this.lEF = (ColumnLayout) this.lEC.findViewById(R.id.pb_head_owner_root);
        this.lEG = (ThreadSkinView) this.lEC.findViewById(R.id.pb_thread_skin);
        this.lEH = (TextView) this.lEF.findViewById(R.id.pb_head_owner_info_user_name);
        this.lEI = (TextView) this.lEF.findViewById(R.id.floor_owner);
        this.lEJ = (ImageView) this.lEF.findViewById(R.id.icon_forum_level);
        this.lEM = (FrameLayout) this.lEF.findViewById(R.id.pb_head_headImage_container);
        this.lEK = (HeadPendantView) this.lEF.findViewById(R.id.pb_pendant_head_owner_photo);
        this.lEK.setHasPendantStyle();
        this.lEL = (TBLottieAnimationView) this.lEF.findViewById(R.id.pb_head_living_lottie);
        this.lEF.setOnLongClickListener(this.mOnLongClickListener);
        this.lEF.setOnTouchListener(this.fgS);
        this.lEF.setVisibility(8);
        if (this.lEK.getHeadView() != null) {
            this.lEK.getHeadView().setIsRound(true);
            this.lEK.getHeadView().setDrawBorder(true);
            this.lEK.getHeadView().setPlaceHolder(1);
        }
        this.lso = (UserIconBox) this.lEF.findViewById(R.id.show_icon_vip);
        this.lsp = (UserIconBox) this.lEF.findViewById(R.id.show_icon_yinji);
        this.lEN = (LinearLayout) this.lEC.findViewById(R.id.pb_head_owner_info_root);
        this.lEO = (LinearLayout) this.lEF.findViewById(R.id.pb_first_floor_location_container);
        this.lEQ = (PbFirstFloorUserLikeButton) this.lEF.findViewById(R.id.pb_like_button);
        this.lES = (TextView) this.lEF.findViewById(R.id.pb_views);
        this.lET = (TextView) this.lEF.findViewById(R.id.pb_item_first_floor_reply_time);
        this.lEU = (TextView) this.lEF.findViewById(R.id.pb_item_first_floor_location_address);
        this.lEV = (TextView) this.lEF.findViewById(R.id.pb_item_first_floor_distance);
        this.lEW = (TextView) this.lEF.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View dom() {
        return this.lEC;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0287 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x037d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, com.baidu.tieba.pb.data.f fVar, PostData postData, View.OnClickListener onClickListener) {
        String cutChineseAndEnglishWithSuffix;
        ArrayList<IconData> tShowInfoNew;
        boolean z;
        if (postData != null && postData.blC() != null) {
            MetaData blC = postData.blC();
            String string = blC.getName_show() == null ? StringUtils.string(blC.getUserName()) : StringUtils.string(blC.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.blC().getSealPrefix())) {
                i2 = k.byteLength(blC.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = blC.getIconInfo();
                    tShowInfoNew = blC.getTShowInfoNew();
                    if (this.lsp != null) {
                        this.lsp.setTag(R.id.tag_user_id, blC.getUserId());
                        if (this.lpX.dkB() != null) {
                            this.lsp.setOnClickListener(this.lpX.dkB().lqj.lGr);
                        }
                        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        this.lsp.a(iconInfo, 4, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                    }
                    if (this.lso != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.lso.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.lpX.dkB() != null) {
                            this.lso.setOnClickListener(this.lpX.dkB().lqj.lGs);
                        }
                        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                        this.lso.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                    }
                    this.lEH.setText(dT(blC.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lEH.setTag(R.id.tag_user_id, blC.getUserId());
                    this.lEH.setTag(R.id.tag_user_name, blC.getName_show());
                    if (y.isEmpty(tShowInfoNew) || blC.isBigV()) {
                        ap.setViewTextColor(this.lEH, R.color.CAM_X0301, 1);
                    } else {
                        ap.setViewTextColor(this.lEH, R.color.CAM_X0105, 1);
                    }
                    if (!fVar.dik()) {
                        this.lEI.setVisibility(8);
                    } else if (blC.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(blC.getBawu_type())) {
                        this.lEI.setText(R.string.bawu_member_bazhu_tip);
                        this.lEI.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.bj(this.lEI).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else if (blC.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(blC.getBawu_type())) {
                        this.lEI.setText(R.string.bawu_member_xbazhu_tip);
                        this.lEI.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.bj(this.lEI).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else {
                        this.lEI.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.lET.setText(au.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.lET.setText(au.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.dik()) {
                        this.lEU.setVisibility(8);
                        if (this.lEO.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lEO.getLayoutParams()).rightMargin = 0;
                        }
                        this.lEF.setSpacingRight(0);
                        String str = null;
                        if (blC.getBaijiahaoInfo() != null) {
                            str = blC.getBaijiahaoInfo().auth_desc;
                        }
                        if (blC.isNewGod()) {
                            this.lEW.setVisibility(0);
                            this.lEW.setText(blC.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (blC.showBazhuGrade()) {
                            this.lEW.setVisibility(0);
                            this.lEW.setText(au.cutChineseAndEnglishWithSuffix(blC.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.lEW.setVisibility(0);
                            this.lEW.setText(str);
                        } else {
                            this.lEW.setVisibility(8);
                        }
                    } else {
                        if (blC.isNewGod()) {
                            this.lEW.setVisibility(0);
                            this.lEW.setText(blC.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
                        } else if (blC.showBazhuGrade()) {
                            this.lEW.setVisibility(0);
                            this.lEW.setText(au.cutChineseAndEnglishWithSuffix(blC.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.lEW.setVisibility(8);
                        }
                        if (this.lEO.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.lEO.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.lEF.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f dJT = postData.dJT();
                        if (dJT != null && !TextUtils.isEmpty(dJT.getName()) && !TextUtils.isEmpty(dJT.getName().trim())) {
                            this.lEU.setVisibility(0);
                            this.lEU.setText(dJT.getName());
                        } else {
                            this.lEU.setVisibility(8);
                        }
                        if (dJT != null && !TextUtils.isEmpty(dJT.getDistance())) {
                            this.lEV.setText(dJT.getDistance());
                            this.lEV.setVisibility(0);
                            final int measureText = (int) this.lEV.getPaint().measureText(dJT.getDistance(), 0, dJT.getDistance().length());
                            this.lEO.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = d.this.lEO.getMeasuredWidth();
                                    int measuredWidth2 = d.this.lET.getMeasuredWidth();
                                    int measuredWidth3 = d.this.lEW.getMeasuredWidth();
                                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                                    if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                                        d.this.lEV.setVisibility(8);
                                        d.this.lEU.setVisibility(8);
                                    } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize) {
                                        d.this.lEU.setVisibility(8);
                                    }
                                }
                            });
                        } else {
                            this.lEV.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.dhH().blC() != null && fVar.dhH().blC().getAlaInfo() != null && fVar.dhH().blC().getAlaInfo().live_status == 1) {
                        don();
                        z = true;
                    }
                    this.lEK.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.lEK.a(blC, 4);
                        this.lEK.setIsclearmode(false);
                    } else {
                        this.lEK.setIsclearmode(true);
                    }
                    this.lEK.setVisibility(0);
                    if (this.lEP != null) {
                        this.lEP.setVisibility(8);
                    }
                    this.lEH.setOnClickListener(onClickListener);
                    this.lEK.getHeadView().setUserId(blC.getUserId());
                    this.lEK.getHeadView().setUserName(blC.getUserName());
                    this.lEK.getHeadView().setTid(postData.getId());
                    this.lEK.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lEK.getHeadView().setFName(fVar.getForumName());
                    this.lEK.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.lEK.BP(blC.getAvater());
                    } else {
                        this.lEK.a(blC);
                    }
                    String name_show = blC.getName_show();
                    String userName = blC.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.lEH.setText(com.baidu.tieba.pb.c.aR(this.lpX.getPageContext().getPageActivity(), this.lEH.getText().toString()));
                        this.lEH.setGravity(16);
                        this.lEH.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dhr());
                        ap.setViewTextColor(this.lEH, R.color.CAM_X0312, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = blC.getIconInfo();
                tShowInfoNew = blC.getTShowInfoNew();
                if (this.lsp != null) {
                }
                if (this.lso != null) {
                }
                this.lEH.setText(dT(blC.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lEH.setTag(R.id.tag_user_id, blC.getUserId());
                this.lEH.setTag(R.id.tag_user_name, blC.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.lEH, R.color.CAM_X0301, 1);
                if (!fVar.dik()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dik()) {
                }
                z = false;
                if (fVar.dhH().blC() != null) {
                    don();
                    z = true;
                }
                this.lEK.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lEK.setVisibility(0);
                if (this.lEP != null) {
                }
                this.lEH.setOnClickListener(onClickListener);
                this.lEK.getHeadView().setUserId(blC.getUserId());
                this.lEK.getHeadView().setUserName(blC.getUserName());
                this.lEK.getHeadView().setTid(postData.getId());
                this.lEK.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lEK.getHeadView().setFName(fVar.getForumName());
                this.lEK.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = blC.getName_show();
                String userName2 = blC.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.lEH.setText(com.baidu.tieba.pb.c.aR(this.lpX.getPageContext().getPageActivity(), this.lEH.getText().toString()));
                    this.lEH.setGravity(16);
                    this.lEH.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dhr());
                    ap.setViewTextColor(this.lEH, R.color.CAM_X0312, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = blC.getIconInfo();
                    tShowInfoNew = blC.getTShowInfoNew();
                    if (this.lsp != null) {
                    }
                    if (this.lso != null) {
                    }
                    this.lEH.setText(dT(blC.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.lEH.setTag(R.id.tag_user_id, blC.getUserId());
                    this.lEH.setTag(R.id.tag_user_name, blC.getName_show());
                    if (y.isEmpty(tShowInfoNew)) {
                    }
                    ap.setViewTextColor(this.lEH, R.color.CAM_X0301, 1);
                    if (!fVar.dik()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.dik()) {
                    }
                    z = false;
                    if (fVar.dhH().blC() != null) {
                    }
                    this.lEK.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.lEK.setVisibility(0);
                    if (this.lEP != null) {
                    }
                    this.lEH.setOnClickListener(onClickListener);
                    this.lEK.getHeadView().setUserId(blC.getUserId());
                    this.lEK.getHeadView().setUserName(blC.getUserName());
                    this.lEK.getHeadView().setTid(postData.getId());
                    this.lEK.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.lEK.getHeadView().setFName(fVar.getForumName());
                    this.lEK.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = blC.getName_show();
                    String userName22 = blC.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = blC.getIconInfo();
                tShowInfoNew = blC.getTShowInfoNew();
                if (this.lsp != null) {
                }
                if (this.lso != null) {
                }
                this.lEH.setText(dT(blC.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.lEH.setTag(R.id.tag_user_id, blC.getUserId());
                this.lEH.setTag(R.id.tag_user_name, blC.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.lEH, R.color.CAM_X0301, 1);
                if (!fVar.dik()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dik()) {
                }
                z = false;
                if (fVar.dhH().blC() != null) {
                }
                this.lEK.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.lEK.setVisibility(0);
                if (this.lEP != null) {
                }
                this.lEH.setOnClickListener(onClickListener);
                this.lEK.getHeadView().setUserId(blC.getUserId());
                this.lEK.getHeadView().setUserName(blC.getUserName());
                this.lEK.getHeadView().setTid(postData.getId());
                this.lEK.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.lEK.getHeadView().setFName(fVar.getForumName());
                this.lEK.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = blC.getName_show();
                String userName222 = blC.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.lEE.aI(fVar.dhH());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.din()) {
                this.lEQ.setVisibility(0);
            }
            if (z) {
                this.lEQ.setVisibility(8);
                if (fVar != null && fVar.dhH() != null && fVar.dhH().getBaijiahaoData() != null && fVar.dhH().getBaijiahaoData().oriUgcType == 3) {
                    this.lES.setVisibility(8);
                } else {
                    this.lES.setVisibility(0);
                }
                this.lES.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), au.numberUniformFormatExtra(fVar.dif())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.blC().hadConcerned()) {
                this.lEQ.setVisibility(8);
                this.lES.setVisibility(8);
            } else {
                this.lES.setVisibility(8);
            }
            if (fVar.lnn || 3 == fVar.din()) {
                this.lEQ.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ay.r(fVar);
            if (z && postData != null && postData.blC() != null) {
                postData.blC().setIsLike(postData.blC().hadConcerned());
            }
            if (this.lER == null) {
                bx dhH = fVar.dhH();
                int i = 1;
                if (dhH != null) {
                    if (dhH.bkk()) {
                        i = 4;
                    } else if (dhH.bkl()) {
                        i = 6;
                    } else if (dhH.bnA()) {
                        i = 7;
                    } else if (dhH.bnz()) {
                        i = 5;
                    }
                }
                this.lER = new ax(this.lpX.getPageContext(), this.lEQ, i);
                this.lER.l(this.lpX.getUniqueId());
                this.lER.setThreadData(dhH);
            }
            if (postData != null && postData.blC() != null) {
                postData.blC().setIsLike(postData.blC().hadConcerned());
                this.lER.a(postData.blC());
                this.lER.setTid(threadId);
            }
            this.lER.lBj = z2;
            this.lER.GE(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.blY() != null) {
                this.lEG.setData(this.lpX.getPageContext(), fVar.dhJ().get(0).blY(), com.baidu.tieba.tbadkCore.d.a.g("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.dhH().getId(), this.lpX.bjk() ? "FRS" : null));
                this.lEF.setPadding(this.lEF.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.lEF.getPaddingRight(), this.lEF.getPaddingBottom());
                return;
            }
            this.lEG.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.lpX.diN()) {
            this.lEX = 0;
            if (postData != null && postData.blC() != null) {
                this.lEX = postData.blC().getLevel_id();
            }
            if (this.lEX > 0 && !z) {
                this.lEJ.setVisibility(0);
                ap.setImageResource(this.lEJ, BitmapHelper.getGradeResourceIdInEnterForum(this.lEX));
                return;
            }
            this.lEJ.setVisibility(8);
            return;
        }
        this.lEJ.setVisibility(8);
    }

    public void G(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dih()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.lEF.getPaddingBottom();
            if (fVar.dik()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.lEF.setPadding(this.lEF.getPaddingLeft(), dimens, this.lEF.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        int paddingBottom2 = this.lEF.getPaddingBottom();
        if (fVar != null && !fVar.dhH().bki() && fVar.dik() && (!StringUtils.isNull(fVar.dhH().getTitle()) || fVar.dhH().bmm() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.lEF.setPadding(this.lEF.getPaddingLeft(), dimens2, this.lEF.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.lEF.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lEC);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.lEC, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.lEC);
        }
    }

    public void setVisibility(int i) {
        this.lEF.setVisibility(i);
    }

    private void don() {
        if (this.lEL != null) {
            this.lEL.setVisibility(0);
            this.lEL.setSpeed(0.8f);
            this.lEL.loop(true);
            this.lEL.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.lEL.playAnimation();
                }
            });
        }
    }

    public void c(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lno) {
            this.lED.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lED.setVisibility(0);
        } else if (z && z2) {
            this.lED.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lED.setVisibility(0);
        } else if (z) {
            this.lED.setImageResource(R.drawable.pic_pb_refined_n);
            this.lED.setVisibility(0);
        } else if (z2) {
            this.lED.setImageResource(R.drawable.pic_pb_stick_n);
            this.lED.setVisibility(0);
        } else {
            this.lED.setVisibility(8);
        }
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str));
            return n.a((Context) this.lpX.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> doo() {
        SparseArray<Object> sparseArray = (SparseArray) this.lEF.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.lEF.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView djf() {
        return this.lEE.djf();
    }

    public void ub(boolean z) {
        this.lEE.ub(z);
    }

    public void onChangeSkinType(int i) {
        if (this.lEJ != null) {
            ap.setImageResource(this.lEJ, BitmapHelper.getGradeResourceIdInEnterForum(this.lEX));
        }
        if (this.lEQ != null) {
            this.lEQ.onChangeSkinType(i);
        }
        if (this.lEU != null) {
            ap.setViewTextColor(this.lEU, R.color.CAM_X0109);
        }
        if (this.lET != null) {
            ap.setViewTextColor(this.lET, R.color.CAM_X0109);
        }
        if (this.lES != null) {
            ap.setViewTextColor(this.lES, R.color.CAM_X0109);
        }
        if (this.lEW != null) {
            ap.setViewTextColor(this.lEW, R.color.CAM_X0109);
        }
        if (this.lEV != null) {
            ap.setViewTextColor(this.lEV, R.color.CAM_X0109);
        }
        if (i == 4) {
            if (this.lEL != null) {
                this.lEL.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.lEL != null) {
                this.lEL.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.lEL != null) {
            this.lEL.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.lEB != null) {
            this.lEB.Si();
        }
        if (this.lEF != null && this.lEP != null) {
            this.lEF.removeView(this.lEM);
            this.lEP = null;
        }
        if (this.lEL != null) {
            this.lEL.cancelAnimation();
        }
    }

    public void dnA() {
        if (this.lEB != null) {
            this.lEB.Si();
        }
    }
}
