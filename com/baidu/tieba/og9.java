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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.af9;
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
public class og9 extends qg9<rba, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public af9 A;
    public boolean B;
    public TbRichTextView.t g;
    public boolean h;
    public float i;
    public String j;
    public td9 k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public TbRichTextView.z n;
    public af9 o;
    public View.OnLongClickListener p;
    public al9 q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public String x;
    public ag<ConstrainImageLayout> y;
    public ag<TbImageView> z;

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
    public final void e0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar, View view2, int i2) {
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
        if (!(interceptable == null || interceptable.invokeLLLI(1048602, this, pbCommenFloorItemViewHolder, rbaVar, view2, i2) == null) || pbCommenFloorItemViewHolder == null || rbaVar == null) {
            return;
        }
        if (rbaVar.R) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.e.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.e.setVisibility(8);
        }
        pbCommenFloorItemViewHolder.p.setTag(null);
        pbCommenFloorItemViewHolder.p.setUserId(null);
        pbCommenFloorItemViewHolder.E.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.q.setIsHost(false);
        if (rbaVar.r() != null) {
            String str2 = this.j;
            if (str2 != null && !str2.equals("0") && this.j.equals(rbaVar.r().getUserId())) {
                pbCommenFloorItemViewHolder.q.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = rbaVar.r().getIconInfo();
            ArrayList<IconData> tShowInfoNew = rbaVar.r().getTShowInfoNew();
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (iconInfo.size() < 2) {
                int size = iconInfo.size();
                if (size > 1) {
                    rbaVar.t1((dimens * size) + (dimens2 * size));
                } else if (size == 1) {
                    rbaVar.t1(dimens + dimens2);
                } else {
                    rbaVar.t1(0);
                }
            } else {
                rbaVar.t1((dimens * 2) + (dimens2 * 2));
            }
            if (pbCommenFloorItemViewHolder.F != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.F.setTag(tShowInfoNew.get(0).getUrl());
                }
                vl9 vl9Var = this.a;
                if (vl9Var != null && vl9Var.Y() != null) {
                    pbCommenFloorItemViewHolder.F.setOnClickListener(this.a.Y().c.e);
                }
                int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.F.h(tShowInfoNew, 3, dimens3, dimens3, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !rbaVar.r().isBigV()) {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
            }
            String avater = rbaVar.r().getAvater();
            int i4 = rbaVar.d0 ? 2 : 8;
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_id, rbaVar.r().getUserId());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, rbaVar.r().getUserName());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, rbaVar.r().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, rl9.k(this.k, rbaVar, rbaVar.e0, i4, 2));
            String name_show = rbaVar.r().getName_show();
            String userName = rbaVar.r().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.h.setText(xb9.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                pbCommenFloorItemViewHolder.g.setGravity(16);
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, xb9.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
            }
            if (rbaVar.r().getPendantData() != null && !StringUtils.isNull(rbaVar.r().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.E.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.E.i(rbaVar.r());
                pbCommenFloorItemViewHolder.p.setVisibility(8);
                pbCommenFloorItemViewHolder.E.setVisibility(0);
                pbCommenFloorItemViewHolder.E.getHeadView().startLoad(avater, 28, false);
                pbCommenFloorItemViewHolder.E.getHeadView().setUserId(rbaVar.r().getUserId());
                pbCommenFloorItemViewHolder.E.getHeadView().setUserName(rbaVar.r().getUserName());
                td9 td9Var = this.k;
                pbCommenFloorItemViewHolder.E.getHeadView().setFid(td9Var != null ? td9Var.l() : "");
                td9 td9Var2 = this.k;
                pbCommenFloorItemViewHolder.E.getHeadView().setFName(td9Var2 != null ? td9Var2.m() : "");
                pbCommenFloorItemViewHolder.E.getHeadView().setFloor(rbaVar.I());
                pbCommenFloorItemViewHolder.E.getHeadView().setTid(rbaVar.S());
                pbCommenFloorItemViewHolder.E.getHeadView().setTag(R.id.tag_statistic_item, rl9.k(this.k, rbaVar, rbaVar.e0, i4, 2));
                pbCommenFloorItemViewHolder.E.i(rbaVar.r());
            } else {
                pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, rbaVar.r(), 4);
                pbCommenFloorItemViewHolder.p.setUserId(rbaVar.r().getUserId());
                td9 td9Var3 = this.k;
                pbCommenFloorItemViewHolder.p.setFid(td9Var3 != null ? td9Var3.l() : "");
                td9 td9Var4 = this.k;
                pbCommenFloorItemViewHolder.p.setFName(td9Var4 != null ? td9Var4.m() : "");
                pbCommenFloorItemViewHolder.p.setFloor(rbaVar.I());
                pbCommenFloorItemViewHolder.p.setTid(rbaVar.S());
                pbCommenFloorItemViewHolder.p.setUserName(rbaVar.r().getUserName(), rbaVar.s0());
                pbCommenFloorItemViewHolder.p.setTag(R.id.tag_virtual_user_url, rbaVar.r().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.p.setTag(R.id.tag_statistic_item, rl9.k(this.k, rbaVar, rbaVar.e0, i4, 2));
                pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                pbCommenFloorItemViewHolder.p.startLoad(avater, 28, false);
                pbCommenFloorItemViewHolder.p.setVisibility(0);
                pbCommenFloorItemViewHolder.E.setVisibility(8);
            }
            if (rbaVar.r() != null && rbaVar.r().getAlaInfo() != null && rbaVar.r().getAlaUserData() != null && rbaVar.r().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.e(true);
                pbCommenFloorItemViewHolder.p.setLiveStatus(1);
                pbCommenFloorItemViewHolder.p.setAlaInfo(rbaVar.r().getAlaInfo());
                pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(rbaVar.r().getAlaInfo());
                threadData = null;
            } else {
                pbCommenFloorItemViewHolder.e(false);
                pbCommenFloorItemViewHolder.p.setLiveStatus(0);
                threadData = null;
                pbCommenFloorItemViewHolder.p.setAlaInfo(null);
                pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(null);
            }
            x0(pbCommenFloorItemViewHolder.i, rbaVar);
            if (TbSingleton.getInstance().isUserGrowthOpen() && rbaVar.r().getUserGrowthData() != null) {
                int a2 = rbaVar.r().getUserGrowthData().a();
                if (a2 >= 0 && a2 <= 10) {
                    pbCommenFloorItemViewHolder.j.setImageResource(ax.b(a2));
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
        vl9 vl9Var2 = this.a;
        if (vl9Var2 == null || vl9Var2.Y() == null || !this.a.Y().A0() || rbaVar.r() == null) {
            str = "";
            i3 = 0;
        } else {
            i3 = rbaVar.r().getLevel_id();
            str = rbaVar.r().getLevelName();
        }
        td9 td9Var5 = this.k;
        if (td9Var5 != null && td9Var5.j0()) {
            i3 = 0;
        }
        if (i3 > 0) {
            pbCommenFloorItemViewHolder.D.setVisibility(0);
            pbCommenFloorItemViewHolder.D.setLevel(i3, str);
        } else {
            pbCommenFloorItemViewHolder.D.setVisibility(8);
        }
        if (((rba) getItem(i2)).V() == 1 && this.k.O() != null && this.k.O().isQuestionThread() && !O(rbaVar)) {
            ((rba) getItem(i2)).X0(true);
            pbCommenFloorItemViewHolder.x0.setVisibility(0);
            if (((rba) getItem(i2)).U().booleanValue()) {
                pbCommenFloorItemViewHolder.y0.setVisibility(0);
                pbCommenFloorItemViewHolder.c0.setVisibility(8);
                pbCommenFloorItemViewHolder.d0.setVisibility(8);
                pbCommenFloorItemViewHolder.y0.postDelayed(new o(this, pbCommenFloorItemViewHolder), 3000L);
            } else {
                pbCommenFloorItemViewHolder.y0.setVisibility(8);
                pbCommenFloorItemViewHolder.c0.setVisibility(0);
                pbCommenFloorItemViewHolder.d0.setVisibility(0);
            }
        } else {
            ((rba) getItem(i2)).X0(false);
            pbCommenFloorItemViewHolder.x0.setVisibility(8);
            pbCommenFloorItemViewHolder.y0.setVisibility(8);
            pbCommenFloorItemViewHolder.c0.setVisibility(0);
            pbCommenFloorItemViewHolder.d0.setVisibility(0);
        }
        SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.x0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w0, R.color.CAM_X0105, 1);
        J(rbaVar, pbCommenFloorItemViewHolder, 2);
        pbCommenFloorItemViewHolder.f.post(new p(this, pbCommenFloorItemViewHolder, (rbaVar.r() == null || rbaVar.r().getName_show() == null) ? "" : rbaVar.r().getName_show()));
        if (!StringUtils.isNull(rbaVar.r().getDiplayIntro())) {
            pbCommenFloorItemViewHolder.z0.setVisibility(0);
            pbCommenFloorItemViewHolder.z0.setText(rbaVar.r().getDiplayIntro() + "");
        } else {
            pbCommenFloorItemViewHolder.z0.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, rbaVar);
        sparseArray.put(R.id.tag_load_sub_data, rbaVar);
        sparseArray.put(R.id.tag_load_sub_view, view2);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(rbaVar.I()));
        sparseArray.put(R.id.tag_forbid_user_post_id, rbaVar.S());
        sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.o);
        sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.c0);
        sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.y);
        sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.z);
        td9 td9Var6 = this.k;
        ThreadData O = (td9Var6 == null || td9Var6.O() == null) ? threadData : this.k.O();
        if (O != null && O.isUgcThreadType()) {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z8 = (rbaVar.r() == null || StringUtils.isNull(rbaVar.r().getVirtualUserUrl())) ? false : true;
        td9 td9Var7 = this.k;
        if (td9Var7 == null || td9Var7.W() == 0 || i0()) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            z = (this.k.W() == 1002 || this.k.W() == 3) ? false : true;
            if (this.k.W() == 3 || this.k.j0()) {
                z2 = false;
                z3 = false;
            } else {
                z2 = true;
                z3 = true;
            }
            if (rbaVar != null && rbaVar.r() != null) {
                String userId = rbaVar.r().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        td9 td9Var8 = this.k;
        if (td9Var8 != null && td9Var8.O() != null && this.k.O().getAuthor() != null && rbaVar.r() != null) {
            String userId2 = this.k.O().getAuthor().getUserId();
            String userId3 = rbaVar.r().getUserId();
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
                if (rbaVar != null && rbaVar.r() != null && UtilHelper.isCurrentAccount(rbaVar.r().getUserId())) {
                    z6 = true;
                    z4 = true;
                }
                if (z8) {
                    z = false;
                    z5 = false;
                    z4 = false;
                }
                int i5 = rbaVar.I() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.W()));
                    if (rbaVar.r() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, rbaVar.r().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, rbaVar.r().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, rbaVar.r().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (rbaVar.r() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, rbaVar.r().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, rbaVar.r().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, rbaVar.r().getName_show());
                    }
                    if (this.k.O() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.k.O().getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, rbaVar.S());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(rbaVar.z0()));
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.W()));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                    sparseArray.put(R.id.tag_del_post_id, rbaVar.S());
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
        if (rbaVar != null) {
            z6 = true;
            z4 = true;
        }
        if (z8) {
        }
        if (rbaVar.I() != 1) {
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
        if (interceptable == null || interceptable.invokeL(1048616, this, view2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ og9 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            /* renamed from: com.baidu.tieba.og9$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class View$OnClickListenerC0416a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0416a(a aVar) {
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
                        rl9.x("c14886");
                        f fVar = this.a.a;
                        if (fVar.c.getItem(fVar.a) instanceof rba) {
                            f fVar2 = this.a.a;
                            og9 og9Var = fVar2.c;
                            og9Var.j0(((rba) og9Var.getItem(fVar2.a)).r());
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
                        if (fVar.c.getItem(fVar.a) instanceof rba) {
                            f fVar2 = this.a.a;
                            rba rbaVar = (rba) fVar2.c.getItem(fVar2.a);
                            rbaVar.K0();
                            if (rbaVar.d0() <= 0) {
                                rbaVar.d1(Boolean.FALSE);
                                this.a.a.b.y0.setVisibility(8);
                                this.a.a.b.c0.setVisibility(0);
                                this.a.a.b.d0.setVisibility(0);
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
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.b.c0.getAgreeFlag()) {
                    return;
                }
                f fVar = this.a;
                ((rba) fVar.c.getItem(fVar.a)).J0();
                f fVar2 = this.a;
                ((rba) fVar2.c.getItem(fVar2.a)).d1(Boolean.TRUE);
                this.a.b.c0.setVisibility(8);
                this.a.b.d0.setVisibility(8);
                this.a.b.y0.setVisibility(0);
                this.a.b.y0.setOnClickListener(new View$OnClickListenerC0416a(this));
                this.a.b.y0.postDelayed(new b(this), 5000L);
            }
        }

        public f(og9 og9Var, int i, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var, Integer.valueOf(i), pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = og9Var;
            this.a = i;
            this.b = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !UtilHelper.isCurrentAccount(this.c.k.O().getAuthor().getUserId()) || !this.c.k.O().isQuestionThread() || UtilHelper.isCurrentAccount(((rba) this.c.getItem(this.a)).r().getUserId())) {
                return;
            }
            if (this.b.c0.getAgreeFlag()) {
                ((rba) this.c.getItem(this.a)).e1(1);
                this.b.x0.setVisibility(0);
                ((rba) this.c.getItem(this.a)).X0(true);
                this.b.i.setVisibility(8);
                this.b.c0.postDelayed(new a(this), 900L);
                return;
            }
            ((rba) this.c.getItem(this.a)).e1(0);
            this.b.y0.setVisibility(8);
            this.b.x0.setVisibility(8);
            this.b.c0.setVisibility(0);
            this.b.d0.setVisibility(0);
            ((rba) this.c.getItem(this.a)).X0(false);
            if (((rba) this.c.getItem(this.a)).g0().booleanValue()) {
                this.b.i.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ kj9 b;
        public final /* synthetic */ og9 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ rba a;
            public final /* synthetic */ c b;

            public a(c cVar, rba rbaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, rbaVar};
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
                this.a = rbaVar;
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

        public c(og9 og9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, kj9 kj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var, pbCommenFloorItemViewHolder, kj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = og9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = kj9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            rba rbaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof rba) && (rbaVar = (rba) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b != null) {
                SafeHandler.getInst().postDelayed(new a(this, rbaVar), 100L);
                String Q = this.c.k.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.c.k.Q())) && this.c.k.O() != null) {
                    Q = this.c.k.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.c.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", rbaVar.S()).param("obj_source", this.c.h0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rba a;
        public final /* synthetic */ og9 b;

        public a(og9 og9Var, rba rbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var, rbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = og9Var;
            this.a = rbaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                rba rbaVar = this.a;
                if (rbaVar != null && rbaVar.r() != null) {
                    xw5.d(this.b.k.l(), this.a.r().getPortrait(), "3", this.b.b.getContext());
                }
                yw5.c("c15281", this.b.k.l(), "3");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public b(og9 og9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var, pbCommenFloorItemViewHolder};
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
        public final /* synthetic */ og9 b;

        public d(og9 og9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = og9Var;
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
                String Q = this.b.k.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.k.Q())) && this.b.k.O() != null) {
                    Q = this.b.k.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", this.b.h0(this.a.o)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ og9 b;

        public e(og9 og9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = og9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.c0) != null && agreeView.getData() != null) {
                if (view2 == this.a.c0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String Q = this.b.k.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.k.Q())) && this.b.k.O() != null) {
                    Q = this.b.k.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.c0.getData().postId).param("obj_source", this.b.h0(this.a.c0)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og9 a;

        public g(og9 og9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og9Var;
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
    public class h implements bg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og9 a;

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

        public h(og9 og9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
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
    public class i implements bg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public i(og9 og9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
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
        @Override // com.baidu.tieba.bg
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
    public class j implements af9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og9 a;

        @Override // com.baidu.tieba.af9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public j(og9 og9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og9Var;
        }

        @Override // com.baidu.tieba.af9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    if ((view2 instanceof TbListTextView) && this.a.m != null) {
                        this.a.m.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.N6(false);
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

        @Override // com.baidu.tieba.af9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (((pbFragment = this.a.b) != null && pbFragment.M5() != null && !this.a.b.M5().e2()) || view2.getId() == R.id.obfuscated_res_0x7f090b70)) {
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

        public k(og9 og9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var, pbCommenFloorItemViewHolder};
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tBLottieAnimationView = this.a.A0) != null) {
                tBLottieAnimationView.setVisibility(8);
                this.a.A0.pauseAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rba a;
        public final /* synthetic */ og9 b;

        public l(og9 og9Var, rba rbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var, rbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = og9Var;
            this.a = rbaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.r() != null && this.a.r().getPortrait() != null && !TextUtils.isEmpty(this.a.r().getPortrait())) {
                String str2 = null;
                if (this.a.u0() != null) {
                    str2 = this.a.u0().getFigureUrl();
                    str = this.a.u0().getBackgroundValue();
                } else {
                    str = null;
                }
                x16.a(this.b.a.Y().getPageContext(), this.a.r().getPortrait(), str2, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ rba b;
        public final /* synthetic */ og9 c;

        public m(og9 og9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var, pbCommenFloorItemViewHolder, rbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = og9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = rbaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.R.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.M(this.a, !z, this.b.M());
                this.b.a1(!z);
                this.c.m0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.M5() != null && this.c.b.M5().D1() != null && this.c.b.M5().m1() != null && !z && this.a.getView().getTop() < this.c.b.M5().D1().getMeasuredHeight()) {
                    this.c.b.M5().m1().setSelectionFromTop(ListUtils.getPosition(this.c.b.M5().m1().getData(), this.b) + this.c.b.M5().m1().getHeaderViewsCount(), this.c.b.M5().D1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ og9 b;

        public n(og9 og9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = og9Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 4, this.a);
            BrowserHelper.startWebActivity(this.b.mContext, (String) null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public o(og9 og9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var, pbCommenFloorItemViewHolder};
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
                this.a.y0.setVisibility(8);
                this.a.c0.setVisibility(0);
                this.a.d0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public p(og9 og9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og9Var, pbCommenFloorItemViewHolder, str};
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
                arrayList.add(this.a.F);
                arrayList.add(this.a.i);
                arrayList.add(this.a.j);
                arrayList.add(this.a.x0);
                arrayList.add(this.a.D);
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                ww5.c(measuredWidth, str, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.D, arrayList, pbCommenFloorItemViewHolder.G);
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder2 = this.a;
                yw5.a(pbCommenFloorItemViewHolder2.g, pbCommenFloorItemViewHolder2.F, pbCommenFloorItemViewHolder2.j, pbCommenFloorItemViewHolder2.D, pbCommenFloorItemViewHolder2.G, 1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public og9(vl9 vl9Var, BdUniqueId bdUniqueId) {
        super(vl9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vl9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((vl9) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.y = new ag<>(new h(this), 6, 0);
        this.z = new ag<>(new i(this), 12, 0);
        this.A = new af9(new j(this));
        this.B = false;
        if (vl9Var != null && vl9Var.R() != null) {
            this.t = vl9Var.R().r1();
        }
    }

    public final void G(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.o);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new g(this));
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

    public void r(td9 td9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, td9Var) == null) {
            this.k = td9Var;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.r = z;
        }
    }

    public void s0(af9 af9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, af9Var) == null) {
            this.o = af9Var;
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
        if (!(tag instanceof rba)) {
            return;
        }
        x0(textView, (rba) tag);
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, rbaVar) == null) && pbCommenFloorItemViewHolder != null && rbaVar != null && (imageView = pbCommenFloorItemViewHolder.H) != null && this.k != null) {
            imageView.setVisibility(8);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, rbaVar) == null) && pbCommenFloorItemViewHolder != null && rbaVar != null) {
            int i2 = 0;
            if (pbCommenFloorItemViewHolder.X.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ImageView imageView = pbCommenFloorItemViewHolder.W;
                if (!rbaVar.c0) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
        }
    }

    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048600, this, pbCommenFloorItemViewHolder, rbaVar) == null) && pbCommenFloorItemViewHolder != null && rbaVar != null) {
            pbCommenFloorItemViewHolder.i(rbaVar.f1156T, rbaVar.S(), this.v);
        }
    }

    public final void m0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, pbCommenFloorItemViewHolder, rbaVar) == null) {
            TbRichText e0 = rbaVar.e0();
            if (e0 != null) {
                e0.isChanged = true;
            }
            pbCommenFloorItemViewHolder.q.setText(e0, true, this.g);
        }
    }

    public final void H(rba rbaVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rbaVar) == null) {
            if (rbaVar != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", rbaVar.S());
                statisticItem.param("pid", rbaVar.S());
                statisticItem.param("tid", rbaVar.o0());
                statisticItem.param("fid", rbaVar.O());
                statisticItem.param("fname", rbaVar.P());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            td9 td9Var = this.k;
            if (td9Var != null) {
                if (td9Var.x0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                        td9 td9Var2 = this.k;
                        int i4 = rbaVar.e0;
                        if (rbaVar.d0) {
                            i3 = 2;
                        } else {
                            i3 = 8;
                        }
                        rl9.e(uniqueId, td9Var2, rbaVar, i4, i3, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                    td9 td9Var3 = this.k;
                    int i5 = rbaVar.e0;
                    if (rbaVar.d0) {
                        i2 = 2;
                    } else {
                        i2 = 8;
                    }
                    rl9.e(uniqueId2, td9Var3, rbaVar, i5, i2, "common_exp_source_pb_comment");
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: k0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07ae, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091b15)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07a6, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.Y().getPageContext(), inflate, this.t);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.v;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.u);
                pbCommenFloorItemViewHolder.v.setIsVideoThread(false);
            }
            u0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.q;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.s);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void n0(rba rbaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, rbaVar) == null) {
            String userId = rbaVar.r().getUserId();
            td9 td9Var = this.k;
            String str2 = "";
            if (td9Var == null) {
                str = "";
            } else {
                str = td9Var.l();
            }
            td9 td9Var2 = this.k;
            if (td9Var2 != null) {
                str2 = td9Var2.m();
            }
            int I = rbaVar.I();
            String S = rbaVar.S();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", S);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, I);
            if (rbaVar.r().getAlaInfo() != null) {
                AlaInfoData alaInfo = rbaVar.r().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void I(rba rbaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rbaVar) == null) && rbaVar.E == 0 && rbaVar.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", rbaVar.S());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            vl9 vl9Var = this.a;
            if (vl9Var != null) {
                int r1 = vl9Var.R().r1();
                if (1 != r1 && 2 != r1) {
                    if (3 == r1) {
                        statisticItem.param("obj_source", "2");
                    } else {
                        statisticItem.param("obj_source", "0");
                    }
                } else {
                    statisticItem.param("obj_source", "1");
                }
            }
            TiebaStatic.log(statisticItem);
            if (rbaVar.r() != null && rbaVar.r().getAlaInfo() != null && rbaVar.r().getAlaInfo().live_status == 1) {
                n0(rbaVar);
            }
        }
    }

    public final void J(rba rbaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, rbaVar, pbCommenFloorItemViewHolder, i2) == null) {
            if (pbCommenFloorItemViewHolder.G != null && rbaVar.r() != null) {
                pbCommenFloorItemViewHolder.G.setTag(R.id.tag_user_id, rbaVar.r().getUserId());
                vl9 vl9Var = this.a;
                if (vl9Var != null && vl9Var.Y() != null) {
                    pbCommenFloorItemViewHolder.G.setOnClickListener(this.a.Y().c.c);
                }
                ArrayList<IconData> iconInfo = rbaVar.r().getIconInfo();
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                pbCommenFloorItemViewHolder.G.g(iconInfo, i2, dimens, dimens, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            if (rbaVar.g0().booleanValue() && !rbaVar.R()) {
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
            int equipmentWidth = ((((BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = s(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().J = (equipmentWidth - i3) - s(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                equipmentWidth /= 2;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((equipmentWidth - i3) * this.i));
            tbRichTextView.getLayoutStrategy().q((int) (equipmentWidth * 1.618f * this.i));
        }
    }

    public final void M(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.R.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.f1143T.setText(R.string.obfuscated_res_0x7f0f06e4);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.f1143T.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.R.setVisibility(0);
            pbCommenFloorItemViewHolder.f1143T.setText(R.string.obfuscated_res_0x7f0f0474);
        }
    }

    public final void N(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, rbaVar}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.I) != null && pbCommenFloorItemViewHolder.S != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.S.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = true;
            boolean z3 = !ListUtils.isEmpty(rbaVar.i0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.I.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.S.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(0);
                if (z3) {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.S.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.I.setLayoutParams(layoutParams);
                }
            } else {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
                if (layoutParams != null) {
                    layoutParams.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds14);
                    pbCommenFloorItemViewHolder.I.setLayoutParams(layoutParams);
                }
            }
            if (pbCommenFloorItemViewHolder.s0.getVisibility() != 0 && pbCommenFloorItemViewHolder.z0.getVisibility() != 0) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().k(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            } else {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().k(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            }
            lqa.b(rbaVar, pbCommenFloorItemViewHolder.q, (TextUtils.isEmpty(rbaVar.u()) || !this.h) ? false : false);
        }
    }

    public final void p0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2, rba rbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048619, this, pbCommenFloorItemViewHolder, i2, rbaVar) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.p);
            if (this.a.Y() != null && this.a.Y().getPageContext() != null && this.a.Y().getPageContext().getOrignalPage() != null) {
                ij9 ij9Var = this.a.Y().c;
                pbCommenFloorItemViewHolder.g.setOnClickListener(ij9Var.b);
                pbCommenFloorItemViewHolder.p.setOnClickListener(ij9Var.b);
                pbCommenFloorItemViewHolder.t0.setOnClickListener(ij9Var.d);
                pbCommenFloorItemViewHolder.s0.setOnClickListener(ij9Var.d);
                pbCommenFloorItemViewHolder.E.setOnClickListener(ij9Var.b);
                pbCommenFloorItemViewHolder.E.getHeadView().setOnClickListener(ij9Var.b);
                pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.q.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.m);
                pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.n);
                pbCommenFloorItemViewHolder.q.setOnImageTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(ij9Var.f);
                pbCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.m);
                pbCommenFloorItemViewHolder.J.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.K.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.M.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.w.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.h0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.l0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.l0.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.D.setOnClickListener(new a(this, rbaVar));
                pbCommenFloorItemViewHolder.d0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.n0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.e0.setOnClickListener(new b(this, pbCommenFloorItemViewHolder));
                kj9 kj9Var = this.a.Y().d;
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.z.setOnClickListener(new c(this, pbCommenFloorItemViewHolder, kj9Var));
                pbCommenFloorItemViewHolder.o.D = new d(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.c0.D = new e(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.c0.setAfterClickListener(new f(this, i2, pbCommenFloorItemViewHolder));
            }
        }
    }

    public final boolean O(rba rbaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rbaVar)) == null) {
            if (this.k.O() != null && this.k.O().getAuthor() != null && this.k.O().getAuthor().getUserId() != null && rbaVar != null && rbaVar.r() != null && rbaVar.r().getUserId() != null) {
                return this.k.O().getAuthor().getUserId().equals(rbaVar.r().getUserId());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void P(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).c0) != null && agreeView.getData() != null && !g0(pbCommenFloorItemViewHolder.q)) {
            pbCommenFloorItemViewHolder.c0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.c0.O();
        }
    }

    public final void Q(rba rbaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, rbaVar) == null) && rbaVar != null) {
            int i2 = 8;
            if (rbaVar.d0) {
                i2 = 2;
            }
            StatisticItem k2 = rl9.k(this.k, rbaVar, rbaVar.e0, i2, 6);
            rbaVar.f0 = k2;
            if (!ListUtils.isEmpty(rbaVar.i0())) {
                Iterator<rba> it = rbaVar.i0().iterator();
                while (it.hasNext()) {
                    it.next().f0 = k2;
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
            rba rbaVar = null;
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return false;
            }
            if (sparseArray.get(R.id.tag_clip_board) instanceof rba) {
                rbaVar = (rba) sparseArray.get(R.id.tag_clip_board);
            }
            if (rbaVar == null) {
                return false;
            }
            return rbaVar.A0();
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
    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        boolean z;
        boolean z2;
        td9 td9Var;
        td9 td9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, rbaVar) == null) && pbCommenFloorItemViewHolder != null && rbaVar != null) {
            String str = null;
            boolean z3 = true;
            if (rbaVar.I() > 0 && (td9Var2 = this.k) != null && !td9Var2.j0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0b1a), Integer.valueOf(rbaVar.I()));
                pbCommenFloorItemViewHolder.C.setVisibility(0);
                pbCommenFloorItemViewHolder.C.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.C.setVisibility(8);
                z = false;
            }
            if (rbaVar.r() != null) {
                str = rbaVar.r().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    og5 Z = rbaVar.Z();
                    z3 = (Z != null || StringUtils.isNull(Z.b()) || (td9Var = this.k) == null || td9Var.j0()) ? false : false;
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
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(rbaVar.p0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(rbaVar.p0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(rbaVar.p0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setText(str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        if (rbaVar.c0) {
                            pbCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(Z.b(), 7, "..."));
                        } else {
                            pbCommenFloorItemViewHolder.n.setText(Z.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.n.setVisibility(8);
                    }
                    TextView textView = pbCommenFloorItemViewHolder.f0;
                    textView.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            og5 Z2 = rbaVar.Z();
            if (Z2 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(rbaVar.p0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView2 = pbCommenFloorItemViewHolder.f0;
            textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048589, this, pbCommenFloorItemViewHolder, rbaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && rbaVar != null) {
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.e0.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.n0.setVisibility(8);
            e0(pbCommenFloorItemViewHolder, rbaVar, view2, i2);
            R(pbCommenFloorItemViewHolder, rbaVar);
            V(pbCommenFloorItemViewHolder, rbaVar);
            Y(pbCommenFloorItemViewHolder, rbaVar, view2);
            X(pbCommenFloorItemViewHolder, rbaVar, view2, i2);
            S(pbCommenFloorItemViewHolder, rbaVar);
            b0(pbCommenFloorItemViewHolder, rbaVar);
            W(pbCommenFloorItemViewHolder, rbaVar);
            v0(pbCommenFloorItemViewHolder, rbaVar);
            c0(pbCommenFloorItemViewHolder, rbaVar);
            mf9.j(pbCommenFloorItemViewHolder, rbaVar, view2, this.h, this.A);
            a0(pbCommenFloorItemViewHolder, rbaVar);
            T(pbCommenFloorItemViewHolder, rbaVar);
            Z(pbCommenFloorItemViewHolder, rbaVar);
            d0(pbCommenFloorItemViewHolder, rbaVar);
            f0(pbCommenFloorItemViewHolder, rbaVar);
            mf9.o(pbCommenFloorItemViewHolder, view2, rbaVar, this.r, true);
            mf9.h(pbCommenFloorItemViewHolder, rbaVar, this.k, this.mContext);
        }
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, rbaVar) == null) && pbCommenFloorItemViewHolder != null && rbaVar != null && rbaVar.o() != null) {
            rbaVar.o().threadId = this.a.R().M1();
            rbaVar.o().objType = 1;
            rbaVar.o().isInPost = true;
            ThreadData threadData = null;
            td9 td9Var = this.k;
            if (td9Var != null && td9Var.O() != null) {
                threadData = this.k.O();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setThreadData(threadData);
            pbCommenFloorItemViewHolder.o.setData(rbaVar.o());
            pbCommenFloorItemViewHolder.c0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.c0.setData(rbaVar.o());
        }
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, pbCommenFloorItemViewHolder, rbaVar) == null) {
            if (rbaVar != null && rbaVar.r() != null && rbaVar.l0() != null) {
                TbRichText e0 = rbaVar.e0();
                if (e0 != null && StringUtils.isNull(e0.toString()) && StringUtils.isNull(rbaVar.u())) {
                    z = true;
                } else {
                    z = false;
                }
                if (rbaVar.r().getSmallTailThemeData() != null) {
                    str = rbaVar.r().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.J.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                gm9.c(rbaVar.l0(), pbCommenFloorItemViewHolder.J, pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, false, false, z, rbaVar.r().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.J.setVisibility(8);
            pbCommenFloorItemViewHolder.K.setVisibility(8);
        }
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, pbCommenFloorItemViewHolder, rbaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.P != null && pbCommenFloorItemViewHolder.M != null) {
            if (rbaVar != null && (alaLiveInfoCoreData = rbaVar.U) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.P.setText(rbaVar.U.liveTitle);
                pbCommenFloorItemViewHolder.M.setTag(rbaVar.U);
                pbCommenFloorItemViewHolder.M.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbCommenFloorItemViewHolder.M.setVisibility(8);
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, pbCommenFloorItemViewHolder, rbaVar) == null) {
            if (rbaVar.N() != 2 && rbaVar.N() != 4) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                pbCommenFloorItemViewHolder.R.setVisibility(0);
                N(false, pbCommenFloorItemViewHolder, rbaVar);
            } else {
                pbCommenFloorItemViewHolder.S.setOnClickListener(new m(this, pbCommenFloorItemViewHolder, rbaVar));
                pbCommenFloorItemViewHolder.S.setVisibility(0);
                M(pbCommenFloorItemViewHolder, rbaVar.D0(), rbaVar.M());
                N(true, pbCommenFloorItemViewHolder, rbaVar);
            }
            m0(pbCommenFloorItemViewHolder, rbaVar);
        }
    }

    public final void f0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, pbCommenFloorItemViewHolder, rbaVar) == null) && pbCommenFloorItemViewHolder != null && WorldCupEnableSwitch.isOn() && rbaVar != null) {
            AgreeView agreeView = pbCommenFloorItemViewHolder.c0;
            if (agreeView != null) {
                agreeView.setAgreeAlone(true);
                pbCommenFloorItemViewHolder.c0.setPadding(0, 0, 0, 0);
            }
            TbImageView tbImageView = pbCommenFloorItemViewHolder.B0;
            if (tbImageView != null) {
                tbImageView.setVisibility(0);
                pbCommenFloorItemViewHolder.B0.setImageResource(R.drawable.obfuscated_res_0x7f080a09);
                pbCommenFloorItemViewHolder.B0.setOnClickListener(new l(this, rbaVar));
            }
            HeadWorldCupFlagLayout headWorldCupFlagLayout = pbCommenFloorItemViewHolder.C0;
            if (headWorldCupFlagLayout != null) {
                headWorldCupFlagLayout.b(rbaVar.r());
            }
        }
    }

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048592, this, pbCommenFloorItemViewHolder, rbaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && rbaVar != null) {
            if (rbaVar.k0() > 0) {
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.x.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.x.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, rbaVar);
                if (rbaVar.N() == 2) {
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
                sparseArray2.put(R.id.tag_load_sub_data, rbaVar);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, rbaVar);
            }
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            if (!rbaVar.z0() && !rbaVar.y0(false)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams2.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds0);
                layoutParams2.leftMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams2);
                if (this.q == null) {
                    al9 al9Var = new al9(this.mContext);
                    this.q = al9Var;
                    al9Var.f(this.e);
                    this.q.h(this.l);
                    this.q.e(this.m);
                    String str = null;
                    td9 td9Var = this.k;
                    if (td9Var != null && td9Var.O() != null && this.k.O().getAuthor() != null) {
                        str = this.k.O().getAuthor().getUserId();
                    }
                    boolean z = true;
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    td9 td9Var2 = this.k;
                    if (td9Var2 != null) {
                        this.q.j(td9Var2.W(), z);
                        this.q.i(this.k.O());
                    }
                }
                this.q.g(rbaVar.S());
                pbCommenFloorItemViewHolder.v.setSubPbAdapter(this.q);
                pbCommenFloorItemViewHolder.v.setVisibility(0);
                pbCommenFloorItemViewHolder.v.setData(rbaVar, view2);
                pbCommenFloorItemViewHolder.v.setChildOnClickListener(this.m);
                pbCommenFloorItemViewHolder.v.setChildOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.v.setChildOnTouchListener(this.A);
            }
            if (rbaVar.P) {
                pbCommenFloorItemViewHolder.I.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.I.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams3.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.w.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.u.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.u.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.g0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1223));
        }
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048593, this, pbCommenFloorItemViewHolder, rbaVar, view2) == null) && pbCommenFloorItemViewHolder != null && rbaVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds148);
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
            K(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(rbaVar.u()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.q.setTid(this.k.Q());
            pbCommenFloorItemViewHolder.q.setPid(rbaVar.S());
            pbCommenFloorItemViewHolder.q.setPosition(TbRichTextView.Position.PB_COMMENT_FLOOR);
            pbCommenFloorItemViewHolder.q.setText(rbaVar.e0(), true, this.g);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, rbaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            sparseArray.put(R.id.tag_is_top_question, Boolean.FALSE);
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.n0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.d0.setTag(sparseArray);
        }
    }

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, rbaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            vl9 vl9Var = this.a;
            if (vl9Var != null && vl9Var.R() != null && StringHelper.equals(this.a.R().T0(), rbaVar.S())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, pbCommenFloorItemViewHolder, rbaVar) == null) && pbCommenFloorItemViewHolder != null && rbaVar != null) {
            String f0 = rbaVar.f0();
            if (!StringUtils.isNull(f0)) {
                pbCommenFloorItemViewHolder.X.startLoad(f0, 10, false);
                pbCommenFloorItemViewHolder.X.setVisibility(0);
                pbCommenFloorItemViewHolder.W.setVisibility(8);
                return;
            }
            pbCommenFloorItemViewHolder.X.setVisibility(8);
        }
    }

    public final boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            td9 td9Var = this.k;
            if (td9Var != null && td9Var.O() != null) {
                return this.k.O().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View l0(int i2, View view2, ViewGroup viewGroup, rba rbaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, rbaVar, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) rbaVar, (rba) pbCommenFloorItemViewHolder);
            u0(pbCommenFloorItemViewHolder);
            p0(pbCommenFloorItemViewHolder, i2, rbaVar);
            G(pbCommenFloorItemViewHolder);
            rba rbaVar2 = (rba) getItem(i2);
            if (rbaVar2 != null) {
                rbaVar2.e0 = i2 + 1;
                I(rbaVar2);
                H(rbaVar2);
                rbaVar2.y1();
                Q(rbaVar2);
                U(pbCommenFloorItemViewHolder, rbaVar2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.qg9, com.baidu.tieba.lm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i2, view2, viewGroup, (rba) obj, (PbCommenFloorItemViewHolder) viewHolder);
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
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.C, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbCommenFloorItemViewHolder.s.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.s.g(skinType);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.v, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f080b9d, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080b9e, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.v.d();
            pbCommenFloorItemViewHolder.t.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.N, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.M, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.O, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.Q, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f1143T, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.R.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbCommenFloorItemViewHolder.f1143T.setText(R.string.obfuscated_res_0x7f0f0474);
            } else {
                td9 td9Var = this.k;
                if (td9Var != null && StringUtils.isNull(td9Var.j())) {
                    pbCommenFloorItemViewHolder.f1143T.setText(this.k.j());
                } else {
                    pbCommenFloorItemViewHolder.f1143T.setText(R.string.obfuscated_res_0x7f0f06e4);
                }
            }
            pbCommenFloorItemViewHolder.o.Q(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.d(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.I, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.d0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.n0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.c();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    public void v0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, rba rbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, pbCommenFloorItemViewHolder, rbaVar) == null) {
            String str = "#7F66FE";
            if (rbaVar.u0() != null) {
                VirtualImageCustomFigure u0 = rbaVar.u0();
                pbCommenFloorItemViewHolder.t0.setHeadImageViewResource(u0.getFigureUrl());
                pbCommenFloorItemViewHolder.t0.setTid(rbaVar.S());
                pbCommenFloorItemViewHolder.t0.setLocate(ei9.c);
                pbCommenFloorItemViewHolder.t0.setFrom(5);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(u0.getBackGroundType())) {
                    str = u0.getBackgroundValue();
                    pbCommenFloorItemViewHolder.t0.setHeadImageBackgroundColorResource(u0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(u0.getBackGroundType())) {
                    pbCommenFloorItemViewHolder.t0.setHeadImageBackgroundResource(u0.getBackgroundValue());
                }
                pbCommenFloorItemViewHolder.t0.f(rbaVar.r());
                pbCommenFloorItemViewHolder.r0.setVisibility(8);
                pbCommenFloorItemViewHolder.u0.setVisibility(0);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_id, rbaVar.r().getUserId());
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_name, rbaVar.r().getUserName());
                pbCommenFloorItemViewHolder.g();
                String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb");
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.Y() != null && this.b.Y().getIntent() != null && this.b.Y().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && !this.B && SharedPrefHelper.getInstance().getInt(sharedPrefKeyWithAccount, 0) == 3 && !ak9.c(this.k) && (rbaVar.x() == null || !wb9.c())) {
                    this.B = true;
                    pbCommenFloorItemViewHolder.A0.setVisibility(0);
                    pbCommenFloorItemViewHolder.A0.playAnimation();
                    SafeHandler.getInst().postDelayed(new k(this, pbCommenFloorItemViewHolder), 4000L);
                }
            } else {
                pbCommenFloorItemViewHolder.u0.setVisibility(8);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_id, null);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.r0.setVisibility(0);
                pbCommenFloorItemViewHolder.A0.setVisibility(8);
                pbCommenFloorItemViewHolder.A0.pauseAnimation();
            }
            if (rbaVar.v0() != null && !TextUtils.isEmpty(rbaVar.v0().getIcon())) {
                pbCommenFloorItemViewHolder.s0.setData(rbaVar.v0(), false, str);
                pbCommenFloorItemViewHolder.s0.setVisibility(0);
                if (pbCommenFloorItemViewHolder.v0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.v0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbCommenFloorItemViewHolder.v0.setLayoutParams(marginLayoutParams);
                }
                pbCommenFloorItemViewHolder.s0.setTag(R.id.tag_user_id, rbaVar.r().getUserId());
                pbCommenFloorItemViewHolder.s0.setTag(R.id.tag_user_name, rbaVar.r().getUserName());
                this.w = ei9.d;
                this.x = pbCommenFloorItemViewHolder.s0.getData();
                pbCommenFloorItemViewHolder.t0.setWithBubble(this.w);
                pbCommenFloorItemViewHolder.t0.setBubbleName(this.x);
                pbCommenFloorItemViewHolder.t0.setVirtualHeadUid(rbaVar.r().getUserId());
            } else {
                if (pbCommenFloorItemViewHolder.v0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.v0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbCommenFloorItemViewHolder.v0.setLayoutParams(marginLayoutParams2);
                }
                pbCommenFloorItemViewHolder.s0.setVisibility(8);
                pbCommenFloorItemViewHolder.s0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.s0.setTag(R.id.tag_user_id, null);
                int i2 = ei9.e;
                this.w = i2;
                pbCommenFloorItemViewHolder.t0.setWithBubble(i2);
            }
            if (pbCommenFloorItemViewHolder.t0.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.t0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            if (rbaVar.u0() != null) {
                ei9.a(2, rbaVar.S(), ei9.c, this.w, this.x, rbaVar.t());
            }
        }
    }

    public final void x0(TextView textView, rba rbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, textView, rbaVar) == null) {
            if (textView == null && rbaVar == null) {
                return;
            }
            textView.setTag(rbaVar);
            td9 td9Var = this.k;
            if (td9Var != null && td9Var.j0()) {
                rbaVar.l1(Boolean.FALSE);
                rbaVar.Z0(0);
                textView.setTag(null);
            } else if (rbaVar.r() != null) {
                com.baidu.tbadk.core.data.MetaData r = rbaVar.r();
                String str = this.j;
                if (str != null && !str.equals("0") && this.j.equals(r.getUserId())) {
                    rbaVar.l1(Boolean.TRUE);
                    rbaVar.Z0(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    EMManager.from(textView).setCorner(R.string.J_X04).setBorderWidth(R.dimen.L_X01).setTextColor(R.color.CAM_X0302).setBorderColor(R.color.CAM_X0302);
                } else if (r.getIs_bawu() == 1 && rbaVar.B0()) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    rbaVar.l1(Boolean.TRUE);
                    rbaVar.Z0(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.brand_official);
                } else if (r.getIs_bawu() == 1 && "manager".equals(r.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    rbaVar.l1(Boolean.TRUE);
                    rbaVar.Z0(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (r.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(r.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    rbaVar.l1(Boolean.TRUE);
                    rbaVar.Z0(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (r.getIs_bawu() == 1 && "pri_content_assist".equals(r.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    rbaVar.l1(Boolean.TRUE);
                    rbaVar.Z0(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (r.getIs_bawu() == 1 && "pri_manage_assist".equals(r.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    rbaVar.l1(Boolean.TRUE);
                    rbaVar.Z0(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    rbaVar.l1(Boolean.FALSE);
                    rbaVar.Z0(0);
                }
            } else {
                rbaVar.l1(Boolean.FALSE);
                rbaVar.Z0(0);
            }
        }
    }
}
