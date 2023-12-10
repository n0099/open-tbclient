package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class uab extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public List<CloudMusicData.MusicTagList.MusicList> b;
    public c c;
    public String d;

    /* loaded from: classes8.dex */
    public interface c {
        void t2(View view2, String str, int i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList a;
        public final /* synthetic */ int b;
        public final /* synthetic */ uab c;

        public a(uab uabVar, CloudMusicData.MusicTagList.MusicList musicList, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uabVar, musicList, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uabVar;
            this.a = musicList;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.c != null) {
                this.c.c.t2(view2, this.a.resource, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TbImageView b;
        public View c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public View h;

        public b() {
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

        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.g, R.drawable.obfuscated_res_0x7f08032d);
                SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
                SkinManager.setImageResource(this.b, R.drawable.btn_icon_play_video_n);
            }
        }
    }

    public uab(BdPageContext bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "";
        this.a = bdPageContext;
        this.b = new ArrayList();
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.b.contains(musicList)) {
                this.b.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.b.get(i);
        }
        return (CloudMusicData.MusicTagList.MusicList) invokeI.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.d = str;
        }
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.c = cVar;
        }
    }

    public void f(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            getItem(i).isLoading = z;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0218, viewGroup, false);
                bVar = new b();
                bVar.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09191c);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091919);
                bVar.a = tbImageView;
                tbImageView.setDrawerType(1);
                bVar.a.setIsRound(true);
                bVar.a.setDefaultResource(R.drawable.obfuscated_res_0x7f08037d);
                bVar.a.setDefaultBgResource(R.color.transparent);
                bVar.a.setBorderWidth(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070224));
                bVar.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                bVar.a.setConrers(15);
                bVar.c = view2.findViewById(R.id.obfuscated_res_0x7f09191a);
                bVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09191d);
                bVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091916);
                bVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091918);
                bVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091917);
                bVar.h = view2.findViewById(R.id.obfuscated_res_0x7f0915ea);
                view2.setTag(bVar);
            } else {
                bVar = (b) view2.getTag();
            }
            bVar.b(TbadkCoreApplication.getInst().getSkinType());
            CloudMusicData.MusicTagList.MusicList musicList = this.b.get(i);
            if (musicList != null) {
                bVar.d.setText(musicList.name);
                bVar.a.startLoad(musicList.image, 10, false);
                bVar.e.setText(musicList.author);
                bVar.f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
                if (musicList.isLoading) {
                    bVar.c.setVisibility(0);
                } else {
                    bVar.c.setVisibility(4);
                }
                if (musicList.equals(vab.b().a())) {
                    bVar.b.setImageResource(R.drawable.obfuscated_res_0x7f080421);
                    bVar.a.setDrawBorder(true);
                    bVar.g.setVisibility(0);
                    bVar.c.setVisibility(4);
                    musicList.isLoading = false;
                    bVar.g.setOnClickListener(new a(this, musicList, i));
                } else if (vab.b().a() == null && getItem(i) != null && !TextUtils.isEmpty(this.d) && this.d.equals(String.valueOf(getItem(i).music_id))) {
                    bVar.b.setImageResource(R.drawable.btn_icon_play_video_n);
                    bVar.a.setDrawBorder(true);
                    bVar.g.setVisibility(8);
                    bVar.c.setVisibility(4);
                    musicList.isLoading = false;
                } else {
                    bVar.b.setImageResource(R.drawable.btn_icon_play_video_n);
                    bVar.a.setDrawBorder(false);
                    bVar.g.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
