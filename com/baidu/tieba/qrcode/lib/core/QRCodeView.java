package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.t2.b.a.c;
/* loaded from: classes4.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Camera f20462e;

    /* renamed from: f  reason: collision with root package name */
    public CameraPreview f20463f;

    /* renamed from: g  reason: collision with root package name */
    public ScanBoxView f20464g;

    /* renamed from: h  reason: collision with root package name */
    public c f20465h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f20466i;
    public boolean j;
    public d.a.p0.t2.b.a.c k;
    public int l;
    public Runnable m;

    /* loaded from: classes4.dex */
    public class a extends d.a.p0.t2.b.a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Camera f20467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ QRCodeView f20468f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(QRCodeView qRCodeView, Camera camera, byte[] bArr, c.a aVar, int i2, Camera camera2) {
            super(camera, bArr, aVar, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeView, camera, bArr, aVar, Integer.valueOf(i2), camera2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Camera) objArr2[0], (byte[]) objArr2[1], (c.a) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20468f = qRCodeView;
            this.f20467e = camera2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                QRCodeView qRCodeView = this.f20468f;
                if (qRCodeView.j) {
                    try {
                        if (qRCodeView.f20465h != null && !TextUtils.isEmpty(str)) {
                            this.f20468f.f20465h.b(str);
                        } else {
                            this.f20467e.setOneShotPreviewCallback(this.f20468f);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QRCodeView f20469e;

        public b(QRCodeView qRCodeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20469e = qRCodeView;
        }

        @Override // java.lang.Runnable
        public void run() {
            QRCodeView qRCodeView;
            Camera camera;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (camera = (qRCodeView = this.f20469e).f20462e) != null && qRCodeView.j) {
                try {
                    camera.setOneShotPreviewCallback(qRCodeView);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();

        void b(String str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void b() {
        d.a.p0.t2.b.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.k) == null) {
            return;
        }
        cVar.a();
        this.k = null;
    }

    public void c() {
        ScanBoxView scanBoxView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (scanBoxView = this.f20464g) == null) {
            return;
        }
        scanBoxView.setVisibility(8);
    }

    public final void d(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) {
            this.f20463f = new CameraPreview(getContext());
            ScanBoxView scanBoxView = new ScanBoxView(getContext());
            this.f20464g = scanBoxView;
            scanBoxView.k(context, attributeSet);
            this.f20463f.setId(R.id.bgaqrcode_camera_preview);
            addView(this.f20463f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
            layoutParams.addRule(6, this.f20463f.getId());
            layoutParams.addRule(8, this.f20463f.getId());
            addView(this.f20464g, layoutParams);
            this.l = d.a.p0.t2.b.a.a.c(context);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
            this.f20466i = null;
            this.f20465h = null;
            this.m = null;
        }
    }

    public void f() {
        ScanBoxView scanBoxView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (scanBoxView = this.f20464g) == null) {
            return;
        }
        scanBoxView.setVisibility(0);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h(0);
        }
    }

    public boolean getIsScanBarcodeStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20464g.getIsBarcode() : invokeV.booleanValue;
    }

    public ScanBoxView getScanBoxView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20464g : (ScanBoxView) invokeV.objValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && this.f20462e == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i3 = 0; i3 < Camera.getNumberOfCameras(); i3++) {
                Camera.getCameraInfo(i3, cameraInfo);
                if (cameraInfo.facing == i2) {
                    i(i3);
                    return;
                }
            }
        }
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            try {
                Camera open = Camera.open(i2);
                this.f20462e = open;
                this.f20463f.setCamera(open);
            } catch (Exception unused) {
                c cVar = this.f20465h;
                if (cVar != null) {
                    cVar.a();
                }
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            k(1000);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.j = true;
            this.f20466i.removeCallbacks(this.m);
            this.f20466i.postDelayed(this.m, i2);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                n();
                if (this.f20462e != null) {
                    this.f20463f.g();
                    this.f20463f.setCamera(null);
                    this.f20462e.release();
                    this.f20462e = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b();
            this.j = false;
            Camera camera = this.f20462e;
            if (camera != null) {
                try {
                    camera.setOneShotPreviewCallback(null);
                } catch (Exception unused) {
                }
            }
            Handler handler = this.f20466i;
            if (handler != null) {
                handler.removeCallbacks(this.m);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            m();
            c();
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, bArr, camera) == null) && this.j) {
            b();
            a aVar = new a(this, camera, bArr, this, this.l, camera);
            aVar.c();
            this.k = aVar;
        }
    }

    public void setDelegate(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.f20465h = cVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QRCodeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = false;
        this.m = new b(this);
        this.f20466i = new Handler();
        d(context, attributeSet);
    }
}
