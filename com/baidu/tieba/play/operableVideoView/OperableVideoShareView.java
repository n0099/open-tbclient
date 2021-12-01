package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.q0.d1.o;
import c.a.q0.s.q.d2;
import c.a.r0.x2.r.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class OperableVideoShareView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_HOME_RECOMMEND = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f48457e;

    /* renamed from: f  reason: collision with root package name */
    public View f48458f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f48459g;

    /* renamed from: h  reason: collision with root package name */
    public View f48460h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f48461i;

    /* renamed from: j  reason: collision with root package name */
    public View f48462j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f48463k;
    public View l;
    public View m;
    public ImageView n;
    public d2 o;
    public int p;
    public View.OnClickListener q;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OperableVideoShareView f48464e;

        public a(OperableVideoShareView operableVideoShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {operableVideoShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48464e = operableVideoShareView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || o.a()) {
                return;
            }
            if (view == this.f48464e.f48458f) {
                this.f48464e.h(3);
            } else if (view == this.f48464e.f48460h) {
                this.f48464e.h(2);
            } else if (view == this.f48464e.f48462j) {
                this.f48464e.h(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperableVideoShareView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = 3;
        this.q = new a(this);
        g();
    }

    public void changeViewLayout(boolean z, boolean z2) {
        int f2;
        int f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f48460h.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f48458f.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f48462j.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.l.getLayoutParams();
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            if (z2 && !z) {
                f2 = l.f(getContext(), R.dimen.tbds72);
                f3 = l.f(getContext(), R.dimen.tbds52);
            } else {
                f2 = l.f(getContext(), R.dimen.tbds36);
                f3 = l.f(getContext(), R.dimen.tbds26);
            }
            layoutParams4.rightMargin = f3;
            layoutParams4.leftMargin = f3;
            layoutParams5.rightMargin = f2;
            layoutParams5.leftMargin = f2;
            layoutParams3.rightMargin = f2;
            layoutParams3.leftMargin = f2;
            layoutParams2.rightMargin = f2;
            layoutParams2.leftMargin = f2;
            layoutParams.rightMargin = f2;
            layoutParams.leftMargin = f2;
        }
    }

    public final String e(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var)) == null) {
            if (d2Var == null || d2Var.F0() == null) {
                return null;
            }
            ArrayList<MediaData> F0 = d2Var.F0();
            int size = F0.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediaData mediaData = F0.get(i2);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        return mediaData.getThumbnails_url();
                    }
                    if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        return mediaData.getPicUrl();
                    }
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final int f(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var)) == null) {
            if (d2Var != null) {
                if (d2Var.t2()) {
                    return 4;
                }
                if (d2Var.k0() == 1) {
                    return 3;
                }
                return d2Var.u2() ? 2 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinearLayout.inflate(getContext(), getLayoutR(), this);
            this.f48458f = findViewById(R.id.share_weixin);
            this.f48459g = (ImageView) findViewById(R.id.share_weixin_img);
            this.f48460h = findViewById(R.id.share_weixin_timeline);
            this.f48461i = (ImageView) findViewById(R.id.share_weixin_timeline_img);
            this.f48462j = findViewById(R.id.share_qq);
            this.f48463k = (ImageView) findViewById(R.id.share_qq_img);
            this.l = findViewById(R.id.divider_line);
            this.m = findViewById(R.id.video_replay);
            this.n = (ImageView) findViewById(R.id.replay_img);
            this.f48458f.setOnClickListener(this.q);
            this.f48460h.setOnClickListener(this.q);
            this.f48462j.setOnClickListener(this.q);
            setOnClickListener(this.q);
            this.f48459g.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_wechat40_svg, 1, false));
            this.f48461i.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_circle40_svg, 1, false));
            this.f48463k.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_qq40_svg, 1, false));
            this.n.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_replay44_svg, R.color.CAM_X0105, null, false));
            this.n.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.f(getContext(), R.dimen.tbds52), getResources().getColor(R.color.CAM_X0622)));
        }
    }

    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.operable_video_share_view : invokeV.intValue;
    }

    public final void h(int i2) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (d2Var = this.o) == null) {
            return;
        }
        String valueOf = String.valueOf(d2Var.U());
        String a0 = this.o.a0();
        OriginalForumInfo originalForumInfo = this.o.K1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            a0 = originalForumInfo.ori_fname;
        }
        String title = this.o.getTitle();
        String v1 = this.o.v1();
        String str = "http://tieba.baidu.com/p/" + v1 + "?share=9105&fr=share";
        String e2 = e(this.o);
        Uri parse = e2 == null ? null : Uri.parse(e2);
        String o = this.o.o();
        String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, o);
        ShareItem shareItem = new ShareItem();
        shareItem.r = title;
        shareItem.s = format;
        if (!this.o.G2() && this.o.u2() && this.o.t1() != null) {
            shareItem.R = this.o.t1().play_count.intValue();
        }
        shareItem.D = o;
        shareItem.t = str;
        shareItem.o = this.p;
        shareItem.q = v1;
        shareItem.F = 3;
        shareItem.G = this.o.M2() ? 11 : 2;
        if (i2 == 3) {
            shareItem.H = 1;
        } else if (i2 == 2) {
            shareItem.H = 2;
        } else if (i2 == 8) {
            shareItem.H = 3;
        } else {
            shareItem.H = 0;
        }
        shareItem.J = valueOf;
        shareItem.p = a0;
        shareItem.K = v1;
        shareItem.L = this.o.G0();
        shareItem.f41582h = true;
        shareItem.E = 3;
        shareItem.M = f(this.o);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.o);
        shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(this.o);
        shareItem.I = 1;
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        shareItem.i0 = this.o.b1();
        Bundle bundle = new Bundle();
        bundle.putString("tid", shareItem.K);
        bundle.putString("fid", shareItem.J);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt(TiebaStatic.Params.OBJ_PARAM2, shareItem.G);
        bundle.putInt(TiebaStatic.Params.OBJ_PARAM3, shareItem.H);
        bundle.putInt("obj_source", shareItem.o);
        bundle.putInt("obj_locate", shareItem.I);
        shareItem.k(bundle);
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem.param("tid", shareItem.K);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", shareItem.J);
        statisticItem.param("obj_locate", this.p);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, shareItem.H);
        statisticItem.param("nid", shareItem.L);
        if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i2, shareItem, true));
    }

    public void setShareData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, d2Var) == null) {
            this.o = d2Var;
            if (d2Var != null && !d2Var.G2()) {
                this.f48462j.setVisibility(0);
                this.f48458f.setVisibility(0);
                this.f48460h.setVisibility(0);
                this.l.setVisibility(0);
                return;
            }
            this.f48462j.setVisibility(8);
            this.f48458f.setVisibility(8);
            this.f48460h.setVisibility(8);
            this.l.setVisibility(8);
        }
    }

    public void setShareFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setVideoContainer(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f48457e = dVar;
            this.m.setOnClickListener(dVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = 3;
        this.q = new a(this);
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = 3;
        this.q = new a(this);
        g();
    }
}
