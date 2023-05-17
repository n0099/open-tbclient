package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class AlbumImagePagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public LayoutInflater b;
    public List<ImageFileInfo> c;
    public Map<Integer, Boolean> d;

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }

    public AlbumImagePagerAdapter(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new HashMap();
        this.a = baseFragmentActivity;
        this.b = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
    }

    public ImageFileInfo b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return (ImageFileInfo) ListUtils.getItem(this.c, i);
        }
        return (ImageFileInfo) invokeI.objValue;
    }

    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this.d.get(Integer.valueOf(i)) == null) {
                return false;
            }
            return this.d.get(Integer.valueOf(i)).booleanValue();
        }
        return invokeI.booleanValue;
    }

    public void d(List<ImageFileInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.c = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ListUtils.getCount(this.c);
        }
        return invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) {
            View inflate = this.b.inflate(R.layout.obfuscated_res_0x7f0d011c, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0903e0);
            tbImageView.setTag(null);
            tbImageView.setDefaultBgResource(0);
            tbImageView.setDefaultResource(0);
            tbImageView.setGifIconSupport(false);
            tbImageView.setLongIconSupport(false);
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092422);
            tbImageView2.setTag(null);
            tbImageView2.setDefaultBgResource(0);
            tbImageView2.setDefaultResource(0);
            tbImageView2.setGifIconSupport(false);
            tbImageView2.setLongIconSupport(false);
            ImageFileInfo b = b(i);
            if (b != null) {
                tbImageView2.O(b.getFilePath(), 35, false, true);
                tbImageView.N(b.getFilePath(), 36, false);
                this.d.put(Integer.valueOf(i), Boolean.TRUE);
            }
            viewGroup.addView(inflate, 0);
            SkinManager.setBackgroundColor(inflate, R.color.CAM_X0201);
            return inflate;
        }
        return invokeLI.objValue;
    }
}
