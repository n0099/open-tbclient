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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.a26;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.ww7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class jy7 extends ly7 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ww7 A;
    public boolean B;
    public TbRichTextView.s g;
    public boolean h;
    public float i;
    public String j;
    public uv7 k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public TbRichTextView.y n;
    public ww7 o;
    public View.OnLongClickListener p;
    public d28 q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public String x;
    public vg y;
    public vg z;

    /* JADX WARN: Removed duplicated region for block: B:275:0x07e3  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x07ee  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x07f7  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x083a  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0844  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x08aa  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x08b4  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x08f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048603, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        if (postData.Q) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.e.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.e.setVisibility(8);
        }
        pbCommenFloorItemViewHolder.p.setTag(null);
        pbCommenFloorItemViewHolder.p.setUserId(null);
        pbCommenFloorItemViewHolder.L.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.q.setIsHost(false);
        if (postData.s() != null) {
            String str = this.j;
            if (str != null && !str.equals("0") && this.j.equals(postData.s().getUserId())) {
                pbCommenFloorItemViewHolder.q.setIsHost(true);
            }
            ArrayList iconInfo = postData.s().getIconInfo();
            ArrayList tShowInfoNew = postData.s().getTShowInfoNew();
            int f2 = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            int f3 = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (iconInfo.size() < 2) {
                i3 = iconInfo.size();
                if (i3 > 1) {
                    postData.f1((f2 * i3) + (f3 * i3));
                } else if (i3 == 1) {
                    postData.f1(f2 + f3);
                } else {
                    postData.f1(0);
                }
            } else {
                postData.f1((f2 * 2) + (f3 * 2));
                i3 = 2;
            }
            if (pbCommenFloorItemViewHolder.M != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.M.setTag(((IconData) tShowInfoNew.get(0)).getUrl());
                }
                e38 e38Var = this.a;
                if (e38Var != null && e38Var.P() != null) {
                    pbCommenFloorItemViewHolder.M.setOnClickListener(this.a.P().d.e);
                }
                int f4 = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.M.h(tShowInfoNew, 3, f4, f4, fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        wz7.m(pbCommenFloorItemViewHolder.g);
                    } else {
                        nv4.d(pbCommenFloorItemViewHolder.g).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            int i4 = postData.b0 ? 2 : 8;
            pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092091, postData.s().getUserId());
            pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092099, postData.s().getUserName());
            pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f09209b, postData.s().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092087, u28.i(this.k, postData, postData.c0, i4, 2));
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.h.setText(uu7.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                pbCommenFloorItemViewHolder.g.setGravity(16);
                pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092066, uu7.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.L.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.L.j(postData.s(), 4);
                pbCommenFloorItemViewHolder.p.setVisibility(8);
                pbCommenFloorItemViewHolder.L.setVisibility(0);
                pbCommenFloorItemViewHolder.L.getHeadView().L(avater, 28, false);
                pbCommenFloorItemViewHolder.L.getHeadView().setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.L.getHeadView().setUserName(postData.s().getUserName());
                uv7 uv7Var = this.k;
                pbCommenFloorItemViewHolder.L.getHeadView().setFid(uv7Var != null ? uv7Var.m() : "");
                uv7 uv7Var2 = this.k;
                pbCommenFloorItemViewHolder.L.getHeadView().setFName(uv7Var2 != null ? uv7Var2.n() : "");
                pbCommenFloorItemViewHolder.L.getHeadView().setFloor(postData.D());
                pbCommenFloorItemViewHolder.L.getHeadView().setTid(postData.M());
                pbCommenFloorItemViewHolder.L.getHeadView().setTag(R.id.obfuscated_res_0x7f092087, u28.i(this.k, postData, postData.c0, i4, 2));
                pbCommenFloorItemViewHolder.L.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, postData.s(), 4);
                pbCommenFloorItemViewHolder.p.setUserId(postData.s().getUserId());
                uv7 uv7Var3 = this.k;
                pbCommenFloorItemViewHolder.p.setFid(uv7Var3 != null ? uv7Var3.m() : "");
                uv7 uv7Var4 = this.k;
                pbCommenFloorItemViewHolder.p.setFName(uv7Var4 != null ? uv7Var4.n() : "");
                pbCommenFloorItemViewHolder.p.setFloor(postData.D());
                pbCommenFloorItemViewHolder.p.setTid(postData.M());
                pbCommenFloorItemViewHolder.p.setUserName(postData.s().getUserName(), postData.i0());
                pbCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f09209b, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f092087, u28.i(this.k, postData, postData.c0, i4, 2));
                pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                pbCommenFloorItemViewHolder.p.L(avater, 28, false);
                pbCommenFloorItemViewHolder.p.setVisibility(0);
                pbCommenFloorItemViewHolder.L.setVisibility(8);
            }
            if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaUserData() != null && postData.s().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.d(true);
                pbCommenFloorItemViewHolder.p.setLiveStatus(1);
                pbCommenFloorItemViewHolder.p.setAlaInfo(postData.s().getAlaInfo());
                pbCommenFloorItemViewHolder.L.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.L.getHeadView().setAlaInfo(postData.s().getAlaInfo());
            } else {
                pbCommenFloorItemViewHolder.d(false);
                pbCommenFloorItemViewHolder.p.setLiveStatus(0);
                pbCommenFloorItemViewHolder.p.setAlaInfo(null);
                pbCommenFloorItemViewHolder.L.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.L.getHeadView().setAlaInfo(null);
            }
            B0(pbCommenFloorItemViewHolder.i, postData);
            if (TbSingleton.getInstance().isUserGrowthOpen() && postData.s().getUserGrowthData() != null) {
                int a2 = postData.s().getUserGrowthData().a();
                if (a2 >= 0 && a2 <= 10) {
                    pbCommenFloorItemViewHolder.j.setImageResource(lx.b(a2));
                    pbCommenFloorItemViewHolder.j.setVisibility(0);
                    pbCommenFloorItemViewHolder.j.setOnClickListener(new l(this, a2));
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 4, a2);
                } else {
                    pbCommenFloorItemViewHolder.j.setVisibility(8);
                }
            }
        } else {
            i3 = 2;
        }
        e38 e38Var2 = this.a;
        int level_id = (e38Var2 == null || e38Var2.P() == null || !this.a.P().u0() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        uv7 uv7Var5 = this.k;
        if (uv7Var5 != null && uv7Var5.k0()) {
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
        if (postData.y() > 1000) {
            i5 -= 2;
        }
        if (postData.y() > 10) {
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
        int e2 = wz7.e();
        String[] strArr = new String[1];
        strArr[0] = (postData.s() == null || postData.s().getName_show() == null) ? "" : postData.s().getName_show();
        int d2 = oi5.d(strArr[0]);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i6 = e2 - 2;
            if (d2 > i6) {
                strArr[0] = oi5.l(strArr[0], i6);
                strArr[0] = strArr[0] + StringHelper.STRING_MORE;
            }
        } else if (d2 > e2) {
            strArr[0] = oi5.l(strArr[0], e2);
            strArr[0] = strArr[0] + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.h.setText(i0(postData.s().getSealPrefix(), strArr[0]));
        } else {
            pbCommenFloorItemViewHolder.h.setText(strArr[0]);
        }
        if (((PostData) getItem(i2)).P() == 1 && this.k.P() != null && this.k.P().isQuestionThread() && !R(postData)) {
            ((PostData) getItem(i2)).J0(true);
            pbCommenFloorItemViewHolder.C0.setVisibility(0);
            if (((PostData) getItem(i2)).O().booleanValue()) {
                pbCommenFloorItemViewHolder.D0.setVisibility(0);
                pbCommenFloorItemViewHolder.i0.setVisibility(8);
                pbCommenFloorItemViewHolder.j0.setVisibility(8);
                pbCommenFloorItemViewHolder.D0.postDelayed(new m(this, pbCommenFloorItemViewHolder), 3000L);
            } else {
                pbCommenFloorItemViewHolder.D0.setVisibility(8);
                pbCommenFloorItemViewHolder.i0.setVisibility(0);
                pbCommenFloorItemViewHolder.j0.setVisibility(0);
            }
        } else {
            ((PostData) getItem(i2)).J0(false);
            pbCommenFloorItemViewHolder.C0.setVisibility(8);
            pbCommenFloorItemViewHolder.D0.setVisibility(8);
            pbCommenFloorItemViewHolder.i0.setVisibility(0);
            pbCommenFloorItemViewHolder.j0.setVisibility(0);
        }
        SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.C0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.B0, R.color.CAM_X0105, 1);
        pbCommenFloorItemViewHolder.f.post(new n(this, pbCommenFloorItemViewHolder, postData, new String[]{strArr[0]}, 2));
        if (!StringUtils.isNull(postData.s().getDiplayIntro())) {
            pbCommenFloorItemViewHolder.E0.setVisibility(0);
            pbCommenFloorItemViewHolder.E0.setText(postData.s().getDiplayIntro() + "");
        } else {
            pbCommenFloorItemViewHolder.E0.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f09203c, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092059, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f09205b, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f09206a, Integer.valueOf(i2));
        sparseArray.put(R.id.obfuscated_res_0x7f092069, Integer.valueOf(postData.D()));
        sparseArray.put(R.id.obfuscated_res_0x7f09204c, postData.M());
        sparseArray.put(R.id.obfuscated_res_0x7f0917e1, pbCommenFloorItemViewHolder.o);
        sparseArray.put(R.id.obfuscated_res_0x7f0917e2, pbCommenFloorItemViewHolder.i0);
        sparseArray.put(R.id.obfuscated_res_0x7f0917df, pbCommenFloorItemViewHolder.y);
        sparseArray.put(R.id.obfuscated_res_0x7f0917e0, pbCommenFloorItemViewHolder.z);
        uv7 uv7Var6 = this.k;
        ThreadData P = (uv7Var6 == null || uv7Var6.P() == null) ? null : this.k.P();
        if (P != null && P.isUgcThreadType()) {
            sparseArray.put(R.id.obfuscated_res_0x7f0917de, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.obfuscated_res_0x7f0917de, Boolean.FALSE);
        }
        boolean z8 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        uv7 uv7Var7 = this.k;
        if (uv7Var7 == null || uv7Var7.X() == 0 || k0()) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            z = (this.k.X() == 1002 || this.k.X() == 3) ? false : true;
            if (this.k.X() == 3 || this.k.k0()) {
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
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        uv7 uv7Var8 = this.k;
        if (uv7Var8 != null && uv7Var8.P() != null && this.k.P().getAuthor() != null && postData.s() != null) {
            String userId2 = this.k.P().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
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
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z4 = true;
                    z6 = true;
                }
                if (z8) {
                    z = false;
                    z5 = false;
                    z4 = false;
                }
                int i7 = postData.D() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092084, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(this.k.X()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092049, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f09204a, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f09204b, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092084, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092053, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092094, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f092095, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f092093, postData.s().getName_show());
                    }
                    if (this.k.P() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092097, this.k.P().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092096, postData.M());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092050, Boolean.valueOf(postData.p0()));
                    sparseArray.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(this.k.X()));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f092040, Integer.valueOf(i7));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203e, postData.M());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09205d, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f092054, Boolean.valueOf(z7));
                pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            }
        }
        z4 = z2;
        z5 = false;
        z6 = false;
        z7 = false;
        if (postData != null) {
            z4 = true;
            z6 = true;
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
        sparseArray.put(R.id.obfuscated_res_0x7f09205d, Boolean.valueOf(z3));
        sparseArray.put(R.id.obfuscated_res_0x7f092054, Boolean.valueOf(z7));
        pbCommenFloorItemViewHolder.q.setTag(sparseArray);
        pbCommenFloorItemViewHolder.s.setTag(sparseArray);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, view2) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ jy7 c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            /* renamed from: com.baidu.tieba.jy7$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class View$OnClickListenerC0291a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0291a(a aVar) {
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
                        u28.p("c14886");
                        e eVar = this.a.a;
                        jy7 jy7Var = eVar.c;
                        jy7Var.l0(((PostData) jy7Var.getItem(eVar.a)).s());
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
                        e eVar = this.a.a;
                        ((PostData) eVar.c.getItem(eVar.a)).z0();
                        e eVar2 = this.a.a;
                        if (((PostData) eVar2.c.getItem(eVar2.a)).W() <= 0) {
                            e eVar3 = this.a.a;
                            ((PostData) eVar3.c.getItem(eVar3.a)).P0(Boolean.FALSE);
                            this.a.a.b.D0.setVisibility(8);
                            this.a.a.b.i0.setVisibility(0);
                            this.a.a.b.j0.setVisibility(0);
                        }
                    }
                }
            }

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.b.i0.getAgreeFlag()) {
                    return;
                }
                e eVar = this.a;
                ((PostData) eVar.c.getItem(eVar.a)).y0();
                e eVar2 = this.a;
                ((PostData) eVar2.c.getItem(eVar2.a)).P0(Boolean.TRUE);
                this.a.b.i0.setVisibility(8);
                this.a.b.j0.setVisibility(8);
                this.a.b.D0.setVisibility(0);
                this.a.b.D0.setOnClickListener(new View$OnClickListenerC0291a(this));
                this.a.b.D0.postDelayed(new b(this), 5000L);
            }
        }

        public e(jy7 jy7Var, int i, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var, Integer.valueOf(i), pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jy7Var;
            this.a = i;
            this.b = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !UtilHelper.isCurrentAccount(this.c.k.P().getAuthor().getUserId()) || !this.c.k.P().isQuestionThread() || UtilHelper.isCurrentAccount(((PostData) this.c.getItem(this.a)).s().getUserId())) {
                return;
            }
            if (this.b.i0.getAgreeFlag()) {
                ((PostData) this.c.getItem(this.a)).Q0(1);
                this.b.C0.setVisibility(0);
                ((PostData) this.c.getItem(this.a)).J0(true);
                this.b.i.setVisibility(8);
                this.b.i0.postDelayed(new a(this), 900L);
                return;
            }
            ((PostData) this.c.getItem(this.a)).Q0(0);
            this.b.D0.setVisibility(8);
            this.b.C0.setVisibility(8);
            this.b.i0.setVisibility(0);
            this.b.j0.setVisibility(0);
            ((PostData) this.c.getItem(this.a)).J0(false);
            if (((PostData) this.c.getItem(this.a)).Y().booleanValue()) {
                this.b.i.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ d18 b;
        public final /* synthetic */ jy7 c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ b b;

            public a(b bVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.b;
                    bVar.b.b.a(bVar.c.k, null, this.a, bVar.a.q.getLayoutStrategy());
                }
            }
        }

        public b(jy7 jy7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, d18 d18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var, pbCommenFloorItemViewHolder, d18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jy7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = d18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092059) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092059)) != null && this.a.c != null && this.b != null) {
                hh.a().postDelayed(new a(this, postData), 100L);
                String R = this.c.k.R();
                if ((StringUtils.isNull(R) || "0".equals(this.c.k.R())) && this.c.k.P() != null) {
                    R = this.c.k.P().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", R).param("fid", this.c.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.M()).param("obj_source", this.c.j0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public a(jy7 jy7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var, pbCommenFloorItemViewHolder};
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

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ jy7 b;

        public c(jy7 jy7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jy7Var;
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
                String R = this.b.k.R();
                if ((StringUtils.isNull(R) || "0".equals(this.b.k.R())) && this.b.k.P() != null) {
                    R = this.b.k.P().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", R).param("fid", this.b.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", this.b.j0(this.a.o)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ jy7 b;

        public d(jy7 jy7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jy7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.i0) != null && agreeView.getData() != null) {
                if (view2 == this.a.i0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String R = this.b.k.R();
                if ((StringUtils.isNull(R) || "0".equals(this.b.k.R())) && this.b.k.P() != null) {
                    R = this.b.k.P().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", R).param("fid", this.b.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.i0.getData().postId).param("obj_source", this.b.j0(this.a.i0)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy7 a;

        public f(jy7 jy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jy7Var;
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

    /* loaded from: classes4.dex */
    public class g implements wg {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy7 a;

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

        public g(jy7 jy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jy7Var;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) obj;
            e(constrainImageLayout);
            return constrainImageLayout;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) obj;
            h(constrainImageLayout);
            return constrainImageLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
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
    public class h implements wg {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy7 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public h(jy7 jy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jy7Var;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            TbImageView tbImageView = (TbImageView) obj;
            e(tbImageView);
            return tbImageView;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            TbImageView tbImageView = (TbImageView) obj;
            h(tbImageView);
            return tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
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
        @Override // com.baidu.tieba.wg
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
    public class i implements ww7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy7 a;

        @Override // com.baidu.tieba.ww7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public i(jy7 jy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jy7Var;
        }

        @Override // com.baidu.tieba.ww7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    if ((view2 instanceof TbListTextView) && this.a.m != null) {
                        this.a.m.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.Z6(false);
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

        @Override // com.baidu.tieba.ww7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (((pbFragment = this.a.b) != null && pbFragment.O5() != null && !this.a.b.O5().I1()) || view2.getId() == R.id.obfuscated_res_0x7f090a16)) {
                    return true;
                }
                if (view2 instanceof FrameLayout) {
                    this.a.S(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof FrameLayout) {
                            this.a.S((FrameLayout) parent);
                            break;
                        } else {
                            parent = parent.getParent();
                            i++;
                        }
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public j(jy7 jy7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var, pbCommenFloorItemViewHolder};
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tBLottieAnimationView = this.a.F0) != null) {
                tBLottieAnimationView.setVisibility(8);
                this.a.F0.pauseAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ jy7 c;

        public k(jy7 jy7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jy7Var;
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
                this.c.P(this.a, !z, this.b.G());
                this.b.M0(!z);
                this.c.o0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.O5() != null && this.c.b.O5().m1() != null && this.c.b.O5().T0() != null && !z && this.a.getView().getTop() < this.c.b.O5().m1().getMeasuredHeight()) {
                    this.c.b.O5().T0().setSelectionFromTop(ListUtils.getPosition(this.c.b.O5().T0().getData(), this.b) + this.c.b.O5().T0().getHeaderViewsCount(), this.c.b.O5().m1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ jy7 b;

        public l(jy7 jy7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jy7Var;
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
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public m(jy7 jy7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var, pbCommenFloorItemViewHolder};
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
                this.a.D0.setVisibility(8);
                this.a.i0.setVisibility(0);
                this.a.j0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ String[] c;
        public final /* synthetic */ int d;
        public final /* synthetic */ jy7 e;

        public n(jy7 jy7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, String[] strArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var, pbCommenFloorItemViewHolder, postData, strArr, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = jy7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = postData;
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
                this.e.h0();
                boolean z = true;
                boolean z2 = !this.e.R(this.b);
                if (!StringUtils.isNull(this.c[0])) {
                    i = this.a.h.getWidth();
                } else {
                    i = 0;
                }
                if (this.a.M.getVisibility() == 8) {
                    width = 0;
                } else {
                    width = this.a.M.getWidth() + wz7.c + wz7.b;
                }
                if (this.a.j.getVisibility() == 8) {
                    width2 = 0;
                } else {
                    width2 = this.a.j.getWidth() + wz7.b;
                }
                if (this.a.K.getVisibility() == 8) {
                    width3 = 0;
                } else {
                    width3 = this.a.K.getWidth() + wz7.b;
                }
                int g = wz7.g(measuredWidth, width, i, width2, width3, z2);
                if (g < 0 && !StringUtils.isNull(this.c[0])) {
                    this.a.g.setWidth(i + g);
                } else {
                    this.a.g.setWidth(i);
                    z = false;
                }
                if (this.a.h.getText() == null) {
                    if (z) {
                        this.a.g.setText(this.c[0]);
                        jy7 jy7Var = this.e;
                        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                        jy7Var.w0(pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.j);
                    } else {
                        this.a.g.setText(this.c[0]);
                        this.e.x0(this.a.j, false);
                    }
                } else if (z) {
                    PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder2 = this.a;
                    pbCommenFloorItemViewHolder2.g.setText(pbCommenFloorItemViewHolder2.h.getText());
                    jy7 jy7Var2 = this.e;
                    PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder3 = this.a;
                    jy7Var2.w0(pbCommenFloorItemViewHolder3.g, pbCommenFloorItemViewHolder3.j);
                } else {
                    PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder4 = this.a;
                    pbCommenFloorItemViewHolder4.g.setText(pbCommenFloorItemViewHolder4.h.getText());
                    this.e.x0(this.a.j, false);
                }
                this.e.N(this.b, this.a, g, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ TbImageView c;
        public final /* synthetic */ jy7 d;

        public o(jy7 jy7Var, TextView textView, TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy7Var, textView, tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jy7Var;
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
                if (layout.getEllipsisCount(lineCount) == 0) {
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
    public jy7(e38 e38Var, BdUniqueId bdUniqueId) {
        super(e38Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e38Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((e38) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.y = new vg(new g(this), 6, 0);
        this.z = new vg(new h(this), 12, 0);
        this.A = new ww7(new i(this));
        this.B = false;
        if (e38Var != null && e38Var.K() != null) {
            this.t = e38Var.K().R1();
        }
        s(R.dimen.tbds14);
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null && (imageView = pbCommenFloorItemViewHolder.O) != null && this.k != null) {
            imageView.setVisibility(8);
        }
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.d0;
            if (postData.a0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void f0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048602, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.h(postData.R, postData.M(), this.v);
        }
    }

    public final void o0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, pbCommenFloorItemViewHolder, postData) == null) {
            TbRichText X = postData.X();
            X.isChanged = true;
            pbCommenFloorItemViewHolder.q.setText(X, true, this.g);
        }
    }

    public final void w0(TextView textView, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, textView, tbImageView) == null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new o(this, textView, tbImageView));
        }
    }

    public final void A0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof PostData)) {
            return;
        }
        B0(textView, (PostData) tag);
    }

    public final void K(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.o);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new f(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.h = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onLongClickListener) == null) {
            this.p = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, yVar) == null) {
            this.n = yVar;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.j = str;
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.s = z;
        }
    }

    public void r(uv7 uv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, uv7Var) == null) {
            this.k = uv7Var;
        }
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.v = z;
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.r = z;
        }
    }

    public void u0(ww7 ww7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, ww7Var) == null) {
            this.o = ww7Var;
        }
    }

    public void v0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, sVar) == null) {
            this.g = sVar;
        }
    }

    @Override // com.baidu.tieba.ly7, com.baidu.tieba.rn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        n0(i2, view2, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void B0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            uv7 uv7Var = this.k;
            if (uv7Var != null && uv7Var.k0()) {
                postData.X0(Boolean.FALSE);
                postData.L0(0);
                textView.setTag(null);
            } else if (postData.s() != null) {
                MetaData s = postData.s();
                String str = this.j;
                if (str != null && !str.equals("0") && this.j.equals(s.getUserId())) {
                    postData.X0(Boolean.TRUE);
                    postData.L0(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f0889);
                    textView.setBackgroundColor(0);
                    nv4 d2 = nv4.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.q0()) {
                    nv4 d3 = nv4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    postData.X0(Boolean.TRUE);
                    postData.L0(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.obfuscated_res_0x7f0f0346);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    nv4 d4 = nv4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    postData.X0(Boolean.TRUE);
                    postData.L0(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.obfuscated_res_0x7f0f02ff);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    nv4 d5 = nv4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    postData.X0(Boolean.TRUE);
                    postData.L0(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.obfuscated_res_0x7f0f0300);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    nv4 d6 = nv4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    postData.X0(Boolean.TRUE);
                    postData.L0(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.obfuscated_res_0x7f0f02fc);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    nv4 d7 = nv4.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    postData.X0(Boolean.TRUE);
                    postData.L0(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.obfuscated_res_0x7f0f02fd);
                } else {
                    postData.X0(Boolean.FALSE);
                    postData.L0(0);
                }
            } else {
                postData.X0(Boolean.FALSE);
                postData.L0(0);
            }
        }
    }

    public void z0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, pbCommenFloorItemViewHolder, postData) == null) {
            String str = "#7F66FE";
            if (postData.k0() != null) {
                VirtualImageCustomFigure k0 = postData.k0();
                pbCommenFloorItemViewHolder.y0.setHeadImageViewResource(k0.getFigureUrl());
                pbCommenFloorItemViewHolder.y0.setTid(postData.M());
                pbCommenFloorItemViewHolder.y0.setLocate(a08.c);
                pbCommenFloorItemViewHolder.y0.setFrom(5);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(k0.getBackGroundType())) {
                    str = k0.getBackgroundValue();
                    pbCommenFloorItemViewHolder.y0.setHeadImageBackgroundColorResource(k0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(k0.getBackGroundType())) {
                    pbCommenFloorItemViewHolder.y0.setHeadImageBackgroundResource(k0.getBackgroundValue());
                }
                pbCommenFloorItemViewHolder.y0.e(postData.s());
                pbCommenFloorItemViewHolder.w0.setVisibility(8);
                pbCommenFloorItemViewHolder.z0.setVisibility(0);
                pbCommenFloorItemViewHolder.y0.setTag(R.id.obfuscated_res_0x7f092091, postData.s().getUserId());
                pbCommenFloorItemViewHolder.y0.setTag(R.id.obfuscated_res_0x7f092099, postData.s().getUserName());
                pbCommenFloorItemViewHolder.f();
                String o2 = ux4.o("key_reaction_guide_show_number_pb");
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.P() != null && this.b.P().getIntent() != null && this.b.P().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && !this.B && ux4.k().l(o2, 0) == 3) {
                    this.B = true;
                    pbCommenFloorItemViewHolder.F0.setVisibility(0);
                    pbCommenFloorItemViewHolder.F0.playAnimation();
                    hh.a().postDelayed(new j(this, pbCommenFloorItemViewHolder), 4000L);
                }
            } else {
                pbCommenFloorItemViewHolder.z0.setVisibility(8);
                pbCommenFloorItemViewHolder.y0.setTag(R.id.obfuscated_res_0x7f092091, null);
                pbCommenFloorItemViewHolder.y0.setTag(R.id.obfuscated_res_0x7f092099, null);
                pbCommenFloorItemViewHolder.w0.setVisibility(0);
                pbCommenFloorItemViewHolder.F0.setVisibility(8);
                pbCommenFloorItemViewHolder.F0.pauseAnimation();
            }
            if (postData.l0() != null && !TextUtils.isEmpty(postData.l0().getIcon())) {
                pbCommenFloorItemViewHolder.x0.setData(postData.l0(), false, str);
                pbCommenFloorItemViewHolder.x0.setVisibility(0);
                if (pbCommenFloorItemViewHolder.A0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.A0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbCommenFloorItemViewHolder.A0.setLayoutParams(marginLayoutParams);
                }
                pbCommenFloorItemViewHolder.x0.setTag(R.id.obfuscated_res_0x7f092091, postData.s().getUserId());
                pbCommenFloorItemViewHolder.x0.setTag(R.id.obfuscated_res_0x7f092099, postData.s().getUserName());
                this.w = a08.d;
                this.x = pbCommenFloorItemViewHolder.x0.getData();
                pbCommenFloorItemViewHolder.y0.setWithBubble(this.w);
                pbCommenFloorItemViewHolder.y0.setBubbleName(this.x);
                pbCommenFloorItemViewHolder.y0.setVirtualHeadUid(postData.s().getUserId());
            } else {
                if (pbCommenFloorItemViewHolder.A0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.A0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbCommenFloorItemViewHolder.A0.setLayoutParams(marginLayoutParams2);
                }
                pbCommenFloorItemViewHolder.x0.setVisibility(8);
                pbCommenFloorItemViewHolder.x0.setTag(R.id.obfuscated_res_0x7f092099, null);
                pbCommenFloorItemViewHolder.x0.setTag(R.id.obfuscated_res_0x7f092091, null);
                int i2 = a08.e;
                this.w = i2;
                pbCommenFloorItemViewHolder.y0.setWithBubble(i2);
            }
            if (pbCommenFloorItemViewHolder.y0.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.y0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            if (postData.k0() != null) {
                a08.a(2, postData.M(), a08.c, this.w, this.x, postData.t());
            }
        }
    }

    public final void L(PostData postData) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, postData) == null) {
            if (postData != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", postData.M());
                statisticItem.param("pid", postData.M());
                statisticItem.param("tid", postData.f0());
                statisticItem.param("fid", postData.I());
                statisticItem.param("fname", postData.J());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            uv7 uv7Var = this.k;
            if (uv7Var != null) {
                if (uv7Var.x0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                        uv7 uv7Var2 = this.k;
                        int i4 = postData.c0;
                        if (postData.b0) {
                            i3 = 2;
                        } else {
                            i3 = 8;
                        }
                        u28.e(uniqueId, uv7Var2, postData, i4, i3, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                    uv7 uv7Var3 = this.k;
                    int i5 = postData.c0;
                    if (postData.b0) {
                        i2 = 2;
                    } else {
                        i2 = 8;
                    }
                    u28.e(uniqueId2, uv7Var3, postData, i5, i2, "common_exp_source_pb_comment");
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: m0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06e3, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091860)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06db, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.P().getPageContext(), inflate, this.t);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.v;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.u);
                pbCommenFloorItemViewHolder.v.setIsVideoThread(false);
            }
            y0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.q;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.s);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void p0(PostData postData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, postData) == null) {
            String userId = postData.s().getUserId();
            uv7 uv7Var = this.k;
            String str2 = "";
            if (uv7Var == null) {
                str = "";
            } else {
                str = uv7Var.m();
            }
            uv7 uv7Var2 = this.k;
            if (uv7Var2 != null) {
                str2 = uv7Var2.n();
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
        if ((interceptable == null || interceptable.invokeL(1048580, this, postData) == null) && postData.D == 0 && postData.L) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.M());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            e38 e38Var = this.a;
            if (e38Var != null) {
                int R1 = e38Var.K().R1();
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
                p0(postData);
            }
        }
    }

    public final void N(PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048581, this, postData, pbCommenFloorItemViewHolder, i2, i3) == null) {
            if (i2 > postData.n0() + postData.N()) {
                if (pbCommenFloorItemViewHolder.N != null && postData.s() != null) {
                    pbCommenFloorItemViewHolder.N.setTag(R.id.obfuscated_res_0x7f092091, postData.s().getUserId());
                    e38 e38Var = this.a;
                    if (e38Var != null && e38Var.P() != null) {
                        pbCommenFloorItemViewHolder.N.setOnClickListener(this.a.P().d.c);
                    }
                    ArrayList iconInfo = postData.s().getIconInfo();
                    int f2 = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.N.g(iconInfo, i3, f2, f2, fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (postData.Y().booleanValue() && !postData.L()) {
                    pbCommenFloorItemViewHolder.i.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.i.setVisibility(8);
                }
            } else if (i2 > postData.N()) {
                if (postData.Y().booleanValue() && !postData.L()) {
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

    public final void O(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int k2 = ((((fj.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                k2 = (k2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = s(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().q((int) ((k2 - i3) * this.i));
            tbRichTextView.getLayoutStrategy().H = (k2 - i3) - s(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().p((int) (k2 * 1.618f * this.i));
        }
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.Y.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f05ef);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.a0.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.Y.setVisibility(0);
            pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0402);
        }
    }

    public final void Q(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.P) != null && pbCommenFloorItemViewHolder.Z != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.Z.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !ListUtils.isEmpty(postData.a0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.P.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.Z.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().l(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().l(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.Z.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = fj.f(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
                }
            } else {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().l(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
                if (layoutParams != null) {
                    layoutParams.topMargin = fj.f(this.mContext, R.dimen.tbds14);
                    pbCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
                }
            }
            if (pbCommenFloorItemViewHolder.x0.getVisibility() != 0 && pbCommenFloorItemViewHolder.E0.getVisibility() != 0) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().j(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            } else {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().j(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            }
        }
    }

    public final boolean R(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, postData)) == null) {
            if (this.k.P() != null && this.k.P().getAuthor() != null && this.k.P().getAuthor().getUserId() != null && postData != null && postData.s() != null && postData.s().getUserId() != null) {
                return this.k.P().getAuthor().getUserId().equals(postData.s().getUserId());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void S(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).i0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.i0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.i0.J();
        }
    }

    public final void T(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, postData) == null) && postData != null) {
            int i2 = 8;
            if (postData.b0) {
                i2 = 2;
            }
            StatisticItem i3 = u28.i(this.k, postData, postData.c0, i2, 6);
            postData.d0 = i3;
            if (!ListUtils.isEmpty(postData.a0())) {
                Iterator<PostData> it = postData.a0().iterator();
                while (it.hasNext()) {
                    it.next().d0 = i3;
                }
            }
        }
    }

    public final String j0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            Object obj = "1";
            if (sparseArray == null) {
                return "1";
            }
            Object obj2 = sparseArray.get(R.id.obfuscated_res_0x7f09187f);
            if (obj2 != null) {
                obj = obj2;
            }
            sparseArray.remove(R.id.obfuscated_res_0x7f09187f);
            view2.setTag(sparseArray);
            return obj.toString();
        }
        return (String) invokeL.objValue;
    }

    public void l0(com.baidu.tbadk.data.MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, metaData) == null) {
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
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        boolean z2;
        uv7 uv7Var;
        uv7 uv7Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            String str = null;
            boolean z3 = true;
            if (postData.D() > 0 && (uv7Var2 = this.k) != null && !uv7Var2.k0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f09a1), Integer.valueOf(postData.D()));
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
                    p45 T = postData.T();
                    z3 = (T != null || StringUtils.isNull(T.b()) || (uv7Var = this.k) == null || uv7Var.k0()) ? false : false;
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
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.g0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(postData.g0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(postData.g0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        TextView textView = pbCommenFloorItemViewHolder.n;
                        textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1524) + str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        if (postData.a0) {
                            pbCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(T.b(), 7, StringHelper.STRING_MORE));
                        } else {
                            pbCommenFloorItemViewHolder.n.setText(T.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.n.setVisibility(8);
                    }
                    TextView textView2 = pbCommenFloorItemViewHolder.l0;
                    textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            p45 T2 = postData.T();
            if (T2 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.g0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView22 = pbCommenFloorItemViewHolder.l0;
            textView22.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void r0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048621, this, pbCommenFloorItemViewHolder, i2) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.p);
            if (this.a.P() != null && this.a.P().getPageContext() != null && this.a.P().getPageContext().getOrignalPage() != null) {
                b18 b18Var = this.a.P().d;
                pbCommenFloorItemViewHolder.g.setOnClickListener(b18Var.b);
                pbCommenFloorItemViewHolder.p.setOnClickListener(b18Var.b);
                pbCommenFloorItemViewHolder.y0.setOnClickListener(b18Var.d);
                pbCommenFloorItemViewHolder.x0.setOnClickListener(b18Var.d);
                pbCommenFloorItemViewHolder.L.setOnClickListener(b18Var.b);
                pbCommenFloorItemViewHolder.L.getHeadView().setOnClickListener(b18Var.b);
                pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.q.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.m);
                pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.n);
                pbCommenFloorItemViewHolder.q.setOnImageTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(b18Var.f);
                pbCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.m);
                pbCommenFloorItemViewHolder.Q.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.R.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.T.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.w.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.n0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.r0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.r0.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.j0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.s0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.k0.setOnClickListener(new a(this, pbCommenFloorItemViewHolder));
                d18 d18Var = this.a.P().e;
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.z.setOnClickListener(new b(this, pbCommenFloorItemViewHolder, d18Var));
                pbCommenFloorItemViewHolder.o.y = new c(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.i0.y = new d(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.i0.setAfterClickListener(new e(this, i2, pbCommenFloorItemViewHolder));
            }
        }
    }

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048591, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.k0.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.s0.setVisibility(8);
            g0(pbCommenFloorItemViewHolder, postData, view2, i2);
            U(pbCommenFloorItemViewHolder, postData);
            Y(pbCommenFloorItemViewHolder, postData);
            b0(pbCommenFloorItemViewHolder, postData, view2);
            a0(pbCommenFloorItemViewHolder, postData, view2, i2);
            V(pbCommenFloorItemViewHolder, postData);
            d0(pbCommenFloorItemViewHolder, postData);
            Z(pbCommenFloorItemViewHolder, postData);
            z0(pbCommenFloorItemViewHolder, postData);
            e0(pbCommenFloorItemViewHolder, postData);
            ix7.d(pbCommenFloorItemViewHolder, postData, view2, this.h, this.A);
            W(pbCommenFloorItemViewHolder, postData);
            c0(pbCommenFloorItemViewHolder, postData);
            f0(pbCommenFloorItemViewHolder, postData);
            ix7.i(pbCommenFloorItemViewHolder, view2, postData, this.r, true);
        }
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null && postData.q() != null) {
            postData.q().threadId = this.a.K().m2();
            postData.q().objType = 1;
            postData.q().isInPost = true;
            ThreadData threadData = null;
            uv7 uv7Var = this.k;
            if (uv7Var != null && uv7Var.P() != null) {
                threadData = this.k.P();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setThreadData(threadData);
            pbCommenFloorItemViewHolder.o.setData(postData.q());
            pbCommenFloorItemViewHolder.i0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.i0.setData(postData.q());
        }
    }

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.W != null && pbCommenFloorItemViewHolder.T != null) {
            if (postData != null && (alaLiveInfoCoreData = postData.S) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.W.setText(postData.S.liveTitle);
                pbCommenFloorItemViewHolder.T.setTag(postData.S);
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

    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.d0() != null) {
                TbRichText X = postData.X();
                if (X != null && StringUtils.isNull(X.toString()) && StringUtils.isNull(postData.v())) {
                    z = true;
                } else {
                    z = false;
                }
                b48.c(postData.d0(), pbCommenFloorItemViewHolder.Q, pbCommenFloorItemViewHolder.R, pbCommenFloorItemViewHolder.S, false, false, z);
                return;
            }
            pbCommenFloorItemViewHolder.Q.setVisibility(8);
            pbCommenFloorItemViewHolder.R.setVisibility(8);
        }
    }

    public final void e0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData.H() != 2 && postData.H() != 4) {
                pbCommenFloorItemViewHolder.Z.setVisibility(8);
                pbCommenFloorItemViewHolder.Y.setVisibility(0);
                Q(false, pbCommenFloorItemViewHolder, postData);
            } else {
                pbCommenFloorItemViewHolder.Z.setOnClickListener(new k(this, pbCommenFloorItemViewHolder, postData));
                pbCommenFloorItemViewHolder.Z.setVisibility(0);
                P(pbCommenFloorItemViewHolder, postData.s0(), postData.G());
                Q(true, pbCommenFloorItemViewHolder, postData);
            }
            o0(pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void x0(TbImageView tbImageView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048627, this, tbImageView, z) != null) || tbImageView == null) {
            return;
        }
        if (z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.setMargins(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds_16), fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
            tbImageView.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams2.setMargins(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
        tbImageView.setLayoutParams(layoutParams2);
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048594, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.c0() > 0) {
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.x.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.x.setTag(sparseArray);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f092059, postData);
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
                sparseArray2.put(R.id.obfuscated_res_0x7f092059, postData);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.obfuscated_res_0x7f092059, postData);
            }
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            if (!postData.p0() && !postData.o0(false)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams2.topMargin = fj.f(this.mContext, R.dimen.tbds0);
                layoutParams2.leftMargin = fj.f(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = fj.f(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = fj.f(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams2);
                if (this.q == null) {
                    d28 d28Var = new d28(this.mContext);
                    this.q = d28Var;
                    d28Var.f(this.e);
                    this.q.h(this.l);
                    this.q.e(this.m);
                    String str = null;
                    uv7 uv7Var = this.k;
                    if (uv7Var != null && uv7Var.P() != null && this.k.P().getAuthor() != null) {
                        str = this.k.P().getAuthor().getUserId();
                    }
                    boolean z = true;
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    uv7 uv7Var2 = this.k;
                    if (uv7Var2 != null) {
                        this.q.j(uv7Var2.X(), z);
                        this.q.i(this.k.P());
                    }
                }
                this.q.g(postData.M());
                pbCommenFloorItemViewHolder.v.setSubPbAdapter(this.q);
                pbCommenFloorItemViewHolder.v.setVisibility(0);
                pbCommenFloorItemViewHolder.v.setData(postData, view2);
                pbCommenFloorItemViewHolder.v.setChildOnClickListener(this.m);
                pbCommenFloorItemViewHolder.v.setChildOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.v.setChildOnTouchListener(this.A);
            }
            if (postData.O) {
                pbCommenFloorItemViewHolder.P.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.P.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams3.topMargin = fj.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = fj.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.w.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.u.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.u.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.m0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1010));
        }
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048595, this, pbCommenFloorItemViewHolder, postData, view2) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = fj.f(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = fj.f(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
            if (!this.h) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().g(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.q.k0(null);
                pbCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081252);
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().x(R.drawable.pic_video);
            O(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(postData.v()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.q.setText(postData.X(), true, this.g);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.obfuscated_res_0x7f09203c, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f092055, Boolean.FALSE);
            sparseArray.put(R.id.obfuscated_res_0x7f092056, Boolean.FALSE);
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.obfuscated_res_0x7f09204f, sparseArray);
            pbCommenFloorItemViewHolder.s0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.j0.setTag(sparseArray);
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            e38 e38Var = this.a;
            if (e38Var != null && e38Var.K() != null && StringHelper.equals(this.a.K().t1(), postData.M())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final SpannableStringBuilder i0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new a26.a(str, R.drawable.pic_smalldot_title));
                return a26.h(this.a.P(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            uv7 uv7Var = this.k;
            if (uv7Var != null && uv7Var.P() != null) {
                return this.k.P().isQuestionThread();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            uv7 uv7Var = this.k;
            if (uv7Var != null && uv7Var.P() != null) {
                return this.k.P().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View n0(int i2, View view2, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, postData, pbCommenFloorItemViewHolder);
            y0(pbCommenFloorItemViewHolder);
            r0(pbCommenFloorItemViewHolder, i2);
            K(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) getItem(i2);
            if (postData2 != null) {
                postData2.c0 = i2 + 1;
                M(postData2);
                L(postData2);
                postData2.j1();
                T(postData2);
                X(pbCommenFloorItemViewHolder, postData2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048628, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            A0(pbCommenFloorItemViewHolder.i);
            boolean z = true;
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    wz7.m(pbCommenFloorItemViewHolder.g);
                } else {
                    nv4.d(pbCommenFloorItemViewHolder.g).A(R.string.F_X02);
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
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.v, fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f0809aa, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f0809ab, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
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
                pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0402);
            } else {
                uv7 uv7Var = this.k;
                if (uv7Var != null && StringUtils.isNull(uv7Var.k())) {
                    pbCommenFloorItemViewHolder.a0.setText(this.k.k());
                } else {
                    pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f05ef);
                }
            }
            pbCommenFloorItemViewHolder.o.L(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.j0, R.drawable.obfuscated_res_0x7f080985, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.s0, R.drawable.obfuscated_res_0x7f080985, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }
}
