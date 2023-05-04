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
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbTopCommenFloorItemViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.uw8;
import com.baidu.tieba.vh6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class nz8 extends jy8<pp9, PbTopCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView.u g;
    public boolean h;
    public float i;
    public String j;
    public qv8 k;
    public View.OnClickListener l;
    public TbRichTextView.a0 m;
    public uw8 n;
    public View.OnLongClickListener o;
    public boolean p;
    public int q;
    public boolean r;
    public int s;
    public String t;
    public xf<ConstrainImageLayout> u;
    public xf<TbImageView> v;
    public uw8 w;

    /* JADX WARN: Removed duplicated region for block: B:280:0x0805  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0809  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0812  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x081b  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x085e  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0865  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x08ce  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x08d8  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x091a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var, View view2, int i2) {
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048604, this, pbTopCommenFloorItemViewHolder, pp9Var, view2, i2) == null) || pbTopCommenFloorItemViewHolder == null || pp9Var == null) {
            return;
        }
        SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.e, R.color.CAM_X0204);
        pbTopCommenFloorItemViewHolder.e.setVisibility(0);
        pbTopCommenFloorItemViewHolder.q.setTag(null);
        pbTopCommenFloorItemViewHolder.q.setUserId(null);
        pbTopCommenFloorItemViewHolder.C.getHeadView().setUserId(null);
        pbTopCommenFloorItemViewHolder.r.setIsHost(false);
        if (pp9Var.p() != null) {
            String str = this.j;
            if (str != null && !str.equals("0") && this.j.equals(pp9Var.p().getUserId())) {
                pbTopCommenFloorItemViewHolder.r.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = pp9Var.p().getIconInfo();
            ArrayList<IconData> tShowInfoNew = pp9Var.p().getTShowInfoNew();
            int g2 = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            int g3 = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (iconInfo.size() < 2) {
                i3 = iconInfo.size();
                if (i3 > 1) {
                    pp9Var.m1((g2 * i3) + (g3 * i3));
                } else if (i3 == 1) {
                    pp9Var.m1(g2 + g3);
                } else {
                    pp9Var.m1(0);
                }
            } else {
                pp9Var.m1((g2 * 2) + (g3 * 2));
                i3 = 2;
            }
            if (pbTopCommenFloorItemViewHolder.D != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbTopCommenFloorItemViewHolder.D.setTag(tShowInfoNew.get(0).getUrl());
                }
                z29 z29Var = this.a;
                if (z29Var != null && z29Var.R() != null) {
                    pbTopCommenFloorItemViewHolder.D.setOnClickListener(this.a.R().c.e);
                }
                int g4 = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbTopCommenFloorItemViewHolder.D.h(tShowInfoNew, 3, g4, g4, ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !pp9Var.p().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        sz8.G(pbTopCommenFloorItemViewHolder.h);
                    } else {
                        g35.d(pbTopCommenFloorItemViewHolder.h).C(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0301, 1);
            }
            String avater = pp9Var.p().getAvater();
            int i5 = pp9Var.c0 ? 2 : 8;
            pbTopCommenFloorItemViewHolder.p.setTag(R.id.tag_pb_top_replay_more, pp9Var);
            pbTopCommenFloorItemViewHolder.p.setTag(R.id.tag_is_top_question, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_user_id, pp9Var.p().getUserId());
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_is_top_question, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_user_name, pp9Var.p().getUserName());
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_virtual_user_url, pp9Var.p().getVirtualUserUrl());
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_statistic_item, v29.i(this.k, pp9Var, pp9Var.d0, i5, 2));
            String name_show = pp9Var.p().getName_show();
            String userName = pp9Var.p().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbTopCommenFloorItemViewHolder.i.setText(su8.b(this.mContext, pbTopCommenFloorItemViewHolder.h.getText().toString()));
                pbTopCommenFloorItemViewHolder.h.setGravity(16);
                pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_nick_name_activity, su8.a());
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0312, 1);
            }
            if (pp9Var.p().getPendantData() != null && !StringUtils.isNull(pp9Var.p().getPendantData().getImgUrl())) {
                pbTopCommenFloorItemViewHolder.C.setBigVDimenSize(R.dimen.tbds36);
                pbTopCommenFloorItemViewHolder.C.i(pp9Var.p());
                pbTopCommenFloorItemViewHolder.q.setVisibility(8);
                pbTopCommenFloorItemViewHolder.C.setVisibility(0);
                pbTopCommenFloorItemViewHolder.C.getHeadView().N(avater, 28, false);
                pbTopCommenFloorItemViewHolder.C.getHeadView().setUserId(pp9Var.p().getUserId());
                pbTopCommenFloorItemViewHolder.C.getHeadView().setUserName(pp9Var.p().getUserName());
                qv8 qv8Var = this.k;
                pbTopCommenFloorItemViewHolder.C.getHeadView().setFid(qv8Var != null ? qv8Var.l() : "");
                qv8 qv8Var2 = this.k;
                pbTopCommenFloorItemViewHolder.C.getHeadView().setFName(qv8Var2 != null ? qv8Var2.m() : "");
                pbTopCommenFloorItemViewHolder.C.getHeadView().setFloor(pp9Var.D());
                pbTopCommenFloorItemViewHolder.C.getHeadView().setTid(pp9Var.N());
                pbTopCommenFloorItemViewHolder.C.getHeadView().setTag(R.id.tag_statistic_item, v29.i(this.k, pp9Var, pp9Var.d0, i5, 2));
                pbTopCommenFloorItemViewHolder.C.setTag(R.id.tag_is_top_question, Boolean.TRUE);
                pbTopCommenFloorItemViewHolder.C.i(pp9Var.p());
            } else {
                pbTopCommenFloorItemViewHolder.q.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbTopCommenFloorItemViewHolder.q, pp9Var.p(), 4);
                pbTopCommenFloorItemViewHolder.q.setUserId(pp9Var.p().getUserId());
                qv8 qv8Var3 = this.k;
                pbTopCommenFloorItemViewHolder.q.setFid(qv8Var3 != null ? qv8Var3.l() : "");
                qv8 qv8Var4 = this.k;
                pbTopCommenFloorItemViewHolder.q.setFName(qv8Var4 != null ? qv8Var4.m() : "");
                pbTopCommenFloorItemViewHolder.q.setFloor(pp9Var.D());
                pbTopCommenFloorItemViewHolder.q.setTid(pp9Var.N());
                pbTopCommenFloorItemViewHolder.q.setUserName(pp9Var.p().getUserName(), pp9Var.o0());
                pbTopCommenFloorItemViewHolder.q.setTag(R.id.tag_virtual_user_url, pp9Var.p().getVirtualUserUrl());
                pbTopCommenFloorItemViewHolder.q.setTag(R.id.tag_is_top_question, Boolean.TRUE);
                pbTopCommenFloorItemViewHolder.q.setTag(R.id.tag_statistic_item, v29.i(this.k, pp9Var, pp9Var.d0, i5, 2));
                pbTopCommenFloorItemViewHolder.q.setImageDrawable(null);
                pbTopCommenFloorItemViewHolder.q.N(avater, 28, false);
                pbTopCommenFloorItemViewHolder.q.setVisibility(0);
                pbTopCommenFloorItemViewHolder.C.setVisibility(8);
            }
            if (pp9Var.p() != null && pp9Var.p().getAlaInfo() != null && pp9Var.p().getAlaUserData() != null && pp9Var.p().getAlaUserData().live_status == 1) {
                pbTopCommenFloorItemViewHolder.d(true);
                pbTopCommenFloorItemViewHolder.q.setLiveStatus(1);
                pbTopCommenFloorItemViewHolder.q.setAlaInfo(pp9Var.p().getAlaInfo());
                pbTopCommenFloorItemViewHolder.C.getHeadView().setLiveStatus(1);
                pbTopCommenFloorItemViewHolder.C.getHeadView().setAlaInfo(pp9Var.p().getAlaInfo());
            } else {
                pbTopCommenFloorItemViewHolder.d(false);
                pbTopCommenFloorItemViewHolder.q.setLiveStatus(0);
                pbTopCommenFloorItemViewHolder.q.setAlaInfo(null);
                pbTopCommenFloorItemViewHolder.C.getHeadView().setLiveStatus(0);
                pbTopCommenFloorItemViewHolder.C.getHeadView().setAlaInfo(null);
            }
            B0(pbTopCommenFloorItemViewHolder.j, pp9Var);
            if (TbSingleton.getInstance().isUserGrowthOpen() && pp9Var.p().getUserGrowthData() != null) {
                int a2 = pp9Var.p().getUserGrowthData().a();
                if (a2 >= 0 && a2 <= 10) {
                    pbTopCommenFloorItemViewHolder.k.setImageResource(vw.b(a2));
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
        z29 z29Var2 = this.a;
        int level_id = (z29Var2 == null || z29Var2.R() == null || !this.a.R().z0() || pp9Var.p() == null) ? 0 : pp9Var.p().getLevel_id();
        qv8 qv8Var5 = this.k;
        if (qv8Var5 != null && qv8Var5.h0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbTopCommenFloorItemViewHolder.B.setVisibility(0);
            SkinManager.setImageResource(pbTopCommenFloorItemViewHolder.B, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbTopCommenFloorItemViewHolder.B.setVisibility(8);
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
        if (pbTopCommenFloorItemViewHolder.D.getChildCount() > 0) {
            i6 -= 2;
        }
        if (pp9Var.v() > 1000) {
            i6 -= 2;
        }
        if (pp9Var.v() > 10) {
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
            if (i6 < 10 && pbTopCommenFloorItemViewHolder.B.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.B.setVisibility(8);
            }
        }
        int k2 = sz8.k();
        String name_show2 = (pp9Var.p() == null || pp9Var.p().getName_show() == null) ? "" : pp9Var.p().getName_show();
        int e2 = cs5.e(name_show2);
        if (pp9Var.p() != null && !StringUtils.isNull(pp9Var.p().getSealPrefix())) {
            int i7 = k2 - 2;
            if (e2 > i7) {
                name_show2 = cs5.m(name_show2, i7) + StringHelper.STRING_MORE;
            }
        } else if (e2 > k2) {
            name_show2 = cs5.m(name_show2, k2) + StringHelper.STRING_MORE;
        }
        if (pp9Var.p() != null && !StringUtils.isNull(pp9Var.p().getSealPrefix())) {
            pbTopCommenFloorItemViewHolder.i.setText(l0(pp9Var.p().getSealPrefix(), name_show2));
        } else {
            pbTopCommenFloorItemViewHolder.i.setText(name_show2);
        }
        if (((pp9) getItem(i2)).R() == 1 && this.k.M() != null && this.k.M().isQuestionThread() && !S(pp9Var)) {
            ((pp9) getItem(i2)).Q0(true);
            pbTopCommenFloorItemViewHolder.j0.setVisibility(0);
            if (((pp9) getItem(i2)).Q().booleanValue()) {
                pbTopCommenFloorItemViewHolder.k0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.W.setVisibility(8);
                pbTopCommenFloorItemViewHolder.X.setVisibility(8);
                pbTopCommenFloorItemViewHolder.k0.postDelayed(new k(this, pbTopCommenFloorItemViewHolder), 3000L);
            } else {
                pbTopCommenFloorItemViewHolder.k0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.W.setVisibility(0);
                pbTopCommenFloorItemViewHolder.X.setVisibility(0);
            }
        } else {
            ((pp9) getItem(i2)).Q0(false);
            pbTopCommenFloorItemViewHolder.j0.setVisibility(8);
            pbTopCommenFloorItemViewHolder.k0.setVisibility(8);
            pbTopCommenFloorItemViewHolder.W.setVisibility(0);
            pbTopCommenFloorItemViewHolder.X.setVisibility(0);
        }
        ImageView imageView = pbTopCommenFloorItemViewHolder.x;
        if (imageView != null) {
            SparseArray sparseArray = (SparseArray) imageView.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbTopCommenFloorItemViewHolder.x.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, pp9Var);
        }
        ImageView imageView2 = pbTopCommenFloorItemViewHolder.y;
        if (imageView2 != null) {
            SparseArray sparseArray2 = (SparseArray) imageView2.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbTopCommenFloorItemViewHolder.y.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_load_sub_data, pp9Var);
        }
        SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.j0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.n0, R.color.CAM_X0105, 1);
        pbTopCommenFloorItemViewHolder.g.post(new l(this, pbTopCommenFloorItemViewHolder, new String[]{name_show2}, pp9Var, 2));
        if (!StringUtils.isNull(pp9Var.p().getDiplayIntro())) {
            i4 = 0;
            pbTopCommenFloorItemViewHolder.l0.setVisibility(0);
            pbTopCommenFloorItemViewHolder.l0.setText(pp9Var.p().getDiplayIntro() + "");
        } else {
            i4 = 0;
            pbTopCommenFloorItemViewHolder.l0.setVisibility(8);
        }
        SparseArray sparseArray3 = new SparseArray();
        sparseArray3.put(R.id.tag_clip_board, pp9Var);
        sparseArray3.put(R.id.tag_load_sub_data, pp9Var);
        sparseArray3.put(R.id.tag_load_sub_view, view2);
        sparseArray3.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray3.put(R.id.tag_pb_floor_number, Integer.valueOf(pp9Var.D()));
        sparseArray3.put(R.id.tag_forbid_user_post_id, pp9Var.N());
        sparseArray3.put(R.id.pb_dialog_item_zan_2, pbTopCommenFloorItemViewHolder.W);
        sparseArray3.put(R.id.pb_dialog_item_reply, pbTopCommenFloorItemViewHolder.x);
        sparseArray3.put(R.id.pb_dialog_item_share, pbTopCommenFloorItemViewHolder.y);
        qv8 qv8Var6 = this.k;
        ThreadData M = (qv8Var6 == null || qv8Var6.M() == null) ? null : this.k.M();
        if (M != null && M.isUgcThreadType()) {
            sparseArray3.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray3.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z7 = (pp9Var.p() == null || StringUtils.isNull(pp9Var.p().getVirtualUserUrl())) ? false : true;
        qv8 qv8Var7 = this.k;
        if (qv8Var7 == null || qv8Var7.U() == 0 || n0()) {
            z = false;
            z2 = false;
        } else {
            z = (this.k.U() == 1002 || this.k.U() == 3) ? false : true;
            z2 = (this.k.U() == 3 || this.k.h0()) ? false : true;
            if (pp9Var != null && pp9Var.p() != null) {
                String userId = pp9Var.p().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        qv8 qv8Var8 = this.k;
        if (qv8Var8 != null && qv8Var8.M() != null && this.k.M().getAuthor() != null && pp9Var.p() != null) {
            String userId2 = this.k.M().getAuthor().getUserId();
            String userId3 = pp9Var.p().getUserId();
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
                if (pp9Var != null && pp9Var.p() != null && UtilHelper.isCurrentAccount(pp9Var.p().getUserId())) {
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
                if (pp9Var.D() != 1) {
                    i4 = 1;
                }
                if (!z6) {
                    sparseArray3.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray3.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.U()));
                    if (pp9Var.p() != null) {
                        sparseArray3.put(R.id.tag_forbid_user_name, pp9Var.p().getUserName());
                        sparseArray3.put(R.id.tag_forbid_user_name_show, pp9Var.p().getName_show());
                        sparseArray3.put(R.id.tag_forbid_user_portrait, pp9Var.p().getPortrait());
                    }
                } else {
                    sparseArray3.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray3.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray3.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (pp9Var.p() != null) {
                        sparseArray3.put(R.id.tag_user_mute_mute_userid, pp9Var.p().getUserId());
                        sparseArray3.put(R.id.tag_user_mute_mute_username, pp9Var.p().getUserName());
                        sparseArray3.put(R.id.tag_user_mute_mute_nameshow, pp9Var.p().getName_show());
                    }
                    if (this.k.M() != null) {
                        sparseArray3.put(R.id.tag_user_mute_thread_id, this.k.M().getId());
                    }
                    sparseArray3.put(R.id.tag_user_mute_post_id, pp9Var.N());
                } else {
                    sparseArray3.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray3.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray3.put(R.id.tag_has_sub_post, Boolean.valueOf(pp9Var.v0()));
                    sparseArray3.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.U()));
                    sparseArray3.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                    sparseArray3.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                    sparseArray3.put(R.id.tag_del_post_id, pp9Var.N());
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
        if (pp9Var != null) {
            z2 = true;
            z4 = true;
        }
        if (z7) {
        }
        if (pp9Var.D() != 1) {
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

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder b;
        public final /* synthetic */ nz8 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* renamed from: com.baidu.tieba.nz8$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class View$OnClickListenerC0377a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0377a(a aVar) {
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
                        v29.t("c14886");
                        c cVar = this.a.a;
                        nz8 nz8Var = cVar.c;
                        nz8Var.o0(((pp9) nz8Var.getItem(cVar.a)).p());
                    }
                }
            }

            /* loaded from: classes5.dex */
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
                        ((pp9) cVar.c.getItem(cVar.a)).F0();
                        c cVar2 = this.a.a;
                        if (((pp9) cVar2.c.getItem(cVar2.a)).Z() <= 0) {
                            c cVar3 = this.a.a;
                            ((pp9) cVar3.c.getItem(cVar3.a)).W0(Boolean.FALSE);
                            this.a.a.b.k0.setVisibility(8);
                            this.a.a.b.W.setVisibility(0);
                            this.a.a.b.X.setVisibility(0);
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
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.b.W.getAgreeFlag()) {
                    return;
                }
                c cVar = this.a;
                ((pp9) cVar.c.getItem(cVar.a)).E0();
                c cVar2 = this.a;
                ((pp9) cVar2.c.getItem(cVar2.a)).W0(Boolean.TRUE);
                this.a.b.W.setVisibility(8);
                this.a.b.X.setVisibility(8);
                this.a.b.k0.setVisibility(0);
                this.a.b.k0.setOnClickListener(new View$OnClickListenerC0377a(this));
                this.a.b.k0.postDelayed(new b(this), 5000L);
            }
        }

        public c(nz8 nz8Var, int i, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz8Var, Integer.valueOf(i), pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nz8Var;
            this.a = i;
            this.b = pbTopCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !UtilHelper.isCurrentAccount(this.c.k.M().getAuthor().getUserId()) || !this.c.k.M().isQuestionThread() || UtilHelper.isCurrentAccount(((pp9) this.c.getItem(this.a)).p().getUserId())) {
                return;
            }
            if (this.b.W.getAgreeFlag()) {
                ((pp9) this.c.getItem(this.a)).X0(1);
                this.b.j0.setVisibility(0);
                ((pp9) this.c.getItem(this.a)).Q0(true);
                this.b.j.setVisibility(8);
                this.b.W.postDelayed(new a(this), 900L);
                return;
            }
            ((pp9) this.c.getItem(this.a)).X0(0);
            this.b.k0.setVisibility(8);
            this.b.j0.setVisibility(8);
            this.b.W.setVisibility(0);
            ((pp9) this.c.getItem(this.a)).Q0(false);
            if (((pp9) this.c.getItem(this.a)).c0().booleanValue()) {
                this.b.j.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ z09 b;
        public final /* synthetic */ nz8 c;

        /* renamed from: com.baidu.tieba.nz8$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0376a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ pp9 a;
            public final /* synthetic */ a b;

            public RunnableC0376a(a aVar, pp9 pp9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, pp9Var};
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
                this.a = pp9Var;
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

        public a(nz8 nz8Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, z09 z09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz8Var, pbTopCommenFloorItemViewHolder, z09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nz8Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = z09Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            pp9 pp9Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof pp9) && (pp9Var = (pp9) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b != null) {
                jg.a().postDelayed(new RunnableC0376a(this, pp9Var), 100L);
                String O = this.c.k.O();
                if ((StringUtils.isNull(O) || "0".equals(this.c.k.O())) && this.c.k.M() != null) {
                    O = this.c.k.M().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", O).param("fid", this.c.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", pp9Var.N()).param("obj_source", this.c.m0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ nz8 b;

        public b(nz8 nz8Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz8Var, pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nz8Var;
            this.a = pbTopCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbTopCommenFloorItemViewHolder = this.a) != null && (agreeView = pbTopCommenFloorItemViewHolder.W) != null && agreeView.getData() != null) {
                if (view2 == this.a.W.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String O = this.b.k.O();
                if ((StringUtils.isNull(O) || "0".equals(this.b.k.O())) && this.b.k.M() != null) {
                    O = this.b.k.M().getNid();
                }
                if (this.a.W.getData().hasAgree) {
                    i2 = 3;
                } else {
                    i2 = 4;
                }
                v29.s(i2);
                TiebaStatic.log(new StatisticItem("c13700").param("tid", O).param("fid", this.b.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.W.getData().postId).param("obj_source", this.b.m0(this.a.W)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz8 a;

        public d(nz8 nz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz8Var;
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

    /* loaded from: classes5.dex */
    public class e implements yf<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz8 a;

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

        public e(nz8 nz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz8Var;
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

    /* loaded from: classes5.dex */
    public class f implements yf<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz8 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public f(nz8 nz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz8Var;
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

    /* loaded from: classes5.dex */
    public class g implements uw8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz8 a;

        @Override // com.baidu.tieba.uw8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public g(nz8 nz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz8Var;
        }

        @Override // com.baidu.tieba.uw8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.n != null) {
                    if ((view2 instanceof TbListTextView) && this.a.l != null) {
                        this.a.l.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.I6(true);
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

        @Override // com.baidu.tieba.uw8.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || ((pbFragment = this.a.b) != null && pbFragment.I5() != null && !this.a.b.I5().K1())) {
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

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pp9 a;
        public final /* synthetic */ nz8 b;

        public h(nz8 nz8Var, pp9 pp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz8Var, pp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nz8Var;
            this.a = pp9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.p() != null && this.a.p().getPortrait() != null && !TextUtils.isEmpty(this.a.p().getPortrait())) {
                String str2 = null;
                if (this.a.q0() != null) {
                    str2 = this.a.q0().getFigureUrl();
                    str = this.a.q0().getBackgroundValue();
                } else {
                    str = null;
                }
                mx5.a(this.b.a.R().getPageContext(), this.a.p().getPortrait(), str2, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ pp9 b;
        public final /* synthetic */ nz8 c;

        public i(nz8 nz8Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz8Var, pbTopCommenFloorItemViewHolder, pp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nz8Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = pp9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.O.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.Q(this.a, !z, this.b.G());
                this.b.T0(!z);
                this.c.r0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.I5() != null && this.c.b.I5().n1() != null && this.c.b.I5().W0() != null && !z && this.a.getView().getTop() < this.c.b.I5().n1().getMeasuredHeight()) {
                    this.c.b.I5().W0().setSelectionFromTop(ListUtils.getPosition(this.c.b.I5().W0().getData(), this.b) + this.c.b.I5().W0().getHeaderViewsCount(), this.c.b.I5().n1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ nz8 b;

        public j(nz8 nz8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nz8Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 4, this.a);
            pt4.v(this.b.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;

        public k(nz8 nz8Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz8Var, pbTopCommenFloorItemViewHolder};
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
                this.a.k0.setVisibility(8);
                this.a.W.setVisibility(0);
                this.a.X.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ pp9 c;
        public final /* synthetic */ int d;
        public final /* synthetic */ nz8 e;

        public l(nz8 nz8Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, String[] strArr, pp9 pp9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz8Var, pbTopCommenFloorItemViewHolder, strArr, pp9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nz8Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = strArr;
            this.c = pp9Var;
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
                if (this.a.D.getVisibility() == 8) {
                    width = 0;
                } else {
                    width = this.a.D.getWidth() + sz8.c + sz8.b;
                }
                if (this.a.k.getVisibility() == 8) {
                    width2 = 0;
                } else {
                    width2 = this.a.k.getWidth() + sz8.b;
                }
                if (this.a.B.getVisibility() == 8) {
                    width3 = 0;
                } else {
                    width3 = this.a.B.getWidth() + sz8.b;
                }
                int p = sz8.p(measuredWidth, width, i, width2, width3, k0);
                if (p < 0 && !StringUtils.isNull(this.b[0])) {
                    this.a.h.setWidth(i + p);
                    z = true;
                } else {
                    this.a.h.setWidth(i);
                    z = false;
                }
                if (this.a.i.getText() == null) {
                    this.a.h.setText(this.b[0]);
                } else {
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder = this.a;
                    pbTopCommenFloorItemViewHolder.h.setText(pbTopCommenFloorItemViewHolder.i.getText());
                }
                if (z) {
                    nz8 nz8Var = this.e;
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder2 = this.a;
                    nz8Var.w0(pbTopCommenFloorItemViewHolder2.h, pbTopCommenFloorItemViewHolder2.k);
                } else {
                    this.e.x0(this.a.k, false);
                }
                this.e.O(this.c, this.a, p, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ TbImageView c;
        public final /* synthetic */ nz8 d;

        public m(nz8 nz8Var, TextView textView, TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz8Var, textView, tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nz8Var;
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
                boolean z = true;
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
                    nz8 nz8Var = this.d;
                    TbImageView tbImageView2 = this.c;
                    if (substring.length() % 2 == 0) {
                        z = false;
                    }
                    nz8Var.x0(tbImageView2, z);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nz8(z29 z29Var, BdUniqueId bdUniqueId) {
        super(z29Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z29Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((z29) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.w = new uw8(new g(this));
        if (z29Var != null && z29Var.Q() != null) {
            this.q = z29Var.Q().y1();
        }
    }

    public final void V(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) {
            if (!TextUtils.isEmpty(pp9Var.r()) && this.h && !k0()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.s.getLayoutParams();
                layoutParams.topMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                pbTopCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
                if (!TextUtils.isEmpty(pp9Var.x())) {
                    pbTopCommenFloorItemViewHolder.t.setVisibility(0);
                    pbTopCommenFloorItemViewHolder.t.k(ks4.a(pp9Var.x()));
                } else {
                    pbTopCommenFloorItemViewHolder.t.setVisibility(8);
                }
                pbTopCommenFloorItemViewHolder.r.p0(pp9Var.r());
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

    @Override // com.baidu.tieba.jy8, com.baidu.tieba.vm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        q0(i2, view2, viewGroup, (pp9) obj, (PbTopCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void W(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) && pbTopCommenFloorItemViewHolder != null && pp9Var != null && (imageView = pbTopCommenFloorItemViewHolder.F) != null && this.k != null) {
            imageView.setVisibility(8);
        }
    }

    public final void Y(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) && pbTopCommenFloorItemViewHolder != null && pp9Var != null) {
            ImageView imageView = pbTopCommenFloorItemViewHolder.T;
            if (pp9Var.b0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void h0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) && pbTopCommenFloorItemViewHolder != null && pp9Var != null) {
            pbTopCommenFloorItemViewHolder.g(pp9Var.S, pp9Var.N(), this.r);
        }
    }

    public final void r0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) {
            TbRichText a0 = pp9Var.a0();
            a0.isChanged = true;
            pbTopCommenFloorItemViewHolder.r.setText(a0, true, this.g);
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
        if (!(tag instanceof pp9)) {
            return;
        }
        B0(textView, (pp9) tag);
    }

    public final void K(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
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

    public void r(qv8 qv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, qv8Var) == null) {
            this.k = qv8Var;
        }
    }

    public void u0(uw8 uw8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, uw8Var) == null) {
            this.n = uw8Var;
        }
    }

    public void v0(TbRichTextView.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, uVar) == null) {
            this.g = uVar;
        }
    }

    public final void B0(TextView textView, pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, pp9Var) == null) {
            if (textView == null && pp9Var == null) {
                return;
            }
            textView.setTag(pp9Var);
            qv8 qv8Var = this.k;
            if (qv8Var != null && qv8Var.h0()) {
                pp9Var.e1(Boolean.FALSE);
                pp9Var.S0(0);
                textView.setTag(null);
            } else if (pp9Var.p() != null) {
                MetaData p = pp9Var.p();
                String str = this.j;
                if (str != null && !str.equals("0") && this.j.equals(p.getUserId())) {
                    pp9Var.e1(Boolean.TRUE);
                    pp9Var.S0(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    g35 d2 = g35.d(textView);
                    d2.o(R.string.J_X04);
                    d2.m(R.dimen.L_X01);
                    d2.w(R.color.CAM_X0302);
                    d2.l(R.color.CAM_X0302);
                } else if (p.getIs_bawu() == 1 && pp9Var.w0()) {
                    g35 d3 = g35.d(textView);
                    d3.w(R.color.CAM_X0101);
                    d3.o(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    pp9Var.e1(Boolean.TRUE);
                    pp9Var.S0(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.brand_official);
                } else if (p.getIs_bawu() == 1 && "manager".equals(p.getBawu_type())) {
                    g35 d4 = g35.d(textView);
                    d4.w(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    pp9Var.e1(Boolean.TRUE);
                    pp9Var.S0(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (p.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(p.getBawu_type())) {
                    g35 d5 = g35.d(textView);
                    d5.w(R.color.CAM_X0101);
                    d5.o(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    pp9Var.e1(Boolean.TRUE);
                    pp9Var.S0(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (p.getIs_bawu() == 1 && "pri_content_assist".equals(p.getBawu_type())) {
                    g35 d6 = g35.d(textView);
                    d6.w(R.color.CAM_X0101);
                    d6.o(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    pp9Var.e1(Boolean.TRUE);
                    pp9Var.S0(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (p.getIs_bawu() == 1 && "pri_manage_assist".equals(p.getBawu_type())) {
                    g35 d7 = g35.d(textView);
                    d7.w(R.color.CAM_X0101);
                    d7.o(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    pp9Var.e1(Boolean.TRUE);
                    pp9Var.S0(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    pp9Var.e1(Boolean.FALSE);
                    pp9Var.S0(0);
                }
            } else {
                pp9Var.e1(Boolean.FALSE);
                pp9Var.S0(0);
            }
        }
    }

    public void z0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) {
            String str = "#7F66FE";
            if (pp9Var.q0() != null) {
                VirtualImageCustomFigure q0 = pp9Var.q0();
                pbTopCommenFloorItemViewHolder.f0.setHeadImageViewResource(q0.getFigureUrl());
                pbTopCommenFloorItemViewHolder.f0.setTid(pp9Var.N());
                pbTopCommenFloorItemViewHolder.f0.setLocate(vz8.c);
                pbTopCommenFloorItemViewHolder.f0.setFrom(5);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(q0.getBackGroundType())) {
                    str = q0.getBackgroundValue();
                    pbTopCommenFloorItemViewHolder.f0.setHeadImageBackgroundColorResource(q0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(q0.getBackGroundType())) {
                    pbTopCommenFloorItemViewHolder.f0.setHeadImageBackgroundResource(q0.getBackgroundValue());
                }
                pbTopCommenFloorItemViewHolder.f0.e(pp9Var.p());
                pbTopCommenFloorItemViewHolder.d0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.g0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.f0.setTag(R.id.tag_user_id, pp9Var.p().getUserId());
                pbTopCommenFloorItemViewHolder.f0.setTag(R.id.tag_user_name, pp9Var.p().getUserName());
                pbTopCommenFloorItemViewHolder.f();
                pbTopCommenFloorItemViewHolder.o0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.o0.playAnimation();
            } else {
                pbTopCommenFloorItemViewHolder.g0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.f0.setTag(R.id.tag_user_id, null);
                pbTopCommenFloorItemViewHolder.f0.setTag(R.id.tag_user_name, null);
                pbTopCommenFloorItemViewHolder.d0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.o0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.o0.pauseAnimation();
            }
            if (pp9Var.r0() != null && !TextUtils.isEmpty(pp9Var.r0().getIcon())) {
                pbTopCommenFloorItemViewHolder.e0.setData(pp9Var.r0(), false, str);
                pbTopCommenFloorItemViewHolder.e0.setVisibility(0);
                if (pbTopCommenFloorItemViewHolder.h0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbTopCommenFloorItemViewHolder.h0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbTopCommenFloorItemViewHolder.h0.setLayoutParams(marginLayoutParams);
                }
                pbTopCommenFloorItemViewHolder.e0.setTag(R.id.tag_user_id, pp9Var.p().getUserId());
                pbTopCommenFloorItemViewHolder.e0.setTag(R.id.tag_user_name, pp9Var.p().getUserName());
                this.s = vz8.d;
                this.t = pbTopCommenFloorItemViewHolder.e0.getData();
                pbTopCommenFloorItemViewHolder.f0.setWithBubble(this.s);
                pbTopCommenFloorItemViewHolder.f0.setBubbleName(this.t);
                pbTopCommenFloorItemViewHolder.f0.setVirtualHeadUid(pp9Var.p().getUserId());
            } else {
                if (pbTopCommenFloorItemViewHolder.h0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbTopCommenFloorItemViewHolder.h0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbTopCommenFloorItemViewHolder.h0.setLayoutParams(marginLayoutParams2);
                }
                pbTopCommenFloorItemViewHolder.e0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.e0.setTag(R.id.tag_user_name, null);
                pbTopCommenFloorItemViewHolder.e0.setTag(R.id.tag_user_id, null);
                int i2 = vz8.e;
                this.s = i2;
                pbTopCommenFloorItemViewHolder.f0.setWithBubble(i2);
            }
            if (pbTopCommenFloorItemViewHolder.f0.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.f0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (pbTopCommenFloorItemViewHolder.g0.getVisibility() == 0) {
                layoutParams.setMargins(0, ii.g(this.mContext, R.dimen.M_H_X005), 0, ii.g(this.mContext, R.dimen.tbds5));
            } else {
                layoutParams.setMargins(0, ii.g(this.mContext, R.dimen.M_H_X005), 0, ii.g(this.mContext, R.dimen.tbds_10));
            }
            pbTopCommenFloorItemViewHolder.i0.setLayoutParams(layoutParams);
            if (pp9Var.q0() != null && pp9Var.p() != null) {
                vz8.a(2, pp9Var.N(), vz8.c, this.s, this.t, pp9Var.p().getUserId());
            }
        }
    }

    public final void M(pp9 pp9Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pp9Var) == null) {
            if (pp9Var != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", pp9Var.N());
                statisticItem.param("pid", pp9Var.N());
                statisticItem.param("tid", pp9Var.k0());
                statisticItem.param("fid", pp9Var.J());
                statisticItem.param("fname", pp9Var.K());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            qv8 qv8Var = this.k;
            if (qv8Var != null) {
                if (qv8Var.v0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                        qv8 qv8Var2 = this.k;
                        int i4 = pp9Var.d0;
                        if (pp9Var.c0) {
                            i3 = 2;
                        } else {
                            i3 = 8;
                        }
                        v29.e(uniqueId, qv8Var2, pp9Var, i4, i3, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                    qv8 qv8Var3 = this.k;
                    int i5 = pp9Var.d0;
                    if (pp9Var.c0) {
                        i2 = 2;
                    } else {
                        i2 = 8;
                    }
                    v29.e(uniqueId2, qv8Var3, pp9Var, i5, i2, "common_exp_source_pb_comment");
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: p0 */
    public PbTopCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0746, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091a06)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d073e, (ViewGroup) null));
            PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder = new PbTopCommenFloorItemViewHolder(this.a.R().getPageContext(), inflate, this.q);
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

    public final void s0(pp9 pp9Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, pp9Var) == null) {
            String userId = pp9Var.p().getUserId();
            qv8 qv8Var = this.k;
            String str2 = "";
            if (qv8Var == null) {
                str = "";
            } else {
                str = qv8Var.l();
            }
            qv8 qv8Var2 = this.k;
            if (qv8Var2 != null) {
                str2 = qv8Var2.m();
            }
            int D = pp9Var.D();
            String N = pp9Var.N();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", N);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, D);
            if (pp9Var.p().getAlaInfo() != null) {
                AlaInfoData alaInfo = pp9Var.p().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void N(pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, pp9Var) == null) && pp9Var.E == 0 && pp9Var.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", pp9Var.N());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            z29 z29Var = this.a;
            if (z29Var != null) {
                int y1 = z29Var.Q().y1();
                if (1 != y1 && 2 != y1) {
                    if (3 == y1) {
                        statisticItem.param("obj_source", "2");
                    } else {
                        statisticItem.param("obj_source", "0");
                    }
                } else {
                    statisticItem.param("obj_source", "1");
                }
            }
            TiebaStatic.log(statisticItem);
            if (pp9Var.p() != null && pp9Var.p().getAlaInfo() != null && pp9Var.p().getAlaInfo().live_status == 1) {
                s0(pp9Var);
            }
        }
    }

    public final void O(pp9 pp9Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048581, this, pp9Var, pbTopCommenFloorItemViewHolder, i2, i3) == null) {
            if (i2 > pp9Var.t0() + pp9Var.P()) {
                if (pbTopCommenFloorItemViewHolder.E != null && pp9Var.p() != null) {
                    pbTopCommenFloorItemViewHolder.E.setTag(R.id.tag_user_id, pp9Var.p().getUserId());
                    z29 z29Var = this.a;
                    if (z29Var != null && z29Var.R() != null) {
                        pbTopCommenFloorItemViewHolder.E.setOnClickListener(this.a.R().c.c);
                    }
                    ArrayList<IconData> iconInfo = pp9Var.p().getIconInfo();
                    int g2 = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbTopCommenFloorItemViewHolder.E.g(iconInfo, i3, g2, g2, ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (pp9Var.c0().booleanValue() && !pp9Var.M()) {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(0);
                } else {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(8);
                }
            } else if (i2 > pp9Var.P()) {
                if (pp9Var.c0().booleanValue() && !pp9Var.M()) {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(0);
                } else {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(8);
                }
                pbTopCommenFloorItemViewHolder.E.setVisibility(8);
            } else {
                pbTopCommenFloorItemViewHolder.E.setVisibility(8);
                pbTopCommenFloorItemViewHolder.j.setVisibility(8);
            }
        }
    }

    public final void P(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int l2 = ((((ii.l(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
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
                pbTopCommenFloorItemViewHolder.O.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbTopCommenFloorItemViewHolder.Q.setText(R.string.obfuscated_res_0x7f0f063b);
                    return;
                } else {
                    pbTopCommenFloorItemViewHolder.Q.setText(str);
                    return;
                }
            }
            pbTopCommenFloorItemViewHolder.O.setVisibility(0);
            pbTopCommenFloorItemViewHolder.Q.setText(R.string.obfuscated_res_0x7f0f042c);
        }
    }

    public final void R(boolean z, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), pbTopCommenFloorItemViewHolder, pp9Var}) == null) && pbTopCommenFloorItemViewHolder != null && (linearLayout = pbTopCommenFloorItemViewHolder.P) != null && (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = true;
            boolean z3 = !ListUtils.isEmpty(pp9Var.e0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbTopCommenFloorItemViewHolder.P.getLayoutParams();
            if (z) {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().n(0);
                if (z3) {
                    pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().m(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams != null) {
                        layoutParams.topMargin = ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().m(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams != null) {
                        layoutParams.topMargin = 0;
                    }
                }
                pbTopCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
            } else {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().m(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().n(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            }
            if (pbTopCommenFloorItemViewHolder.e0.getVisibility() != 0 && pbTopCommenFloorItemViewHolder.l0.getVisibility() != 0) {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().k(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            } else {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().k(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            }
            r3a.b(pp9Var, pbTopCommenFloorItemViewHolder.r, (TextUtils.isEmpty(pp9Var.r()) || !this.h) ? false : false);
        }
    }

    public final void d0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048598, this, pbTopCommenFloorItemViewHolder, pp9Var, view2) == null) && pbTopCommenFloorItemViewHolder != null && pp9Var != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.s.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = ii.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = ii.g(this.mContext, R.dimen.M_W_X007);
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
            P(pbTopCommenFloorItemViewHolder.r, view2, !StringUtils.isNull(pp9Var.r()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbTopCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbTopCommenFloorItemViewHolder.r.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbTopCommenFloorItemViewHolder.r.setIsFromCDN(this.e);
            pbTopCommenFloorItemViewHolder.r.setTid(this.k.O());
            pbTopCommenFloorItemViewHolder.r.setPid(pp9Var.N());
            pbTopCommenFloorItemViewHolder.r.setPosition(TbRichTextView.Position.PB_COMMENT_FLOOR);
            pbTopCommenFloorItemViewHolder.r.setText(pp9Var.a0(), true, this.g);
            SparseArray sparseArray = (SparseArray) pbTopCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, pp9Var);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            sparseArray.put(R.id.tag_is_top_question, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbTopCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbTopCommenFloorItemViewHolder.X.setTag(sparseArray);
            pbTopCommenFloorItemViewHolder.t.setTag(sparseArray);
        }
    }

    public final boolean S(pp9 pp9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, pp9Var)) == null) {
            if (this.k.M() != null && this.k.M().getAuthor() != null && this.k.M().getAuthor().getUserId() != null && pp9Var != null && pp9Var.p() != null && pp9Var.p().getUserId() != null) {
                return this.k.M().getAuthor().getUserId().equals(pp9Var.p().getUserId());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void U(pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pp9Var) == null) {
            if (pp9Var != null) {
                int i2 = 8;
                if (pp9Var.c0) {
                    i2 = 2;
                }
                StatisticItem i3 = v29.i(this.k, pp9Var, pp9Var.d0, i2, 6);
                pp9Var.e0 = i3;
                if (!ListUtils.isEmpty(pp9Var.e0())) {
                    Iterator<pp9> it = pp9Var.e0().iterator();
                    while (it.hasNext()) {
                        it.next().e0 = i3;
                    }
                }
            }
            v29.t("c14887");
        }
    }

    public final void T(View view2) {
        PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbTopCommenFloorItemViewHolder) && (agreeView = (pbTopCommenFloorItemViewHolder = (PbTopCommenFloorItemViewHolder) view2.getTag()).W) != null && agreeView.getData() != null) {
            pbTopCommenFloorItemViewHolder.W.setAgreeSource(2);
            pbTopCommenFloorItemViewHolder.W.N();
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
    public final void X(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        boolean z;
        qv8 qv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) && pbTopCommenFloorItemViewHolder != null && pp9Var != null) {
            String str = null;
            boolean z2 = true;
            if (pp9Var.p() != null) {
                str = pp9Var.p().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z = true;
                    kc5 V = pp9Var.V();
                    z2 = (V != null || StringUtils.isNull(V.b()) || (qv8Var = this.k) == null || qv8Var.h0()) ? false : false;
                    pbTopCommenFloorItemViewHolder.m.setVisibility(8);
                    if (z2 && !z) {
                        pbTopCommenFloorItemViewHolder.n.setVisibility(8);
                    } else {
                        pbTopCommenFloorItemViewHolder.n.setVisibility(0);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(pp9Var.l0()), "yyyy"))) {
                        pbTopCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTimeShort(pp9Var.l0()));
                    } else {
                        pbTopCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTime(pp9Var.l0()));
                    }
                    if (!z) {
                        pbTopCommenFloorItemViewHolder.o.setVisibility(0);
                        TextView textView = pbTopCommenFloorItemViewHolder.o;
                        textView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + str);
                    } else if (z2) {
                        pbTopCommenFloorItemViewHolder.o.setVisibility(0);
                        if (pp9Var.b0) {
                            pbTopCommenFloorItemViewHolder.o.setText(StringHelper.cutStringWithSuffix(V.b(), 7, StringHelper.STRING_MORE));
                        } else {
                            pbTopCommenFloorItemViewHolder.o.setText(V.b());
                        }
                    } else {
                        pbTopCommenFloorItemViewHolder.o.setVisibility(8);
                    }
                    TextView textView2 = pbTopCommenFloorItemViewHolder.Z;
                    textView2.setText(((Object) pbTopCommenFloorItemViewHolder.l.getText()) + "  • ");
                }
            }
            z = false;
            kc5 V2 = pp9Var.V();
            if (V2 != null) {
            }
            pbTopCommenFloorItemViewHolder.m.setVisibility(8);
            if (z2) {
            }
            pbTopCommenFloorItemViewHolder.n.setVisibility(0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(pp9Var.l0()), "yyyy"))) {
            }
            if (!z) {
            }
            TextView textView22 = pbTopCommenFloorItemViewHolder.Z;
            textView22.setText(((Object) pbTopCommenFloorItemViewHolder.l.getText()) + "  • ");
        }
    }

    public final void t0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048622, this, pbTopCommenFloorItemViewHolder, i2) == null) {
            pbTopCommenFloorItemViewHolder.c.setOnTouchListener(this.w);
            pbTopCommenFloorItemViewHolder.c.setOnLongClickListener(this.o);
            if (this.a.R() != null && this.a.R().getPageContext() != null && this.a.R().getPageContext().getOrignalPage() != null) {
                x09 x09Var = this.a.R().c;
                pbTopCommenFloorItemViewHolder.h.setOnClickListener(x09Var.b);
                pbTopCommenFloorItemViewHolder.q.setOnClickListener(x09Var.b);
                pbTopCommenFloorItemViewHolder.f0.setOnClickListener(x09Var.d);
                pbTopCommenFloorItemViewHolder.e0.setOnClickListener(x09Var.d);
                pbTopCommenFloorItemViewHolder.C.setOnClickListener(x09Var.b);
                pbTopCommenFloorItemViewHolder.C.getHeadView().setOnClickListener(x09Var.b);
                pbTopCommenFloorItemViewHolder.r.setOnLongClickListener(this.o);
                pbTopCommenFloorItemViewHolder.r.setOnTouchListener(this.w);
                pbTopCommenFloorItemViewHolder.r.setCommonTextViewOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.r.setOnImageClickListener(this.m);
                pbTopCommenFloorItemViewHolder.r.setOnImageTouchListener(this.w);
                pbTopCommenFloorItemViewHolder.r.setOnEmotionClickListener(x09Var.f);
                pbTopCommenFloorItemViewHolder.r.setOnVoiceAfterClickListener(this.l);
                pbTopCommenFloorItemViewHolder.G.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.H.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.J.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.p.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.X.setOnClickListener(this.l);
                z09 z09Var = this.a.R().d;
                pbTopCommenFloorItemViewHolder.x.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.y.setOnClickListener(new a(this, pbTopCommenFloorItemViewHolder, z09Var));
                pbTopCommenFloorItemViewHolder.W.B = new b(this, pbTopCommenFloorItemViewHolder);
                pbTopCommenFloorItemViewHolder.W.setAfterClickListener(new c(this, i2, pbTopCommenFloorItemViewHolder));
            }
        }
    }

    public final void Z(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048592, this, pbTopCommenFloorItemViewHolder, pp9Var, view2, i2) == null) && pbTopCommenFloorItemViewHolder != null && pp9Var != null) {
            pbTopCommenFloorItemViewHolder.v.setVisibility(8);
            pbTopCommenFloorItemViewHolder.V.setVisibility(0);
            pbTopCommenFloorItemViewHolder.Y.setVisibility(8);
            i0(pbTopCommenFloorItemViewHolder, pp9Var, view2, i2);
            W(pbTopCommenFloorItemViewHolder, pp9Var);
            a0(pbTopCommenFloorItemViewHolder, pp9Var);
            d0(pbTopCommenFloorItemViewHolder, pp9Var, view2);
            X(pbTopCommenFloorItemViewHolder, pp9Var);
            f0(pbTopCommenFloorItemViewHolder, pp9Var);
            b0(pbTopCommenFloorItemViewHolder, pp9Var);
            z0(pbTopCommenFloorItemViewHolder, pp9Var);
            g0(pbTopCommenFloorItemViewHolder, pp9Var);
            V(pbTopCommenFloorItemViewHolder, pp9Var);
            Y(pbTopCommenFloorItemViewHolder, pp9Var);
            e0(pbTopCommenFloorItemViewHolder, pp9Var);
            h0(pbTopCommenFloorItemViewHolder, pp9Var);
            j0(pbTopCommenFloorItemViewHolder, pp9Var);
            c0(pbTopCommenFloorItemViewHolder, pp9Var);
        }
    }

    public final void a0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) && pbTopCommenFloorItemViewHolder != null && pp9Var != null && pp9Var.n() != null) {
            pp9Var.n().threadId = this.a.Q().S1();
            pp9Var.n().objType = 1;
            pp9Var.n().isInPost = true;
            ThreadData threadData = null;
            qv8 qv8Var = this.k;
            if (qv8Var != null && qv8Var.M() != null) {
                threadData = this.k.M();
            }
            pbTopCommenFloorItemViewHolder.W.setThreadData(threadData);
            pbTopCommenFloorItemViewHolder.W.setData(pp9Var.n());
        }
    }

    public final void b0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) && pbTopCommenFloorItemViewHolder != null && pbTopCommenFloorItemViewHolder.M != null && pbTopCommenFloorItemViewHolder.J != null) {
            if (pp9Var != null && (alaLiveInfoCoreData = pp9Var.T) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbTopCommenFloorItemViewHolder.M.setText(pp9Var.T.liveTitle);
                pbTopCommenFloorItemViewHolder.J.setTag(pp9Var.T);
                pbTopCommenFloorItemViewHolder.J.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbTopCommenFloorItemViewHolder.J.setVisibility(8);
        }
    }

    public final void g0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) {
            if (pp9Var.I() != 2 && pp9Var.I() != 4) {
                pbTopCommenFloorItemViewHolder.P.setVisibility(8);
                pbTopCommenFloorItemViewHolder.O.setVisibility(0);
                R(false, pbTopCommenFloorItemViewHolder, pp9Var);
            } else {
                pbTopCommenFloorItemViewHolder.P.setOnClickListener(new i(this, pbTopCommenFloorItemViewHolder, pp9Var));
                pbTopCommenFloorItemViewHolder.P.setVisibility(0);
                Q(pbTopCommenFloorItemViewHolder, pp9Var.y0(), pp9Var.G());
                R(true, pbTopCommenFloorItemViewHolder, pp9Var);
            }
            r0(pbTopCommenFloorItemViewHolder, pp9Var);
        }
    }

    public final void j0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) && pbTopCommenFloorItemViewHolder != null && WorldCupEnableSwitch.isOn() && pp9Var != null) {
            AgreeView agreeView = pbTopCommenFloorItemViewHolder.W;
            if (agreeView != null) {
                agreeView.setAgreeAlone(true);
                pbTopCommenFloorItemViewHolder.W.setPadding(0, 0, 0, 0);
            }
            TbImageView tbImageView = pbTopCommenFloorItemViewHolder.p0;
            if (tbImageView != null) {
                tbImageView.setVisibility(0);
                pbTopCommenFloorItemViewHolder.p0.setImageResource(R.drawable.obfuscated_res_0x7f0808b1);
                pbTopCommenFloorItemViewHolder.p0.setOnClickListener(new h(this, pp9Var));
            }
            HeadWorldCupFlagLayout headWorldCupFlagLayout = pbTopCommenFloorItemViewHolder.q0;
            if (headWorldCupFlagLayout != null) {
                headWorldCupFlagLayout.b(pp9Var.p());
            }
        }
    }

    public final void x0(TbImageView tbImageView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048626, this, tbImageView, z) != null) || tbImageView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        if (z) {
            layoutParams.setMargins(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds_16), ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
        } else {
            layoutParams.setMargins(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
        }
        tbImageView.setLayoutParams(layoutParams);
    }

    public final void c0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) {
            if (pp9Var.g0() != 0) {
                pbTopCommenFloorItemViewHolder.p.setVisibility(0);
                TextView textView = pbTopCommenFloorItemViewHolder.p;
                textView.setText("查看全部" + pp9Var.g0() + "条数据");
                return;
            }
            pbTopCommenFloorItemViewHolder.p.setVisibility(8);
        }
    }

    public final void e0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048600, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) && pbTopCommenFloorItemViewHolder != null && pbTopCommenFloorItemViewHolder.c != null) {
            z29 z29Var = this.a;
            if (z29Var != null && z29Var.Q() != null && StringHelper.equals(this.a.Q().a1(), pp9Var.N())) {
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
                arrayList.add(new vh6.a(str, R.drawable.pic_smalldot_title));
                return vh6.h(this.a.R(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final void f0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, pp9 pp9Var) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, pbTopCommenFloorItemViewHolder, pp9Var) == null) {
            if (pp9Var != null && pp9Var.h0() != null && pp9Var.p() != null && !k0()) {
                TbRichText a0 = pp9Var.a0();
                if (a0 != null && StringUtils.isNull(a0.toString()) && StringUtils.isNull(pp9Var.r())) {
                    z = true;
                } else {
                    z = false;
                }
                if (pp9Var.p().getSmallTailThemeData() != null) {
                    str = pp9Var.p().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbTopCommenFloorItemViewHolder.G.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbTopCommenFloorItemViewHolder.H.setTag(R.id.tag_pb_small_tail_theme_id, str);
                k39.c(pp9Var.h0(), pbTopCommenFloorItemViewHolder.G, pbTopCommenFloorItemViewHolder.H, pbTopCommenFloorItemViewHolder.I, false, true, z, pp9Var.p().getSmallTailThemeData());
                return;
            }
            pbTopCommenFloorItemViewHolder.G.setVisibility(8);
            pbTopCommenFloorItemViewHolder.H.setVisibility(8);
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            qv8 qv8Var = this.k;
            if (qv8Var != null && qv8Var.M() != null) {
                return this.k.M().isQuestionThread();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            qv8 qv8Var = this.k;
            if (qv8Var != null && qv8Var.M() != null) {
                return this.k.M().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View q0(int i2, View view2, ViewGroup viewGroup, pp9 pp9Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, pp9Var, pbTopCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) pp9Var, (pp9) pbTopCommenFloorItemViewHolder);
            y0(pbTopCommenFloorItemViewHolder);
            t0(pbTopCommenFloorItemViewHolder, i2);
            K(pbTopCommenFloorItemViewHolder);
            pp9 pp9Var2 = (pp9) getItem(i2);
            if (pp9Var2 != null) {
                pp9Var2.d0 = i2 + 1;
                N(pp9Var2);
                M(pp9Var2);
                pp9Var2.r1();
                U(pp9Var2);
                Z(pbTopCommenFloorItemViewHolder, pp9Var2, view2, i2);
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
                    sz8.G(pbTopCommenFloorItemViewHolder.h);
                } else {
                    g35.d(pbTopCommenFloorItemViewHolder.h).C(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.l, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.A, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.o, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.m0, R.color.CAM_X0105, 1);
            pbTopCommenFloorItemViewHolder.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbTopCommenFloorItemViewHolder.t.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.t.g(skinType);
            }
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.Z, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.a0, R.color.CAM_X0107, 1);
            pbTopCommenFloorItemViewHolder.u.b();
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.M, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.K, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.J, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.L, R.color.CAM_X0109);
            SkinManager.setImageResource(pbTopCommenFloorItemViewHolder.N, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.Q, (int) R.color.CAM_X0107);
            if (pbTopCommenFloorItemViewHolder.O.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbTopCommenFloorItemViewHolder.Q.setText(R.string.obfuscated_res_0x7f0f042c);
            } else {
                qv8 qv8Var = this.k;
                if (qv8Var != null && StringUtils.isNull(qv8Var.j())) {
                    pbTopCommenFloorItemViewHolder.Q.setText(this.k.j());
                } else {
                    pbTopCommenFloorItemViewHolder.Q.setText(R.string.obfuscated_res_0x7f0f063b);
                }
            }
            pbTopCommenFloorItemViewHolder.c(skinType);
            WebPManager.setPureDrawable(pbTopCommenFloorItemViewHolder.X, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbTopCommenFloorItemViewHolder.b();
        }
        pbTopCommenFloorItemViewHolder.a = skinType;
    }
}
