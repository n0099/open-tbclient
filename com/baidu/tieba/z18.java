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
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.qy7;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w36;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class z18 extends f08<PostData, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qy7 A;
    public int g;
    public TbRichTextView.s h;
    public boolean i;
    public float j;
    public String k;
    public ox7 l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public TbRichTextView.y o;
    public qy7 p;
    public View.OnLongClickListener q;
    public y38 r;
    public int s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public boolean x;
    public og<ConstrainImageLayout> y;
    public og<TbImageView> z;

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
    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048596, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        if (postData.R) {
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
        if (postData.s() != null) {
            String str = this.k;
            if (str != null && !"0".equals(str) && this.k.equals(postData.s().getUserId())) {
                pbCommenFloorItemViewHolder.q.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.N;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.obfuscated_res_0x7f0920ea, postData.s().getUserId());
                z48 z48Var = this.a;
                if (z48Var != null && z48Var.P() != null) {
                    pbCommenFloorItemViewHolder.N.setOnClickListener(this.a.P().d.c);
                }
                int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.N;
                i3 = R.id.obfuscated_res_0x7f0920ea;
                userIconBox2.g(iconInfo, 2, g2, g2, g3);
            } else {
                i3 = R.id.obfuscated_res_0x7f0920ea;
            }
            if (pbCommenFloorItemViewHolder.M != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.M.setTag(tShowInfoNew.get(0).getUrl());
                }
                z48 z48Var2 = this.a;
                if (z48Var2 != null && z48Var2.P() != null) {
                    pbCommenFloorItemViewHolder.M.setOnClickListener(this.a.P().d.e);
                }
                int g4 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.M.h(tShowInfoNew, 3, g4, g4, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        q18.F(pbCommenFloorItemViewHolder.g);
                    } else {
                        pw4.d(pbCommenFloorItemViewHolder.g).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            int i4 = postData.c0 ? 2 : 8;
            pbCommenFloorItemViewHolder.g.setTag(i3, postData.s().getUserId());
            pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f0920f2, postData.s().getUserName());
            pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f0920f4, postData.s().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f0920e0, p48.i(this.l, postData, postData.d0, i4, 2));
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.g.setText(ow7.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                pbCommenFloorItemViewHolder.g.setGravity(16);
                pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f0920be, ow7.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.L.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.L.j(postData.s(), 4);
                pbCommenFloorItemViewHolder.p.setVisibility(8);
                pbCommenFloorItemViewHolder.L.setVisibility(0);
                pbCommenFloorItemViewHolder.L.getHeadView().K(avater, 28, false);
                pbCommenFloorItemViewHolder.L.getHeadView().setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.L.getHeadView().setUserName(postData.s().getUserName());
                ox7 ox7Var = this.l;
                pbCommenFloorItemViewHolder.L.getHeadView().setFid(ox7Var != null ? ox7Var.m() : "");
                ox7 ox7Var2 = this.l;
                pbCommenFloorItemViewHolder.L.getHeadView().setFName(ox7Var2 != null ? ox7Var2.n() : "");
                pbCommenFloorItemViewHolder.L.getHeadView().setFloor(postData.D());
                pbCommenFloorItemViewHolder.L.getHeadView().setTid(postData.M());
                pbCommenFloorItemViewHolder.L.getHeadView().setTag(R.id.obfuscated_res_0x7f0920e0, p48.i(this.l, postData, postData.d0, i4, 2));
                pbCommenFloorItemViewHolder.L.n(postData.s().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, postData.s(), 4);
                pbCommenFloorItemViewHolder.p.setUserId(postData.s().getUserId());
                ox7 ox7Var3 = this.l;
                pbCommenFloorItemViewHolder.p.setFid(ox7Var3 != null ? ox7Var3.m() : "");
                ox7 ox7Var4 = this.l;
                pbCommenFloorItemViewHolder.p.setFName(ox7Var4 != null ? ox7Var4.n() : "");
                pbCommenFloorItemViewHolder.p.setFloor(postData.D());
                pbCommenFloorItemViewHolder.p.setTid(postData.M());
                pbCommenFloorItemViewHolder.p.setUserName(postData.s().getUserName(), postData.k0());
                pbCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f0920f4, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f0920e0, p48.i(this.l, postData, postData.d0, i4, 2));
                pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                pbCommenFloorItemViewHolder.p.K(avater, 28, false);
                pbCommenFloorItemViewHolder.p.setVisibility(0);
                pbCommenFloorItemViewHolder.L.setVisibility(8);
            }
            if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaUserData() != null && postData.s().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.d(true);
                pbCommenFloorItemViewHolder.p.setLiveStatus(1);
                pbCommenFloorItemViewHolder.p.setAlaInfo(postData.s().getAlaInfo());
                pbCommenFloorItemViewHolder.L.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.L.getHeadView().setAlaInfo(postData.s().getAlaInfo());
                threadData = null;
            } else {
                pbCommenFloorItemViewHolder.d(false);
                pbCommenFloorItemViewHolder.p.setLiveStatus(0);
                threadData = null;
                pbCommenFloorItemViewHolder.p.setAlaInfo(null);
                pbCommenFloorItemViewHolder.L.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.L.getHeadView().setAlaInfo(null);
            }
            r0(pbCommenFloorItemViewHolder.i, postData);
        }
        z48 z48Var3 = this.a;
        int level_id = (z48Var3 == null || z48Var3.P() == null || !this.a.P().t0() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        ox7 ox7Var5 = this.l;
        if (ox7Var5 != null && ox7Var5.l0()) {
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
        if (postData.y() > 1000) {
            i5 -= 2;
        }
        if (postData.y() > 10) {
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
        String name_show2 = postData.s() != null ? postData.s().getName_show() : "";
        int d2 = tj5.d(name_show2);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i6 = i5 - 2;
            if (d2 > i6) {
                name_show2 = tj5.l(name_show2, i6) + StringHelper.STRING_MORE;
            }
        } else if (d2 > i5) {
            name_show2 = tj5.l(name_show2, i5) + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.g.setText(c0(postData.s().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.g.setText(name_show2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f092094, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f0920b1, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f0920b3, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f0920c2, Integer.valueOf(i2));
        sparseArray.put(R.id.obfuscated_res_0x7f0920c1, Integer.valueOf(postData.D()));
        sparseArray.put(R.id.obfuscated_res_0x7f0920a4, postData.M());
        sparseArray.put(R.id.obfuscated_res_0x7f091829, pbCommenFloorItemViewHolder.o);
        sparseArray.put(R.id.obfuscated_res_0x7f09182a, pbCommenFloorItemViewHolder.j0);
        sparseArray.put(R.id.obfuscated_res_0x7f091827, pbCommenFloorItemViewHolder.y);
        sparseArray.put(R.id.obfuscated_res_0x7f091828, pbCommenFloorItemViewHolder.z);
        ox7 ox7Var6 = this.l;
        if (ox7Var6 != null && ox7Var6.Q() != null) {
            threadData = this.l.Q();
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            sparseArray.put(R.id.obfuscated_res_0x7f091826, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.obfuscated_res_0x7f091826, Boolean.FALSE);
        }
        boolean z8 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        ox7 ox7Var7 = this.l;
        if (ox7Var7 == null || ox7Var7.Y() == 0 || e0()) {
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
            if (postData != null && postData.s() != null) {
                String userId = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || "0".equals(userId) || userId.length() == 0) {
                    z = false;
                }
            }
        }
        ox7 ox7Var8 = this.l;
        if (ox7Var8 != null && ox7Var8.Q() != null && this.l.Q().getAuthor() != null && postData.s() != null) {
            String userId2 = this.l.Q().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
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
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z6 = true;
                    z4 = true;
                }
                if (z8) {
                    z = false;
                    z5 = false;
                    z4 = false;
                }
                int i7 = postData.D() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920dd, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(this.l.Y()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920a1, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f0920a2, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f0920a3, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920dd, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f0920ab, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ed, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ee, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ec, postData.s().getName_show());
                    }
                    if (this.l.Q() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920f0, this.l.Q().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f0920ef, postData.M());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f0920a8, Boolean.valueOf(postData.r0()));
                    sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(this.l.Y()));
                    sparseArray.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f092098, Integer.valueOf(i7));
                    sparseArray.put(R.id.obfuscated_res_0x7f092096, postData.M());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920db, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f0920b5, Boolean.valueOf(z2));
                sparseArray.put(R.id.obfuscated_res_0x7f0920ac, Boolean.valueOf(z7));
                pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            }
        }
        z4 = z3;
        z5 = false;
        z6 = false;
        z7 = false;
        if (postData != null) {
            z6 = true;
            z4 = true;
        }
        if (z8) {
        }
        if (postData.D() != 1) {
        }
        if (!z) {
        }
        if (!z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f0920b5, Boolean.valueOf(z2));
        sparseArray.put(R.id.obfuscated_res_0x7f0920ac, Boolean.valueOf(z7));
        pbCommenFloorItemViewHolder.q.setTag(sparseArray);
        pbCommenFloorItemViewHolder.s.setTag(sparseArray);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ y28 b;
        public final /* synthetic */ z18 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ j b;

            public a(j jVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, postData};
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
                this.a = postData;
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

        public j(z18 z18Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, y28 y28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z18Var, pbCommenFloorItemViewHolder, y28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z18Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = y28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.obfuscated_res_0x7f0920b1) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f0920b1)) != null && this.a.c != null && this.b != null) {
                ah.a().postDelayed(new a(this, postData), 100L);
                String S = this.c.l.S();
                if ((StringUtils.isNull(S) || "0".equals(this.c.l.S())) && this.c.l.Q() != null) {
                    S = this.c.l.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.c.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.M()).param("obj_source", this.c.d0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ z18 b;

        public a(z18 z18Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z18Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z18Var;
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
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.j0.getData().postId).param("obj_source", this.b.d0(this.a.j0)).param("obj_type", i));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.b.l.m());
                statisticItem.param("tid", this.b.l.S());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.b.l.j().M());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", this.b.b0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z18 a;

        public b(z18 z18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z18Var;
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
    public class c implements pg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z18 a;

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

        public c(z18 z18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z18Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
    public class d implements pg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z18 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public d(z18 z18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z18Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
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
    public class e implements qy7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z18 a;

        @Override // com.baidu.tieba.qy7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public e(z18 z18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z18Var;
        }

        @Override // com.baidu.tieba.qy7.a
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

        @Override // com.baidu.tieba.qy7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (((pbFragment = this.a.b) != null && pbFragment.y5() != null && !this.a.b.y5().I1()) || view2.getId() == R.id.obfuscated_res_0x7f090a2a)) {
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
                            this.a.L((RelativeLayout) parent);
                            break;
                        }
                    }
                } else {
                    this.a.L(view2);
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
        public final /* synthetic */ z18 b;

        public f(z18 z18Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z18Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z18Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.a.c, R.color.CAM_X0205);
                z48 z48Var = this.b.a;
                if (z48Var != null && z48Var.K() != null) {
                    this.b.a.K().Y0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ z18 c;

        public g(z18 z18Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z18Var, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z18Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = postData;
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
                this.c.I(this.a, !z, this.b.G());
                this.b.O0(!z);
                this.c.h0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.y5() != null && this.c.b.y5().m1() != null && this.c.b.y5().T0() != null && !z && this.a.getView().getTop() < this.c.b.y5().m1().getMeasuredHeight()) {
                    this.c.b.y5().T0().setSelectionFromTop(ListUtils.getPosition(this.c.b.y5().T0().getData(), this.b) + this.c.b.y5().T0().getHeaderViewsCount(), this.c.b.y5().m1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ z18 b;

        public h(z18 z18Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z18Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z18Var;
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

        public i(z18 z18Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z18Var, pbCommenFloorItemViewHolder};
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
        public final /* synthetic */ z18 b;

        public k(z18 z18Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z18Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z18Var;
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
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", this.b.d0(this.a.o)).param("obj_type", i));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.b.l.m());
                statisticItem.param("tid", this.b.l.S());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.b.l.j().M());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", this.b.b0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z18(z48 z48Var, BdUniqueId bdUniqueId) {
        super(z48Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z48Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((z48) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.y = new og<>(new c(this), 6, 0);
        this.z = new og<>(new d(this), 12, 0);
        this.A = new qy7(new e(this));
        if (z48Var != null && z48Var.K() != null) {
            this.v = z48Var.K().R1();
        }
        this.g = s(R.dimen.tbds14);
    }

    public final void E(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.p);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new b(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.i = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onLongClickListener) == null) {
            this.q = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.s = i2;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void l0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048612, this, f2) == null) {
            this.j = f2;
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.t = z;
        }
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, yVar) == null) {
            this.o = yVar;
        }
    }

    public void n0(qy7 qy7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, qy7Var) == null) {
            this.p = qy7Var;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.k = str;
        }
    }

    public void o0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, sVar) == null) {
            this.h = sVar;
        }
    }

    public final void q0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof PostData)) {
            return;
        }
        r0(textView, (PostData) tag);
    }

    public void r(ox7 ox7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, ox7Var) == null) {
            this.l = ox7Var;
        }
    }

    public final void N(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null && (imageView = pbCommenFloorItemViewHolder.O) != null && this.l != null) {
            imageView.setVisibility(8);
        }
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.d0;
            if (postData.b0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.h(postData.S, postData.M(), this.x);
        }
    }

    public final void h0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, pbCommenFloorItemViewHolder, postData) == null) {
            TbRichText X = postData.X();
            X.isChanged = true;
            pbCommenFloorItemViewHolder.q.setText(X, true, this.h);
        }
    }

    public final void F(PostData postData) {
        ox7 ox7Var;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData) == null) && (ox7Var = this.l) != null) {
            if (ox7Var.y0()) {
                AbsVideoPbFragment absVideoPbFragment = this.c;
                if (absVideoPbFragment != null) {
                    BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                    ox7 ox7Var2 = this.l;
                    int i4 = postData.d0;
                    if (postData.c0) {
                        i3 = 2;
                    } else {
                        i3 = 8;
                    }
                    p48.e(uniqueId, ox7Var2, postData, i4, i3, "common_exp_source_pb_comment");
                    return;
                }
                return;
            }
            PbFragment pbFragment = this.b;
            if (pbFragment != null) {
                BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                ox7 ox7Var3 = this.l;
                int i5 = postData.d0;
                if (postData.c0) {
                    i2 = 2;
                } else {
                    i2 = 8;
                }
                p48.e(uniqueId2, ox7Var3, postData, i5, i2, "common_exp_source_pb_comment");
            }
        }
    }

    public final void G(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData) == null) && postData.E == 0 && postData.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.M());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            z48 z48Var = this.a;
            if (z48Var != null) {
                int R1 = z48Var.K().R1();
                if (1 != R1 && 2 != R1) {
                    if (3 == R1) {
                        statisticItem.param("obj_source", "2");
                    } else {
                        statisticItem.param("obj_source", "0");
                    }
                } else {
                    statisticItem.param("obj_source", "1");
                }
            }
            TiebaStatic.log(statisticItem);
            if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaInfo().live_status == 1) {
                i0(postData);
            }
        }
    }

    public final void H(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int m = ((((yi.m(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                m = (m - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = s(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().H = (m - i3) - s(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                m /= 2;
            }
            tbRichTextView.getLayoutStrategy().q((int) ((m - i3) * this.j));
            tbRichTextView.getLayoutStrategy().p((int) (m * 1.618f * this.j));
        }
    }

    public final void I(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.Y.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f05f3);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.a0.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.Y.setVisibility(0);
            pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0405);
        }
    }

    public final void K(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.P) != null && pbCommenFloorItemViewHolder.Z != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.Z.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !ListUtils.isEmpty(postData.b0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.P.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.Z.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().l(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().l(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.Z.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = yi.g(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().l(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = yi.g(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
            }
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048591, this, pbCommenFloorItemViewHolder, postData, view2) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = yi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = yi.g(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
            if (!this.i) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().g(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.q.k0(null);
                pbCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f08127e);
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().x(R.drawable.pic_video);
            H(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(postData.v()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.q.setText(postData.X(), true, this.h);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.obfuscated_res_0x7f092094, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f0920ad, Boolean.FALSE);
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.obfuscated_res_0x7f0920a7, sparseArray);
            pbCommenFloorItemViewHolder.t0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.k0.setTag(sparseArray);
        }
    }

    public final void L(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).j0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.j0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.j0.K();
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
            statisticItem.param("fid", this.l.m());
            statisticItem.param("tid", this.l.S());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("post_id", this.l.j().M());
            statisticItem.param("obj_source", 1);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", b0());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: f0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06fc, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0918ab)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06f4, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.P().getPageContext(), inflate, this.v);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.v;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.w);
                pbCommenFloorItemViewHolder.v.setIsVideoThread(true);
            }
            p0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.q;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.u);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void i0(PostData postData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, postData) == null) {
            String userId = postData.s().getUserId();
            ox7 ox7Var = this.l;
            String str2 = "";
            if (ox7Var == null) {
                str = "";
            } else {
                str = ox7Var.m();
            }
            ox7 ox7Var2 = this.l;
            if (ox7Var2 != null) {
                str2 = ox7Var2.n();
            }
            int D = postData.D();
            String M = postData.M();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", M);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, D);
            if (postData.s().getAlaInfo() != null) {
                AlaInfoData alaInfo = postData.s().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void M(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, postData) == null) && postData != null) {
            int i2 = 8;
            if (postData.c0) {
                i2 = 2;
            }
            StatisticItem i3 = p48.i(this.l, postData, postData.d0, i2, 6);
            postData.e0 = i3;
            if (!ListUtils.isEmpty(postData.b0())) {
                Iterator<PostData> it = postData.b0().iterator();
                while (it.hasNext()) {
                    it.next().e0 = i3;
                }
            }
        }
    }

    public final String d0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            Object obj = "1";
            if (sparseArray == null) {
                return "1";
            }
            Object obj2 = sparseArray.get(R.id.obfuscated_res_0x7f0918cb);
            if (obj2 != null) {
                obj = obj2;
            }
            sparseArray.remove(R.id.obfuscated_res_0x7f0918cb);
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
    public final void O(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        ox7 ox7Var;
        ox7 ox7Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            String str = null;
            boolean z3 = true;
            if (postData.D() > 0 && (ox7Var2 = this.l) != null && !ox7Var2.l0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f09af), Integer.valueOf(postData.D()));
                pbCommenFloorItemViewHolder.J.setVisibility(0);
                pbCommenFloorItemViewHolder.J.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.J.setVisibility(8);
                z = false;
            }
            if (postData.s() != null) {
                str = postData.s().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    n55 T = postData.T();
                    z3 = (T != null || StringUtils.isNull(T.b()) || (ox7Var = this.l) == null || ox7Var.l0()) ? false : false;
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
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.i0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(postData.i0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(postData.i0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(this.g, 0, 0, 0);
                        TextView textView = pbCommenFloorItemViewHolder.n;
                        textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1549) + str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(this.g, 0, 0, 0);
                        if (postData.b0) {
                            pbCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(T.b(), 7, StringHelper.STRING_MORE));
                        } else {
                            pbCommenFloorItemViewHolder.n.setText(T.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.n.setVisibility(8);
                    }
                    TextView textView2 = pbCommenFloorItemViewHolder.m0;
                    textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            n55 T2 = postData.T();
            if (T2 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            i3 = this.g;
            pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.i0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView22 = pbCommenFloorItemViewHolder.m0;
            textView22.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void r0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            ox7 ox7Var = this.l;
            if (ox7Var != null && ox7Var.l0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.s() != null) {
                MetaData s = postData.s();
                String str = this.k;
                if (str != null && !"0".equals(str) && this.k.equals(s.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f0894);
                    textView.setBackgroundColor(0);
                    pw4 d2 = pw4.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.s0()) {
                    pw4 d3 = pw4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0347);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    pw4 d4 = pw4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0300);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    pw4 d5 = pw4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0301);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    pw4 d6 = pw4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fd);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    pw4 d7 = pw4.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fe);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048587, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.l0.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.t0.setVisibility(8);
            Z(pbCommenFloorItemViewHolder, postData, view2, i2);
            a0(pbCommenFloorItemViewHolder, postData);
            N(pbCommenFloorItemViewHolder, postData);
            R(pbCommenFloorItemViewHolder, postData);
            U(pbCommenFloorItemViewHolder, postData, view2);
            T(pbCommenFloorItemViewHolder, postData, view2, i2);
            O(pbCommenFloorItemViewHolder, postData);
            W(pbCommenFloorItemViewHolder, postData);
            S(pbCommenFloorItemViewHolder, postData);
            X(pbCommenFloorItemViewHolder, postData);
            cz7.d(pbCommenFloorItemViewHolder, postData, view2, this.i, this.A);
            P(pbCommenFloorItemViewHolder, postData);
            V(pbCommenFloorItemViewHolder, postData);
            Y(pbCommenFloorItemViewHolder, postData);
            cz7.i(pbCommenFloorItemViewHolder, view2, postData, this.t, true);
            cz7.q(this.a.P().getPageContext(), pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null && postData.q() != null) {
            postData.q().threadId = this.a.K().m2();
            postData.q().objType = 1;
            postData.q().isInPost = true;
            ThreadData threadData = null;
            ox7 ox7Var = this.l;
            if (ox7Var != null && ox7Var.Q() != null) {
                threadData = this.l.Q();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setThreadData(threadData);
            pbCommenFloorItemViewHolder.o.setData(postData.q());
            pbCommenFloorItemViewHolder.j0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.j0.setData(postData.q());
        }
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            z48 z48Var = this.a;
            if (z48Var != null && z48Var.K() != null && StringHelper.equals(this.a.K().t1(), postData.M())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
                return;
            }
            z48 z48Var2 = this.a;
            if (z48Var2 != null && z48Var2.K() != null && StringHelper.equals(this.a.K().s1(), postData.M())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
                ah.a().postDelayed(new f(this, pbCommenFloorItemViewHolder), 3000L);
                return;
            }
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
        }
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.s() != null && postData.e0() != null) {
                TbRichText X = postData.X();
                if (X != null && StringUtils.isNull(X.toString()) && StringUtils.isNull(postData.v())) {
                    z = true;
                } else {
                    z = false;
                }
                if (postData.s().getSmallTailThemeData() != null) {
                    str = postData.s().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.Q.setTag(R.id.obfuscated_res_0x7f0920c4, str);
                pbCommenFloorItemViewHolder.R.setTag(R.id.obfuscated_res_0x7f0920c4, str);
                w58.c(postData.e0(), pbCommenFloorItemViewHolder.Q, pbCommenFloorItemViewHolder.R, pbCommenFloorItemViewHolder.S, false, false, z, postData.s().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.Q.setVisibility(8);
            pbCommenFloorItemViewHolder.R.setVisibility(8);
        }
    }

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.W != null && pbCommenFloorItemViewHolder.T != null) {
            if (postData != null && (alaLiveInfoCoreData = postData.T) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.W.setText(postData.T.liveTitle);
                pbCommenFloorItemViewHolder.T.setTag(postData.T);
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

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData.H() != 2 && postData.H() != 4) {
                pbCommenFloorItemViewHolder.Z.setVisibility(8);
                pbCommenFloorItemViewHolder.Y.setVisibility(0);
                K(false, pbCommenFloorItemViewHolder, postData);
            } else {
                pbCommenFloorItemViewHolder.Z.setOnClickListener(new g(this, pbCommenFloorItemViewHolder, postData));
                pbCommenFloorItemViewHolder.Z.setVisibility(0);
                I(pbCommenFloorItemViewHolder, postData.u0(), postData.G());
                K(true, pbCommenFloorItemViewHolder, postData);
            }
            h0(pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null && TbSingleton.getInstance().isUserGrowthOpen() && postData.s().getUserGrowthData() != null) {
            int a2 = postData.s().getUserGrowthData().a();
            if (a2 >= 0 && a2 <= 10) {
                pbCommenFloorItemViewHolder.j.setImageResource(ex.b(a2));
                pbCommenFloorItemViewHolder.j.setVisibility(0);
                pbCommenFloorItemViewHolder.j.setOnClickListener(new h(this, a2));
                CommonStatisticUtils.staticNameplateOfUserLevel(1, 7, a2);
                return;
            }
            pbCommenFloorItemViewHolder.j.setVisibility(8);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048590, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.d0() > 0) {
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.x.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.x.setTag(sparseArray);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f0920b1, postData);
                if (postData.H() == 2) {
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
                sparseArray2.put(R.id.obfuscated_res_0x7f0920b1, postData);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.obfuscated_res_0x7f0920b1, postData);
            }
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            boolean z = true;
            if (!postData.r0() && !postData.q0(true)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams2.topMargin = yi.g(this.mContext, R.dimen.tbds10);
                layoutParams2.leftMargin = yi.g(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = yi.g(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = yi.g(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams2);
                if (this.r == null) {
                    y38 y38Var = new y38(this.mContext);
                    this.r = y38Var;
                    y38Var.f(this.e);
                    this.r.h(this.m);
                    this.r.e(this.n);
                    String str = null;
                    ox7 ox7Var = this.l;
                    if (ox7Var != null && ox7Var.Q() != null && this.l.Q().getAuthor() != null) {
                        str = this.l.Q().getAuthor().getUserId();
                    }
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    ox7 ox7Var2 = this.l;
                    if (ox7Var2 != null) {
                        this.r.j(ox7Var2.Y(), z);
                        this.r.i(this.l.Q());
                    }
                }
                this.r.g(postData.M());
                pbCommenFloorItemViewHolder.v.setSubPbAdapter(this.r);
                pbCommenFloorItemViewHolder.v.setVisibility(0);
                pbCommenFloorItemViewHolder.v.setData(postData, view2);
                pbCommenFloorItemViewHolder.v.setChildOnClickListener(this.n);
                pbCommenFloorItemViewHolder.v.setChildOnLongClickListener(this.q);
                pbCommenFloorItemViewHolder.v.setChildOnTouchListener(this.A);
            }
            if (postData.P) {
                pbCommenFloorItemViewHolder.P.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.P.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams3.topMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.w.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.u.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.u.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.n0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1031));
        }
    }

    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ox7 ox7Var = this.l;
            if (ox7Var != null && ox7Var.Q() != null) {
                return this.l.Q().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final SpannableStringBuilder c0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new w36.a(str, R.drawable.pic_smalldot_title));
                return w36.h(this.a.P(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public View g0(int i2, View view2, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, postData, pbCommenFloorItemViewHolder);
            p0(pbCommenFloorItemViewHolder);
            k0(pbCommenFloorItemViewHolder);
            E(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) getItem(i2);
            if (postData2 != null) {
                postData2.d0 = i2 + 1;
                G(postData2);
                F(postData2);
                postData2.l1();
                M(postData2);
                Q(pbCommenFloorItemViewHolder, postData2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void k0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.q);
            if (this.a.P() != null && this.a.P().getPageContext() != null && this.a.P().getPageContext().getOrignalPage() != null) {
                w28 w28Var = this.a.P().d;
                pbCommenFloorItemViewHolder.g.setOnClickListener(w28Var.b);
                pbCommenFloorItemViewHolder.p.setOnClickListener(w28Var.b);
                pbCommenFloorItemViewHolder.L.setOnClickListener(w28Var.b);
                pbCommenFloorItemViewHolder.L.getHeadView().setOnClickListener(w28Var.b);
                pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.q);
                pbCommenFloorItemViewHolder.q.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.n);
                pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.o);
                pbCommenFloorItemViewHolder.q.setOnImageTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(w28Var.f);
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
                y28 y28Var = this.a.P().e;
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.z.setOnClickListener(new j(this, pbCommenFloorItemViewHolder, y28Var));
                pbCommenFloorItemViewHolder.o.A = new k(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.j0.A = new a(this, pbCommenFloorItemViewHolder);
            }
        }
    }

    @Override // com.baidu.tieba.f08, com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        g0(i2, view2, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void p0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048621, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            q0(pbCommenFloorItemViewHolder.i);
            boolean z = true;
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    q18.F(pbCommenFloorItemViewHolder.g);
                } else {
                    pw4.d(pbCommenFloorItemViewHolder.g).A(R.string.F_X02);
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
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.v, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f0809c7, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f0809c8, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
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
                pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0405);
            } else {
                ox7 ox7Var = this.l;
                if (ox7Var != null && StringUtils.isNull(ox7Var.k())) {
                    pbCommenFloorItemViewHolder.a0.setText(this.l.k());
                } else {
                    pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f05f3);
                }
            }
            pbCommenFloorItemViewHolder.o.M(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.k0, R.drawable.obfuscated_res_0x7f0809a2, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t0, R.drawable.obfuscated_res_0x7f0809a2, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }
}
