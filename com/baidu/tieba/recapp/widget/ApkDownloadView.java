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
import d.a.o0.s.c.d;
import d.a.p0.q.d.g.b;
import d.a.p0.w2.c0.e;
import d.a.p0.w2.c0.i;
import java.util.List;
/* loaded from: classes4.dex */
public class ApkDownloadView extends FrameLayout implements d.a.p0.q.d.g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.w2.k0.a f20655e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadData f20656f;

    /* renamed from: g  reason: collision with root package name */
    public b.a f20657g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadStatus f20658h;

    /* renamed from: i  reason: collision with root package name */
    public String f20659i;
    public CustomMessageListener j;
    public CustomMessageListener k;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ApkDownloadView f20660a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ApkDownloadView apkDownloadView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apkDownloadView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20660a = apkDownloadView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage) && this.f20660a.f20656f != null) {
                DownloadData downloadData = null;
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                int i2 = 0;
                while (true) {
                    if (i2 >= data.size()) {
                        break;
                    }
                    DownloadData downloadData2 = data.get(i2);
                    if (TextUtils.isEmpty(this.f20660a.f20656f.getId())) {
                        i2++;
                    } else if (this.f20660a.f20656f.getId().equals(downloadData2.getId())) {
                        downloadData = downloadData2;
                    }
                }
                if (downloadData != null) {
                    int k = this.f20660a.k(downloadData);
                    if (i.n(downloadData) == 1) {
                        this.f20660a.w(k);
                    } else if (i.n(downloadData) == 3) {
                        this.f20660a.f20655e.setButtonText(this.f20660a.getResources().getString(R.string.immediately_install));
                    } else {
                        this.f20660a.p(downloadData);
                    }
                    this.f20660a.postInvalidate();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ApkDownloadView f20661a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ApkDownloadView apkDownloadView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apkDownloadView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20661a = apkDownloadView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f20661a.f20656f == null) {
                return;
            }
            DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
            if (this.f20661a.f20656f.getId() == null || downloadData == null || !this.f20661a.f20656f.getId().equals(downloadData.getId())) {
                return;
            }
            this.f20661a.v(downloadData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDownloadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f20659i = getResources().getString(R.string.install_app);
        this.j = null;
        this.k = null;
        n(context);
    }

    public static int l(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, downloadData)) == null) {
            if (downloadData == null) {
                return 0;
            }
            int process = downloadData.getProcess();
            if (process <= 0) {
                process = i.l().j(downloadData.getId(), downloadData.getName());
            }
            return Math.max(process, 0);
        }
        return invokeL.intValue;
    }

    public static int m(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, downloadData)) == null) {
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null && !adAdSense.g()) {
                return e.p(downloadData);
            }
            return i.n(downloadData);
        }
        return invokeL.intValue;
    }

    @Override // d.a.p0.q.d.g.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && this.f20658h == DownloadStatus.STATUS_DOWNLOADING) {
            w(i2);
        }
    }

    @Override // d.a.p0.q.d.g.b
    public boolean b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            b.a aVar = this.f20657g;
            if (aVar != null) {
                return aVar.b(view);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.p0.q.d.g.b
    public void c(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadStatus) == null) {
            this.f20658h = downloadStatus;
            DownloadData downloadData = this.f20656f;
            if (downloadData != null) {
                downloadData.setStatus(getDownloadStatus());
                v(this.f20656f);
            }
        }
    }

    @Override // d.a.p0.q.d.g.b
    public void d(DownloadStatus downloadStatus, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, downloadStatus, i2) == null) {
            c(downloadStatus);
            a(i2);
        }
    }

    @Override // d.a.p0.q.d.g.b
    public View getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (View) invokeV.objValue;
    }

    public int getDownloadStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            DownloadStatus downloadStatus = this.f20658h;
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

    @Override // d.a.p0.q.d.g.b
    @NonNull
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (View) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f20655e.b();
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            if (this.j == null) {
                a aVar = new a(this, 2001118);
                this.j = aVar;
                aVar.setTag(bdUniqueId);
            }
            if (this.k == null) {
                b bVar = new b(this, 2016484);
                this.k = bVar;
                bVar.setTag(bdUniqueId);
            }
        }
    }

    public final int k(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, downloadData)) == null) {
            if (downloadData == null) {
                return 0;
            }
            return (int) ((downloadData.getLength() * 100) / downloadData.getSize());
        }
        return invokeL.intValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            this.f20655e = (d.a.p0.w2.k0.a) LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true).findViewById(R.id.feed_ad_operate_progress_button);
            o(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f20655e.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onAttachedToWindow();
            q();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDetachedFromWindow();
            u();
            t();
        }
    }

    public void p(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, downloadData) == null) {
            DownloadCacheKey g2 = d.a.p0.q.d.e.c().g(downloadData.getId());
            this.f20655e.setButtonText(getResources().getString(R.string.go_on_download), g2 != null ? d.a.p0.q.d.b.c().a(g2).getPercent() : 0);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.j != null) {
                MessageManager.getInstance().registerListener(this.j);
            }
            if (this.k != null) {
                MessageManager.getInstance().registerListener(this.k);
            }
        }
    }

    public void r(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, downloadData) == null) {
            this.f20655e.setButtonText(this.f20659i);
        }
    }

    public void s(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadData) == null) {
            w(l(downloadData));
        }
    }

    public void setBackgroundSkin(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            d.a.p0.w2.k0.a aVar = this.f20655e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setBackgroundSkin(i2);
            }
        }
    }

    public void setData(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, downloadData) == null) || downloadData == null) {
            return;
        }
        DownloadData downloadData2 = (DownloadData) downloadData.clone();
        this.f20656f = downloadData2;
        if (downloadData2 == null) {
            return;
        }
        setTag(downloadData2);
        v(downloadData);
    }

    public void setForegroundSkin(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            d.a.p0.w2.k0.a aVar = this.f20655e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setForeground(i2);
            }
        }
    }

    public void setInitText(String str) {
        d.a.p0.w2.k0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.f20659i = str;
            if (TextUtils.isEmpty(str) || (aVar = this.f20655e) == null) {
                return;
            }
            aVar.setInitText(str);
        }
    }

    public void setOnClickInterceptListener(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            this.f20657g = aVar;
        }
    }

    public void setStrokeWidth(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            d.a.p0.w2.k0.a aVar = this.f20655e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setStrokeWidth(i2);
            }
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.f20655e.setButtonTextColor(i2);
        }
    }

    public void setTextColorInitSkin(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            d.a.p0.w2.k0.a aVar = this.f20655e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setTextColorInitSkin(i2);
            }
        }
    }

    public void setTextColorSkin(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            d.a.p0.w2.k0.a aVar = this.f20655e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setTextColorSkin(i2);
            }
        }
    }

    public void setTextNightColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.f20655e.setButtonTextNightColor(i2);
        }
    }

    public void setTextSize(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.f20655e.setButtonTextSize(i2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            super.setVisibility(i2);
            if (i2 == 0) {
                q();
            } else {
                u();
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            setOnClickInterceptListener(null);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.j != null) {
                MessageManager.getInstance().unRegisterListener(this.j);
            }
            if (this.k != null) {
                MessageManager.getInstance().unRegisterListener(this.k);
            }
        }
    }

    public void v(DownloadData downloadData) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, downloadData) == null) || downloadData == null) {
            return;
        }
        DownloadCacheKey g2 = d.a.p0.q.d.e.c().g(downloadData.getId());
        AdDownloadData adDownloadData = null;
        if (g2 != null) {
            adDownloadData = d.a.p0.q.d.b.c().a(g2);
            i2 = adDownloadData.getPercent();
        } else {
            i2 = 0;
        }
        switch (downloadData.getStatus()) {
            case 1:
            case 5:
                w(i2);
                return;
            case 2:
            case 7:
                this.f20655e.setButtonText(getResources().getString(R.string.go_on_download), i2);
                return;
            case 3:
                this.f20655e.setButtonText(getResources().getString(R.string.immediately_install), i2);
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
                this.f20655e.setButtonText(this.f20659i, 0);
                return;
            case 8:
                this.f20655e.setButtonText(getResources().getString(R.string.immediately_open), 0);
                if (adDownloadData != null) {
                    adDownloadData.setFakePercent(0);
                    adDownloadData.setPercent(0);
                    return;
                }
                return;
        }
    }

    public final void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.f20655e.setProgress(Math.max(0, i2));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20659i = getResources().getString(R.string.install_app);
        this.j = null;
        this.k = null;
        n(context);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20659i = getResources().getString(R.string.install_app);
        this.j = null;
        this.k = null;
        n(context);
    }
}
