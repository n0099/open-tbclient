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
    private View.OnClickListener hpF;
    private PbFragment jHL;
    private UserIconBox jJT;
    private UserIconBox jJU;
    private ThreadSkinView jVA;
    private ImageView jVD;
    private HeadPendantView jVE;
    private TBLottieAnimationView jVF;
    private LinearLayout jVH;
    private LinearLayout jVI;
    private at jVL;
    private com.baidu.tieba.c.d jVv;
    private ImageView jVx;
    private f jVy;
    private View.OnLongClickListener mOnLongClickListener = null;
    private RelativeLayout jVw = null;
    private ColumnLayout jVz = null;
    private TextView jVB = null;
    private TextView jVC = null;
    private FrameLayout jVG = null;
    private ClickableHeaderImageView jVJ = null;
    private PbFirstFloorUserLikeButton jVK = null;
    private TextView jVM = null;
    private TextView jVN = null;
    private TextView jVO = null;
    private TextView jVP = null;
    private int jVQ = 0;

    public d(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar, View.OnClickListener onClickListener) {
        this.hpF = null;
        this.jHL = pbFragment;
        this.efF = cVar;
        this.hpF = onClickListener;
        int dimens = l.getDimens(this.jHL.getContext(), R.dimen.tbds6);
        this.agG = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aVA().lp(0).O(dimens).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aVC(), com.baidu.tbadk.core.util.e.a.c.aVA().lp(0).O(dimens).wJ("#4D000000").aVC()});
        this.agH = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aVA().lp(0).O(dimens).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aVC(), com.baidu.tbadk.core.util.e.a.c.aVA().lp(0).O(dimens).wJ("#4D000000").aVC()});
        initView();
    }

    private void initView() {
        this.jVw = (RelativeLayout) LayoutInflater.from(this.jHL.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
        this.jVx = (ImageView) this.jVw.findViewById(R.id.pb_thread_type_stamp_top_part);
        this.jVx.getLayoutParams().height = au.cHo();
        this.jVy = new f(this.jHL.getBaseFragmentActivity(), this.jVw);
        this.jVy.init();
        this.jVy.a(this.jVy.cDY(), this.hpF);
        this.jVz = (ColumnLayout) this.jVw.findViewById(R.id.pb_head_owner_root);
        this.jVA = (ThreadSkinView) this.jVw.findViewById(R.id.pb_thread_skin);
        this.jVB = (TextView) this.jVz.findViewById(R.id.pb_head_owner_info_user_name);
        this.jVC = (TextView) this.jVz.findViewById(R.id.floor_owner);
        this.jVD = (ImageView) this.jVz.findViewById(R.id.icon_forum_level);
        this.jVG = (FrameLayout) this.jVz.findViewById(R.id.pb_head_headImage_container);
        this.jVE = (HeadPendantView) this.jVz.findViewById(R.id.pb_pendant_head_owner_photo);
        this.jVE.setHasPendantStyle();
        this.jVF = (TBLottieAnimationView) this.jVz.findViewById(R.id.pb_head_living_lottie);
        this.jVz.setOnLongClickListener(this.mOnLongClickListener);
        this.jVz.setOnTouchListener(this.efF);
        this.jVz.setVisibility(8);
        if (this.jVE.getHeadView() != null) {
            this.jVE.getHeadView().setIsRound(true);
            this.jVE.getHeadView().setDrawBorder(false);
            this.jVE.getHeadView().setPlaceHolder(1);
        }
        this.jJT = (UserIconBox) this.jVz.findViewById(R.id.show_icon_vip);
        this.jJU = (UserIconBox) this.jVz.findViewById(R.id.show_icon_yinji);
        this.jVH = (LinearLayout) this.jVw.findViewById(R.id.pb_head_owner_info_root);
        this.jVI = (LinearLayout) this.jVz.findViewById(R.id.pb_first_floor_location_container);
        this.jVK = (PbFirstFloorUserLikeButton) this.jVz.findViewById(R.id.pb_like_button);
        this.jVM = (TextView) this.jVz.findViewById(R.id.pb_views);
        this.jVN = (TextView) this.jVz.findViewById(R.id.pb_item_first_floor_reply_time);
        this.jVO = (TextView) this.jVz.findViewById(R.id.pb_item_first_floor_location_address);
        this.jVP = (TextView) this.jVz.findViewById(R.id.pb_item_first_floor_bjh_desc);
    }

    public View cIU() {
        return this.jVw;
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
                    if (this.jJU != null) {
                        this.jJU.setTag(R.id.tag_user_id, aQx.getUserId());
                        if (this.jHL.cFs() != null) {
                            this.jJU.setOnClickListener(this.jHL.cFs().jHX.jXj);
                        }
                        this.jJU.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
                    }
                    if (this.jJT != null) {
                        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                            this.jJT.setTag(tShowInfoNew.get(0).getUrl());
                        }
                        if (this.jHL.cFs() != null) {
                            this.jJT.setOnClickListener(this.jHL.cFs().jHX.jXk);
                        }
                        this.jJT.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    }
                    this.jVB.setText(dk(aQx.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.jVB.setTag(R.id.tag_user_id, aQx.getUserId());
                    this.jVB.setTag(R.id.tag_user_name, aQx.getName_show());
                    if (v.isEmpty(tShowInfoNew) || aQx.isBigV()) {
                        am.setViewTextColor(this.jVB, R.color.cp_cont_h, 1);
                    } else {
                        am.setViewTextColor(this.jVB, R.color.cp_cont_b, 1);
                    }
                    if (!eVar.cCZ()) {
                        this.jVC.setVisibility(8);
                    } else if (aQx.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aQx.getBawu_type())) {
                        this.jVC.setText(R.string.bawu_member_bazhu_tip);
                        this.jVC.setVisibility(0);
                        if (i == 1) {
                            if (this.agG.getDrawable(1) != null) {
                                this.agG.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agG.getDrawable(1) != null) {
                            this.agG.getDrawable(1).setAlpha(0);
                        }
                        this.jVC.setBackgroundDrawable(this.agG);
                        am.setViewTextColor(this.jVC, (int) R.color.cp_cont_a);
                    } else if (aQx.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aQx.getBawu_type())) {
                        this.jVC.setText(R.string.bawu_member_xbazhu_tip);
                        this.jVC.setVisibility(0);
                        if (i == 1) {
                            if (this.agH.getDrawable(1) != null) {
                                this.agH.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.agH.getDrawable(1) != null) {
                            this.agH.getDrawable(1).setAlpha(0);
                        }
                        this.jVC.setBackgroundDrawable(this.agH);
                        am.setViewTextColor(this.jVC, (int) R.color.cp_cont_a);
                    } else {
                        this.jVC.setVisibility(8);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                        this.jVN.setText(aq.getFormatTimeShort(postData.getTime()));
                    } else {
                        this.jVN.setText(aq.getFormatTime(postData.getTime()));
                    }
                    if (!eVar.cCZ()) {
                        this.jVO.setVisibility(8);
                        if (this.jVI.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.jVI.getLayoutParams()).rightMargin = 0;
                        }
                        this.jVz.setSpacingRight(0);
                        String str = null;
                        if (aQx.getBaijiahaoInfo() != null) {
                            str = aQx.getBaijiahaoInfo().auth_desc;
                        }
                        if (!StringUtils.isNull(str)) {
                            this.jVP.setVisibility(0);
                            this.jVP.setText(str);
                        } else {
                            this.jVP.setVisibility(8);
                        }
                    } else {
                        this.jVP.setVisibility(8);
                        if (this.jVI.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                            ((ColumnLayout.LayoutParams) this.jVI.getLayoutParams()).rightMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                        }
                        this.jVz.setSpacingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                        com.baidu.tbadk.data.f ddM = postData.ddM();
                        if (ddM != null && !TextUtils.isEmpty(ddM.getName()) && !TextUtils.isEmpty(ddM.getName().trim())) {
                            this.jVO.setVisibility(0);
                            this.jVO.setText(ddM.getName());
                        } else {
                            this.jVO.setVisibility(8);
                        }
                    }
                    if (eVar.cCy().aQx() != null || eVar.cCy().aQx().getAlaInfo() == null) {
                        z = false;
                    } else if (eVar.cCy().aQx().getAlaInfo().live_status != 1) {
                        z = false;
                    } else {
                        cIV();
                        z = true;
                    }
                    if (z) {
                        this.jVE.a(aQx, 4);
                        this.jVE.setIsclearmode(false);
                    } else {
                        this.jVE.setIsclearmode(true);
                    }
                    this.jVE.setVisibility(0);
                    if (this.jVJ != null) {
                        this.jVJ.setVisibility(8);
                    }
                    this.jVB.setOnClickListener(onClickListener);
                    this.jVE.getHeadView().setUserId(aQx.getUserId());
                    this.jVE.getHeadView().setUserName(aQx.getUserName());
                    this.jVE.getHeadView().setTid(postData.getId());
                    this.jVE.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.jVE.getHeadView().setFName(eVar.getForumName());
                    this.jVE.getHeadView().setOnClickListener(onClickListener);
                    if (!z) {
                        this.jVE.wQ(aQx.getAvater());
                    } else {
                        this.jVE.a(aQx);
                    }
                    String name_show = aQx.getName_show();
                    String userName = aQx.getUserName();
                    if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                        this.jVB.setText(com.baidu.tieba.pb.c.aK(this.jHL.getPageContext().getPageActivity(), this.jVB.getText().toString()));
                        this.jVB.setGravity(16);
                        this.jVB.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cCh());
                        am.setViewTextColor(this.jVB, R.color.cp_other_f, 1);
                    }
                }
                cutChineseAndEnglishWithSuffix = string;
                ArrayList<IconData> iconInfo2 = aQx.getIconInfo();
                tShowInfoNew = aQx.getTShowInfoNew();
                if (this.jJU != null) {
                }
                if (this.jJT != null) {
                }
                this.jVB.setText(dk(aQx.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.jVB.setTag(R.id.tag_user_id, aQx.getUserId());
                this.jVB.setTag(R.id.tag_user_name, aQx.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                am.setViewTextColor(this.jVB, R.color.cp_cont_h, 1);
                if (!eVar.cCZ()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!eVar.cCZ()) {
                }
                if (eVar.cCy().aQx() != null) {
                }
                z = false;
                if (z) {
                }
                this.jVE.setVisibility(0);
                if (this.jVJ != null) {
                }
                this.jVB.setOnClickListener(onClickListener);
                this.jVE.getHeadView().setUserId(aQx.getUserId());
                this.jVE.getHeadView().setUserName(aQx.getUserName());
                this.jVE.getHeadView().setTid(postData.getId());
                this.jVE.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.jVE.getHeadView().setFName(eVar.getForumName());
                this.jVE.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show2 = aQx.getName_show();
                String userName2 = aQx.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                    this.jVB.setText(com.baidu.tieba.pb.c.aK(this.jHL.getPageContext().getPageActivity(), this.jVB.getText().toString()));
                    this.jVB.setGravity(16);
                    this.jVB.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cCh());
                    am.setViewTextColor(this.jVB, R.color.cp_other_f, 1);
                }
            } else {
                if (k.byteLength(string) > 14) {
                    cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    ArrayList<IconData> iconInfo22 = aQx.getIconInfo();
                    tShowInfoNew = aQx.getTShowInfoNew();
                    if (this.jJU != null) {
                    }
                    if (this.jJT != null) {
                    }
                    this.jVB.setText(dk(aQx.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                    this.jVB.setTag(R.id.tag_user_id, aQx.getUserId());
                    this.jVB.setTag(R.id.tag_user_name, aQx.getName_show());
                    if (v.isEmpty(tShowInfoNew)) {
                    }
                    am.setViewTextColor(this.jVB, R.color.cp_cont_h, 1);
                    if (!eVar.cCZ()) {
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                    }
                    if (!eVar.cCZ()) {
                    }
                    if (eVar.cCy().aQx() != null) {
                    }
                    z = false;
                    if (z) {
                    }
                    this.jVE.setVisibility(0);
                    if (this.jVJ != null) {
                    }
                    this.jVB.setOnClickListener(onClickListener);
                    this.jVE.getHeadView().setUserId(aQx.getUserId());
                    this.jVE.getHeadView().setUserName(aQx.getUserName());
                    this.jVE.getHeadView().setTid(postData.getId());
                    this.jVE.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                    this.jVE.getHeadView().setFName(eVar.getForumName());
                    this.jVE.getHeadView().setOnClickListener(onClickListener);
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
                if (this.jJU != null) {
                }
                if (this.jJT != null) {
                }
                this.jVB.setText(dk(aQx.getSealPrefix(), cutChineseAndEnglishWithSuffix));
                this.jVB.setTag(R.id.tag_user_id, aQx.getUserId());
                this.jVB.setTag(R.id.tag_user_name, aQx.getName_show());
                if (v.isEmpty(tShowInfoNew)) {
                }
                am.setViewTextColor(this.jVB, R.color.cp_cont_h, 1);
                if (!eVar.cCZ()) {
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                }
                if (!eVar.cCZ()) {
                }
                if (eVar.cCy().aQx() != null) {
                }
                z = false;
                if (z) {
                }
                this.jVE.setVisibility(0);
                if (this.jVJ != null) {
                }
                this.jVB.setOnClickListener(onClickListener);
                this.jVE.getHeadView().setUserId(aQx.getUserId());
                this.jVE.getHeadView().setUserName(aQx.getUserName());
                this.jVE.getHeadView().setTid(postData.getId());
                this.jVE.getHeadView().setFid(eVar == null ? eVar.getForumId() : "");
                this.jVE.getHeadView().setFName(eVar.getForumName());
                this.jVE.getHeadView().setOnClickListener(onClickListener);
                if (!z) {
                }
                String name_show222 = aQx.getName_show();
                String userName222 = aQx.getUserName();
                if (NickNameActivitySwitch.isOn()) {
                }
            }
        }
        if (eVar != null) {
            this.jVy.aH(eVar.cCy());
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, PostData postData, boolean z) {
        if (eVar != null && postData != null) {
            if (3 != eVar.cDc()) {
                this.jVK.setVisibility(0);
            }
            if (z) {
                this.jVK.setVisibility(8);
                if (eVar != null && eVar.cCy() != null && eVar.cCy().getBaijiahaoData() != null && eVar.cCy().getBaijiahaoData().oriUgcType == 3) {
                    this.jVM.setVisibility(8);
                } else {
                    this.jVM.setVisibility(0);
                }
                this.jVM.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), aq.numberUniformFormatExtra(eVar.cCV())));
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aQx().hadConcerned()) {
                this.jVK.setVisibility(8);
                this.jVM.setVisibility(8);
            } else {
                this.jVM.setVisibility(8);
            }
            if (eVar.jFe || 3 == eVar.cDc()) {
                this.jVK.setVisibility(8);
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
            if (this.jVL == null) {
                bk cCy = eVar.cCy();
                int i = 1;
                if (cCy != null) {
                    if (cCy.aPm()) {
                        i = 4;
                    } else if (cCy.aPn()) {
                        i = 6;
                    } else if (cCy.aSw()) {
                        i = 7;
                    } else if (cCy.aSv()) {
                        i = 5;
                    }
                }
                this.jVL = new at(this.jHL.getPageContext(), this.jVK, i);
                this.jVL.l(this.jHL.getUniqueId());
                this.jVL.setThreadData(cCy);
            }
            if (postData != null && postData.aQx() != null) {
                postData.aQx().setIsLike(postData.aQx().hadConcerned());
                this.jVL.a(postData.aQx());
                this.jVL.setTid(threadId);
            }
            this.jVL.jSd = z2;
            this.jVL.Ay(q);
        }
    }

    public void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        if (postData != null && eVar != null) {
            if (postData.aQU() != null) {
                this.jVA.setData(this.jHL.getPageContext(), eVar.cCA().get(0).aQU(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", eVar.getForum().getId(), eVar.getForum().getName(), eVar.cCy().getId(), this.jHL.aSr() ? "FRS" : null));
                this.jVz.setPadding(this.jVz.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.jVz.getPaddingRight(), this.jVz.getPaddingBottom());
                return;
            }
            this.jVA.setData(null, null, null);
        }
    }

    public void a(PostData postData, boolean z) {
        if (this.jHL.cDE()) {
            this.jVQ = 0;
            if (postData != null && postData.aQx() != null) {
                this.jVQ = postData.aQx().getLevel_id();
            }
            if (this.jVQ > 0 && !z) {
                this.jVD.setVisibility(0);
                am.setImageResource(this.jVD, BitmapHelper.getGradeResourceIdInEnterForum(this.jVQ));
                return;
            }
            this.jVD.setVisibility(8);
            return;
        }
        this.jVD.setVisibility(8);
    }

    public void D(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.aWj()) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds45);
            int paddingBottom = this.jVz.getPaddingBottom();
            if (eVar.cCZ()) {
                dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                paddingBottom = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
            }
            this.jVz.setPadding(this.jVz.getPaddingLeft(), dimens, this.jVz.getPaddingRight(), paddingBottom);
            return;
        }
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds48);
        int paddingBottom2 = this.jVz.getPaddingBottom();
        if (eVar != null && !eVar.cCy().aPk() && eVar.cCZ() && (!StringUtils.isNull(eVar.cCy().getTitle()) || eVar.cCy().aRi() != null)) {
            dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
        }
        this.jVz.setPadding(this.jVz.getPaddingLeft(), dimens2, this.jVz.getPaddingRight(), paddingBottom2);
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        this.jVz.setOnLongClickListener(onLongClickListener);
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.jVw);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.jVw, i);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.jVw);
        }
    }

    public void setVisibility(int i) {
        this.jVz.setVisibility(i);
    }

    private void cIV() {
        if (this.jVF != null) {
            this.jVF.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jVF.getLayoutParams();
            layoutParams.topMargin = -l.getDimens(this.jHL.cFs(), R.dimen.ds15);
            layoutParams.leftMargin = -l.getDimens(this.jHL.cFs(), R.dimen.ds8);
            this.jVF.setLayoutParams(layoutParams);
            this.jVF.loop(true);
            this.jVF.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jVF.playAnimation();
                }
            });
        }
    }

    public void d(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.jFf) {
            this.jVx.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jVx.setVisibility(0);
        } else if (z && z2) {
            this.jVx.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jVx.setVisibility(0);
        } else if (z) {
            this.jVx.setImageResource(R.drawable.pic_pb_refined_n);
            this.jVx.setVisibility(0);
        } else if (z2) {
            this.jVx.setImageResource(R.drawable.pic_pb_stick_n);
            this.jVx.setVisibility(0);
        } else {
            this.jVx.setVisibility(8);
        }
    }

    private SpannableStringBuilder dk(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str));
            return m.a((Context) this.jHL.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public SparseArray<Object> cIW() {
        SparseArray<Object> sparseArray = (SparseArray) this.jVz.getTag();
        if (sparseArray == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            this.jVz.setTag(sparseArray2);
            return sparseArray2;
        }
        return sparseArray;
    }

    public TextView cDY() {
        return this.jVy.cDY();
    }

    public void rj(boolean z) {
        this.jVy.rj(z);
    }

    public void onChangeSkinType(int i) {
        if (this.jVD != null) {
            am.setImageResource(this.jVD, BitmapHelper.getGradeResourceIdInEnterForum(this.jVQ));
        }
        if (this.jVK != null) {
            this.jVK.onChangeSkinType(i);
        }
        if (this.jVO != null) {
            am.setViewTextColor(this.jVO, (int) R.color.cp_cont_d);
        }
        if (this.jVN != null) {
            am.setViewTextColor(this.jVN, (int) R.color.cp_cont_d);
        }
        if (this.jVM != null) {
            am.setViewTextColor(this.jVM, (int) R.color.cp_cont_d);
        }
        if (this.jVP != null) {
            am.setViewTextColor(this.jVP, (int) R.color.cp_cont_d);
        }
        if (i == 4) {
            if (this.jVF != null) {
                this.jVF.setAnimation("live/card_live_bg_black.json");
            }
        } else if (i == 1) {
            if (this.jVF != null) {
                this.jVF.setAnimation("live/card_live_bg_night.json");
            }
        } else if (this.jVF != null) {
            this.jVF.setAnimation("live/card_live_bg.json");
        }
    }

    public void onDestroy() {
        if (this.jVv != null) {
            this.jVv.Gu();
        }
        if (this.jVz != null && this.jVJ != null) {
            this.jVz.removeView(this.jVG);
            this.jVJ = null;
        }
        if (this.jVF != null) {
            this.jVF.cancelAnimation();
        }
    }

    public void cIk() {
        if (this.jVv != null) {
            this.jVv.Gu();
        }
    }
}
