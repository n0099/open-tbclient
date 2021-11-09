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
/* loaded from: classes9.dex */
public class AlbumImagePagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f55759a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f55760b;

    /* renamed from: c  reason: collision with root package name */
    public List<ImageFileInfo> f55761c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, Boolean> f55762d;

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
        this.f55762d = new HashMap();
        this.f55759a = baseFragmentActivity;
        this.f55760b = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ListUtils.getCount(this.f55761c) : invokeV.intValue;
    }

    public ImageFileInfo getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? (ImageFileInfo) ListUtils.getItem(this.f55761c, i2) : (ImageFileInfo) invokeI.objValue;
    }

    public boolean getItemClick(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.f55762d.get(Integer.valueOf(i2)) == null) {
                return false;
            }
            return this.f55762d.get(Integer.valueOf(i2)).booleanValue();
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
            View inflate = this.f55760b.inflate(R.layout.album_big_image_item, (ViewGroup) null);
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
            ImageFileInfo item = getItem(i2);
            if (item != null) {
                tbImageView2.startLoad(item.getFilePath(), 35, false, true);
                tbImageView.startLoad(item.getFilePath(), 36, false);
                this.f55762d.put(Integer.valueOf(i2), Boolean.TRUE);
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void setData(List<ImageFileInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f55761c = list;
            notifyDataSetChanged();
        }
    }
}
