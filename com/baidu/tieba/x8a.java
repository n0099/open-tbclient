package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class x8a extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<y8a> a;
    public String b;
    public int c;
    public VideoEffectLayout.h d;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public ProgressBar b;
        public TextView c;
        public int d;

        public a(x8a x8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x8aVar};
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

    public x8a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getItem(0) != null && getItem(0).getType() == 3) {
            this.c = 0;
            this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cc7);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<y8a> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public y8a getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<y8a> list = this.a;
            if (list == null || i < 0 || i >= list.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (y8a) invokeI.objValue;
    }

    public void f(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            this.d = hVar;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            y8a item = getItem(i);
            if (item == null) {
                return 0;
            }
            int type = item.getType();
            if (type != 1) {
                if (type != 3) {
                    return 0;
                }
                return 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public final void b(a aVar, View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, view2, viewGroup) == null) {
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911d2);
            aVar.a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.a.setDrawerType(1);
            aVar.a.setDefaultBgResource(R.color.transparent);
            aVar.a.setBorderWidth(vi.g(viewGroup.getContext(), R.dimen.obfuscated_res_0x7f070224));
            aVar.a.setConrers(15);
            aVar.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.c = (TextView) view2.findViewById(R.id.tv_name);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getItem(0) != null && getItem(0).getType() == 3) {
            this.c = 1;
            this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cc5);
            notifyDataSetChanged();
        }
    }

    public void e(List<y8a> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, str) == null) {
            this.a = list;
            this.b = str;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        y8a y8aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                aVar = new a(this);
                int itemViewType = getItemViewType(i);
                if (itemViewType != 0) {
                    if (itemViewType != 1) {
                        if (itemViewType == 2) {
                            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d059e, (ViewGroup) null);
                            b(aVar, view2, viewGroup);
                            SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0101);
                        }
                    } else {
                        view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d059f, (ViewGroup) null);
                        b(aVar, view2, viewGroup);
                        aVar.b = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f0911e0);
                        aVar.a.setDefaultResource(R.drawable.obfuscated_res_0x7f08036a);
                        SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0101);
                    }
                } else {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d059f, (ViewGroup) null);
                    b(aVar, view2, viewGroup);
                    ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f0911e0);
                    aVar.b = progressBar;
                    progressBar.setVisibility(4);
                    SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0101);
                }
                view2.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
            }
            List<y8a> list = this.a;
            if (list != null && i >= 0 && i <= list.size() - 1 && (y8aVar = this.a.get(i)) != null) {
                int itemViewType2 = getItemViewType(i);
                if (itemViewType2 != 0) {
                    if (itemViewType2 != 1) {
                        if (itemViewType2 == 2) {
                            if (!TextUtils.isEmpty(y8aVar.b()) && y8aVar.b().equals(this.b)) {
                                aVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f0802aa);
                            } else {
                                aVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f0802a9);
                            }
                        }
                    } else {
                        MusicData musicData = (MusicData) y8aVar.c();
                        if (musicData.editMusicType == 0) {
                            aVar.a.N(musicData.img, 10, false);
                        } else {
                            aVar.a.N(String.valueOf(y8aVar.a()), 24, false);
                        }
                        if (this.c != i) {
                            aVar.b.setVisibility(4);
                        } else if (aVar.b.getVisibility() == 0) {
                            aVar.a.setDrawBorder(false);
                        }
                        if (!TextUtils.isEmpty(y8aVar.b()) && y8aVar.b().equals(this.b)) {
                            aVar.a.setDrawBorder(true);
                        } else {
                            aVar.a.setDrawBorder(false);
                        }
                    }
                } else {
                    aVar.a.N(String.valueOf(y8aVar.a()), 24, false);
                    if (!TextUtils.isEmpty(y8aVar.b()) && y8aVar.b().equals(this.b)) {
                        aVar.a.setDrawBorder(true);
                    } else {
                        aVar.a.setDrawBorder(false);
                    }
                }
                aVar.a.setTag(y8aVar);
                aVar.a.setTag(R.id.obfuscated_res_0x7f091ddb, aVar);
                aVar.a.setOnClickListener(this);
                aVar.c.setText(y8aVar.b());
                aVar.d = i;
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        VideoEffectLayout.h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f0911d2 && (view2.getTag() instanceof y8a)) {
            y8a y8aVar = (y8a) view2.getTag();
            if (y8aVar.getType() == 3 && (y8aVar.c() instanceof MusicData)) {
                StatisticItem statisticItem = new StatisticItem("c12423");
                statisticItem.param("obj_id", ((MusicData) y8aVar.c()).id);
                statisticItem.param("obj_locate", this.a.indexOf(y8aVar) + 1);
                statisticItem.param("obj_source", 1);
                TiebaStatic.log(statisticItem);
                if (view2.getResources().getString(R.string.obfuscated_res_0x7f0f0cc5).equals(y8aVar.b()) && (hVar = this.d) != null) {
                    hVar.g1(y8aVar, view2.getTag(R.id.obfuscated_res_0x7f091ddb));
                    this.c = this.a.indexOf(y8aVar);
                    this.b = y8aVar.b();
                }
                if (!TextUtils.isEmpty(y8aVar.b()) && y8aVar.b().equals(this.b)) {
                    return;
                }
                if (!y8aVar.b().equals(view2.getResources().getString(R.string.obfuscated_res_0x7f0f0cc5))) {
                    this.c = this.a.indexOf(y8aVar);
                }
            } else {
                this.c = this.a.indexOf(y8aVar);
            }
            this.b = y8aVar.b();
            notifyDataSetChanged();
            VideoEffectLayout.h hVar2 = this.d;
            if (hVar2 != null) {
                hVar2.g1(y8aVar, view2.getTag(R.id.obfuscated_res_0x7f091ddb));
            }
        }
    }
}
