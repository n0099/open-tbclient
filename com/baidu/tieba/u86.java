package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaLiveMarkData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.p86;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class u86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TbPageContext<BaseFragmentActivity> b;
    public BdListView c;
    public p86 d;
    public HeadImageView e;
    public TextView f;
    public TextView g;
    public TbImageView h;
    public RelativeLayout i;
    public ImageView j;
    public TextView k;
    public LinearLayout l;
    public AlaNetRefreshView m;
    public RelativeLayout n;
    public TextView o;
    public View p;
    public c q;
    public List<AlaLiveMarkData> r;
    public p86.d s;

    /* loaded from: classes6.dex */
    public interface c {
        void a(r86 r86Var);
    }

    /* loaded from: classes6.dex */
    public class a extends bg<rm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u86 a;

        public a(u86 u86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u86Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        public void onLoaded(rm rmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, rmVar, str, i) == null) {
                super.onLoaded((a) rmVar, str, i);
                if (rmVar != null && rmVar.p() != null) {
                    this.a.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.a.h.setImageBitmap(BitmapHelper.fastblur(rmVar.p(), 15, 0.75f));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements p86.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u86 a;

        public b(u86 u86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u86Var;
        }

        @Override // com.baidu.tieba.p86.d
        public void a(r86 r86Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, r86Var) == null) && this.a.q != null) {
                this.a.q.a(r86Var);
            }
        }
    }

    public u86(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new ArrayList();
        this.s = new b(this);
        this.b = tbPageContext;
        this.q = cVar;
        e();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void d() {
        AlaNetRefreshView alaNetRefreshView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (alaNetRefreshView = this.m) != null) {
            alaNetRefreshView.dettachView(this.n);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00e3, (ViewGroup) null);
            this.a = inflate;
            inflate.setPadding(0, (int) this.b.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275), 0, 0);
            this.e = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090224);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090225);
            this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090222);
            this.h = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090221);
            this.n = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090228);
            this.l = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090223);
            this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090226);
            this.j = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09099d);
            this.k = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09099f);
            this.p = this.a.findViewById(R.id.obfuscated_res_0x7f090229);
            this.c = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f090227);
            p86 p86Var = new p86(this.b, this.s);
            this.d = p86Var;
            this.c.setAdapter((ListAdapter) p86Var);
            RelativeLayout relativeLayout = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0909a7);
            this.i = relativeLayout;
            this.c.setEmptyView(relativeLayout);
            this.e.setIsRound(true);
            this.e.setDefaultBgResource(R.color.transparent);
            this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.h.setDefaultBgResource(R.color.transparent);
            this.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f, (int) R.color.common_color_10310);
            SkinManager.setViewTextColor(this.g, (int) R.color.white_alpha70);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0106);
            this.j.setAlpha(1.0f);
            this.p.setBackgroundColor(this.b.getResources().getColor(R.color.black_alpha30));
        }
    }

    public void g(AlaUserInfoData alaUserInfoData, List<s86> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, alaUserInfoData, list) == null) {
            p86 p86Var = this.d;
            if (p86Var != null && list != null) {
                p86Var.d(list);
            }
            i(alaUserInfoData);
        }
    }

    public void h(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        TbPageContext<BaseFragmentActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), onClickListener}) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        if (this.m == null) {
            this.m = new AlaNetRefreshView(tbPageContext.getPageActivity());
        }
        this.m.setImageResource(i);
        this.m.setNetFailTipText(this.b.getString(i2));
        this.m.onChangeSkinType();
        this.m.setIsShowRefreshButton(z);
        if (z) {
            this.m.setOnRefreshClickListener(onClickListener);
        }
        this.m.attachView(this.n);
    }

    public final void i(AlaUserInfoData alaUserInfoData) {
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, alaUserInfoData) == null) {
            if (alaUserInfoData != null) {
                String str = alaUserInfoData.user_nickname;
                String str2 = alaUserInfoData.user_name;
                if (str == null) {
                    if (str2 != null) {
                        str = str2;
                    } else {
                        str = TbadkCoreApplication.getCurrentAccountNameShow();
                    }
                }
                String str3 = alaUserInfoData.portrait;
                if (str3 == null) {
                    str3 = TbadkCoreApplication.getCurrentPortrait();
                }
                if (alaUserInfoData.mark_count == null) {
                    format = String.format(this.b.getString(R.string.obfuscated_res_0x7f0f01f2), 0);
                } else {
                    format = String.format(this.b.getString(R.string.obfuscated_res_0x7f0f01f2), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
                }
                j(str3, str, format);
                int dimension = (int) this.b.getResources().getDimension(R.dimen.obfuscated_res_0x7f070207);
                List<AlaLiveMarkData> list = this.r;
                if (list != null && list.size() > 0) {
                    this.r.clear();
                }
                LinearLayout linearLayout = this.l;
                if (linearLayout != null) {
                    linearLayout.removeAllViews();
                    List<AlaLiveMarkData> list2 = alaUserInfoData.live_mark_info_new;
                    this.r = list2;
                    if (list2 != null) {
                        for (int i = 0; i < this.r.size(); i++) {
                            TbImageView tbImageView = new TbImageView(this.b.getPageActivity());
                            tbImageView.setDefaultBgResource(R.color.transparent);
                            tbImageView.M(this.r.get(i).mark_pic, 21, false);
                            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.b.getResources().getDimension(R.dimen.obfuscated_res_0x7f07023c);
                            this.l.addView(tbImageView);
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            j(TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountNameShow(), String.format(this.b.getString(R.string.obfuscated_res_0x7f0f01f2), 0));
            List<AlaLiveMarkData> list3 = this.r;
            if (list3 != null && list3.size() > 0) {
                this.r.clear();
            }
            LinearLayout linearLayout2 = this.l;
            if (linearLayout2 != null) {
                linearLayout2.removeAllViews();
            }
        }
    }

    public final void j(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            if (!StringUtils.isNull(str)) {
                this.e.M(str, 25, false);
                cg.h().m(str, 25, new a(this), null);
            } else {
                this.e.M(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
                this.h.M(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            }
            if (!StringUtils.isNull(str2)) {
                this.f.setText(str2);
            } else {
                this.f.setText("");
            }
            if (!StringUtils.isNull(str3)) {
                this.g.setText(str3);
            } else {
                this.g.setText("");
            }
        }
    }
}
