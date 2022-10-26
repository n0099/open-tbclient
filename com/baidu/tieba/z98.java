package com.baidu.tieba;

import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import com.baidu.tieba.personPolymeric.tab.view.AlignTextView;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BaijiahaoInfo;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes6.dex */
public class z98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public UserData B;
    public w88 C;
    public boolean D;
    public NoDataView E;
    public String F;
    public View.OnClickListener G;
    public TbPageContext a;
    public View b;
    public TextView c;
    public AlignTextView d;
    public TextView e;
    public LinearLayout f;
    public TextView g;
    public TextView h;
    public LinearLayout i;
    public TextView j;
    public AlignTextView k;
    public AlignTextView l;
    public TextView m;
    public ImageView n;
    public RelativeLayout o;
    public RelativeLayout p;
    public TextView q;
    public ImageView r;
    public TextView s;
    public View t;
    public ImageView u;
    public TextView v;
    public RoundRelativeLayout w;
    public TextView x;
    public TextView y;
    public ImageView z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z98 a;

        public a(z98 z98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z98Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Layout layout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (layout = this.a.m.getLayout()) != null) {
                int lineCount = layout.getLineCount();
                if (lineCount > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                    this.a.o.setOnClickListener(this.a.G);
                    this.a.n.setVisibility(0);
                    return;
                }
                this.a.o.setOnClickListener(null);
                this.a.n.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z98 a;

        public b(z98 z98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 != this.a.o && view2 != this.a.n) {
                    if (view2 == this.a.q) {
                        this.a.q();
                    } else if (view2 == this.a.r) {
                        this.a.q();
                    } else if (view2 == this.a.w) {
                        if (StringUtils.isNull(this.a.F)) {
                            BdToast.b(this.a.a.getPageActivity(), this.a.a.getPageActivity().getText(R.string.obfuscated_res_0x7f0f0800)).i();
                        } else {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.a.getPageActivity());
                            hotUserRankActivityConfig.setCategory(this.a.F);
                            hotUserRankActivityConfig.setIsGod(true);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                        }
                        TiebaStatic.log(new StatisticItem("c13899").param("uid", this.a.B.getUserId()));
                    }
                } else if (this.a.D) {
                    this.a.q();
                } else {
                    PersonIntroductionActivity.y1(this.a.a.getPageActivity(), this.a.B.getIntro());
                }
            }
        }
    }

    public z98(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = new b(this);
        this.a = tbPageContext;
        this.D = z;
        p();
    }

    public void n(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!z2 && z) {
                this.E.setVisibility(0);
            } else {
                this.E.setVisibility(8);
            }
        }
    }

    public void m(w88 w88Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, w88Var) == null) && w88Var != null && w88Var.j() != null) {
            this.C = w88Var;
            this.B = w88Var.j();
            this.b.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RecyclerView.LayoutParams(-1, -2);
            } else {
                layoutParams.width = -1;
            }
            this.b.setLayoutParams(layoutParams);
            if (this.B.getAlaUserData() != null && this.B.getAlaUserData().ala_id > 0) {
                this.i.setVisibility(0);
                this.h.setVisibility(0);
                this.h.setText(String.valueOf(this.B.getAlaUserData().ala_id));
            } else {
                this.i.setVisibility(8);
                this.h.setVisibility(8);
            }
            String tb_age = this.B.getTb_age();
            if (ej.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.j.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e6d, tb_age));
            hu4 birthdayInfo = this.B.getBirthdayInfo();
            if (birthdayInfo != null && !ej.isEmpty(birthdayInfo.b)) {
                if (birthdayInfo.c < 0) {
                    birthdayInfo.c = 0;
                }
                if (birthdayInfo.d == 2) {
                    this.e.setVisibility(0);
                    this.e.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e7e, Integer.valueOf(birthdayInfo.c)));
                } else {
                    this.e.setVisibility(8);
                }
                this.c.setVisibility(0);
                this.c.setText(birthdayInfo.b);
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
                this.c.setVisibility(8);
                this.e.setVisibility(8);
            }
            if (this.D) {
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
            String intro = this.B.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.B.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !ej.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!ej.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.j.getLeft(), 0), 0, spannableString.length(), 18);
                    this.m.setText(spannableString);
                    hh.a().post(new a(this));
                    this.p.setVisibility(8);
                    this.t.setVisibility(0);
                } else {
                    this.o.setVisibility(8);
                    if (this.D) {
                        this.p.setVisibility(0);
                        this.r.setVisibility(8);
                        this.t.setVisibility(8);
                    } else {
                        this.p.setVisibility(8);
                        this.t.setVisibility(0);
                    }
                }
            } else if (ej.isEmpty(intro)) {
                this.o.setVisibility(8);
                if (this.D) {
                    this.p.setVisibility(0);
                    this.r.setVisibility(8);
                    this.t.setVisibility(8);
                } else {
                    this.p.setVisibility(8);
                    this.t.setVisibility(0);
                }
            } else {
                this.p.setVisibility(8);
                this.o.setVisibility(8);
                this.t.setVisibility(0);
            }
            if (w88Var.E != null) {
                this.w.setVisibility(0);
                String str = w88Var.E.module_name;
                this.F = str;
                if (TextUtils.isEmpty(str)) {
                    this.F = "";
                }
                this.x.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07fe), this.F));
                if (w88Var.E.is_in_rank.booleanValue()) {
                    Integer num = w88Var.E.today_rank;
                    if (num != null && num.intValue() > 0 && w88Var.E.today_rank.intValue() <= 500) {
                        this.y.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07fd), w88Var.E.today_rank));
                    } else {
                        this.y.setText(this.a.getString(R.string.obfuscated_res_0x7f0f07fc));
                    }
                } else {
                    this.y.setText(this.a.getString(R.string.obfuscated_res_0x7f0f07fc));
                }
                TiebaStatic.log(new StatisticItem("c13898").param("uid", this.B.getUserId()));
                return;
            }
            this.w.setVisibility(8);
        }
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0718, (ViewGroup) null);
            this.b = inflate;
            inflate.setVisibility(8);
            this.s = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091970);
            this.c = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091962);
            AlignTextView alignTextView = (AlignTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091963);
            this.d = alignTextView;
            alignTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09195e);
            this.f = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091964);
            this.t = this.b.findViewById(R.id.obfuscated_res_0x7f091f21);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091960);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09195f);
            this.i = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091961);
            AlignTextView alignTextView2 = (AlignTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091967);
            this.k = alignTextView2;
            alignTextView2.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091966);
            AlignTextView alignTextView3 = (AlignTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091969);
            this.l = alignTextView3;
            alignTextView3.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.m = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091968);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09196b);
            this.n = imageView;
            imageView.setOnClickListener(this.G);
            RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09196a);
            this.o = relativeLayout;
            relativeLayout.setOnClickListener(this.G);
            this.p = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09196c);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09196d);
            this.q = textView;
            textView.setOnClickListener(this.G);
            this.u = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09196e);
            this.v = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09196f);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090cda);
            this.w = roundRelativeLayout;
            roundRelativeLayout.setOnClickListener(this.G);
            this.A = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090cd8);
            this.z = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090cdb);
            this.y = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090cdc);
            this.x = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090ce4);
            ImageView imageView2 = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091965);
            this.r = imageView2;
            imageView2.setOnClickListener(this.G);
            int measureText = (int) this.g.getPaint().measureText(this.a.getString(R.string.obfuscated_res_0x7f0f0e3e));
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = measureText;
                this.d.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.k.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = measureText;
                this.k.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.l.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.width = measureText;
                this.l.setLayoutParams(layoutParams3);
            }
            NoDataView a2 = NoDataViewFactory.a(this.a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070230)), NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c83)), null);
            this.E = a2;
            View view2 = this.b;
            if (view2 instanceof ViewGroup) {
                ((ViewGroup) view2).addView(a2);
            }
            r(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || TbadkCoreApplication.getCurrentAccountInfo() == null) {
            return;
        }
        PersonChangeData personChangeData = new PersonChangeData();
        UserData userData = this.B;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.B.getUserName());
            personChangeData.setSex(this.B.getSex());
            personChangeData.setIntro(this.B.getIntro());
            personChangeData.setNameShow(this.B.getName_show());
            personChangeData.setMem(this.B.getIsMem());
            personChangeData.setForumAge(this.B.getTb_age());
            personChangeData.setCanModifyAvatar(this.B.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.B.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.B.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.B.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.C.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.B.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.B.getBirthdayInfo().c);
                personChangeData.setBirthdayTime(this.B.getBirthdayInfo().a);
                personChangeData.setBirthdayShowStatus(this.B.getBirthdayInfo().d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.icon_pure_personalba_edit24_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0108, 1, i);
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0108, 1, i);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0108, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0108, 1, i);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0105, 1, i);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0206);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0311);
            SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0311);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.z, R.drawable.obfuscated_res_0x7f0805f3, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.A, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
            NoDataView noDataView = this.E;
            if (noDataView != null) {
                noDataView.f(this.a, i);
            }
        }
    }
}
