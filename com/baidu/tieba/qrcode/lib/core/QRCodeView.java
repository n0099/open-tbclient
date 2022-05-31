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
import com.repackage.i68;
import com.repackage.k68;
/* loaded from: classes3.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, k68.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Camera a;
    public CameraPreview b;
    public ScanBoxView c;
    public c d;
    public Handler e;
    public boolean f;
    public k68 g;
    public int h;
    public Runnable i;

    /* loaded from: classes3.dex */
    public class a extends k68 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Camera e;
        public final /* synthetic */ QRCodeView f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(QRCodeView qRCodeView, Camera camera, byte[] bArr, k68.a aVar, int i, Camera camera2) {
            super(camera, bArr, aVar, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeView, camera, bArr, aVar, Integer.valueOf(i), camera2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Camera) objArr2[0], (byte[]) objArr2[1], (k68.a) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = qRCodeView;
            this.e = camera2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                QRCodeView qRCodeView = this.f;
                if (qRCodeView.f) {
                    try {
                        if (qRCodeView.d != null && !TextUtils.isEmpty(str)) {
                            this.f.d.b(str);
                        } else {
                            this.e.setOneShotPreviewCallback(this.f);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QRCodeView a;

        public b(QRCodeView qRCodeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qRCodeView;
        }

        @Override // java.lang.Runnable
        public void run() {
            QRCodeView qRCodeView;
            Camera camera;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (camera = (qRCodeView = this.a).a) != null && qRCodeView.f) {
                try {
                    camera.setOneShotPreviewCallback(qRCodeView);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void b() {
        k68 k68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (k68Var = this.g) == null) {
            return;
        }
        k68Var.a();
        this.g = null;
    }

    public void c() {
        ScanBoxView scanBoxView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (scanBoxView = this.c) == null) {
            return;
        }
        scanBoxView.setVisibility(8);
    }

    public final void d(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) {
            this.b = new CameraPreview(getContext());
            ScanBoxView scanBoxView = new ScanBoxView(getContext());
            this.c = scanBoxView;
            scanBoxView.k(context, attributeSet);
            this.b.setId(R.id.obfuscated_res_0x7f090366);
            addView(this.b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
            layoutParams.addRule(6, this.b.getId());
            layoutParams.addRule(8, this.b.getId());
            addView(this.c, layoutParams);
            this.h = i68.c(context);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
            this.e = null;
            this.d = null;
            this.i = null;
        }
    }

    public void f() {
        ScanBoxView scanBoxView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (scanBoxView = this.c) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c.getIsBarcode() : invokeV.booleanValue;
    }

    public ScanBoxView getScanBoxView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (ScanBoxView) invokeV.objValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && this.a == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    i(i2);
                    return;
                }
            }
        }
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            try {
                Camera open = Camera.open(i);
                this.a = open;
                this.b.setCamera(open);
            } catch (Exception unused) {
                c cVar = this.d;
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

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f = true;
            this.e.removeCallbacks(this.i);
            this.e.postDelayed(this.i, i);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                n();
                if (this.a != null) {
                    this.b.g();
                    this.b.setCamera(null);
                    this.a.release();
                    this.a = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b();
            this.f = false;
            Camera camera = this.a;
            if (camera != null) {
                try {
                    camera.setOneShotPreviewCallback(null);
                } catch (Exception unused) {
                }
            }
            Handler handler = this.e;
            if (handler != null) {
                handler.removeCallbacks(this.i);
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
        if ((interceptable == null || interceptable.invokeLL(1048591, this, bArr, camera) == null) && this.f) {
            b();
            a aVar = new a(this, camera, bArr, this, this.h, camera);
            aVar.c();
            this.g = aVar;
        }
    }

    public void setDelegate(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.d = cVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = false;
        this.i = new b(this);
        this.e = new Handler();
        d(context, attributeSet);
    }
}
