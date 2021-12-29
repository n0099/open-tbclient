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
import c.a.d.f.p.n;
import c.a.t0.o4.d;
import c.a.t0.o4.f;
import c.a.t0.o4.g;
import c.a.t0.o4.h;
import c.a.t0.o4.j;
import c.a.t0.o4.u.c;
import c.a.t0.o4.u.e;
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
/* loaded from: classes13.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f51558e;

    /* renamed from: f  reason: collision with root package name */
    public c f51559f;

    /* renamed from: g  reason: collision with root package name */
    public e f51560g;

    /* renamed from: h  reason: collision with root package name */
    public AlbumImagePagerAdapter f51561h;

    /* renamed from: i  reason: collision with root package name */
    public View f51562i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f51563j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f51564k;
    public View l;
    public TBSpecificationBtn m;
    public TextView n;
    public View o;
    public ViewPager p;
    public int q;
    public View.OnClickListener r;
    public ViewPager.OnPageChangeListener s;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlbumImageBrowseFragment f51565e;

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
            this.f51565e = albumImageBrowseFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == this.f51565e.l || view != this.f51565e.f51564k || this.f51565e.f51561h == null || this.f51565e.f51559f == null || this.f51565e.f51558e == null) {
                return;
            }
            if (this.f51565e.f51559f.p()) {
                this.f51565e.f51558e.showToast(j.album_choose_switch_tip);
            } else if (this.f51565e.f51561h.getItemClick(this.f51565e.q)) {
                ImageFileInfo item = this.f51565e.f51561h.getItem(this.f51565e.q);
                if (c.a.t0.o4.b0.a.a(item)) {
                    this.f51565e.f51558e.showToast(j.album_choose_image_low_quality_tip);
                } else if (!c.a.t0.o4.b0.a.b(item)) {
                    if (this.f51565e.f51559f.n(item)) {
                        if (this.f51565e.f51560g.k(item)) {
                            AlbumImageBrowseFragment albumImageBrowseFragment = this.f51565e;
                            albumImageBrowseFragment.s(albumImageBrowseFragment.f51564k, false);
                            this.f51565e.f51560g.J(item, false);
                        }
                    } else if (this.f51565e.f51560g.d(item)) {
                        AlbumImageBrowseFragment albumImageBrowseFragment2 = this.f51565e;
                        albumImageBrowseFragment2.s(albumImageBrowseFragment2.f51564k, true);
                        this.f51565e.f51560g.J(item, true);
                    }
                    this.f51565e.q();
                } else {
                    this.f51565e.f51558e.showToast(String.format(this.f51565e.getString(j.album_choose_image_max_wh_tip), Integer.valueOf(c.a.s0.s.g0.b.j().k("key_upload_pic_max_width", 0)), Integer.valueOf(c.a.s0.s.g0.b.j().k("key_upload_pic_max_height", 0))));
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlbumImageBrowseFragment f51566e;

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
            this.f51566e = albumImageBrowseFragment;
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
                this.f51566e.q = i2;
                if (this.f51566e.f51561h == null || this.f51566e.f51559f == null) {
                    return;
                }
                ImageFileInfo item = this.f51566e.f51561h.getItem(this.f51566e.q);
                boolean z = true;
                if (this.f51566e.f51559f.n(item)) {
                    AlbumImageBrowseFragment albumImageBrowseFragment = this.f51566e;
                    albumImageBrowseFragment.s(albumImageBrowseFragment.f51564k, true);
                } else {
                    AlbumImageBrowseFragment albumImageBrowseFragment2 = this.f51566e;
                    albumImageBrowseFragment2.s(albumImageBrowseFragment2.f51564k, false);
                }
                if (this.f51566e.f51559f != null && this.f51566e.f51559f.m() != null) {
                    z = this.f51566e.f51559f.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.f51566e.n.setVisibility(8);
                } else if (item == null || !item.isGif()) {
                    this.f51566e.n.setVisibility(0);
                } else {
                    this.f51566e.n.setVisibility(8);
                }
                AlbumImageBrowseFragment albumImageBrowseFragment3 = this.f51566e;
                albumImageBrowseFragment3.selectOriginalImg(albumImageBrowseFragment3.f51559f.s());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51563j : (View) invokeV.objValue;
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
            c.a.s0.x0.a.a(getPageContext(), this.f51562i);
            SkinManager.setNavbarIconSrc(this.f51563j, f.icon_return_bg_s, f.icon_return_bg, i2);
            c cVar = this.f51559f;
            if (cVar != null) {
                selectOriginalImg(cVar.s());
            }
            AlbumImagePagerAdapter albumImagePagerAdapter = this.f51561h;
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
            this.f51558e = baseFragmentActivity;
            if (this.f51560g == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f51560g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f51560g = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            e eVar = this.f51560g;
            if (eVar != null) {
                this.f51559f = eVar.r();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.f51558e = baseFragmentActivity;
            if (this.f51560g == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f51560g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f51560g = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            e eVar = this.f51560g;
            if (eVar != null) {
                this.f51559f = eVar.r();
            }
            View inflate = layoutInflater.inflate(h.album_big_image_view, (ViewGroup) null);
            this.f51562i = inflate;
            this.f51563j = (ImageView) inflate.findViewById(g.img_back);
            this.f51564k = (ImageView) this.f51562i.findViewById(g.img_choose);
            this.p = (ViewPager) this.f51562i.findViewById(g.viewPager);
            this.o = this.f51562i.findViewById(g.album_no_data);
            this.n = (TextView) this.f51562i.findViewById(g.original_select_btn);
            this.l = this.f51562i.findViewById(g.layout_bottom);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f51562i.findViewById(g.next_step);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(c.a.t0.o4.e.tbds34);
            this.m.getStyleConfig().l(n.f(this.f51558e, c.a.t0.o4.e.tbds25));
            this.f51563j.setOnClickListener(this.f51558e);
            this.m.setOnClickListener(this.f51558e);
            this.f51564k.setOnClickListener(this.r);
            this.n.setOnClickListener(this.f51558e);
            this.l.setOnClickListener(this.r);
            this.p.setOnPageChangeListener(this.s);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            c cVar = this.f51559f;
            if (cVar != null && cVar.m() != null) {
                this.n.setVisibility(this.f51559f.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
                this.f51562i.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
            }
            return this.f51562i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            super.onHiddenChanged(z);
            if (!z || (albumImagePagerAdapter = this.f51561h) == null) {
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

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f51560g.K();
        }
    }

    public final void r() {
        List<ImageFileInfo> i2;
        int j2;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f51559f == null && (eVar = this.f51560g) != null) {
                this.f51559f = eVar.r();
            }
            c cVar = this.f51559f;
            if (cVar == null || (i2 = cVar.i()) == null || (j2 = this.f51559f.j()) < 0) {
                return;
            }
            this.q = j2;
            AlbumImagePagerAdapter albumImagePagerAdapter = new AlbumImagePagerAdapter(this.f51558e);
            this.f51561h = albumImagePagerAdapter;
            this.p.setAdapter(albumImagePagerAdapter);
            int i3 = this.q;
            if (i3 == 0 && i2 != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(i2, i3);
                boolean z = true;
                if (this.f51559f.n(imageFileInfo)) {
                    s(this.f51564k, true);
                } else {
                    s(this.f51564k, false);
                }
                c cVar2 = this.f51559f;
                if (cVar2 != null && cVar2.m() != null) {
                    z = this.f51559f.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.n.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(0);
                }
            }
            this.f51561h.setData(i2);
            this.p.setCurrentItem(this.q, false);
            selectOriginalImg(this.f51559f.s());
        }
    }

    public void refresh() {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (albumImagePagerAdapter = this.f51561h) == null) {
            return;
        }
        s(this.f51564k, this.f51559f.n(albumImagePagerAdapter.getItem(this.q)));
    }

    public void refreshItem(ImageFileInfo imageFileInfo, boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        ImageFileInfo item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048588, this, imageFileInfo, z) == null) || imageFileInfo == null || imageFileInfo.getFilePath() == null || (albumImagePagerAdapter = this.f51561h) == null || (item = albumImagePagerAdapter.getItem(this.q)) == null || item.getFilePath() == null || !item.getFilePath().equals(imageFileInfo.getFilePath())) {
            return;
        }
        s(this.f51564k, z);
    }

    public final void refreshPage() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || isHidden()) {
            return;
        }
        this.o.setVisibility(8);
        this.p.setVisibility(0);
        r();
    }

    public final void s(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, imageView, z) == null) || imageView == null || this.f51558e == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(f.icon_pure_strok324_select, SkinManager.getColor(d.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(f.icon_pure_strok324, SkinManager.getColor(d.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        if (this.m != null) {
            c cVar = this.f51559f;
            int count = cVar != null ? ListUtils.getCount(cVar.g()) : 0;
            c cVar2 = this.f51559f;
            this.m.setText(this.f51558e.getString(j.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(cVar2 != null ? cVar2.l() : 1)}));
            this.m.setEnabled(count > 0);
        }
    }

    public void selectOriginalImg(boolean z) {
        ImageFileInfo item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || this.f51558e == null || this.n == null) {
            return;
        }
        AlbumImagePagerAdapter albumImagePagerAdapter = this.f51561h;
        long fileSize = (albumImagePagerAdapter == null || (item = albumImagePagerAdapter.getItem(this.q)) == null) ? 0L : FileHelper.getFileSize(item.getFilePath());
        String string = this.f51558e.getResources().getString(j.original_img);
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
            this.f51560g = eVar;
        }
    }
}
