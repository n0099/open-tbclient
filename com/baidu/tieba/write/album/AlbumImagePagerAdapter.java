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
/* loaded from: classes4.dex */
public class AlbumImagePagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f22546a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f22547b;

    /* renamed from: c  reason: collision with root package name */
    public List<ImageFileInfo> f22548c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, Boolean> f22549d;

    public AlbumImagePagerAdapter(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22549d = new HashMap();
        this.f22546a = baseFragmentActivity;
        this.f22547b = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
    }

    public ImageFileInfo b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (ImageFileInfo) ListUtils.getItem(this.f22548c, i2) : (ImageFileInfo) invokeI.objValue;
    }

    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.f22549d.get(Integer.valueOf(i2)) == null) {
                return false;
            }
            return this.f22549d.get(Integer.valueOf(i2)).booleanValue();
        }
        return invokeI.booleanValue;
    }

    public void d(List<ImageFileInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f22548c = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i2, obj) == null) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.f22548c) : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) {
            View inflate = this.f22547b.inflate(R.layout.album_big_image_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.big_image);
            tbImageView.setTag(null);
            tbImageView.setDefaultBgResource(0);
            tbImageView.setDefaultResource(0);
            tbImageView.setGifIconSupport(false);
            tbImageView.setLongIconSupport(false);
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(R.id.thumbnail_iamge);
            tbImageView2.setTag(null);
            tbImageView2.setDefaultBgResource(0);
            tbImageView2.setDefaultResource(0);
            tbImageView2.setGifIconSupport(false);
            tbImageView2.setLongIconSupport(false);
            ImageFileInfo b2 = b(i2);
            if (b2 != null) {
                tbImageView2.N(b2.getFilePath(), 35, false, true);
                tbImageView.M(b2.getFilePath(), 36, false);
                this.f22549d.put(Integer.valueOf(i2), Boolean.TRUE);
            }
            viewGroup.addView(inflate, 0);
            SkinManager.setBackgroundColor(inflate, R.color.CAM_X0201);
            return inflate;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }
}
