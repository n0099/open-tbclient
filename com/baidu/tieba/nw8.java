package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.video.record.StickerItem;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class nw8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<StickerItem> a;
    public VideoEffectLayout.h b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ nw8 b;

        public a(nw8 nw8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nw8Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || ((StickerItem) this.b.a.get(this.a * 2)).isSelect || this.b.b == null) {
                return;
            }
            this.b.b.w1((StickerItem) this.b.a.get(this.a * 2));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ nw8 b;

        public b(nw8 nw8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nw8Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || ((StickerItem) this.b.a.get((this.a * 2) + 1)).isSelect || this.b.b == null) {
                return;
            }
            this.b.b.w1((StickerItem) this.b.a.get((this.a * 2) + 1));
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;
        public RelativeLayout b;
        public TbImageView c;
        public TbImageView d;
        public ProgressBar e;
        public ProgressBar f;
        public ImageView g;

        public c(nw8 nw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public nw8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public StickerItem getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (StickerItem) ListUtils.getItem(this.a, i) : (StickerItem) invokeI.objValue;
    }

    public void d(List<StickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a = list;
        }
    }

    public void e(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) {
            this.b = hVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.isEmpty(this.a)) {
                return 0;
            }
            return (int) Math.ceil(this.a.size() / 2.0d);
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d052d, (ViewGroup) null);
                cVar = new c(this);
                cVar.c = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0922af);
                cVar.d = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0903fa);
                cVar.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f092296);
                cVar.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916e3);
                cVar.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0903e1);
                cVar.e = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f0922ae);
                cVar.f = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f0903f6);
                view2.setTag(cVar);
            } else {
                cVar = (c) view2.getTag();
            }
            cVar.c.setAutoChangeStyle(false);
            cVar.d.setAutoChangeStyle(false);
            cVar.c.setGifIconSupport(false);
            cVar.d.setGifIconSupport(false);
            int i2 = i * 2;
            if (ListUtils.getItem(this.a, i2) instanceof StickerItem) {
                cVar.a.setVisibility(0);
                if (this.a.get(i2).id == -1) {
                    cVar.g.setVisibility(0);
                    cVar.c.setVisibility(8);
                    cVar.g.setImageResource(R.drawable.obfuscated_res_0x7f080b2b);
                } else {
                    cVar.g.setVisibility(8);
                    cVar.c.setVisibility(0);
                    cVar.c.K(this.a.get(i2).img, 10, true);
                }
                cVar.a.setOnClickListener(new a(this, i));
                if (this.a.get(i2).isDownLoading) {
                    cVar.e.setVisibility(0);
                } else {
                    cVar.e.setVisibility(8);
                }
                if (this.a.get(i2).isSelect) {
                    SkinManager.setBackgroundResource(cVar.a, R.drawable.obfuscated_res_0x7f0802e2);
                } else {
                    cVar.a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.a.setVisibility(8);
            }
            int i3 = i2 + 1;
            if (ListUtils.getItem(this.a, i3) instanceof StickerItem) {
                cVar.b.setVisibility(0);
                cVar.d.K(this.a.get(i3).img, 10, true);
                cVar.b.setOnClickListener(new b(this, i));
                if (this.a.get(i3).isDownLoading) {
                    cVar.f.setVisibility(0);
                } else {
                    cVar.f.setVisibility(8);
                }
                if (this.a.get(i3).isSelect) {
                    SkinManager.setBackgroundResource(cVar.b, R.drawable.obfuscated_res_0x7f0802e2);
                } else {
                    cVar.b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.b.setVisibility(8);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
