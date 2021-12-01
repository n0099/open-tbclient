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
import c.a.d.f.p.l;
import c.a.r0.l4.k.c;
import c.a.r0.l4.k.e;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes11.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f50758e;

    /* renamed from: f  reason: collision with root package name */
    public c f50759f;

    /* renamed from: g  reason: collision with root package name */
    public e f50760g;

    /* renamed from: h  reason: collision with root package name */
    public AlbumImagePagerAdapter f50761h;

    /* renamed from: i  reason: collision with root package name */
    public View f50762i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f50763j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f50764k;
    public View l;
    public TBSpecificationBtn m;
    public TextView n;
    public View o;
    public ViewPager p;
    public int q;
    public View.OnClickListener r;
    public ViewPager.OnPageChangeListener s;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlbumImageBrowseFragment f50765e;

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
            this.f50765e = albumImageBrowseFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == this.f50765e.l || view != this.f50765e.f50764k || this.f50765e.f50761h == null || this.f50765e.f50759f == null || this.f50765e.f50758e == null) {
                return;
            }
            if (this.f50765e.f50759f.p()) {
                this.f50765e.f50758e.showToast(R.string.album_choose_switch_tip);
            } else if (this.f50765e.f50761h.getItemClick(this.f50765e.q)) {
                ImageFileInfo item = this.f50765e.f50761h.getItem(this.f50765e.q);
                if (c.a.r0.l4.r.a.a(item)) {
                    this.f50765e.f50758e.showToast(R.string.album_choose_image_low_quality_tip);
                } else if (!c.a.r0.l4.r.a.b(item)) {
                    if (this.f50765e.f50759f.n(item)) {
                        if (this.f50765e.f50760g.j(item)) {
                            AlbumImageBrowseFragment albumImageBrowseFragment = this.f50765e;
                            albumImageBrowseFragment.r(albumImageBrowseFragment.f50764k, false);
                            this.f50765e.f50760g.M(item, false);
                        }
                    } else if (this.f50765e.f50760g.c(item)) {
                        AlbumImageBrowseFragment albumImageBrowseFragment2 = this.f50765e;
                        albumImageBrowseFragment2.r(albumImageBrowseFragment2.f50764k, true);
                        this.f50765e.f50760g.M(item, true);
                    }
                    this.f50765e.p();
                } else {
                    this.f50765e.f50758e.showToast(String.format(this.f50765e.getString(R.string.album_choose_image_max_wh_tip), Integer.valueOf(c.a.q0.s.e0.b.j().k("key_upload_pic_max_width", 0)), Integer.valueOf(c.a.q0.s.e0.b.j().k("key_upload_pic_max_height", 0))));
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlbumImageBrowseFragment f50766e;

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
            this.f50766e = albumImageBrowseFragment;
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
                this.f50766e.q = i2;
                if (this.f50766e.f50761h == null || this.f50766e.f50759f == null) {
                    return;
                }
                ImageFileInfo item = this.f50766e.f50761h.getItem(this.f50766e.q);
                boolean z = true;
                if (this.f50766e.f50759f.n(item)) {
                    AlbumImageBrowseFragment albumImageBrowseFragment = this.f50766e;
                    albumImageBrowseFragment.r(albumImageBrowseFragment.f50764k, true);
                } else {
                    AlbumImageBrowseFragment albumImageBrowseFragment2 = this.f50766e;
                    albumImageBrowseFragment2.r(albumImageBrowseFragment2.f50764k, false);
                }
                if (this.f50766e.f50759f != null && this.f50766e.f50759f.m() != null) {
                    z = this.f50766e.f50759f.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.f50766e.n.setVisibility(8);
                } else if (item == null || !item.isGif()) {
                    this.f50766e.n.setVisibility(0);
                } else {
                    this.f50766e.n.setVisibility(8);
                }
                AlbumImageBrowseFragment albumImageBrowseFragment3 = this.f50766e;
                albumImageBrowseFragment3.selectOriginalImg(albumImageBrowseFragment3.f50759f.s());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50763j : (View) invokeV.objValue;
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
            c.a.q0.w0.a.a(getPageContext(), this.f50762i);
            SkinManager.setNavbarIconSrc(this.f50763j, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i2);
            c cVar = this.f50759f;
            if (cVar != null) {
                selectOriginalImg(cVar.s());
            }
            AlbumImagePagerAdapter albumImagePagerAdapter = this.f50761h;
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
            this.f50758e = baseFragmentActivity;
            if (this.f50760g == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f50760g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f50760g = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            e eVar = this.f50760g;
            if (eVar != null) {
                this.f50759f = eVar.q();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.f50758e = baseFragmentActivity;
            if (this.f50760g == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f50760g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f50760g = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            e eVar = this.f50760g;
            if (eVar != null) {
                this.f50759f = eVar.q();
            }
            View inflate = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
            this.f50762i = inflate;
            this.f50763j = (ImageView) inflate.findViewById(R.id.img_back);
            this.f50764k = (ImageView) this.f50762i.findViewById(R.id.img_choose);
            this.p = (ViewPager) this.f50762i.findViewById(R.id.viewPager);
            this.o = this.f50762i.findViewById(R.id.album_no_data);
            this.n = (TextView) this.f50762i.findViewById(R.id.original_select_btn);
            this.l = this.f50762i.findViewById(R.id.layout_bottom);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f50762i.findViewById(R.id.next_step);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.m.getStyleConfig().l(l.f(this.f50758e, R.dimen.tbds25));
            this.f50763j.setOnClickListener(this.f50758e);
            this.m.setOnClickListener(this.f50758e);
            this.f50764k.setOnClickListener(this.r);
            this.n.setOnClickListener(this.f50758e);
            this.l.setOnClickListener(this.r);
            this.p.setOnPageChangeListener(this.s);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            c cVar = this.f50759f;
            if (cVar != null && cVar.m() != null) {
                this.n.setVisibility(this.f50759f.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
                this.f50762i.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
            }
            return this.f50762i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            super.onHiddenChanged(z);
            if (!z || (albumImagePagerAdapter = this.f50761h) == null) {
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
            this.f50760g.O();
        }
    }

    public final void q() {
        List<ImageFileInfo> i2;
        int j2;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f50759f == null && (eVar = this.f50760g) != null) {
                this.f50759f = eVar.q();
            }
            c cVar = this.f50759f;
            if (cVar == null || (i2 = cVar.i()) == null || (j2 = this.f50759f.j()) < 0) {
                return;
            }
            this.q = j2;
            AlbumImagePagerAdapter albumImagePagerAdapter = new AlbumImagePagerAdapter(this.f50758e);
            this.f50761h = albumImagePagerAdapter;
            this.p.setAdapter(albumImagePagerAdapter);
            int i3 = this.q;
            if (i3 == 0 && i2 != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(i2, i3);
                boolean z = true;
                if (this.f50759f.n(imageFileInfo)) {
                    r(this.f50764k, true);
                } else {
                    r(this.f50764k, false);
                }
                c cVar2 = this.f50759f;
                if (cVar2 != null && cVar2.m() != null) {
                    z = this.f50759f.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.n.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(0);
                }
            }
            this.f50761h.setData(i2);
            this.p.setCurrentItem(this.q, false);
            selectOriginalImg(this.f50759f.s());
        }
    }

    public final void r(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, imageView, z) == null) || imageView == null || this.f50758e == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        if (this.m != null) {
            c cVar = this.f50759f;
            int count = cVar != null ? ListUtils.getCount(cVar.g()) : 0;
            c cVar2 = this.f50759f;
            this.m.setText(this.f50758e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(cVar2 != null ? cVar2.l() : 1)}));
            this.m.setEnabled(count > 0);
        }
    }

    public void refresh() {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (albumImagePagerAdapter = this.f50761h) == null) {
            return;
        }
        r(this.f50764k, this.f50759f.n(albumImagePagerAdapter.getItem(this.q)));
    }

    public void refreshItem(ImageFileInfo imageFileInfo, boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        ImageFileInfo item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, imageFileInfo, z) == null) || imageFileInfo == null || imageFileInfo.getFilePath() == null || (albumImagePagerAdapter = this.f50761h) == null || (item = albumImagePagerAdapter.getItem(this.q)) == null || item.getFilePath() == null || !item.getFilePath().equals(imageFileInfo.getFilePath())) {
            return;
        }
        r(this.f50764k, z);
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
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || this.f50758e == null || this.n == null) {
            return;
        }
        AlbumImagePagerAdapter albumImagePagerAdapter = this.f50761h;
        long fileSize = (albumImagePagerAdapter == null || (item = albumImagePagerAdapter.getItem(this.q)) == null) ? 0L : FileHelper.getFileSize(item.getFilePath());
        String string = this.f50758e.getResources().getString(R.string.original_img);
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            if (fileSize > 0) {
                sb.append("(");
                sb.append(StringHelper.getFormatSize(fileSize));
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            String sb2 = sb.toString();
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0302);
            this.n.setText(sb2);
            this.n.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_select16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
        this.n.setText(string);
        this.n.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_selection16, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setAlbumView(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            this.f50760g = eVar;
        }
    }
}
