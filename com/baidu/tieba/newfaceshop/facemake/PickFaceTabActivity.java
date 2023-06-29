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
import com.baidu.tieba.h05;
import com.baidu.tieba.l59;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes7.dex */
public class PickFaceTabActivity extends BaseFragmentActivity implements l59 {
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

    /* loaded from: classes7.dex */
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
                if (this.a.f != null && this.a.f.W1() != null) {
                    for (Map.Entry<String, EmotionImageData> entry : this.a.f.W1().entrySet()) {
                        FaceData faceData = new FaceData();
                        faceData.type = 2;
                        faceData.emotionImageData = entry.getValue();
                        arrayList.add(faceData);
                    }
                }
                if (this.a.h != null && this.a.h.L1() != null) {
                    for (Map.Entry<String, ImageFileInfo> entry2 : this.a.h.L1().entrySet()) {
                        FaceData faceData2 = new FaceData();
                        faceData2.type = 3;
                        faceData2.imageFileInfo = entry2.getValue();
                        arrayList.add(faceData2);
                    }
                }
                if (this.a.g != null && this.a.g.L1() != null) {
                    for (Map.Entry<String, EmotionImageData> entry3 : this.a.g.L1().entrySet()) {
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

    /* loaded from: classes7.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickFaceTabActivity a;

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
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) {
                return;
            }
            this.a.A1(i);
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

    @Override // com.baidu.tieba.l59
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.i++;
            C1();
        }
    }

    @Override // com.baidu.tieba.l59
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i = this.i;
            if (i > 0) {
                this.i = i - 1;
            }
            C1();
        }
    }

    @Override // com.baidu.tieba.l59
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.i < 24) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void A1(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.b != null) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        this.c.setTitle(this.j.getText(R.string.my_mark).toString());
                        return;
                    }
                    return;
                }
                this.c.setTitle(this.j.getText(R.string.album_all).toString());
                return;
            }
            this.c.setTitle(this.j.getText(R.string.obfuscated_res_0x7f0f06f4).toString());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            h05 layoutMode = getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            getLayoutMode().k(this.a);
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
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.j = getPageContext().getPageActivity();
            setContentView(R.layout.obfuscated_res_0x7f0d07df);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f0922fc);
            this.e = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.e.setOnPageChangeListener(this.k);
            this.e.setShouldDrawIndicatorLine(false);
            this.e.r(true);
            z1();
            y1();
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String string = this.j.getString(R.string.obfuscated_res_0x7f0f00e7);
            if (this.i > 0) {
                FaceGroupMakeTitleBar faceGroupMakeTitleBar = this.c;
                faceGroupMakeTitleBar.setRightText(string + "(" + this.i + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            this.c.setRightText(string);
        }
    }

    public final void x1(Fragment fragment, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048583, this, fragment, i, str) != null) || fragment == null) {
            return;
        }
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        cVar.c = fragment;
        cVar.a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.h = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        cVar.b = fragmentTabIndicator;
        this.e.b(cVar);
    }

    public final void y1() {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            FaceSearchFragment faceSearchFragment = new FaceSearchFragment();
            this.f = faceSearchFragment;
            faceSearchFragment.c2(this);
            FaceAlbumFragment faceAlbumFragment = new FaceAlbumFragment();
            this.h = faceAlbumFragment;
            faceAlbumFragment.P1(this);
            FaceCollectFragment faceCollectFragment = new FaceCollectFragment();
            this.g = faceCollectFragment;
            faceCollectFragment.N1(this);
            Intent intent = getIntent();
            if (intent != null) {
                Serializable serializableExtra = intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST);
                if (serializableExtra != null && (serializableExtra instanceof ArrayList)) {
                    arrayList = (ArrayList) serializableExtra;
                } else {
                    arrayList = null;
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(PickFaceTabActivityConfig.CHOOSED_LIST, arrayList);
                    this.f.setArguments(bundle);
                    this.g.setArguments(bundle);
                    this.h.setArguments(bundle);
                    this.i = arrayList.size();
                    C1();
                }
            }
            x1(this.f, 1, this.j.getText(R.string.obfuscated_res_0x7f0f06f0).toString());
            x1(this.h, 3, this.j.getText(R.string.obfuscated_res_0x7f0f06ec).toString());
            x1(this.g, 2, this.j.getText(R.string.my_mark).toString());
            this.e.k(1);
            this.e.setCurrentTab(0);
            this.e.getFragmentTabWidget().getLayoutParams().height = xi.g(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070358);
            this.e.getFragmentTabWidget().setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d_alpha90));
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a = (LinearLayout) findViewById(R.id.layout_root);
            this.b = (NavigationBar) findViewById(R.id.navigation_bar);
            this.c = new FaceGroupMakeTitleBar(getPageContext().getPageActivity());
            this.c.setLayoutParams(new RelativeLayout.LayoutParams(xi.l(getPageContext().getPageActivity()), -1));
            this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.c, (View.OnClickListener) null);
            this.d = (NoNetworkView) findViewById(R.id.view_no_network);
            this.c.setRightListener(new a(this));
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            A1(0);
            C1();
        }
    }
}
