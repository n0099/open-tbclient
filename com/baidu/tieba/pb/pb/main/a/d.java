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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
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
    private LayerDrawable agj;
    private LayerDrawable agk;
    private com.baidu.tieba.pb.a.c dRm;
    private View.OnClickListener haG;
    private com.baidu.tieba.c.d jCQ;
    private ImageView jCS;
    private com.baidu.tieba.pb.pb.main.e jCT;
    private ThreadSkinView jCV;
    private ImageView jCY;
    private HeadPendantView jCZ;
    private TBLottieAnimationView jDa;
    private LinearLayout jDc;
    private LinearLayout jDd;
    private al jDg;
    private PbFragment jpW;
    private UserIconBox jrS;
    private UserIconBox jrT;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout jCR = null;
    private ColumnLayout jCU = null;
    private TextView jCW = null;
    private TextView jCX = null;
    private FrameLayout jDb = null;
    private ClickableHeaderImageView jDe = null;
    private PbFirstFloorUserLikeButton jDf = null;
    private TextView jDh = null;
    private TextView jDi = null;
    private TextView jDj = null;
    private TextView jDk = null;
    private int jDl = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.haG = null;
        this.jpW = pbFragment;
        this.dRm = cVar;
        this.haG = onClickListener;
        int dimens = l.getDimens(this.jpW.getContext(), R.dimen.tbds6);
        this.agj = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aPx(), com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(dimens).vd("#4D000000").aPx()});
        this.agk = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aPx(), com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(dimens).vd("#4D000000").aPx()});
        initView();
    }

    private void initView() {
        this.jCR = (RelativeLayout) LayoutInflater.from(this.jpW.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.jCS = (ImageView) this.jCR.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.jCS.getLayoutParams().height = am.cAc();
        this.jCT = new com.baidu.tieba.pb.pb.main.e(this.jpW.getBaseFragmentActivity(), this.jCR);
        this.jCT.init();
        this.jCT.a(this.jCT.cwL(), this.haG);
        this.jCU = (ColumnLayout) this.jCR.findViewById(R.id.pb_head_owner_root);
        this.jCV = (ThreadSkinView) this.jCR.findViewById(R.id.pb_thread_skin);
        this.jCW = (TextView) this.jCU.findViewById(R.id.pb_head_owner_info_user_name);
        this.jCW.getPaint().setFakeBoldText(true);
        this.jCX = (TextView) this.jCU.findViewById(R.id.floor_owner);
        this.jCY = (ImageView) this.jCU.findViewById(R.id.icon_forum_level);
        this.jDb = (FrameLayout) this.jCU.findViewById(R.id.pb_head_headImage_container);
        this.jCZ = (HeadPendantView) this.jCU.findViewById(R.id.pb_pendant_head_owner_photo);
        this.jCZ.setHasPendantStyle();
        this.jDa = (TBLottieAnimationView) this.jCU.findViewById(R.id.pb_head_living_lottie);
        this.jCU.setOnLongClickListener(this.mOnLongClickListener);
        this.jCU.setOnTouchListener(this.dRm);
        this.jCU.setVisibility(8);
        if (this.jCZ.getHeadView() != null) {
            this.jCZ.getHeadView().setIsRound(true);
            this.jCZ.getHeadView().setDrawBorder(false);
            this.jCZ.getHeadView().setPlaceHolder(1);
        }
        this.jrS = (UserIconBox) this.jCU.findViewById(R.id.show_icon_vip);
        this.jrT = (UserIconBox) this.jCU.findViewById(R.id.show_icon_yinji);
        this.jDc = (LinearLayout) this.jCR.findViewById(R.id.pb_head_owner_info_root);
        this.jDd = (LinearLayout) this.jCU.findViewById(R.id.pb_first_floor_location_container);
        this.jDf = (PbFirstFloorUserLikeButton) this.jCU.findViewById(R.id.pb_like_button);
        this.jDh = (TextView) this.jCU.findViewById(R.id.pb_views);
        this.jDi = (TextView) this.jCU.findViewById(R.id.pb_item_first_floor_reply_time);
        this.jDj = (TextView) this.jCU.findViewById(R.id.pb_item_first_floor_location_address);
        this.jDk = (TextView) this.jCU.findViewById(R.id.pb_item_first_floor_bjh_desc);
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
        if (postData != null && postData.aKC() != null) {
            MetaData aKC = postData.aKC();
            String string = aKC.getName_show() == null ? StringUtils.string(aKC.getUserName()) : StringUtils.string(aKC.getName_show());
            int i2 = 0;
            if (!StringUtils.isNull(postData.aKC().getSealPrefix())) {
                i2 = k.byteLength(aKC.getSealPrefix()) + 2;
            }
            if (i2 > 0) {
                if (k.byteLength(string) > 12) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo = aKC.getIconInfo();
                    tShowInfoNew = aKC.getTShowInfoNew();
                    if (this.jrT != null) {
                        this.jrT.setTag(R.id.tag_user_id, aKC.getUserId());
                        if (this.jpW.cyi() != null) {
                            this.jrT.setOnClickListener(this.jpW.cyi().jqi.jEE);
                        }
                        this.jrT.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.jrS != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.jrS.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.jpW.cyi() != null) {
                            this.jrS.setOnClickListener(this.jpW.cyi().jqi.jEF);
                        }
                        this.jrS.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.jCW.setText(cL(aKC.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.jCW.setTag(R.id.tag_user_id, aKC.getUserId());
                    this.jCW.setTag(R.id.tag_user_name, aKC.getName_show());
                    if (v.isEmpty(tShowInfoNew) || aKC.isBigV()) {
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.jCW, R.color.cp_cont_h, 1);
                    } else {
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.jCW, R.color.cp_cont_b, 1);
                    }
                    if (!eVar.cvQ()) {
                        this.jCX.setVisibility(8);
                    } else if (aKC.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aKC.getBawu_type())) {
                        this.jCX.setText(R.string.bawu_member_bazhu_tip);
                        this.jCX.setVisibility(0);
                        if (i == 1) {
                            if (this.agj.getDrawable(1) != null) {
                                this.agj.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agj.getDrawable(1) != null) {
                            this.agj.getDrawable(1).setAlpha(0);
                        }
                        this.jCX.setBackgroundDrawable(this.agj);
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.jCX, (int) R.color.cp_cont_a);
                    } else if (aKC.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aKC.getBawu_type())) {
                        this.jCX.setText(R.string.bawu_member_xbazhu_tip);
                        this.jCX.setVisibility(0);
                        if (i == 1) {
                            if (this.agk.getDrawable(1) != null) {
                                this.agk.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agk.getDrawable(1) != null) {
                            this.agk.getDrawable(1).setAlpha(0);
                        }
                        this.jCX.setBackgroundDrawable(this.agk);
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.jCX, (int) R.color.cp_cont_a);
                    } else {
                        this.jCX.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.jDi.setText(aq.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.jDi.setText(aq.getFormatTime(postData.getTime()));
                    }
                    if (!eVar.cvQ()) {
                        this.jDj.setVisibility(8);
                        if (this.jDd.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.jDd.getLayoutParams()).rightMargin = 0;
                        }
                        this.jCU.setSpacingRight(0);
                        String str = null;
                        if (aKC.getBaijiahaoInfo() != null) {
                            str = aKC.getBaijiahaoInfo().auth_desc;
                        }
                        if (!StringUtils.isNull(str)) {
                            this.jDk.setVisibility(0);
                            this.jDk.setText(str);
                        } else {
                            this.jDk.setVisibility(8);
                        }
                    } else {
                        this.jDk.setVisibility(8);
                        if (this.jDd.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.jDd.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.jCU.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        f cWs = postData.cWs();
                        if (cWs != null && !TextUtils.isEmpty(cWs.getName()) && !TextUtils.isEmpty(cWs.getName().trim())) {
                            this.jDj.setVisibility(0);
                            this.jDj.setText(cWs.getName());
                        } else {
                            this.jDj.setVisibility(8);
                        }
                    }
                    if (eVar.cvs().aKC() != null || eVar.cvs().aKC().getAlaUserData() == null) {
                        z = false;
                    } else if (eVar.cvs().aKC().getAlaUserData().live_status != 1) {
                        z = false;
                    } else {
                        cBI();
                        z = true;
                    }
                    if (z) {
                        this.jCZ.a(aKC, 0);
                        this.jCZ.setIsclearmode(false);
                    } else {
                        this.jCZ.setIsclearmode(true);
                    }
                    this.jCZ.setVisibility(0);
                    if (this.jDe != null) {
                        this.jDe.setVisibility(8);
                    }
                    this.jCW.setOnClickListener(onClickListener);
                    this.jCZ.getHeadView().setUserId(aKC.getUserId());
                    this.jCZ.getHeadView().setUserName(aKC.getUserName());
                    this.jCZ.getHeadView().setTid(postData.getId());
                    this.jCZ.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.jCZ.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.jCZ.vk(aKC.getAvater());
                    } else {
                        this.jCZ.a(aKC);
                    }
                    String name_show = aKC.getName_show();
                    String userName = aKC.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.jCW.setText(com.baidu.tieba.pb.c.aJ(this.jpW.getPageContext().getPageActivity(), this.jCW.getText().toString()));
                        this.jCW.setGravity(16);
                        this.jCW.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cvb());
                        com.baidu.tbadk.core.util.am.setViewTextColor(this.jCW, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = aKC.getIconInfo();
                tShowInfoNew = aKC.getTShowInfoNew();
                if (this.jrT != null) {
                }
                if (this.jrS != null) {
                }
                this.jCW.setText(cL(aKC.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.jCW.setTag(R.id.tag_user_id, aKC.getUserId());
                this.jCW.setTag(R.id.tag_user_name, aKC.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jCW, R.color.cp_cont_h, 1);
                if (!eVar.cvQ()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!eVar.cvQ()) {
                }
                if (eVar.cvs().aKC() != null) {
                }
                z = false;
                if (z) {
                }
                this.jCZ.setVisibility(0);
                if (this.jDe != null) {
                }
                this.jCW.setOnClickListener(onClickListener);
                this.jCZ.getHeadView().setUserId(aKC.getUserId());
                this.jCZ.getHeadView().setUserName(aKC.getUserName());
                this.jCZ.getHeadView().setTid(postData.getId());
                this.jCZ.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.jCZ.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = aKC.getName_show();
                String userName2 = aKC.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.jCW.setText(com.baidu.tieba.pb.c.aJ(this.jpW.getPageContext().getPageActivity(), this.jCW.getText().toString()));
                    this.jCW.setGravity(16);
                    this.jCW.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cvb());
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.jCW, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = aKC.getIconInfo();
                    tShowInfoNew = aKC.getTShowInfoNew();
                    if (this.jrT != null) {
                    }
                    if (this.jrS != null) {
                    }
                    this.jCW.setText(cL(aKC.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.jCW.setTag(R.id.tag_user_id, aKC.getUserId());
                    this.jCW.setTag(R.id.tag_user_name, aKC.getName_show());
                    if (v.isEmpty(tShowInfoNew)) {
                    }
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.jCW, R.color.cp_cont_h, 1);
                    if (!eVar.cvQ()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!eVar.cvQ()) {
                    }
                    if (eVar.cvs().aKC() != null) {
                    }
                    z = false;
                    if (z) {
                    }
                    this.jCZ.setVisibility(0);
                    if (this.jDe != null) {
                    }
                    this.jCW.setOnClickListener(onClickListener);
                    this.jCZ.getHeadView().setUserId(aKC.getUserId());
                    this.jCZ.getHeadView().setUserName(aKC.getUserName());
                    this.jCZ.getHeadView().setTid(postData.getId());
                    this.jCZ.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.jCZ.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                    }
                    String name_show22 = aKC.getName_show();
                    String userName22 = aKC.getUserName();
                    if (NickNameActivitySwitch.isOn()) {
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo222 = aKC.getIconInfo();
                tShowInfoNew = aKC.getTShowInfoNew();
                if (this.jrT != null) {
                }
                if (this.jrS != null) {
                }
                this.jCW.setText(cL(aKC.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.jCW.setTag(R.id.tag_user_id, aKC.getUserId());
                this.jCW.setTag(R.id.tag_user_name, aKC.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jCW, R.color.cp_cont_h, 1);
                if (!eVar.cvQ()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!eVar.cvQ()) {
                }
                if (eVar.cvs().aKC() != null) {
                }
                z = false;
                if (z) {
                }
                this.jCZ.setVisibility(0);
                if (this.jDe != null) {
                }
                this.jCW.setOnClickListener(onClickListener);
                this.jCZ.getHeadView().setUserId(aKC.getUserId());
                this.jCZ.getHeadView().setUserName(aKC.getUserName());
                this.jCZ.getHeadView().setTid(postData.getId());
                this.jCZ.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.jCZ.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = aKC.getName_show();
                String userName222 = aKC.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (eVar != null) {
            this.jCT.aH(eVar.cvs());
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z) {
        if (eVar != null && postData != null) {
            if (3 != eVar.cvT()) {
                this.jDf.setVisibility(0);
            }
            if (z) {
                this.jDf.setVisibility(8);
                if (eVar != null && eVar.cvs() != null && eVar.cvs().getBaijiahaoData() != null && eVar.cvs().getBaijiahaoData().oriUgcType == 3) {
                    this.jDh.setVisibility(8);
                } else {
                    this.jDh.setVisibility(0);
                }
                this.jDh.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), aq.numberUniformFormatExtra(eVar.cvM())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aKC().hadConcerned()) {
                this.jDf.setVisibility(8);
                this.jDh.setVisibility(8);
            } else {
                this.jDh.setVisibility(8);
            }
            if (eVar.jnC || 3 == eVar.cvT()) {
                this.jDf.setVisibility(8);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z, boolean z2) {
        if (eVar != null && postData != null) {
            String threadId = eVar != null ? eVar.getThreadId() : "";
            int A = A(eVar);
            if (z && postData != null && postData.aKC() != null) {
                postData.aKC().setIsLike(postData.aKC().hadConcerned());
            }
            if (this.jDg == null) {
                bj cvs = eVar.cvs();
                int i = 1;
                if (cvs != null) {
                    if (cvs.aJr()) {
                        i = 4;
                    } else if (cvs.aJs()) {
                        i = 6;
                    } else if (cvs.aMx()) {
                        i = 7;
                    } else if (cvs.aMw()) {
                        i = 5;
                    }
                }
                this.jDg = new al(this.jpW.getPageContext(), this.jDf, i);
                this.jDg.j(this.jpW.getUniqueId());
            }
            if (postData != null && postData.aKC() != null) {
                postData.aKC().setIsLike(postData.aKC().hadConcerned());
                this.jDg.a(postData.aKC());
                this.jDg.setTid(threadId);
            }
            this.jDg.jzE = z2;
            this.jDg.zL(A);
        }
    }

    public int A(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cvs() == null) {
            return 0;
        }
        if (eVar.cvs().aLW()) {
            return (v.isEmpty(eVar.cvL()) && (eVar.cvr() == null || StringUtils.isNull(eVar.cvr().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        if (postData != null && eVar != null) {
            if (postData.aKX() != null) {
                this.jCV.setData(this.jpW.getPageContext(), eVar.cvu().get(0).aKX(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", eVar.getForum().getId(), eVar.getForum().getName(), eVar.cvs().getId(), this.jpW.aMs() ? "FRS" : null));
                this.jCU.setPadding(this.jCU.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.jCU.getPaddingRight(), this.jCU.getPaddingBottom());
                return;
            }
            this.jCV.setData(null, null, null);
        }
    }

    public void a(PostData postData, boolean z) {
        if (this.jpW.cwr()) {
            this.jDl = 0;
            if (postData != null && postData.aKC() != null) {
                this.jDl = postData.aKC().getLevel_id();
            }
            if (this.jDl > 0 && !z) {
                this.jCY.setVisibility(0);
                com.baidu.tbadk.core.util.am.setImageResource(this.jCY, BitmapHelper.getGradeResourceIdInEnterForum(this.jDl));
                return;
            }
            this.jCY.setVisibility(8);
            return;
        }
        this.jCY.setVisibility(8);
    }

    public void B(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.aQe()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.jCU.getPaddingBottom();
            if (eVar.cvQ()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.jCU.setPadding(this.jCU.getPaddingLeft(), dimens, this.jCU.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.jCU.getPaddingBottom();
        if (eVar != null && !eVar.cvs().aJp() && eVar.cvQ() && (!StringUtils.isNull(eVar.cvs().getTitle()) || eVar.cvs().aLj() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.jCU.setPadding(this.jCU.getPaddingLeft(), dimens2, this.jCU.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.jCU.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.jCR);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.jCR, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.jCR);
        }
    }

    public void setVisibility(int i) {
        this.jCU.setVisibility(i);
    }

    private void cBI() {
        if (this.jDa != null) {
            this.jDa.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jDa.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.jpW.cyi(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.jpW.cyi(), R.dimen.ds8);
            this.jDa.setLayoutParams(layoutParams);
            this.jDa.loop(true);
            this.jDa.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jDa.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.jnD) {
            this.jCS.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jCS.setVisibility(0);
        } else if (z && z2) {
            this.jCS.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jCS.setVisibility(0);
        } else if (z) {
            this.jCS.setImageResource(R.drawable.pic_pb_refined_n);
            this.jCS.setVisibility(0);
        } else if (z2) {
            this.jCS.setImageResource(R.drawable.pic_pb_stick_n);
            this.jCS.setVisibility(0);
        } else {
            this.jCS.setVisibility(8);
        }
    }

    private SpannableStringBuilder cL(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str));
            return com.baidu.tieba.card.l.a((Context) this.jpW.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> cBJ() {
        SparseArray<Object> sparseArray = (SparseArray) this.jCU.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.jCU.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView cwL() {
        return this.jCT.cwL();
    }

    public void qL(boolean z) {
        this.jCT.qL(z);
    }

    public void onChangeSkinType(int i) {
        if (this.jCY != null) {
            com.baidu.tbadk.core.util.am.setImageResource(this.jCY, BitmapHelper.getGradeResourceIdInEnterForum(this.jDl));
        }
        if (this.jDf != null) {
            this.jDf.onChangeSkinType(i);
        }
        if (this.jDj != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jDj, (int) R.color.cp_cont_d);
        }
        if (this.jDi != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jDi, (int) R.color.cp_cont_d);
        }
        if (this.jDh != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jDh, (int) R.color.cp_cont_d);
        }
        if (this.jDk != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jDk, (int) R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.jDa != null) {
                this.jDa.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.jDa != null) {
                this.jDa.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.jDa != null) {
            this.jDa.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.jCQ != null) {
            this.jCQ.ED();
        }
        if (this.jCU != null && this.jDe != null) {
            this.jCU.removeView(this.jDb);
            this.jDe = null;
        }
        if (this.jDa != null) {
            this.jDa.cancelAnimation();
        }
    }

    public void cAY() {
        if (this.jCQ != null) {
            this.jCQ.ED();
        }
    }
}
