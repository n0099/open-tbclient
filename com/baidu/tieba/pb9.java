package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
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
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
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
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.WorldCupEnableSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.ba9;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class pb9 extends rb9<n4a, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ba9 A;
    public boolean B;
    public TbRichTextView.t g;
    public boolean h;
    public float i;
    public String j;
    public u89 k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public TbRichTextView.z n;
    public ba9 o;
    public View.OnLongClickListener p;
    public ag9 q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public String x;
    public mg<ConstrainImageLayout> y;
    public mg<TbImageView> z;

    /* JADX WARN: Removed duplicated region for block: B:217:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x06b0  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x06f3  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x06fd  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0763  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x076d  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x07ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar, View view2, int i2) {
        ThreadData threadData;
        String str;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048602, this, pbCommenFloorItemViewHolder, n4aVar, view2, i2) == null) || pbCommenFloorItemViewHolder == null || n4aVar == null) {
            return;
        }
        if (n4aVar.R) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.e.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.e.setVisibility(8);
        }
        pbCommenFloorItemViewHolder.q.setTag(null);
        pbCommenFloorItemViewHolder.q.setUserId(null);
        pbCommenFloorItemViewHolder.F.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.r.setIsHost(false);
        if (n4aVar.q() != null) {
            String str2 = this.j;
            if (str2 != null && !str2.equals("0") && this.j.equals(n4aVar.q().getUserId())) {
                pbCommenFloorItemViewHolder.r.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = n4aVar.q().getIconInfo();
            ArrayList<IconData> tShowInfoNew = n4aVar.q().getTShowInfoNew();
            int g2 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            int g3 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (iconInfo.size() < 2) {
                int size = iconInfo.size();
                if (size > 1) {
                    n4aVar.t1((g2 * size) + (g3 * size));
                } else if (size == 1) {
                    n4aVar.t1(g2 + g3);
                } else {
                    n4aVar.t1(0);
                }
            } else {
                n4aVar.t1((g2 * 2) + (g3 * 2));
            }
            if (pbCommenFloorItemViewHolder.G != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.G.setTag(tShowInfoNew.get(0).getUrl());
                }
                vg9 vg9Var = this.a;
                if (vg9Var != null && vg9Var.V() != null) {
                    pbCommenFloorItemViewHolder.G.setOnClickListener(this.a.V().c.e);
                }
                int g4 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.G.h(tShowInfoNew, 3, g4, g4, xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !n4aVar.q().isBigV()) {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
            }
            String avater = n4aVar.q().getAvater();
            int i4 = n4aVar.d0 ? 2 : 8;
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_id, n4aVar.q().getUserId());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, n4aVar.q().getUserName());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, n4aVar.q().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, rg9.i(this.k, n4aVar, n4aVar.e0, i4, 2));
            String name_show = n4aVar.q().getName_show();
            String userName = n4aVar.q().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.h.setText(v79.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                pbCommenFloorItemViewHolder.g.setGravity(16);
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, v79.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
            }
            if (n4aVar.q().getPendantData() != null && !StringUtils.isNull(n4aVar.q().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.F.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.F.i(n4aVar.q());
                pbCommenFloorItemViewHolder.q.setVisibility(8);
                pbCommenFloorItemViewHolder.F.setVisibility(0);
                pbCommenFloorItemViewHolder.F.getHeadView().N(avater, 28, false);
                pbCommenFloorItemViewHolder.F.getHeadView().setUserId(n4aVar.q().getUserId());
                pbCommenFloorItemViewHolder.F.getHeadView().setUserName(n4aVar.q().getUserName());
                u89 u89Var = this.k;
                pbCommenFloorItemViewHolder.F.getHeadView().setFid(u89Var != null ? u89Var.l() : "");
                u89 u89Var2 = this.k;
                pbCommenFloorItemViewHolder.F.getHeadView().setFName(u89Var2 != null ? u89Var2.m() : "");
                pbCommenFloorItemViewHolder.F.getHeadView().setFloor(n4aVar.I());
                pbCommenFloorItemViewHolder.F.getHeadView().setTid(n4aVar.S());
                pbCommenFloorItemViewHolder.F.getHeadView().setTag(R.id.tag_statistic_item, rg9.i(this.k, n4aVar, n4aVar.e0, i4, 2));
                pbCommenFloorItemViewHolder.F.i(n4aVar.q());
            } else {
                pbCommenFloorItemViewHolder.q.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.q, n4aVar.q(), 4);
                pbCommenFloorItemViewHolder.q.setUserId(n4aVar.q().getUserId());
                u89 u89Var3 = this.k;
                pbCommenFloorItemViewHolder.q.setFid(u89Var3 != null ? u89Var3.l() : "");
                u89 u89Var4 = this.k;
                pbCommenFloorItemViewHolder.q.setFName(u89Var4 != null ? u89Var4.m() : "");
                pbCommenFloorItemViewHolder.q.setFloor(n4aVar.I());
                pbCommenFloorItemViewHolder.q.setTid(n4aVar.S());
                pbCommenFloorItemViewHolder.q.setUserName(n4aVar.q().getUserName(), n4aVar.s0());
                pbCommenFloorItemViewHolder.q.setTag(R.id.tag_virtual_user_url, n4aVar.q().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.q.setTag(R.id.tag_statistic_item, rg9.i(this.k, n4aVar, n4aVar.e0, i4, 2));
                pbCommenFloorItemViewHolder.q.setImageDrawable(null);
                pbCommenFloorItemViewHolder.q.N(avater, 28, false);
                pbCommenFloorItemViewHolder.q.setVisibility(0);
                pbCommenFloorItemViewHolder.F.setVisibility(8);
            }
            if (n4aVar.q() != null && n4aVar.q().getAlaInfo() != null && n4aVar.q().getAlaUserData() != null && n4aVar.q().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.d(true);
                pbCommenFloorItemViewHolder.q.setLiveStatus(1);
                pbCommenFloorItemViewHolder.q.setAlaInfo(n4aVar.q().getAlaInfo());
                pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(n4aVar.q().getAlaInfo());
                threadData = null;
            } else {
                pbCommenFloorItemViewHolder.d(false);
                pbCommenFloorItemViewHolder.q.setLiveStatus(0);
                threadData = null;
                pbCommenFloorItemViewHolder.q.setAlaInfo(null);
                pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(null);
            }
            x0(pbCommenFloorItemViewHolder.i, n4aVar);
            if (TbSingleton.getInstance().isUserGrowthOpen() && n4aVar.q().getUserGrowthData() != null) {
                int a2 = n4aVar.q().getUserGrowthData().a();
                if (a2 >= 0 && a2 <= 10) {
                    pbCommenFloorItemViewHolder.j.setImageResource(ay.b(a2));
                    pbCommenFloorItemViewHolder.j.setVisibility(0);
                    pbCommenFloorItemViewHolder.j.setOnClickListener(new n(this, a2));
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 4, a2);
                } else {
                    pbCommenFloorItemViewHolder.j.setVisibility(8);
                }
            }
        } else {
            threadData = null;
        }
        vg9 vg9Var2 = this.a;
        if (vg9Var2 == null || vg9Var2.V() == null || !this.a.V().z0() || n4aVar.q() == null) {
            str = "";
            i3 = 0;
        } else {
            i3 = n4aVar.q().getLevel_id();
            str = n4aVar.q().getLevelName();
        }
        u89 u89Var5 = this.k;
        if (u89Var5 != null && u89Var5.i0()) {
            i3 = 0;
        }
        if (i3 > 0) {
            pbCommenFloorItemViewHolder.E.setVisibility(0);
            pbCommenFloorItemViewHolder.E.setLevel(i3, str);
        } else {
            pbCommenFloorItemViewHolder.E.setVisibility(8);
        }
        if (((n4a) getItem(i2)).V() == 1 && this.k.N() != null && this.k.N().isQuestionThread() && !O(n4aVar)) {
            ((n4a) getItem(i2)).X0(true);
            pbCommenFloorItemViewHolder.y0.setVisibility(0);
            if (((n4a) getItem(i2)).U().booleanValue()) {
                pbCommenFloorItemViewHolder.z0.setVisibility(0);
                pbCommenFloorItemViewHolder.d0.setVisibility(8);
                pbCommenFloorItemViewHolder.e0.setVisibility(8);
                pbCommenFloorItemViewHolder.z0.postDelayed(new o(this, pbCommenFloorItemViewHolder), 3000L);
            } else {
                pbCommenFloorItemViewHolder.z0.setVisibility(8);
                pbCommenFloorItemViewHolder.d0.setVisibility(0);
                pbCommenFloorItemViewHolder.e0.setVisibility(0);
            }
        } else {
            ((n4a) getItem(i2)).X0(false);
            pbCommenFloorItemViewHolder.y0.setVisibility(8);
            pbCommenFloorItemViewHolder.z0.setVisibility(8);
            pbCommenFloorItemViewHolder.d0.setVisibility(0);
            pbCommenFloorItemViewHolder.e0.setVisibility(0);
        }
        SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.y0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x0, R.color.CAM_X0105, 1);
        J(n4aVar, pbCommenFloorItemViewHolder, 2);
        pbCommenFloorItemViewHolder.f.post(new p(this, pbCommenFloorItemViewHolder, (n4aVar.q() == null || n4aVar.q().getName_show() == null) ? "" : n4aVar.q().getName_show()));
        if (!StringUtils.isNull(n4aVar.q().getDiplayIntro())) {
            pbCommenFloorItemViewHolder.A0.setVisibility(0);
            pbCommenFloorItemViewHolder.A0.setText(n4aVar.q().getDiplayIntro() + "");
        } else {
            pbCommenFloorItemViewHolder.A0.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, n4aVar);
        sparseArray.put(R.id.tag_load_sub_data, n4aVar);
        sparseArray.put(R.id.tag_load_sub_view, view2);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(n4aVar.I()));
        sparseArray.put(R.id.tag_forbid_user_post_id, n4aVar.S());
        sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.p);
        sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.d0);
        sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.z);
        sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.A);
        u89 u89Var6 = this.k;
        ThreadData N = (u89Var6 == null || u89Var6.N() == null) ? threadData : this.k.N();
        if (N != null && N.isUgcThreadType()) {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z8 = (n4aVar.q() == null || StringUtils.isNull(n4aVar.q().getVirtualUserUrl())) ? false : true;
        u89 u89Var7 = this.k;
        if (u89Var7 == null || u89Var7.V() == 0 || i0()) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            z = (this.k.V() == 1002 || this.k.V() == 3) ? false : true;
            if (this.k.V() == 3 || this.k.i0()) {
                z2 = false;
                z3 = false;
            } else {
                z2 = true;
                z3 = true;
            }
            if (n4aVar != null && n4aVar.q() != null) {
                String userId = n4aVar.q().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        u89 u89Var8 = this.k;
        if (u89Var8 != null && u89Var8.N() != null && this.k.N().getAuthor() != null && n4aVar.q() != null) {
            String userId2 = this.k.N().getAuthor().getUserId();
            String userId3 = n4aVar.q().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z5 = false;
                    z6 = true;
                } else {
                    z5 = true;
                    z6 = false;
                }
                z4 = true;
                z7 = true;
                if (n4aVar != null && n4aVar.q() != null && UtilHelper.isCurrentAccount(n4aVar.q().getUserId())) {
                    z6 = true;
                    z4 = true;
                }
                if (z8) {
                    z = false;
                    z5 = false;
                    z4 = false;
                }
                int i5 = n4aVar.I() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.V()));
                    if (n4aVar.q() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, n4aVar.q().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, n4aVar.q().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, n4aVar.q().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (n4aVar.q() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, n4aVar.q().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, n4aVar.q().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, n4aVar.q().getName_show());
                    }
                    if (this.k.N() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.k.N().getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, n4aVar.S());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(n4aVar.z0()));
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.V()));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                    sparseArray.put(R.id.tag_del_post_id, n4aVar.S());
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
                pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                pbCommenFloorItemViewHolder.t.setTag(sparseArray);
            }
        }
        z4 = z2;
        z5 = false;
        z6 = false;
        z7 = false;
        if (n4aVar != null) {
            z6 = true;
            z4 = true;
        }
        if (z8) {
        }
        if (n4aVar.I() != 1) {
        }
        if (!z) {
        }
        if (!z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z3));
        sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
        pbCommenFloorItemViewHolder.r.setTag(sparseArray);
        pbCommenFloorItemViewHolder.t.setTag(sparseArray);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, view2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ pb9 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            /* renamed from: com.baidu.tieba.pb9$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class View$OnClickListenerC0449a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0449a(a aVar) {
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
                        rg9.v("c14886");
                        f fVar = this.a.a;
                        if (fVar.c.getItem(fVar.a) instanceof n4a) {
                            f fVar2 = this.a.a;
                            pb9 pb9Var = fVar2.c;
                            pb9Var.j0(((n4a) pb9Var.getItem(fVar2.a)).q());
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
                        if (fVar.c.getItem(fVar.a) instanceof n4a) {
                            f fVar2 = this.a.a;
                            n4a n4aVar = (n4a) fVar2.c.getItem(fVar2.a);
                            n4aVar.K0();
                            if (n4aVar.d0() <= 0) {
                                n4aVar.d1(Boolean.FALSE);
                                this.a.a.b.z0.setVisibility(8);
                                this.a.a.b.d0.setVisibility(0);
                                this.a.a.b.e0.setVisibility(0);
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
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.b.d0.getAgreeFlag()) {
                    return;
                }
                f fVar = this.a;
                ((n4a) fVar.c.getItem(fVar.a)).J0();
                f fVar2 = this.a;
                ((n4a) fVar2.c.getItem(fVar2.a)).d1(Boolean.TRUE);
                this.a.b.d0.setVisibility(8);
                this.a.b.e0.setVisibility(8);
                this.a.b.z0.setVisibility(0);
                this.a.b.z0.setOnClickListener(new View$OnClickListenerC0449a(this));
                this.a.b.z0.postDelayed(new b(this), 5000L);
            }
        }

        public f(pb9 pb9Var, int i, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var, Integer.valueOf(i), pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pb9Var;
            this.a = i;
            this.b = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !UtilHelper.isCurrentAccount(this.c.k.N().getAuthor().getUserId()) || !this.c.k.N().isQuestionThread() || UtilHelper.isCurrentAccount(((n4a) this.c.getItem(this.a)).q().getUserId())) {
                return;
            }
            if (this.b.d0.getAgreeFlag()) {
                ((n4a) this.c.getItem(this.a)).e1(1);
                this.b.y0.setVisibility(0);
                ((n4a) this.c.getItem(this.a)).X0(true);
                this.b.i.setVisibility(8);
                this.b.d0.postDelayed(new a(this), 900L);
                return;
            }
            ((n4a) this.c.getItem(this.a)).e1(0);
            this.b.z0.setVisibility(8);
            this.b.y0.setVisibility(8);
            this.b.d0.setVisibility(0);
            this.b.e0.setVisibility(0);
            ((n4a) this.c.getItem(this.a)).X0(false);
            if (((n4a) this.c.getItem(this.a)).g0().booleanValue()) {
                this.b.i.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ le9 b;
        public final /* synthetic */ pb9 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n4a a;
            public final /* synthetic */ c b;

            public a(c cVar, n4a n4aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, n4aVar};
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
                this.a = n4aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.b;
                    cVar.b.b.a(cVar.c.k, null, this.a, cVar.a.r.getLayoutStrategy());
                }
            }
        }

        public c(pb9 pb9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, le9 le9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var, pbCommenFloorItemViewHolder, le9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pb9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = le9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            n4a n4aVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof n4a) && (n4aVar = (n4a) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b != null) {
                yg.a().postDelayed(new a(this, n4aVar), 100L);
                String P = this.c.k.P();
                if ((StringUtils.isNull(P) || "0".equals(this.c.k.P())) && this.c.k.N() != null) {
                    P = this.c.k.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.c.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", n4aVar.S()).param("obj_source", this.c.h0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n4a a;
        public final /* synthetic */ pb9 b;

        public a(pb9 pb9Var, n4a n4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var, n4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pb9Var;
            this.a = n4aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                n4a n4aVar = this.a;
                if (n4aVar != null && n4aVar.q() != null) {
                    fy5.d(this.b.k.l(), this.a.q().getPortrait(), "3", this.b.b.getContext());
                }
                gy5.c("c15281", this.b.k.l(), "3");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public b(pb9 pb9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var, pbCommenFloorItemViewHolder};
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
                this.a.z.performClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ pb9 b;

        public d(pb9 pb9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pb9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.p) != null && agreeView.getData() != null) {
                if (view2 == this.a.p.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String P = this.b.k.P();
                if ((StringUtils.isNull(P) || "0".equals(this.b.k.P())) && this.b.k.N() != null) {
                    P = this.b.k.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.b.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.p.getData().postId).param("obj_source", this.b.h0(this.a.p)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ pb9 b;

        public e(pb9 pb9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pb9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.d0) != null && agreeView.getData() != null) {
                if (view2 == this.a.d0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String P = this.b.k.P();
                if ((StringUtils.isNull(P) || "0".equals(this.b.k.P())) && this.b.k.N() != null) {
                    P = this.b.k.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.b.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.d0.getData().postId).param("obj_source", this.b.h0(this.a.d0)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pb9 a;

        public g(pb9 pb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pb9Var;
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
    public class h implements ng<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pb9 a;

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

        public h(pb9 pb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pb9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ng
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ng
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ng
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ng
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
    public class i implements ng<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pb9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public i(pb9 pb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pb9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ng
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ng
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ng
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
        @Override // com.baidu.tieba.ng
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
    public class j implements ba9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pb9 a;

        @Override // com.baidu.tieba.ba9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public j(pb9 pb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pb9Var;
        }

        @Override // com.baidu.tieba.ba9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    if ((view2 instanceof TbListTextView) && this.a.m != null) {
                        this.a.m.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.M6(false);
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

        @Override // com.baidu.tieba.ba9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (((pbFragment = this.a.b) != null && pbFragment.L5() != null && !this.a.b.L5().O1()) || view2.getId() == R.id.obfuscated_res_0x7f090b54)) {
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
                            this.a.P((FrameLayout) parent);
                            break;
                        }
                    }
                } else {
                    this.a.P(view2);
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

        public k(pb9 pb9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var, pbCommenFloorItemViewHolder};
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tBLottieAnimationView = this.a.B0) != null) {
                tBLottieAnimationView.setVisibility(8);
                this.a.B0.pauseAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n4a a;
        public final /* synthetic */ pb9 b;

        public l(pb9 pb9Var, n4a n4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var, n4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pb9Var;
            this.a = n4aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.q() != null && this.a.q().getPortrait() != null && !TextUtils.isEmpty(this.a.q().getPortrait())) {
                String str2 = null;
                if (this.a.u0() != null) {
                    str2 = this.a.u0().getFigureUrl();
                    str = this.a.u0().getBackgroundValue();
                } else {
                    str = null;
                }
                l36.a(this.b.a.V().getPageContext(), this.a.q().getPortrait(), str2, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ n4a b;
        public final /* synthetic */ pb9 c;

        public m(pb9 pb9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var, pbCommenFloorItemViewHolder, n4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pb9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = n4aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.S.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.M(this.a, !z, this.b.L());
                this.b.a1(!z);
                this.c.m0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.L5() != null && this.c.b.L5().o1() != null && this.c.b.L5().X0() != null && !z && this.a.getView().getTop() < this.c.b.L5().o1().getMeasuredHeight()) {
                    this.c.b.L5().X0().setSelectionFromTop(ListUtils.getPosition(this.c.b.L5().X0().getData(), this.b) + this.c.b.L5().X0().getHeaderViewsCount(), this.c.b.L5().o1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ pb9 b;

        public n(pb9 pb9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pb9Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 4, this.a);
            ux4.v(this.b.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public o(pb9 pb9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var, pbCommenFloorItemViewHolder};
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
                this.a.z0.setVisibility(8);
                this.a.d0.setVisibility(0);
                this.a.e0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public p(pb9 pb9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb9Var, pbCommenFloorItemViewHolder, str};
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
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.f.getMeasuredWidth();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.a.G);
                arrayList.add(this.a.i);
                arrayList.add(this.a.j);
                arrayList.add(this.a.y0);
                arrayList.add(this.a.E);
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                ey5.c(measuredWidth, str, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.E, arrayList, pbCommenFloorItemViewHolder.H);
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder2 = this.a;
                gy5.a(pbCommenFloorItemViewHolder2.g, pbCommenFloorItemViewHolder2.G, pbCommenFloorItemViewHolder2.j, pbCommenFloorItemViewHolder2.E, pbCommenFloorItemViewHolder2.H, 1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pb9(vg9 vg9Var, BdUniqueId bdUniqueId) {
        super(vg9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vg9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((vg9) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.y = new mg<>(new h(this), 6, 0);
        this.z = new mg<>(new i(this), 12, 0);
        this.A = new ba9(new j(this));
        this.B = false;
        if (vg9Var != null && vg9Var.Q() != null) {
            this.t = vg9Var.Q().x1();
        }
    }

    public final void G(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.r.setTextViewOnTouchListener(this.o);
            pbCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.t.setOnTouchListener(new g(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.h = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onLongClickListener) == null) {
            this.p = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void n(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, zVar) == null) {
            this.n = zVar;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.j = str;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.s = z;
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.v = z;
        }
    }

    public void r(u89 u89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, u89Var) == null) {
            this.k = u89Var;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.r = z;
        }
    }

    public void s0(ba9 ba9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, ba9Var) == null) {
            this.o = ba9Var;
        }
    }

    public void t0(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, tVar) == null) {
            this.g = tVar;
        }
    }

    public final void w0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof n4a)) {
            return;
        }
        x0(textView, (n4a) tag);
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, n4aVar) == null) && pbCommenFloorItemViewHolder != null && n4aVar != null && (imageView = pbCommenFloorItemViewHolder.I) != null && this.k != null) {
            imageView.setVisibility(8);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, n4aVar) == null) && pbCommenFloorItemViewHolder != null && n4aVar != null) {
            int i2 = 0;
            if (pbCommenFloorItemViewHolder.Y.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ImageView imageView = pbCommenFloorItemViewHolder.X;
                if (!n4aVar.c0) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
        }
    }

    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048600, this, pbCommenFloorItemViewHolder, n4aVar) == null) && pbCommenFloorItemViewHolder != null && n4aVar != null) {
            pbCommenFloorItemViewHolder.h(n4aVar.f1137T, n4aVar.S(), this.v);
        }
    }

    public final void m0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, pbCommenFloorItemViewHolder, n4aVar) == null) {
            TbRichText e0 = n4aVar.e0();
            if (e0 != null) {
                e0.isChanged = true;
            }
            pbCommenFloorItemViewHolder.r.setText(e0, true, this.g);
        }
    }

    public final void H(n4a n4aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n4aVar) == null) {
            if (n4aVar != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", n4aVar.S());
                statisticItem.param("pid", n4aVar.S());
                statisticItem.param("tid", n4aVar.o0());
                statisticItem.param("fid", n4aVar.O());
                statisticItem.param("fname", n4aVar.P());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            u89 u89Var = this.k;
            if (u89Var != null) {
                if (u89Var.w0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                        u89 u89Var2 = this.k;
                        int i4 = n4aVar.e0;
                        if (n4aVar.d0) {
                            i3 = 2;
                        } else {
                            i3 = 8;
                        }
                        rg9.e(uniqueId, u89Var2, n4aVar, i4, i3, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                    u89 u89Var3 = this.k;
                    int i5 = n4aVar.e0;
                    if (n4aVar.d0) {
                        i2 = 2;
                    } else {
                        i2 = 8;
                    }
                    rg9.e(uniqueId2, u89Var3, n4aVar, i5, i2, "common_exp_source_pb_comment");
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: k0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d078e, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091ae2)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0787, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.V().getPageContext(), inflate, this.t);
            pbCommenFloorItemViewHolder.u.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.u.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.w;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.u);
                pbCommenFloorItemViewHolder.w.setIsVideoThread(false);
            }
            u0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.r;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.s);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void n0(n4a n4aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, n4aVar) == null) {
            String userId = n4aVar.q().getUserId();
            u89 u89Var = this.k;
            String str2 = "";
            if (u89Var == null) {
                str = "";
            } else {
                str = u89Var.l();
            }
            u89 u89Var2 = this.k;
            if (u89Var2 != null) {
                str2 = u89Var2.m();
            }
            int I = n4aVar.I();
            String S = n4aVar.S();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", S);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, I);
            if (n4aVar.q().getAlaInfo() != null) {
                AlaInfoData alaInfo = n4aVar.q().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void I(n4a n4aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n4aVar) == null) && n4aVar.E == 0 && n4aVar.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", n4aVar.S());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            vg9 vg9Var = this.a;
            if (vg9Var != null) {
                int x1 = vg9Var.Q().x1();
                if (1 != x1 && 2 != x1) {
                    if (3 == x1) {
                        statisticItem.param("obj_source", "2");
                    } else {
                        statisticItem.param("obj_source", "0");
                    }
                } else {
                    statisticItem.param("obj_source", "1");
                }
            }
            TiebaStatic.log(statisticItem);
            if (n4aVar.q() != null && n4aVar.q().getAlaInfo() != null && n4aVar.q().getAlaInfo().live_status == 1) {
                n0(n4aVar);
            }
        }
    }

    public final void J(n4a n4aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, n4aVar, pbCommenFloorItemViewHolder, i2) == null) {
            if (pbCommenFloorItemViewHolder.H != null && n4aVar.q() != null) {
                pbCommenFloorItemViewHolder.H.setTag(R.id.tag_user_id, n4aVar.q().getUserId());
                vg9 vg9Var = this.a;
                if (vg9Var != null && vg9Var.V() != null) {
                    pbCommenFloorItemViewHolder.H.setOnClickListener(this.a.V().c.c);
                }
                ArrayList<IconData> iconInfo = n4aVar.q().getIconInfo();
                int g2 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                pbCommenFloorItemViewHolder.H.g(iconInfo, i2, g2, g2, xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            if (n4aVar.g0().booleanValue() && !n4aVar.R()) {
                pbCommenFloorItemViewHolder.i.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.i.setVisibility(8);
            }
        }
    }

    public final void K(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int m2 = ((((xi.m(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
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

    public final void M(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f06da);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.U.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.S.setVisibility(0);
            pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f0471);
        }
    }

    public final void N(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, n4aVar}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.J) != null && pbCommenFloorItemViewHolder.f1141T != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.f1141T.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = true;
            boolean z3 = !ListUtils.isEmpty(n4aVar.i0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.J.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.f1141T.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().n(0);
                if (z3) {
                    pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.f1141T.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = xi.g(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
                }
            } else {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().n(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
                if (layoutParams != null) {
                    layoutParams.topMargin = xi.g(this.mContext, R.dimen.tbds14);
                    pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
                }
            }
            if (pbCommenFloorItemViewHolder.t0.getVisibility() != 0 && pbCommenFloorItemViewHolder.A0.getVisibility() != 0) {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().k(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            } else {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().k(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            }
            via.b(n4aVar, pbCommenFloorItemViewHolder.r, (TextUtils.isEmpty(n4aVar.t()) || !this.h) ? false : false);
        }
    }

    public final void p0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2, n4a n4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048619, this, pbCommenFloorItemViewHolder, i2, n4aVar) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.p);
            if (this.a.V() != null && this.a.V().getPageContext() != null && this.a.V().getPageContext().getOrignalPage() != null) {
                je9 je9Var = this.a.V().c;
                pbCommenFloorItemViewHolder.g.setOnClickListener(je9Var.b);
                pbCommenFloorItemViewHolder.q.setOnClickListener(je9Var.b);
                pbCommenFloorItemViewHolder.u0.setOnClickListener(je9Var.d);
                pbCommenFloorItemViewHolder.t0.setOnClickListener(je9Var.d);
                pbCommenFloorItemViewHolder.F.setOnClickListener(je9Var.b);
                pbCommenFloorItemViewHolder.F.getHeadView().setOnClickListener(je9Var.b);
                pbCommenFloorItemViewHolder.r.setOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.r.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.r.setCommonTextViewOnClickListener(this.m);
                pbCommenFloorItemViewHolder.r.setOnImageClickListener(this.n);
                pbCommenFloorItemViewHolder.r.setOnImageTouchListener(this.A);
                pbCommenFloorItemViewHolder.r.setOnEmotionClickListener(je9Var.f);
                pbCommenFloorItemViewHolder.r.setOnVoiceAfterClickListener(this.m);
                pbCommenFloorItemViewHolder.K.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.L.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.N.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.i0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.m0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.m0.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.E.setOnClickListener(new a(this, n4aVar));
                pbCommenFloorItemViewHolder.e0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.o0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.f0.setOnClickListener(new b(this, pbCommenFloorItemViewHolder));
                le9 le9Var = this.a.V().d;
                pbCommenFloorItemViewHolder.z.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.A.setOnClickListener(new c(this, pbCommenFloorItemViewHolder, le9Var));
                pbCommenFloorItemViewHolder.p.D = new d(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.d0.D = new e(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.d0.setAfterClickListener(new f(this, i2, pbCommenFloorItemViewHolder));
            }
        }
    }

    public final boolean O(n4a n4aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, n4aVar)) == null) {
            if (this.k.N() != null && this.k.N().getAuthor() != null && this.k.N().getAuthor().getUserId() != null && n4aVar != null && n4aVar.q() != null && n4aVar.q().getUserId() != null) {
                return this.k.N().getAuthor().getUserId().equals(n4aVar.q().getUserId());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void P(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).d0) != null && agreeView.getData() != null && !g0(pbCommenFloorItemViewHolder.r)) {
            pbCommenFloorItemViewHolder.d0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.d0.O();
        }
    }

    public final void Q(n4a n4aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, n4aVar) == null) && n4aVar != null) {
            int i2 = 8;
            if (n4aVar.d0) {
                i2 = 2;
            }
            StatisticItem i3 = rg9.i(this.k, n4aVar, n4aVar.e0, i2, 6);
            n4aVar.f0 = i3;
            if (!ListUtils.isEmpty(n4aVar.i0())) {
                Iterator<n4a> it = n4aVar.i0().iterator();
                while (it.hasNext()) {
                    it.next().f0 = i3;
                }
            }
        }
    }

    public final boolean g0(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            n4a n4aVar = null;
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return false;
            }
            if (sparseArray.get(R.id.tag_clip_board) instanceof n4a) {
                n4aVar = (n4a) sparseArray.get(R.id.tag_clip_board);
            }
            if (n4aVar == null || n4aVar.l() == 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final String h0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, view2)) == null) {
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

    public void j0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mContext, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        boolean z;
        boolean z2;
        u89 u89Var;
        u89 u89Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, n4aVar) == null) && pbCommenFloorItemViewHolder != null && n4aVar != null) {
            String str = null;
            boolean z3 = true;
            if (n4aVar.I() > 0 && (u89Var2 = this.k) != null && !u89Var2.i0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0b0e), Integer.valueOf(n4aVar.I()));
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
                z = false;
            }
            if (n4aVar.q() != null) {
                str = n4aVar.q().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    fh5 Z = n4aVar.Z();
                    z3 = (Z != null || StringUtils.isNull(Z.b()) || (u89Var = this.k) == null || u89Var.i0()) ? false : false;
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
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(n4aVar.p0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(n4aVar.p0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(n4aVar.p0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        pbCommenFloorItemViewHolder.o.setText(str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        if (n4aVar.c0) {
                            pbCommenFloorItemViewHolder.o.setText(StringHelper.cutStringWithSuffix(Z.b(), 7, "..."));
                        } else {
                            pbCommenFloorItemViewHolder.o.setText(Z.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.o.setVisibility(8);
                    }
                    pbCommenFloorItemViewHolder.n.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds14), 0, 0, 0);
                    TextView textView = pbCommenFloorItemViewHolder.g0;
                    textView.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            fh5 Z2 = n4aVar.Z();
            if (Z2 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(n4aVar.p0()), "yyyy"))) {
            }
            if (!z2) {
            }
            pbCommenFloorItemViewHolder.n.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds14), 0, 0, 0);
            TextView textView2 = pbCommenFloorItemViewHolder.g0;
            textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048589, this, pbCommenFloorItemViewHolder, n4aVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && n4aVar != null) {
            pbCommenFloorItemViewHolder.B.setVisibility(8);
            pbCommenFloorItemViewHolder.v.setVisibility(0);
            pbCommenFloorItemViewHolder.f0.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.p.setVisibility(8);
            pbCommenFloorItemViewHolder.o0.setVisibility(8);
            e0(pbCommenFloorItemViewHolder, n4aVar, view2, i2);
            R(pbCommenFloorItemViewHolder, n4aVar);
            V(pbCommenFloorItemViewHolder, n4aVar);
            Y(pbCommenFloorItemViewHolder, n4aVar, view2);
            X(pbCommenFloorItemViewHolder, n4aVar, view2, i2);
            S(pbCommenFloorItemViewHolder, n4aVar);
            b0(pbCommenFloorItemViewHolder, n4aVar);
            W(pbCommenFloorItemViewHolder, n4aVar);
            v0(pbCommenFloorItemViewHolder, n4aVar);
            c0(pbCommenFloorItemViewHolder, n4aVar);
            na9.f(pbCommenFloorItemViewHolder, n4aVar, view2, this.h, this.A);
            a0(pbCommenFloorItemViewHolder, n4aVar);
            T(pbCommenFloorItemViewHolder, n4aVar);
            Z(pbCommenFloorItemViewHolder, n4aVar);
            d0(pbCommenFloorItemViewHolder, n4aVar);
            f0(pbCommenFloorItemViewHolder, n4aVar);
            na9.k(pbCommenFloorItemViewHolder, view2, n4aVar, this.r, true);
            na9.d(pbCommenFloorItemViewHolder, n4aVar, this.k);
        }
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, n4aVar) == null) && pbCommenFloorItemViewHolder != null && n4aVar != null && n4aVar.o() != null) {
            n4aVar.o().threadId = this.a.Q().R1();
            n4aVar.o().objType = 1;
            n4aVar.o().isInPost = true;
            ThreadData threadData = null;
            u89 u89Var = this.k;
            if (u89Var != null && u89Var.N() != null) {
                threadData = this.k.N();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.p.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.p.setThreadData(threadData);
            pbCommenFloorItemViewHolder.p.setData(n4aVar.o());
            pbCommenFloorItemViewHolder.d0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.d0.setData(n4aVar.o());
        }
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, pbCommenFloorItemViewHolder, n4aVar) == null) {
            if (n4aVar != null && n4aVar.q() != null && n4aVar.l0() != null) {
                TbRichText e0 = n4aVar.e0();
                if (e0 != null && StringUtils.isNull(e0.toString()) && StringUtils.isNull(n4aVar.t())) {
                    z = true;
                } else {
                    z = false;
                }
                if (n4aVar.q().getSmallTailThemeData() != null) {
                    str = n4aVar.q().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.L.setTag(R.id.tag_pb_small_tail_theme_id, str);
                gh9.c(n4aVar.l0(), pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, pbCommenFloorItemViewHolder.M, false, false, z, n4aVar.q().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.K.setVisibility(8);
            pbCommenFloorItemViewHolder.L.setVisibility(8);
        }
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, pbCommenFloorItemViewHolder, n4aVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.Q != null && pbCommenFloorItemViewHolder.N != null) {
            if (n4aVar != null && (alaLiveInfoCoreData = n4aVar.U) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.Q.setText(n4aVar.U.liveTitle);
                pbCommenFloorItemViewHolder.N.setTag(n4aVar.U);
                pbCommenFloorItemViewHolder.N.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbCommenFloorItemViewHolder.N.setVisibility(8);
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, pbCommenFloorItemViewHolder, n4aVar) == null) {
            if (n4aVar.M() != 2 && n4aVar.M() != 4) {
                pbCommenFloorItemViewHolder.f1141T.setVisibility(8);
                pbCommenFloorItemViewHolder.S.setVisibility(0);
                N(false, pbCommenFloorItemViewHolder, n4aVar);
            } else {
                pbCommenFloorItemViewHolder.f1141T.setOnClickListener(new m(this, pbCommenFloorItemViewHolder, n4aVar));
                pbCommenFloorItemViewHolder.f1141T.setVisibility(0);
                M(pbCommenFloorItemViewHolder, n4aVar.D0(), n4aVar.L());
                N(true, pbCommenFloorItemViewHolder, n4aVar);
            }
            m0(pbCommenFloorItemViewHolder, n4aVar);
        }
    }

    public final void f0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, pbCommenFloorItemViewHolder, n4aVar) == null) && pbCommenFloorItemViewHolder != null && WorldCupEnableSwitch.isOn() && n4aVar != null) {
            AgreeView agreeView = pbCommenFloorItemViewHolder.d0;
            if (agreeView != null) {
                agreeView.setAgreeAlone(true);
                pbCommenFloorItemViewHolder.d0.setPadding(0, 0, 0, 0);
            }
            TbImageView tbImageView = pbCommenFloorItemViewHolder.C0;
            if (tbImageView != null) {
                tbImageView.setVisibility(0);
                pbCommenFloorItemViewHolder.C0.setImageResource(R.drawable.obfuscated_res_0x7f080a04);
                pbCommenFloorItemViewHolder.C0.setOnClickListener(new l(this, n4aVar));
            }
            HeadWorldCupFlagLayout headWorldCupFlagLayout = pbCommenFloorItemViewHolder.D0;
            if (headWorldCupFlagLayout != null) {
                headWorldCupFlagLayout.b(n4aVar.q());
            }
        }
    }

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048592, this, pbCommenFloorItemViewHolder, n4aVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && n4aVar != null) {
            if (n4aVar.k0() > 0) {
                pbCommenFloorItemViewHolder.y.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.y.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, n4aVar);
                if (n4aVar.M() == 2) {
                    pbCommenFloorItemViewHolder.y.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.y.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            }
            ImageView imageView = pbCommenFloorItemViewHolder.z;
            if (imageView != null) {
                SparseArray sparseArray2 = (SparseArray) imageView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, n4aVar);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.A;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.A.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, n4aVar);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            if (!n4aVar.z0() && !n4aVar.y0(false)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.w.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.w.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.w.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.w.getLayoutParams();
                layoutParams2.topMargin = xi.g(this.mContext, R.dimen.tbds0);
                layoutParams2.leftMargin = xi.g(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = xi.g(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = xi.g(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.w.setLayoutParams(layoutParams2);
                if (this.q == null) {
                    ag9 ag9Var = new ag9(this.mContext);
                    this.q = ag9Var;
                    ag9Var.f(this.e);
                    this.q.h(this.l);
                    this.q.e(this.m);
                    String str = null;
                    u89 u89Var = this.k;
                    if (u89Var != null && u89Var.N() != null && this.k.N().getAuthor() != null) {
                        str = this.k.N().getAuthor().getUserId();
                    }
                    boolean z = true;
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    u89 u89Var2 = this.k;
                    if (u89Var2 != null) {
                        this.q.j(u89Var2.V(), z);
                        this.q.i(this.k.N());
                    }
                }
                this.q.g(n4aVar.S());
                pbCommenFloorItemViewHolder.w.setSubPbAdapter(this.q);
                pbCommenFloorItemViewHolder.w.setVisibility(0);
                pbCommenFloorItemViewHolder.w.setData(n4aVar, view2);
                pbCommenFloorItemViewHolder.w.setChildOnClickListener(this.m);
                pbCommenFloorItemViewHolder.w.setChildOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.w.setChildOnTouchListener(this.A);
            }
            if (n4aVar.P) {
                pbCommenFloorItemViewHolder.J.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.J.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
            layoutParams3.topMargin = xi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = xi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.x.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.v.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.h0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f120e));
        }
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048593, this, pbCommenFloorItemViewHolder, n4aVar, view2) == null) && pbCommenFloorItemViewHolder != null && n4aVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = xi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = xi.g(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.r.setPadding(0, 0, 0, 0);
            if (!this.h) {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.r.p0(null);
                pbCommenFloorItemViewHolder.r.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().z(R.drawable.pic_video);
            K(pbCommenFloorItemViewHolder.r, view2, !StringUtils.isNull(n4aVar.t()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.r.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.r.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.r.setTid(this.k.P());
            pbCommenFloorItemViewHolder.r.setPid(n4aVar.S());
            pbCommenFloorItemViewHolder.r.setPosition(TbRichTextView.Position.PB_COMMENT_FLOOR);
            pbCommenFloorItemViewHolder.r.setText(n4aVar.e0(), true, this.g);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, n4aVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            sparseArray.put(R.id.tag_is_top_question, Boolean.FALSE);
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.o0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.e0.setTag(sparseArray);
        }
    }

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, n4aVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            vg9 vg9Var = this.a;
            if (vg9Var != null && vg9Var.Q() != null && StringHelper.equals(this.a.Q().Z0(), n4aVar.S())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, pbCommenFloorItemViewHolder, n4aVar) == null) && pbCommenFloorItemViewHolder != null && n4aVar != null) {
            String f0 = n4aVar.f0();
            if (!StringUtils.isNull(f0)) {
                pbCommenFloorItemViewHolder.Y.N(f0, 10, false);
                pbCommenFloorItemViewHolder.Y.setVisibility(0);
                pbCommenFloorItemViewHolder.X.setVisibility(8);
                return;
            }
            pbCommenFloorItemViewHolder.Y.setVisibility(8);
        }
    }

    public final boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            u89 u89Var = this.k;
            if (u89Var != null && u89Var.N() != null) {
                return this.k.N().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View l0(int i2, View view2, ViewGroup viewGroup, n4a n4aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, n4aVar, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) n4aVar, (n4a) pbCommenFloorItemViewHolder);
            u0(pbCommenFloorItemViewHolder);
            p0(pbCommenFloorItemViewHolder, i2, n4aVar);
            G(pbCommenFloorItemViewHolder);
            n4a n4aVar2 = (n4a) getItem(i2);
            if (n4aVar2 != null) {
                n4aVar2.e0 = i2 + 1;
                I(n4aVar2);
                H(n4aVar2);
                n4aVar2.y1();
                Q(n4aVar2);
                U(pbCommenFloorItemViewHolder, n4aVar2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.rb9, com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i2, view2, viewGroup, (n4a) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void u0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048625, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            w0(pbCommenFloorItemViewHolder.i);
            boolean z = true;
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.D, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.o, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.y, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbCommenFloorItemViewHolder.t.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.t.g(skinType);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.h0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.w, xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080b8e, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.A, R.drawable.obfuscated_res_0x7f080b8f, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.w.d();
            pbCommenFloorItemViewHolder.u.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.Q, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.O, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.N, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.P, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.R, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.U, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.S.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f0471);
            } else {
                u89 u89Var = this.k;
                if (u89Var != null && StringUtils.isNull(u89Var.j())) {
                    pbCommenFloorItemViewHolder.U.setText(this.k.j());
                } else {
                    pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f06da);
                }
            }
            pbCommenFloorItemViewHolder.p.Q(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.e0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.o0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    public void v0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, n4a n4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, pbCommenFloorItemViewHolder, n4aVar) == null) {
            String str = "#7F66FE";
            if (n4aVar.u0() != null) {
                VirtualImageCustomFigure u0 = n4aVar.u0();
                pbCommenFloorItemViewHolder.u0.setHeadImageViewResource(u0.getFigureUrl());
                pbCommenFloorItemViewHolder.u0.setTid(n4aVar.S());
                pbCommenFloorItemViewHolder.u0.setLocate(fd9.c);
                pbCommenFloorItemViewHolder.u0.setFrom(5);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(u0.getBackGroundType())) {
                    str = u0.getBackgroundValue();
                    pbCommenFloorItemViewHolder.u0.setHeadImageBackgroundColorResource(u0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(u0.getBackGroundType())) {
                    pbCommenFloorItemViewHolder.u0.setHeadImageBackgroundResource(u0.getBackgroundValue());
                }
                pbCommenFloorItemViewHolder.u0.f(n4aVar.q());
                pbCommenFloorItemViewHolder.s0.setVisibility(8);
                pbCommenFloorItemViewHolder.v0.setVisibility(0);
                pbCommenFloorItemViewHolder.u0.setTag(R.id.tag_user_id, n4aVar.q().getUserId());
                pbCommenFloorItemViewHolder.u0.setTag(R.id.tag_user_name, n4aVar.q().getUserName());
                pbCommenFloorItemViewHolder.f();
                String t = r95.t("key_reaction_guide_show_number_pb");
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.V() != null && this.b.V().getIntent() != null && this.b.V().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && !this.B && r95.p().q(t, 0) == 3 && !bf9.c(this.k) && (n4aVar.x() == null || !u79.c())) {
                    this.B = true;
                    pbCommenFloorItemViewHolder.B0.setVisibility(0);
                    pbCommenFloorItemViewHolder.B0.playAnimation();
                    yg.a().postDelayed(new k(this, pbCommenFloorItemViewHolder), 4000L);
                }
            } else {
                pbCommenFloorItemViewHolder.v0.setVisibility(8);
                pbCommenFloorItemViewHolder.u0.setTag(R.id.tag_user_id, null);
                pbCommenFloorItemViewHolder.u0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.s0.setVisibility(0);
                pbCommenFloorItemViewHolder.B0.setVisibility(8);
                pbCommenFloorItemViewHolder.B0.pauseAnimation();
            }
            if (n4aVar.v0() != null && !TextUtils.isEmpty(n4aVar.v0().getIcon())) {
                pbCommenFloorItemViewHolder.t0.setData(n4aVar.v0(), false, str);
                pbCommenFloorItemViewHolder.t0.setVisibility(0);
                if (pbCommenFloorItemViewHolder.w0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.w0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbCommenFloorItemViewHolder.w0.setLayoutParams(marginLayoutParams);
                }
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_id, n4aVar.q().getUserId());
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_name, n4aVar.q().getUserName());
                this.w = fd9.d;
                this.x = pbCommenFloorItemViewHolder.t0.getData();
                pbCommenFloorItemViewHolder.u0.setWithBubble(this.w);
                pbCommenFloorItemViewHolder.u0.setBubbleName(this.x);
                pbCommenFloorItemViewHolder.u0.setVirtualHeadUid(n4aVar.q().getUserId());
            } else {
                if (pbCommenFloorItemViewHolder.w0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.w0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbCommenFloorItemViewHolder.w0.setLayoutParams(marginLayoutParams2);
                }
                pbCommenFloorItemViewHolder.t0.setVisibility(8);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_id, null);
                int i2 = fd9.e;
                this.w = i2;
                pbCommenFloorItemViewHolder.u0.setWithBubble(i2);
            }
            if (pbCommenFloorItemViewHolder.u0.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.u0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            if (n4aVar.u0() != null) {
                fd9.a(2, n4aVar.S(), fd9.c, this.w, this.x, n4aVar.s());
            }
        }
    }

    public final void x0(TextView textView, n4a n4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, textView, n4aVar) == null) {
            if (textView == null && n4aVar == null) {
                return;
            }
            textView.setTag(n4aVar);
            u89 u89Var = this.k;
            if (u89Var != null && u89Var.i0()) {
                n4aVar.l1(Boolean.FALSE);
                n4aVar.Z0(0);
                textView.setTag(null);
            } else if (n4aVar.q() != null) {
                com.baidu.tbadk.core.data.MetaData q = n4aVar.q();
                String str = this.j;
                if (str != null && !str.equals("0") && this.j.equals(q.getUserId())) {
                    n4aVar.l1(Boolean.TRUE);
                    n4aVar.Z0(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    s75 d2 = s75.d(textView);
                    d2.o(R.string.J_X04);
                    d2.m(R.dimen.L_X01);
                    d2.x(R.color.CAM_X0302);
                    d2.l(R.color.CAM_X0302);
                } else if (q.getIs_bawu() == 1 && n4aVar.B0()) {
                    s75 d3 = s75.d(textView);
                    d3.x(R.color.CAM_X0101);
                    d3.o(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    n4aVar.l1(Boolean.TRUE);
                    n4aVar.Z0(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.brand_official);
                } else if (q.getIs_bawu() == 1 && "manager".equals(q.getBawu_type())) {
                    s75 d4 = s75.d(textView);
                    d4.x(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    n4aVar.l1(Boolean.TRUE);
                    n4aVar.Z0(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (q.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(q.getBawu_type())) {
                    s75 d5 = s75.d(textView);
                    d5.x(R.color.CAM_X0101);
                    d5.o(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    n4aVar.l1(Boolean.TRUE);
                    n4aVar.Z0(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (q.getIs_bawu() == 1 && "pri_content_assist".equals(q.getBawu_type())) {
                    s75 d6 = s75.d(textView);
                    d6.x(R.color.CAM_X0101);
                    d6.o(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    n4aVar.l1(Boolean.TRUE);
                    n4aVar.Z0(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (q.getIs_bawu() == 1 && "pri_manage_assist".equals(q.getBawu_type())) {
                    s75 d7 = s75.d(textView);
                    d7.x(R.color.CAM_X0101);
                    d7.o(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    n4aVar.l1(Boolean.TRUE);
                    n4aVar.Z0(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    n4aVar.l1(Boolean.FALSE);
                    n4aVar.Z0(0);
                }
            } else {
                n4aVar.l1(Boolean.FALSE);
                n4aVar.Z0(0);
            }
        }
    }
}
