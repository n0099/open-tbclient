package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.m;
import c.a.s0.n4.d;
import c.a.s0.n4.f;
import c.a.s0.n4.g;
import c.a.s0.n4.h;
import c.a.s0.n4.j;
import c.a.s0.n4.u.c;
import c.a.s0.n4.u.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes12.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f51309e;

    /* renamed from: f  reason: collision with root package name */
    public c f51310f;

    /* renamed from: g  reason: collision with root package name */
    public e f51311g;

    /* renamed from: h  reason: collision with root package name */
    public AlbumImagePagerAdapter f51312h;

    /* renamed from: i  reason: collision with root package name */
    public View f51313i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f51314j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f51315k;
    public View l;
    public TBSpecificationBtn m;
    public TextView n;
    public View o;
    public ViewPager p;
    public int q;
    public View.OnClickListener r;
    public ViewPager.OnPageChangeListener s;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlbumImageBrowseFragment f51316e;

        public a(AlbumImageBrowseFragment albumImageBrowseFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {albumImageBrowseFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51316e = albumImageBrowseFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == this.f51316e.l || view != this.f51316e.f51315k || this.f51316e.f51312h == null || this.f51316e.f51310f == null || this.f51316e.f51309e == null) {
                return;
            }
            if (this.f51316e.f51310f.p()) {
                this.f51316e.f51309e.showToast(j.album_choose_switch_tip);
            } else if (this.f51316e.f51312h.getItemClick(this.f51316e.q)) {
                ImageFileInfo item = this.f51316e.f51312h.getItem(this.f51316e.q);
                if (c.a.s0.n4.b0.a.a(item)) {
                    this.f51316e.f51309e.showToast(j.album_choose_image_low_quality_tip);
                } else if (!c.a.s0.n4.b0.a.b(item)) {
                    if (this.f51316e.f51310f.n(item)) {
                        if (this.f51316e.f51311g.j(item)) {
                            AlbumImageBrowseFragment albumImageBrowseFragment = this.f51316e;
                            albumImageBrowseFragment.r(albumImageBrowseFragment.f51315k, false);
                            this.f51316e.f51311g.L(item, false);
                        }
                    } else if (this.f51316e.f51311g.c(item)) {
                        AlbumImageBrowseFragment albumImageBrowseFragment2 = this.f51316e;
                        albumImageBrowseFragment2.r(albumImageBrowseFragment2.f51315k, true);
                        this.f51316e.f51311g.L(item, true);
                    }
                    this.f51316e.p();
                } else {
                    this.f51316e.f51309e.showToast(String.format(this.f51316e.getString(j.album_choose_image_max_wh_tip), Integer.valueOf(c.a.r0.s.g0.b.j().k("key_upload_pic_max_width", 0)), Integer.valueOf(c.a.r0.s.g0.b.j().k("key_upload_pic_max_height", 0))));
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlbumImageBrowseFragment f51317e;

        public b(AlbumImageBrowseFragment albumImageBrowseFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {albumImageBrowseFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51317e = albumImageBrowseFragment;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f51317e.q = i2;
                if (this.f51317e.f51312h == null || this.f51317e.f51310f == null) {
                    return;
                }
                ImageFileInfo item = this.f51317e.f51312h.getItem(this.f51317e.q);
                boolean z = true;
                if (this.f51317e.f51310f.n(item)) {
                    AlbumImageBrowseFragment albumImageBrowseFragment = this.f51317e;
                    albumImageBrowseFragment.r(albumImageBrowseFragment.f51315k, true);
                } else {
                    AlbumImageBrowseFragment albumImageBrowseFragment2 = this.f51317e;
                    albumImageBrowseFragment2.r(albumImageBrowseFragment2.f51315k, false);
                }
                if (this.f51317e.f51310f != null && this.f51317e.f51310f.m() != null) {
                    z = this.f51317e.f51310f.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.f51317e.n.setVisibility(8);
                } else if (item == null || !item.isGif()) {
                    this.f51317e.n.setVisibility(0);
                } else {
                    this.f51317e.n.setVisibility(8);
                }
                AlbumImageBrowseFragment albumImageBrowseFragment3 = this.f51317e;
                albumImageBrowseFragment3.selectOriginalImg(albumImageBrowseFragment3.f51310f.s());
            }
        }
    }

    public AlbumImageBrowseFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = -1;
        this.r = new a(this);
        this.s = new b(this);
    }

    public View getBackBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51314j : (View) invokeV.objValue;
    }

    public View getBtnNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : invokeV.intValue;
    }

    public View getOriginSelectBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.r0.w0.a.a(getPageContext(), this.f51313i);
            SkinManager.setNavbarIconSrc(this.f51314j, f.icon_return_bg_s, f.icon_return_bg, i2);
            c cVar = this.f51310f;
            if (cVar != null) {
                selectOriginalImg(cVar.s());
            }
            AlbumImagePagerAdapter albumImagePagerAdapter = this.f51312h;
            if (albumImagePagerAdapter != null) {
                albumImagePagerAdapter.notifyDataSetChanged();
            }
            this.m.changeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.f51309e = baseFragmentActivity;
            if (this.f51311g == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f51311g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f51311g = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            e eVar = this.f51311g;
            if (eVar != null) {
                this.f51310f = eVar.q();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.f51309e = baseFragmentActivity;
            if (this.f51311g == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f51311g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f51311g = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            e eVar = this.f51311g;
            if (eVar != null) {
                this.f51310f = eVar.q();
            }
            View inflate = layoutInflater.inflate(h.album_big_image_view, (ViewGroup) null);
            this.f51313i = inflate;
            this.f51314j = (ImageView) inflate.findViewById(g.img_back);
            this.f51315k = (ImageView) this.f51313i.findViewById(g.img_choose);
            this.p = (ViewPager) this.f51313i.findViewById(g.viewPager);
            this.o = this.f51313i.findViewById(g.album_no_data);
            this.n = (TextView) this.f51313i.findViewById(g.original_select_btn);
            this.l = this.f51313i.findViewById(g.layout_bottom);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f51313i.findViewById(g.next_step);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(c.a.s0.n4.e.tbds34);
            this.m.getStyleConfig().l(m.f(this.f51309e, c.a.s0.n4.e.tbds25));
            this.f51314j.setOnClickListener(this.f51309e);
            this.m.setOnClickListener(this.f51309e);
            this.f51315k.setOnClickListener(this.r);
            this.n.setOnClickListener(this.f51309e);
            this.l.setOnClickListener(this.r);
            this.p.setOnPageChangeListener(this.s);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            c cVar = this.f51310f;
            if (cVar != null && cVar.m() != null) {
                this.n.setVisibility(this.f51310f.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
                this.f51313i.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
            }
            return this.f51313i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            super.onHiddenChanged(z);
            if (!z || (albumImagePagerAdapter = this.f51312h) == null) {
                return;
            }
            albumImagePagerAdapter.setData(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            if (isShow()) {
                refreshPage();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f51311g.M();
        }
    }

    public final void q() {
        List<ImageFileInfo> i2;
        int j2;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f51310f == null && (eVar = this.f51311g) != null) {
                this.f51310f = eVar.q();
            }
            c cVar = this.f51310f;
            if (cVar == null || (i2 = cVar.i()) == null || (j2 = this.f51310f.j()) < 0) {
                return;
            }
            this.q = j2;
            AlbumImagePagerAdapter albumImagePagerAdapter = new AlbumImagePagerAdapter(this.f51309e);
            this.f51312h = albumImagePagerAdapter;
            this.p.setAdapter(albumImagePagerAdapter);
            int i3 = this.q;
            if (i3 == 0 && i2 != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(i2, i3);
                boolean z = true;
                if (this.f51310f.n(imageFileInfo)) {
                    r(this.f51315k, true);
                } else {
                    r(this.f51315k, false);
                }
                c cVar2 = this.f51310f;
                if (cVar2 != null && cVar2.m() != null) {
                    z = this.f51310f.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.n.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(0);
                }
            }
            this.f51312h.setData(i2);
            this.p.setCurrentItem(this.q, false);
            selectOriginalImg(this.f51310f.s());
        }
    }

    public final void r(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, imageView, z) == null) || imageView == null || this.f51309e == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(f.icon_pure_strok324_select, SkinManager.getColor(d.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(f.icon_pure_strok324, SkinManager.getColor(d.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        if (this.m != null) {
            c cVar = this.f51310f;
            int count = cVar != null ? ListUtils.getCount(cVar.g()) : 0;
            c cVar2 = this.f51310f;
            this.m.setText(this.f51309e.getString(j.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(cVar2 != null ? cVar2.l() : 1)}));
            this.m.setEnabled(count > 0);
        }
    }

    public void refresh() {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (albumImagePagerAdapter = this.f51312h) == null) {
            return;
        }
        r(this.f51315k, this.f51310f.n(albumImagePagerAdapter.getItem(this.q)));
    }

    public void refreshItem(ImageFileInfo imageFileInfo, boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        ImageFileInfo item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, imageFileInfo, z) == null) || imageFileInfo == null || imageFileInfo.getFilePath() == null || (albumImagePagerAdapter = this.f51312h) == null || (item = albumImagePagerAdapter.getItem(this.q)) == null || item.getFilePath() == null || !item.getFilePath().equals(imageFileInfo.getFilePath())) {
            return;
        }
        r(this.f51315k, z);
    }

    public final void refreshPage() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || isHidden()) {
            return;
        }
        this.o.setVisibility(8);
        this.p.setVisibility(0);
        q();
    }

    public void selectOriginalImg(boolean z) {
        ImageFileInfo item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || this.f51309e == null || this.n == null) {
            return;
        }
        AlbumImagePagerAdapter albumImagePagerAdapter = this.f51312h;
        long fileSize = (albumImagePagerAdapter == null || (item = albumImagePagerAdapter.getItem(this.q)) == null) ? 0L : FileHelper.getFileSize(item.getFilePath());
        String string = this.f51309e.getResources().getString(j.original_img);
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            if (fileSize > 0) {
                sb.append("(");
                sb.append(StringHelper.getFormatSize(fileSize));
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            String sb2 = sb.toString();
            SkinManager.setViewTextColor(this.n, d.CAM_X0302);
            this.n.setText(sb2);
            this.n.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(f.icon_pure_image_ok_select16, SkinManager.getColor(d.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        SkinManager.setViewTextColor(this.n, d.CAM_X0106);
        this.n.setText(string);
        this.n.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(f.icon_pure_image_ok_selection16, SkinManager.getColor(d.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setAlbumView(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            this.f51311g = eVar;
        }
    }
}
