package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pi;
import com.repackage.xn7;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class PickFaceTabActivity extends BaseFragmentActivity implements xn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public NavigationBar b;
    public FaceGroupMakeTitleBar c;
    public NoNetworkView d;
    public FragmentTabHost e;
    public FaceSearchFragment f;
    public FaceCollectFragment g;
    public FaceAlbumFragment h;
    public int i;
    public Activity j;
    public ViewPager.OnPageChangeListener k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickFaceTabActivity a;

        public a(PickFaceTabActivity pickFaceTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickFaceTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pickFaceTabActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Intent intent = new Intent();
                ArrayList arrayList = new ArrayList();
                if (this.a.f != null && this.a.f.I1() != null) {
                    for (Map.Entry<String, EmotionImageData> entry : this.a.f.I1().entrySet()) {
                        FaceData faceData = new FaceData();
                        faceData.type = 2;
                        faceData.emotionImageData = entry.getValue();
                        arrayList.add(faceData);
                    }
                }
                if (this.a.h != null && this.a.h.w1() != null) {
                    for (Map.Entry<String, ImageFileInfo> entry2 : this.a.h.w1().entrySet()) {
                        FaceData faceData2 = new FaceData();
                        faceData2.type = 3;
                        faceData2.imageFileInfo = entry2.getValue();
                        arrayList.add(faceData2);
                    }
                }
                if (this.a.g != null && this.a.g.w1() != null) {
                    for (Map.Entry<String, EmotionImageData> entry3 : this.a.g.w1().entrySet()) {
                        FaceData faceData3 = new FaceData();
                        faceData3.type = 1;
                        faceData3.emotionImageData = entry3.getValue();
                        arrayList.add(faceData3);
                    }
                }
                intent.putExtra(PickFaceTabActivityConfig.CHOOSED_LIST, arrayList);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickFaceTabActivity a;

        public b(PickFaceTabActivity pickFaceTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pickFaceTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pickFaceTabActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.y0(i);
            }
        }
    }

    public PickFaceTabActivity() {
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
        this.i = 0;
        this.k = new b(this);
    }

    @Override // com.repackage.xn7
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.i;
            if (i > 0) {
                this.i = i - 1;
            }
            z0();
        }
    }

    @Override // com.repackage.xn7
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.i < 24 : invokeV.booleanValue;
    }

    @Override // com.repackage.xn7
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.i++;
            z0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            getLayoutMode().k(i == 1);
            getLayoutMode().j(this.a);
            SkinManager.setBackgroundResource(this.a, R.color.CAM_X0201);
            this.b.onChangeSkinType(getPageContext(), i);
            this.f.onChangeSkinType(i);
            this.g.onChangeSkinType(i);
            this.h.onChangeSkinType(i);
            this.d.d(getPageContext(), i);
            this.e.s(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.j = getPageContext().getPageActivity();
            setContentView(R.layout.obfuscated_res_0x7f0d06eb);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f091ec6);
            this.e = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.e.setOnPageChangeListener(this.k);
            this.e.setShouldDrawIndicatorLine(false);
            this.e.r(true);
            x0();
            w0();
        }
    }

    public final void t0(Fragment fragment, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048581, this, fragment, i, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.c = fragment;
        bVar.a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.h = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        bVar.b = fragmentTabIndicator;
        this.e.c(bVar);
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            FaceSearchFragment faceSearchFragment = new FaceSearchFragment();
            this.f = faceSearchFragment;
            faceSearchFragment.O1(this);
            FaceAlbumFragment faceAlbumFragment = new FaceAlbumFragment();
            this.h = faceAlbumFragment;
            faceAlbumFragment.B1(this);
            FaceCollectFragment faceCollectFragment = new FaceCollectFragment();
            this.g = faceCollectFragment;
            faceCollectFragment.y1(this);
            Intent intent = getIntent();
            if (intent != null) {
                Serializable serializableExtra = intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST);
                ArrayList arrayList = (serializableExtra == null || !(serializableExtra instanceof ArrayList)) ? null : (ArrayList) serializableExtra;
                if (!ListUtils.isEmpty(arrayList)) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(PickFaceTabActivityConfig.CHOOSED_LIST, arrayList);
                    this.f.setArguments(bundle);
                    this.g.setArguments(bundle);
                    this.h.setArguments(bundle);
                    this.i = arrayList.size();
                    z0();
                }
            }
            t0(this.f, 1, this.j.getText(R.string.obfuscated_res_0x7f0f05e5).toString());
            t0(this.h, 3, this.j.getText(R.string.obfuscated_res_0x7f0f05e1).toString());
            t0(this.g, 2, this.j.getText(R.string.obfuscated_res_0x7f0f0b3e).toString());
            this.e.n(1);
            this.e.setCurrentTab(0);
            this.e.getFragmentTabWidget().getLayoutParams().height = pi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070238);
            this.e.getFragmentTabWidget().setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d_alpha90));
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091251);
            this.b = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09158d);
            this.c = new FaceGroupMakeTitleBar(getPageContext().getPageActivity());
            this.c.setLayoutParams(new RelativeLayout.LayoutParams(pi.k(getPageContext().getPageActivity()), -1));
            this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.c, (View.OnClickListener) null);
            this.d = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f092439);
            this.c.setRightListener(new a(this));
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            y0(0);
            z0();
        }
    }

    public final void y0(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || this.b == null) {
            return;
        }
        if (i == 0) {
            this.c.setTitle(this.j.getText(R.string.obfuscated_res_0x7f0f05e9).toString());
        } else if (i == 1) {
            this.c.setTitle(this.j.getText(R.string.obfuscated_res_0x7f0f024d).toString());
        } else if (i != 2) {
        } else {
            this.c.setTitle(this.j.getText(R.string.obfuscated_res_0x7f0f0b3e).toString());
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String string = this.j.getString(R.string.obfuscated_res_0x7f0f00b8);
            if (this.i > 0) {
                FaceGroupMakeTitleBar faceGroupMakeTitleBar = this.c;
                faceGroupMakeTitleBar.setRightText(string + "(" + this.i + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            this.c.setRightText(string);
        }
    }
}
