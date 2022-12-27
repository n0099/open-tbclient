package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class sk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public PermissionJudgePolicy h;
    public r48 i;
    public Bitmap j;
    public e k;
    public View l;
    public String m;
    public String n;
    public d o;
    public int p;
    public View.OnClickListener q;

    /* loaded from: classes6.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(int i);
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk6 a;

        public a(sk6 sk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sk6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Bitmap m = this.a.m();
                if (view2.getId() != this.a.b.getId()) {
                    if (view2.getId() != this.a.c.getId()) {
                        if (view2.getId() != this.a.d.getId()) {
                            if (view2.getId() != this.a.e.getId()) {
                                if (view2.getId() != this.a.f.getId()) {
                                    if (view2.getId() != this.a.g.getId()) {
                                        return;
                                    }
                                    this.a.u(m, 6);
                                    return;
                                }
                                this.a.u(m, 8);
                                return;
                            }
                            this.a.u(m, 4);
                            return;
                        }
                        this.a.u(m, 2);
                        return;
                    }
                    this.a.u(m, 3);
                    return;
                }
                this.a.p(m);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ik5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ int b;
        public final /* synthetic */ sk6 c;

        public b(sk6 sk6Var, Bitmap bitmap, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk6Var, bitmap, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sk6Var;
            this.a = bitmap;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (ShareItem) invokeV.objValue;
            }
            return this.c.l(this.a, this.b);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements mj5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ sk6 b;

        public c(sk6 sk6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sk6Var;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.a.getPageActivity(), this.a, shareItem, false));
            }
        }
    }

    public sk6(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new a(this);
        this.a = tbPageContext;
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.p = i;
        }
    }

    public void s(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.m = str;
            this.n = str2;
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h == null) {
                this.h = new PermissionJudgePolicy();
            }
            this.h.clearRequestPermissionList();
            this.h.appendRequestPermission(this.a.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            return this.h.startRequestPermission(this.a.getPageActivity());
        }
        return invokeV.booleanValue;
    }

    public Bitmap m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j == null) {
                d dVar = this.o;
                if (dVar != null) {
                    dVar.a();
                }
                this.l.buildDrawingCache();
                this.j = this.l.getDrawingCache();
                d dVar2 = this.o;
                if (dVar2 != null) {
                    dVar2.b();
                }
            }
            return this.j;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final ShareItem l(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, i)) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.o0 = false;
            shareItem.n0 = false;
            shareItem.h0 = 1;
            if (i == 6) {
                shareItem.v = this.a.getString(R.string.come_on_look_forum) + PreferencesUtil.LEFT_MOUNT + this.n + this.a.getString(R.string.core_bar) + PreferencesUtil.RIGHT_MOUNT + "@" + this.a.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + xi.getUrlEncode(this.n) + "&fr=frsshare";
            } else {
                shareItem.v = this.a.getString(R.string.obfuscated_res_0x7f0f029e);
            }
            shareItem.w = "";
            shareItem.j(bitmap);
            shareItem.h();
            return shareItem;
        }
        return (ShareItem) invokeLI.objValue;
    }

    public final void u(Bitmap bitmap, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048586, this, bitmap, i) == null) && bitmap != null && !k()) {
            int i2 = 1;
            if (i == 3) {
                i2 = 2;
            } else if (i == 2) {
                i2 = 3;
            } else if (i == 4) {
                i2 = 4;
            } else if (i == 8) {
                i2 = 5;
            } else if (i == 6) {
                i2 = 6;
            }
            e eVar = this.k;
            if (eVar != null) {
                eVar.a(i2);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
            if (i == 3) {
                statisticItem.param("obj_type", 2);
            } else if (i == 2) {
                statisticItem.param("obj_type", 3);
            } else if (i == 8) {
                statisticItem.param("obj_type", 4);
            } else if (i == 4) {
                statisticItem.param("obj_type", 5);
            } else if (i == 6) {
                statisticItem.param("obj_type", 6);
            }
            statisticItem.param("obj_source", this.p);
            TiebaStatic.log(statisticItem);
            mk5.b(new b(this, bitmap, i), new c(this, i));
        }
    }

    public final int n() {
        InterceptResult invokeV;
        int l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int g = yi.g(this.a.getPageActivity(), R.dimen.tbds44);
            int g2 = yi.g(this.a.getPageActivity(), R.dimen.tbds54);
            if (UtilHelper.getRealScreenOrientation(this.a.getPageActivity()) == 2) {
                l = yi.j(this.a.getPageActivity());
            } else {
                l = yi.l(this.a.getPageActivity());
            }
            return ((l - (g * 2)) - g2) / 6;
        }
        return invokeV.intValue;
    }

    public void o(View view2, View view3, d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048580, this, view2, view3, dVar) != null) || view2 == null) {
            return;
        }
        TextView textView = (TextView) view2.findViewById(R.id.frs_private_share_download);
        this.b = textView;
        t(textView, new SvgMaskType(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.b.setOnClickListener(this.q);
        TextView textView2 = (TextView) view2.findViewById(R.id.frs_private_share_wechat);
        this.c = textView2;
        t(textView2, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
        this.c.setOnClickListener(this.q);
        TextView textView3 = (TextView) view2.findViewById(R.id.frs_private_share_moment);
        this.d = textView3;
        t(textView3, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
        this.d.setOnClickListener(this.q);
        TextView textView4 = (TextView) view2.findViewById(R.id.frs_private_share_qzone);
        this.e = textView4;
        t(textView4, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
        this.e.setOnClickListener(this.q);
        TextView textView5 = (TextView) view2.findViewById(R.id.frs_private_share_qq);
        this.f = textView5;
        t(textView5, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
        this.f.setOnClickListener(this.q);
        TextView textView6 = (TextView) view2.findViewById(R.id.frs_private_share_weibo);
        this.g = textView6;
        t(textView6, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
        this.g.setOnClickListener(this.q);
        this.l = view3;
        this.o = dVar;
    }

    public final void p(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, bitmap) != null) || k()) {
            return;
        }
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(1);
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_source", this.p);
        TiebaStatic.log(statisticItem);
        if (this.i == null) {
            this.i = new r48(this.a);
        }
        this.i.b(this.m, BitmapHelper.Bitmap2Bytes(bitmap, 100));
    }

    public final void t(TextView textView, AbsSvgType absSvgType) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, textView, absSvgType) != null) || absSvgType == null || (drawable = absSvgType.getDrawable()) == null) {
            return;
        }
        int g = yi.g(this.a.getPageActivity(), R.dimen.tbds88);
        drawable.setBounds(0, 0, g, g);
        textView.setCompoundDrawables(null, drawable, null, null);
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = n();
        textView.setLayoutParams(layoutParams);
    }
}
