package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.c1.q;
import c.a.p0.c3.w.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes5.dex */
public class OperableVideoShareView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public View f35579b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f35580c;

    /* renamed from: d  reason: collision with root package name */
    public View f35581d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f35582e;

    /* renamed from: f  reason: collision with root package name */
    public View f35583f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f35584g;

    /* renamed from: h  reason: collision with root package name */
    public View f35585h;
    public View i;
    public ImageView j;
    public ThreadData k;
    public int l;
    public View.OnClickListener m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OperableVideoShareView a;

        public a(OperableVideoShareView operableVideoShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {operableVideoShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = operableVideoShareView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || q.a()) {
                return;
            }
            if (view == this.a.f35579b) {
                this.a.i(3);
            } else if (view == this.a.f35581d) {
                this.a.i(2);
            } else if (view == this.a.f35583f) {
                this.a.i(8);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 3;
        this.m = new a(this);
        h();
    }

    public void e(boolean z, boolean z2) {
        int f2;
        int f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f35581d.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f35579b.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f35583f.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f35585h.getLayoutParams();
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            if (z2 && !z) {
                f2 = n.f(getContext(), R.dimen.tbds72);
                f3 = n.f(getContext(), R.dimen.tbds52);
            } else {
                f2 = n.f(getContext(), R.dimen.tbds36);
                f3 = n.f(getContext(), R.dimen.tbds26);
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

    public final String f(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null || threadData.getMedias() == null) {
                return null;
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            int size = medias.size();
            for (int i = 0; i < size; i++) {
                MediaData mediaData = medias.get(i);
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

    public final int g(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                if (threadData.isRealGod()) {
                    return 4;
                }
                if (threadData.getIsLive() == 1) {
                    return 3;
                }
                return threadData.isRealVideoThread() ? 2 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0651 : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayout.inflate(getContext(), getLayoutR(), this);
            this.f35579b = findViewById(R.id.obfuscated_res_0x7f091ce5);
            this.f35580c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ce6);
            this.f35581d = findViewById(R.id.obfuscated_res_0x7f091ce7);
            this.f35582e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ce8);
            this.f35583f = findViewById(R.id.obfuscated_res_0x7f091cce);
            this.f35584g = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ccf);
            this.f35585h = findViewById(R.id.obfuscated_res_0x7f0907f4);
            this.i = findViewById(R.id.obfuscated_res_0x7f092371);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f091a48);
            this.f35579b.setOnClickListener(this.m);
            this.f35581d.setOnClickListener(this.m);
            this.f35583f.setOnClickListener(this.m);
            setOnClickListener(this.m);
            this.f35580c.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f080823, 1, false));
            this.f35582e.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f08081f, 1, false));
            this.f35584g.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.obfuscated_res_0x7f080820, 1, false));
            this.j.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f08062f, R.color.CAM_X0105, null, false));
            this.j.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(getContext(), R.dimen.tbds52), getResources().getColor(R.color.CAM_X0622)));
        }
    }

    public final void i(int i) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (threadData = this.k) == null) {
            return;
        }
        String valueOf = String.valueOf(threadData.getFid());
        String forum_name = this.k.getForum_name();
        OriginalForumInfo originalForumInfo = this.k.mOriginalForumInfo;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            forum_name = originalForumInfo.ori_fname;
        }
        String title = this.k.getTitle();
        String tid = this.k.getTid();
        String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
        String f2 = f(this.k);
        Uri parse = f2 == null ? null : Uri.parse(f2);
        String str2 = this.k.getAbstract();
        String format = MessageFormat.format(getResources().getString(R.string.obfuscated_res_0x7f0f110f), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.r = title;
        shareItem.s = format;
        if (!this.k.isUgcThreadType() && this.k.isRealVideoThread() && this.k.getThreadVideoInfo() != null) {
            shareItem.R = this.k.getThreadVideoInfo().play_count.intValue();
        }
        shareItem.D = str2;
        shareItem.t = str;
        shareItem.o = this.l;
        shareItem.q = tid;
        shareItem.F = 3;
        shareItem.G = this.k.isWorksInfo() ? 11 : 2;
        if (i == 3) {
            shareItem.H = 1;
        } else if (i == 2) {
            shareItem.H = 2;
        } else if (i == 8) {
            shareItem.H = 3;
        } else {
            shareItem.H = 0;
        }
        shareItem.J = valueOf;
        shareItem.p = forum_name;
        shareItem.K = tid;
        shareItem.L = this.k.getNid();
        shareItem.f30358h = true;
        shareItem.E = 3;
        shareItem.M = g(this.k);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.k);
        shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(this.k);
        shareItem.I = 1;
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        shareItem.k0 = this.k.getShareImageUrl();
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
        statisticItem.param("obj_locate", this.l);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, shareItem.H);
        statisticItem.param("nid", shareItem.L);
        if (!m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
    }

    public void setShareData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            this.k = threadData;
            if (threadData != null && !threadData.isUgcThreadType()) {
                this.f35583f.setVisibility(0);
                this.f35579b.setVisibility(0);
                this.f35581d.setVisibility(0);
                this.f35585h.setVisibility(0);
                return;
            }
            this.f35583f.setVisibility(8);
            this.f35579b.setVisibility(8);
            this.f35581d.setVisibility(8);
            this.f35585h.setVisibility(8);
        }
    }

    public void setShareFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.l = i;
        }
    }

    public void setVideoContainer(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.a = dVar;
            this.i.setOnClickListener(dVar);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 3;
        this.m = new a(this);
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = 3;
        this.m = new a(this);
        h();
    }
}
