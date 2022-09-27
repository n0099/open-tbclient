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
import com.baidu.tieba.ej;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.fo4;
import com.baidu.tieba.g85;
import com.baidu.tieba.go4;
import com.baidu.tieba.io4;
import com.baidu.tieba.on;
import com.baidu.tieba.vr7;
import com.baidu.tieba.wr7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class FaceAlbumFragment extends BaseFragment implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public go4 a;
    public GridView b;
    public wr7 c;
    public List<ImageFileInfo> d;
    public vr7 e;
    public NoDataView f;
    public BaseFragmentActivity g;

    /* loaded from: classes5.dex */
    public class a implements io4 {
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

        @Override // com.baidu.tieba.io4
        public void a(List<fo4> list, List<ImageFileInfo> list2, String str) {
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

        @Override // com.baidu.tieba.io4
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements g85 {
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

        @Override // com.baidu.tieba.g85
        public void a(on onVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, onVar, str, z) == null) || (tbImageView = (TbImageView) this.a.b.findViewWithTag(str)) == null || onVar == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            this.g = (BaseFragmentActivity) getPageContext().getPageActivity();
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02e2, (ViewGroup) null);
            SkinManager.setBackgroundResource(inflate, R.color.CAM_X0201);
            NoDataView a2 = NoDataViewFactory.a(this.g, inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, ej.f(this.g, R.dimen.obfuscated_res_0x7f07029e)), NoDataViewFactory.e.c(this.g.getText(R.string.obfuscated_res_0x7f0f05ff).toString()), null);
            this.f = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f.setVisibility(8);
            this.b = (GridView) inflate.findViewById(R.id.obfuscated_res_0x7f090cf7);
            v1();
            w1();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            go4 go4Var = this.a;
            if (go4Var != null) {
                go4Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, absListView, i) == null) {
            super.onScrollStateChanged(absListView, i);
            if (i == 2) {
                this.c.l(true);
            } else if (this.c.i()) {
                this.c.l(false);
                x1();
            }
        }
    }

    public LinkedHashMap<String, ImageFileInfo> u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            wr7 wr7Var = this.c;
            if (wr7Var != null) {
                return wr7Var.f();
            }
            return null;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    public final void v1() {
        Serializable serializable;
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d = new ArrayList();
            this.a = new go4(getActivity());
            wr7 wr7Var = new wr7(this.g, this.d);
            this.c = wr7Var;
            wr7Var.j(this.e);
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

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.i(fo4.f, new a(this));
        }
    }

    public final void x1() {
        wr7 wr7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (wr7Var = this.c) == null || wr7Var.g() == null) {
            return;
        }
        int childCount = this.b.getChildCount();
        int firstVisiblePosition = this.b.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getChildAt(i);
            if (childAt != null) {
                TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.obfuscated_res_0x7f090e94);
                ImageFileInfo item = this.c.getItem(firstVisiblePosition + i);
                if (item != null && tbImageView != null) {
                    tbImageView.setTag(item.toCachedKey(false));
                    this.c.g().e(item, new b(this), false, false);
                }
            }
        }
    }

    public void z1(vr7 vr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, vr7Var) == null) {
            this.e = vr7Var;
            wr7 wr7Var = this.c;
            if (wr7Var != null) {
                wr7Var.j(vr7Var);
            }
        }
    }
}
