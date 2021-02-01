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
import com.baidu.tbadk.core.data.cb;
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
import com.baidu.tbadk.util.aj;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.an;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class e {
    private com.baidu.tieba.pb.a.c fvK;
    private View.OnClickListener jiV;
    private PbFragment lMX;
    private UserIconBox lPw;
    private UserIconBox lPx;
    private com.baidu.tieba.c.e mcf;
    private ImageView mch;
    private com.baidu.tieba.pb.pb.main.f mci;
    private ThreadSkinView mck;
    private ImageView mcn;
    private HeadPendantView mco;
    private TBLottieAnimationView mcp;
    private LinearLayout mcr;
    private LinearLayout mcs;
    private an mcv;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout mcg = null;
    private ColumnLayout mcj = null;
    private TextView mcl = null;
    private TextView mcm = null;
    private FrameLayout mcq = null;
    private ClickableHeaderImageView mct = null;
    private PbFirstFloorUserLikeButton mcu = null;
    private TextView mcw = null;
    private TextView mcx = null;
    private TextView mcy = null;
    private TextView mcz = null;
    private TextView mcA = null;
    private int mcB = 0;

    public e(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.jiV = null;
        this.lMX = pbFragment;
        this.fvK = cVar;
        this.jiV = onClickListener;
        initView();
    }

    private void initView() {
        this.mcg = (RelativeLayout) LayoutInflater.from(this.lMX.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.mch = (ImageView) this.mcg.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.mch.getLayoutParams().height = ao.dqe();
        this.mci = new com.baidu.tieba.pb.pb.main.f(this.lMX.getBaseFragmentActivity(), this.mcg);
        this.mci.init();
        this.mci.setOnClickListener(this.mci.dmA(), this.jiV);
        this.mcj = (ColumnLayout) this.mcg.findViewById(R.id.pb_head_owner_root);
        this.mck = (ThreadSkinView) this.mcg.findViewById(R.id.pb_thread_skin);
        this.mcl = (TextView) this.mcj.findViewById(R.id.pb_head_owner_info_user_name);
        this.mcm = (TextView) this.mcj.findViewById(R.id.floor_owner);
        this.mcn = (ImageView) this.mcj.findViewById(R.id.icon_forum_level);
        this.mcq = (FrameLayout) this.mcj.findViewById(R.id.pb_head_headImage_container);
        this.mco = (HeadPendantView) this.mcj.findViewById(R.id.pb_pendant_head_owner_photo);
        this.mco.setHasPendantStyle();
        this.mcp = (TBLottieAnimationView) this.mcj.findViewById(R.id.pb_head_living_lottie);
        this.mcj.setOnLongClickListener(this.mOnLongClickListener);
        this.mcj.setOnTouchListener(this.fvK);
        this.mcj.setVisibility(8);
        if (this.mco.getHeadView() != null) {
            this.mco.getHeadView().setIsRound(true);
            this.mco.getHeadView().setDrawBorder(true);
            this.mco.getHeadView().setPlaceHolder(1);
        }
        this.lPw = (UserIconBox) this.mcj.findViewById(R.id.show_icon_vip);
        this.lPx = (UserIconBox) this.mcj.findViewById(R.id.show_icon_yinji);
        this.mcr = (LinearLayout) this.mcg.findViewById(R.id.pb_head_owner_info_root);
        this.mcs = (LinearLayout) this.mcj.findViewById(R.id.pb_first_floor_location_container);
        this.mcu = (PbFirstFloorUserLikeButton) this.mcj.findViewById(R.id.pb_like_button);
        this.mcw = (TextView) this.mcj.findViewById(R.id.pb_views);
        this.mcx = (TextView) this.mcj.findViewById(R.id.pb_item_first_floor_reply_time);
        this.mcy = (TextView) this.mcj.findViewById(R.id.pb_item_first_floor_location_address);
        this.mcz = (TextView) this.mcj.findViewById(R.id.pb_item_first_floor_distance);
        this.mcA = (TextView) this.mcj.findViewById(R.id.pb_item_first_floor_general_desc);
    }

    public View drQ() {
        return this.mcg;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0281 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0377  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, com.baidu.tieba.pb.data.f fVar, PostData postData, View.OnClickListener onClickListener) {
        String cutChineseAndEnglishWithSuffix;
        ArrayList<IconData> tShowInfoNew;
        boolean z;
        if (postData != null && postData.bnQ() != null) {
            MetaData bnQ = postData.bnQ();
            String string = bnQ.getName_show() == null ? StringUtils.string(bnQ.getUserName()) : StringUtils.string(bnQ.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.bnQ().getSealPrefix())) {
                i2 = k.byteLength(bnQ.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = bnQ.getIconInfo();
                    tShowInfoNew = bnQ.getTShowInfoNew();
                    if (this.lPx != null) {
                        this.lPx.setTag(R.id.tag_user_id, bnQ.getUserId());
                        if (this.lMX.doa() != null) {
                            this.lPx.setOnClickListener(this.lMX.doa().lNj.mdX);
                        }
                        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        this.lPx.a(iconInfo, 4, dimens, dimens, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                    }
                    if (this.lPw != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.lPw.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.lMX.doa() != null) {
                            this.lPw.setOnClickListener(this.lMX.doa().lNj.mdY);
                        }
                        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                        this.lPw.a(tShowInfoNew, 3, dimens2, dimens2, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                    }
                    this.mcl.setText(dT(bnQ.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.mcl.setTag(R.id.tag_user_id, bnQ.getUserId());
                    this.mcl.setTag(R.id.tag_user_name, bnQ.getName_show());
                    if (y.isEmpty(tShowInfoNew) || bnQ.isBigV()) {
                        ap.setViewTextColor(this.mcl, R.color.CAM_X0301, 1);
                    } else {
                        ap.setViewTextColor(this.mcl, R.color.CAM_X0105, 1);
                    }
                    if (!fVar.dlC()) {
                        this.mcm.setVisibility(8);
                    } else if (bnQ.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bnQ.getBawu_type())) {
                        this.mcm.setText(R.string.bawu_member_bazhu_tip);
                        this.mcm.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.br(this.mcm).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else if (bnQ.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bnQ.getBawu_type())) {
                        this.mcm.setText(R.string.bawu_member_xbazhu_tip);
                        this.mcm.setVisibility(0);
                        com.baidu.tbadk.core.elementsMaven.c.br(this.mcm).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    } else {
                        this.mcm.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.mcx.setText(au.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.mcx.setText(au.getFormatTime(postData.getTime()));
                    }
                    if (!fVar.dlC()) {
                        this.mcy.setVisibility(8);
                        if (this.mcs.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.mcs.getLayoutParams()).rightMargin = 0;
                        }
                        this.mcj.setSpacingRight(0);
                        String str = null;
                        if (bnQ.getBaijiahaoInfo() != null) {
                            str = bnQ.getBaijiahaoInfo().auth_desc;
                        }
                        if (bnQ.isNewGod()) {
                            this.mcA.setVisibility(0);
                            this.mcA.setText(bnQ.getNewGodData().getFieldName() + aj.lA(bnQ.isVideoGod()));
                        } else if (bnQ.showBazhuGrade()) {
                            this.mcA.setVisibility(0);
                            this.mcA.setText(au.cutChineseAndEnglishWithSuffix(bnQ.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else if (!StringUtils.isNull(str)) {
                            this.mcA.setVisibility(0);
                            this.mcA.setText(str);
                        } else {
                            this.mcA.setVisibility(8);
                        }
                    } else {
                        if (bnQ.isNewGod()) {
                            this.mcA.setVisibility(0);
                            this.mcA.setText(bnQ.getNewGodData().getFieldName() + aj.rF(bnQ.getNewGodData().getType()));
                        } else if (bnQ.showBazhuGrade()) {
                            this.mcA.setVisibility(0);
                            this.mcA.setText(au.cutChineseAndEnglishWithSuffix(bnQ.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                        } else {
                            this.mcA.setVisibility(8);
                        }
                        if (this.mcs.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.mcs.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.mcj.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.g dNA = postData.dNA();
                        if (dNA != null && !TextUtils.isEmpty(dNA.getName()) && !TextUtils.isEmpty(dNA.getName().trim())) {
                            this.mcy.setVisibility(0);
                            this.mcy.setText(dNA.getName());
                        } else {
                            this.mcy.setVisibility(8);
                        }
                        if (dNA != null && !TextUtils.isEmpty(dNA.getDistance())) {
                            this.mcz.setText(dNA.getDistance());
                            this.mcz.setVisibility(0);
                            final int measureText = (int) this.mcz.getPaint().measureText(dNA.getDistance(), 0, dNA.getDistance().length());
                            this.mcs.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = e.this.mcs.getMeasuredWidth();
                                    int measuredWidth2 = e.this.mcx.getMeasuredWidth();
                                    int measuredWidth3 = e.this.mcA.getMeasuredWidth();
                                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                                    if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                                        e.this.mcz.setVisibility(8);
                                        e.this.mcy.setVisibility(8);
                                    } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize) {
                                        e.this.mcy.setVisibility(8);
                                    }
                                }
                            });
                        } else {
                            this.mcz.setVisibility(8);
                        }
                    }
                    z = false;
                    if (fVar.dkZ().bnQ() != null && fVar.dkZ().bnQ().getAlaInfo() != null && fVar.dkZ().bnQ().getAlaInfo().live_status == 1) {
                        drR();
                        z = true;
                    }
                    this.mco.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                        this.mco.a(bnQ, 4);
                        this.mco.setIsclearmode(false);
                    } else {
                        this.mco.setIsclearmode(true);
                    }
                    this.mco.setVisibility(0);
                    if (this.mct != null) {
                        this.mct.setVisibility(8);
                    }
                    this.mcl.setOnClickListener(onClickListener);
                    this.mco.getHeadView().setUserId(bnQ.getUserId());
                    this.mco.getHeadView().setUserName(bnQ.getUserName());
                    this.mco.getHeadView().setTid(postData.getId());
                    this.mco.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.mco.getHeadView().setFName(fVar.getForumName());
                    this.mco.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.mco.BA(bnQ.getAvater());
                    } else {
                        this.mco.a(bnQ);
                    }
                    String name_show = bnQ.getName_show();
                    String userName = bnQ.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.mcl.setText(com.baidu.tieba.pb.c.ba(this.lMX.getPageContext().getPageActivity(), this.mcl.getText().toString()));
                        this.mcl.setGravity(16);
                        this.mcl.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dkJ());
                        ap.setViewTextColor(this.mcl, R.color.CAM_X0312, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = bnQ.getIconInfo();
                tShowInfoNew = bnQ.getTShowInfoNew();
                if (this.lPx != null) {
                }
                if (this.lPw != null) {
                }
                this.mcl.setText(dT(bnQ.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.mcl.setTag(R.id.tag_user_id, bnQ.getUserId());
                this.mcl.setTag(R.id.tag_user_name, bnQ.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.mcl, R.color.CAM_X0301, 1);
                if (!fVar.dlC()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dlC()) {
                }
                z = false;
                if (fVar.dkZ().bnQ() != null) {
                    drR();
                    z = true;
                }
                this.mco.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.mco.setVisibility(0);
                if (this.mct != null) {
                }
                this.mcl.setOnClickListener(onClickListener);
                this.mco.getHeadView().setUserId(bnQ.getUserId());
                this.mco.getHeadView().setUserName(bnQ.getUserName());
                this.mco.getHeadView().setTid(postData.getId());
                this.mco.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.mco.getHeadView().setFName(fVar.getForumName());
                this.mco.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = bnQ.getName_show();
                String userName2 = bnQ.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.mcl.setText(com.baidu.tieba.pb.c.ba(this.lMX.getPageContext().getPageActivity(), this.mcl.getText().toString()));
                    this.mcl.setGravity(16);
                    this.mcl.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dkJ());
                    ap.setViewTextColor(this.mcl, R.color.CAM_X0312, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = bnQ.getIconInfo();
                    tShowInfoNew = bnQ.getTShowInfoNew();
                    if (this.lPx != null) {
                    }
                    if (this.lPw != null) {
                    }
                    this.mcl.setText(dT(bnQ.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.mcl.setTag(R.id.tag_user_id, bnQ.getUserId());
                    this.mcl.setTag(R.id.tag_user_name, bnQ.getName_show());
                    if (y.isEmpty(tShowInfoNew)) {
                    }
                    ap.setViewTextColor(this.mcl, R.color.CAM_X0301, 1);
                    if (!fVar.dlC()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!fVar.dlC()) {
                    }
                    z = false;
                    if (fVar.dkZ().bnQ() != null) {
                    }
                    this.mco.setBigVDimenSize(R.dimen.tbds32);
                    if (z) {
                    }
                    this.mco.setVisibility(0);
                    if (this.mct != null) {
                    }
                    this.mcl.setOnClickListener(onClickListener);
                    this.mco.getHeadView().setUserId(bnQ.getUserId());
                    this.mco.getHeadView().setUserName(bnQ.getUserName());
                    this.mco.getHeadView().setTid(postData.getId());
                    this.mco.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                    this.mco.getHeadView().setFName(fVar.getForumName());
                    this.mco.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = bnQ.getName_show();
                    String userName22 = bnQ.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = bnQ.getIconInfo();
                tShowInfoNew = bnQ.getTShowInfoNew();
                if (this.lPx != null) {
                }
                if (this.lPw != null) {
                }
                this.mcl.setText(dT(bnQ.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.mcl.setTag(R.id.tag_user_id, bnQ.getUserId());
                this.mcl.setTag(R.id.tag_user_name, bnQ.getName_show());
                if (y.isEmpty(tShowInfoNew)) {
                }
                ap.setViewTextColor(this.mcl, R.color.CAM_X0301, 1);
                if (!fVar.dlC()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!fVar.dlC()) {
                }
                z = false;
                if (fVar.dkZ().bnQ() != null) {
                }
                this.mco.setBigVDimenSize(R.dimen.tbds32);
                if (z) {
                }
                this.mco.setVisibility(0);
                if (this.mct != null) {
                }
                this.mcl.setOnClickListener(onClickListener);
                this.mco.getHeadView().setUserId(bnQ.getUserId());
                this.mco.getHeadView().setUserName(bnQ.getUserName());
                this.mco.getHeadView().setTid(postData.getId());
                this.mco.getHeadView().setFid(fVar == null ? fVar.getForumId() : "");
                this.mco.getHeadView().setFName(fVar.getForumName());
                this.mco.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = bnQ.getName_show();
                String userName222 = bnQ.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (fVar != null) {
            this.mci.aK(fVar.dkZ());
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z) {
        if (fVar != null && postData != null) {
            if (3 != fVar.dlF()) {
                this.mcu.setVisibility(0);
            }
            if (z) {
                this.mcu.setVisibility(8);
                if (fVar != null && fVar.dkZ() != null && fVar.dkZ().getBaijiahaoData() != null && fVar.dkZ().getBaijiahaoData().oriUgcType == 3) {
                    this.mcw.setVisibility(8);
                } else {
                    this.mcw.setVisibility(0);
                }
                this.mcw.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), au.numberUniformFormatExtra(fVar.dlx())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.bnQ().hadConcerned()) {
                this.mcu.setVisibility(8);
                this.mcw.setVisibility(8);
            } else {
                this.mcw.setVisibility(8);
            }
            if (fVar.lKb || 3 == fVar.dlF()) {
                this.mcu.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, PostData postData, boolean z, boolean z2) {
        if (fVar != null && postData != null) {
            String threadId = fVar != null ? fVar.getThreadId() : "";
            int r = ao.r(fVar);
            if (z && postData != null && postData.bnQ() != null) {
                postData.bnQ().setIsLike(postData.bnQ().hadConcerned());
            }
            if (this.mcv == null) {
                cb dkZ = fVar.dkZ();
                int i = 1;
                if (dkZ != null) {
                    if (dkZ.bmx()) {
                        i = 4;
                    } else if (dkZ.bmy()) {
                        i = 6;
                    } else if (dkZ.bpO()) {
                        i = 7;
                    } else if (dkZ.bpN()) {
                        i = 5;
                    }
                }
                this.mcv = new an(this.lMX.getPageContext(), this.mcu, i);
                this.mcv.l(this.lMX.getUniqueId());
                this.mcv.setThreadData(dkZ);
            }
            if (postData != null && postData.bnQ() != null) {
                postData.bnQ().setIsLike(postData.bnQ().hadConcerned());
                this.mcv.a(postData.bnQ());
                this.mcv.setTid(threadId);
            }
            this.mcv.lYB = z2;
            this.mcv.Ga(r);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && fVar != null) {
            if (postData.bol() != null) {
                this.mck.setData(this.lMX.getPageContext(), fVar.dlb().get(0).bol(), com.baidu.tieba.tbadkCore.d.a.i("PB", "c0132", fVar.getForum().getId(), fVar.getForum().getName(), fVar.dkZ().getId(), this.lMX.blu() ? "FRS" : null));
                this.mcj.setPadding(this.mcj.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.mcj.getPaddingRight(), this.mcj.getPaddingBottom());
                return;
            }
            this.mck.setData(null, null, null);
        }
    }

    public void b(PostData postData, boolean z) {
        if (this.lMX.dmi()) {
            this.mcB = 0;
            if (postData != null && postData.bnQ() != null) {
                this.mcB = postData.bnQ().getLevel_id();
            }
            if (this.mcB > 0 && !z) {
                this.mcn.setVisibility(0);
                ap.setImageResource(this.mcn, BitmapHelper.getGradeResourceIdInEnterForum(this.mcB));
                return;
            }
            this.mcn.setVisibility(8);
            return;
        }
        this.mcn.setVisibility(8);
    }

    public void G(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlz()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.mcj.getPaddingBottom();
            if (fVar.dlC()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.mcj.setPadding(this.mcj.getPaddingLeft(), dimens, this.mcj.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        int paddingBottom2 = this.mcj.getPaddingBottom();
        if (fVar != null && !fVar.dkZ().bmv() && fVar.dlC() && (!StringUtils.isNull(fVar.dkZ().getTitle()) || fVar.dkZ().boz() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.mcj.setPadding(this.mcj.getPaddingLeft(), dimens2, this.mcj.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.mcj.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.mcg);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.mcg, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.mcg);
        }
    }

    public void setVisibility(int i) {
        this.mcj.setVisibility(i);
    }

    private void drR() {
        if (this.mcp != null) {
            this.mcp.setVisibility(0);
            this.mcp.setSpeed(0.8f);
            this.mcp.loop(true);
            this.mcp.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.mcp.playAnimation();
                }
            });
        }
    }

    public void c(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lKc) {
            this.mch.setImageResource(R.drawable.pic_frs_headlines_n);
            this.mch.setVisibility(0);
        } else if (z && z2) {
            this.mch.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.mch.setVisibility(0);
        } else if (z) {
            this.mch.setImageResource(R.drawable.pic_pb_refined_n);
            this.mch.setVisibility(0);
        } else if (z2) {
            this.mch.setImageResource(R.drawable.pic_pb_stick_n);
            this.mch.setVisibility(0);
        } else {
            this.mch.setVisibility(8);
        }
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.lMX.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> drS() {
        SparseArray<Object> sparseArray = (SparseArray) this.mcj.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.mcj.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView dmA() {
        return this.mci.dmA();
    }

    public void uO(boolean z) {
        this.mci.uO(z);
    }

    public void onChangeSkinType(int i) {
        if (this.mcn != null) {
            ap.setImageResource(this.mcn, BitmapHelper.getGradeResourceIdInEnterForum(this.mcB));
        }
        if (this.mcu != null) {
            this.mcu.onChangeSkinType(i);
        }
        if (this.mcy != null) {
            ap.setViewTextColor(this.mcy, R.color.CAM_X0109);
        }
        if (this.mcx != null) {
            ap.setViewTextColor(this.mcx, R.color.CAM_X0109);
        }
        if (this.mcw != null) {
            ap.setViewTextColor(this.mcw, R.color.CAM_X0109);
        }
        if (this.mcA != null) {
            ap.setViewTextColor(this.mcA, R.color.CAM_X0109);
        }
        if (this.mcz != null) {
            ap.setViewTextColor(this.mcz, R.color.CAM_X0109);
        }
        if (this.mcp != null) {
            ap.a(this.mcp, R.raw.card_live_header_bg);
        }
    }

    public void onDestroy() {
        if (this.mcf != null) {
            this.mcf.Tz();
        }
        if (this.mcj != null && this.mct != null) {
            this.mcj.removeView(this.mcq);
            this.mct = null;
        }
        if (this.mcp != null) {
            this.mcp.cancelAnimation();
        }
    }

    public void drd() {
        if (this.mcf != null) {
            this.mcf.Tz();
        }
    }
}
