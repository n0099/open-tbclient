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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class k39 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<QmStickerItem> a;
    public RecordEffectLayout.i b;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ k39 b;

        public a(k39 k39Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k39Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k39Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !((QmStickerItem) this.b.a.get(this.a * 2)).isSelect && this.b.b != null) {
                this.b.b.a((QmStickerItem) this.b.a.get(this.a * 2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ k39 b;

        public b(k39 k39Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k39Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k39Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !((QmStickerItem) this.b.a.get((this.a * 2) + 1)).isSelect && this.b.b != null) {
                this.b.b.a((QmStickerItem) this.b.a.get((this.a * 2) + 1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;
        public RelativeLayout b;
        public TbImageView c;
        public TbImageView d;
        public TbImageView e;
        public TbImageView f;
        public ProgressBar g;
        public ProgressBar h;
        public ImageView i;

        public c(k39 k39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k39Var};
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

    public k39() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public QmStickerItem getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return (QmStickerItem) ListUtils.getItem(this.a, i);
        }
        return (QmStickerItem) invokeI.objValue;
    }

    public void d(List<QmStickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a = list;
        }
    }

    public void e(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.b = iVar;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0176, (ViewGroup) null);
                cVar = new c(this);
                cVar.c = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0922fd);
                cVar.d = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090410);
                cVar.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0922e3);
                cVar.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09171c);
                cVar.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0903f6);
                cVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0922fa);
                cVar.f = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090408);
                cVar.g = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f0922fc);
                cVar.h = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f09040c);
                view2.setTag(cVar);
            } else {
                cVar = (c) view2.getTag();
            }
            cVar.c.setAutoChangeStyle(false);
            cVar.d.setAutoChangeStyle(false);
            cVar.e.setAutoChangeStyle(false);
            cVar.f.setAutoChangeStyle(false);
            cVar.c.setGifIconSupport(false);
            cVar.d.setGifIconSupport(false);
            int i2 = i * 2;
            if (ListUtils.getItem(this.a, i2) instanceof QmStickerItem) {
                cVar.a.setVisibility(0);
                if (this.a.get(i2).id == -1) {
                    cVar.i.setVisibility(0);
                    cVar.c.setVisibility(8);
                    cVar.i.setImageResource(R.drawable.obfuscated_res_0x7f080b5c);
                } else {
                    cVar.i.setVisibility(8);
                    cVar.c.setVisibility(0);
                    cVar.c.K(this.a.get(i2).bgurl, 10, true);
                }
                cVar.a.setOnClickListener(new a(this, i));
                if (this.a.get(i2).isDownLoading) {
                    cVar.g.setVisibility(0);
                    cVar.e.setVisibility(8);
                } else {
                    cVar.g.setVisibility(8);
                    if (this.a.get(i2).isLocalSource) {
                        cVar.e.setVisibility(8);
                    } else {
                        cVar.e.setVisibility(0);
                    }
                }
                if (this.a.get(i2).isSelect) {
                    cVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810f6);
                } else {
                    cVar.a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.a.setVisibility(8);
            }
            int i3 = i2 + 1;
            if (ListUtils.getItem(this.a, i3) instanceof QmStickerItem) {
                cVar.b.setVisibility(0);
                cVar.d.K(this.a.get(i3).bgurl, 10, true);
                cVar.b.setOnClickListener(new b(this, i));
                if (this.a.get(i3).isDownLoading) {
                    cVar.h.setVisibility(0);
                    cVar.f.setVisibility(8);
                } else {
                    cVar.h.setVisibility(8);
                    if (this.a.get(i3).isLocalSource) {
                        cVar.f.setVisibility(8);
                    } else {
                        cVar.f.setVisibility(0);
                    }
                }
                if (this.a.get(i3).isSelect) {
                    cVar.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f0810f6);
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
