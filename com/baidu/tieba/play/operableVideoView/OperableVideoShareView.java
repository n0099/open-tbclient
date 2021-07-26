package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
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
import d.a.d.e.p.k;
import d.a.p0.b1.l;
import d.a.p0.s.q.b2;
import d.a.q0.n2.q.d;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class OperableVideoShareView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f20439e;

    /* renamed from: f  reason: collision with root package name */
    public View f20440f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20441g;

    /* renamed from: h  reason: collision with root package name */
    public View f20442h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f20443i;
    public View j;
    public ImageView k;
    public View l;
    public View m;
    public ImageView n;
    public b2 o;
    public int p;
    public View.OnClickListener q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OperableVideoShareView f20444e;

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
            this.f20444e = operableVideoShareView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || l.a()) {
                return;
            }
            if (view == this.f20444e.f20440f) {
                this.f20444e.i(3);
            } else if (view == this.f20444e.f20442h) {
                this.f20444e.i(2);
            } else if (view == this.f20444e.j) {
                this.f20444e.i(8);
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
        h();
    }

    public void e(boolean z, boolean z2) {
        int g2;
        int g3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f20442h.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f20440f.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.l.getLayoutParams();
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            if (z2 && !z) {
                g2 = d.a.d.e.p.l.g(getContext(), R.dimen.tbds72);
                g3 = d.a.d.e.p.l.g(getContext(), R.dimen.tbds52);
            } else {
                g2 = d.a.d.e.p.l.g(getContext(), R.dimen.tbds36);
                g3 = d.a.d.e.p.l.g(getContext(), R.dimen.tbds26);
            }
            layoutParams4.rightMargin = g3;
            layoutParams4.leftMargin = g3;
            layoutParams5.rightMargin = g2;
            layoutParams5.leftMargin = g2;
            layoutParams3.rightMargin = g2;
            layoutParams3.leftMargin = g2;
            layoutParams2.rightMargin = g2;
            layoutParams2.leftMargin = g2;
            layoutParams.rightMargin = g2;
            layoutParams.leftMargin = g2;
        }
    }

    public final String f(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var)) == null) {
            if (b2Var == null || b2Var.A0() == null) {
                return null;
            }
            ArrayList<MediaData> A0 = b2Var.A0();
            int size = A0.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediaData mediaData = A0.get(i2);
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

    public final int g(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var)) == null) {
            if (b2Var != null) {
                if (b2Var.f2()) {
                    return 4;
                }
                if (b2Var.h0() == 1) {
                    return 3;
                }
                return b2Var.g2() ? 2 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.operable_video_share_view : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayout.inflate(getContext(), getLayoutR(), this);
            this.f20440f = findViewById(R.id.share_weixin);
            this.f20441g = (ImageView) findViewById(R.id.share_weixin_img);
            this.f20442h = findViewById(R.id.share_weixin_timeline);
            this.f20443i = (ImageView) findViewById(R.id.share_weixin_timeline_img);
            this.j = findViewById(R.id.share_qq);
            this.k = (ImageView) findViewById(R.id.share_qq_img);
            this.l = findViewById(R.id.divider_line);
            this.m = findViewById(R.id.video_replay);
            this.n = (ImageView) findViewById(R.id.replay_img);
            this.f20440f.setOnClickListener(this.q);
            this.f20442h.setOnClickListener(this.q);
            this.j.setOnClickListener(this.q);
            setOnClickListener(this.q);
            this.f20441g.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_wechat40_svg, 1, false));
            this.f20443i.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_circle40_svg, 1, false));
            this.k.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_qq40_svg, 1, false));
            this.n.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_replay44_svg, R.color.CAM_X0105, null, false));
            this.n.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.d.e.p.l.g(getContext(), R.dimen.tbds52), getResources().getColor(R.color.CAM_X0622)));
        }
    }

    public final void i(int i2) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (b2Var = this.o) == null) {
            return;
        }
        String valueOf = String.valueOf(b2Var.R());
        String X = this.o.X();
        OriginalForumInfo originalForumInfo = this.o.F1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            X = originalForumInfo.ori_fname;
        }
        String title = this.o.getTitle();
        String o1 = this.o.o1();
        String str = "http://tieba.baidu.com/p/" + o1 + "?share=9105&fr=share";
        String f2 = f(this.o);
        Uri parse = f2 == null ? null : Uri.parse(f2);
        String h2 = this.o.h();
        String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, h2);
        ShareItem shareItem = new ShareItem();
        shareItem.r = title;
        shareItem.s = format;
        if (!this.o.r2() && this.o.g2() && this.o.m1() != null) {
            shareItem.R = this.o.m1().play_count.intValue();
        }
        shareItem.D = h2;
        shareItem.t = str;
        shareItem.o = this.p;
        shareItem.q = o1;
        shareItem.F = 3;
        shareItem.G = this.o.w2() ? 11 : 2;
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
        shareItem.p = X;
        shareItem.K = o1;
        shareItem.L = this.o.B0();
        shareItem.f12894h = true;
        shareItem.E = 3;
        shareItem.M = g(this.o);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.o);
        shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(this.o);
        shareItem.I = 1;
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        shareItem.f0 = this.o.V0();
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

    public void setShareData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, b2Var) == null) {
            this.o = b2Var;
            if (b2Var != null && !b2Var.r2()) {
                this.j.setVisibility(0);
                this.f20440f.setVisibility(0);
                this.f20442h.setVisibility(0);
                this.l.setVisibility(0);
                return;
            }
            this.j.setVisibility(8);
            this.f20440f.setVisibility(8);
            this.f20442h.setVisibility(8);
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
            this.f20439e = dVar;
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
        h();
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
        h();
    }
}
