package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
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
/* loaded from: classes6.dex */
public class vm8 extends bl8<bc9, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mj8 A;
    public int g;
    public TbRichTextView.u h;
    public boolean i;
    public float j;
    public String k;
    public ki8 l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public TbRichTextView.a0 o;
    public mj8 p;
    public View.OnLongClickListener q;
    public vo8 r;
    public int s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public boolean x;
    public xf<ConstrainImageLayout> y;
    public xf<TbImageView> z;

    /* JADX WARN: Removed duplicated region for block: B:245:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x06f9  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0703  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0769  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0773  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x07b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, View view2, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048596, this, pbCommenFloorItemViewHolder, bc9Var, view2, i2) == null) || pbCommenFloorItemViewHolder == null || bc9Var == null) {
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
        ThreadData threadData = null;
        pbCommenFloorItemViewHolder.p.setTag(null);
        pbCommenFloorItemViewHolder.p.setUserId(null);
        pbCommenFloorItemViewHolder.g.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.L.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.q.setIsHost(false);
        if (bc9Var.r() != null) {
            String str = this.k;
            if (str != null && !"0".equals(str) && this.k.equals(bc9Var.r().getUserId())) {
                pbCommenFloorItemViewHolder.q.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = bc9Var.r().getIconInfo();
            ArrayList<IconData> tShowInfoNew = bc9Var.r().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.N;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, bc9Var.r().getUserId());
                wp8 wp8Var = this.a;
                if (wp8Var != null && wp8Var.M() != null) {
                    pbCommenFloorItemViewHolder.N.setOnClickListener(this.a.M().d.c);
                }
                int g2 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                int g3 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.N;
                i3 = R.id.tag_user_id;
                userIconBox2.h(iconInfo, 2, g2, g2, g3);
            } else {
                i3 = R.id.tag_user_id;
            }
            if (pbCommenFloorItemViewHolder.M != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.M.setTag(tShowInfoNew.get(0).getUrl());
                }
                wp8 wp8Var2 = this.a;
                if (wp8Var2 != null && wp8Var2.M() != null) {
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
            pbCommenFloorItemViewHolder.g.setTag(i3, bc9Var.r().getUserId());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, bc9Var.r().getUserName());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, bc9Var.r().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, mp8.i(this.l, bc9Var, bc9Var.d0, i4, 2));
            String name_show = bc9Var.r().getName_show();
            String userName = bc9Var.r().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.g.setText(kh8.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
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
                ki8 ki8Var = this.l;
                pbCommenFloorItemViewHolder.L.getHeadView().setFid(ki8Var != null ? ki8Var.m() : "");
                ki8 ki8Var2 = this.l;
                pbCommenFloorItemViewHolder.L.getHeadView().setFName(ki8Var2 != null ? ki8Var2.n() : "");
                pbCommenFloorItemViewHolder.L.getHeadView().setFloor(bc9Var.E());
                pbCommenFloorItemViewHolder.L.getHeadView().setTid(bc9Var.O());
                pbCommenFloorItemViewHolder.L.getHeadView().setTag(R.id.tag_statistic_item, mp8.i(this.l, bc9Var, bc9Var.d0, i4, 2));
                pbCommenFloorItemViewHolder.L.n(bc9Var.r().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, bc9Var.r(), 4);
                pbCommenFloorItemViewHolder.p.setUserId(bc9Var.r().getUserId());
                ki8 ki8Var3 = this.l;
                pbCommenFloorItemViewHolder.p.setFid(ki8Var3 != null ? ki8Var3.m() : "");
                ki8 ki8Var4 = this.l;
                pbCommenFloorItemViewHolder.p.setFName(ki8Var4 != null ? ki8Var4.n() : "");
                pbCommenFloorItemViewHolder.p.setFloor(bc9Var.E());
                pbCommenFloorItemViewHolder.p.setTid(bc9Var.O());
                pbCommenFloorItemViewHolder.p.setUserName(bc9Var.r().getUserName(), bc9Var.m0());
                pbCommenFloorItemViewHolder.p.setTag(R.id.tag_virtual_user_url, bc9Var.r().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.p.setTag(R.id.tag_statistic_item, mp8.i(this.l, bc9Var, bc9Var.d0, i4, 2));
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
                threadData = null;
            } else {
                pbCommenFloorItemViewHolder.d(false);
                pbCommenFloorItemViewHolder.p.setLiveStatus(0);
                threadData = null;
                pbCommenFloorItemViewHolder.p.setAlaInfo(null);
                pbCommenFloorItemViewHolder.L.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.L.getHeadView().setAlaInfo(null);
            }
            t0(pbCommenFloorItemViewHolder.i, bc9Var);
        }
        wp8 wp8Var3 = this.a;
        int level_id = (wp8Var3 == null || wp8Var3.M() == null || !this.a.M().x0() || bc9Var.r() == null) ? 0 : bc9Var.r().getLevel_id();
        ki8 ki8Var5 = this.l;
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
        if (pbCommenFloorItemViewHolder.N.getChildCount() == 1) {
            i5 = 13;
        } else if (pbCommenFloorItemViewHolder.N.getChildCount() > 1) {
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
            pbCommenFloorItemViewHolder.N.setVisibility(8);
            if (pbCommenFloorItemViewHolder.N.getChildCount() == 1) {
                i5 += 2;
            } else if (pbCommenFloorItemViewHolder.N.getChildCount() > 1) {
                i5 += 4;
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.i.getVisibility() == 0) {
                i5 += 2;
                pbCommenFloorItemViewHolder.i.setVisibility(8);
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.K.getVisibility() == 0) {
                i5 += 2;
                pbCommenFloorItemViewHolder.K.setVisibility(8);
            }
        }
        String name_show2 = bc9Var.r() != null ? bc9Var.r().getName_show() : "";
        int f2 = dq5.f(name_show2);
        if (bc9Var.r() != null && !StringUtils.isNull(bc9Var.r().getSealPrefix())) {
            int i6 = i5 - 2;
            if (f2 > i6) {
                name_show2 = dq5.n(name_show2, i6) + StringHelper.STRING_MORE;
            }
        } else if (f2 > i5) {
            name_show2 = dq5.n(name_show2, i5) + StringHelper.STRING_MORE;
        }
        if (bc9Var.r() != null && !StringUtils.isNull(bc9Var.r().getSealPrefix())) {
            pbCommenFloorItemViewHolder.g.setText(e0(bc9Var.r().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.g.setText(name_show2);
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
        ki8 ki8Var6 = this.l;
        if (ki8Var6 != null && ki8Var6.Q() != null) {
            threadData = this.l.Q();
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z8 = (bc9Var.r() == null || StringUtils.isNull(bc9Var.r().getVirtualUserUrl())) ? false : true;
        ki8 ki8Var7 = this.l;
        if (ki8Var7 == null || ki8Var7.Y() == 0 || g0()) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            z = (this.l.Y() == 1002 || this.l.Y() == 3) ? false : true;
            if (this.l.Y() == 3 || this.l.l0()) {
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
                if (userId == null || "0".equals(userId) || userId.length() == 0) {
                    z = false;
                }
            }
        }
        ki8 ki8Var8 = this.l;
        if (ki8Var8 != null && ki8Var8.Q() != null && this.l.Q().getAuthor() != null && bc9Var.r() != null) {
            String userId2 = this.l.Q().getAuthor().getUserId();
            String userId3 = bc9Var.r().getUserId();
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
                if (bc9Var != null && bc9Var.r() != null && UtilHelper.isCurrentAccount(bc9Var.r().getUserId())) {
                    z6 = true;
                    z4 = true;
                }
                if (z8) {
                    z = false;
                    z5 = false;
                    z4 = false;
                }
                int i7 = bc9Var.E() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.l.Y()));
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
                    if (this.l.Q() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.l.Q().getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, bc9Var.O());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(bc9Var.t0()));
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.l.Y()));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i7));
                    sparseArray.put(R.id.tag_del_post_id, bc9Var.O());
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
                pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            }
        }
        z4 = z3;
        z5 = false;
        z6 = false;
        z7 = false;
        if (bc9Var != null) {
            z6 = true;
            z4 = true;
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
        sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z2));
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

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ vn8 b;
        public final /* synthetic */ vm8 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bc9 a;
            public final /* synthetic */ j b;

            public a(j jVar, bc9 bc9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, bc9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = jVar;
                this.a = bc9Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    j jVar = this.b;
                    jVar.b.b.a(jVar.c.l, null, this.a, jVar.a.q.getLayoutStrategy());
                }
            }
        }

        public j(vm8 vm8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, vn8 vn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm8Var, pbCommenFloorItemViewHolder, vn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vm8Var;
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
                String S = this.c.l.S();
                if ((StringUtils.isNull(S) || "0".equals(this.c.l.S())) && this.c.l.Q() != null) {
                    S = this.c.l.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.c.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", bc9Var.O()).param("obj_source", this.c.f0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ vm8 b;

        public a(vm8 vm8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vm8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.l != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.j0) != null && agreeView.getData() != null) {
                if (view2 == this.a.j0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String S = this.b.l.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.l.S())) && this.b.l.Q() != null) {
                    S = this.b.l.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.j0.getData().postId).param("obj_source", this.b.f0(this.a.j0)).param("obj_type", i));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.b.l.m());
                statisticItem.param("tid", this.b.l.S());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.b.l.j().O());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", this.b.d0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vm8 a;

        public b(vm8 vm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vm8Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.p != null) {
                    this.a.p.a(view2);
                    return this.a.p.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements yf<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vm8 a;

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

        public c(vm8 vm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vm8Var;
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

    /* loaded from: classes6.dex */
    public class d implements yf<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vm8 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public d(vm8 vm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vm8Var;
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

    /* loaded from: classes6.dex */
    public class e implements mj8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vm8 a;

        @Override // com.baidu.tieba.mj8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public e(vm8 vm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vm8Var;
        }

        @Override // com.baidu.tieba.mj8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.p != null) {
                    if ((view2 instanceof TbListTextView) && this.a.n != null) {
                        this.a.n.onClick(view2);
                        return true;
                    }
                    this.a.p.a(view2);
                    this.a.p.onSingleTapConfirmed(motionEvent);
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
                            this.a.N((RelativeLayout) parent);
                            break;
                        }
                    }
                } else {
                    this.a.N(view2);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ vm8 b;

        public f(vm8 vm8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vm8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.a.c, R.color.CAM_X0205);
                wp8 wp8Var = this.b.a;
                if (wp8Var != null && wp8Var.L() != null) {
                    this.b.a.L().C0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ bc9 b;
        public final /* synthetic */ vm8 c;

        public g(vm8 vm8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm8Var, pbCommenFloorItemViewHolder, bc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vm8Var;
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
                this.c.L(this.a, !z, this.b.I());
                this.b.R0(!z);
                this.c.j0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.M5() != null && this.c.b.M5().s1() != null && this.c.b.M5().Z0() != null && !z && this.a.getView().getTop() < this.c.b.M5().s1().getMeasuredHeight()) {
                    this.c.b.M5().Z0().setSelectionFromTop(ListUtils.getPosition(this.c.b.M5().Z0().getData(), this.b) + this.c.b.M5().Z0().getHeaderViewsCount(), this.c.b.M5().s1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ vm8 b;

        public h(vm8 vm8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vm8Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 7, this.a);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public i(vm8 vm8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm8Var, pbCommenFloorItemViewHolder};
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
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ vm8 b;

        public k(vm8 vm8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vm8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.l != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.o) != null && agreeView.getData() != null) {
                if (view2 == this.a.o.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String S = this.b.l.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.l.S())) && this.b.l.Q() != null) {
                    S = this.b.l.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", this.b.f0(this.a.o)).param("obj_type", i));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.b.l.m());
                statisticItem.param("tid", this.b.l.S());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.b.l.j().O());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", this.b.d0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vm8(wp8 wp8Var, BdUniqueId bdUniqueId) {
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
        this.g = 0;
        this.h = null;
        this.i = true;
        this.j = 1.0f;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.u = true;
        this.w = true;
        this.x = false;
        this.y = new xf<>(new c(this), 6, 0);
        this.z = new xf<>(new d(this), 12, 0);
        this.A = new mj8(new e(this));
        if (wp8Var != null && wp8Var.L() != null) {
            this.v = wp8Var.L().v1();
        }
        this.g = s(R.dimen.tbds14);
    }

    public final void G(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.p);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new b(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.i = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onLongClickListener) == null) {
            this.q = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.s = i2;
        }
    }

    public void n(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, a0Var) == null) {
            this.o = a0Var;
        }
    }

    public void n0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f2) == null) {
            this.j = f2;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.k = str;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.t = z;
        }
    }

    public void p0(mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, mj8Var) == null) {
            this.p = mj8Var;
        }
    }

    public void q0(TbRichTextView.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, uVar) == null) {
            this.h = uVar;
        }
    }

    public void r(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, ki8Var) == null) {
            this.l = ki8Var;
        }
    }

    public final void s0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048623, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof bc9)) {
            return;
        }
        t0(textView, (bc9) tag);
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null && (imageView = pbCommenFloorItemViewHolder.O) != null && this.l != null) {
            imageView.setVisibility(8);
        }
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.d0;
            if (bc9Var.b0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            pbCommenFloorItemViewHolder.h(bc9Var.S, bc9Var.O(), this.x);
        }
    }

    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, pbCommenFloorItemViewHolder, bc9Var) == null) {
            TbRichText Z = bc9Var.Z();
            Z.isChanged = true;
            pbCommenFloorItemViewHolder.q.setText(Z, true, this.h);
        }
    }

    public final void H(bc9 bc9Var) {
        ki8 ki8Var;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bc9Var) == null) && (ki8Var = this.l) != null) {
            if (ki8Var.y0()) {
                AbsVideoPbFragment absVideoPbFragment = this.c;
                if (absVideoPbFragment != null) {
                    BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                    ki8 ki8Var2 = this.l;
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
                ki8 ki8Var3 = this.l;
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

    public final void I(bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bc9Var) == null) && bc9Var.E == 0 && bc9Var.M) {
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
                k0(bc9Var);
            }
        }
    }

    public final void J(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int m = ((((hi.m(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                m = (m - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = s(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().J = (m - i3) - s(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                m /= 2;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((m - i3) * this.j));
            tbRichTextView.getLayoutStrategy().q((int) (m * 1.618f * this.j));
        }
    }

    public final void L(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
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

    public final void M(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, bc9Var}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.P) != null && pbCommenFloorItemViewHolder.Z != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.Z.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !ListUtils.isEmpty(bc9Var.d0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.P.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.Z.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(0);
                if (z2) {
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
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = hi.g(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
            }
        }
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048591, this, pbCommenFloorItemViewHolder, bc9Var, view2) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = hi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = hi.g(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
            if (!this.i) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.q.p0(null);
                pbCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().z(R.drawable.pic_video);
            J(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(bc9Var.t()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.q.setText(bc9Var.Z(), true, this.h);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, bc9Var);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.t0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.k0.setTag(sparseArray);
        }
    }

    public final void N(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).j0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.j0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.j0.N();
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
            statisticItem.param("fid", this.l.m());
            statisticItem.param("tid", this.l.S());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("post_id", this.l.j().O());
            statisticItem.param("obj_source", 1);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", d0());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: h0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d073d, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0919fe)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0735, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.M().getPageContext(), inflate, this.v);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.v;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.w);
                pbCommenFloorItemViewHolder.v.setIsVideoThread(true);
            }
            r0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.q;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.u);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void k0(bc9 bc9Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bc9Var) == null) {
            String userId = bc9Var.r().getUserId();
            ki8 ki8Var = this.l;
            String str2 = "";
            if (ki8Var == null) {
                str = "";
            } else {
                str = ki8Var.m();
            }
            ki8 ki8Var2 = this.l;
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
        if ((interceptable == null || interceptable.invokeL(1048583, this, bc9Var) == null) && bc9Var != null) {
            int i2 = 8;
            if (bc9Var.c0) {
                i2 = 2;
            }
            StatisticItem i3 = mp8.i(this.l, bc9Var, bc9Var.d0, i2, 6);
            bc9Var.e0 = i3;
            if (!ListUtils.isEmpty(bc9Var.d0())) {
                Iterator<bc9> it = bc9Var.d0().iterator();
                while (it.hasNext()) {
                    it.next().e0 = i3;
                }
            }
        }
    }

    public final String f0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, view2)) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        ki8 ki8Var;
        ki8 ki8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            String str = null;
            boolean z3 = true;
            if (bc9Var.E() > 0 && (ki8Var2 = this.l) != null && !ki8Var2.l0()) {
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
                    z3 = (V != null || StringUtils.isNull(V.b()) || (ki8Var = this.l) == null || ki8Var.l0()) ? false : false;
                    if (!z) {
                        pbCommenFloorItemViewHolder.l.setVisibility(0);
                        i2 = this.g;
                    } else {
                        pbCommenFloorItemViewHolder.l.setVisibility(8);
                        i2 = 0;
                    }
                    if (z3 && !z2) {
                        pbCommenFloorItemViewHolder.m.setVisibility(8);
                        i3 = 0;
                    } else {
                        pbCommenFloorItemViewHolder.m.setVisibility(0);
                        i3 = this.g;
                    }
                    pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(bc9Var.k0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(bc9Var.k0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(bc9Var.k0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(this.g, 0, 0, 0);
                        TextView textView = pbCommenFloorItemViewHolder.n;
                        textView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(this.g, 0, 0, 0);
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
            i3 = this.g;
            pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(bc9Var.k0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView22 = pbCommenFloorItemViewHolder.m0;
            textView22.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void t0(TextView textView, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, textView, bc9Var) == null) {
            if (textView == null && bc9Var == null) {
                return;
            }
            textView.setTag(bc9Var);
            ki8 ki8Var = this.l;
            if (ki8Var != null && ki8Var.l0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (bc9Var.r() != null) {
                MetaData r = bc9Var.r();
                String str = this.k;
                if (str != null && !"0".equals(str) && this.k.equals(r.getUserId())) {
                    textView.setVisibility(0);
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
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (r.getIs_bawu() == 1 && "manager".equals(r.getBawu_type())) {
                    n15 d4 = n15.d(textView);
                    d4.w(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (r.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(r.getBawu_type())) {
                    n15 d5 = n15.d(textView);
                    d5.w(R.color.CAM_X0101);
                    d5.o(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (r.getIs_bawu() == 1 && "pri_content_assist".equals(r.getBawu_type())) {
                    n15 d6 = n15.d(textView);
                    d6.w(R.color.CAM_X0101);
                    d6.o(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (r.getIs_bawu() == 1 && "pri_manage_assist".equals(r.getBawu_type())) {
                    n15 d7 = n15.d(textView);
                    d7.w(R.color.CAM_X0101);
                    d7.o(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048587, this, pbCommenFloorItemViewHolder, bc9Var, view2, i2) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.l0.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.t0.setVisibility(8);
            b0(pbCommenFloorItemViewHolder, bc9Var, view2, i2);
            c0(pbCommenFloorItemViewHolder, bc9Var);
            P(pbCommenFloorItemViewHolder, bc9Var);
            T(pbCommenFloorItemViewHolder, bc9Var);
            W(pbCommenFloorItemViewHolder, bc9Var, view2);
            V(pbCommenFloorItemViewHolder, bc9Var, view2, i2);
            Q(pbCommenFloorItemViewHolder, bc9Var);
            Y(pbCommenFloorItemViewHolder, bc9Var);
            U(pbCommenFloorItemViewHolder, bc9Var);
            Z(pbCommenFloorItemViewHolder, bc9Var);
            yj8.d(pbCommenFloorItemViewHolder, bc9Var, view2, this.i, this.A);
            R(pbCommenFloorItemViewHolder, bc9Var);
            X(pbCommenFloorItemViewHolder, bc9Var);
            a0(pbCommenFloorItemViewHolder, bc9Var);
            yj8.i(pbCommenFloorItemViewHolder, view2, bc9Var, this.t, true);
            yj8.q(this.a.M().getPageContext(), pbCommenFloorItemViewHolder, bc9Var);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null && bc9Var.o() != null) {
            bc9Var.o().threadId = this.a.L().Q1();
            bc9Var.o().objType = 1;
            bc9Var.o().isInPost = true;
            ThreadData threadData = null;
            ki8 ki8Var = this.l;
            if (ki8Var != null && ki8Var.Q() != null) {
                threadData = this.l.Q();
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

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            wp8 wp8Var = this.a;
            if (wp8Var != null && wp8Var.L() != null && StringHelper.equals(this.a.L().X0(), bc9Var.O())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
                return;
            }
            wp8 wp8Var2 = this.a;
            if (wp8Var2 != null && wp8Var2.L() != null && StringHelper.equals(this.a.L().W0(), bc9Var.O())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
                jg.a().postDelayed(new f(this, pbCommenFloorItemViewHolder), 3000L);
                return;
            }
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
        }
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, bc9Var) == null) {
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

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.W != null && pbCommenFloorItemViewHolder.T != null) {
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

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, bc9Var) == null) {
            if (bc9Var.J() != 2 && bc9Var.J() != 4) {
                pbCommenFloorItemViewHolder.Z.setVisibility(8);
                pbCommenFloorItemViewHolder.Y.setVisibility(0);
                M(false, pbCommenFloorItemViewHolder, bc9Var);
            } else {
                pbCommenFloorItemViewHolder.Z.setOnClickListener(new g(this, pbCommenFloorItemViewHolder, bc9Var));
                pbCommenFloorItemViewHolder.Z.setVisibility(0);
                L(pbCommenFloorItemViewHolder, bc9Var.w0(), bc9Var.I());
                M(true, pbCommenFloorItemViewHolder, bc9Var);
            }
            j0(pbCommenFloorItemViewHolder, bc9Var);
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null && TbSingleton.getInstance().isUserGrowthOpen() && bc9Var.r().getUserGrowthData() != null) {
            int a2 = bc9Var.r().getUserGrowthData().a();
            if (a2 >= 0 && a2 <= 10) {
                pbCommenFloorItemViewHolder.j.setImageResource(sw.b(a2));
                pbCommenFloorItemViewHolder.j.setVisibility(0);
                pbCommenFloorItemViewHolder.j.setOnClickListener(new h(this, a2));
                CommonStatisticUtils.staticNameplateOfUserLevel(1, 7, a2);
                return;
            }
            pbCommenFloorItemViewHolder.j.setVisibility(8);
        }
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048590, this, pbCommenFloorItemViewHolder, bc9Var, view2, i2) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
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
            boolean z = true;
            if (!bc9Var.t0() && !bc9Var.s0(true)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams2.topMargin = hi.g(this.mContext, R.dimen.tbds10);
                layoutParams2.leftMargin = hi.g(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = hi.g(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = hi.g(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams2);
                if (this.r == null) {
                    vo8 vo8Var = new vo8(this.mContext);
                    this.r = vo8Var;
                    vo8Var.f(this.e);
                    this.r.h(this.m);
                    this.r.e(this.n);
                    String str = null;
                    ki8 ki8Var = this.l;
                    if (ki8Var != null && ki8Var.Q() != null && this.l.Q().getAuthor() != null) {
                        str = this.l.Q().getAuthor().getUserId();
                    }
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    ki8 ki8Var2 = this.l;
                    if (ki8Var2 != null) {
                        this.r.j(ki8Var2.Y(), z);
                        this.r.i(this.l.Q());
                    }
                }
                this.r.g(bc9Var.O());
                pbCommenFloorItemViewHolder.v.setSubPbAdapter(this.r);
                pbCommenFloorItemViewHolder.v.setVisibility(0);
                pbCommenFloorItemViewHolder.v.setData(bc9Var, view2);
                pbCommenFloorItemViewHolder.v.setChildOnClickListener(this.n);
                pbCommenFloorItemViewHolder.v.setChildOnLongClickListener(this.q);
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

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ki8 ki8Var = this.l;
            if (ki8Var != null && ki8Var.Q() != null) {
                return this.l.Q().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final SpannableStringBuilder e0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, str, str2)) == null) {
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

    public View i0(int i2, View view2, ViewGroup viewGroup, bc9 bc9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, bc9Var, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) bc9Var, (bc9) pbCommenFloorItemViewHolder);
            r0(pbCommenFloorItemViewHolder);
            m0(pbCommenFloorItemViewHolder);
            G(pbCommenFloorItemViewHolder);
            bc9 bc9Var2 = (bc9) getItem(i2);
            if (bc9Var2 != null) {
                bc9Var2.d0 = i2 + 1;
                I(bc9Var2);
                H(bc9Var2);
                bc9Var2.o1();
                O(bc9Var2);
                S(pbCommenFloorItemViewHolder, bc9Var2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void m0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.q);
            if (this.a.M() != null && this.a.M().getPageContext() != null && this.a.M().getPageContext().getOrignalPage() != null) {
                tn8 tn8Var = this.a.M().d;
                pbCommenFloorItemViewHolder.g.setOnClickListener(tn8Var.b);
                pbCommenFloorItemViewHolder.p.setOnClickListener(tn8Var.b);
                pbCommenFloorItemViewHolder.L.setOnClickListener(tn8Var.b);
                pbCommenFloorItemViewHolder.L.getHeadView().setOnClickListener(tn8Var.b);
                pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.q);
                pbCommenFloorItemViewHolder.q.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.n);
                pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.o);
                pbCommenFloorItemViewHolder.q.setOnImageTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(tn8Var.f);
                pbCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.n);
                pbCommenFloorItemViewHolder.Q.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.R.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.T.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.w.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.o0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.s0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.k0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.t0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.l0.setOnClickListener(new i(this, pbCommenFloorItemViewHolder));
                vn8 vn8Var = this.a.M().e;
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.z.setOnClickListener(new j(this, pbCommenFloorItemViewHolder, vn8Var));
                pbCommenFloorItemViewHolder.o.B = new k(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.j0.B = new a(this, pbCommenFloorItemViewHolder);
            }
        }
    }

    @Override // com.baidu.tieba.bl8, com.baidu.tieba.tm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view2, viewGroup, (bc9) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void r0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            s0(pbCommenFloorItemViewHolder.i);
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
                ki8 ki8Var = this.l;
                if (ki8Var != null && StringUtils.isNull(ki8Var.k())) {
                    pbCommenFloorItemViewHolder.a0.setText(this.l.k());
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
}
