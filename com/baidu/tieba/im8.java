package com.baidu.tieba;

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
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.mj8;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbTopCommenFloorItemViewHolder;
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
/* loaded from: classes4.dex */
public class im8 extends bl8<bc9, PbTopCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView.u g;
    public boolean h;
    public float i;
    public String j;
    public ki8 k;
    public View.OnClickListener l;
    public TbRichTextView.a0 m;
    public mj8 n;
    public View.OnLongClickListener o;
    public boolean p;
    public int q;
    public boolean r;
    public int s;
    public String t;
    public xf<ConstrainImageLayout> u;
    public xf<TbImageView> v;
    public mj8 w;

    /* JADX WARN: Removed duplicated region for block: B:283:0x0813  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0817  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0820  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0829  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x086c  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0873  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x08dc  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x08e6  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0928  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var, View view2, int i2) {
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048604, this, pbTopCommenFloorItemViewHolder, bc9Var, view2, i2) == null) || pbTopCommenFloorItemViewHolder == null || bc9Var == null) {
            return;
        }
        if (bc9Var.r() != null) {
            bc9Var.r().isBaijiahaoUser();
        }
        SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.e, R.color.CAM_X0204);
        pbTopCommenFloorItemViewHolder.e.setVisibility(0);
        pbTopCommenFloorItemViewHolder.q.setTag(null);
        pbTopCommenFloorItemViewHolder.q.setUserId(null);
        pbTopCommenFloorItemViewHolder.J.getHeadView().setUserId(null);
        pbTopCommenFloorItemViewHolder.r.setIsHost(false);
        if (bc9Var.r() != null) {
            String str = this.j;
            if (str != null && !str.equals("0") && this.j.equals(bc9Var.r().getUserId())) {
                pbTopCommenFloorItemViewHolder.r.setIsHost(true);
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
            if (pbTopCommenFloorItemViewHolder.K != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbTopCommenFloorItemViewHolder.K.setTag(tShowInfoNew.get(0).getUrl());
                }
                wp8 wp8Var = this.a;
                if (wp8Var != null && wp8Var.M() != null) {
                    pbTopCommenFloorItemViewHolder.K.setOnClickListener(this.a.M().d.e);
                }
                int g4 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbTopCommenFloorItemViewHolder.K.i(tShowInfoNew, 3, g4, g4, hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !bc9Var.r().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        mm8.F(pbTopCommenFloorItemViewHolder.h);
                    } else {
                        n15.d(pbTopCommenFloorItemViewHolder.h).B(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0301, 1);
            }
            String avater = bc9Var.r().getAvater();
            int i5 = bc9Var.c0 ? 2 : 8;
            pbTopCommenFloorItemViewHolder.p.setTag(R.id.tag_pb_top_replay_more, bc9Var);
            pbTopCommenFloorItemViewHolder.p.setTag(R.id.tag_is_top_question, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_user_id, bc9Var.r().getUserId());
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_is_top_question, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_user_name, bc9Var.r().getUserName());
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_virtual_user_url, bc9Var.r().getVirtualUserUrl());
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_statistic_item, mp8.i(this.k, bc9Var, bc9Var.d0, i5, 2));
            String name_show = bc9Var.r().getName_show();
            String userName = bc9Var.r().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbTopCommenFloorItemViewHolder.i.setText(kh8.b(this.mContext, pbTopCommenFloorItemViewHolder.h.getText().toString()));
                pbTopCommenFloorItemViewHolder.h.setGravity(16);
                pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_nick_name_activity, kh8.a());
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0312, 1);
            }
            if (bc9Var.r().getPendantData() != null && !StringUtils.isNull(bc9Var.r().getPendantData().getImgUrl())) {
                pbTopCommenFloorItemViewHolder.J.setBigVDimenSize(R.dimen.tbds36);
                pbTopCommenFloorItemViewHolder.J.i(bc9Var.r());
                pbTopCommenFloorItemViewHolder.q.setVisibility(8);
                pbTopCommenFloorItemViewHolder.J.setVisibility(0);
                pbTopCommenFloorItemViewHolder.J.getHeadView().M(avater, 28, false);
                pbTopCommenFloorItemViewHolder.J.getHeadView().setUserId(bc9Var.r().getUserId());
                pbTopCommenFloorItemViewHolder.J.getHeadView().setUserName(bc9Var.r().getUserName());
                ki8 ki8Var = this.k;
                pbTopCommenFloorItemViewHolder.J.getHeadView().setFid(ki8Var != null ? ki8Var.m() : "");
                ki8 ki8Var2 = this.k;
                pbTopCommenFloorItemViewHolder.J.getHeadView().setFName(ki8Var2 != null ? ki8Var2.n() : "");
                pbTopCommenFloorItemViewHolder.J.getHeadView().setFloor(bc9Var.E());
                pbTopCommenFloorItemViewHolder.J.getHeadView().setTid(bc9Var.O());
                pbTopCommenFloorItemViewHolder.J.getHeadView().setTag(R.id.tag_statistic_item, mp8.i(this.k, bc9Var, bc9Var.d0, i5, 2));
                pbTopCommenFloorItemViewHolder.J.setTag(R.id.tag_is_top_question, Boolean.TRUE);
                pbTopCommenFloorItemViewHolder.J.i(bc9Var.r());
            } else {
                pbTopCommenFloorItemViewHolder.q.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbTopCommenFloorItemViewHolder.q, bc9Var.r(), 4);
                pbTopCommenFloorItemViewHolder.q.setUserId(bc9Var.r().getUserId());
                ki8 ki8Var3 = this.k;
                pbTopCommenFloorItemViewHolder.q.setFid(ki8Var3 != null ? ki8Var3.m() : "");
                ki8 ki8Var4 = this.k;
                pbTopCommenFloorItemViewHolder.q.setFName(ki8Var4 != null ? ki8Var4.n() : "");
                pbTopCommenFloorItemViewHolder.q.setFloor(bc9Var.E());
                pbTopCommenFloorItemViewHolder.q.setTid(bc9Var.O());
                pbTopCommenFloorItemViewHolder.q.setUserName(bc9Var.r().getUserName(), bc9Var.m0());
                pbTopCommenFloorItemViewHolder.q.setTag(R.id.tag_virtual_user_url, bc9Var.r().getVirtualUserUrl());
                pbTopCommenFloorItemViewHolder.q.setTag(R.id.tag_is_top_question, Boolean.TRUE);
                pbTopCommenFloorItemViewHolder.q.setTag(R.id.tag_statistic_item, mp8.i(this.k, bc9Var, bc9Var.d0, i5, 2));
                pbTopCommenFloorItemViewHolder.q.setImageDrawable(null);
                pbTopCommenFloorItemViewHolder.q.M(avater, 28, false);
                pbTopCommenFloorItemViewHolder.q.setVisibility(0);
                pbTopCommenFloorItemViewHolder.J.setVisibility(8);
            }
            if (bc9Var.r() != null && bc9Var.r().getAlaInfo() != null && bc9Var.r().getAlaUserData() != null && bc9Var.r().getAlaUserData().live_status == 1) {
                pbTopCommenFloorItemViewHolder.d(true);
                pbTopCommenFloorItemViewHolder.q.setLiveStatus(1);
                pbTopCommenFloorItemViewHolder.q.setAlaInfo(bc9Var.r().getAlaInfo());
                pbTopCommenFloorItemViewHolder.J.getHeadView().setLiveStatus(1);
                pbTopCommenFloorItemViewHolder.J.getHeadView().setAlaInfo(bc9Var.r().getAlaInfo());
            } else {
                pbTopCommenFloorItemViewHolder.d(false);
                pbTopCommenFloorItemViewHolder.q.setLiveStatus(0);
                pbTopCommenFloorItemViewHolder.q.setAlaInfo(null);
                pbTopCommenFloorItemViewHolder.J.getHeadView().setLiveStatus(0);
                pbTopCommenFloorItemViewHolder.J.getHeadView().setAlaInfo(null);
            }
            B0(pbTopCommenFloorItemViewHolder.j, bc9Var);
            if (TbSingleton.getInstance().isUserGrowthOpen() && bc9Var.r().getUserGrowthData() != null) {
                int a2 = bc9Var.r().getUserGrowthData().a();
                if (a2 >= 0 && a2 <= 10) {
                    pbTopCommenFloorItemViewHolder.k.setImageResource(sw.b(a2));
                    pbTopCommenFloorItemViewHolder.k.setVisibility(0);
                    pbTopCommenFloorItemViewHolder.k.setOnClickListener(new j(this, a2));
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 4, a2);
                } else {
                    pbTopCommenFloorItemViewHolder.k.setVisibility(8);
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
            pbTopCommenFloorItemViewHolder.I.setVisibility(0);
            SkinManager.setImageResource(pbTopCommenFloorItemViewHolder.I, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbTopCommenFloorItemViewHolder.I.setVisibility(8);
        }
        int i6 = 15;
        if (i3 == 1) {
            i6 = 13;
        } else if (i3 > 1) {
            i6 = 11;
        }
        if (pbTopCommenFloorItemViewHolder.j.getVisibility() == 0) {
            i6 -= 2;
        }
        if (pbTopCommenFloorItemViewHolder.K.getChildCount() > 0) {
            i6 -= 2;
        }
        if (bc9Var.w() > 1000) {
            i6 -= 2;
        }
        if (bc9Var.w() > 10) {
            i6 -= 2;
        }
        if (i6 < 10) {
            if (i3 == 1) {
                i6 += 2;
            } else if (i3 > 1) {
                i6 += 4;
            }
            if (i6 < 10 && pbTopCommenFloorItemViewHolder.j.getVisibility() == 0) {
                i6 += 2;
                pbTopCommenFloorItemViewHolder.j.setVisibility(8);
            }
            if (i6 < 10 && pbTopCommenFloorItemViewHolder.I.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.I.setVisibility(8);
            }
        }
        int m2 = mm8.m();
        String name_show2 = (bc9Var.r() == null || bc9Var.r().getName_show() == null) ? "" : bc9Var.r().getName_show();
        int f2 = dq5.f(name_show2);
        if (bc9Var.r() != null && !StringUtils.isNull(bc9Var.r().getSealPrefix())) {
            int i7 = m2 - 2;
            if (f2 > i7) {
                name_show2 = dq5.n(name_show2, i7) + StringHelper.STRING_MORE;
            }
        } else if (f2 > m2) {
            name_show2 = dq5.n(name_show2, m2) + StringHelper.STRING_MORE;
        }
        if (bc9Var.r() != null && !StringUtils.isNull(bc9Var.r().getSealPrefix())) {
            pbTopCommenFloorItemViewHolder.i.setText(l0(bc9Var.r().getSealPrefix(), name_show2));
        } else {
            pbTopCommenFloorItemViewHolder.i.setText(name_show2);
        }
        if (((bc9) getItem(i2)).R() == 1 && this.k.Q() != null && this.k.Q().isQuestionThread() && !S(bc9Var)) {
            ((bc9) getItem(i2)).O0(true);
            pbTopCommenFloorItemViewHolder.q0.setVisibility(0);
            if (((bc9) getItem(i2)).Q().booleanValue()) {
                pbTopCommenFloorItemViewHolder.r0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.d0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.e0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.r0.postDelayed(new k(this, pbTopCommenFloorItemViewHolder), 3000L);
            } else {
                pbTopCommenFloorItemViewHolder.r0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.d0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.e0.setVisibility(0);
            }
        } else {
            ((bc9) getItem(i2)).O0(false);
            pbTopCommenFloorItemViewHolder.q0.setVisibility(8);
            pbTopCommenFloorItemViewHolder.r0.setVisibility(8);
            pbTopCommenFloorItemViewHolder.d0.setVisibility(0);
            pbTopCommenFloorItemViewHolder.e0.setVisibility(0);
        }
        ImageView imageView = pbTopCommenFloorItemViewHolder.B;
        if (imageView != null) {
            SparseArray sparseArray = (SparseArray) imageView.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbTopCommenFloorItemViewHolder.B.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, bc9Var);
        }
        ImageView imageView2 = pbTopCommenFloorItemViewHolder.C;
        if (imageView2 != null) {
            SparseArray sparseArray2 = (SparseArray) imageView2.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbTopCommenFloorItemViewHolder.C.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_load_sub_data, bc9Var);
        }
        SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.q0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.u0, R.color.CAM_X0105, 1);
        pbTopCommenFloorItemViewHolder.g.post(new l(this, pbTopCommenFloorItemViewHolder, new String[]{name_show2}, bc9Var, 2));
        if (!StringUtils.isNull(bc9Var.r().getDiplayIntro())) {
            i4 = 0;
            pbTopCommenFloorItemViewHolder.s0.setVisibility(0);
            pbTopCommenFloorItemViewHolder.s0.setText(bc9Var.r().getDiplayIntro() + "");
        } else {
            i4 = 0;
            pbTopCommenFloorItemViewHolder.s0.setVisibility(8);
        }
        SparseArray sparseArray3 = new SparseArray();
        sparseArray3.put(R.id.tag_clip_board, bc9Var);
        sparseArray3.put(R.id.tag_load_sub_data, bc9Var);
        sparseArray3.put(R.id.tag_load_sub_view, view2);
        sparseArray3.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray3.put(R.id.tag_pb_floor_number, Integer.valueOf(bc9Var.E()));
        sparseArray3.put(R.id.tag_forbid_user_post_id, bc9Var.O());
        sparseArray3.put(R.id.pb_dialog_item_zan_2, pbTopCommenFloorItemViewHolder.d0);
        sparseArray3.put(R.id.pb_dialog_item_reply, pbTopCommenFloorItemViewHolder.B);
        sparseArray3.put(R.id.pb_dialog_item_share, pbTopCommenFloorItemViewHolder.C);
        ki8 ki8Var6 = this.k;
        ThreadData Q = (ki8Var6 == null || ki8Var6.Q() == null) ? null : this.k.Q();
        if (Q != null && Q.isUgcThreadType()) {
            sparseArray3.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray3.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z7 = (bc9Var.r() == null || StringUtils.isNull(bc9Var.r().getVirtualUserUrl())) ? false : true;
        ki8 ki8Var7 = this.k;
        if (ki8Var7 == null || ki8Var7.Y() == 0 || n0()) {
            z = false;
            z2 = false;
        } else {
            z = (this.k.Y() == 1002 || this.k.Y() == 3) ? false : true;
            z2 = (this.k.Y() == 3 || this.k.l0()) ? false : true;
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
                    z2 = true;
                    z3 = false;
                    z4 = true;
                } else {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                }
                z5 = true;
                if (bc9Var != null && bc9Var.r() != null && UtilHelper.isCurrentAccount(bc9Var.r().getUserId())) {
                    z2 = true;
                    z4 = true;
                }
                if (z7) {
                    z6 = z;
                } else {
                    z2 = false;
                    z3 = false;
                    z6 = false;
                }
                if (bc9Var.E() != 1) {
                    i4 = 1;
                }
                if (!z6) {
                    sparseArray3.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray3.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.Y()));
                    if (bc9Var.r() != null) {
                        sparseArray3.put(R.id.tag_forbid_user_name, bc9Var.r().getUserName());
                        sparseArray3.put(R.id.tag_forbid_user_name_show, bc9Var.r().getName_show());
                        sparseArray3.put(R.id.tag_forbid_user_portrait, bc9Var.r().getPortrait());
                    }
                } else {
                    sparseArray3.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray3.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray3.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (bc9Var.r() != null) {
                        sparseArray3.put(R.id.tag_user_mute_mute_userid, bc9Var.r().getUserId());
                        sparseArray3.put(R.id.tag_user_mute_mute_username, bc9Var.r().getUserName());
                        sparseArray3.put(R.id.tag_user_mute_mute_nameshow, bc9Var.r().getName_show());
                    }
                    if (this.k.Q() != null) {
                        sparseArray3.put(R.id.tag_user_mute_thread_id, this.k.Q().getId());
                    }
                    sparseArray3.put(R.id.tag_user_mute_post_id, bc9Var.O());
                } else {
                    sparseArray3.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray3.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray3.put(R.id.tag_has_sub_post, Boolean.valueOf(bc9Var.t0()));
                    sparseArray3.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.Y()));
                    sparseArray3.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                    sparseArray3.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                    sparseArray3.put(R.id.tag_del_post_id, bc9Var.O());
                } else {
                    sparseArray3.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                sparseArray3.put(R.id.tag_is_self_post, Boolean.valueOf(z5));
                pbTopCommenFloorItemViewHolder.r.setTag(sparseArray3);
                pbTopCommenFloorItemViewHolder.t.setTag(sparseArray3);
            }
        }
        z3 = false;
        z4 = false;
        z5 = false;
        if (bc9Var != null) {
            z2 = true;
            z4 = true;
        }
        if (z7) {
        }
        if (bc9Var.E() != 1) {
        }
        if (!z6) {
        }
        if (!z3) {
        }
        if (!z2) {
        }
        sparseArray3.put(R.id.tag_is_self_post, Boolean.valueOf(z5));
        pbTopCommenFloorItemViewHolder.r.setTag(sparseArray3);
        pbTopCommenFloorItemViewHolder.t.setTag(sparseArray3);
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view2) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder b;
        public final /* synthetic */ im8 c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* renamed from: com.baidu.tieba.im8$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class View$OnClickListenerC0293a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0293a(a aVar) {
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
                        c cVar = this.a.a;
                        im8 im8Var = cVar.c;
                        im8Var.o0(((bc9) im8Var.getItem(cVar.a)).r());
                    }
                }
            }

            /* loaded from: classes4.dex */
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
                        c cVar = this.a.a;
                        ((bc9) cVar.c.getItem(cVar.a)).D0();
                        c cVar2 = this.a.a;
                        if (((bc9) cVar2.c.getItem(cVar2.a)).Y() <= 0) {
                            c cVar3 = this.a.a;
                            ((bc9) cVar3.c.getItem(cVar3.a)).U0(Boolean.FALSE);
                            this.a.a.b.r0.setVisibility(8);
                            this.a.a.b.d0.setVisibility(0);
                            this.a.a.b.e0.setVisibility(0);
                        }
                    }
                }
            }

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.b.d0.getAgreeFlag()) {
                    return;
                }
                c cVar = this.a;
                ((bc9) cVar.c.getItem(cVar.a)).C0();
                c cVar2 = this.a;
                ((bc9) cVar2.c.getItem(cVar2.a)).U0(Boolean.TRUE);
                this.a.b.d0.setVisibility(8);
                this.a.b.e0.setVisibility(8);
                this.a.b.r0.setVisibility(0);
                this.a.b.r0.setOnClickListener(new View$OnClickListenerC0293a(this));
                this.a.b.r0.postDelayed(new b(this), 5000L);
            }
        }

        public c(im8 im8Var, int i, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im8Var, Integer.valueOf(i), pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = im8Var;
            this.a = i;
            this.b = pbTopCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !UtilHelper.isCurrentAccount(this.c.k.Q().getAuthor().getUserId()) || !this.c.k.Q().isQuestionThread() || UtilHelper.isCurrentAccount(((bc9) this.c.getItem(this.a)).r().getUserId())) {
                return;
            }
            if (this.b.d0.getAgreeFlag()) {
                ((bc9) this.c.getItem(this.a)).V0(1);
                this.b.q0.setVisibility(0);
                ((bc9) this.c.getItem(this.a)).O0(true);
                this.b.j.setVisibility(8);
                this.b.d0.postDelayed(new a(this), 900L);
                return;
            }
            ((bc9) this.c.getItem(this.a)).V0(0);
            this.b.r0.setVisibility(8);
            this.b.q0.setVisibility(8);
            this.b.d0.setVisibility(0);
            ((bc9) this.c.getItem(this.a)).O0(false);
            if (((bc9) this.c.getItem(this.a)).b0().booleanValue()) {
                this.b.j.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ vn8 b;
        public final /* synthetic */ im8 c;

        /* renamed from: com.baidu.tieba.im8$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0292a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bc9 a;
            public final /* synthetic */ a b;

            public RunnableC0292a(a aVar, bc9 bc9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bc9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = bc9Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.b;
                    aVar.b.b.a(aVar.c.k, null, this.a, aVar.a.r.getLayoutStrategy());
                }
            }
        }

        public a(im8 im8Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, vn8 vn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im8Var, pbTopCommenFloorItemViewHolder, vn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = im8Var;
            this.a = pbTopCommenFloorItemViewHolder;
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
                jg.a().postDelayed(new RunnableC0292a(this, bc9Var), 100L);
                String S = this.c.k.S();
                if ((StringUtils.isNull(S) || "0".equals(this.c.k.S())) && this.c.k.Q() != null) {
                    S = this.c.k.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.c.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", bc9Var.O()).param("obj_source", this.c.m0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ im8 b;

        public b(im8 im8Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im8Var, pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = im8Var;
            this.a = pbTopCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbTopCommenFloorItemViewHolder = this.a) != null && (agreeView = pbTopCommenFloorItemViewHolder.d0) != null && agreeView.getData() != null) {
                if (view2 == this.a.d0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String S = this.b.k.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.k.S())) && this.b.k.Q() != null) {
                    S = this.b.k.Q().getNid();
                }
                if (this.a.d0.getData().hasAgree) {
                    i2 = 3;
                } else {
                    i2 = 4;
                }
                mp8.s(i2);
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.d0.getData().postId).param("obj_source", this.b.m0(this.a.d0)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im8 a;

        public d(im8 im8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = im8Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.n != null) {
                    this.a.n.a(view2);
                    return this.a.n.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements yf<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im8 a;

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

        public e(im8 im8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = im8Var;
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

    /* loaded from: classes4.dex */
    public class f implements yf<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im8 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public f(im8 im8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = im8Var;
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

    /* loaded from: classes4.dex */
    public class g implements mj8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im8 a;

        @Override // com.baidu.tieba.mj8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public g(im8 im8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = im8Var;
        }

        @Override // com.baidu.tieba.mj8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.n != null) {
                    if ((view2 instanceof TbListTextView) && this.a.l != null) {
                        this.a.l.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.P6(true);
                        }
                    } else {
                        this.a.n.a(view2);
                        this.a.n.onSingleTapConfirmed(motionEvent);
                    }
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
                if (view2 == null || ((pbFragment = this.a.b) != null && pbFragment.M5() != null && !this.a.b.M5().P1())) {
                    return true;
                }
                if (!(view2 instanceof RelativeLayout)) {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (!(parent instanceof RelativeLayout)) {
                            parent = parent.getParent();
                            i++;
                        } else {
                            this.a.T((RelativeLayout) parent);
                            break;
                        }
                    }
                } else {
                    this.a.T(view2);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bc9 a;
        public final /* synthetic */ im8 b;

        public h(im8 im8Var, bc9 bc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im8Var, bc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = im8Var;
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

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ bc9 b;
        public final /* synthetic */ im8 c;

        public i(im8 im8Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im8Var, pbTopCommenFloorItemViewHolder, bc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = im8Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = bc9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.V.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.Q(this.a, !z, this.b.I());
                this.b.R0(!z);
                this.c.r0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.M5() != null && this.c.b.M5().s1() != null && this.c.b.M5().Z0() != null && !z && this.a.getView().getTop() < this.c.b.M5().s1().getMeasuredHeight()) {
                    this.c.b.M5().Z0().setSelectionFromTop(ListUtils.getPosition(this.c.b.M5().Z0().getData(), this.b) + this.c.b.M5().Z0().getHeaderViewsCount(), this.c.b.M5().s1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ im8 b;

        public j(im8 im8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = im8Var;
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

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;

        public k(im8 im8Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im8Var, pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbTopCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r0.setVisibility(8);
                this.a.d0.setVisibility(0);
                this.a.e0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ bc9 c;
        public final /* synthetic */ int d;
        public final /* synthetic */ im8 e;

        public l(im8 im8Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, String[] strArr, bc9 bc9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im8Var, pbTopCommenFloorItemViewHolder, strArr, bc9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = im8Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = strArr;
            this.c = bc9Var;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int width;
            int width2;
            int width3;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.g.getMeasuredWidth();
                boolean k0 = this.e.k0();
                if (!StringUtils.isNull(this.b[0])) {
                    i = this.a.i.getWidth();
                } else {
                    i = 0;
                }
                if (this.a.K.getVisibility() == 8) {
                    width = 0;
                } else {
                    width = this.a.K.getWidth() + mm8.c + mm8.b;
                }
                if (this.a.k.getVisibility() == 8) {
                    width2 = 0;
                } else {
                    width2 = this.a.k.getWidth() + mm8.b;
                }
                if (this.a.I.getVisibility() == 8) {
                    width3 = 0;
                } else {
                    width3 = this.a.I.getWidth() + mm8.b;
                }
                int r = mm8.r(measuredWidth, width, i, width2, width3, k0);
                if (r < 0 && !StringUtils.isNull(this.b[0])) {
                    this.a.h.setWidth(i + r);
                    z = true;
                } else {
                    this.a.h.setWidth(i);
                    z = false;
                }
                if (this.a.i.getText() == null) {
                    if (z) {
                        this.a.h.setText(this.b[0]);
                        im8 im8Var = this.e;
                        PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder = this.a;
                        im8Var.w0(pbTopCommenFloorItemViewHolder.h, pbTopCommenFloorItemViewHolder.k);
                    } else {
                        this.a.h.setText(this.b[0]);
                        this.e.x0(this.a.k, false);
                    }
                } else if (z) {
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder2 = this.a;
                    pbTopCommenFloorItemViewHolder2.h.setText(pbTopCommenFloorItemViewHolder2.i.getText());
                    im8 im8Var2 = this.e;
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder3 = this.a;
                    im8Var2.w0(pbTopCommenFloorItemViewHolder3.h, pbTopCommenFloorItemViewHolder3.k);
                } else {
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder4 = this.a;
                    pbTopCommenFloorItemViewHolder4.h.setText(pbTopCommenFloorItemViewHolder4.i.getText());
                    this.e.x0(this.a.k, false);
                }
                this.e.O(this.c, this.a, r, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ TbImageView c;
        public final /* synthetic */ im8 d;

        public m(im8 im8Var, TextView textView, TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im8Var, textView, tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = im8Var;
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
                        this.d.x0(this.c, false);
                    } else {
                        this.d.x0(this.c, true);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public im8(wp8 wp8Var, BdUniqueId bdUniqueId) {
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
        this.p = true;
        this.r = false;
        this.s = 0;
        this.t = null;
        this.u = new xf<>(new e(this), 6, 0);
        this.v = new xf<>(new f(this), 12, 0);
        this.w = new mj8(new g(this));
        if (wp8Var != null && wp8Var.L() != null) {
            this.q = wp8Var.L().v1();
        }
        s(R.dimen.tbds14);
    }

    public final void V(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) {
            if (!TextUtils.isEmpty(bc9Var.t()) && this.h && !k0()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.s.getLayoutParams();
                layoutParams.topMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                pbTopCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
                if (!TextUtils.isEmpty(bc9Var.x())) {
                    pbTopCommenFloorItemViewHolder.t.setVisibility(0);
                    pbTopCommenFloorItemViewHolder.t.k(fs4.a(bc9Var.x()));
                } else {
                    pbTopCommenFloorItemViewHolder.t.setVisibility(8);
                }
                pbTopCommenFloorItemViewHolder.r.p0(bc9Var.t());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.s.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbTopCommenFloorItemViewHolder.s.setLayoutParams(layoutParams2);
                pbTopCommenFloorItemViewHolder.r.setPadding(0, 0, 0, 0);
                pbTopCommenFloorItemViewHolder.r.p0(null);
                pbTopCommenFloorItemViewHolder.t.setVisibility(8);
            }
            pbTopCommenFloorItemViewHolder.r.setTextViewOnTouchListener(this.w);
            pbTopCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
        }
    }

    @Override // com.baidu.tieba.bl8, com.baidu.tieba.tm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        q0(i2, view2, viewGroup, (bc9) obj, (PbTopCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void W(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) && pbTopCommenFloorItemViewHolder != null && bc9Var != null && (imageView = pbTopCommenFloorItemViewHolder.M) != null && this.k != null) {
            imageView.setVisibility(8);
        }
    }

    public final void Y(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) && pbTopCommenFloorItemViewHolder != null && bc9Var != null) {
            ImageView imageView = pbTopCommenFloorItemViewHolder.a0;
            if (bc9Var.b0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void h0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) && pbTopCommenFloorItemViewHolder != null && bc9Var != null) {
            pbTopCommenFloorItemViewHolder.g(bc9Var.S, bc9Var.O(), this.r);
        }
    }

    public final void r0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) {
            TbRichText Z = bc9Var.Z();
            Z.isChanged = true;
            pbTopCommenFloorItemViewHolder.r.setText(Z, true, this.g);
        }
    }

    public final void w0(TextView textView, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, textView, tbImageView) == null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new m(this, textView, tbImageView));
        }
    }

    public final void A0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof bc9)) {
            return;
        }
        B0(textView, (bc9) tag);
    }

    public final void L(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbTopCommenFloorItemViewHolder) == null) {
            pbTopCommenFloorItemViewHolder.r.setTextViewOnTouchListener(this.n);
            pbTopCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
            pbTopCommenFloorItemViewHolder.t.setOnTouchListener(new d(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.h = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onLongClickListener) == null) {
            this.o = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void n(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, a0Var) == null) {
            this.m = a0Var;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.j = str;
        }
    }

    public void r(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, ki8Var) == null) {
            this.k = ki8Var;
        }
    }

    public void u0(mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, mj8Var) == null) {
            this.n = mj8Var;
        }
    }

    public void v0(TbRichTextView.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, uVar) == null) {
            this.g = uVar;
        }
    }

    public final void B0(TextView textView, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, bc9Var) == null) {
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

    public void z0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) {
            String str = "#7F66FE";
            if (bc9Var.o0() != null) {
                VirtualImageCustomFigure o0 = bc9Var.o0();
                pbTopCommenFloorItemViewHolder.m0.setHeadImageViewResource(o0.getFigureUrl());
                pbTopCommenFloorItemViewHolder.m0.setTid(bc9Var.O());
                pbTopCommenFloorItemViewHolder.m0.setLocate(qm8.c);
                pbTopCommenFloorItemViewHolder.m0.setFrom(5);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(o0.getBackGroundType())) {
                    str = o0.getBackgroundValue();
                    pbTopCommenFloorItemViewHolder.m0.setHeadImageBackgroundColorResource(o0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(o0.getBackGroundType())) {
                    pbTopCommenFloorItemViewHolder.m0.setHeadImageBackgroundResource(o0.getBackgroundValue());
                }
                pbTopCommenFloorItemViewHolder.m0.e(bc9Var.r());
                pbTopCommenFloorItemViewHolder.k0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.n0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.m0.setTag(R.id.tag_user_id, bc9Var.r().getUserId());
                pbTopCommenFloorItemViewHolder.m0.setTag(R.id.tag_user_name, bc9Var.r().getUserName());
                pbTopCommenFloorItemViewHolder.f();
                pbTopCommenFloorItemViewHolder.v0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.v0.playAnimation();
            } else {
                pbTopCommenFloorItemViewHolder.n0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.m0.setTag(R.id.tag_user_id, null);
                pbTopCommenFloorItemViewHolder.m0.setTag(R.id.tag_user_name, null);
                pbTopCommenFloorItemViewHolder.k0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.v0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.v0.pauseAnimation();
            }
            if (bc9Var.p0() != null && !TextUtils.isEmpty(bc9Var.p0().getIcon())) {
                pbTopCommenFloorItemViewHolder.l0.setData(bc9Var.p0(), false, str);
                pbTopCommenFloorItemViewHolder.l0.setVisibility(0);
                if (pbTopCommenFloorItemViewHolder.o0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbTopCommenFloorItemViewHolder.o0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbTopCommenFloorItemViewHolder.o0.setLayoutParams(marginLayoutParams);
                }
                pbTopCommenFloorItemViewHolder.l0.setTag(R.id.tag_user_id, bc9Var.r().getUserId());
                pbTopCommenFloorItemViewHolder.l0.setTag(R.id.tag_user_name, bc9Var.r().getUserName());
                this.s = qm8.d;
                this.t = pbTopCommenFloorItemViewHolder.l0.getData();
                pbTopCommenFloorItemViewHolder.m0.setWithBubble(this.s);
                pbTopCommenFloorItemViewHolder.m0.setBubbleName(this.t);
                pbTopCommenFloorItemViewHolder.m0.setVirtualHeadUid(bc9Var.r().getUserId());
            } else {
                if (pbTopCommenFloorItemViewHolder.o0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbTopCommenFloorItemViewHolder.o0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbTopCommenFloorItemViewHolder.o0.setLayoutParams(marginLayoutParams2);
                }
                pbTopCommenFloorItemViewHolder.l0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.l0.setTag(R.id.tag_user_name, null);
                pbTopCommenFloorItemViewHolder.l0.setTag(R.id.tag_user_id, null);
                int i2 = qm8.e;
                this.s = i2;
                pbTopCommenFloorItemViewHolder.m0.setWithBubble(i2);
            }
            if (pbTopCommenFloorItemViewHolder.m0.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.m0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (pbTopCommenFloorItemViewHolder.n0.getVisibility() == 0) {
                layoutParams.setMargins(0, hi.g(this.mContext, R.dimen.M_H_X005), 0, hi.g(this.mContext, R.dimen.tbds5));
            } else {
                layoutParams.setMargins(0, hi.g(this.mContext, R.dimen.M_H_X005), 0, hi.g(this.mContext, R.dimen.tbds_10));
            }
            pbTopCommenFloorItemViewHolder.p0.setLayoutParams(layoutParams);
            if (bc9Var.o0() != null && bc9Var.r() != null) {
                qm8.a(2, bc9Var.O(), qm8.c, this.s, this.t, bc9Var.r().getUserId());
            }
        }
    }

    public final void M(bc9 bc9Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bc9Var) == null) {
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
    /* renamed from: p0 */
    public PbTopCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d073e, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0919fe)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0735, (ViewGroup) null));
            PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder = new PbTopCommenFloorItemViewHolder(this.a.M().getPageContext(), inflate, this.q);
            pbTopCommenFloorItemViewHolder.u.setConstrainLayoutPool(this.u);
            pbTopCommenFloorItemViewHolder.u.setImageViewPool(this.v);
            y0(pbTopCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbTopCommenFloorItemViewHolder.r;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.p);
            }
            return pbTopCommenFloorItemViewHolder;
        }
        return (PbTopCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void s0(bc9 bc9Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bc9Var) == null) {
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

    public final void N(bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bc9Var) == null) && bc9Var.E == 0 && bc9Var.M) {
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
                s0(bc9Var);
            }
        }
    }

    public final void O(bc9 bc9Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048581, this, bc9Var, pbTopCommenFloorItemViewHolder, i2, i3) == null) {
            if (i2 > bc9Var.r0() + bc9Var.P()) {
                if (pbTopCommenFloorItemViewHolder.L != null && bc9Var.r() != null) {
                    pbTopCommenFloorItemViewHolder.L.setTag(R.id.tag_user_id, bc9Var.r().getUserId());
                    wp8 wp8Var = this.a;
                    if (wp8Var != null && wp8Var.M() != null) {
                        pbTopCommenFloorItemViewHolder.L.setOnClickListener(this.a.M().d.c);
                    }
                    ArrayList<IconData> iconInfo = bc9Var.r().getIconInfo();
                    int g2 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbTopCommenFloorItemViewHolder.L.h(iconInfo, i3, g2, g2, hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (bc9Var.b0().booleanValue() && !bc9Var.N()) {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(0);
                } else {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(8);
                }
            } else if (i2 > bc9Var.P()) {
                if (bc9Var.b0().booleanValue() && !bc9Var.N()) {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(0);
                } else {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(8);
                }
                pbTopCommenFloorItemViewHolder.L.setVisibility(8);
            } else {
                pbTopCommenFloorItemViewHolder.L.setVisibility(8);
                pbTopCommenFloorItemViewHolder.j.setVisibility(8);
            }
        }
    }

    public final void P(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int l2 = ((((hi.l(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                l2 = (l2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = s(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((l2 - i3) * this.i));
            tbRichTextView.getLayoutStrategy().J = (l2 - i3) - s(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().q((int) (l2 * 1.618f * this.i));
        }
    }

    public final void Q(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{pbTopCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbTopCommenFloorItemViewHolder.V.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbTopCommenFloorItemViewHolder.X.setText(R.string.obfuscated_res_0x7f0f0634);
                    return;
                } else {
                    pbTopCommenFloorItemViewHolder.X.setText(str);
                    return;
                }
            }
            pbTopCommenFloorItemViewHolder.V.setVisibility(0);
            pbTopCommenFloorItemViewHolder.X.setText(R.string.obfuscated_res_0x7f0f0425);
        }
    }

    public final void R(boolean z, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), pbTopCommenFloorItemViewHolder, bc9Var}) == null) && pbTopCommenFloorItemViewHolder != null && (linearLayout = pbTopCommenFloorItemViewHolder.W) != null && (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = true;
            boolean z3 = !ListUtils.isEmpty(bc9Var.d0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbTopCommenFloorItemViewHolder.W.getLayoutParams();
            if (z) {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().n(0);
                if (z3) {
                    pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().m(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams != null) {
                        layoutParams.topMargin = hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().m(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams != null) {
                        layoutParams.topMargin = 0;
                    }
                }
                pbTopCommenFloorItemViewHolder.W.setLayoutParams(layoutParams);
            } else {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().m(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().n(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            }
            if (pbTopCommenFloorItemViewHolder.l0.getVisibility() != 0 && pbTopCommenFloorItemViewHolder.s0.getVisibility() != 0) {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().k(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            } else {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().k(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            }
            wp9.b(bc9Var, pbTopCommenFloorItemViewHolder.r, (TextUtils.isEmpty(bc9Var.t()) || !this.h) ? false : false);
        }
    }

    public final void d0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048598, this, pbTopCommenFloorItemViewHolder, bc9Var, view2) == null) && pbTopCommenFloorItemViewHolder != null && bc9Var != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.s.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = hi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = hi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbTopCommenFloorItemViewHolder.r.setPadding(0, 0, 0, 0);
            if (!this.h) {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.icon_click);
            } else {
                pbTopCommenFloorItemViewHolder.r.p0(null);
                pbTopCommenFloorItemViewHolder.r.setBackgroundDrawable(null);
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.transparent_bg);
            }
            pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().z(R.drawable.pic_video);
            P(pbTopCommenFloorItemViewHolder.r, view2, !StringUtils.isNull(bc9Var.t()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbTopCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbTopCommenFloorItemViewHolder.r.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbTopCommenFloorItemViewHolder.r.setIsFromCDN(this.e);
            pbTopCommenFloorItemViewHolder.r.setTid(this.k.S());
            pbTopCommenFloorItemViewHolder.r.setPid(bc9Var.O());
            pbTopCommenFloorItemViewHolder.r.setPosition(TbRichTextView.Position.PB_COMMENT_FLOOR);
            pbTopCommenFloorItemViewHolder.r.setText(bc9Var.Z(), true, this.g);
            SparseArray sparseArray = (SparseArray) pbTopCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, bc9Var);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            sparseArray.put(R.id.tag_is_top_question, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbTopCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbTopCommenFloorItemViewHolder.e0.setTag(sparseArray);
            pbTopCommenFloorItemViewHolder.t.setTag(sparseArray);
        }
    }

    public final boolean S(bc9 bc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bc9Var)) == null) {
            if (this.k.Q() != null && this.k.Q().getAuthor() != null && this.k.Q().getAuthor().getUserId() != null && bc9Var != null && bc9Var.r() != null && bc9Var.r().getUserId() != null) {
                return this.k.Q().getAuthor().getUserId().equals(bc9Var.r().getUserId());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void U(bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bc9Var) == null) {
            if (bc9Var != null) {
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
            mp8.t("c14887");
        }
    }

    public final void T(View view2) {
        PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbTopCommenFloorItemViewHolder) && (agreeView = (pbTopCommenFloorItemViewHolder = (PbTopCommenFloorItemViewHolder) view2.getTag()).d0) != null && agreeView.getData() != null) {
            pbTopCommenFloorItemViewHolder.d0.setAgreeSource(2);
            pbTopCommenFloorItemViewHolder.d0.N();
        }
    }

    public final String m0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, view2)) == null) {
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

    public void o0(com.baidu.tbadk.data.MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mContext, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        boolean z;
        ki8 ki8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) && pbTopCommenFloorItemViewHolder != null && bc9Var != null) {
            String str = null;
            boolean z2 = true;
            if (bc9Var.r() != null) {
                str = bc9Var.r().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z = true;
                    oa5 V = bc9Var.V();
                    z2 = (V != null || StringUtils.isNull(V.b()) || (ki8Var = this.k) == null || ki8Var.l0()) ? false : false;
                    pbTopCommenFloorItemViewHolder.m.setVisibility(8);
                    if (z2 && !z) {
                        pbTopCommenFloorItemViewHolder.n.setVisibility(8);
                    } else {
                        pbTopCommenFloorItemViewHolder.n.setVisibility(0);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(bc9Var.k0()), "yyyy"))) {
                        pbTopCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTimeShort(bc9Var.k0()));
                    } else {
                        pbTopCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTime(bc9Var.k0()));
                    }
                    if (!z) {
                        pbTopCommenFloorItemViewHolder.o.setVisibility(0);
                        TextView textView = pbTopCommenFloorItemViewHolder.o;
                        textView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + str);
                    } else if (z2) {
                        pbTopCommenFloorItemViewHolder.o.setVisibility(0);
                        if (bc9Var.b0) {
                            pbTopCommenFloorItemViewHolder.o.setText(StringHelper.cutStringWithSuffix(V.b(), 7, StringHelper.STRING_MORE));
                        } else {
                            pbTopCommenFloorItemViewHolder.o.setText(V.b());
                        }
                    } else {
                        pbTopCommenFloorItemViewHolder.o.setVisibility(8);
                    }
                    TextView textView2 = pbTopCommenFloorItemViewHolder.g0;
                    textView2.setText(((Object) pbTopCommenFloorItemViewHolder.l.getText()) + "  • ");
                }
            }
            z = false;
            oa5 V2 = bc9Var.V();
            if (V2 != null) {
            }
            pbTopCommenFloorItemViewHolder.m.setVisibility(8);
            if (z2) {
            }
            pbTopCommenFloorItemViewHolder.n.setVisibility(0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(bc9Var.k0()), "yyyy"))) {
            }
            if (!z) {
            }
            TextView textView22 = pbTopCommenFloorItemViewHolder.g0;
            textView22.setText(((Object) pbTopCommenFloorItemViewHolder.l.getText()) + "  • ");
        }
    }

    public final void t0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048622, this, pbTopCommenFloorItemViewHolder, i2) == null) {
            pbTopCommenFloorItemViewHolder.c.setOnTouchListener(this.w);
            pbTopCommenFloorItemViewHolder.c.setOnLongClickListener(this.o);
            if (this.a.M() != null && this.a.M().getPageContext() != null && this.a.M().getPageContext().getOrignalPage() != null) {
                tn8 tn8Var = this.a.M().d;
                pbTopCommenFloorItemViewHolder.h.setOnClickListener(tn8Var.b);
                pbTopCommenFloorItemViewHolder.q.setOnClickListener(tn8Var.b);
                pbTopCommenFloorItemViewHolder.m0.setOnClickListener(tn8Var.d);
                pbTopCommenFloorItemViewHolder.l0.setOnClickListener(tn8Var.d);
                pbTopCommenFloorItemViewHolder.J.setOnClickListener(tn8Var.b);
                pbTopCommenFloorItemViewHolder.J.getHeadView().setOnClickListener(tn8Var.b);
                pbTopCommenFloorItemViewHolder.r.setOnLongClickListener(this.o);
                pbTopCommenFloorItemViewHolder.r.setOnTouchListener(this.w);
                pbTopCommenFloorItemViewHolder.r.setCommonTextViewOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.r.setOnImageClickListener(this.m);
                pbTopCommenFloorItemViewHolder.r.setOnImageTouchListener(this.w);
                pbTopCommenFloorItemViewHolder.r.setOnEmotionClickListener(tn8Var.f);
                pbTopCommenFloorItemViewHolder.r.setOnVoiceAfterClickListener(this.l);
                pbTopCommenFloorItemViewHolder.N.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.O.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.Q.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.p.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.e0.setOnClickListener(this.l);
                vn8 vn8Var = this.a.M().e;
                pbTopCommenFloorItemViewHolder.B.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.C.setOnClickListener(new a(this, pbTopCommenFloorItemViewHolder, vn8Var));
                pbTopCommenFloorItemViewHolder.d0.B = new b(this, pbTopCommenFloorItemViewHolder);
                pbTopCommenFloorItemViewHolder.d0.setAfterClickListener(new c(this, i2, pbTopCommenFloorItemViewHolder));
            }
        }
    }

    public final void Z(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048592, this, pbTopCommenFloorItemViewHolder, bc9Var, view2, i2) == null) && pbTopCommenFloorItemViewHolder != null && bc9Var != null) {
            pbTopCommenFloorItemViewHolder.v.setVisibility(8);
            pbTopCommenFloorItemViewHolder.c0.setVisibility(0);
            pbTopCommenFloorItemViewHolder.f0.setVisibility(8);
            i0(pbTopCommenFloorItemViewHolder, bc9Var, view2, i2);
            W(pbTopCommenFloorItemViewHolder, bc9Var);
            a0(pbTopCommenFloorItemViewHolder, bc9Var);
            d0(pbTopCommenFloorItemViewHolder, bc9Var, view2);
            X(pbTopCommenFloorItemViewHolder, bc9Var);
            f0(pbTopCommenFloorItemViewHolder, bc9Var);
            b0(pbTopCommenFloorItemViewHolder, bc9Var);
            z0(pbTopCommenFloorItemViewHolder, bc9Var);
            g0(pbTopCommenFloorItemViewHolder, bc9Var);
            V(pbTopCommenFloorItemViewHolder, bc9Var);
            Y(pbTopCommenFloorItemViewHolder, bc9Var);
            e0(pbTopCommenFloorItemViewHolder, bc9Var);
            h0(pbTopCommenFloorItemViewHolder, bc9Var);
            j0(pbTopCommenFloorItemViewHolder, bc9Var);
            c0(pbTopCommenFloorItemViewHolder, bc9Var);
        }
    }

    public final void a0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) && pbTopCommenFloorItemViewHolder != null && bc9Var != null && bc9Var.o() != null) {
            bc9Var.o().threadId = this.a.L().Q1();
            bc9Var.o().objType = 1;
            bc9Var.o().isInPost = true;
            ThreadData threadData = null;
            ki8 ki8Var = this.k;
            if (ki8Var != null && ki8Var.Q() != null) {
                threadData = this.k.Q();
            }
            pbTopCommenFloorItemViewHolder.d0.setThreadData(threadData);
            pbTopCommenFloorItemViewHolder.d0.setData(bc9Var.o());
        }
    }

    public final void b0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) && pbTopCommenFloorItemViewHolder != null && pbTopCommenFloorItemViewHolder.T != null && pbTopCommenFloorItemViewHolder.Q != null) {
            if (bc9Var != null && (alaLiveInfoCoreData = bc9Var.T) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbTopCommenFloorItemViewHolder.T.setText(bc9Var.T.liveTitle);
                pbTopCommenFloorItemViewHolder.Q.setTag(bc9Var.T);
                pbTopCommenFloorItemViewHolder.Q.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbTopCommenFloorItemViewHolder.Q.setVisibility(8);
        }
    }

    public final void g0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) {
            if (bc9Var.J() != 2 && bc9Var.J() != 4) {
                pbTopCommenFloorItemViewHolder.W.setVisibility(8);
                pbTopCommenFloorItemViewHolder.V.setVisibility(0);
                R(false, pbTopCommenFloorItemViewHolder, bc9Var);
            } else {
                pbTopCommenFloorItemViewHolder.W.setOnClickListener(new i(this, pbTopCommenFloorItemViewHolder, bc9Var));
                pbTopCommenFloorItemViewHolder.W.setVisibility(0);
                Q(pbTopCommenFloorItemViewHolder, bc9Var.w0(), bc9Var.I());
                R(true, pbTopCommenFloorItemViewHolder, bc9Var);
            }
            r0(pbTopCommenFloorItemViewHolder, bc9Var);
        }
    }

    public final void j0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) && pbTopCommenFloorItemViewHolder != null && WorldCupEnableSwitch.isOn() && bc9Var != null) {
            AgreeView agreeView = pbTopCommenFloorItemViewHolder.d0;
            if (agreeView != null) {
                agreeView.setAgreeAlone(true);
                pbTopCommenFloorItemViewHolder.d0.setPadding(0, 0, 0, 0);
            }
            TbImageView tbImageView = pbTopCommenFloorItemViewHolder.w0;
            if (tbImageView != null) {
                tbImageView.setVisibility(0);
                pbTopCommenFloorItemViewHolder.w0.setImageResource(R.drawable.obfuscated_res_0x7f080893);
                pbTopCommenFloorItemViewHolder.w0.setOnClickListener(new h(this, bc9Var));
            }
            HeadWorldCupFlagLayout headWorldCupFlagLayout = pbTopCommenFloorItemViewHolder.x0;
            if (headWorldCupFlagLayout != null) {
                headWorldCupFlagLayout.b(bc9Var.r());
            }
        }
    }

    public final void x0(TbImageView tbImageView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048626, this, tbImageView, z) != null) || tbImageView == null) {
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

    public final void c0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) {
            if (bc9Var.f0() != 0) {
                pbTopCommenFloorItemViewHolder.p.setVisibility(0);
                TextView textView = pbTopCommenFloorItemViewHolder.p;
                textView.setText("查看全部" + bc9Var.f0() + "条数据");
                return;
            }
            pbTopCommenFloorItemViewHolder.p.setVisibility(8);
        }
    }

    public final void e0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048600, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) && pbTopCommenFloorItemViewHolder != null && pbTopCommenFloorItemViewHolder.c != null) {
            wp8 wp8Var = this.a;
            if (wp8Var != null && wp8Var.L() != null && StringHelper.equals(this.a.L().X0(), bc9Var.O())) {
                SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final SpannableStringBuilder l0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, str, str2)) == null) {
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

    public final void f0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, bc9 bc9Var) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, pbTopCommenFloorItemViewHolder, bc9Var) == null) {
            if (bc9Var != null && bc9Var.g0() != null && bc9Var.r() != null && !k0()) {
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
                pbTopCommenFloorItemViewHolder.N.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbTopCommenFloorItemViewHolder.O.setTag(R.id.tag_pb_small_tail_theme_id, str);
                tq8.c(bc9Var.g0(), pbTopCommenFloorItemViewHolder.N, pbTopCommenFloorItemViewHolder.O, pbTopCommenFloorItemViewHolder.P, false, true, z, bc9Var.r().getSmallTailThemeData());
                return;
            }
            pbTopCommenFloorItemViewHolder.N.setVisibility(8);
            pbTopCommenFloorItemViewHolder.O.setVisibility(8);
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            ki8 ki8Var = this.k;
            if (ki8Var != null && ki8Var.Q() != null) {
                return this.k.Q().isQuestionThread();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            ki8 ki8Var = this.k;
            if (ki8Var != null && ki8Var.Q() != null) {
                return this.k.Q().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View q0(int i2, View view2, ViewGroup viewGroup, bc9 bc9Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, bc9Var, pbTopCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) bc9Var, (bc9) pbTopCommenFloorItemViewHolder);
            y0(pbTopCommenFloorItemViewHolder);
            t0(pbTopCommenFloorItemViewHolder, i2);
            L(pbTopCommenFloorItemViewHolder);
            bc9 bc9Var2 = (bc9) getItem(i2);
            if (bc9Var2 != null) {
                bc9Var2.d0 = i2 + 1;
                N(bc9Var2);
                M(bc9Var2);
                bc9Var2.o1();
                U(bc9Var2);
                Z(pbTopCommenFloorItemViewHolder, bc9Var2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, pbTopCommenFloorItemViewHolder) != null) || pbTopCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbTopCommenFloorItemViewHolder.a != skinType) {
            A0(pbTopCommenFloorItemViewHolder.j);
            boolean z = true;
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    mm8.F(pbTopCommenFloorItemViewHolder.h);
                } else {
                    n15.d(pbTopCommenFloorItemViewHolder.h).B(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.l, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.H, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.o, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.t0, R.color.CAM_X0105, 1);
            pbTopCommenFloorItemViewHolder.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbTopCommenFloorItemViewHolder.t.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.t.g(skinType);
            }
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h0, R.color.CAM_X0107, 1);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.getColor(R.color.CAM_X0304);
            pbTopCommenFloorItemViewHolder.u.b();
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.T, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.R, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.Q, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.S, R.color.CAM_X0109);
            SkinManager.setImageResource(pbTopCommenFloorItemViewHolder.U, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.X, (int) R.color.CAM_X0107);
            if (pbTopCommenFloorItemViewHolder.V.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbTopCommenFloorItemViewHolder.X.setText(R.string.obfuscated_res_0x7f0f0425);
            } else {
                ki8 ki8Var = this.k;
                if (ki8Var != null && StringUtils.isNull(ki8Var.k())) {
                    pbTopCommenFloorItemViewHolder.X.setText(this.k.k());
                } else {
                    pbTopCommenFloorItemViewHolder.X.setText(R.string.obfuscated_res_0x7f0f0634);
                }
            }
            pbTopCommenFloorItemViewHolder.c(skinType);
            WebPManager.setPureDrawable(pbTopCommenFloorItemViewHolder.e0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbTopCommenFloorItemViewHolder.b();
        }
        pbTopCommenFloorItemViewHolder.a = skinType;
    }
}
