package com.baidu.tieba;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class mo2 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public String b;
    public ArrayList<ap2> c;
    public int d;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SimpleDraweeView a;
        public TextView b;
        public TextView c;

        public a(mo2 mo2Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mo2Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f090246);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090249);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090248);
        }
    }

    public mo2(Activity activity, String str, ArrayList<ap2> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.b = str;
        this.c = arrayList;
        this.d = (int) (re3.f(activity, 50.0f) / 2.0f);
    }

    public final String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? TextUtils.equals(this.b, "Image") ? this.a.getString(R.string.obfuscated_res_0x7f0f12c3, new Object[]{Integer.valueOf(i)}) : this.a.getString(R.string.obfuscated_res_0x7f0f1292, new Object[]{Integer.valueOf(i)}) : (String) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<ap2> arrayList = this.c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i < 0 || i > this.c.size()) {
                return null;
            }
            return this.c.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d080b, (ViewGroup) null);
                aVar = new a(this, view2);
                view2.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
            }
            view2.setBackground(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081156));
            ap2 ap2Var = this.c.get(i);
            if (ap2Var == null) {
                return view2;
            }
            aVar.b.setText(ap2Var.c());
            ArrayList<MediaModel> arrayList = ap2Var.d;
            if (arrayList == null) {
                return view2;
            }
            aVar.c.setText(a(arrayList.size()));
            if (ap2Var.d.get(0) != null && !TextUtils.isEmpty(ap2Var.d.get(0).getPath())) {
                ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(ap2Var.d.get(0).getPath())));
                int i2 = this.d;
                newBuilderWithSource.setResizeOptions(new ResizeOptions(i2, i2));
                newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
                aVar.a.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setImageRequest(newBuilderWithSource.build()).setOldController(aVar.a.getController()).build());
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
