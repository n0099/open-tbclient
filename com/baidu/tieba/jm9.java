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
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.feedback.AigcFeedbackHelper;
import com.baidu.tieba.pb.feedback.FeedbackButtonStateType;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.vk9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import tbclient.AigcFeedbackInfo;
/* loaded from: classes6.dex */
public class jm9 extends lm9<tha, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vk9 A;
    public boolean B;
    public TbRichTextView.t g;
    public boolean h;
    public float i;
    public String j;
    public aj9 k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public TbRichTextView.z n;
    public vk9 o;
    public View.OnLongClickListener p;
    public wq9 q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public String x;
    public bg<ConstrainImageLayout> y;
    public bg<TbImageView> z;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:217:0x06a0  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x06f7  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0767  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0771  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x07b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2, int i2) {
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
        if (!(interceptable == null || interceptable.invokeLLLI(1048621, this, pbCommenFloorItemViewHolder, thaVar, view2, i2) == null) || pbCommenFloorItemViewHolder == null || thaVar == null) {
            return;
        }
        if (thaVar.R) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.e.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.e.setVisibility(8);
        }
        pbCommenFloorItemViewHolder.p.setTag(null);
        pbCommenFloorItemViewHolder.p.setUserId(null);
        pbCommenFloorItemViewHolder.E.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.q.setIsHost(false);
        if (thaVar.t() != null) {
            String str2 = this.j;
            if (str2 != null && !str2.equals("0") && this.j.equals(thaVar.t().getUserId())) {
                pbCommenFloorItemViewHolder.q.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = thaVar.t().getIconInfo();
            ArrayList<IconData> tShowInfoNew = thaVar.t().getTShowInfoNew();
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (iconInfo.size() < 2) {
                int size = iconInfo.size();
                if (size > 1) {
                    thaVar.x1((dimens * size) + (dimens2 * size));
                } else if (size == 1) {
                    thaVar.x1(dimens + dimens2);
                } else {
                    thaVar.x1(0);
                }
            } else {
                thaVar.x1((dimens * 2) + (dimens2 * 2));
            }
            if (pbCommenFloorItemViewHolder.F != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.F.setTag(tShowInfoNew.get(0).getUrl());
                }
                rr9 rr9Var = this.a;
                if (rr9Var != null && rr9Var.e0() != null) {
                    pbCommenFloorItemViewHolder.F.setOnClickListener(this.a.e0().c.e);
                }
                int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.F.h(tShowInfoNew, 3, dimens3, dimens3, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !thaVar.t().isBigV()) {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
            }
            String avater = thaVar.t().getAvater();
            int i4 = thaVar.e0 ? 2 : 8;
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_id, thaVar.t().getUserId());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, thaVar.t().getUserName());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, thaVar.t().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, nr9.k(this.k, thaVar, thaVar.f0, i4, 2));
            String name_show = thaVar.t().getName_show();
            String userName = thaVar.t().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.h.setText(eh9.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                pbCommenFloorItemViewHolder.g.setGravity(16);
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, eh9.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
            }
            if (thaVar.t().getPendantData() != null && !StringUtils.isNull(thaVar.t().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.E.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.E.i(thaVar.t());
                pbCommenFloorItemViewHolder.p.setVisibility(8);
                pbCommenFloorItemViewHolder.E.setVisibility(0);
                pbCommenFloorItemViewHolder.E.getHeadView().startLoad(avater, 28, false);
                pbCommenFloorItemViewHolder.E.getHeadView().setUserId(thaVar.t().getUserId());
                pbCommenFloorItemViewHolder.E.getHeadView().setUserName(thaVar.t().getUserName());
                aj9 aj9Var = this.k;
                pbCommenFloorItemViewHolder.E.getHeadView().setFid(aj9Var != null ? aj9Var.l() : "");
                aj9 aj9Var2 = this.k;
                pbCommenFloorItemViewHolder.E.getHeadView().setFName(aj9Var2 != null ? aj9Var2.m() : "");
                pbCommenFloorItemViewHolder.E.getHeadView().setFloor(thaVar.L());
                pbCommenFloorItemViewHolder.E.getHeadView().setTid(thaVar.U());
                pbCommenFloorItemViewHolder.E.getHeadView().setTag(R.id.tag_statistic_item, nr9.k(this.k, thaVar, thaVar.f0, i4, 2));
                pbCommenFloorItemViewHolder.E.i(thaVar.t());
            } else {
                pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, thaVar.t(), 4);
                pbCommenFloorItemViewHolder.p.setUserId(thaVar.t().getUserId());
                aj9 aj9Var3 = this.k;
                pbCommenFloorItemViewHolder.p.setFid(aj9Var3 != null ? aj9Var3.l() : "");
                aj9 aj9Var4 = this.k;
                pbCommenFloorItemViewHolder.p.setFName(aj9Var4 != null ? aj9Var4.m() : "");
                pbCommenFloorItemViewHolder.p.setFloor(thaVar.L());
                pbCommenFloorItemViewHolder.p.setTid(thaVar.U());
                pbCommenFloorItemViewHolder.p.setUserName(thaVar.t().getUserName(), thaVar.t0());
                pbCommenFloorItemViewHolder.p.setTag(R.id.tag_virtual_user_url, thaVar.t().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.p.setTag(R.id.tag_statistic_item, nr9.k(this.k, thaVar, thaVar.f0, i4, 2));
                pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                pbCommenFloorItemViewHolder.p.startLoad(avater, 28, false);
                pbCommenFloorItemViewHolder.p.setVisibility(0);
                pbCommenFloorItemViewHolder.E.setVisibility(8);
            }
            if (thaVar.t() != null && thaVar.t().getAlaInfo() != null && thaVar.t().getAlaUserData() != null && thaVar.t().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.d(true);
                pbCommenFloorItemViewHolder.p.setLiveStatus(1);
                pbCommenFloorItemViewHolder.p.setAlaInfo(thaVar.t().getAlaInfo());
                pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(thaVar.t().getAlaInfo());
                threadData = null;
            } else {
                pbCommenFloorItemViewHolder.d(false);
                pbCommenFloorItemViewHolder.p.setLiveStatus(0);
                threadData = null;
                pbCommenFloorItemViewHolder.p.setAlaInfo(null);
                pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(null);
            }
            oo9.e(pbCommenFloorItemViewHolder.i, thaVar, this.k, this.j);
            if (TbSingleton.getInstance().isUserGrowthOpen() && thaVar.t().getUserGrowthData() != null) {
                int a2 = thaVar.t().getUserGrowthData().a();
                if (a2 >= 0 && a2 <= 10) {
                    pbCommenFloorItemViewHolder.j.setImageResource(ex.b(a2));
                    pbCommenFloorItemViewHolder.j.setVisibility(0);
                    pbCommenFloorItemViewHolder.j.setOnClickListener(new r(this, a2));
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 4, a2);
                } else {
                    pbCommenFloorItemViewHolder.j.setVisibility(8);
                }
            }
        } else {
            threadData = null;
        }
        rr9 rr9Var2 = this.a;
        if (rr9Var2 == null || rr9Var2.e0() == null || !this.a.e0().I0() || thaVar.t() == null) {
            str = "";
            i3 = 0;
        } else {
            i3 = thaVar.t().getLevel_id();
            str = thaVar.t().getLevelName();
        }
        aj9 aj9Var5 = this.k;
        if (aj9Var5 != null && aj9Var5.j0()) {
            i3 = 0;
        }
        if (i3 > 0) {
            pbCommenFloorItemViewHolder.D.setVisibility(0);
            pbCommenFloorItemViewHolder.D.setLevel(i3, str);
        } else {
            pbCommenFloorItemViewHolder.D.setVisibility(8);
        }
        if (((tha) getItem(i2)).W() == 1 && this.k.O() != null && this.k.O().isQuestionThread() && !oo9.a(this.k, thaVar)) {
            ((tha) getItem(i2)).b1(true);
            pbCommenFloorItemViewHolder.x0.setVisibility(0);
            if (((tha) getItem(i2)).V().booleanValue()) {
                pbCommenFloorItemViewHolder.y0.setVisibility(0);
                pbCommenFloorItemViewHolder.c0.setVisibility(8);
                pbCommenFloorItemViewHolder.d0.setVisibility(8);
                pbCommenFloorItemViewHolder.y0.postDelayed(new s(this, pbCommenFloorItemViewHolder, thaVar), 3000L);
            } else {
                pbCommenFloorItemViewHolder.y0.setVisibility(8);
                D0(pbCommenFloorItemViewHolder, thaVar);
                pbCommenFloorItemViewHolder.d0.setVisibility(0);
            }
        } else {
            ((tha) getItem(i2)).b1(false);
            pbCommenFloorItemViewHolder.x0.setVisibility(8);
            pbCommenFloorItemViewHolder.y0.setVisibility(8);
            D0(pbCommenFloorItemViewHolder, thaVar);
            pbCommenFloorItemViewHolder.d0.setVisibility(0);
        }
        SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.x0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w0, R.color.CAM_X0105, 1);
        Q(thaVar, pbCommenFloorItemViewHolder, 2);
        pbCommenFloorItemViewHolder.f.post(new t(this, pbCommenFloorItemViewHolder, (thaVar.t() == null || thaVar.t().getName_show() == null) ? "" : thaVar.t().getName_show()));
        if (!StringUtils.isNull(thaVar.t().getDiplayIntro())) {
            pbCommenFloorItemViewHolder.z0.setVisibility(0);
            pbCommenFloorItemViewHolder.z0.setText(thaVar.t().getDiplayIntro() + "");
        } else {
            pbCommenFloorItemViewHolder.z0.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, thaVar);
        sparseArray.put(R.id.tag_load_sub_data, thaVar);
        sparseArray.put(R.id.tag_load_sub_view, view2);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(thaVar.L()));
        sparseArray.put(R.id.tag_forbid_user_post_id, thaVar.U());
        sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.o);
        sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.c0);
        sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.y);
        sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.z);
        aj9 aj9Var6 = this.k;
        ThreadData O = (aj9Var6 == null || aj9Var6.O() == null) ? threadData : this.k.O();
        if (O != null && O.isUgcThreadType()) {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z8 = (thaVar.t() == null || StringUtils.isNull(thaVar.t().getVirtualUserUrl())) ? false : true;
        aj9 aj9Var7 = this.k;
        if (aj9Var7 == null || aj9Var7.W() == 0 || oo9.c(this.k)) {
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
            if (thaVar != null && thaVar.t() != null) {
                String userId = thaVar.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        aj9 aj9Var8 = this.k;
        if (aj9Var8 != null && aj9Var8.O() != null && this.k.O().getAuthor() != null && thaVar.t() != null) {
            String userId2 = this.k.O().getAuthor().getUserId();
            String userId3 = thaVar.t().getUserId();
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
                if (thaVar != null && thaVar.t() != null && UtilHelper.isCurrentAccount(thaVar.t().getUserId())) {
                    z6 = true;
                    z4 = true;
                }
                if (z8) {
                    z = false;
                    z5 = false;
                    z4 = false;
                }
                int i5 = thaVar.L() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.W()));
                    if (thaVar.t() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, thaVar.t().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, thaVar.t().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, thaVar.t().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (thaVar.t() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, thaVar.t().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, thaVar.t().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, thaVar.t().getName_show());
                    }
                    if (this.k.O() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.k.O().getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, thaVar.U());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(thaVar.A0()));
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.W()));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                    sparseArray.put(R.id.tag_del_post_id, thaVar.U());
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
        if (thaVar != null) {
            z6 = true;
            z4 = true;
        }
        if (z8) {
        }
        if (thaVar.L() != 1) {
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

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ gp9 b;
        public final /* synthetic */ jm9 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tha a;
            public final /* synthetic */ f b;

            public a(f fVar, tha thaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, thaVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = thaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    f fVar = this.b;
                    fVar.b.b.a(fVar.c.k, null, this.a, fVar.a.q.getLayoutStrategy());
                }
            }
        }

        public f(jm9 jm9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, gp9 gp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, pbCommenFloorItemViewHolder, gp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jm9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = gp9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            tha thaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof tha) && (thaVar = (tha) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b != null) {
                SafeHandler.getInst().postDelayed(new a(this, thaVar), 100L);
                String Q = this.c.k.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.c.k.Q())) && this.c.k.O() != null) {
                    Q = this.c.k.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.c.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", thaVar.U()).param("obj_source", this.c.s0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ tha c;
        public final /* synthetic */ jm9 d;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    nr9.x("c14886");
                    j jVar = this.a;
                    if (jVar.d.getItem(jVar.a) instanceof tha) {
                        j jVar2 = this.a;
                        tha thaVar = (tha) jVar2.d.getItem(jVar2.a);
                        if (thaVar.B() != null) {
                            UrlManager.getInstance().dealOneLink(thaVar.B().a());
                            return;
                        }
                        j jVar3 = this.a;
                        jm9 jm9Var = jVar3.d;
                        jm9Var.t0(((tha) jm9Var.getItem(jVar3.a)).t());
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public b(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    j jVar = this.a;
                    if (jVar.d.getItem(jVar.a) instanceof tha) {
                        j jVar2 = this.a;
                        tha thaVar = (tha) jVar2.d.getItem(jVar2.a);
                        thaVar.M0();
                        if (thaVar.e0() <= 0) {
                            thaVar.h1(Boolean.FALSE);
                            this.a.b.y0.setVisibility(8);
                            j jVar3 = this.a;
                            jVar3.d.D0(jVar3.b, jVar3.c);
                            this.a.b.d0.setVisibility(0);
                        }
                    }
                }
            }
        }

        public j(jm9 jm9Var, int i, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, Integer.valueOf(i), pbCommenFloorItemViewHolder, thaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jm9Var;
            this.a = i;
            this.b = pbCommenFloorItemViewHolder;
            this.c = thaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((tha) this.d.getItem(this.a)).L0();
                ((tha) this.d.getItem(this.a)).h1(Boolean.TRUE);
                this.b.c0.setVisibility(8);
                this.b.d0.setVisibility(8);
                this.b.y0.setVisibility(0);
                this.b.y0.setOnClickListener(new a(this));
                this.b.y0.postDelayed(new b(this), 5000L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Function1<FeedbackButtonStateType, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tha a;
        public final /* synthetic */ int b;
        public final /* synthetic */ PbCommenFloorItemViewHolder c;
        public final /* synthetic */ View d;
        public final /* synthetic */ jm9 e;

        public a(jm9 jm9Var, tha thaVar, int i, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, thaVar, Integer.valueOf(i), pbCommenFloorItemViewHolder, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = jm9Var;
            this.a = thaVar;
            this.b = i;
            this.c = pbCommenFloorItemViewHolder;
            this.d = view2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(FeedbackButtonStateType feedbackButtonStateType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, feedbackButtonStateType)) == null) {
                PbFragment pbFragment = this.e.b;
                if (pbFragment == null) {
                    return null;
                }
                pbFragment.F2 = this.a;
                int i = m.a[feedbackButtonStateType.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                this.a.U0(1);
                                this.e.X(this.c, this.a);
                                jm9 jm9Var = this.e;
                                jm9Var.x0(this.c, jm9Var.b.getListView(), this.b);
                                AigcFeedbackHelper.b(this.e.b.getPageContext(), this.a.p());
                                AigcFeedbackHelper.d(this.a);
                                this.e.b0(this.b, this.c, this.a, false, this.d);
                                pk9.b(String.valueOf(this.a.p0()), this.a.U(), false, true);
                            }
                        } else {
                            pk9.e(String.valueOf(this.a.p0()), this.a.U(), this.a.F());
                            this.a.U0(0);
                            AigcFeedbackHelper.b(this.e.b.getPageContext(), this.a.p());
                            this.e.Y(this.c, this.a);
                            pk9.b(String.valueOf(this.a.p0()), this.a.U(), false, false);
                        }
                    } else {
                        pk9.e(String.valueOf(this.a.p0()), this.a.U(), this.a.F());
                        this.a.U0(0);
                        AigcFeedbackHelper.a(this.e.b.getPageContext(), this.a.p());
                        this.e.b0(this.b, this.c, this.a, true, this.d);
                        this.e.Y(this.c, this.a);
                        pk9.b(String.valueOf(this.a.p0()), this.a.U(), true, true);
                    }
                } else {
                    AigcFeedbackHelper.a(this.e.b.getPageContext(), this.a.p());
                    this.e.b0(this.b, this.c, this.a, false, this.d);
                    pk9.b(String.valueOf(this.a.p0()), this.a.U(), true, false);
                }
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Function0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jm9 a;

        public b(jm9 jm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jm9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Boolean invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.mContext == null) {
                    return Boolean.TRUE;
                }
                return Boolean.valueOf(!ViewHelper.checkUpIsLogin(this.a.mContext));
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tha a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ jm9 c;

        public c(jm9 jm9Var, tha thaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, thaVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jm9Var;
            this.a = thaVar;
            this.b = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            tha thaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (thaVar = this.a) == null) {
                return;
            }
            pk9.e(String.valueOf(thaVar.p0()), this.a.U(), this.a.F());
            this.a.U0(0);
            this.c.Y(this.b, this.a);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tha a;
        public final /* synthetic */ jm9 b;

        public d(jm9 jm9Var, tha thaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, thaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jm9Var;
            this.a = thaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                tha thaVar = this.a;
                if (thaVar != null && thaVar.t() != null) {
                    ky5.d(this.b.k.l(), this.a.t().getPortrait(), "3", this.b.b.getContext());
                }
                ly5.c("c15281", this.b.k.l(), "3");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public e(jm9 jm9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, pbCommenFloorItemViewHolder};
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

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ jm9 b;

        public g(jm9 jm9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jm9Var;
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
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", this.b.s0(this.a.o)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ jm9 b;

        public h(jm9 jm9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jm9Var;
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
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.c0.getData().postId).param("obj_source", this.b.s0(this.a.c0)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ tha c;
        public final /* synthetic */ View d;
        public final /* synthetic */ jm9 e;

        public i(jm9 jm9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i, tha thaVar, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, pbCommenFloorItemViewHolder, Integer.valueOf(i), thaVar, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = jm9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = i;
            this.c = thaVar;
            this.d = view2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AgreeView agreeView = this.a.c0;
                if (agreeView != null && agreeView.getAgreeFlag()) {
                    z = true;
                } else {
                    z = false;
                }
                this.e.b0(this.b, this.a, this.c, z, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements cg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jm9 a;

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

        public k(jm9 jm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jm9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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

    /* loaded from: classes6.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jm9 a;

        public l(jm9 jm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jm9Var;
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

    /* loaded from: classes6.dex */
    public static /* synthetic */ class m {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-685158198, "Lcom/baidu/tieba/jm9$m;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-685158198, "Lcom/baidu/tieba/jm9$m;");
                    return;
                }
            }
            int[] iArr = new int[FeedbackButtonStateType.values().length];
            a = iArr;
            try {
                iArr[FeedbackButtonStateType.UNSELECT_POSITIVE_STATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FeedbackButtonStateType.SELECT_POSITIVE_STATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FeedbackButtonStateType.UNSELECT_NEGATIVE_STATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FeedbackButtonStateType.SELECT_NEGATIVE_STATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements cg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jm9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public n(jm9 jm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jm9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
        @Override // com.baidu.tieba.cg
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

    /* loaded from: classes6.dex */
    public class o implements vk9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jm9 a;

        @Override // com.baidu.tieba.vk9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public o(jm9 jm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jm9Var;
        }

        @Override // com.baidu.tieba.vk9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    if ((view2 instanceof TbListTextView) && this.a.m != null) {
                        this.a.m.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.i8(false);
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

        @Override // com.baidu.tieba.vk9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (((pbFragment = this.a.b) != null && pbFragment.H6() != null && !this.a.b.H6().e2()) || view2.getId() == R.id.obfuscated_res_0x7f090b78)) {
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
                            this.a.Z((FrameLayout) parent);
                            break;
                        }
                    }
                } else {
                    this.a.Z(view2);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public p(jm9 jm9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, pbCommenFloorItemViewHolder};
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

    /* loaded from: classes6.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ tha b;
        public final /* synthetic */ jm9 c;

        public q(jm9 jm9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, pbCommenFloorItemViewHolder, thaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jm9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = thaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.R.getVisibility() == 8 && this.a.C0.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.S(this.a, !z, this.b.O());
                this.b.e1(!z);
                this.c.w0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.H6() != null && this.c.b.H6().D1() != null && this.c.b.H6().m1() != null && !z && this.a.getView().getTop() < this.c.b.H6().D1().getMeasuredHeight()) {
                    this.c.b.H6().m1().setSelectionFromTop(ListUtils.getPosition(this.c.b.H6().m1().getData(), this.b) + this.c.b.H6().m1().getHeaderViewsCount(), this.c.b.H6().D1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ jm9 b;

        public r(jm9 jm9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jm9Var;
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

    /* loaded from: classes6.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ tha b;
        public final /* synthetic */ jm9 c;

        public s(jm9 jm9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, pbCommenFloorItemViewHolder, thaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jm9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = thaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y0.setVisibility(8);
                this.c.D0(this.a, this.b);
                this.a.d0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public t(jm9 jm9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm9Var, pbCommenFloorItemViewHolder, str};
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
                jy5.c(measuredWidth, str, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.D, arrayList, pbCommenFloorItemViewHolder.G);
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder2 = this.a;
                ly5.a(pbCommenFloorItemViewHolder2.g, pbCommenFloorItemViewHolder2.F, pbCommenFloorItemViewHolder2.j, pbCommenFloorItemViewHolder2.D, pbCommenFloorItemViewHolder2.G, 1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jm9(rr9 rr9Var, BdUniqueId bdUniqueId) {
        super(rr9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rr9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((rr9) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.y = new bg<>(new k(this), 6, 0);
        this.z = new bg<>(new n(this), 12, 0);
        this.A = new vk9(new o(this));
        this.B = false;
        if (rr9Var != null && rr9Var.X() != null) {
            this.t = rr9Var.X().q1();
        }
    }

    public void B0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.v = z;
        }
    }

    public void C0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.r = z;
        }
    }

    public void E0(vk9 vk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vk9Var) == null) {
            this.o = vk9Var;
        }
    }

    public void F0(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tVar) == null) {
            this.g = tVar;
        }
    }

    public final void N(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.o);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new l(this));
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

    public void n(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, zVar) == null) {
            this.n = zVar;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.j = str;
        }
    }

    public void r(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, aj9Var) == null) {
            this.k = aj9Var;
        }
    }

    public void z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.s = z;
        }
    }

    public final void D0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            if (!thaVar.y0()) {
                pbCommenFloorItemViewHolder.c0.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.c0.setVisibility(8);
            }
        }
    }

    public final void f0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048604, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            int i2 = 0;
            if (pbCommenFloorItemViewHolder.X.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ImageView imageView = pbCommenFloorItemViewHolder.W;
                if (!thaVar.d0) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
        }
    }

    public final void p0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048620, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            pbCommenFloorItemViewHolder.h(thaVar.f1164T, thaVar.U(), this.v);
        }
    }

    public final void w0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, pbCommenFloorItemViewHolder, thaVar) == null) {
            TbRichText f0 = thaVar.f0();
            if (f0 != null) {
                f0.isChanged = true;
            }
            pbCommenFloorItemViewHolder.q.setText(f0, true, this.g);
        }
    }

    public final void A0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2, tha thaVar, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048576, this, pbCommenFloorItemViewHolder, i2, thaVar, view2) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.p);
            if (this.a.e0() != null && this.a.e0().getPageContext() != null && this.a.e0().getPageContext().getOrignalPage() != null) {
                ep9 ep9Var = this.a.e0().c;
                pbCommenFloorItemViewHolder.g.setOnClickListener(ep9Var.b);
                pbCommenFloorItemViewHolder.p.setOnClickListener(ep9Var.b);
                pbCommenFloorItemViewHolder.t0.setOnClickListener(ep9Var.d);
                pbCommenFloorItemViewHolder.s0.setOnClickListener(ep9Var.d);
                pbCommenFloorItemViewHolder.E.setOnClickListener(ep9Var.b);
                pbCommenFloorItemViewHolder.E.getHeadView().setOnClickListener(ep9Var.b);
                pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.q.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.m);
                pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.n);
                pbCommenFloorItemViewHolder.q.setOnImageTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(ep9Var.f);
                pbCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.m);
                pbCommenFloorItemViewHolder.J.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.K.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.M.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.w.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.h0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.l0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.l0.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.D.setOnClickListener(new d(this, thaVar));
                pbCommenFloorItemViewHolder.d0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.n0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.e0.setOnClickListener(new e(this, pbCommenFloorItemViewHolder));
                gp9 gp9Var = this.a.e0().d;
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.z.setOnClickListener(new f(this, pbCommenFloorItemViewHolder, gp9Var));
                pbCommenFloorItemViewHolder.o.D = new g(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.c0.D = new h(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.c0.setAfterClickListener(new i(this, pbCommenFloorItemViewHolder, i2, thaVar, view2));
            }
        }
    }

    public final void G0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            oo9.d(pbCommenFloorItemViewHolder.i, this.k, this.j);
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
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f080bba, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080bbb, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.v.d();
            pbCommenFloorItemViewHolder.t.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.N, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.M, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.O, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.Q, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f1141T, (int) R.color.CAM_X0107);
            if ((pbCommenFloorItemViewHolder.R.getVisibility() == 8 && pbCommenFloorItemViewHolder.C0.getVisibility() == 8) ? false : false) {
                pbCommenFloorItemViewHolder.f1141T.setText(R.string.obfuscated_res_0x7f0f0477);
            } else {
                aj9 aj9Var = this.k;
                if (aj9Var != null && StringUtils.isNull(aj9Var.j())) {
                    pbCommenFloorItemViewHolder.f1141T.setText(this.k.j());
                } else {
                    pbCommenFloorItemViewHolder.f1141T.setText(R.string.obfuscated_res_0x7f0f06ef);
                }
            }
            pbCommenFloorItemViewHolder.o.P(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.I, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.d0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.n0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    public void H0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, pbCommenFloorItemViewHolder, thaVar) == null) {
            String str = "#7F66FE";
            if (thaVar.v0() != null) {
                VirtualImageCustomFigure v0 = thaVar.v0();
                pbCommenFloorItemViewHolder.t0.setHeadImageViewResource(v0.getFigureUrl());
                pbCommenFloorItemViewHolder.t0.setTid(thaVar.U());
                pbCommenFloorItemViewHolder.t0.setLocate(zn9.c);
                pbCommenFloorItemViewHolder.t0.setFrom(5);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(v0.getBackGroundType())) {
                    str = v0.getBackgroundValue();
                    pbCommenFloorItemViewHolder.t0.setHeadImageBackgroundColorResource(v0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(v0.getBackGroundType())) {
                    pbCommenFloorItemViewHolder.t0.setHeadImageBackgroundResource(v0.getBackgroundValue());
                }
                pbCommenFloorItemViewHolder.t0.f(thaVar.t());
                pbCommenFloorItemViewHolder.r0.setVisibility(8);
                pbCommenFloorItemViewHolder.u0.setVisibility(0);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_id, thaVar.t().getUserId());
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_name, thaVar.t().getUserName());
                pbCommenFloorItemViewHolder.f();
                String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb");
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.e0() != null && this.b.e0().getIntent() != null && this.b.e0().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && !this.B && SharedPrefHelper.getInstance().getInt(sharedPrefKeyWithAccount, 0) == 3 && !wp9.c(this.k) && (thaVar.y() == null || !dh9.c())) {
                    this.B = true;
                    pbCommenFloorItemViewHolder.A0.setVisibility(0);
                    pbCommenFloorItemViewHolder.A0.playAnimation();
                    SafeHandler.getInst().postDelayed(new p(this, pbCommenFloorItemViewHolder), 4000L);
                }
            } else {
                pbCommenFloorItemViewHolder.u0.setVisibility(8);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_id, null);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.r0.setVisibility(0);
                pbCommenFloorItemViewHolder.A0.setVisibility(8);
                pbCommenFloorItemViewHolder.A0.pauseAnimation();
            }
            if (thaVar.w0() != null && !TextUtils.isEmpty(thaVar.w0().getIcon())) {
                pbCommenFloorItemViewHolder.s0.setData(thaVar.w0(), false, str);
                pbCommenFloorItemViewHolder.s0.setVisibility(0);
                if (pbCommenFloorItemViewHolder.v0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.v0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbCommenFloorItemViewHolder.v0.setLayoutParams(marginLayoutParams);
                }
                pbCommenFloorItemViewHolder.s0.setTag(R.id.tag_user_id, thaVar.t().getUserId());
                pbCommenFloorItemViewHolder.s0.setTag(R.id.tag_user_name, thaVar.t().getUserName());
                this.w = zn9.d;
                this.x = pbCommenFloorItemViewHolder.s0.getData();
                pbCommenFloorItemViewHolder.t0.setWithBubble(this.w);
                pbCommenFloorItemViewHolder.t0.setBubbleName(this.x);
                pbCommenFloorItemViewHolder.t0.setVirtualHeadUid(thaVar.t().getUserId());
            } else {
                if (pbCommenFloorItemViewHolder.v0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.v0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbCommenFloorItemViewHolder.v0.setLayoutParams(marginLayoutParams2);
                }
                pbCommenFloorItemViewHolder.s0.setVisibility(8);
                pbCommenFloorItemViewHolder.s0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.s0.setTag(R.id.tag_user_id, null);
                int i2 = zn9.e;
                this.w = i2;
                pbCommenFloorItemViewHolder.t0.setWithBubble(i2);
            }
            if (pbCommenFloorItemViewHolder.t0.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.t0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            if (thaVar.v0() != null) {
                zn9.a(2, thaVar.U(), zn9.c, this.w, this.x, thaVar.u());
            }
        }
    }

    public final void O(tha thaVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, thaVar) == null) {
            if (thaVar != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", thaVar.U());
                statisticItem.param("pid", thaVar.U());
                statisticItem.param("tid", thaVar.p0());
                statisticItem.param("fid", thaVar.Q());
                statisticItem.param("fname", thaVar.R());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            aj9 aj9Var = this.k;
            if (aj9Var != null) {
                if (aj9Var.x0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                        aj9 aj9Var2 = this.k;
                        int i4 = thaVar.f0;
                        if (thaVar.e0) {
                            i3 = 2;
                        } else {
                            i3 = 8;
                        }
                        nr9.e(uniqueId, aj9Var2, thaVar, i4, i3, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                    aj9 aj9Var3 = this.k;
                    int i5 = thaVar.f0;
                    if (thaVar.e0) {
                        i2 = 2;
                    } else {
                        i2 = 8;
                    }
                    nr9.e(uniqueId2, aj9Var3, thaVar, i5, i2, "common_exp_source_pb_comment");
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: u0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07c7, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091b51)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07bf, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.e0().getPageContext(), inflate, this.t);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.v;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.u);
                pbCommenFloorItemViewHolder.v.setIsVideoThread(false);
            }
            G0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.q;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.s);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void y0(tha thaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, thaVar) == null) {
            String userId = thaVar.t().getUserId();
            aj9 aj9Var = this.k;
            String str2 = "";
            if (aj9Var == null) {
                str = "";
            } else {
                str = aj9Var.l();
            }
            aj9 aj9Var2 = this.k;
            if (aj9Var2 != null) {
                str2 = aj9Var2.m();
            }
            int L = thaVar.L();
            String U = thaVar.U();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", U);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, L);
            if (thaVar.t().getAlaInfo() != null) {
                AlaInfoData alaInfo = thaVar.t().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void P(tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, thaVar) == null) && thaVar.E == 0 && thaVar.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", thaVar.U());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            rr9 rr9Var = this.a;
            if (rr9Var != null) {
                int q1 = rr9Var.X().q1();
                if (1 != q1 && 2 != q1) {
                    if (3 == q1) {
                        statisticItem.param("obj_source", "2");
                    } else {
                        statisticItem.param("obj_source", "0");
                    }
                } else {
                    statisticItem.param("obj_source", "1");
                }
            }
            TiebaStatic.log(statisticItem);
            if (thaVar.t() != null && thaVar.t().getAlaInfo() != null && thaVar.t().getAlaInfo().live_status == 1) {
                y0(thaVar);
            }
        }
    }

    public final void Q(tha thaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, thaVar, pbCommenFloorItemViewHolder, i2) == null) {
            if (pbCommenFloorItemViewHolder.G != null && thaVar.t() != null) {
                pbCommenFloorItemViewHolder.G.setTag(R.id.tag_user_id, thaVar.t().getUserId());
                rr9 rr9Var = this.a;
                if (rr9Var != null && rr9Var.e0() != null) {
                    pbCommenFloorItemViewHolder.G.setOnClickListener(this.a.e0().c.c);
                }
                ArrayList<IconData> iconInfo = thaVar.t().getIconInfo();
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                pbCommenFloorItemViewHolder.G.g(iconInfo, i2, dimens, dimens, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            if (thaVar.h0().booleanValue() && !thaVar.T()) {
                pbCommenFloorItemViewHolder.i.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.i.setVisibility(8);
            }
        }
    }

    public final void R(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
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

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.R.setVisibility(8);
                pbCommenFloorItemViewHolder.C0.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.f1141T.setText(R.string.obfuscated_res_0x7f0f06ef);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.f1141T.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.R.setVisibility(0);
            pbCommenFloorItemViewHolder.C0.setVisibility(0);
            pbCommenFloorItemViewHolder.f1141T.setText(R.string.obfuscated_res_0x7f0f0477);
        }
    }

    public final void U(AigcFeedbackInfo aigcFeedbackInfo, tha thaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048591, this, aigcFeedbackInfo, thaVar, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        a0(pbCommenFloorItemViewHolder);
        if (thaVar != null && aigcFeedbackInfo != null && thaVar.y0()) {
            int F = thaVar.F();
            if (F != 1) {
                if (F != 2) {
                    Y(pbCommenFloorItemViewHolder, thaVar);
                } else {
                    W(pbCommenFloorItemViewHolder, thaVar);
                }
            } else {
                X(pbCommenFloorItemViewHolder, thaVar);
            }
            if (!TextUtils.isEmpty(aigcFeedbackInfo.feedback_fold_tip)) {
                str = aigcFeedbackInfo.feedback_fold_tip;
            } else {
                str = "";
            }
            pbCommenFloorItemViewHolder.F0.a(str);
            pbCommenFloorItemViewHolder.F0.setOnClickFoldListener(new c(this, thaVar, pbCommenFloorItemViewHolder));
        }
    }

    public final void x0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, BdTypeListView bdTypeListView, int i2) {
        int firstVisiblePosition;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048629, this, pbCommenFloorItemViewHolder, bdTypeListView, i2) == null) && pbCommenFloorItemViewHolder != null && bdTypeListView != null && (firstVisiblePosition = bdTypeListView.getFirstVisiblePosition()) == i2 + bdTypeListView.getHeaderViewsCount()) {
            bdTypeListView.setSelectionFromTop(firstVisiblePosition, (((pbCommenFloorItemViewHolder.c.getTop() - pbCommenFloorItemViewHolder.F0.getMeasuredHeight()) + pbCommenFloorItemViewHolder.R.getMeasuredHeight()) + pbCommenFloorItemViewHolder.C0.getMeasuredHeight()) - BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146));
        }
    }

    public final void T(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, thaVar}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.I) != null && pbCommenFloorItemViewHolder.S != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.S.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = true;
            boolean z3 = !ListUtils.isEmpty(thaVar.j0());
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
            swa.b(thaVar, pbCommenFloorItemViewHolder.q, (TextUtils.isEmpty(thaVar.v()) || !this.h) ? false : false);
        }
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            pbCommenFloorItemViewHolder.R.setVisibility(8);
            pbCommenFloorItemViewHolder.F0.setVisibility(0);
            pbCommenFloorItemViewHolder.C0.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.C0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.D0.getLayoutParams();
            layoutParams.topMargin = 0;
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            if (thaVar.H0(false)) {
                i2 = R.dimen.tbds48;
            } else {
                i2 = R.dimen.tbds25;
            }
            layoutParams.bottomMargin = BdUtilHelper.getDimens(inst, i2);
            layoutParams2.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            pk9.f(String.valueOf(thaVar.p0()), thaVar.U(), thaVar.F());
        }
    }

    public final void h0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048606, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null && thaVar.p() != null) {
            thaVar.p().threadId = this.a.X().L1();
            thaVar.p().objType = 1;
            thaVar.p().isInPost = true;
            ThreadData threadData = null;
            aj9 aj9Var = this.k;
            if (aj9Var != null && aj9Var.O() != null) {
                threadData = this.k.O();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setThreadData(threadData);
            pbCommenFloorItemViewHolder.o.setData(thaVar.p());
            pbCommenFloorItemViewHolder.c0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.c0.setData(thaVar.p());
        }
    }

    public final void n0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, pbCommenFloorItemViewHolder, thaVar) == null) {
            if (thaVar != null && thaVar.t() != null && thaVar.m0() != null) {
                TbRichText f0 = thaVar.f0();
                if (f0 != null && StringUtils.isNull(f0.toString()) && StringUtils.isNull(thaVar.v())) {
                    z = true;
                } else {
                    z = false;
                }
                if (thaVar.t().getSmallTailThemeData() != null) {
                    str = thaVar.t().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.J.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                cs9.c(thaVar.m0(), pbCommenFloorItemViewHolder.J, pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, false, false, z, thaVar.t().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.J.setVisibility(8);
            pbCommenFloorItemViewHolder.K.setVisibility(8);
        }
    }

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            pbCommenFloorItemViewHolder.R.setVisibility(8);
            pbCommenFloorItemViewHolder.F0.setVisibility(0);
            pbCommenFloorItemViewHolder.C0.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.C0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_10);
            }
            pk9.f(String.valueOf(thaVar.p0()), thaVar.U(), thaVar.F());
        }
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            pbCommenFloorItemViewHolder.R.setVisibility(0);
            pbCommenFloorItemViewHolder.F0.setVisibility(8);
            pbCommenFloorItemViewHolder.C0.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.C0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.D0.getLayoutParams();
            layoutParams.topMargin = 0;
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            if (thaVar.H0(false)) {
                i2 = R.dimen.tbds48;
            } else {
                i2 = R.dimen.tbds25;
            }
            layoutParams.bottomMargin = BdUtilHelper.getDimens(inst, i2);
            layoutParams2.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            w0(pbCommenFloorItemViewHolder, thaVar);
        }
    }

    public final void i0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048607, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.P != null && pbCommenFloorItemViewHolder.M != null) {
            if (thaVar != null && (alaLiveInfoCoreData = thaVar.U) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.P.setText(thaVar.U.liveTitle);
                pbCommenFloorItemViewHolder.M.setTag(thaVar.U);
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

    public final void o0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, pbCommenFloorItemViewHolder, thaVar) == null) {
            if (thaVar.P() != 2 && thaVar.P() != 4) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                pbCommenFloorItemViewHolder.R.setVisibility(0);
                pbCommenFloorItemViewHolder.C0.setVisibility(0);
                T(false, pbCommenFloorItemViewHolder, thaVar);
            } else {
                pbCommenFloorItemViewHolder.S.setOnClickListener(new q(this, pbCommenFloorItemViewHolder, thaVar));
                pbCommenFloorItemViewHolder.S.setVisibility(0);
                S(pbCommenFloorItemViewHolder, thaVar.E0(), thaVar.O());
                T(true, pbCommenFloorItemViewHolder, thaVar);
            }
            w0(pbCommenFloorItemViewHolder, thaVar);
        }
    }

    public final void Z(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).c0) != null && agreeView.getData() != null && !r0(pbCommenFloorItemViewHolder.q)) {
            pbCommenFloorItemViewHolder.c0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.c0.N();
        }
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        pbCommenFloorItemViewHolder.R.setVisibility(0);
        pbCommenFloorItemViewHolder.F0.setVisibility(8);
        pbCommenFloorItemViewHolder.C0.setVisibility(0);
        ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.C0.getLayoutParams()).bottomMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        ((RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.D0.getLayoutParams()).topMargin = 0;
    }

    public final void c0(tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, thaVar) == null) && thaVar != null) {
            int i2 = 8;
            if (thaVar.e0) {
                i2 = 2;
            }
            StatisticItem k2 = nr9.k(this.k, thaVar, thaVar.f0, i2, 6);
            thaVar.g0 = k2;
            if (!ListUtils.isEmpty(thaVar.j0())) {
                Iterator<tha> it = thaVar.j0().iterator();
                while (it.hasNext()) {
                    it.next().g0 = k2;
                }
            }
        }
    }

    public final boolean r0(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            tha thaVar = null;
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return false;
            }
            if (sparseArray.get(R.id.tag_clip_board) instanceof tha) {
                thaVar = (tha) sparseArray.get(R.id.tag_clip_board);
            }
            if (thaVar == null) {
                return false;
            }
            return thaVar.B0();
        }
        return invokeL.booleanValue;
    }

    public final String s0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, view2)) == null) {
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

    public void t0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mContext, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    public final void b0(int i2, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, boolean z, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), pbCommenFloorItemViewHolder, thaVar, Boolean.valueOf(z), view2}) != null) || !UtilHelper.isCurrentAccount(this.k.O().getAuthor().getUserId()) || !this.k.O().isQuestionThread() || UtilHelper.isCurrentAccount(((tha) getItem(i2)).t().getUserId())) {
            return;
        }
        if (z) {
            ((tha) getItem(i2)).i1(1);
            pbCommenFloorItemViewHolder.x0.setVisibility(0);
            ((tha) getItem(i2)).b1(true);
            pbCommenFloorItemViewHolder.i.setVisibility(8);
            pbCommenFloorItemViewHolder.c0.postDelayed(new j(this, i2, pbCommenFloorItemViewHolder, thaVar), 900L);
        } else {
            ((tha) getItem(i2)).i1(0);
            pbCommenFloorItemViewHolder.y0.setVisibility(8);
            pbCommenFloorItemViewHolder.x0.setVisibility(8);
            D0(pbCommenFloorItemViewHolder, thaVar);
            pbCommenFloorItemViewHolder.d0.setVisibility(0);
            ((tha) getItem(i2)).b1(false);
            if (((tha) getItem(i2)).h0().booleanValue()) {
                pbCommenFloorItemViewHolder.i.setVisibility(0);
            }
        }
        q0(pbCommenFloorItemViewHolder, thaVar, view2, i2);
    }

    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048601, this, pbCommenFloorItemViewHolder, thaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            U(thaVar.s(), thaVar, pbCommenFloorItemViewHolder);
            D0(pbCommenFloorItemViewHolder, thaVar);
            if (!thaVar.y0()) {
                pbCommenFloorItemViewHolder.E0.setVisibility(8);
                return;
            }
            pbCommenFloorItemViewHolder.c0.setVisibility(8);
            pbCommenFloorItemViewHolder.E0.setVisibility(0);
            pbCommenFloorItemViewHolder.E0.b(new jk9(thaVar, new a(this, thaVar, i2, pbCommenFloorItemViewHolder, view2), new b(this)));
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
    public final void e0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        boolean z;
        boolean z2;
        aj9 aj9Var;
        aj9 aj9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            String str = null;
            boolean z3 = true;
            if (thaVar.L() > 0 && (aj9Var2 = this.k) != null && !aj9Var2.j0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0b33), Integer.valueOf(thaVar.L()));
                pbCommenFloorItemViewHolder.C.setVisibility(0);
                pbCommenFloorItemViewHolder.C.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.C.setVisibility(8);
                z = false;
            }
            if (thaVar.t() != null) {
                str = thaVar.t().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    oh5 a0 = thaVar.a0();
                    z3 = (a0 != null || StringUtils.isNull(a0.b()) || (aj9Var = this.k) == null || aj9Var.j0()) ? false : false;
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
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(thaVar.q0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(thaVar.q0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(thaVar.q0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setText(str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        if (thaVar.d0) {
                            pbCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(a0.b(), 7, "..."));
                        } else {
                            pbCommenFloorItemViewHolder.n.setText(a0.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.n.setVisibility(8);
                    }
                    TextView textView = pbCommenFloorItemViewHolder.f0;
                    textView.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            oh5 a02 = thaVar.a0();
            if (a02 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(thaVar.q0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView2 = pbCommenFloorItemViewHolder.f0;
            textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void g0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048605, this, pbCommenFloorItemViewHolder, thaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.e0.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.n0.setVisibility(8);
            q0(pbCommenFloorItemViewHolder, thaVar, view2, i2);
            oo9.b(pbCommenFloorItemViewHolder, thaVar, this.k);
            h0(pbCommenFloorItemViewHolder, thaVar);
            k0(pbCommenFloorItemViewHolder, thaVar, view2);
            j0(pbCommenFloorItemViewHolder, thaVar, view2, i2);
            e0(pbCommenFloorItemViewHolder, thaVar);
            n0(pbCommenFloorItemViewHolder, thaVar);
            i0(pbCommenFloorItemViewHolder, thaVar);
            H0(pbCommenFloorItemViewHolder, thaVar);
            o0(pbCommenFloorItemViewHolder, thaVar);
            hl9.j(pbCommenFloorItemViewHolder, thaVar, view2, this.h, this.A);
            m0(pbCommenFloorItemViewHolder, thaVar);
            f0(pbCommenFloorItemViewHolder, thaVar);
            l0(pbCommenFloorItemViewHolder, thaVar);
            p0(pbCommenFloorItemViewHolder, thaVar);
            d0(pbCommenFloorItemViewHolder, thaVar, view2, i2);
            hl9.o(pbCommenFloorItemViewHolder, view2, thaVar, this.r, true);
            hl9.h(pbCommenFloorItemViewHolder, thaVar, this.k, this.mContext);
        }
    }

    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048608, this, pbCommenFloorItemViewHolder, thaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            if (thaVar.l0() > 0) {
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.x.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.x.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, thaVar);
                if (thaVar.P() == 2) {
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
                sparseArray2.put(R.id.tag_load_sub_data, thaVar);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, thaVar);
            }
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            if (!thaVar.A0() && !thaVar.z0(false)) {
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
                    wq9 wq9Var = new wq9(this.mContext);
                    this.q = wq9Var;
                    wq9Var.f(this.e);
                    this.q.h(this.l);
                    this.q.e(this.m);
                    String str = null;
                    aj9 aj9Var = this.k;
                    if (aj9Var != null && aj9Var.O() != null && this.k.O().getAuthor() != null) {
                        str = this.k.O().getAuthor().getUserId();
                    }
                    boolean z = true;
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    aj9 aj9Var2 = this.k;
                    if (aj9Var2 != null) {
                        this.q.j(aj9Var2.W(), z);
                        this.q.i(this.k.O());
                    }
                }
                this.q.g(thaVar.U());
                pbCommenFloorItemViewHolder.v.setSubPbAdapter(this.q);
                pbCommenFloorItemViewHolder.v.setVisibility(0);
                pbCommenFloorItemViewHolder.v.setData(thaVar, view2);
                pbCommenFloorItemViewHolder.v.setChildOnClickListener(this.m);
                pbCommenFloorItemViewHolder.v.setChildOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.v.setChildOnTouchListener(this.A);
            }
            if (thaVar.P) {
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
            pbCommenFloorItemViewHolder.g0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1247));
        }
    }

    public final void k0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048610, this, pbCommenFloorItemViewHolder, thaVar, view2) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
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
            R(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(thaVar.v()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.q.setTid(this.k.Q());
            pbCommenFloorItemViewHolder.q.setPid(thaVar.U());
            pbCommenFloorItemViewHolder.q.setPosition(TbRichTextView.Position.PB_COMMENT_FLOOR);
            pbCommenFloorItemViewHolder.q.setText(thaVar.f0(), true, this.g);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, thaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            sparseArray.put(R.id.tag_is_top_question, Boolean.FALSE);
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.n0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.d0.setTag(sparseArray);
        }
    }

    public final void l0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048611, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            rr9 rr9Var = this.a;
            if (rr9Var != null && rr9Var.X() != null && StringHelper.equals(this.a.X().S0(), thaVar.U())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final void m0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048612, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            String g0 = thaVar.g0();
            if (!StringUtils.isNull(g0)) {
                pbCommenFloorItemViewHolder.X.startLoad(g0, 10, false);
                pbCommenFloorItemViewHolder.X.setVisibility(0);
                pbCommenFloorItemViewHolder.W.setVisibility(8);
                return;
            }
            pbCommenFloorItemViewHolder.X.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm9, com.baidu.tieba.pm
    /* renamed from: v0 */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, tha thaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, thaVar, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) thaVar, (tha) pbCommenFloorItemViewHolder);
            G0(pbCommenFloorItemViewHolder);
            A0(pbCommenFloorItemViewHolder, i2, thaVar, view2);
            N(pbCommenFloorItemViewHolder);
            tha thaVar2 = (tha) getItem(i2);
            if (thaVar2 != null) {
                thaVar2.f0 = i2 + 1;
                P(thaVar2);
                O(thaVar2);
                thaVar2.C1();
                c0(thaVar2);
                g0(pbCommenFloorItemViewHolder, thaVar2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
