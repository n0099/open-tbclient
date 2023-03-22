package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.WorldCupEnableSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.mj8;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.xe6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class zk8 extends bl8<bc9, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mj8 A;
    public boolean B;
    public TbRichTextView.u g;
    public boolean h;
    public float i;
    public String j;
    public ki8 k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public TbRichTextView.a0 n;
    public mj8 o;
    public View.OnLongClickListener p;
    public vo8 q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public String x;
    public xf<ConstrainImageLayout> y;
    public xf<TbImageView> z;

    /* JADX WARN: Removed duplicated region for block: B:275:0x07db  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x07ef  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0832  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x083c  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x08a2  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x08ac  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x08eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, View view2, int i2) {
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048608, this, pbCommenFloorItemViewHolder, bc9Var, view2, i2) == null) || pbCommenFloorItemViewHolder == null || bc9Var == null) {
            return;
        }
        if (bc9Var.r() != null) {
            bc9Var.r().isBaijiahaoUser();
        }
        if (bc9Var.R) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.e.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.e.setVisibility(8);
        }
        pbCommenFloorItemViewHolder.p.setTag(null);
        pbCommenFloorItemViewHolder.p.setUserId(null);
        pbCommenFloorItemViewHolder.L.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.q.setIsHost(false);
        if (bc9Var.r() != null) {
            String str = this.j;
            if (str != null && !str.equals("0") && this.j.equals(bc9Var.r().getUserId())) {
                pbCommenFloorItemViewHolder.q.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = bc9Var.r().getIconInfo();
            ArrayList<IconData> tShowInfoNew = bc9Var.r().getTShowInfoNew();
            int g2 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            int g3 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (iconInfo.size() < 2) {
                i3 = iconInfo.size();
                if (i3 > 1) {
                    bc9Var.k1((g2 * i3) + (g3 * i3));
                } else if (i3 == 1) {
                    bc9Var.k1(g2 + g3);
                } else {
                    bc9Var.k1(0);
                }
            } else {
                bc9Var.k1((g2 * 2) + (g3 * 2));
                i3 = 2;
            }
            if (pbCommenFloorItemViewHolder.M != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.M.setTag(tShowInfoNew.get(0).getUrl());
                }
                wp8 wp8Var = this.a;
                if (wp8Var != null && wp8Var.M() != null) {
                    pbCommenFloorItemViewHolder.M.setOnClickListener(this.a.M().d.e);
                }
                int g4 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.M.i(tShowInfoNew, 3, g4, g4, hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !bc9Var.r().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        mm8.F(pbCommenFloorItemViewHolder.g);
                    } else {
                        n15.d(pbCommenFloorItemViewHolder.g).B(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
            }
            String avater = bc9Var.r().getAvater();
            int i4 = bc9Var.c0 ? 2 : 8;
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_id, bc9Var.r().getUserId());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, bc9Var.r().getUserName());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, bc9Var.r().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, mp8.i(this.k, bc9Var, bc9Var.d0, i4, 2));
            String name_show = bc9Var.r().getName_show();
            String userName = bc9Var.r().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.h.setText(kh8.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                pbCommenFloorItemViewHolder.g.setGravity(16);
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, kh8.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
            }
            if (bc9Var.r().getPendantData() != null && !StringUtils.isNull(bc9Var.r().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.L.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.L.i(bc9Var.r());
                pbCommenFloorItemViewHolder.p.setVisibility(8);
                pbCommenFloorItemViewHolder.L.setVisibility(0);
                pbCommenFloorItemViewHolder.L.getHeadView().M(avater, 28, false);
                pbCommenFloorItemViewHolder.L.getHeadView().setUserId(bc9Var.r().getUserId());
                pbCommenFloorItemViewHolder.L.getHeadView().setUserName(bc9Var.r().getUserName());
                ki8 ki8Var = this.k;
                pbCommenFloorItemViewHolder.L.getHeadView().setFid(ki8Var != null ? ki8Var.m() : "");
                ki8 ki8Var2 = this.k;
                pbCommenFloorItemViewHolder.L.getHeadView().setFName(ki8Var2 != null ? ki8Var2.n() : "");
                pbCommenFloorItemViewHolder.L.getHeadView().setFloor(bc9Var.E());
                pbCommenFloorItemViewHolder.L.getHeadView().setTid(bc9Var.O());
                pbCommenFloorItemViewHolder.L.getHeadView().setTag(R.id.tag_statistic_item, mp8.i(this.k, bc9Var, bc9Var.d0, i4, 2));
                pbCommenFloorItemViewHolder.L.i(bc9Var.r());
            } else {
                pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, bc9Var.r(), 4);
                pbCommenFloorItemViewHolder.p.setUserId(bc9Var.r().getUserId());
                ki8 ki8Var3 = this.k;
                pbCommenFloorItemViewHolder.p.setFid(ki8Var3 != null ? ki8Var3.m() : "");
                ki8 ki8Var4 = this.k;
                pbCommenFloorItemViewHolder.p.setFName(ki8Var4 != null ? ki8Var4.n() : "");
                pbCommenFloorItemViewHolder.p.setFloor(bc9Var.E());
                pbCommenFloorItemViewHolder.p.setTid(bc9Var.O());
                pbCommenFloorItemViewHolder.p.setUserName(bc9Var.r().getUserName(), bc9Var.m0());
                pbCommenFloorItemViewHolder.p.setTag(R.id.tag_virtual_user_url, bc9Var.r().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.p.setTag(R.id.tag_statistic_item, mp8.i(this.k, bc9Var, bc9Var.d0, i4, 2));
                pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                pbCommenFloorItemViewHolder.p.M(avater, 28, false);
                pbCommenFloorItemViewHolder.p.setVisibility(0);
                pbCommenFloorItemViewHolder.L.setVisibility(8);
            }
            if (bc9Var.r() != null && bc9Var.r().getAlaInfo() != null && bc9Var.r().getAlaUserData() != null && bc9Var.r().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.d(true);
                pbCommenFloorItemViewHolder.p.setLiveStatus(1);
                pbCommenFloorItemViewHolder.p.setAlaInfo(bc9Var.r().getAlaInfo());
                pbCommenFloorItemViewHolder.L.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.L.getHeadView().setAlaInfo(bc9Var.r().getAlaInfo());
            } else {
                pbCommenFloorItemViewHolder.d(false);
                pbCommenFloorItemViewHolder.p.setLiveStatus(0);
                pbCommenFloorItemViewHolder.p.setAlaInfo(null);
                pbCommenFloorItemViewHolder.L.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.L.getHeadView().setAlaInfo(null);
            }
            F0(pbCommenFloorItemViewHolder.i, bc9Var);
            if (TbSingleton.getInstance().isUserGrowthOpen() && bc9Var.r().getUserGrowthData() != null) {
                int a2 = bc9Var.r().getUserGrowthData().a();
                if (a2 >= 0 && a2 <= 10) {
                    pbCommenFloorItemViewHolder.j.setImageResource(sw.b(a2));
                    pbCommenFloorItemViewHolder.j.setVisibility(0);
                    pbCommenFloorItemViewHolder.j.setOnClickListener(new n(this, a2));
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 4, a2);
                } else {
                    pbCommenFloorItemViewHolder.j.setVisibility(8);
                }
            }
        } else {
            i3 = 2;
        }
        wp8 wp8Var2 = this.a;
        int level_id = (wp8Var2 == null || wp8Var2.M() == null || !this.a.M().x0() || bc9Var.r() == null) ? 0 : bc9Var.r().getLevel_id();
        ki8 ki8Var5 = this.k;
        if (ki8Var5 != null && ki8Var5.l0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.K.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.K, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.K.setVisibility(8);
        }
        int i5 = 15;
        if (i3 == 1) {
            i5 = 13;
        } else if (i3 > 1) {
            i5 = 11;
        }
        if (pbCommenFloorItemViewHolder.i.getVisibility() == 0) {
            i5 -= 2;
        }
        if (pbCommenFloorItemViewHolder.M.getChildCount() > 0) {
            i5 -= 2;
        }
        if (bc9Var.w() > 1000) {
            i5 -= 2;
        }
        if (bc9Var.w() > 10) {
            i5 -= 2;
        }
        if (i5 < 10) {
            if (i3 == 1) {
                i5 += 2;
            } else if (i3 > 1) {
                i5 += 4;
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.i.getVisibility() == 0) {
                i5 += 2;
                pbCommenFloorItemViewHolder.i.setVisibility(8);
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.K.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.K.setVisibility(8);
            }
        }
        int m2 = mm8.m();
        String[] strArr = new String[1];
        strArr[0] = (bc9Var.r() == null || bc9Var.r().getName_show() == null) ? "" : bc9Var.r().getName_show();
        int f2 = dq5.f(strArr[0]);
        if (bc9Var.r() != null && !StringUtils.isNull(bc9Var.r().getSealPrefix())) {
            int i6 = m2 - 2;
            if (f2 > i6) {
                strArr[0] = dq5.n(strArr[0], i6);
                strArr[0] = strArr[0] + StringHelper.STRING_MORE;
            }
        } else if (f2 > m2) {
            strArr[0] = dq5.n(strArr[0], m2);
            strArr[0] = strArr[0] + StringHelper.STRING_MORE;
        }
        if (bc9Var.r() != null && !StringUtils.isNull(bc9Var.r().getSealPrefix())) {
            pbCommenFloorItemViewHolder.h.setText(m0(bc9Var.r().getSealPrefix(), strArr[0]));
        } else {
            pbCommenFloorItemViewHolder.h.setText(strArr[0]);
        }
        if (((bc9) getItem(i2)).R() == 1 && this.k.Q() != null && this.k.Q().isQuestionThread() && !T(bc9Var)) {
            ((bc9) getItem(i2)).O0(true);
            pbCommenFloorItemViewHolder.D0.setVisibility(0);
            if (((bc9) getItem(i2)).Q().booleanValue()) {
                pbCommenFloorItemViewHolder.E0.setVisibility(0);
                pbCommenFloorItemViewHolder.j0.setVisibility(8);
                pbCommenFloorItemViewHolder.k0.setVisibility(8);
                pbCommenFloorItemViewHolder.E0.postDelayed(new o(this, pbCommenFloorItemViewHolder), 3000L);
            } else {
                pbCommenFloorItemViewHolder.E0.setVisibility(8);
                pbCommenFloorItemViewHolder.j0.setVisibility(0);
                pbCommenFloorItemViewHolder.k0.setVisibility(0);
            }
        } else {
            ((bc9) getItem(i2)).O0(false);
            pbCommenFloorItemViewHolder.D0.setVisibility(8);
            pbCommenFloorItemViewHolder.E0.setVisibility(8);
            pbCommenFloorItemViewHolder.j0.setVisibility(0);
            pbCommenFloorItemViewHolder.k0.setVisibility(0);
        }
        SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.D0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.C0, R.color.CAM_X0105, 1);
        pbCommenFloorItemViewHolder.f.post(new p(this, pbCommenFloorItemViewHolder, bc9Var, new String[]{strArr[0]}, 2));
        if (!StringUtils.isNull(bc9Var.r().getDiplayIntro())) {
            pbCommenFloorItemViewHolder.F0.setVisibility(0);
            pbCommenFloorItemViewHolder.F0.setText(bc9Var.r().getDiplayIntro() + "");
        } else {
            pbCommenFloorItemViewHolder.F0.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, bc9Var);
        sparseArray.put(R.id.tag_load_sub_data, bc9Var);
        sparseArray.put(R.id.tag_load_sub_view, view2);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(bc9Var.E()));
        sparseArray.put(R.id.tag_forbid_user_post_id, bc9Var.O());
        sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.o);
        sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.j0);
        sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.y);
        sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.z);
        ki8 ki8Var6 = this.k;
        ThreadData Q = (ki8Var6 == null || ki8Var6.Q() == null) ? null : this.k.Q();
        if (Q != null && Q.isUgcThreadType()) {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z8 = (bc9Var.r() == null || StringUtils.isNull(bc9Var.r().getVirtualUserUrl())) ? false : true;
        ki8 ki8Var7 = this.k;
        if (ki8Var7 == null || ki8Var7.Y() == 0 || o0()) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            z = (this.k.Y() == 1002 || this.k.Y() == 3) ? false : true;
            if (this.k.Y() == 3 || this.k.l0()) {
                z2 = false;
                z3 = false;
            } else {
                z2 = true;
                z3 = true;
            }
            if (bc9Var != null && bc9Var.r() != null) {
                String userId = bc9Var.r().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        ki8 ki8Var8 = this.k;
        if (ki8Var8 != null && ki8Var8.Q() != null && this.k.Q().getAuthor() != null && bc9Var.r() != null) {
            String userId2 = this.k.Q().getAuthor().getUserId();
            String userId3 = bc9Var.r().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z5 = false;
                    z4 = true;
                    z6 = true;
                } else {
                    z5 = true;
                    z4 = true;
                    z6 = false;
                }
                z7 = true;
                if (bc9Var != null && bc9Var.r() != null && UtilHelper.isCurrentAccount(bc9Var.r().getUserId())) {
                    z4 = true;
                    z6 = true;
                }
                if (z8) {
                    z = false;
                    z5 = false;
                    z4 = false;
                }
                int i7 = bc9Var.E() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.Y()));
                    if (bc9Var.r() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, bc9Var.r().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, bc9Var.r().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, bc9Var.r().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (bc9Var.r() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, bc9Var.r().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, bc9Var.r().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, bc9Var.r().getName_show());
                    }
                    if (this.k.Q() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.k.Q().getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, bc9Var.O());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(bc9Var.t0()));
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.Y()));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i7));
                    sparseArray.put(R.id.tag_del_post_id, bc9Var.O());
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
                pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            }
        }
        z4 = z2;
        z5 = false;
        z6 = false;
        z7 = false;
        if (bc9Var != null) {
            z4 = true;
            z6 = true;
        }
        if (z8) {
        }
        if (bc9Var.E() != 1) {
        }
        if (!z) {
        }
        if (!z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z3));
        sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
        pbCommenFloorItemViewHolder.q.setTag(sparseArray);
        pbCommenFloorItemViewHolder.s.setTag(sparseArray);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ zk8 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            /* renamed from: com.baidu.tieba.zk8$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class View$OnClickListenerC0498a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0498a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                        mp8.t("c14886");
                        f fVar = this.a.a;
                        if (fVar.c.getItem(fVar.a) instanceof bc9) {
                            f fVar2 = this.a.a;
                            zk8 zk8Var = fVar2.c;
                            zk8Var.p0(((bc9) zk8Var.getItem(fVar2.a)).r());
                        }
                    }
                }
            }

            /* loaded from: classes7.dex */
            public class b implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public b(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        f fVar = this.a.a;
                        if (fVar.c.getItem(fVar.a) instanceof bc9) {
                            f fVar2 = this.a.a;
                            bc9 bc9Var = (bc9) fVar2.c.getItem(fVar2.a);
                            bc9Var.D0();
                            if (bc9Var.Y() <= 0) {
                                bc9Var.U0(Boolean.FALSE);
                                this.a.a.b.E0.setVisibility(8);
                                this.a.a.b.j0.setVisibility(0);
                                this.a.a.b.k0.setVisibility(0);
                            }
                        }
                    }
                }
            }

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.b.j0.getAgreeFlag()) {
                    return;
                }
                f fVar = this.a;
                ((bc9) fVar.c.getItem(fVar.a)).C0();
                f fVar2 = this.a;
                ((bc9) fVar2.c.getItem(fVar2.a)).U0(Boolean.TRUE);
                this.a.b.j0.setVisibility(8);
                this.a.b.k0.setVisibility(8);
                this.a.b.E0.setVisibility(0);
                this.a.b.E0.setOnClickListener(new View$OnClickListenerC0498a(this));
                this.a.b.E0.postDelayed(new b(this), 5000L);
            }
        }

        public f(zk8 zk8Var, int i, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, Integer.valueOf(i), pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zk8Var;
            this.a = i;
            this.b = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !UtilHelper.isCurrentAccount(this.c.k.Q().getAuthor().getUserId()) || !this.c.k.Q().isQuestionThread() || UtilHelper.isCurrentAccount(((bc9) this.c.getItem(this.a)).r().getUserId())) {
                return;
            }
            if (this.b.j0.getAgreeFlag()) {
                ((bc9) this.c.getItem(this.a)).V0(1);
                this.b.D0.setVisibility(0);
                ((bc9) this.c.getItem(this.a)).O0(true);
                this.b.i.setVisibility(8);
                this.b.j0.postDelayed(new a(this), 900L);
                return;
            }
            ((bc9) this.c.getItem(this.a)).V0(0);
            this.b.E0.setVisibility(8);
            this.b.D0.setVisibility(8);
            this.b.j0.setVisibility(0);
            this.b.k0.setVisibility(0);
            ((bc9) this.c.getItem(this.a)).O0(false);
            if (((bc9) this.c.getItem(this.a)).b0().booleanValue()) {
                this.b.i.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ vn8 b;
        public final /* synthetic */ zk8 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bc9 a;
            public final /* synthetic */ c b;

            public a(c cVar, bc9 bc9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bc9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = bc9Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.b;
                    cVar.b.b.a(cVar.c.k, null, this.a, cVar.a.q.getLayoutStrategy());
                }
            }
        }

        public c(zk8 zk8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, vn8 vn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, pbCommenFloorItemViewHolder, vn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zk8Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = vn8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            bc9 bc9Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof bc9) && (bc9Var = (bc9) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b != null) {
                jg.a().postDelayed(new a(this, bc9Var), 100L);
                String S = this.c.k.S();
                if ((StringUtils.isNull(S) || "0".equals(this.c.k.S())) && this.c.k.Q() != null) {
                    S = this.c.k.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.c.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", bc9Var.O()).param("obj_source", this.c.n0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ TbImageView c;
        public final /* synthetic */ zk8 d;

        public a(zk8 zk8Var, TextView textView, TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, textView, tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = zk8Var;
            this.b = textView;
            this.c = tbImageView;
            this.a = true;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a) {
                return;
            }
            Layout layout = this.b.getLayout();
            if (this.b != null && layout != null) {
                int lineCount = layout.getLineCount() - 1;
                if (layout.getEllipsisCount(lineCount) == 0 || layout.getEllipsisStart(lineCount) < 0) {
                    return;
                }
                String charSequence = this.b.getText().toString();
                String substring = charSequence.substring(0, layout.getEllipsisStart(lineCount));
                this.b.setText(charSequence.substring(0, layout.getEllipsisStart(lineCount)).concat(StringHelper.STRING_MORE));
                this.a = false;
                TbImageView tbImageView = this.c;
                if (tbImageView != null && tbImageView.getVisibility() == 0) {
                    if (substring.length() % 2 == 0) {
                        this.d.B0(this.c, false);
                    } else {
                        this.d.B0(this.c, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public b(zk8 zk8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ zk8 b;

        public d(zk8 zk8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zk8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.o) != null && agreeView.getData() != null) {
                if (view2 == this.a.o.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String S = this.b.k.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.k.S())) && this.b.k.Q() != null) {
                    S = this.b.k.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", this.b.n0(this.a.o)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ zk8 b;

        public e(zk8 zk8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zk8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.j0) != null && agreeView.getData() != null) {
                if (view2 == this.a.j0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String S = this.b.k.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.k.S())) && this.b.k.Q() != null) {
                    S = this.b.k.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.j0.getData().postId).param("obj_source", this.b.n0(this.a.j0)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk8 a;

        public g(zk8 zk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk8Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    this.a.o.a(view2);
                    return this.a.o.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements yf<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk8 a;

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public h(zk8 zk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk8Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new ConstrainImageLayout(this.a.mContext);
            }
            return (ConstrainImageLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements yf<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk8 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public i(zk8 zk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk8Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements mj8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk8 a;

        @Override // com.baidu.tieba.mj8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public j(zk8 zk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk8Var;
        }

        @Override // com.baidu.tieba.mj8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    if ((view2 instanceof TbListTextView) && this.a.m != null) {
                        this.a.m.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.P6(false);
                            return true;
                        }
                        return true;
                    }
                    this.a.o.a(view2);
                    this.a.o.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.mj8.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (((pbFragment = this.a.b) != null && pbFragment.M5() != null && !this.a.b.M5().P1()) || view2.getId() == R.id.obfuscated_res_0x7f090b04)) {
                    return true;
                }
                if (!(view2 instanceof FrameLayout)) {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (!(parent instanceof FrameLayout)) {
                            parent = parent.getParent();
                            i++;
                        } else {
                            this.a.U((FrameLayout) parent);
                            break;
                        }
                    }
                } else {
                    this.a.U(view2);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public k(zk8 zk8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            TBLottieAnimationView tBLottieAnimationView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tBLottieAnimationView = this.a.G0) != null) {
                tBLottieAnimationView.setVisibility(8);
                this.a.G0.pauseAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bc9 a;
        public final /* synthetic */ zk8 b;

        public l(zk8 zk8Var, bc9 bc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, bc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zk8Var;
            this.a = bc9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.r() != null && this.a.r().getPortrait() != null && !TextUtils.isEmpty(this.a.r().getPortrait())) {
                String str2 = null;
                if (this.a.o0() != null) {
                    str2 = this.a.o0().getFigureUrl();
                    str = this.a.o0().getBackgroundValue();
                } else {
                    str = null;
                }
                fv5.a(this.b.a.M().getPageContext(), this.a.r().getPortrait(), str2, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ bc9 b;
        public final /* synthetic */ zk8 c;

        public m(zk8 zk8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, pbCommenFloorItemViewHolder, bc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zk8Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = bc9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.Y.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.R(this.a, !z, this.b.I());
                this.b.R0(!z);
                this.c.s0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.M5() != null && this.c.b.M5().s1() != null && this.c.b.M5().Z0() != null && !z && this.a.getView().getTop() < this.c.b.M5().s1().getMeasuredHeight()) {
                    this.c.b.M5().Z0().setSelectionFromTop(ListUtils.getPosition(this.c.b.M5().Z0().getData(), this.b) + this.c.b.M5().Z0().getHeaderViewsCount(), this.c.b.M5().s1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ zk8 b;

        public n(zk8 zk8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zk8Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 4, this.a);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public o(zk8 zk8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0.setVisibility(8);
                this.a.j0.setVisibility(0);
                this.a.k0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ bc9 b;
        public final /* synthetic */ String[] c;
        public final /* synthetic */ int d;
        public final /* synthetic */ zk8 e;

        public p(zk8 zk8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, String[] strArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var, pbCommenFloorItemViewHolder, bc9Var, strArr, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zk8Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = bc9Var;
            this.c = strArr;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int width;
            int width2;
            int width3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.f.getMeasuredWidth();
                this.e.l0();
                boolean z = true;
                boolean z2 = !this.e.T(this.b);
                if (!StringUtils.isNull(this.c[0])) {
                    i = this.a.h.getWidth();
                } else {
                    i = 0;
                }
                if (this.a.M.getVisibility() == 8) {
                    width = 0;
                } else {
                    width = this.a.M.getWidth() + mm8.c + mm8.b;
                }
                if (this.a.j.getVisibility() == 8) {
                    width2 = 0;
                } else {
                    width2 = this.a.j.getWidth() + mm8.b;
                }
                if (this.a.K.getVisibility() == 8) {
                    width3 = 0;
                } else {
                    width3 = this.a.K.getWidth() + mm8.b;
                }
                int r = mm8.r(measuredWidth, width, i, width2, width3, z2);
                if (r < 0 && !StringUtils.isNull(this.c[0])) {
                    this.a.g.setWidth(i + r);
                } else {
                    this.a.g.setWidth(i);
                    z = false;
                }
                if (this.a.h.getText() == null) {
                    if (z) {
                        this.a.g.setText(this.c[0]);
                        zk8 zk8Var = this.e;
                        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                        zk8Var.A0(pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.j);
                    } else {
                        this.a.g.setText(this.c[0]);
                        this.e.B0(this.a.j, false);
                    }
                } else if (z) {
                    PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder2 = this.a;
                    pbCommenFloorItemViewHolder2.g.setText(pbCommenFloorItemViewHolder2.h.getText());
                    zk8 zk8Var2 = this.e;
                    PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder3 = this.a;
                    zk8Var2.A0(pbCommenFloorItemViewHolder3.g, pbCommenFloorItemViewHolder3.j);
                } else {
                    PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder4 = this.a;
                    pbCommenFloorItemViewHolder4.g.setText(pbCommenFloorItemViewHolder4.h.getText());
                    this.e.B0(this.a.j, false);
                }
                this.e.P(this.b, this.a, r, this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zk8(wp8 wp8Var, BdUniqueId bdUniqueId) {
        super(wp8Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wp8Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((wp8) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.h = true;
        this.i = 1.0f;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = true;
        this.u = true;
        this.v = false;
        this.w = 0;
        this.x = null;
        this.y = new xf<>(new h(this), 6, 0);
        this.z = new xf<>(new i(this), 12, 0);
        this.A = new mj8(new j(this));
        this.B = false;
        if (wp8Var != null && wp8Var.L() != null) {
            this.t = wp8Var.L().v1();
        }
        s(R.dimen.tbds14);
    }

    @Override // com.baidu.tieba.bl8, com.baidu.tieba.tm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        r0(i2, view2, viewGroup, (bc9) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void A0(TextView textView, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, textView, tbImageView) == null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, textView, tbImageView));
        }
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null && (imageView = pbCommenFloorItemViewHolder.O) != null && this.k != null) {
            imageView.setVisibility(8);
        }
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            int i2 = 0;
            if (pbCommenFloorItemViewHolder.e0.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ImageView imageView = pbCommenFloorItemViewHolder.d0;
                if (!bc9Var.b0) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
        }
    }

    public final void i0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048607, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            pbCommenFloorItemViewHolder.h(bc9Var.S, bc9Var.O(), this.v);
        }
    }

    public final void s0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, pbCommenFloorItemViewHolder, bc9Var) == null) {
            TbRichText Z = bc9Var.Z();
            if (Z != null) {
                Z.isChanged = true;
            }
            pbCommenFloorItemViewHolder.q.setText(Z, true, this.g);
        }
    }

    public final void E0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof bc9)) {
            return;
        }
        F0(textView, (bc9) tag);
    }

    public final void M(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.o);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new g(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.h = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onLongClickListener) == null) {
            this.p = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void n(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, a0Var) == null) {
            this.n = a0Var;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.j = str;
        }
    }

    public void r(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, ki8Var) == null) {
            this.k = ki8Var;
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.s = z;
        }
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.v = z;
        }
    }

    public void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.r = z;
        }
    }

    public void y0(mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, mj8Var) == null) {
            this.o = mj8Var;
        }
    }

    public void z0(TbRichTextView.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, uVar) == null) {
            this.g = uVar;
        }
    }

    public final void B0(TbImageView tbImageView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, z) != null) || tbImageView == null) {
            return;
        }
        if (z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.setMargins(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds_16), hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
            tbImageView.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams2.setMargins(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
        tbImageView.setLayoutParams(layoutParams2);
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.W != null && pbCommenFloorItemViewHolder.T != null) {
            if (bc9Var != null && (alaLiveInfoCoreData = bc9Var.T) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.W.setText(bc9Var.T.liveTitle);
                pbCommenFloorItemViewHolder.T.setTag(bc9Var.T);
                pbCommenFloorItemViewHolder.T.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbCommenFloorItemViewHolder.T.setVisibility(8);
        }
    }

    public final void h0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, pbCommenFloorItemViewHolder, bc9Var) == null) {
            if (bc9Var.J() != 2 && bc9Var.J() != 4) {
                pbCommenFloorItemViewHolder.Z.setVisibility(8);
                pbCommenFloorItemViewHolder.Y.setVisibility(0);
                S(false, pbCommenFloorItemViewHolder, bc9Var);
            } else {
                pbCommenFloorItemViewHolder.Z.setOnClickListener(new m(this, pbCommenFloorItemViewHolder, bc9Var));
                pbCommenFloorItemViewHolder.Z.setVisibility(0);
                R(pbCommenFloorItemViewHolder, bc9Var.w0(), bc9Var.I());
                S(true, pbCommenFloorItemViewHolder, bc9Var);
            }
            s0(pbCommenFloorItemViewHolder, bc9Var);
        }
    }

    public final void k0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048610, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && WorldCupEnableSwitch.isOn() && bc9Var != null) {
            AgreeView agreeView = pbCommenFloorItemViewHolder.j0;
            if (agreeView != null) {
                agreeView.setAgreeAlone(true);
                pbCommenFloorItemViewHolder.j0.setPadding(0, 0, 0, 0);
            }
            TbImageView tbImageView = pbCommenFloorItemViewHolder.H0;
            if (tbImageView != null) {
                tbImageView.setVisibility(0);
                pbCommenFloorItemViewHolder.H0.setImageResource(R.drawable.obfuscated_res_0x7f080893);
                pbCommenFloorItemViewHolder.H0.setOnClickListener(new l(this, bc9Var));
            }
            HeadWorldCupFlagLayout headWorldCupFlagLayout = pbCommenFloorItemViewHolder.I0;
            if (headWorldCupFlagLayout != null) {
                headWorldCupFlagLayout.b(bc9Var.r());
            }
        }
    }

    public final void C0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            E0(pbCommenFloorItemViewHolder.i);
            boolean z = true;
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    mm8.F(pbCommenFloorItemViewHolder.g);
                } else {
                    n15.d(pbCommenFloorItemViewHolder.g).B(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbCommenFloorItemViewHolder.s.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.s.g(skinType);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.v, hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f080a17, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080a18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.v.d();
            pbCommenFloorItemViewHolder.t.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.W, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.U, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.T, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.V, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.X, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.a0, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.Y.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0425);
            } else {
                ki8 ki8Var = this.k;
                if (ki8Var != null && StringUtils.isNull(ki8Var.k())) {
                    pbCommenFloorItemViewHolder.a0.setText(this.k.k());
                } else {
                    pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0634);
                }
            }
            pbCommenFloorItemViewHolder.o.P(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.k0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    public void D0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, pbCommenFloorItemViewHolder, bc9Var) == null) {
            String str = "#7F66FE";
            if (bc9Var.o0() != null) {
                VirtualImageCustomFigure o0 = bc9Var.o0();
                pbCommenFloorItemViewHolder.z0.setHeadImageViewResource(o0.getFigureUrl());
                pbCommenFloorItemViewHolder.z0.setTid(bc9Var.O());
                pbCommenFloorItemViewHolder.z0.setLocate(qm8.c);
                pbCommenFloorItemViewHolder.z0.setFrom(5);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(o0.getBackGroundType())) {
                    str = o0.getBackgroundValue();
                    pbCommenFloorItemViewHolder.z0.setHeadImageBackgroundColorResource(o0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(o0.getBackGroundType())) {
                    pbCommenFloorItemViewHolder.z0.setHeadImageBackgroundResource(o0.getBackgroundValue());
                }
                pbCommenFloorItemViewHolder.z0.e(bc9Var.r());
                pbCommenFloorItemViewHolder.x0.setVisibility(8);
                pbCommenFloorItemViewHolder.A0.setVisibility(0);
                pbCommenFloorItemViewHolder.z0.setTag(R.id.tag_user_id, bc9Var.r().getUserId());
                pbCommenFloorItemViewHolder.z0.setTag(R.id.tag_user_name, bc9Var.r().getUserName());
                pbCommenFloorItemViewHolder.f();
                String q = m35.q("key_reaction_guide_show_number_pb");
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.M() != null && this.b.M().getIntent() != null && this.b.M().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && !this.B && m35.m().n(q, 0) == 3) {
                    this.B = true;
                    pbCommenFloorItemViewHolder.G0.setVisibility(0);
                    pbCommenFloorItemViewHolder.G0.playAnimation();
                    jg.a().postDelayed(new k(this, pbCommenFloorItemViewHolder), 4000L);
                }
            } else {
                pbCommenFloorItemViewHolder.A0.setVisibility(8);
                pbCommenFloorItemViewHolder.z0.setTag(R.id.tag_user_id, null);
                pbCommenFloorItemViewHolder.z0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.x0.setVisibility(0);
                pbCommenFloorItemViewHolder.G0.setVisibility(8);
                pbCommenFloorItemViewHolder.G0.pauseAnimation();
            }
            if (bc9Var.p0() != null && !TextUtils.isEmpty(bc9Var.p0().getIcon())) {
                pbCommenFloorItemViewHolder.y0.setData(bc9Var.p0(), false, str);
                pbCommenFloorItemViewHolder.y0.setVisibility(0);
                if (pbCommenFloorItemViewHolder.B0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.B0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbCommenFloorItemViewHolder.B0.setLayoutParams(marginLayoutParams);
                }
                pbCommenFloorItemViewHolder.y0.setTag(R.id.tag_user_id, bc9Var.r().getUserId());
                pbCommenFloorItemViewHolder.y0.setTag(R.id.tag_user_name, bc9Var.r().getUserName());
                this.w = qm8.d;
                this.x = pbCommenFloorItemViewHolder.y0.getData();
                pbCommenFloorItemViewHolder.z0.setWithBubble(this.w);
                pbCommenFloorItemViewHolder.z0.setBubbleName(this.x);
                pbCommenFloorItemViewHolder.z0.setVirtualHeadUid(bc9Var.r().getUserId());
            } else {
                if (pbCommenFloorItemViewHolder.B0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.B0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbCommenFloorItemViewHolder.B0.setLayoutParams(marginLayoutParams2);
                }
                pbCommenFloorItemViewHolder.y0.setVisibility(8);
                pbCommenFloorItemViewHolder.y0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.y0.setTag(R.id.tag_user_id, null);
                int i2 = qm8.e;
                this.w = i2;
                pbCommenFloorItemViewHolder.z0.setWithBubble(i2);
            }
            if (pbCommenFloorItemViewHolder.z0.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.z0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            if (bc9Var.o0() != null) {
                qm8.a(2, bc9Var.O(), qm8.c, this.w, this.x, bc9Var.s());
            }
        }
    }

    public final void F0(TextView textView, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, textView, bc9Var) == null) {
            if (textView == null && bc9Var == null) {
                return;
            }
            textView.setTag(bc9Var);
            ki8 ki8Var = this.k;
            if (ki8Var != null && ki8Var.l0()) {
                bc9Var.c1(Boolean.FALSE);
                bc9Var.Q0(0);
                textView.setTag(null);
            } else if (bc9Var.r() != null) {
                MetaData r = bc9Var.r();
                String str = this.j;
                if (str != null && !str.equals("0") && this.j.equals(r.getUserId())) {
                    bc9Var.c1(Boolean.TRUE);
                    bc9Var.Q0(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    n15 d2 = n15.d(textView);
                    d2.o(R.string.J_X04);
                    d2.m(R.dimen.L_X01);
                    d2.w(R.color.CAM_X0302);
                    d2.l(R.color.CAM_X0302);
                } else if (r.getIs_bawu() == 1 && bc9Var.u0()) {
                    n15 d3 = n15.d(textView);
                    d3.w(R.color.CAM_X0101);
                    d3.o(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    bc9Var.c1(Boolean.TRUE);
                    bc9Var.Q0(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.brand_official);
                } else if (r.getIs_bawu() == 1 && "manager".equals(r.getBawu_type())) {
                    n15 d4 = n15.d(textView);
                    d4.w(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    bc9Var.c1(Boolean.TRUE);
                    bc9Var.Q0(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (r.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(r.getBawu_type())) {
                    n15 d5 = n15.d(textView);
                    d5.w(R.color.CAM_X0101);
                    d5.o(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    bc9Var.c1(Boolean.TRUE);
                    bc9Var.Q0(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (r.getIs_bawu() == 1 && "pri_content_assist".equals(r.getBawu_type())) {
                    n15 d6 = n15.d(textView);
                    d6.w(R.color.CAM_X0101);
                    d6.o(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    bc9Var.c1(Boolean.TRUE);
                    bc9Var.Q0(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (r.getIs_bawu() == 1 && "pri_manage_assist".equals(r.getBawu_type())) {
                    n15 d7 = n15.d(textView);
                    d7.w(R.color.CAM_X0101);
                    d7.o(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    bc9Var.c1(Boolean.TRUE);
                    bc9Var.Q0(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    bc9Var.c1(Boolean.FALSE);
                    bc9Var.Q0(0);
                }
            } else {
                bc9Var.c1(Boolean.FALSE);
                bc9Var.Q0(0);
            }
        }
    }

    public final void N(bc9 bc9Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bc9Var) == null) {
            if (bc9Var != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", bc9Var.O());
                statisticItem.param("pid", bc9Var.O());
                statisticItem.param("tid", bc9Var.j0());
                statisticItem.param("fid", bc9Var.K());
                statisticItem.param("fname", bc9Var.L());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            ki8 ki8Var = this.k;
            if (ki8Var != null) {
                if (ki8Var.y0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                        ki8 ki8Var2 = this.k;
                        int i4 = bc9Var.d0;
                        if (bc9Var.c0) {
                            i3 = 2;
                        } else {
                            i3 = 8;
                        }
                        mp8.e(uniqueId, ki8Var2, bc9Var, i4, i3, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                    ki8 ki8Var3 = this.k;
                    int i5 = bc9Var.d0;
                    if (bc9Var.c0) {
                        i2 = 2;
                    } else {
                        i2 = 8;
                    }
                    mp8.e(uniqueId2, ki8Var3, bc9Var, i5, i2, "common_exp_source_pb_comment");
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: q0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d073d, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0919fe)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0735, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.M().getPageContext(), inflate, this.t);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.v;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.u);
                pbCommenFloorItemViewHolder.v.setIsVideoThread(false);
            }
            C0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.q;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.s);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void t0(bc9 bc9Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bc9Var) == null) {
            String userId = bc9Var.r().getUserId();
            ki8 ki8Var = this.k;
            String str2 = "";
            if (ki8Var == null) {
                str = "";
            } else {
                str = ki8Var.m();
            }
            ki8 ki8Var2 = this.k;
            if (ki8Var2 != null) {
                str2 = ki8Var2.n();
            }
            int E = bc9Var.E();
            String O = bc9Var.O();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", O);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, E);
            if (bc9Var.r().getAlaInfo() != null) {
                AlaInfoData alaInfo = bc9Var.r().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void O(bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bc9Var) == null) && bc9Var.E == 0 && bc9Var.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", bc9Var.O());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            wp8 wp8Var = this.a;
            if (wp8Var != null) {
                int v1 = wp8Var.L().v1();
                if (1 != v1 && 2 != v1) {
                    if (3 == v1) {
                        statisticItem.param("obj_source", "2");
                    } else {
                        statisticItem.param("obj_source", "0");
                    }
                } else {
                    statisticItem.param("obj_source", "1");
                }
            }
            TiebaStatic.log(statisticItem);
            if (bc9Var.r() != null && bc9Var.r().getAlaInfo() != null && bc9Var.r().getAlaInfo().live_status == 1) {
                t0(bc9Var);
            }
        }
    }

    public final void P(bc9 bc9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048585, this, bc9Var, pbCommenFloorItemViewHolder, i2, i3) == null) {
            if (i2 > bc9Var.r0() + bc9Var.P()) {
                if (pbCommenFloorItemViewHolder.N != null && bc9Var.r() != null) {
                    pbCommenFloorItemViewHolder.N.setTag(R.id.tag_user_id, bc9Var.r().getUserId());
                    wp8 wp8Var = this.a;
                    if (wp8Var != null && wp8Var.M() != null) {
                        pbCommenFloorItemViewHolder.N.setOnClickListener(this.a.M().d.c);
                    }
                    ArrayList<IconData> iconInfo = bc9Var.r().getIconInfo();
                    int g2 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.N.h(iconInfo, i3, g2, g2, hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (bc9Var.b0().booleanValue() && !bc9Var.N()) {
                    pbCommenFloorItemViewHolder.i.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.i.setVisibility(8);
                }
            } else if (i2 > bc9Var.P()) {
                if (bc9Var.b0().booleanValue() && !bc9Var.N()) {
                    pbCommenFloorItemViewHolder.i.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.i.setVisibility(8);
                }
                pbCommenFloorItemViewHolder.N.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.N.setVisibility(8);
                pbCommenFloorItemViewHolder.i.setVisibility(8);
            }
        }
    }

    public final void Q(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int m2 = ((((hi.m(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                m2 = (m2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = s(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().J = (m2 - i3) - s(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                m2 /= 2;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((m2 - i3) * this.i));
            tbRichTextView.getLayoutStrategy().q((int) (m2 * 1.618f * this.i));
        }
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.Y.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0634);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.a0.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.Y.setVisibility(0);
            pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0425);
        }
    }

    public final void S(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, bc9Var}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.P) != null && pbCommenFloorItemViewHolder.Z != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.Z.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = true;
            boolean z3 = !ListUtils.isEmpty(bc9Var.d0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.P.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.Z.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(0);
                if (z3) {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.Z.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = hi.g(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
                }
            } else {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
                if (layoutParams != null) {
                    layoutParams.topMargin = hi.g(this.mContext, R.dimen.tbds14);
                    pbCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
                }
            }
            if (pbCommenFloorItemViewHolder.y0.getVisibility() != 0 && pbCommenFloorItemViewHolder.F0.getVisibility() != 0) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().k(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            } else {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().k(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            }
            wp9.b(bc9Var, pbCommenFloorItemViewHolder.q, (TextUtils.isEmpty(bc9Var.t()) || !this.h) ? false : false);
        }
    }

    public final boolean T(bc9 bc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bc9Var)) == null) {
            if (this.k.Q() != null && this.k.Q().getAuthor() != null && this.k.Q().getAuthor().getUserId() != null && bc9Var != null && bc9Var.r() != null && bc9Var.r().getUserId() != null) {
                return this.k.Q().getAuthor().getUserId().equals(bc9Var.r().getUserId());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void U(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).j0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.j0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.j0.N();
        }
    }

    public final void V(bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, bc9Var) == null) && bc9Var != null) {
            int i2 = 8;
            if (bc9Var.c0) {
                i2 = 2;
            }
            StatisticItem i3 = mp8.i(this.k, bc9Var, bc9Var.d0, i2, 6);
            bc9Var.e0 = i3;
            if (!ListUtils.isEmpty(bc9Var.d0())) {
                Iterator<bc9> it = bc9Var.d0().iterator();
                while (it.hasNext()) {
                    it.next().e0 = i3;
                }
            }
        }
    }

    public final String n0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            Object obj = "1";
            if (sparseArray == null) {
                return "1";
            }
            Object obj2 = sparseArray.get(R.id.pb_track_more_obj_source);
            if (obj2 != null) {
                obj = obj2;
            }
            sparseArray.remove(R.id.pb_track_more_obj_source);
            view2.setTag(sparseArray);
            return obj.toString();
        }
        return (String) invokeL.objValue;
    }

    public void p0(com.baidu.tbadk.data.MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mContext, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        boolean z;
        boolean z2;
        ki8 ki8Var;
        ki8 ki8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            String str = null;
            boolean z3 = true;
            if (bc9Var.E() > 0 && (ki8Var2 = this.k) != null && !ki8Var2.l0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0a43), Integer.valueOf(bc9Var.E()));
                pbCommenFloorItemViewHolder.J.setVisibility(0);
                pbCommenFloorItemViewHolder.J.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.J.setVisibility(8);
                z = false;
            }
            if (bc9Var.r() != null) {
                str = bc9Var.r().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    oa5 V = bc9Var.V();
                    z3 = (V != null || StringUtils.isNull(V.b()) || (ki8Var = this.k) == null || ki8Var.l0()) ? false : false;
                    if (!z) {
                        pbCommenFloorItemViewHolder.l.setVisibility(0);
                    } else {
                        pbCommenFloorItemViewHolder.l.setVisibility(8);
                    }
                    if (z3 && !z2) {
                        pbCommenFloorItemViewHolder.m.setVisibility(8);
                    } else {
                        pbCommenFloorItemViewHolder.m.setVisibility(0);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(bc9Var.k0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(bc9Var.k0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(bc9Var.k0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        TextView textView = pbCommenFloorItemViewHolder.n;
                        textView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        if (bc9Var.b0) {
                            pbCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(V.b(), 7, StringHelper.STRING_MORE));
                        } else {
                            pbCommenFloorItemViewHolder.n.setText(V.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.n.setVisibility(8);
                    }
                    TextView textView2 = pbCommenFloorItemViewHolder.m0;
                    textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            oa5 V2 = bc9Var.V();
            if (V2 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(bc9Var.k0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView22 = pbCommenFloorItemViewHolder.m0;
            textView22.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void v0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048627, this, pbCommenFloorItemViewHolder, i2) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.p);
            if (this.a.M() != null && this.a.M().getPageContext() != null && this.a.M().getPageContext().getOrignalPage() != null) {
                tn8 tn8Var = this.a.M().d;
                pbCommenFloorItemViewHolder.g.setOnClickListener(tn8Var.b);
                pbCommenFloorItemViewHolder.p.setOnClickListener(tn8Var.b);
                pbCommenFloorItemViewHolder.z0.setOnClickListener(tn8Var.d);
                pbCommenFloorItemViewHolder.y0.setOnClickListener(tn8Var.d);
                pbCommenFloorItemViewHolder.L.setOnClickListener(tn8Var.b);
                pbCommenFloorItemViewHolder.L.getHeadView().setOnClickListener(tn8Var.b);
                pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.q.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.m);
                pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.n);
                pbCommenFloorItemViewHolder.q.setOnImageTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(tn8Var.f);
                pbCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.m);
                pbCommenFloorItemViewHolder.Q.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.R.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.T.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.w.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.o0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.s0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.s0.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.k0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.t0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.l0.setOnClickListener(new b(this, pbCommenFloorItemViewHolder));
                vn8 vn8Var = this.a.M().e;
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.z.setOnClickListener(new c(this, pbCommenFloorItemViewHolder, vn8Var));
                pbCommenFloorItemViewHolder.o.B = new d(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.j0.B = new e(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.j0.setAfterClickListener(new f(this, i2, pbCommenFloorItemViewHolder));
            }
        }
    }

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048595, this, pbCommenFloorItemViewHolder, bc9Var, view2, i2) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.l0.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.t0.setVisibility(8);
            j0(pbCommenFloorItemViewHolder, bc9Var, view2, i2);
            W(pbCommenFloorItemViewHolder, bc9Var);
            a0(pbCommenFloorItemViewHolder, bc9Var);
            d0(pbCommenFloorItemViewHolder, bc9Var, view2);
            c0(pbCommenFloorItemViewHolder, bc9Var, view2, i2);
            X(pbCommenFloorItemViewHolder, bc9Var);
            g0(pbCommenFloorItemViewHolder, bc9Var);
            b0(pbCommenFloorItemViewHolder, bc9Var);
            D0(pbCommenFloorItemViewHolder, bc9Var);
            h0(pbCommenFloorItemViewHolder, bc9Var);
            yj8.d(pbCommenFloorItemViewHolder, bc9Var, view2, this.h, this.A);
            f0(pbCommenFloorItemViewHolder, bc9Var);
            Y(pbCommenFloorItemViewHolder, bc9Var);
            e0(pbCommenFloorItemViewHolder, bc9Var);
            i0(pbCommenFloorItemViewHolder, bc9Var);
            k0(pbCommenFloorItemViewHolder, bc9Var);
            yj8.i(pbCommenFloorItemViewHolder, view2, bc9Var, this.r, true);
        }
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null && bc9Var.o() != null) {
            bc9Var.o().threadId = this.a.L().Q1();
            bc9Var.o().objType = 1;
            bc9Var.o().isInPost = true;
            ThreadData threadData = null;
            ki8 ki8Var = this.k;
            if (ki8Var != null && ki8Var.Q() != null) {
                threadData = this.k.Q();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setThreadData(threadData);
            pbCommenFloorItemViewHolder.o.setData(bc9Var.o());
            pbCommenFloorItemViewHolder.j0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.j0.setData(bc9Var.o());
        }
    }

    public final void g0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, pbCommenFloorItemViewHolder, bc9Var) == null) {
            if (bc9Var != null && bc9Var.r() != null && bc9Var.g0() != null) {
                TbRichText Z = bc9Var.Z();
                if (Z != null && StringUtils.isNull(Z.toString()) && StringUtils.isNull(bc9Var.t())) {
                    z = true;
                } else {
                    z = false;
                }
                if (bc9Var.r().getSmallTailThemeData() != null) {
                    str = bc9Var.r().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.Q.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.R.setTag(R.id.tag_pb_small_tail_theme_id, str);
                tq8.c(bc9Var.g0(), pbCommenFloorItemViewHolder.Q, pbCommenFloorItemViewHolder.R, pbCommenFloorItemViewHolder.S, false, false, z, bc9Var.r().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.Q.setVisibility(8);
            pbCommenFloorItemViewHolder.R.setVisibility(8);
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048599, this, pbCommenFloorItemViewHolder, bc9Var, view2, i2) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            if (bc9Var.f0() > 0) {
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.x.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.x.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, bc9Var);
                if (bc9Var.J() == 2) {
                    pbCommenFloorItemViewHolder.x.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.x.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.w.setVisibility(8);
            }
            ImageView imageView = pbCommenFloorItemViewHolder.y;
            if (imageView != null) {
                SparseArray sparseArray2 = (SparseArray) imageView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, bc9Var);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, bc9Var);
            }
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            if (!bc9Var.t0() && !bc9Var.s0(false)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams2.topMargin = hi.g(this.mContext, R.dimen.tbds0);
                layoutParams2.leftMargin = hi.g(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = hi.g(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = hi.g(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams2);
                if (this.q == null) {
                    vo8 vo8Var = new vo8(this.mContext);
                    this.q = vo8Var;
                    vo8Var.f(this.e);
                    this.q.h(this.l);
                    this.q.e(this.m);
                    String str = null;
                    ki8 ki8Var = this.k;
                    if (ki8Var != null && ki8Var.Q() != null && this.k.Q().getAuthor() != null) {
                        str = this.k.Q().getAuthor().getUserId();
                    }
                    boolean z = true;
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    ki8 ki8Var2 = this.k;
                    if (ki8Var2 != null) {
                        this.q.j(ki8Var2.Y(), z);
                        this.q.i(this.k.Q());
                    }
                }
                this.q.g(bc9Var.O());
                pbCommenFloorItemViewHolder.v.setSubPbAdapter(this.q);
                pbCommenFloorItemViewHolder.v.setVisibility(0);
                pbCommenFloorItemViewHolder.v.setData(bc9Var, view2);
                pbCommenFloorItemViewHolder.v.setChildOnClickListener(this.m);
                pbCommenFloorItemViewHolder.v.setChildOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.v.setChildOnTouchListener(this.A);
            }
            if (bc9Var.P) {
                pbCommenFloorItemViewHolder.P.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.P.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams3.topMargin = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.w.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.u.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.u.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.n0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10c3));
        }
    }

    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048601, this, pbCommenFloorItemViewHolder, bc9Var, view2) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = hi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = hi.g(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
            if (!this.h) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.q.p0(null);
                pbCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().z(R.drawable.pic_video);
            Q(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(bc9Var.t()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.q.setTid(this.k.S());
            pbCommenFloorItemViewHolder.q.setPid(bc9Var.O());
            pbCommenFloorItemViewHolder.q.setPosition(TbRichTextView.Position.PB_COMMENT_FLOOR);
            pbCommenFloorItemViewHolder.q.setText(bc9Var.Z(), true, this.g);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, bc9Var);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            sparseArray.put(R.id.tag_is_top_question, Boolean.FALSE);
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.t0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.k0.setTag(sparseArray);
        }
    }

    public final void e0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            wp8 wp8Var = this.a;
            if (wp8Var != null && wp8Var.L() != null && StringHelper.equals(this.a.L().X0(), bc9Var.O())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final void f0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048604, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            String a0 = bc9Var.a0();
            if (!StringUtils.isNull(a0)) {
                pbCommenFloorItemViewHolder.e0.M(a0, 10, false);
                pbCommenFloorItemViewHolder.e0.setVisibility(0);
                pbCommenFloorItemViewHolder.d0.setVisibility(8);
                return;
            }
            pbCommenFloorItemViewHolder.e0.setVisibility(8);
        }
    }

    public final SpannableStringBuilder m0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new xe6.a(str, R.drawable.pic_smalldot_title));
                return xe6.h(this.a.M(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            ki8 ki8Var = this.k;
            if (ki8Var != null && ki8Var.Q() != null) {
                return this.k.Q().isQuestionThread();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            ki8 ki8Var = this.k;
            if (ki8Var != null && ki8Var.Q() != null) {
                return this.k.Q().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View r0(int i2, View view2, ViewGroup viewGroup, bc9 bc9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, bc9Var, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) bc9Var, (bc9) pbCommenFloorItemViewHolder);
            C0(pbCommenFloorItemViewHolder);
            v0(pbCommenFloorItemViewHolder, i2);
            M(pbCommenFloorItemViewHolder);
            bc9 bc9Var2 = (bc9) getItem(i2);
            if (bc9Var2 != null) {
                bc9Var2.d0 = i2 + 1;
                O(bc9Var2);
                N(bc9Var2);
                bc9Var2.o1();
                V(bc9Var2);
                Z(pbCommenFloorItemViewHolder, bc9Var2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
