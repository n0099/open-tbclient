package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes8.dex */
public class sy2 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public ArrayList<MediaModel> b;
    public ez2 c;
    public int d;
    public int e;
    public FrameLayout.LayoutParams f;

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy2 a;

        public a(sy2 sy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.m();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy2 a;

        public b(sy2 sy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.k();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements k63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy2 a;

        @Override // com.baidu.tieba.k63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }

        public c(sy2 sy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy2Var;
        }

        @Override // com.baidu.tieba.k63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.u();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements bz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy2 a;

        @Override // com.baidu.tieba.bz2
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        public d(sy2 sy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy2Var;
        }

        @Override // com.baidu.tieba.bz2
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                yy2.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", xy2.e);
                bundle.putString("swanAppId", xy2.f);
                bundle.putParcelableArrayList("mediaModels", yy2.e());
                bundle.putString("swanTmpPath", xy2.j);
                xy2.g(this.a.a, bundle);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements k63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy2 a;

        @Override // com.baidu.tieba.k63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }

        public e(sy2 sy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy2Var;
        }

        @Override // com.baidu.tieba.k63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.t();
        }
    }

    /* loaded from: classes8.dex */
    public class f implements bz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy2 a;

        @Override // com.baidu.tieba.bz2
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        public f(sy2 sy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy2Var;
        }

        @Override // com.baidu.tieba.bz2
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                yy2.i(vy2.c(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", xy2.e);
                bundle.putString("swanAppId", xy2.f);
                bundle.putParcelableArrayList("mediaModels", yy2.e());
                bundle.putString("swanTmpPath", xy2.j);
                xy2.g(this.a.a, bundle);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaModel a;
        public final /* synthetic */ j b;
        public final /* synthetic */ sy2 c;

        public g(sy2 sy2Var, MediaModel mediaModel, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy2Var, mediaModel, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sy2Var;
            this.a = mediaModel;
            this.b = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.c.l(this.a, this.b);
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaModel a;
        public final /* synthetic */ int b;
        public final /* synthetic */ sy2 c;

        public h(sy2 sy2Var, MediaModel mediaModel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy2Var, mediaModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sy2Var;
            this.a = mediaModel;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.c.j(this.a, this.b);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoModel a;
        public final /* synthetic */ MediaModel b;
        public final /* synthetic */ int c;
        public final /* synthetic */ sy2 d;

        public i(sy2 sy2Var, VideoModel videoModel, MediaModel mediaModel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy2Var, videoModel, mediaModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = sy2Var;
            this.a = videoModel;
            this.b = mediaModel;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !this.d.s(this.a.getPath()) || this.d.n(this.a.getDuration())) {
                return;
            }
            this.d.j(this.b, this.c);
        }
    }

    /* loaded from: classes8.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SimpleDraweeView a;
        public ImageView b;
        public TextView c;
        public ImageView d;
        public View e;
        public View f;
        public TextView g;
        public View h;

        public j(sy2 sy2Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy2Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f090252);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090254);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090256);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f090257);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f090255);
            this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090259);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f090258);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090253);
        }
    }

    public sy2(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.b = new ArrayList<>();
        int o = yo3.o(this.a);
        int n = yo3.n(this.a);
        this.d = o / 4;
        this.e = n / 4;
        this.f = new FrameLayout.LayoutParams((o - yo3.f(this.a, 10.0f)) / 4, (o - yo3.f(this.a, 10.0f)) / 4);
    }

    public final String o(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j2)) == null) {
            long j3 = j2 / 1000;
            long j4 = j3 / 3600;
            long j5 = j3 % 3600;
            String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j5 / 60));
            String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j5 % 60));
            if (j4 == 0) {
                return this.a.getString(R.string.obfuscated_res_0x7f0f15a6, new Object[]{format, format2});
            }
            return this.a.getString(R.string.obfuscated_res_0x7f0f15a7, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j4)), format, format2});
        }
        return (String) invokeJ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean s(String str) {
        InterceptResult invokeL;
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever2 = null;
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            } catch (Exception e2) {
                e = e2;
            }
            try {
                mediaMetadataRetriever.setDataSource(str);
                str2 = mediaMetadataRetriever.extractMetadata(12);
            } catch (Exception e3) {
                e = e3;
                mediaMetadataRetriever2 = mediaMetadataRetriever;
                if (wy2.a) {
                    e.printStackTrace();
                }
                str2 = "";
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                }
                if (TextUtils.isEmpty(str2)) {
                }
                za3.g(AppRuntime.getAppContext(), this.a.getString(R.string.obfuscated_res_0x7f0f1527)).G();
                return false;
            }
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e4) {
                    if (wy2.a) {
                        e4.printStackTrace();
                    }
                }
            }
            if (TextUtils.isEmpty(str2) && str2.startsWith(FileUtils.VIDEO_FILE_START)) {
                if (!TextUtils.equals("video/mp4", str2) && !TextUtils.equals("video/3gp", str2) && !TextUtils.equals(MimeTypes.VIDEO_WEBM, str2) && !TextUtils.equals("video/mkv", str2)) {
                    return false;
                }
                return true;
            }
            za3.g(AppRuntime.getAppContext(), this.a.getString(R.string.obfuscated_res_0x7f0f1527)).G();
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (xy2.h) {
                if (i2 == 0) {
                    return null;
                }
                return this.b.get(i2 - 1);
            }
            return this.b.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (!xy2.h || i2 != 0) {
                return 1;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            j63.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new e(this));
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            j63.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new c(this));
        }
    }

    public void x(ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) {
            if (this.b.size() > 0) {
                this.b.clear();
            }
            this.b.addAll(arrayList);
            xy2.i(this.b);
            notifyDataSetChanged();
        }
    }

    public void z(ez2 ez2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, ez2Var) == null) {
            this.c = ez2Var;
        }
    }

    public final void A(j jVar, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jVar, view2) == null) {
            Resources resources = this.a.getResources();
            view2.setBackgroundColor(-1);
            jVar.a.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060afa));
            jVar.c.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b05));
            jVar.h.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081473));
            jVar.g.setTextColor(-1);
            jVar.b.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060b08));
            jVar.a.setLayoutParams(this.f);
            jVar.b.setLayoutParams(this.f);
            jVar.b.setVisibility(8);
            jVar.c.setVisibility(8);
            jVar.f.setVisibility(8);
            jVar.h.setVisibility(8);
            jVar.f.setVisibility(0);
            jVar.d.setImageResource(R.drawable.obfuscated_res_0x7f081481);
            jVar.h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.h.getLayoutParams();
            layoutParams.width = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070847);
            layoutParams.height = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070842);
            jVar.h.setLayoutParams(layoutParams);
        }
    }

    public final void l(MediaModel mediaModel, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, mediaModel, jVar) == null) {
            int d2 = yy2.d();
            if (!yy2.f(mediaModel)) {
                if (d2 >= xy2.c) {
                    xy2.j(xy2.d);
                    return;
                } else if (d2 > 0 && TextUtils.equals(xy2.d, "single") && !TextUtils.equals(yy2.b(), mediaModel.getType())) {
                    za3.f(this.a, R.string.obfuscated_res_0x7f0f1520).G();
                    return;
                } else if (mediaModel.getSize() > 52428800 && TextUtils.equals(mediaModel.getType(), "image")) {
                    za3.f(this.a, R.string.obfuscated_res_0x7f0f151f).G();
                    return;
                } else {
                    jVar.d.setImageResource(R.drawable.obfuscated_res_0x7f08147f);
                    jVar.c.setVisibility(0);
                    jVar.c.setText(String.valueOf(yy2.c(mediaModel) + 1));
                    yy2.i(mediaModel);
                    jVar.e.startAnimation(AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010173));
                    ez2 ez2Var = this.c;
                    if (ez2Var != null) {
                        ez2Var.a(d2);
                    }
                    notifyDataSetChanged();
                    return;
                }
            }
            yy2.h(mediaModel);
            jVar.d.setImageResource(R.drawable.obfuscated_res_0x7f081481);
            jVar.c.setVisibility(8);
            ez2 ez2Var2 = this.c;
            if (ez2Var2 != null) {
                ez2Var2.a(d2);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (xy2.h) {
                return this.b.size() + 1;
            }
            return this.b.size();
        }
        return invokeV.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (yy2.d() >= xy2.c) {
                xy2.j(xy2.d);
            } else {
                q(this.a);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            vy2.e(this.a, xy2.f, xy2.g, xy2.i, new f(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            vy2.f(this.a, xy2.f, new d(this));
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view2, viewGroup)) == null) {
            if (getItemViewType(i2) == 0) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d093c, (ViewGroup) null, false);
                r(inflate);
                return inflate;
            }
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0942, (ViewGroup) null);
                jVar = new j(this, view2);
                view2.setTag(jVar);
            } else {
                jVar = (j) view2.getTag();
            }
            A(jVar, view2);
            MediaModel mediaModel = (MediaModel) getItem(i2);
            if (mediaModel == null) {
                return view2;
            }
            y(mediaModel.getPath(), jVar);
            v(mediaModel, jVar, i2);
            w(mediaModel, jVar, i2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void w(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048596, this, mediaModel, jVar, i2) == null) && (mediaModel instanceof VideoModel)) {
            VideoModel videoModel = (VideoModel) mediaModel;
            jVar.h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.h.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070841);
            } else {
                layoutParams.width = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070845);
            }
            layoutParams.height = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070842);
            jVar.h.setLayoutParams(layoutParams);
            jVar.g.setText(o(videoModel.getDuration()));
            jVar.a.setOnClickListener(new i(this, videoModel, mediaModel, i2));
        }
    }

    public final void j(MediaModel mediaModel, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048583, this, mediaModel, i2) != null) || xy2.f(xy2.d, mediaModel)) {
            return;
        }
        if (xy2.h) {
            i2--;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("compressed", xy2.e);
        bundle.putString("swanAppId", xy2.f);
        bundle.putString("mode", xy2.d);
        bundle.putString("previewFrom", "clickItem");
        bundle.putInt("previewPosition", i2);
        xy2.k(this.a, bundle);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (yy2.d() >= xy2.c) {
                xy2.j(xy2.d);
            } else if (vo3.c() < 52428800) {
                za3.g(AppRuntime.getAppContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1518)).G();
            } else {
                p(this.a);
            }
        }
    }

    public final boolean n(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            if (j2 < 3000) {
                za3.g(AppRuntime.getAppContext(), this.a.getString(R.string.obfuscated_res_0x7f0f1526)).G();
                return true;
            } else if (j2 > 300000) {
                za3.g(AppRuntime.getAppContext(), this.a.getString(R.string.obfuscated_res_0x7f0f1525)).G();
                return true;
            } else {
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            view2.findViewById(R.id.obfuscated_res_0x7f09024b).setLayoutParams(this.f);
            view2.setTag(null);
            view2.setClickable(true);
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09024c);
            if (TextUtils.equals(xy2.b, "Image")) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f081469);
                view2.setOnClickListener(new a(this));
                return;
            }
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08146d);
            view2.setOnClickListener(new b(this));
        }
    }

    public final void v(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, mediaModel, jVar, i2) == null) {
            if (yy2.f(mediaModel)) {
                jVar.d.setImageResource(R.drawable.obfuscated_res_0x7f08147f);
                jVar.c.setVisibility(0);
                jVar.c.setText(String.valueOf(yy2.c(mediaModel) + 1));
            }
            if (xy2.f(xy2.d, mediaModel)) {
                jVar.b.setVisibility(0);
            } else {
                jVar.b.setVisibility(8);
            }
            if (wy2.d) {
                if (xy2.d(mediaModel.getPath())) {
                    jVar.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f151c));
                } else if (xy2.e(mediaModel.getPath())) {
                    jVar.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f151d));
                } else {
                    jVar.h.setVisibility(8);
                }
            } else {
                jVar.h.setVisibility(8);
            }
            jVar.f.setOnClickListener(new g(this, mediaModel, jVar));
            jVar.a.setOnClickListener(new h(this, mediaModel, i2));
        }
    }

    public final void y(String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, jVar) == null) {
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(str)));
            newBuilderWithSource.setResizeOptions(new ResizeOptions((int) (this.d / 2.0f), (int) (this.e / 2.0f)));
            newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
            newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build());
            AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setImageRequest(newBuilderWithSource.build()).setAutoPlayAnimations(false).setOldController(jVar.a.getController()).build();
            jVar.a.setController(build);
            DraweeHierarchy hierarchy = build.getHierarchy();
            if (hierarchy instanceof GenericDraweeHierarchy) {
                ou2.C().c((GenericDraweeHierarchy) hierarchy, false);
            }
        }
    }
}
