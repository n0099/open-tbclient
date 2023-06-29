package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.pushdialog.PushDialogVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes8.dex */
public class zq9 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PushDialogActivity a;
    public Drawable b;
    public View c;
    public View d;
    public EditorScrollView e;
    public TbImageView f;
    public TextView g;
    public ImageView h;
    public TextView i;
    public TbRichTextView j;
    public PushDialogVideoView k;
    public ClickableHeaderImageView l;
    public TextView m;
    public TextView n;
    public CommonUserLikeButton o;
    public View p;
    public TextView q;
    public w16 r;
    public long s;
    public f26 t;
    public boolean u;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zq9 a;

        public a(zq9 zq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zq9Var;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.u) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 1).param("tid", this.a.a.z1()));
                this.a.u = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zq9 a;

        public b(zq9 zq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zq9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.a.y1() != null) {
                this.a.a.y1().d();
            }
        }
    }

    public zq9(PushDialogActivity pushDialogActivity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pushDialogActivity, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = false;
        this.a = pushDialogActivity;
        pushDialogActivity.setContentView(i);
        this.d = d(R.id.obfuscated_res_0x7f091f38);
        this.c = d(R.id.obfuscated_res_0x7f0908b8);
        EditorScrollView editorScrollView = (EditorScrollView) d(R.id.obfuscated_res_0x7f091d8f);
        this.e = editorScrollView;
        editorScrollView.setOverScrollMode(2);
        this.e.setListener(new a(this));
        if (this.c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            int j = xi.j(this.a);
            layoutParams.height = j / 2;
            layoutParams.topMargin = (int) (j * 0.22f);
            this.c.postInvalidate();
        }
        if (xi.C()) {
            Drawable a2 = lca.a();
            this.b = a2;
            if (a2 != null && this.a.getWindow() != null) {
                this.a.getWindow().setBackgroundDrawable(this.b);
            }
        }
        View d = d(R.id.obfuscated_res_0x7f091d8d);
        this.p = d;
        d.setOnClickListener(this);
        this.q = (TextView) d(R.id.comment_num);
        TbImageView tbImageView = (TbImageView) d(R.id.obfuscated_res_0x7f091d91);
        this.f = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.f.setAutoChangeStyle(false);
        this.g = (TextView) d(R.id.obfuscated_res_0x7f091d92);
        this.i = (TextView) d(R.id.obfuscated_res_0x7f091d90);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) d(R.id.obfuscated_res_0x7f091d94);
        this.l = clickableHeaderImageView;
        clickableHeaderImageView.setBorderSurroundContent(true);
        this.l.setIsRound(true);
        this.l.setEnabled(false);
        this.l.setAutoChangeStyle(false);
        this.l.setBorderWidth(xi.g(this.a, R.dimen.tbds1));
        this.l.setBorderColor(ContextCompat.getColor(this.a, R.color.black_alpha15));
        this.r = new w16();
        TbRichTextView tbRichTextView = (TbRichTextView) d(R.id.obfuscated_res_0x7f091d8e);
        this.j = tbRichTextView;
        tbRichTextView.setTextColor(ContextCompat.getColor(this.a, R.color.CAM_X0107));
        this.r.u(xi.g(this.a, R.dimen.tbds38));
        this.r.x(xi.g(this.a, R.dimen.tbds42));
        this.r.k(xi.g(this.a, R.dimen.tbds23));
        this.r.p(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.r.j(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.j.setLayoutStrategy(this.r);
        PushDialogVideoView pushDialogVideoView = (PushDialogVideoView) d(R.id.obfuscated_res_0x7f091d97);
        this.k = pushDialogVideoView;
        pushDialogVideoView.setPageContext(this.a.getPageContext());
        this.m = (TextView) d(R.id.obfuscated_res_0x7f091d96);
        this.n = (TextView) d(R.id.obfuscated_res_0x7f091d93);
        CommonUserLikeButton commonUserLikeButton = (CommonUserLikeButton) d(R.id.obfuscated_res_0x7f091d95);
        this.o = commonUserLikeButton;
        commonUserLikeButton.setAfterOnClickListener(this);
        ImageView imageView = (ImageView) d(R.id.obfuscated_res_0x7f090899);
        this.h = imageView;
        imageView.setOnClickListener(this);
    }

    public final View d(@IdRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return this.a.findViewById(i);
        }
        return (View) invokeI.objValue;
    }

    public void e() {
        PushDialogVideoView pushDialogVideoView;
        f26 f26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (pushDialogVideoView = this.k) != null) {
            pushDialogVideoView.setNetworkChange();
            if (BdNetTypeUtil.isMobileNet() && this.k.A() && (f26Var = this.t) != null && f26Var.c() > 0 && this.t.b() > 0) {
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                double c = ((this.t.c() * (1.0f - ((this.k.getCurrentPosition() * 1.0f) / (this.t.b() * 1000)))) * 1.0f) / 1048576.0f;
                if (c >= 0.1d) {
                    xi.Q(this.a.getPageContext().getPageActivity(), String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1175), decimalFormat.format(c)));
                }
            }
        }
    }

    public void f() {
        PushDialogVideoView pushDialogVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (pushDialogVideoView = this.k) != null) {
            pushDialogVideoView.C();
        }
    }

    public void g() {
        PushDialogVideoView pushDialogVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (pushDialogVideoView = this.k) != null) {
            pushDialogVideoView.D();
        }
    }

    public void h() {
        PushDialogVideoView pushDialogVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (pushDialogVideoView = this.k) != null) {
            pushDialogVideoView.E();
        }
    }

    public void i(ar9 ar9Var) {
        boolean z;
        boolean z2;
        int g;
        int g2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ar9Var) != null) || ar9Var == null) {
            return;
        }
        this.f.N(ar9Var.a(), 17, false);
        this.g.setText(ar9Var.b());
        if (ar9Var.d() != null) {
            this.l.setData(ar9Var.d());
            this.m.setText(ar9Var.d().getName_show());
            if (ar9Var.d().getGodUserData() != null && (!StringUtils.isNull(ar9Var.d().getGodUserData().getForumName()) || !StringUtils.isNull(ar9Var.d().getGodUserData().getIntro()))) {
                this.n.setText(ar9Var.d().getGodUserData().getForumName() + "吧 " + ar9Var.d().getGodIntro());
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(ar9Var.d().getUserId())) {
                this.o.setVisibility(8);
            } else {
                new sb5(this.a.getPageContext(), this.o).l(ar9Var.d());
                this.o.g(0);
                this.o.setVisibility(0);
            }
            br9 c = ar9Var.c();
            if (c == null) {
                this.a.y1().d();
                this.a.finish();
                return;
            }
            if (c.a() != null && !ListUtils.isEmpty(c.a().W())) {
                z = false;
            } else {
                z = true;
            }
            if (StringUtils.isNull(c.d()) && z) {
                this.a.y1().d();
                this.a.finish();
                return;
            }
            if (c.a() != null) {
                Iterator<TbRichTextData> it = c.a().W().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        this.t = next.l0();
                    }
                    if (this.t != null) {
                        break;
                    }
                }
            }
            this.s = c.c();
            if (this.t == null) {
                this.k.setVisibility(8);
                this.j.setVisibility(0);
                if (!BdNetTypeUtil.is4GNet() && !BdNetTypeUtil.isWifiNet()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.r.y(z2);
                if (z2) {
                    g = (xi.l(TbadkCoreApplication.getInst()) - (xi.g(this.a, R.dimen.tbds22) * 2)) - (xi.g(this.a, R.dimen.tbds44) * 2);
                    g2 = (int) (g * 1.618f);
                } else {
                    g = xi.g(this.a, R.dimen.tbds360);
                    g2 = xi.g(this.a, R.dimen.tbds202);
                }
                this.r.l(z2);
                this.r.r(g);
                this.r.q(g2);
                this.j.setText(c.a());
            } else {
                this.j.setVisibility(8);
                this.k.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
                int l = xi.l(this.a) - xi.g(this.a, R.dimen.tbds132);
                layoutParams.width = l;
                layoutParams.height = (int) (l * 0.5625f);
                this.k.setLayoutParams(layoutParams);
                this.k.setTbRichTextVideoInfo(this.t);
                this.k.stopPlay();
                this.k.setThumbnail(this.t.d());
                this.k.setVideoUrl(this.t.e(), String.valueOf(this.s));
                this.k.G();
                to9 to9Var = new to9();
                to9Var.a = "15";
                to9Var.c = String.valueOf(this.s);
                to9Var.e = TbadkCoreApplication.getCurrentAccount();
                this.k.setVideoViewBusiness(to9Var);
            }
            if (StringUtils.isNull(c.d())) {
                this.i.setVisibility(8);
            } else {
                this.i.setText(c.d());
                this.i.setVisibility(0);
            }
            this.q.setText(String.format(Locale.CHINA, this.a.getString(R.string.obfuscated_res_0x7f0f0383), Integer.valueOf(c.b())));
            if (!this.a.y1().c()) {
                this.a.y1().e();
                return;
            }
            return;
        }
        this.a.y1().d();
        this.a.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (view2 == this.h) {
                TiebaStatic.log(new StatisticItem("c13198").param("tid", this.a.z1()));
                yg.a().postDelayed(new b(this), 100L);
                this.a.finish();
            } else if (view2 == this.p) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 4).param("tid", this.a.z1()));
                if (this.s == 0) {
                    this.a.finish();
                    return;
                }
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(this.s + "", null, null)));
                this.a.y1().e();
                this.a.finish();
            } else if (view2 == this.o) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 3).param("tid", this.a.z1()));
            }
        }
    }
}
