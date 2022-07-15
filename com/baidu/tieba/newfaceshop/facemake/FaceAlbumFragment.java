package com.baidu.tieba.newfaceshop.facemake;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bl4;
import com.repackage.k45;
import com.repackage.pi;
import com.repackage.xn7;
import com.repackage.yk4;
import com.repackage.ym;
import com.repackage.yn7;
import com.repackage.zk4;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class FaceAlbumFragment extends BaseFragment implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zk4 a;
    public GridView b;
    public yn7 c;
    public List<ImageFileInfo> d;
    public xn7 e;
    public NoDataView f;
    public BaseFragmentActivity g;

    /* loaded from: classes3.dex */
    public class a implements bl4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceAlbumFragment a;

        public a(FaceAlbumFragment faceAlbumFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceAlbumFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceAlbumFragment;
        }

        @Override // com.repackage.bl4
        public void a(List<yk4> list, List<ImageFileInfo> list2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
                if (!ListUtils.isEmpty(list2)) {
                    this.a.d.addAll(list2);
                    this.a.c.notifyDataSetChanged();
                    return;
                }
                this.a.b.setVisibility(8);
                this.a.f.setVisibility(0);
            }
        }

        @Override // com.repackage.bl4
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements k45 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceAlbumFragment a;

        public b(FaceAlbumFragment faceAlbumFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceAlbumFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceAlbumFragment;
        }

        @Override // com.repackage.k45
        public void a(ym ymVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, ymVar, str, z) == null) || (tbImageView = (TbImageView) this.a.b.findViewWithTag(str)) == null || ymVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    public FaceAlbumFragment() {
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

    public final void A1() {
        yn7 yn7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (yn7Var = this.c) == null || yn7Var.g() == null) {
            return;
        }
        int childCount = this.b.getChildCount();
        int firstVisiblePosition = this.b.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getChildAt(i);
            if (childAt != null) {
                TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.obfuscated_res_0x7f090e33);
                ImageFileInfo item = this.c.getItem(firstVisiblePosition + i);
                if (item != null && tbImageView != null) {
                    tbImageView.setTag(item.toCachedKey(false));
                    this.c.g().e(item, new b(this), false, false);
                }
            }
        }
    }

    public void B1(xn7 xn7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xn7Var) == null) {
            this.e = xn7Var;
            yn7 yn7Var = this.c;
            if (yn7Var != null) {
                yn7Var.j(xn7Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            this.g = (BaseFragmentActivity) getPageContext().getPageActivity();
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02da, (ViewGroup) null);
            SkinManager.setBackgroundResource(inflate, R.color.CAM_X0201);
            NoDataView a2 = NoDataViewFactory.a(this.g, inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, pi.f(this.g, R.dimen.obfuscated_res_0x7f0702a0)), NoDataViewFactory.e.c(this.g.getText(R.string.obfuscated_res_0x7f0f05e7).toString()), null);
            this.f = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f.setVisibility(8);
            this.b = (GridView) inflate.findViewById(R.id.obfuscated_res_0x7f090ca0);
            x1();
            y1();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            zk4 zk4Var = this.a;
            if (zk4Var != null) {
                zk4Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, absListView, i) == null) {
            super.onScrollStateChanged(absListView, i);
            if (i == 2) {
                this.c.l(true);
            } else if (this.c.i()) {
                this.c.l(false);
                A1();
            }
        }
    }

    public LinkedHashMap<String, ImageFileInfo> w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            yn7 yn7Var = this.c;
            if (yn7Var != null) {
                return yn7Var.f();
            }
            return null;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    public final void x1() {
        Serializable serializable;
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d = new ArrayList();
            this.a = new zk4(getActivity());
            yn7 yn7Var = new yn7(this.g, this.d);
            this.c = yn7Var;
            yn7Var.j(this.e);
            this.b.setAdapter((ListAdapter) this.c);
            this.b.setOnScrollListener(this);
            if (getArguments() == null || (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) == null || !(serializable instanceof ArrayList)) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                FaceData faceData = (FaceData) it.next();
                if (faceData != null && faceData.type == 3 && (imageFileInfo = faceData.imageFileInfo) != null) {
                    linkedHashMap.put(imageFileInfo.getFilePath(), faceData.imageFileInfo);
                }
            }
            this.c.e(linkedHashMap);
        }
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.i(yk4.f, new a(this));
        }
    }
}
