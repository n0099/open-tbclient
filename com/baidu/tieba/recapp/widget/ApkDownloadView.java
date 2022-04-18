package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hk0;
import com.repackage.hw4;
import com.repackage.ib8;
import com.repackage.ij5;
import com.repackage.lj5;
import com.repackage.nd8;
import com.repackage.ob8;
import com.repackage.oj5;
import com.repackage.rg5;
import com.repackage.rj0;
import java.util.List;
/* loaded from: classes4.dex */
public class ApkDownloadView extends FrameLayout implements oj5, hk0<View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nd8 a;
    public DownloadData b;
    public oj5.a c;
    public DownloadStatus d;
    public String e;
    public CustomMessageListener f;
    public CustomMessageListener g;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ApkDownloadView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ApkDownloadView apkDownloadView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apkDownloadView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = apkDownloadView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage) && this.a.b != null) {
                DownloadData downloadData = null;
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                int i = 0;
                while (true) {
                    if (i >= data.size()) {
                        break;
                    }
                    DownloadData downloadData2 = data.get(i);
                    if (TextUtils.isEmpty(this.a.b.getId())) {
                        i++;
                    } else if (this.a.b.getId().equals(downloadData2.getId())) {
                        downloadData = downloadData2;
                    }
                }
                if (downloadData != null) {
                    int l = this.a.l(downloadData);
                    if (ob8.l(downloadData) == 1) {
                        this.a.x(l);
                    } else if (ob8.l(downloadData) == 3) {
                        this.a.a.setButtonText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f08c8));
                    } else {
                        this.a.q(downloadData);
                    }
                    this.a.postInvalidate();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ApkDownloadView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ApkDownloadView apkDownloadView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apkDownloadView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = apkDownloadView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.b == null) {
                return;
            }
            DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
            if (this.a.b.getId() == null || downloadData == null || !this.a.b.getId().equals(downloadData.getId())) {
                return;
            }
            this.a.w(downloadData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = getResources().getString(R.string.obfuscated_res_0x7f0f08e8);
        this.f = null;
        this.g = null;
        o(context);
    }

    public static int m(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, downloadData)) == null) {
            if (downloadData == null) {
                return 0;
            }
            int process = downloadData.getProcess();
            if (process <= 0) {
                process = ob8.j().h(downloadData.getId(), downloadData.getName());
            }
            return Math.max(process, 0);
        }
        return invokeL.intValue;
    }

    public static int n(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, downloadData)) == null) {
            hw4 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null && !adAdSense.f()) {
                return ib8.p(downloadData);
            }
            return ob8.l(downloadData);
        }
        return invokeL.intValue;
    }

    @Override // com.repackage.oj5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.d == DownloadStatus.STATUS_DOWNLOADING) {
            x(i);
        }
    }

    @Override // com.repackage.oj5
    public boolean b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            oj5.a aVar = this.c;
            if (aVar != null) {
                return aVar.b(view2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.hk0
    public void c(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) {
        }
    }

    @Override // com.repackage.oj5
    public void d(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadStatus) == null) {
            this.d = downloadStatus;
            DownloadData downloadData = this.b;
            if (downloadData != null) {
                downloadData.setStatus(getDownloadStatus());
                w(this.b);
            }
        }
    }

    @Override // com.repackage.oj5
    public void e(DownloadStatus downloadStatus, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, downloadStatus, i) == null) {
            d(downloadStatus);
            a(i);
        }
    }

    @Override // com.repackage.oj5
    public View getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (View) invokeV.objValue;
    }

    public int getDownloadStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            DownloadStatus downloadStatus = this.d;
            if (downloadStatus == null || downloadStatus == DownloadStatus.STATUS_NONE) {
                return 6;
            }
            if (downloadStatus == DownloadStatus.STATUS_DOWNLOADING) {
                return 1;
            }
            if (downloadStatus == DownloadStatus.STATUS_PAUSED) {
                return 7;
            }
            if (downloadStatus == DownloadStatus.STATUS_SUCCESS) {
                return 3;
            }
            return downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.oj5, com.repackage.hk0
    @NonNull
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (View) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.b();
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            if (this.f == null) {
                a aVar = new a(this, 2001118);
                this.f = aVar;
                aVar.setTag(bdUniqueId);
            }
            if (this.g == null) {
                b bVar = new b(this, 2016484);
                this.g = bVar;
                bVar.setTag(bdUniqueId);
            }
        }
    }

    public final int l(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, downloadData)) == null) {
            if (downloadData == null) {
                return 0;
            }
            return (int) ((downloadData.getLength() * 100) / downloadData.getSize());
        }
        return invokeL.intValue;
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            this.a = (nd8) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0120, (ViewGroup) this, true).findViewById(R.id.obfuscated_res_0x7f09098a);
            p(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onAttachedToWindow();
            r();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDetachedFromWindow();
            v();
            u();
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.a.a();
        }
    }

    public void q(DownloadData downloadData) {
        AdDownloadData a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, downloadData) == null) {
            DownloadCacheKey h = lj5.d().h(downloadData.getId());
            this.a.setButtonText(getResources().getString(R.string.obfuscated_res_0x7f0f07ab), (h == null || (a2 = ij5.c().a(h)) == null) ? 0 : a2.getPercent());
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f != null) {
                MessageManager.getInstance().registerListener(this.f);
            }
            if (this.g != null) {
                MessageManager.getInstance().registerListener(this.g);
            }
        }
    }

    public void s(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadData) == null) {
            this.a.setButtonText(this.e);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            nd8 nd8Var = this.a;
            if (nd8Var instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) nd8Var).setBackgroundSkin(i);
            }
        }
    }

    public void setData(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, downloadData) == null) || downloadData == null) {
            return;
        }
        DownloadData downloadData2 = (DownloadData) downloadData.clone();
        this.b = downloadData2;
        if (downloadData2 == null) {
            return;
        }
        setTag(downloadData2);
        w(downloadData);
    }

    public void setForegroundSkin(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            nd8 nd8Var = this.a;
            if (nd8Var instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) nd8Var).setForeground(i);
            }
        }
    }

    public void setInitText(String str) {
        nd8 nd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.e = str;
            if (TextUtils.isEmpty(str) || (nd8Var = this.a) == null) {
                return;
            }
            nd8Var.setInitText(str);
        }
    }

    public void setOnClickInterceptListener(oj5.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            this.c = aVar;
        }
    }

    public void setRatio(int i) {
        nd8 nd8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i) == null) || (nd8Var = this.a) == null) {
            return;
        }
        nd8Var.setRatio(i);
    }

    public void setStrokeWidth(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            nd8 nd8Var = this.a;
            if (nd8Var instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) nd8Var).setStrokeWidth(i);
            }
        }
    }

    public void setTextColor(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.a.setButtonTextColor(i);
        }
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            nd8 nd8Var = this.a;
            if (nd8Var instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) nd8Var).setTextColorInitSkin(i);
            }
        }
    }

    public void setTextColorSkin(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            nd8 nd8Var = this.a;
            if (nd8Var instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) nd8Var).setTextColorSkin(i);
            }
        }
    }

    public void setTextNightColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.a.setButtonTextNightColor(i);
        }
    }

    public void setTextSize(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.a.setButtonTextSize(i);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            super.setVisibility(i);
            if (i == 0) {
                r();
            } else {
                v();
            }
        }
    }

    public void t(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, downloadData) == null) {
            x(m(downloadData));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            setOnClickInterceptListener(null);
        }
    }

    @Override // com.repackage.hk0
    public void update(String str, @NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, rj0Var) == null) {
            this.a.setButtonText(str, (int) Math.max(rj0Var.i * 100.0f, rj0Var.j * 100.0f));
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.f != null) {
                MessageManager.getInstance().unRegisterListener(this.f);
            }
            if (this.g != null) {
                MessageManager.getInstance().unRegisterListener(this.g);
            }
        }
    }

    public void w(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, downloadData) == null) || downloadData == null || rg5.h().y()) {
            return;
        }
        DownloadCacheKey h = lj5.d().h(downloadData.getId());
        AdDownloadData adDownloadData = null;
        int percent = (h == null || (adDownloadData = ij5.c().a(h)) == null) ? 0 : adDownloadData.getPercent();
        switch (downloadData.getStatus()) {
            case 1:
            case 5:
                x(percent);
                return;
            case 2:
            case 7:
                this.a.setButtonText(getResources().getString(R.string.obfuscated_res_0x7f0f07ab), percent);
                return;
            case 3:
                this.a.setButtonText(getResources().getString(R.string.obfuscated_res_0x7f0f08c8), percent);
                if (adDownloadData != null) {
                    adDownloadData.setFakePercent(0);
                    adDownloadData.setPercent(0);
                    return;
                }
                return;
            case 4:
            default:
                return;
            case 6:
                this.a.setButtonText(this.e, 0);
                return;
            case 8:
                this.a.setButtonText(getResources().getString(R.string.obfuscated_res_0x7f0f08c9), 0);
                if (adDownloadData != null) {
                    adDownloadData.setFakePercent(0);
                    adDownloadData.setPercent(0);
                    return;
                }
                return;
        }
    }

    public final void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.a.setProgress(Math.max(0, i));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = getResources().getString(R.string.obfuscated_res_0x7f0f08e8);
        this.f = null;
        this.g = null;
        o(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDownloadView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = getResources().getString(R.string.obfuscated_res_0x7f0f08e8);
        this.f = null;
        this.g = null;
        o(context);
    }
}
